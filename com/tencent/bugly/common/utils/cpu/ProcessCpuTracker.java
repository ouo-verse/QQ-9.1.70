package com.tencent.bugly.common.utils.cpu;

import android.os.StrictMode;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.component.media.MtpConstants;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/* loaded from: classes5.dex */
public class ProcessCpuTracker {
    private static final boolean DEBUG = false;
    private static final int MAX_CPU_CORE_NUM = 10;
    private static final int MAX_CPU_IDLE_STATE_NUM = 3;
    static final int PROCESS_FULL_STAT_MAJOR_FAULTS = 2;
    static final int PROCESS_FULL_STAT_MINOR_FAULTS = 1;
    static final int PROCESS_FULL_STAT_STIME = 4;
    static final int PROCESS_FULL_STAT_UTIME = 3;
    static final int PROCESS_FULL_STAT_VSIZE = 5;
    static final int PROCESS_SCHEDSTAT_CPU_DELAY_TIME = 1;
    static final int PROCESS_SCHEDSTAT_CPU_TIME = 0;
    static final int PROCESS_STAT_MAJOR_FAULTS = 1;
    static final int PROCESS_STAT_MINOR_FAULTS = 0;
    static final int PROCESS_STAT_STIME = 3;
    static final int PROCESS_STAT_UTIME = 2;
    private static final String TAG = "ProcessCpuTracker";
    private int cpuCoreNum;
    private boolean hasProcTimeInStateReaderInited;
    private long mBaseIdleTime;
    private long mBaseIoWaitTime;
    private long mBaseIrqTime;
    private long mBaseSoftIrqTime;
    private long mBaseSystemTime;
    private long mBaseUserTime;
    boolean mCollectDeviceCpu;
    boolean mCollectDeviceLoad;
    private int[] mCurPids;
    private int[] mCurThreadPids;
    private long mCurrentSampleRealTime;
    private long mCurrentSampleTime;
    private long mCurrentSampleWallTime;
    private final boolean mIncludeThreads;
    private final long mJiffyMillis;
    private long mLastSampleRealTime;
    private long mLastSampleTime;
    private long mLastSampleWallTime;
    private int mRelIdleTime;
    private int mRelIoWaitTime;
    private int mRelIrqTime;
    private int mRelSoftIrqTime;
    private boolean mRelStatsAreGood;
    private int mRelSystemTime;
    private int mRelUserTime;
    private boolean mWorkingProcsSorted;
    ProcTimeInStateReader[] procTimeInStateReaders;
    private static final int[] PROCESS_STATS_FORMAT = {32, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE, 32, 32, 32, 32, 32, 32, 32, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 32, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 32, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED};
    private static final int[] PROCESS_FULL_STATS_FORMAT = {32, com.tencent.mobileqq.msf.core.c0.g.M1, 32, 32, 32, 32, 32, 32, 32, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 32, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 32, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 32, 32, 32, 32, 32, 32, 32, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED};
    private static final int[] PROCESS_SCHEDSTATS_FORMAT = {MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED};
    private static final int[] SYSTEM_CPU_FORMAT = {288, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED};
    private static final int[] LOAD_AVERAGE_FORMAT = {16416, 16416, 16416};
    private static final Comparator<Stats> sLoadComparator = new Comparator<Stats>() { // from class: com.tencent.bugly.common.utils.cpu.ProcessCpuTracker.1
        @Override // java.util.Comparator
        public int compare(Stats stats, Stats stats2) {
            int i3 = stats.rel_utime + stats.rel_stime;
            int i16 = stats2.rel_utime + stats2.rel_stime;
            if (i3 != i16) {
                return i3 > i16 ? -1 : 1;
            }
            boolean z16 = stats.added;
            if (z16 != stats2.added) {
                return z16 ? -1 : 1;
            }
            if (stats.removed != stats2.removed) {
                return z16 ? -1 : 1;
            }
            return 0;
        }
    };
    private final long[] mProcessStatsData = new long[4];
    private final String[] mProcessFullStatsStringData = new String[6];
    private final long[] mProcessFullStatsData = new long[6];
    private final long[] mSystemCpuData = new long[7];
    private final float[] mLoadAverageData = new float[3];
    private float mLoad1 = 0.0f;
    private float mLoad5 = 0.0f;
    private float mLoad15 = 0.0f;
    private final ArrayList<Stats> mProcStats = new ArrayList<>();
    private final ArrayList<Stats> mWorkingProcs = new ArrayList<>();
    private boolean mFirst = true;

