package com.tencent.biz.qqcircle.comment.recpic;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import feedcloud.InferFeedInfoReq;
import feedcloud.InferFeedInfoRsp;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSInferFeedDescRequest extends QCircleBaseRequest {
    private final String mFeedId;

    public QFSInferFeedDescRequest(String str) {
        this.mFeedId = str;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.clip_infer_svr.ClipInferSvr.InferFeedInfo";
    }

    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public String getFeedId() {
        return this.mFeedId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        InferFeedInfoReq.a aVar = new InferFeedInfoReq.a();
        aVar.f398503a = this.mFeedId;
        return aVar.build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public InferFeedInfoRsp decode(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return InferFeedInfoRsp.ADAPTER.decode(bArr);
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
