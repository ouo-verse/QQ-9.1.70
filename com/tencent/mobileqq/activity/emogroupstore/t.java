package com.tencent.mobileqq.activity.emogroupstore;

import android.animation.ValueAnimator;
import android.widget.ProgressBar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProgressBar f182185d;

        a(ProgressBar progressBar) {
            this.f182185d = progressBar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) progressBar);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            ProgressBar progressBar = this.f182185d;
            if (progressBar != null) {
                progressBar.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    public static ValueAnimator a(ProgressBar progressBar, int i3) {
        ValueAnimator duration = ValueAnimator.ofInt(0, i3).setDuration(500L);
        duration.addUpdateListener(new a(progressBar));
        return duration;
    }
}
