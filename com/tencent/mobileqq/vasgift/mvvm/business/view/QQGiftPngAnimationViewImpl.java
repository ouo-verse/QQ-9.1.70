package com.tencent.mobileqq.vasgift.mvvm.business.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes20.dex */
public class QQGiftPngAnimationViewImpl implements sh2.a {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f311961a;

    /* renamed from: b, reason: collision with root package name */
    private qh2.a f311962b = null;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f311963c = null;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f311964d = "";

    /* renamed from: e, reason: collision with root package name */
    private boolean f311965e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPngAnimationViewImpl$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f311966d;

        AnonymousClass1(String str) {
            this.f311966d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int dip2px = ScreenUtil.dip2px(250.0f);
            QQGiftPngAnimationViewImpl qQGiftPngAnimationViewImpl = QQGiftPngAnimationViewImpl.this;
            qQGiftPngAnimationViewImpl.f311963c = BitmapUtils.decodeSampleBitmap(qQGiftPngAnimationViewImpl.f311961a.getContext(), this.f311966d, dip2px, dip2px);
            QQGiftPngAnimationViewImpl.this.f311961a.post(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPngAnimationViewImpl.1.1

                /* renamed from: com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPngAnimationViewImpl$1$1$a */
                /* loaded from: classes20.dex */
                class a implements ValueAnimator.AnimatorUpdateListener {
                    a() {
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int i3;
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (floatValue < 300.0f) {
                            i3 = (int) ((floatValue / 300.0f) * 255.0f);
                        } else if (1300.0f < floatValue && floatValue <= 1600.0f) {
                            i3 = (int) ((1.0f - ((floatValue - 1300.0f) / 300.0f)) * 255.0f);
                        } else {
                            i3 = 255;
                        }
                        QQGiftPngAnimationViewImpl.this.f311961a.setAlpha(i3);
                    }
                }

                /* renamed from: com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPngAnimationViewImpl$1$1$b */
                /* loaded from: classes20.dex */
                class b implements Animator.AnimatorListener {
                    b() {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator, boolean z16) {
                        onAnimationEnd(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator, boolean z16) {
                        onAnimationStart(animator);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (QQGiftPngAnimationViewImpl.this.f311965e) {
                            return;
                        }
                        if (QQGiftPngAnimationViewImpl.this.f311962b != null) {
                            QQGiftPngAnimationViewImpl.this.f311962b.onAnimationEnd();
                        }
                        QQGiftPngAnimationViewImpl.this.f311961a.setImageBitmap(null);
                        if (QQGiftPngAnimationViewImpl.this.f311963c != null) {
                            QQGiftPngAnimationViewImpl.this.f311963c.recycle();
                            QQGiftPngAnimationViewImpl.this.f311963c = null;
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        if (QQGiftPngAnimationViewImpl.this.f311962b != null) {
                            QQGiftPngAnimationViewImpl.this.f311962b.onAnimationStart();
                        }
                        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GIFT_VIEW_IMPL_PLAY_START, "png");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!TextUtils.isEmpty(AnonymousClass1.this.f311966d)) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (anonymousClass1.f311966d.equals(QQGiftPngAnimationViewImpl.this.f311964d)) {
                            QQGiftPngAnimationViewImpl.this.f311961a.setImageBitmap(QQGiftPngAnimationViewImpl.this.f311963c);
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1600.0f);
                            ofFloat.setDuration(1600L);
                            ofFloat.addUpdateListener(new a());
                            ofFloat.addListener(new b());
                            ofFloat.start();
                            return;
                        }
                    }
                    QLog.e("QQGiftPngAnimationViewImpl", 1, "playCancel cause path is not match");
                }
            });
        }
    }

    public QQGiftPngAnimationViewImpl(Context context) {
        this.f311961a = new ImageView(context);
    }

    @Override // sh2.a
    public FrameLayout.LayoutParams a(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        int dpToPx = ImmersiveUtils.dpToPx(250.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(100.0f);
        return layoutParams;
    }

    @Override // sh2.a
    public void b(qh2.a aVar) {
        this.f311962b = aVar;
    }

    @Override // sh2.a
    public synchronized void c(String str) {
        this.f311965e = false;
        this.f311964d = str;
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GIFT_VIEW_IMPL_PLAY, "png");
        ThreadManager.c(new AnonymousClass1(str), true);
    }

    @Override // sh2.a
    public View d() {
        return this.f311961a;
    }

    @Override // sh2.a
    public synchronized void stop() {
        this.f311965e = true;
        this.f311964d = "";
        this.f311961a.clearAnimation();
    }
}
