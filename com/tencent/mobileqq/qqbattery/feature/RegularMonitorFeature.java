package com.tencent.mobileqq.qqbattery.feature;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature;
import com.tencent.mobileqq.qqbattery.feature.TrafficMonitorFeature;
import com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature;
import com.tencent.mobileqq.qqbattery.h;
import i.b;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RegularMonitorFeature extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public long f262281e;

    /* renamed from: f, reason: collision with root package name */
    public final a.a f262282f;

    public RegularMonitorFeature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f262282f = new a.a(new Runnable() { // from class: com.tencent.mobileqq.qqbattery.feature.RegularMonitorFeature.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RegularMonitorFeature.this);
                    }
                }

                /* JADX WARN: Can't wrap try/catch for region: R(5:8|(3:10|(1:12)(1:17)|(3:14|15|16))|18|19|(5:21|22|23|15|16)(4:24|23|15|16)) */
                /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
                
                    r0 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:27:0x007f, code lost:
                
                    r6 = com.tencent.mobileqq.qqbattery.feature.g.a("get EXTRA_TEMPERATURE failed: ");
                    r6.append(r0.getMessage());
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_BatteryCanaryUtil", r6.toString(), new java.lang.Object[0]);
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    int i3;
                    int intValue;
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String b16 = RegularMonitorFeature.this.f262318d.j().b();
                    boolean a16 = RegularMonitorFeature.this.f262318d.j().a();
                    float h16 = ((d) RegularMonitorFeature.this.f262318d.k(d.class)).h();
                    int a17 = i.b.a(RegularMonitorFeature.this.f262318d.b());
                    Application b17 = RegularMonitorFeature.this.f262318d.b();
                    b.a aVar = i.b.f406965a;
                    i.c<Integer> cVar = aVar.f406967b;
                    if (cVar != null) {
                        if (SystemClock.uptimeMillis() - cVar.f406970c >= cVar.f406969b) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            intValue = aVar.f406967b.f406968a.intValue();
                            int i16 = intValue;
                            int f16 = b.f(RegularMonitorFeature.this.f262318d.b());
                            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", "Regular Print, isForeground:" + a16 + ", scene:" + b16 + ", topCpuUsage:" + h16 + ", temperature:" + i16 + ", powerPct:" + a17 + ", deviceStat:" + f16, new Object[0]);
                            TrafficMonitorFeature.a g16 = ((TrafficMonitorFeature) RegularMonitorFeature.this.f262318d.k(TrafficMonitorFeature.class)).g();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Regular Print, trafficSnapshot:");
                            sb5.append(g16);
                            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", sb5.toString(), new Object[0]);
                            AlarmMonitorFeature.b f17 = ((AlarmMonitorFeature) RegularMonitorFeature.this.f262318d.k(AlarmMonitorFeature.class)).f();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Regular Print, alarmSnapshot:");
                            sb6.append(f17);
                            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", sb6.toString(), new Object[0]);
                            WakeLockMonitorFeature.c f18 = ((WakeLockMonitorFeature) RegularMonitorFeature.this.f262318d.k(WakeLockMonitorFeature.class)).f();
                            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", "Regular Print, wakeLockSnapshot:" + f18, new Object[0]);
                            RegularMonitorFeature.this.f262318d.g().a(new h(a16, b16, h16, a17, i16, f16, g16, f17, f18));
                            Handler i17 = RegularMonitorFeature.this.f262318d.i();
                            RegularMonitorFeature regularMonitorFeature = RegularMonitorFeature.this;
                            i17.postDelayed(regularMonitorFeature.f262282f, regularMonitorFeature.f262281e);
                        }
                    }
                    Intent b18 = i.b.b(b17);
                    if (b18 != null) {
                        i3 = b18.getIntExtra("temperature", 0);
                        Integer valueOf = Integer.valueOf(i3);
                        aVar.f406967b = new i.c<>(valueOf, 5000L);
                        intValue = valueOf.intValue();
                        int i162 = intValue;
                        int f162 = b.f(RegularMonitorFeature.this.f262318d.b());
                        com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", "Regular Print, isForeground:" + a16 + ", scene:" + b16 + ", topCpuUsage:" + h16 + ", temperature:" + i162 + ", powerPct:" + a17 + ", deviceStat:" + f162, new Object[0]);
                        TrafficMonitorFeature.a g162 = ((TrafficMonitorFeature) RegularMonitorFeature.this.f262318d.k(TrafficMonitorFeature.class)).g();
                        StringBuilder sb52 = new StringBuilder();
                        sb52.append("Regular Print, trafficSnapshot:");
                        sb52.append(g162);
                        com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", sb52.toString(), new Object[0]);
                        AlarmMonitorFeature.b f172 = ((AlarmMonitorFeature) RegularMonitorFeature.this.f262318d.k(AlarmMonitorFeature.class)).f();
                        StringBuilder sb62 = new StringBuilder();
                        sb62.append("Regular Print, alarmSnapshot:");
                        sb62.append(f172);
                        com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", sb62.toString(), new Object[0]);
                        WakeLockMonitorFeature.c f182 = ((WakeLockMonitorFeature) RegularMonitorFeature.this.f262318d.k(WakeLockMonitorFeature.class)).f();
                        com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", "Regular Print, wakeLockSnapshot:" + f182, new Object[0]);
                        RegularMonitorFeature.this.f262318d.g().a(new h(a16, b16, h16, a17, i162, f162, g162, f172, f182));
                        Handler i172 = RegularMonitorFeature.this.f262318d.i();
                        RegularMonitorFeature regularMonitorFeature2 = RegularMonitorFeature.this;
                        i172.postDelayed(regularMonitorFeature2.f262282f, regularMonitorFeature2.f262281e);
                    }
                    i3 = 0;
                    Integer valueOf2 = Integer.valueOf(i3);
                    aVar.f406967b = new i.c<>(valueOf2, 5000L);
                    intValue = valueOf2.intValue();
                    int i1622 = intValue;
                    int f1622 = b.f(RegularMonitorFeature.this.f262318d.b());
                    com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", "Regular Print, isForeground:" + a16 + ", scene:" + b16 + ", topCpuUsage:" + h16 + ", temperature:" + i1622 + ", powerPct:" + a17 + ", deviceStat:" + f1622, new Object[0]);
                    TrafficMonitorFeature.a g1622 = ((TrafficMonitorFeature) RegularMonitorFeature.this.f262318d.k(TrafficMonitorFeature.class)).g();
                    StringBuilder sb522 = new StringBuilder();
                    sb522.append("Regular Print, trafficSnapshot:");
                    sb522.append(g1622);
                    com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", sb522.toString(), new Object[0]);
                    AlarmMonitorFeature.b f1722 = ((AlarmMonitorFeature) RegularMonitorFeature.this.f262318d.k(AlarmMonitorFeature.class)).f();
                    StringBuilder sb622 = new StringBuilder();
                    sb622.append("Regular Print, alarmSnapshot:");
                    sb622.append(f1722);
                    com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", sb622.toString(), new Object[0]);
                    WakeLockMonitorFeature.c f1822 = ((WakeLockMonitorFeature) RegularMonitorFeature.this.f262318d.k(WakeLockMonitorFeature.class)).f();
                    com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_RegularMonitorFeature", "Regular Print, wakeLockSnapshot:" + f1822, new Object[0]);
                    RegularMonitorFeature.this.f262318d.g().a(new h(a16, b16, h16, a17, i1622, f1622, g1622, f1722, f1822));
                    Handler i1722 = RegularMonitorFeature.this.f262318d.i();
                    RegularMonitorFeature regularMonitorFeature22 = RegularMonitorFeature.this;
                    i1722.postDelayed(regularMonitorFeature22.f262282f, regularMonitorFeature22.f262281e);
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
        if (this.f262282f != null) {
            this.f262318d.i().post(this.f262282f);
        }
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.e
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void d(com.tencent.mobileqq.qqbattery.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        } else {
            super.d(gVar);
            this.f262281e = this.f262318d.h().d();
        }
    }
}
