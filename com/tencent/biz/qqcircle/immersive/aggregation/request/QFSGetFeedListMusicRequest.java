package com.tencent.biz.qqcircle.immersive.aggregation.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetFeedListMusicRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetFeedListReq mRequest = new FeedCloudRead$StGetFeedListReq();

    public QFSGetFeedListMusicRequest(QFSFlowAggregationInitBean qFSFlowAggregationInitBean, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.mRequest.feedAttchInfo.set(str);
        }
        this.mRequest.from.set(0);
        this.mRequest.source.set(43);
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        if (!TextUtils.isEmpty(str2)) {
            qQCircleFeedBase$StFeedListBusiReqData.refreshAttachInfo.set(str2);
        }
        if (qFSFlowAggregationInitBean != null && qFSFlowAggregationInitBean.getFeedMusic() != null) {
            qQCircleFeedBase$StFeedListBusiReqData.musicInfo.set(qFSFlowAggregationInitBean.getFeedMusic());
        }
        this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedListBusiReqData.toByteArray()));
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedListMusic";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }
}
