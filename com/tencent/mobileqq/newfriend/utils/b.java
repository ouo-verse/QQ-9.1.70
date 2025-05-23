package com.tencent.mobileqq.newfriend.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    private static void a(AllInOne allInOne, Intent intent) {
        if (intent != null && intent.hasExtra(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID)) {
            int intExtra = intent.getIntExtra(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 55);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, intExtra);
        } else if (allInOne != null) {
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 54);
        }
    }

    public static void b(AppRuntime appRuntime, Context context, String str) {
        AllInOne allInOne;
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "SystemMessageHelper")) {
            allInOne = new AllInOne(str, 1);
        } else {
            allInOne = new AllInOne(str, 25);
        }
        allInOne.profileEntryType = 109;
        allInOne.uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        a(allInOne, null);
        ProfileUtils.openProfileCard(context, allInOne);
    }

    public static boolean c(AppRuntime appRuntime, Context context, String str, long j3, int i3, int i16, Intent intent) {
        KplRoleInfo.WZRYUIinfo wZRYUIinfo;
        ReportController.o(appRuntime, "CliOper", "", "", "Verify_msg", "Verify_msg_prof", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("SystemMessageHelper", 2, "openProfileCard | sourceId = " + i16);
        }
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "SystemMessageHelper")) {
            AllInOne allInOne = new AllInOne(str, 1);
            allInOne.profileEntryType = 109;
            a(allInOne, intent);
            allInOne.uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            ProfileUtils.openProfileCard(context, allInOne);
        } else {
            if (intent != null && intent.hasExtra(IProfileCardConst.KEY_WZRY_DATA)) {
                wZRYUIinfo = (KplRoleInfo.WZRYUIinfo) intent.getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA);
            } else {
                wZRYUIinfo = null;
            }
            d(context, str, j3, i3, i16, intent, wZRYUIinfo);
        }
        return true;
    }

    private static void d(Context context, String str, long j3, int i3, int i16, Intent intent, KplRoleInfo.WZRYUIinfo wZRYUIinfo) {
        if (i3 != -1011 && i3 != -1006 && i3 != 1) {
            if (i3 != 7) {
                if (i3 != 187) {
                    AllInOne allInOne = new AllInOne(str, 25);
                    allInOne.profileEntryType = 109;
                    allInOne.chatAbility = 1;
                    if (i3 == 6) {
                        allInOne.chatAbility = 0;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("sysInfoExtres", intent);
                    if (wZRYUIinfo != null) {
                        allInOne.extras.putSerializable(IProfileCardConst.KEY_WZRY_DATA, wZRYUIinfo);
                    }
                    allInOne.uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                    a(allInOne, intent);
                    h(context, allInOne, bundle);
                    return;
                }
            } else {
                g(context, str, j3, i16, intent);
                return;
            }
        }
        f(context, str, j3, i16, intent, wZRYUIinfo);
    }

    public static void e(Context context, String str) {
        AllInOne allInOne = new AllInOne(str, 1);
        Bundle bundle = new Bundle();
        bundle.putBoolean(AppConstants.Key.KEY_NEED_TRACK_BACK, true);
        h(context, allInOne, bundle);
    }

    private static void f(Context context, String str, long j3, int i3, Intent intent, KplRoleInfo.WZRYUIinfo wZRYUIinfo) {
        AllInOne allInOne = new AllInOne(str, 28);
        allInOne.profileEntryType = 109;
        allInOne.sourceID = i3;
        allInOne.troopUin = String.valueOf(j3);
        Bundle bundle = new Bundle();
        bundle.putParcelable("sysInfoExtres", intent);
        if (wZRYUIinfo != null) {
            allInOne.extras.putSerializable(IProfileCardConst.KEY_WZRY_DATA, wZRYUIinfo);
        }
        allInOne.uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        a(allInOne, intent);
        h(context, allInOne, bundle);
    }

    private static void g(Context context, String str, long j3, int i3, Intent intent) {
        AllInOne allInOne = new AllInOne(str, 25);
        allInOne.profileEntryType = 109;
        allInOne.sourceID = i3;
        allInOne.troopUin = String.valueOf(j3);
        allInOne.chatAbility = 1;
        allInOne.uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("sysInfoExtres", intent);
        a(allInOne, intent);
        h(context, allInOne, bundle);
    }

    public static void h(Context context, AllInOne allInOne, Bundle bundle) {
        if (context != null) {
            try {
                Intent intent = ProfileUtils.getIntent(context, allInOne);
                if (bundle != null && bundle.getBoolean("single_top", false)) {
                    intent.addFlags(67108864);
                } else {
                    intent.addFlags(536870912);
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                if (bundle != null && bundle.getBoolean(AppConstants.Key.KEY_NEED_TRACK_BACK, false)) {
                    intent.putExtra(AppConstants.Key.KEY_NEED_TRACK_BACK, true);
                }
                if (bundle != null) {
                    intent.putExtra(IProfileCardConst.KEY_PROFILE_EXTRA, bundle);
                }
                context.startActivity(intent);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("SystemMessageHelper", 2, e16.toString());
                }
            }
        }
    }
}
