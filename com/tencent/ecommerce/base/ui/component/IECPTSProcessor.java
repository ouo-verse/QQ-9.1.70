package com.tencent.ecommerce.base.ui.component;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/base/ui/component/IECPTSProcessor;", "", "", "Lbh0/e;", "pageParserParams", "Lorg/json/JSONObject;", "data", "reqParam", "Lcom/tencent/ecommerce/base/ui/b;", "process", "ext", "processRemoteParserParamsArray", "localPageParserParamsArray", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IECPTSProcessor {
    List<ECPageParserParams> localPageParserParamsArray(JSONObject ext);

    List<ECBasePtsViewData> process(List<ECPageParserParams> pageParserParams, JSONObject data, JSONObject reqParam);

    List<ECPageParserParams> processRemoteParserParamsArray(JSONObject data, JSONObject ext);
}
