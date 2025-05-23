package com.tencent.mobileqq.gallery.picocr;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f211814a;

    /* renamed from: b, reason: collision with root package name */
    public int f211815b;

    /* renamed from: c, reason: collision with root package name */
    public int f211816c;

    /* renamed from: d, reason: collision with root package name */
    public String f211817d;

    /* renamed from: e, reason: collision with root package name */
    public String f211818e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<b> f211819f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<String> f211820g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap<String, String> f211821h;

    /* renamed from: i, reason: collision with root package name */
    public int f211822i;

    /* renamed from: j, reason: collision with root package name */
    public int f211823j;

    /* renamed from: k, reason: collision with root package name */
    public int f211824k;

    /* renamed from: l, reason: collision with root package name */
    public String f211825l;

    /* renamed from: m, reason: collision with root package name */
    public int f211826m;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f211819f = new ArrayList<>();
            this.f211820g = new ArrayList<>();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "mMd5= " + this.f211814a + "\nbaseWidth= " + this.f211815b + "\nbaseHeight= " + this.f211816c + "\nmLanguage= " + this.f211817d + "\nurl= " + this.f211818e + "\nlanguageList= " + this.f211820g.toString() + "\nmSrcLangMap= " + this.f211821h.toString() + "\nfileSize= " + this.f211822i + "\nreqHeight= " + this.f211824k + "\nreqWidth= " + this.f211823j + "\nafMd5= " + this.f211825l + "\nrotateDe= " + this.f211826m + "\n";
    }
}
