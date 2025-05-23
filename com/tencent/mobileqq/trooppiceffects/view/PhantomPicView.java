package com.tencent.mobileqq.trooppiceffects.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.f;

/* loaded from: classes19.dex */
public class PhantomPicView extends FrameLayout implements a {
    static IPatchRedirector $redirector_;
    protected boolean C;

    /* renamed from: d, reason: collision with root package name */
    protected ImageView f303302d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f303303e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f303304f;

    /* renamed from: h, reason: collision with root package name */
    protected FrameLayout f303305h;

    /* renamed from: i, reason: collision with root package name */
    protected FrameLayout f303306i;

    /* renamed from: m, reason: collision with root package name */
    protected Handler f303307m;

    public PhantomPicView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f303307m = new Handler(Looper.getMainLooper());
        this.f303302d = new ImageView(context);
        this.f303303e = new ImageView(context);
        this.f303304f = new ImageView(context);
        this.f303305h = new FrameLayout(context);
        this.f303306i = new FrameLayout(context);
        this.f303302d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f303303e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f303304f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f303302d, -1, -1);
        addView(this.f303305h, -1, -1);
        addView(this.f303306i, -1, -1);
        this.f303305h.addView(this.f303303e, -1, -1);
        this.f303306i.addView(this.f303304f, -1, -1);
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.C) {
            return;
        }
        this.f303305h.setVisibility(0);
        Keyframe[] keyframeArr = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.33f, 1.1f), Keyframe.ofFloat(1.0f, 1.0f)};
        Keyframe[] keyframeArr2 = {Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.33f, 0.8f), Keyframe.ofFloat(0.66f, 0.8f), Keyframe.ofFloat(1.0f, 0.0f)};
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(BasicAnimation.KeyPath.SCALE_X, keyframeArr);
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(BasicAnimation.KeyPath.SCALE_Y, keyframeArr);
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f303305h, ofKeyframe).setDuration(320L);
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.f303305h, ofKeyframe2).setDuration(320L);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(this.f303305h, PropertyValuesHolder.ofKeyframe(c.f123400v, keyframeArr2)).setDuration(320L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).with(duration3);
        animatorSet.start();
        this.f303305h.setTag(animatorSet);
        this.f303307m.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.trooppiceffects.view.PhantomPicView.1
            static IPatchRedirector $redirector_;

            /* renamed from: com.tencent.mobileqq.trooppiceffects.view.PhantomPicView$1$a */
            /* loaded from: classes19.dex */
            class a extends f {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
                    }
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
                    } else {
                        PhantomPicView.this.a();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                    }
                }

                @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhantomPicView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                PhantomPicView.this.f303306i.setVisibility(0);
                Keyframe[] keyframeArr3 = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.33f, 1.1f), Keyframe.ofFloat(1.0f, 1.0f)};
                Keyframe[] keyframeArr4 = {Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.33f, 0.8f), Keyframe.ofFloat(0.66f, 0.8f), Keyframe.ofFloat(1.0f, 0.0f)};
                PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe(BasicAnimation.KeyPath.SCALE_X, keyframeArr3);
                PropertyValuesHolder ofKeyframe4 = PropertyValuesHolder.ofKeyframe(BasicAnimation.KeyPath.SCALE_Y, keyframeArr3);
                ObjectAnimator duration4 = ObjectAnimator.ofPropertyValuesHolder(PhantomPicView.this.f303306i, ofKeyframe3).setDuration(320L);
                ObjectAnimator duration5 = ObjectAnimator.ofPropertyValuesHolder(PhantomPicView.this.f303306i, ofKeyframe4).setDuration(320L);
                ObjectAnimator duration6 = ObjectAnimator.ofPropertyValuesHolder(PhantomPicView.this.f303306i, PropertyValuesHolder.ofKeyframe(c.f123400v, keyframeArr4)).setDuration(320L);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(duration4).with(duration5).with(duration6);
                animatorSet2.start();
                PhantomPicView.this.f303306i.setTag(animatorSet2);
                animatorSet2.addListener(new a());
            }
        }, 80L);
    }

    @Override // com.tencent.mobileqq.trooppiceffects.view.a
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.trooppiceffects.view.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f303305h.clearAnimation();
        this.f303305h.setTag(null);
        this.f303306i.clearAnimation();
        this.f303306i.setTag(null);
        this.C = true;
        this.f303307m.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.trooppiceffects.view.a
    public void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            a();
        }
    }

    @Override // com.tencent.mobileqq.trooppiceffects.view.a
    public void setBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
            return;
        }
        this.f303302d.setImageBitmap(bitmap);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setColorFilter(Color.parseColor("#D000FF"), PorterDuff.Mode.ADD);
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable2.setColorFilter(Color.parseColor("#0005FF"), PorterDuff.Mode.ADD);
        this.f303303e.setImageDrawable(bitmapDrawable);
        this.f303304f.setImageDrawable(bitmapDrawable2);
        this.f303305h.setVisibility(4);
        this.f303306i.setVisibility(4);
    }
}
