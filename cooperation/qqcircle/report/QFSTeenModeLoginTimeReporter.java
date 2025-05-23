package cooperation.qqcircle.report;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.requests.QFSTeenModeDurationReportRequest;
import cooperation.qqcircle.report.requests.QFSTeenModeResetDurationRequest;
import java.util.concurrent.atomic.AtomicBoolean;
import qqcircle.QQCircleDurationReport$DurationDialog;
import qqcircle.QQCircleDurationReport$ReportDurationRsp;
import qqcircle.QQCircleDurationReport$ResetDurationRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSTeenModeLoginTimeReporter {
    private static final int DEFAULT_HEARTBEAT = 60000;
    private static final int SECOND_TO_MILLIS = 1000;
    private static final String TAG = "QFSTeenModeLoginTimeReporter";
    private static volatile QFSTeenModeLoginTimeReporter sInstance;
    private String mDialogId;
    private Runnable mReportRunnable;
    private QFSTeenModeTimeoutListener mTimeoutListener;
    private long mHeartbeatGap = 60000;
    private final AtomicBoolean mReportScheduled = new AtomicBoolean(false);
    private final Handler mTeenModeReportHandler = RFWThreadManager.getInstance().getSerialThreadHandler();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class QFSTeenModeDialogBean {
        public String mContent;
        public String mJumpText;
        public String mJumpUrl;
        public String mTitle;
        public String mToastText;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface QFSTeenModeTimeoutListener {
        void showAntiAddictionWindow(QFSTeenModeDialogBean qFSTeenModeDialogBean);
    }

    QFSTeenModeLoginTimeReporter() {
    }

    public static QFSTeenModeLoginTimeReporter getInstance() {
        if (sInstance == null) {
            synchronized (QFSTeenModeLoginTimeReporter.class) {
                if (sInstance == null) {
                    sInstance = new QFSTeenModeLoginTimeReporter();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoginTimeReportRsp(final QQCircleDurationReport$ReportDurationRsp qQCircleDurationReport$ReportDurationRsp) {
        if (qQCircleDurationReport$ReportDurationRsp == null) {
            return;
        }
        this.mTeenModeReportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter.5
            @Override // java.lang.Runnable
            public void run() {
                QFSTeenModeLoginTimeReporter qFSTeenModeLoginTimeReporter = QFSTeenModeLoginTimeReporter.this;
                long j3 = 60000;
                if (qQCircleDurationReport$ReportDurationRsp.heart_beat_interval.get() * 1000 >= 60000) {
                    j3 = qQCircleDurationReport$ReportDurationRsp.heart_beat_interval.get() * 1000;
                }
                qFSTeenModeLoginTimeReporter.mHeartbeatGap = j3;
                if (qQCircleDurationReport$ReportDurationRsp.dialog.get() != null && !TextUtils.isEmpty(qQCircleDurationReport$ReportDurationRsp.dialog.f429301id.get())) {
                    QFSTeenModeLoginTimeReporter.this.mDialogId = qQCircleDurationReport$ReportDurationRsp.dialog.f429301id.get();
                    QFSTeenModeLoginTimeReporter.this.stopReport();
                    if (QFSTeenModeLoginTimeReporter.this.mTimeoutListener != null) {
                        QFSTeenModeLoginTimeReporter.this.mTimeoutListener.showAntiAddictionWindow(QFSTeenModeLoginTimeReporter.this.transformToDialogBean(qQCircleDurationReport$ReportDurationRsp.dialog.get()));
                    }
                }
            }
        });
    }

    private void heartbeatStart() {
        this.mTeenModeReportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter.2
            @Override // java.lang.Runnable
            public void run() {
                QFSTeenModeLoginTimeReporter.this.sendLoginHeartbeatRequest(0L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report() {
        if (this.mReportRunnable == null) {
            this.mReportRunnable = new Runnable() { // from class: cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter.3
                @Override // java.lang.Runnable
                public void run() {
                    QFSTeenModeLoginTimeReporter qFSTeenModeLoginTimeReporter = QFSTeenModeLoginTimeReporter.this;
                    qFSTeenModeLoginTimeReporter.sendLoginHeartbeatRequest(qFSTeenModeLoginTimeReporter.mHeartbeatGap);
                    QFSTeenModeLoginTimeReporter.this.report();
                }
            };
        }
        this.mTeenModeReportHandler.postDelayed(this.mReportRunnable, this.mHeartbeatGap);
    }

    private void reset() {
        this.mTeenModeReportHandler.post(new Runnable() { // from class: cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter.1
            @Override // java.lang.Runnable
            public void run() {
                QFSTeenModeLoginTimeReporter.this.mHeartbeatGap = 60000L;
                QLog.d(QFSTeenModeLoginTimeReporter.TAG, 1, "Reset Reporter");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLoginHeartbeatRequest(long j3) {
        int i3;
        if (j3 == 0) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        VSNetworkHelper.getInstance().sendRequest(new QFSTeenModeDurationReportRequest(i3, j3 / 1000), new VSDispatchObserver.OnVSRspCallBack<QQCircleDurationReport$ReportDurationRsp>() { // from class: cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter.4
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j16, String str, QQCircleDurationReport$ReportDurationRsp qQCircleDurationReport$ReportDurationRsp) {
                if (z16 && j16 == 0 && qQCircleDurationReport$ReportDurationRsp != null) {
                    QFSTeenModeLoginTimeReporter.this.handleLoginTimeReportRsp(qQCircleDurationReport$ReportDurationRsp);
                    return;
                }
                QLog.e(QFSTeenModeLoginTimeReporter.TAG, 1, "reportLoginTimeToServer error:" + str + ",traceId:" + baseRequest.getTraceId());
            }
        });
    }

    public void releaseReportListener() {
        this.mTimeoutListener = null;
    }

    public void resetLoginTimeDuration() {
        if (TextUtils.isEmpty(this.mDialogId)) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QFSTeenModeResetDurationRequest(this.mDialogId), new VSDispatchObserver.OnVSRspCallBack<QQCircleDurationReport$ResetDurationRsp>() { // from class: cooperation.qqcircle.report.QFSTeenModeLoginTimeReporter.6
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleDurationReport$ResetDurationRsp qQCircleDurationReport$ResetDurationRsp) {
                if (z16 && j3 == 0 && qQCircleDurationReport$ResetDurationRsp != null) {
                    QFSTeenModeLoginTimeReporter.this.startReport();
                    return;
                }
                QLog.e(QFSTeenModeLoginTimeReporter.TAG, 1, "ResetLoginTimeDuration error:" + str + ",traceId:" + baseRequest.getTraceId());
            }
        });
    }

    public void setReportListener(QFSTeenModeTimeoutListener qFSTeenModeTimeoutListener) {
        this.mTimeoutListener = qFSTeenModeTimeoutListener;
    }

    public void startReport() {
        if (this.mReportScheduled.compareAndSet(false, true) && ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            heartbeatStart();
            report();
            QLog.d(TAG, 1, "Start Report");
        }
    }

    public void stopReport() {
        if (this.mReportScheduled.compareAndSet(true, false) && ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            Runnable runnable = this.mReportRunnable;
            if (runnable != null) {
                this.mTeenModeReportHandler.removeCallbacks(runnable);
            }
            reset();
            QLog.d(TAG, 1, "Stop Report");
        }
    }

    public QFSTeenModeDialogBean transformToDialogBean(QQCircleDurationReport$DurationDialog qQCircleDurationReport$DurationDialog) {
        if (qQCircleDurationReport$DurationDialog == null) {
            return new QFSTeenModeDialogBean();
        }
        QFSTeenModeDialogBean qFSTeenModeDialogBean = new QFSTeenModeDialogBean();
        qFSTeenModeDialogBean.mTitle = qQCircleDurationReport$DurationDialog.title.get();
        qFSTeenModeDialogBean.mContent = qQCircleDurationReport$DurationDialog.content.get();
        qFSTeenModeDialogBean.mJumpText = qQCircleDurationReport$DurationDialog.jump_text.get();
        qFSTeenModeDialogBean.mJumpUrl = qQCircleDurationReport$DurationDialog.jump_url.get();
        qFSTeenModeDialogBean.mToastText = qQCircleDurationReport$DurationDialog.toast_text.get();
        return qFSTeenModeDialogBean;
    }
}
