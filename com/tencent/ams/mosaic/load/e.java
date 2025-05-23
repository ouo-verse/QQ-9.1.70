package com.tencent.ams.mosaic.load;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e implements Comparable<e> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f71525d;

    /* renamed from: e, reason: collision with root package name */
    public String f71526e;

    /* renamed from: f, reason: collision with root package name */
    public String f71527f;

    /* renamed from: h, reason: collision with root package name */
    public int f71528h;

    public e(String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Integer.valueOf(i3));
            return;
        }
        this.f71525d = str;
        this.f71526e = str2;
        this.f71527f = str3;
        this.f71528h = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar)).intValue();
        }
        if (eVar == null) {
            return 1;
        }
        return Integer.compare(this.f71528h, eVar.f71528h);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "QuickJSSoItem{url='" + this.f71525d + "', md5='" + this.f71526e + "', name='" + this.f71527f + "', priority=" + this.f71528h + '}';
    }
}
