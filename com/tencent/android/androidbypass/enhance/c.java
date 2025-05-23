package com.tencent.android.androidbypass.enhance;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final float f72103a;

    public c(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
        } else {
            this.f72103a = f16;
        }
    }

    public static c a(Context context) {
        return new c(context.getResources().getDisplayMetrics().density);
    }

    public float b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this, i3)).floatValue();
        }
        return i3 / this.f72103a;
    }

    public int c(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16))).intValue();
        }
        return (int) (f16 * this.f72103a);
    }

    public int d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        return (int) ((i3 * this.f72103a) + 0.5f);
    }
}
