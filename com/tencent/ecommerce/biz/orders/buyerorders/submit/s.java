package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CommitOrderReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CommitOrderRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/s;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CommitOrderReq;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CommitOrderRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "", "Ljava/lang/String;", "pageExt", "aidStr", "c", "activityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class s implements IECNetworkPBContracts<ECQshopOrderSvr$CommitOrderReq, ECQshopOrderSvr$CommitOrderRsp> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String pageExt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String aidStr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String activityId;

    public s(String str, String str2, String str3) {
        this.pageExt = str;
        this.aidStr = str2;
        this.activityId = str3;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ECQshopOrderSvr$CommitOrderRsp decodeResponse(byte[] rsp) {
        return new ECQshopOrderSvr$CommitOrderRsp().mergeFrom(rsp);
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] encodeRequestParams(ECQshopOrderSvr$CommitOrderReq params, int channel, JSONObject reqExt) {
        params.req_ext.set(this.pageExt);
        params.aid.set(this.aidStr);
        String str = this.activityId;
        if (str != null) {
            params.active_id.set(str);
        }
        return params.toByteArray();
    }
}
