package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Paint;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UIGdiMeasure {
    private Paint mPaint;

    public UIGdiMeasure() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }

    public int breakText(String str, int i3, float[] fArr) {
        float f16;
        this.mPaint.setAntiAlias(true);
        int min = Math.min((int) ((i3 * 2) / getStringWidth("a")), str.length());
        if (min <= 0) {
            return 0;
        }
        float[] fArr2 = new float[min];
        this.mPaint.getTextWidths(str.subSequence(0, min).toString(), fArr2);
        int i16 = 0;
        int i17 = 0;
        while (i16 < min) {
            i17 = (int) (i17 + fArr2[i16]);
            if (i17 > i3) {
                break;
            }
            i16++;
        }
        if (fArr != null) {
            float f17 = i17;
            if (i16 < min) {
                f16 = fArr2[i16];
            } else {
                f16 = 0.0f;
            }
            fArr[0] = f17 - f16;
        }
        return i16;
    }

    public float getCharHeight() {
        this.mPaint.setAntiAlias(true);
        return this.mPaint.getTextSize();
    }

    public float getStringWidth(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        this.mPaint.setAntiAlias(true);
        return this.mPaint.measureText(str);
    }

    public void getStringWidthHeight(String str, HippyTKDUISize hippyTKDUISize) {
        hippyTKDUISize.mWidth = (int) getStringWidth(str);
        hippyTKDUISize.mHeight = (int) getCharHeight();
    }

    public int getStringWidthInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        this.mPaint.setAntiAlias(true);
        return (int) Math.ceil(this.mPaint.measureText(str));
    }

    public void setFontSize(int i3) {
        this.mPaint.setTextSize(i3);
    }

    public UIGdiMeasure(Paint paint) {
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }
}
