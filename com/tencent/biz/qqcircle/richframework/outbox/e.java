package com.tencent.biz.qqcircle.richframework.outbox;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.smartparcelable.NeedParcel;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends b {
    public QCircleBaseRequest E;

    @NeedParcel
    public String F;

    @NeedParcel
    public String G;

    @NeedParcel
    public long H;

    @NeedParcel
    public String I;
    public BaseSenderChain J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<Object> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            Call.OnRspCallBack listener;
            BaseSenderChain baseSenderChain = e.this.J;
            if (baseSenderChain != null && baseSenderChain.getListener() != null && (listener = e.this.J.getListener()) != null) {
                listener.onReceive(z16, j3, str, baseRequest, obj, e.this.J.getExtraData());
            }
            e.this.i(z16, j3, str);
            e.this.setResultCode(j3);
            e.this.setResultMsg(str);
            QCircleOutboxTaskQueue.k().d(e.this, z16);
        }
    }

    public e(QCircleBaseRequest qCircleBaseRequest, BaseSenderChain baseSenderChain) {
        this.E = qCircleBaseRequest;
        this.f91908i = qCircleBaseRequest.getRequestByteKey();
        this.F = qCircleBaseRequest.get$cmd();
        this.G = this.F + HostDataTransUtils.getAccount() + HostDataTransUtils.getQUA3() + new String(this.f91908i);
        this.J = baseSenderChain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z16, long j3, String str) {
        String str2;
        FeedCloudCommon$Entry[] feedCloudCommon$EntryArr = new FeedCloudCommon$Entry[5];
        if (z16) {
            str2 = "0";
        } else {
            str2 = j3 + "";
        }
        feedCloudCommon$EntryArr[0] = QCircleReportHelper.newEntry("ret_code", str2);
        feedCloudCommon$EntryArr[1] = QCircleReportHelper.newEntry("url", str);
        feedCloudCommon$EntryArr[2] = QCircleReportHelper.newEntry("refer", this.F + "");
        feedCloudCommon$EntryArr[3] = QCircleReportHelper.newEntry("count", this.f91906f + "");
        feedCloudCommon$EntryArr[4] = QCircleReportHelper.newEntry("attach_info", this.f91904d + "_" + Arrays.toString(this.f91909m) + "_" + this.H + "_" + this.I + "_state=" + getState());
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_OUTBOX_TASK_RESEND_EVENT, (List<FeedCloudCommon$Entry>) Arrays.asList(feedCloudCommon$EntryArr));
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    protected String b() {
        return "QCircleSenderTask";
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public String c() {
        return this.F;
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public void e(String str, String str2, boolean z16) {
        if (z16) {
            QLog.e(str + "_QCircleSenderTask", 1, str2 + " id:" + getTaskId() + " ,state:" + this.f91907h + " ,cmd:" + this.F + " ,resultCode:" + this.H + " ,errMsg:" + this.I);
            return;
        }
        QLog.d(str + "_QCircleSenderTask", 4, str2 + " id:" + getTaskId() + " ,state:" + this.f91907h + " ,cmd:" + this.F);
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public void f() {
        if (4 == this.f91907h) {
            QLog.i("QCircleSenderTask", 1, "QCircleSenderTask.run is already removed");
        } else {
            h();
            this.f91905e = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public long getTaskId() {
        return super.getTaskId();
    }

    public void h() {
        if (this.E == null) {
            this.E = new QCircleSenderRequest(this.F, this.f91908i, this.f91909m);
        }
        VSNetworkHelper.getInstance().sendRequest(this.E, new a());
        QLog.i("QCircleSenderTask", 1, "doRun id:" + getTaskId());
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public boolean isNullTask() {
        if (this.E == null && this.f91908i == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public void onRemove() {
        this.E = null;
        this.J = null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public void onRestore() {
        if (this.E == null && !isNullTask()) {
            this.E = new QCircleSenderRequest(this.F, this.f91908i);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public void onResume() {
        this.f91906f++;
    }

    @Override // com.tencent.biz.qqcircle.richframework.outbox.b
    public void clear() {
    }
}
