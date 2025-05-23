package com.huawei.hms.push.utils.ha;

/* loaded from: classes2.dex */
public class PushAnalyticsCenter {

    /* renamed from: a, reason: collision with root package name */
    public PushBaseAnalytics f37487a;

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public static PushAnalyticsCenter f37488a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f37488a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f37487a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f37487a = pushBaseAnalytics;
    }
}
