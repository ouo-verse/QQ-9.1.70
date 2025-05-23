package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class RelationBootMonitor {
    private static final List<String> APP_AUTHORITIES;
    private static final Object LOCK;
    private static final ArrayList<String> SPECIAL_ACTION;
    private static final String TAG = "RelationBootMonitor";
    private static volatile boolean isInitList;
    private static RelationBootListener relationBootListener;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface RelationBootListener {
        void monitor(int i3, String str, String str2, Throwable th5);
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        SPECIAL_ACTION = arrayList;
        APP_AUTHORITIES = new ArrayList();
        LOCK = new Object();
        isInitList = false;
        arrayList.add("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        arrayList.add("com.android.launcher.action.UNINSTALL_SHORTCUT");
        arrayList.add("com.android.launcher.action.INSTALL_SHORTCUT");
        arrayList.add("android.hardware.action.NEW_PICTURE");
        arrayList.add("com.android.music.metachanged");
    }

    RelationBootMonitor() {
    }

    public static boolean bindService(Object obj, Intent intent, ServiceConnection serviceConnection, int i3) {
        if (obj instanceof Context) {
            inspectIntent(11, intent);
            return ((Context) obj).bindService(intent, serviceConnection, i3);
        }
        return ((Boolean) com.tencent.qmethod.pandoraex.core.t.b(obj, "bindService", new Class[]{Intent.class, ServiceConnection.class, Integer.TYPE}, intent, serviceConnection, Integer.valueOf(i3))).booleanValue();
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    private static boolean canBroadcastBeReceivedByExternalApp(String str) {
        ActivityInfo activityInfo;
        if (com.tencent.qmethod.pandoraex.api.q.b() == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryBroadcastReceivers = com.tencent.qmethod.pandoraex.api.q.b().getPackageManager().queryBroadcastReceivers(new Intent(str), 0);
            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                String packageName = com.tencent.qmethod.pandoraex.api.q.b().getPackageName();
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && !activityInfo.packageName.equals(packageName)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "find ipc error", th5);
            return false;
        }
    }

    private static void getRegisteredAuthorities() {
        if (com.tencent.qmethod.pandoraex.api.q.b() == null) {
            return;
        }
        try {
            ProviderInfo[] providerInfoArr = com.tencent.qmethod.pandoraex.api.q.b().getPackageManager().getPackageInfo(com.tencent.qmethod.pandoraex.api.q.b().getPackageName(), 8).providers;
            if (providerInfoArr != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    String str = providerInfo.authority;
                    if (str != null) {
                        APP_AUTHORITIES.add(str);
                        com.tencent.qmethod.pandoraex.core.o.a(TAG, "add:" + providerInfo.authority);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e16) {
            com.tencent.qmethod.pandoraex.core.o.b(TAG, "No Provider", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void inspectBroadcast(String str, String str2, Throwable th5) {
        if (!SPECIAL_ACTION.contains(str) && !canBroadcastBeReceivedByExternalApp(str)) {
            com.tencent.qmethod.pandoraex.core.o.a(TAG, "ignore action:" + str);
            return;
        }
        RelationBootListener relationBootListener2 = relationBootListener;
        if (relationBootListener2 != null) {
            relationBootListener2.monitor(10, str, str2, th5);
        }
    }

    private static void inspectIntent(int i3, Intent intent) {
        try {
            inspectIntentInner(i3, intent, null);
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "inspectIntent error", th5);
        }
    }

    private static void inspectIntentInner(int i3, Intent intent, Uri uri) {
        if (relationBootListener == null) {
            return;
        }
        if (i3 == 10) {
            if (intent != null && intent.getAction() != null) {
                final String action = intent.getAction();
                final Throwable th5 = new Throwable();
                final String replace = intent.toString().replace(AutoStartMonitor.BUNDLE_REPLACE_TEXT, AutoStartMonitor.getBundleDataShort(intent.getExtras()));
                com.tencent.qmethod.pandoraex.core.h.a().post(new Runnable() { // from class: com.tencent.qmethod.pandoraex.monitor.RelationBootMonitor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RelationBootMonitor.inspectBroadcast(action, replace, th5);
                    }
                });
                return;
            }
            return;
        }
        if (i3 == 11) {
            final String str = intent.getPackage();
            if (!TextUtils.isEmpty(str) && !InstalledAppListMonitor.isSelfPackageName(str)) {
                final Throwable th6 = new Throwable();
                final String replace2 = intent.toString().replace(AutoStartMonitor.BUNDLE_REPLACE_TEXT, AutoStartMonitor.getBundleDataShort(intent.getExtras()));
                com.tencent.qmethod.pandoraex.core.h.a().post(new Runnable() { // from class: com.tencent.qmethod.pandoraex.monitor.RelationBootMonitor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RelationBootMonitor.inspectService(str, replace2, th6);
                    }
                });
                return;
            }
            return;
        }
        if (i3 == 12) {
            processProvider(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void inspectProvider(String str, Throwable th5) {
        RelationBootListener relationBootListener2 = relationBootListener;
        if (relationBootListener2 != null) {
            relationBootListener2.monitor(12, str, "", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void inspectService(String str, String str2, Throwable th5) {
        RelationBootListener relationBootListener2 = relationBootListener;
        if (relationBootListener2 != null) {
            relationBootListener2.monitor(11, str, str2, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void inspectUri(int i3, Uri uri) {
        try {
            inspectIntentInner(i3, null, uri);
        } catch (Throwable th5) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "inspectIntent error", th5);
        }
    }

    private static void processProvider(Uri uri) {
        if (uri == null) {
            return;
        }
        if (!isInitList) {
            synchronized (LOCK) {
                if (!isInitList) {
                    getRegisteredAuthorities();
                    isInitList = true;
                }
            }
        }
        final String authority = uri.getAuthority();
        if (!APP_AUTHORITIES.contains(authority)) {
            final Throwable th5 = new Throwable();
            com.tencent.qmethod.pandoraex.core.h.a().post(new Runnable() { // from class: com.tencent.qmethod.pandoraex.monitor.RelationBootMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    RelationBootMonitor.inspectProvider(authority, th5);
                }
            });
        }
    }

    public static void sendBroadcast(Object obj, Intent intent) {
        if (!(obj instanceof Context)) {
            com.tencent.qmethod.pandoraex.core.t.b(obj, "sendBroadcast", new Class[]{Intent.class}, intent);
        } else {
            inspectIntent(10, intent);
            ((Context) obj).sendBroadcast(intent);
        }
    }

    public static void setListener(RelationBootListener relationBootListener2) {
        relationBootListener = relationBootListener2;
    }

    public static ComponentName startService(Object obj, Intent intent) {
        if (obj instanceof Context) {
            inspectIntent(11, intent);
            return ((Context) obj).startService(intent);
        }
        return (ComponentName) com.tencent.qmethod.pandoraex.core.t.b(obj, "startService", new Class[]{Intent.class}, intent);
    }

    public static void sendBroadcast(Object obj, Intent intent, String str) {
        if (!(obj instanceof Context)) {
            com.tencent.qmethod.pandoraex.core.t.b(obj, "sendBroadcast", new Class[]{Intent.class, String.class}, intent, str);
        } else {
            inspectIntent(10, intent);
            ((Context) obj).sendBroadcast(intent, str);
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean bindService(Object obj, Intent intent, int i3, Executor executor, ServiceConnection serviceConnection) {
        boolean bindService;
        if (obj instanceof Context) {
            inspectIntent(11, intent);
            bindService = ((Context) obj).bindService(intent, i3, executor, serviceConnection);
            return bindService;
        }
        return ((Boolean) com.tencent.qmethod.pandoraex.core.t.b(obj, "bindService", new Class[]{Intent.class, Integer.TYPE, Executor.class, ServiceConnection.class}, intent, Integer.valueOf(i3), executor, serviceConnection)).booleanValue();
    }
}
