package com.tencent.mobileqq.qqlive.widget.chat.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LinkMovementLongClickMethod extends LinkMovementMethod {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static LinkMovementLongClickMethod f273880e;

    /* renamed from: a, reason: collision with root package name */
    private long f273881a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private d f273882b;

    /* renamed from: c, reason: collision with root package name */
    private b f273883c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f273884d;

    public LinkMovementLongClickMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273884d = new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.chat.span.LinkMovementLongClickMethod.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LinkMovementLongClickMethod.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (LinkMovementLongClickMethod.this.f273882b != null) {
                        LinkMovementLongClickMethod.this.f273882b.a();
                        LinkMovementLongClickMethod.this.f273882b = null;
                    }
                }
            };
        }
    }

    public static LinkMovementLongClickMethod c() {
        if (f273880e == null) {
            f273880e = new LinkMovementLongClickMethod();
        }
        return f273880e;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, spannable, motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 1 && action != 0) {
            if (action == 3) {
                textView.removeCallbacks(this.f273884d);
                this.f273882b = null;
            }
        } else {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y16 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            b[] bVarArr = (b[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, b.class);
            if (bVarArr.length > 0) {
                this.f273883c = bVarArr[0];
            }
            b bVar = this.f273883c;
            if (bVar != null) {
                bVar.a(motionEvent);
            }
            if (clickableSpanArr.length != 0) {
                ClickableSpan clickableSpan = clickableSpanArr[0];
                if (action == 1) {
                    if (System.currentTimeMillis() - this.f273881a < 300) {
                        clickableSpanArr[0].onClick(textView);
                    } else {
                        d dVar = this.f273882b;
                        if (dVar != null && dVar == clickableSpan) {
                            dVar.a();
                        }
                    }
                    textView.removeCallbacks(this.f273884d);
                    this.f273882b = null;
                } else {
                    this.f273882b = null;
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpan), spannable.getSpanEnd(clickableSpanArr[0]));
                    this.f273881a = System.currentTimeMillis();
                    if (clickableSpan instanceof d) {
                        this.f273882b = (d) clickableSpan;
                        textView.postDelayed(this.f273884d, 300L);
                    }
                }
                return true;
            }
            Selection.removeSelection(spannable);
            this.f273882b = null;
        }
        if (action == 1 || action == 3) {
            this.f273883c = null;
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
