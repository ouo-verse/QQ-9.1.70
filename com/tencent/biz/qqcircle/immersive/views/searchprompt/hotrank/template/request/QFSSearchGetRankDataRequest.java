package com.tencent.biz.qqcircle.immersive.views.searchprompt.hotrank.template.request;

import circlesearch.CircleSearchExhibition$GetRankingDataReq;
import circlesearch.CircleSearchExhibition$GetRankingDataRsp;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchGetRankDataRequest extends QFSSearchBaseRequest {
    private final CircleSearchExhibition$GetRankingDataReq request;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSSearchGetRankDataRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final CircleSearchExhibition$GetRankingDataReq f91302c = new CircleSearchExhibition$GetRankingDataReq();

        public a e(String str, String str2) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set(str);
            feedCloudCommon$Entry.value.set(str2);
            this.f91302c.ext_info.mapInfo.add(feedCloudCommon$Entry);
            return this;
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public QFSSearchGetRankDataRequest b() {
            QFSSearchGetRankDataRequest qFSSearchGetRankDataRequest = new QFSSearchGetRankDataRequest(this.f91302c);
            this.f91858a = qFSSearchGetRankDataRequest;
            return qFSSearchGetRankDataRequest;
        }

        public a g(String str) {
            this.f91302c.attachInfo.set(str);
            return this;
        }

        public a h(byte[] bArr) {
            this.f91302c.serverParams.set(ByteStringMicro.copyFrom(bArr));
            return this;
        }
    }

    QFSSearchGetRankDataRequest(CircleSearchExhibition$GetRankingDataReq circleSearchExhibition$GetRankingDataReq) {
        this.request = circleSearchExhibition$GetRankingDataReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.circlesearch.exhibition.ExhibitionSvr.GetRankingData";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.request.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CircleSearchExhibition$GetRankingDataRsp circleSearchExhibition$GetRankingDataRsp = new CircleSearchExhibition$GetRankingDataRsp();
        try {
            circleSearchExhibition$GetRankingDataRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.w("QFSSearchGetRankDataRequest", 1, e16.getMessage(), e16);
        }
        return circleSearchExhibition$GetRankingDataRsp;
    }
}
