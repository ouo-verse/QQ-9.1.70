package com.tencent.aelight.camera.ae.flashshow.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CameraFocusView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    protected int f65098d;

    /* renamed from: e, reason: collision with root package name */
    protected int f65099e;

    public CameraFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65098d = 0;
        this.f65099e = 0;
        setDrawableRes(R.drawable.iz9);
    }

    public void a() {
        clearAnimation();
        setVisibility(4);
    }

    public boolean c(MotionEvent motionEvent) {
        return b(motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    public void setDrawableRes(int i3) {
        Drawable drawable = getResources().getDrawable(i3);
        if (drawable != null) {
            this.f65098d = drawable.getMinimumWidth();
            this.f65099e = drawable.getMinimumHeight();
        }
    }

    public boolean b(float f16, float f17) {
        setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setStartOffset(1000L);
        alphaAnimation.setDuration(800L);
        alphaAnimation.setFillAfter(true);
        setPadding(((int) f16) - (this.f65098d / 2), ((int) f17) - (this.f65099e / 2), 0, 0);
        startAnimation(alphaAnimation);
        return true;
    }
}
