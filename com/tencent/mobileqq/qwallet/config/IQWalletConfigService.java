package com.tencent.mobileqq.qwallet.config;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes16.dex */
public interface IQWalletConfigService extends IRuntimeService {
    void handleQWalletSettingCofig(ConfigurationService$Config configurationService$Config);

    void tryGetConfig(int i3);

    void tryRequestAllConfig();
}
