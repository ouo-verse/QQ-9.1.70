package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CoverTextView extends CoverView {
    private TextView textView;

    public CoverTextView(@NonNull Context context) {
        super(context);
        this.textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.textView.setGravity(16);
        addView(this.textView, layoutParams);
    }

    public TextView getTextView() {
        return this.textView;
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        super.setAlpha(f16);
        this.textView.setAlpha(f16);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        super.setBackgroundColor(i3);
        this.textView.setBackgroundColor(i3);
    }

    public void setBorder(int i3, int i16, float f16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i17);
        gradientDrawable.setCornerRadius(f16 * DisplayUtil.getDensity(getContext()));
        if (i3 > 0) {
            gradientDrawable.setStroke(i3, i16);
        }
        this.textView.setBackgroundDrawable(gradientDrawable);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.textView.setEllipsize(truncateAt);
    }

    public void setGravity(int i3) {
        this.textView.setGravity(i3 | 16);
    }

    public void setIncludeFontPadding(boolean z16) {
        this.textView.setIncludeFontPadding(z16);
    }

    public void setLineSpacing(float f16, float f17) {
        this.textView.setLineSpacing(f16, f17);
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        this.textView.setPadding(i3, i16, i17, i18);
    }

    @Override // android.view.View
    public void setScaleX(float f16) {
        this.textView.setScaleX(f16);
    }

    @Override // android.view.View
    public void setScaleY(float f16) {
        this.textView.setScaleY(f16);
    }

    public void setSingleLine(boolean z16) {
        this.textView.setSingleLine(z16);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setTextColor(int i3) {
        this.textView.setTextColor(i3);
    }

    public void setTextSize(float f16) {
        this.textView.setTextSize(f16);
    }

    public void setTypeface(Typeface typeface) {
        this.textView.setTypeface(typeface);
    }

    public void setTextSize(int i3, float f16) {
        this.textView.setTextSize(i3, f16);
    }
}
