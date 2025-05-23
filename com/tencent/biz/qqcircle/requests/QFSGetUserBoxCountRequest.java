package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead$GetUserBoxCntReq;
import feedcloud.FeedCloudRead$GetUserBoxCntRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSGetUserBoxCountRequest extends QCircleBaseRequest {
    private final FeedCloudRead$GetUserBoxCntReq mRequest = new MessageMicro<FeedCloudRead$GetUserBoxCntReq>() { // from class: feedcloud.FeedCloudRead$GetUserBoxCntReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"uid"}, new Object[]{""}, FeedCloudRead$GetUserBoxCntReq.class);
        public final PBStringField uid = PBField.initString("");
    };

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetUserBoxCnt";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$GetUserBoxCntRsp feedCloudRead$GetUserBoxCntRsp = new FeedCloudRead$GetUserBoxCntRsp();
        try {
            feedCloudRead$GetUserBoxCntRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$GetUserBoxCntRsp;
    }
}
