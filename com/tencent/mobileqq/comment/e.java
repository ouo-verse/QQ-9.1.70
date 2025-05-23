package com.tencent.mobileqq.comment;

import android.graphics.Paint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static final String a(Paint paint, String str, int i3) {
        float measureText = paint.measureText(str);
        float measureText2 = paint.measureText("\u2026");
        if (measureText2 > measureText) {
            return str;
        }
        float f16 = i3;
        if (measureText2 > f16) {
            return "\u2026";
        }
        if (measureText > f16) {
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            float f17 = f16 - measureText2;
            float f18 = 0.0f;
            for (int i16 = 0; i16 < length; i16++) {
                f18 += fArr[i16];
                if (f18 > f17) {
                    return str.substring(0, i16) + "\u2026";
                }
            }
            return str;
        }
        return str;
    }
}
