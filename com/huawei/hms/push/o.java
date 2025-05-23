package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static int f37471a;

    public static synchronized void a(Context context, k kVar) {
        int hashCode;
        int i3;
        int i16;
        int hashCode2;
        synchronized (o.class) {
            if (context != null) {
                if (!a(kVar)) {
                    HMSLog.d("PushSelfShowLog", "showNotification, the msg id = " + kVar.p());
                    if (f37471a == 0) {
                        f37471a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                    }
                    if (TextUtils.isEmpty(kVar.l())) {
                        String q16 = kVar.q();
                        if (!TextUtils.isEmpty(q16)) {
                            int hashCode3 = q16.hashCode();
                            kVar.a(hashCode3);
                            HMSLog.d("PushSelfShowLog", "notification msgTag = " + hashCode3);
                        }
                        if (kVar.s() != -1) {
                            hashCode = kVar.s();
                            i3 = (kVar.k() + System.currentTimeMillis()).hashCode();
                            i16 = i3 + 1;
                            hashCode2 = (kVar.s() + kVar.k() + context.getPackageName()).hashCode();
                        } else {
                            hashCode = f37471a + 1;
                            i3 = hashCode + 1;
                            i16 = i3 + 1;
                            hashCode2 = i16 + 1;
                            f37471a = hashCode2;
                        }
                    } else {
                        hashCode = (kVar.l() + kVar.k()).hashCode();
                        i3 = f37471a + 1;
                        i16 = i3 + 1;
                        f37471a = i16;
                        hashCode2 = (kVar.l() + kVar.k() + context.getPackageName()).hashCode();
                    }
                    HMSLog.d("PushSelfShowLog", "notifyId:" + hashCode + ",openNotifyId:" + i3 + ",delNotifyId:" + i16 + ",alarmNotifyId:" + hashCode2);
                    int[] iArr = new int[4];
                    iArr[0] = hashCode;
                    iArr[1] = i3;
                    iArr[2] = i16;
                    if (kVar.f() <= 0) {
                        hashCode2 = 0;
                    }
                    iArr[3] = hashCode2;
                    Notification a16 = q.e() ? a(context, kVar, iArr) : null;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null && a16 != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        }
                        notificationManager.notify(hashCode, a16);
                        d(context, kVar, iArr);
                        e.a(context, kVar.p(), kVar.b(), "100");
                    }
                }
            }
        }
    }

    public static PendingIntent b(Context context, k kVar, int[] iArr) {
        Intent a16 = a(context, kVar, iArr, "2", 268435456);
        if (a()) {
            a16.setClass(context, TransActivity.class);
            a16.setFlags(268468224);
            return PendingIntent.getActivity(context, iArr[2], a16, q.b());
        }
        return PendingIntent.getBroadcast(context, iArr[2], a16, q.b());
    }

    public static PendingIntent c(Context context, k kVar, int[] iArr) {
        Intent a16 = a(context, kVar, iArr, "1", 268435456);
        if (a()) {
            a16.setClass(context, TransActivity.class);
            a16.setFlags(268468224);
            return PendingIntent.getActivity(context, iArr[1], a16, q.b());
        }
        return PendingIntent.getBroadcast(context, iArr[1], a16, q.b());
    }

    public static void d(Context context, k kVar, int[] iArr) {
        HMSLog.i("PushSelfShowLog", "setAutoClear time is: " + kVar.f());
        if (kVar.f() <= 0) {
            return;
        }
        a(context, a(context, kVar, iArr, "-1", 32), kVar.f(), iArr[3]);
    }

    public static void d(k kVar, Notification.Builder builder) {
        String u16 = kVar.u();
        String j3 = kVar.j();
        if (TextUtils.isEmpty(j3)) {
            builder.setContentText(u16);
            return;
        }
        builder.setContentText(j3);
        if (TextUtils.isEmpty(u16)) {
            return;
        }
        builder.setContentTitle(u16);
    }

    public static void c(k kVar, Notification.Builder builder) {
        builder.setTicker(kVar.x());
    }

    @SuppressLint({"NewApi"})
    public static void b(Context context, Notification.Builder builder, k kVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String k3 = kVar.k();
            if (TextUtils.isEmpty(k3)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", k3);
            builder.setExtras(bundle);
        }
    }

    public static void b(k kVar, Notification.Builder builder) {
        String t16 = kVar.t();
        if (TextUtils.isEmpty(t16)) {
            return;
        }
        builder.setSubText(t16);
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static Intent a(Context context, k kVar, int[] iArr, String str, int i3) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", kVar.o()).putExtra("selfshow_token", kVar.y()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i3);
        return intent;
    }

    public static Notification a(Context context, k kVar, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (m.a(kVar) == n.STYLE_BIGTEXT) {
            m.a(builder, kVar.g(), kVar);
        }
        l.a(context, builder, kVar);
        b(kVar, builder);
        d(kVar, builder);
        a(context, kVar, builder);
        a(builder);
        a(kVar, builder);
        c(kVar, builder);
        builder.setContentIntent(c(context, kVar, iArr));
        builder.setDeleteIntent(b(context, kVar, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        b(context, builder, kVar);
        a(context, builder, kVar);
        return builder.build();
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, Notification.Builder builder, k kVar) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !q.a(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        String k3 = kVar.k();
        HMSLog.i("PushSelfShowLog", "the package name of notification is:" + k3);
        if (!TextUtils.isEmpty(k3)) {
            String a16 = q.a(context, k3);
            HMSLog.i("PushSelfShowLog", "the app name is:" + a16);
            if (a16 != null) {
                bundle.putCharSequence("android.extraAppName", a16);
            }
        }
        builder.setExtras(bundle);
    }

    public static void a(Context context, Intent intent, long j3, int i3) {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enter setDelayAlarm(interval:");
            sb5.append(j3);
            sb5.append("ms.");
            HMSLog.d("PushSelfShowLog", sb5.toString());
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j3, PendingIntent.getBroadcast(context, i3, intent, q.b()));
            }
        } catch (Exception e16) {
            HMSLog.w("PushSelfShowLog", "set DelayAlarm error." + e16.toString());
        }
    }

    public static void a(Context context, k kVar, Notification.Builder builder) {
        Bitmap a16 = l.a(context, kVar);
        if (a16 != null) {
            builder.setLargeIcon(a16);
        }
    }

    public static void a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    public static void a(k kVar, Notification.Builder builder) {
        builder.setAutoCancel(kVar.e() == 1);
        builder.setOngoing(false);
    }

    public static boolean a(k kVar) {
        return kVar == null || (TextUtils.isEmpty(kVar.u()) && TextUtils.isEmpty(kVar.j()));
    }
}
