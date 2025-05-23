package com.tencent.mobileqq.vasgift.mvvm.business.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements sh2.a {

    /* renamed from: a, reason: collision with root package name */
    private qh2.a f311970a = null;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private ImageView f311971b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f311972c;

    /* renamed from: d, reason: collision with root package name */
    private final AnimatorSet f311973d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vasgift.mvvm.business.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8939a extends AnimatorListenerAdapter {
        C8939a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (a.this.f311970a != null) {
                a.this.f311970a.onAnimationEnd();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (a.this.f311970a != null) {
                a.this.f311970a.onAnimationStart();
            }
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GIFT_VIEW_IMPL_PLAY_START, VasPerfReportUtils.JUNIOR_GIFT_VIEW);
        }
    }

    public a(Context context) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f311973d = animatorSet;
        this.f311972c = context;
        ImageView imageView = new ImageView(context);
        this.f311971b = imageView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f311971b, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f311971b, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat2.setDuration(500L);
        ofFloat3.setDuration(500L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat3).after(2500L);
        animatorSet.addListener(new C8939a());
    }

    @Override // sh2.a
    public FrameLayout.LayoutParams a(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        layoutParams.width = ImmersiveUtils.dpToPx(225.0f);
        layoutParams.height = ImmersiveUtils.dpToPx(225.0f);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(100.0f);
        return layoutParams;
    }

    @Override // sh2.a
    public void b(qh2.a aVar) {
        this.f311970a = aVar;
    }

    @Override // sh2.a
    public void c(String str) {
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GIFT_VIEW_IMPL_PLAY, VasPerfReportUtils.JUNIOR_GIFT_VIEW);
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            this.f311971b.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(str));
            this.f311973d.start();
        }
    }

    @Override // sh2.a
    public View d() {
        return this.f311971b;
    }

    @Override // sh2.a
    public void stop() {
        this.f311973d.cancel();
    }
}
