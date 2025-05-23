package com.tencent.av.utils;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class aj {
    public static void a(Activity activity) {
        if (activity == null || activity.getIntent() == null || TextUtils.equals(activity.getIntent().getStringExtra("Fromwhere"), "SmallScreen")) {
            return;
        }
        RFWLog.i("QAVQZoneEntranceHelper", RFWLog.CLR, "clear qav qzone top status");
        b(false);
    }

    public static void b(boolean z16) {
        uq3.k.a().j("qav_qzone_home_page_is_top", z16);
    }

    public static boolean c() {
        return uq3.k.a().c("qav_qzone_home_page_is_top", false);
    }
}
