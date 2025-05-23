package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class z {
    public static boolean a(Activity activity, String str) {
        if (activity != null && activity.getWindow() != null) {
            View decorView = activity.getWindow().getDecorView();
            Object obj = activity;
            if (decorView.getParent() instanceof View) {
                obj = ((View) decorView.getParent()).getContext();
            }
            QQPermission qQPermission = QQPermissionFactory.getQQPermission((Activity) obj, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_MIX_FEED));
            if (qQPermission != null && qQPermission.hasPermission(str) == 0) {
                return true;
            }
            return false;
        }
        QLog.d("QCirclePermissionUtil", 1, "hasPermission error with null activity");
        return false;
    }

    public static void b(Activity activity, int i3, QQPermission.BasePermissionsListener basePermissionsListener, BusinessConfig businessConfig, String... strArr) {
        if (activity != null && activity.getWindow() != null) {
            View decorView = activity.getWindow().getDecorView();
            Object obj = activity;
            if (decorView.getParent() instanceof View) {
                obj = ((View) decorView.getParent()).getContext();
            }
            QQPermission qQPermission = QQPermissionFactory.getQQPermission((Activity) obj, businessConfig);
            if (qQPermission == null) {
                return;
            }
            qQPermission.requestPermissions(strArr, i3, basePermissionsListener);
            return;
        }
        QLog.d("QCirclePermissionUtil", 1, "requestPermissions error with null activity");
    }
}
