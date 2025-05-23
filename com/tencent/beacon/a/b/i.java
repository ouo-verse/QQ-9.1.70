package com.tencent.beacon.a.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i extends g {

    /* renamed from: e, reason: collision with root package name */
    private static volatile i f77610e;

    i() {
    }

    public static i e() {
        if (f77610e == null) {
            synchronized (i.class) {
                if (f77610e == null) {
                    f77610e = new i();
                }
            }
        }
        return f77610e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.beacon.a.b.g
    public String b() {
        return "00400014144";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.beacon.a.b.g
    public String c() {
        return "6478159937";
    }
}
