package com.tencent.liteav.sdkcommon;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f119107a;

    /* renamed from: b, reason: collision with root package name */
    private final String f119108b;

    b(DashboardManager dashboardManager, String str) {
        this.f119107a = dashboardManager;
        this.f119108b = str;
    }

    public static Runnable a(DashboardManager dashboardManager, String str) {
        return new b(dashboardManager, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119107a.addDashboardInternal(this.f119108b);
    }
}
