package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThemeImageWrapper {
    static IPatchRedirector $redirector_;
    public static int MODE_CIRCLE;
    public static int MODE_OTHER;
    public static int MODE_SQURE;
    public static final ColorFilter NIGHT_MODE_COLOR_FILTER;
    public static final int NIGHT_MODE_MASK_COLOR;
    int defColor;
    boolean isSupportMaskView;
    boolean mAdaptThemeForHead;
    Paint mMaskPaint;
    private int maskColor;
    private ColorFilter maskColorFilter;
    private int maskMode;
    RectF tempRectF;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface DrawInterface {
        int getHeight();

        int getWidth();

        void superOnDraw(Canvas canvas);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56406);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        MODE_CIRCLE = 1;
        MODE_SQURE = 2;
        MODE_OTHER = 3;
        int parseColor = Color.parseColor("#1E000000");
        NIGHT_MODE_MASK_COLOR = parseColor;
        NIGHT_MODE_COLOR_FILTER = new PorterDuffColorFilter(parseColor, PorterDuff.Mode.SRC_ATOP);
    }

    public ThemeImageWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isSupportMaskView = true;
        this.tempRectF = new RectF();
        this.maskMode = MODE_CIRCLE;
        this.maskColor = QQTheme.NIGHTMODE_MASKCOLOR;
        this.maskColorFilter = QQTheme.NIGHTMODE_COLORFILTER;
        this.mAdaptThemeForHead = false;
        Paint paint = new Paint();
        this.mMaskPaint = paint;
        paint.setAntiAlias(true);
        this.mMaskPaint.setColorFilter(this.maskColorFilter);
        this.defColor = this.mMaskPaint.getColor();
    }

    public static boolean isNightMode() {
        if (!"1103".equals(QQTheme.getCurrentThemeId()) && !"2920".equals(QQTheme.getCurrentThemeId())) {
            return false;
        }
        return true;
    }

    public static boolean isNightModeForSimpleUI() {
        return "2920".equals(QQTheme.getCurrentThemeId());
    }

    public void adaptThemeForHead(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mAdaptThemeForHead = z16;
        }
    }

    public void onDraw(Canvas canvas, DrawInterface drawInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas, (Object) drawInterface);
            return;
        }
        if (canvas != null && drawInterface != null) {
            if (this.isSupportMaskView && isNightMode()) {
                this.tempRectF.set(0.0f, 0.0f, drawInterface.getWidth(), drawInterface.getHeight());
                int i3 = this.maskMode;
                if (isNightModeForSimpleUI()) {
                    i3 = MODE_OTHER;
                }
                if (i3 == MODE_CIRCLE) {
                    drawInterface.superOnDraw(canvas);
                    this.mMaskPaint.setColorFilter(null);
                    this.mMaskPaint.setColor(this.maskColor);
                    RectF rectF = this.tempRectF;
                    canvas.drawRoundRect(rectF, rectF.centerX(), this.tempRectF.centerY(), this.mMaskPaint);
                    return;
                }
                if (i3 == MODE_SQURE) {
                    drawInterface.superOnDraw(canvas);
                    this.mMaskPaint.setColorFilter(null);
                    this.mMaskPaint.setColor(this.maskColor);
                    canvas.drawRect(this.tempRectF, this.mMaskPaint);
                    return;
                }
                if (this.mMaskPaint.getColorFilter() == null) {
                    this.mMaskPaint.setColorFilter(this.maskColorFilter);
                }
                this.mMaskPaint.setColor(this.defColor);
                canvas.saveLayer(null, this.mMaskPaint, 31);
                drawInterface.superOnDraw(canvas);
                canvas.restore();
                return;
            }
            drawInterface.superOnDraw(canvas);
        }
    }

    public void setMaskShape(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.maskMode = i3;
        }
    }

    public void setSupportMaskView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isSupportMaskView = z16;
        }
    }

    public void setThirtyTransparencyMask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.maskColor = NIGHT_MODE_MASK_COLOR;
        this.maskColorFilter = NIGHT_MODE_COLOR_FILTER;
        Paint paint = new Paint();
        this.mMaskPaint = paint;
        paint.setAntiAlias(true);
        this.mMaskPaint.setColorFilter(this.maskColorFilter);
        this.defColor = this.mMaskPaint.getColor();
    }
}
