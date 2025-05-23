package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.BridgeManager;

/* loaded from: classes31.dex */
public class ProductDetailBaseViewModel {
    public final h tokenColor(String str) {
        SkinColor skinColor = SkinColor.INSTANCE;
        BridgeManager.f117344a.u();
        return skinColor.tokenColor(str, getDisableNightMode());
    }

    public boolean getDisableNightMode() {
        throw null;
    }
}
