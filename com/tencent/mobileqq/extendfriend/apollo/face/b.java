package com.tencent.mobileqq.extendfriend.apollo.face;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawableImpl;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.proavatar.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.j;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements a {
    static IPatchRedirector $redirector_;

    @Nullable
    private static Bitmap a(String str, int i3) {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null) {
            f16 = j.h(BaseApplicationImpl.getApplication().getResources(), i3);
        }
        if (f16 != null) {
            imageCacheHelper.i(str, f16, Business.Conversation);
        }
        if (QLog.isColorLevel()) {
            QLog.d("extend.apollo.Util", 2, "getBitmapWithCache, bitmap=" + f16);
        }
        return f16;
    }

    public static Drawable b(int i3) {
        Bitmap a16 = a("static://Apollo_Face-" + i3 + "-shape", e(i3));
        if (a16 == null) {
            return com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        return new BitmapDrawable(a16);
    }

    public static FaceDrawable c(AppInterface appInterface, String str, int i3, int i16, int i17, FaceDrawable.OnLoadingStateChangeListener onLoadingStateChangeListener) {
        int i18;
        if (!TextUtils.isEmpty(str) && appInterface != null) {
            if (!(appInterface instanceof QQAppInterface)) {
                return null;
            }
            int h16 = h(i3, i16);
            if (i17 == 0) {
                i18 = f(i3, i16);
            } else {
                i18 = i17;
            }
            Drawable b16 = b(i18);
            if (AvatarOptimiseConfigUtil.b()) {
                return new g(appInterface, 116, 200, str, (byte) 1, i18, h16, false, b16, b16, onLoadingStateChangeListener, false);
            }
            return new FaceDrawableImpl(appInterface, 116, 200, str, (byte) 1, i18, h16, false, b16, b16, onLoadingStateChangeListener, false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("extend.apollo.Util", 2, "getFaceDrawable fail, uin=" + str + ", type=116,appIntf=" + appInterface);
        }
        return null;
    }

    public static FaceDrawable d(AppInterface appInterface, String str) {
        return c(appInterface, str, 0, 0, 6, null);
    }

    @NotNull
    private static int e(int i3) {
        if (i3 == 6) {
            return R.drawable.ndv;
        }
        if (i3 != 7) {
            if (i3 != 8) {
                return R.drawable.ndv;
            }
            return R.drawable.nds;
        }
        return R.drawable.ndu;
    }

    public static int f(int i3, int i16) {
        if (i16 == 2 && i3 == 1) {
            return 8;
        }
        if (i3 == 1) {
            return 7;
        }
        return 6;
    }

    public static int[] g(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[iArr.length * iArr2.length];
        int i3 = 0;
        for (int i16 : iArr) {
            for (int i17 : iArr2) {
                iArr3[i3] = h(i16, i17);
                i3++;
            }
        }
        return iArr3;
    }

    public static int h(int i3, int i16) {
        return (i3 << 4) | i16;
    }
}
