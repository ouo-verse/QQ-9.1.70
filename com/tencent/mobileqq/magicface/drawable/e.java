package com.tencent.mobileqq.magicface.drawable;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f243323a;

    /* renamed from: b, reason: collision with root package name */
    public int f243324b;

    /* renamed from: c, reason: collision with root package name */
    public int f243325c;

    /* renamed from: d, reason: collision with root package name */
    public int f243326d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f243327e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f243328f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f243329g;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a();
        }
    }

    private void a() {
        this.f243323a = 0;
        this.f243324b = 1;
        this.f243325c = 100;
        this.f243326d = 0;
        this.f243327e = null;
        this.f243328f = null;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        String[] strArr = this.f243327e;
        if (strArr != null && strArr.length > 0) {
            for (int i3 = 0; i3 < this.f243327e.length; i3++) {
                if (!new File(this.f243327e[i3]).exists()) {
                    return false;
                }
            }
        }
        String[] strArr2 = this.f243328f;
        if (strArr2 != null && strArr2.length > 0) {
            for (int i16 = 0; i16 < this.f243328f.length; i16++) {
                if (!new File(this.f243328f[i16]).exists()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
