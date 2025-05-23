package com.tencent.trackrecordlib.f;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void a(View view, int i3, KeyEvent keyEvent);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.trackrecordlib.f.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC10020b {
        void a(View view, MotionEvent motionEvent);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
