package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq;
import feedcloud.FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp;
import okio.ByteString;
import trpc.tianshu.RedPointTransInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSFeedCloudRenderFeedDetailRequest extends QCircleBaseRequest {
    private final FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq mRequest;

    public QFSFeedCloudRenderFeedDetailRequest(String str, String str2, int i3, boolean z16) {
        FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq = new FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq();
        this.mRequest = feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq;
        feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq.f398472id.set(str);
        feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq.entry_schema.set(str2);
        feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq.force_detail.set(z16);
        feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataReq.source.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.render_feed_detail.Render.GetFeedDetailWithExtraData";
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getMethodName() {
        return (String) a.c("FeedCloudSvr.trpc.feedcloud.render_feed_detail.Render.GetFeedDetailWithExtraData").second;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String getServiceName() {
        return (String) a.c("FeedCloudSvr.trpc.feedcloud.render_feed_detail.Render.GetFeedDetailWithExtraData").first;
    }

    public void setAllPushTransInfo(RedPointTransInfo redPointTransInfo) {
        ByteString byteString;
        if (redPointTransInfo != null && (byteString = redPointTransInfo.feedTransInfo) != null) {
            try {
                this.mRequest.red_trans_info.set(ByteStringMicro.copyFrom(byteString.toByteArray()));
                return;
            } catch (Exception e16) {
                RFWLog.e(BaseRequest.TAG, RFWLog.USR, "setAllPushTransInfo error:" + e16);
                return;
            }
        }
        RFWLog.e(BaseRequest.TAG, RFWLog.USR, "setAllPushTransInfo info is null");
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp = new FeedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp();
        try {
            feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRenderFeedDetail$GetFeedDetailWithExtraDataRsp;
    }
}
