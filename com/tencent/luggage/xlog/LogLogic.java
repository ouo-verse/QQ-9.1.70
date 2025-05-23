package com.tencent.luggage.xlog;

import android.os.Debug;
import android.os.Process;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LogLogic {
    public static String convertStreamToString(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader;
        StringBuilder sb5 = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb5.append(readLine);
                        sb5.append('\n');
                    } else {
                        bufferedReader.close();
                        return sb5.toString();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
    }

    public static native int getAppenderModeFromCfg();

    public static long getDalvikHeap() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static native int getIPxxLogLevel();

    public static native int getLogLevelFromCfg();

    public static long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    public static String getStringFromFile(String str) throws Exception {
        return "";
    }

    public static String getVmSize() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(Process.myPid()))).trim().split("\n");
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    return str;
                }
            }
            return split[12];
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getVmStatus() {
        String format = String.format("/proc/%s/status", Integer.valueOf(Process.myPid()));
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append(getStringFromFile(format).trim());
            return sb5.toString();
        } catch (Exception unused) {
            return sb5.toString();
        }
    }

    public static native void initIPxxLogInfo();

    public static native void setIPxxLogML(int i3, int i16);

    public static String appendMemLog(String str) {
        return str;
    }
}
