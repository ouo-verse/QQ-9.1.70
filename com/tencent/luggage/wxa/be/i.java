package com.tencent.luggage.wxa.be;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i extends LinkMovementMethod {
    public abstract void a(String str);

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y16 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, URLSpan.class);
        if (uRLSpanArr.length != 0) {
            a(uRLSpanArr[0].getURL());
        }
        return true;
    }
}
