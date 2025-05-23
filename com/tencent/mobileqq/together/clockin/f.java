package com.tencent.mobileqq.together.clockin;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends e implements Observer {

    /* renamed from: e, reason: collision with root package name */
    private Context f293370e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f293371f;

    /* renamed from: h, reason: collision with root package name */
    private LottieAnimationView f293372h;

    /* renamed from: i, reason: collision with root package name */
    private c f293373i;

    public f(LottieAnimationView lottieAnimationView, RelativeLayout relativeLayout, Context context, com.tencent.mobileqq.together.clockin.a aVar, c cVar) {
        super(aVar);
        if (aVar != null) {
            aVar.addObserver(this);
        }
        this.f293370e = context;
        this.f293371f = relativeLayout;
        this.f293373i = cVar;
        this.f293372h = lottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
            this.f293372h.addAnimatorListener(new a());
            c cVar2 = this.f293373i;
            if (cVar2 != null && !TextUtils.isEmpty(cVar2.f293353p)) {
                this.f293372h.setAnimationFromUrl(this.f293373i.f293353p);
            }
        }
    }

    private void e() {
        c cVar;
        if (this.f293371f != null && this.f293372h != null && this.f293370e != null && (cVar = this.f293373i) != null && !TextUtils.isEmpty(cVar.f293353p)) {
            int instantScreenHeight = ScreenUtil.getInstantScreenHeight(this.f293370e);
            int[] iArr = new int[2];
            this.f293371f.getLocationOnScreen(iArr);
            int height = (instantScreenHeight - iArr[1]) - this.f293371f.getHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f293372h.getLayoutParams();
            int dpToPx = height - ViewUtils.dpToPx(30.0f);
            layoutParams.bottomMargin = dpToPx;
            if (dpToPx + ViewUtils.dpToPx(170.0f) > instantScreenHeight) {
                layoutParams.bottomMargin = (instantScreenHeight - ViewUtils.dpToPx(170.0f)) + ViewUtils.dpToPx(30.0f);
            }
            this.f293372h.setLayoutParams(layoutParams);
            this.f293372h.setVisibility(0);
            this.f293372h.setAnimationFromUrl(this.f293373i.f293353p);
            this.f293372h.loop(false);
            this.f293372h.playAnimation();
        }
    }

    public void d() {
        LottieAnimationView lottieAnimationView = this.f293372h;
        if (lottieAnimationView != null) {
            lottieAnimationView.removeAllAnimatorListeners();
            if (this.f293372h.isAnimating()) {
                this.f293372h.cancelAnimation();
            }
            this.f293372h = null;
        }
    }

    public void f(int i3) {
        LottieAnimationView lottieAnimationView = this.f293372h;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i3);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((obj instanceof Integer) && ((Integer) obj).intValue() == 4) {
            e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f.this.f293372h != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("IntegralClockView", 2, "integralLottieView play end");
                }
                f.this.f293372h.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.d("IntegralClockView", 2, "integralLottieView play start");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
