package com.tencent.xweb.remotedebug;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebRemoteDebugService extends Service {
    public final Notification a() {
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this, "channel_id_xweb_remote_debug").setSmallIcon(R.drawable.f162714ma4).setContentTitle(getString(R.string.f242717vb)).setContentText(getString(R.string.f242707va)).setContentIntent(PendingIntent.getBroadcast(this, 0, new Intent(this, (Class<?>) XWebRemoteDebugServiceStopReceiver.class), 201326592)).setPriority(0).setAutoCancel(true);
        x0.d("XWebRemoteDebugService", "createNotification");
        return autoCancel.build();
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = getString(R.string.f242697v_);
            String string2 = getString(R.string.f242687v9);
            NotificationChannel notificationChannel = new NotificationChannel("channel_id_xweb_remote_debug", string, 3);
            notificationChannel.setDescription(string2);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
                x0.d("XWebRemoteDebugService", "createNotificationChannel");
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b();
        startForeground(-120410, a());
    }
}
