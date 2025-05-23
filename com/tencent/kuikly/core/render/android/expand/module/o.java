package com.tencent.kuikly.core.render.android.expand.module;

import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/o;", "Li01/e;", "", "params", "", "c", "a", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class o extends i01.e {
    private final void a() {
        d01.l i3;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (i3 = d01.u.f392615m.i()) != null) {
            i3.b(aVar);
        }
    }

    private final void c(String params) {
        boolean z16;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            JSONObject k06 = KRCSSViewExtensionKt.k0(params);
            String pageName = k06.optString("pageName");
            Intrinsics.checkNotNullExpressionValue(pageName, "pageName");
            if (pageName.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            JSONObject optJSONObject = k06.optJSONObject(ISchemeApi.KEY_PAGE_DATA);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            String hotReloadIp = k06.optString("hotReloadIp");
            d01.l i3 = d01.u.f392615m.i();
            if (i3 != null) {
                Intrinsics.checkNotNullExpressionValue(hotReloadIp, "hotReloadIp");
                i3.c(aVar, pageName, optJSONObject, hotReloadIp);
            }
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -504772615) {
            if (hashCode == -482608985 && method.equals("closePage")) {
                a();
                return Unit.INSTANCE;
            }
        } else if (method.equals(IndividuationPlugin.Method_OpenPage)) {
            c(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
