package com.tencent.mobileqq.vasgift.utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    public static URLDrawable a(String str, Drawable drawable, Drawable drawable2) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("QQGiftImageUtil", 2, "getDrawable url:" + str);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable2;
            if (c(str)) {
                return URLDrawable.getDrawable(str, obtain);
            }
            return URLDrawable.getFileDrawable(str, obtain);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable b(Context context) {
        Drawable drawable = context.getResources().getDrawable(R.drawable.nkc);
        drawable.setColorFilter(-7829368, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static boolean c(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("http://"))) {
            return true;
        }
        return false;
    }
}
