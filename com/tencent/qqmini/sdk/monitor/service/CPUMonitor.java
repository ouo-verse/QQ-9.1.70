package com.tencent.qqmini.sdk.monitor.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public class CPUMonitor {
    private static final int BUSY_TIME = 1200;
    private static final int INTERVAL_TIME = 1000;
    private static final String TAG = "CPUMonitor";
    private static final int TOTAL_SIZE = 10;
    private static Handler mHandler;
    private static HandlerThread newHT;
    private static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    private static LinkedHashMap<Long, String> map = new LinkedHashMap<>();
    private static int pid = 0;
    private static long userLast = 0;
    private static long systemLast = 0;
    private static long idleLast = 0;
    private static long iowaitLast = 0;
    private static long totalLast = 0;
    private static long appCpuTimeLast = 0;
    private static volatile boolean hasStart = false;
    private static boolean isError = false;
    private static Runnable getCPURunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.monitor.service.CPUMonitor.1
        @Override // java.lang.Runnable
        public void run() {
            if (!CPUMonitor.isError) {
                CPUMonitor.getCpuTime();
                if (CPUMonitor.mHandler != null) {
                    CPUMonitor.mHandler.postDelayed(CPUMonitor.getCPURunnable, 1000L);
                }
            }
        }
    };

    public static String getCPURateInfo() {
        StringBuilder sb5 = new StringBuilder();
        synchronized (map) {
            for (Map.Entry<Long, String> entry : map.entrySet()) {
                sb5.append(TIME_FORMATTER.format(Long.valueOf(entry.getKey().longValue())));
                sb5.append(" ");
                sb5.append(entry.getValue());
                sb5.append("\r\n");
            }
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getCpuTime() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String readLine;
        String str;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
                try {
                    readLine = bufferedReader2.readLine();
                    str = "";
                    if (readLine == null) {
                        readLine = "";
                    }
                    if (pid == 0) {
                        pid = Process.myPid();
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + pid + "/stat")), 1000);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            try {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 != null) {
                    str = readLine2;
                }
                parseCpuRate(readLine, str);
                isError = false;
                bufferedReader2.close();
                bufferedReader.close();
            } catch (Throwable th7) {
                th = th7;
                bufferedReader3 = bufferedReader2;
                try {
                    isError = true;
                    th.printStackTrace();
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Throwable th8) {
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            throw th8;
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th8;
                }
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    public static boolean isCPUbusy(long j3, long j16) {
        if (j16 - j3 > 1000) {
            long j17 = j3 - 1000;
            long j18 = j3 + 1000;
            synchronized (map) {
                Iterator<Map.Entry<Long, String>> it = map.entrySet().iterator();
                long j19 = 0;
                while (it.hasNext()) {
                    long longValue = it.next().getKey().longValue();
                    if (j17 < longValue && longValue < j18) {
                        if (j19 != 0 && longValue - j19 > 1200) {
                            return true;
                        }
                        j19 = longValue;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isError() {
        return isError;
    }

    private static void parseCpuRate(String str, String str2) {
        long j3;
        String[] split = str.split(" ");
        if (split != null && split.length >= 9) {
            long parseLong = Long.parseLong(split[2]);
            long parseLong2 = Long.parseLong(split[3]);
            long parseLong3 = Long.parseLong(split[4]);
            long parseLong4 = Long.parseLong(split[5]);
            long parseLong5 = Long.parseLong(split[6]);
            long parseLong6 = parseLong2 + parseLong + parseLong3 + parseLong4 + parseLong5 + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            String[] split2 = str2.split(" ");
            if (split2 != null && split2.length >= 17) {
                long parseLong7 = Long.parseLong(split2[13]) + Long.parseLong(split2[14]) + Long.parseLong(split2[15]) + Long.parseLong(split2[16]);
                if (totalLast != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    long j16 = parseLong4 - idleLast;
                    long j17 = parseLong6 - totalLast;
                    j3 = parseLong6;
                    sb5.append("cpu:");
                    sb5.append(((j17 - j16) * 100) / j17);
                    sb5.append("% ");
                    sb5.append("app:");
                    sb5.append(((parseLong7 - appCpuTimeLast) * 100) / j17);
                    sb5.append("% ");
                    sb5.append("[");
                    sb5.append("user:");
                    sb5.append(((parseLong - userLast) * 100) / j17);
                    sb5.append("% ");
                    sb5.append("system:");
                    sb5.append(((parseLong3 - systemLast) * 100) / j17);
                    sb5.append("% ");
                    sb5.append("iowait:");
                    sb5.append(((parseLong5 - iowaitLast) * 100) / j17);
                    sb5.append("% ]");
                    synchronized (map) {
                        map.put(Long.valueOf(System.currentTimeMillis()), sb5.toString());
                        if (map.size() > 10) {
                            Iterator<Map.Entry<Long, String>> it = map.entrySet().iterator();
                            if (it.hasNext()) {
                                map.remove(it.next().getKey());
                            }
                        }
                    }
                } else {
                    j3 = parseLong6;
                }
                userLast = parseLong;
                systemLast = parseLong3;
                idleLast = parseLong4;
                iowaitLast = parseLong5;
                totalLast = j3;
                appCpuTimeLast = parseLong7;
            }
        }
    }

    private static void reset() {
        userLast = 0L;
        systemLast = 0L;
        idleLast = 0L;
        iowaitLast = 0L;
        totalLast = 0L;
        appCpuTimeLast = 0L;
    }

    public static void start() {
        if (hasStart) {
            return;
        }
        reset();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("qzminiapp-monitor", 10);
        newHT = baseHandlerThread;
        baseHandlerThread.start();
        Looper looper = newHT.getLooper();
        if (looper != null) {
            Handler handler = new Handler(looper);
            mHandler = handler;
            handler.removeCallbacks(getCPURunnable);
            mHandler.postDelayed(getCPURunnable, 1000L);
        }
        hasStart = true;
    }

    public static void stop() {
        hasStart = false;
        Handler handler = mHandler;
        if (handler != null) {
            handler.removeCallbacks(getCPURunnable);
        }
        HandlerThread handlerThread = newHT;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }
}
