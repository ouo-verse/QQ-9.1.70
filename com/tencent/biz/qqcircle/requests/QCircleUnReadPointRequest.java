package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StClearRedPointReq;
import feedcloud.FeedCloudRead$StClearRedPointRsp;

/* loaded from: classes5.dex */
public class QCircleUnReadPointRequest extends QCircleBaseRequest {
    public FeedCloudRead$StClearRedPointReq mRequest;

    public QCircleUnReadPointRequest(String str, int i3) {
        FeedCloudRead$StClearRedPointReq feedCloudRead$StClearRedPointReq = new FeedCloudRead$StClearRedPointReq();
        this.mRequest = feedCloudRead$StClearRedPointReq;
        feedCloudRead$StClearRedPointReq.userID.set(QCirclePluginGlobalInfo.l());
        this.mRequest.toUID.set(str);
        this.mRequest.pageType.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.ClearRedPoint";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudRead$StClearRedPointRsp> messageMicro = new MessageMicro<FeedCloudRead$StClearRedPointRsp>() { // from class: feedcloud.FeedCloudRead$StClearRedPointRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "result"}, new Object[]{null, null}, FeedCloudRead$StClearRedPointRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
            public FeedCloudCommon$Result result = new FeedCloudCommon$Result();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }

    public QCircleUnReadPointRequest(String str, int i3, long j3) {
        this(str, i3);
        this.mRequest.lastPageTime.set(j3);
    }
}
