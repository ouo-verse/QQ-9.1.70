package com.tencent.mobileqq.vas.config.business.qvip;

import androidx.annotation.Keep;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
@Keep
/* loaded from: classes20.dex */
public class QVipFeatureConfig {
    public boolean enableSplashAnim = true;
    public boolean enableDownloadExtraTabIcon = true;
    public boolean enableShootAnim = true;

    private void setSplashEnable(boolean z16) {
        BaseApplication.getContext().getSharedPreferences(AppConstants.BANNER_AND_SPLASH, 4).edit().putBoolean("splashAnim", z16).commit();
    }

    public void onParsedConfigFinished() {
        setSplashEnable(this.enableSplashAnim);
    }
}
