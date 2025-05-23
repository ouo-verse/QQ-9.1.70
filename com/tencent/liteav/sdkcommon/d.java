package com.tencent.liteav.sdkcommon;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f119111a;

    d(DashboardManager dashboardManager) {
        this.f119111a = dashboardManager;
    }

    public static Runnable a(DashboardManager dashboardManager) {
        return new d(dashboardManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119111a.removeAllDashboardInternal();
    }
}
