package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.xiaomi.push.ge;
import com.xiaomi.push.gk;
import com.xiaomi.push.hz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    private static Context f389728c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f389729d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f389730e;

    /* renamed from: f, reason: collision with root package name */
    private static WeakHashMap<Integer, j> f389731f = new WeakHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private String f389732a;

    /* renamed from: b, reason: collision with root package name */
    private String f389733b;

    j(String str) {
        this.f389732a = str;
    }

    private static int a(String str) {
        int packageUid;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                packageUid = f389728c.getPackageManager().getPackageUid(str, 0);
                return packageUid;
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    private static NotificationManager c() {
        return (NotificationManager) f389728c.getSystemService("notification");
    }

    public static j e(Context context, String str) {
        q(context);
        int hashCode = str.hashCode();
        j jVar = f389731f.get(Integer.valueOf(hashCode));
        if (jVar == null) {
            j jVar2 = new j(str);
            f389731f.put(Integer.valueOf(hashCode), jVar2);
            return jVar2;
        }
        return jVar;
    }

    private static <T> T f(Object obj) {
        if (obj != null) {
            try {
                return (T) obj.getClass().getMethod(VasPerfReportUtils.WHILE_GET_LIST, new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private static Object g(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static String j(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String k3 = k("mipush|%s|%s", str2, "");
            if (str.startsWith(k3)) {
                return k("mipush_%s_%s", str2, str.replace(k3, ""));
            }
            return str;
        }
        return str;
    }

    private static String k(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(str, str2, str3);
    }

    private static void q(Context context) {
        boolean z16;
        if (f389728c == null) {
            f389728c = context.getApplicationContext();
            NotificationManager c16 = c();
            Boolean bool = (Boolean) com.xiaomi.push.y.e(c16, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            r("fwk is support.init:" + bool);
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            f389730e = z16;
            if (z16) {
                f389729d = com.xiaomi.push.y.e(c16, "getService", new Object[0]);
            }
        }
    }

    static void r(String str) {
        jz4.c.m("NMHelper:" + str);
    }

    private static boolean s() {
        if (!hz.i() || !ah.d(f389728c).m(gk.NotificationBelongToAppSwitch.a(), true)) {
            return false;
        }
        return f389730e;
    }

    public static boolean t(Context context) {
        q(context);
        return s();
    }

    private String w(String str) {
        return x(this.f389732a, str);
    }

    public static String x(String str, String str2) {
        String str3;
        if (s()) {
            str3 = "mipush|%s|%s";
        } else {
            str3 = "mipush_%s_%s";
        }
        return k(str3, str, str2);
    }

    @TargetApi(26)
    public NotificationChannel b(String str) {
        NotificationChannel notificationChannel;
        String id5;
        NotificationChannel notificationChannel2 = null;
        try {
            if (!s()) {
                notificationChannel = c().getNotificationChannel(str);
                notificationChannel2 = notificationChannel;
            } else {
                List<NotificationChannel> l3 = l();
                if (l3 != null) {
                    for (NotificationChannel notificationChannel3 : l3) {
                        id5 = notificationChannel3.getId();
                        if (str.equals(id5)) {
                            notificationChannel2 = notificationChannel3;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e16) {
            r("getNotificationChannel error" + e16);
        }
        return notificationChannel2;
    }

    public Context d() {
        return f389728c;
    }

    public String h() {
        return this.f389732a;
    }

    public String i(String str) {
        if (TextUtils.isEmpty(str)) {
            return v();
        }
        if (hz.j(d())) {
            return w(str);
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @TargetApi(26)
    public List<NotificationChannel> l() {
        String str;
        String id5;
        String str2 = this.f389732a;
        List<NotificationChannel> list = null;
        try {
            if (!s()) {
                list = c().getNotificationChannels();
                str = "mipush_%s_%s";
            } else {
                int a16 = a(str2);
                if (a16 != -1) {
                    Object obj = f389729d;
                    Object[] objArr = {str2, Integer.valueOf(a16), Boolean.FALSE};
                    str = "mipush|%s|%s";
                    list = (List) f(com.xiaomi.push.y.e(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            }
            if (hz.i() && list != null) {
                ArrayList arrayList = new ArrayList();
                String k3 = k(str, str2, "");
                for (NotificationChannel notificationChannel : list) {
                    id5 = notificationChannel.getId();
                    if (id5.startsWith(k3)) {
                        arrayList.add(notificationChannel);
                    }
                }
                return arrayList;
            }
            return list;
        } catch (Exception e16) {
            r("getNotificationChannels error " + e16);
            return list;
        }
    }

    public void m(int i3) {
        String str = this.f389732a;
        try {
            if (s()) {
                int c16 = ge.c();
                String packageName = d().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.y.n(f389729d, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i3), Integer.valueOf(c16));
                } else {
                    com.xiaomi.push.y.n(f389729d, "cancelNotificationWithTag", str, null, Integer.valueOf(i3), Integer.valueOf(c16));
                }
                r("cancel succ:" + i3);
                return;
            }
            c().cancel(i3);
        } catch (Exception e16) {
            r("cancel error" + e16);
        }
    }

    public void n(int i3, Notification notification) {
        String str = this.f389732a;
        NotificationManager c16 = c();
        try {
            int i16 = Build.VERSION.SDK_INT;
            if (s()) {
                notification.extras.putString("xmsf_target_package", str);
                if (i16 >= 29) {
                    c16.notifyAsPackage(str, null, i3, notification);
                } else {
                    c16.notify(i3, notification);
                }
            } else {
                c16.notify(i3, notification);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    public void o(NotificationChannel notificationChannel) {
        String str = this.f389732a;
        try {
            if (!s()) {
                c().createNotificationChannel(notificationChannel);
            } else {
                int a16 = a(str);
                if (a16 != -1) {
                    com.xiaomi.push.y.n(f389729d, "createNotificationChannelsForPackage", str, Integer.valueOf(a16), g(Arrays.asList(notificationChannel)));
                }
            }
        } catch (Exception e16) {
            r("createNotificationChannel error" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(NotificationChannel notificationChannel, boolean z16) {
        String str = this.f389732a;
        try {
            if (z16) {
                int a16 = a(str);
                if (a16 != -1) {
                    com.xiaomi.push.y.n(f389729d, "updateNotificationChannelForPackage", str, Integer.valueOf(a16), notificationChannel);
                }
            } else {
                o(notificationChannel);
            }
        } catch (Exception e16) {
            r("updateNotificationChannel error " + e16);
        }
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f389732a + "}";
    }

    public boolean u(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(w(""));
        }
        return false;
    }

    String v() {
        if (TextUtils.isEmpty(this.f389733b)) {
            this.f389733b = w("default");
        }
        return this.f389733b;
    }

    public List<StatusBarNotification> y() {
        String str = this.f389732a;
        NotificationManager c16 = c();
        List<StatusBarNotification> list = null;
        try {
            if (s()) {
                int c17 = ge.c();
                if (c17 != -1) {
                    list = (List) f(com.xiaomi.push.y.e(f389729d, "getAppActiveNotifications", str, Integer.valueOf(c17)));
                }
            } else {
                StatusBarNotification[] activeNotifications = c16.getActiveNotifications();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (str.equals(k.x(statusBarNotification.getNotification()))) {
                                arrayList.add(statusBarNotification);
                            }
                        }
                        list = arrayList;
                    } catch (Throwable th5) {
                        th = th5;
                        list = arrayList;
                        r("getActiveNotifications error " + th);
                        return list;
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z(String str, String str2) {
        if (!s()) {
            return str2;
        }
        return str;
    }
}
