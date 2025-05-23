package com.tencent.mobileqq.tvideo.pr;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import tvideo.TVideoFloatPr$GetQqPromotionLocationReq;
import tvideo.TVideoFloatPr$GetQqPromotionLocationResp;

/* loaded from: classes19.dex */
public class TVideoFloatPrLocationRequest extends TVideoBaseRequest {
    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getCallee() {
        return "trpc.flow_pool.gateway.FlowPoolActivity";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getFunc() {
        return "/trpc.flow_pool.gateway.FlowPoolActivity/GetQqPromotionLocation";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return new MessageMicro<TVideoFloatPr$GetQqPromotionLocationReq>() { // from class: tvideo.TVideoFloatPr$GetQqPromotionLocationReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TVideoFloatPr$GetQqPromotionLocationReq.class);
        }.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        TVideoFloatPr$GetQqPromotionLocationResp tVideoFloatPr$GetQqPromotionLocationResp = new TVideoFloatPr$GetQqPromotionLocationResp();
        try {
            tVideoFloatPr$GetQqPromotionLocationResp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return tVideoFloatPr$GetQqPromotionLocationResp;
    }
}
