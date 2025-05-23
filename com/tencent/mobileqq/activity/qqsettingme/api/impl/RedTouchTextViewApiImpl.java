package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RedTouchTextViewApiImpl implements IRedTouchTextViewApi {
    static IPatchRedirector $redirector_;

    public RedTouchTextViewApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi
    public Drawable getApngURLDrawable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return VasApngUtil.getApngURLDrawable(str, VasApngUtil.VIP_APNG_TAGS, com.tencent.mobileqq.urldrawable.b.f306350a);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi
    public double getOptRatio(InputStream inputStream, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, this, inputStream, Integer.valueOf(i3), Integer.valueOf(i16))).doubleValue();
        }
        return BaseImageUtil.getOptRatio(inputStream, i3, i16);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi
    public Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, bitmap, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return BaseImageUtil.getRoundedCornerBitmap(bitmap, f16, i3, i16);
    }
}
