package com.tencent.mobileqq.upgrade.manager;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import org.jetbrains.annotations.NotNull;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static boolean a(UpgradeInfo upgradeInfo) {
        if (upgradeInfo == null || TextUtils.isEmpty(upgradeInfo.strNewSoftwareMD5) || TextUtils.isEmpty(upgradeInfo.strNewSoftwareURL) || upgradeInfo.iUpgradeSdkId == 0) {
            return false;
        }
        return true;
    }

    private static boolean b(UpgradeInfo upgradeInfo) {
        if (upgradeInfo == null || TextUtils.isEmpty(upgradeInfo.strNewSoftwareMD564) || TextUtils.isEmpty(upgradeInfo.strNewSoftwareURL64) || upgradeInfo.iUpgradeSdkId64 == 0) {
            return false;
        }
        return true;
    }

    public static void c(UpgradeInfo upgradeInfo) {
        String str;
        if (upgradeInfo == null) {
            QLog.d("UpgradeController_Config", 1, "[afterParse] mTempUpgradeInfo is null.");
            return;
        }
        upgradeInfo.iAppid = AppSetting.f();
        boolean e16 = e();
        boolean a16 = a(upgradeInfo);
        boolean b16 = b(upgradeInfo);
        if (!a16 && !b16) {
            QLog.d("UpgradeController_Config", 1, "[afterParse] has no any config.");
            upgradeInfo.isValid = false;
            return;
        }
        if (b16 && !a16) {
            if (!e16) {
                QLog.d("UpgradeController_Config", 1, "[afterParse] 32 arch, but no 32 config.");
                upgradeInfo.isValid = false;
                return;
            } else if (!d(upgradeInfo)) {
                QLog.d("UpgradeController_Config", 1, "[afterParse] copy failed.");
            }
        } else if (b16) {
            QLog.d("UpgradeController_Config", 1, "[afterParse] both 32 and 64.");
            if (e16) {
                d(upgradeInfo);
            }
        } else {
            QLog.d("UpgradeController_Config", 1, "[afterParse] has 32 no 64.");
        }
        String str2 = upgradeInfo.strUpgradePageUrl;
        if (upgradeInfo.is64) {
            str = ResourceAttributes.HostArchValues.ARM64;
        } else {
            str = ResourceAttributes.HostArchValues.ARM32;
        }
        String addParameter = URLUtil.addParameter(str2, "arch", str);
        upgradeInfo.strUrl = addParameter;
        upgradeInfo.strUpgradePageUrl = addParameter;
        upgradeInfo.strNewUpgradeDescURL = addParameter;
        QLog.d("UpgradeController_Config", 1, "[afterParse] choose 64:", Boolean.valueOf(upgradeInfo.is64), ", new upgrade url: ", addParameter);
    }

    private static boolean d(@NotNull UpgradeInfo upgradeInfo) {
        if (!b(upgradeInfo)) {
            QLog.d("UpgradeController_Config", 1, "[set64ConfigAsDefault] error: no 64 config.");
            return false;
        }
        QLog.d("UpgradeController_Config", 1, "[set64ConfigAsDefault] before copy: sdkId: ", Integer.valueOf(upgradeInfo.iUpgradeSdkId), ". url: ", upgradeInfo.strNewSoftwareURL, ". md5: ", upgradeInfo.strNewSoftwareMD5, ". progress: ", upgradeInfo.strProgressName);
        upgradeInfo.iUpgradeSdkId = upgradeInfo.iUpgradeSdkId64;
        upgradeInfo.strNewSoftwareURL = upgradeInfo.strNewSoftwareURL64;
        upgradeInfo.strNewSoftwareMD5 = upgradeInfo.strNewSoftwareMD564;
        upgradeInfo.strProgressName = upgradeInfo.strProgressName64;
        upgradeInfo.is64 = true;
        return true;
    }

    private static boolean e() {
        for (String str : Build.SUPPORTED_ABIS) {
            if ("arm64-v8a".equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
