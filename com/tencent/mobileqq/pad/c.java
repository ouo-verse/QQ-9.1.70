package com.tencent.mobileqq.pad;

import android.app.Activity;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static boolean a(Activity activity, int i3) {
        boolean isInMultiWindowMode;
        if (!AppSetting.t(activity)) {
            QLog.d("PadUtils", 1, "isSplitViewMode = false");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                QLog.d("PadUtils", 1, "isInMultiWindowMode = true");
                return false;
            }
        }
        if (PadUtil.a(activity) == DeviceType.TABLET && i3 != 2) {
            QLog.d("PadUtils", 1, "isPad, and no orientation landscape");
            return false;
        }
        if (PadUtil.b(activity) && PadUtil.a(activity) == DeviceType.FOLD && !b(activity)) {
            QLog.d("PadUtils", 1, "isFold, and no canShowSplitViewOfFold");
            return false;
        }
        if (com.tencent.common.config.pad.g.b(activity) == 1) {
            return false;
        }
        QLog.d("PadUtils", 1, "canShowSplitView");
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (com.tencent.common.config.pad.d.b(r3) == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (com.tencent.common.config.pad.j.c(r3) == 3) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:?, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Activity activity) {
        boolean z16 = true;
        if (!com.tencent.common.config.pad.j.g()) {
            if (!com.tencent.common.config.pad.d.d()) {
                if (com.tencent.common.config.pad.c.c()) {
                    return com.tencent.common.config.pad.c.d(activity);
                }
                if (!com.tencent.common.config.pad.g.d() && !com.tencent.common.config.pad.i.b() && !com.tencent.common.config.pad.h.e() && !com.tencent.common.config.pad.c.c()) {
                    return false;
                }
                return com.tencent.common.config.pad.g.c(activity);
            }
        }
    }

    public static void c(Activity activity) {
        if (activity == null) {
            QLog.e("PadUtils", 1, "initActivityOrientation activity is null");
            return;
        }
        if (AppSetting.o(activity)) {
            if (PadUtil.b(activity) && PadUtil.a(activity) == DeviceType.FOLD && !b(activity)) {
                activity.setRequestedOrientation(1);
                return;
            } else {
                activity.setRequestedOrientation(-1);
                return;
            }
        }
        activity.setRequestedOrientation(1);
    }

    public static boolean d(Activity activity) {
        if (activity == null || PadUtil.a(activity) != DeviceType.FOLD || b(activity)) {
            return false;
        }
        return true;
    }

    public static boolean e(Activity activity) {
        if (activity == null || PadUtil.a(activity) != DeviceType.FOLD || !b(activity)) {
            return false;
        }
        return true;
    }
}
