package com.vivo.push.util;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.raft.raftframework.sla.SLAReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f387881a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: b, reason: collision with root package name */
    private static String[] f387882b = {SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};

    /* renamed from: c, reason: collision with root package name */
    private static String[] f387883c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: d, reason: collision with root package name */
    private static String[] f387884d = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* renamed from: e, reason: collision with root package name */
    private static String[] f387885e = new String[0];

    /* renamed from: f, reason: collision with root package name */
    private static Map<String, Bundle> f387886f = new ConcurrentHashMap();

    public static long a(Context context) {
        String a16 = aa.a(context);
        if (TextUtils.isEmpty(a16)) {
            u.a("Utility", "systemPushPkgName is null");
            return -1L;
        }
        return a(context, a16);
    }

    public static String b(Context context, String str) {
        Object a16 = a(context, str, "verification_status");
        return a16 != null ? a16.toString() : "";
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00be: MOVE (r1 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:81:0x00be */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0 A[Catch: Exception -> 0x00bc, TRY_ENTER, TryCatch #1 {Exception -> 0x00bc, blocks: (B:49:0x0098, B:51:0x009d, B:53:0x00a1, B:41:0x00b0, B:43:0x00b5, B:45:0x00b9), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey c(Context context) {
        Cursor cursor;
        ContentProviderClient contentProviderClient;
        Cursor cursor2;
        Cursor cursor3 = null;
        try {
            try {
                try {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 24) {
                        ContentResolver contentResolver = context.getContentResolver();
                        Uri uri = com.vivo.push.x.f387937a;
                        contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                        if (contentProviderClient != null) {
                            try {
                                u.a("Utility", "client is null");
                                cursor2 = contentProviderClient.query(uri, null, null, null, null);
                            } catch (Exception e16) {
                                e = e16;
                                cursor2 = null;
                                e.printStackTrace();
                                if (cursor2 != null) {
                                }
                                if (contentProviderClient != null) {
                                    contentProviderClient.close();
                                }
                                return null;
                            } catch (Throwable th5) {
                                th = th5;
                                if (cursor3 != null) {
                                    try {
                                        cursor3.close();
                                    } catch (Exception unused) {
                                        throw th;
                                    }
                                }
                                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                    contentProviderClient.close();
                                }
                                throw th;
                            }
                        } else {
                            cursor2 = null;
                        }
                    } else {
                        contentProviderClient = null;
                        cursor2 = null;
                    }
                    if (cursor2 == null) {
                        try {
                            cursor2 = ContactsMonitor.query(context.getContentResolver(), com.vivo.push.x.f387937a, null, null, null, null);
                        } catch (Exception e17) {
                            e = e17;
                            e.printStackTrace();
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                contentProviderClient.close();
                            }
                            return null;
                        }
                    }
                    if (cursor2 == null) {
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (contentProviderClient != null && i3 >= 24) {
                            contentProviderClient.close();
                        }
                        return null;
                    }
                    while (cursor2.moveToNext()) {
                        if ("pushkey".equals(cursor2.getString(cursor2.getColumnIndex("name")))) {
                            String string = cursor2.getString(cursor2.getColumnIndex("value"));
                            u.d("Utility", "result key : ".concat(String.valueOf(string)));
                            PublicKey a16 = ab.a(string);
                            try {
                                cursor2.close();
                                if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                                    contentProviderClient.close();
                                }
                            } catch (Exception unused3) {
                            }
                            return a16;
                        }
                    }
                    cursor2.close();
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                } catch (Exception e18) {
                    e = e18;
                    contentProviderClient = null;
                    cursor2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    contentProviderClient = null;
                }
            } catch (Exception unused4) {
            }
            return null;
        } catch (Throwable th7) {
            th = th7;
            cursor3 = cursor;
        }
    }

    private static void d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() != null) {
                ServiceInfo[] serviceInfoArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 4).services;
                if (serviceInfoArr != null) {
                    for (String str2 : f387883c) {
                        a(str2, serviceInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("serviceInfos is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e16) {
            throw new VivoPushException("error " + e16.getMessage());
        }
    }

    private static void e(Context context, String str) throws VivoPushException {
        if (f387885e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 1).activities;
                if (activityInfoArr != null) {
                    for (String str2 : f387885e) {
                        a(str2, activityInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("activityInfos is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e16) {
            throw new VivoPushException("error " + e16.getMessage());
        }
    }

    private static void f(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() != null) {
                ActivityInfo[] activityInfoArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 2).receivers;
                if (activityInfoArr != null) {
                    for (String str2 : f387884d) {
                        a(str2, activityInfoArr, str);
                    }
                    return;
                }
                throw new VivoPushException("receivers is null");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e16) {
            throw new VivoPushException(e16.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int g(Context context, String str) {
        String obj;
        int intValue;
        String str2;
        if (context != null && !TextUtils.isEmpty(str)) {
            Object a16 = a(context, str, "sdk_version_vivo");
            if (a16 instanceof String) {
                obj = (String) a16;
            } else {
                if (a16 instanceof Integer) {
                    intValue = ((Integer) a16).intValue();
                    str2 = "";
                    if (intValue <= 0) {
                        return intValue;
                    }
                    try {
                        return Integer.parseInt(str2);
                    } catch (Exception e16) {
                        u.a("Utility", "getClientSdkVersion: ".concat(String.valueOf(e16)));
                        return 0;
                    }
                }
                if (a16 == null) {
                    return 0;
                }
                obj = a16.toString();
            }
            str2 = obj;
            intValue = 0;
            if (intValue <= 0) {
            }
        } else {
            u.a("Utility", "getClientSdkVersion() error, context is null or pkgName is empty");
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0114, code lost:
    
        r12 = r12 + 1;
        r8 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) throws VivoPushException {
        String obj;
        u.d("Utility", "check PushService AndroidManifest declearation !");
        String a16 = aa.a(context);
        boolean d16 = aa.d(context, context.getPackageName());
        boolean e16 = aa.e(context, context.getPackageName());
        boolean c16 = aa.c(context, context.getPackageName());
        int i3 = 0;
        if (e16) {
            f387881a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
            f387882b = new String[]{SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
            f387883c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
            f387884d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        } else {
            if (!c16 && !d16) {
                throw new VivoPushException("AndroidManifest.xml\u4e2dreceiver\u914d\u7f6e\u9879\u9519\u8bef\uff0c\u8be6\u89c1\u63a5\u5165\u6587\u6863");
            }
            if (c16) {
                f387883c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
            } else {
                f387883c = new String[]{"com.vivo.push.sdk.service.CommandService"};
            }
            f387884d = new String[0];
            f387881a = new String[0];
            if (d16) {
                f387882b = new String[]{SLAReporter.PERMISSION_NET, "android.permission.WRITE_SETTINGS"};
            } else {
                f387882b = new String[]{SLAReporter.PERMISSION_NET};
            }
        }
        if (d16) {
            long a17 = a(context, context.getPackageName());
            long j3 = context.getPackageName().equals(a16) ? 1341L : 341L;
            if (a17 == -1) {
                throw new VivoPushException("AndroidManifest.xml\u4e2d\u672a\u914d\u7f6esdk_version");
            }
            if (a17 != j3) {
                throw new VivoPushException("AndroidManifest.xml\u4e2dsdk_version\u914d\u7f6e\u9879\u9519\u8bef\uff0c\u8bf7\u914d\u7f6e\u5f53\u524dsdk_version\u7248\u672c\u4e3a:".concat(String.valueOf(j3)));
            }
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String[] strArr = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    String[] strArr2 = f387882b;
                    int length = strArr2.length;
                    int i16 = 0;
                    while (i16 < length) {
                        String str = strArr2[i16];
                        int length2 = strArr.length;
                        for (int i17 = i3; i17 < length2; i17++) {
                            if (!str.equals(strArr[i17])) {
                            }
                        }
                        throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr));
                    }
                    f(context, a16);
                    d(context, a16);
                    e(context, a16);
                    try {
                        if (a(context, context.getPackageName(), "local_iv") != null) {
                            String packageName = context.getPackageName();
                            Object a18 = a(context, packageName, "com.vivo.push.api_key");
                            String str2 = "";
                            if (a18 != null) {
                                obj = a18.toString();
                            } else {
                                Object a19 = a(context, packageName, "api_key");
                                obj = a19 != null ? a19.toString() : "";
                            }
                            if (!TextUtils.isEmpty(obj)) {
                                String packageName2 = context.getPackageName();
                                Object a26 = a(context, packageName2, "com.vivo.push.app_id");
                                if (a26 != null) {
                                    str2 = a26.toString();
                                } else {
                                    Object a27 = a(context, packageName2, "app_id");
                                    if (a27 != null) {
                                        str2 = a27.toString();
                                    }
                                }
                                if (TextUtils.isEmpty(str2)) {
                                    throw new VivoPushException("com.vivo.push.app_id is null");
                                }
                                if ((d16 || e16) && a(context, context.getPackageName()) == -1) {
                                    throw new VivoPushException("sdkversion is null");
                                }
                                if (e16) {
                                    a(context, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
                                    a(context, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
                                    return;
                                }
                                return;
                            }
                            throw new VivoPushException("com.vivo.push.api_key is null");
                        }
                        throw new VivoPushException("AndroidManifest.xml\u4e2d\u672a\u914d\u7f6e".concat("local_iv"));
                    } catch (Exception e17) {
                        throw new VivoPushException("getMetaValue error " + e17.getMessage());
                    }
                }
                throw new VivoPushException("Permissions is null!");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e18) {
            throw new VivoPushException(e18.getMessage());
        }
    }

    public static long a(Context context, String str) {
        Object a16 = a(context, str, "com.vivo.push.sdk_version");
        if (a16 == null) {
            a16 = a(context, str, "sdk_version");
        }
        if (a16 != null) {
            try {
                return Long.parseLong(a16.toString());
            } catch (Exception e16) {
                e16.printStackTrace();
                u.a("Utility", "getSdkVersionCode error ", e16);
                return -1L;
            }
        }
        u.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00f5 A[Catch: Exception -> 0x00f1, TryCatch #7 {Exception -> 0x00f1, blocks: (B:77:0x00ed, B:65:0x00f5, B:67:0x00f9), top: B:76:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) {
        Throwable th5;
        ContentProviderClient contentProviderClient;
        Cursor cursor = null;
        try {
            try {
                try {
                } catch (Exception e16) {
                    e = e16;
                    contentProviderClient = null;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
                    }
                    if (0 == 0) {
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e17) {
                        u.a("Utility", "close", e17);
                        throw th5;
                    }
                }
                if (0 == 0) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        ((ContentProviderClient) null).close();
                        throw th5;
                    }
                    throw th5;
                }
                throw th5;
            }
        } catch (Exception e18) {
            u.a("Utility", "close", e18);
        }
        if (context == null) {
            u.a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        int i3 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName, 0).versionCode;
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 24) {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = com.vivo.push.x.f387938b;
            contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
            if (contentProviderClient != null) {
                try {
                    u.a("Utility", "client is null");
                    cursor = contentProviderClient.query(uri, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"341", packageName, String.valueOf(i3)}, null);
                } catch (Exception e19) {
                    e = e19;
                    u.a("Utility", "isSupport", e);
                    if (0 != 0) {
                        cursor.close();
                    }
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                    return false;
                }
            }
        } else {
            contentProviderClient = null;
        }
        if (cursor == null) {
            cursor = ContactsMonitor.query(context.getContentResolver(), com.vivo.push.x.f387938b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"341", packageName, String.valueOf(i3)}, null);
        }
        if (cursor == null) {
            u.a("Utility", "cursor is null");
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e26) {
                    u.a("Utility", "close", e26);
                }
            }
            if (contentProviderClient != null && i16 >= 24) {
                contentProviderClient.close();
            }
            return false;
        }
        if (cursor.moveToFirst() && (cursor.getInt(cursor.getColumnIndex(QCircleDaTongConstant.ElementParamValue.PERMISSION)) & 1) != 0) {
            try {
                cursor.close();
                if (contentProviderClient != null && i16 >= 24) {
                    contentProviderClient.close();
                }
            } catch (Exception e27) {
                u.a("Utility", "close", e27);
            }
            return true;
        }
        cursor.close();
        if (contentProviderClient != null && i16 >= 24) {
            contentProviderClient.close();
        }
        return false;
    }

    public static Object a(Context context, String str, String str2) {
        Object obj;
        Bundle bundle;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, Bundle> map = f387886f;
            Object obj2 = (map == null || map.size() <= 0 || (bundle = f387886f.get(str)) == null) ? null : bundle.get(str2);
            if (obj2 != null) {
                return obj2;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                obj = r0 != null ? r0.get(str2) : obj2;
            } catch (Exception e16) {
                e = e16;
                r0 = obj2;
            }
            try {
                if (f387886f.size() > 300) {
                    return obj;
                }
                f387886f.put(str, r0);
                return obj;
            } catch (Exception e17) {
                r0 = obj;
                e = e17;
                u.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                return r0;
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    public static int c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int a16 = (int) a(context, str);
            return a16 <= 0 ? g(context, str) : a16;
        }
        u.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f387881a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    private static void a(Context context, String str, String str2, boolean z16) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z16) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (it.hasNext()) {
                        if (str2.equals(it.next().activityInfo.name)) {
                            return;
                        }
                    }
                    throw new VivoPushException(str2 + " is missing");
                }
                throw new VivoPushException("checkModule " + intent + " has no receivers");
            }
            List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(packageManager, intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (str2.equals(resolveInfo.serviceInfo.name)) {
                        if (resolveInfo.serviceInfo.exported) {
                            return;
                        }
                        throw new VivoPushException(resolveInfo.serviceInfo.name + " exported is false");
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            }
            throw new VivoPushException("checkModule " + intent + " has no services");
        } catch (Exception e16) {
            u.a("Utility", "error  " + e16.getMessage());
            throw new VivoPushException("checkModule error" + e16.getMessage());
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) SystemProperties.class.getMethod("get", String.class).invoke(null, str);
        } catch (Exception e16) {
            e16.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static void a(Context context, Intent intent) {
        String a16 = aa.a(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(a16)) {
            u.a("Utility", "illegality abe adapter : push pkg is null");
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            u.a("Utility", "illegality abe adapter : src pkg is null");
            return;
        }
        if (a16.equals(context.getPackageName())) {
            u.a("Utility", "illegality abe adapter : abe is not pushservice");
            return;
        }
        if (!a16.equals(stringExtra)) {
            u.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + a16);
            intent.setPackage(a16);
            intent.setClassName(a16, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
            return;
        }
        u.a("Utility", "illegality abe adapter : pushPkg = " + a16 + " ; srcPkg = " + stringExtra);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00de A[Catch: Exception -> 0x00da, TryCatch #3 {Exception -> 0x00da, blocks: (B:71:0x00d6, B:59:0x00de, B:61:0x00e2), top: B:70:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2, long j3) {
        Throwable th5;
        ContentProviderClient contentProviderClient;
        Cursor cursor = null;
        try {
            try {
                try {
                } catch (Exception e16) {
                    e = e16;
                    contentProviderClient = null;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
                    }
                    if (0 == 0) {
                    }
                }
            } catch (Exception e17) {
                u.a("Utility", "close", e17);
            }
            if (context == null) {
                u.a("Utility", "context is null");
                return false;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = com.vivo.push.x.f387939c;
                contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                if (contentProviderClient != null) {
                    try {
                        u.a("Utility", "client is null");
                        cursor = contentProviderClient.query(uri, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j3)}, null);
                    } catch (Exception e18) {
                        e = e18;
                        u.a("Utility", "isOverdue", e);
                        if (0 != 0) {
                            cursor.close();
                        }
                        if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient.close();
                        }
                        return false;
                    }
                }
            } else {
                contentProviderClient = null;
            }
            if (cursor == null) {
                cursor = ContactsMonitor.query(context.getContentResolver(), com.vivo.push.x.f387939c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j3)}, null);
            }
            if (cursor == null) {
                u.a("Utility", "cursor is null");
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e19) {
                        u.a("Utility", "close", e19);
                    }
                }
                if (contentProviderClient != null && i3 >= 24) {
                    contentProviderClient.close();
                }
                return false;
            }
            if (cursor.moveToFirst()) {
                boolean parseBoolean = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("clientState")));
                try {
                    cursor.close();
                    if (contentProviderClient != null && i3 >= 24) {
                        contentProviderClient.close();
                    }
                } catch (Exception e26) {
                    u.a("Utility", "close", e26);
                }
                return parseBoolean;
            }
            cursor.close();
            if (contentProviderClient != null && i3 >= 24) {
                contentProviderClient.close();
            }
            return false;
        } catch (Throwable th7) {
            th5 = th7;
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e27) {
                    u.a("Utility", "close", e27);
                    throw th5;
                }
            }
            if (0 == 0) {
                if (Build.VERSION.SDK_INT >= 24) {
                    ((ContentProviderClient) null).close();
                    throw th5;
                }
                throw th5;
            }
            throw th5;
        }
    }

    public static boolean a(Context context, String str, boolean z16) {
        Cursor a16;
        Cursor cursor = null;
        try {
            try {
                try {
                    Uri uri = com.vivo.push.x.f387941e;
                    String[] strArr = new String[2];
                    strArr[0] = str;
                    strArr[1] = z16 ? "1" : "0";
                    a16 = a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
                } catch (Exception e16) {
                    u.a("Utility", "close", e16);
                }
            } catch (Exception e17) {
                u.a("Utility", "syncAgreePrivacyStatement", e17);
                if (0 != 0) {
                    cursor.close();
                }
            }
            if (a16 == null) {
                u.a("Utility", "cursor is null");
                if (a16 != null) {
                    try {
                        a16.close();
                    } catch (Exception e18) {
                        u.a("Utility", "close", e18);
                    }
                }
                return false;
            }
            if (a16.moveToFirst()) {
                boolean parseBoolean = Boolean.parseBoolean(a16.getString(a16.getColumnIndex("agreePrivacyStatement")));
                try {
                    a16.close();
                } catch (Exception e19) {
                    u.a("Utility", "close", e19);
                }
                return parseBoolean;
            }
            a16.close();
            return false;
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e26) {
                    u.a("Utility", "close", e26);
                }
            }
            throw th5;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0088: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:49:0x0088 */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Cursor a(Uri uri, String str, String[] strArr, Context context) {
        ContentProviderClient contentProviderClient;
        ContentProviderClient contentProviderClient2;
        Cursor cursor;
        ContentProviderClient contentProviderClient3 = null;
        try {
            try {
                if (context == null) {
                    u.a("Utility", "context is null");
                    return null;
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 24) {
                    contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                    if (contentProviderClient != null) {
                        try {
                            u.a("Utility", "client is null");
                            cursor = contentProviderClient.query(uri, null, str, strArr, null);
                        } catch (Exception e16) {
                            e = e16;
                            u.a("Utility", "queryContentResolver", e);
                            if (contentProviderClient != null) {
                                try {
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        contentProviderClient.close();
                                    }
                                } catch (Exception e17) {
                                    u.a("Utility", "close", e17);
                                }
                            }
                            return null;
                        }
                    } else {
                        cursor = null;
                    }
                } else {
                    contentProviderClient = null;
                    cursor = null;
                }
                if (cursor == null) {
                    cursor = ContactsMonitor.query(context.getContentResolver(), uri, null, str, strArr, null);
                }
                if (cursor != null) {
                    if (contentProviderClient != null && i3 >= 24) {
                        try {
                            contentProviderClient.close();
                        } catch (Exception e18) {
                            u.a("Utility", "close", e18);
                        }
                    }
                    return cursor;
                }
                u.a("Utility", "cursor is null");
                if (contentProviderClient != null && i3 >= 24) {
                    try {
                        contentProviderClient.close();
                    } catch (Exception e19) {
                        u.a("Utility", "close", e19);
                    }
                }
                return null;
            } catch (Exception e26) {
                e = e26;
                contentProviderClient = null;
            } catch (Throwable th5) {
                th = th5;
                Throwable th6 = th;
                if (contentProviderClient3 == null) {
                }
            }
        } catch (Throwable th7) {
            th = th7;
            contentProviderClient3 = contentProviderClient2;
            Throwable th62 = th;
            if (contentProviderClient3 == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient3.close();
                        throw th62;
                    }
                    throw th62;
                } catch (Exception e27) {
                    u.a("Utility", "close", e27);
                    throw th62;
                }
            }
            throw th62;
        }
    }
}
