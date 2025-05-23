package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.raft.raftframework.sla.SLAReporter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.xiaomi.push.ii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class m {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f388070a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f388071b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f388072c;

        /* renamed from: d, reason: collision with root package name */
        public String f388073d;

        public b(String str, boolean z16, boolean z17, String str2) {
            this.f388070a = str;
            this.f388071b = z16;
            this.f388072c = z17;
            this.f388073d = str2;
        }
    }

    private static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void b(final Context context) {
        new BaseThread(new Runnable() { // from class: com.xiaomi.mipush.sdk.m.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), com.tencent.mobileqq.msf.core.c0.g.f247750t1);
                    m.j(context);
                    m.l(context, packageInfo);
                    m.k(context, packageInfo);
                } catch (Throwable th5) {
                    Log.e("ManifestChecker", "", th5);
                }
            }
        }).start();
    }

    private static void d(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && !TextUtils.isEmpty(activityInfo.name) && activityInfo.name.equals(str2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                break;
            }
        }
        if (z16) {
        } else {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }

    private static void e(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() == activityInfo.enabled) {
            if (boolArr[1].booleanValue() == activityInfo.exported) {
                return;
            } else {
                throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
            }
        }
        throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
    }

    private static boolean f(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (g(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean g(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5 A[EDGE_INSN: B:23:0x00a5->B:24:0x00a5 BREAK  A[LOOP:0: B:8:0x0071->B:37:0x0071], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(com.xiaomi.push.service.r.f389788o);
        intent.setPackage(packageName);
        try {
            ActivityInfo a16 = a(packageManager, intent, ii.c(context, "com.xiaomi.push.service.receivers.PingReceiver"));
            if (!MiPushClient.e0(context)) {
                if (a16 != null) {
                    e(a16, new Boolean[]{Boolean.TRUE, Boolean.FALSE});
                } else {
                    throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", "com.xiaomi.push.service.receivers.PingReceiver"));
                }
            } else if (a16 != null) {
                e(a16, new Boolean[]{Boolean.TRUE, Boolean.FALSE});
            }
        } catch (ClassNotFoundException e16) {
            jz4.c.q(e16);
        }
        Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent2.setPackage(packageName);
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent2, 16384).iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null) {
                try {
                } catch (ClassNotFoundException e17) {
                    jz4.c.q(e17);
                }
                if (!TextUtils.isEmpty(activityInfo.name) && PushMessageReceiver.class.isAssignableFrom(ii.c(context, activityInfo.name)) && activityInfo.enabled) {
                    z16 = true;
                    if (!z16) {
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        if (z16) {
            if (MiPushClient.B(context)) {
                d(context, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
                d(context, "com.huawei.intent.action.PUSH", "com.huawei.hms.support.api.push.PushEventReceiver");
            }
            if (MiPushClient.D(context)) {
                d(context, "com.vivo.pushclient.action.RECEIVE", "com.xiaomi.assemble.control.FTOSPushMessageReceiver");
                return;
            }
            return;
        }
        throw new a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(Context context, PackageInfo packageInfo) {
        boolean z16;
        HashSet hashSet = new HashSet();
        String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(Arrays.asList(SLAReporter.PERMISSION_NET, "android.permission.ACCESS_NETWORK_STATE", str, "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE"));
        PermissionInfo[] permissionInfoArr = packageInfo.permissions;
        if (permissionInfoArr != null) {
            for (PermissionInfo permissionInfo : permissionInfoArr) {
                if (str.equals(permissionInfo.name)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            String[] strArr = packageInfo.requestedPermissions;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                        hashSet.remove(str2);
                        if (hashSet.isEmpty()) {
                            break;
                        }
                    }
                }
            }
            if (hashSet.isEmpty()) {
                return;
            } else {
                throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator().next()));
            }
        }
        throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
        hashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!MiPushClient.e0(context) || f(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (MiPushClient.A(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (MiPushClient.C(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    b bVar = (b) hashMap2.remove(serviceInfo.name);
                    boolean z16 = bVar.f388071b;
                    boolean z17 = bVar.f388072c;
                    String str = bVar.f388073d;
                    if (z16 == serviceInfo.enabled) {
                        if (z17 == serviceInfo.exported) {
                            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, serviceInfo.permission)) {
                                throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                            }
                            hashMap.put(serviceInfo.name, serviceInfo.processName);
                            if (hashMap2.isEmpty()) {
                                break;
                            }
                        } else {
                            throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, Boolean.valueOf(z17)));
                        }
                    } else {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, Boolean.valueOf(z16)));
                    }
                }
            }
        }
        if (hashMap2.isEmpty()) {
            if (TextUtils.equals((CharSequence) hashMap.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) hashMap.get(MessageHandleService.class.getCanonicalName()))) {
                if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
                    throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
                }
                return;
            }
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()));
        }
        throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", hashMap2.keySet().iterator().next()));
    }
}
