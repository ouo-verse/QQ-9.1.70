package com.tencent.ams.fusion.widget.olympic2024;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GalleryItem {
    static IPatchRedirector $redirector_ = null;
    private static final float OPENING_CEREMONY_CENTER_Y_OFFSET_RATIO = -0.013333334f;
    private static final float OPENING_CEREMONY_DEFAULT_ASPECT_RATIO = 0.5625f;
    private static final float WIN_GOLD_CENTER_Y_OFFSET_RATIO = 0.10666667f;
    private static final float WIN_GOLD_DEFAULT_ASPECT_RATIO = 0.67764705f;
    private float mDismissRotation;
    private float mDisplayAlpha;
    private float mDisplayRotation;
    private int mHeight;
    private Bitmap mImage;
    private float mInitAlpha;
    private float mInitRotation;
    private float mItemCenterYOffsetRatio;
    private int mRadius;
    private String mVideoPath;
    private int mWidth;

    public GalleryItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mWidth = 0;
        this.mHeight = 0;
        this.mItemCenterYOffsetRatio = Float.MIN_VALUE;
        this.mInitAlpha = 0.6f;
        this.mDisplayAlpha = 1.0f;
        this.mRadius = 32;
    }

    private float getOpeningCeremonyDefaultHeight(Context context) {
        return getWinGoldDefaultWidth(context) / getOpeningCeremonyAspectRatio();
    }

    private float getWinGoldDefaultHeight(Context context) {
        return getWinGoldDefaultWidth(context) / getWinGoldAspectRatio();
    }

    private int getWinGoldDefaultWidth(Context context) {
        float relativeSize375 = Utils.getRelativeSize375(context, 288) / getWinGoldAspectRatio();
        int screenHeight = Utils.getScreenHeight(context);
        if (screenHeight > 0) {
            float f16 = screenHeight;
            if (relativeSize375 / f16 > 0.52f) {
                return (int) (f16 * 0.52f * getWinGoldAspectRatio());
            }
        }
        return Utils.getRelativeSize375(context, 288);
    }

    public float getDismissRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.mDismissRotation;
    }

    public float getDisplayAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, (Object) this)).floatValue();
        }
        return this.mDisplayAlpha;
    }

    public float getDisplayRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.mDisplayRotation;
    }

    public Bitmap getImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mImage;
    }

    public float getInitAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        return this.mInitAlpha;
    }

    public float getInitRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.mInitRotation;
    }

    public float getItemCenterYOffsetRatio(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this, i3)).floatValue();
        }
        float f16 = this.mItemCenterYOffsetRatio;
        if (f16 != Float.MIN_VALUE) {
            return f16;
        }
        if (i3 == 0) {
            return WIN_GOLD_CENTER_Y_OFFSET_RATIO;
        }
        if (i3 == 1) {
            return OPENING_CEREMONY_CENTER_Y_OFFSET_RATIO;
        }
        return 0.0f;
    }

    public float getOpeningCeremonyAspectRatio() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Float) iPatchRedirector.redirect((short) 22, (Object) this)).floatValue();
        }
        int i16 = this.mWidth;
        if (i16 > 0 && (i3 = this.mHeight) > 0) {
            return i16 / i3;
        }
        return 0.5625f;
    }

    public int getOpeningCeremonyHeight(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) context)).intValue();
        }
        int i3 = this.mHeight;
        if (i3 == 0) {
            return (int) getOpeningCeremonyDefaultHeight(context);
        }
        return i3;
    }

    public int getRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mRadius;
    }

    public String getVideoPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mVideoPath;
    }

    public int getWidth(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) context)).intValue();
        }
        int i3 = this.mWidth;
        if (i3 == 0) {
            return getWinGoldDefaultWidth(context);
        }
        return i3;
    }

    public float getWinGoldAspectRatio() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Float) iPatchRedirector.redirect((short) 21, (Object) this)).floatValue();
        }
        int i16 = this.mWidth;
        if (i16 > 0 && (i3 = this.mHeight) > 0) {
            return i16 / i3;
        }
        return WIN_GOLD_DEFAULT_ASPECT_RATIO;
    }

    public int getWinGoldHeight(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) context)).intValue();
        }
        int i3 = this.mHeight;
        if (i3 == 0) {
            return (int) getWinGoldDefaultHeight(context);
        }
        return i3;
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (this.mImage != null) {
            return true;
        }
        return false;
    }

    public GalleryItem obtain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (GalleryItem) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        GalleryItem galleryItem = new GalleryItem();
        galleryItem.setImage(this.mImage);
        galleryItem.setVideoPath(this.mVideoPath);
        galleryItem.setRadius(this.mRadius);
        galleryItem.setInitRotation(this.mInitRotation);
        galleryItem.setDisplayRotation(this.mDisplayRotation);
        galleryItem.setDismissRotation(this.mDismissRotation);
        galleryItem.setInitAlpha(this.mInitAlpha);
        galleryItem.setDisplayAlpha(this.mDisplayAlpha);
        galleryItem.setItemCenterYOffsetRatio(this.mItemCenterYOffsetRatio);
        return galleryItem;
    }

    public void setDismissRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.mDismissRotation = f16;
        }
    }

    public void setDisplayAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        } else {
            this.mDisplayAlpha = f16;
        }
    }

    public void setDisplayRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        } else {
            this.mDisplayRotation = f16;
        }
    }

    public void setImage(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        } else {
            this.mImage = bitmap;
        }
    }

    public void setInitAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        } else {
            this.mInitAlpha = f16;
        }
    }

    public void setInitRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.mInitRotation = f16;
        }
    }

    public void setItemCenterYOffsetRatio(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
        } else {
            this.mItemCenterYOffsetRatio = f16;
        }
    }

    public void setRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mRadius = i3;
        }
    }

    public void setVideoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mVideoPath = str;
        }
    }
}
