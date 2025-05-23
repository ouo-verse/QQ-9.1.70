package com.tencent.mtt.hippy.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public enum b {
    EVAL_ERROR('E'),
    RANGE_ERROR('R'),
    REFERENCE_ERROR('F'),
    SYNTAX_ERROR('S'),
    TYPE_ERROR('T'),
    URI_ERROR('U'),
    MESSAGE('m'),
    STACK('s'),
    END('.');


    /* renamed from: j, reason: collision with root package name */
    private final byte f337122j;

    b(char c16) {
        this.f337122j = (byte) c16;
    }

    public byte a() {
        return this.f337122j;
    }

    public static b a(byte b16) {
        for (b bVar : values()) {
            if (bVar.f337122j == b16) {
                return bVar;
            }
        }
        return null;
    }
}
