package com.tencent.biz.subscribe.comment;

import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {
    public static String a(long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.f171998mo2);
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < 10000000) {
            String valueOf = String.valueOf((j3 / 10000.0d) + 0.05d);
            return valueOf.substring(0, valueOf.indexOf(".") + 2) + "w";
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return (j3 / 10000) + "w";
        }
        String valueOf2 = String.valueOf(j3 / 1.0E8d);
        return valueOf2.substring(0, valueOf2.indexOf(".") + 2) + qqStr;
    }
}
