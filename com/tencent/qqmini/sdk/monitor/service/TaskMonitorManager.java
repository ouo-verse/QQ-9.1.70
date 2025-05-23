package com.tencent.qqmini.sdk.monitor.service;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.monitor.common.FPSCalculator;
import com.tencent.qqmini.sdk.monitor.common.ProcessStats;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TaskMonitorManager {
    public static final String SCENE_TAG_HIDE = "hide";
    public static final String SCENE_TAG_SHOW = "show";
    public static final String TAG = "TaskMonitorManager";
    public static String TASK_PERFM_SWITCH_PAGE = "\u5207\u6362\u9875\u9762\u8017\u65f6";
    protected static TaskMonitorManager mInstance;
    private final FpsListener mFpsListener;
    protected boolean mEnable = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
    protected boolean isCalcDeviceUsageOk = true;
    protected volatile int sTotalCpuUsage = 0;
    protected volatile long mAppLastUsage = 0;
    protected volatile long mDeviceLastUsage = 0;
    protected volatile long mAppCurUsage = 0;
    protected volatile long mDeviceCurUsage = 0;
    protected volatile double mCurrentFps = 0.0d;
    protected ConcurrentHashMap<String, ThreadMsgInfo> mMsgInfoList = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class FpsListener implements FPSCalculator.GetFPSListener {
        FpsListener() {
        }

        @Override // com.tencent.qqmini.sdk.monitor.common.FPSCalculator.GetFPSListener
        public void onInfo(long j3, double d16) {
            TaskMonitorManager.this.mCurrentFps = d16;
        }
    }

    protected TaskMonitorManager() {
        FpsListener fpsListener = new FpsListener();
        this.mFpsListener = fpsListener;
        FPSCalculator.getInstance().addListener(fpsListener);
        updateCpuInfoSync();
    }

    public static TaskMonitorManager g() {
        if (mInstance == null) {
            synchronized (TaskMonitorManager.class) {
                if (mInstance == null) {
                    mInstance = new TaskMonitorManager();
                }
            }
        }
        return mInstance;
    }

    public static int[] getMemoryStatics() {
        int[] iArr = {0, 0, 0};
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Map<String, String> memoryStats = memoryInfo.getMemoryStats();
            iArr[0] = safeConvertInt(memoryStats.get("summary.total-pss"), 0);
            iArr[1] = safeConvertInt(memoryStats.get("summary.native-heap"), 0);
            iArr[2] = safeConvertInt(memoryStats.get("summary.graphics"), 0);
        } catch (Throwable th5) {
            QMLog.e("TaskMonitorManager", "getMemoryStatics exception. e=", th5);
        }
        return iArr;
    }

    public static int getTotalPss(Context context) {
        ActivityManager activityManager;
        Debug.MemoryInfo memoryInfo;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) == null) {
            return 0;
        }
        try {
            Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{Process.myPid()});
            if (processMemoryInfo != null && processMemoryInfo.length > 0 && (memoryInfo = processMemoryInfo[0]) != null) {
                Map<String, String> memoryStats = memoryInfo.getMemoryStats();
                if (memoryStats.containsKey("summary.total-pss")) {
                    return Integer.parseInt(memoryStats.get("summary.total-pss"));
                }
                return memoryInfo.getTotalPss();
            }
            return 0;
        } catch (Throwable th5) {
            QMLog.e("TaskMonitorManager", "getProcessPss error", th5);
            return 0;
        }
    }

    private static int safeConvertInt(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    protected ThreadMsgInfo fillEndThreadInfo(ThreadMsgInfo threadMsgInfo) {
        if (threadMsgInfo != null) {
            threadMsgInfo.realTimeEnd = System.currentTimeMillis();
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            threadMsgInfo.threadTimeEnd = currentThreadTimeMillis;
            long j3 = threadMsgInfo.realTimeEnd - threadMsgInfo.realTimeStart;
            long j16 = 0;
            if (j3 <= 0) {
                j3 = 0;
            }
            threadMsgInfo.realTimeCost = j3;
            long j17 = currentThreadTimeMillis - threadMsgInfo.threadTimeStart;
            if (j17 > 0) {
                j16 = j17;
            }
            threadMsgInfo.threadTimeCost = j16;
        }
        return threadMsgInfo;
    }

    protected String genKey(String str, Runnable runnable) {
        if (TextUtils.isEmpty(str)) {
            if (runnable == null) {
                return "null";
            }
            return runnable.toString();
        }
        return str;
    }

    protected ThreadMsgInfo genStartThreadInfo(String str, Thread thread) {
        ThreadMsgInfo threadMsgInfo = new ThreadMsgInfo();
        threadMsgInfo.key = genKey(str, thread);
        if (thread != null) {
            threadMsgInfo.currentRunnable = thread.toString();
            threadMsgInfo.currentThreadName = thread.getName();
            threadMsgInfo.currentThreadId = thread.getId();
            try {
                threadMsgInfo.currentThreadStack = thread.getStackTrace();
            } catch (Exception unused) {
                threadMsgInfo.currentThreadStack = null;
            }
        }
        threadMsgInfo.realTimeStart = System.currentTimeMillis();
        threadMsgInfo.threadTimeStart = SystemClock.currentThreadTimeMillis();
        return threadMsgInfo;
    }

    public String getCpuUsageInfo() {
        return "CPU\u5df2\u4f7f\u7528: " + (this.mAppCurUsage - this.mAppLastUsage);
    }

    public String getCpuUsageRate() {
        String str;
        if (this.sTotalCpuUsage > 0) {
            str = "CPU\u4f7f\u7528\u7387: " + this.sTotalCpuUsage + "%";
        } else {
            str = "CPU\u4f7f\u7528\u7387: -";
        }
        updateCpuInfoSync();
        return str;
    }

    public double getCurrentFps() {
        return this.mCurrentFps;
    }

    public boolean getEnable() {
        return this.mEnable;
    }

    public long getHeapAllocatedMemory() {
        return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576;
    }

    public long getMemeryUsage() {
        int i3;
        long maxMemory = Runtime.getRuntime().maxMemory();
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (maxMemory > 0 && freeMemory > 0) {
            i3 = (int) ((((float) freeMemory) / ((float) maxMemory)) * 100.0f);
        } else {
            i3 = 0;
        }
        return i3;
    }

    public ThreadMsgInfo getTaskLooperInfo(String str) {
        ConcurrentHashMap<String, ThreadMsgInfo> concurrentHashMap;
        if (!this.mEnable || TextUtils.isEmpty(str) || (concurrentHashMap = this.mMsgInfoList) == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.mMsgInfoList.get(str);
    }

    public ThreadMsgInfo getTaskPerfmSwitchPageInfo() {
        return getTaskLooperInfo(TASK_PERFM_SWITCH_PAGE);
    }

    public long getTotalCpuUsageAndUpdate() {
        return this.sTotalCpuUsage;
    }

    public void setCurrentFps(double d16) {
        this.mCurrentFps = d16;
    }

    public void setEnable(boolean z16) {
        this.mEnable = z16;
    }

    public void startLooperMonitor(String str) {
        startLooperMonitor(str, null, null, null, null);
    }

    public void stopLooperMonitor(String str) {
        stopLooperMonitor(str, null);
    }

    public void switchPerfmPage(String str, boolean z16) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadMsgInfo taskPerfmSwitchPageInfo = getTaskPerfmSwitchPageInfo();
        if (QMLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("switchPerfmPage, page url is ");
            sb5.append(str);
            sb5.append(", ");
            if (z16) {
                str3 = "show";
            } else {
                str3 = "hide";
            }
            sb5.append(str3);
            QMLog.d("TaskMonitorManager", sb5.toString());
        }
        if (z16) {
            str2 = "show";
        } else {
            str2 = "hide";
        }
        if (taskPerfmSwitchPageInfo != null) {
            if (z16) {
                stopLooperMonitor(TASK_PERFM_SWITCH_PAGE, null);
                return;
            } else {
                String str4 = TASK_PERFM_SWITCH_PAGE;
                startLooperMonitor(str4, null, str4, str, str2);
                return;
            }
        }
        String str5 = TASK_PERFM_SWITCH_PAGE;
        startLooperMonitor(str5, null, str5, str, str2);
    }

    public void updateCpuInfoSync() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager.1
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                boolean z16;
                TaskMonitorManager taskMonitorManager = TaskMonitorManager.this;
                taskMonitorManager.mAppLastUsage = taskMonitorManager.mAppCurUsage;
                TaskMonitorManager.this.mAppCurUsage = ProcessStats.collectCpuUsage("-1");
                long j16 = TaskMonitorManager.this.mAppCurUsage - TaskMonitorManager.this.mAppLastUsage;
                TaskMonitorManager taskMonitorManager2 = TaskMonitorManager.this;
                if (taskMonitorManager2.isCalcDeviceUsageOk) {
                    taskMonitorManager2.mDeviceLastUsage = taskMonitorManager2.mDeviceCurUsage;
                    TaskMonitorManager.this.mDeviceCurUsage = ProcessStats.collectCpuUsage("-2");
                    j3 = TaskMonitorManager.this.mDeviceCurUsage - TaskMonitorManager.this.mDeviceLastUsage;
                } else {
                    j3 = 0;
                }
                TaskMonitorManager taskMonitorManager3 = TaskMonitorManager.this;
                if (taskMonitorManager3.mDeviceCurUsage > 0 && j3 > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                taskMonitorManager3.isCalcDeviceUsageOk = z16;
                TaskMonitorManager taskMonitorManager4 = TaskMonitorManager.this;
                if (taskMonitorManager4.isCalcDeviceUsageOk) {
                    taskMonitorManager4.sTotalCpuUsage = (int) ((j16 * 100) / j3);
                } else {
                    taskMonitorManager4.sTotalCpuUsage = 0;
                }
            }
        });
    }

    public void startLooperMonitor(String str, Thread thread, String str2, String str3, String str4) {
        if (this.mEnable) {
            String genKey = genKey(str, thread);
            if (TextUtils.isEmpty(genKey)) {
                return;
            }
            if (QMLog.isColorLevel()) {
                QMLog.d("TaskMonitorManager", "startLooperMonitor, key is " + str);
            }
            ConcurrentHashMap<String, ThreadMsgInfo> concurrentHashMap = this.mMsgInfoList;
            if (concurrentHashMap != null) {
                ThreadMsgInfo threadMsgInfo = concurrentHashMap.containsKey(genKey) ? this.mMsgInfoList.get(str) : null;
                if (threadMsgInfo == null) {
                    threadMsgInfo = genStartThreadInfo(str, thread);
                }
                threadMsgInfo.realTimeStart = System.currentTimeMillis();
                threadMsgInfo.threadTimeStart = SystemClock.currentThreadTimeMillis();
                threadMsgInfo.sceneName = str2;
                threadMsgInfo.sceneDes = str3;
                threadMsgInfo.sceneTag = str4;
                this.mMsgInfoList.put(genKey, threadMsgInfo);
            }
        }
    }

    public void stopLooperMonitor(String str, Runnable runnable) {
        ConcurrentHashMap<String, ThreadMsgInfo> concurrentHashMap;
        if (this.mEnable) {
            String genKey = genKey(str, runnable);
            if (QMLog.isColorLevel()) {
                QMLog.d("TaskMonitorManager", "stopLooperMonitor, key is " + genKey);
            }
            if (TextUtils.isEmpty(genKey) || (concurrentHashMap = this.mMsgInfoList) == null || !concurrentHashMap.containsKey(genKey)) {
                return;
            }
            this.mMsgInfoList.put(str, fillEndThreadInfo(this.mMsgInfoList.get(genKey)));
        }
    }
}
