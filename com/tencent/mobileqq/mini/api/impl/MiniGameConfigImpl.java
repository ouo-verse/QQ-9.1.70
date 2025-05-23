package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.api.IMiniGameConfig;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGameConfigProcessor;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/mini/api/impl/MiniGameConfigImpl;", "Lcom/tencent/mobileqq/mini/api/IMiniGameConfig;", "()V", "getScreenRecordEnabled", "", "isMiniGamePackageExceptionSwitchEnable", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameConfigImpl implements IMiniGameConfig {
    private static final String TAG = "MiniGameFeatureToggleIm";

    @Override // com.tencent.mobileqq.mini.api.IMiniGameConfig
    public boolean getScreenRecordEnabled() {
        return MiniGameConfigProcessor.INSTANCE.loadConfig().getScreenRecordEnabled();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniGameConfig
    public boolean isMiniGamePackageExceptionSwitchEnable() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("minigame_excepton_toggle", false);
        QLog.i(TAG, 1, "[isMiniGamePackageExceptionSwitchEnable]:" + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }
}
