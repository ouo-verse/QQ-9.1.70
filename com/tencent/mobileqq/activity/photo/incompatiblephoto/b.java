package com.tencent.mobileqq.activity.photo.incompatiblephoto;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f184461a;

    /* renamed from: b, reason: collision with root package name */
    String f184462b;

    /* renamed from: c, reason: collision with root package name */
    String f184463c;

    public b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f184463c = str;
        }
    }

    public static boolean a(String str) {
        if (b(str) != null) {
            return true;
        }
        return false;
    }

    public static b b(String str) {
        if (d.c(str)) {
            return new d(str);
        }
        if (a.c(str)) {
            return new a(str);
        }
        return null;
    }
}
