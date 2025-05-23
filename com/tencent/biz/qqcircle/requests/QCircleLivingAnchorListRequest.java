package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetUserFollowLivingListReq;
import feedcloud.FeedCloudRead$StGetUserFollowLivingListRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleLivingAnchorListRequest extends QCircleBaseRequest {
    private FeedCloudRead$StGetUserFollowLivingListReq mRequest = new MessageMicro<FeedCloudRead$StGetUserFollowLivingListReq>() { // from class: feedcloud.FeedCloudRead$StGetUserFollowLivingListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "attchInfo"}, new Object[]{null, ""}, FeedCloudRead$StGetUserFollowLivingListReq.class);
        public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
        public final PBStringField attchInfo = PBField.initString("");
    };

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetUserFollowLivingAnchorList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetUserFollowLivingListRsp feedCloudRead$StGetUserFollowLivingListRsp = new FeedCloudRead$StGetUserFollowLivingListRsp();
        try {
            feedCloudRead$StGetUserFollowLivingListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QCircleLivingAnchorList", 1, "decode e=" + e16);
        }
        return feedCloudRead$StGetUserFollowLivingListRsp;
    }
}
