package com.tencent.mobileqq.mutualmark.widget.util;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static URLDrawable a(String str) {
        return b(str, null);
    }

    public static URLDrawable b(String str, String str2) {
        return c(str, str2, new ColorDrawable(0), new ColorDrawable(0));
    }

    public static URLDrawable c(String str, String str2, Drawable drawable, Drawable drawable2) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mExtraInfo = new Bundle();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable2;
        obtain.mMemoryCacheKeySuffix = str2;
        obtain.mUseApngImage = true;
        return URLDrawable.getDrawable(str, obtain);
    }
}
