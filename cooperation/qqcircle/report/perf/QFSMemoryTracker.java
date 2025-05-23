package cooperation.qqcircle.report.perf;

import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.perf.api.IMemoryUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.richframework.sender.util.EventControlUtils;
import uq3.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSMemoryTracker extends AbsPerfTracker {
    public static final String TAG = "QFSMemoryTracker";
    private static volatile QFSMemoryTracker sInstance;
    private final long mMemoryThrottledTime;
    private String mScene;

    QFSMemoryTracker() {
        boolean z16;
        if (Math.random() <= c.t2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mEnableTrackerRatio = z16;
        long throttledMemoryTime = ((IMemoryUtilApi) QRoute.api(IMemoryUtilApi.class)).getThrottledMemoryTime();
        this.mMemoryThrottledTime = throttledMemoryTime;
        RFWLog.d(TAG, RFWLog.USR, "QFSMemoryTracker mEnableTrackerRatio:" + this.mEnableTrackerRatio + "mMemoryThrottledTime:" + throttledMemoryTime);
    }

    public static QFSMemoryTracker g() {
        if (sInstance == null) {
            synchronized (QFSMemoryTracker.class) {
                if (sInstance == null) {
                    sInstance = new QFSMemoryTracker();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterTracker(Message message) {
        PerfTrackerTimerManager.g().registerTimerListener(this);
        generateSeq();
        Debug.MemoryInfo throttledMemoryInfo = ((IMemoryUtilApi) QRoute.api(IMemoryUtilApi.class)).getThrottledMemoryInfo(Process.myPid());
        if (throttledMemoryInfo == null) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof String) {
            this.mScene = (String) obj;
        }
        new QFSMemoryReportBean(throttledMemoryInfo).setReportSeq(this.mReportSeq).setType(message.what).setScene(this.mScene).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExitTracker(Message message) {
        PerfTrackerTimerManager.g().unRegisterTimerListener(this);
        removeMessage(2);
        Debug.MemoryInfo throttledMemoryInfo = ((IMemoryUtilApi) QRoute.api(IMemoryUtilApi.class)).getThrottledMemoryInfo(Process.myPid());
        if (throttledMemoryInfo == null) {
            return;
        }
        new QFSMemoryReportBean(throttledMemoryInfo).setType(message.what).setScene(this.mScene).setReportSeq(this.mReportSeq).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegularTracker(Message message) {
        Debug.MemoryInfo throttledMemoryInfo = ((IMemoryUtilApi) QRoute.api(IMemoryUtilApi.class)).getThrottledMemoryInfo(Process.myPid());
        if (throttledMemoryInfo == null) {
            return;
        }
        new QFSMemoryReportBean(throttledMemoryInfo).setReportSeq(this.mReportSeq).setType(message.what).setScene(this.mScene).report();
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
        if ((!this.mEnableTrackerRatio || !c.i5() || Build.VERSION.SDK_INT < 29) && !com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_PERF_TRACKER, 0)) {
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
        return new Handler.Callback() { // from class: cooperation.qqcircle.report.perf.QFSMemoryTracker.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                int i3 = message.what;
                if (i3 == 1) {
                    QFSMemoryTracker.this.onEnterTracker(message);
                } else if (i3 == 2) {
                    QFSMemoryTracker.this.onRegularTracker(message);
                } else if (i3 == 3) {
                    QFSMemoryTracker.this.onExitTracker(message);
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
        if (!EventControlUtils.throttlingAtOnce(getLogTag() + "timeUpdateCallBack", this.mMemoryThrottledTime)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        sendMessage(obtain);
    }
}
