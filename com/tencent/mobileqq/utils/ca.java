package com.tencent.mobileqq.utils;

import android.app.Activity;
import com.tencent.common.config.AppSetting;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ca {
    public static void a(Activity activity) {
        int i3;
        if (activity == null) {
            return;
        }
        if (AppSetting.o(activity)) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        activity.setRequestedOrientation(i3);
    }
}
