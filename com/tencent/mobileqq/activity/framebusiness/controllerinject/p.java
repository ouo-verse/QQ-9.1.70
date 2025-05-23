package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes10.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences.Editor f182377a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences.Editor f182378b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f182379c;

    public p(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        SharedPreferences c16 = TabMMKVManager.d().c();
        this.f182379c = c16;
        this.f182378b = c16.edit();
        this.f182377a = context.getSharedPreferences(TabDataHelper.K_TAB_DATA_HELPER_SP, 4).edit();
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f182378b.commit();
            this.f182377a.commit();
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f182377a.commit();
        }
    }

    public void c(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
            return;
        }
        boolean z17 = this.f182379c.getBoolean(str, false);
        this.f182378b.putBoolean(str, z16);
        if (z17 != z16) {
            TabMMKVManager.d().e(this.f182379c, str);
        }
        this.f182377a.putBoolean(str, z16);
    }

    public void d(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        int i16 = this.f182379c.getInt(str, Integer.MIN_VALUE);
        this.f182378b.putInt(str, i3);
        if (i16 != i3) {
            TabMMKVManager.d().e(this.f182379c, str);
        }
        this.f182377a.putInt(str, i3);
    }

    public void e(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3));
            return;
        }
        long j16 = this.f182379c.getLong(str, Long.MIN_VALUE);
        this.f182378b.putLong(str, j3);
        if (j16 != j3) {
            TabMMKVManager.d().e(this.f182379c, str);
        }
        this.f182377a.putLong(str, j3);
    }

    public void f(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        String string = this.f182379c.getString(str, null);
        this.f182378b.putString(str, str2);
        if (!Objects.equals(string, str2)) {
            TabMMKVManager.d().e(this.f182379c, str);
        }
        this.f182377a.putString(str, str2);
    }
}
