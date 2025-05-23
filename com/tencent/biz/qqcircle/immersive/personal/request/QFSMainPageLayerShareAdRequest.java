package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$GetMainPageLayerShareADReq;
import feedcloud.FeedCloudRead$GetMainPageLayerShareADRsp;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSMainPageLayerShareAdRequest extends QCircleBaseRequest {
    private final int mEndPos;
    private final FeedCloudRead$GetMainPageLayerShareADReq mRequest;
    private final int mStartPos;

    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSMainPageLayerShareAdRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudRead$GetMainPageLayerShareADReq f89012c;

        /* renamed from: d, reason: collision with root package name */
        private int f89013d;

        /* renamed from: e, reason: collision with root package name */
        private int f89014e;

        public a(List<String> list, String str, String str2) {
            FeedCloudRead$GetMainPageLayerShareADReq feedCloudRead$GetMainPageLayerShareADReq = new FeedCloudRead$GetMainPageLayerShareADReq();
            this.f89012c = feedCloudRead$GetMainPageLayerShareADReq;
            feedCloudRead$GetMainPageLayerShareADReq.feed_ids.set(list);
            feedCloudRead$GetMainPageLayerShareADReq.attach_info.set(str);
            feedCloudRead$GetMainPageLayerShareADReq.dst_user_id.set(str2);
            feedCloudRead$GetMainPageLayerShareADReq.adres.set(j.f90213a.u(str2, ""));
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSMainPageLayerShareAdRequest b() {
            return new QFSMainPageLayerShareAdRequest(this.f89012c, this.f89013d, this.f89014e);
        }

        public a f(int i3) {
            this.f89014e = i3;
            return this;
        }

        public a g(int i3) {
            this.f89013d = i3;
            return this;
        }
    }

    public QFSMainPageLayerShareAdRequest(FeedCloudRead$GetMainPageLayerShareADReq feedCloudRead$GetMainPageLayerShareADReq, int i3, int i16) {
        this.mRequest = feedCloudRead$GetMainPageLayerShareADReq;
        this.mStartPos = i3;
        this.mEndPos = i16;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainPageLayerShareAD";
    }

    public int getEndPos() {
        return this.mEndPos;
    }

    public List<String> getReqFeedIds() {
        return this.mRequest.feed_ids.get();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public int getStartPos() {
        return this.mStartPos;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudRead$GetMainPageLayerShareADRsp decode(byte[] bArr) {
        FeedCloudRead$GetMainPageLayerShareADRsp feedCloudRead$GetMainPageLayerShareADRsp = new FeedCloudRead$GetMainPageLayerShareADRsp();
        try {
            feedCloudRead$GetMainPageLayerShareADRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSMainPageLayerShareAdRequest", 1, "decode error:", e16);
        }
        return feedCloudRead$GetMainPageLayerShareADRsp;
    }
}
