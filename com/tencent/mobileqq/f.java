package com.tencent.mobileqq;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f implements DialogInterface.OnCancelListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<Activity> f205582d;

    public f(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.f205582d = new WeakReference<>(activity);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            return;
        }
        Activity activity = this.f205582d.get();
        if (activity != null && !activity.isFinishing()) {
            dialogInterface.dismiss();
        }
    }
}
