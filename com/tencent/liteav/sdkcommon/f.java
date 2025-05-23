package com.tencent.liteav.sdkcommon;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final DashboardManager f119115a;

    /* renamed from: b, reason: collision with root package name */
    private final String f119116b;

    /* renamed from: c, reason: collision with root package name */
    private final String f119117c;

    f(DashboardManager dashboardManager, String str, String str2) {
        this.f119115a = dashboardManager;
        this.f119116b = str;
        this.f119117c = str2;
    }

    public static Runnable a(DashboardManager dashboardManager, String str, String str2) {
        return new f(dashboardManager, str, str2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f119115a.appendLogInternal(this.f119116b, this.f119117c);
    }
}
