package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum gm {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* renamed from: a, reason: collision with other field name */
    private final int f24742a;

    gm(int i3) {
        this.f24742a = i3;
    }

    public static gm a(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    return BOOLEAN;
                }
                return STRING;
            }
            return LONG;
        }
        return INT;
    }
}
