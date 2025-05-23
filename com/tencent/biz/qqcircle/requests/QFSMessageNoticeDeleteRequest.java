package com.tencent.biz.qqcircle.requests;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq;
import feedcloud.FeedCloudWrite$StDelNoticeCategoryPageAndDetailRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMessageNoticeDeleteRequest extends QCircleBaseRequest {
    public FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq mRequest;

    public QFSMessageNoticeDeleteRequest(@NonNull FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq feedCloudWrite$StDelNoticeCategoryPageAndDetailReq = new FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq();
        this.mRequest = feedCloudWrite$StDelNoticeCategoryPageAndDetailReq;
        feedCloudWrite$StDelNoticeCategoryPageAndDetailReq.feedId.set(feedCloudMeta$StNotice.feedId.get());
        this.mRequest.extInfo.set(feedCloudMeta$StNotice.feed.extInfo.get());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DelNoticeCategoryPageAndDetail";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudWrite$StDelNoticeCategoryPageAndDetailRsp> messageMicro = new MessageMicro<FeedCloudWrite$StDelNoticeCategoryPageAndDetailRsp>() { // from class: feedcloud.FeedCloudWrite$StDelNoticeCategoryPageAndDetailRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ext"}, new Object[]{null}, FeedCloudWrite$StDelNoticeCategoryPageAndDetailRsp.class);
            public FeedCloudCommon$StCommonExt ext = new FeedCloudCommon$StCommonExt();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }

    public QFSMessageNoticeDeleteRequest(int i3) {
        FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq feedCloudWrite$StDelNoticeCategoryPageAndDetailReq = new FeedCloudWrite$StDelNoticeCategoryPageAndDetailReq();
        this.mRequest = feedCloudWrite$StDelNoticeCategoryPageAndDetailReq;
        feedCloudWrite$StDelNoticeCategoryPageAndDetailReq.category_id.set(i3);
    }
}
