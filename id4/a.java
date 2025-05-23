package id4;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface a {
    String[] allKeys();

    void clear();

    byte[] getByteArray(String str);

    long getLong(String str, long j3);

    void lock();

    void putByteArray(@NonNull String str, byte[] bArr);

    void putLong(@NonNull String str, long j3);

    void remove(String str);

    void trim();

    void unlock();
}
