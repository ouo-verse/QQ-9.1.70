package com.tencent.mobileqq.gamecenter.util;

import android.content.res.Resources;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    public static final int a(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }
}
