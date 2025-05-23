package com.tencent.smtt.sdk.network;

/* compiled from: P */
/* loaded from: classes23.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f369456a;

    c() {
    }

    public static a a(String str, b bVar) {
        if ("http".equals(str) || "https".equals(str)) {
            return a(bVar);
        }
        return null;
    }

    private static a a(b bVar) {
        a aVar = f369456a;
        if (aVar != null) {
            return aVar;
        }
        synchronized (c.class) {
            if (f369456a == null) {
                f369456a = new a(bVar);
            }
        }
        return f369456a;
    }
}
