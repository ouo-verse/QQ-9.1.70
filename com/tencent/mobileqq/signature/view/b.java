package com.tencent.mobileqq.signature.view;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends LinkMovementMethod {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static b f288496c;

    /* renamed from: a, reason: collision with root package name */
    ITopic f288497a;

    /* renamed from: b, reason: collision with root package name */
    boolean f288498b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static MovementMethod getInstance() {
        if (f288496c == null) {
            f288496c = new b();
        }
        return f288496c;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        ITopic iTopic;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, spannable, motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 0 || action == 3) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int totalPaddingLeft = x16 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y16 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            ITopic[] iTopicArr = (ITopic[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ITopic.class);
            if (QLog.isColorLevel()) {
                QLog.i("StateColorMovementMethod", 2, String.format("onTouch action[%d] links=[%d]", Integer.valueOf(action), Integer.valueOf(iTopicArr.length)));
            }
            if (iTopicArr.length != 0) {
                this.f288498b = false;
                ITopic iTopic2 = iTopicArr[0];
                if (action == 1) {
                    ITopic iTopic3 = this.f288497a;
                    if (iTopic3 != null) {
                        iTopic3.setPressed(textView, false);
                        this.f288497a = null;
                    }
                    iTopic2.onClick(textView);
                } else if (action == 0) {
                    iTopic2.setPressed(textView, true);
                    this.f288497a = iTopic2;
                } else if (action == 3 && (iTopic = this.f288497a) != null) {
                    iTopic.setPressed(textView, false);
                    this.f288497a = null;
                }
                return true;
            }
            if (action == 1) {
                if (this.f288498b) {
                    this.f288498b = false;
                    textView.performClick();
                }
            } else if (action == 0) {
                this.f288498b = true;
            } else if (action == 3) {
                this.f288498b = false;
            }
            ITopic iTopic4 = this.f288497a;
            if (iTopic4 != null) {
                iTopic4.setPressed(textView, false);
                this.f288497a = null;
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
