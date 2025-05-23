package cooperation.qqcircle.report.requests;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon$Result;
import java.util.ArrayList;
import qqcircle.QQCircleBase$StAppInfo;
import qqcircle.QQCircleBase$StNetworkInfo;
import qqcircle.QQCircleReport$StHeartbeatSignalReq;
import qqcircle.QQCircleReport$StHeartbeatSignalRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleHeartbeatSignalReportRequest extends QCircleBaseRequest {
    private QQCircleReport$StHeartbeatSignalReq mReq;

    public QCircleHeartbeatSignalReportRequest(long j3, int i3, byte[] bArr) {
        QQCircleReport$StHeartbeatSignalReq qQCircleReport$StHeartbeatSignalReq = new QQCircleReport$StHeartbeatSignalReq();
        this.mReq = qQCircleReport$StHeartbeatSignalReq;
        qQCircleReport$StHeartbeatSignalReq.uin.set(QCircleHostStubUtil.getCurrentAccountLongUin());
        this.mReq.interval_time_ms.set(j3);
        this.mReq.sig_optype.set(i3);
        QQCircleBase$StAppInfo qQCircleBase$StAppInfo = new QQCircleBase$StAppInfo();
        qQCircleBase$StAppInfo.app_version.set(((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName());
        qQCircleBase$StAppInfo.qua.set(QUA.getQUA3());
        qQCircleBase$StAppInfo.platform.set("android");
        this.mReq.app_info.set(qQCircleBase$StAppInfo);
        QQCircleBase$StNetworkInfo qQCircleBase$StNetworkInfo = new QQCircleBase$StNetworkInfo();
        qQCircleBase$StNetworkInfo.network_type.set(QCircleReportHelper.getNetworkType());
        this.mReq.network_info.set(qQCircleBase$StNetworkInfo);
        ArrayList arrayList = new ArrayList();
        if (bArr != null) {
            arrayList.add(QCircleReportHelper.newEntry(QCircleReportHelper.MAP_KEY_SESSION, bArr));
        }
        this.mReq.byteExtinfo.set(arrayList);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.HeartbeatSignal";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleReport$StHeartbeatSignalRsp> messageMicro = new MessageMicro<QQCircleReport$StHeartbeatSignalRsp>() { // from class: qqcircle.QQCircleReport$StHeartbeatSignalRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"result"}, new Object[]{null}, QQCircleReport$StHeartbeatSignalRsp.class);
            public FeedCloudCommon$Result result = new FeedCloudCommon$Result();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
