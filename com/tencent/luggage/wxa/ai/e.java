package com.tencent.luggage.wxa.ai;

import android.app.Activity;
import com.tencent.luggage.wxa.a8.x;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.mg.o;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e implements com.tencent.luggage.wxa.j8.d {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.i8.e f121482a;

    /* renamed from: b, reason: collision with root package name */
    public AppBrandInvokeContext f121483b;

    /* renamed from: c, reason: collision with root package name */
    public double f121484c;

    /* renamed from: d, reason: collision with root package name */
    public int f121485d;

    /* renamed from: e, reason: collision with root package name */
    public e0 f121486e;

    /* renamed from: f, reason: collision with root package name */
    public String f121487f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f121488g = false;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.i8.b f121489h = null;

    /* renamed from: i, reason: collision with root package name */
    public x f121490i = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.xd.d e16;
            Activity activity;
            if (e.this.f121483b != null && (e16 = e.this.f121483b.e()) != null) {
                if (e16 instanceof com.tencent.luggage.wxa.ic.l) {
                    activity = ((com.tencent.luggage.wxa.ic.l) e16).L();
                } else if ((e16 instanceof v) && (e16.getContext() instanceof Activity)) {
                    activity = (Activity) e16.getContext();
                } else {
                    activity = null;
                }
                if (activity != null) {
                    w.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
                    try {
                        activity.getWindow().addFlags(128);
                    } catch (Exception e17) {
                        w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn exception", e17);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.xd.d e16;
            Activity activity;
            if (e.this.f121483b != null && (e16 = e.this.f121483b.e()) != null) {
                if (e16 instanceof com.tencent.luggage.wxa.ic.l) {
                    activity = ((com.tencent.luggage.wxa.ic.l) e16).L();
                } else if ((e16 instanceof v) && (e16.getContext() instanceof Activity)) {
                    activity = (Activity) e16.getContext();
                } else {
                    activity = null;
                }
                if (activity != null) {
                    w.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
                    try {
                        activity.getWindow().clearFlags(128);
                    } catch (Exception e17) {
                        w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn exception", e17);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends k0 {
        private static final int CTRL_INDEX = 838;
        private static final String NAME = "onXWebVideoBackgroundPlaybackChange";

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends k0 {
        private static final int CTRL_INDEX = 543;
        private static final String NAME = "onXWebVideoEnded";

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ai.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6016e extends k0 {
        private static final int CTRL_INDEX = 545;
        private static final String NAME = "onXWebVideoError";

        public C6016e() {
        }

        public /* synthetic */ C6016e(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends k0 {
        private static final int CTRL_INDEX = 546;
        private static final String NAME = "onXWebVideoLoadedMetaData";

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends k0 {
        private static final int CTRL_INDEX = 542;
        private static final String NAME = "onXWebVideoPause";

        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends k0 {
        private static final int CTRL_INDEX = 541;
        private static final String NAME = "onXWebVideoPlay";

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends k0 {
        private static final int CTRL_INDEX = 683;
        private static final String NAME = "onXWebVideoPreloadedMetaData";

        public i() {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends k0 {
        private static final int CTRL_INDEX = 547;
        private static final String NAME = "onXWebVideoProgress";

        public j() {
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends k0 {
        private static final int CTRL_INDEX = 837;
        private static final String NAME = "onXWebVideoSeekComplete";

        public k() {
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l extends k0 {
        private static final int CTRL_INDEX = 544;
        private static final String NAME = "onXWebVideoTimeUpdate";

        public l() {
        }

        public /* synthetic */ l(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends k0 {
        private static final int CTRL_INDEX = 540;
        private static final String NAME = "onXWebVideoWaiting";

        public m() {
        }

        public /* synthetic */ m(a aVar) {
            this();
        }
    }

    public final void c() {
        AppBrandInvokeContext appBrandInvokeContext;
        w.a("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart");
        if (this.f121482a != null && (appBrandInvokeContext = this.f121483b) != null) {
            com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(appBrandInvokeContext);
            if (a16 == null) {
                w.f("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, audioOfVideoBackgroundPlayManager is null");
                return;
            } else {
                a16.d(this.f121482a);
                return;
            }
        }
        w.f("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayStart, mPluginHandler or mInvokeContext is null");
    }

    public final void d() {
        c0.a(new a());
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void destroy() {
        g();
    }

    public final void e() {
        w.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer");
        if (this.f121486e == null) {
            w.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
            this.f121486e = new e0("AppBrandVideoEventHandler_HandlerThread#" + hashCode(), new e0.a() { // from class: com.tencent.luggage.wxa.ai.l
                @Override // com.tencent.luggage.wxa.tn.e0.a
                public final boolean a() {
                    boolean b16;
                    b16 = e.this.b();
                    return b16;
                }
            }, true);
        }
        e0 e0Var = this.f121486e;
        if (e0Var != null) {
            e0Var.a(0L, 250L);
        }
        AppBrandInvokeContext appBrandInvokeContext = this.f121483b;
        if (appBrandInvokeContext != null && o.a(appBrandInvokeContext.getAppId())) {
            w.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "startUpdateTimer, send play event");
            new com.tencent.luggage.wxa.vg.a().c();
        }
    }

    public final void f() {
        c0.a(new b());
    }

    public final void g() {
        w.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
        e0 e0Var = this.f121486e;
        if (e0Var != null) {
            e0Var.f();
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void onBackgroundPlaybackChange(boolean z16) {
        try {
            JSONObject a16 = a();
            a16.put("playInBackground", z16);
            a(new c(null), a16);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoBackgroundPlaybackChange fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void onVideoEnded() {
        try {
            a(new d(null), a());
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", e16);
        }
        g();
        f();
        c(true);
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void onVideoWaiting() {
        this.f121488g = true;
        try {
            JSONObject a16 = a();
            a16.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, System.currentTimeMillis());
            a(new m(null), a16);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", e16);
        }
        x xVar = this.f121490i;
        if (xVar != null) {
            xVar.j();
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void a(com.tencent.luggage.wxa.i8.e eVar) {
        this.f121482a = eVar;
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void b(boolean z16) {
        try {
            a(new g(null), a());
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", e16);
        }
        g();
        f();
        c(false);
        x xVar = this.f121490i;
        if (xVar != null) {
            if (!z16) {
                xVar.onPause();
            } else {
                xVar.onStop();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void a(com.tencent.luggage.wxa.z7.c cVar) {
        if (cVar instanceof AppBrandInvokeContext) {
            this.f121483b = (AppBrandInvokeContext) cVar;
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void a(boolean z16) {
        this.f121488g = false;
        try {
            this.f121485d = 0;
            JSONObject a16 = a();
            a16.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, System.currentTimeMillis());
            a(new h(null), a16);
            e();
            d();
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", e16);
        }
        c();
        x xVar = this.f121490i;
        if (xVar != null) {
            xVar.a(z16);
        }
    }

    public final void c(boolean z16) {
        AppBrandInvokeContext appBrandInvokeContext;
        w.a("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop");
        if (this.f121482a != null && (appBrandInvokeContext = this.f121483b) != null) {
            com.tencent.luggage.wxa.ph.a a16 = com.tencent.luggage.wxa.a8.e.a(appBrandInvokeContext);
            if (a16 == null) {
                w.f("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, audioOfVideoBackgroundPlayManager is null");
                return;
            } else {
                a16.b(this.f121482a, z16);
                return;
            }
        }
        w.f("MicroMsg.SameLayer.AppBrandVideoEventHandler", "markVideoPlayPauseOrStop, pluginHandler or invokeContext is null");
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void b(int i3) {
        this.f121488g = false;
        e0 e0Var = this.f121486e;
        if (e0Var != null && e0Var.g() && this.f121482a != null) {
            w.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoSeekComplete, dispatch onVideoTimeUpdate");
            a(this.f121482a.h(), (int) (this.f121484c * 1000.0d));
        }
        try {
            JSONObject a16 = a();
            a16.put("position", i3);
            a(new k(null), a16);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoSeekComplete fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void a(int i3) {
        try {
            JSONObject a16 = a();
            a16.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, i3);
            a(new j(null), a16);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b() {
        com.tencent.luggage.wxa.i8.e eVar = this.f121482a;
        if (eVar == null) {
            return true;
        }
        a(eVar.h(), (int) (this.f121484c * 1000.0d));
        return true;
    }

    public void a(int i3, int i16) {
        if (this.f121488g) {
            w.a("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onVideoTimeUpdate, video waiting");
            return;
        }
        try {
            if (Math.abs(i3 - this.f121485d) < 250) {
                return;
            }
            com.tencent.luggage.wxa.i8.b bVar = this.f121489h;
            if (bVar != null) {
                bVar.a(i3, i16);
            }
            this.f121485d = i3;
            double doubleValue = new BigDecimal((i3 * 1.0d) / 1000.0d).setScale(3, 4).doubleValue();
            JSONObject a16 = a();
            a16.put("position", doubleValue);
            a16.put("duration", (i16 * 1.0d) / 1000.0d);
            a(new l(null), a16);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void a(String str, int i3, int i16) {
        g();
        f();
        try {
            JSONObject a16 = a();
            a16.put("errMsg", String.format(Locale.US, "%s(%d,%d)", str, Integer.valueOf(i3), Integer.valueOf(i16)));
            a(new C6016e(null), a16);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", e16);
        }
        c(true);
        x xVar = this.f121490i;
        if (xVar != null) {
            xVar.a();
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void a(int i3, int i16, int i17) {
        try {
            JSONObject a16 = a();
            a16.put("width", i3);
            a16.put("height", i16);
            double d16 = (i17 * 1.0d) / 1000.0d;
            this.f121484c = d16;
            a16.put("duration", d16);
            a(new f(null), a16);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void a(long j3) {
        try {
            JSONObject a16 = a();
            a16.put("preloadSize", j3);
            a(new i(null), a16);
        } catch (JSONException e16) {
            w.b("MicroMsg.SameLayer.AppBrandVideoEventHandler", "onXWebVideoPreloadedMetaData fail", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public void a(String str) {
        this.f121487f = str;
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public synchronized void a(com.tencent.luggage.wxa.i8.b bVar) {
        this.f121489h = bVar;
    }

    @Override // com.tencent.luggage.wxa.j8.d
    public synchronized void a(x xVar) {
        this.f121490i = xVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.f121487f);
        return jSONObject;
    }

    public final void a(k0 k0Var, JSONObject jSONObject) {
        com.tencent.luggage.wxa.xd.d e16;
        if (k0Var != null) {
            if (!(k0Var instanceof l) && !(k0Var instanceof j)) {
                w.d("MicroMsg.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", k0Var.getName(), jSONObject.toString());
            }
            k0 data = k0Var.setData(jSONObject.toString());
            AppBrandInvokeContext appBrandInvokeContext = this.f121483b;
            if (appBrandInvokeContext == null || (e16 = appBrandInvokeContext.e()) == null) {
                return;
            }
            if (e16 instanceof com.tencent.luggage.wxa.ic.l) {
                com.tencent.luggage.wxa.ic.l lVar = (com.tencent.luggage.wxa.ic.l) e16;
                lVar.a(data, (int[]) null);
                v J = lVar.J();
                if (J != null) {
                    J.a(data, (int[]) null);
                    return;
                }
                return;
            }
            if (e16 instanceof v) {
                ((v) e16).a(data, (int[]) null);
            } else {
                e16.a(data, (int[]) null);
            }
        }
    }
}
