package cw;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends LinkMovementMethod {

    /* renamed from: d, reason: collision with root package name */
    private static d f391982d;

    /* renamed from: a, reason: collision with root package name */
    public int f391983a = -10864125;

    /* renamed from: b, reason: collision with root package name */
    public int f391984b = -7447805;

    /* renamed from: c, reason: collision with root package name */
    private boolean f391985c;

    private int a(TextView textView, int i3, int i16) {
        if (this.f391985c) {
            return -1;
        }
        Object tag = textView.getTag(i3);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return i16;
    }

    public static MovementMethod getInstance() {
        if (f391982d == null) {
            f391982d = new d();
        }
        return f391982d;
    }

    public void b(boolean z16) {
        this.f391985c = z16;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
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
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    int a16 = a(textView, R.id.jau, this.f391984b);
                    clickableSpanArr[0].onClick(textView);
                    spannable.setSpan(new ForegroundColorSpan(a16), spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]), 33);
                } else if (action == 0) {
                    spannable.setSpan(new ForegroundColorSpan(a(textView, R.id.jat, this.f391983a)), spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]), 33);
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                }
                return true;
            }
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
