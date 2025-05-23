package com.tencent.ams.fusion.service.resdownload;

import android.text.TextUtils;
import com.tencent.ams.fusion.a.g;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements ResRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f70303a;

    /* renamed from: b, reason: collision with root package name */
    private String f70304b;

    /* renamed from: c, reason: collision with root package name */
    private String f70305c;

    /* renamed from: d, reason: collision with root package name */
    private int f70306d;

    /* renamed from: e, reason: collision with root package name */
    private SplashOrder f70307e;

    public d(String str, String str2, int i3, SplashOrder splashOrder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), splashOrder);
            return;
        }
        this.f70303a = str;
        this.f70305c = str2;
        this.f70306d = i3;
        this.f70307e = splashOrder;
    }

    @Override // com.tencent.ams.fusion.service.resdownload.ResRequest
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f70303a;
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f70304b = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.ams.fusion.service.resdownload.ResRequest
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f70305c;
    }

    @Override // com.tencent.ams.fusion.service.resdownload.ResRequest
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f70306d;
    }

    public SplashOrder f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SplashOrder) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f70307e;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f70304b;
    }

    @Override // com.tencent.ams.fusion.service.resdownload.ResRequest
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int i3 = this.f70306d;
        if ((i3 == 2 || i3 == 3) && !TextUtils.isEmpty(this.f70304b)) {
            return g.b(this.f70304b);
        }
        return g.b(this.f70303a);
    }
}
