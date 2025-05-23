package com.tencent.centaur.host.loader.debug.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.centaur.host.loader.debug.base.CentaurDragFloatTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CentaurLoadControlView extends CentaurDragFloatTextView {
    static IPatchRedirector $redirector_;

    public CentaurLoadControlView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public CentaurLoadControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CentaurLoadControlView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    private void b() {
    }
}
