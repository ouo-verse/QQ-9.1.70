package com.tencent.paysdk.network;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static HandlerThread f342048a;

    /* renamed from: b, reason: collision with root package name */
    static Handler f342049b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MessageHandlerConstants.NOTIFY_TYPE_ROAM_MESSAGE_SEARCH_IN_CLOUD);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("NetworkDispatcher");
        f342048a = baseHandlerThread;
        baseHandlerThread.start();
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (d.class) {
            if (f342049b == null) {
                f342049b = new Handler(f342048a.getLooper());
            }
            f342049b.post(runnable);
        }
    }
}
