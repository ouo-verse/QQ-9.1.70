package com.tencent.liteav.sdkcommon;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f119112a;

    /* renamed from: b, reason: collision with root package name */
    private final String f119113b;

    /* renamed from: c, reason: collision with root package name */
    private final String f119114c;

    e(DashboardManager dashboardManager, String str, String str2) {
        this.f119112a = dashboardManager;
        this.f119113b = str;
        this.f119114c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new e(dashboardManager, str, str2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119112a.setStatusInternal(this.f119113b, this.f119114c);
    }
}
