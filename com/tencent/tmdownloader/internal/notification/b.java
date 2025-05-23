package com.tencent.tmdownloader.internal.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.i;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    NotifyParam f380742a;

    /* renamed from: b, reason: collision with root package name */
    Notification f380743b;

    /* renamed from: c, reason: collision with root package name */
    private i f380744c;

    /* renamed from: d, reason: collision with root package name */
    private Context f380745d;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380744c = null;
        this.f380745d = null;
        a();
    }

    private int a(long j3, long j16) {
        return (int) ((((float) j3) * 100.0f) / ((float) j16));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        super.handleMessage(message);
        com.tencent.tmdownloader.internal.downloadservice.c queryDownloadInfo = ApkDownloadManager.getInstance().queryDownloadInfo(message.getData().getString("url"));
        if (queryDownloadInfo != null) {
            NotifyParam notifyParam = this.f380742a;
            notifyParam.url = queryDownloadInfo.f380681b;
            notifyParam.title = queryDownloadInfo.D;
            notifyParam.nKey = String.valueOf(queryDownloadInfo.f380696q);
            try {
                if (this.f380743b == null) {
                    this.f380743b = a.b().a(this.f380742a);
                } else {
                    RemoteViews remoteViews = new RemoteViews(this.f380745d.getPackageName(), this.f380744c.c("qapp_center_notification"));
                    a.b().a(remoteViews);
                    remoteViews.setInt(this.f380744c.b("notification_root"), "setBackgroundColor", -1);
                    remoteViews.setInt(this.f380744c.b("notification_title"), "setTextColor", -16777216);
                    remoteViews.setInt(this.f380744c.b("notification_progress"), "setTextColor", -12303292);
                    remoteViews.setInt(this.f380744c.b("notification_content"), "setTextColor", -12303292);
                    this.f380743b.contentView = remoteViews;
                }
            } catch (Exception e16) {
                r.b("SDK_NotificationHandler", "init Notification " + e16);
            }
            if (this.f380743b == null) {
                return;
            }
            r.b("SDK_NotificationHandler", "<handleMessage> msg.what = " + message.what);
            switch (message.what) {
                case 1:
                    this.f380743b.tickerText = a(this.f380744c.d("notification_tickerText_download_prefix"), queryDownloadInfo.D);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_content"), 0);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notif_pro_bar_layout"), 8);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_progress"), 8);
                    this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_title"), d.a(a(this.f380744c.d("notification_title_download_prefix"), queryDownloadInfo.D), 18, true));
                    this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_content"), a(this.f380744c.d("download_wait")));
                    this.f380743b.contentView.setImageViewResource(this.f380744c.b("notification_icon"), this.f380744c.a("qfile_file_ufdownload"));
                    NotifyParam notifyParam2 = this.f380742a;
                    notifyParam2.notificationTypeId = 101;
                    a(this.f380743b, c.a(notifyParam2), true);
                    this.f380743b.flags = 34;
                    a.b().c(this.f380742a.nKey);
                    break;
                case 2:
                    this.f380743b.tickerText = a(this.f380744c.d("notification_tickerText_download_prefix"), queryDownloadInfo.D);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_content"), 8);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notif_pro_bar_layout"), 0);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_progress"), 0);
                    if (queryDownloadInfo.f380688i > 0) {
                        str = "notification_title_download_prefix";
                        this.f380743b.contentView.setProgressBar(this.f380744c.b("notif_pro_bar"), 100, a(queryDownloadInfo.f380687h, queryDownloadInfo.f380688i), false);
                        RemoteViews remoteViews2 = this.f380743b.contentView;
                        int b16 = this.f380744c.b("notification_progress");
                        StringBuilder sb5 = new StringBuilder();
                        str2 = "qfile_file_ufdownload";
                        sb5.append((a(queryDownloadInfo.f380687h, queryDownloadInfo.f380688i) * 100) / 100);
                        sb5.append("%");
                        remoteViews2.setTextViewText(b16, sb5.toString());
                    } else {
                        str = "notification_title_download_prefix";
                        str2 = "qfile_file_ufdownload";
                    }
                    this.f380743b.contentView.setImageViewResource(this.f380744c.b("notification_icon"), this.f380744c.a(str2));
                    this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_title"), d.a(a(this.f380744c.d(str), queryDownloadInfo.D), 18, true));
                    NotifyParam notifyParam3 = this.f380742a;
                    notifyParam3.notificationTypeId = 102;
                    a(this.f380743b, c.a(notifyParam3), true);
                    if (!TextUtils.isEmpty("")) {
                        this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_content"), 0);
                        this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_content"), Html.fromHtml(""));
                    } else {
                        this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_content"), 8);
                    }
                    this.f380743b.flags = 34;
                    break;
                case 3:
                    r.b("SDK_NotificationHandler", ">>pause:" + this.f380742a.url);
                    this.f380743b.tickerText = a(this.f380744c.d("notification_content_download_pause"));
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_content"), 0);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notif_pro_bar_layout"), 8);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_progress"), 8);
                    this.f380743b.contentView.setImageViewResource(this.f380744c.b("notification_icon"), this.f380744c.a("qfile_file_ufdownload_pause"));
                    this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_title"), d.a(queryDownloadInfo.D, 18, true));
                    this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_content"), a(this.f380744c.d("notification_content_download_pause")));
                    NotifyParam notifyParam4 = this.f380742a;
                    notifyParam4.notificationTypeId = 103;
                    a(this.f380743b, c.a(notifyParam4), true);
                    this.f380743b.flags = 16;
                    a.b().c(this.f380742a.nKey);
                    break;
                case 4:
                    r.b("SDK_NotificationHandler", ">>complete:" + this.f380742a.url);
                    Notification a16 = a.b().a(this.f380742a);
                    this.f380743b = a16;
                    if (a16 != null) {
                        a16.tickerText = a(this.f380744c.d("notification_tickerText_download_complete"));
                        this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_content"), 0);
                        this.f380743b.contentView.setViewVisibility(this.f380744c.b("notif_pro_bar_layout"), 8);
                        this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_progress"), 8);
                        this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_content"), a(this.f380744c.d("notification_content_download_complete")));
                        this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_title"), d.a(queryDownloadInfo.D, 18, true));
                        NotifyParam notifyParam5 = this.f380742a;
                        notifyParam5.notificationTypeId = 104;
                        a(this.f380743b, c.a(notifyParam5), true);
                        Bitmap a17 = a(a(com.tencent.tmdownloader.f.b.c.b(queryDownloadInfo.f380689j)), 72, 72, true);
                        if (a17 != null && !a17.isRecycled()) {
                            this.f380743b.contentView.setImageViewBitmap(this.f380744c.b("notification_icon"), a17);
                        } else {
                            r.b("SDK_NotificationHandler", ">>download icon fail,so we use default notification icon");
                            this.f380743b.contentView.setImageViewResource(this.f380744c.b("notification_icon"), this.f380744c.a("qfile_file_ufdownload"));
                        }
                        this.f380743b.flags = 16;
                        a.b().c(this.f380742a.nKey);
                        break;
                    } else {
                        return;
                    }
                case 5:
                    r.b("SDK_NotificationHandler", ">>error:" + this.f380742a.url);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_content"), 0);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notif_pro_bar_layout"), 8);
                    this.f380743b.contentView.setViewVisibility(this.f380744c.b("notification_progress"), 8);
                    this.f380743b.contentView.setImageViewResource(this.f380744c.b("notification_icon"), this.f380744c.a("qfile_file_ufdownload_error"));
                    String str3 = (String) message.obj;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = a(this.f380744c.d("download_err_unknown"));
                    }
                    this.f380743b.tickerText = a(this.f380744c.d("notification_tickerText_download_err"), str3);
                    this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_content"), a(this.f380744c.d("notification_content_download_err_suffix"), str3));
                    this.f380743b.contentView.setTextViewText(this.f380744c.b("notification_title"), d.a(queryDownloadInfo.D, 18, true));
                    NotifyParam notifyParam6 = this.f380742a;
                    notifyParam6.notificationTypeId = 105;
                    a(this.f380743b, c.a(notifyParam6), true);
                    this.f380743b.flags = 16;
                    a.b().c(this.f380742a.nKey);
                    break;
                case 6:
                    a.b().e(this.f380742a.nKey);
                    break;
            }
            a b17 = a.b();
            NotifyParam notifyParam7 = this.f380742a;
            int a18 = b17.a(notifyParam7.nKey, notifyParam7.url);
            r.b("SDK_NotificationHandler", "notification id = " + a18);
            Notification notification = this.f380743b;
            a b18 = a.b();
            NotifyParam notifyParam8 = this.f380742a;
            notification.when = b18.b(notifyParam8.nKey, notifyParam8.url);
            a.b().a(a18, this.f380743b);
        }
    }

    private void a() {
        this.f380742a = new NotifyParam();
        Context context = GlobalUtil.getInstance().getContext();
        this.f380745d = context;
        this.f380744c = new i(context);
    }

    public b(Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper);
            return;
        }
        this.f380744c = null;
        this.f380745d = null;
        a();
    }

    private Bitmap a(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = GlobalUtil.getInstance().getContext().getPackageManager().getPackageArchiveInfo(str, 1);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        Drawable loadIcon = applicationInfo.loadIcon(GlobalUtil.getInstance().getContext().getPackageManager());
        if (loadIcon == null) {
            return null;
        }
        if (loadIcon instanceof BitmapDrawable) {
            return ((BitmapDrawable) loadIcon).getBitmap();
        }
        if (loadIcon instanceof StateListDrawable) {
            return ((BitmapDrawable) ((StateListDrawable) loadIcon).getCurrent()).getBitmap();
        }
        return null;
    }

    private static Bitmap a(Bitmap bitmap, int i3, int i16, boolean z16) {
        Matrix matrix;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float f16 = width / height;
        float f17 = i3;
        float f18 = i16;
        float f19 = f17 / f18;
        Matrix matrix2 = new Matrix();
        if (f16 > f19) {
            float f26 = f18 / height;
            if (f26 < 0.9f || f26 > 1.0f) {
                matrix2.setScale(f26, f26);
                matrix = matrix2;
            }
            matrix = null;
        } else {
            float f27 = f17 / width;
            if (f27 < 0.9f || f27 > 1.0f) {
                matrix2.setScale(f27, f27);
                matrix = matrix2;
            }
            matrix = null;
        }
        Bitmap createBitmap = matrix != null ? Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true) : bitmap;
        if (z16 && createBitmap != bitmap && !GlobalUtil.isMIUI()) {
            bitmap.recycle();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, Math.max(0, createBitmap.getWidth() - i3) / 2, Math.max(0, createBitmap.getHeight() - i16) / 2, i3, i16);
        if (createBitmap2 != createBitmap && ((z16 || createBitmap != bitmap) && !GlobalUtil.isMIUI())) {
            createBitmap.recycle();
        }
        return createBitmap2;
    }

    private void a(Notification notification, PendingIntent pendingIntent, boolean z16) {
        if (z16) {
            notification.contentView.setOnClickPendingIntent(this.f380744c.b("notification_root"), pendingIntent);
        } else {
            notification.contentIntent = pendingIntent;
        }
    }

    protected String a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        try {
            return this.f380745d.getString(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    protected String a(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) objArr);
        }
        try {
            return this.f380745d.getString(i3, objArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