    /* loaded from: classes5.dex */
    public interface FilterStats {
        boolean needed(Stats stats);
    }

    /* loaded from: classes5.dex */
    public static class Stats {
        public boolean active;
        public boolean added;
        public String baseName;
        public long base_majfaults;
        public long base_minfaults;
        public long base_stime;
        public long base_uptime;
        public long base_utime;
        final String cmdlineFile;
        public boolean interesting;
        public String name;
        public int nameWidth;
        public final int pid;
        public int rel_majfaults;
        public int rel_minfaults;
        public int rel_stime;
        public long rel_uptime;
        public int rel_utime;
        public boolean removed;
        final String statFile;
        final ArrayList<Stats> threadStats;
        final String threadsDir;
        public final int uid;
        public long vsize;
        public boolean working;
        final ArrayList<Stats> workingThreads;

        Stats(int i3, int i16, boolean z16) {
            this.pid = i3;
            if (i16 < 0) {
                File file = new File("/proc", Integer.toString(i3));
                this.uid = getUid(file.toString());
                this.statFile = new File(file, "stat").toString();
                this.cmdlineFile = new File(file, "cmdline").toString();
                this.threadsDir = new File(file, "task").toString();
                if (z16) {
                    this.threadStats = new ArrayList<>();
                    this.workingThreads = new ArrayList<>();
                    return;
                } else {
                    this.threadStats = null;
                    this.workingThreads = null;
                    return;
                }
            }
            File file2 = new File(new File(new File("/proc", Integer.toString(i16)), "task"), Integer.toString(i3));
            this.uid = getUid(file2.toString());
            this.statFile = new File(file2, "stat").toString();
            this.cmdlineFile = null;
            this.threadsDir = null;
            this.threadStats = null;
            this.workingThreads = null;
        }

        private static int getUid(String str) {
            try {
                return Os.stat(str).st_uid;
            } catch (Throwable th5) {
                Logger.f365497g.w(ProcessCpuTracker.TAG, "Failed to stat(" + str + "): " + th5);
                return -1;
            }
        }
    }

