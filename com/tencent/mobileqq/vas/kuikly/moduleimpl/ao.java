package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.ark.ark;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasColorNoteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/ao;", "", "", ark.ARKMETADATA_JSON, "", "d", "c", "", "b", "isDisplay", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ao {
    public void a(@NotNull String isDisplay) {
        Intrinsics.checkNotNullParameter(isDisplay, "isDisplay");
        ((IVasColorNoteApi) QRoute.api(IVasColorNoteApi.class)).displayColorNote(Boolean.parseBoolean(isDisplay));
    }

    public boolean b(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return ((IVasColorNoteApi) QRoute.api(IVasColorNoteApi.class)).isColorNoteExist(new JSONObject(json).optInt("type", 0));
    }

    public void c(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        ((IVasColorNoteApi) QRoute.api(IVasColorNoteApi.class)).removeColorNote(new JSONObject(json).optInt("type", 0));
    }

    public void d(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        IVasColorNoteApi iVasColorNoteApi = (IVasColorNoteApi) QRoute.api(IVasColorNoteApi.class);
        String optString = jSONObject.optString("title");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"title\")");
        String optString2 = jSONObject.optString("subtitle");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"subtitle\")");
        String optString3 = jSONObject.optString("picUrl");
        Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(\"picUrl\")");
        int optInt = jSONObject.optInt("type", 0);
        String optString4 = jSONObject.optString("url");
        Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(\"url\")");
        iVasColorNoteApi.showColorNote(optString, optString2, optString3, optInt, optString4);
    }
}
