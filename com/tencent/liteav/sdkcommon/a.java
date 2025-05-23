package com.tencent.liteav.sdkcommon;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f119105a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f119106b;

    a(DashboardManager dashboardManager, boolean z16) {
        this.f119105a = dashboardManager;
        this.f119106b = z16;
    }

    public static Runnable a(DashboardManager dashboardManager, boolean z16) {
        return new a(dashboardManager, z16);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119105a.showDashboardInternal(this.f119106b);
    }
}
