package com.tencent.mobileqq.troop.honor.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements Comparable<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public int f297511d;

    /* renamed from: e, reason: collision with root package name */
    public String f297512e;

    /* renamed from: f, reason: collision with root package name */
    public String f297513f;

    /* renamed from: h, reason: collision with root package name */
    public String f297514h;

    /* renamed from: i, reason: collision with root package name */
    public String f297515i;

    /* renamed from: m, reason: collision with root package name */
    public int f297516m;

    public a(int i3, String str, String str2, String str3, String str4, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3, str4, Integer.valueOf(i16));
            return;
        }
        this.f297511d = i3;
        this.f297512e = str;
        this.f297513f = str2;
        this.f297514h = str3;
        this.f297515i = str4;
        this.f297516m = i16;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).intValue();
        }
        int i3 = this.f297516m;
        int i16 = aVar.f297516m;
        if (i3 < i16) {
            return -1;
        }
        if (i3 > i16) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopHonor{id=" + this.f297511d + ", name='" + this.f297512e + "', iconUrl='" + this.f297513f + "', bigIconUrl='" + this.f297514h + "', greyBigIconUrl='" + this.f297515i + "', priority='" + this.f297516m + "'}";
    }
}
