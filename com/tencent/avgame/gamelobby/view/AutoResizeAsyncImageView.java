package com.tencent.avgame.gamelobby.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import gx.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AutoResizeAsyncImageView extends ImageView implements URLDrawable.URLDrawableListener {
    static IPatchRedirector $redirector_;
    public static final String F;
    private Drawable C;
    private Drawable D;
    private URLDrawable.URLDrawableListener E;

    /* renamed from: d, reason: collision with root package name */
    private int f77545d;

    /* renamed from: e, reason: collision with root package name */
    private int f77546e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f77547f;

    /* renamed from: h, reason: collision with root package name */
    private float f77548h;

    /* renamed from: i, reason: collision with root package name */
    private float f77549i;

    /* renamed from: m, reason: collision with root package name */
    private URLDrawable.URLDrawableOptions f77550m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20480);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            F = AutoResizeAsyncImageView.class.getName();
        }
    }

    public AutoResizeAsyncImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private Drawable a(TypedArray typedArray, int i3, Drawable drawable) {
        Drawable drawable2 = typedArray.getDrawable(i3);
        if (drawable2 != null) {
            return drawable2;
        }
        return drawable;
    }

    private void b() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        this.f77550m = obtain;
        obtain.mLoadingDrawable = this.C;
        obtain.mFailedDrawable = this.D;
        obtain.mDecodeFileStrategy = 3;
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) uRLDrawable);
            return;
        }
        URLDrawable.URLDrawableListener uRLDrawableListener = this.E;
        if (uRLDrawableListener != null) {
            uRLDrawableListener.onLoadCanceled(uRLDrawable);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) uRLDrawable, (Object) th5);
            return;
        }
        URLDrawable.URLDrawableListener uRLDrawableListener = this.E;
        if (uRLDrawableListener != null) {
            uRLDrawableListener.onLoadFialed(uRLDrawable, th5);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) uRLDrawable, i3);
            return;
        }
        URLDrawable.URLDrawableListener uRLDrawableListener = this.E;
        if (uRLDrawableListener != null) {
            uRLDrawableListener.onLoadProgressed(uRLDrawable, i3);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) uRLDrawable);
            return;
        }
        setImageDrawable(uRLDrawable);
        requestLayout();
        URLDrawable.URLDrawableListener uRLDrawableListener = this.E;
        if (uRLDrawableListener != null) {
            uRLDrawableListener.onLoadSuccessed(uRLDrawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        double ceil;
        int i17;
        double ceil2;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Drawable drawable = getDrawable();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (drawable != null) {
            if (drawable.getIntrinsicHeight() >= 0 && drawable.getIntrinsicWidth() >= 0) {
                z16 = false;
            }
            if (mode == 1073741824 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                int size = View.MeasureSpec.getSize(i3);
                if (z16) {
                    i18 = this.f77546e;
                } else {
                    if (this.f77547f) {
                        ceil2 = Math.ceil((size * this.f77548h) / this.f77549i);
                    } else {
                        ceil2 = Math.ceil((size * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
                    }
                    i18 = (int) ceil2;
                }
                setMeasuredDimension(size, Math.min(i18, getMaxHeight()));
                return;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && mode2 == 1073741824) {
                int size2 = View.MeasureSpec.getSize(i16);
                if (z16) {
                    i17 = this.f77545d;
                } else {
                    if (this.f77547f) {
                        ceil = Math.ceil((size2 * this.f77549i) / this.f77548h);
                    } else {
                        ceil = Math.ceil((size2 * drawable.getIntrinsicWidth()) / drawable.getIntrinsicHeight());
                    }
                    i17 = (int) ceil;
                }
                setMeasuredDimension(Math.min(i17, getMaxWidth()), size2);
                return;
            }
            super.onMeasure(i3, i16);
            return;
        }
        if (mode == 1073741824 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            setMeasuredDimension(View.MeasureSpec.getSize(i3), this.f77546e);
        } else if ((mode == Integer.MIN_VALUE || mode == 0) && mode2 == 1073741824) {
            setMeasuredDimension(this.f77545d, View.MeasureSpec.getSize(i16));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    public void setFailedDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
        } else {
            if (drawable == null) {
                return;
            }
            this.D = drawable;
            this.f77550m.mFailedDrawable = drawable;
        }
    }

    public void setFixedRatio(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f77547f = z16;
        }
    }

    public void setFixedRatioHeight(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Float.valueOf(f16));
        } else {
            this.f77548h = f16;
        }
    }

    public void setFixedRatioWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else {
            this.f77549i = f16;
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) drawable);
        } else {
            if (drawable == null) {
                return;
            }
            this.C = drawable;
            this.f77550m.mLoadingDrawable = drawable;
        }
    }

    public void setLoopOne() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", 1);
        this.f77550m.mExtraInfo = bundle;
    }

    public void setMinHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f77546e = Math.max(i3, 0);
        }
    }

    public void setMinWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f77545d = Math.max(i3, 0);
        }
    }

    public void setRatio(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f77549i = i3;
            this.f77548h = i16;
        }
    }

    public void setURLDrawableListener(URLDrawable.URLDrawableListener uRLDrawableListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) uRLDrawableListener);
        } else {
            this.E = uRLDrawableListener;
        }
    }

    public AutoResizeAsyncImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public AutoResizeAsyncImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f77545d = 0;
        this.f77546e = 0;
        this.f77547f = false;
        this.f77548h = -1.0f;
        this.f77549i = -1.0f;
        this.E = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f403664y);
        this.f77545d = obtainStyledAttributes.getDimensionPixelSize(a.G, 0);
        this.f77546e = obtainStyledAttributes.getDimensionPixelSize(a.F, 0);
        this.f77548h = obtainStyledAttributes.getFloat(a.C, -1.0f);
        this.f77549i = obtainStyledAttributes.getFloat(a.D, -1.0f);
        this.f77547f = obtainStyledAttributes.getBoolean(a.B, false);
        ColorDrawable colorDrawable = new ColorDrawable(obtainStyledAttributes.getColor(a.f403672z, 0));
        this.C = a(obtainStyledAttributes, a.E, colorDrawable);
        this.D = a(obtainStyledAttributes, a.A, colorDrawable);
        b();
        this.f77550m.mUseApngImage = obtainStyledAttributes.getBoolean(a.H, false);
        obtainStyledAttributes.recycle();
    }
}
