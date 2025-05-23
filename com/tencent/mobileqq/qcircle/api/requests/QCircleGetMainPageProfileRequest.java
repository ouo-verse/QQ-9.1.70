package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StGetMainPageReq;
import qqcircle.QQCircleMainPageProfile$GetQQProfileFeedListRsp;

/* loaded from: classes16.dex */
public class QCircleGetMainPageProfileRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetMainPageReq mRequest;

    public QCircleGetMainPageProfileRequest(String str, String str2, int i3) {
        FeedCloudRead$StGetMainPageReq feedCloudRead$StGetMainPageReq = new FeedCloudRead$StGetMainPageReq();
        this.mRequest = feedCloudRead$StGetMainPageReq;
        if (str2 != null) {
            feedCloudRead$StGetMainPageReq.feedAttchInfo.set(str2);
        }
        if (str != null) {
            this.mRequest.userId.set(str);
        }
        this.mRequest.from.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.mainpage_profile_reader.MainpageProfileReader.GetQQProfileFeedList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleMainPageProfile$GetQQProfileFeedListRsp qQCircleMainPageProfile$GetQQProfileFeedListRsp = new QQCircleMainPageProfile$GetQQProfileFeedListRsp();
        try {
            qQCircleMainPageProfile$GetQQProfileFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleMainPageProfile$GetQQProfileFeedListRsp;
    }
}
