package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public enum gl {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* renamed from: a, reason: collision with other field name */
    private final int f24740a;

    gl(int i3) {
        this.f24740a = i3;
    }

    public int a() {
        return this.f24740a;
    }

    public static gl a(int i3) {
        if (i3 == 1) {
            return MISC_CONFIG;
        }
        if (i3 != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
