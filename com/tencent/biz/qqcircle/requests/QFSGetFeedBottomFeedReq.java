package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSGetFeedBottomFeedReq extends QFSGetFeedListRequest {
    public FeedCloudRead$StGetFeedListReq mRequest;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a extends QFSGetFeedListRequest.b {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest.b
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public QFSGetFeedBottomFeedReq b() {
            this.f89002c.busiReqData.set(ByteStringMicro.copyFrom(this.f89003d.toByteArray()));
            this.f89002c.listNum.set(6);
            return new QFSGetFeedBottomFeedReq(this.f89002c);
        }
    }

    public QFSGetFeedBottomFeedReq(FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq) {
        super(feedCloudRead$StGetFeedListReq);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest, com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetAutoPopUpFeedList";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.request.QFSGetFeedListRequest, com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudRead$StGetFeedListRsp decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }
}
