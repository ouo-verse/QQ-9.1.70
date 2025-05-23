package com.tencent.biz.qqcircle.requests;

import feedcloud.SetShareMessageInfoReq;
import feedcloud.SetShareMessageInfoRsp;
import feedcloud.ShareMessageInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSetShareMessageInfoRequest extends QCircleBaseRequest {
    private List<ShareMessageInfo> mShareMessageInfoList;

    public QCircleSetShareMessageInfoRequest(List<ShareMessageInfo> list) {
        this.mShareMessageInfoList = list;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.reply_share_message.ReplyShareMessage.SetShareMessageInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        SetShareMessageInfoReq.a aVar = new SetShareMessageInfoReq.a();
        List<ShareMessageInfo> list = this.mShareMessageInfoList;
        if (list != null && !list.isEmpty()) {
            aVar.b(this.mShareMessageInfoList);
        }
        return aVar.build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public SetShareMessageInfoRsp decode(byte[] bArr) {
        try {
            return SetShareMessageInfoRsp.ADAPTER.decode(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return new SetShareMessageInfoRsp.a().build();
        }
    }
}
