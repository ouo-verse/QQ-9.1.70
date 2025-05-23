package com.tencent.guild.api.appsetting.impl;

import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/api/appsetting/impl/AppSettingImpl;", "Lcom/tencent/guild/api/appsetting/IAppSetting;", "()V", "appSetting", "Lcom/tencent/mobileqq/config/api/IAppSettingApi;", "getAppSetting", "()Lcom/tencent/mobileqq/config/api/IAppSettingApi;", "debug", "", "gray", "public", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class AppSettingImpl implements IAppSetting {
    private final IAppSettingApi getAppSetting() {
        QRouteApi api = QRoute.api(IAppSettingApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAppSettingApi::class.java)");
        return (IAppSettingApi) api;
    }

    @Override // com.tencent.guild.api.appsetting.IAppSetting
    public boolean debug() {
        return getAppSetting().isDebugVersion();
    }

    @Override // com.tencent.guild.api.appsetting.IAppSetting
    public boolean gray() {
        return getAppSetting().isGrayVersion();
    }

    @Override // com.tencent.guild.api.appsetting.IAppSetting
    /* renamed from: public */
    public boolean mo112public() {
        return getAppSetting().isPublicVersion();
    }
}
