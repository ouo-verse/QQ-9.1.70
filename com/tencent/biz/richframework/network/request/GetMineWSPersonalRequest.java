package com.tencent.biz.richframework.network.request;

import WEISHI_USER_GROWTH.WEISHI$stGetPersonalPageReq;
import WEISHI_USER_GROWTH.WEISHI$stGetPersonalPageRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes5.dex */
public class GetMineWSPersonalRequest extends VSBaseRequest {
    private final WEISHI$stGetPersonalPageReq req;

    public GetMineWSPersonalRequest(String str, int i3) {
        WEISHI$stGetPersonalPageReq wEISHI$stGetPersonalPageReq = new WEISHI$stGetPersonalPageReq();
        this.req = wEISHI$stGetPersonalPageReq;
        wEISHI$stGetPersonalPageReq.person_id.set(str);
        wEISHI$stGetPersonalPageReq.type.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "LightAppSvc.ws_qq_feeds.GetPersonalPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        WEISHI$stGetPersonalPageRsp wEISHI$stGetPersonalPageRsp = new WEISHI$stGetPersonalPageRsp();
        try {
            wEISHI$stGetPersonalPageRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return wEISHI$stGetPersonalPageRsp;
    }
}
