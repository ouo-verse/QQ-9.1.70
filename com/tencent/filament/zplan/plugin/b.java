package com.tencent.filament.zplan.plugin;

import com.tencent.filament.js.annotation.JsFilamentEvent;
import com.tencent.filament.js.annotation.JsFilamentPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import dl0.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@JsFilamentPlugin
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/plugin/b;", "", "Lcom/tencent/filament/zplan/engine/js/a;", "req", "", "sendMSFRequest", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/filament/zplan/plugin/b$a", "Lgl0/c;", "", "rsp", "error", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements gl0.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.filament.zplan.engine.js.a f105777a;

        a(com.tencent.filament.zplan.engine.js.a aVar) {
            this.f105777a = aVar;
        }

        @Override // gl0.c
        public void a(@Nullable String rsp, @Nullable String error) {
            if (rsp != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WebViewPlugin.KEY_RESPONSE, rsp);
                this.f105777a.g(jSONObject);
                return;
            }
            this.f105777a.b(error);
        }
    }

    @JsFilamentEvent({"sendMSFRequest"})
    @NotNull
    public final String sendMSFRequest(@NotNull com.tencent.filament.zplan.engine.js.a req) {
        Intrinsics.checkNotNullParameter(req, "req");
        JSONObject jSONObject = new JSONObject(req.getJsonParams());
        String command = jSONObject.optString("command");
        String reqData = jSONObject.optString("reqData");
        f fVar = (f) fl0.a.f399763a.a(f.class);
        if (fVar == null) {
            req.b("no proxy");
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(command, "command");
        Intrinsics.checkNotNullExpressionValue(reqData, "reqData");
        fVar.a(command, reqData, new a(req));
        return "";
    }
}
