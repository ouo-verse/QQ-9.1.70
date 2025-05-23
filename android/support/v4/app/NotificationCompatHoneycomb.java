package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* compiled from: P */
/* loaded from: classes.dex */
class NotificationCompatHoneycomb {
    NotificationCompatHoneycomb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Notification add(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i3, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap) {
        boolean z16;
        boolean z17;
        boolean z18;
        Notification.Builder lights = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        boolean z19 = true;
        if ((notification.flags & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z16);
        if ((notification.flags & 8) != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z17);
        if ((notification.flags & 16) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z18).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) == 0) {
            z19 = false;
        }
        return deleteIntent.setFullScreenIntent(pendingIntent2, z19).setLargeIcon(bitmap).setNumber(i3).getNotification();
    }
}
