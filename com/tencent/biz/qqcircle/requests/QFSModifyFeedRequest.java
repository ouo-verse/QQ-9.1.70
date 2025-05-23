package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedAppInnnerJumpInfo;
import feedcloud.FeedCloudWrite$StModifyFeedReq;
import feedcloud.FeedCloudWrite$StModifyFeedRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSModifyFeedRequest extends QCircleBaseRequest {
    private FeedCloudWrite$StModifyFeedReq mRequest;

    public QFSModifyFeedRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, long j3) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSModifyFeedRequest", 1, "[QFSModifyFeedRequest] feed is null");
            return;
        }
        QLog.d("QFSModifyFeedRequest", 1, "[QFSModifyFeedRequest] qqGroupId =" + j3);
        FeedCloudWrite$StModifyFeedReq feedCloudWrite$StModifyFeedReq = new FeedCloudWrite$StModifyFeedReq();
        this.mRequest = feedCloudWrite$StModifyFeedReq;
        feedCloudWrite$StModifyFeedReq.feed.set(feedCloudMeta$StFeed);
        FeedCloudMeta$StFeedAppInnnerJumpInfo feedCloudMeta$StFeedAppInnnerJumpInfo = new FeedCloudMeta$StFeedAppInnnerJumpInfo();
        feedCloudMeta$StFeedAppInnnerJumpInfo.qq_group_id.set(j3);
        feedCloudMeta$StFeedAppInnnerJumpInfo.qq_group_source.set(2);
        this.mRequest.feed.feedExtraInfo.inner_jump.set(feedCloudMeta$StFeedAppInnnerJumpInfo);
        this.mRequest.mBitmap.set(16384L);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.ModifyFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return get$pbReqBytes();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudWrite$StModifyFeedRsp> messageMicro = new MessageMicro<FeedCloudWrite$StModifyFeedRsp>() { // from class: feedcloud.FeedCloudWrite$StModifyFeedRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "feed", "busiRspData"}, new Object[]{null, null, ByteStringMicro.EMPTY}, FeedCloudWrite$StModifyFeedRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
            public FeedCloudMeta$StFeed feed = new FeedCloudMeta$StFeed();
            public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
