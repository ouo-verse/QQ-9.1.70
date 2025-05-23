package com.tencent.mobileqq.msgbackup.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f251153a;

    /* renamed from: b, reason: collision with root package name */
    public int f251154b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f251155c;

    /* renamed from: d, reason: collision with root package name */
    public long f251156d;

    /* renamed from: e, reason: collision with root package name */
    public String f251157e;

    /* renamed from: f, reason: collision with root package name */
    public String f251158f;

    /* renamed from: g, reason: collision with root package name */
    public short f251159g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f251160h;

    /* renamed from: i, reason: collision with root package name */
    public long f251161i;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f251160h = true;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MsgBackupSessionTask[msg = " + this.f251153a + ", cmd = " + this.f251154b + ", isFileTask = " + this.f251155c + ", sessionId = " + this.f251156d + ", path = " + this.f251157e + ", url = " + this.f251158f + ", retryTimes = " + ((int) this.f251159g) + "]";
    }
}
