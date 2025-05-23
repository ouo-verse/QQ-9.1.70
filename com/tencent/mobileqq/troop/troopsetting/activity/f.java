package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;
import java.util.ArrayList;
import wh2.eq;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static void b(AppInterface appInterface, final String str) {
        ArrayList<Long> arrayList = new ArrayList<>(1);
        arrayList.add(Long.valueOf(Long.parseLong(str)));
        ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).upgradeGroupFeed(arrayList, 1, new eq() { // from class: com.tencent.mobileqq.troop.troopsetting.activity.e
            @Override // wh2.eq
            public final void onUpgradeGroupCallback(int i3, String str2, ArrayList arrayList2) {
                f.d(str, i3, str2, arrayList2);
            }
        });
    }

    public static boolean c(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean("open_from_aio", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(String str, int i3, String str2, ArrayList arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopSettingUIUtils", 2, str + "now upgrade | result = " + i3 + " errMsg = " + str2);
        }
    }

    public static void e(View view) {
        VideoReport.setElementId(view, "em_group_forum_upgrade");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    public static boolean f(AppInterface appInterface, TroopInfoData troopInfoData) {
        if (troopInfoData == null) {
            return false;
        }
        ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class);
        String str = troopInfoData.troopUin;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return iTroopUpgradeUtilsApi.shouldShowTroopUpgradeSetting(appInterface, str);
    }

    public static boolean g(String str) {
        if (str == null) {
            return false;
        }
        return !((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).hasTouchRedDotOfTroopUpgrade(str);
    }
}
