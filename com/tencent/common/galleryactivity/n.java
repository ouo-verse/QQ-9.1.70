package com.tencent.common.galleryactivity;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class n extends k {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract URL c();

    public abstract Drawable getImageDrawable();
}
