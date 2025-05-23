package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx;

import android.text.TextUtils;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import java.util.HashMap;
import pw2.i;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    public static String a(boolean z16, String str, String str2, String str3) {
        if (z16 && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pathType", 2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ad_trace_data", str2);
        hashMap2.put("token", str);
        if (!TextUtils.isEmpty(str3)) {
            hashMap2.put(CoverDBCacheData.PACKAGE_INFO, str3);
        }
        hashMap.put("invokeData", hashMap2);
        return i.s(hashMap);
    }
}
