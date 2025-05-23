package com.tencent.mobileqq.richmedia;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    public static int a(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, "##" + str2);
            return 0;
        }
        return 0;
    }

    public static int b(String str, String str2) {
        QLog.e(str, 2, "##" + str2);
        return 0;
    }
}
