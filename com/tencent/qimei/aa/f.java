package com.tencent.qimei.aa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final Map<String, f> f342904f;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f342905a;

    /* renamed from: b, reason: collision with root package name */
    public final String f342906b;

    /* renamed from: c, reason: collision with root package name */
    public Context f342907c;

    /* renamed from: d, reason: collision with root package name */
    public String f342908d;

    /* renamed from: e, reason: collision with root package name */
    public String f342909e;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements com.tencent.qimei.v.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f342910a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f342911b;

        public a(String str, String str2) {
            this.f342910a = str;
            this.f342911b = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, str, str2);
            }
        }

        @Override // com.tencent.qimei.v.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                f.this.f342905a.edit().putString(this.f342910a, this.f342911b).apply();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements com.tencent.qimei.v.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f342913a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f342914b;

        public b(String str, long j3) {
            this.f342913a = str;
            this.f342914b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, str, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.qimei.v.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                f.this.f342905a.edit().putLong(this.f342913a, this.f342914b).apply();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16225);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342904f = new ConcurrentHashMap();
        }
    }

    public f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f342906b = str;
        }
    }

    public static synchronized f b(String str) {
        f fVar;
        synchronized (f.class) {
            Map<String, f> map = f342904f;
            fVar = map.get(str);
            if (fVar == null) {
                fVar = new f(str);
                map.put(str, fVar);
            }
        }
        return fVar;
    }

    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3));
        } else {
            if (a() == null) {
                return;
            }
            com.tencent.qimei.u.a.a(this.f342906b, new b(str, j3));
        }
    }

    public long c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).longValue();
        }
        if (a() == null) {
            return 0L;
        }
        return this.f342905a.getLong(str, 0L);
    }

    public String d(String str) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (a() == null || (string = this.f342905a.getString(str, "")) == null) {
            return "";
        }
        return string;
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else {
            if (a() == null) {
                return;
            }
            com.tencent.qimei.u.a.a(this.f342906b, new a(str, str2));
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (a() != null && com.tencent.qimei.u.a.f()) {
            this.f342905a.edit().remove(str).apply();
        }
    }

    public final SharedPreferences a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.f342905a == null) {
            synchronized (this) {
                if (this.f342905a == null && this.f342907c != null) {
                    if (TextUtils.isEmpty(this.f342909e)) {
                        this.f342909e = "";
                    }
                    String str = "QV1" + this.f342909e + com.tencent.qimei.ab.a.a(this.f342906b);
                    this.f342908d = str;
                    this.f342905a = this.f342907c.getSharedPreferences(str, 0);
                }
            }
        }
        return this.f342905a;
    }
}
