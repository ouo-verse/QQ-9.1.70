package com.tencent.mobileqq.richstatus.comment.spannable;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseMovementMethod {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f282324a;

    /* renamed from: b, reason: collision with root package name */
    private int f282325b;

    /* renamed from: c, reason: collision with root package name */
    private int f282326c;

    /* renamed from: d, reason: collision with root package name */
    private BackgroundColorSpan f282327d;

    /* renamed from: e, reason: collision with root package name */
    private ClickableSpan[] f282328e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f282329f;

    public a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f282324a = "CommentMovementMethod";
        this.f282329f = true;
        this.f282326c = i3;
        this.f282325b = i16;
    }

    private void a(boolean z16) {
        this.f282329f = z16;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f282329f;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, textView, spannable, motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y16 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            this.f282328e = clickableSpanArr;
            if (clickableSpanArr.length > 0) {
                a(false);
                Selection.setSelection(spannable, spannable.getSpanStart(this.f282328e[0]), spannable.getSpanEnd(this.f282328e[0]));
                BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(this.f282326c);
                this.f282327d = backgroundColorSpan;
                spannable.setSpan(backgroundColorSpan, spannable.getSpanStart(this.f282328e[0]), spannable.getSpanEnd(this.f282328e[0]), 33);
            } else {
                a(true);
                textView.setBackgroundColor(this.f282325b);
            }
        } else if (action == 1) {
            ClickableSpan[] clickableSpanArr2 = this.f282328e;
            if (clickableSpanArr2.length > 0) {
                clickableSpanArr2[0].onClick(textView);
                Object obj = this.f282327d;
                if (obj != null) {
                    spannable.removeSpan(obj);
                }
            }
            Selection.removeSelection(spannable);
            textView.setBackgroundResource(R.color.ajr);
        } else if (action != 2) {
            Object obj2 = this.f282327d;
            if (obj2 != null) {
                spannable.removeSpan(obj2);
            }
            textView.setBackgroundResource(R.color.ajr);
        }
        return Touch.onTouchEvent(textView, spannable, motionEvent);
    }
}
