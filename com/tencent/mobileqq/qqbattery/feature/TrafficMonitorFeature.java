package com.tencent.mobileqq.qqbattery.feature;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.feature.e;
import i.e;

/* compiled from: P */
/* loaded from: classes16.dex */
public class TrafficMonitorFeature extends com.tencent.mobileqq.qqbattery.feature.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public a f262284e;

    /* renamed from: f, reason: collision with root package name */
    public a.a f262285f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a extends e.a<a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262287d;

        /* renamed from: e, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262288e;

        /* renamed from: f, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262289f;

        /* renamed from: g, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262290g;

        /* renamed from: h, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262291h;

        /* renamed from: i, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262292i;

        /* renamed from: j, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262293j;

        /* renamed from: k, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262294k;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqbattery.feature.TrafficMonitorFeature$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public class C8289a extends e.a.AbstractC8291a<a> {
            static IPatchRedirector $redirector_;

            public C8289a(a aVar, a aVar2) {
                super(aVar, aVar2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) aVar2);
                }
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.qqbattery.feature.e$a, com.tencent.mobileqq.qqbattery.feature.TrafficMonitorFeature$a] */
            @Override // com.tencent.mobileqq.qqbattery.feature.e.a.AbstractC8291a
            public final a a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (e.a) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                a aVar = new a();
                aVar.f262287d = f.b(((a) this.f262347a).f262287d, ((a) this.f262348b).f262287d);
                aVar.f262288e = f.b(((a) this.f262347a).f262288e, ((a) this.f262348b).f262288e);
                aVar.f262289f = f.b(((a) this.f262347a).f262289f, ((a) this.f262348b).f262289f);
                aVar.f262290g = f.b(((a) this.f262347a).f262290g, ((a) this.f262348b).f262290g);
                aVar.f262291h = f.b(((a) this.f262347a).f262291h, ((a) this.f262348b).f262291h);
                aVar.f262292i = f.b(((a) this.f262347a).f262292i, ((a) this.f262348b).f262292i);
                aVar.f262293j = f.b(((a) this.f262347a).f262293j, ((a) this.f262348b).f262293j);
                aVar.f262294k = f.b(((a) this.f262347a).f262294k, ((a) this.f262348b).f262294k);
                return aVar;
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f262287d = e.a.b.AbstractC8294b.c(0L);
            this.f262288e = e.a.b.AbstractC8294b.c(0L);
            this.f262289f = e.a.b.AbstractC8294b.c(0L);
            this.f262290g = e.a.b.AbstractC8294b.c(0L);
            this.f262291h = e.a.b.AbstractC8294b.c(0L);
            this.f262292i = e.a.b.AbstractC8294b.c(0L);
            this.f262293j = e.a.b.AbstractC8294b.c(0L);
            this.f262294k = e.a.b.AbstractC8294b.c(0L);
        }

        public e.a.AbstractC8291a<a> c(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e.a.AbstractC8291a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
            return new C8289a(aVar, this);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder a16 = g.a("TrafficStatSnapshot{wifiRxBytes=");
            a16.append(this.f262287d);
            a16.append(", wifiTxBytes=");
            a16.append(this.f262288e);
            a16.append(", wifiRxPackets=");
            a16.append(this.f262289f);
            a16.append(", wifiTxPackets=");
            a16.append(this.f262290g);
            a16.append(", mobileRxBytes=");
            a16.append(this.f262291h);
            a16.append(", mobileTxBytes=");
            a16.append(this.f262292i);
            a16.append(", mobileRxPackets=");
            a16.append(this.f262293j);
            a16.append(", mobileTxPackets=");
            a16.append(this.f262294k);
            a16.append('}');
            return a16.toString();
        }
    }

    public TrafficMonitorFeature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f262284e = null;
            this.f262285f = new a.a(new Runnable() { // from class: com.tencent.mobileqq.qqbattery.feature.TrafficMonitorFeature.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TrafficMonitorFeature.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TrafficMonitorFeature trafficMonitorFeature = TrafficMonitorFeature.this;
                        trafficMonitorFeature.f262284e = trafficMonitorFeature.f(trafficMonitorFeature.f262318d.b());
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.b();
        if (this.f262285f != null) {
            this.f262318d.i().post(this.f262285f);
        }
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.e
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Integer.MIN_VALUE;
    }

    public a f(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        e.a a16 = i.e.a(context);
        if (a16 == null) {
            return null;
        }
        a aVar = new a();
        aVar.f262287d = e.a.b.AbstractC8294b.c(Long.valueOf(a16.f406972a));
        aVar.f262288e = e.a.b.AbstractC8294b.c(Long.valueOf(a16.f406973b));
        aVar.f262289f = e.a.b.AbstractC8294b.c(Long.valueOf(a16.f406974c));
        aVar.f262290g = e.a.b.AbstractC8294b.c(Long.valueOf(a16.f406975d));
        aVar.f262291h = e.a.b.AbstractC8294b.c(Long.valueOf(a16.f406976e));
        aVar.f262292i = e.a.b.AbstractC8294b.c(Long.valueOf(a16.f406977f));
        aVar.f262293j = e.a.b.AbstractC8294b.c(Long.valueOf(a16.f406978g));
        aVar.f262294k = e.a.b.AbstractC8294b.c(Long.valueOf(a16.f406979h));
        return aVar;
    }

    public a g() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            obj = iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            a f16 = f(this.f262318d.b());
            if (f16 == null) {
                return null;
            }
            a aVar = this.f262284e;
            if (aVar == null) {
                this.f262284e = f16;
                return null;
            }
            obj = f16.c(aVar).f262349c;
        }
        return (a) obj;
    }
}
