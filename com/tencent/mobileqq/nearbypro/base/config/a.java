package com.tencent.mobileqq.nearbypro.base.config;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00060\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/config/a;", "Lcom/tencent/mobileqq/nearbypro/base/a;", "", "debug", "public", "gray", "", "b", "getVersion", "kotlin.jvm.PlatformType", "a", "toString", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a implements com.tencent.mobileqq.nearbypro.base.a {
    @Override // com.tencent.mobileqq.nearbypro.base.a
    public String a() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion();
    }

    @Override // com.tencent.mobileqq.nearbypro.base.a
    @Nullable
    public String b() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName();
    }

    @Override // com.tencent.mobileqq.nearbypro.base.a
    public boolean debug() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion();
    }

    @Override // com.tencent.mobileqq.nearbypro.base.a
    @Nullable
    public String getVersion() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getVersion();
    }

    @Override // com.tencent.mobileqq.nearbypro.base.a
    public boolean gray() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isGrayVersion();
    }

    @Override // com.tencent.mobileqq.nearbypro.base.a
    /* renamed from: public */
    public boolean mo208public() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion();
    }

    @NotNull
    public String toString() {
        return "debug=" + debug() + ", public=" + mo208public() + ", gray=" + gray() + ", reportVersion=" + b() + ", version=" + getVersion() + ", subVersion=" + a();
    }
}
