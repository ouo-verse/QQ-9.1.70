package com.tencent.paysdk.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Handler f342083a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AppConstants.VALUE.UIN_TYPE_CONVERSATION_CONTACTS_GUIDE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342083a = new Handler(Looper.getMainLooper());
        }
    }

    public static Handler a() {
        return f342083a;
    }

    public static void b(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f342083a.post(runnable);
        }
    }
}
