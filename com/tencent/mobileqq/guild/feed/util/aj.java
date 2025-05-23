package com.tencent.mobileqq.guild.feed.util;

import android.app.Activity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class aj {
    public static void a(Activity activity, int i3, QQPermission.BasePermissionsListener basePermissionsListener, BusinessConfig businessConfig, String... strArr) {
        if (activity != null) {
            QLog.d("GuildFeedPermissionUtil", 1, "requestPermissions in ComponentBaseActivity");
            QQPermissionFactory.getQQPermission(activity, businessConfig).requestPermissions(strArr, i3, basePermissionsListener);
        } else {
            QLog.d("GuildFeedPermissionUtil", 1, "requestPermissions error with unknown activity");
        }
    }
}
