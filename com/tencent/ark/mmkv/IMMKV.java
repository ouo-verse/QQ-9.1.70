package com.tencent.ark.mmkv;

import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IMMKV {
    void clear();

    boolean getBoolean(String str, boolean z16);

    byte[] getByte(String str, byte[] bArr);

    double getDouble(String str, double d16);

    float getFloat(String str, float f16);

    int getInt(String str, int i3);

    long getLong(String str, long j3);

    Set<String> getSet(String str, Set<String> set);

    String getString(String str, String str2);

    void putBoolean(String str, boolean z16);

    void putByte(String str, byte[] bArr);

    void putDouble(String str, double d16);

    void putFloat(String str, float f16);

    void putInt(String str, int i3);

    void putLong(String str, long j3);

    void putSet(String str, Set<String> set);

    void putString(String str, String str2);
}
