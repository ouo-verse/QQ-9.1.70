package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.ThemeImageView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ForwardHeadView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Context f315674d;

    /* renamed from: e, reason: collision with root package name */
    private ThemeImageView f315675e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f315676f;

    public ForwardHeadView(Context context) {
        this(context, null);
    }

    private void b() {
        this.f315675e = new ThemeImageView(this.f315674d);
        addView(this.f315675e, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this.f315674d);
        this.f315676f = imageView;
        addView(imageView);
    }

    public ImageView a() {
        return this.f315675e;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        float measuredWidth = getMeasuredWidth();
        int i17 = (int) (0.55f * measuredWidth);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i17, i17);
        layoutParams.gravity = 85;
        int i18 = -((int) (measuredWidth * 0.075f));
        layoutParams.bottomMargin = i18;
        layoutParams.rightMargin = i18;
        this.f315676f.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        this.f315675e.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        this.f315675e.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        this.f315675e.setBackgroundResource(i3);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f315675e.setImageDrawable(drawable);
    }

    public void setImageResource(int i3) {
        this.f315675e.setImageResource(i3);
    }

    public void setShowGuildIcon(boolean z16) {
        int i3;
        int i16;
        if (QQTheme.isNowThemeIsNight()) {
            i3 = R.drawable.jns;
        } else {
            i3 = R.drawable.jnr;
        }
        setShowIcon(i3);
        ImageView imageView = this.f315676f;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView.setVisibility(i16);
    }

    public void setShowIcon(int i3) {
        this.f315676f.setImageResource(i3);
    }

    public ForwardHeadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForwardHeadView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315674d = context;
        b();
    }
}
