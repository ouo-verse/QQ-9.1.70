package com.tencent.ams.fusion.widget.apng.frame.animation;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface Animatable2 {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class AnimationCallback {
        static IPatchRedirector $redirector_;

        public AnimationCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void onAnimationEnd(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
            }
        }

        public void onAnimationStart(Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
            }
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(AnimationCallback animationCallback);
}
