package com.tencent.qqnt.chats.view.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.view.shimmer.Shimmer;

/* compiled from: P */
/* loaded from: classes24.dex */
public class ShimmerFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f355629d;

    /* renamed from: e, reason: collision with root package name */
    private final a f355630e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f355631f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f355632h;

    public ShimmerFrameLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f355629d = new Paint();
        this.f355630e = new a();
        this.f355631f = true;
        this.f355632h = false;
        b(context, null);
    }

    private void b(Context context, @Nullable AttributeSet attributeSet) {
        Shimmer.b aVar;
        setWillNotDraw(false);
        this.f355630e.setCallback(this);
        if (attributeSet == null) {
            d(new Shimmer.a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ow3.a.D3, 0, 0);
        try {
            int i3 = ow3.a.I3;
            if (obtainStyledAttributes.hasValue(i3) && obtainStyledAttributes.getBoolean(i3, false)) {
                aVar = new Shimmer.c();
            } else {
                aVar = new Shimmer.a();
            }
            d(aVar.c(obtainStyledAttributes).a());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        g();
        this.f355631f = false;
        invalidate();
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f355630e.a();
    }

    public ShimmerFrameLayout d(@Nullable Shimmer shimmer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ShimmerFrameLayout) iPatchRedirector.redirect((short) 5, (Object) this, (Object) shimmer);
        }
        this.f355630e.d(shimmer);
        if (shimmer != null && shimmer.f355620o) {
            setLayerType(2, this.f355629d);
        } else {
            setLayerType(0, null);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        if (this.f355631f) {
            this.f355630e.draw(canvas);
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        this.f355631f = true;
        if (z16) {
            f();
        }
        invalidate();
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (isAttachedToWindow()) {
            this.f355630e.f();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f355632h = false;
            this.f355630e.g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            super.onAttachedToWindow();
            this.f355630e.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.onDetachedFromWindow();
            g();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onLayout(z16, i3, i16, i17, i18);
            this.f355630e.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        a aVar = this.f355630e;
        if (aVar == null) {
            return;
        }
        if (i3 != 0) {
            if (c()) {
                g();
                this.f355632h = true;
                return;
            }
            return;
        }
        if (this.f355632h) {
            aVar.b();
            this.f355632h = false;
        }
    }

    public void setStaticAnimationProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else {
            this.f355630e.e(f16);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) drawable)).booleanValue();
        }
        if (!super.verifyDrawable(drawable) && drawable != this.f355630e) {
            return false;
        }
        return true;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f355629d = new Paint();
        this.f355630e = new a();
        this.f355631f = true;
        this.f355632h = false;
        b(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f355629d = new Paint();
        this.f355630e = new a();
        this.f355631f = true;
        this.f355632h = false;
        b(context, attributeSet);
    }
}
