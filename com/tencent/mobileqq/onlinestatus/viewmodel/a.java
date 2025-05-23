package com.tencent.mobileqq.onlinestatus.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<AppInterface> f256860a;

    public a(AppInterface appInterface) {
        this.f256860a = new WeakReference<>(appInterface);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        com.tencent.mobileqq.onlinestatus.repository.a aVar = new com.tencent.mobileqq.onlinestatus.repository.a(this.f256860a.get());
        AccountOnlineStateViewModel accountOnlineStateViewModel = new AccountOnlineStateViewModel(aVar);
        aVar.m(accountOnlineStateViewModel);
        return accountOnlineStateViewModel;
    }
}
