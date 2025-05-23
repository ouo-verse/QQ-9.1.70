package com.tencent.ecommerce.biz.detail.dataprocessor.processor;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSProcessor;", "", "Lbh0/e;", "pageParserParams", "Lorg/json/JSONObject;", "data", "reqParam", "Lcom/tencent/ecommerce/base/ui/b;", "process", "ext", "processRemoteParserParamsArray", "localPageParserParamsArray", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class a implements IECPTSProcessor {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> localPageParserParamsArray(JSONObject ext) {
        List<ECPageParserParams> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECBasePtsViewData> process(List<ECPageParserParams> pageParserParams, JSONObject data, JSONObject reqParam) {
        ArrayList arrayList = new ArrayList();
        for (ECPageParserParams eCPageParserParams : pageParserParams) {
            IECPTSComposerParser iECPTSComposerParser = sh0.a.f433807b.a().get(Integer.valueOf(eCPageParserParams.parserId));
            List<ECBasePtsViewData> parse = iECPTSComposerParser != null ? iECPTSComposerParser.parse(eCPageParserParams, data, reqParam) : null;
            if (parse != null) {
                Iterator<ECBasePtsViewData> it = parse.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> processRemoteParserParamsArray(JSONObject data, JSONObject ext) {
        return null;
    }
}
