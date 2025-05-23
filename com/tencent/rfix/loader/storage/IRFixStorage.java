package com.tencent.rfix.loader.storage;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRFixStorage {
    boolean contains(String str);

    boolean delete(boolean z16);

    boolean getBoolean(String str, boolean z16);

    int getInt(String str, int i3);

    long getLong(String str, long j3);

    String getString(String str, String str2);

    void load(boolean z16);

    void putBoolean(String str, boolean z16);

    void putInt(String str, int i3);

    void putLong(String str, long j3);

    void putString(String str, String str2);

    void remove(String str);

    void save(boolean z16);
}
