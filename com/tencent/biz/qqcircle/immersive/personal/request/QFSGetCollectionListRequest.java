package com.tencent.biz.qqcircle.immersive.personal.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudRead$GetCollectionListReq;
import feedcloud.FeedCloudRead$GetCollectionListRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetCollectionListRequest extends QCircleBaseRequest {
    private final FeedCloudRead$GetCollectionListReq mRequest;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements RequestInterceptor {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public void interceptRequest(BaseRequest baseRequest) {
            com.tencent.biz.richframework.network.request.a.a(this, baseRequest);
            cq.f92752a.a(QFSGetCollectionListRequest.this.mRequest.extInfo);
        }

        @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
        public /* synthetic */ void interceptResponse(Object[] objArr) {
            com.tencent.biz.richframework.network.request.a.b(this, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends QCircleBaseRequest.a<QFSGetCollectionListRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudRead$GetCollectionListReq f89000c;

        public b(String str) {
            FeedCloudRead$GetCollectionListReq feedCloudRead$GetCollectionListReq = new FeedCloudRead$GetCollectionListReq();
            this.f89000c = feedCloudRead$GetCollectionListReq;
            feedCloudRead$GetCollectionListReq.user_id.set(c(str));
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetCollectionListRequest b() {
            return new QFSGetCollectionListRequest(this.f89000c);
        }

        public b f(String str) {
            this.f89000c.attach_info.set(c(str));
            return this;
        }

        public b g(int i3) {
            this.f89000c.req_type.set(i3);
            return this;
        }
    }

    QFSGetCollectionListRequest(FeedCloudRead$GetCollectionListReq feedCloudRead$GetCollectionListReq) {
        this.mRequest = feedCloudRead$GetCollectionListReq;
        addRequestInterceptor(new a());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCollectionList";
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        return (String) com.tencent.biz.qqcircle.requests.a.a("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCollectionList").second;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return (String) com.tencent.biz.qqcircle.requests.a.a("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCollectionList").first;
    }

    public void setAttachInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mRequest.attach_info.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudRead$GetCollectionListRsp decode(byte[] bArr) {
        FeedCloudRead$GetCollectionListRsp feedCloudRead$GetCollectionListRsp = new FeedCloudRead$GetCollectionListRsp();
        try {
            feedCloudRead$GetCollectionListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$GetCollectionListRsp;
    }
}
