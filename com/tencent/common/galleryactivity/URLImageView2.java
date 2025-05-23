package com.tencent.common.galleryactivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class URLImageView2 extends URLImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public URLDrawable f99854d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f99855e;

    public URLImageView2(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f99855e = false;
        }
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, (Object) th5);
            return;
        }
        URLDrawable uRLDrawable2 = this.f99854d;
        if (uRLDrawable == uRLDrawable2) {
            setImageDrawable(uRLDrawable2);
        } else {
            super.onLoadFialed(uRLDrawable, th5);
        }
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            return;
        }
        if (uRLDrawable == this.f99854d) {
            Drawable drawable = getDrawable();
            if (drawable != null && drawable.getIntrinsicWidth() == uRLDrawable.getIntrinsicWidth() && drawable.getIntrinsicHeight() == uRLDrawable.getIntrinsicHeight()) {
                this.f99855e = true;
                setImageDrawable(this.f99854d);
                this.f99855e = false;
                return;
            }
            setImageDrawable(this.f99854d);
            return;
        }
        super.onLoadSuccessed(uRLDrawable);
    }

    @Override // android.view.View
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (!this.f99855e) {
            super.requestLayout();
        }
    }

    public void setDecodingDrawble(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            return;
        }
        URLDrawable uRLDrawable2 = this.f99854d;
        if (uRLDrawable2 != null) {
            uRLDrawable2.setURLDrawableListener(null);
        }
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(this);
        }
        this.f99854d = uRLDrawable;
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            return;
        }
        super.setImageDrawable(drawable);
        URLDrawable uRLDrawable = this.f99854d;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
            this.f99854d = null;
        }
    }
}
