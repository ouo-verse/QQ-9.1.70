package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected a f236927a;

    /* renamed from: b, reason: collision with root package name */
    protected a f236928b;

    /* renamed from: c, reason: collision with root package name */
    protected a f236929c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f236930d;

    public c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f236930d = context;
        }
    }

    public a a(int i3, HeartAnimator heartAnimator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) heartAnimator);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (this.f236927a == null) {
                        this.f236927a = new b(this.f236930d, R.drawable.f5i, heartAnimator);
                    }
                    return this.f236927a;
                }
            } else {
                if (this.f236929c == null) {
                    this.f236929c = new PayLikeFloatViewBuilder(this.f236930d, R.drawable.f161451bs2, heartAnimator);
                }
                return this.f236929c;
            }
        }
        if (this.f236928b == null) {
            this.f236928b = new b(this.f236930d, R.drawable.f5m, heartAnimator);
        }
        return this.f236928b;
    }
}
