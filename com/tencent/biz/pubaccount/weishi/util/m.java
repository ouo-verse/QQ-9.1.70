package com.tencent.biz.pubaccount.weishi.util;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class m implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ClickableSpan a16;
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        if (!(textView.getText() instanceof Spanned)) {
            return false;
        }
        int action = motionEvent.getAction();
        if ((action != 1 && action != 0) || (a16 = a(textView, b(textView, motionEvent))) == null) {
            return false;
        }
        if (action == 1) {
            a16.onClick(textView);
        }
        return true;
    }

    public static ClickableSpan a(TextView textView, int i3) {
        ClickableSpan[] clickableSpanArr;
        if (textView != null && i3 >= 0) {
            CharSequence text = textView.getText();
            if ((text instanceof Spanned) && (clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(i3, i3 + 1, ClickableSpan.class)) != null && clickableSpanArr.length > 0) {
                return clickableSpanArr[0];
            }
        }
        return null;
    }

    public static int b(TextView textView, MotionEvent motionEvent) {
        int offsetForHorizontal;
        if (textView != null && motionEvent != null) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y16 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int lineForVertical = layout.getLineForVertical(scrollY);
            float f16 = scrollX;
            if (f16 < layout.getLineLeft(lineForVertical) || f16 > layout.getLineRight(lineForVertical) || scrollY < layout.getLineTop(lineForVertical) || scrollY > layout.getLineBottom(lineForVertical) || (offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f16)) > textView.getText().length() - layout.getEllipsisCount(lineForVertical)) {
                return -1;
            }
            return layout.getPrimaryHorizontal(offsetForHorizontal) > f16 ? offsetForHorizontal - 1 : offsetForHorizontal;
        }
        return -1;
    }
}
