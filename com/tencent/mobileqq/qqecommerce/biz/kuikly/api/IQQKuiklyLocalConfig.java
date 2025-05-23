package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyLocalConfig;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "disablePageAsyncLoad", "", "disableTurboDisplay", "enableKuiklyHotReload", "getKuiklyLocalIp", "", "getString", "key", "default", "setString", "", "value", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQKuiklyLocalConfig extends QRouteApi {
    boolean disablePageAsyncLoad();

    boolean disableTurboDisplay();

    boolean enableKuiklyHotReload();

    @NotNull
    String getKuiklyLocalIp();

    @NotNull
    String getString(@NotNull String key, @NotNull String r26);

    void setString(@NotNull String key, @NotNull String value);
}
