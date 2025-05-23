package com.tencent.ams.fusion.widget.downloadcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadButton extends View {
    static IPatchRedirector $redirector_;
    private float mCornerRadius;
    private GradientDrawable mDrawableButton;
    private GradientDrawable mDrawableProgress;
    private GradientDrawable mDrawableProgressBackground;
    private float mProgress;
    private String mText;
    private float mTextBaseLineY;
    private Paint mTextPaint;
    private Paint mTextProgressPaint;

    public DownloadButton(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mCornerRadius = Utils.dp2px(40.0f);
        this.mDrawableButton = new GradientDrawable();
        this.mDrawableProgressBackground = new GradientDrawable();
        this.mDrawableProgress = new GradientDrawable();
        initialize(context);
    }

    private Paint createTextPaint() {
        int i3;
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setAntiAlias(true);
        paint.setTextSize(Utils.dp2px(16.0f));
        if (ViewUtils.isDarkMode()) {
            i3 = DownloadCardView.COLOR_APP_NAME_DARK;
        } else {
            i3 = -1;
        }
        paint.setColor(i3);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setFakeBoldText(true);
        return paint;
    }

    private float getTextBaseLineY() {
        if (this.mTextBaseLineY == 0.0f) {
            Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
            this.mTextBaseLineY = (int) (((getMeasuredHeight() / 2) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f));
        }
        return this.mTextBaseLineY;
    }

    private void initialize(Context context) {
        int i3;
        this.mTextPaint = createTextPaint();
        this.mTextProgressPaint = createTextPaint();
        GradientDrawable gradientDrawable = this.mDrawableProgressBackground;
        if (ViewUtils.isDarkMode()) {
            i3 = DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK;
        } else {
            i3 = -657931;
        }
        gradientDrawable.setColor(i3);
        setBackgroundDrawable(this.mDrawableProgressBackground);
    }

    @Override // android.view.View
    public void invalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.mDrawableButton.setCornerRadius(this.mCornerRadius);
        this.mDrawableProgressBackground.setCornerRadius(this.mCornerRadius);
        this.mDrawableProgress.setCornerRadius(this.mCornerRadius);
        super.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        if (!TextUtils.isEmpty(this.mText)) {
            canvas.drawText(this.mText, getMeasuredWidth() / 2, getTextBaseLineY(), this.mTextPaint);
        }
        float f16 = this.mProgress;
        if (f16 >= 0.0f && f16 <= 100.0f) {
            RectF rectF = new RectF(0.0f, 0.0f, getMeasuredWidth() * (this.mProgress / 100.0f), getMeasuredHeight());
            Path path = new Path();
            path.addRect(rectF, Path.Direction.CW);
            path.close();
            canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
            canvas.clipPath(path, Region.Op.INTERSECT);
            this.mDrawableProgress.setBounds(new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()));
            this.mDrawableProgress.draw(canvas);
            if (!TextUtils.isEmpty(this.mText)) {
                canvas.drawText(this.mText, getMeasuredWidth() / 2, getTextBaseLineY(), this.mTextProgressPaint);
            }
            canvas.restore();
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mProgress = 0.0f;
            invalidate();
        }
    }

    public void setCornerRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mCornerRadius = f16;
        }
    }

    public void setProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.mProgress = Math.max(Math.min(f16, 100.0f), 0.0f);
            invalidate();
        }
    }

    public void setProgressBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mDrawableProgressBackground.setColor(i3);
            invalidate();
        }
    }

    public void setProgressColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mDrawableProgress.setColor(i3);
            invalidate();
        }
    }

    public void setText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mText = str;
            invalidate();
        }
    }

    public void setThemeColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.mDrawableButton.setColor(i3);
        this.mDrawableProgress.setColor(i3);
        Paint paint = this.mTextPaint;
        if (ViewUtils.isDarkMode()) {
            i3 = DownloadCardView.COLOR_APP_NAME_DARK;
        }
        paint.setColor(i3);
        invalidate();
    }
}
