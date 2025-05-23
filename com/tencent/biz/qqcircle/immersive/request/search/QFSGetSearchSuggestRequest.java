package com.tencent.biz.qqcircle.immersive.request.search;

import circlesearch.CircleSearchExhibition$StSuggestionReq;
import circlesearch.CircleSearchExhibition$StSuggestionRsp;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetSearchSuggestRequest extends QFSSearchBaseRequest {
    private final CircleSearchExhibition$StSuggestionReq mRequest;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSGetSearchSuggestRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final CircleSearchExhibition$StSuggestionReq f89843c = new CircleSearchExhibition$StSuggestionReq();

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetSearchSuggestRequest b() {
            QFSGetSearchSuggestRequest qFSGetSearchSuggestRequest = new QFSGetSearchSuggestRequest(this.f89843c);
            this.f91858a = qFSGetSearchSuggestRequest;
            return qFSGetSearchSuggestRequest;
        }

        public a f(String str) {
            this.f89843c.input_word.set(str);
            return this;
        }
    }

    QFSGetSearchSuggestRequest(CircleSearchExhibition$StSuggestionReq circleSearchExhibition$StSuggestionReq) {
        this.mRequest = circleSearchExhibition$StSuggestionReq;
        circleSearchExhibition$StSuggestionReq.adRequest.set(j.f90213a.l(new QQCircleFeedBase$StFeedListBusiReqData().entrySchema.get(), 1001));
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.circlesearch.exhibition.ExhibitionSvr.ExhibitionSuggestion";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CircleSearchExhibition$StSuggestionRsp circleSearchExhibition$StSuggestionRsp = new CircleSearchExhibition$StSuggestionRsp();
        try {
            circleSearchExhibition$StSuggestionRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return circleSearchExhibition$StSuggestionRsp;
    }
}
