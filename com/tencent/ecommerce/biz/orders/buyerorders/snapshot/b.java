package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import bh0.ECPageParserParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/b;", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Lorg/json/JSONObject;", "ext", "", "Lbh0/e;", "localPageParserParamsArray", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends com.tencent.ecommerce.biz.detail.dataprocessor.processor.a {
    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> localPageParserParamsArray(JSONObject ext) {
        List<ECPageParserParams> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECPageParserParams[]{new ECPageParserParams(21, "product_detail_mainpic", "product_info", null, 8, null), new ECPageParserParams(0, "qshop_detail_title", "product_info", null, 9, null), new ECPageParserParams(0, "qshop_detail_snapshot_tips", "order_info", null, 9, null), new ECPageParserParams(0, "qshop_detail_snapshot_spec_and_property", "order_info", null, 9, null), new ECPageParserParams(0, "qshop_detail_snapshot_shop", "product_info", null, 9, null), new ECPageParserParams(24, "qshop_product_detail_table_title", "product_info", null, 8, null), new ECPageParserParams(0, "qshop_product_detail_table", "product_info", null, 9, null), new ECPageParserParams(0, "qshop_detail_pictures", "product_info", null, 9, null)});
        return listOf;
    }
}
