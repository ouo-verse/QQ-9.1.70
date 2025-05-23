package com.tencent.mobileqq.pic.api.impl;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.Avif2JpgResult;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.api.IDebugAvif2Jpg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.PicConvertUtil;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DebugAvif2JpgImpl implements IDebugAvif2Jpg {
    static IPatchRedirector $redirector_;

    public DebugAvif2JpgImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IDebugAvif2Jpg
    public Avif2JpgResult debugAvif2Jpg(String str, String str2, @Nullable @android.support.annotation.Nullable String str3, @Nullable @android.support.annotation.Nullable ThumbWidthHeightDP thumbWidthHeightDP, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Avif2JpgResult) iPatchRedirector.redirect((short) 2, this, str, str2, str3, thumbWidthHeightDP, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        return PicConvertUtil.debugConvertAvif2Jpg(str, str2, str3, thumbWidthHeightDP, i3, z16);
    }

    @Override // com.tencent.mobileqq.pic.api.IDebugAvif2Jpg
    public boolean isEnableLogMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return PicConvertUtil.sEnableLogMore;
    }

    @Override // com.tencent.mobileqq.pic.api.IDebugAvif2Jpg
    public void setEnableLogMore(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            PicConvertUtil.sEnableLogMore = z16;
        }
    }
}
