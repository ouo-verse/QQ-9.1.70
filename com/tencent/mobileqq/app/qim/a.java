package com.tencent.mobileqq.app.qim;

import android.content.DialogInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f196532a;

    /* renamed from: b, reason: collision with root package name */
    private static DialogInterface.OnDismissListener f196533b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.qim.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class DialogInterfaceOnDismissListenerC7390a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        DialogInterfaceOnDismissListenerC7390a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.f196532a = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f196533b = new DialogInterfaceOnDismissListenerC7390a();
        }
    }

    public static void b() {
        b bVar = f196532a;
        if (bVar != null && bVar.isShowing()) {
            f196532a.dismiss();
        }
    }
}
