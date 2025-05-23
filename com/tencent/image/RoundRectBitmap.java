package com.tencent.image;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RoundRectBitmap {
    static IPatchRedirector $redirector_;
    public final Bitmap mBitmap;
    public final int mBoardColor;
    public final float mBorderWidth;
    public final float mCornerRadius;
    public int mDisplayHeight;
    public int mDisplayWidth;

    public RoundRectBitmap(Bitmap bitmap, float f16, int i3, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bitmap, Float.valueOf(f16), Integer.valueOf(i3), Float.valueOf(f17));
            return;
        }
        this.mBitmap = bitmap;
        this.mCornerRadius = f16;
        this.mBoardColor = i3;
        this.mBorderWidth = f17;
    }

    public int getByteSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return Utils.getBitmapSize(this.mBitmap);
    }

    public RoundRectBitmap(Bitmap bitmap, float f16) {
        this(bitmap, f16, -16777216, 0.0f);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, bitmap, Float.valueOf(f16));
    }
}
