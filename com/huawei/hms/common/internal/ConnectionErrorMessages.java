package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ConnectionErrorMessages {
    private static boolean a(Context context) {
        if (context != null && Util.isAvailableLibExist(context) && AvailableUtil.isInstallerLibExist(context)) {
            return true;
        }
        return false;
    }

    public static String getErrorDialogButtonMessage(Activity activity, int i3) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return ResourceLoaderUtil.getString("hms_confirm");
            }
            if (a(activity)) {
                return ResourceLoaderUtil.getString("hms_update");
            }
            return ResourceLoaderUtil.getString("hms_confirm");
        }
        if (a(activity)) {
            return ResourceLoaderUtil.getString("hms_install");
        }
        return ResourceLoaderUtil.getString("hms_confirm");
    }

    public static String getErrorMessage(Activity activity, int i3) {
        if (activity == null) {
            return null;
        }
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i3 != 1 && i3 != 2) {
            return null;
        }
        if (a(activity)) {
            return ResourceLoaderUtil.getString("hms_update_title");
        }
        return activity.getString(ResourceLoaderUtil.getStringId("hms_apk_not_installed_hints"), Util.getAppName(activity, activity.getPackageName()));
    }

    public static String getErrorTitle(Activity activity, int i3) {
        if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(activity.getApplicationContext());
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        HMSLog.e("HuaweiApiAvailability", "Unexpected error code " + i3);
                        return null;
                    }
                    HMSLog.e("HuaweiApiAvailability", "Huawei Mobile Services is invalid. Cannot recover.");
                    return null;
                }
                return ResourceLoaderUtil.getString("hms_bindfaildlg_message");
            }
            if (!a(activity)) {
                return null;
            }
            return ResourceLoaderUtil.getString("hms_update_message");
        }
        if (!a(activity)) {
            return null;
        }
        return ResourceLoaderUtil.getString("hms_install_message");
    }
}
