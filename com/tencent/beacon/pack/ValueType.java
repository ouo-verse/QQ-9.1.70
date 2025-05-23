package com.tencent.beacon.pack;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ValueType implements Serializable {
    public static final int BYTE_VAL = 1;
    public static final int MAP_VAL = 0;
    public static final int UNKNOWN_VAL = 2;

    /* renamed from: t, reason: collision with root package name */
    private String f78094t;
    private int value;
    public static final ValueType MAP = new ValueType(0, 0, "MAP");
    public static final ValueType BYTE = new ValueType(1, 1, "BYTE");
    public static final ValueType UNKNOWN = new ValueType(2, 2, "UNKNOWN");
    private static ValueType[] values = new ValueType[3];

    ValueType(int i3, int i16, String str) {
        this.f78094t = str;
        this.value = i16;
        values[i3] = this;
    }

    public static ValueType convert(int i3) {
        for (ValueType valueType : values) {
            if (valueType.value() == i3) {
                return valueType;
            }
        }
        return null;
    }

    public String toString() {
        return this.f78094t;
    }

    public int value() {
        return this.value;
    }

    public static ValueType convert(String str) {
        for (ValueType valueType : values) {
            if (valueType.toString().equals(str)) {
                return valueType;
            }
        }
        return null;
    }
}
