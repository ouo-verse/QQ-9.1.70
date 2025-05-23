package com.tencent.qqnt.doutu;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f356038a;

    /* renamed from: b, reason: collision with root package name */
    public String f356039b;

    /* renamed from: c, reason: collision with root package name */
    public long f356040c;

    /* renamed from: d, reason: collision with root package name */
    public String f356041d;

    /* renamed from: e, reason: collision with root package name */
    public String f356042e;

    /* renamed from: f, reason: collision with root package name */
    public long f356043f;

    /* renamed from: g, reason: collision with root package name */
    public int f356044g;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f356043f = 0L;
            this.f356044g = 0;
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f356038a) && !TextUtils.isEmpty(this.f356039b)) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "DoutuItem uuid:" + this.f356038a + ", md5" + this.f356039b + ", fileId" + this.f356040c + ", url" + this.f356041d + ",key:" + this.f356043f + ",count:" + this.f356044g + ",picUin:" + this.f356042e;
    }

    public c(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.f356043f = j3;
            this.f356044g = i3;
        }
    }
}
