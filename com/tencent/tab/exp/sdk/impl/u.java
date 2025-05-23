package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import com.tencent.mmkv.MMKV;

/* compiled from: P */
/* loaded from: classes26.dex */
final class u implements id4.a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final MMKV f374176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(@NonNull String str) {
        this.f374176a = MMKV.a0(str, 2);
    }

    @Override // id4.a
    public String[] allKeys() {
        return this.f374176a.allKeys();
    }

    @Override // id4.a
    public void clear() {
        this.f374176a.clearAll();
    }

    @Override // id4.a
    public byte[] getByteArray(String str) {
        return this.f374176a.f(str);
    }

    @Override // id4.a
    public long getLong(String str, long j3) {
        return this.f374176a.m(str, j3);
    }

    @Override // id4.a
    public void lock() {
        this.f374176a.lock();
    }

    @Override // id4.a
    public void putByteArray(@NonNull String str, byte[] bArr) {
        this.f374176a.P(str, bArr);
    }

    @Override // id4.a
    public void putLong(@NonNull String str, long j3) {
        this.f374176a.F(str, j3);
    }

    @Override // id4.a
    public void remove(String str) {
        this.f374176a.remove(str);
    }

    @Override // id4.a
    public void trim() {
        if (this.f374176a.totalSize() > 0) {
            this.f374176a.trim();
        }
    }

    @Override // id4.a
    public void unlock() {
        this.f374176a.unlock();
    }
}
