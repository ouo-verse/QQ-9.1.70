package com.tencent.mobileqq.util;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class p {
    public static void a(String str, HashMap<String, CoreInfo> hashMap) {
        if (!QLog.isColorLevel()) {
            return;
        }
        QLog.i("ContactCoreInfoUtil", 2, "logContactRemarks from: " + str + "remarks size: " + hashMap.size());
        long j3 = 0;
        for (Map.Entry<String, CoreInfo> entry : hashMap.entrySet()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("logContactRemarks, ");
            j3++;
            sb5.append(j3);
            sb5.append(" ");
            sb5.append(entry.getValue().remark);
            sb5.append(" ");
            sb5.append(entry.getValue().getUin());
            QLog.i("ContactCoreInfoUtil", 2, sb5.toString());
            if (j3 > 10 && j3 < hashMap.size()) {
                QLog.i("ContactCoreInfoUtil", 2, "logContactRemarks, more items omitted");
                return;
            }
        }
    }
}
