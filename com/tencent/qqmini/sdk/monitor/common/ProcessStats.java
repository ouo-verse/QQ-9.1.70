package com.tencent.qqmini.sdk.monitor.common;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qqmini.sdk.monitor.common.RecyclablePool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes23.dex */
public class ProcessStats {
    private static final int COUNT_SPLIT = 17;
    public static final String ID_APP = "-1";
    public static final String ID_DEV = "-2";
    public static final long INVALID_VALUE = -1;
    private static final int PERCENT_RATIO = 100;
    private static final String TAG = "ProcessStats";
    private static final RecyclablePool sPool = new RecyclablePool(Stats.class, 30);
    public static long sLastUpdateTime = 0;
    public static int sTotalCpuUsage = 0;
    public static Stats sAppSt = obtainStats();
    public static int sCpuCoreNum = -1;
    static int[] sWordIndexs = new int[17];
    static int[] sWhiteIndexs = new int[17];
    private static Map<String, Stats> sThreadUsageMap = new HashMap(30);
    private static int threadUsageUpdateTimes = 0;
    private static long baseTotalIdle = 0;
    private static long baseTotalCpu = 0;

    /* loaded from: classes23.dex */
    public static class Stats extends RecyclablePool.Recyclable {
        public long baseStime;
        public long baseUtime;
        public int cpuUsage;
        public String name;
        public long relStime;
        public long relUtime;

        @Override // com.tencent.qqmini.sdk.monitor.common.RecyclablePool.Recyclable
        public void recycle() {
            super.recycle();
        }
    }

    public static long collectCpuUsage(String str) {
        Object[] collectProcessStats = collectProcessStats(str);
        if (collectProcessStats == null) {
            return -1L;
        }
        return ((Long) collectProcessStats[1]).longValue() + ((Long) collectProcessStats[2]).longValue();
    }

    private static void collectProcessStats(String str, Stats stats, boolean z16) {
        String str2;
        long j3;
        long j16;
        try {
            Object[] collectProcessStats = collectProcessStats(str);
            if (collectProcessStats != null) {
                str2 = (String) collectProcessStats[0];
                j3 = ((Long) collectProcessStats[1]).longValue();
                j16 = ((Long) collectProcessStats[2]).longValue();
            } else {
                str2 = null;
                j3 = -100;
                j16 = -100;
            }
            if (z16) {
                stats.baseUtime = j3;
                stats.baseStime = j16;
                stats.name = str2;
                return;
            }
            long j17 = stats.baseUtime;
            if (j17 == -100) {
                stats.relUtime = -100L;
                stats.relStime = -100L;
            } else {
                stats.relUtime = j3 - j17;
                stats.relStime = j16 - stats.baseStime;
            }
        } catch (Exception unused) {
        }
    }

