package com.tencent.tmdownloader.internal.downloadservice.g;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f380715a;

    /* renamed from: b, reason: collision with root package name */
    public String f380716b;

    /* renamed from: c, reason: collision with root package name */
    public int f380717c;

    /* renamed from: d, reason: collision with root package name */
    public long f380718d;

    /* renamed from: e, reason: collision with root package name */
    public long f380719e;

    public b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f380717c = 0;
        this.f380718d = 0L;
        this.f380719e = 0L;
        this.f380715a = str;
        this.f380716b = str2;
    }

    public boolean a(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17))).booleanValue();
        }
        if (j3 == j16) {
            this.f380718d = j3;
            this.f380719e = j17;
            return true;
        }
        if (j17 - this.f380719e >= 1000 && j3 != this.f380718d) {
            this.f380718d = j3;
            this.f380719e = j17;
            return true;
        }
        if (j16 <= 0 || (((((float) j3) * 1.0f) - (((float) this.f380718d) * 1.0f)) / ((float) j16)) * 1.0f <= 0.009999999776482582d) {
            return false;
        }
        this.f380718d = j3;
        this.f380719e = j17;
        return true;
    }
}
