package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TokenResUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    int f255364d;

    /* renamed from: e, reason: collision with root package name */
    TextView f255365e;

    /* renamed from: f, reason: collision with root package name */
    URLImageView f255366f;

    /* renamed from: h, reason: collision with root package name */
    TextView f255367h;

    public OnlineStatusView(Context context) {
        super(context);
        this.f255364d = 1;
        d();
    }

    public CharSequence a() {
        CharSequence text = this.f255365e.getText();
        CharSequence text2 = this.f255367h.getText();
        StringBuilder sb5 = new StringBuilder(10);
        sb5.append(text);
        sb5.append(text2);
        return sb5.toString();
    }

    public int b() {
        CharSequence text = this.f255365e.getText();
        CharSequence text2 = this.f255367h.getText();
        int measureText = (int) this.f255365e.getPaint().measureText(text, 0, text.length());
        int measureText2 = (int) this.f255367h.getPaint().measureText(text2, 0, text2.length());
        int dip2px = ViewUtils.dip2px(2.0f);
        int dip2px2 = ViewUtils.dip2px(12.0f);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusView", 2, "prefixLen:", Integer.valueOf(measureText), " suffixLen:", Integer.valueOf(measureText2), " iconLen:", Integer.valueOf(dip2px2));
        }
        return measureText + dip2px2 + measureText2 + dip2px;
    }

    public TextView c() {
        return this.f255367h;
    }

    void d() {
        setOrientation(0);
        setGravity(16);
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158570j9);
        TextView textView = new TextView(getContext());
        this.f255365e = textView;
        textView.setDuplicateParentStateEnabled(false);
        this.f255365e.setIncludeFontPadding(false);
        this.f255365e.setSingleLine(true);
        this.f255365e.setTextColor(getResources().getColor(TokenResUtils.getTokenRes(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
        this.f255365e.setTextSize(0, dimensionPixelSize);
        this.f255365e.setText("[");
        this.f255365e.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(19.0f));
        layoutParams.gravity = 16;
        addView(this.f255365e, layoutParams);
        URLImageView uRLImageView = new URLImageView(getContext());
        this.f255366f = uRLImageView;
        uRLImageView.setDuplicateParentStateEnabled(false);
        this.f255366f.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(12.0f), ViewUtils.dip2px(12.0f));
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = ViewUtils.dip2px(2.0f);
        layoutParams2.rightMargin = ViewUtils.dip2px(2.0f);
        addView(this.f255366f, layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.f255367h = textView2;
        textView2.setDuplicateParentStateEnabled(false);
        this.f255367h.setIncludeFontPadding(false);
        this.f255367h.setSingleLine(true);
        this.f255367h.setTextColor(getResources().getColor(TokenResUtils.getTokenRes(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
        this.f255367h.setTextSize(0, dimensionPixelSize);
        this.f255367h.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(19.0f));
        layoutParams3.gravity = 16;
        addView(this.f255367h, layoutParams3);
    }

    public void setDescText(String str) {
        if (this.f255364d == 2) {
            this.f255365e.setVisibility(0);
            this.f255367h.setText(str + "]");
            return;
        }
        this.f255365e.setVisibility(8);
        this.f255367h.setText(str);
    }

    public void setIconDrawable(Drawable drawable) {
        this.f255366f.setImageDrawable(drawable);
    }

    public void setTextSize(int i3) {
        float f16 = i3;
        this.f255365e.setTextSize(0, f16);
        this.f255367h.setTextSize(0, f16);
    }

    public void setViewStyle(int i3) {
        this.f255364d = i3;
    }

    public OnlineStatusView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f255364d = 1;
        d();
    }

    public OnlineStatusView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f255364d = 1;
        d();
    }
}
