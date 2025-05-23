package com.google.android.exoplayer2.ext.mediaplayer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qqmini.miniapp.util.logmonitor.LogCmdOptions;
import cooperation.qzone.util.PerfTracer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ExoMediaPlayerUtils {
    public static String getLogcatContent() {
        return getLogcatContent(0, null, 10);
    }

    public static String getPrintableStackTrace(Throwable th5) {
        return getPrintableStackTrace(th5, false);
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static String join(Iterator<String> it, String str) {
        String str2 = "";
        if (it != null) {
            while (it.hasNext()) {
                str2 = str2 + it.next();
                if (it.hasNext()) {
                    str2 = str2 + str;
                }
            }
        }
        return str2;
    }

    public static String getLogcatContent(int i3, String str, int i16) {
        int i17;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - (i16 * 1000);
        int i18 = Calendar.getInstance().get(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault());
        int i19 = 0;
        String[] strArr = str == null ? new String[]{"logcat", LogCmdOptions.DUMP, "-v", PerfTracer.THREADTIME_TAG} : new String[]{"logcat", LogCmdOptions.DUMP, "-v", PerfTracer.THREADTIME_TAG, "-s", str};
        StringBuilder sb5 = new StringBuilder();
        Process process = null;
        try {
            process = RuntimeMonitor.exec(Runtime.getRuntime(), strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            boolean z16 = false;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.matches("^\\d\\d-\\d\\d\\s\\d\\d:.*")) {
                    String substring = readLine.substring(i19, 18);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(i18);
                    sb6.append("-");
                    int i26 = i18;
                    sb6.append(substring.substring(0, 18));
                    long time = simpleDateFormat.parse(sb6.toString()).getTime();
                    if (time > currentTimeMillis) {
                        break;
                    }
                    if (time > j3) {
                        if (!z16) {
                            sb5.append(">>>>>> start logcat log <<<<<<\n");
                            z16 = true;
                        }
                        sb5.append(readLine);
                        sb5.append("\n");
                    }
                    if (i3 <= 0 || sb5.length() <= i3) {
                        i17 = 0;
                    } else {
                        i17 = 0;
                        sb5.delete(0, sb5.length() - i3);
                    }
                    i19 = i17;
                    i18 = i26;
                }
            }
            sb5.append(">>>>>> end logcat log <<<<<<");
            String sb7 = sb5.toString();
            try {
                process.getOutputStream().close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            try {
                process.getInputStream().close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            try {
                process.getErrorStream().close();
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            return sb7;
        } catch (Throwable th5) {
            try {
                sb5.append("\n[error:" + th5.toString() + "]");
                String sb8 = sb5.toString();
                if (process != null) {
                    try {
                        process.getOutputStream().close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                return sb8;
            } finally {
            }
        }
    }

    private static String getPrintableStackTrace(Throwable th5, boolean z16) {
        if (th5 == null) {
            return "";
        }
        Thread currentThread = Thread.currentThread();
        StringBuilder sb5 = new StringBuilder();
        if (!z16) {
            sb5.append("Exception in thread \"");
            sb5.append(currentThread.getName());
            sb5.append("\"");
            sb5.append(th5.toString());
        }
        for (StackTraceElement stackTraceElement : th5.getStackTrace()) {
            sb5.append("\tat ");
            sb5.append(stackTraceElement);
            sb5.append("\n");
        }
        Throwable targetException = th5 instanceof InvocationTargetException ? ((InvocationTargetException) th5).getTargetException() : th5.getCause();
        if (targetException != null) {
            sb5.append("caused by: ");
            sb5.append(targetException.toString());
            sb5.append("\n");
            sb5.append(getPrintableStackTrace(targetException, true));
        }
        return sb5.toString();
    }

    public static String join(List<String> list, String str) {
        return list != null ? join(list.iterator(), str) : "";
    }

    public static String join(List<String> list) {
        return join(list, "|");
    }
}
