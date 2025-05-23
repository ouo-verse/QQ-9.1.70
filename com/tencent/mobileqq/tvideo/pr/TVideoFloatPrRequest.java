package com.tencent.mobileqq.tvideo.pr;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.util.ArrayList;
import java.util.List;
import tvideo.TVideoFloatPr$FlowPoolReportMap;
import tvideo.TVideoFloatPr$GetQqPromotionReq;
import tvideo.TVideoFloatPr$GetQqPromotionResp;

/* loaded from: classes19.dex */
public class TVideoFloatPrRequest extends TVideoBaseRequest {
    private final List<TVideoFloatPr$FlowPoolReportMap> clientContext = new ArrayList();
    private final f params;

    public TVideoFloatPrRequest(f fVar) {
        this.params = fVar;
    }

    private void a() {
        if (qx2.a.c().e()) {
            TVideoFloatPr$FlowPoolReportMap tVideoFloatPr$FlowPoolReportMap = new TVideoFloatPr$FlowPoolReportMap();
            tVideoFloatPr$FlowPoolReportMap.key.set("privacy_h5_show");
            tVideoFloatPr$FlowPoolReportMap.value.set("1");
            this.clientContext.add(tVideoFloatPr$FlowPoolReportMap);
        }
    }

    private void b() {
        if (!TextUtils.isEmpty(this.params.e())) {
            TVideoFloatPr$FlowPoolReportMap tVideoFloatPr$FlowPoolReportMap = new TVideoFloatPr$FlowPoolReportMap();
            tVideoFloatPr$FlowPoolReportMap.key.set("tag");
            tVideoFloatPr$FlowPoolReportMap.value.set(this.params.e());
            this.clientContext.add(tVideoFloatPr$FlowPoolReportMap);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getCallee() {
        return "trpc.flow_pool.gateway.FlowPoolActivity";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getFunc() {
        return "/trpc.flow_pool.gateway.FlowPoolActivity/GetQqPromotion";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        TVideoFloatPr$GetQqPromotionReq tVideoFloatPr$GetQqPromotionReq = new TVideoFloatPr$GetQqPromotionReq();
        f fVar = this.params;
        if (fVar != null) {
            tVideoFloatPr$GetQqPromotionReq.pageType.set(fVar.d());
            tVideoFloatPr$GetQqPromotionReq.channelId.set(this.params.a() + "");
            tVideoFloatPr$GetQqPromotionReq.cid.set(this.params.b());
            tVideoFloatPr$GetQqPromotionReq.uniqueId.set(this.params.f());
            tVideoFloatPr$GetQqPromotionReq.pageIdx.set(this.params.c());
            a();
            b();
            tVideoFloatPr$GetQqPromotionReq.clientCtx.set(this.clientContext);
        }
        return tVideoFloatPr$GetQqPromotionReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        TVideoFloatPr$GetQqPromotionResp tVideoFloatPr$GetQqPromotionResp = new TVideoFloatPr$GetQqPromotionResp();
        try {
            tVideoFloatPr$GetQqPromotionResp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return tVideoFloatPr$GetQqPromotionResp;
    }
}
