package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.xiaomi.push.gk;
import com.xiaomi.push.hz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@TargetApi(24)
/* loaded from: classes28.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static g f389713b = new g();

    /* renamed from: a, reason: collision with root package name */
    private SpannableString f389714a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        List<c> f389715a;

        /* renamed from: b, reason: collision with root package name */
        List<c> f389716b;

        b() {
            this.f389715a = new ArrayList();
            this.f389716b = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        int f389718a;

        /* renamed from: b, reason: collision with root package name */
        Notification f389719b;

        public c(int i3, Notification notification) {
            this.f389718a = i3;
            this.f389719b = notification;
        }

        public String toString() {
            return "id:" + this.f389718a;
        }
    }

    g() {
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    private PendingIntent b(Context context, String str) {
        PendingIntent activity;
        if (context == null && TextUtils.isEmpty(str)) {
            jz4.c.m("ctx or pkg must not be null in getting launch intent");
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                jz4.c.m("pm must not be null in getting launch intent");
                return null;
            }
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, str);
            if (launchIntentForPackage == null) {
                jz4.c.m("targetIntent must not be null in getting launch intent");
                return null;
            }
            launchIntentForPackage.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 31) {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 33554432);
            } else {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 0);
            }
            return activity;
        } catch (Throwable th5) {
            jz4.c.B("error occurred during getting launch pendingIntent. exception:" + th5);
            return null;
        }
    }

    private SpannableString c(Context context, String str) {
        int i3;
        Resources resources;
        DisplayMetrics displayMetrics;
        int max;
        if (this.f389714a == null) {
            if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null && (max = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) > 0) {
                i3 = max / 16;
            } else {
                i3 = 200;
            }
            if (TextUtils.isEmpty(str)) {
                str = "\u65b0\u6d88\u606f";
            }
            StringBuilder sb5 = new StringBuilder(str.length() + i3 + 12);
            sb5.append(str);
            for (int i16 = 0; i16 < i3; i16++) {
                sb5.append(TokenParser.SP);
            }
            sb5.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb5.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb5.length(), 33);
            this.f389714a = spannableString;
        }
        return this.f389714a;
    }

    public static g d() {
        return f389713b;
    }

    private String e(Notification notification) {
        Bundle bundle;
        if (notification != null && (bundle = notification.extras) != null) {
            return bundle.getString("push_src_group_name");
        }
        return null;
    }

    private List<StatusBarNotification> g(j jVar) {
        List<StatusBarNotification> list;
        if (jVar != null) {
            list = jVar.y();
        } else {
            list = null;
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list;
    }

    private void i(Context context, int i3, Notification notification, boolean z16) {
        Notification notification2;
        String x16 = k.x(notification);
        if (TextUtils.isEmpty(x16)) {
            jz4.c.m("group auto not extract pkg from notification:" + i3);
            return;
        }
        List<StatusBarNotification> g16 = g(j.e(context, x16));
        if (g16 == null) {
            jz4.c.m("group auto not get notifications");
            return;
        }
        String p16 = p(notification);
        HashMap hashMap = new HashMap();
        for (StatusBarNotification statusBarNotification : g16) {
            if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i3) {
                l(hashMap, statusBarNotification);
            }
        }
        for (Map.Entry<String, b> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                b value = entry.getValue();
                if (z16 && key.equals(p16) && !r(notification)) {
                    c cVar = new c(i3, notification);
                    if (n(notification)) {
                        value.f389716b.add(cVar);
                    } else {
                        value.f389715a.add(cVar);
                    }
                }
                int size = value.f389715a.size();
                if (value.f389716b.size() <= 0) {
                    if (z16 && size >= 2) {
                        k(context, x16, key, value.f389715a.get(0).f389719b);
                    }
                } else if (size <= 0) {
                    j(context, x16, key);
                } else if (ah.d(context).m(gk.NotificationGroupUpdateTimeSwitch.a(), false) && (notification2 = value.f389716b.get(0).f389719b) != null) {
                    notification2.when = System.currentTimeMillis();
                    k(context, x16, key, notification2);
                }
            }
        }
    }

    private void j(Context context, String str, String str2) {
        jz4.c.w("group cancel summary:" + str2);
        j.e(context, str).m(a(str, str2));
    }

    private void k(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        String channelId;
        try {
            if (TextUtils.isEmpty(str2)) {
                jz4.c.m("group show summary group is null");
                return;
            }
            int b16 = k.b(context, str);
            if (b16 == 0) {
                jz4.c.m("group show summary not get icon from " + str);
                return;
            }
            j e16 = j.e(context, str);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26) {
                channelId = notification.getChannelId();
                String z16 = e16.z(channelId, "groupSummary");
                NotificationChannel b17 = e16.b(z16);
                if ("groupSummary".equals(z16) && b17 == null) {
                    e16.o(new NotificationChannel(z16, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, z16);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            k.q(defaults, true);
            Notification build = defaults.setContentTitle(c(context, "\u65b0\u6d88\u606f")).setContentText("\u4f60\u6709\u4e00\u6761\u65b0\u6d88\u606f").setSmallIcon(Icon.createWithResource(str, b16)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (i3 >= 31) {
                build.contentIntent = b(context, str);
            }
            if (!hz.r() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                k.l(build, str);
            }
            int a16 = a(str, str2);
            e16.n(a16, build);
            jz4.c.w("group show summary notify:" + a16);
        } catch (Exception e17) {
            jz4.c.m("group show summary error " + e17);
        }
    }

    private void l(Map<String, b> map, StatusBarNotification statusBarNotification) {
        String p16 = p(statusBarNotification.getNotification());
        b bVar = map.get(p16);
        if (bVar == null) {
            bVar = new b();
            map.put(p16, bVar);
        }
        c cVar = new c(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (n(statusBarNotification.getNotification())) {
            bVar.f389716b.add(cVar);
        } else {
            bVar.f389715a.add(cVar);
        }
    }

    private boolean m() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    private boolean n(Notification notification) {
        if (notification != null) {
            Object e16 = com.xiaomi.push.y.e(notification, "isGroupSummary", null);
            if (e16 instanceof Boolean) {
                return ((Boolean) e16).booleanValue();
            }
            return false;
        }
        return false;
    }

    private boolean o(Context context) {
        if (!s(context) || !j.t(context)) {
            return false;
        }
        return ah.d(context).m(gk.LatestNotificationNotIntoGroupSwitch.a(), false);
    }

    private String p(Notification notification) {
        if (notification == null) {
            return null;
        }
        String group = notification.getGroup();
        if (r(notification)) {
            return e(notification);
        }
        return group;
    }

    private void q(Context context, int i3, Notification notification) {
        Notification.Builder recoverBuilder;
        String x16 = k.x(notification);
        if (TextUtils.isEmpty(x16)) {
            jz4.c.m("group restore not extract pkg from notification:" + i3);
            return;
        }
        j e16 = j.e(context, x16);
        List<StatusBarNotification> g16 = g(e16);
        if (g16 == null) {
            jz4.c.m("group restore not get notifications");
            return;
        }
        for (StatusBarNotification statusBarNotification : g16) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && r(notification2) && statusBarNotification.getId() != i3) {
                recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                recoverBuilder.setGroup(e(notification2));
                k.q(recoverBuilder, n(notification2));
                e16.n(statusBarNotification.getId(), recoverBuilder.build());
                jz4.c.w("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    private boolean r(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), e(notification)));
    }

    private boolean s(Context context) {
        return ah.d(context).m(gk.NotificationAutoGroupSwitch.a(), true);
    }

    public String f(Context context, Notification.Builder builder, String str) {
        if (m() && o(context)) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle extras = builder.getExtras();
            extras.putString("push_src_group_name", str);
            extras.putLong("push_src_group_time", currentTimeMillis);
            return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
        }
        return str;
    }

    public void h(Context context, int i3, Notification notification) {
        if (!m()) {
            return;
        }
        if (o(context)) {
            try {
                q(context, i3, notification);
            } catch (Exception e16) {
                jz4.c.m("group notify handle restore error " + e16);
            }
        }
        if (s(context)) {
            try {
                i(context, i3, notification, true);
            } catch (Exception e17) {
                jz4.c.m("group notify handle auto error " + e17);
            }
        }
    }
}
