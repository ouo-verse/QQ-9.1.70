package com.tencent.luggage.wxa.ph;

import android.util.ArrayMap;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.a8.j;
import com.tencent.luggage.wxa.a8.n;
import com.tencent.luggage.wxa.a8.o;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.th.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uc.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends h {

    /* renamed from: a, reason: collision with root package name */
    public final g f137572a;

    /* renamed from: b, reason: collision with root package name */
    public final String f137573b;

    /* renamed from: c, reason: collision with root package name */
    public final c f137574c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f137575d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f137576e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f137577f = true;

    /* renamed from: g, reason: collision with root package name */
    public volatile j f137578g = null;

    /* renamed from: h, reason: collision with root package name */
    public final Object f137579h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public boolean f137580i = false;

    /* renamed from: j, reason: collision with root package name */
    public final Map f137581j = new ArrayMap();

    /* renamed from: k, reason: collision with root package name */
    public final List f137582k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final List f137583l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final LinkedList f137584m = new LinkedList();
    public AtomicBoolean C = new AtomicBoolean(false);
    public AtomicBoolean D = new AtomicBoolean(false);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ph.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6601a extends e.c {
        public C6601a() {
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onCreate() {
            super.onCreate();
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
            a.this.f137575d = false;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            super.onDestroy();
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            a.this.b();
            e.b(a.this.f137573b, this);
            a.this.f137576e.clear();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            super.onPause(dVar);
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onPause, type: " + dVar);
            a.this.a(dVar);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            super.onResume();
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
            a.this.o();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f137586a;

        public b(String str) {
            this.f137586a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(z.c(), this.f137586a, 0).show();
        }
    }

    public a(g gVar) {
        this.f137572a = gVar;
        String appId = gVar.getAppId();
        this.f137573b = appId;
        this.f137574c = new c(this);
        this.f137575d = !gVar.B0();
        e.a(appId, new C6601a());
    }

    public j d() {
        j jVar = this.f137578g;
        if (jVar == null || !this.D.get()) {
            return jVar;
        }
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBackgroundAudioPlayer, ignore");
        return null;
    }

    public void e(j jVar) {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, videoPlayer:" + jVar.getName());
        synchronized (this.f137579h) {
            this.f137582k.remove(jVar);
            this.f137583l.remove(jVar);
            this.f137584m.remove(jVar);
        }
        if (d() == jVar) {
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayerRelease, disableAppBrandBackgroundRun");
            b();
            if (!this.f137577f) {
                this.f137574c.a();
                this.f137578g = null;
            }
        }
    }

    public final boolean f(j jVar) {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, videoPlayer:" + jVar.getName());
        o oVar = (o) jVar.getAddOn(o.class);
        if (oVar == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pausePlay, playerAddOnVideoController is null");
            return false;
        }
        oVar.pause();
        return true;
    }

    public final boolean g(j jVar) {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayer:" + jVar.getName());
        n nVar = (n) jVar.getAddOn(n.class);
        if (nVar == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio, videoPlayerAddOnPlayAudio is null");
            return false;
        }
        nVar.playAudio();
        d(jVar);
        return true;
    }

    public final void h(j jVar) {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayer:" + jVar.getName());
        n nVar = (n) jVar.getAddOn(n.class);
        if (nVar == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playVideo, videoPlayerAddOnPlayAudio is null");
        } else {
            nVar.playVideo();
            d(jVar);
        }
    }

    public boolean i() {
        w.a("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isBackgroundAudioPlayPaused: " + this.f137577f);
        return this.f137577f;
    }

    public boolean j() {
        return this.f137580i;
    }

    public boolean k() {
        j d16 = d();
        if (d16 == null) {
            return true;
        }
        o oVar = (o) d16.getAddOn(o.class);
        if (oVar == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
            return true;
        }
        return oVar.isPlaying();
    }

    public final void l() {
        Iterator it = new ArrayList(this.f137576e).iterator();
        if (!it.hasNext()) {
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(it.next());
        throw null;
    }

    public final void m() {
        Iterator it = new ArrayList(this.f137576e).iterator();
        if (!it.hasNext()) {
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(it.next());
        throw null;
    }

    public final void n() {
        Iterator it = new ArrayList(this.f137576e).iterator();
        if (!it.hasNext()) {
            return;
        }
        com.tencent.luggage.wxa.k0.d.a(it.next());
        throw null;
    }

    public final void o() {
        this.f137575d = false;
        if (this.C.getAndSet(false)) {
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeForeground, ignore");
            return;
        }
        j d16 = d();
        if (d16 == null) {
            return;
        }
        if (k()) {
            h(d16);
        }
        this.f137577f = false;
        this.f137574c.a();
        this.f137578g = null;
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeForeground, disableAppBrandBackgroundRun");
        b();
    }

    public void p() {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay");
        j d16 = d();
        if (d16 == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "pauseBackgroundAudioPlay, mBackgroundAudioPlayer is null");
        } else if (f(d16)) {
            this.f137577f = true;
            l();
        }
    }

    public void q() {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay");
        j d16 = d();
        if (d16 == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startBackgroundAudioPlay, backgroundAudioPlayer is null");
        } else if (i(d16)) {
            this.f137577f = false;
            this.f137574c.c();
            m();
        }
    }

    public void r() {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay");
        j d16 = d();
        if (d16 == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "stopBackgroundAudioPlay, backgroundAudioPlayer is null");
            return;
        }
        if (f(d16)) {
            this.f137577f = false;
            this.f137574c.a();
        }
        l();
    }

    public void b(j jVar) {
        boolean z16;
        boolean z17;
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableBackgroundPlayAudio, videoPlayer:" + jVar.getName());
        synchronized (this.f137579h) {
            this.f137581j.remove(jVar);
            j d16 = d();
            z16 = false;
            if (!this.f137584m.contains(jVar) && d16 != jVar) {
                this.f137582k.remove(jVar);
                z17 = false;
            }
            if (!this.f137575d) {
                this.f137584m.remove(jVar);
            }
            z17 = true;
            if (d16 == jVar) {
                z16 = true;
                z17 = false;
            }
        }
        if (z16) {
            r();
            if (!this.f137575d) {
                b();
                this.f137578g = null;
            }
            this.f137574c.a();
        }
        if (z17) {
            h(jVar);
        }
    }

    public final void c() {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableAppBrandBackgroundRun");
        com.tencent.luggage.wxa.th.a aVar = new com.tencent.luggage.wxa.th.a();
        a.C6755a c6755a = aVar.f141319d;
        c6755a.f141320a = this.f137573b;
        c6755a.f141321b = 64;
        c6755a.f141322c = 1;
        aVar.c();
        a(true);
    }

    @Override // com.tencent.luggage.wxa.uc.h
    public boolean a() {
        boolean z16;
        synchronized (this.f137579h) {
            z16 = !this.f137584m.isEmpty();
        }
        return z16;
    }

    public final boolean i(j jVar) {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, videoPlayer:" + jVar.getName());
        o oVar = (o) jVar.getAddOn(o.class);
        if (oVar == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "startPlay, playerAddOnVideoController is null");
            return false;
        }
        oVar.start();
        return true;
    }

    public void d(j jVar) {
        boolean z16;
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayStart, videoPlayer:" + jVar.getName());
        synchronized (this.f137579h) {
            if (this.f137582k.contains(jVar)) {
                this.f137582k.remove(jVar);
                this.f137584m.remove(jVar);
                this.f137584m.addFirst(jVar);
                z16 = true;
            } else {
                this.f137583l.remove(jVar);
                this.f137583l.add(jVar);
                z16 = false;
            }
        }
        if (this.f137575d && z16 && c(jVar)) {
            g(jVar);
        }
        if (!this.f137575d || d() == null) {
            return;
        }
        c();
    }

    public final String f() {
        com.tencent.luggage.wxa.k0.d.a(this.f137572a.c(com.tencent.luggage.wxa.xh.c.class));
        w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "getBanBackgroundRunHint, helper is null");
        return null;
    }

    public boolean a(j jVar) {
        boolean z16;
        boolean z17;
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, videoPlayer: " + jVar.getName() + ", pauseType: " + e.d(this.f137573b));
        synchronized (this.f137579h) {
            z16 = false;
            z17 = !this.f137584m.isEmpty() && jVar == this.f137584m.getFirst();
        }
        if (z17 && this.D.getAndSet(false)) {
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, ignore");
        } else {
            z16 = z17;
        }
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "amIBackgroundAudioPlayer, amIBackgroundAudioPlayer: " + z16);
        return z16;
    }

    public g h() {
        return this.f137572a;
    }

    public final boolean c(j jVar) {
        Boolean bool;
        synchronized (this.f137579h) {
            bool = (Boolean) this.f137581j.get(jVar);
        }
        return bool != null && bool.booleanValue();
    }

    public boolean a(j jVar, boolean z16) {
        boolean z17 = false;
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, videoPlayer: %s, playAudioImmediate: %b", jVar.getName(), Boolean.valueOf(z16));
        if (this.f137575d) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "enableBackgroundPlayAudio, current is in background");
            return false;
        }
        this.f137580i = true;
        synchronized (this.f137579h) {
            this.f137581j.put(jVar, Boolean.valueOf(z16));
            if (this.f137583l.contains(jVar)) {
                this.f137583l.remove(jVar);
                this.f137584m.remove(jVar);
                this.f137584m.addFirst(jVar);
                z17 = true;
            } else {
                this.f137582k.remove(jVar);
                this.f137582k.add(jVar);
            }
        }
        if (z17 && z16) {
            g(jVar);
        }
        return true;
    }

    public void b(j jVar, boolean z16) {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, videoPlayer:" + jVar.getName());
        synchronized (this.f137579h) {
            if (z16) {
                if (this.f137584m.contains(jVar)) {
                    this.f137584m.remove(jVar);
                    this.f137582k.add(jVar);
                } else {
                    this.f137583l.remove(jVar);
                }
            } else {
                this.f137582k.add(jVar);
            }
        }
        if (d() == jVar) {
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "markVideoPlayPauseOrStop, disableAppBrandBackgroundRun");
            if (this.f137577f) {
                return;
            }
            this.f137574c.a();
        }
    }

    public void a(e.d dVar) {
        j jVar;
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, pauseType: " + dVar);
        this.f137575d = true;
        j d16 = d();
        if (d16 != null) {
            n();
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer: " + d16.getName());
            return;
        }
        synchronized (this.f137579h) {
            if (!this.f137584m.isEmpty() && (jVar = (j) this.f137584m.getFirst()) != null) {
                this.f137578g = jVar;
                String f16 = f();
                if (!w0.c(f16)) {
                    w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, ban");
                    r();
                    com.tencent.luggage.wxa.zp.h.f146825d.a(new b(f16));
                    return;
                }
                this.f137577f = false;
                w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "isEnableFloatBall:%b", Boolean.valueOf(this.f137580i));
                if (this.f137580i) {
                    if (k()) {
                        if (g(jVar)) {
                            this.f137574c.c();
                        } else {
                            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "playAudio fail");
                        }
                    }
                    w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, enableAppBrandBackgroundRun");
                    c();
                    return;
                }
                r();
                return;
            }
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onRuntimeBackground, backgroundAudioPlayer is null");
        }
    }

    public void b() {
        w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "disableAppBrandBackgroundRun");
        com.tencent.luggage.wxa.th.a aVar = new com.tencent.luggage.wxa.th.a();
        a.C6755a c6755a = aVar.f141319d;
        c6755a.f141320a = this.f137573b;
        c6755a.f141321b = 64;
        c6755a.f141322c = 2;
        aVar.c();
    }

    public void a(boolean z16) {
        j d16 = d();
        if (d16 == null) {
            return;
        }
        o oVar = (o) d16.getAddOn(o.class);
        if (oVar == null) {
            w.f("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onBackgroundPlaybackChange, playerAddOnVideoController is null");
        } else {
            w.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onBackgroundPlaybackChange playInBackground:%b", Boolean.valueOf(z16));
            oVar.onBackgroundPlaybackChange(z16);
        }
    }
}
