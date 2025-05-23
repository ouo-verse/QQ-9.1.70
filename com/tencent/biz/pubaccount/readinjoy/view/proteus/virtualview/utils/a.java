package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.os.SystemClock;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends LinkMovementMethod {

    /* renamed from: b, reason: collision with root package name */
    private static LinkMovementMethod f79864b;

    /* renamed from: a, reason: collision with root package name */
    private long f79865a;

    private static long a() {
        return SystemClock.uptimeMillis();
    }

    private static ClickableSpan[] b(TextView textView, Spanned spanned, MotionEvent motionEvent) {
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y16 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        return (ClickableSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
    }

    private static boolean c(long j3, long j16) {
        if (j3 - j16 < ViewConfiguration.getLongPressTimeout()) {
            return true;
        }
        return false;
    }

    public static MovementMethod getInstance() {
        if (f79864b == null) {
            f79864b = new a();
        }
        return f79864b;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f79865a = a();
        }
        if (action == 1) {
            ClickableSpan[] b16 = b(textView, spannable, motionEvent);
            Selection.removeSelection(spannable);
            if (b16.length != 0) {
                ClickableSpan clickableSpan = b16[0];
                if (!c(a(), this.f79865a)) {
                    return false;
                }
                clickableSpan.onClick(textView);
                return true;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
