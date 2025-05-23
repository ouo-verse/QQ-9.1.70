package com.tencent.mobileqq.vas.qid;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VipQidHelper {
    public static final String FROM_CARD = "&from=icon";
    public static final String FROM_SET = "&from=set";
    public static String TAG = "VipQidHelper";

    public static boolean isQIdVisible() {
        return QVipQidProcessor.get().isEnableQid();
    }

    public static boolean isQidOpen(AppInterface appInterface) {
        if (appInterface == null) {
            return false;
        }
        return VasMMKV.getCommon().decodeBool(QVipConfigManager.KEY_BOOLEAN_QID_KEYWORD_OPEN, false);
    }

    public static void jumpQidSetInfoPage(Activity activity, ProfileCardInfo profileCardInfo) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(QVipQidProcessor.get().getHomePageUrl());
        if (profileCardInfo != null) {
            str = FROM_CARD;
        } else {
            str = FROM_SET;
        }
        sb5.append(str);
        String buildTraceDetailUrl = ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(sb5.toString(), IVipTraceDetailReport.FROM.PROFIEDCARD_QID);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "jumpQidSetInfoPage url:" + buildTraceDetailUrl);
        }
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(activity, buildTraceDetailUrl);
        } else {
            Intent qQBrowserIntent = VasUtil.getTempApi().getQQBrowserIntent();
            qQBrowserIntent.putExtra("uin", VasUtil.getCurrentUin());
            qQBrowserIntent.putExtra("url", buildTraceDetailUrl);
            qQBrowserIntent.putExtra("hide_more_button", true);
            qQBrowserIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            if (activity != null) {
                activity.startActivity(qQBrowserIntent);
            }
        }
        reportQIdEvent("0X800B60D", profileCardInfo);
    }

    public static void reportQIdEvent(String str, ProfileCardInfo profileCardInfo) {
        if (profileCardInfo == null || profileCardInfo.allInOne == null || profileCardInfo.card == null) {
            return;
        }
        AppRuntime app = VasUtil.getApp();
        int i3 = TextUtils.isEmpty(profileCardInfo.allInOne.troopUin) ? 1 : 2;
        int i16 = profileCardInfo.allInOne.uin.equals(app.getCurrentAccountUin()) ? 1 : 2;
        boolean isVipOpen = profileCardInfo.card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
        ReportController.o(app, "dc00898", "", "", "", str, i3, 0, String.valueOf(i16), String.valueOf(isVipOpen ? 1 : 0), "", "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QID_LOG,reportQIdEvent,fromType:" + i3 + " isOwner:" + i16 + " openVip:" + (isVipOpen ? 1 : 0));
        }
    }

    public static void setQidOpen(AppInterface appInterface, boolean z16) {
        if (appInterface == null) {
            return;
        }
        VasMMKV.getCommon().encodeBool(QVipConfigManager.KEY_BOOLEAN_QID_KEYWORD_OPEN, z16);
    }

    public static void reportQIdEvent(String str, int i3) {
        ReportController.o(VasUtil.getApp(), "dc00898", "", "", "", str, 0, 0, String.valueOf(i3), "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QID_LOG,reportQIdEvent,entry:" + i3);
        }
    }
}
