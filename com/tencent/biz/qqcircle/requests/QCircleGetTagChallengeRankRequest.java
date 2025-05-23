package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$GetTagChallengeRankReq;
import feedcloud.FeedCloudRead$GetTagChallengeRankRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetTagChallengeRankRequest extends QCircleBaseRequest {
    public static final String TAG = "com.tencent.biz.qqcircle.requests.QCircleGetTagChallengeRankRequest";
    private FeedCloudRead$GetTagChallengeRankReq mRequest;

    public QCircleGetTagChallengeRankRequest(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, String str) {
        FeedCloudRead$GetTagChallengeRankReq feedCloudRead$GetTagChallengeRankReq = new FeedCloudRead$GetTagChallengeRankReq();
        this.mRequest = feedCloudRead$GetTagChallengeRankReq;
        if (feedCloudCommon$StCommonExt != null) {
            feedCloudRead$GetTagChallengeRankReq.extInfo.set(feedCloudCommon$StCommonExt);
        }
        if (str != null) {
            this.mRequest.feedAttchInfo.set(str);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetTagChallengeRank";
    }

    public FeedCloudRead$GetTagChallengeRankReq getRequest() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$GetTagChallengeRankRsp feedCloudRead$GetTagChallengeRankRsp = new FeedCloudRead$GetTagChallengeRankRsp();
        try {
            feedCloudRead$GetTagChallengeRankRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            QLog.e(TAG, 4, "decode rsp error: " + e16.getMessage());
        }
        return feedCloudRead$GetTagChallengeRankRsp;
    }
}
