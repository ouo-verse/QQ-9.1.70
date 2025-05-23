package com.tencent.mobileqq.qqlive.room.multichat.audience;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected final Activity f271659d;

    public a(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.f271659d = activity;
        }
    }

    private float d(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).intValue();
        }
        return (int) ((f16 * d(this.f271659d)) + 0.5f);
    }
}
