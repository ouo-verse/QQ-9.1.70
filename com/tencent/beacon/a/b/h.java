package com.tencent.beacon.a.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h extends g {

    /* renamed from: e, reason: collision with root package name */
    private static volatile h f77609e;

    h() {
    }

    public static h e() {
        if (f77609e == null) {
            synchronized (h.class) {
                if (f77609e == null) {
                    f77609e = new h();
                }
            }
        }
        return f77609e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.beacon.a.b.g
    public String b() {
        return "03300051017";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.beacon.a.b.g
    public String c() {
        return "9462881773";
    }
}
