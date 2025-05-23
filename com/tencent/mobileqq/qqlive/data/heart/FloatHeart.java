package com.tencent.mobileqq.qqlive.data.heart;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FloatHeart {
    static IPatchRedirector $redirector_;
    public long anchorId;
    public boolean firstLike;
    public String likeResId;
    public String materialId;
    public long roomId;

    public FloatHeart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
