package com.tencent.mobileqq.mini.model;

import com.tencent.luggage.wxa.xd.t0;
import com.tencent.mobileqq.mini.manager.MiniAppDetainManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/model/DetailConfigParseHelper;", "", "()V", "parse", "", "Lcom/tencent/mobileqq/mini/model/AppDetainConfig;", "configStr", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DetailConfigParseHelper {
    public final List<AppDetainConfig> parse(String configStr) {
        JSONArray optJSONArray;
        Intrinsics.checkNotNullParameter(configStr, "configStr");
        ArrayList arrayList = new ArrayList();
        try {
            optJSONArray = new JSONObject(configStr).optJSONArray("detainConfig");
        } catch (Exception e16) {
            QLog.e(MiniAppDetainManager.TAG, 1, "parse failed-->", e16);
        }
        if (optJSONArray == null) {
            return arrayList;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i3);
            String string = jSONObject.getString("content");
            Intrinsics.checkNotNullExpressionValue(string, "itemJson.getString(\"content\")");
            String string2 = jSONObject.getString("exitButton");
            Intrinsics.checkNotNullExpressionValue(string2, "itemJson.getString(\"exitButton\")");
            String string3 = jSONObject.getString("enterButton");
            Intrinsics.checkNotNullExpressionValue(string3, "itemJson.getString(\"enterButton\")");
            AppDetainConfig appDetainConfig = new AppDetainConfig(string, string2, string3, jSONObject.optString(t0.NAME, null), jSONObject.optString("openType", null), jSONObject.optString("exitPage", null));
            if (appDetainConfig.isValidItem()) {
                arrayList.add(appDetainConfig);
            }
        }
        return arrayList;
    }
}
