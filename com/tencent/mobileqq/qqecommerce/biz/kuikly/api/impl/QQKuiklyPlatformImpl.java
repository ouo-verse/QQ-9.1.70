package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyPlatform;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyPlatformImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyPlatform;", "()V", "tabBarHeight", "", "getTabBarHeight", "updateTabBarHeight", "", "height", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQKuiklyPlatformImpl implements IQQKuiklyPlatform {
    private volatile int tabBarHeight;

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyPlatform
    public int getTabBarHeight() {
        return this.tabBarHeight;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyPlatform
    public void updateTabBarHeight(int height) {
        this.tabBarHeight = height;
    }
}
