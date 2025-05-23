package com.tencent.mobileqq.wink.request;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleSmartMatchMusic$GetSmartMaterialMusicReq;
import qqcircle.QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class QQWinkGetSmartMaterialMusicReq extends QCircleBaseRequest {
    public static final String CMD = "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetSmartMaterialMusic";
    private final QQCircleSmartMatchMusic$GetSmartMaterialMusicReq mRequest;

    public QQWinkGetSmartMaterialMusicReq(String str) {
        QQCircleSmartMatchMusic$GetSmartMaterialMusicReq qQCircleSmartMatchMusic$GetSmartMaterialMusicReq = new QQCircleSmartMatchMusic$GetSmartMaterialMusicReq();
        this.mRequest = qQCircleSmartMatchMusic$GetSmartMaterialMusicReq;
        qQCircleSmartMatchMusic$GetSmartMaterialMusicReq.material_id.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return CMD;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp = new QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp();
        try {
            qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(BaseRequest.TAG, 1, "decode :" + e16);
        }
        return qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp;
    }
}
