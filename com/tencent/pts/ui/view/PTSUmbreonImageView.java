package com.tencent.pts.ui.view;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.vnode.b;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes22.dex */
public class PTSUmbreonImageView extends PTSImageView {
    static IPatchRedirector $redirector_;

    public PTSUmbreonImageView(b bVar) {
        super(bVar.getContext());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        }
    }
}
