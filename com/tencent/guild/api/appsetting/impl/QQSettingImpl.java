package com.tencent.guild.api.appsetting.impl;

import com.tencent.guild.api.appsetting.IQQSetting;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/api/appsetting/impl/QQSettingImpl;", "Lcom/tencent/guild/api/appsetting/IQQSetting;", "()V", "isEnterSendMsg", "", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class QQSettingImpl implements IQQSetting {
    @Override // com.tencent.guild.api.appsetting.IQQSetting
    public boolean isEnterSendMsg() {
        return ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).isEnterSendMsg();
    }
}
