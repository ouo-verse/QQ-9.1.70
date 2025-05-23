package com.tencent.now.od.ui.game.meleegame.widget.scorebar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AddScoreTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private AnimationSet f338580d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f338581e;

    public AddScoreTextView(Context context) {
        super(context);
    }

    private void a() {
        AnimationSet animationSet = this.f338580d;
        if (animationSet != null) {
            animationSet.cancel();
        }
        clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.4f, 1, -0.3f);
        translateAnimation.setDuration(400L);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.5f);
        translateAnimation2.setStartOffset(400L);
        translateAnimation2.setDuration(400L);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.2f);
        translateAnimation3.setStartOffset(800L);
        translateAnimation3.setDuration(400L);
        AnimationSet animationSet2 = new AnimationSet(true);
        this.f338580d = animationSet2;
        animationSet2.addAnimation(alphaAnimation);
        this.f338580d.addAnimation(translateAnimation);
        this.f338580d.addAnimation(translateAnimation2);
        this.f338580d.addAnimation(translateAnimation3);
        this.f338580d.setAnimationListener(new a());
        startAnimation(this.f338580d);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f338581e = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f338581e = false;
        AnimationSet animationSet = this.f338580d;
        if (animationSet != null) {
            animationSet.cancel();
        }
        clearAnimation();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.f338581e) {
            a();
        }
    }

    public AddScoreTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddScoreTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AddScoreTextView.this.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AddScoreTextView.this.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
