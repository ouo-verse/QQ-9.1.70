package com.tencent.biz.qqcircle.immersive.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetPushListByOpUIDsFeedIDReq;
import feedcloud.FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp;

/* loaded from: classes4.dex */
public class QFSGetCommentAreaPushDataRequest extends QCircleBaseRequest {
    private final FeedCloudRead$StGetPushListByOpUIDsFeedIDReq mRequest;

    public QFSGetCommentAreaPushDataRequest(String str, String str2, ByteStringMicro byteStringMicro, String str3, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, String str4) {
        FeedCloudRead$StGetPushListByOpUIDsFeedIDReq feedCloudRead$StGetPushListByOpUIDsFeedIDReq = new FeedCloudRead$StGetPushListByOpUIDsFeedIDReq();
        this.mRequest = feedCloudRead$StGetPushListByOpUIDsFeedIDReq;
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSCommentAreaTabVPAdapter", 1, " feedId is null");
            return;
        }
        if (feedCloudCommon$StCommonExt != null) {
            feedCloudRead$StGetPushListByOpUIDsFeedIDReq.ext_info.set(feedCloudCommon$StCommonExt);
        }
        feedCloudRead$StGetPushListByOpUIDsFeedIDReq.feed_id.set(str);
        if (!TextUtils.isEmpty(str4)) {
            feedCloudRead$StGetPushListByOpUIDsFeedIDReq.like_key.set(str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            feedCloudRead$StGetPushListByOpUIDsFeedIDReq.author_uid.set(str2);
        }
        feedCloudRead$StGetPushListByOpUIDsFeedIDReq.count.set(30);
        if (byteStringMicro != null) {
            feedCloudRead$StGetPushListByOpUIDsFeedIDReq.backent_trans_data.set(byteStringMicro);
        }
        if (!TextUtils.isEmpty(str3)) {
            feedCloudRead$StGetPushListByOpUIDsFeedIDReq.anchor_uid.set(str3);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetPushListByOpUIDsFeedID";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return get$pbReqBytes();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp feedCloudRead$StGetPushListByOpUIDsFeedIDRsp = new FeedCloudRead$StGetPushListByOpUIDsFeedIDRsp();
        try {
            feedCloudRead$StGetPushListByOpUIDsFeedIDRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetPushListByOpUIDsFeedIDRsp;
    }
}
