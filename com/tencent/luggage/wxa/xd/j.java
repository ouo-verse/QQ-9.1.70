package com.tencent.luggage.wxa.xd;

import android.os.Build;
import android.webkit.ValueCallback;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class j extends e implements i {
    public final /* synthetic */ k E = new k();
    public final String F = "AppBrandComponentWxaSharedKT";
    public Boolean G;

    public abstract boolean A();

    public void B() {
        this.E.a();
    }

    @Override // com.tencent.luggage.wxa.xd.i, com.tencent.luggage.wxa.yi.h
    public /* synthetic */ com.tencent.luggage.wxa.yi.g a() {
        return q41.e.a(this);
    }

    public void b(JSONObject provideConfig) {
        Intrinsics.checkNotNullParameter(provideConfig, "provideConfig");
        new m1().a(provideConfig);
    }

    public final void c(JSONObject __wxConfig) {
        Intrinsics.checkNotNullParameter(__wxConfig, "__wxConfig");
        a(this, __wxConfig, (ValueCallback) null, 2, (Object) null);
    }

    public boolean w() {
        if (y()) {
            com.tencent.luggage.wxa.tn.w.d(this.F, "this:" + this + " invokeCostManager:" + getInvokeCostManager() + " start");
            g1 invokeCostManager = getInvokeCostManager();
            Intrinsics.checkNotNull(invokeCostManager);
            invokeCostManager.d();
            return true;
        }
        return false;
    }

    public JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        a(jSONObject, "preload", Boolean.TRUE);
        return jSONObject;
    }

    public final boolean y() {
        if (this.G == null) {
            if (i() == null) {
                com.tencent.luggage.wxa.tn.w.f(this.F, "isCollectInvokeCost false, libReader is null");
                return false;
            }
            com.tencent.luggage.wxa.rc.q i3 = i();
            Intrinsics.checkNotNull(i3);
            this.G = Boolean.valueOf(Boolean.parseBoolean(i3.h("collectInvokeCost")));
            com.tencent.luggage.wxa.tn.w.d(this.F, "this:" + this + " isCollectInvokeCost:" + this.G);
        }
        Boolean bool = this.G;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    public abstract boolean z();

    public static /* synthetic */ void a(j jVar, JSONObject jSONObject, ValueCallback valueCallback, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: injectWxConfig");
        }
        if ((i3 & 2) != 0) {
            valueCallback = null;
        }
        jVar.a(jSONObject, valueCallback);
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        com.tencent.luggage.wxa.ic.g runtime = getRuntime();
        if (runtime == null) {
            com.tencent.luggage.wxa.zp.h.f146825d.execute(runnable);
        } else {
            runtime.d(runnable);
        }
    }

    public final void a(JSONObject __wxConfig, ValueCallback valueCallback) {
        Intrinsics.checkNotNullParameter(__wxConfig, "__wxConfig");
        getJsRuntime().evaluateJavascript("var __wxConfig = " + __wxConfig, valueCallback);
    }

    public void a(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        b(config);
        a(config, TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "Android " + Build.VERSION.RELEASE);
        a(config, "systemApiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
        a(config, "brand", Build.BRAND);
        a(config, "pixelRatio", Float.valueOf(getContext().getResources().getDisplayMetrics().density));
    }

    public final void a(JSONObject obj, String key, Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            obj.put(key, obj2);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a(this.F, e16, "put with key(" + key + ')', new Object[0]);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public final void a(Runnable runnable) {
        Unit unit;
        if (runnable == null) {
            return;
        }
        com.tencent.luggage.wxa.ic.g runtime = getRuntime();
        if (runtime != null) {
            runtime.e(runnable);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (z() || A()) {
                com.tencent.luggage.wxa.tn.c0.a(runnable);
            }
        }
    }

    public final void a(Runnable runnable, long j3) {
        Unit unit;
        if (runnable == null) {
            return;
        }
        com.tencent.luggage.wxa.ic.g runtime = getRuntime();
        if (runtime != null) {
            runtime.b(runnable, j3);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (z() || A()) {
                com.tencent.luggage.wxa.tn.c0.a(runnable, j3);
            }
        }
    }
}
