package com.tencent.luggage.wxa.uh;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.a8.x;
import com.tencent.luggage.wxa.ag.h;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.p004if.g;
import com.tencent.luggage.wxa.p004if.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.liveplayer.LivePlayerPluginHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements h {

    /* renamed from: a, reason: collision with root package name */
    public final LivePlayerPluginHandler f142400a;

    /* renamed from: b, reason: collision with root package name */
    public b f142401b = new b(this, null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h.a f142402a;

        public a(h.a aVar) {
            this.f142402a = aVar;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            w.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, value: " + str);
            try {
                c.this.f142400a.updateVideoPosition(new JSONObject(str));
                this.f142402a.a(c.this.f142400a.getVideoPositionX(), c.this.f142400a.getVideoPositionY());
            } catch (JSONException unused) {
                w.f("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, parse " + str + " failed");
                this.f142402a.a(c.this.f142400a.getVideoPositionX(), c.this.f142400a.getVideoPositionY());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements j {

        /* renamed from: a, reason: collision with root package name */
        public j.a f142404a;

        /* renamed from: b, reason: collision with root package name */
        public int f142405b;

        /* renamed from: c, reason: collision with root package name */
        public x f142406c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements x {
            public a() {
            }

            @Override // com.tencent.luggage.wxa.a8.x
            public void a() {
            }

            @Override // com.tencent.luggage.wxa.a8.x
            public void b() {
                if (b.this.f142404a == null) {
                    b.this.f142405b = 1;
                } else {
                    b.this.f142404a.d(b.this);
                }
            }

            @Override // com.tencent.luggage.wxa.a8.x
            public void f() {
                if (b.this.f142404a == null) {
                    b.this.f142405b = 7;
                } else {
                    b.this.f142404a.a(b.this);
                }
            }

            @Override // com.tencent.luggage.wxa.a8.x
            public void j() {
                if (b.this.f142404a == null) {
                    b.this.f142405b = 0;
                } else {
                    b.this.f142404a.f(b.this);
                }
            }

            @Override // com.tencent.luggage.wxa.a8.x
            public void onPause() {
                if (b.this.f142404a == null) {
                    b.this.f142405b = 4;
                } else {
                    b.this.f142404a.g(b.this);
                }
            }

            @Override // com.tencent.luggage.wxa.a8.x
            public void onStop() {
                if (b.this.f142404a == null) {
                    b.this.f142405b = 4;
                } else {
                    b.this.f142404a.g(b.this);
                }
            }

            @Override // com.tencent.luggage.wxa.a8.x
            public void a(boolean z16) {
                if (b.this.f142404a != null) {
                    b.this.f142404a.a(b.this, z16);
                } else {
                    b.this.f142405b = z16 ? 2 : 3;
                }
            }
        }

        public b() {
            this.f142404a = null;
            this.f142405b = -1;
            this.f142406c = new a();
            c.this.f142400a.setOnPlayListener(this.f142406c);
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public boolean c() {
            return c.this.f142400a.isBackgroundPlayAudioEnabled();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public Integer d() {
            Integer originPageViewId = c.this.f142400a.getOriginPageViewId();
            w.a("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getOriginPageViewId, originPageViewId: " + originPageViewId);
            return originPageViewId;
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public r g() {
            return g.f130201b.a(c.this.f142400a.isAutoPauseIfNavigate(), c.this.f142400a.isAutoPauseIfOpenNative());
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public String getKey() {
            String key = c.this.f142400a.getKey();
            w.a("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getKey, key: " + key);
            return key;
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public j.b getType() {
            return j.b.LivePlayer;
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public int getVideoHeight() {
            return -1;
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public int getVideoWidth() {
            return -1;
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public void pause() {
            c.this.f142400a.stopExternal();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public void release() {
            c.this.f142400a.releaseExternal();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public void start() {
            c.this.f142400a.playExternal();
        }

        @Override // com.tencent.luggage.wxa.ag.j
        public void a(j.a aVar) {
            this.f142404a = aVar;
            if (aVar != null) {
                switch (this.f142405b) {
                    case 0:
                        aVar.f(this);
                        return;
                    case 1:
                        aVar.d(this);
                        return;
                    case 2:
                        aVar.d(this);
                        aVar.a((j) this, true);
                        return;
                    case 3:
                        aVar.d(this);
                        aVar.a((j) this, false);
                        return;
                    case 4:
                        aVar.g(this);
                        return;
                    case 5:
                        aVar.b(this);
                        return;
                    case 6:
                        aVar.c(this);
                        return;
                    case 7:
                        aVar.a(this);
                        return;
                    default:
                        return;
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    public c(LivePlayerPluginHandler livePlayerPluginHandler) {
        this.f142400a = livePlayerPluginHandler;
    }

    public Surface b() {
        return this.f142400a.getSurface();
    }

    public SurfaceTexture c() {
        return this.f142400a.getSurfaceTexture();
    }

    public boolean d() {
        return this.f142400a.isJustPlayAudio();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public Point e() {
        return new Point(this.f142400a.getVideoPositionX(), this.f142400a.getVideoPositionY());
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public j h() {
        return this.f142401b;
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public int i() {
        return this.f142400a.getHtmlWidth();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public boolean isPlaying() {
        com.tencent.luggage.wxa.d8.a a16 = a();
        if (a16 == null) {
            return false;
        }
        return a16.isPlaying();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public int k() {
        return this.f142400a.getHtmlHeight();
    }

    @Override // com.tencent.luggage.wxa.ag.h
    public void a(v vVar, h.a aVar) {
        com.tencent.luggage.wxa.ei.j jsRuntime = vVar.getJsRuntime();
        if (jsRuntime == null) {
            w.f("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, null == jsRuntime");
            aVar.a(this.f142400a.getVideoPositionX(), this.f142400a.getVideoPositionY());
            return;
        }
        String str = "document.querySelector('embed[embed-id=\"" + this.f142400a.getId() + "\"]').getBoundingClientRect().toJSON()";
        w.d("MicroMsg.AppBrand.XWebLivePlayerOriginVideoContainer", "getVideoPositionAsync, jsScript: " + str);
        jsRuntime.evaluateJavascript(str, new a(aVar));
    }

    public com.tencent.luggage.wxa.d8.a a() {
        return this.f142400a.getAdapter();
    }

    public boolean a(Surface surface) {
        return this.f142400a.setSurface(surface);
    }

    public boolean a(int i3, int i16) {
        return this.f142400a.setSurfaceSize(i3, i16);
    }
}
