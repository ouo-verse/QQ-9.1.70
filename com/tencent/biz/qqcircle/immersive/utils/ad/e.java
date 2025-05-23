package com.tencent.biz.qqcircle.immersive.utils.ad;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/e;", "", "", "src", "", "g", "e", "c", "", "msg", "d", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f90083a = new e();

    e() {
    }

    private final int c() {
        if (DeviceInfoUtils.isLowPerfDevice()) {
            return -3003;
        }
        if (System.currentTimeMillis() - uq3.k.b().f("sp_key_ad_web_preload_last_time", 0L) > 86400000) {
            uq3.k.b().n("sp_key_ad_web_preload_total_count", 1L);
            uq3.k.b().n("sp_key_ad_web_preload_last_time", System.currentTimeMillis());
            return 0;
        }
        long f16 = uq3.k.b().f("sp_key_ad_web_preload_total_count", 0L);
        if (f16 < 4) {
            uq3.k.b().n("sp_key_ad_web_preload_last_time", System.currentTimeMillis());
            uq3.k.b().n("sp_key_ad_web_preload_total_count", f16 + 1);
            return 0;
        }
        return -1000;
    }

    private final void d(String msg2) {
        QLog.i("QFSAdPreloadWebHelper", 2, msg2);
    }

    private final void e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            d("preloadWebProcess app error");
            return;
        }
        if (((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isWebProcessExist()) {
            d("WebProcess exit, cancel preload");
            return;
        }
        int c16 = c();
        if (c16 != 0) {
            d("preloadWebProcess no need result " + c16);
            return;
        }
        d("preloadWebProcess");
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IW\u2026va, ProcessConstant.MAIN)");
        ((IWebProcessManagerService) runtimeService).startWebProcess(40, new com.tencent.mobileqq.webview.util.u() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.d
            @Override // com.tencent.mobileqq.webview.util.u
            public final void onResult(boolean z16) {
                e.f(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(boolean z16) {
        f90083a.d("preloadWebProcess isSuccess " + z16);
    }

    @JvmStatic
    public static final void g(int src) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.ad.c
            @Override // java.lang.Runnable
            public final void run() {
                e.h();
            }
        });
        f90083a.d("preloadWebProcessAsync from = " + src);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        f90083a.e();
    }
}
