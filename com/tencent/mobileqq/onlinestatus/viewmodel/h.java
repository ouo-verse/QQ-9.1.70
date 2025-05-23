package com.tencent.mobileqq.onlinestatus.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.onlinestatus.repository.k;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h implements ViewModelProvider.Factory {
    @Override // androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        if (!cls.isAssignableFrom(g.class)) {
            return null;
        }
        return cls.cast(new g(new k()));
    }
}
