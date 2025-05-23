package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl;

import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IBaseHttpAdapterFactory;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.BaseHttpAdapter;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/BaseHttpAdapterFactoryImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/IBaseHttpAdapterFactory;", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/hippy/qq/api/IBaseHttpAdapter;", "enableHttp2", "", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class BaseHttpAdapterFactoryImpl implements IBaseHttpAdapterFactory {
    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.IBaseHttpAdapterFactory
    public IBaseHttpAdapter create(boolean enableHttp2) {
        return new BaseHttpAdapter(enableHttp2);
    }
}