    public ProcessCpuTracker(boolean z16) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.cpuCoreNum = availableProcessors;
        this.hasProcTimeInStateReaderInited = false;
        this.procTimeInStateReaders = new ProcTimeInStateReader[availableProcessors];
        this.mIncludeThreads = z16;
        this.mCollectDeviceCpu = false;
        this.mCollectDeviceLoad = false;
        this.mJiffyMillis = 1000 / Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    private int[] collectStats(String str, int i3, boolean z16, int[] iArr, ArrayList<Stats> arrayList) {
        int[] iArr2;
        int length;
        int i16;
        Stats stats;
        int[] iArr3;
        int i17;
        ArrayList<Stats> arrayList2;
        int i18;
        int i19;
        int i26;
        long j3;
        long j16;
        long j17;
        int i27 = i3;
        ArrayList<Stats> arrayList3 = arrayList;
        int i28 = 1;
        ?? r102 = 0;
        if (this.mIncludeThreads) {
            iArr2 = Process.getPids(str, iArr);
        } else {
            iArr2 = new int[]{android.os.Process.myPid()};
        }
        int[] iArr4 = iArr2;
        if (iArr4 == null) {
            length = 0;
        } else {
            length = iArr4.length;
        }
        int size = arrayList.size();
        int i29 = 0;
        int i36 = 0;
        while (i36 < length && (i16 = iArr4[i36]) >= 0) {
            if (i29 < size) {
                stats = arrayList3.get(i29);
            } else {
                stats = null;
            }
            if (stats != null && stats.pid == i16) {
                stats.added = r102;
                stats.working = r102;
                int i37 = i29 + 1;
                if (stats.interesting) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    long[] jArr = this.mProcessStatsData;
                    if (Process.readProcFile(stats.statFile, PROCESS_STATS_FORMAT, null, jArr, null)) {
                        int[] iArr5 = iArr4;
                        i17 = length;
                        long j18 = jArr[r102];
                        long j19 = jArr[1];
                        long j26 = jArr[2];
                        long j27 = this.mJiffyMillis;
                        i26 = size;
                        long j28 = j26 * j27;
                        long j29 = jArr[3] * j27;
                        if (j28 == stats.base_utime && j29 == stats.base_stime) {
                            stats.rel_utime = 0;
                            stats.rel_stime = 0;
                            stats.rel_minfaults = 0;
                            stats.rel_majfaults = 0;
                            if (stats.active) {
                                stats.active = false;
                            }
                            iArr3 = iArr5;
                        } else {
                            if (!stats.active) {
                                stats.active = true;
                            }
                            if (i27 < 0) {
                                getName(stats, stats.cmdlineFile);
                                ArrayList<Stats> arrayList4 = stats.threadStats;
                                if (arrayList4 != null) {
                                    j16 = uptimeMillis;
                                    iArr3 = iArr5;
                                    j3 = j19;
                                    j17 = j29;
                                    this.mCurThreadPids = collectStats(stats.threadsDir, i16, false, this.mCurThreadPids, arrayList4);
                                    stats.rel_uptime = j16 - stats.base_uptime;
                                    stats.base_uptime = j16;
                                    stats.rel_utime = (int) (j28 - stats.base_utime);
                                    stats.rel_stime = (int) (j17 - stats.base_stime);
                                    stats.base_utime = j28;
                                    stats.base_stime = j17;
                                    stats.rel_minfaults = (int) (j18 - stats.base_minfaults);
                                    stats.rel_majfaults = (int) (j3 - stats.base_majfaults);
                                    stats.base_minfaults = j18;
                                    stats.base_majfaults = j3;
                                    stats.working = true;
                                }
                            }
                            iArr3 = iArr5;
                            j3 = j19;
                            j16 = uptimeMillis;
                            j17 = j29;
                            stats.rel_uptime = j16 - stats.base_uptime;
                            stats.base_uptime = j16;
                            stats.rel_utime = (int) (j28 - stats.base_utime);
                            stats.rel_stime = (int) (j17 - stats.base_stime);
                            stats.base_utime = j28;
                            stats.base_stime = j17;
                            stats.rel_minfaults = (int) (j18 - stats.base_minfaults);
                            stats.rel_majfaults = (int) (j3 - stats.base_majfaults);
                            stats.base_minfaults = j18;
                            stats.base_majfaults = j3;
                            stats.working = true;
                        }
                        i18 = i3;
                        arrayList2 = arrayList;
                        i29 = i37;
                        size = i26;
                    }
                }
                iArr3 = iArr4;
                i17 = length;
                i26 = size;
                i18 = i3;
                arrayList2 = arrayList;
                i29 = i37;
                size = i26;
            } else {
                iArr3 = iArr4;
                i17 = length;
                int i38 = size;
                if (stats != null && stats.pid <= i16) {
                    stats.rel_utime = 0;
                    stats.rel_stime = 0;
                    stats.rel_minfaults = 0;
                    stats.rel_majfaults = 0;
                    stats.removed = true;
                    stats.working = true;
                    arrayList2 = arrayList;
                    arrayList2.remove(i29);
                    size = i38 - 1;
                    i36--;
                    i18 = i3;
                } else {
                    arrayList2 = arrayList;
                    i18 = i3;
                    Stats stats2 = new Stats(i16, i18, this.mIncludeThreads);
                    arrayList2.add(i29, stats2);
                    int i39 = i29 + 1;
                    size = i38 + 1;
                    String[] strArr = this.mProcessFullStatsStringData;
                    long[] jArr2 = this.mProcessFullStatsData;
                    stats2.base_uptime = SystemClock.uptimeMillis();
                    if (Process.readProcFile(stats2.statFile, PROCESS_FULL_STATS_FORMAT, strArr, jArr2, null)) {
                        stats2.vsize = jArr2[5];
                        stats2.interesting = true;
                        stats2.baseName = strArr[0];
                        stats2.base_minfaults = jArr2[1];
                        stats2.base_majfaults = jArr2[2];
                        long j36 = jArr2[3];
                        long j37 = this.mJiffyMillis;
                        stats2.base_utime = j36 * j37;
                        stats2.base_stime = jArr2[4] * j37;
                    } else {
                        Logger.f365497g.w(TAG, "Skipping unknown process pid " + i16);
                        stats2.baseName = "<unknown>";
                        stats2.base_stime = 0L;
                        stats2.base_utime = 0L;
                        stats2.base_majfaults = 0L;
                        stats2.base_minfaults = 0L;
                    }
                    if (i18 < 0) {
                        getName(stats2, stats2.cmdlineFile);
                        ArrayList<Stats> arrayList5 = stats2.threadStats;
                        if (arrayList5 != null) {
                            this.mCurThreadPids = collectStats(stats2.threadsDir, i16, true, this.mCurThreadPids, arrayList5);
                        }
                    } else if (stats2.interesting) {
                        String str2 = stats2.baseName;
                        stats2.name = str2;
                        stats2.nameWidth = onMeasureProcessName(str2);
                    }
                    stats2.rel_utime = 0;
                    stats2.rel_stime = 0;
                    stats2.rel_minfaults = 0;
                    stats2.rel_majfaults = 0;
                    i19 = 1;
                    stats2.added = true;
                    if (!z16 && stats2.interesting) {
                        stats2.working = true;
                    }
                    i29 = i39;
                    i36 += i19;
                    arrayList3 = arrayList2;
                    i27 = i18;
                    length = i17;
                    iArr4 = iArr3;
                    r102 = 0;
                    i28 = i19;
                }
            }
            i19 = 1;
            i36 += i19;
            arrayList3 = arrayList2;
            i27 = i18;
            length = i17;
            iArr4 = iArr3;
            r102 = 0;
            i28 = i19;
        }
        ArrayList<Stats> arrayList6 = arrayList3;
        boolean z17 = i28;
        int[] iArr6 = iArr4;
        int i46 = size;
        while (i29 < i46) {
            Stats stats3 = arrayList6.get(i29);
            stats3.rel_utime = 0;
            stats3.rel_stime = 0;
            stats3.rel_minfaults = 0;
            stats3.rel_majfaults = 0;
            stats3.removed = z17;
            stats3.working = z17;
            arrayList6.remove(i29);
            i46--;
            Logger.f365497g.v(TAG, "Removed pid " + stats3.pid + MsgSummary.STR_COLON + stats3);
            z17 = 1;
        }
        return iArr6;
    }

    private long getDeviceCpuIdleTime() {
        long j3 = 0;
        for (int i3 = 0; i3 < this.cpuCoreNum; i3++) {
            for (int i16 = 0; i16 < 3; i16++) {
                String str = "/sys/devices/system/cpu/cpu" + i3 + "/cpuidle/state" + i16 + "/time";
                if (new File(str).exists()) {
                    j3 += Long.valueOf(FileUtil.readOutputFromFile(str)).longValue();
                }
            }
        }
        return j3 / 1000;
    }

    private long getDeviceCpuTime() {
        Path path;
        Path resolve;
        if (!this.hasProcTimeInStateReaderInited) {
            try {
                initProcTimeInStateReaderArray();
            } catch (IOException e16) {
                Logger.f365497g.c(TAG, e16);
            }
            this.hasProcTimeInStateReaderInited = true;
        }
        long j3 = 0;
        for (int i3 = 0; i3 < this.cpuCoreNum; i3++) {
            path = Paths.get(("/sys/devices/system/cpu/cpu" + i3) + "/cpufreq/stats", new String[0]);
            resolve = path.resolve("time_in_state");
            for (long j16 : this.procTimeInStateReaders[i3].getUsageTimesMillis(resolve)) {
                j3 += j16;
            }
        }
        return j3;
    }

    private void getName(Stats stats, String str) {
        String str2 = stats.name;
        if (str2 == null || str2.equals("app_process") || stats.name.equals("<pre-initialized>") || stats.name.equals("usap32") || stats.name.equals("usap64")) {
            String readTerminatedProcFile = ProcStatsUtil.readTerminatedProcFile(str, (byte) 0);
            if (readTerminatedProcFile != null && readTerminatedProcFile.length() > 1) {
                int lastIndexOf = readTerminatedProcFile.lastIndexOf("/");
                if (lastIndexOf > 0 && lastIndexOf < readTerminatedProcFile.length() - 1) {
                    readTerminatedProcFile = readTerminatedProcFile.substring(lastIndexOf + 1);
                }
                str2 = readTerminatedProcFile;
            }
            if (str2 == null) {
                str2 = stats.baseName;
            }
        }
        String str3 = stats.name;
        if (str3 == null || !str2.equals(str3)) {
            stats.name = str2;
            stats.nameWidth = onMeasureProcessName(str2);
        }
    }

    private void initProcTimeInStateReaderArray() throws IOException {
        Path path;
        Path resolve;
        for (int i3 = 0; i3 < this.cpuCoreNum; i3++) {
            String str = "/sys/devices/system/cpu/cpu" + i3;
            if (new File(str).exists()) {
                path = Paths.get(str + "/cpufreq/stats", new String[0]);
                resolve = path.resolve("time_in_state");
                this.procTimeInStateReaders[i3] = new ProcTimeInStateReader(resolve);
            }
        }
    }

    private void printProcessCPU(PrintWriter printWriter, String str, int i3, String str2, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
        printWriter.print(str);
        long j3 = i16 == 0 ? 1 : i16;
        printRatio(printWriter, i17 + i18 + i19 + i26 + i27, j3);
        printWriter.print("% ");
        if (i3 >= 0) {
            printWriter.print(i3);
            printWriter.print("/");
        }
        printWriter.print(str2);
        printWriter.print(MsgSummary.STR_COLON);
        printRatio(printWriter, i17, j3);
        printWriter.print("% user + ");
        printRatio(printWriter, i18, j3);
        printWriter.print("% kernel");
        if (i19 > 0) {
            printWriter.print(" + ");
            printRatio(printWriter, i19, j3);
            printWriter.print("% iowait");
        }
        if (i26 > 0) {
            printWriter.print(" + ");
            printRatio(printWriter, i26, j3);
            printWriter.print("% irq");
        }
        if (i27 > 0) {
            printWriter.print(" + ");
            printRatio(printWriter, i27, j3);
            printWriter.print("% softirq");
        }
        if (i28 > 0 || i29 > 0) {
            printWriter.print(" / faults:");
            if (i28 > 0) {
                printWriter.print(" ");
                printWriter.print(i28);
                printWriter.print(" minor");
            }
            if (i29 > 0) {
                printWriter.print(" ");
                printWriter.print(i29);
                printWriter.print(" major");
            }
        }
        printWriter.println();
    }

    private void printRatio(PrintWriter printWriter, long j3, long j16) {
        long j17 = (j3 * 1000) / j16;
        long j18 = j17 / 10;
        printWriter.print(j18);
        if (j18 < 10) {
            long j19 = j17 - (j18 * 10);
            if (j19 != 0) {
                printWriter.print('.');
                printWriter.print(j19);
            }
        }
    }

    final void buildWorkingProcs() {
        if (!this.mWorkingProcsSorted) {
            this.mWorkingProcs.clear();
            int size = this.mProcStats.size();
            for (int i3 = 0; i3 < size; i3++) {
                Stats stats = this.mProcStats.get(i3);
                if (stats.working) {
                    this.mWorkingProcs.add(stats);
                    ArrayList<Stats> arrayList = stats.threadStats;
                    if (arrayList != null && arrayList.size() > 1) {
                        stats.workingThreads.clear();
                        int size2 = stats.threadStats.size();
                        for (int i16 = 0; i16 < size2; i16++) {
                            Stats stats2 = stats.threadStats.get(i16);
                            if (stats2.working) {
                                stats.workingThreads.add(stats2);
                            }
                        }
                        Collections.sort(stats.workingThreads, sLoadComparator);
                    }
                }
            }
            Collections.sort(this.mWorkingProcs, sLoadComparator);
            this.mWorkingProcsSorted = true;
        }
    }

    public final int countStats() {
        return this.mProcStats.size();
    }

    public final int countWorkingStats() {
        buildWorkingProcs();
        return this.mWorkingProcs.size();
    }

    public long getCpuDelayTimeForPid(int i3) {
        long[] jArr = new long[4];
        if (Process.readProcFile("/proc/" + i3 + "/schedstat", PROCESS_SCHEDSTATS_FORMAT, null, jArr, null)) {
            return jArr[1] / 1000000;
        }
        return 0L;
    }

    public long getCpuTimeForPid(int i3) {
        long[] jArr = new long[4];
        if (Process.readProcFile("/proc/" + i3 + "/stat", PROCESS_STATS_FORMAT, null, jArr, null)) {
            return (jArr[2] + jArr[3]) * this.mJiffyMillis;
        }
        return 0L;
    }

    public final int getLastIdleTime() {
        return this.mRelIdleTime;
    }

    public final int getLastIoWaitTime() {
        return this.mRelIoWaitTime;
    }

    public final int getLastIrqTime() {
        return this.mRelIrqTime;
    }

    public final int getLastSoftIrqTime() {
        return this.mRelSoftIrqTime;
    }

    public final int getLastSystemTime() {
        return this.mRelSystemTime;
    }

    public final int getLastUserTime() {
        return this.mRelUserTime;
    }

    public final Stats getStats(int i3) {
        return this.mProcStats.get(i3);
    }

    public final Stats getTopWorkingStats() {
        buildWorkingProcs();
        if (!this.mWorkingProcs.isEmpty()) {
            return this.mWorkingProcs.get(0);
        }
        return null;
    }

    public final float getTotalCpuPercent() {
        int i3 = this.mRelUserTime;
        int i16 = this.mRelSystemTime;
        int i17 = i3 + i16 + this.mRelIrqTime + this.mRelIdleTime;
        if (i17 <= 0) {
            return 0.0f;
        }
        return (((i3 + i16) + r3) * 100.0f) / i17;
    }

    public final Stats getWorkingStats(int i3) {
        return this.mWorkingProcs.get(i3);
    }

    public final boolean hasGoodLastStats() {
        return this.mRelStatsAreGood;
    }

    public void init() {
        this.mFirst = true;
        update();
    }

    public int onMeasureProcessName(String str) {
        return 0;
    }

    public final String printCurrentLoad() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.print("Load: ");
        printWriter.print(this.mLoad1);
        printWriter.print(" / ");
        printWriter.print(this.mLoad5);
        printWriter.print(" / ");
        printWriter.println(this.mLoad15);
        printWriter.flush();
        return stringWriter.toString();
    }

    public final String printCurrentState(long j3) {
        return printCurrentState(j3, Integer.MAX_VALUE);
    }

    public void update() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mCollectDeviceCpu) {
            updateDeviceCpu();
        }
        updateProcessCpu();
        if (this.mCollectDeviceLoad) {
            updateDeviceLoad();
        }
        this.mLastSampleTime = this.mCurrentSampleTime;
        this.mCurrentSampleTime = uptimeMillis;
        this.mLastSampleRealTime = this.mCurrentSampleRealTime;
        this.mCurrentSampleRealTime = elapsedRealtime;
        this.mLastSampleWallTime = this.mCurrentSampleWallTime;
        this.mCurrentSampleWallTime = currentTimeMillis;
        this.mWorkingProcsSorted = false;
        this.mFirst = false;
    }

    public void updateDeviceCpu() {
        boolean z16;
        long[] jArr = this.mSystemCpuData;
        if (!AndroidVersion.isOverO()) {
            z16 = Process.readProcFile("/proc/stat", SYSTEM_CPU_FORMAT, null, jArr, null);
        } else {
            jArr[0] = getDeviceCpuTime();
            jArr[3] = getDeviceCpuIdleTime();
            jArr[6] = 0;
            jArr[5] = 0;
            jArr[4] = 0;
            jArr[2] = 0;
            jArr[1] = 0;
            z16 = true;
        }
        if (z16) {
            long j3 = jArr[0] + jArr[1];
            long j16 = this.mJiffyMillis;
            long j17 = j3 * j16;
            long j18 = jArr[2] * j16;
            long j19 = jArr[3] * j16;
            long j26 = jArr[4] * j16;
            long j27 = jArr[5] * j16;
            long j28 = j16 * jArr[6];
            long j29 = this.mBaseUserTime;
            if (j17 >= j29) {
                long j36 = this.mBaseSystemTime;
                if (j18 >= j36) {
                    long j37 = this.mBaseIoWaitTime;
                    if (j26 >= j37) {
                        long j38 = this.mBaseIrqTime;
                        if (j27 >= j38) {
                            long j39 = this.mBaseSoftIrqTime;
                            if (j28 >= j39) {
                                long j46 = this.mBaseIdleTime;
                                if (j19 >= j46) {
                                    this.mRelUserTime = (int) (j17 - j29);
                                    this.mRelSystemTime = (int) (j18 - j36);
                                    this.mRelIoWaitTime = (int) (j26 - j37);
                                    this.mRelIrqTime = (int) (j27 - j38);
                                    this.mRelSoftIrqTime = (int) (j28 - j39);
                                    this.mRelIdleTime = (int) (j19 - j46);
                                    this.mRelStatsAreGood = true;
                                    this.mBaseUserTime = j17;
                                    this.mBaseSystemTime = j18;
                                    this.mBaseIoWaitTime = j26;
                                    this.mBaseIrqTime = j27;
                                    this.mBaseSoftIrqTime = j28;
                                    this.mBaseIdleTime = j19;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            this.mRelUserTime = 0;
            this.mRelSystemTime = 0;
            this.mRelIoWaitTime = 0;
            this.mRelIrqTime = 0;
            this.mRelSoftIrqTime = 0;
            this.mRelIdleTime = 0;
            this.mRelStatsAreGood = false;
            Logger.f365497g.w(TAG, "/proc/stats has gone backwards; skipping CPU update");
        }
    }

    public void updateDeviceLoad() {
        float[] fArr = this.mLoadAverageData;
        if (Process.readProcFile("/proc/loadavg", LOAD_AVERAGE_FORMAT, null, null, fArr)) {
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            if (f16 != this.mLoad1 || f17 != this.mLoad5 || f18 != this.mLoad15) {
                this.mLoad1 = f16;
                this.mLoad5 = f17;
                this.mLoad15 = f18;
                onLoadChanged(f16, f17, f18);
            }
        }
    }

    public void updateProcessCpu() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (this.mIncludeThreads) {
                this.mCurPids = collectStats("/proc/self/task", android.os.Process.myPid(), this.mFirst, this.mCurPids, this.mProcStats);
            } else {
                this.mCurPids = collectStats("/proc/self/task", -1, this.mFirst, this.mCurPids, this.mProcStats);
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public final List<Stats> getStats(FilterStats filterStats) {
        ArrayList arrayList = new ArrayList(this.mProcStats.size());
        int size = this.mProcStats.size();
        for (int i3 = 0; i3 < size; i3++) {
            Stats stats = this.mProcStats.get(i3);
            if (filterStats.needed(stats)) {
                arrayList.add(stats);
            }
        }
        return arrayList;
    }

    public final String printCurrentState(long j3, int i3) {
        ArrayList<Stats> arrayList;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        buildWorkingProcs();
        StringWriter stringWriter = new StringWriter();
        int i16 = 0;
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
        printWriter.print("CPU usage from ");
        long j16 = this.mLastSampleTime;
        if (j3 > j16) {
            printWriter.print(j3 - j16);
            printWriter.print("ms to ");
            printWriter.print(j3 - this.mCurrentSampleTime);
            printWriter.print("ms ago");
        } else {
            printWriter.print(j16 - j3);
            printWriter.print("ms to ");
            printWriter.print(this.mCurrentSampleTime - j3);
            printWriter.print("ms later");
        }
        printWriter.print(" (");
        printWriter.print(simpleDateFormat.format(new Date(this.mLastSampleWallTime)));
        printWriter.print(" to ");
        printWriter.print(simpleDateFormat.format(new Date(this.mCurrentSampleWallTime)));
        printWriter.print(")");
        long j17 = this.mCurrentSampleTime - this.mLastSampleTime;
        long j18 = this.mCurrentSampleRealTime - this.mLastSampleRealTime;
        long j19 = j18 > 0 ? (j17 * 100) / j18 : 0L;
        if (j19 != 100) {
            printWriter.print(" with ");
            printWriter.print(j19);
            printWriter.print("% awake");
        }
        printWriter.println(":");
        int i17 = this.mRelUserTime + this.mRelSystemTime + this.mRelIoWaitTime + this.mRelIrqTime + this.mRelSoftIrqTime + this.mRelIdleTime;
        int min = Math.min(i3, this.mWorkingProcs.size());
        int i18 = 0;
        while (i18 < min) {
            Stats stats = this.mWorkingProcs.get(i18);
            int i19 = i18;
            int i26 = min;
            int i27 = i16;
            printProcessCPU(printWriter, stats.added ? " +" : stats.removed ? " -" : "  ", stats.pid, stats.name, (int) stats.rel_uptime, stats.rel_utime, stats.rel_stime, 0, 0, 0, stats.rel_minfaults, stats.rel_majfaults);
            Stats stats2 = stats;
            if (!stats2.removed && (arrayList = stats2.workingThreads) != null) {
                int size = arrayList.size();
                int i28 = i27;
                while (i28 < size) {
                    Stats stats3 = stats2.workingThreads.get(i28);
                    printProcessCPU(printWriter, stats3.added ? "   +" : stats3.removed ? "   -" : "    ", stats3.pid, stats3.name, (int) stats2.rel_uptime, stats3.rel_utime, stats3.rel_stime, 0, 0, 0, 0, 0);
                    i28++;
                    size = size;
                    stats2 = stats2;
                }
            }
            i18 = i19 + 1;
            min = i26;
            i16 = i27;
        }
        printProcessCPU(printWriter, "", -1, "TOTAL", i17, this.mRelUserTime, this.mRelSystemTime, this.mRelIoWaitTime, this.mRelIrqTime, this.mRelSoftIrqTime, 0, 0);
        printWriter.flush();
        return stringWriter.toString();
    }

    public void onLoadChanged(float f16, float f17, float f18) {
    }
}
