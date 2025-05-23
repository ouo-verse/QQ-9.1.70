package com.tencent.mobileqq.qwallet.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import qk2.PrivatePolicyConfig;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    public static boolean a(QBaseActivity qBaseActivity, AppRuntime appRuntime, int i3) {
        boolean z16;
        if (appRuntime != null && qBaseActivity != null) {
            boolean z17 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getBoolean(appRuntime.getCurrentUin(), QWalletPreferenceApiImpl.KEY_PRIVACY_HAS_CLICK_AGREE, false);
            if (QLog.isColorLevel()) {
                QLog.i("QWalletPrivacyUtils", 2, "hasClickAgree" + z17);
            }
            if (z17) {
                return false;
            }
            PrivatePolicyConfig privatePolicyConfig = (PrivatePolicyConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig("qwallet_private_policy_config", new PrivatePolicyConfig());
            if (privatePolicyConfig.getSwitch() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String title = privatePolicyConfig.getTitle();
                String content = privatePolicyConfig.getContent();
                if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(content)) {
                    c(qBaseActivity, title, content, "https://i.gtimg.cn/channel/imglib/201802/upload_895b44a9069ca68cb5c84439c7e1d2aa.jpg", i3);
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(AppRuntime appRuntime) {
        if (appRuntime != null) {
            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putBoolean(appRuntime.getAccount(), QWalletPreferenceApiImpl.KEY_PRIVACY_HAS_CLICK_AGREE, true);
        }
    }

    private static void c(QBaseActivity qBaseActivity, String str, String str2, String str3, int i3) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("title", str);
        intent.putExtra("content", str2);
        intent.putExtra("background", str3);
        intent.putExtra(WadlProxyConsts.CHANNEL, i3);
        QPublicFragmentActivity.b.b(qBaseActivity, intent, QPublicTransFragmentActivity.class, QWalletPrivacyFragment.class);
    }
}
