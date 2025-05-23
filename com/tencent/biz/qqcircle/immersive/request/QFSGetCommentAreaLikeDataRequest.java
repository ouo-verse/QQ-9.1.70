package com.tencent.biz.qqcircle.immersive.request;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetLikeListByOpUIDsFeedIDReq;
import feedcloud.FeedCloudRead$StGetLikeListByOpUIDsFeedIDRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetCommentAreaLikeDataRequest extends QCircleBaseRequest {
    private final FeedCloudRead$StGetLikeListByOpUIDsFeedIDReq mRequest;

    public QFSGetCommentAreaLikeDataRequest(String str, ByteStringMicro byteStringMicro, List<String> list, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, String str2) {
        FeedCloudRead$StGetLikeListByOpUIDsFeedIDReq feedCloudRead$StGetLikeListByOpUIDsFeedIDReq = new FeedCloudRead$StGetLikeListByOpUIDsFeedIDReq();
        this.mRequest = feedCloudRead$StGetLikeListByOpUIDsFeedIDReq;
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSCommentAreaTabVPAdapter", 1, " feedId is null");
            return;
        }
        if (feedCloudCommon$StCommonExt != null) {
            feedCloudRead$StGetLikeListByOpUIDsFeedIDReq.ext_info.set(feedCloudCommon$StCommonExt);
        }
        feedCloudRead$StGetLikeListByOpUIDsFeedIDReq.feed_id.set(str);
        if (!TextUtils.isEmpty(str2)) {
            feedCloudRead$StGetLikeListByOpUIDsFeedIDReq.like_key.set(str2);
        }
        feedCloudRead$StGetLikeListByOpUIDsFeedIDReq.count.set(30);
        if (byteStringMicro != null) {
            feedCloudRead$StGetLikeListByOpUIDsFeedIDReq.backent_trans_data.set(byteStringMicro);
        }
        if (list != null && list.size() > 0) {
            feedCloudRead$StGetLikeListByOpUIDsFeedIDReq.anchor_uids.set(list);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetLikeListByOpUIDsFeedID";
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
        FeedCloudRead$StGetLikeListByOpUIDsFeedIDRsp feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp = new FeedCloudRead$StGetLikeListByOpUIDsFeedIDRsp();
        try {
            feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetLikeListByOpUIDsFeedIDRsp;
    }
}
