package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e implements ViewModelProvider.Factory {
    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        StickerRecRepository stickerRecRepository = new StickerRecRepository();
        d dVar = new d(stickerRecRepository);
        stickerRecRepository.m(dVar);
        return dVar;
    }
}
