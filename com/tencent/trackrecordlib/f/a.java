package com.tencent.trackrecordlib.f;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends View.AccessibilityDelegate {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381120a;

    /* renamed from: b, reason: collision with root package name */
    private View.AccessibilityDelegate f381121b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f381120a = a.class.getSimpleName();
        }
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) accessibilityDelegate);
        } else {
            this.f381121b = accessibilityDelegate;
        }
    }

    public View.AccessibilityDelegate a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View.AccessibilityDelegate) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f381121b;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
            return;
        }
        com.tencent.trackrecordlib.core.c.a().a(view, i3);
        View.AccessibilityDelegate accessibilityDelegate = this.f381121b;
        if (accessibilityDelegate != null) {
            accessibilityDelegate.sendAccessibilityEvent(view, i3);
        } else {
            super.sendAccessibilityEvent(view, i3);
        }
    }
}
