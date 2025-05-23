package com.tencent.mobileqq.troop.troopmemberlevel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f300590a;

    /* renamed from: b, reason: collision with root package name */
    public int f300591b;

    /* renamed from: c, reason: collision with root package name */
    public String f300592c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f300593d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f300594e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f300595f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f300596g;

    /* renamed from: h, reason: collision with root package name */
    public int f300597h;

    /* renamed from: i, reason: collision with root package name */
    public int f300598i;

    /* renamed from: j, reason: collision with root package name */
    public String f300599j;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f300590a = 0;
        this.f300591b = 0;
        this.f300592c = "";
        this.f300593d = null;
        this.f300594e = null;
        this.f300595f = false;
        this.f300596g = false;
        this.f300597h = -1;
        this.f300598i = -1;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "rankId = " + this.f300590a + ",realLevel = " + this.f300591b + ",rankTitle = " + this.f300592c + ",isShowLevel = " + this.f300595f + ",isShowRank = " + this.f300596g;
    }
}
