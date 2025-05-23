package com.tencent.raft.standard.storage;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRStorage {
    public static final IPatchRedirector $redirector_ = null;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface IRStorageFactory {
        IRStorage createIRStorage(String str);
    }

    @Nullable
    String[] allKeys();

    void clear();

    @Nullable
    byte[] getByteArray(@NotNull String str);

    long getLong(@NotNull String str, long j3);

    String getString(@NotNull String str, String str2);

    void lock();

    void putByteArray(@NotNull String str, @Nullable byte[] bArr);

    void putLong(@NotNull String str, long j3);

    void putString(@NotNull String str, String str2);

    void remove(@NotNull String str);

    void trim();

    void unlock();
}
