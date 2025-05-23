package k00;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name */
    Spannable f411317d;

    public a(Spannable spannable) {
        this.f411317d = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        if (action != 1 && action != 0) {
            return false;
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
        int totalPaddingTop = y16 - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) this.f411317d.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpanArr.length == 0) {
            Selection.removeSelection(this.f411317d);
            textView.performClick();
            return false;
        }
        if (action == 1) {
            clickableSpanArr[0].onClick(textView);
        } else {
            Spannable spannable = this.f411317d;
            Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), this.f411317d.getSpanEnd(clickableSpanArr[0]));
        }
        return true;
    }
}
