package cooperation.qzone.push;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneNotificationAdapter {
    private static volatile QZoneNotificationAdapter notificationAdapter;
    private String channelId = QQNotificationManager.CHANNEL_ID_SHOW_BADGE;

    QZoneNotificationAdapter() {
    }

    public static QZoneNotificationAdapter getInstance() {
        if (notificationAdapter == null) {
            synchronized (QZoneNotificationAdapter.class) {
                if (notificationAdapter == null) {
                    notificationAdapter = new QZoneNotificationAdapter();
                }
            }
        }
        return notificationAdapter;
    }

    public Notification buildNotification(PendingIntent pendingIntent, Context context, Bitmap bitmap, String str, String str2, int i3) {
        NotificationCompat.Builder ticker = new NotificationCompat.Builder(context).setSmallIcon(i3).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(str2);
        ticker.setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent);
        if (SdkInfoUtil.isOreo() && SdkInfoUtil.isTargetSDKOreo()) {
            ticker.setChannelId(this.channelId);
        }
        if (bitmap != null) {
            ticker.setLargeIcon(bitmap);
        }
        return ticker.build();
    }

    @TargetApi(16)
    public Notification newNotificationForMz(PendingIntent pendingIntent, Context context, Bitmap bitmap, String str, String str2, int i3) {
        Notification.Builder builder;
        Notification notification = null;
        try {
            Notification.Builder builder2 = new Notification.Builder(context);
            Method declaredMethod = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", Integer.TYPE);
            if (declaredMethod != null) {
                declaredMethod.invoke(builder2, 1);
                builder2.setContentIntent(pendingIntent).setSmallIcon(i3).setWhen(System.currentTimeMillis()).setAutoCancel(true).setTicker(str2).setContentTitle(str).setContentText(str2);
                if (bitmap != null) {
                    builder2.setLargeIcon(bitmap);
                }
                notification = builder2.build();
                if (notification != null) {
                    QQNotificationManager.addChannelIfNeed(notification, this.channelId);
                }
            }
        } catch (Throwable th5) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("QZoneNotification.newNotificationForMeizu", 2, th5, new Object[0]);
                }
                if (notification == null) {
                    builder = new Notification.Builder(context);
                } else {
                    return notification;
                }
            } catch (Throwable th6) {
                if (notification == null) {
                    new Notification.Builder(context).setSmallIcon(i3).setTicker(str2).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).setAutoCancel(true).build();
                }
                throw th6;
            }
        }
        if (notification == null) {
            builder = new Notification.Builder(context);
            return builder.setSmallIcon(i3).setTicker(str2).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).setAutoCancel(true).build();
        }
        return notification;
    }

    @TargetApi(16)
    public Notification newNotificationForOppo(PendingIntent pendingIntent, Context context, Bitmap bitmap, String str, String str2, int i3) {
        Notification.Builder builder;
        Notification notification = null;
        try {
            Notification.Builder builder2 = new Notification.Builder(context);
            builder2.setContentIntent(pendingIntent).setSmallIcon(i3).setWhen(System.currentTimeMillis()).setAutoCancel(true).setTicker(str2).setContentTitle(str).setContentText(str2);
            if (bitmap != null) {
                builder2.setLargeIcon(bitmap);
            }
            notification = builder2.build();
            if (notification != null) {
                QQNotificationManager.addChannelIfNeed(notification, this.channelId);
            }
        } catch (Throwable th5) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("QZoneNotification.newNotificationForOppo", 2, th5, new Object[0]);
                }
                if (notification == null) {
                    builder = new Notification.Builder(context);
                } else {
                    return notification;
                }
            } catch (Throwable th6) {
                if (notification == null) {
                    new Notification.Builder(context).setSmallIcon(i3).setTicker(str2).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).setAutoCancel(true).build();
                }
                throw th6;
            }
        }
        if (notification == null) {
            builder = new Notification.Builder(context);
            return builder.setSmallIcon(i3).setTicker(str2).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).setAutoCancel(true).build();
        }
        return notification;
    }
}
