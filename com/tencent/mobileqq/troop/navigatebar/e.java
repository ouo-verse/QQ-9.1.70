package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static void a(TroopAioNavigateBarManager troopAioNavigateBarManager, TroopAioNavMsg troopAioNavMsg) {
        if (troopAioNavMsg == null) {
            QLog.d("NavigateBarOffLineDataUtil", 1, "addOfflineData, data is null");
            return;
        }
        if (troopAioNavigateBarManager == null) {
            QLog.d("NavigateBarOffLineDataUtil", 1, "addOfflineData, troop info manager is null");
            return;
        }
        int b16 = b(troopAioNavMsg.eventType);
        String str = troopAioNavMsg.troopId;
        long j3 = troopAioNavMsg.msgSeq;
        TroopMessageNavigateInfo e16 = troopAioNavigateBarManager.e(str, b16, j3, j3, "", 0, troopAioNavMsg);
        if (e16 != null && e16.type == b16) {
            e16.extObjType = 1;
            e16.extObjJsonStr = TroopAioNavMsg.transToJsonStr(troopAioNavMsg);
        }
    }

    private static int b(int i3) {
        switch (i3) {
            case 1000:
            case 1001:
                return 23;
            case 1002:
                return 22;
            case 1003:
                return 11;
            case 1004:
                return 17;
            case 1005:
                return 26;
            default:
                switch (i3) {
                    case 2000:
                        return 14;
                    case 2001:
                        return 4;
                    case 2002:
                        return 17;
                    case 2003:
                        return 6;
                    case 2004:
                    case 2005:
                        return 102;
                    default:
                        return -1;
                }
        }
    }
}
