package com.tencent.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class URLImageView extends ImageView implements URLDrawable.URLDrawableListener {
    static IPatchRedirector $redirector_;
    private URLDrawableDownListener listener;

    public URLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uRLDrawable);
            return;
        }
        URLDrawableDownListener uRLDrawableDownListener = this.listener;
        if (uRLDrawableDownListener != null) {
            uRLDrawableDownListener.onLoadCancelled(this, uRLDrawable);
        }
    }

    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uRLDrawable, (Object) th5);
            return;
        }
        if (getDrawable() == uRLDrawable) {
            super.setImageDrawable(null);
            super.setImageDrawable(uRLDrawable);
        } else if (getBackground() == uRLDrawable) {
            super.setBackgroundDrawable(null);
            super.setBackgroundDrawable(uRLDrawable);
        }
        URLDrawableDownListener uRLDrawableDownListener = this.listener;
        if (uRLDrawableDownListener != null) {
            uRLDrawableDownListener.onLoadFailed(this, uRLDrawable, null);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) uRLDrawable, i3);
            return;
        }
        URLDrawableDownListener uRLDrawableDownListener = this.listener;
        if (uRLDrawableDownListener != null) {
            uRLDrawableDownListener.onLoadProgressed(this, uRLDrawable, i3);
        }
    }

    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable);
            return;
        }
        if (getDrawable() == uRLDrawable) {
            super.setImageDrawable(null);
            super.setImageDrawable(uRLDrawable);
        } else if (getBackground() == uRLDrawable) {
            super.setBackgroundDrawable(null);
            super.setBackgroundDrawable(uRLDrawable);
        }
        URLDrawableDownListener uRLDrawableDownListener = this.listener;
        if (uRLDrawableDownListener != null) {
            uRLDrawableDownListener.onLoadSuccessed(this, uRLDrawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
            return;
        }
        Drawable background = getBackground();
        if (background == drawable) {
            return;
        }
        if (background instanceof URLDrawable) {
            ((URLDrawable) background).setURLDrawableListener(null);
        }
        if (drawable instanceof URLDrawable) {
            ((URLDrawable) drawable).setURLDrawableListener(this);
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundURL(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            if (str != null) {
                if ((getBackground() instanceof URLDrawable) && ((URLDrawable) getBackground()).getURL().toString().equals(str)) {
                    return;
                }
                setBackgroundDrawable(URLDrawable.getDrawable(str));
                return;
            }
            throw new IllegalArgumentException("url can't be null");
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) drawable);
            return;
        }
        Drawable drawable2 = getDrawable();
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 instanceof URLDrawable) {
            ((URLDrawable) drawable2).setURLDrawableListener(null);
        }
        if (drawable instanceof URLDrawable) {
            ((URLDrawable) drawable).setURLDrawableListener(this);
        }
        super.setImageDrawable(drawable);
    }

    @Deprecated
    public void setImageURL(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            if (str != null) {
                if ((getDrawable() instanceof URLDrawable) && ((URLDrawable) getDrawable()).getURL().toString().equals(str)) {
                    return;
                }
                setImageDrawable(URLDrawable.getDrawable(str));
                return;
            }
            throw new IllegalArgumentException("url can't be null");
        }
    }

    public void setURLDrawableDownListener(URLDrawableDownListener uRLDrawableDownListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawableDownListener);
        } else {
            this.listener = uRLDrawableDownListener;
        }
    }

    public URLImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public URLImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }
}
