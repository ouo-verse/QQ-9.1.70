package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CustomImgView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f384543d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f384544e;

    public CustomImgView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void b() {
        URLImageView uRLImageView = new URLImageView(getContext());
        this.f384543d = uRLImageView;
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f384543d, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(getContext());
        this.f384544e = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f384544e, new FrameLayout.LayoutParams(-1, -1));
        this.f384544e.setDuplicateParentStateEnabled(true);
    }

    public Drawable a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f384543d.getDrawable();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
        } else {
            this.f384544e.setImageDrawable(drawable);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap);
        } else {
            this.f384543d.setImageBitmap(bitmap);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
        } else {
            this.f384543d.setImageDrawable(drawable);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) scaleType);
        } else {
            this.f384543d.setScaleType(scaleType);
            this.f384544e.setScaleType(scaleType);
        }
    }

    public void setURLDrawableListener(URLDrawableDownListener uRLDrawableDownListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) uRLDrawableDownListener);
            return;
        }
        ImageView imageView = this.f384543d;
        if (imageView != null && (imageView instanceof URLImageView)) {
            ((URLImageView) imageView).setURLDrawableDownListener(uRLDrawableDownListener);
        }
    }

    public CustomImgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public CustomImgView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
