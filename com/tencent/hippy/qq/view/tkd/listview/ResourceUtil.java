package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ResourceUtil {
    public static Bitmap getBitmap(int i3) {
        return BitmapFactory.decodeResource(BaseApplication.getContext().getResources(), i3);
    }

    @ColorInt
    public static int getColor(@ColorRes int i3) {
        return BaseApplication.getContext().getResources().getColor(i3);
    }

    public static String getString(@StringRes int i3) {
        return BaseApplication.getContext().getString(i3);
    }
}
