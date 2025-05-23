package com.tencent.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BottomDrawable extends Drawable {
    static IPatchRedirector $redirector_;
    private Bitmap mBitmap;
    Rect mDesRect;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private int mHeight;
    private int mNewBitmMapHeight;
    private Paint mPaint;
    Rect mSrcRect;
    private int mTop;
    private int mWidth;

    public BottomDrawable(Bitmap bitmap, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mSrcRect = new Rect();
        this.mDesRect = new Rect();
        this.mPaint = new Paint();
        this.mWidth = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.mHeight = height;
        this.mBitmap = bitmap;
        this.mDisplayWidth = i3;
        this.mDisplayHeight = i16;
        if (i3 <= 0) {
            this.mDisplayWidth = 1080;
        }
        if (i16 <= 0) {
            this.mDisplayHeight = 1920;
        }
        int i17 = (this.mDisplayHeight * this.mWidth) / this.mDisplayWidth;
        this.mNewBitmMapHeight = i17;
        if (height > i17) {
            this.mTop = height - i17;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UserGuideWeiShiActivity", 2, "displayWidth" + i3 + " displayHeight " + i16);
            QLog.i("UserGuideWeiShiActivity", 2, "mWidth" + this.mWidth + " mHeight " + this.mHeight);
            QLog.i("UserGuideWeiShiActivity", 2, "mNewBitmMapHeight" + this.mNewBitmMapHeight + " mTop " + this.mTop);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        this.mSrcRect.set(0, this.mTop, this.mWidth, this.mHeight);
        this.mDesRect.set(0, 0, this.mWidth, this.mNewBitmMapHeight);
        canvas.drawBitmap(this.mBitmap, this.mSrcRect, this.mDesRect, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mNewBitmMapHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else if (i3 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i3);
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) colorFilter);
        } else {
            this.mPaint.setColorFilter(colorFilter);
            super.invalidateSelf();
        }
    }
}
