package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.tavcut.core.render.exporter.ExportOutput;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class PicTypeKandian extends PicTypeNormal {
    static IPatchRedirector $redirector_;

    PicTypeKandian(CompressInfo compressInfo) {
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
        return 80;
    }

    @Override // com.tencent.mobileqq.pic.compress.PicTypeNormal
    protected final int[] i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f258689k.L == 2) {
            return null;
        }
        int[] iArr = {ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH, ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH * 2};
        com.tencent.mobileqq.pic.f.b("PicTypeNormal", "getScaleLargerSide", "PicType.SendPhotoMaxLongSide = " + iArr[0]);
        return iArr;
    }
}
