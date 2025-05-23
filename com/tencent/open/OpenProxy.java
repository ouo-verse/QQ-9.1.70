package com.tencent.open;

import com.tencent.mobileqq.app.ThreadManagerV2;

/* loaded from: classes22.dex */
public class OpenProxy {

    /* renamed from: a, reason: collision with root package name */
    private static OpenProxy f339502a;

    OpenProxy() {
    }

    public static synchronized OpenProxy c() {
        OpenProxy openProxy;
        synchronized (OpenProxy.class) {
            if (f339502a == null) {
                f339502a = new OpenProxy();
            }
            openProxy = f339502a;
        }
        return openProxy;
    }

    public void a(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.OpenProxy.1
            @Override // java.lang.Runnable
            public void run() {
                up3.b.b(str);
            }
        }, 64, null, false);
    }

    public void b(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.OpenProxy.2
            @Override // java.lang.Runnable
            public void run() {
                up3.b.g(str);
            }
        }, 64, null, false);
    }
}
