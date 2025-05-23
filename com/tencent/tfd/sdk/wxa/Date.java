package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Date {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Date f375589a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375589a = new Date();
        }
    }

    public Date() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(Context context, Chestnut chestnut) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) chestnut)).booleanValue();
        }
        if (!b(context, chestnut)) {
            return false;
        }
        long a16 = chestnut.a(context, "112");
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(a16 - currentTimeMillis) < Coconut.f375544e.a(context, "1", 0L, 3600000L)) {
            return false;
        }
        return true;
    }

    public final boolean b(Context context, Chestnut chestnut) {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) chestnut)).booleanValue();
        }
        try {
            j3 = Long.valueOf(Chestnut.b(context, "801")).longValue();
        } catch (Throwable unused) {
            j3 = 0;
        }
        chestnut.getClass();
        try {
            j16 = Long.valueOf(Chestnut.b(context, "802")).longValue();
        } catch (Throwable unused2) {
            j16 = 0;
        }
        if (j16 == 0) {
            j16 = 14400000;
        }
        if (Math.abs(j3 - System.currentTimeMillis()) >= j16) {
            return true;
        }
        return false;
    }
}
