package cooperation.qqcircle.report.perf;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.richframework.sender.util.EventControlUtils;
import java.util.Arrays;
import java.util.HashSet;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSAMSMemoryInfoTracker extends AbsPerfTracker {
    private static final int CPU_REPORT_PERIOD = c.d1();
    public static final String TAG = "QFSAMSMemoryInfoTracker";
    private static volatile QFSAMSMemoryInfoTracker sInstance;
    private ActivityManager.MemoryInfo mExitMemoryInfo;
    private ActivityManager.MemoryInfo mInitMemoryInfo;
    private float mMaxUsage;
    private int mRecordCounts;
    private String mScene;
    private final long mStaticDelayTimeMs;
    private final float[] mMemoryUsages = new float[CPU_REPORT_PERIOD];
    private final HashSet<String> mRecorder = new HashSet<>();

    QFSAMSMemoryInfoTracker() {
        boolean z16;
        if (Math.random() <= c.t2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mEnableTrackerRatio = z16;
        long E0 = c.E0();
        this.mStaticDelayTimeMs = E0;
        RFWLog.d(TAG, RFWLog.USR, "QFSMemoryTracker mEnableTrackerRatio:" + this.mEnableTrackerRatio + " |mStaticDelayTimeMs:" + E0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterEnter(Message message) {
        new QFSAMSMemoryInfoReportBean(getMemoryInc(message)).setReportScene(this.mScene).setIsFirst(isFirstReport(this.mScene, QFSAMSMemoryInfoReportBean.EVENT_ID_AFTER_ENTER)).setInitMemory(this.mInitMemoryInfo).setType(message.what).setReportSeq(this.mReportSeq).report(QFSAMSMemoryInfoReportBean.EVENT_ID_AFTER_ENTER);
        recorderReport(this.mScene, QFSAMSMemoryInfoReportBean.EVENT_ID_AFTER_ENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterExit(Message message) {
        float memoryInc = getMemoryInc(message);
        new QFSAMSMemoryInfoReportBean(memoryInc).setReportScene(this.mScene).setIsFirst(isFirstReport(this.mScene, QFSAMSMemoryInfoReportBean.EVENT_ID_AFTER_EXIT)).setInitMemory(this.mInitMemoryInfo).setType(message.what).setRecycledMemory(getRecycleMemory()).setReportSeq(this.mReportSeq).report(QFSAMSMemoryInfoReportBean.EVENT_ID_AFTER_EXIT);
        recorderReport(this.mScene, QFSAMSMemoryInfoReportBean.EVENT_ID_AFTER_EXIT);
    }

    private void clearData() {
        Arrays.fill(this.mMemoryUsages, 0.0f);
        this.mRecordCounts = 0;
        this.mMaxUsage = 0.0f;
    }

    private void fileOnceData(Message message) {
        if (this.mRecordCounts >= this.mMemoryUsages.length) {
            reportRegularData(message);
            clearData();
            return;
        }
        float memoryInc = getMemoryInc(message);
        this.mMaxUsage = Math.max(memoryInc, this.mMaxUsage);
        float[] fArr = this.mMemoryUsages;
        int i3 = this.mRecordCounts;
        fArr[i3] = memoryInc;
        this.mRecordCounts = i3 + 1;
    }

    public static QFSAMSMemoryInfoTracker g() {
        if (sInstance == null) {
            synchronized (QFSMemoryTracker.class) {
                if (sInstance == null) {
                    sInstance = new QFSAMSMemoryInfoTracker();
                }
            }
        }
        return sInstance;
    }

    private float getMemoryInc(Message message) {
        ActivityManager.MemoryInfo memoryInfo;
        ActivityManager.MemoryInfo memoryInfo2 = getMemoryInfo();
        if (memoryInfo2 != null && (memoryInfo = this.mInitMemoryInfo) != null) {
            return ((float) (memoryInfo.availMem - memoryInfo2.availMem)) / 1048576.0f;
        }
        RFWLog.d(TAG, RFWLog.USR, "getMemoryInc error empty memory info");
        return 0.0f;
    }

    private ActivityManager.MemoryInfo getMemoryInfo() {
        Application application;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            application = RFWApplication.getApplication();
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, e16);
        }
        if (application == null) {
            RFWLog.d(TAG, RFWLog.USR, "getMemoryInfo error empty application");
            return null;
        }
        ((ActivityManager) application.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    private float getRecycleMemory() {
        ActivityManager.MemoryInfo memoryInfo;
        ActivityManager.MemoryInfo memoryInfo2 = getMemoryInfo();
        if (memoryInfo2 != null && (memoryInfo = this.mExitMemoryInfo) != null) {
            return ((float) (memoryInfo2.availMem - memoryInfo.availMem)) / 1048576.0f;
        }
        RFWLog.d(TAG, RFWLog.USR, "getRecycleMemory error empty memory info");
        return 0.0f;
    }

    private void initEnterData(Message message) {
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo();
        if (memoryInfo == null) {
            return;
        }
        this.mInitMemoryInfo = memoryInfo;
        Object obj = message.obj;
        if (obj instanceof String) {
            this.mScene = (String) obj;
            RFWLog.d(TAG, RFWLog.USR, "getMemoryUsage enter scene:" + this.mScene);
        }
    }

    private boolean isFirstReport(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashSet<String> hashSet = this.mRecorder;
            return !hashSet.contains(str + str2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterTracker(Message message) {
        PerfTrackerTimerManager.g().registerTimerListener(this);
        generateSeq();
        clearData();
        initEnterData(message);
        sendDelayJob(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExitTracker(Message message) {
        PerfTrackerTimerManager.g().unRegisterTimerListener(this);
        fileOnceData(message);
        reportRegularData(message);
        clearData();
        removeMessage(2);
        sendDelayJob(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegularTracker(Message message) {
        fileOnceData(message);
    }

    private void recorderExitInfo() {
        this.mExitMemoryInfo = getMemoryInfo();
    }

    private void recorderReport(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mRecorder.add(str + str2);
        }
    }

    private void reportRegularData(Message message) {
        int min = Math.min(this.mMemoryUsages.length, this.mRecordCounts);
        if (min <= 0) {
            RFWLog.d(TAG, RFWLog.USR, "report error no data");
            return;
        }
        float f16 = 0.0f;
        for (int i3 = 0; i3 < min; i3++) {
            f16 += this.mMemoryUsages[i3];
        }
        float f17 = f16 / min;
        RFWLog.d(TAG, RFWLog.DEV, "reportData memory:" + f17 + "|maxMemory:" + this.mMaxUsage);
        new QFSAMSMemoryInfoReportBean(f17, this.mMaxUsage).setReportScene(this.mScene).setIsFirst(isFirstReport(this.mScene, QFSAMSMemoryInfoReportBean.EVENT_ID_REGULAR)).setInitMemory(this.mInitMemoryInfo).setType(message.what).setReportSeq(this.mReportSeq).report(QFSAMSMemoryInfoReportBean.EVENT_ID_REGULAR);
        recorderReport(this.mScene, QFSAMSMemoryInfoReportBean.EVENT_ID_REGULAR);
    }

    private void sendDelayJob(int i3) {
        recorderExitInfo();
        Message obtain = Message.obtain();
        obtain.what = i3;
        sendMessageDelay(obtain, this.mStaticDelayTimeMs);
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected boolean enableReport() {
        boolean z16;
        if (Math.random() <= c.u2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (enableTracker() && z16) {
            return true;
        }
        return false;
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected boolean enableTracker() {
        if ((!this.mEnableTrackerRatio || !c.Z4()) && !com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_PERF_TRACKER, 0)) {
            return false;
        }
        return true;
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    public void enter(String str) {
        if (!enableTracker()) {
            RFWLog.d(TAG, RFWLog.USR, "enter not enable tracker");
            return;
        }
        removeMessage(4);
        removeMessage(5);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = str;
        sendMessage(obtain);
        RFWLog.d(TAG, RFWLog.USR, "enter enable tracker");
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    public void exit() {
        if (!enableTracker()) {
            RFWLog.d(TAG, RFWLog.USR, "exit not enable tracker");
            return;
        }
        removeMessage(4);
        removeMessage(5);
        Message obtain = Message.obtain();
        obtain.what = 3;
        sendMessage(obtain);
        RFWLog.d(TAG, RFWLog.USR, "exit enable tracker");
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected Handler.Callback getHandlerCallBack() {
        return new Handler.Callback() { // from class: cooperation.qqcircle.report.perf.QFSAMSMemoryInfoTracker.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                int i3 = message.what;
                if (i3 == 1) {
                    QFSAMSMemoryInfoTracker.this.onEnterTracker(message);
                } else if (i3 == 2) {
                    QFSAMSMemoryInfoTracker.this.onRegularTracker(message);
                } else if (i3 == 3) {
                    QFSAMSMemoryInfoTracker.this.onExitTracker(message);
                } else if (i3 == 4) {
                    QFSAMSMemoryInfoTracker.this.afterEnter(message);
                } else if (i3 == 5) {
                    QFSAMSMemoryInfoTracker.this.afterExit(message);
                }
                return true;
            }
        };
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected String getLogTag() {
        return TAG;
    }

    @Override // cooperation.qqcircle.report.perf.ITimerListener
    public void onTimerCallback() {
        GuardManager guardManager;
        if (!enableTracker() || (guardManager = GuardManager.sInstance) == null || !guardManager.isApplicationForeground()) {
            return;
        }
        if (!EventControlUtils.throttlingAtOnce(getLogTag() + "timeUpdateCallBack", c.F0())) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        sendMessage(obtain);
    }
}
