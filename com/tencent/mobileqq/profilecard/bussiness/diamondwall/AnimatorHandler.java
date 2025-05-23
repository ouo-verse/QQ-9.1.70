package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.f;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AnimatorHandler extends Handler {
    static IPatchRedirector $redirector_;
    public static boolean playing;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class FloatEvaluator implements TypeEvaluator {
        static IPatchRedirector $redirector_;

        FloatEvaluator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnimatorHandler.this);
            }
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f16, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), obj, obj2);
            }
            float f17 = f16 * 3.0f;
            if (f17 <= 0.45f) {
                return Float.valueOf(1.0f - ((f17 / 0.45f) * 0.6f));
            }
            if (f17 <= 1.3f) {
                return Double.valueOf((((f17 - 0.45f) / 0.84999996f) * 0.6f) + 0.4d);
            }
            if (f17 <= 2.45f) {
                return Float.valueOf(1.0f - (((f17 - 1.3f) / 1.1500001f) * 0.6f));
            }
            return Double.valueOf((((f17 - 2.45f) / 0.54999995f) * 0.6f) + 0.4d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74090);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            playing = false;
        }
    }

    public AnimatorHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        } else if (1 == message.arg1) {
            startPopAnimation(message);
        }
    }

    public void startPopAnimation(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        View view = (View) message.obj;
        int i3 = message.getData().getInt(BaseProfileDiamondWallComponent.TIPS_TIMES);
        long j3 = message.getData().getLong(BaseProfileDiamondWallComponent.REMIND_TIME);
        int i16 = message.what;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(3.0f);
        ofFloat.setEvaluator(new FloatEvaluator());
        ofFloat.setDuration(3000L);
        if (i3 >= 1) {
            ofFloat.setRepeatCount(i3 - 1);
        }
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view) { // from class: com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View val$view;

            {
                this.val$view = view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnimatorHandler.this, (Object) view);
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) valueAnimator);
                } else {
                    this.val$view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.addListener(new f(view, j3, i16) { // from class: com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$remindTime;
            final /* synthetic */ int val$type;
            final /* synthetic */ View val$view;

            {
                this.val$view = view;
                this.val$remindTime = j3;
                this.val$type = i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AnimatorHandler.this, view, Long.valueOf(j3), Integer.valueOf(i16));
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animator);
                    return;
                }
                this.val$view.setAlpha(1.0f);
                AnimatorHandler.playing = false;
                long j16 = this.val$remindTime;
                if (j16 != 0) {
                    BaseProfileDiamondWallComponent.saveShowPopTime(j16, this.val$type);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animator);
                    return;
                }
                this.val$view.setAlpha(1.0f);
                AnimatorHandler.playing = false;
                long j16 = this.val$remindTime;
                if (j16 != 0) {
                    BaseProfileDiamondWallComponent.saveShowPopTime(j16, this.val$type);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) animator);
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animator);
                } else {
                    AnimatorHandler.playing = true;
                }
            }
        });
        ofFloat.start();
    }
}
