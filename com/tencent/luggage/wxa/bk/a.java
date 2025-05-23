package com.tencent.luggage.wxa.bk;

import android.media.AudioManager;
import android.os.Looper;
import com.tencent.luggage.wxa.fd.e0;
import com.tencent.luggage.wxa.hn.Cif;
import com.tencent.luggage.wxa.hn.e4;
import com.tencent.luggage.wxa.hn.f4;
import com.tencent.luggage.wxa.hn.hf;
import com.tencent.luggage.wxa.hn.jf;
import com.tencent.luggage.wxa.hn.kf;
import com.tencent.luggage.wxa.hn.mf;
import com.tencent.luggage.wxa.hn.mi;
import com.tencent.luggage.wxa.hn.nf;
import com.tencent.luggage.wxa.hn.oi;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Cif f122929a = null;

    /* renamed from: b, reason: collision with root package name */
    public hf f122930b = null;

    /* renamed from: c, reason: collision with root package name */
    public mf f122931c = null;

    /* renamed from: d, reason: collision with root package name */
    public nf f122932d = null;

    /* renamed from: e, reason: collision with root package name */
    public kf f122933e = null;

    /* renamed from: f, reason: collision with root package name */
    public mi f122934f = null;

    /* renamed from: g, reason: collision with root package name */
    public oi f122935g = null;

    /* renamed from: h, reason: collision with root package name */
    public b0 f122936h = new b0(Looper.getMainLooper());

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6077a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f122937a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f122938b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bk.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6078a implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.r1.a f122940a;

            public C6078a(com.tencent.luggage.wxa.r1.a aVar) {
                this.f122940a = aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(Boolean bool, com.tencent.luggage.wxa.bj.a aVar) {
                w.d("MicroMsg.AppBrandGameExtraConfigMgr", "hy: on get wxa game config resp: success?:%s, exception?:%s", bool, aVar);
                if (bool.booleanValue()) {
                    f4 b16 = this.f122940a.b();
                    a.this.f122931c = b16.f127601e;
                    a.this.f122932d = b16.f127602f;
                    a.this.f122933e = b16.f127603g;
                    a.this.f122934f = b16.f127604h;
                    a.this.f122935g = b16.f127605i;
                }
                b bVar = RunnableC6077a.this.f122938b;
                if (bVar != null) {
                    bVar.a(bool.booleanValue(), aVar);
                }
                return Unit.INSTANCE;
            }
        }

        public RunnableC6077a(com.tencent.luggage.wxa.ic.g gVar, b bVar) {
            this.f122937a = gVar;
            this.f122938b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            com.tencent.luggage.wxa.ic.g gVar = this.f122937a;
            if (gVar != null && gVar.h0() != null) {
                com.tencent.luggage.wxa.ic.g gVar2 = this.f122937a;
                if (gVar2 instanceof com.tencent.luggage.wxa.c5.e) {
                    i3 = ((com.tencent.luggage.wxa.c5.e) gVar2).S().I;
                } else {
                    i3 = 4;
                }
                w.d("MicroMsg.AppBrandGameExtraConfigMgr", "hy: trigger wxa game config update, appServiceType:%d", Integer.valueOf(i3));
                a.this.f122931c = null;
                a.this.f122932d = null;
                a.this.f122933e = null;
                a.this.f122934f = null;
                a.this.f122935g = null;
                if (!e0.b(i3)) {
                    com.tencent.luggage.wxa.r1.a a16 = a.this.a(this.f122937a);
                    a16.a(new C6078a(a16));
                    return;
                }
                return;
            }
            w.f("MicroMsg.AppBrandGameExtraConfigMgr", "hy: runtime is null!");
            b bVar = this.f122938b;
            if (bVar != null) {
                bVar.a(false, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z16, com.tencent.luggage.wxa.bj.a aVar);
    }

    public String b() {
        if (this.f122931c == null) {
            return "null";
        }
        return "WxaGameSampleConfig{SampleType=" + this.f122931c.f128209d + ", SampleIntervalInSeconds=" + this.f122931c.f128210e + ", FpsLagWindowSize=" + this.f122931c.f128211f + ", FpsLagWindowDiff=" + this.f122931c.f128212g + ", FpsLowThreshold=" + this.f122931c.f128213h + '}';
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar, b bVar) {
        this.f122936h.a((Runnable) new RunnableC6077a(gVar, bVar));
    }

    public final com.tencent.luggage.wxa.r1.a a(com.tencent.luggage.wxa.ic.g gVar) {
        com.tencent.luggage.wxa.r1.a aVar = new com.tencent.luggage.wxa.r1.a();
        if (gVar.h0().i() != null && gVar.h0().i().e() != null) {
            com.tencent.luggage.wxa.mc.j e16 = gVar.h0().i().e();
            Cif cif = new Cif();
            this.f122929a = cif;
            cif.f127901d = e16.getPkgAppVersion();
            this.f122929a.f127902e = e16.lastModified();
            this.f122929a.f127903f = 0;
        }
        if (gVar.j0() != null && gVar.j0().f125966l != null) {
            com.tencent.mm.plugin.appbrand.appcache.a aVar2 = gVar.j0().f125966l;
            hf hfVar = new hf();
            this.f122930b = hfVar;
            hfVar.f127803d = aVar2.f151861a;
            hfVar.f127804e = aVar2.pkgVersion;
            e L1 = ((com.tencent.luggage.wxa.c5.e) gVar).L1();
            if (L1 != null) {
                hf hfVar2 = this.f122930b;
                hfVar2.f127805f = L1.f122984c;
                hfVar2.f127807h = L1.f122982a;
                hfVar2.f127806g = 0;
            }
        }
        int streamVolume = SystemMethodProxy.getStreamVolume((AudioManager) gVar.F().getSystemService("audio"), 3);
        jf jfVar = new jf();
        jfVar.f127958d = streamVolume == 0;
        e4 a16 = aVar.a();
        a16.f127541e = gVar.getAppId();
        a16.f127543g = this.f122929a;
        a16.f127542f = this.f122930b;
        a16.f127544h = jfVar;
        return aVar;
    }

    public mf a() {
        return this.f122931c;
    }
}
