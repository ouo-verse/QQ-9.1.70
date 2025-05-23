package com.tencent.mobileqq.util;

import android.app.Activity;
import android.view.WindowManager;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bb {
    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        int orientation = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getOrientation();
        int i3 = activity.getResources().getConfiguration().orientation;
        int i16 = 1;
        if (i3 != 1) {
            i16 = (i3 == 2 && orientation != 0 && orientation != 1 && VersionUtils.isGingerBread()) ? 8 : 0;
        } else if (orientation != 0 && orientation != 3 && VersionUtils.isGingerBread()) {
            i16 = 9;
        }
        activity.setRequestedOrientation(i16);
    }

    public static void b(Activity activity) {
        if (activity != null) {
            activity.setRequestedOrientation(-1);
        }
    }
}
