package com.tencent.imcore.message;

import android.database.Cursor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ah<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f116514a;

    /* renamed from: b, reason: collision with root package name */
    int f116515b;

    /* renamed from: c, reason: collision with root package name */
    String f116516c;

    /* renamed from: d, reason: collision with root package name */
    int f116517d;

    /* renamed from: e, reason: collision with root package name */
    T f116518e;

    /* renamed from: f, reason: collision with root package name */
    Cursor f116519f;

    /* renamed from: g, reason: collision with root package name */
    public Object f116520g;

    public ah(String str, int i3, String str2, int i16, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), t16);
            return;
        }
        this.f116514a = str;
        this.f116515b = i3;
        this.f116516c = str2;
        this.f116517d = i16;
        this.f116518e = t16;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f116517d;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f116514a;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f116515b;
    }

    public void d(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cursor);
        } else {
            this.f116519f = cursor;
        }
    }
}
