package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class WebViewProgressBar extends View {
    private static final String LOG_TAG = "WebViewProgressBar";
    private Drawable mBackgroundDrawable;
    private Drawable mContrastDrawable;
    private WebViewProgressBarController mController;
    private boolean mEnableAlpha;
    private Drawable mProgressDrawable;

    public WebViewProgressBar(Context context) {
        super(context);
        this.mEnableAlpha = true;
        this.mContrastDrawable = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        super.onDraw(canvas);
        WebViewProgressBarController webViewProgressBarController = this.mController;
        if (webViewProgressBarController == null || webViewProgressBarController.getLoadingStep() == 6) {
            return;
        }
        if (this.mContrastDrawable != null && this.mProgressDrawable != null) {
            int currWidth = (int) this.mController.getCurrWidth();
            if (currWidth < this.mProgressDrawable.getIntrinsicWidth()) {
                i18 = currWidth - this.mProgressDrawable.getIntrinsicWidth();
                i17 = this.mProgressDrawable.getIntrinsicWidth();
            } else {
                i17 = currWidth;
                i18 = 0;
            }
            int i19 = i17 + i18;
            if (i19 > 0) {
                this.mContrastDrawable.setBounds(0, 0, getWidth(), getHeight());
                this.mContrastDrawable.draw(canvas);
                Drawable drawable = this.mBackgroundDrawable;
                if (drawable != null) {
                    drawable.setBounds(0, 0, getWidth(), getHeight());
                    this.mBackgroundDrawable.draw(canvas);
                }
            }
            this.mProgressDrawable.setBounds(i18, 0, i19, getHeight());
            this.mProgressDrawable.draw(canvas);
            return;
        }
        if (this.mBackgroundDrawable == null) {
            this.mBackgroundDrawable = getContext().getResources().getDrawable(R.drawable.skin_custom_progress_bg);
        }
        this.mBackgroundDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.mBackgroundDrawable.draw(canvas);
        if (this.mProgressDrawable == null) {
            this.mProgressDrawable = getContext().getResources().getDrawable(R.drawable.f162458gv4);
        }
        int currWidth2 = (int) this.mController.getCurrWidth();
        if (this.mEnableAlpha) {
            this.mProgressDrawable.setAlpha(this.mController.getAlpha());
        }
        if (currWidth2 < this.mProgressDrawable.getIntrinsicWidth()) {
            i16 = currWidth2 - this.mProgressDrawable.getIntrinsicWidth();
            i3 = this.mProgressDrawable.getIntrinsicWidth();
        } else {
            i3 = currWidth2;
            i16 = 0;
        }
        this.mProgressDrawable.setBounds(i16, 0, i3 + i16, getHeight());
        this.mProgressDrawable.draw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        WebViewProgressBarController webViewProgressBarController = this.mController;
        if (webViewProgressBarController != null) {
            webViewProgressBarController.setProgressBarWidth(getWidth());
        }
    }

    public void setController(WebViewProgressBarController webViewProgressBarController) {
        WebViewProgressBarController webViewProgressBarController2 = this.mController;
        if (webViewProgressBarController2 == webViewProgressBarController) {
            return;
        }
        if (webViewProgressBarController2 != null) {
            webViewProgressBarController2.setProgressBar(null);
        }
        this.mController = webViewProgressBarController;
        if (webViewProgressBarController != null) {
            webViewProgressBarController.setProgressBar(this);
            this.mController.setProgressBarWidth(getWidth());
        }
        invalidate();
    }

    public void setCustomColor(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "setCustomColor color=" + Integer.toHexString(i3));
        }
        this.mContrastDrawable = new ColorDrawable(-1);
        int i16 = i3 & Integer.MAX_VALUE;
        this.mBackgroundDrawable = new ColorDrawable(i16);
        this.mProgressDrawable = new ColorDrawable(i16);
        this.mEnableAlpha = false;
    }

    public void reset() {
        this.mBackgroundDrawable = null;
        this.mProgressDrawable = null;
        this.mContrastDrawable = null;
        this.mEnableAlpha = true;
    }

    public WebViewProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEnableAlpha = true;
        this.mContrastDrawable = null;
    }

    public WebViewProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mEnableAlpha = true;
        this.mContrastDrawable = null;
    }
}
