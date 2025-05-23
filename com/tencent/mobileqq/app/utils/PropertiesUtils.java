package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import mqq.app.MobileQQ;

/* loaded from: classes11.dex */
public class PropertiesUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_FONT_LEVEL = "key_font_level";
    public static final String KEY_LOCALE_ID = "key_local_cache";
    public static final String KEY_LOCALE_LAST = "key_local_last";
    public static final String KEY_MIN_SCREEN_WIDTH = "key_min_screen_width";
    public static final String KEY_PREVIOUS_SYS_SCALE = "key_previous_sys_scale";
    public static final String KEY_SHOW_FONT_CHANGED_TIP = "key_show_font_change_tip";
    private static final String PROPERTIES_FILE_NAME = "qq_properties_local";
    private static final String PROPERTIES_KEY_FONT_LEVEL = "font_level";
    private static final String PROPERTIES_OLD_FILE_NAME = "font_set_prop";
    private static final String TAG = "PropertiesUtils";
    private static boolean sInited;
    private static StringBuilder sLogBuilder;
    private static Properties sProperties;
    private static File sPropertiesFile;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sPropertiesFile = null;
        sProperties = null;
        sLogBuilder = new StringBuilder();
        sInited = false;
    }

    public PropertiesUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addLog(String str) {
        try {
            sLogBuilder.append(str + "\n");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v37, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void initializeProperties(Context context) {
        Throwable th5;
        IllegalArgumentException e16;
        IOException e17;
        StringBuilder sb5;
        if (sProperties != null) {
            return;
        }
        BaseApplication context2 = BaseApplication.getContext();
        if (context2 != null) {
            context = context2;
        }
        if (context == null) {
            return;
        }
        sPropertiesFile = new File(context.getFilesDir() + File.separator + PROPERTIES_FILE_NAME);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("initialize properties file, ");
        String absolutePath = sPropertiesFile.getAbsolutePath();
        sb6.append(absolutePath);
        printLog(sb6.toString());
        ?? r26 = absolutePath;
        if (!sPropertiesFile.exists()) {
            addLog("[initializeProperties]: file not exist");
            try {
                sPropertiesFile.createNewFile();
                r26 = absolutePath;
            } catch (IOException e18) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("[initializeProperties]: createNewFile ");
                sb7.append(QLog.getStackTraceString(e18));
                addLog(sb7.toString());
                r26 = sb7;
            }
        }
        sProperties = new Properties();
        try {
            try {
                r26 = new FileInputStream(sPropertiesFile.getAbsoluteFile());
            } catch (IOException e19) {
                r26 = 0;
                e17 = e19;
            } catch (IllegalArgumentException e26) {
                r26 = 0;
                e16 = e26;
            } catch (Throwable th6) {
                r26 = 0;
                th5 = th6;
                if (r26 != 0) {
                }
                throw th5;
            }
            try {
                sProperties.load(r26);
            } catch (IOException e27) {
                e17 = e27;
                addLog("[initializeProperties]: load " + QLog.getStackTraceString(e17));
                if (r26 != 0) {
                    try {
                        r26.close();
                    } catch (IOException e28) {
                        e = e28;
                        sb5 = new StringBuilder();
                        sb5.append("[initializeProperties]: finally ");
                        sb5.append(QLog.getStackTraceString(e));
                        addLog(sb5.toString());
                        sInited = true;
                    }
                }
                sInited = true;
            } catch (IllegalArgumentException e29) {
                e16 = e29;
                addLog("[initializeProperties]: load " + QLog.getStackTraceString(e16));
                if (sPropertiesFile.exists()) {
                    try {
                        sPropertiesFile.delete();
                    } catch (Throwable th7) {
                        addLog("[initializeProperties]: delete after exception " + QLog.getStackTraceString(th7));
                    }
                }
                if (r26 != 0) {
                    try {
                        r26.close();
                    } catch (IOException e36) {
                        e = e36;
                        sb5 = new StringBuilder();
                        sb5.append("[initializeProperties]: finally ");
                        sb5.append(QLog.getStackTraceString(e));
                        addLog(sb5.toString());
                        sInited = true;
                    }
                }
                sInited = true;
            }
            try {
                r26.close();
            } catch (IOException e37) {
                e = e37;
                sb5 = new StringBuilder();
                sb5.append("[initializeProperties]: finally ");
                sb5.append(QLog.getStackTraceString(e));
                addLog(sb5.toString());
                sInited = true;
            }
            sInited = true;
        } catch (Throwable th8) {
            th5 = th8;
            if (r26 != 0) {
                try {
                    r26.close();
                } catch (IOException e38) {
                    addLog("[initializeProperties]: finally " + QLog.getStackTraceString(e38));
                }
            }
            throw th5;
        }
    }

    private static void printLog(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    public static String read(Context context, String str, String str2) {
        if (sProperties == null) {
            initializeProperties(context);
        }
        Properties properties = sProperties;
        if (properties == null) {
            return str2;
        }
        if (properties.stringPropertyNames().contains(str)) {
            return sProperties.getProperty(str);
        }
        return readFromOldProperty(context, str, str2);
    }

    private static String readFromOldProperty(Context context, String str, String str2) {
        if (context != null && KEY_FONT_LEVEL.equals(str)) {
            Context context2 = BaseApplication.getContext();
            if (context2 == null) {
                context2 = context;
            }
            Properties properties = new Properties();
            File file = new File(context2.getFilesDir() + PROPERTIES_OLD_FILE_NAME);
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            properties.load(fileInputStream2);
                            String property = properties.getProperty(PROPERTIES_KEY_FONT_LEVEL);
                            printLog("readFromOldProperty " + property);
                            save(context, str, property);
                            try {
                                fileInputStream2.close();
                            } catch (Exception e16) {
                                printLog(e16.getMessage());
                            }
                            return property;
                        } catch (IOException e17) {
                            e = e17;
                            fileInputStream = fileInputStream2;
                            printLog(e.getMessage());
                            try {
                                fileInputStream.close();
                                return str2;
                            } catch (Exception e18) {
                                printLog(e18.getMessage());
                                return str2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = fileInputStream2;
                            try {
                                fileInputStream.close();
                            } catch (Exception e19) {
                                printLog(e19.getMessage());
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (IOException e26) {
                    e = e26;
                }
            } else {
                return str2;
            }
        } else {
            return str2;
        }
    }

    public static String readPropertiesContent(Context context) {
        try {
            return FileUtils.readFileContent(new File(context.getFilesDir() + File.separator + PROPERTIES_FILE_NAME));
        } catch (Throwable unused) {
            addLog("readPropertiesContent err");
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void save(Context context, String str, String str2) {
        Throwable th5;
        FileOutputStream fileOutputStream;
        IOException e16;
        StringBuilder sb5;
        if (MobileQQ.sProcessId != 1) {
            printLog("only main process can save!");
            return;
        }
        if (sProperties == null) {
            initializeProperties(context);
        }
        if (sProperties == null) {
            return;
        }
        addLog("save " + str + " properties= " + str2 + " inited= " + sInited);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("save pre:");
        sb6.append(sProperties.size());
        sb6.append(", names:");
        sb6.append(sProperties.stringPropertyNames().toString());
        printLog(sb6.toString());
        sProperties.setProperty(str, str2);
        ?? sb7 = new StringBuilder();
        sb7.append("save nxt:");
        sb7.append(sProperties.size());
        sb7.append(", names:");
        ?? obj = sProperties.stringPropertyNames().toString();
        sb7.append(obj);
        printLog(sb7.toString());
        try {
            try {
                fileOutputStream = new FileOutputStream(sPropertiesFile.getAbsolutePath());
            } catch (IOException e17) {
                fileOutputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                obj = 0;
                th5 = th6;
                if (obj != 0) {
                }
                throw th5;
            }
            try {
                sProperties.store(fileOutputStream, (String) null);
            } catch (IOException e18) {
                e16 = e18;
                addLog("[save]: keyStr is " + str + " properties is " + str2 + QLog.getStackTraceString(e16));
                obj = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        obj = fileOutputStream;
                    } catch (IOException e19) {
                        e = e19;
                        sb5 = new StringBuilder();
                        sb5.append("[save]: finally keyStr is ");
                        sb5.append(str);
                        sb5.append(" properties is ");
                        sb5.append(str2);
                        sb5.append(QLog.getStackTraceString(e));
                        addLog(sb5.toString());
                    }
                }
            }
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
                obj = fileOutputStream;
            } catch (IOException e26) {
                e = e26;
                sb5 = new StringBuilder();
                sb5.append("[save]: finally keyStr is ");
                sb5.append(str);
                sb5.append(" properties is ");
                sb5.append(str2);
                sb5.append(QLog.getStackTraceString(e));
                addLog(sb5.toString());
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (obj != 0) {
                try {
                    obj.flush();
                    obj.close();
                } catch (IOException e27) {
                    addLog("[save]: finally keyStr is " + str + " properties is " + str2 + QLog.getStackTraceString(e27));
                }
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tryPrintLog() {
        try {
            String sb5 = sLogBuilder.toString();
            if (!TextUtils.isEmpty(sb5)) {
                QLog.e(TAG, 1, sb5);
            }
        } catch (Throwable unused) {
        }
    }
}
