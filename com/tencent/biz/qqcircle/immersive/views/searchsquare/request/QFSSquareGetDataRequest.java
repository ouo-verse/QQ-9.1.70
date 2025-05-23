package com.tencent.biz.qqcircle.immersive.views.searchsquare.request;

import circlesearch.CircleSearchExhibition$StSquareReq;
import circlesearch.CircleSearchExhibition$StSquareRsp;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSquareGetDataRequest extends QFSSearchBaseRequest {
    private final CircleSearchExhibition$StSquareReq request;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSSquareGetDataRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final CircleSearchExhibition$StSquareReq f91316c = new CircleSearchExhibition$StSquareReq();

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSSquareGetDataRequest b() {
            QFSSquareGetDataRequest qFSSquareGetDataRequest = new QFSSquareGetDataRequest(this.f91316c);
            this.f91858a = qFSSquareGetDataRequest;
            return qFSSquareGetDataRequest;
        }

        public a f(String str) {
            this.f91316c.query.set(str);
            return this;
        }

        public a g(int i3) {
            this.f91316c.type.add(Integer.valueOf(i3));
            return this;
        }
    }

    QFSSquareGetDataRequest(CircleSearchExhibition$StSquareReq circleSearchExhibition$StSquareReq) {
        this.request = circleSearchExhibition$StSquareReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.circlesearch.exhibition.ExhibitionSvr.QuerySquareInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.request.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CircleSearchExhibition$StSquareRsp circleSearchExhibition$StSquareRsp = new CircleSearchExhibition$StSquareRsp();
        try {
            circleSearchExhibition$StSquareRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.w("QFSSquareGetBubbleRequest", 1, e16.getMessage(), e16);
        }
        return circleSearchExhibition$StSquareRsp;
    }
}
