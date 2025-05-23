package com.tencent.biz.qqcircle.rerank.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetCloudSealFeedReq;
import feedcloud.FeedCloudRead$StGetCloudSealFeedRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSRankEdgeGetFeedsReq extends QCircleBaseRequest {
    public FeedCloudRead$StGetCloudSealFeedReq mRequest = new FeedCloudRead$StGetCloudSealFeedReq();

    public QFSRankEdgeGetFeedsReq(String str, int i3, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.mRequest.attachInfo.set(str2);
        }
        this.mRequest.listNum.set(i3);
        a(str);
        b("0");
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("AlgId");
        feedCloudCommon$Entry.value.set(str);
        feedCloudCommon$StCommonExt.mapInfo.add(feedCloudCommon$Entry);
        this.mRequest.extInfo.set(feedCloudCommon$StCommonExt);
    }

    private void b(String str) {
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("edge_rerank_req_type");
        feedCloudCommon$Entry.value.set(str);
        feedCloudCommon$StCommonExt.mapInfo.add(feedCloudCommon$Entry);
        this.mRequest.extInfo.set(feedCloudCommon$StCommonExt);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCloudSealFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudRead$StGetCloudSealFeedRsp decode(byte[] bArr) {
        FeedCloudRead$StGetCloudSealFeedRsp feedCloudRead$StGetCloudSealFeedRsp = new FeedCloudRead$StGetCloudSealFeedRsp();
        try {
            feedCloudRead$StGetCloudSealFeedRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetCloudSealFeedRsp;
    }

    public QFSRankEdgeGetFeedsReq(boolean z16) {
        b("1");
    }
}
