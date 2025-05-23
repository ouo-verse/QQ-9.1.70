package com.tencent.rfix.loader.safemode;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.utils.PatchFileUtils;
import com.tencent.rfix.loader.utils.ProcessUtils;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFixSafeModeKeeper {
    private static final long P2_DURATION = 2000;
    private static final long P3_DURATION = 10000;
    private static final long P3_LATEST_CRASH_DURATION = 120000;
    public static final int RESULT_OK = 0;
    public static final int RESULT_P1_LIMIT = -1;
    public static final int RESULT_P2_LIMIT = -2;
    public static final int RESULT_P3_LIMIT = -3;
    private static final String RFIX_SAFE_MODE_INFO_NAME = "rfix_safe_mode_info";
    private static final String TAG = "RFix.RFixSafeModeKeeper";
    private static Strategy curStrategy = Strategy.MAIN_PROCESS;
    protected static volatile boolean hasLoadPatch;
    private static volatile boolean hasRegisterExceptionHandler;
    protected static volatile boolean loadingPatch;
    protected static volatile long patchLoadTime;
    protected static volatile boolean useSafeMode;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public enum Strategy {
        MAIN_PROCESS(2, 5, 3),
        MULTI_PROCESS(5, 5, 5);

        public final int p1MaxCount;
        public final int p2MaxCount;
        public final int p3MaxCount;

        Strategy(int i3, int i16, int i17) {
            this.p1MaxCount = i3;
            this.p2MaxCount = i16;
            this.p3MaxCount = i17;
        }
    }

    public static int checkSafeMode(Context context, RFixLoadResult rFixLoadResult) {
        RFixSafeModeInfo rFixSafeModeInfo = new RFixSafeModeInfo(context, getSafeModeInfoName(context));
        if (reachP1Limit(rFixSafeModeInfo)) {
            return -1;
        }
        if (reachP2Limit(rFixSafeModeInfo)) {
            rFixLoadResult.safeModeSubResult = -2;
        }
        if (reachP3Limit(rFixSafeModeInfo.p3CrashTimes)) {
            return -3;
        }
        rFixSafeModeInfo.p1Count++;
        useSafeMode = true;
        rFixSafeModeInfo.saveStoreInfo();
        return 0;
    }

    private static String getSafeModeInfoName(Context context) {
        String str;
        if (curStrategy == Strategy.MULTI_PROCESS) {
            return RFIX_SAFE_MODE_INFO_NAME;
        }
        String processName = ProcessUtils.getProcessName(context);
        int indexOf = processName.indexOf(58);
        if (indexOf >= 0) {
            str = processName.substring(indexOf);
        } else {
            str = "";
        }
        return RFIX_SAFE_MODE_INFO_NAME + str;
    }

    public static Strategy getStrategy() {
        return curStrategy;
    }

    protected static void handlePatchCrash(Context context, String str) {
        boolean isP3Crash = isP3Crash(SystemClock.elapsedRealtime(), patchLoadTime);
        RFixLog.i(TAG, String.format("handlePatchCrash isP3Crash=%s", Boolean.valueOf(isP3Crash)));
        if (isP3Crash) {
            RFixSafeModeInfo rFixSafeModeInfo = new RFixSafeModeInfo(context, getSafeModeInfoName(context));
            rFixSafeModeInfo.p3CrashTimes.add(Long.valueOf(System.currentTimeMillis()));
            if (rFixSafeModeInfo.p3CrashTimes.size() > curStrategy.p3MaxCount) {
                rFixSafeModeInfo.p3CrashTimes.remove(0);
            }
            rFixSafeModeInfo.saveStoreInfo();
            writeLastCrashFile(context, str);
        }
    }

    public static void initialize(Context context) {
        RFixLog.d(TAG, "initialize strategy=" + curStrategy);
        loadingPatch = true;
        hasLoadPatch = false;
        if (!hasRegisterExceptionHandler) {
            hasRegisterExceptionHandler = true;
            Thread.setDefaultUncaughtExceptionHandler(new RFixExceptionHandler(context));
        }
    }

    protected static boolean isP3Crash(long j3, long j16) {
        long j17 = j3 - j16;
        RFixLog.i(TAG, "isP3Crash loadTime = " + j16 + ", currentTime = " + j3 + ", elapsedTime = " + j17);
        if (j3 > 0 && j16 > 0 && j17 > 0 && j17 < 10000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void onJavaCrash(Context context, Throwable th5) {
        String throwableToString = throwableToString(th5);
        if (loadingPatch) {
            writeLastCrashFile(context, throwableToString);
        } else if (hasLoadPatch) {
            handlePatchCrash(context, throwableToString);
        } else {
            RFixLog.w(TAG, "handleJavaCrash no patch load, ignore!");
        }
    }

    public static void onLoadPatchEnd(Context context, RFixLoadResult rFixLoadResult) {
        loadingPatch = false;
        RFixConstants.LoadResult loadResult = rFixLoadResult.result;
        RFixConstants.LoadResult loadResult2 = RFixConstants.LoadResult.LOAD_RESULT_SUCCESS;
        if (loadResult == loadResult2) {
            hasLoadPatch = true;
            patchLoadTime = SystemClock.elapsedRealtime();
        }
        if (!useSafeMode) {
            return;
        }
        final RFixSafeModeInfo rFixSafeModeInfo = new RFixSafeModeInfo(context, getSafeModeInfoName(context));
        rFixSafeModeInfo.p1Count = 0;
        if (rFixLoadResult.result == loadResult2) {
            rFixSafeModeInfo.p2Count++;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.rfix.loader.safemode.RFixSafeModeKeeper.1
                @Override // java.lang.Runnable
                public void run() {
                    RFixSafeModeInfo rFixSafeModeInfo2 = RFixSafeModeInfo.this;
                    rFixSafeModeInfo2.p2Count = 0;
                    rFixSafeModeInfo2.saveStoreInfo();
                }
            }, 2000L);
        }
        rFixSafeModeInfo.saveStoreInfo();
    }

    public static void onNativeCrash(Context context, String str) {
        if (!loadingPatch && hasLoadPatch) {
            handlePatchCrash(context, str);
        } else {
            RFixLog.w(TAG, "handleNativeCrash no patch load, ignore!");
        }
    }

    private static boolean reachP1Limit(RFixSafeModeInfo rFixSafeModeInfo) {
        if (rFixSafeModeInfo.p1Count >= curStrategy.p1MaxCount) {
            return true;
        }
        return false;
    }

    private static boolean reachP2Limit(RFixSafeModeInfo rFixSafeModeInfo) {
        if (rFixSafeModeInfo.p2Count >= curStrategy.p2MaxCount) {
            return true;
        }
        return false;
    }

    private static boolean reachP3Limit(List<Long> list) {
        if (list == null || list.isEmpty() || list.size() < curStrategy.p3MaxCount || list.get(list.size() - 1).longValue() - list.get(0).longValue() > 120000) {
            return false;
        }
        return true;
    }

    public static void resetSafeMode(Context context) {
        RFixSafeModeInfo rFixSafeModeInfo = new RFixSafeModeInfo(context, getSafeModeInfoName(context));
        rFixSafeModeInfo.p1Count = 0;
        rFixSafeModeInfo.p2Count = 0;
        rFixSafeModeInfo.p3CrashTimes = new ArrayList();
        rFixSafeModeInfo.saveStoreInfo();
    }

    public static void setStrategy(Strategy strategy) {
        curStrategy = strategy;
    }

    public static String throwableToString(Throwable th5) {
        PrintWriter printWriter;
        ByteArrayOutputStream byteArrayOutputStream;
        String str = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            printWriter = new PrintWriter(byteArrayOutputStream);
        } catch (Throwable th6) {
            th = th6;
            printWriter = null;
        }
        try {
            th5.printStackTrace(printWriter);
            printWriter.flush();
            str = byteArrayOutputStream.toString();
        } catch (Throwable th7) {
            th = th7;
            try {
                RFixLog.e(TAG, "throwableToString fail!", th);
                return str;
            } finally {
                PatchFileUtils.closeQuietly(printWriter);
            }
        }
        return str;
    }

    public static void writeLastCrashFile(Context context, String str) {
        PrintWriter printWriter;
        RFixLog.w(TAG, String.format("writeLastCrashFile content=\n%s", str));
        File patchLastCrashFile = PatchFileUtils.getPatchLastCrashFile(context);
        File parentFile = patchLastCrashFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        PrintWriter printWriter2 = null;
        try {
            printWriter = new PrintWriter(new FileWriter(patchLastCrashFile, false));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            printWriter.write(str);
            PatchFileUtils.closeQuietly(printWriter);
        } catch (Throwable th6) {
            th = th6;
            printWriter2 = printWriter;
            try {
                RFixLog.e(TAG, "writeLastCrashFile fail!", th);
            } finally {
                PatchFileUtils.closeQuietly(printWriter2);
            }
        }
    }
}
