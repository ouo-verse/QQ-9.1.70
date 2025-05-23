package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/x;", "", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/x$a;", "", "", "param", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.kuikly.moduleimpl.x$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String param, @Nullable Function1<Object, Unit> callback) {
            int i3;
            String str;
            Intrinsics.checkNotNullParameter(param, "param");
            String key = new JSONObject(param).optString("business");
            IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Object mqqData = iVasKuiklyApi.getMqqData(key);
            if (mqqData == null) {
                i3 = -1;
            } else {
                i3 = 0;
            }
            if (mqqData == null) {
                str = "\u65e0\u6570\u636e";
            } else {
                str = "";
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", i3);
                jSONObject.put("msg", str);
                jSONObject.put("data", mqqData);
                if (callback != null) {
                    callback.invoke(jSONObject);
                }
            } catch (JSONException unused) {
                if (callback != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -2);
                    jSONObject2.put("msg", "json error");
                    callback.invoke(jSONObject2);
                }
            }
        }

        Companion() {
        }
    }
}
