package com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas;

import bh0.ECPageParserParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/saas/ECTxVideoSellerProductProcessor;", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Lorg/json/JSONObject;", "data", "ext", "", "Lbh0/e;", "processRemoteParserParamsArray", "localPageParserParamsArray", "<init>", "()V", "a", "TxVideoDetailType", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECTxVideoSellerProductProcessor extends com.tencent.ecommerce.biz.detail.dataprocessor.processor.a {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/saas/ECTxVideoSellerProductProcessor$TxVideoDetailType;", "", "(Ljava/lang/String;I)V", "DETAIL_TYPE_UNKNOWN", "DETAIL_TYPE_MEMBER", "DETAIL_TYPE_VIDEO_MEMBER", "DETAIL_TYPE_SINGLE_VIDEO", "DETAIL_TYPE_UNION_MEMBER", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum TxVideoDetailType {
        DETAIL_TYPE_UNKNOWN,
        DETAIL_TYPE_MEMBER,
        DETAIL_TYPE_VIDEO_MEMBER,
        DETAIL_TYPE_SINGLE_VIDEO,
        DETAIL_TYPE_UNION_MEMBER
    }

    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> processRemoteParserParamsArray(JSONObject data, JSONObject ext) {
        JSONObject optJSONObject;
        ArrayList arrayList = null;
        JSONArray optJSONArray = (data == null || (optJSONObject = data.optJSONObject("tx_video_product")) == null) ? null : optJSONObject.optJSONArray("page_names");
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

    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> localPageParserParamsArray(JSONObject ext) {
        List<ECPageParserParams> listOf;
        List<ECPageParserParams> listOf2;
        Integer valueOf = ext != null ? Integer.valueOf(ext.optInt("EC_GOODS_DETAIL_TYPE", 0)) : null;
        int ordinal = TxVideoDetailType.DETAIL_TYPE_UNION_MEMBER.ordinal();
        if (valueOf != null && valueOf.intValue() == ordinal) {
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new ECPageParserParams[]{new ECPageParserParams(1, "product_detail_mainpic", "", ext), new ECPageParserParams(8, "txvideo_product_detail_price_sales", "", ext), new ECPageParserParams(9, "product_detail_rich_text_name", "", ext), new ECPageParserParams(8, "product_detail_commission_ratio", "", ext), new ECPageParserParams(0, "product_detail_pictures", "", ext), new ECPageParserParams(0, "txvideo_video_info", "", ext), new ECPageParserParams(10, "product_detail_rule", "tx_video_product", ext), new ECPageParserParams(7, "qshop_detail_recommen_title_new", "", ext), new ECPageParserParams(6, "product_detail_saas_card", "", ext)});
            return listOf2;
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECPageParserParams[]{new ECPageParserParams(1, "product_detail_mainpic", "", ext), new ECPageParserParams(8, "txvideo_product_detail_price_sales", "", ext), new ECPageParserParams(9, "product_detail_rich_text_name", "", ext), new ECPageParserParams(8, "txvideo_product_detail_commission", "", ext), new ECPageParserParams(0, "txvideo_video_info", "", ext), new ECPageParserParams(10, "product_detail_rule", "tx_video_product", ext)});
        return listOf;
    }
}
