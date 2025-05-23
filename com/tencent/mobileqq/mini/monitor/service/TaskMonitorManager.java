package com.tencent.mobileqq.mini.monitor.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.f;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TaskMonitorManager {
    public static final String SCENE_TAG_HIDE = "hide";
    public static final String SCENE_TAG_SHOW = "show";
    public static final String TAG = "TaskMonitorManager";
    public static String TASK_PERFM_SWITCH_PAGE = HardCodeUtil.qqStr(R.string.tzl);
    protected static TaskMonitorManager mInstance;
    protected boolean mEnable = false;
    protected boolean isCalcDeviceUsageOk = true;
    protected volatile int sTotalCpuUsage = 0;
    protected volatile long mAppLastUsage = 0;
    protected volatile long mDeviceLastUsage = 0;
    protected volatile long mAppCurUsage = 0;
    protected volatile long mDeviceCurUsage = 0;
    protected volatile double mCurrentFps = 0.0d;
    protected ConcurrentHashMap<String, ThreadMsgInfo> mMsgInfoList = new ConcurrentHashMap<>();
    private FpsListener mFpsListener = new FpsListener();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private class FpsListener implements FPSCalculator.a {
        FpsListener() {
        }

        @Override // com.tencent.mobileqq.util.FPSCalculator.a
        public void onInfo(long j3, double d16) {
            TaskMonitorManager.this.mCurrentFps = d16;
        }
    }

    protected TaskMonitorManager() {
        FPSCalculator.p().l(this.mFpsListener);
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

    protected String genKey(String str, Runnable runnable) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (runnable == null) {
            return "null";
        }
        return runnable.toString();
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
        return (Runtime.getRuntime().maxMemory() <= 0 || Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() <= 0) ? 0 : (int) ((((float) r2) / ((float) r0)) * 100.0f);
    }

    public ThreadMsgInfo getTaskLooperInfo(String str) {
        ConcurrentHashMap<String, ThreadMsgInfo> concurrentHashMap;
        if (this.mEnable && !TextUtils.isEmpty(str) && (concurrentHashMap = this.mMsgInfoList) != null && concurrentHashMap.containsKey(str)) {
            return this.mMsgInfoList.get(str);
        }
        return null;
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
        if (QLog.isColorLevel()) {
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
            QLog.d("TaskMonitorManager", 2, sb5.toString());
        }
        if (z16) {
            str2 = "show";
        } else {
            str2 = "hide";
        }
        if (taskPerfmSwitchPageInfo == null) {
            String str4 = TASK_PERFM_SWITCH_PAGE;
            startLooperMonitor(str4, null, str4, str, str2);
        } else if (z16) {
            stopLooperMonitor(TASK_PERFM_SWITCH_PAGE, null);
        } else {
            String str5 = TASK_PERFM_SWITCH_PAGE;
            startLooperMonitor(str5, null, str5, str, str2);
        }
    }

    public void updateCpuInfoSync() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager.1
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                TaskMonitorManager taskMonitorManager = TaskMonitorManager.this;
                taskMonitorManager.mAppLastUsage = taskMonitorManager.mAppCurUsage;
                TaskMonitorManager.this.mAppCurUsage = f.a("-1");
                long j16 = TaskMonitorManager.this.mAppCurUsage - TaskMonitorManager.this.mAppLastUsage;
                TaskMonitorManager taskMonitorManager2 = TaskMonitorManager.this;
                if (taskMonitorManager2.isCalcDeviceUsageOk) {
                    taskMonitorManager2.mDeviceLastUsage = taskMonitorManager2.mDeviceCurUsage;
                    TaskMonitorManager.this.mDeviceCurUsage = f.a("-2");
                    j3 = TaskMonitorManager.this.mDeviceCurUsage - TaskMonitorManager.this.mDeviceLastUsage;
                } else {
                    j3 = 0;
                }
                TaskMonitorManager taskMonitorManager3 = TaskMonitorManager.this;
                taskMonitorManager3.isCalcDeviceUsageOk = taskMonitorManager3.mDeviceCurUsage > 0 && j3 > 0;
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
            if (QLog.isColorLevel()) {
                QLog.d("TaskMonitorManager", 2, "startLooperMonitor, key is " + str);
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
            if (QLog.isColorLevel()) {
                QLog.d("TaskMonitorManager", 2, "stopLooperMonitor, key is " + genKey);
            }
            if (TextUtils.isEmpty(genKey) || (concurrentHashMap = this.mMsgInfoList) == null || !concurrentHashMap.containsKey(genKey)) {
                return;
            }
            this.mMsgInfoList.put(str, fillEndThreadInfo(this.mMsgInfoList.get(genKey)));
        }
    }

    protected ThreadMsgInfo fillEndThreadInfo(ThreadMsgInfo threadMsgInfo) {
        if (threadMsgInfo != null) {
            threadMsgInfo.realTimeEnd = System.currentTimeMillis();
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            threadMsgInfo.threadTimeEnd = currentThreadTimeMillis;
            long j3 = threadMsgInfo.realTimeEnd - threadMsgInfo.realTimeStart;
            if (j3 <= 0) {
                j3 = 0;
            }
            threadMsgInfo.realTimeCost = j3;
            long j16 = currentThreadTimeMillis - threadMsgInfo.threadTimeStart;
            threadMsgInfo.threadTimeCost = j16 > 0 ? j16 : 0L;
        }
        return threadMsgInfo;
    }
}
