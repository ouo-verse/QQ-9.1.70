package com.tencent.bugly.matrix.memguard;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.matrix.backtrace.WeChatBacktrace;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class MemGuard {
    private static final String DEFAULT_DUMP_FILE_EXT = ".txt";
    private static final String HOOK_COMMON_NATIVE_LIB_NAME = "matrix-hookcommon";
    private static final String ISSUE_CALLBACK_THREAD_NAME = "MemGuard.IssueCB";
    private static final long ISSUE_CALLBACK_TIMEOUT_MS = 5000;
    private static final String NATIVE_LIB_NAME = "matrix-memguard";
    private static final String TAG = "MemGuard";
    private static final boolean[] sInstalled = {false};
    private static IssueCallback sIssueCallback = new IssueCallback() { // from class: com.tencent.bugly.matrix.memguard.MemGuard.1
        @Override // com.tencent.bugly.matrix.memguard.MemGuard.IssueCallback
        public void onIssueDumpped(@NonNull String str) throws Throwable {
            BufferedReader bufferedReader;
            Throwable th5;
            File file = new File(str);
            if (!file.exists()) {
                Logger.f365497g.e(MemGuard.TAG, "Dump file %s does not exist, dump failure ?", str);
                return;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            Logger.f365497g.w(MemGuard.TAG, readLine);
                        } else {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                bufferedReader = null;
                th5 = th7;
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface IssueCallback {
        void onIssueDumpped(@NonNull String str) throws Throwable;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface NativeLibLoader {
        void loadLibrary(@NonNull String str);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class Options {
        public static final boolean DEFAULT_IGNORE_OVERLAPPED_READING = false;
        public static final int DEFAULT_MAX_ALLOCATION_SIZE = 8192;
        public static final int DEFAULT_MAX_DETECTABLE_ALLOCATION_COUNT = 4096;
        public static final int DEFAULT_MAX_SKIPPED_ALLOCATION_COUNT = 5;
        public static final int DEFAULT_PERCENTAGE_OF_LEFT_SIDE_GUARD = 30;
        public static final boolean DEFAULT_PERFECT_RIGHT_SIDE_GUARD = false;
        public static final String DEFAULT_TARGET_SO_PATTERN = ".*/lib.*\\.so$";

        @Keep
        public boolean ignoreOverlappedReading;

        @Keep
        public String[] ignoredSOPatterns;

        @Keep
        public String issueDumpFilePath;

        @Keep
        public int maxAllocationSize;

        @Keep
        public int maxDetectableAllocationCount;

        @Keep
        public int maxSkippedAllocationCount;

        @Keep
        public int percentageOfLeftSideGuard;

        @Keep
        public boolean perfectRightSideGuard;

        @Keep
        public String[] targetSOPatterns;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        public static class Builder {
            private Context mContext;
            private boolean mIgnoreOverlappedReading;
            private final List<String> mIgnoredSOPatterns;
            private String mIssueDumpFileDir;
            private int mMaxAllocationSize;
            private int mMaxDetectableAllocationCount;
            private int mMaxSkippedAllocationCount;
            private int mPercentageOfLeftSideGuard;
            private boolean mPerfectRightSideGuard;
            private final List<String> mTargetSOPatterns;

            public Builder(Context context) {
                this.mContext = context;
                if (context instanceof Activity) {
                    this.mContext = context.getApplicationContext();
                }
                this.mMaxAllocationSize = 8192;
                this.mMaxDetectableAllocationCount = 4096;
                this.mMaxSkippedAllocationCount = 5;
                this.mPercentageOfLeftSideGuard = 30;
                this.mPerfectRightSideGuard = false;
                this.mIgnoreOverlappedReading = false;
                this.mIssueDumpFileDir = MemGuard.getDefaultIssueDumpDir(context);
                this.mTargetSOPatterns = new ArrayList();
                this.mIgnoredSOPatterns = new ArrayList();
            }

            @NonNull
            public Options build() {
                Options options = new Options();
                if (getTargetSOPatterns().isEmpty()) {
                    setTargetSOPattern(Options.DEFAULT_TARGET_SO_PATTERN, new String[0]);
                }
                options.maxAllocationSize = getMaxAllocationSize();
                options.maxDetectableAllocationCount = getMaxDetectableAllocationCount();
                options.maxSkippedAllocationCount = getMaxSkippedAllocationCount();
                options.percentageOfLeftSideGuard = getPercentageOfLeftSideGuard();
                options.perfectRightSideGuard = isPerfectRightSideGuard();
                options.ignoreOverlappedReading = isIgnoreOverlappedReading();
                options.issueDumpFilePath = MemGuard.generateIssueDumpFilePath(this.mContext, getIssueDumpFileDir());
                options.targetSOPatterns = (String[]) getTargetSOPatterns().toArray(new String[0]);
                options.ignoredSOPatterns = (String[]) getIgnoredSOPatterns().toArray(new String[0]);
                return options;
            }

            @NonNull
            public List<String> getIgnoredSOPatterns() {
                return Collections.unmodifiableList(this.mIgnoredSOPatterns);
            }

            @Nullable
            public String getIssueDumpFileDir() {
                return this.mIssueDumpFileDir;
            }

            public int getMaxAllocationSize() {
                return this.mMaxAllocationSize;
            }

            public int getMaxDetectableAllocationCount() {
                return this.mMaxDetectableAllocationCount;
            }

            public int getMaxSkippedAllocationCount() {
                return this.mMaxSkippedAllocationCount;
            }

            public int getPercentageOfLeftSideGuard() {
                return this.mPercentageOfLeftSideGuard;
            }

            @NonNull
            public List<String> getTargetSOPatterns() {
                return Collections.unmodifiableList(this.mTargetSOPatterns);
            }

            public boolean isIgnoreOverlappedReading() {
                return this.mIgnoreOverlappedReading;
            }

            public boolean isPerfectRightSideGuard() {
                return this.mPerfectRightSideGuard;
            }

            @NonNull
            public Builder setIgnoredSOPattern(@NonNull String str, String... strArr) {
                this.mIgnoredSOPatterns.clear();
                this.mIgnoredSOPatterns.add(str);
                this.mIgnoredSOPatterns.addAll(Arrays.asList(strArr));
                return this;
            }

            @NonNull
            public Builder setIsIgnoreOverlappedReading(boolean z16) {
                this.mIgnoreOverlappedReading = z16;
                return this;
            }

            @NonNull
            public Builder setIsPerfectRightSideGuard(boolean z16) {
                this.mPerfectRightSideGuard = z16;
                return this;
            }

            @NonNull
            public Builder setIssueDumpFileDir(@Nullable String str) {
                this.mIssueDumpFileDir = str;
                return this;
            }

            @NonNull
            public Builder setMaxDetectableAllocationCount(int i3) {
                this.mMaxDetectableAllocationCount = i3;
                return this;
            }

            @NonNull
            public Builder setMaxDetectableSize(int i3) {
                this.mMaxAllocationSize = i3;
                return this;
            }

            @NonNull
            public Builder setMaxSkippedAllocationCount(int i3) {
                this.mMaxSkippedAllocationCount = i3;
                return this;
            }

            @NonNull
            public Builder setPercentageOfLeftSideGuard(int i3) {
                this.mPercentageOfLeftSideGuard = i3;
                return this;
            }

            @NonNull
            public Builder setTargetSOPattern(@NonNull String str, String... strArr) {
                this.mTargetSOPatterns.clear();
                this.mTargetSOPatterns.add(str);
                this.mTargetSOPatterns.addAll(Arrays.asList(strArr));
                return this;
            }
        }

        public String toString() {
            return "Options{maxAllocationSize=" + this.maxAllocationSize + ", maxDetectableAllocationCount=" + this.maxDetectableAllocationCount + ", maxSkippedAllocationCount=" + this.maxSkippedAllocationCount + ", percentageOfLeftSideGuard=" + this.percentageOfLeftSideGuard + ", perfectRightSideGuard=" + this.perfectRightSideGuard + ", ignoreOverlappedReading=" + this.ignoreOverlappedReading + ", issueDumpFilePath=" + this.issueDumpFilePath + ", targetSOPatterns=" + Arrays.toString(this.targetSOPatterns) + ", ignoredSOPatterns=" + Arrays.toString(this.ignoredSOPatterns) + '}';
        }

        Options() {
        }
    }

    @Keep
    private static void c2jNotifyOnIssueDumped(final String str) {
        BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.bugly.matrix.memguard.MemGuard.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MemGuard.sIssueCallback.onIssueDumpped(str);
                } catch (Throwable th5) {
                    Logger.f365497g.e(MemGuard.TAG, "Exception was thrown when onIssueDumpped was called." + th5);
                }
            }
        }, ISSUE_CALLBACK_THREAD_NAME);
        long currentTimeMillis = System.currentTimeMillis();
        baseThread.start();
        try {
            baseThread.join(5000L);
        } catch (InterruptedException unused) {
            Logger.f365497g.w(TAG, "Issue callback was interrupted.");
        }
        if (System.currentTimeMillis() - currentTimeMillis > 5000) {
            Logger.f365497g.w(TAG, "Timeout when call issue callback.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String generateIssueDumpFilePath(Context context, String str) {
        return new File(str, "asan_info_" + TraceGenerator.getProcessLaunchId() + DEFAULT_DUMP_FILE_EXT).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getDefaultIssueDumpDir(@NonNull Context context) {
        return new File(context.getFilesDir(), "bugly_asan").getAbsolutePath();
    }

    @NonNull
    public static List<File> getLastIssueDumpFilesInDefaultDir(@NonNull Context context) {
        File[] listFiles = new File(getDefaultIssueDumpDir(context)).listFiles(new FilenameFilter() { // from class: com.tencent.bugly.matrix.memguard.MemGuard.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(MemGuard.DEFAULT_DUMP_FILE_EXT);
            }
        });
        if (listFiles != null) {
            return Collections.unmodifiableList(Arrays.asList(listFiles));
        }
        return Collections.emptyList();
    }

    private static String getProcessSuffix(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid == myPid) {
                    int lastIndexOf = runningAppProcessInfo.processName.lastIndexOf(58);
                    if (lastIndexOf >= 0) {
                        return runningAppProcessInfo.processName.substring(lastIndexOf + 1);
                    }
                    return "main";
                }
            }
            return "@";
        }
        return "@";
    }

    public static boolean install(@NonNull Options options, @Nullable IssueCallback issueCallback) {
        boolean z16;
        Objects.requireNonNull(options);
        boolean[] zArr = sInstalled;
        synchronized (zArr) {
            if (zArr[0]) {
                Logger.f365497g.w(TAG, "Already installed.");
                return true;
            }
            try {
                WeChatBacktrace.initQuickBacktrace();
                if (issueCallback != null) {
                    sIssueCallback = issueCallback;
                }
                z16 = nativeInstall(options);
            } catch (Throwable th5) {
                Logger.f365497g.e(TAG, "Install MemGuard failed." + th5);
                z16 = false;
            }
            if (z16) {
                Logger.f365497g.i(TAG, "Install MemGuard successfully with " + options);
            } else {
                Logger.f365497g.e(TAG, "Install MemGuard failed with " + options);
            }
            sInstalled[0] = z16;
            return z16;
        }
    }

    public static boolean isInstalled() {
        boolean z16;
        boolean[] zArr = sInstalled;
        synchronized (zArr) {
            z16 = zArr[0];
        }
        return z16;
    }

    @Nullable
    private static native String nativeGetIssueDumpFilePath();

    private static native boolean nativeInstall(@NonNull Options options);

    public static native void stopDumpIssue();
}
