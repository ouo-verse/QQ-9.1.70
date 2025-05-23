package com.tencent.qfsmonet.utils;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static boolean a(@NonNull MonetHandler monetHandler, @NonNull Runnable runnable) {
        try {
            if (Looper.myLooper() == monetHandler.getLooper()) {
                runnable.run();
                return true;
            }
            monetHandler.b(runnable);
            return true;
        } catch (IllegalStateException e16) {
            a.b("MonetUtils", "init failed. ex=" + e16.toString());
            return false;
        }
    }
}
