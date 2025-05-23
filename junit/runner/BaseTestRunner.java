package junit.runner;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestSuite;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class BaseTestRunner implements TestListener {
    public static final String SUITE_METHODNAME = "suite";
    private static Properties fPreferences = null;
    static boolean fgFilterStack = true;
    static int fgMaxMessageLength = getPreference("maxmessage", 500);
    boolean fLoading = true;

    static boolean filterLine(String str) {
        String[] strArr = {"junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke("};
        for (int i3 = 0; i3 < 8; i3++) {
            if (str.indexOf(strArr[i3]) > 0) {
                return true;
            }
        }
        return false;
    }

    public static String getFilteredTrace(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return getFilteredTrace(stringWriter.toString());
    }

    public static String getPreference(String str) {
        return getPreferences().getProperty(str);
    }

    protected static Properties getPreferences() {
        if (fPreferences == null) {
            Properties properties = new Properties();
            fPreferences = properties;
            properties.put(ToastView.ICON_LOADING, "true");
            fPreferences.put("filterstack", "true");
            readPreferences();
        }
        return fPreferences;
    }

    private static File getPreferencesFile() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    private static void readPreferences() {
        FileInputStream fileInputStream;
        Throwable th5;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(getPreferencesFile());
            } catch (IOException unused) {
            } catch (Throwable th6) {
                fileInputStream = null;
                th5 = th6;
            }
            try {
                setPreferences(new Properties(getPreferences()));
                getPreferences().load(fileInputStream);
                fileInputStream.close();
            } catch (IOException unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th5;
            }
        } catch (IOException unused4) {
        }
    }

    public static void savePreferences() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(getPreferencesFile());
        try {
            getPreferences().store(fileOutputStream, "");
        } finally {
            fileOutputStream.close();
        }
    }

    public static void setPreference(String str, String str2) {
        getPreferences().put(str, str2);
    }

    protected static void setPreferences(Properties properties) {
        fPreferences = properties;
    }

    protected static boolean showStackRaw() {
        if (getPreference("filterstack").equals("true") && fgFilterStack) {
            return false;
        }
        return true;
    }

    public static String truncate(String str) {
        if (fgMaxMessageLength != -1 && str.length() > fgMaxMessageLength) {
            return str.substring(0, fgMaxMessageLength) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    @Override // junit.framework.TestListener
    public synchronized void addError(Test test, Throwable th5) {
        testFailed(1, test, th5);
    }

    @Override // junit.framework.TestListener
    public synchronized void addFailure(Test test, AssertionFailedError assertionFailedError) {
        testFailed(2, test, assertionFailedError);
    }

    public String elapsedTimeAsString(long j3) {
        return NumberFormat.getInstance().format(j3 / 1000.0d);
    }

    @Override // junit.framework.TestListener
    public synchronized void endTest(Test test) {
        testEnded(test.toString());
    }

    public String extractClassName(String str) {
        if (str.startsWith("Default package for")) {
            return str.substring(str.lastIndexOf(".") + 1);
        }
        return str;
    }

    public Test getTest(String str) {
        if (str.length() <= 0) {
            clearStatus();
            return null;
        }
        try {
            Class<?> loadSuiteClass = loadSuiteClass(str);
            try {
                Method method = loadSuiteClass.getMethod(SUITE_METHODNAME, new Class[0]);
                if (!Modifier.isStatic(method.getModifiers())) {
                    runFailed("Suite() method must be static");
                    return null;
                }
                try {
                    Test test = (Test) method.invoke(null, new Object[0]);
                    if (test == null) {
                        return test;
                    }
                    clearStatus();
                    return test;
                } catch (IllegalAccessException e16) {
                    runFailed("Failed to invoke suite():" + e16.toString());
                    return null;
                } catch (InvocationTargetException e17) {
                    runFailed("Failed to invoke suite():" + e17.getTargetException().toString());
                    return null;
                }
            } catch (Exception unused) {
                clearStatus();
                return new TestSuite(loadSuiteClass);
            }
        } catch (ClassNotFoundException e18) {
            String message = e18.getMessage();
            if (message != null) {
                str = message;
            }
            runFailed("Class not found \"" + str + "\"");
            return null;
        } catch (Exception e19) {
            runFailed("Error: " + e19.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<?> loadSuiteClass(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    protected String processArguments(String[] strArr) {
        String str = null;
        int i3 = 0;
        while (i3 < strArr.length) {
            if (strArr[i3].equals("-noloading")) {
                setLoading(false);
            } else if (strArr[i3].equals("-nofilterstack")) {
                fgFilterStack = false;
            } else if (strArr[i3].equals(LogCmdOptions.CLEAR)) {
                i3++;
                if (strArr.length > i3) {
                    str = extractClassName(strArr[i3]);
                } else {
                    System.out.println("Missing Test class name");
                }
            } else {
                str = strArr[i3];
            }
            i3++;
        }
        return str;
    }

    protected abstract void runFailed(String str);

    public void setLoading(boolean z16) {
        this.fLoading = z16;
    }

    @Override // junit.framework.TestListener
    public synchronized void startTest(Test test) {
        testStarted(test.toString());
    }

    public abstract void testEnded(String str);

    public abstract void testFailed(int i3, Test test, Throwable th5);

    public abstract void testStarted(String str);

    protected boolean useReloadingTestSuiteLoader() {
        if (getPreference(ToastView.ICON_LOADING).equals("true") && this.fLoading) {
            return true;
        }
        return false;
    }

    public static int getPreference(String str, int i3) {
        String preference = getPreference(str);
        if (preference == null) {
            return i3;
        }
        try {
            return Integer.parseInt(preference);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public static String getFilteredTrace(String str) {
        if (showStackRaw()) {
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!filterLine(readLine)) {
                        printWriter.println(readLine);
                    }
                } else {
                    return stringWriter.toString();
                }
            } catch (Exception unused) {
                return str;
            }
        }
    }

    protected void clearStatus() {
    }
}
