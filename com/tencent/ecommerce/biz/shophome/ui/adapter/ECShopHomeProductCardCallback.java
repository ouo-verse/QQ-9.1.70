package com.tencent.ecommerce.biz.shophome.ui.adapter;

import com.tencent.ecommerce.biz.shophome.model.ECShopProductInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductCardCallback;", "", "Lcom/tencent/ecommerce/biz/shophome/model/c;", "product", "", "onAddProductToDeliver", "onAddProductToWindow", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface ECShopHomeProductCardCallback {
    void onAddProductToDeliver(ECShopProductInfo product);

    void onAddProductToWindow(ECShopProductInfo product);
}
