package com.tencent.mobileqq.vashealth;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;

/* loaded from: classes20.dex */
public class PathTraceService extends Service {
    public static String C = "com.tencent.mobileqq.vashealth.PathTraceService.update";
    public static String D = "status";
    public static String E = "time";
    public static String F = "distance";

    /* renamed from: m, reason: collision with root package name */
    static PathTraceService f312152m;

    /* renamed from: d, reason: collision with root package name */
    private UpdateRunDataBroadCastReceiver f312153d;

    /* renamed from: e, reason: collision with root package name */
    private RemoteViews f312154e;

    /* renamed from: f, reason: collision with root package name */
    private NotificationCompat.Builder f312155f;

    /* renamed from: h, reason: collision with root package name */
    private QQNotificationManager f312156h;

    /* renamed from: i, reason: collision with root package name */
    private Notification f312157i;

    /* loaded from: classes20.dex */
    public static class KernelService extends Service {
        private Notification a(Context context) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setSmallIcon(R.drawable.icon);
            builder.setContent(new RemoteViews(PathTraceService.f312152m.getApplication().getPackageName(), R.layout.qapp_center_notification));
            builder.setChannelId("CHANNEL_ID_HEALTH_MSG");
            Notification build = builder.build();
            startForeground(1, build);
            return build;
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public void onCreate() {
            super.onCreate();
            if (QLog.isColorLevel()) {
                QLog.d("PathTraceManager.Service", 2, "KernelService.onCreate");
            }
        }

        @Override // android.app.Service
        public void onDestroy() {
            if (QLog.isColorLevel()) {
                QLog.d("PathTraceManager.Service", 2, "KernelService.onDestroy");
            }
            try {
                super.stopForeground(true);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("PathTraceManager.Service", 2, "destory failed");
                }
            }
            super.onDestroy();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i3, int i16) {
            if (intent != null && PathTraceService.f312152m != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("PathTraceManager.Service", 2, "onStartCommand:");
                }
                try {
                    QLog.d("PathTraceManager.Service", 1, "PathTraceService startForeground");
                    PathTraceService.f312152m.startForeground(237, a(this));
                    super.startForeground(237, a(this));
                    super.stopForeground(true);
                } catch (Exception e16) {
                    QLog.d("PathTraceManager.Service", 1, "", e16);
                }
            }
            return 2;
        }
    }

    /* loaded from: classes20.dex */
    public class UpdateRunDataBroadCastReceiver extends BroadcastReceiver {
        public UpdateRunDataBroadCastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QLog.i("PathTraceManager.Service", 1, "onReceive");
            int intExtra = intent.getIntExtra(PathTraceService.D, 0);
            long longExtra = intent.getLongExtra(PathTraceService.E, 0L);
            double doubleExtra = intent.getDoubleExtra(PathTraceService.F, 0.0d);
            if (intExtra == 1) {
                PathTraceService.this.f312154e.setTextViewText(R.id.fba, HardCodeUtil.qqStr(R.string.f172276p03));
            }
            PathTraceService.this.f312154e.setChronometer(R.id.fbb, SystemClock.elapsedRealtime() - (longExtra * 1000), null, false);
            DecimalFormat decimalFormat = new DecimalFormat("######0.00");
            PathTraceService.this.f312154e.setTextViewText(R.id.fb_, decimalFormat.format(doubleExtra / 1000.0d) + "km");
            try {
                PathTraceService pathTraceService = PathTraceService.this;
                pathTraceService.f312157i = pathTraceService.f312155f.build();
                PathTraceService.this.f312156h.notify("PathTraceManager.Service", 237, PathTraceService.this.f312157i);
            } catch (Throwable unused) {
                QLog.e("PathTraceManager.Service", 1, "[update] err in notify");
            }
        }
    }

    public Notification f(Context context, PendingIntent pendingIntent) {
        Bitmap bitmap;
        this.f312155f = new NotificationCompat.Builder(context);
        this.f312154e = new RemoteViews(context.getPackageName(), R.layout.f168339tf);
        this.f312155f.setContentIntent(pendingIntent);
        this.f312155f.setContentTitle("QQ\u8fd0\u52a8");
        this.f312155f.setChannelId("CHANNEL_ID_HEALTH_MSG");
        this.f312155f.setSmallIcon(R.drawable.c4c);
        try {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.c4c);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PathTraceManager.Service", 2, "Exception:" + e16.toString());
            }
            bitmap = null;
        }
        if (bitmap != null) {
            this.f312155f.setLargeIcon(bitmap);
        }
        this.f312155f.setOngoing(true);
        this.f312155f.setContent(this.f312154e);
        this.f312155f.setContentIntent(pendingIntent);
        Notification build = this.f312155f.build();
        this.f312157i = build;
        return build;
    }

    void g() {
        QLog.d("PathTraceManager.Service", 1, "stopTempService");
        try {
            stopService(new Intent(this, (Class<?>) KernelService.class));
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f312152m = this;
        QLog.d("PathTraceManager.Service", 1, "onCreate");
        g();
        if (Build.VERSION.SDK_INT < 25) {
            try {
                startService(new Intent(this, (Class<?>) KernelService.class));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        g();
        super.onDestroy();
        f312152m = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        if (intent != null) {
            super.onStartCommand(intent, i3, i16);
        }
        if (Build.VERSION.SDK_INT >= 25) {
            if (this.f312153d == null) {
                this.f312153d = new UpdateRunDataBroadCastReceiver();
                registerReceiver(this.f312153d, new IntentFilter(C));
            }
            this.f312156h = QQNotificationManager.getInstance();
            Intent intent2 = new Intent("com.tencent.mobileqq.action.MAINACTIVITY");
            intent2.putExtra(QQNotificationManager.PARAM_NOTIFYID, 237);
            super.startForeground(237, f(this, PendingIntent.getActivity(this, 1, intent2, 335544320)));
            return 2;
        }
        return 2;
    }
}
