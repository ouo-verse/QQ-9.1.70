package com.tencent.mobileqq.selectfriend.relationlist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ForwardAvatarView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Context f285536d;

    /* renamed from: e, reason: collision with root package name */
    private QQProAvatarView f285537e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f285538f;

    public ForwardAvatarView(Context context) {
        this(context, null);
    }

    private void b() {
        this.f285537e = new QQProAvatarView(this.f285536d, null);
        addView(this.f285537e, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this.f285536d);
        this.f285538f = imageView;
        addView(imageView);
    }

    public QQProAvatarView a() {
        return this.f285537e;
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
        this.f285538f.setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        this.f285537e.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        this.f285537e.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        this.f285537e.setBackgroundResource(i3);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f285537e.setImageDrawable(drawable);
    }

    public void setImageResource(int i3) {
        this.f285537e.setImageResource(i3);
    }

    public void setShowGuildIcon(boolean z16) {
        setShowIcon(QQTheme.isNowThemeIsNight() ? R.drawable.jns : R.drawable.jnr);
        this.f285538f.setVisibility(z16 ? 0 : 8);
    }

    public void setShowIcon(int i3) {
        this.f285538f.setImageResource(i3);
    }

    public ForwardAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForwardAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f285536d = context;
        b();
    }
}
