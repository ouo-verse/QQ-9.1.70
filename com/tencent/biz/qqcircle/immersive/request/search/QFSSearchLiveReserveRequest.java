package com.tencent.biz.qqcircle.immersive.request.search;

import circlesearch.CircleSearchExhibition$StliveReserveReq;
import circlesearch.CircleSearchExhibition$StliveReserveRsp;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchLiveReserveRequest extends QFSSearchBaseRequest {
    private final CircleSearchExhibition$StliveReserveReq request;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSSearchLiveReserveRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final CircleSearchExhibition$StliveReserveReq f89844c;

        public a() {
            CircleSearchExhibition$StliveReserveReq circleSearchExhibition$StliveReserveReq = new CircleSearchExhibition$StliveReserveReq();
            this.f89844c = circleSearchExhibition$StliveReserveReq;
            circleSearchExhibition$StliveReserveReq.uin.set(QCircleHostStubUtil.getCurrentAccount());
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSSearchLiveReserveRequest b() {
            QFSSearchLiveReserveRequest qFSSearchLiveReserveRequest = new QFSSearchLiveReserveRequest(this.f89844c);
            this.f91858a = qFSSearchLiveReserveRequest;
            return qFSSearchLiveReserveRequest;
        }

        public a f(String str) {
            this.f89844c.room_id.set(str);
            return this;
        }

        public a g(int i3) {
            this.f89844c.status.set(i3);
            return this;
        }
    }

    QFSSearchLiveReserveRequest(CircleSearchExhibition$StliveReserveReq circleSearchExhibition$StliveReserveReq) {
        this.request = circleSearchExhibition$StliveReserveReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.circlesearch.exhibition.ExhibitionSvr.SetLiveReserve";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.request.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<CircleSearchExhibition$StliveReserveRsp> messageMicro = new MessageMicro<CircleSearchExhibition$StliveReserveRsp>() { // from class: circlesearch.CircleSearchExhibition$StliveReserveRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"success"}, new Object[]{Boolean.FALSE}, CircleSearchExhibition$StliveReserveRsp.class);
            public final PBBoolField success = PBField.initBool(false);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.w("QFSSearchLiveReserveRequest", 1, e16.getMessage(), e16);
        }
        return messageMicro;
    }
}
