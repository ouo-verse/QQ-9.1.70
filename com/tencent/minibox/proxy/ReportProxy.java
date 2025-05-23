package com.tencent.minibox.proxy;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u00aa\u0001\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/minibox/proxy/ReportProxy;", "", "report", "", "reportJson", "Lorg/json/JSONObject;", "target", "", "reportToDC04239", "appId", "", "actionType", "subActionType", "reserves", "reserves2", "reserves3", "reserves4", "reserves5", "reserves6", "reserves7", "reserves8", "scene", "via", "reportData", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface ReportProxy {
    void report(@Nullable JSONObject reportJson, int target);

    void reportToDC04239(@Nullable String appId, @NotNull String actionType, @Nullable String subActionType, @Nullable String reserves, @Nullable String reserves2, @Nullable String reserves3, @Nullable String reserves4, @Nullable String reserves5, @Nullable String reserves6, @Nullable String reserves7, @Nullable String reserves8, int scene, @Nullable String via, @Nullable String reportData);
}
