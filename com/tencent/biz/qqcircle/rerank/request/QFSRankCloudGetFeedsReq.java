package com.tencent.biz.qqcircle.rerank.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;
import seal.SealCloudRerankInfo$CloudReRankInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSRankCloudGetFeedsReq extends QCircleBaseRequest {
    public FeedCloudRead$StGetFeedListReq mRequest;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private SealCloudRerankInfo$CloudReRankInfo f91873a;

        /* renamed from: b, reason: collision with root package name */
        private String f91874b;

        private FeedCloudCommon$Entry b() {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("AlgId");
            feedCloudCommon$Entry.value.set("");
            QLog.d("QFSRankGetFeedListRequest", 1, "getAlgIdEntry:");
            return feedCloudCommon$Entry;
        }

        public FeedCloudRead$StGetFeedListReq a() {
            FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
            feedCloudRead$StGetFeedListReq.from.set(0);
            feedCloudRead$StGetFeedListReq.source.set(10);
            e(feedCloudRead$StGetFeedListReq);
            return feedCloudRead$StGetFeedListReq;
        }

        public a c(SealCloudRerankInfo$CloudReRankInfo sealCloudRerankInfo$CloudReRankInfo) {
            this.f91873a = sealCloudRerankInfo$CloudReRankInfo;
            return this;
        }

        public a d(String str) {
            this.f91874b = str;
            return this;
        }

        protected void e(FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq) {
            feedCloudRead$StGetFeedListReq.extInfo.setHasFlag(true);
            List<FeedCloudCommon$BytesEntry> list = feedCloudRead$StGetFeedListReq.extInfo.mapBytesInfo.get();
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set("RecomTransInfo");
            feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(this.f91873a.toByteArray()));
            list.add(feedCloudCommon$BytesEntry);
            feedCloudRead$StGetFeedListReq.extInfo.mapBytesInfo.set(list);
            feedCloudRead$StGetFeedListReq.extInfo.mapInfo.add(b());
            if (!TextUtils.isEmpty(this.f91874b)) {
                FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
                feedCloudCommon$Entry.key.set("RerankVersion");
                feedCloudCommon$Entry.value.set(this.f91874b);
                feedCloudRead$StGetFeedListReq.extInfo.mapInfo.add(feedCloudCommon$Entry);
            }
        }
    }

    public QFSRankCloudGetFeedsReq(a aVar) {
        this.mRequest = aVar.a();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRerankedFeedList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }
}
