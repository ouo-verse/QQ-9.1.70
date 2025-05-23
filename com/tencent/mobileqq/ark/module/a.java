package com.tencent.mobileqq.ark.module;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    public static boolean a(String str, long j3, ark.Application application, String str2) {
        boolean z16;
        if (j3 == 0) {
            z16 = true;
        } else if (application != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            z16 = application.CheckPermissions(str2);
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("ArkApp.ArkAPIPermission", 1, String.format("ModuleCheckPermission.denied:Name:%s,Permission:%s.", str, str2));
        }
        return z16;
    }
}
