package com.tencent.mobileqq.qqbattery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final List<com.tencent.mobileqq.qqbattery.feature.e> f262235a;

    /* renamed from: b, reason: collision with root package name */
    public int f262236b;

    /* renamed from: c, reason: collision with root package name */
    public int f262237c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f262238d;

    /* renamed from: e, reason: collision with root package name */
    public long f262239e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f262240f;

    /* renamed from: g, reason: collision with root package name */
    public long f262241g;

    /* renamed from: h, reason: collision with root package name */
    public float f262242h;

    /* renamed from: i, reason: collision with root package name */
    public int f262243i;

    /* renamed from: j, reason: collision with root package name */
    public int f262244j;

    /* renamed from: k, reason: collision with root package name */
    public long f262245k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f262246l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f262247m;

    /* renamed from: n, reason: collision with root package name */
    public long f262248n;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final b f262249a;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqbattery.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public class C8286a implements Comparator<com.tencent.mobileqq.qqbattery.feature.e> {
            static IPatchRedirector $redirector_;

            public C8286a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.util.Comparator
            public final int compare(com.tencent.mobileqq.qqbattery.feature.e eVar, com.tencent.mobileqq.qqbattery.feature.e eVar2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar, (Object) eVar2)).intValue();
                }
                return Integer.compare(eVar2.c(), eVar.c());
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f262249a = new b(null);
            }
        }

        public a a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.f262249a.f262238d = z16;
            return this;
        }

        public b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (b) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            Collections.sort(this.f262249a.f262235a, new C8286a());
            return this.f262249a;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<com.tencent.mobileqq.qqbattery.feature.e>, java.util.ArrayList] */
        public a c(Class<? extends com.tencent.mobileqq.qqbattery.feature.e> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            }
            try {
                this.f262249a.f262235a.add(cls.newInstance());
            } catch (Exception e16) {
                com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_BatteryMonitorConfig", e16, "", new Object[0]);
            }
            return this;
        }

        public a d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                this.f262249a.f262247m = z16;
                return this;
            }
            return (a) iPatchRedirector.redirect((short) 13, (Object) this, z16);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f262235a = new ArrayList();
        this.f262236b = 20;
        this.f262237c = 10;
        this.f262238d = false;
        this.f262239e = 3600000L;
        this.f262240f = true;
        this.f262241g = 5000L;
        this.f262242h = 0.25f;
        this.f262243i = 200;
        this.f262244j = 10;
        this.f262245k = 600000L;
        this.f262246l = true;
        this.f262247m = true;
        this.f262248n = MiniBoxNoticeInfo.MIN_5;
    }

    public List<com.tencent.mobileqq.qqbattery.feature.e> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f262235a;
    }

    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.f262245k;
    }

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.f262248n;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f262247m;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f262246l;
    }

    public /* synthetic */ b(C8287b c8287b) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8287b);
    }
}
