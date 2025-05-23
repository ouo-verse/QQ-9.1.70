package com.tencent.mobileqq.qqlive.trtc.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(Handler handler, Runnable runnable) {
        if (handler == null) {
            runnable.run();
        } else if (Looper.myLooper() != handler.getLooper()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }
}
