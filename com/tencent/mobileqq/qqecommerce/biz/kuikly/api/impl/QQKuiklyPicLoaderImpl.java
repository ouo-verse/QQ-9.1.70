package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyPicLoader;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyPicLoaderImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyPicLoader;", "()V", "loadImage", "", "option", "Lcom/tencent/libra/request/Option;", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQKuiklyPicLoaderImpl implements IQQKuiklyPicLoader {
    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyPicLoader
    public void loadImage(Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        QQKuiklyPicLoader.f262774a.s(option);
    }
}
