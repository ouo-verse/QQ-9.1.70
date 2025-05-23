package com.tencent.ams.fusion.service.splash.data.b;

import com.tencent.ams.fusion.service.splash.data.SplashNetDataRequest;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements SplashNetDataRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f70513a;

    /* renamed from: b, reason: collision with root package name */
    private String f70514b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f70515c;

    /* renamed from: d, reason: collision with root package name */
    private Map f70516d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f70517e;

    /* renamed from: f, reason: collision with root package name */
    private Object f70518f;

    /* renamed from: g, reason: collision with root package name */
    private int f70519g;

    /* renamed from: h, reason: collision with root package name */
    private long f70520h;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f70519g = Integer.MIN_VALUE;
            this.f70520h = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70513a;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f70514b : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            this.f70520h = j3;
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f70515c : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.f70513a = str;
        }
    }

    public void f(Map map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) map);
        } else {
            this.f70516d = map;
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f70515c = z16;
        }
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.f70514b = str;
        }
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f70517e = z16;
        }
    }

    public Map j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f70516d;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f70517e;
    }

    public Object l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f70518f;
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f70519g;
    }

    public long n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.f70520h;
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            this.f70519g = i3;
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
    }

    public void d(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            this.f70518f = obj;
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, obj);
        }
    }
}
