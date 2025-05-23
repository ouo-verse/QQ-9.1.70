package com.qzone.widget.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {
    public static int b(int i3) {
        return Color.blue(i3) | (Color.red(i3) << 16) | (Color.green(i3) << 8);
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e16) {
            QLog.d("ColorUtils", 1, "parseColor error, ", e16);
            return 0;
        }
    }

    public static int a(float f16, int i3, int i16) {
        if (i3 == i16) {
            return i3;
        }
        float f17 = ((i3 >> 24) & 255) / 255.0f;
        float pow = (float) Math.pow(((i3 >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((i3 >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((i3 & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((i16 >> 16) & 255) / 255.0f, 2.2d);
        float f18 = f17 + (((((i16 >> 24) & 255) / 255.0f) - f17) * f16);
        float pow5 = pow2 + ((((float) Math.pow(((i16 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f16);
        float pow6 = pow3 + (f16 * (((float) Math.pow((i16 & 255) / 255.0f, 2.2d)) - pow3));
        return (Math.round(((float) Math.pow(pow + ((pow4 - pow) * f16), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f18 * 255.0f) << 24) | (Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow6, 0.45454545454545453d)) * 255.0f);
    }
}
