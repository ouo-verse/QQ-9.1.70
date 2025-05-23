package com.tencent.mobileqq.nearby.now.utils.impl;

import android.content.Context;
import com.tencent.mobileqq.nearby.now.utils.IStorageCenter;
import q92.d;

/* compiled from: P */
/* loaded from: classes33.dex */
public class StorageCenterImpl implements IStorageCenter {
    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public boolean getBoolean(String str, boolean z16) {
        return d.a(str, z16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public float getFloat(String str, float f16) {
        return d.b(str, f16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public int getInt(String str, int i3) {
        return d.c(str, i3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public long getLong(String str, long j3) {
        return d.d(str, j3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public String getString(String str, String str2) {
        return d.e(str, str2);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public void init(Context context, String str) {
        d.f(context, str);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public void putBoolean(String str, boolean z16) {
        d.g(str, z16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public void putFloat(String str, float f16) {
        d.h(str, f16);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public void putInt(String str, int i3) {
        d.i(str, i3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public void putLong(String str, long j3) {
        d.j(str, j3);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public void putString(String str, String str2) {
        d.k(str, str2);
    }

    @Override // com.tencent.mobileqq.nearby.now.utils.IStorageCenter
    public void remove(String str) {
        d.l(str);
    }
}
