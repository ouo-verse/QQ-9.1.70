package com.tencent.luggage.wxa.li;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a {
    NeedLatestVersion,
    LocalVersionFallback,
    UpdateApp,
    WxaMigrate,
    WeakNetReload,
    FallbackErrorReload,
    NeedLatestVersionByLaunchParams,
    JsApiNavigateToMiniProgram;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.li.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public /* synthetic */ class C6442a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f133419a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.UpdateApp.ordinal()] = 1;
            f133419a = iArr;
        }
    }

    public final String b() {
        if (C6442a.f133419a[ordinal()] == 1) {
            return "updateApp";
        }
        return name();
    }
}
