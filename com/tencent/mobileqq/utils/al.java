package com.tencent.mobileqq.utils;

import android.R;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    private static int f307425a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static String f307426b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f307427c = true;

    public static float a(Context context, float f16) {
        return f16 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    private static int b(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int c(TextView textView, int i3) {
        if (textView != null && textView.getText() != null && i3 > 0) {
            return new StaticLayout(textView.getText().toString(), textView.getPaint(), i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount();
        }
        return -1;
    }

    public static int d(Context context) {
        String str;
        Resources resources = context.getResources();
        g(context);
        if (f307427c) {
            str = "navigation_bar_height";
        } else {
            str = "navigation_bar_height_landscape";
        }
        return b(resources, str);
    }

    @SuppressLint({"NewApi"})
    public static int e(Context context) {
        int launcherLargeIconSize = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getLauncherLargeIconSize();
        int dimension = (int) context.getResources().getDimension(R.dimen.app_icon_size);
        if (QLog.isColorLevel()) {
            QLog.d("DisplayUtils", 2, "launcher icon size = " + launcherLargeIconSize + " , app icon size = " + dimension);
        }
        return Math.max(launcherLargeIconSize, dimension);
    }

    public static boolean f(Context context) {
        boolean z16;
        int i3 = f307425a;
        if (i3 != -1) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            z16 = resources.getBoolean(identifier);
            if ("1".equals(f307426b)) {
                z16 = false;
            } else if ("0".equals(f307426b)) {
                z16 = true;
            }
        } else {
            z16 = !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, "hasNavbar=" + z16);
        }
        if (z16) {
            f307425a = 1;
        } else {
            f307425a = 0;
        }
        return z16;
    }

    public static void g(Context context) {
        if (context != null) {
            boolean z16 = true;
            if (context.getResources().getConfiguration().orientation != 1) {
                z16 = false;
            }
            f307427c = z16;
        }
    }
}
