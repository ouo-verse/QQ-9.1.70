package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.api.IQZoneVideoApi;
import feedcloud.FeedCloudEeveeBase$ClientInfo;
import feedcloud.FeedCloudEeveeBase$StEeveeAttachInfo;
import feedcloud.FeedCloudEeveeUndealmsg$FcUndealMsgsReq;
import feedcloud.FeedCloudEeveeUndealmsg$FcUndealMsgsRsp;
import feedcloud.FeedCloudEeveeUndealmsg$SignalMsg;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleEeveeUndealMsgRequest extends QCircleBaseRequest {
    public static final String CMD_EEVEE = "FeedCloudSvr.trpc.feedcloud.eeveeundealmsg.EeveeMsgChannel.FcUndealMsgs";
    FeedCloudEeveeUndealmsg$FcUndealMsgsReq mReq;

    public QCircleEeveeUndealMsgRequest(FeedCloudEeveeBase$ClientInfo feedCloudEeveeBase$ClientInfo, int i3, int i16, FeedCloudEeveeUndealmsg$SignalMsg feedCloudEeveeUndealmsg$SignalMsg) {
        this(feedCloudEeveeBase$ClientInfo, i3, i16, feedCloudEeveeUndealmsg$SignalMsg, null);
    }

    private void addQQVideoAttachInfo(FeedCloudEeveeUndealmsg$FcUndealMsgsReq feedCloudEeveeUndealmsg$FcUndealMsgsReq) {
        String experimentId = ((IQZoneVideoApi) QRoute.api(IQZoneVideoApi.class)).getExperimentId();
        String experimentGrayId = ((IQZoneVideoApi) QRoute.api(IQZoneVideoApi.class)).getExperimentGrayId();
        if (experimentId == null) {
            experimentId = "";
        }
        if (experimentGrayId == null) {
            experimentGrayId = "";
        }
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo = new FeedCloudEeveeBase$StEeveeAttachInfo();
        feedCloudEeveeBase$StEeveeAttachInfo.key.set("qq_video_exp_id");
        feedCloudEeveeBase$StEeveeAttachInfo.value.set(experimentId);
        feedCloudEeveeUndealmsg$FcUndealMsgsReq.attachInfo.add(feedCloudEeveeBase$StEeveeAttachInfo);
        FeedCloudEeveeBase$StEeveeAttachInfo feedCloudEeveeBase$StEeveeAttachInfo2 = new FeedCloudEeveeBase$StEeveeAttachInfo();
        feedCloudEeveeBase$StEeveeAttachInfo2.key.set("qq_video_exp_group_id");
        feedCloudEeveeBase$StEeveeAttachInfo2.value.set(experimentGrayId);
        feedCloudEeveeUndealmsg$FcUndealMsgsReq.attachInfo.add(feedCloudEeveeBase$StEeveeAttachInfo2);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return CMD_EEVEE;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    public QCircleEeveeUndealMsgRequest(FeedCloudEeveeBase$ClientInfo feedCloudEeveeBase$ClientInfo, int i3, int i16, FeedCloudEeveeUndealmsg$SignalMsg feedCloudEeveeUndealmsg$SignalMsg, List<FeedCloudEeveeBase$StEeveeAttachInfo> list) {
        FeedCloudEeveeUndealmsg$FcUndealMsgsReq feedCloudEeveeUndealmsg$FcUndealMsgsReq = new FeedCloudEeveeUndealmsg$FcUndealMsgsReq();
        this.mReq = feedCloudEeveeUndealmsg$FcUndealMsgsReq;
        feedCloudEeveeUndealmsg$FcUndealMsgsReq.appid.set(10000);
        this.mReq.uid.set(String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()));
        this.mReq.clientInfo.set(feedCloudEeveeBase$ClientInfo);
        this.mReq.visitScene.set(i3);
        if (list != null && list.size() != 0) {
            this.mReq.attachInfo.clear();
            this.mReq.attachInfo.addAll(list);
        }
        addQQVideoAttachInfo(this.mReq);
        this.mReq.visitPage.set(i16);
        this.mReq.signalMsg.set(feedCloudEeveeUndealmsg$SignalMsg);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudEeveeUndealmsg$FcUndealMsgsRsp feedCloudEeveeUndealmsg$FcUndealMsgsRsp = new FeedCloudEeveeUndealmsg$FcUndealMsgsRsp();
        try {
            feedCloudEeveeUndealmsg$FcUndealMsgsRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudEeveeUndealmsg$FcUndealMsgsRsp;
    }
}
