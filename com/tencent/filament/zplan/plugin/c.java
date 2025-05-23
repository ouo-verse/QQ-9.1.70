package com.tencent.filament.zplan.plugin;

import android.os.Build;
import com.tencent.filament.js.annotation.JsFilamentEvent;
import com.tencent.filament.js.annotation.JsFilamentPlugin;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import dl0.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@JsFilamentPlugin
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/filament/zplan/plugin/c;", "", "", "c", "", "b", "", "e", "d", "Ldl0/i;", "a", "Lcom/tencent/filament/zplan/engine/js/a;", "req", "getSystemInfoSync", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class c {
    private final i a() {
        return (i) fl0.a.f399763a.a(i.class);
    }

    private final float b() {
        i a16 = a();
        if (a16 != null) {
            return a16.c();
        }
        return 0.0f;
    }

    private final String c() {
        i a16 = a();
        if (a16 != null) {
            return a16.a();
        }
        return "";
    }

    private final int d() {
        i a16 = a();
        if (a16 != null) {
            return a16.b();
        }
        return 0;
    }

    private final int e() {
        i a16 = a();
        if (a16 != null) {
            return a16.d();
        }
        return 0;
    }

    @JsFilamentEvent({"getSystemInfoSync"})
    @NotNull
    public final String getSystemInfoSync(@NotNull com.tencent.filament.zplan.engine.js.a req) {
        Intrinsics.checkNotNullParameter(req, "req");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("model", DeviceInfoMonitor.getModel());
        jSONObject.put("qqVersion", c());
        jSONObject.put(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "Android " + Build.VERSION.RELEASE);
        jSONObject.put("pixelRatio", Float.valueOf(b()));
        jSONObject.put("screenWidth", e());
        jSONObject.put("screenHeight", d());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "data.toString()");
        return jSONObject2;
    }
}
