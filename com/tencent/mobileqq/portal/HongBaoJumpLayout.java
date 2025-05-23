package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HongBaoJumpLayout extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public int f259175d;

    /* renamed from: e, reason: collision with root package name */
    public int f259176e;

    /* renamed from: f, reason: collision with root package name */
    public int f259177f;

    /* renamed from: h, reason: collision with root package name */
    public int f259178h;

    public HongBaoJumpLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f259175d = getResources().getDimensionPixelOffset(R.dimen.af9);
        this.f259176e = getResources().getDimensionPixelOffset(R.dimen.af8);
        this.f259177f = getResources().getDimensionPixelOffset(R.dimen.af6);
        this.f259178h = getResources().getDimensionPixelOffset(R.dimen.af7);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
        } else {
            super.draw(canvas);
        }
    }

    public HongBaoJumpLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            a();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }
}
