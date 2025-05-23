package com.qwallet.temp.impl;

import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.ark.api.notify.GdtNotify;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends GdtNotify {

    /* renamed from: f, reason: collision with root package name */
    private final IQWalletTemp.a f41770f;

    public b(IQWalletTemp.a aVar) {
        this.f41770f = aVar;
    }

    @Override // com.tencent.mobileqq.ark.api.notify.GdtNotify, com.tencent.mobileqq.ark.module.g
    public boolean notify(String str, String str2, String str3) {
        return this.f41770f.notify(str, str2, str3) || super.notify(str, str2, str3);
    }
}
