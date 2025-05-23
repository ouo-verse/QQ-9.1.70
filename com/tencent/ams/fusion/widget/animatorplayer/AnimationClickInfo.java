package com.tencent.ams.fusion.widget.animatorplayer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AnimationClickInfo {
    static IPatchRedirector $redirector_;
    public AnimationItem item;

    /* renamed from: x, reason: collision with root package name */
    public float f70534x;

    /* renamed from: y, reason: collision with root package name */
    public float f70535y;

    public AnimationClickInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "AnimationClickInfo{item=" + this.item + ", x=" + this.f70534x + ", y=" + this.f70535y + '}';
    }
}
