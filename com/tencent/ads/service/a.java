package com.tencent.ads.service;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f61685a = ".l.qq.com";

    /* renamed from: b, reason: collision with root package name */
    private static final String f61686b = "AdConfig";

    /* renamed from: c, reason: collision with root package name */
    private static a f61687c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f61688d = ".qq.com";

    /* renamed from: e, reason: collision with root package name */
    private static final String f61689e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f61690f;

    /* renamed from: g, reason: collision with root package name */
    private String f61691g = f61690f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f61692h = true;

    static {
        String str = "https://dp3" + f61688d;
        f61689e = str;
        f61690f = String.valueOf(str) + "/exception/";
    }

    a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f61687c == null) {
                f61687c = new a();
            }
            aVar = f61687c;
        }
        return aVar;
    }

    public final boolean b() {
        return this.f61692h;
    }

    public final String c() {
        return this.f61691g;
    }
}
