package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCirclePendant$GetMyPendantBannerReq;
import qqcircle.QQCirclePendant$GetMyPendantBannerRsp;

/* loaded from: classes5.dex */
public class QCircleGetMyPendantBannerRequest extends QCircleBaseRequest {
    private QQCirclePendant$GetMyPendantBannerReq mReq;

    public QCircleGetMyPendantBannerRequest(String str) {
        QQCirclePendant$GetMyPendantBannerReq qQCirclePendant$GetMyPendantBannerReq = new QQCirclePendant$GetMyPendantBannerReq();
        this.mReq = qQCirclePendant$GetMyPendantBannerReq;
        qQCirclePendant$GetMyPendantBannerReq.pendantKey.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circle_pendant.CirclePendant.GetMyPendantBanner";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCirclePendant$GetMyPendantBannerRsp qQCirclePendant$GetMyPendantBannerRsp = new QQCirclePendant$GetMyPendantBannerRsp();
        try {
            qQCirclePendant$GetMyPendantBannerRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCirclePendant$GetMyPendantBannerRsp;
    }
}
