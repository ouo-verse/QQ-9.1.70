package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetMessageListReq;
import feedcloud.FeedCloudRead$StGetMessageListRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMessageBoxRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetMessageListReq mRequest;

    public QFSMessageBoxRequest(String str, String str2, String str3, String str4) {
        FeedCloudRead$StGetMessageListReq feedCloudRead$StGetMessageListReq = new FeedCloudRead$StGetMessageListReq();
        this.mRequest = feedCloudRead$StGetMessageListReq;
        feedCloudRead$StGetMessageListReq.listNum.set(10);
        if (!TextUtils.isEmpty(str4)) {
            this.mRequest.extInfo.set(new FeedCloudCommon$StCommonExt());
            bh.a(this.mRequest.extInfo.mapInfo, "sub_msg_from", str4);
        }
        if (str != null) {
            this.mRequest.operation.setHasFlag(true);
            this.mRequest.operation.opUser.setHasFlag(true);
            this.mRequest.operation.opUser.f398463id.set(str);
        }
        if (str3 != null) {
            this.mRequest.feedAttchInfo.set(str3);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.mRequest.message_category_id.set(Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            QLog.e(BaseRequest.TAG, 1, "QFSMessageBoxRequest invalid type:", str2);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMessageList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetMessageListRsp feedCloudRead$StGetMessageListRsp = new FeedCloudRead$StGetMessageListRsp();
        try {
            feedCloudRead$StGetMessageListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetMessageListRsp;
    }
}
