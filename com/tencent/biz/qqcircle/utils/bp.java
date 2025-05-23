package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bp {

    /* renamed from: a, reason: collision with root package name */
    private static String f92717a = null;

    /* renamed from: b, reason: collision with root package name */
    private static long f92718b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f92719c = -1;

    public static int a() {
        return f92719c;
    }

    public static boolean b() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qfs_enable_tab_type_restore_LOGIC", true) || f92719c == -1) {
            return false;
        }
        if (System.currentTimeMillis() - f92718b < 3000 || !TextUtils.equals(f92717a, QQTheme.getCurrentThemeId())) {
            return true;
        }
        return false;
    }

    public static void c(int i3) {
        RFWLog.d("QFSFolderRestoreUtils", RFWLog.USR, "onFolderDestroy type:" + i3);
        f92719c = i3;
        f92717a = QQTheme.getCurrentThemeId();
        f92718b = System.currentTimeMillis();
    }
}
