package com.tencent.ad.tangram.widget.bubble;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes3.dex */
final class GdtDisplayUtil {
    GdtDisplayUtil() {
    }

    public static int dpToPx(Context context, int i3) {
        float f16;
        try {
            f16 = Math.round(i3 * context.getResources().getDisplayMetrics().density);
        } catch (Throwable th5) {
            GdtLogger.e("DisplayUtil", "GdtBubble Display" + th5.getMessage());
            f16 = 0.0f;
        }
        return (int) f16;
    }
}
