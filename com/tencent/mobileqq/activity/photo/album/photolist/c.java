package com.tencent.mobileqq.activity.photo.album.photolist;

import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends d {
    static IPatchRedirector $redirector_;

    public c(f<? extends OtherCommonData> fVar) {
        super(fVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            return;
        }
        this.K = 0;
        int i3 = (this.C.getDisplayMetrics().widthPixels - (this.K * 2)) / o0().f184304o;
        this.I = i3;
        this.J = i3;
    }
}
