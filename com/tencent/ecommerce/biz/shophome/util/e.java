package com.tencent.ecommerce.biz.shophome.util;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.ecommerce.biz.shophome.model.ECShopCategoryInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/util/e;", "", "Lorg/json/JSONArray;", "jsonArray", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/biz/shophome/model/b;", "Lkotlin/collections/ArrayList;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f104394a = new e();

    e() {
    }

    public final ArrayList<ECShopCategoryInfo> a(JSONArray jsonArray) {
        ArrayList<ECShopCategoryInfo> arrayList = new ArrayList<>();
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jsonArray.getJSONObject(i3);
                Object opt = jSONObject.opt("name");
                arrayList.add(new ECShopCategoryInfo(opt != null ? opt.toString() : null, jSONObject.optJSONObject("category_info"), jSONObject.optInt(PictureConst.KEY_CATEGORY_TYPE), a(jSONObject.optJSONArray("sub_category")), jSONObject.optString("url"), false, 32, null));
            }
        }
        return arrayList;
    }
}
