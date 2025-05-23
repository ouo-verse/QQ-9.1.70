package com.tencent.av.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.AVScreenCaptureService;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.PopupDialog;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVScreenCaptureService {

    /* renamed from: d, reason: collision with root package name */
    private static String f74299d = "AVScreenCaptureService";

    /* renamed from: e, reason: collision with root package name */
    private static int f74300e = 110;

    /* renamed from: a, reason: collision with root package name */
    private Intent f74301a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f74302b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f74303c;

    public AVScreenCaptureService(Context context, VideoAppInterface videoAppInterface) {
        this.f74302b = new WeakReference<>(context);
        this.f74303c = new WeakReference<>(videoAppInterface);
    }

    private void c(Service service, String str, int i3, int i16) {
        Notification.Builder builder;
        String string;
        String str2;
        Bitmap bitmap;
        WeakReference<Context> weakReference = this.f74302b;
        if (weakReference != null && weakReference.get() != null) {
            QLog.d(f74299d, 1, "[createNotificationChannel]");
            QQNotificationManager.getInstance();
            int i17 = Build.VERSION.SDK_INT;
            if (i17 >= 26) {
                builder = new Notification.Builder(this.f74302b.get().getApplicationContext(), QQNotificationManager.CHANNEL_ID_OTHER);
            } else {
                builder = new Notification.Builder(this.f74302b.get().getApplicationContext());
            }
            Intent intent = new Intent(this.f74302b.get(), (Class<?>) AVActivity.class);
            if (i3 == 4) {
                string = this.f74302b.get().getString(R.string.dfy);
            } else {
                string = this.f74302b.get().getString(R.string.dfq);
            }
            WeakReference<VideoAppInterface> weakReference2 = this.f74303c;
            if (weakReference2 != null && weakReference2.get() != null) {
                str2 = this.f74303c.get().G(i16, str, null);
                bitmap = this.f74303c.get().J(i16, str, null, true, true);
            } else {
                str2 = "";
                bitmap = null;
            }
            builder.setContentIntent(PendingIntent.getActivity(this.f74302b.get(), 0, intent, 67108864)).setContentText(string).setContentTitle(str2).setSmallIcon(R.drawable.h9o).setLargeIcon(bitmap).setWhen(System.currentTimeMillis());
            builder.setFullScreenIntent(null, false);
            builder.setVibrate(null);
            Notification build = builder.build();
            build.defaults = 1;
            int i18 = (build.flags | 2 | 32 | 8) & (-5) & (-2);
            build.category = null;
            build.flags = i18 & (-129);
            if (i17 >= 29) {
                service.startForeground(f74300e, build, 32);
            } else {
                service.startForeground(f74300e, build);
            }
            QLog.d(f74299d, 1, "[createNotificationChannel] title=" + str2 + " content=" + string + " largeIcon=" + bitmap);
            return;
        }
        QLog.e(f74299d, 1, "[createNotificationChannel] error: context is null.");
    }

    public void d(Service service) {
        service.stopForeground(true);
        QLog.d(f74299d, 1, "[onDestroy]");
    }

    public void e(Intent intent, Service service) {
        c(service, intent.getStringExtra("peerUin"), intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0), intent.getIntExtra("uinType", -1));
        this.f74301a = (Intent) intent.getParcelableExtra("data");
        QLog.d(f74299d, 1, "[onStartCommand]");
        WeakReference<Context> weakReference = this.f74302b;
        if (weakReference != null && weakReference.get() != null) {
            try {
                qw.a.b().d(this.f74301a);
            } catch (Exception e16) {
                QLog.e(f74299d, 1, "startCapture error: " + e16 + " try again.");
                ThreadManagerV2.executeDelay(new AnonymousClass1(), 16, null, false, 1000L);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.av.service.AVScreenCaptureService$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void g() {
            PopupDialog.n0(Foreground.getTopActivity(), 230, R.string.f1782936_, R.string.f17828369, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.av.service.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AVScreenCaptureService.AnonymousClass1.f(dialogInterface, i3);
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                qw.a.b().d(AVScreenCaptureService.this.f74301a);
            } catch (Exception e16) {
                QLog.e(AVScreenCaptureService.f74299d, 1, "startCapture error: " + e16);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.av.service.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AVScreenCaptureService.AnonymousClass1.g();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(DialogInterface dialogInterface, int i3) {
        }
    }
}
