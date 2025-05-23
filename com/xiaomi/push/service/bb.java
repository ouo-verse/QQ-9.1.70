package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import com.xiaomi.push.dh;
import com.xiaomi.push.hz;
import com.xiaomi.push.ij;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bb {
    private static int a(Map<String, String> map) {
        return Math.max(0, ij.a(map.get("notification_top_period"), 0));
    }

    @TargetApi(19)
    private static Notification b(Notification notification, int i3, String str, j jVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString("message_id"))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> y16 = jVar.y();
        if (y16 == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : y16) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString("message_id");
            if (i3 == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    private static ae.a c(final Context context, final String str, final int i3, final String str2, final Notification notification) {
        return new ae.a() { // from class: com.xiaomi.push.service.bb.1
            @Override // com.xiaomi.push.ae.a
            public String e() {
                return bb.i(i3, str2);
            }

            @Override // java.lang.Runnable
            @TargetApi(19)
            public void run() {
                bb.k(context, str, i3, str2, notification);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    public static void e(Context context, String str, int i3, String str2, Notification notification) {
        if (hz.j(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            k(context, str, i3, str2, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Context context, Map<String, String> map, dh dhVar, long j3) {
        if (map != null && dhVar != null && hz.j(context) && g(map)) {
            int a16 = a(map);
            int h16 = h(map);
            if (a16 > 0 && h16 <= a16) {
                dhVar.setPriority(2);
                Bundle bundle = new Bundle();
                bundle.putLong("mipush_org_when", j3);
                bundle.putBoolean("mipush_n_top_flag", true);
                if (h16 > 0) {
                    bundle.putInt("mipush_n_top_fre", h16);
                }
                bundle.putInt("mipush_n_top_prd", a16);
                dhVar.addExtras(bundle);
                return;
            }
            jz4.c.B("set top notification failed - period:" + a16 + " frequency:" + h16);
        }
    }

    private static boolean g(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (!TextUtils.isEmpty(str)) {
            boolean parseBoolean = Boolean.parseBoolean(str);
            jz4.c.z("top notification' repeat is " + parseBoolean);
            return parseBoolean;
        }
        return false;
    }

    private static int h(Map<String, String> map) {
        return Math.max(0, ij.a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(int i3, String str) {
        return "n_top_update_" + i3 + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public static void k(Context context, String str, int i3, String str2, Notification notification) {
        j e16;
        Notification b16;
        boolean z16;
        int groupAlertBehavior;
        int i16;
        Notification.Builder recoverBuilder;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && Build.VERSION.SDK_INT >= 26 && (b16 = b(notification, i3, str2, (e16 = j.e(context, str)))) != null) {
            if (notification != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            groupAlertBehavior = b16.getGroupAlertBehavior();
            if (groupAlertBehavior != 1) {
                com.xiaomi.push.y.j(b16, "mGroupAlertBehavior", 1);
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = b16.extras.getLong("mipush_org_when", 0L);
            int i17 = b16.extras.getInt("mipush_n_top_fre", 0);
            int i18 = b16.extras.getInt("mipush_n_top_prd", 0);
            if (i18 > 0 && i18 >= i17) {
                long j16 = (i18 * 1000) + j3;
                if (j3 < currentTimeMillis && currentTimeMillis < j16) {
                    if (i17 > 0) {
                        i16 = (int) Math.min((j16 - currentTimeMillis) / 1000, i17);
                    } else {
                        i16 = i18;
                    }
                } else {
                    i16 = 0;
                }
                if (!z16) {
                    if (i16 <= 0) {
                        recoverBuilder = Notification.Builder.recoverBuilder(context, b16);
                        recoverBuilder.setPriority(0);
                        recoverBuilder.setWhen(currentTimeMillis);
                        Bundle extras = recoverBuilder.getExtras();
                        if (extras != null) {
                            extras.remove("mipush_n_top_flag");
                            extras.remove("mipush_org_when");
                            extras.remove("mipush_n_top_fre");
                            extras.remove("mipush_n_top_prd");
                            recoverBuilder.setExtras(extras);
                        }
                        jz4.c.m("update top notification to common: " + str2);
                        e16.n(i3, recoverBuilder.build());
                    } else {
                        b16.when = currentTimeMillis;
                        jz4.c.m("update top notification: " + str2);
                        e16.n(i3, b16);
                    }
                }
                if (i16 > 0) {
                    jz4.c.m("schedule top notification next update delay: " + i16);
                    com.xiaomi.push.ae.b(context).m(i(i3, str2));
                    com.xiaomi.push.ae.b(context).n(c(context, str, i3, str2, null), i16);
                }
            }
        }
    }
}
