package com.tencent.mobileqq.search.searchdetail.content.template;

import com.tencent.qqnt.kernel.nativeinterface.SearchGameButton;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SearchGameButton;", "Lorg/json/JSONObject;", CacheTable.TABLE_NAME, "", "a", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class m {
    @NotNull
    public static final String a(@NotNull SearchGameButton searchGameButton, @NotNull JSONObject reportInfo) {
        Intrinsics.checkNotNullParameter(searchGameButton, "<this>");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", searchGameButton.appId);
        jSONObject.put("channelId", searchGameButton.channelId);
        jSONObject.put(PushClientConstants.TAG_PKG_NAME, searchGameButton.pkgName);
        jSONObject.put("name", searchGameButton.name);
        jSONObject.put("icon", searchGameButton.icon);
        jSONObject.put("url", searchGameButton.url);
        jSONObject.put("appSize", searchGameButton.appSize);
        jSONObject.put("businessChannel", searchGameButton.businessChannel);
        jSONObject.put("reportData", reportInfo);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }
}
