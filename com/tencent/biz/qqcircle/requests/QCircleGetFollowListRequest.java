package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetFollowListReq;
import feedcloud.FeedCloudRead$StGetFollowListRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetFollowListRequest extends QCircleBaseRequest {
    private int mListNum;
    private FeedCloudRead$StGetFollowListReq mRequest;

    public QCircleGetFollowListRequest(String str, long j3) {
        this(str, j3, false);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFollowList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public QCircleGetFollowListRequest(String str, long j3, boolean z16) {
        this.mListNum = 100;
        this.mRequest = new FeedCloudRead$StGetFollowListReq();
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("source");
        feedCloudCommon$Entry.value.set(z16 ? "1" : "2");
        feedCloudCommon$StCommonExt.mapInfo.add(feedCloudCommon$Entry);
        FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry2.key.set("timestamp");
        feedCloudCommon$Entry2.value.set(j3 + "");
        feedCloudCommon$StCommonExt.mapInfo.add(feedCloudCommon$Entry2);
        this.mRequest.extInfo.set(feedCloudCommon$StCommonExt);
        if (str != null) {
            this.mRequest.attachInfo.set(str);
        }
        this.mRequest.count.set(this.mListNum);
        this.mRequest.userId.set(HostDataTransUtils.getAccount());
        this.mRequest.filterRelation.set(z16 ? 0 : 2);
        this.mRequest.followMethod.set(z16 ? 1 : 0);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFollowListRsp feedCloudRead$StGetFollowListRsp = new FeedCloudRead$StGetFollowListRsp();
        try {
            feedCloudRead$StGetFollowListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFollowListRsp;
    }
}
