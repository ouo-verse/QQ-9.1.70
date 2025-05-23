package com.tencent.mobileqq.pic.api.impl;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.IOriPicCompress;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.RichmediaService;

/* loaded from: classes16.dex */
public class OriPicCompressImpl implements IOriPicCompress {
    static IPatchRedirector $redirector_;

    public OriPicCompressImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IOriPicCompress
    public void compressOriginPic(CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) compressInfo);
        } else {
            RichmediaService.A(compressInfo);
        }
    }
}
