package com.tencent.relation.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class OrderTextView extends TextView {
    static IPatchRedirector $redirector_;

    public OrderTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private String[] a(String str, Paint paint, float f16) {
        int length = str.length();
        int i3 = 0;
        if (paint.measureText(str) <= f16) {
            return new String[]{str};
        }
        int ceil = (int) Math.ceil(r1 / f16);
        String[] strArr = new String[ceil];
        int i16 = 1;
        int i17 = 0;
        while (true) {
            if (i3 < length) {
                if (paint.measureText(str, i3, i16) > f16) {
                    i16--;
                    strArr[i17] = (String) str.subSequence(i3, i16);
                    i3 = i16;
                    i17++;
                }
                if (i16 == length && i17 < ceil) {
                    strArr[i17] = (String) str.subSequence(i3, i16);
                    break;
                }
                i16++;
            } else {
                break;
            }
        }
        return strArr;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f16 = fontMetrics.descent - fontMetrics.ascent;
        float f17 = f16;
        for (String str : a(getText().toString(), paint, getWidth())) {
            if (str == null) {
                QLog.e("OrderTextView", 1, "null == text");
            } else {
                canvas.drawText(str, 0.0f, f17, paint);
                f17 += fontMetrics.leading + f16;
            }
        }
    }

    public OrderTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public OrderTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
