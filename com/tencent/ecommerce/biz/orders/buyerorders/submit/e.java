package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.AddressCheckResult;
import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$CheckShipStatusReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$CheckShipStatusRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0002\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J.\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/e;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lkotlin/Pair;", "", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/a;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class e implements IECNetworkPBContracts<Pair<? extends String, ? extends ECAddress>, AddressCheckResult> {
    @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AddressCheckResult decodeResponse(byte[] rsp) {
        ECQshopLogisticsTemplateSvr$CheckShipStatusRsp mergeFrom = new ECQshopLogisticsTemplateSvr$CheckShipStatusRsp().mergeFrom(rsp);
        return new AddressCheckResult(mergeFrom.enable_shiped.get(), mergeFrom.show_bulletin.get() ? new BulletinInfo(mergeFrom.bulletin.title.get(), mergeFrom.bulletin.content.get()) : null);
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] encodeRequestParams(Pair<String, ECAddress> params, int channel, JSONObject reqExt) {
        ECQshopLogisticsTemplateSvr$CheckShipStatusReq eCQshopLogisticsTemplateSvr$CheckShipStatusReq = new ECQshopLogisticsTemplateSvr$CheckShipStatusReq();
        eCQshopLogisticsTemplateSvr$CheckShipStatusReq.spu_id.set(params.getFirst());
        eCQshopLogisticsTemplateSvr$CheckShipStatusReq.address.set(com.tencent.ecommerce.biz.orders.address.b.e(params.getSecond()));
        return eCQshopLogisticsTemplateSvr$CheckShipStatusReq.toByteArray();
    }
}
