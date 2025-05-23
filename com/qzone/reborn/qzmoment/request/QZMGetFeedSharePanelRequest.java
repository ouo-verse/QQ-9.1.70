package com.qzone.reborn.qzmoment.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentReader$StGetFeedSharePanelReq;
import qzonemoment.QZMomentReader$StGetFeedSharePanelRsp;
import rn.g;

/* loaded from: classes37.dex */
public class QZMGetFeedSharePanelRequest extends QZMBaseRequest {
    private QZMomentReader$StGetFeedSharePanelReq mGetFeedSharePanelReq;

    public QZMGetFeedSharePanelRequest(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        QZMomentReader$StGetFeedSharePanelReq qZMomentReader$StGetFeedSharePanelReq = new QZMomentReader$StGetFeedSharePanelReq();
        this.mGetFeedSharePanelReq = qZMomentReader$StGetFeedSharePanelReq;
        if (qZMomentMeta$StFeed != null) {
            qZMomentReader$StGetFeedSharePanelReq.feed.set(g.c(qZMomentMeta$StFeed));
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qz_moment.commreader.ComReader.GetFeedSharePanel";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mGetFeedSharePanelReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentReader$StGetFeedSharePanelRsp qZMomentReader$StGetFeedSharePanelRsp = new QZMomentReader$StGetFeedSharePanelRsp();
        try {
            qZMomentReader$StGetFeedSharePanelRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qZMomentReader$StGetFeedSharePanelRsp;
    }
}
