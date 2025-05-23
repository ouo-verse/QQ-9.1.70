package com.tencent.tuxmetersdk.export.injector.storage;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxStorage {
    String[] allKeys();

    byte[] getByteArray(String str);

    long getLong(String str, long j3);

    String getString(String str);

    void lock();

    void putByteArray(String str, byte[] bArr);

    void putLong(String str, long j3);

    void putString(String str, String str2);

    void remove(String str);

    void trim();

    void unlock();
}
