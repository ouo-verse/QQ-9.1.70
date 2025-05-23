package com.tencent.mobileqq.qqlive.verified;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends com.tencent.mobileqq.qqfloatingwindow.a {
    static IPatchRedirector $redirector_;
    public static final String CLASS_NAME;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61890);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            CLASS_NAME = a.class.getName();
        }
    }

    public a(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void o0() {
        ViewParent parent;
        if (z() == null || (parent = z().getParent()) == null) {
            return;
        }
        ViewParent parent2 = parent.getParent();
        if (parent2 instanceof FrameLayout) {
            ((FrameLayout) parent2).setElevation(0.0f);
        }
    }

    private void p0() {
        View A = A(R.id.m2n);
        if (A != null) {
            A.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.updateFloatingView();
        p0();
        int dip2px = ViewUtils.dip2px(4.0f);
        setRoundCorners(dip2px, dip2px);
        V(null);
        P(null);
        o0();
    }
}
