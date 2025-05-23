package com.tencent.youtu.sdkkitframework.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class YtLogger {
    static IPatchRedirector $redirector_ = null;
    public static final int DEBUG_LEVEL = 4;
    public static final int ERROR_LEVEL = 0;
    public static final int INFO_LEVEL = 2;
    public static final int ONLINE_LEVEL = -1000;
    public static final int VERB_LEVEL = 5;
    public static final int WARN_LEVEL = 1;
    private static int currentLogLevel;

    @SuppressLint({"SimpleDateFormat"})
    private static DateFormat dateFormat;
    private static String keywords;
    private static String lastLogMessage;
    private static File localFile;
    private static String localLogPath;
    private static IYtLoggerListener loggerListener;
    private static ExecutorService mExecutorService;
    private static boolean needLogFile;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21352);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS");
        loggerListener = null;
        needLogFile = false;
        keywords = null;
        localFile = null;
        currentLogLevel = 0;
        lastLogMessage = "";
        mExecutorService = ProxyExecutors.newSingleThreadExecutor();
    }

    public YtLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void buildMessageForLocalLogFile(int i3, String str, String str2) {
        boolean z16;
        int i16;
        if (i3 != 0 && i3 != 1 && (i16 = currentLogLevel) != 4 && ((i16 != 2 || i3 == 4) && (i16 != -1000 || i3 != -1000))) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (i3 != -1000) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                stringBuffer.append("[VERB]");
                            }
                        } else {
                            stringBuffer.append("[DEBUG]");
                        }
                    } else {
                        stringBuffer.append("[INFO]");
                    }
                } else {
                    stringBuffer.append("[WARN]");
                }
            } else {
                stringBuffer.append("[ERROR]");
            }
        } else {
            stringBuffer.append("[ONLINE]");
        }
        stringBuffer.append(dateFormat.format(new Date()));
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        save2File(stringBuffer.toString());
    }

    public static void d(String str, Object obj) {
        if (currentLogLevel >= 4) {
            showLog(4, str, "[YTLog]-[DEBUG]-" + obj);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        int i3 = currentLogLevel;
        if (i3 >= 0 || i3 == -1000) {
            showLog(0, str, "[YTLog]-[ERROR]-" + str2, th5);
        }
    }

    private static File getLogFile(String str) {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        File file2 = new File(file.getPath() + File.separator + (dateFormat.format(new Date()) + ".log"));
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return file2;
    }

    public static void i(String str, String str2) {
        if (currentLogLevel >= 2) {
            showLog(2, str, "[YTLog]-[INFO]-" + str2);
        }
    }

    public static void o(String str, Object obj) {
        int i3 = currentLogLevel;
        if (i3 == -1000 || i3 == 4) {
            showLog(-1000, str, "[YTLog]-[ONLINE]-" + System.currentTimeMillis() + "-" + obj);
        }
    }

    private static void save2File(String str) {
        File file = localFile;
        if (file != null) {
            writeFile(file, str);
        }
    }

    public static void setLogLevel(int i3) {
        int i16 = -1000;
        if (i3 != -1000) {
            i16 = Math.min(i3, Math.max(i3, 0));
        }
        currentLogLevel = i16;
    }

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static void setNeedLogFile(boolean z16, String str, String str2) {
        if (TextUtils.isEmpty(localLogPath)) {
            needLogFile = false;
            w("YTLog", "file saved must put path", null);
            return;
        }
        needLogFile = z16;
        if (z16) {
            keywords = str2;
            localLogPath = str;
            localFile = getLogFile(str);
        }
    }

    private static void showLog(int i3, String str, String str2, Throwable th5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        if (th5 != null) {
            stringBuffer.append(Log.getStackTraceString(th5));
        }
        String stringBuffer2 = stringBuffer.toString();
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log(str, stringBuffer2);
        }
        String str3 = localLogPath;
        if (str3 != null && !"".equals(str3) && needLogFile) {
            buildMessageForLocalLogFile(i3, str, stringBuffer2);
        }
        Log.e(str, stringBuffer2);
    }

    public static void v(String str, Object obj) {
        if (currentLogLevel >= 5) {
            showLog(5, str, "[YTLog]-[VERB]-" + obj);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        int i3 = currentLogLevel;
        if (i3 >= 1 || i3 == -1000) {
            showLog(1, str, "[YTLog]-[WARN]-" + str2, th5);
        }
    }

    private static void writeFile(File file, String str) {
        if (!TextUtils.isEmpty(keywords) && str.contains(keywords)) {
            mExecutorService.submit(new Runnable(file, str) { // from class: com.tencent.youtu.sdkkitframework.common.YtLogger.1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String val$content;
                public final /* synthetic */ File val$file;

                {
                    this.val$file = file;
                    this.val$content = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) str);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    PrintWriter printWriter;
                    Exception e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    PrintWriter printWriter2 = null;
                    try {
                        printWriter = new PrintWriter(new BufferedWriter(new FileWriter(this.val$file, true)));
                    } catch (Exception e17) {
                        printWriter = null;
                        e16 = e17;
                    } catch (Throwable th5) {
                        th = th5;
                        if (printWriter2 != null) {
                        }
                        throw th;
                    }
                    try {
                        try {
                            printWriter.println(this.val$content);
                            printWriter.flush();
                            printWriter.close();
                        } catch (Throwable th6) {
                            PrintWriter printWriter3 = printWriter;
                            th = th6;
                            printWriter2 = printWriter3;
                            if (printWriter2 != null) {
                                printWriter2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        e16.printStackTrace();
                        if (printWriter != null) {
                            printWriter.close();
                        }
                    }
                }
            });
        }
    }

    public static void setNeedLogFile(boolean z16, String str) {
        setNeedLogFile(z16, str, null);
    }

    private static void showLog(int i3, String str, String str2) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log(str, str2);
        }
        String str3 = localLogPath;
        if (str3 != null && !"".equals(str3) && needLogFile) {
            buildMessageForLocalLogFile(i3, str, str2);
        }
        if (lastLogMessage.equals(str2)) {
            return;
        }
        lastLogMessage = str2;
        Log.d(str, str2);
    }
}
