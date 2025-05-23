package com.tencent.qqnt.aio.at;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public short f349464a;

    /* renamed from: b, reason: collision with root package name */
    public short f349465b;

    /* renamed from: c, reason: collision with root package name */
    public byte f349466c;

    /* renamed from: d, reason: collision with root package name */
    public long f349467d;

    /* renamed from: e, reason: collision with root package name */
    public String f349468e;

    /* renamed from: f, reason: collision with root package name */
    public long f349469f;

    /* renamed from: g, reason: collision with root package name */
    public short f349470g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f349471h;

    /* renamed from: i, reason: collision with root package name */
    public String f349472i;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f349464a = (short) 0;
        this.f349465b = (short) 0;
        this.f349466c = (byte) 0;
        this.f349467d = 0L;
        this.f349468e = "";
        this.f349469f = 0L;
        this.f349470g = (short) 0;
        this.f349471h = false;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f349464a >= 0 && this.f349465b > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "flag:" + ((int) this.f349466c) + " uin:" + this.f349467d + " channelId:" + this.f349469f + " startPos:" + ((int) this.f349464a) + " textLen:" + ((int) this.f349465b) + "\n";
    }
}
