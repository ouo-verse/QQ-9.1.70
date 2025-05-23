package com.tencent.mobileqq.persistence;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class UpgradeUtil {
    private static final String[] TABLE_PREFIX_DEPRECATED = {"mr_troop_", "mr_discusssion_", "mr_temp_game_msg_", "mr_contact_", "mr_multimessage_"};

    public static boolean isDeprecatedTable(String str) {
        for (String str2 : TABLE_PREFIX_DEPRECATED) {
            if (str.startsWith(str2)) {
                QLog.d("UpgradeUtil", 1, "isDeprecatedTable filter table name: " + str);
                return true;
            }
        }
        return false;
    }
}
