package cooperation.qqcircle.report.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import qqcircle.QQCircleDurationReport$ResetDurationReq;
import qqcircle.QQCircleDurationReport$ResetDurationRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSTeenModeResetDurationRequest extends QCircleBaseRequest {
    private QQCircleDurationReport$ResetDurationReq mReq;

    public QFSTeenModeResetDurationRequest(String str) {
        QQCircleDurationReport$ResetDurationReq qQCircleDurationReport$ResetDurationReq = new QQCircleDurationReport$ResetDurationReq();
        this.mReq = qQCircleDurationReport$ResetDurationReq;
        qQCircleDurationReport$ResetDurationReq.dialog_id.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circle_duration_report.CircleDurationReport.ResetDuration";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleDurationReport$ResetDurationRsp> messageMicro = new MessageMicro<QQCircleDurationReport$ResetDurationRsp>() { // from class: qqcircle.QQCircleDurationReport$ResetDurationRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleDurationReport$ResetDurationRsp.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
