package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Bitmap f236919a;

    /* renamed from: b, reason: collision with root package name */
    protected int f236920b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f236921c;

    /* renamed from: d, reason: collision with root package name */
    protected HeartAnimator f236922d;

    public a(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.f236921c = context;
            this.f236920b = i3;
        }
    }

    public void a(HeartAnimator.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            aVar.f236889o = 1.0f;
        }
    }

    public Drawable[] b(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) qQAppInterface);
        }
        return null;
    }

    public Bitmap c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HeartAnimator heartAnimator = this.f236922d;
        if (heartAnimator != null) {
            a(heartAnimator.c());
            return null;
        }
        return null;
    }

    public a(Context context, int i3, HeartAnimator heartAnimator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), heartAnimator);
            return;
        }
        this.f236921c = context;
        this.f236920b = i3;
        this.f236922d = heartAnimator;
    }
}
