package com.tencent.mobileqq.qrscan;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class s {
    static IPatchRedirector $redirector_;

    public static void a(Rect rect, Rect rect2, int i3, int i16, float f16) {
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        float width = rect.width();
        int i17 = centerX - ((int) ((width * 0.5f) * f16));
        float height = rect.height();
        int i18 = centerY - ((int) ((0.5f * height) * f16));
        int i19 = ((int) (width * f16)) + i17;
        int i26 = ((int) (f16 * height)) + i18;
        if (i17 < 0) {
            i17 = 0;
        }
        if (i18 < 0) {
            i18 = 0;
        }
        if (i19 <= i3) {
            i3 = i19;
        }
        if (i26 <= i16) {
            i16 = i26;
        }
        rect2.set(i17, i18, i3, i16);
    }
}
