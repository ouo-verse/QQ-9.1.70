package com.tencent.luggage.wxa.ai;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.a8.x;
import com.tencent.luggage.wxa.ag.h;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.wxa.i8.e;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.p004if.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xg.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k implements com.tencent.luggage.wxa.ag.h {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.i8.e f121508a;

    /* renamed from: b, reason: collision with root package name */
    public d f121509b = new d(this, null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.i8.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.i8.b
        public void a(int i3, int i16) {
            if (k.this.f121509b.f121515b != null) {
                float f16 = (i3 * 100.0f) / i16;
                int i17 = i16 - i3;
                if (f16 >= 99.0f && i17 <= 1000) {
                    k.this.f121509b.f121515b.e(k.this.f121509b);
                } else {
                    k.this.f121509b.f121515b.a(k.this.f121509b, f16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h.a f121512a;

        public c(h.a aVar) {
            this.f121512a = aVar;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            w.d("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, value: " + str);
            try {
                k.this.f121508a.updateVideoPosition(new JSONObject(str));
                this.f121512a.a(k.this.f121508a.getVideoPositionX(), k.this.f121508a.getVideoPositionY());
            } catch (JSONException unused) {
                w.f("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, parse " + str + " failed");
                this.f121512a.a(k.this.f121508a.getVideoPositionX(), k.this.f121508a.getVideoPositionY());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.ag.j {

        /* renamed from: a, reason: collision with root package name */
        public final String f121514a;

        /* renamed from: b, reason: collision with root package name */
        public j.a f121515b;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f121516c;

        /* renamed from: d, reason: collision with root package name */
        public g.f f121517d;

        /* renamed from: e, reason: collision with root package name */
        public g.InterfaceC6908g f121518e;

        /* renamed from: f, reason: collision with root package name */
        public g.b f121519f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements g.f {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.xg.g.f
            public void a(com.tencent.luggage.wxa.xg.g gVar) {
                d.this.f121516c = true;
                if (d.this.f121515b != null) {
                    w.d(d.this.f121514a, "onLoadEnd from OnPreparedListener");
                    d.this.f121515b.d(d.this);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements g.InterfaceC6908g {
            public b() {
            }

            @Override // com.tencent.luggage.wxa.xg.g.InterfaceC6908g
            public void a(com.tencent.luggage.wxa.xg.g gVar) {
                if (d.this.f121515b != null) {
                    w.d(d.this.f121514a, "onLoadEnd from OnSeekCompleteListener");
                    d.this.f121515b.d(d.this);
                    d.this.f121515b.a((com.tencent.luggage.wxa.ag.j) d.this, false);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements g.b {
            public c() {
            }

            @Override // com.tencent.luggage.wxa.xg.g.b
            public void a(com.tencent.luggage.wxa.xg.g gVar) {
                if (d.this.f121515b != null) {
                    d.this.f121515b.a(d.this);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ai.k$d$d, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6017d implements e.n0 {
            public C6017d() {
            }

            @Override // com.tencent.luggage.wxa.i8.e.n0
            public void a(boolean z16) {
                com.tencent.luggage.wxa.xg.h b16 = k.this.b();
                if (b16 != null) {
                    d.this.f121516c = z16;
                    b16.b(d.this.f121517d);
                    b16.b(d.this.f121518e);
                    b16.b(d.this.f121519f);
                }
            }
        }

        public d() {
            this.f121514a = "MicroMsg.AppBrand.XWebVideoVideoController#" + hashCode();
            this.f121515b = null;
            this.f121516c = false;
            this.f121517d = new a();
            this.f121518e = new b();
            this.f121519f = new c();
            k.this.f121508a.a(new C6017d());
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public r g() {
            return com.tencent.luggage.wxa.p004if.g.f130201b.a(k.this.f121508a.isAutoPauseIfNavigate(), k.this.f121508a.isAutoPauseIfOpenNative());
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public String getKey() {
            return k.this.f121508a.getKey();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public j.b getType() {
            return j.b.Video;
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public int getVideoHeight() {
            com.tencent.luggage.wxa.xg.h b16 = k.this.b();
            if (b16 == null) {
                return 0;
            }
            return b16.getVideoHeight();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public int getVideoWidth() {
            com.tencent.luggage.wxa.xg.h b16 = k.this.b();
            if (b16 == null) {
                return 0;
            }
            return b16.getVideoWidth();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public void pause() {
            w.a(this.f121514a, "pause");
            k.this.f121508a.pauseExternal();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public void release() {
            w.a(this.f121514a, "release");
            k.this.f121508a.releaseExternal();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public void start() {
            w.a(this.f121514a, "start");
            k.this.f121508a.playExternal();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public boolean c() {
            return k.this.f121508a.isBackgroundPlayAudioEnabled();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public Integer d() {
            Integer originPageViewId = k.this.f121508a.getOriginPageViewId();
            w.a("MicroMsg.AppBrand.XWebVideoVideoController", "getOriginPageViewId, originPageViewId: " + originPageViewId);
            return originPageViewId;
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public void a(j.a aVar) {
            if (aVar != null) {
                if (!this.f121516c) {
                    w.d(this.f121514a, "onLoading from mPrepared");
                    aVar.f(this);
                } else {
                    w.d(this.f121514a, "onLoadEnd from mPrepared");
                    aVar.d(this);
                }
            }
            this.f121515b = aVar;
        }

        public /* synthetic */ d(k kVar, a aVar) {
            this();
        }
    }

    public k(com.tencent.luggage.wxa.i8.e eVar) {
        this.f121508a = eVar;
        eVar.a(new a());
        eVar.setOnPlayListener(new b());
    }

    public Surface c() {
        return this.f121508a.getSurface();
    }

    public SurfaceTexture d() {
        return this.f121508a.getSurfaceTexture();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public Point e() {
        return new Point(this.f121508a.getVideoPositionX(), this.f121508a.getVideoPositionY());
    }

    public float f() {
        return this.f121508a.t();
    }

    public boolean g() {
        return this.f121508a.isJustPlayAudio();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public com.tencent.luggage.wxa.ag.j h() {
        return this.f121509b;
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public int i() {
        return this.f121508a.m();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public boolean isPlaying() {
        return this.f121508a.isPlaying();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public int k() {
        return this.f121508a.l();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements x {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.a8.x
        public void a(boolean z16) {
            if (k.this.f121509b.f121515b != null) {
                k.this.f121509b.f121515b.a(k.this.f121509b, z16);
            }
        }

        @Override // com.tencent.luggage.wxa.a8.x
        public void b() {
            if (k.this.f121509b.f121515b != null) {
                w.d("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoadEnd from XWebOnPlayListener");
                k.this.f121509b.f121515b.d(k.this.f121509b);
            }
        }

        @Override // com.tencent.luggage.wxa.a8.x
        public void f() {
            if (k.this.f121509b.f121515b != null) {
                k.this.f121509b.f121515b.a(k.this.f121509b);
            }
        }

        @Override // com.tencent.luggage.wxa.a8.x
        public void j() {
            if (k.this.f121509b.f121515b != null) {
                w.d("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "onLoading from XWebOnPlayListener");
                k.this.f121509b.f121515b.f(k.this.f121509b);
            }
        }

        @Override // com.tencent.luggage.wxa.a8.x
        public void onPause() {
            if (k.this.f121509b.f121515b != null) {
                k.this.f121509b.f121515b.g(k.this.f121509b);
            }
        }

        @Override // com.tencent.luggage.wxa.a8.x
        public void onStop() {
            if (k.this.f121509b.f121515b != null) {
                k.this.f121509b.f121515b.c(k.this.f121509b);
            }
        }

        @Override // com.tencent.luggage.wxa.a8.x
        public void a() {
            if (k.this.f121509b.f121515b != null) {
                k.this.f121509b.f121515b.b(k.this.f121509b);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public void a(v vVar, h.a aVar) {
        com.tencent.luggage.wxa.ei.j jsRuntime = vVar.getJsRuntime();
        if (jsRuntime == null) {
            w.f("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
            aVar.a(this.f121508a.getVideoPositionX(), this.f121508a.getVideoPositionY());
            return;
        }
        String str = "document.querySelector('embed[embed-id=\"" + this.f121508a.getId() + "\"]').getBoundingClientRect().toJSON()";
        w.d("MicroMsg.AppBrand.XWebVideoOriginVideoContainer", "getVideoPositionAsync, jsScript: " + str);
        jsRuntime.evaluateJavascript(str, new c(aVar));
    }

    public com.tencent.luggage.wxa.xg.h b() {
        com.tencent.luggage.wxa.xg.g k3 = this.f121508a.k();
        if (k3 instanceof com.tencent.luggage.wxa.xg.h) {
            return (com.tencent.luggage.wxa.xg.h) k3;
        }
        return null;
    }

    public boolean a(Surface surface) {
        return this.f121508a.setSurface(surface);
    }

    public float a() {
        return this.f121508a.q();
    }

    public void a(e.m0 m0Var) {
        this.f121508a.a(m0Var);
    }
}
