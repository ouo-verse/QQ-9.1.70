package com.tencent.mobileqq.qqecommerce.biz.nv.api.impl;

import cg2.a;
import com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModel;
import com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModelFactory;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/impl/NVViewModelFactoryImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModelFactory;", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel;", "environmentEnsureByUser", "", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class NVViewModelFactoryImpl implements INVViewModelFactory {
    @Override // com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModelFactory
    public INVViewModel create(boolean environmentEnsureByUser) {
        return new a(environmentEnsureByUser);
    }
}
