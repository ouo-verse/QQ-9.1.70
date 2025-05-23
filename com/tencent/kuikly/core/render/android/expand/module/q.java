package com.tencent.kuikly.core.render.android.expand.module;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/q;", "Li01/e;", "", "params", "a", "c", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "d", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class q extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/q$a;", "", "", "GET_ITEM", "Ljava/lang/String;", "MODULE_NAME", "SET_ITEM", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.module.q$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String a(String params) {
        Context context;
        SharedPreferences sharedPreferences;
        String string;
        if (params == null || (context = getContext()) == null || (sharedPreferences = context.getSharedPreferences("KRSharedPreferencesModule", 0)) == null || (string = sharedPreferences.getString(params, "")) == null) {
            return "";
        }
        return string;
    }

    private final String c(String params) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String optString = k06.optString("key");
        String optString2 = k06.optString("value");
        Context context = getContext();
        if (context != null && (sharedPreferences = context.getSharedPreferences("KRSharedPreferencesModule", 0)) != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString(optString, optString2)) != null) {
            putString.apply();
            return "";
        }
        return "";
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -75439223) {
            if (hashCode == 1984670357 && method.equals("setItem")) {
                return c(params);
            }
        } else if (method.equals("getItem")) {
            return a(params);
        }
        return super.call(method, params, callback);
    }
}
