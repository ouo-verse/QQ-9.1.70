package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Paint;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UIUtilBase {

    /* renamed from: fm, reason: collision with root package name */
    protected static Paint.FontMetricsInt f114175fm = new Paint.FontMetricsInt();

    public static int getTextHeight(int i3) {
        Paint paint = new Paint();
        paint.setTextSize(i3);
        paint.getFontMetricsInt(f114175fm);
        paint.setAntiAlias(true);
        Paint.FontMetricsInt fontMetricsInt = f114175fm;
        return (int) Math.ceil(fontMetricsInt.descent - fontMetricsInt.ascent);
    }

    public static int getTextWidth(String str, Paint paint, int i3) {
        if (str != null && !"".equals(str.trim())) {
            float textSize = paint.getTextSize();
            paint.setTextSize(i3);
            int measureText = (int) paint.measureText(str);
            paint.setTextSize(textSize);
            return measureText;
        }
        return 0;
    }

    public static int getTextHeight(Paint paint, int i3) {
        paint.setTextSize(i3);
        paint.getFontMetricsInt(f114175fm);
        paint.setAntiAlias(true);
        Paint.FontMetricsInt fontMetricsInt = f114175fm;
        return (int) Math.ceil(fontMetricsInt.descent - fontMetricsInt.ascent);
    }
}
