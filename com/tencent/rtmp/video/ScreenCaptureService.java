package com.tencent.rtmp.video;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Binder;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ScreenCaptureService extends Service {
    static IPatchRedirector $redirector_ = null;
    private static final String CHANNEL_ID = "notification_id";
    private static final int NOTIFICATION_ID = 13957237;
    private static final String TAG = "ScreenCaptureService";

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f368817d = 0;

    public ScreenCaptureService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Notification createNotification() {
        if (BaseBridge.getSystemOSVersion() >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel(CHANNEL_ID, "notification_name", 2));
        }
        Notification.Builder defaults = new Notification.Builder(this).setDefaults(1);
        if (BaseBridge.getSystemOSVersion() >= 26) {
            defaults.setChannelId(CHANNEL_ID);
        }
        return defaults.build();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        }
        BaseBridge.printLog(TAG, "Service on bind");
        return new Binder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            stopForeground(true);
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        MediaProjectionManager mediaProjectionManager;
        MediaProjection mediaProjection;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int intExtra = intent.getIntExtra("code", -1);
        Intent intent2 = (Intent) intent.getParcelableExtra("data");
        BaseBridge.printLog(TAG, "On Start server command, code:" + intExtra + ", data:" + intent2);
        if (intent2 == null) {
            stopSelf();
            return 2;
        }
        try {
            if (BaseBridge.getSystemOSVersion() >= 29) {
                startForeground(NOTIFICATION_ID, createNotification(), 32);
            } else if (BaseBridge.getSystemOSVersion() >= 26) {
                startForeground(NOTIFICATION_ID, createNotification());
            }
        } catch (Throwable th5) {
            BaseBridge.printLog(TAG, "start foreground failed.".concat(String.valueOf(th5)));
        }
        if (BaseBridge.getSystemOSVersion() >= 21) {
            if (BaseBridge.getAppContext() != null) {
                mediaProjectionManager = (MediaProjectionManager) BaseBridge.getAppContext().getSystemService("media_projection");
            } else {
                mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            }
            try {
                mediaProjection = mediaProjectionManager.getMediaProjection(intExtra, intent2);
            } catch (Throwable th6) {
                BaseBridge.printLog(TAG, "onStartCommand mediaProjectionManager getMediaProjection fail.".concat(String.valueOf(th6)));
                mediaProjection = null;
            }
            VirtualDisplayManagerProxy.getInstance().signalSessionRequestFinish(mediaProjection);
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent)).booleanValue();
        }
        BaseBridge.printLog(TAG, "Service on unbind");
        return super.onUnbind(intent);
    }
}
