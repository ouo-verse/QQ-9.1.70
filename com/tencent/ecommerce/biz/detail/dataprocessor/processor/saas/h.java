package com.tencent.ecommerce.biz.detail.dataprocessor.processor.saas;

import bh0.ECPageParserParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/saas/h;", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Lorg/json/JSONObject;", "ext", "", "Lbh0/e;", "localPageParserParamsArray", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h extends com.tencent.ecommerce.biz.detail.dataprocessor.processor.a {
    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> localPageParserParamsArray(JSONObject ext) {
        List<ECPageParserParams> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECPageParserParams(20, "empty_page_card", "", ext));
        return listOf;
    }
}