    public static final String dumpProcessStats(int i3) {
        try {
            StringBuilder sb5 = new StringBuilder(i3 * 110);
            collectProcessStats("-1", sAppSt, false);
            Log.d("CpuUsage", "read app :" + sAppSt.baseUtime + ", " + sAppSt.baseStime);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "top -m " + i3 + " -s cpu -n 1").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                    sb5.append("\r\n");
                } else {
                    collectProcessStats("-1", sAppSt, false);
                    Log.d("CpuUsage", "read app :" + sAppSt.baseUtime + ", " + sAppSt.baseStime);
                    return sb5.toString();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static final List<String> dumpThreadStats(int i3, boolean z16) {
        int i16;
        HashMap hashMap = new HashMap();
        if (z16) {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            int activeCount = threadGroup.activeCount();
            Thread[] threadArr = new Thread[activeCount];
            threadGroup.enumerate(threadArr);
            hashMap = new HashMap(activeCount);
            for (int i17 = 0; i17 < activeCount; i17++) {
                Thread thread = threadArr[i17];
                if (thread != null) {
                    hashMap.put(thread.getName(), thread);
                }
            }
        }
        ArrayList arrayList = new ArrayList(sThreadUsageMap.size() / 2);
        for (String str : sThreadUsageMap.keySet()) {
            Stats stats = sThreadUsageMap.get(str);
            if (stats.cpuUsage >= i3) {
                if (z16) {
                    i16 = 300;
                } else {
                    i16 = 50;
                }
                StringBuilder sb5 = new StringBuilder(i16);
                sb5.append(stats.name);
                sb5.append("_");
                sb5.append(str);
                sb5.append(":");
                sb5.append(stats.cpuUsage);
                sb5.append("\r\n");
                if (z16) {
                    Thread thread2 = (Thread) hashMap.get(stats.name);
                    if (thread2 != null) {
                        sb5.append(Arrays.toString(thread2.getStackTrace()));
                    }
                    char[] stringValue = StringUtils.getStringValue(sb5);
                    if (stringValue != null) {
                        arrayList.add(StringUtils.newStringWithData(stringValue));
                    } else {
                        arrayList.add(sb5.toString());
                    }
                }
            }
        }
        if (z16) {
            arrayList.add(Arrays.toString(Looper.getMainLooper().getThread().getStackTrace()));
        }
        return arrayList;
    }

    private static final int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.tencent.qqmini.sdk.monitor.common.ProcessStats.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (Pattern.matches("cpu[0-9]+", file.getName())) {
                        return true;
                    }
                    return false;
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    @SuppressLint({"NewApi"})
    public static final int getNumberOfCores() {
        if (sCpuCoreNum == -1) {
            sCpuCoreNum = Runtime.getRuntime().availableProcessors();
        }
        return sCpuCoreNum;
    }

    private static final RandomAccessFile getReader(String str) {
        RandomAccessFile randomAccessFile;
        try {
            if (str.equals("-2")) {
                randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            } else if (str.equals("-1")) {
                randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/task/" + str + "/stat", "r");
            }
            return randomAccessFile;
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    private static final String[] getThreadPids(long j3) {
        File file = new File("/proc/" + j3 + "/task");
        if (file.exists() && file.isDirectory()) {
            return file.list();
        }
        return null;
    }

    public static Stats obtainStats() {
        return (Stats) sPool.obtain(Stats.class);
    }

    public static void returnStats(Stats stats) {
        stats.recycle();
    }

    public static void traceEnd(boolean z16) {
        long j3;
        long j16;
        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(1024);
        try {
            Object[] collectProcessStats = collectProcessStats("-2");
            if (collectProcessStats != null) {
                j3 = ((Long) collectProcessStats[1]).longValue();
                j16 = ((Long) collectProcessStats[2]).longValue();
            } else {
                j3 = -1;
                j16 = -1;
            }
            long j17 = ((j3 + j16) - baseTotalCpu) - baseTotalIdle;
            collectProcessStats("-1", sAppSt, false);
            if (z16) {
                for (String str : sThreadUsageMap.keySet()) {
                    Stats stats = sThreadUsageMap.get(str);
                    collectProcessStats(str, stats, false);
                    stats.cpuUsage = (int) (((stats.relStime + stats.relUtime) * 100) / j17);
                }
            }
            sTotalCpuUsage = (int) (((j16 - baseTotalCpu) * 100) / j17);
            Stats stats2 = sAppSt;
            stats2.cpuUsage = (int) (((stats2.relStime + stats2.relUtime) * 100) / j17);
            sLastUpdateTime = SystemClock.uptimeMillis();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            ByteArrayPool.getGenericInstance().returnBuf(buf);
            throw th5;
        }
        ByteArrayPool.getGenericInstance().returnBuf(buf);
    }

    public static void traceStart(boolean z16) {
        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(1024);
        try {
            try {
                Object[] collectProcessStats = collectProcessStats("-2");
                if (collectProcessStats != null) {
                    baseTotalIdle = ((Long) collectProcessStats[1]).longValue();
                    baseTotalCpu = ((Long) collectProcessStats[2]).longValue();
                } else {
                    baseTotalIdle = -1L;
                    baseTotalCpu = -1L;
                }
                collectProcessStats("-1", sAppSt, true);
                if (z16) {
                    Iterator<Stats> it = sThreadUsageMap.values().iterator();
                    while (it.hasNext()) {
                        returnStats(it.next());
                    }
                    sThreadUsageMap.clear();
                    String[] threadPids = getThreadPids(Process.myPid());
                    if (threadPids != null) {
                        for (String str : threadPids) {
                            Stats obtainStats = obtainStats();
                            collectProcessStats(str, obtainStats, true);
                            sThreadUsageMap.put(str, obtainStats);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            ByteArrayPool.getGenericInstance().returnBuf(buf);
        }
    }

    public static Object[] collectProcessStats(String str) {
        RandomAccessFile reader = getReader(str);
        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(1024);
        try {
            reader.seek(0L);
            int read = reader.read(buf);
            int i3 = 0;
            int i16 = 0;
            while (i3 < read && i16 < 17) {
                while (i3 < read && buf[i3] == 32) {
                    i3++;
                }
                if (i3 < read) {
                    sWordIndexs[i16] = i3;
                }
                while (i3 < read && buf[i3] != 32) {
                    i3++;
                }
                if (i3 < read) {
                    sWhiteIndexs[i16] = i3;
                }
                i16++;
            }
            if (i16 == 17) {
                if (!"-2".equals(str)) {
                    int i17 = sWordIndexs[1];
                    String str2 = new String(buf, i17 + 1, (sWhiteIndexs[1] - i17) - 1);
                    int i18 = sWordIndexs[13];
                    long parseLong = Long.parseLong(new String(buf, i18, sWhiteIndexs[13] - i18));
                    int i19 = sWordIndexs[15];
                    Long valueOf = Long.valueOf(parseLong + Long.parseLong(new String(buf, i19, sWhiteIndexs[15] - i19)));
                    int i26 = sWordIndexs[14];
                    long parseLong2 = Long.parseLong(new String(buf, i26, sWhiteIndexs[14] - i26));
                    int i27 = sWordIndexs[16];
                    Object[] objArr = {str2, valueOf, Long.valueOf(parseLong2 + Long.parseLong(new String(buf, i27, sWhiteIndexs[16] - i27)))};
                    ByteArrayPool.getGenericInstance().returnBuf(buf);
                    try {
                        reader.close();
                    } catch (Exception unused) {
                    }
                    return objArr;
                }
                int i28 = sWordIndexs[4];
                Long valueOf2 = Long.valueOf(Long.parseLong(new String(buf, i28, sWhiteIndexs[4] - i28)));
                int i29 = sWordIndexs[1];
                long parseLong3 = Long.parseLong(new String(buf, i29, sWhiteIndexs[1] - i29));
                int i36 = sWordIndexs[2];
                long parseLong4 = parseLong3 + Long.parseLong(new String(buf, i36, sWhiteIndexs[2] - i36));
                int i37 = sWordIndexs[3];
                long parseLong5 = parseLong4 + Long.parseLong(new String(buf, i37, sWhiteIndexs[3] - i37));
                int i38 = sWordIndexs[5];
                long parseLong6 = parseLong5 + Long.parseLong(new String(buf, i38, sWhiteIndexs[5] - i38));
                int i39 = sWordIndexs[6];
                long parseLong7 = parseLong6 + Long.parseLong(new String(buf, i39, sWhiteIndexs[6] - i39));
                int i46 = sWordIndexs[7];
                long parseLong8 = parseLong7 + Long.parseLong(new String(buf, i46, sWhiteIndexs[7] - i46));
                int i47 = sWordIndexs[8];
                Object[] objArr2 = {"device", valueOf2, Long.valueOf(parseLong8 + Long.parseLong(new String(buf, i47, sWhiteIndexs[8] - i47)))};
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                try {
                    reader.close();
                } catch (Exception unused2) {
                }
                return objArr2;
            }
        } catch (Exception unused3) {
        } catch (Throwable th5) {
            ByteArrayPool.getGenericInstance().returnBuf(buf);
            try {
                reader.close();
            } catch (Exception unused4) {
            }
            throw th5;
        }
        ByteArrayPool.getGenericInstance().returnBuf(buf);
        try {
            reader.close();
            return null;
        } catch (Exception unused5) {
            return null;
        }
    }
}
