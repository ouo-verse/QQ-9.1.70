package com.tencent.mobileqq.microapp.util;

import android.content.Context;
import android.graphics.Color;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DisplayUtil {
    static IPatchRedirector $redirector_;
    private static float density;

    DisplayUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getBarHeight(Context context) {
        try {
            return context.getResources().getDimensionPixelSize(((Integer) Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null)).intValue());
        } catch (Exception e16) {
            e16.printStackTrace();
            return 38;
        }
    }

    public static float getDensity(Context context) {
        float f16 = density;
        if (f16 != 0.0f) {
            return f16;
        }
        if (context != null) {
            float f17 = context.getResources().getDisplayMetrics().density;
            density = f17;
            return f17;
        }
        throw new IllegalArgumentException("");
    }

    public static int parseColor(String str) {
        try {
            if (str.length() == 4 && str.substring(0, 1).equals("#")) {
                String substring = str.substring(1, 2);
                String substring2 = str.substring(2, 3);
                String substring3 = str.substring(3, 4);
                str = "#" + substring + substring + substring2 + substring2 + substring3 + substring3;
            }
            return Color.parseColor(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int px2dip(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
