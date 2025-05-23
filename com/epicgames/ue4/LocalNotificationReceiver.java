package com.epicgames.ue4;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LocalNotificationReceiver extends BroadcastReceiver {
    public static final String KEY_LOCAL_NOTIFICATION_ACTION = "local-notification-action";
    public static final String KEY_LOCAL_NOTIFICATION_ACTION_EVENT = "local-notification-activationEvent";
    public static final String KEY_LOCAL_NOTIFICATION_BODY = "local-notification-body";
    public static final String KEY_LOCAL_NOTIFICATION_ID = "local-notification-ID";
    public static final String KEY_LOCAL_NOTIFICATION_TITLE = "local-notification-title";
    private static final CharSequence NOTICATION_CHANNEL_NAME = "ue4-push-notification-channel";
    private static final String NOTIFICATION_CHANNEL_ID = "ue4-push-notification-channel-id";

    public static int getNotificationIconID(Context context) {
        int identifier = context.getResources().getIdentifier("ic_notification_simple", "drawable", context.getPackageName());
        if (identifier == 0) {
            identifier = context.getResources().getIdentifier("ic_notification", "drawable", context.getPackageName());
        }
        if (identifier == 0) {
            return context.getResources().getIdentifier("icon", "drawable", context.getPackageName());
        }
        return identifier;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NotificationChannel notificationChannel;
        int intExtra = intent.getIntExtra(KEY_LOCAL_NOTIFICATION_ID, 0);
        String stringExtra = intent.getStringExtra(KEY_LOCAL_NOTIFICATION_TITLE);
        String stringExtra2 = intent.getStringExtra(KEY_LOCAL_NOTIFICATION_BODY);
        String stringExtra3 = intent.getStringExtra(KEY_LOCAL_NOTIFICATION_ACTION);
        String stringExtra4 = intent.getStringExtra(KEY_LOCAL_NOTIFICATION_ACTION_EVENT);
        if (stringExtra != null && stringExtra2 != null && stringExtra3 != null && stringExtra4 != null) {
            Intent intent2 = new Intent(context, (Class<?>) GameActivity.class);
            intent2.setFlags(603979776);
            intent2.putExtra("localNotificationID", intExtra);
            intent2.putExtra("localNotificationAppLaunched", true);
            intent2.putExtra("localNotificationLaunchActivationEvent", stringExtra4);
            int notificationIconID = getNotificationIconID(context);
            PendingIntent activity = PendingIntent.getActivity(context, intExtra, intent2, 0);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationCompat.Builder style = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID).setSmallIcon(notificationIconID).setContentIntent(activity).setWhen(System.currentTimeMillis()).setTicker(stringExtra2).setContentTitle(stringExtra).setStyle(new NotificationCompat.BigTextStyle().bigText(stringExtra2));
            int i3 = Build.VERSION.SDK_INT;
            style.setContentText(stringExtra2);
            style.setColor(-15851965);
            if (i3 >= 26 && notificationManager != null) {
                notificationChannel = notificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID);
                if (notificationChannel == null) {
                    NotificationChannel notificationChannel2 = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTICATION_CHANNEL_NAME, 3);
                    notificationChannel2.enableVibration(true);
                    notificationChannel2.enableLights(true);
                    notificationManager.createNotificationChannel(notificationChannel2);
                }
            }
            Notification build = style.build();
            build.flags |= 16;
            build.defaults |= 3;
            if (notificationManager != null) {
                notificationManager.notify(intExtra, build);
                GameActivity.LocalNotificationRemoveDetails(context, intExtra);
            }
        }
    }
}
