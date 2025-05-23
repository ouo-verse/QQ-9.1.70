package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class PicTypeTroopBar extends PicTypeNormal {
    static IPatchRedirector $redirector_;

    PicTypeTroopBar(CompressInfo compressInfo) {
        super(compressInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) compressInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.compress.d
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        CompressInfo compressInfo = this.f258689k;
        if (compressInfo.L == 2) {
            return 100;
        }
        if (compressInfo.M != 1) {
            return 85;
        }
        return 90;
    }
}
