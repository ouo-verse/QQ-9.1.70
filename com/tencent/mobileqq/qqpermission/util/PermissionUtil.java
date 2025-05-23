package com.tencent.mobileqq.qqpermission.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.widget.az;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes17.dex */
public class PermissionUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String PREFIX_MULTI_SCENE_AUTH = "multiSceneAuth-";
    private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
    private static final String SCHEME_PACKAGE = "package";
    private static final String TAG = "PermissionUtil";
    private static HashMap<String, String> permissionGroupMapOnQ;

    /* loaded from: classes17.dex */
    public static class PermissionGroup {
        static IPatchRedirector $redirector_;
        public String name;
        public List<String> permissions;

        public PermissionGroup() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public PermissionUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean canRequestInstalledApps(Context context) {
        try {
        } catch (Exception e16) {
            QLog.d(TAG, 1, "GET_INSTALLED_APPS not support", e16);
        }
        if (context.getPackageManager().getPermissionInfo(QQPermissionConstants.Permission.GET_INSTALLED_APPS, 0) == null) {
            return false;
        }
        return true;
    }

    public static int checkPermission(Context context, PermissionGroup permissionGroup) {
        List<String> list;
        if (permissionGroup != null && (list = permissionGroup.permissions) != null && !list.isEmpty()) {
            Iterator<String> it = permissionGroup.permissions.iterator();
            while (it.hasNext()) {
                if (ContextCompat.checkSelfPermission(context, it.next()) == 0) {
                    return 0;
                }
            }
        }
        return -1;
    }

    public static String getHashKey(String str, String str2, String str3) {
        return str + "#" + str2 + "#" + str3;
    }

    public static String getIntroductionByScene(BusinessConfig businessConfig, String str) {
        if (businessConfig != null && str != null) {
            String str2 = QQPermissionConstants.Permission.PERMISSION_GROUP.get(str);
            QLog.d(TAG, 1, "getIntroductionByScene businessConfig: " + businessConfig + ", permission: " + str + ", permissionByGroup: " + str2);
            if (str2 == null) {
                return null;
            }
            Map<String, Integer> map = QQPermissionConstants.Business.PERMISSION_SCENE_INTRODUCE;
            Integer num = map.get(getHashKey(businessConfig.getBusinessId(), businessConfig.getBusinessScene(), str2));
            if (num == null) {
                QLog.w(TAG, 1, "getIntroductionByScene introductionStrId is null!");
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    num = map.get(getHashKey(businessConfig.getBusinessId(), businessConfig.getBusinessScene(), "location"));
                    if (num == null) {
                        QLog.w(TAG, 1, "getIntroductionByScene location introductionStrId is null!");
                    }
                }
                return null;
            }
            String g16 = az.g(num.intValue());
            QLog.d(TAG, 1, "getIntroductionByScene introductionStrId[" + num + "], introduction[" + g16 + "]");
            return g16;
        }
        QLog.w(TAG, 1, "getIntroductionByScene businessConfig: " + businessConfig + ", permission: " + str);
        return null;
    }

    public static String getPermissionGroupName(PackageManager packageManager, String str) {
        PermissionInfo permissionInfo;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            return getPermissionMapOnR().get(str);
        }
        if (i3 >= 29) {
            return getPermissionMapOnQ().get(str);
        }
        try {
            permissionInfo = packageManager.getPermissionInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e16) {
            QPLog.e(TAG, "getPermissionInfo exception", e16);
            permissionInfo = null;
        }
        if (permissionInfo == null) {
            return null;
        }
        return permissionInfo.group;
    }

    @RequiresApi(api = 29)
    private static HashMap<String, String> getPermissionMapOnQ() {
        if (permissionGroupMapOnQ == null) {
            synchronized (PermissionUtil.class) {
                if (permissionGroupMapOnQ == null) {
                    permissionGroupMapOnQ = new HashMap<>();
                }
                permissionGroupMapOnQ.put("android.permission.READ_CALENDAR", "android.permission-group.CALENDAR");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.WRITE_CALENDAR, "android.permission-group.CALENDAR");
                permissionGroupMapOnQ.put("android.permission.READ_CALL_LOG", "android.permission-group.CALL_LOG");
                permissionGroupMapOnQ.put("android.permission.WRITE_CALL_LOG", "android.permission-group.CALL_LOG");
                permissionGroupMapOnQ.put("android.permission.PROCESS_OUTGOING_CALLS", "android.permission-group.CALL_LOG");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.CAMERA, "android.permission-group.CAMERA");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.READ_CONTACTS, "android.permission-group.CONTACTS");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.WRITE_CONTACTS, "android.permission-group.CONTACTS");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.GET_ACCOUNTS, "android.permission-group.CONTACTS");
                permissionGroupMapOnQ.put("android.permission.ACCESS_FINE_LOCATION", "android.permission-group.LOCATION");
                permissionGroupMapOnQ.put("android.permission.ACCESS_COARSE_LOCATION", "android.permission-group.LOCATION");
                permissionGroupMapOnQ.put("android.permission.ACCESS_BACKGROUND_LOCATION", "android.permission-group.LOCATION");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.RECORD_AUDIO, "android.permission-group.MICROPHONE");
                permissionGroupMapOnQ.put(DeviceInfoUtil.PERMISSION_READ_PHONE, "android.permission-group.PHONE");
                permissionGroupMapOnQ.put("android.permission.READ_PHONE_NUMBERS", "android.permission-group.PHONE");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.CALL_PHONE, "android.permission-group.PHONE");
                permissionGroupMapOnQ.put("android.permission.ANSWER_PHONE_CALLS", "android.permission-group.PHONE");
                permissionGroupMapOnQ.put("com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission-group.PHONE");
                permissionGroupMapOnQ.put("android.permission.USE_SIP", "android.permission-group.PHONE");
                permissionGroupMapOnQ.put("android.permission.ACCEPT_HANDOVER", "android.permission-group.PHONE");
                permissionGroupMapOnQ.put("android.permission.BODY_SENSORS", "android.permission-group.SENSORS");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.ACTIVITY_RECOGNITION, "android.permission-group.ACTIVITY_RECOGNITION");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.SEND_SMS, "android.permission-group.SMS");
                permissionGroupMapOnQ.put("android.permission.RECEIVE_SMS", "android.permission-group.SMS");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.READ_SMS, "android.permission-group.SMS");
                permissionGroupMapOnQ.put("android.permission.RECEIVE_WAP_PUSH", "android.permission-group.SMS");
                permissionGroupMapOnQ.put("android.permission.RECEIVE_MMS", "android.permission-group.SMS");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, "android.permission-group.STORAGE");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "android.permission-group.STORAGE");
                permissionGroupMapOnQ.put(QQPermissionConstants.Permission.ACCESS_MEDIA_LOCATION, "android.permission-group.STORAGE");
            }
        }
        return permissionGroupMapOnQ;
    }

    @TargetApi(30)
    private static Map<String, String> getPermissionMapOnR() {
        return getPermissionMapOnQ();
    }

    public static List<PermissionGroup> getRequestedPermissionGroups(Context context) {
        String[] requestedPermissionList;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (requestedPermissionList = getRequestedPermissionList(packageManager, context.getPackageName())) == null || requestedPermissionList.length == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : requestedPermissionList) {
            String permissionGroupName = getPermissionGroupName(packageManager, str);
            if (!TextUtils.isEmpty(permissionGroupName)) {
                PermissionGroup permissionGroup = (PermissionGroup) hashMap.get(permissionGroupName);
                if (permissionGroup == null) {
                    permissionGroup = new PermissionGroup();
                    permissionGroup.name = permissionGroupName;
                    hashMap.put(permissionGroupName, permissionGroup);
                }
                if (permissionGroup.permissions == null) {
                    permissionGroup.permissions = new ArrayList();
                }
                permissionGroup.permissions.add(str);
            }
        }
        return new ArrayList(hashMap.values());
    }

    private static String[] getRequestedPermissionList(PackageManager packageManager, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(packageManager, str, 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException e16) {
            QPLog.e(TAG, "getPackageInfo exception", e16);
            return null;
        }
    }

    public static void gotoSettingPage(Context context) {
        QPLog.i(TAG, "gotoSettingPage");
        Intent intent = new Intent();
        intent.addFlags(335544320);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", "com.tencent.mobileqq", null));
        context.startActivity(intent);
    }

    public static boolean isInstalledAppsGranted(Context context) {
        if (!canRequestInstalledApps(context) || ContextCompat.checkSelfPermission(context, QQPermissionConstants.Permission.GET_INSTALLED_APPS) == 0) {
            return true;
        }
        return false;
    }

    public static List<String> queryPermissionsByGroup(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            Map<String, String> permissionMapOnR = getPermissionMapOnR();
            for (String str2 : permissionMapOnR.keySet()) {
                if (permissionMapOnR.get(str2).equals(str)) {
                    arrayList.add(str2);
                }
            }
        } else if (i3 >= 29) {
            HashMap<String, String> permissionMapOnQ = getPermissionMapOnQ();
            for (String str3 : permissionMapOnQ.keySet()) {
                if (permissionMapOnQ.get(str3).equals(str)) {
                    arrayList.add(str3);
                }
            }
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    Iterator<PermissionInfo> it = packageManager.queryPermissionsByGroup(str, 0).iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().name);
                    }
                } catch (PackageManager.NameNotFoundException e16) {
                    QLog.e(TAG, 1, "queryPermissionsByGroup error: ", e16);
                }
            }
        }
        return arrayList;
    }

    public static String getHashKey(String str, String str2) {
        return PREFIX_MULTI_SCENE_AUTH + str + "#" + str2;
    }
}
