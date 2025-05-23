package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dn {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f307682a = {"com.android.launcher.permission.READ_SETTINGS", "com.android.launcher2.permission.READ_SETTINGS", "com.android.launcher3.permission.READ_SETTINGS", "com.google.android.launcher.permission.READ_SETTINGS", "com.huawei.android.launcher.permission.READ_SETTINGS", "com.huawei.launcher2.permission.READ_SETTINGS", "com.huawei.launcher3.permission.READ_SETTINGS", "com.bbk.launcher2.permission.READ_SETTINGS", "com.huaqin.launcherEx.permission.READ_SETTINGS", "com.htc.launcher.permission.READ_SETTINGS", "com.htc.launcher.settings", "com.oppo.launcher.permission.READ_SETTINGS", "com.meizu.android.launcher.permission.READ_SETTINGS", "com.meizu.launcher2.permission.READ_SETTINGS", "com.meizu.android.launcher3.permission.READ_SETTINGS", "com.lenovo.launcher.permission.READ_SETTINGS", "com.ebproductions.android.launcher.permission.READ_SETTINGS", "com.android.mylauncher.permission.READ_SETTINGS", "com.sec.android.app.twlauncher.settings.READ_SETTINGS", "com.fede.launcher.permission.READ_SETTINGS", "net.qihoo.launcher.permission.READ_SETTINGS", "com.qihoo360.launcher.permission.READ_SETTINGS", "com.lge.launcher.permission.READ_SETTINGS", "org.adw.launcher.permission.READ_SETTINGS", "telecom.mdesk.permission.READ_SETTINGS"};

    /* renamed from: b, reason: collision with root package name */
    private static String f307683b = null;

    public static String a(Context context) {
        if (f307683b == null) {
            f307683b = GlobalUtil.DEF_STRING;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.SHORTCUT, 2, "getShortcutUri.shortcutUri=" + f307683b);
        }
        return f307683b;
    }
}
