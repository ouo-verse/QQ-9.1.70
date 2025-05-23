package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;

/* compiled from: P */
/* loaded from: classes20.dex */
public class fd {
    public static void a(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String... strArr) {
        String[] strArr2 = {"", "", "", ""};
        if (strArr != null) {
            int length = strArr.length;
            for (int i17 = 0; i17 < length && i17 < 4; i17++) {
                if (!TextUtils.isEmpty(strArr[i17])) {
                    strArr2[i17] = strArr[i17];
                }
            }
        }
        ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).reportClickEventTo644(appInterface, str, str2, str3, i3, i16, strArr2);
    }
}
