package com.tencent.mobileqq.aio.reserve1.navigation.view;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import com.tencent.mobileqq.aio.reserve1.navigation.AIONavCorrelation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(Paint paint, Path path, int i3, int i16, int i17, int i18) {
        float strokeWidth = paint.getStrokeWidth();
        path.reset();
        float f16 = i17;
        float f17 = (i16 * 0.5f) + strokeWidth + f16;
        float f18 = i18 + strokeWidth;
        path.moveTo(f17, f18);
        float f19 = (i17 + i3) - strokeWidth;
        path.lineTo(f19, f18);
        float f26 = (i18 + i16) - strokeWidth;
        path.lineTo(f19, f26);
        path.lineTo(f17 + strokeWidth, f26);
        path.arcTo(f16 + strokeWidth, f18, (i17 + i16) - strokeWidth, f26, 90.0f, 181.0f, false);
    }

    public static void b(c cVar, AIONavCorrelation aIONavCorrelation) {
        String str = "#0099FF";
        if (aIONavCorrelation == AIONavCorrelation.STRONG) {
            if (QQTheme.isNowThemeSimpleNight()) {
                str = "#0066CC";
            } else if (QQTheme.isNowThemeIsNight()) {
                str = "#0071FF";
            }
            int parseColor = Color.parseColor(str);
            cVar.f193366e = parseColor;
            cVar.f193365d = -1;
            cVar.f193364c = parseColor;
        } else {
            cVar.f193365d = Color.parseColor("#0099FF");
            if (QQTheme.isNowThemeIsNight()) {
                int parseColor2 = Color.parseColor("#1A1A1A");
                cVar.f193366e = parseColor2;
                cVar.f193364c = parseColor2;
            } else {
                cVar.f193366e = -1;
                cVar.f193364c = Color.parseColor("#E3E5E8");
            }
        }
        Log.d("AioNavAnimView", "updateColorProp: bgColor = " + cVar.f193366e + ", fgColor = " + cVar.f193365d + ", borderColor = " + cVar.f193364c);
    }
}
