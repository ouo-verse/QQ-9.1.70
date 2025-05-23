package com.tencent.biz.qqcircle.immersive.request;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import qqcircle.QQCircleLightinteract$StDoUrgeReq;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDoUrgeRequest extends QCircleBaseRequest {
    private final QQCircleLightinteract$StDoUrgeReq mRequest;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSDoUrgeRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final QQCircleLightinteract$StDoUrgeReq f89834c;

        public a(@NonNull String str, int i3) {
            QQCircleLightinteract$StDoUrgeReq qQCircleLightinteract$StDoUrgeReq = new QQCircleLightinteract$StDoUrgeReq();
            this.f89834c = qQCircleLightinteract$StDoUrgeReq;
            qQCircleLightinteract$StDoUrgeReq.userID.set(str);
            qQCircleLightinteract$StDoUrgeReq.urgePosition.set(i3);
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSDoUrgeRequest b() {
            QFSDoUrgeRequest qFSDoUrgeRequest = new QFSDoUrgeRequest(this.f89834c);
            this.f91858a = qFSDoUrgeRequest;
            return qFSDoUrgeRequest;
        }
    }

    QFSDoUrgeRequest(QQCircleLightinteract$StDoUrgeReq qQCircleLightinteract$StDoUrgeReq) {
        this.mRequest = qQCircleLightinteract$StDoUrgeReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlelightinteract.CircleLightInteract.DoUrge";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    public String getUin() {
        QQCircleLightinteract$StDoUrgeReq qQCircleLightinteract$StDoUrgeReq = this.mRequest;
        if (qQCircleLightinteract$StDoUrgeReq == null) {
            return "";
        }
        return qQCircleLightinteract$StDoUrgeReq.userID.get();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp = new FeedCloudRead$StGetSearchPageRsp();
        try {
            feedCloudRead$StGetSearchPageRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetSearchPageRsp;
    }
}
