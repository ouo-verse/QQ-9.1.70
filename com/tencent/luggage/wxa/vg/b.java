package com.tencent.luggage.wxa.vg;

import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements g.c {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.mg.a f143480a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.f f143481b;

    /* renamed from: c, reason: collision with root package name */
    public e0 f143482c;

    /* renamed from: d, reason: collision with root package name */
    public int f143483d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e0.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            int currPosMs;
            try {
                currPosMs = b.this.f143480a.getCurrPosMs();
            } catch (JSONException e16) {
                w.b("MicroMsg.Video.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e16);
            }
            if (Math.abs(currPosMs - b.this.f143483d) < 250) {
                return true;
            }
            JSONObject f16 = b.this.f();
            b.this.f143483d = currPosMs;
            f16.put("position", new BigDecimal((currPosMs * 1.0d) / 1000.0d).setScale(3, 4).doubleValue());
            f16.put("duration", b.this.f143480a.getDuration());
            b.this.a(new j(null), f16);
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vg.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6848b extends k0 {
        private static final int CTRL_INDEX = 131;
        private static final String NAME = "onVideoClickDanmuBtn";

        public C6848b() {
        }

        public /* synthetic */ C6848b(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends k0 {
        private static final int CTRL_INDEX = 129;
        private static final String NAME = "onVideoEnded";

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends k0 {
        private static final int CTRL_INDEX = 349;
        private static final String NAME = "onVideoError";

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends k0 {
        private static final int CTRL_INDEX = 130;
        private static final String NAME = "onVideoFullScreenChange";

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends k0 {
        private static final int CTRL_INDEX = 628;
        private static final String NAME = "onVideoLoadedMetaData";

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends k0 {
        private static final int CTRL_INDEX = 128;
        private static final String NAME = "onVideoPause";

        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends k0 {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoPlay";

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends k0 {
        private static final int CTRL_INDEX = 548;
        private static final String NAME = "onVideoProgress";

        public i() {
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends k0 {
        private static final int CTRL_INDEX = 138;
        private static final String NAME = "onVideoTimeUpdate";

        public j() {
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends k0 {
        private static final int CTRL_INDEX = 350;
        private static final String NAME = "onVideoWaiting";

        public k() {
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    public b(com.tencent.luggage.wxa.mg.a aVar, com.tencent.luggage.wxa.xd.f fVar) {
        this.f143480a = aVar;
        this.f143481b = fVar;
        fVar.a(this);
    }

    public void d() {
        this.f143481b.b(this);
        m();
    }

    public final JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.f143480a.getCookieData());
        return jSONObject;
    }

    public void g() {
        try {
            a(new c(null), f());
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "OnVideoEnded e=%s", e16);
        }
        m();
    }

    public void h() {
        try {
            a(new g(null), f());
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "OnVideoPause e=%s", e16);
        }
        m();
    }

    public void i() {
        try {
            this.f143483d = 0;
            JSONObject f16 = f();
            f16.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, System.currentTimeMillis());
            a(new h(null), f16);
            l();
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "OnVideoPlay e=%s", e16);
        }
    }

    public void k() {
        try {
            JSONObject f16 = f();
            f16.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, System.currentTimeMillis());
            a(new k(null), f16);
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "onVideoWaiting e=%s", e16);
        }
    }

    public final void l() {
        if (this.f143482c == null) {
            this.f143482c = new e0(new a(), true);
        }
        this.f143482c.a(250L);
    }

    public final void m() {
        e0 e0Var = this.f143482c;
        if (e0Var != null) {
            e0Var.f();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.g.c
    public void onDestroy() {
        w.a("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
        d();
        this.f143480a.setCallback(null);
    }

    public void a(String str, int i3, int i16) {
        d();
        try {
            JSONObject f16 = f();
            f16.put("errMsg", str);
            a(new d(null), f16);
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "onError e=%s", e16);
        }
    }

    public void a(int i3, boolean z16, int i16) {
        try {
            w.d("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
            JSONObject f16 = f();
            f16.put("fullScreen", z16);
            f16.put("videoPlayerId", i3);
            f16.put("direction", i16);
            a(new e(null), f16);
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", e16);
        }
    }

    public void a(int i3, boolean z16) {
        try {
            w.d("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", Boolean.valueOf(z16));
            JSONObject f16 = f();
            f16.put("showDanmu", z16);
            f16.put("videoPlayerId", i3);
            a(new C6848b(null), f16);
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", e16);
        }
    }

    public void a(int i3, int i16) {
        try {
            w.d("MicroMsg.Video.JsApiVideoCallback", "onVideoCacheUpdate, percent:%d, duration:%s", Integer.valueOf(i3), Integer.valueOf(i16));
            JSONObject f16 = f();
            f16.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, i3);
            f16.put("duration", i16);
            a(new i(null), f16);
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "onVideoCacheUpdate e=%s", e16);
        }
    }

    public void j() {
    }

    public void a(int i3, int i16, int i17) {
        try {
            w.d("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            JSONObject f16 = f();
            f16.put("width", i3);
            f16.put("height", i16);
            f16.put("duration", (i17 * 1.0d) / 1000.0d);
            a(new f(null), f16);
        } catch (JSONException e16) {
            w.b("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", e16);
        }
    }

    public final void a(k0 k0Var, JSONObject jSONObject) {
        if (!(k0Var instanceof j) && !(k0Var instanceof i)) {
            w.d("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", k0Var.getName());
        }
        this.f143481b.a(k0Var.setData(jSONObject.toString()), (int[]) null);
    }
}
