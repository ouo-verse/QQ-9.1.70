package com.tencent.richframework.text.rich.style;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class EditTextLinkMovementMethod extends ArrowKeyMovementMethod {
    private static volatile EditTextLinkMovementMethod sEditTextLinkMovementMethod;

    public static EditTextLinkMovementMethod getInstance() {
        if (sEditTextLinkMovementMethod == null) {
            synchronized (EditTextLinkMovementMethod.class) {
                if (sEditTextLinkMovementMethod == null) {
                    sEditTextLinkMovementMethod = new EditTextLinkMovementMethod();
                }
            }
        }
        return sEditTextLinkMovementMethod;
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y16 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int lineForVertical = layout.getLineForVertical(scrollY);
            float lineLeft = layout.getLineLeft(lineForVertical);
            float f16 = scrollX;
            if (f16 <= layout.getLineRight(lineForVertical) && (scrollX < 0 || f16 >= lineLeft)) {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f16);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    ClickableSpan clickableSpan = clickableSpanArr[0];
                    if (action == 1) {
                        clickableSpan.onClick(textView);
                    }
                }
            }
        }
        return true;
    }
}
