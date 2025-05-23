package com.tencent.ecommerce.base.rmonitor.service;

import android.os.Handler;
import android.os.Looper;
import cg0.a;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.rmonitor.api.IECRMonitorManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/base/rmonitor/service/ECRMonitorManager;", "", "", "stage", "", "c", "b", "Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;", "a", "Lcom/tencent/ecommerce/base/rmonitor/api/IECRMonitorManager;", "rMonitorManager", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainThreadHandler", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECRMonitorManager {

    /* renamed from: c, reason: collision with root package name */
    public static final ECRMonitorManager f100953c = new ECRMonitorManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IECRMonitorManager rMonitorManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRMonitorManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    ECRMonitorManager() {
    }

    public final void b(String stage) {
        a.b("ECRMonitorManager", "[traceEnd] stage = " + stage);
        IECRMonitorManager iECRMonitorManager = rMonitorManager;
        if (iECRMonitorManager != null) {
            iECRMonitorManager.traceEnd(stage);
        }
    }

    public final void c(final String stage) {
        a.b("ECRMonitorManager", "[traceStart] stage = " + stage);
        mainThreadHandler.postDelayed(new Runnable() { // from class: com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager$traceStart$1
            @Override // java.lang.Runnable
            public final void run() {
                IECRMonitorManager iECRMonitorManager;
                ECRMonitorManager eCRMonitorManager = ECRMonitorManager.f100953c;
                iECRMonitorManager = ECRMonitorManager.rMonitorManager;
                if (iECRMonitorManager != null) {
                    iECRMonitorManager.traceStart(stage);
                }
            }
        }, 10L);
    }
}
