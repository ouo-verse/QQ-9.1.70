package com.tencent.mobileqq.util;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.gathererga.tangram.b;
import com.tencent.gathererga.tangram.e;
import com.tencent.gdtad.config.IGdtConfigAPI;
import com.tencent.gdtad.config.data.c;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f306529a = false;

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.gathererga.tangram.e f306530b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8889a implements com.tencent.gathererga.core.d {
        C8889a() {
        }

        @Override // com.tencent.gathererga.core.d
        public void d(String str, String str2) {
            AdLog.d(str, str2);
        }

        @Override // com.tencent.gathererga.core.d
        public void e(String str, String str2) {
            AdLog.e(str, str2);
        }

        @Override // com.tencent.gathererga.core.d
        public void i(String str, String str2) {
            AdLog.i(str, str2);
        }

        @Override // com.tencent.gathererga.core.d
        public void w(String str, String str2) {
            AdLog.w(str, str2);
        }

        @Override // com.tencent.gathererga.core.d
        public void e(String str, String str2, Throwable th5) {
            AdLog.e(str, str2, th5);
        }

        @Override // com.tencent.gathererga.core.d
        public void w(String str, String str2, Throwable th5) {
            AdLog.w(str, str2, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements com.tencent.gathererga.sdk.b {
        b() {
        }

        @Override // com.tencent.gathererga.sdk.b
        public boolean userAgreement() {
            return PrivacyPolicyHelper.isUserAllow();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements com.tencent.gathererga.core.c {
        c() {
        }

        @Override // com.tencent.gathererga.core.c
        public void execute(Runnable runnable) {
            AdThreadManager.getInstance().post(runnable, 4);
        }
    }

    public static com.tencent.gathererga.tangram.e a() {
        return f306530b;
    }

    private static void b() {
        QLog.i("ADGatherSdkInitHelper", 1, "init GatherSDK ");
        BaseApplication context = BaseApplication.getContext();
        try {
            C8889a c8889a = new C8889a();
            ConcurrentHashMap<Integer, com.tencent.gathererga.tangram.c> concurrentHashMap = new ConcurrentHashMap<>();
            com.tencent.gathererga.core.internal.provider.b f16 = com.tencent.gathererga.core.internal.provider.b.f().i().l().g(false).f();
            com.tencent.gathererga.tangram.c cVar = new com.tencent.gathererga.tangram.c();
            cVar.k(true);
            cVar.i(f16);
            cVar.m(f16);
            cVar.j(true);
            f306530b = e.a.a(context, new b.C1148b().n(new c()).o(true).m("1109803375").l(AdVersion.getInstance().getAppVersion()).r(concurrentHashMap).q(new b()).p(c8889a).k());
        } catch (Throwable th5) {
            QLog.e("ADGatherSdkInitHelper", 1, th5, "Gather init crash fail");
            throw th5;
        }
    }

    public static void c() {
        if (f306529a) {
            return;
        }
        synchronized (a.class) {
            if (f306529a) {
                return;
            }
            b();
            f306529a = true;
        }
    }

    private static boolean d() {
        c.b bVar;
        try {
            com.tencent.gdtad.config.data.c configForDeviceInfo = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).getConfigForDeviceInfo();
            if (configForDeviceInfo == null || (bVar = configForDeviceInfo.switches) == null) {
                return false;
            }
            if (!bVar.switch128) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            GdtLog.e("ADGatherSdkInitHelper", "[isScreenWidthBucketEnabled]", th5);
            return false;
        }
    }

    public static void e() {
        if (!f306529a) {
            QLog.i("ADGatherSdkInitHelper", 1, "gatherer is not init");
            return;
        }
        if (f306530b == null) {
            QLog.i("ADGatherSdkInitHelper", 1, "gatherer is not init");
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        ConcurrentHashMap<Integer, Object> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            concurrentHashMap.put(701, com.tencent.mobileqq.statistics.o.c());
            if (d()) {
                concurrentHashMap.put(128, Integer.valueOf(com.tencent.gdtad.util.o.a(context)));
            }
        } catch (Throwable th5) {
            QLog.i("ADGatherSdkInitHelper", 1, th5.getMessage());
        }
        f306530b.d(concurrentHashMap);
    }
}
