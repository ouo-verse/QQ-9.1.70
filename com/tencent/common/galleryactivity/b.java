package com.tencent.common.galleryactivity;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.AdapterView;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(Activity activity, c cVar, int i3);

    public abstract void b(int i3);

    public abstract void c(AdapterView adapterView, int i3);
}
