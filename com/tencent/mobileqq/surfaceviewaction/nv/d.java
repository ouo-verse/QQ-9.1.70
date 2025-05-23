package com.tencent.mobileqq.surfaceviewaction.nv;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends c implements com.tencent.mobileqq.surfaceviewaction.d<SpriteNativeView> {
    static IPatchRedirector $redirector_;
    protected ImageView R;
    private Bitmap S;

    public d(SpriteNativeView spriteNativeView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) spriteNativeView);
        } else {
            this.P = spriteNativeView;
            this.R = C();
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.nv.c
    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.R.getVisibility() != 0) {
            this.R.setVisibility(0);
        }
        boolean A = super.A();
        if (this.S != null) {
            h(this.Q);
            float g16 = (this.Q.f291217a * g()) - (this.S.getWidth() / 2);
            float g17 = (this.N - (this.Q.f291218b * g())) - (this.S.getHeight() / 2);
            this.R.setX(g16);
            this.R.setY(g17);
        }
        this.R.setScaleX(this.f291155m * g());
        this.R.setScaleY(this.f291155m * g());
        this.R.setRotation(this.D);
        this.R.setAlpha((this.E * (f() / 255.0f)) / 255.0f);
        return A;
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.nv.c
    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.P.addView(this.R);
            this.R.setVisibility(4);
        }
    }

    protected ImageView C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new ImageView(this.P.getContext());
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.d
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void a(SpriteNativeView spriteNativeView, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) spriteNativeView, (Object) bitmap);
            return;
        }
        this.S = bitmap;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.S.getWidth(), this.S.getHeight());
        this.R.setImageBitmap(this.S);
        this.R.setLayoutParams(layoutParams);
        this.R.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.R.setPivotX(this.S.getWidth() / 2);
        this.R.setPivotY(this.S.getHeight() / 2);
    }
}
