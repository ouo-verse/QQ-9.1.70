package com.tencent.mobileqq.wxsetting.api.impl;

import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.a;
import com.tencent.mobileqq.wxsetting.api.IWxMiniSettingProvider;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import ob3.i;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wxsetting/api/impl/WxMiniSettingProviderImpl;", "Lcom/tencent/mobileqq/wxsetting/api/IWxMiniSettingProvider;", "()V", "getWxMiniSettingConfig", "Lcom/tencent/mobileqq/widget/listitem/Group;", "registerWxMiniGroupLifecycle", "", VipFunCallConstants.KEY_GROUP, "lifecycle", "Landroidx/lifecycle/Lifecycle;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class WxMiniSettingProviderImpl implements IWxMiniSettingProvider {
    @Override // com.tencent.mobileqq.wxsetting.api.IWxMiniSettingProvider
    public Group getWxMiniSettingConfig() {
        String string = MobileQQ.sMobileQQ.getString(R.string.xzn);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.st\u2026x_mini_use_binding_title)");
        return new Group(string, new i());
    }

    @Override // com.tencent.mobileqq.wxsetting.api.IWxMiniSettingProvider
    public void registerWxMiniGroupLifecycle(Group group, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Iterator<a<?>> it = group.a().iterator();
        while (it.hasNext()) {
            a<?> next = it.next();
            if (next instanceof i) {
                ((i) next).J(lifecycle);
            }
        }
    }
}
