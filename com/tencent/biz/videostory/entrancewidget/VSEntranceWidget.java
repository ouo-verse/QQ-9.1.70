package com.tencent.biz.videostory.entrancewidget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.videostory.entrancewidget.b;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSEntranceWidget {

    /* renamed from: a, reason: collision with root package name */
    private View f97071a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f97072b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f97073c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f97074d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f97075e = false;

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet g() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setStartOffset(2240L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new b());
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private AnimationSet h() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setStartOffset(280L);
        scaleAnimation.setAnimationListener(new a());
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private AnimationSet i() {
        if (this.f97074d != null) {
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.setFillAfter(true);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setInterpolator(new OvershootInterpolator());
            scaleAnimation.setDuration(440L);
            scaleAnimation.setStartOffset(400L);
            scaleAnimation.setAnimationListener(new c());
            animationSet.addAnimation(scaleAnimation);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(320L);
            scaleAnimation2.setStartOffset(2400L);
            animationSet.addAnimation(scaleAnimation2);
            return animationSet;
        }
        return null;
    }

    private Drawable j(String str, final View view) {
        return ImageLoader.getInstance().loadImage(str, new ImageLoader.ImageLoadListener() { // from class: com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, final Drawable drawable, ImageLoader.Options options) {
                View view2;
                if (drawable != null && (view2 = view) != null) {
                    if (view2 instanceof FrameLayout) {
                        view2.post(new Runnable() { // from class: com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                view.setBackgroundDrawable(drawable);
                            }
                        });
                    } else if (view2 instanceof ImageView) {
                        view2.post(new Runnable() { // from class: com.tencent.biz.videostory.entrancewidget.VSEntranceWidget.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ((ImageView) view).setImageDrawable(drawable);
                            }
                        });
                    }
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        });
    }

    public void f(FrameLayout frameLayout, View view, String str) {
        this.f97072b = frameLayout;
        this.f97071a = view;
        b.d d16 = com.tencent.biz.videostory.entrancewidget.b.c().d(str);
        if (d16 != null && d16.b()) {
            this.f97075e = true;
            Drawable j3 = j(d16.f97119c, this.f97072b);
            if (j3 != null) {
                this.f97072b.setBackgroundDrawable(j3);
            }
            this.f97072b.setVisibility(4);
            ImageView imageView = (ImageView) this.f97072b.findViewById(R.id.aok);
            this.f97073c = imageView;
            Drawable j16 = j(d16.f97120d, imageView);
            if (j16 != null) {
                this.f97073c.setImageDrawable(j16);
            }
            this.f97073c.setVisibility(0);
            ImageView imageView2 = (ImageView) this.f97072b.findViewById(R.id.f167127l34);
            this.f97074d = imageView2;
            Drawable j17 = j(d16.f97122f, imageView2);
            if (j17 != null) {
                this.f97074d.setImageDrawable(j17);
            }
            this.f97074d.setVisibility(4);
            return;
        }
        QLog.e("Q.videostory.config.VSEntranceWidget", 1, "bindTargetView error!widgetConfig is null or resource not ready!");
        this.f97075e = false;
    }

    public void k() {
        if (this.f97075e) {
            this.f97072b.setVisibility(0);
            this.f97071a.setAlpha(0.0f);
            this.f97073c.clearAnimation();
            this.f97073c.startAnimation(h());
            this.f97074d.clearAnimation();
            this.f97074d.startAnimation(i());
        } else {
            this.f97072b.setVisibility(8);
        }
        QLog.d("Q.videostory.config.VSEntranceWidget", 1, "playWidgetAnimationset resourceReady:" + this.f97075e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (VSEntranceWidget.this.f97073c != null) {
                VSEntranceWidget.this.f97073c.clearAnimation();
                VSEntranceWidget.this.f97073c.startAnimation(VSEntranceWidget.this.g());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (VSEntranceWidget.this.f97072b != null) {
                VSEntranceWidget.this.f97072b.setVisibility(4);
            }
            if (VSEntranceWidget.this.f97071a != null) {
                VSEntranceWidget.this.f97071a.setAlpha(1.0f);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (VSEntranceWidget.this.f97074d != null) {
                VSEntranceWidget.this.f97074d.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
