package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.XEditTextEx;

/* compiled from: P */
/* loaded from: classes19.dex */
public class XEditTextExWithListener extends XEditTextEx {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
    }

    public XEditTextExWithListener(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return super.onKeyPreIme(i3, keyEvent);
    }

    public void setOnKeyPreImeListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    public XEditTextExWithListener(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }
}
