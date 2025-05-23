package com.tencent.mobileqq.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class l {
    static IPatchRedirector $redirector_;

    public static int a(TroopInfo troopInfo, String str) {
        if (troopInfo == null) {
            return 1;
        }
        String str2 = troopInfo.troopowneruin;
        if (str2 != null && str2.equalsIgnoreCase(str)) {
            return 3;
        }
        String str3 = troopInfo.Administrator;
        if (str3 == null || !str3.contains(str)) {
            return 1;
        }
        return 2;
    }

    public static String b(int i3) {
        if (i3 == 3) {
            return "0";
        }
        if (i3 == 2) {
            return "1";
        }
        if (i3 == 1) {
            return "2";
        }
        return "";
    }

    public static void c(Context context, QQAppInterface qQAppInterface, Intent intent, int i3) {
        AllInOne allInOne;
        if (context != null && qQAppInterface != null && intent != null) {
            String stringExtra = intent.getStringExtra("memberUin");
            String stringExtra2 = intent.getStringExtra("troopUin");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(stringExtra);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "troop_member_card");
            TroopInfo B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(stringExtra2);
            String str = null;
            if (friendsSimpleInfoWithUid != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "troop_member_card")) {
                allInOne = new AllInOne(stringExtra, 20);
                allInOne.nickname = friendsSimpleInfoWithUid.p();
                allInOne.remark = friendsSimpleInfoWithUid.r();
                allInOne.troopCode = stringExtra2;
                if (B != null) {
                    str = B.troopcode;
                }
                allInOne.troopUin = str;
            } else {
                AllInOne allInOne2 = new AllInOne(stringExtra, 21);
                allInOne2.uid = uidFromUin;
                allInOne2.troopCode = stringExtra2;
                if (B != null) {
                    str = B.troopcode;
                }
                allInOne2.troopUin = str;
                allInOne2.subSourceId = i3;
                allInOne = allInOne2;
            }
            allInOne.reportExtra = NewReportPlugin.G(stringExtra2, 1);
            intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
            context.startActivity(intent);
        }
    }

    public static void d(QQAppInterface qQAppInterface, Context context, String str, String str2, int i3, int i16) {
        f(qQAppInterface, context, str, str2, i3, i16, "");
    }

    public static void e(QQAppInterface qQAppInterface, Context context, String str, String str2, int i3, int i16, Bundle bundle) {
        g(qQAppInterface, context, str, str2, i3, i16, "", bundle);
    }

    public static void f(QQAppInterface qQAppInterface, Context context, String str, String str2, int i3, int i16, String str3) {
        if (qQAppInterface == null) {
            return;
        }
        QLog.i("troop_member_card", 1, "[openTroopMemberCard] start");
        if (((ITroopRobotService) qQAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str2)) {
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(context, str, str2);
        } else {
            g(qQAppInterface, context, str, str2, i3, i16, str3, null);
        }
    }

    public static void g(QQAppInterface qQAppInterface, Context context, String str, String str2, int i3, int i16, String str3, Bundle bundle) {
        AllInOne allInOne;
        TroopInfo m3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).m(str, false, false);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(str3, "troop_member_card");
        int i17 = 11;
        String str4 = null;
        if (friendsSimpleInfoWithUid != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(str3, "troop_member_card")) {
            allInOne = new AllInOne(str2, 20);
            allInOne.nickname = friendsSimpleInfoWithUid.p();
            allInOne.remark = friendsSimpleInfoWithUid.r();
            allInOne.troopCode = str;
            if (m3 != null) {
                str4 = m3.troopcode;
            }
            allInOne.troopUin = str4;
        } else {
            allInOne = new AllInOne(str2, 21);
            allInOne.troopCode = str;
            if (m3 != null) {
                str4 = m3.troopcode;
            }
            allInOne.troopUin = str4;
            allInOne.subSourceId = 11;
        }
        if (TextUtils.isEmpty(str3)) {
            allInOne.uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
        } else {
            allInOne.uid = str3;
        }
        allInOne.reportExtra = NewReportPlugin.G(str, 1);
        if (i3 != 0) {
            if (i3 == 1) {
                i17 = 12;
            } else if (i3 == 10) {
                i17 = 17;
            } else {
                i17 = 14;
            }
        }
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 1);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, i17);
        IProfileCardApi iProfileCardApi = (IProfileCardApi) QRoute.api(IProfileCardApi.class);
        if (AppSetting.t(context) && (context instanceof com.tencent.mobileqq.pad.l)) {
            Bundle profileCardBundle = iProfileCardApi.getProfileCardBundle(context, allInOne, new Bundle());
            profileCardBundle.putString("troopUin", str);
            profileCardBundle.putString("memberUin", str2);
            profileCardBundle.putInt("fromFlag", i3);
            com.tencent.mobileqq.pad.i.e(context, profileCardBundle, iProfileCardApi.getProfileCardFragmentClass(), new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.singleTop).a());
            return;
        }
        Intent profileCardIntentOnly = iProfileCardApi.getProfileCardIntentOnly(context, allInOne);
        profileCardIntentOnly.putExtra("troopUin", str);
        profileCardIntentOnly.putExtra("memberUin", str2);
        profileCardIntentOnly.putExtra("fromFlag", i3);
        if (bundle != null) {
            profileCardIntentOnly.putExtras(bundle);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(profileCardIntentOnly, i16);
        } else {
            profileCardIntentOnly.setFlags(268435456);
            context.startActivity(profileCardIntentOnly);
        }
    }
}
