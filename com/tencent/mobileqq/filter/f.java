package com.tencent.mobileqq.filter;

import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f209751a;

    /* renamed from: b, reason: collision with root package name */
    public static int f209752b;

    /* renamed from: c, reason: collision with root package name */
    public static int f209753c;

    /* renamed from: d, reason: collision with root package name */
    private static QQFilterRenderManager f209754d;

    /* renamed from: e, reason: collision with root package name */
    private static QQFilterRenderManager f209755e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42810);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ((IAEKitForQQ) QRoute.api(IAEKitForQQ.class)).initWithConfig();
        ((ICaptureUtil) QRoute.api(ICaptureUtil.class)).loadEffectSo();
        f209751a = 0;
        f209752b = 1;
        f209753c = 2;
    }

    public static QQFilterRenderManager a() {
        return new QQFilterRenderManager(new int[]{70, 80, 90, 184});
    }

    public static QQFilterRenderManager b(int i3) {
        if (i3 == f209753c) {
            return f209754d;
        }
        return null;
    }

    public static synchronized QQFilterRenderManager c() {
        QQFilterRenderManager qQFilterRenderManager;
        synchronized (f.class) {
            QQFilterRenderManager qQFilterRenderManager2 = f209755e;
            if (qQFilterRenderManager2 != null && qQFilterRenderManager2.isSurfaceDestroyed()) {
                f209755e = null;
            }
            if (f209755e == null) {
                f209755e = a();
            }
            qQFilterRenderManager = f209755e;
        }
        return qQFilterRenderManager;
    }

    public static void d(QQFilterRenderManager qQFilterRenderManager) {
        f209754d = qQFilterRenderManager;
    }
}
