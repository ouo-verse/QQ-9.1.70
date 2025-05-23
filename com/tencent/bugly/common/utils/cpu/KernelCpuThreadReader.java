package com.tencent.bugly.common.utils.cpu;

import android.support.annotation.RequiresApi;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

/* compiled from: P */
@RequiresApi(api = 26)
/* loaded from: classes5.dex */
public class KernelCpuThreadReader {
    private static final String CPU_STATISTICS_FILENAME = "time_in_state";
    private static final boolean DEBUG = false;
    private static final Path DEFAULT_INITIAL_TIME_IN_STATE_PATH;
    private static final String DEFAULT_PROCESS_NAME = "unknown_process";
    private static final Path DEFAULT_PROC_PATH;
    private static final String DEFAULT_THREAD_NAME = "unknown_thread";
    private static final int ID_ERROR = -1;
    private static final String PROCESS_DIRECTORY_FILTER = "[0-9]*";
    private static final String PROCESS_NAME_FILENAME = "cmdline";
    private static final String TAG = "KernelCpuThreadReader";
    private static final String THREAD_NAME_FILENAME = "comm";
    private int[] mFrequenciesKhz;
    private FrequencyBucketCreator mFrequencyBucketCreator;
    private final Injector mInjector;
    private final Path mProcPath;
    private final ProcTimeInStateReader mProcTimeInStateReader;
    private Predicate<Integer> mUidPredicate;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class FrequencyBucketCreator {
        private final int[] mBucketStartIndices;
        private final int mNumBuckets;
        private final int mNumFrequencies;

        public FrequencyBucketCreator(long[] jArr, int i3) {
            int length = jArr.length;
            this.mNumFrequencies = length;
            int[] bucketStartIndices = getBucketStartIndices(getClusterStartIndices(jArr), i3, length);
            this.mBucketStartIndices = bucketStartIndices;
            this.mNumBuckets = bucketStartIndices.length;
        }

        private static int[] getBucketStartIndices(int[] iArr, int i3, int i16) {
            int i17;
            int length = iArr.length;
            if (length > i3) {
                return Arrays.copyOfRange(iArr, 0, i3);
            }
            IntArray intArray = new IntArray();
            for (int i18 = 0; i18 < length; i18++) {
                int lowerBound = getLowerBound(i18, iArr);
                int upperBound = getUpperBound(i18, iArr, i16);
                int i19 = length - 1;
                if (i18 != i19) {
                    i17 = i3 / length;
                } else {
                    i17 = i3 - ((i3 / length) * i19);
                }
                int max = Math.max(1, (upperBound - lowerBound) / i17);
                for (int i26 = 0; i26 < i17; i26++) {
                    int i27 = (i26 * max) + lowerBound;
                    if (i27 >= upperBound) {
                        break;
                    }
                    intArray.add(i27);
                }
            }
            return intArray.toArray();
        }

        private static int[] getClusterStartIndices(long[] jArr) {
            IntArray intArray = new IntArray();
            int i3 = 0;
            intArray.add(0);
            while (i3 < jArr.length - 1) {
                long j3 = jArr[i3];
                i3++;
                if (j3 >= jArr[i3]) {
                    intArray.add(i3);
                }
            }
            return intArray.toArray();
        }

        private static int getLowerBound(int i3, int[] iArr) {
            return iArr[i3];
        }

        private static int getUpperBound(int i3, int[] iArr, int i16) {
            if (i3 != iArr.length - 1) {
                return iArr[i3 + 1];
            }
            return i16;
        }

        public int[] bucketFrequencies(long[] jArr) {
            if (jArr.length == this.mNumFrequencies) {
                int i3 = this.mNumBuckets;
                int[] iArr = new int[i3];
                for (int i16 = 0; i16 < i3; i16++) {
                    iArr[i16] = (int) jArr[this.mBucketStartIndices[i16]];
                }
                return iArr;
            }
            throw new IllegalArgumentException();
        }

        public int[] bucketValues(long[] jArr) {
            if (jArr.length == this.mNumFrequencies) {
                int[] iArr = new int[this.mNumBuckets];
                for (int i3 = 0; i3 < this.mNumBuckets; i3++) {
                    int upperBound = getUpperBound(i3, this.mBucketStartIndices, jArr.length);
                    for (int lowerBound = getLowerBound(i3, this.mBucketStartIndices); lowerBound < upperBound; lowerBound++) {
                        iArr[i3] = (int) (iArr[i3] + jArr[lowerBound]);
                    }
                }
                return iArr;
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Injector {
        public int getUidForPid(int i3) {
            return Process.getUidForPid(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ProcessCpuUsage {
        public final int processId;
        public final String processName;
        public ArrayList<ThreadCpuUsage> threadCpuUsages;
        public final int uid;

        public ProcessCpuUsage(int i3, String str, int i16, ArrayList<ThreadCpuUsage> arrayList) {
            this.processId = i3;
            this.processName = str;
            this.uid = i16;
            this.threadCpuUsages = arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ThreadCpuUsage {
        public final int threadId;
        public final String threadName;
        public int[] usageTimesMillis;

        public ThreadCpuUsage(int i3, String str, int[] iArr) {
            this.threadId = i3;
            this.threadName = str;
            this.usageTimesMillis = iArr;
        }
    }

    static {
        Path path;
        Path resolve;
        path = Paths.get("/proc", new String[0]);
        DEFAULT_PROC_PATH = path;
        resolve = path.resolve("self/time_in_state");
        DEFAULT_INITIAL_TIME_IN_STATE_PATH = resolve;
    }

    public KernelCpuThreadReader(int i3, Predicate<Integer> predicate, Path path, Path path2, Injector injector) throws IOException {
        this.mUidPredicate = predicate;
        this.mProcPath = path;
        this.mProcTimeInStateReader = new ProcTimeInStateReader(path2);
        this.mInjector = injector;
        setNumBuckets(i3);
    }

    public static KernelCpuThreadReader create(int i3, Predicate<Integer> predicate) {
        try {
            return new KernelCpuThreadReader(i3, predicate, DEFAULT_PROC_PATH, DEFAULT_INITIAL_TIME_IN_STATE_PATH, new Injector());
        } catch (IOException e16) {
            Logger.f365497g.b(TAG, "Failed to initialize KernelCpuThreadReader", e16);
            return null;
        }
    }

    private int getProcessId(Path path) {
        Path fileName;
        String path2;
        fileName = path.getFileName();
        path2 = fileName.toString();
        try {
            return Integer.parseInt(path2);
        } catch (NumberFormatException e16) {
            Logger.f365497g.b(TAG, "Failed to parse " + path2 + " as process ID", e16);
            return -1;
        }
    }

    private String getProcessName(Path path) {
        Path resolve;
        String path2;
        resolve = path.resolve(PROCESS_NAME_FILENAME);
        path2 = resolve.toString();
        String readSingleLineProcFile = ProcStatsUtil.readSingleLineProcFile(path2);
        if (readSingleLineProcFile != null) {
            return readSingleLineProcFile;
        }
        return DEFAULT_PROCESS_NAME;
    }

    private ThreadCpuUsage getThreadCpuUsage(Path path) {
        Path fileName;
        String path2;
        Path resolve;
        int[] iArr;
        try {
            fileName = path.getFileName();
            path2 = fileName.toString();
            int parseInt = Integer.parseInt(path2);
            String threadName = getThreadName(path);
            resolve = path.resolve(CPU_STATISTICS_FILENAME);
            long[] usageTimesMillis = this.mProcTimeInStateReader.getUsageTimesMillis(resolve);
            if (usageTimesMillis == null) {
                return null;
            }
            FrequencyBucketCreator frequencyBucketCreator = this.mFrequencyBucketCreator;
            if (frequencyBucketCreator != null) {
                iArr = frequencyBucketCreator.bucketValues(usageTimesMillis);
            } else {
                int[] iArr2 = new int[usageTimesMillis.length];
                for (int i3 = 0; i3 < usageTimesMillis.length; i3++) {
                    iArr2[i3] = (int) usageTimesMillis[i3];
                }
                iArr = iArr2;
            }
            return new ThreadCpuUsage(parseInt, threadName, iArr);
        } catch (NumberFormatException e16) {
            Logger.f365497g.b(TAG, "Failed to parse thread ID when iterating over /proc/*/task", e16);
            return null;
        }
    }

    private String getThreadName(Path path) {
        Path resolve;
        String path2;
        resolve = path.resolve(THREAD_NAME_FILENAME);
        path2 = resolve.toString();
        String readNullSeparatedFile = ProcStatsUtil.readNullSeparatedFile(path2);
        if (readNullSeparatedFile == null) {
            return DEFAULT_THREAD_NAME;
        }
        return readNullSeparatedFile;
    }

    public int[] getCpuFrequenciesKhz() {
        return this.mFrequenciesKhz;
    }

    public ArrayList<ProcessCpuUsage> getProcessCpuUsage() {
        DirectoryStream<Path> newDirectoryStream;
        boolean test;
        ProcessCpuUsage processCpuUsage;
        ArrayList<ProcessCpuUsage> arrayList = new ArrayList<>();
        try {
            newDirectoryStream = Files.newDirectoryStream(this.mProcPath, PROCESS_DIRECTORY_FILTER);
            try {
                for (Path path : newDirectoryStream) {
                    int processId = getProcessId(path);
                    int uidForPid = this.mInjector.getUidForPid(processId);
                    if (uidForPid != -1 && processId != -1) {
                        test = this.mUidPredicate.test(Integer.valueOf(uidForPid));
                        if (test && (processCpuUsage = getProcessCpuUsage(path, processId, uidForPid)) != null) {
                            arrayList.add(processCpuUsage);
                        }
                    }
                }
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
                if (!arrayList.isEmpty()) {
                    return arrayList;
                }
                Logger.f365497g.w(TAG, "Didn't successfully get any process CPU information for UIDs specified");
                return null;
            } finally {
            }
        } catch (IOException e16) {
            Logger.f365497g.b(TAG, "Failed to iterate over process paths", e16);
            return null;
        }
    }

    void setNumBuckets(int i3) {
        int[] iArr = this.mFrequenciesKhz;
        if (iArr != null && iArr.length == i3) {
            return;
        }
        long[] frequenciesKhz = this.mProcTimeInStateReader.getFrequenciesKhz();
        if (i3 != 0) {
            FrequencyBucketCreator frequencyBucketCreator = new FrequencyBucketCreator(frequenciesKhz, i3);
            this.mFrequencyBucketCreator = frequencyBucketCreator;
            this.mFrequenciesKhz = frequencyBucketCreator.bucketFrequencies(frequenciesKhz);
        } else {
            this.mFrequencyBucketCreator = null;
            this.mFrequenciesKhz = new int[frequenciesKhz.length];
            for (int i16 = 0; i16 < frequenciesKhz.length; i16++) {
                this.mFrequenciesKhz[i16] = (int) frequenciesKhz[i16];
            }
        }
    }

    void setUidPredicate(Predicate<Integer> predicate) {
        this.mUidPredicate = predicate;
    }

    private ProcessCpuUsage getProcessCpuUsage(Path path, int i3, int i16) {
        Path resolve;
        DirectoryStream newDirectoryStream;
        Iterator it;
        resolve = path.resolve("task");
        ArrayList arrayList = new ArrayList();
        try {
            newDirectoryStream = Files.newDirectoryStream(resolve);
            try {
                it = newDirectoryStream.iterator();
                while (it.hasNext()) {
                    ThreadCpuUsage threadCpuUsage = getThreadCpuUsage((Path) it.next());
                    if (threadCpuUsage != null) {
                        arrayList.add(threadCpuUsage);
                    }
                }
                if (newDirectoryStream != null) {
                    newDirectoryStream.close();
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new ProcessCpuUsage(i3, getProcessName(path), i16, arrayList);
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    if (newDirectoryStream != null) {
                        try {
                            newDirectoryStream.close();
                        } catch (Throwable th7) {
                            th5.addSuppressed(th7);
                        }
                    }
                    throw th6;
                }
            }
        } catch (IOException | DirectoryIteratorException unused) {
            return null;
        }
    }
}
