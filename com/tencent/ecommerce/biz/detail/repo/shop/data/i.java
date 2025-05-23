package com.tencent.ecommerce.biz.detail.repo.shop.data;

import com.tencent.hippy.qq.api.TabPreloadItem;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0000*\u00020\u0000H\u0002\u00a8\u0006\u0006"}, d2 = {"Lorg/json/JSONObject;", "", "e", "", "f", "d", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject d(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("price");
        return optJSONObject != null ? optJSONObject : new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(JSONObject jSONObject) {
        return jSONObject.optString("sku_id", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(TabPreloadItem.TAB_NAME_DYNAMIC);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return optJSONObject.optInt("stock_nums", 0);
    }
}
