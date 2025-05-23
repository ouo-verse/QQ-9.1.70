package com.tencent.mobileqq.troop.entereffect;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f295258a;

    /* renamed from: b, reason: collision with root package name */
    public String f295259b;

    /* renamed from: c, reason: collision with root package name */
    public String f295260c;

    /* renamed from: d, reason: collision with root package name */
    public long f295261d;

    /* renamed from: e, reason: collision with root package name */
    public int f295262e;

    /* renamed from: f, reason: collision with root package name */
    public int f295263f;

    /* renamed from: g, reason: collision with root package name */
    public int f295264g;

    /* renamed from: h, reason: collision with root package name */
    public long f295265h;

    /* renamed from: i, reason: collision with root package name */
    public String f295266i;

    public f(int i3, String str, String str2, int i16, int i17, int i18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3));
            return;
        }
        this.f295266i = "";
        this.f295258a = i3;
        this.f295259b = str;
        this.f295260c = str2;
        this.f295262e = i16;
        this.f295263f = i17;
        this.f295264g = i18;
        this.f295265h = j3;
        this.f295261d = System.currentTimeMillis();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return String.format("{id: %d, uin: %s, troopUin: %s, createTime: %d, svipLevel: %d, svipType: %d, globalTroopLevel: %d, mode: %d}", Integer.valueOf(this.f295258a), this.f295259b, this.f295260c, Long.valueOf(this.f295261d), Integer.valueOf(this.f295262e), Integer.valueOf(this.f295263f), Integer.valueOf(this.f295264g), Long.valueOf(this.f295265h));
    }
}
