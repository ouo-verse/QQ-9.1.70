package com.tencent.mobileqq.wink.utils;

import android.content.Context;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;

/* compiled from: P */
/* loaded from: classes21.dex */
public class i {
    public static int a(Context context, float f16) {
        float f17;
        if (context == null) {
            return Math.round((f16 * 3.0f) + 0.5f);
        }
        if (b(context) && GlobalDisplayMetricsManager.sOriginDisplayMetrics != null) {
            f17 = GlobalDisplayMetricsManager.sOriginDisplayMetrics.density;
        } else {
            f17 = context.getResources().getDisplayMetrics().density;
        }
        return Math.round((f16 * f17) + 0.5f);
    }

    public static boolean b(Context context) {
        return GlobalDisplayMetricsManager.needAdjustDensity(context);
    }
}
