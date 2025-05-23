package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class PicTypeGif extends d {
    static IPatchRedirector $redirector_;

    PicTypeGif(CompressInfo compressInfo) {
        super(compressInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) compressInfo);
        }
    }

    @Override // com.tencent.mobileqq.pic.compress.d
    protected boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pic.compress.d
    protected int e(CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) compressInfo)).intValue();
    }
}
