package com.tencent.mobileqq.login;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ak implements y {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private y f241872a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class a implements y {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Activity> f241873a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<Dialog> f241874b;

        a(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            } else {
                this.f241873a = new WeakReference<>(activity);
            }
        }

        @Override // com.tencent.mobileqq.login.y
        public void a(String str) {
            Dialog dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            Activity activity = this.f241873a.get();
            if (activity != null && !activity.isFinishing()) {
                WeakReference<Dialog> weakReference = this.f241874b;
                if (weakReference != null) {
                    dialog = weakReference.get();
                } else {
                    dialog = null;
                }
                if (dialog != null && dialog.isShowing()) {
                    return;
                }
                Dialog showLoadingDialog = DialogUtil.showLoadingDialog(activity, str, false);
                try {
                    showLoadingDialog.show();
                } catch (Exception e16) {
                    QLog.w("LoginLoadingProxy", 1, "show dialog exception", e16);
                }
                this.f241874b = new WeakReference<>(showLoadingDialog);
            }
        }

        @Override // com.tencent.mobileqq.login.y
        public void b(boolean z16) {
            Dialog dialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            WeakReference<Dialog> weakReference = this.f241874b;
            if (weakReference != null) {
                dialog = weakReference.get();
            } else {
                dialog = null;
            }
            if (dialog != null && dialog.isShowing()) {
                try {
                    dialog.dismiss();
                } catch (Exception e16) {
                    QLog.w("LoginLoadingProxy", 1, "dismiss dialog exception", e16);
                }
            }
            this.f241874b = null;
        }
    }

    public ak(Activity activity, y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) yVar);
            return;
        }
        this.f241872a = yVar;
        if (yVar == null) {
            this.f241872a = new a(activity);
        }
    }

    @Override // com.tencent.mobileqq.login.y
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f241872a.a(str);
        }
    }

    @Override // com.tencent.mobileqq.login.y
    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f241872a.b(z16);
        }
    }
}
