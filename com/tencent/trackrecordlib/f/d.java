package com.tencent.trackrecordlib.f;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.f.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d implements View.OnKeyListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private View.OnKeyListener f381125a;

    /* renamed from: b, reason: collision with root package name */
    private b.a f381126b;

    public d(View.OnKeyListener onKeyListener, b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onKeyListener, (Object) aVar);
        } else {
            this.f381125a = onKeyListener;
            this.f381126b = aVar;
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
        }
        Log.d("OnKeyListenerProxy", "---------------OnKeyListenerProxy-------------");
        b.a aVar = this.f381126b;
        if (aVar != null) {
            aVar.a(view, i3, keyEvent);
        }
        View.OnKeyListener onKeyListener = this.f381125a;
        if (onKeyListener != null && onKeyListener.onKey(view, i3, keyEvent)) {
            return true;
        }
        return false;
    }
}
