package com.tencent.mobileqq.troopmanage.base;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickUIInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troopmanage.TroopManageFragment;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import com.tencent.mobileqq.troopmanage.multigroup.TroopManageTabFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static List<TroopMemberNickUIInfo> b(List<TroopMemberInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (TroopMemberInfo troopMemberInfo : list) {
            if (troopMemberInfo.role == MemberRole.ADMIN) {
                arrayList.add(troopMemberInfo.nickInfo.getUIInfo());
            }
        }
        f(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("TroopManageHelper", 2, "getTroopAdmins: resultsize=" + arrayList.size());
        }
        return arrayList;
    }

    public static Class<? extends QPublicBaseFragment> c() {
        return TroopManageFragment.class;
    }

    public static Class<? extends QPublicBaseFragment> d(boolean z16) {
        if (z16) {
            return TroopManageTabFragment.class;
        }
        return c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(String str, ITroopRobotService iTroopRobotService, TroopMemberNickUIInfo troopMemberNickUIInfo, TroopMemberNickUIInfo troopMemberNickUIInfo2) {
        try {
            if (str.equals(troopMemberNickUIInfo.getUin())) {
                return -1;
            }
            if (str.equals(troopMemberNickUIInfo2.getUin())) {
                return 1;
            }
            if (iTroopRobotService.isRobotUin(troopMemberNickUIInfo.getUin()) && !iTroopRobotService.isRobotUin(troopMemberNickUIInfo2.getUin())) {
                return 1;
            }
            if (!iTroopRobotService.isRobotUin(troopMemberNickUIInfo.getUin()) && iTroopRobotService.isRobotUin(troopMemberNickUIInfo2.getUin())) {
                return -1;
            }
            return Long.compare(Long.parseLong(troopMemberNickUIInfo.getUin()), Long.parseLong(troopMemberNickUIInfo2.getUin()));
        } catch (Exception e16) {
            QLog.e("TroopManageHelper", 1, "[sortAdminNickInfo] exception = " + e16);
            return 0;
        }
    }

    public static void f(List<TroopMemberNickUIInfo> list) {
        if (list != null && !list.isEmpty()) {
            final ITroopRobotService iTroopRobotService = (ITroopRobotService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopRobotService.class, "all");
            final String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
            Collections.sort(list, new Comparator() { // from class: com.tencent.mobileqq.troopmanage.base.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int e16;
                    e16 = b.e(currentUin, iTroopRobotService, (TroopMemberNickUIInfo) obj, (TroopMemberNickUIInfo) obj2);
                    return e16;
                }
            });
        }
    }

    public static void g(ITroopManageService iTroopManageService, TroopInfo troopInfo, String str, String str2, byte b16) {
        if (troopInfo == null) {
            return;
        }
        String str3 = troopInfo.Administrator;
        if (str3 != null) {
            if (str3.startsWith("|")) {
                troopInfo.Administrator = troopInfo.Administrator.substring(1);
            }
            if (troopInfo.Administrator.endsWith("|")) {
                String str4 = troopInfo.Administrator;
                troopInfo.Administrator = str4.substring(0, str4.length() - 1);
            }
        } else {
            troopInfo.Administrator = "";
        }
        if (b16 != 0 && b16 != 2) {
            if (b16 == 1) {
                iTroopManageService.reportClickEvent("CliOper", "", "", "Grp", "Grant_cancel_admin", 0, 0, str2, "0", "", "");
                if (!troopInfo.Administrator.contains(str)) {
                    troopInfo.Administrator += "|" + str;
                }
            }
        } else {
            iTroopManageService.reportClickEvent("CliOper", "", "", "Grp", "Grant_cancel_admin", 0, 0, str2, "1", "", "");
            troopInfo.Administrator = troopInfo.Administrator.replace(str + "|", "").replace("|" + str, "").replace(str, "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopManageHelper", 2, "updateTroopAdmins2DB:" + troopInfo.Administrator);
        }
    }
}
