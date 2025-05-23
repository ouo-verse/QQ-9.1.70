package com.tencent.mobileqq.qqpermission;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.util.QPLog;

/* loaded from: classes17.dex */
public class QQPermissionFactory {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQPermissionFactory";

    public QQPermissionFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static BusinessConfig convertAnnotationConfig(QQPermissionConfig qQPermissionConfig) {
        if (qQPermissionConfig == null) {
            return null;
        }
        return new BusinessConfig(qQPermissionConfig.id(), qQPermissionConfig.scene());
    }

    public static QQPermission getQQPermission(Activity activity) {
        return getQQPermission(activity, null, convertAnnotationConfig((QQPermissionConfig) activity.getClass().getAnnotation(QQPermissionConfig.class)));
    }

    public static QQPermission getQQPermission(Fragment fragment) {
        return getQQPermission(null, fragment, convertAnnotationConfig((QQPermissionConfig) fragment.getClass().getAnnotation(QQPermissionConfig.class)));
    }

    public static QQPermission getQQPermission(Activity activity, BusinessConfig businessConfig) {
        return getQQPermission(activity, null, businessConfig);
    }

    public static QQPermission getQQPermission(Fragment fragment, BusinessConfig businessConfig) {
        return getQQPermission(null, fragment, businessConfig);
    }

    private static QQPermission getQQPermission(Activity activity, Fragment fragment, BusinessConfig businessConfig) {
        if ((fragment == null || fragment.getContext() == null) && activity == null) {
            QPLog.e(TAG, "getQQPermission: activity or fragment is null");
            return null;
        }
        if (businessConfig == null) {
            QPLog.e(TAG, "getQQPermission: BusinessConfig is null");
            return null;
        }
        QQPermission qQPermission = new QQPermission(activity, fragment);
        qQPermission.setBusinessConfig(businessConfig);
        return qQPermission;
    }
}
