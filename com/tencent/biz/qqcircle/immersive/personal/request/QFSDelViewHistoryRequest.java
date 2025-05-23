package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudWrite$StDelViewHistoryReq;
import feedcloud.FeedCloudWrite$StDelViewHistoryRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDelViewHistoryRequest extends QCircleBaseRequest {
    private FeedCloudWrite$StDelViewHistoryReq mRequest;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSDelViewHistoryRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudWrite$StDelViewHistoryReq f88996c;

        public a(int i3) {
            FeedCloudWrite$StDelViewHistoryReq feedCloudWrite$StDelViewHistoryReq = new FeedCloudWrite$StDelViewHistoryReq();
            this.f88996c = feedCloudWrite$StDelViewHistoryReq;
            feedCloudWrite$StDelViewHistoryReq.delType.set(i3);
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSDelViewHistoryRequest b() {
            return new QFSDelViewHistoryRequest(this.f88996c);
        }
    }

    public QFSDelViewHistoryRequest(FeedCloudWrite$StDelViewHistoryReq feedCloudWrite$StDelViewHistoryReq) {
        this.mRequest = feedCloudWrite$StDelViewHistoryReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DelViewHistory";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudWrite$StDelViewHistoryRsp, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudWrite$StDelViewHistoryRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudWrite$StDelViewHistoryRsp>() { // from class: feedcloud.FeedCloudWrite$StDelViewHistoryRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, FeedCloudWrite$StDelViewHistoryRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
        };
        try {
            r06.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
