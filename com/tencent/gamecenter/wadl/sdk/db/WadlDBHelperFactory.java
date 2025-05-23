package com.tencent.gamecenter.wadl.sdk.db;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlDBHelperFactory {
    private static HashMap<String, WadlBaseDBHelper> DB_HELPER_MAP = new HashMap<>();

    public static synchronized WadlBaseDBHelper getDBHelper(int i3) {
        WadlBaseDBHelper wadlBaseDBHelper;
        synchronized (WadlDBHelperFactory.class) {
            String str = WadlProxyConsts.TABLE_NAME_TASKS_PRE + i3;
            wadlBaseDBHelper = DB_HELPER_MAP.get(str);
            if (wadlBaseDBHelper == null) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            wadlBaseDBHelper = new WadlVMDBHelper(MobileQQ.sMobileQQ, str);
                        }
                    } else {
                        wadlBaseDBHelper = new WadlTgpaDBHelper(MobileQQ.sMobileQQ, str);
                    }
                } else {
                    wadlBaseDBHelper = new WadlGameCenterDBHelper(MobileQQ.sMobileQQ, str);
                }
                if (wadlBaseDBHelper != null) {
                    DB_HELPER_MAP.put(str, wadlBaseDBHelper);
                }
            }
        }
        return wadlBaseDBHelper;
    }
}
