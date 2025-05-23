package com.tencent.avcore.camera.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final HandlerThread f77465a;

    /* renamed from: b, reason: collision with root package name */
    private static final Handler f77466b;

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f77467c;

    /* renamed from: d, reason: collision with root package name */
    private static a f77468d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13441);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("qav_camera_thread_sub");
        f77465a = baseHandlerThread;
        baseHandlerThread.start();
        f77466b = new Handler(Looper.getMainLooper());
        f77467c = new Handler(baseHandlerThread.getLooper());
    }

    public static Handler a() {
        return f77467c;
    }

    public static void b(a aVar) {
        if (f77468d == null) {
            return;
        }
        f77468d = aVar;
    }
}
