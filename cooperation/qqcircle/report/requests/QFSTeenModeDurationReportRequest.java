package cooperation.qqcircle.report.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import qqcircle.QQCircleDurationReport$ReportDurationReq;
import qqcircle.QQCircleDurationReport$ReportDurationRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSTeenModeDurationReportRequest extends QCircleBaseRequest {
    private QQCircleDurationReport$ReportDurationReq mReq;

    public QFSTeenModeDurationReportRequest(int i3, long j3) {
        QQCircleDurationReport$ReportDurationReq qQCircleDurationReport$ReportDurationReq = new QQCircleDurationReport$ReportDurationReq();
        this.mReq = qQCircleDurationReport$ReportDurationReq;
        qQCircleDurationReport$ReportDurationReq.type.set(i3);
        this.mReq.duration.set(j3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circle_duration_report.CircleDurationReport.ReportDuration";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleDurationReport$ReportDurationRsp qQCircleDurationReport$ReportDurationRsp = new QQCircleDurationReport$ReportDurationRsp();
        try {
            qQCircleDurationReport$ReportDurationRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleDurationReport$ReportDurationRsp;
    }
}
