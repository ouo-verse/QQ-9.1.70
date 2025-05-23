package com.tencent.mobileqq.onlinestatus.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<AppInterface> f256863a;

    public d(AppInterface appInterface) {
        this.f256863a = new WeakReference<>(appInterface);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        AccountPanelRepository accountPanelRepository = new AccountPanelRepository(this.f256863a.get());
        AccountPanelViewModel accountPanelViewModel = new AccountPanelViewModel(accountPanelRepository);
        accountPanelRepository.P(accountPanelViewModel);
        return accountPanelViewModel;
    }
}
