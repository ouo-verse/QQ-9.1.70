package cooperation.qzone.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;

/* loaded from: classes28.dex */
public class QZonePermission {
    public static Activity getRealPluginActivity(Activity activity) {
        if (activity == null) {
            return null;
        }
        if (activity instanceof QzonePluginProxyActivity) {
            return (Activity) ((QzonePluginProxyActivity) activity).getRealPluginActivity();
        }
        return activity;
    }

    public static boolean requestPermissions(Context context, String str, QQPermission.BasePermissionsListener basePermissionsListener) {
        if (context == null) {
            return false;
        }
        if (context.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && context.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        if (context instanceof Activity) {
            requestPermissions((Activity) context, str, basePermissionsListener);
        }
        return false;
    }

    public static boolean requestStoragePermission(Activity activity, String str) {
        return requestStoragePermission(activity, new QQPermission.BasePermissionsListener() { // from class: cooperation.qzone.util.QZonePermission.1
            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
            }
        }, str);
    }

    public static boolean requestStoragePermissionForPluginActivity(Activity activity, QQPermission.BasePermissionsListener basePermissionsListener, String str) {
        if (activity == null) {
            return false;
        }
        if (activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && activity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        requestPermissions(activity, str, basePermissionsListener);
        return false;
    }

    public static boolean requestStoragePermission(Activity activity, QQPermission.BasePermissionsListener basePermissionsListener, String str) {
        if (activity == null) {
            return false;
        }
        return requestStoragePermissionForPluginActivity(activity, basePermissionsListener, str);
    }

    private static void requestPermissions(Activity activity, String str, QQPermission.BasePermissionsListener basePermissionsListener) {
        QQPermission qQPermission;
        Activity realPluginActivity = getRealPluginActivity(activity);
        if (realPluginActivity == null || (qQPermission = QQPermissionFactory.getQQPermission(realPluginActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QZONE, str))) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE);
        arrayList.add(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        if (Build.VERSION.SDK_INT >= 29) {
            arrayList.add(QQPermissionConstants.Permission.ACCESS_MEDIA_LOCATION);
        }
        qQPermission.requestPermissions((String[]) arrayList.toArray(new String[0]), 2, basePermissionsListener);
    }
}
