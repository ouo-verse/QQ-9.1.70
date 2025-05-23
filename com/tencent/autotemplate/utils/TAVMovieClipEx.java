package com.tencent.autotemplate.utils;

import com.tencent.autotemplate.transition.TransitionEffectParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tavmovie.base.TAVMovieClip;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVMovieClipEx {
    static IPatchRedirector $redirector_;
    private boolean isCurrentReverse;
    private boolean isLastReverse;

    @Deprecated
    private boolean isReverse;
    private TAVMovieClip tavMovieClip;
    private TransitionEffectParam transitionEffectParam;

    public TAVMovieClipEx(TAVMovieClip tAVMovieClip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tAVMovieClip);
        } else {
            this.transitionEffectParam = new TransitionEffectParam();
            this.tavMovieClip = tAVMovieClip;
        }
    }

    public TAVMovieClip getTavMovieClip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TAVMovieClip) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tavMovieClip;
    }

    public TransitionEffectParam getTransitionEffectParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TransitionEffectParam) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.transitionEffectParam;
    }

    public boolean isCurrentReverse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isCurrentReverse;
    }

    public boolean isLastReverse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isLastReverse;
    }

    public boolean isReverse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isReverse;
    }

    public void setCurrentReverse(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isCurrentReverse = z16;
        }
    }

    public void setLastReverse(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isLastReverse = z16;
        }
    }

    public void setReverse(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.isReverse = z16;
        }
    }

    public void setTavMovieClip(TAVMovieClip tAVMovieClip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tAVMovieClip);
        } else {
            this.tavMovieClip = tAVMovieClip;
        }
    }

    public void setTransitionEffectParam(TransitionEffectParam transitionEffectParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) transitionEffectParam);
        } else {
            this.transitionEffectParam = transitionEffectParam;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovieClipEx m95clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TAVMovieClipEx) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        TAVMovieClipEx tAVMovieClipEx = new TAVMovieClipEx(this.tavMovieClip.m275clone());
        tAVMovieClipEx.isCurrentReverse = this.isCurrentReverse;
        tAVMovieClipEx.isLastReverse = this.isLastReverse;
        tAVMovieClipEx.isReverse = this.isReverse;
        tAVMovieClipEx.setTransitionEffectParam(this.transitionEffectParam.m94clone());
        return tAVMovieClipEx;
    }
}
