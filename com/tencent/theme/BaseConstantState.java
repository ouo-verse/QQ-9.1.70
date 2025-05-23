package com.tencent.theme;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class BaseConstantState extends Drawable.ConstantState {
    static IPatchRedirector $redirector_ = null;
    public static final int BITMAP = 0;
    static final int INDEX_DENSITY = 2;
    static final int INDEX_HEIGHT = 1;
    static final int INDEX_WIDTH = 0;
    public static final int SCALE_BITMAP = 1;
    private static Paint sColorPaint;
    private static Paint sPaint;
    int bitmapType;
    boolean hasProblem;
    int[] mImageSizeWhenOOM;
    public SkinData skinData;

    public BaseConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.bitmapType = 0;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Paint getErrorBoundPaint() {
        if (sColorPaint == null) {
            Paint paint = new Paint();
            sColorPaint = paint;
            paint.setColor(1358888960);
        }
        return sColorPaint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Paint getErrorLinePaint() {
        if (sPaint == null) {
            Paint paint = new Paint();
            sPaint = paint;
            paint.setColor(SupportMenu.CATEGORY_MASK);
            sPaint.setStrokeWidth(4.0f);
        }
        return sPaint;
    }

    public static int scaleFromDensity(int i3, int i16, int i17) {
        if (i16 != 0 && i17 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    public void reloadTintColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "BaseConstantState{bitmapType=" + this.bitmapType + ", skinData=" + this.skinData + ", hasProblem=" + this.hasProblem + ", mImageSizeWhenOOM=" + Arrays.toString(this.mImageSizeWhenOOM) + '}';
    }

    public BaseConstantState(BaseConstantState baseConstantState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseConstantState);
            return;
        }
        this.bitmapType = 0;
        this.skinData = baseConstantState.skinData;
        this.bitmapType = baseConstantState.bitmapType;
        this.hasProblem = baseConstantState.hasProblem;
        this.mImageSizeWhenOOM = baseConstantState.mImageSizeWhenOOM;
    }
}
