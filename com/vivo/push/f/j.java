package com.vivo.push.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class j extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.vivo.push.v vVar) {
        super(vVar);
    }

    public static boolean a(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(context.getPackageManager(), intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                com.vivo.push.util.u.d("OnChangePushStatusTask", "enableService push service.");
                return true;
            }
            com.vivo.push.util.u.d("OnChangePushStatusTask", "push service has enabled");
            return false;
        }
        com.vivo.push.util.u.a("OnChangePushStatusTask", "enableService error: can not find push service.");
        return false;
    }

    public static boolean b(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(context.getPackageManager(), intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                com.vivo.push.util.u.d("OnChangePushStatusTask", "disableService push service.");
                return true;
            }
            com.vivo.push.util.u.d("OnChangePushStatusTask", "push service has disabled");
            return false;
        }
        com.vivo.push.util.u.a("OnChangePushStatusTask", "disableService error: can not find push service.");
        return false;
    }

    private static List<ResolveInfo> c(Context context) {
        List<ResolveInfo> list;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
        } catch (Exception unused) {
            list = null;
        }
        if (list == null || list.size() <= 0) {
            Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
            intent2.setPackage(context.getPackageName());
            try {
                return context.getPackageManager().queryBroadcastReceivers(intent2, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
            } catch (Exception unused2) {
                return list;
            }
        }
        return list;
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        if (this.f387838a.getPackageName().equals(com.vivo.push.util.aa.a(this.f387838a))) {
            return;
        }
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) vVar;
        int d16 = jVar.d();
        int e16 = jVar.e();
        com.vivo.push.util.u.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + d16 + " ; receiverStatus is " + e16);
        if (d16 == 2) {
            b(this.f387838a);
        } else if (d16 == 1) {
            a(this.f387838a);
        } else if (d16 == 0) {
            Context context = this.f387838a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(context.getPackageManager(), intent, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 0) {
                    packageManager.setComponentEnabledSetting(componentName, 0, 1);
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "push service has defaulted");
                }
            } else {
                com.vivo.push.util.u.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            }
        }
        if (e16 == 2) {
            Context context2 = this.f387838a;
            List<ResolveInfo> c16 = c(context2);
            if (c16 != null && c16.size() > 0) {
                String str = c16.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager2 = context2.getPackageManager();
                ComponentName componentName2 = new ComponentName(context2, str);
                if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                    packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "push service disableReceiver ");
                    return;
                } else {
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "push service has disableReceiver ");
                    return;
                }
            }
            com.vivo.push.util.u.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            return;
        }
        if (e16 == 1) {
            Context context3 = this.f387838a;
            List<ResolveInfo> c17 = c(context3);
            if (c17 != null && c17.size() > 0) {
                String str2 = c17.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str2)) {
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager3 = context3.getPackageManager();
                ComponentName componentName3 = new ComponentName(context3, str2);
                if (packageManager3.getComponentEnabledSetting(componentName3) != 1) {
                    packageManager3.setComponentEnabledSetting(componentName3, 1, 1);
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "push service enableReceiver ");
                    return;
                } else {
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "push service has enableReceiver ");
                    return;
                }
            }
            com.vivo.push.util.u.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
            return;
        }
        if (e16 == 0) {
            Context context4 = this.f387838a;
            List<ResolveInfo> c18 = c(context4);
            if (c18 != null && c18.size() > 0) {
                String str3 = c18.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager4 = context4.getPackageManager();
                ComponentName componentName4 = new ComponentName(context4, str3);
                if (packageManager4.getComponentEnabledSetting(componentName4) != 0) {
                    packageManager4.setComponentEnabledSetting(componentName4, 0, 1);
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "push service defaultReceiver ");
                    return;
                } else {
                    com.vivo.push.util.u.d("OnChangePushStatusTask", "push service has defaulted");
                    return;
                }
            }
            com.vivo.push.util.u.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
        }
    }
}
