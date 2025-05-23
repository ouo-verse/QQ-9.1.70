package com.tenpay.sdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.reflect.Array;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MyTextView extends TextView {
    private String content;
    int count;
    private Paint paint;
    int[][] position;
    private int textHeight;
    private int top;
    private int width;
    private int xPadding;
    private int xPaddingMin;
    private int yPadding;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void getPositions(String str) {
        int i3;
        float f16;
        int i16;
        int length = str.length();
        this.count = length;
        this.position = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, 2);
        int i17 = 1;
        int i18 = 0;
        for (int i19 = 0; i19 < this.count; i19++) {
            String valueOf = String.valueOf(str.charAt(i19));
            Rect rect = new Rect();
            this.paint.getTextBounds(valueOf, 0, 1, rect);
            int width = rect.width();
            if (valueOf.equals("\u300a") || valueOf.equals("\uff08")) {
                width += this.xPaddingMin * 2;
            }
            float f17 = width;
            int i26 = (int) (i18 + f17);
            if (i26 > this.width) {
                i17++;
                i3 = 0;
            } else {
                i3 = (int) (i26 - f17);
            }
            int[] iArr = this.position[i19];
            iArr[0] = i3;
            iArr[1] = this.top + ((this.textHeight + this.yPadding) * (i17 - 1));
            if (isNumOrLetters(valueOf)) {
                f16 = i3;
                i16 = this.xPaddingMin;
            } else {
                f16 = i3;
                i16 = this.xPadding;
            }
            i18 = (int) (f16 + f17 + i16);
        }
        setHeight((this.textHeight + this.yPadding) * i17);
    }

    public void init() {
        TextPaint paint = getPaint();
        this.paint = paint;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.textHeight = (int) (Math.ceil(fontMetrics.descent - fontMetrics.top) + 2.0d);
        this.top = (int) Math.ceil(0.0f - fontMetrics.top);
        this.xPadding = dip2px(getContext(), 4.0f);
        this.xPaddingMin = dip2px(getContext(), 4.0f);
    }

    public boolean isNumOrLetters(String str) {
        return Pattern.compile("^[A-Za-z0-9_]+$").matcher(str).matches();
    }

    protected void measure() {
        int i3;
        if (!TextUtils.isEmpty(this.content) && this.width == 0) {
            int width = getWidth();
            this.width = width;
            if (width == 0) {
                this.width = getMeasuredWidth();
            }
            if (getLayoutParams().width == -2) {
                int length = this.content.length();
                int dip2px = dip2px(getContext(), 4.0f);
                for (int i16 = 0; i16 < length; i16++) {
                    String valueOf = String.valueOf(this.content.charAt(i16));
                    Rect rect = new Rect();
                    this.paint.getTextBounds("5", 0, 1, rect);
                    int width2 = rect.width();
                    if (valueOf.equals("\u300a") || valueOf.equals("\uff08")) {
                        width2 += this.xPaddingMin * 2;
                    }
                    if (i16 != 0) {
                        if (isNumOrLetters(valueOf)) {
                            i3 = this.xPaddingMin;
                        } else {
                            i3 = this.xPadding;
                        }
                        width2 += i3;
                    }
                    dip2px += width2;
                }
                setWidth(dip2px);
                this.width = dip2px;
            }
            if (this.width > 0) {
                getPositions(this.content);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(this.content)) {
            for (int i3 = 0; i3 < this.count; i3++) {
                String valueOf = String.valueOf(this.content.charAt(i3));
                int[] iArr = this.position[i3];
                canvas.drawText(valueOf, iArr[0], iArr[1], this.paint);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        measure();
    }

    public void setText(String str) {
        this.content = str;
        requestLayout();
        invalidate();
    }

    public MyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MyTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init();
    }
}
