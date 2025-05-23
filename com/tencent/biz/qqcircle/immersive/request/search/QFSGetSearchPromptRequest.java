package com.tencent.biz.qqcircle.immersive.request.search;

import circlesearch.CircleSearchExhibition$StPromptReq;
import circlesearch.CircleSearchExhibition$StPromptResp;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSGetSearchPromptRequest extends QFSSearchBaseRequest {
    private final CircleSearchExhibition$StPromptReq mRequest;

    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSGetSearchPromptRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final CircleSearchExhibition$StPromptReq f89842c = new CircleSearchExhibition$StPromptReq();

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetSearchPromptRequest b() {
            QFSGetSearchPromptRequest qFSGetSearchPromptRequest = new QFSGetSearchPromptRequest(this.f89842c);
            this.f91858a = qFSGetSearchPromptRequest;
            return qFSGetSearchPromptRequest;
        }

        public a f(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
            this.f89842c.ext_info.set(feedCloudCommon$StCommonExt);
            return this;
        }

        public a g(List<Integer> list) {
            this.f89842c.prompts_type.set(list);
            return this;
        }
    }

    QFSGetSearchPromptRequest(CircleSearchExhibition$StPromptReq circleSearchExhibition$StPromptReq) {
        this.mRequest = circleSearchExhibition$StPromptReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.circlesearch.exhibition.ExhibitionSvr.ExhibitionPrompt";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CircleSearchExhibition$StPromptResp circleSearchExhibition$StPromptResp = new CircleSearchExhibition$StPromptResp();
        try {
            circleSearchExhibition$StPromptResp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return circleSearchExhibition$StPromptResp;
    }
}
