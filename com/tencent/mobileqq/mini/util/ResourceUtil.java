package com.tencent.mobileqq.mini.util;

import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ResourceUtil {
    public static int getColor(int i3) {
        return BaseApplication.getContext().getResources().getColor(i3);
    }

    public static Drawable getDrawable(int i3) {
        return BaseApplication.getContext().getResources().getDrawable(i3);
    }

    public static String getString(int i3) {
        return BaseApplication.getContext().getString(i3);
    }
}
