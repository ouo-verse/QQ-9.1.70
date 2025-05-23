package com.tencent.biz.qqcircle.immersive.personal.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudViewHistory$StAddViewHistoryReq;
import feedcloud.FeedCloudViewHistory$StAddViewHistoryRsp;
import java.util.List;
import qqcircle.QQCircleFeedBase$ViewedFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAddViewHistoryRequest extends QCircleBaseRequest {
    private final FeedCloudViewHistory$StAddViewHistoryReq mRequest;

    public QFSAddViewHistoryRequest(List<QQCircleFeedBase$ViewedFeed> list) {
        FeedCloudViewHistory$StAddViewHistoryReq feedCloudViewHistory$StAddViewHistoryReq = new FeedCloudViewHistory$StAddViewHistoryReq();
        this.mRequest = feedCloudViewHistory$StAddViewHistoryReq;
        if (list != null) {
            feedCloudViewHistory$StAddViewHistoryReq.viewed_feed.addAll(list);
        } else {
            QLog.e("QFSAddViewHistoryRequest", 1, "viewedFeeds can not be null!");
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.viewhistory.ViewHistoryProcess.AddViewHistory";
    }

    public List<QQCircleFeedBase$ViewedFeed> getHistorySent() {
        return this.mRequest.viewed_feed.get();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudViewHistory$StAddViewHistoryRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudViewHistory$StAddViewHistoryRsp decode(byte[] bArr) {
        ?? r06 = new MessageMicro<FeedCloudViewHistory$StAddViewHistoryRsp>() { // from class: feedcloud.FeedCloudViewHistory$StAddViewHistoryRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudViewHistory$StAddViewHistoryRsp.class);
        };
        try {
            r06.mergeFrom(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return r06;
    }
}
