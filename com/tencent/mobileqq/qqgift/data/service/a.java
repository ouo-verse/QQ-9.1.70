package com.tencent.mobileqq.qqgift.data.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f264855a;

    /* renamed from: b, reason: collision with root package name */
    public String f264856b;

    /* renamed from: c, reason: collision with root package name */
    public String f264857c;

    /* renamed from: d, reason: collision with root package name */
    public String f264858d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f264859e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f264855a = 0;
        this.f264856b = "";
        this.f264857c = "";
        this.f264858d = "";
        this.f264859e = false;
    }

    public String a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this, i3);
        }
        String str = "sceneId:" + i3 + "panelType:" + this.f264855a + "source:" + this.f264856b + "gameType:" + this.f264857c;
        if (this.f264859e) {
            return str + "anchorID:" + this.f264858d;
        }
        return str;
    }

    public a(int i3, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, str3);
            return;
        }
        this.f264859e = false;
        this.f264855a = i3;
        this.f264856b = str;
        this.f264857c = str2;
        this.f264858d = str3;
    }
}
