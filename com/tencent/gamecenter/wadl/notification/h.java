package com.tencent.gamecenter.wadl.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.app.NotificationCompat;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class h {

    /* renamed from: d, reason: collision with root package name */
    private LruCache<Integer, g> f106962d = new LruCache<>(10);

    /* renamed from: e, reason: collision with root package name */
    protected QQNotificationManager f106963e = QQNotificationManager.getInstance();

    public void a() {
        QLog.i("Wadl_WadlNotificationV2", 1, "clearNotificationCache");
        this.f106962d.evictAll();
    }

    public g b(int i3, int i16) {
        g gVar = this.f106962d.get(Integer.valueOf(i3));
        QLog.i("Wadl_WadlNotificationV2", 1, "getNotificationBuilder notificationId=" + i3 + ",notificationBuilder=" + gVar);
        if (gVar == null) {
            g gVar2 = new g(BaseApplication.context);
            gVar2.setSmallIcon(i16);
            gVar2.setOnlyAlertOnce(true);
            this.f106962d.put(Integer.valueOf(i3), gVar2);
            return gVar2;
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("Wadl_WadlNotificationV2", 1, "getNotificationID resId is empty");
            return 379;
        }
        int abs = Math.abs(("wadl__" + str).hashCode()) % 98;
        int i3 = abs + 379;
        QLog.d("Wadl_WadlNotificationV2", 2, "getNotificationID resId=" + str + ",mod=" + abs + ",id=" + i3);
        return i3;
    }

    public void e(int i3, Bitmap bitmap) {
        g gVar = this.f106962d.get(Integer.valueOf(i3));
        if (gVar != null) {
            gVar.setLargeIcon(bitmap);
            i(i3, gVar.build(), QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
        }
    }

    public void f(String str) {
        int c16 = c(str);
        QQNotificationManager qQNotificationManager = this.f106963e;
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel("gamecenter", c16);
        }
        this.f106962d.remove(Integer.valueOf(c16));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(g gVar, PendingIntent pendingIntent, boolean z16) {
        if (pendingIntent == null) {
            return;
        }
        if (z16) {
            gVar.setContentIntent(pendingIntent);
        } else {
            gVar.setContentIntent(pendingIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(NotificationCompat.Builder builder, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            builder.setTicker(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setContentTitle(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.setContentText(str3);
        }
    }

    public void i(int i3, Notification notification, String str) {
        QQNotificationManager.addChannelIfNeed(notification, str);
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlNotificationV2", 2, "notify notificationId=" + i3 + ",notification=" + notification);
        }
        try {
            notification.when = System.currentTimeMillis() + i3;
            QQNotificationManager qQNotificationManager = this.f106963e;
            if (qQNotificationManager != null) {
                qQNotificationManager.notify("gamecenter", i3, notification);
            }
        } catch (Exception e16) {
            QLog.e("Wadl_WadlNotificationV2", 2, "notify exception", e16);
        }
    }
}
