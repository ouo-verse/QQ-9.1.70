package com.tencent.mobileqq.msf.core.push;

import android.app.Notification;
import android.content.Context;
import com.tencent.commonsdk.badge.BadgeController;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BadgeUtilImpl {
    static IPatchRedirector $redirector_ = null;
    public static final String QQSETTING_SHOW_BADGEUNREAD_KEY = "qqsetting_show_badgeunread_key";
    public static final String TAG = "BadgeUtilImpl";

    public BadgeUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void changeMI6Badge(Context context, int i3, Notification notification) {
        if (!isEnabled(context)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setBadge isdisableabled count=0");
            }
            i3 = 0;
        }
        CommonBadgeUtilImpl.changeMI6Badge(context, i3, notification);
    }

    public static void disableBadge(Context context) {
        if (isSupportBadge(context)) {
            setBadge(context, 0, true);
            SettingCloneUtil.writeValue(context, (String) null, (String) null, QQSETTING_SHOW_BADGEUNREAD_KEY, false);
        }
    }

    public static void enableBadge(Context context) {
        if (isSupportBadge(context)) {
            SettingCloneUtil.writeValue(context, (String) null, (String) null, QQSETTING_SHOW_BADGEUNREAD_KEY, true);
        }
    }

    public static boolean isEnabled(Context context) {
        if (isSupportBadge(context)) {
            return SettingCloneUtil.readValue(context, (String) null, (String) null, QQSETTING_SHOW_BADGEUNREAD_KEY, true);
        }
        return false;
    }

    public static boolean isSupportBadge(Context context) {
        return CommonBadgeUtilImpl.isSupportBadge(context);
    }

    public static void setBadge(Context context, int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setBadge count=" + i3 + "|forceSet=" + z16);
        }
        if (isEnabled(context) || z16) {
            if (!isEnabled(context)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "setBadge isdisableabled count=0");
                }
                i3 = 0;
            }
            BadgeController.setBadge(i3);
            CommonBadgeUtilImpl.setBadge(context, i3, z16);
        }
    }

    public static void setLimitCount(int i3) {
        CommonBadgeUtilImpl.setLimitCount(i3);
    }

    public static void setMIUI6Badge(Context context, int i3, Notification notification) {
        CommonBadgeUtilImpl.setMIUI6Badge(context, i3, notification);
    }

    public static void setBadge(Context context, int i3) {
        setBadge(context, i3, false);
    }
}
