package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/ab;", "", "", "jsonString", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ab {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 function1, String str) {
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final void b(@NotNull String jsonString, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        QLog.i("GXH", 1, "openPanel " + jsonString);
        JSONObject jSONObject = new JSONObject(jsonString);
        IGXHManager gxh = VasUtil.getService().getGxh();
        String optString = jSONObject.optString("title");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"title\")");
        int optInt = jSONObject.optInt("appId");
        String optString2 = jSONObject.optString("appName");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"appName\")");
        String optString3 = jSONObject.optString(WadlProxyConsts.SCENE_ID);
        Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(\"sceneId\")");
        String optString4 = jSONObject.optString("sourceId");
        Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(\"sourceId\")");
        String optString5 = jSONObject.optString("reportExt");
        Intrinsics.checkNotNullExpressionValue(optString5, "jsonObject.optString(\"reportExt\")");
        EIPCCallback a16 = com.tencent.mobileqq.vas.api.f.a(new f.b() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.aa
            @Override // com.tencent.mobileqq.vas.api.f.b
            public final void onCallback(String str) {
                ab.c(Function1.this, str);
            }
        });
        Intrinsics.checkNotNullExpressionValue(a16, "buildCallback {\n        \u2026.invoke(it)\n            }");
        gxh.openRechargePanel(optString, optInt, optString2, optString3, optString4, optString5, a16);
    }
}
