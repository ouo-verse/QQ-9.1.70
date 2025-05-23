package com.tencent.mobileqq.zootopia.download.notification;

import android.app.Notification;
import android.util.LruCache;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u001e\u0010\u0011\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/notification/d;", "", "", "notificationId", "Lcom/tencent/mobileqq/zootopia/download/notification/c;", "a", "Landroid/app/Notification;", "notification", "", "c", "b", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "noticeLruCache", "Lcom/tencent/commonsdk/util/notification/QQNotificationManager;", "kotlin.jvm.PlatformType", "Lcom/tencent/commonsdk/util/notification/QQNotificationManager;", "mQQNotificationManager", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LruCache<Integer, c> noticeLruCache = new LruCache<>(5);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QQNotificationManager mQQNotificationManager = QQNotificationManager.getInstance();

    public final c a(int notificationId) {
        c cVar = this.noticeLruCache.get(Integer.valueOf(notificationId));
        if (cVar == null) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            cVar = new c(context, QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
            cVar.setSmallIcon(R.drawable.b8g);
            try {
                cVar.setOnlyAlertOnce(true);
            } catch (Exception e16) {
                QLog.e("ZPlanNotification_Proxy", 1, "setOnlyAlertOnce error", e16);
            }
            this.noticeLruCache.put(Integer.valueOf(notificationId), cVar);
        }
        return cVar;
    }

    public final void b(int notificationId) {
        QQNotificationManager qQNotificationManager = this.mQQNotificationManager;
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel("ZPlanNotification_Proxy", notificationId);
        }
        this.noticeLruCache.remove(Integer.valueOf(notificationId));
    }

    public final void c(int notificationId, Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        QQNotificationManager.addChannelIfNeed(notification, QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
        if (QLog.isColorLevel()) {
            QLog.i("ZPlanNotification_Proxy", 1, "showNotification notificationId=" + notificationId + ", notification=" + notification);
        }
        try {
            QQNotificationManager qQNotificationManager = this.mQQNotificationManager;
            if (qQNotificationManager != null) {
                qQNotificationManager.notify("ZPlanNotification_Proxy", notificationId, notification);
            }
        } catch (Exception e16) {
            QLog.e("ZPlanNotification_Proxy", 2, "showNotification exception", e16);
        }
    }
}
