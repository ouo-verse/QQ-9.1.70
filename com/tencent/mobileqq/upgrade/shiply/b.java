package com.tencent.mobileqq.upgrade.shiply;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upgrade.bean.ApkBasicInfo;
import com.tencent.upgrade.bean.ClientInfo;
import com.tencent.upgrade.bean.UpgradeStrategy;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a(@NonNull UpgradeDetailWrapper upgradeDetailWrapper, @NonNull UpgradeStrategy upgradeStrategy) {
        Map<String, String> extra = upgradeStrategy.getExtra();
        ClientInfo clientInfo = upgradeStrategy.getClientInfo();
        ApkBasicInfo apkBasicInfo = upgradeStrategy.getApkBasicInfo();
        if (extra != null && extra.size() != 0) {
            if (clientInfo != null && apkBasicInfo != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ShiplyUpgradeManager", 2, "parseShiplyUpgradeStrategyDetail upgradeStrategy info:" + upgradeStrategy);
                }
                if (extra.containsKey("taskName")) {
                    upgradeDetailWrapper.f306174i.dialog.f306150b = b(extra, "taskName", "");
                }
                upgradeDetailWrapper.f306174i.dialog.f306151c = com.tencent.mobileqq.olympic.utils.a.b(b(extra, "taskTime", ""));
                upgradeDetailWrapper.f306174i.dialog.f306152d = com.tencent.mobileqq.olympic.utils.a.b(b(extra, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, ""));
                upgradeDetailWrapper.f306174i.dialog.f306153e = clientInfo.getTitle();
                upgradeDetailWrapper.f306171e.strTitle = upgradeDetailWrapper.f306174i.dialog.f306153e;
                upgradeDetailWrapper.f306174i.dialog.f306154f = b(extra, "strNewTitle", "");
                upgradeDetailWrapper.f306171e.strNewTitle = upgradeDetailWrapper.f306174i.dialog.f306154f;
                upgradeDetailWrapper.f306174i.dialog.f306155g = clientInfo.getDescription();
                upgradeDetailWrapper.f306171e.strUpgradeDesc = upgradeDetailWrapper.f306174i.dialog.f306155g;
                upgradeDetailWrapper.f306174i.dialog.f306156h = b(extra, "desc", "");
                upgradeDetailWrapper.f306174i.dialog.f306157i = b(extra, "installFail", "");
                if (extra.containsKey("info")) {
                    upgradeDetailWrapper.f306174i.dialog.f306158j = b(extra, "info", "");
                }
                if (extra.containsKey("yellowBar")) {
                    upgradeDetailWrapper.f306174i.dialog.f306159k = Integer.valueOf(b(extra, "yellowBar", "")).intValue();
                }
                upgradeDetailWrapper.f306174i.dialog.f306160l = b(extra, "barContent", "");
                upgradeDetailWrapper.f306174i.dialog.f306161m = b(extra, "barContent2", "");
                upgradeDetailWrapper.f306174i.dialog.f306162n = b(extra, "lBtnText", "");
                upgradeDetailWrapper.f306174i.dialog.f306163o = b(extra, "rBtnText", "");
                if (extra.containsKey("downloadDialogMaxTimes")) {
                    upgradeDetailWrapper.f306174i.dialog.f306165q = Integer.valueOf(b(extra, "downloadDialogMaxTimes", "")).intValue();
                }
                if (extra.containsKey("downloadDialogDayRate")) {
                    upgradeDetailWrapper.f306174i.dialog.f306166r = Integer.valueOf(b(extra, "downloadDialogDayRate", "")).intValue();
                }
                if (extra.containsKey("installDialogMaxTimes")) {
                    upgradeDetailWrapper.f306174i.dialog.f306167s = Integer.valueOf(b(extra, "installDialogMaxTimes", "")).intValue();
                }
                if (extra.containsKey("installDialogDayRate")) {
                    upgradeDetailWrapper.f306174i.dialog.f306168t = Integer.valueOf(b(extra, "installDialogDayRate", "")).intValue();
                }
                if (extra.containsKey("needPreDownloadYYB")) {
                    upgradeDetailWrapper.f306174i.dialog.f306164p = b(extra, "needPreDownloadYYB", "").equals("1");
                }
                if (extra.containsKey("status")) {
                    String b16 = b(extra, "status", "");
                    if ("on".equalsIgnoreCase(b16)) {
                        upgradeDetailWrapper.C = 1;
                    } else if (DebugKt.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(b16)) {
                        upgradeDetailWrapper.C = 2;
                    }
                }
                if (extra.containsKey("jumpMarketSupportPhone")) {
                    upgradeDetailWrapper.E = b(extra, "jumpMarketSupportPhone", "");
                }
                if (extra.containsKey("iUpgradeSdkId")) {
                    upgradeDetailWrapper.f306171e.iUpgradeSdkId = Integer.valueOf(b(extra, "iUpgradeSdkId", "")).intValue();
                }
                if (extra.containsKey("iUpgradeType")) {
                    upgradeDetailWrapper.f306171e.iUpgradeType = Integer.valueOf(b(extra, "iUpgradeType", "")).intValue();
                }
                upgradeDetailWrapper.f306171e.strUrl = b(extra, "iDownloadPageUrl", "");
                UpgradeInfo upgradeInfo = upgradeDetailWrapper.f306171e;
                String str = upgradeInfo.strUrl;
                upgradeInfo.strUpgradePageUrl = str;
                upgradeInfo.strNewUpgradeDescURL = str;
                if (extra.containsKey("iActionType")) {
                    upgradeDetailWrapper.f306171e.iActionType = Integer.valueOf(b(extra, "iActionType", "")).intValue();
                }
                if (extra.containsKey("bNewSwitch")) {
                    upgradeDetailWrapper.f306171e.bNewSwitch = Byte.valueOf(b(extra, "bNewSwitch", "")).byteValue();
                }
                if (extra.containsKey("iIncrementUpgrade")) {
                    upgradeDetailWrapper.f306171e.iIncrementUpgrade = Integer.valueOf(b(extra, "iIncrementUpgrade", "")).intValue();
                }
                if (extra.containsKey("iTipsType")) {
                    upgradeDetailWrapper.f306171e.iTipsType = Integer.valueOf(b(extra, "iTipsType", "")).intValue();
                }
                if (extra.containsKey("strProgressName")) {
                    upgradeDetailWrapper.f306171e.strProgressName = b(extra, "strProgressName", "");
                }
                if (extra.containsKey("strNewSoftwareURL")) {
                    upgradeDetailWrapper.f306171e.strNewSoftwareURL = b(extra, "strNewSoftwareURL", "");
                }
                if (extra.containsKey("strNewSoftwareMD5")) {
                    upgradeDetailWrapper.f306171e.strNewSoftwareMD5 = b(extra, "strNewSoftwareMD5", "");
                }
                if (extra.containsKey("bGray")) {
                    upgradeDetailWrapper.f306171e.bGray = Byte.valueOf(b(extra, "bGray", "")).byteValue();
                }
                upgradeDetailWrapper.f306171e.strButtonDesc = b(extra, "strButtonDesc", "");
                upgradeDetailWrapper.f306171e.strCancelButtonDesc = b(extra, "strCancelButtonDescNew", "");
                if (extra.containsKey("iNewTimeStamp")) {
                    upgradeDetailWrapper.f306171e.iNewTimeStamp = Integer.valueOf(b(extra, "iNewTimeStamp", "")).intValue();
                }
                upgradeDetailWrapper.f306171e.strNewTipsDescURL = b(extra, "strNewTipsDescURL", "");
                if (extra.containsKey("iUpgradeSdkId64")) {
                    upgradeDetailWrapper.f306171e.iUpgradeSdkId64 = Integer.parseInt(b(extra, "iUpgradeSdkId64", ""));
                }
                upgradeDetailWrapper.f306171e.strProgressName64 = b(extra, "strProgressName64", "");
                upgradeDetailWrapper.f306171e.strNewSoftwareURL64 = b(extra, "strNewSoftwareURL64", "");
                upgradeDetailWrapper.f306171e.strNewSoftwareMD564 = b(extra, "strNewSoftwareMD564", "");
                return true;
            }
            QLog.e("ShiplyUpgradeManager", 1, "parseShiplyUpgradeStrategyDetail clientInfo or apkBasicInfo is null");
            return false;
        }
        QLog.e("ShiplyUpgradeManager", 1, "parseShiplyUpgradeStrategyDetail userMap is empty");
        return false;
    }

    @Nullable
    private static String b(@NonNull Map<String, String> map, @NonNull String str, @Nullable String str2) {
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return str2;
    }
}
