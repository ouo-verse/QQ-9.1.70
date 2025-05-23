package com.tencent.common.galleryactivity;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class k {
    static IPatchRedirector $redirector_ = null;
    public static final int PHOTO_LAST_SELECTED = 3;
    public static final int PHOTO_SELECTED = 1;
    public static final int PHOTO_UNSELECTED = 2;
    public boolean isImgCenterCropMode;
    public int selectStatus;
    public Rect thubmRect;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.selectStatus = 2;
        }
    }

    public static int getCutValue(Rect rect, Drawable drawable) {
        float width = rect.width();
        float height = rect.height();
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (width > 0.0f && height > 0.0f && intrinsicWidth > 0.0f && intrinsicHeight > 0.0f) {
            float f16 = (width * intrinsicHeight) / (height * intrinsicWidth);
            if (f16 < 1.0f) {
                return 1;
            }
            if (f16 > 1.0f) {
                return 2;
            }
        }
        return 0;
    }

    public abstract Drawable getAnimationDrawable();

    public abstract int getCutValue();

    public int getSelected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.selectStatus;
    }

    public Rect getStartSrcRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Rect) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    public int getStartX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    public int getStartY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    public Rect getThumbRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Rect) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.thubmRect;
    }

    public boolean needAnimation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, z16)).booleanValue();
        }
        return true;
    }

    public void setSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.selectStatus = i3;
        }
    }
}
