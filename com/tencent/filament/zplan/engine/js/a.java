package com.tencent.filament.zplan.engine.js;

import com.tencent.filament.zplan.engine.FilamentNativeJsApp;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0019\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\r\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/filament/zplan/engine/js/a;", "", "", "f", "Lorg/json/JSONObject;", "jsonObject", "g", "message", "c", "b", "result", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "event", "e", "setJsonParams", "(Ljava/lang/String;)V", "jsonParams", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/filament/zplan/engine/js/FilamentJsPluginEngine;", "Ljava/lang/ref/WeakReference;", "engineRef", "", "I", "getCallbackId", "()I", "setCallbackId", "(I)V", "callbackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ref/WeakReference;I)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String event;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jsonParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<FilamentJsPluginEngine> engineRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int callbackId;

    public a(@NotNull String event, @NotNull String jsonParams, @NotNull WeakReference<FilamentJsPluginEngine> engineRef, int i3) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(jsonParams, "jsonParams");
        Intrinsics.checkNotNullParameter(engineRef, "engineRef");
        this.event = event;
        this.jsonParams = jsonParams;
        this.engineRef = engineRef;
        this.callbackId = i3;
    }

    public final void a(@Nullable String result) {
        WeakReference<FilamentNativeJsApp> appRef;
        FilamentNativeJsApp filamentNativeJsApp;
        FilamentJsPluginEngine filamentJsPluginEngine = this.engineRef.get();
        if (filamentJsPluginEngine != null && (appRef = filamentJsPluginEngine.getAppRef()) != null && (filamentNativeJsApp = appRef.get()) != null) {
            filamentNativeJsApp.a("invokeCallbackHandler", result);
        }
    }

    @NotNull
    public final String b(@Nullable String message) {
        return c(null, message);
    }

    @NotNull
    public final String c(@Nullable JSONObject jsonObject, @Nullable String message) {
        String jSONObject = com.tencent.filament.zplan.util.a.f106239a.a(this.event, this.callbackId, jsonObject, message).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "resultObj.toString()");
        a(jSONObject);
        return jSONObject;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getJsonParams() {
        return this.jsonParams;
    }

    @Nullable
    public final String f() {
        return g(null);
    }

    @NotNull
    public final String g(@Nullable JSONObject jsonObject) {
        String jSONObject = com.tencent.filament.zplan.util.a.f106239a.b(this.event, this.callbackId, jsonObject).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "resultObj.toString()");
        a(jSONObject);
        return jSONObject;
    }
}
