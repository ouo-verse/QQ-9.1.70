package com.tencent.mobileqq.activity.home.impl;

import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f183110a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f183111b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f183112c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f183113d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f183114e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f183115f;

    /* renamed from: g, reason: collision with root package name */
    private StringBuilder f183116g;

    /* renamed from: h, reason: collision with root package name */
    private int f183117h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, Boolean> f183118i;

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183117h = -1;
        this.f183116g = new StringBuilder();
        this.f183118i = new HashMap<>();
    }

    public static d a() {
        return new d();
    }

    public StringBuilder b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (StringBuilder) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f183116g;
    }

    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (!TabDataHelper.TAB_CONVERSATION.equals(str) && !TabDataHelper.TAB_CONTACT.equals(str)) {
            Boolean bool = this.f183118i.get(str);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return true;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        StringBuilder sb5 = this.f183116g;
        sb5.append("mIsChanged: ");
        sb5.append(this.f183110a);
        sb5.append(" ");
        QLog.i("FrameUtil.TabFrameModel", 1, this.f183116g.toString());
        StringBuilder sb6 = this.f183116g;
        sb6.delete(0, sb6.length());
        return this.f183110a;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f183115f;
    }

    public void f(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        } else {
            this.f183118i.put(str, Boolean.valueOf(z16));
        }
    }

    public d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (d) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        this.f183110a = false;
        return this;
    }

    public d h(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (d) iPatchRedirector.redirect((short) 15, (Object) this, z16);
        }
        this.f183114e = z16;
        StringBuilder sb5 = this.f183116g;
        sb5.append("mIsBusinessChanged: ");
        sb5.append(this.f183114e);
        sb5.append(" ");
        if (!this.f183110a && !z16) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.f183110a = z17;
        return this;
    }

    public d i(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (d) iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
        this.f183112c = z16;
        StringBuilder sb5 = this.f183116g;
        sb5.append("mIsFirstInit: ");
        sb5.append(this.f183112c);
        sb5.append(" ");
        if (!this.f183110a && !this.f183112c) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.f183110a = z17;
        return this;
    }

    public d j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (d) iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
        this.f183115f = z16;
        StringBuilder sb5 = this.f183116g;
        sb5.append("mIsImmerseLayer: ");
        sb5.append(this.f183115f);
        sb5.append(" ");
        return this;
    }

    public d k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        this.f183111b = z16;
        StringBuilder sb5 = this.f183116g;
        sb5.append("mIsParamsWrong: ");
        sb5.append(this.f183111b);
        sb5.append(" ");
        if (this.f183111b) {
            this.f183110a = false;
        }
        return this;
    }

    public d l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (d) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        this.f183117h = i3;
        StringBuilder sb5 = this.f183116g;
        sb5.append("mSceneId: ");
        sb5.append(this.f183117h);
        sb5.append(" ");
        return this;
    }

    public d m(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (d) iPatchRedirector.redirect((short) 12, (Object) this, z16);
        }
        this.f183113d = z16;
        StringBuilder sb5 = this.f183116g;
        sb5.append("mIsSimpleUIChanged: ");
        sb5.append(this.f183113d);
        sb5.append(" ");
        if (!this.f183110a && !this.f183113d) {
            z17 = false;
        } else {
            z17 = true;
        }
        this.f183110a = z17;
        return this;
    }
}
