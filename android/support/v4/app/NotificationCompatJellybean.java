package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
class NotificationCompatJellybean {

    /* renamed from: b, reason: collision with root package name */
    private Notification.Builder f26395b;

    public NotificationCompatJellybean(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i3, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i16, int i17, boolean z16, boolean z17, int i18, CharSequence charSequence4) {
        boolean z18 = false;
        Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
        if ((notification.flags & 128) != 0) {
            z18 = true;
        }
        Notification.Builder progress = deleteIntent.setFullScreenIntent(pendingIntent2, z18).setLargeIcon(bitmap).setNumber(i3).setUsesChronometer(z17).setPriority(i18).setProgress(i16, i17, z16);
        this.f26395b = progress;
        progress.setShowWhen(true);
    }

    public void addAction(int i3, CharSequence charSequence, PendingIntent pendingIntent) {
        this.f26395b.addAction(i3, charSequence, pendingIntent);
    }

    public void addBigPictureStyle(CharSequence charSequence, boolean z16, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z17) {
        Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(this.f26395b).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z17) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z16) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public void addBigTextStyle(CharSequence charSequence, boolean z16, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(this.f26395b).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z16) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public void addInboxStyle(CharSequence charSequence, boolean z16, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(this.f26395b).setBigContentTitle(charSequence);
        if (z16) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    public Notification build() {
        return this.f26395b.build();
    }
}
