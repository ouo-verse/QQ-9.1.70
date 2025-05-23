package com.tencent.mobileqq.app.utils;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

/* loaded from: classes11.dex */
public class PermissionUtils {
    static IPatchRedirector $redirector_;

    public PermissionUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @TargetApi(23)
    public static boolean isStorePermissionEnable(Context context) {
        if (context != null && context.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && context.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    @TargetApi(23)
    public static void requestStorePermission(AppActivity appActivity, int i3, QQPermissionCallback qQPermissionCallback) {
        if (appActivity != null) {
            appActivity.requestPermissions(qQPermissionCallback, i3, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        }
    }
}
