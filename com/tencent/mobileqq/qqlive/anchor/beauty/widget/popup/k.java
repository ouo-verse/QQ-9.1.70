package com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class k extends l {
    static IPatchRedirector $redirector_;
    private View I;
    private PopupWindow J;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.I = null;
            this.J = null;
        }
    }

    private View n(Activity activity) {
        View inflate = View.inflate(activity, R.layout.h_g, null);
        l(activity, inflate);
        return inflate;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void q(Activity activity, View view, int i3) {
        View decorView = activity.getWindow().getDecorView();
        activity.getWindowManager().getDefaultDisplay().getSize(new Point());
        if (this.J == null) {
            PopupWindow popupWindow = new PopupWindow(view, -1, com.tencent.mobileqq.qqlive.anchor.beauty.utils.d.a(activity, 251.0f));
            this.J = popupWindow;
            popupWindow.setFocusable(true);
            this.J.setOutsideTouchable(true);
            this.J.setSoftInputMode(16);
            this.J.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.j
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    k.this.m();
                }
            });
            this.J.setAnimationStyle(R.style.ayq);
            this.J.update();
        }
        if (!this.J.isShowing()) {
            this.J.showAtLocation(decorView, 80, 0, i3);
            i();
        }
    }

    public void o(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            p(activity, 0);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.l
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.I = null;
        PopupWindow popupWindow = this.J;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.J = null;
        super.onDestroy();
    }

    public void p(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, i3);
            return;
        }
        if (this.I == null) {
            this.I = n(activity);
        }
        q(activity, this.I, i3);
    }
}
