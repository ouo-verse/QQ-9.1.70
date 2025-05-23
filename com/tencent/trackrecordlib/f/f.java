package com.tencent.trackrecordlib.f;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f extends TouchDelegate {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private View f381129a;

    /* renamed from: b, reason: collision with root package name */
    private TouchDelegate f381130b;

    public f(TouchDelegate touchDelegate, Rect rect, View view) {
        super(rect, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, touchDelegate, rect, view);
        } else {
            this.f381130b = touchDelegate;
            this.f381129a = view;
        }
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            int actionIndex = motionEvent.getActionIndex();
            com.tencent.trackrecordlib.core.c.a().a(this.f381129a, motionEvent.getAction(), motionEvent.getPointerId(actionIndex), motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getX(actionIndex), motionEvent.getY(actionIndex), motionEvent.getRawX(), motionEvent.getRawY());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        TouchDelegate touchDelegate = this.f381130b;
        if (touchDelegate != null && touchDelegate.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }
}
