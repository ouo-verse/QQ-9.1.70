package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StVideo;
import qqcircle.QQCircleVideourlexchange$StGetVideoAdaptReq;
import qqcircle.QQCircleVideourlexchange$StGetVideoAdaptRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleVideoUrlAdapterRequest extends QCircleBaseRequest {
    private final QQCircleVideourlexchange$StGetVideoAdaptReq mReq;

    public QCircleVideoUrlAdapterRequest(FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
        QQCircleVideourlexchange$StGetVideoAdaptReq qQCircleVideourlexchange$StGetVideoAdaptReq = new QQCircleVideourlexchange$StGetVideoAdaptReq();
        this.mReq = qQCircleVideourlexchange$StGetVideoAdaptReq;
        qQCircleVideourlexchange$StGetVideoAdaptReq.videos.add(feedCloudMeta$StVideo);
        qQCircleVideourlexchange$StGetVideoAdaptReq.userID.set(HostDataTransUtils.getAccount());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.videocircle.videourlexchange.VideoURLExchange.GetVideoAdaptInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleVideourlexchange$StGetVideoAdaptRsp qQCircleVideourlexchange$StGetVideoAdaptRsp = new QQCircleVideourlexchange$StGetVideoAdaptRsp();
        try {
            qQCircleVideourlexchange$StGetVideoAdaptRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleVideourlexchange$StGetVideoAdaptRsp;
    }
}
