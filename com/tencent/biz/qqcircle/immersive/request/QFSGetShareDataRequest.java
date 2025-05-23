package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.utils.af;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUnifiedTag;
import feedcloud.FeedCloudRead$StGetFeedSharePanelReq;
import feedcloud.FeedCloudRead$StGetFeedSharePanelRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetShareDataRequest extends QCircleBaseRequest {
    private final FeedCloudRead$StGetFeedSharePanelReq mRequest;

    public QFSGetShareDataRequest(QCircleShareInfo qCircleShareInfo) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudRead$StGetFeedSharePanelReq feedCloudRead$StGetFeedSharePanelReq = new FeedCloudRead$StGetFeedSharePanelReq();
        this.mRequest = feedCloudRead$StGetFeedSharePanelReq;
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null) {
            feedCloudRead$StGetFeedSharePanelReq.feed_id.set(af.a(feedCloudMeta$StFeed.f398449id.get()));
            QCircleExtraTypeInfo qCircleExtraTypeInfo = qCircleShareInfo.extraTypeInfo;
            if (qCircleExtraTypeInfo != null) {
                feedCloudRead$StGetFeedSharePanelReq.source.set(qCircleExtraTypeInfo.sourceType);
            }
            feedCloudRead$StGetFeedSharePanelReq.shareStyleType.set(qCircleShareInfo.shareStyleType);
            feedCloudRead$StGetFeedSharePanelReq.feed.f398449id.set(af.a(qCircleShareInfo.feed.f398449id.get()));
            feedCloudRead$StGetFeedSharePanelReq.feed.busiTranparent.set(qCircleShareInfo.feed.busiTranparent.get());
            feedCloudRead$StGetFeedSharePanelReq.feed.poster.f398463id.set(qCircleShareInfo.feed.poster.f398463id.get());
            feedCloudRead$StGetFeedSharePanelReq.feed.createTime.set(qCircleShareInfo.feed.createTime.get());
            feedCloudRead$StGetFeedSharePanelReq.tag_name.set(qCircleShareInfo.tagName);
            feedCloudRead$StGetFeedSharePanelReq.album_id.set(qCircleShareInfo.albumId);
            if (qCircleShareInfo.shareStyleType == 2) {
                feedCloudRead$StGetFeedSharePanelReq.dst_uid.set(qCircleShareInfo.mainPageUserUin);
            }
            if (qCircleShareInfo.shareStyleType == 9) {
                feedCloudRead$StGetFeedSharePanelReq.favorites_id.set(qCircleShareInfo.collectBoxId);
            }
            if (qCircleShareInfo.shareStyleType == 8) {
                feedCloudRead$StGetFeedSharePanelReq.extInfo.mapInfo.set(qCircleShareInfo.feed.buttomBanner.extInfo.get());
                feedCloudRead$StGetFeedSharePanelReq.extInfo.setHasFlag(true);
            }
            FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2 = qCircleShareInfo.gpsInfo;
            if (feedCloudMeta$StGPSV2 != null) {
                feedCloudRead$StGetFeedSharePanelReq.gps_info.set(feedCloudMeta$StGPSV2);
            }
            feedCloudRead$StGetFeedSharePanelReq.feed.setHasFlag(true);
            feedCloudRead$StGetFeedSharePanelReq.feed.poster.setHasFlag(true);
            FeedCloudMeta$StReply feedCloudMeta$StReply = qCircleShareInfo.reply;
            if (feedCloudMeta$StReply != null) {
                feedCloudRead$StGetFeedSharePanelReq.reply = feedCloudMeta$StReply;
                feedCloudMeta$StReply.setHasFlag(true);
            }
            FeedCloudMeta$StComment feedCloudMeta$StComment = qCircleShareInfo.comment;
            if (feedCloudMeta$StComment != null) {
                FeedCloudMeta$StComment feedCloudMeta$StComment2 = feedCloudMeta$StComment.get();
                feedCloudRead$StGetFeedSharePanelReq.comment = feedCloudMeta$StComment2;
                feedCloudMeta$StComment2.setHasFlag(true);
                return;
            }
            return;
        }
        QLog.e("QFSSharePart", 1, "shareInfo or feed is null");
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader_feeds.ComReader.GetFeedSharePanel";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        try {
            return getRequestByteData();
        } catch (Exception e16) {
            QLog.e("QFSSharePart", 1, "getRequestByteKey... exception:", e16);
            return new byte[0];
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedSharePanelRsp feedCloudRead$StGetFeedSharePanelRsp = new FeedCloudRead$StGetFeedSharePanelRsp();
        try {
            feedCloudRead$StGetFeedSharePanelRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedSharePanelRsp;
    }

    public QFSGetShareDataRequest(int i3, String str, String str2) {
        FeedCloudRead$StGetFeedSharePanelReq feedCloudRead$StGetFeedSharePanelReq = new FeedCloudRead$StGetFeedSharePanelReq();
        this.mRequest = feedCloudRead$StGetFeedSharePanelReq;
        feedCloudRead$StGetFeedSharePanelReq.shareStyleType.set(i3);
        FeedCloudMeta$StUnifiedTag feedCloudMeta$StUnifiedTag = new FeedCloudMeta$StUnifiedTag();
        feedCloudMeta$StUnifiedTag.unifiedId.set(str2);
        feedCloudMeta$StUnifiedTag.unifiedType.set(str);
        feedCloudRead$StGetFeedSharePanelReq.unifiedTagInfo.set(feedCloudMeta$StUnifiedTag);
    }
}
