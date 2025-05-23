package com.tencent.mobileqq.qqcommon.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IBaseImageUtilApi;
import com.tencent.mobileqq.utils.BaseImageUtil;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BaseImageUtilApiImpl implements IBaseImageUtilApi {
    static IPatchRedirector $redirector_;

    public BaseImageUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IBaseImageUtilApi
    public Bitmap drawableToBitmap(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
        }
        return BaseImageUtil.drawableToBitmap(drawable);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IBaseImageUtilApi
    public Bitmap getDefaultFaceBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return BaseImageUtil.getDefaultFaceBitmap();
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IBaseImageUtilApi
    public Bitmap getRoundFaceBitmap(Bitmap bitmap, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return BaseImageUtil.getRoundFaceBitmap(bitmap, i3, i16);
    }
}
