package com.tencent.liteav.sdkcommon;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f119109a;

    /* renamed from: b, reason: collision with root package name */
    private final String f119110b;

    c(DashboardManager dashboardManager, String str) {
        this.f119109a = dashboardManager;
        this.f119110b = str;
    }

    public static Runnable a(DashboardManager dashboardManager, String str) {
        return new c(dashboardManager, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119109a.removeDashboardInternal(this.f119110b);
    }
}
