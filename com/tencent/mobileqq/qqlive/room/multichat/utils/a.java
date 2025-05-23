package com.tencent.mobileqq.qqlive.room.multichat.utils;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final PopupWindow f271691a;

    /* renamed from: b, reason: collision with root package name */
    private final Activity f271692b;

    public a(Activity activity, View view, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, view, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f271692b = activity;
        PopupWindow popupWindow = new PopupWindow(view, -1, i3);
        this.f271691a = popupWindow;
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(z16);
        popupWindow.setSoftInputMode(16);
        popupWindow.setAnimationStyle(R.style.ayq);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (!this.f271691a.isShowing()) {
                return;
            }
            this.f271691a.dismiss();
        }
    }

    public void b(PopupWindow.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onDismissListener);
            return;
        }
        if (!this.f271691a.isShowing()) {
            this.f271691a.showAtLocation(this.f271692b.getWindow().getDecorView(), 80, 0, 0);
        }
        this.f271691a.setOnDismissListener(onDismissListener);
    }
}
