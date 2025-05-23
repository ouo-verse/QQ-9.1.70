package com.tencent.mobileqq.minigame.utils;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DpUtil {
    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
