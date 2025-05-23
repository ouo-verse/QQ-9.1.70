package com.tencent.mobileqq.qwallet.hb;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IHbThemeConfigApi extends QRouteApi {
    String getConfigCache();

    void handleQWalletSettingConfig(ConfigurationService$Config configurationService$Config);

    void setConfigCache(String str);
}
