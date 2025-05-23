package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.j;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BaseURLDrawableHelper {
    static IPatchRedirector $redirector_;

    public BaseURLDrawableHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Drawable getFailedDrawable() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("static://CommonFailedDrawable");
        if (f16 == null) {
            Bitmap g16 = j.g(BaseApplication.getContext().getResources(), R.drawable.nje);
            if (g16 != null) {
                imageCacheHelper.k("static://CommonFailedDrawable", g16, Business.AIO, Priority.High, null);
            }
            f16 = g16;
        }
        if (f16 != null) {
            return new BitmapDrawable(f16);
        }
        return new ColorDrawable();
    }
}
