package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f312539a;

    /* renamed from: b, reason: collision with root package name */
    public int f312540b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f312541c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f312542d;

    /* renamed from: e, reason: collision with root package name */
    public long f312543e;

    /* renamed from: f, reason: collision with root package name */
    public long f312544f;

    /* renamed from: g, reason: collision with root package name */
    public int f312545g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f312546h;

    public a(String str, int i3, boolean z16, boolean z17) {
        this(str, i3, z16, z17, 0L, 0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    public boolean a(a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).booleanValue();
        }
        aVar.getClass();
        if (!TextUtils.equals(this.f312539a, aVar.f312539a)) {
            this.f312539a = aVar.f312539a;
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.f312540b;
        int i16 = aVar.f312540b;
        if (i3 != i16) {
            this.f312540b = i16;
            z16 = true;
        }
        boolean z17 = this.f312541c;
        boolean z18 = aVar.f312541c;
        if (z17 != z18) {
            this.f312541c = z18;
            z16 = true;
        }
        boolean z19 = this.f312542d;
        boolean z26 = aVar.f312542d;
        if (z19 != z26) {
            this.f312542d = z26;
            z16 = true;
        }
        long j3 = this.f312543e;
        long j16 = aVar.f312543e;
        if (j3 != j16) {
            this.f312543e = j16;
            z16 = true;
        }
        long j17 = this.f312544f;
        long j18 = aVar.f312544f;
        if (j17 != j18) {
            this.f312544f = j18;
            z16 = true;
        }
        int i17 = this.f312545g;
        int i18 = aVar.f312545g;
        if (i17 != i18) {
            this.f312545g = i18;
            z16 = true;
        }
        boolean z27 = this.f312546h;
        boolean z28 = aVar.f312546h;
        if (z27 != z28) {
            this.f312546h = z28;
            return true;
        }
        return z16;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "inputFilePath=" + this.f312539a + " speedType=" + this.f312540b + " noSleep=" + this.f312541c + " repeat=" + this.f312542d + " startTimeMillSecond=" + this.f312543e + " endTimeMillSecond=" + this.f312544f;
    }

    public a(String str, int i3, boolean z16, boolean z17, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.f312546h = false;
        this.f312539a = str;
        this.f312540b = i3;
        this.f312541c = z17;
        this.f312542d = z16;
        this.f312543e = j3;
        this.f312544f = j16;
    }
}
