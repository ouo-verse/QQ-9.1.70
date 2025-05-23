package com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas;

import bh0.ECPageParserParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/saas/f;", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Lorg/json/JSONObject;", "data", "ext", "", "Lbh0/e;", "processRemoteParserParamsArray", "localPageParserParamsArray", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f extends com.tencent.ecommerce.biz.detail.dataprocessor.processor.a {
    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> localPageParserParamsArray(JSONObject ext) {
        String str;
        int i3;
        List<ECPageParserParams> listOf;
        if (ext != null) {
            ext.optInt("EC_GOODS_TYPE", 0);
        }
        if (ext != null ? ext.optBoolean("activityInProgress") : false) {
            i3 = 31;
            str = "product_detail_presale_price";
        } else {
            str = "txvideo_product_detail_price_sales";
            i3 = 8;
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECPageParserParams[]{new ECPageParserParams(1, "product_detail_mainpic", "", ext), new ECPageParserParams(i3, str, "", ext), new ECPageParserParams(9, "product_detail_rich_text_name", "", ext), new ECPageParserParams(5, "product_detail_commission", "", ext), new ECPageParserParams(13, "hok_skill_intro", "", ext), new ECPageParserParams(0, "hok_skin_features", "", ext), new ECPageParserParams(10, "product_detail_rule", "honor_king_product", ext), new ECPageParserParams(7, "qshop_detail_recommen_title_new", "", ext), new ECPageParserParams(6, "product_detail_saas_card", "", ext)});
        return listOf;
    }

    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> processRemoteParserParamsArray(JSONObject data, JSONObject ext) {
        JSONObject optJSONObject;
        ArrayList arrayList = null;
        JSONArray optJSONArray = (data == null || (optJSONObject = data.optJSONObject("honor_king_product")) == null) ? null : optJSONObject.optJSONArray("page_names");
        if (optJSONArray != null) {
            arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                arrayList.add(new ECPageParserParams(Integer.parseInt(optJSONObject2.optString("parser_id")), optJSONObject2.optString("page_name"), "", ext));
            }
        }
        return arrayList;
    }
}
