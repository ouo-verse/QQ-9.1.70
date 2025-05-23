package com.tencent.mobileqq.nearby.now.view.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LikeAniView extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    /* renamed from: d, reason: collision with root package name */
    private int f252978d;

    /* renamed from: e, reason: collision with root package name */
    private int f252979e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f252980f;

    /* renamed from: h, reason: collision with root package name */
    private Interpolator f252981h;

    /* renamed from: i, reason: collision with root package name */
    private Interpolator f252982i;

    public LikeAniView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f252978d = (int) ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 90.0f);
        this.f252979e = (int) ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 90.0f);
        this.f252980f = new ImageView(getContext());
        addView(this.f252980f, new FrameLayout.LayoutParams(this.f252978d, this.f252979e));
        this.f252980f.setImageResource(((IResourceUtil) QRoute.api(IResourceUtil.class)).getNearbyNowliveShortvideoLike());
        this.f252980f.setVisibility(8);
    }

    public void b(int i3, int i16) {
        int nextInt = new Random().nextInt(40) - 20;
        this.f252980f.setX(i3 - (this.f252978d / 2));
        this.f252980f.setY(i16 - (this.f252979e / 2));
        this.f252980f.setRotation(nextInt);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.3f, 0.85f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(this);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.85f, 1.0f);
        ofFloat2.setDuration(150L);
        ofFloat2.addUpdateListener(this);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.95f);
        ofFloat3.setDuration(150L);
        ofFloat3.addUpdateListener(this);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.95f, 1.0f);
        ofFloat4.setDuration(150L);
        ofFloat4.addUpdateListener(this);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        animatorSet.addListener(this);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f252980f, c.f123400v, 1.0f, 0.0f);
        ofFloat5.setDuration(1500L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorSet, ofFloat5);
        animatorSet2.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f252980f.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f252980f.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f252980f.setVisibility(0);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Float f16 = (Float) valueAnimator.getAnimatedValue();
        this.f252980f.setScaleX(f16.floatValue());
        this.f252980f.setScaleY(f16.floatValue());
    }

    public LikeAniView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LikeAniView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f252978d = 180;
        this.f252979e = 180;
        this.f252981h = new DecelerateInterpolator(1.5f);
        this.f252982i = new LinearInterpolator();
        a();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
