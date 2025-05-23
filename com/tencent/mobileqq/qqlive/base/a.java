package com.tencent.mobileqq.qqlive.base;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.mvvm.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a<T extends c> extends Dialog {
    static IPatchRedirector $redirector_;

    public a(@NonNull Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        } else {
            init();
        }
    }

    private void init() {
        if (getWindow() != null) {
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
        }
    }
}
