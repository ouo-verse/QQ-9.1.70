package com.tencent.biz.qqcircle.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StClearCountInfo;
import feedcloud.FeedCloudRead$StClearCountReq;
import feedcloud.FeedCloudRead$StClearCountRsp;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleClearCountRequest extends QCircleBaseRequest {
    private FeedCloudRead$StClearCountReq mRequest = new FeedCloudRead$StClearCountReq();

    public QCircleClearCountRequest(String str, FeedCloudRead$StClearCountInfo feedCloudRead$StClearCountInfo) {
        if (feedCloudRead$StClearCountInfo != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(feedCloudRead$StClearCountInfo);
            this.mRequest.clearCountInfos.set(arrayList);
        }
        if (!TextUtils.isEmpty(str)) {
            this.mRequest.userId.set(str);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.ClearCount";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StClearCountRsp feedCloudRead$StClearCountRsp = new FeedCloudRead$StClearCountRsp();
        try {
            feedCloudRead$StClearCountRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StClearCountRsp;
    }
}
