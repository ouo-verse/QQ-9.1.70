package com.qzone.reborn.qzmoment.request;

import com.qzone.reborn.qzmoment.bean.QZMFeedDetailInitBean;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentReader$StGetFeedDetailReq;
import qzonemoment.QZMomentReader$StGetFeedDetailRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMGetFeedDetailRequest extends QZMBaseRequest {
    private QZMomentReader$StGetFeedDetailReq mRequest;

    public QZMGetFeedDetailRequest(QZMFeedDetailInitBean qZMFeedDetailInitBean) {
        QZMomentReader$StGetFeedDetailReq qZMomentReader$StGetFeedDetailReq = new QZMomentReader$StGetFeedDetailReq();
        this.mRequest = qZMomentReader$StGetFeedDetailReq;
        qZMomentReader$StGetFeedDetailReq.from.set(0);
        if (qZMFeedDetailInitBean != null) {
            this.mRequest.entryFeed.setHasFlag(true);
            this.mRequest.entryFeed.f430362id.set(qZMFeedDetailInitBean.getId());
            this.mRequest.entryFeed.poster.setHasFlag(true);
            this.mRequest.entryFeed.poster.f430367id.set(qZMFeedDetailInitBean.getPosterId());
            this.mRequest.entryFeed.createTime.set(qZMFeedDetailInitBean.getCreateTime().longValue());
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qz_moment.commreader.ComReader.GetFeedDetail";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentReader$StGetFeedDetailRsp qZMomentReader$StGetFeedDetailRsp = new QZMomentReader$StGetFeedDetailRsp();
        try {
            qZMomentReader$StGetFeedDetailRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZMGetFeedDetailRequest", 1, "decode error: ", e16);
        }
        return qZMomentReader$StGetFeedDetailRsp;
    }
}
