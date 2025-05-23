package com.tencent.ecommerce.biz.detail.repo.saas;

import com.tencent.ecommerce.base.network.api.IECRequest;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/repo/saas/b;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "Lcom/tencent/ecommerce/biz/detail/repo/saas/a;", "a", "Lcom/tencent/ecommerce/biz/detail/repo/saas/a;", "productDetailBySellerReq", "", "saasType", "sassProductId", "", "goodsType", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a productDetailBySellerReq;

    public b(String str, String str2, int i3) {
        this.productDetailBySellerReq = new a(str, str2, i3);
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        return this.productDetailBySellerReq.encodeParams();
    }
}
