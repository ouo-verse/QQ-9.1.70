package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum eh {
    None("", 0),
    Gradient("heat", 2),
    Aggregation("honey", 3),
    ArcLine("arcline", 4),
    GLModel("model", 5),
    Trail("trail", 6),
    Scatter("scatter", 7);


    /* renamed from: h, reason: collision with root package name */
    public final String f148161h;

    /* renamed from: i, reason: collision with root package name */
    private final int f148162i;

    eh(String str, int i3) {
        this.f148161h = str;
        this.f148162i = i3;
    }

    public static eh a(int i3) {
        for (eh ehVar : values()) {
            if (ehVar.f148162i == i3) {
                return ehVar;
            }
        }
        return None;
    }

    private static eh b(String str) {
        for (eh ehVar : values()) {
            if (ehVar.a(str)) {
                return ehVar;
            }
        }
        return None;
    }

    private boolean b(int i3) {
        return this.f148162i == i3;
    }

    public final boolean a(String str) {
        return this.f148161h.equals(str);
    }

    private String a() {
        return this.f148161h;
    }
}
