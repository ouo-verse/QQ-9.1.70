package com.tencent.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class NoFitXPanelContainer extends XPanelContainer {
    static IPatchRedirector $redirector_;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f384627n0;

    public NoFitXPanelContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f384627n0 = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) rect)).booleanValue();
        }
        if (this.f384627n0) {
            rect.top = 0;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            super.setFitsSystemWindows(z16);
            this.f384627n0 = true;
        }
    }

    public NoFitXPanelContainer(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f384627n0 = false;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
    }
}
