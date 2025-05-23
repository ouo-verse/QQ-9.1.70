package com.tencent.biz.pubaccount.subscript;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class f {
    public static String a(String str) {
        String str2;
        if (str != null && str.length() < 5) {
            str2 = SubscriptConstants.f80001a.get(str);
        } else if (str != null) {
            try {
                str2 = String.valueOf(Integer.parseInt(str));
            } catch (Exception unused) {
                str2 = SubscriptConstants.f80001a.get(str);
            }
        } else {
            str2 = str;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubscriptUtil", 2, "getUin subscribeID[" + str + "]'s uin: " + str2);
        }
        return str2;
    }
}
