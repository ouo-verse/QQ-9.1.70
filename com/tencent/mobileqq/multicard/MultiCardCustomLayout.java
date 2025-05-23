package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MultiCardCustomLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private View.OnLongClickListener f251486d;

    /* renamed from: e, reason: collision with root package name */
    private GestureDetector f251487e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f251488f;

    public MultiCardCustomLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f251488f = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.f251488f && this.f251486d != null && (gestureDetector = this.f251487e) != null) {
            gestureDetector.onTouchEvent(motionEvent);
            dispatchTouchEvent = true;
            if (motionEvent.getActionMasked() == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return dispatchTouchEvent;
    }

    public void setDispatchTouchEventOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onLongClickListener);
        } else {
            this.f251486d = onLongClickListener;
        }
    }

    public MultiCardCustomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f251488f = false;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
