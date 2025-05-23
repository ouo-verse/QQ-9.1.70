package com.tencent.mobileqq.guild.util;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class cm<T> extends cn<T> {

    /* renamed from: e, reason: collision with root package name */
    private Boolean f235527e = Boolean.TRUE;

    @Override // com.tencent.mobileqq.guild.util.cn
    @MainThread
    public void d() {
        setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        this.f235527e = Boolean.TRUE;
        super.onActive();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        this.f235527e = Boolean.FALSE;
        super.onInactive();
    }

    @Override // com.tencent.mobileqq.guild.util.cn, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T t16) {
        if (!this.f235527e.booleanValue()) {
            return;
        }
        super.setValue(t16);
    }
}
