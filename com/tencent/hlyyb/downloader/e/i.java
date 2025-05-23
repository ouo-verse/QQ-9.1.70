package com.tencent.hlyyb.downloader.e;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class i {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f114631j = ",";

    /* renamed from: a, reason: collision with root package name */
    public boolean f114632a;

    /* renamed from: b, reason: collision with root package name */
    public int f114633b;

    /* renamed from: c, reason: collision with root package name */
    public int f114634c;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f114635d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f114636e;

    /* renamed from: f, reason: collision with root package name */
    public volatile long f114637f;

    /* renamed from: g, reason: collision with root package name */
    public volatile long f114638g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f114639h;

    /* renamed from: i, reason: collision with root package name */
    public g f114640i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        }
    }

    public i(g gVar, long j3, long j16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, gVar, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        this.f114632a = true;
        this.f114633b = -1;
        this.f114634c = -1;
        this.f114639h = false;
        this.f114640i = gVar;
        this.f114635d = j3;
        this.f114638g = j18;
        this.f114636e = j16;
        this.f114637f = Math.max(j16, j17);
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f114633b + f114631j + this.f114634c + f114631j + this.f114635d + f114631j + this.f114636e + f114631j + this.f114638g;
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "[" + this.f114633b + f114631j + this.f114634c + f114631j + this.f114635d + f114631j + this.f114636e + f114631j + this.f114637f + f114631j + this.f114638g + "]";
    }

    public i(g gVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar, (Object) str);
            return;
        }
        this.f114632a = true;
        this.f114633b = -1;
        this.f114634c = -1;
        this.f114639h = false;
        this.f114640i = gVar;
        String[] split = str.split(f114631j);
        if (split == null || split.length != 5) {
            this.f114632a = false;
            return;
        }
        this.f114633b = Integer.valueOf(split[0]).intValue();
        this.f114634c = Integer.valueOf(split[1]).intValue();
        this.f114635d = Long.valueOf(split[2]).longValue();
        this.f114636e = Long.valueOf(split[3]).longValue();
        this.f114637f = this.f114636e;
        this.f114638g = Long.valueOf(split[4]).longValue();
    }
}
