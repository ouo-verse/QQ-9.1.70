package com.tencent.av.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;

/* compiled from: P */
/* loaded from: classes3.dex */
public class az {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        int a(String str, String str2);
    }

    public static int a(AppInterface appInterface, String str, String str2) {
        if (appInterface instanceof QQAppInterface) {
            return c((QQAppInterface) appInterface, str, str2);
        }
        return b(appInterface, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int b(AppInterface appInterface, String str, String str2) {
        if (appInterface instanceof a) {
            return ((a) appInterface).a(str, str2);
        }
        return -1;
    }

    private static int c(QQAppInterface qQAppInterface, String str, String str2) {
        TroopManager troopManager;
        if (qQAppInterface != null && (troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) != null) {
            if (((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str2, str, null, "TroopMemberUtil") == null) {
                return 3;
            }
            TroopInfo k3 = troopManager.k(str2);
            if (k3 != null && k3.isTroopOwner(str)) {
                return 0;
            }
            if (k3 != null && k3.isTroopAdmin(str)) {
                return 1;
            }
            if (k3 != null) {
                return 2;
            }
        }
        return -1;
    }

    public static int d(AppInterface appInterface, String str, String str2) {
        int a16 = a(appInterface, str, str2);
        if (a16 == 0) {
            return 3;
        }
        if (a16 == 1) {
            return 2;
        }
        if (a16 == 2) {
            return 1;
        }
        if (a16 != 3) {
            return 4;
        }
        return 0;
    }
}
