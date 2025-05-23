package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyLocalConfigImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyLocalConfig;", "", "key", "default", "getString", "value", "", "setString", "getKuiklyLocalIp", "", "enableKuiklyHotReload", "disableTurboDisplay", "disablePageAsyncLoad", "Loe2/a;", DownloadInfo.spKey_Config, "Loe2/a;", "getConfig", "()Loe2/a;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyLocalConfigImpl implements IQQKuiklyLocalConfig {
    private final oe2.a config = new oe2.a();

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig
    public boolean disablePageAsyncLoad() {
        return Intrinsics.areEqual(getString("disable_page_async_load", "0"), "1");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig
    public boolean disableTurboDisplay() {
        return Intrinsics.areEqual(getString("disable_turbo_display", "0"), "1");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig
    public boolean enableKuiklyHotReload() {
        return Intrinsics.areEqual(getString("enable_hot_reload", "0"), "1");
    }

    public final oe2.a getConfig() {
        return this.config;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig
    public String getKuiklyLocalIp() {
        return getString("local_host", "");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig
    public String getString(String key, String r95) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r95, "default");
        return IECLocalConfig.a.f(this.config, key, r95, null, 4, null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyLocalConfig
    public void setString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        IECLocalConfig.a.j(this.config, key, value, null, 4, null);
    }
}
