package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasManagerProxy;
import sw4.h;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g implements h {

    /* renamed from: a, reason: collision with root package name */
    private static g f311222a;

    public static g e() {
        if (f311222a == null) {
            synchronized (g.class) {
                if (f311222a == null) {
                    f311222a = new g();
                }
            }
        }
        return f311222a;
    }

    @Override // sw4.h
    public sw4.b a() {
        return new a();
    }

    @Override // sw4.h
    public sw4.e b() {
        return new d();
    }

    @Override // sw4.h
    public sw4.a c() {
        return new e();
    }

    @Override // sw4.h
    public sw4.g d() {
        return new c();
    }

    @Override // sw4.h
    public sw4.c getDbManager() {
        return ((IVasManagerProxy) QRoute.api(IVasManagerProxy.class)).getDbManager();
    }

    @Override // sw4.h
    public sw4.d getHttpDownloader() {
        return ((IVasManagerProxy) QRoute.api(IVasManagerProxy.class)).getHttpDownloader();
    }

    @Override // sw4.h
    public sw4.f getReportManager() {
        return new f();
    }
}
