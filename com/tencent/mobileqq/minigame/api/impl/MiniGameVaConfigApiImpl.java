package com.tencent.mobileqq.minigame.api.impl;

import com.tencent.mobileqq.minigame.api.IMiniGameVaConfigApi;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameVaConfigApiImpl implements IMiniGameVaConfigApi {
    private static final String TAG = "MiniGameVaConfigApiImpl";
    private boolean localDiffPatchEnable = true;

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVaConfigApi
    public String getVASwitchInfo() {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null) {
            return miniGameVAInterceptConfig.getVaSwitchInfo();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVaConfigApi
    public boolean isDiffPatchEnable() {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig == null) {
            return false;
        }
        QLog.i(TAG, 1, "isDiffPatchEnable:" + miniGameVAInterceptConfig.getDiffPatchDownloadEnable() + " localDiffPatchEnable:" + this.localDiffPatchEnable);
        return miniGameVAInterceptConfig.getDiffPatchDownloadEnable() && this.localDiffPatchEnable;
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVaConfigApi
    public void setDiffPatchEnable(boolean z16) {
        this.localDiffPatchEnable = z16;
    }
}
