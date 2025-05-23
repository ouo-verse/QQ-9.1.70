package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.impl;

import a61.b;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecMvvmCreator;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.a;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.c;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.d;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.e;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.h;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StickerRecMvvmCreatorImpl implements IStickerRecMvvmCreator {
    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecMvvmCreator
    public a createViewBinder(AppInterface appInterface, QBaseActivity qBaseActivity, b bVar, com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.b bVar2) {
        return new c(appInterface, qBaseActivity, bVar, bVar2);
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecMvvmCreator
    public com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.b createViewModel(ViewModelStoreOwner viewModelStoreOwner) {
        return (com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.b) h.b(viewModelStoreOwner, new e()).get(d.class);
    }
}
