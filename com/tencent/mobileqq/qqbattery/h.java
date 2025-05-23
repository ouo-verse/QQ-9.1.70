package com.tencent.mobileqq.qqbattery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature;
import com.tencent.mobileqq.qqbattery.feature.TrafficMonitorFeature;
import com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f262360a;

    /* renamed from: b, reason: collision with root package name */
    private final String f262361b;

    /* renamed from: c, reason: collision with root package name */
    private final float f262362c;

    /* renamed from: d, reason: collision with root package name */
    private final int f262363d;

    /* renamed from: e, reason: collision with root package name */
    private final int f262364e;

    /* renamed from: f, reason: collision with root package name */
    private final int f262365f;

    /* renamed from: g, reason: collision with root package name */
    private final TrafficMonitorFeature.a f262366g;

    /* renamed from: h, reason: collision with root package name */
    private final AlarmMonitorFeature.b f262367h;

    /* renamed from: i, reason: collision with root package name */
    private final WakeLockMonitorFeature.c f262368i;

    public h(boolean z16, String str, float f16, int i3, int i16, int i17, TrafficMonitorFeature.a aVar, AlarmMonitorFeature.b bVar, WakeLockMonitorFeature.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), str, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), aVar, bVar, cVar);
            return;
        }
        this.f262360a = z16;
        this.f262361b = str;
        this.f262362c = f16;
        this.f262363d = i3;
        this.f262364e = i16;
        this.f262365f = i17;
        this.f262366g = aVar;
        this.f262367h = bVar;
        this.f262368i = cVar;
    }

    public AlarmMonitorFeature.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AlarmMonitorFeature.b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f262367h;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f262363d;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f262365f;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f262361b;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f262364e;
    }

    public float f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.f262362c;
    }

    public TrafficMonitorFeature.a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TrafficMonitorFeature.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f262366g;
    }

    public WakeLockMonitorFeature.c h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (WakeLockMonitorFeature.c) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f262368i;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f262360a;
    }
}
