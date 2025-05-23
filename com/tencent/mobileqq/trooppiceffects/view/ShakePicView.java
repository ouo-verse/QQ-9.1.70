package com.tencent.mobileqq.trooppiceffects.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.f;

/* loaded from: classes19.dex */
public class ShakePicView extends FrameLayout implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected ImageView f303309d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f303310e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f303311f;

    /* renamed from: h, reason: collision with root package name */
    protected Handler f303312h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f303313i;

    public ShakePicView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f303312h = new Handler(Looper.getMainLooper());
        this.f303309d = new ImageView(context);
        this.f303310e = new ImageView(context);
        this.f303311f = new ImageView(context);
        this.f303309d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f303310e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f303311f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f303309d, -1, -1);
        addView(this.f303310e, -1, -1);
        addView(this.f303311f, -1, -1);
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f303313i) {
            return;
        }
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.142f, -x.c(getContext(), 2.5f)), Keyframe.ofFloat(0.285f, -x.c(getContext(), 7.5f)), Keyframe.ofFloat(0.426f, -x.c(getContext(), 2.5f)), Keyframe.ofFloat(0.568f, -x.c(getContext(), 2.5f)), Keyframe.ofFloat(0.71f, -x.c(getContext(), 7.5f)), Keyframe.ofFloat(0.852f, -x.c(getContext(), 2.5f)), Keyframe.ofFloat(1.0f, 0.0f));
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.142f, 0.0f), Keyframe.ofFloat(0.285f, -x.c(getContext(), 3.5f)), Keyframe.ofFloat(0.426f, -x.c(getContext(), 13.5f)), Keyframe.ofFloat(0.568f, 0.0f), Keyframe.ofFloat(0.71f, -x.c(getContext(), 3.5f)), Keyframe.ofFloat(0.852f, -x.c(getContext(), 13.5f)), Keyframe.ofFloat(1.0f, 0.0f));
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.f303310e, ofKeyframe).setDuration(280L);
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this.f303310e, ofKeyframe2).setDuration(280L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2);
        animatorSet.start();
        this.f303310e.setTag(animatorSet);
        PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.33f, 0.05f), Keyframe.ofFloat(0.66f, 0.05f), Keyframe.ofFloat(1.0f, 0.0f));
        Keyframe[] keyframeArr = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(1.0f, 2.33f)};
        PropertyValuesHolder ofKeyframe4 = PropertyValuesHolder.ofKeyframe(View.SCALE_X, keyframeArr);
        PropertyValuesHolder ofKeyframe5 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, keyframeArr);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(this.f303311f, ofKeyframe4).setDuration(320L);
        ObjectAnimator duration4 = ObjectAnimator.ofPropertyValuesHolder(this.f303311f, ofKeyframe5).setDuration(320L);
        ObjectAnimator duration5 = ObjectAnimator.ofPropertyValuesHolder(this.f303311f, ofKeyframe3).setDuration(320L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(duration3).with(duration4).with(duration5);
        animatorSet2.start();
        this.f303311f.setTag(animatorSet2);
        animatorSet2.addListener(new f() { // from class: com.tencent.mobileqq.trooppiceffects.view.ShakePicView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShakePicView.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                } else {
                    ShakePicView.this.f303312h.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.trooppiceffects.view.ShakePicView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                ShakePicView.this.a();
                            }
                        }
                    }, 160L);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                }
            }
        });
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
        this.f303310e.clearAnimation();
        this.f303310e.setTag(null);
        this.f303311f.clearAnimation();
        this.f303311f.setTag(null);
        this.f303313i = true;
        this.f303312h.removeCallbacksAndMessages(null);
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
        this.f303309d.setImageBitmap(bitmap);
        this.f303310e.setImageBitmap(bitmap);
        this.f303311f.setImageBitmap(bitmap);
    }
}
