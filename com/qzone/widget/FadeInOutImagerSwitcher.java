package com.qzone.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class FadeInOutImagerSwitcher extends RelativeLayout implements Animation.AnimationListener, ImageLoader.ImageLoadListener {
    private int C;
    private Handler D;
    private ImageLoader.Options E;

    /* renamed from: d, reason: collision with root package name */
    private ImageSwitcher f60375d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f60376e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f60377f;

    /* renamed from: h, reason: collision with root package name */
    private String f60378h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f60379i;

    /* renamed from: m, reason: collision with root package name */
    private int f60380m;

    public FadeInOutImagerSwitcher(Context context) {
        this(context, null);
    }

    private void d(Context context) {
        this.f60375d = (ImageSwitcher) LayoutInflater.from(context).inflate(R.layout.bkw, (ViewGroup) this, true).findViewById(R.id.dei);
        if (isInEditMode()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f154548b2);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.f154550b4);
        loadAnimation.setAnimationListener(this);
        loadAnimation2.setAnimationListener(this);
        this.f60375d.setInAnimation(loadAnimation);
        this.f60375d.setOutAnimation(loadAnimation2);
        this.f60375d.setAnimateFirstView(true);
    }

    public void setFadeInDuration(long j3) {
        Animation inAnimation = this.f60375d.getInAnimation();
        if (inAnimation != null) {
            inAnimation.setDuration(j3);
        }
    }

    public void setFadeOutDuration(long j3) {
        Animation outAnimation = this.f60375d.getOutAnimation();
        if (outAnimation != null) {
            outAnimation.setDuration(j3);
        }
    }

    public void setImageOption(ImageLoader.Options options) {
        this.E = options;
    }

    public void setImageResource(int i3, boolean z16) {
        ImageSwitcher imageSwitcher = this.f60375d;
        if (imageSwitcher == null) {
            QZLog.w("FadeInOutImagerSwitcher", "[setImageResource] mImageSwitch is null");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) imageSwitcher.getCurrentView();
        this.f60377f = viewGroup;
        if (viewGroup == null) {
            QZLog.w("FadeInOutImagerSwitcher", "[setImageResource] mDisplayView is null");
            return;
        }
        ImageView imageView = (ImageView) viewGroup.getChildAt(0);
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(i3);
        }
        View childAt = this.f60377f.getChildAt(1);
        if (childAt != null) {
            childAt.setVisibility(z16 ? 0 : 8);
        }
    }

    public FadeInOutImagerSwitcher(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f60376e = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f60376e = true;
    }

    public FadeInOutImagerSwitcher(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new Handler(Looper.getMainLooper());
        d(context);
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
        if (str == null || !str.equals(this.f60378h) || drawable == null) {
            return;
        }
        final boolean z16 = this.f60379i;
        final int i3 = this.f60380m;
        this.D.post(new Runnable() { // from class: com.qzone.widget.FadeInOutImagerSwitcher.1
            @Override // java.lang.Runnable
            public void run() {
                if (FadeInOutImagerSwitcher.this.f60377f == null || drawable == null) {
                    return;
                }
                FadeInOutImagerSwitcher.this.C = i3;
                ImageView imageView = (ImageView) FadeInOutImagerSwitcher.this.f60377f.getChildAt(0);
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setImageDrawable(drawable);
                }
                View childAt = FadeInOutImagerSwitcher.this.f60377f.getChildAt(1);
                if (childAt != null) {
                    childAt.setVisibility(z16 ? 0 : 8);
                }
                if (FadeInOutImagerSwitcher.this.f60377f == FadeInOutImagerSwitcher.this.f60375d.getNextView()) {
                    FadeInOutImagerSwitcher.this.f60375d.showNext();
                }
                FadeInOutImagerSwitcher.this.invalidate();
            }
        });
    }

    public void setFadeInInterpolator(Interpolator interpolator) {
        Animation inAnimation;
        if (interpolator == null || (inAnimation = this.f60375d.getInAnimation()) == null) {
            return;
        }
        inAnimation.setInterpolator(interpolator);
    }

    public void setFadeOutInterpolator(Interpolator interpolator) {
        Animation outAnimation;
        if (interpolator == null || (outAnimation = this.f60375d.getOutAnimation()) == null) {
            return;
        }
        outAnimation.setInterpolator(interpolator);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageCanceled(String str, ImageLoader.Options options) {
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageFailed(String str, ImageLoader.Options options) {
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageProgress(String str, float f16, ImageLoader.Options options) {
    }
}
