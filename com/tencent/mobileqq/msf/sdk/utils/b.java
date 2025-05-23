package com.tencent.mobileqq.msf.sdk.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f250723a;

    /* renamed from: b, reason: collision with root package name */
    public String f250724b;

    /* renamed from: c, reason: collision with root package name */
    public String f250725c;

    /* renamed from: d, reason: collision with root package name */
    public int f250726d;

    /* renamed from: e, reason: collision with root package name */
    public int f250727e;

    /* renamed from: f, reason: collision with root package name */
    public long f250728f;

    /* renamed from: g, reason: collision with root package name */
    public int f250729g;

    /* renamed from: h, reason: collision with root package name */
    public String f250730h;

    /* renamed from: i, reason: collision with root package name */
    public byte f250731i;

    /* renamed from: j, reason: collision with root package name */
    public int f250732j;

    /* renamed from: k, reason: collision with root package name */
    public long f250733k;

    /* renamed from: l, reason: collision with root package name */
    public Runnable f250734l;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f250731i = (byte) 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public b a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }
        this.f250728f += j3;
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "MonitorDataFlow{bufferSize=" + this.f250728f + ", mType='" + this.f250730h + "', ip:'" + this.f250724b + "', port=" + this.f250726d + ", refer='" + this.f250725c + "', keyHash='" + this.f250732j + "', flag=" + this.f250727e + ", networktype=" + this.f250729g + ", status=" + ((int) this.f250731i) + ", processName='" + this.f250723a + "', lastUpdateTime=" + this.f250733k + '}';
    }

    public b(String str, String str2, int i3, int i16, long j3, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17));
            return;
        }
        this.f250731i = (byte) 0;
        this.f250724b = str;
        this.f250726d = i3;
        this.f250725c = str2;
        this.f250727e = i16;
        this.f250728f = j3;
        this.f250729g = i17;
    }
}
