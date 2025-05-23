package cooperation.qqcircle.report.outbox;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smartparcelable.NeedParcel;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportOutboxTask implements IQueueTask {
    public static final int STATE_PAUSE = 2;
    public static final int STATE_REMOVED = 4;
    public static final int STATE_RESENDING = 1;
    public static final int STATE_SENDING_FINISH = 3;
    private static final String TAG = "QCircleReportOutboxTask";

    /* renamed from: id, reason: collision with root package name */
    @NeedParcel
    private long f390525id;

    @NeedParcel
    public String mCmdName;
    public VSBaseRequest mRequest;

    @NeedParcel
    public byte[] mRequestByteData;

    @NeedParcel
    public String mRequestKey;

    @NeedParcel
    public long mResultCode;

    @NeedParcel
    public String mResultMsg;

    @NeedParcel
    public int mRetryNum;

    @NeedParcel
    public int mState;

    @NeedParcel
    public long mTime;

    public QCircleReportOutboxTask() {
        this.mTime = 0L;
        this.mRetryNum = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportOutboxResendResult(boolean z16, long j3, String str) {
        String str2;
        FeedCloudCommon$Entry[] feedCloudCommon$EntryArr = new FeedCloudCommon$Entry[5];
        if (z16) {
            str2 = "0";
        } else {
            str2 = j3 + "";
        }
        feedCloudCommon$EntryArr[0] = QCircleReportHelper.newEntry("ret_code", str2);
        feedCloudCommon$EntryArr[1] = QCircleReportHelper.newEntry("url", str);
        feedCloudCommon$EntryArr[2] = QCircleReportHelper.newEntry("refer", this.mCmdName + "");
        feedCloudCommon$EntryArr[3] = QCircleReportHelper.newEntry("count", this.mRetryNum + "");
        feedCloudCommon$EntryArr[4] = QCircleReportHelper.newEntry("attach_info", this.f390525id + "_" + this.mResultCode + "_" + this.mResultMsg + "_state=" + getState());
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_OUTBOX_TASK_RESEND_EVENT, (List<FeedCloudCommon$Entry>) Arrays.asList(feedCloudCommon$EntryArr));
    }

    public void doResend() {
        if (this.mRequest == null) {
            this.mRequest = new QCircleReportOutboxRequest(this.mCmdName, this.mRequestByteData);
        }
        VSNetworkHelper.getInstance().sendRequest(this.mRequest, new VSDispatchObserver.OnVSRspCallBack<Object>() { // from class: cooperation.qqcircle.report.outbox.QCircleReportOutboxTask.1
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QCircleReportOutboxTask.this.reportOutboxResendResult(z16, j3, str);
                QCircleReportOutboxTask.this.setResultCode(j3);
                QCircleReportOutboxTask.this.setResultMsg(str);
                QCircleReportOutboxTaskQueue.getInstance().completeTask(QCircleReportOutboxTask.this, z16);
                QLog.i(QCircleReportOutboxTask.TAG, 1, "doResend id:" + QCircleReportOutboxTask.this.getTaskId() + " ,resultCode:" + j3 + " ,trace_id:" + baseRequest.getTraceId());
            }
        });
        QLog.i(TAG, 1, "doResend id:" + getTaskId());
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public String getCacheKey() {
        return this.f390525id + "";
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public long getResultCode() {
        return this.mResultCode;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public String getResultMsg() {
        return this.mResultMsg;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public int getRetryNum() {
        return this.mRetryNum;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public int getState() {
        return this.mState;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public long getTaskId() {
        return this.f390525id;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public long getTime() {
        return this.mTime;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public boolean isNullTask() {
        if (this.mRequest == null && this.mRequestByteData == null) {
            return true;
        }
        return false;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public void onRemove() {
        this.mRequest = null;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public void onRestore() {
        if (this.mRequest == null && !isNullTask()) {
            this.mRequest = new QCircleReportOutboxRequest(this.mCmdName, this.mRequestByteData);
        }
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public void onResume() {
        this.mRetryNum++;
    }

    public void printTaskInfo(String str, String str2) {
        printTaskInfo(str, str2, false);
    }

    public void resend() {
        if (4 == this.mState) {
            QLog.i(TAG, 1, "QCircleQueueTask.run is already removed");
        } else {
            doResend();
            this.mTime = System.currentTimeMillis();
        }
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public void setResultCode(long j3) {
        this.mResultCode = j3;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public void setResultMsg(String str) {
        this.mResultMsg = str;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public void setState(int i3) {
        this.mState = i3;
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public void setTime(long j3) {
        this.mTime = j3;
    }

    public void printTaskInfo(String str, String str2, boolean z16) {
        if (z16) {
            QLog.e(str + "_QCircleSenderTask", 1, str2 + " id:" + getTaskId() + " ,state:" + this.mState + " ,cmd:" + this.mCmdName);
            return;
        }
        QLog.d(str + "_QCircleSenderTask", 2, str2 + " id:" + getTaskId() + " ,state:" + this.mState + " ,cmd:" + this.mCmdName);
    }

    public QCircleReportOutboxTask(VSBaseRequest vSBaseRequest) {
        this.mTime = 0L;
        this.mRetryNum = 0;
        this.f390525id = System.nanoTime();
        this.mRequest = vSBaseRequest;
        this.mRequestByteData = vSBaseRequest.getRequestByteKey();
        this.mCmdName = vSBaseRequest.getCmdName();
        this.mRequestKey = this.mCmdName + QCircleHostStubUtil.getCurrentAccount() + QUA.getQUA3() + new String(this.mRequestByteData);
    }

    @Override // cooperation.qqcircle.report.outbox.IQueueTask
    public void clear() {
    }
}
