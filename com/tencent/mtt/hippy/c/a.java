package com.tencent.mtt.hippy.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public enum a {
    INT8_ARRAY('b'),
    UINT8_ARRAY('B'),
    UINT8_CLAMPED_ARRAY('C'),
    INT16_ARRAY('w'),
    UINT16_ARRAY('W'),
    INT32_ARRAY('d'),
    UINT32_ARRAY('D'),
    FLOAT32_ARRAY('f'),
    FLOAT64_ARRAY('F'),
    BIGINT64_ARRAY('q'),
    BIGUINT64_ARRAY('Q'),
    DATA_VIEW('?');


    /* renamed from: m, reason: collision with root package name */
    private final byte f337109m;

    a(char c16) {
        this.f337109m = (byte) c16;
    }

    public byte a() {
        return this.f337109m;
    }

    public static a a(byte b16) {
        for (a aVar : values()) {
            if (aVar.f337109m == b16) {
                return aVar;
            }
        }
        return null;
    }
}
