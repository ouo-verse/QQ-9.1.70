package com.tencent.trackrecordlib.f;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.f.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e implements View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private View.OnTouchListener f381127a;

    /* renamed from: b, reason: collision with root package name */
    private b.InterfaceC10020b f381128b;

    public e(View.OnTouchListener onTouchListener, b.InterfaceC10020b interfaceC10020b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onTouchListener, (Object) interfaceC10020b);
        } else {
            this.f381127a = onTouchListener;
            this.f381128b = interfaceC10020b;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        b.InterfaceC10020b interfaceC10020b = this.f381128b;
        if (interfaceC10020b != null) {
            interfaceC10020b.a(view, motionEvent);
        }
        View.OnTouchListener onTouchListener = this.f381127a;
        if (onTouchListener != null && onTouchListener.onTouch(view, motionEvent)) {
            return true;
        }
        return false;
    }
}
