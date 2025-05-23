package com.vivo.push.util;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f387866a;

    /* renamed from: b, reason: collision with root package name */
    private static String f387867b;

    public static com.vivo.push.model.b a(Context context, o oVar) {
        com.vivo.push.model.b bVar;
        com.vivo.push.model.b f16;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.b c16 = c(applicationContext);
        if (c16 != null) {
            u.d("PushPackageUtils", "get system push info :".concat(String.valueOf(c16)));
            return c16;
        }
        List<String> a16 = oVar.a(applicationContext);
        com.vivo.push.model.b f17 = f(applicationContext, applicationContext.getPackageName());
        if (a16 != null && a16.size() > 0) {
            com.vivo.push.model.b bVar2 = null;
            String a17 = af.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(a17) || !a(applicationContext, a17, "com.vivo.pushservice.action.METHOD") || (bVar = f(applicationContext, a17)) == null || !bVar.d()) {
                bVar = null;
            }
            if (f17 == null || !f17.d()) {
                f17 = null;
            }
            if (bVar == null) {
                bVar = null;
            }
            if (f17 == null || (bVar != null && (!f17.c() ? !(bVar.c() || f17.b() > bVar.b()) : !(bVar.c() && f17.b() > bVar.b())))) {
                f17 = bVar;
            }
            HashMap hashMap = new HashMap();
            if (f17 == null) {
                f17 = null;
            } else if (f17.c()) {
                bVar2 = f17;
                f17 = null;
            }
            int size = a16.size();
            for (int i3 = 0; i3 < size; i3++) {
                String str = a16.get(i3);
                if (!TextUtils.isEmpty(str) && (f16 = f(applicationContext, str)) != null) {
                    hashMap.put(str, f16);
                    if (f16.d()) {
                        if (f16.c()) {
                            if (bVar2 == null || f16.b() > bVar2.b()) {
                                bVar2 = f16;
                            }
                        } else if (f17 == null || f16.b() > f17.b()) {
                            f17 = f16;
                        }
                    }
                }
            }
            if (f17 == null) {
                u.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                f17 = bVar2;
            }
        } else {
            if (f17 != null && f17.d()) {
                c16 = f17;
            }
            u.a("PushPackageUtils", "findAllPushPackages error: find no package!");
            f17 = c16;
        }
        if (f17 != null) {
            if (f17.c()) {
                u.a(applicationContext, "\u67e5\u627e\u6700\u4f18\u5305\u4e3a:" + f17.a() + "(" + f17.b() + ", Black)");
                u.d("PushPackageUtils", "finSuitablePushPackage" + f17.a() + "(" + f17.b() + ", Black)");
            } else {
                u.a(applicationContext, "\u67e5\u627e\u6700\u4f18\u5305\u4e3a:" + f17.a() + "(" + f17.b() + ")");
                u.d("PushPackageUtils", "finSuitablePushPackage" + f17.a() + "(" + f17.b() + ")");
            }
        } else {
            u.b(applicationContext, "\u67e5\u627e\u6700\u4f18\u5305\u4e3a\u7a7a!");
            u.d("PushPackageUtils", "finSuitablePushPackage is null");
        }
        return f17;
    }

    public static boolean b(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = f387866a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        f387866a = valueOf;
        return valueOf.booleanValue();
    }

    private static com.vivo.push.model.b c(Context context) {
        String a16 = a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(a16)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(a16);
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), a16, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(ag.a(context, a16));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, a16));
            return bVar;
        } catch (Exception e16) {
            e16.printStackTrace();
            u.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e16);
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static com.vivo.push.model.b f(Context context, String str) {
        boolean z16;
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (!a(context, str, "com.vivo.pushservice.action.METHOD") && !a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
                try {
                    PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 128);
                    if (packageInfo != null) {
                        bVar.a(packageInfo.versionCode);
                        bVar.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        bVar.a(ag.a(context, str));
                    }
                    bVar.b(a(context, str));
                    bVar.a(a(context, bVar.b()));
                    return bVar;
                } catch (Exception e16) {
                    u.a("PushPackageUtils", "getPushPackageInfo exception: ", e16);
                }
            }
        }
        return null;
    }

    private static String g(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
                byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b16 : digest) {
                    String upperCase = Integer.toHexString(b16 & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e16) {
                u.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e16)));
            }
        }
        return null;
    }

    public static int b(Context context, String str) {
        int i3 = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i3;
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0109 A[Catch: Exception -> 0x00f3, TRY_ENTER, TryCatch #10 {Exception -> 0x00f3, blocks: (B:62:0x00e6, B:64:0x00eb, B:66:0x00ef, B:34:0x0109, B:36:0x010e, B:38:0x0112), top: B:7:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e A[Catch: Exception -> 0x00f3, TryCatch #10 {Exception -> 0x00f3, blocks: (B:62:0x00e6, B:64:0x00eb, B:66:0x00ef, B:34:0x0109, B:36:0x010e, B:38:0x0112), top: B:7:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        ContentProviderClient contentProviderClient;
        int i3;
        Cursor cursor;
        if (!TextUtils.isEmpty(f387867b)) {
            return f387867b;
        }
        Cursor cursor2 = null;
        try {
        } catch (Exception e16) {
            u.a("PushPackageUtils", "close", e16);
        }
        try {
            try {
                i3 = Build.VERSION.SDK_INT;
                if (i3 >= 24) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uri = com.vivo.push.x.f387937a;
                    contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    if (contentProviderClient != null) {
                        try {
                            u.a("PushPackageUtils", "client is null");
                            cursor = contentProviderClient.query(uri, null, null, null, null);
                        } catch (Exception e17) {
                            e = e17;
                            str = null;
                            u.a("PushPackageUtils", "getSystemPush", e);
                            if (cursor2 != null) {
                            }
                            if (contentProviderClient != null) {
                                contentProviderClient.close();
                            }
                            return str;
                        }
                    } else {
                        cursor = null;
                    }
                } else {
                    contentProviderClient = null;
                    cursor = null;
                }
                if (cursor == null) {
                    try {
                        try {
                            cursor = ContactsMonitor.query(context.getContentResolver(), com.vivo.push.x.f387937a, null, null, null, null);
                        } catch (Exception e18) {
                            e = e18;
                            str = null;
                            cursor2 = cursor;
                            u.a("PushPackageUtils", "getSystemPush", e);
                            if (cursor2 != null) {
                            }
                            if (contentProviderClient != null) {
                            }
                            return str;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e19) {
                                u.a("PushPackageUtils", "close", e19);
                                throw th;
                            }
                        }
                        if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                            contentProviderClient.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e26) {
                e = e26;
                str = null;
                contentProviderClient = null;
            } catch (Throwable th6) {
                th = th6;
                contentProviderClient = null;
            }
            if (cursor == null) {
                u.a("PushPackageUtils", "cursor is null");
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e27) {
                        u.a("PushPackageUtils", "close", e27);
                    }
                }
                if (contentProviderClient != null && i3 >= 24) {
                    contentProviderClient.close();
                }
                return null;
            }
            boolean z16 = false;
            str = null;
            while (cursor.moveToNext()) {
                try {
                    if ("pushPkgName".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                        str = cursor.getString(cursor.getColumnIndex("value"));
                    } else if ("pushEnable".equals(cursor.getString(cursor.getColumnIndex("name")))) {
                        z16 = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("value")));
                    }
                } catch (Exception e28) {
                    e = e28;
                    cursor2 = cursor;
                    u.a("PushPackageUtils", "getSystemPush", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                    return str;
                }
            }
            f387867b = str;
            if (TextUtils.isEmpty(str)) {
                try {
                    cursor.close();
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                } catch (Exception e29) {
                    u.a("PushPackageUtils", "close", e29);
                }
                return null;
            }
            if (!z16) {
                try {
                    cursor.close();
                    if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                } catch (Exception e36) {
                    u.a("PushPackageUtils", "close", e36);
                }
                return null;
            }
            cursor.close();
            if (contentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                contentProviderClient.close();
            }
            return str;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(packageManager, intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                int size = queryIntentServices.size();
                boolean z16 = false;
                for (int i3 = 0; i3 < size; i3++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i3);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z17 = serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z17) {
                            boolean z18 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            z16 = componentEnabledSetting == 1 || (componentEnabledSetting == 0 && z18);
                        }
                    }
                }
                return z16;
            }
            u.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, long j3) {
        com.vivo.push.cache.d a16 = com.vivo.push.cache.b.a().a(context);
        if (a16 != null) {
            return a16.isInBlackList(j3);
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
        } catch (Exception unused) {
            list = null;
        }
        return list != null && list.size() > 0;
    }
}
