package com.tencent.gamecenter.wadl.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.notification.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlCustomNotificationBuilder extends NotificationCompat.Builder {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f106925a;

    /* renamed from: b, reason: collision with root package name */
    String f106926b;

    /* renamed from: c, reason: collision with root package name */
    String f106927c;

    /* renamed from: d, reason: collision with root package name */
    boolean f106928d;

    /* renamed from: e, reason: collision with root package name */
    private String f106929e;

    /* renamed from: f, reason: collision with root package name */
    private NotificationCompat.BigTextStyle f106930f;

    public WadlCustomNotificationBuilder(@NonNull Context context) {
        super(context, QQNotificationManager.CHANNEL_ID_OTHER);
        this.f106925a = null;
        this.f106926b = "";
        this.f106927c = "";
        this.f106928d = false;
        this.f106929e = null;
        setSmallIcon(R.drawable.qfile_file_ufdownload);
        setOnlyAlertOnce(true);
        setPriority(2);
        setSound(null);
        setAutoCancel(true);
        setVisibility(1);
        setDeleteIntent(e());
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        this.f106930f = bigTextStyle;
        setStyle(bigTextStyle);
    }

    private PendingIntent e() {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_GAME_CENTER_ACTION);
        intent.putExtra("key_event_id", 7);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private Bitmap f() {
        Bitmap bitmap = this.f106925a;
        if (bitmap != null) {
            return bitmap;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.notification.WadlCustomNotificationBuilder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WadlCustomNotificationBuilder.this.f106925a = BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), R.drawable.mvc);
                    WadlCustomNotificationBuilder wadlCustomNotificationBuilder = WadlCustomNotificationBuilder.this;
                    wadlCustomNotificationBuilder.j(wadlCustomNotificationBuilder.f106925a);
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("WadlCustomNotificationBuilder", 2, "Exception:" + e16.toString());
                    }
                }
            }
        }, 16, null, true);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str, Bitmap bitmap, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("WadlCustomNotificationBuilder", 2, "loadGameIcon.onImageLoaded url=" + str);
        }
        k(str, bitmap);
    }

    private Bitmap h() {
        try {
        } catch (Throwable th5) {
            QLog.e("WadlCustomNotificationBuilder", 1, th5, new Object[0]);
        }
        if (TextUtils.isEmpty(this.f106929e)) {
            return null;
        }
        Bitmap c16 = e.b().c(this.f106929e);
        if (c16 != null) {
            return c16;
        }
        e.b().d(this.f106929e, new e.b() { // from class: com.tencent.gamecenter.wadl.notification.a
            @Override // com.tencent.gamecenter.wadl.notification.e.b
            public final void onImageLoaded(String str, Bitmap bitmap, String str2) {
                WadlCustomNotificationBuilder.this.g(str, bitmap, str2);
            }
        }, 100, 100);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Bitmap bitmap) {
        QLog.d("WadlCustomNotificationBuilder", 1, "refreshMultiIcon isSingleIcon=" + this.f106928d);
        if (!this.f106928d) {
            setLargeIcon(bitmap);
            l(build());
        }
    }

    private void k(String str, Bitmap bitmap) {
        QLog.d("WadlCustomNotificationBuilder", 1, "refreshSingleIcon isSingleIcon=" + this.f106928d + ",iconUrl=" + this.f106929e + ",callbackIconUrl=" + str);
        if (!TextUtils.isEmpty(this.f106929e) && this.f106929e.equals(str) && this.f106928d) {
            setLargeIcon(bitmap);
            l(build());
        }
    }

    private void l(Notification notification) {
        QQNotificationManager.addChannelIfNeed(notification, QQNotificationManager.CHANNEL_ID_OTHER);
        try {
            notification.when = System.currentTimeMillis() + 378;
            QQNotificationManager.getInstance().notify("gamecenter", NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, notification);
        } catch (Exception e16) {
            QLog.e("WadlCustomNotificationBuilder", 2, "showNotification exception", e16);
        }
    }

    public void i() {
        if (QLog.isColorLevel()) {
            QLog.d("WadlCustomNotificationBuilder", 2, "onDestroy NOTIFICATION_ID=378");
        }
        this.f106925a = null;
    }

    public void m(WadlResult wadlResult, Bundle bundle) {
        if (wadlResult != null && bundle != null) {
            this.f106929e = wadlResult.wadlParams.iconUrl;
            this.f106926b = bundle.getString("K_TITLE", "");
            this.f106927c = bundle.getString("K_SUB_TITLE", "");
            this.f106928d = bundle.getBoolean("K_IS_SINGLE_ICON", false);
            setContentTitle(this.f106926b);
            setContentText(this.f106927c);
            this.f106930f.bigText(this.f106927c);
            setTicker(this.f106926b);
            if (wadlResult.isRunning()) {
                setProgress(100, wadlResult.progress, false);
                setContentIntent(com.tencent.gamecenter.wadl.util.i.f(WadlProxyConsts.KUIKLY_DOWNLOAD_ADMIN_SCHEME));
            } else if (wadlResult.isDownloadComplete()) {
                setProgress(0, 0, false);
                setContentIntent(com.tencent.gamecenter.wadl.util.i.d(wadlResult));
            } else {
                setProgress(0, 0, false);
                setContentIntent(com.tencent.gamecenter.wadl.util.i.g(WadlProxyConsts.KUIKLY_DOWNLOAD_ADMIN_SCHEME));
            }
            if (!this.f106928d) {
                setLargeIcon(f());
            } else {
                setLargeIcon(h());
            }
            l(build());
        }
    }
}
