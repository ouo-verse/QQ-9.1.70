package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UIStringUtils {

    /* renamed from: fm, reason: collision with root package name */
    private static Paint.FontMetricsInt f114174fm = new Paint.FontMetricsInt();
    private static float mPaintOffset = ImmersiveUtils.dpToPx(1.0f);

    public static void drawText(Canvas canvas, Paint paint, float f16, float f17, String str) {
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setStyle(Paint.Style.FILL);
        paint.getFontMetricsInt(f114174fm);
        canvas.drawText(str, f16, (f17 - paint.ascent()) - mPaintOffset, paint);
        paint.setAntiAlias(false);
    }

    public static String getFileExt(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    public static boolean isEmpty(String str) {
        if (str != null && !"".equals(str.trim())) {
            return false;
        }
        return true;
    }
}
