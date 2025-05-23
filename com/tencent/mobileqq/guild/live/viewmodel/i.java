package com.tencent.mobileqq.guild.live.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i {
    public static ViewModelProvider a(@NonNull ViewModelStoreOwner viewModelStoreOwner) {
        return new ViewModelProvider(viewModelStoreOwner, ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplication.getContext()));
    }
}
