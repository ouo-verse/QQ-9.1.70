package cooperation.qqcircle.report.perf;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.perf.api.ICpuUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.richframework.sender.util.EventControlUtils;
import java.util.Arrays;
import uq3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSCpuTracker extends AbsPerfTracker {
    private static final int CPU_REPORT_PERIOD = c.d1();
    public static final String TAG = "QFSCpuTracker";
    private static volatile QFSCpuTracker sInstance;
    private final float[] mCpuUsages = new float[CPU_REPORT_PERIOD];
    private float mMaxUsage;
    private int mRecordCounts;
    private String mScene;

    QFSCpuTracker() {
        boolean z16;
        if (Math.random() <= c.c1()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mEnableTrackerRatio = z16;
        RFWLog.d(TAG, RFWLog.USR, "QFSCpuTracker mEnableTrackerRatio:" + this.mEnableTrackerRatio);
    }

    private void clearData() {
        Arrays.fill(this.mCpuUsages, 0.0f);
        this.mRecordCounts = 0;
        this.mMaxUsage = 0.0f;
    }

    private void fileOnceData(Message message) {
        if (this.mRecordCounts >= this.mCpuUsages.length) {
            reportData(message);
            clearData();
            return;
        }
        float cpuUsage = ((ICpuUtilApi) QRoute.api(ICpuUtilApi.class)).getCpuUsage(Process.myPid());
        this.mMaxUsage = Math.max(cpuUsage, this.mMaxUsage);
        float[] fArr = this.mCpuUsages;
        int i3 = this.mRecordCounts;
        fArr[i3] = cpuUsage;
        this.mRecordCounts = i3 + 1;
    }

    public static QFSCpuTracker g() {
        if (sInstance == null) {
            synchronized (QFSCpuTracker.class) {
                if (sInstance == null) {
                    sInstance = new QFSCpuTracker();
                }
            }
        }
        return sInstance;
    }

    private void initScene(Message message) {
        Object obj = message.obj;
        if (obj instanceof String) {
            this.mScene = (String) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterTracker(Message message) {
        PerfTrackerTimerManager.g().registerTimerListener(this);
        generateSeq();
        initScene(message);
        clearData();
        fileOnceData(message);
        reportData(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExitTracker(Message message) {
        PerfTrackerTimerManager.g().unRegisterTimerListener(this);
        fileOnceData(message);
        reportData(message);
        clearData();
        removeMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegularTracker(Message message) {
        fileOnceData(message);
    }

    private void reportData(Message message) {
        int min = Math.min(this.mCpuUsages.length, this.mRecordCounts);
        if (min <= 0) {
            RFWLog.d(TAG, RFWLog.USR, "report error no data");
            return;
        }
        float f16 = 0.0f;
        for (int i3 = 0; i3 < min; i3++) {
            f16 += this.mCpuUsages[i3];
        }
        float f17 = f16 / min;
        RFWLog.d(TAG, RFWLog.DEV, "reportData avgCpu:" + f17 + "|maxCpu:" + this.mMaxUsage);
        new QFSCpuReportBean(f17, this.mMaxUsage).setType(message.what).setScene(this.mScene).setReportSeq(this.mReportSeq).report();
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected boolean enableReport() {
        boolean z16;
        if (Math.random() <= c.e1()) {
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
        if ((!this.mEnableTrackerRatio || !c.f5()) && !com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_PERF_TRACKER, 0)) {
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
        Message obtain = Message.obtain();
        obtain.what = 3;
        sendMessage(obtain);
        RFWLog.d(TAG, RFWLog.USR, "exit enable tracker");
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected Handler.Callback getHandlerCallBack() {
        return new Handler.Callback() { // from class: cooperation.qqcircle.report.perf.QFSCpuTracker.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                int i3 = message.what;
                if (i3 == 1) {
                    QFSCpuTracker.this.onEnterTracker(message);
                } else if (i3 == 2) {
                    QFSCpuTracker.this.onRegularTracker(message);
                } else if (i3 == 3) {
                    QFSCpuTracker.this.onExitTracker(message);
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
        if (!EventControlUtils.throttlingAtOnce(getLogTag() + "timeUpdateCallBack", c.f1())) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        sendMessage(obtain);
    }
}
