package com.tencent.qqnt.textpreview;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.selectable.h;
import com.tencent.widget.ScrollView;

/* loaded from: classes25.dex */
public abstract class PreviewTextContainerView extends LinearLayout implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static float f362309d;

    /* loaded from: classes25.dex */
    public static class a extends LinkMovementMethod {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static a f362310a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static MovementMethod getInstance() {
            if (f362310a == null) {
                f362310a = new a();
            }
            return f362310a;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, spannable, motionEvent)).booleanValue();
            }
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
                        clickableSpanArr[0].onClick(textView);
                    } else if (action == 0) {
                        Rect rect = new Rect();
                        textView.getGlobalVisibleRect(rect);
                        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                        }
                    }
                    return true;
                }
            }
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public PreviewTextContainerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public abstract TextView h();

    public abstract boolean i();

    public abstract boolean j();

    public abstract void setAniStickerLocID(int i3);

    public abstract void setAniStickerResult(String str);

    public abstract void setAniStickerShowBig(boolean z16);

    public abstract void setAutoAdjustGravity(boolean z16);

    public abstract void setDispatchTouchToTv(boolean z16);

    public abstract void setIsSendMsg(boolean z16);

    public abstract void setOutScrollView(ScrollView scrollView);

    public PreviewTextContainerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PreviewTextContainerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
