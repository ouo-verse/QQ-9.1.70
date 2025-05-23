package com.tencent.tavsticker.utils;

import android.content.res.Resources;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ViewUtils {
    public static int dip2px(float f16) {
        return (int) ((f16 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(float f16) {
        return (int) ((f16 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
