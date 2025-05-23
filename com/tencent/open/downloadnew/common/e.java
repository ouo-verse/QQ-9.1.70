package com.tencent.open.downloadnew.common;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.mobileqq.R;
import com.tencent.open.base.f;
import com.tencent.open.base.j;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    protected NoticeParam f341490a;

    /* renamed from: b, reason: collision with root package name */
    protected Notification f341491b;

    public e() {
        this.f341490a = new NoticeParam();
    }

    protected String a(int i3) {
        return com.tencent.open.adapter.a.f().e().getString(i3);
    }

    protected String b(int i3, Object... objArr) {
        return com.tencent.open.adapter.a.f().e().getString(i3, objArr);
    }

    protected void c(Notification notification, PendingIntent pendingIntent, boolean z16) {
        if (z16) {
            notification.contentView.setOnClickPendingIntent(R.id.notification_root, pendingIntent);
        } else {
            notification.contentIntent = pendingIntent;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        Bundle data = message.getData();
        String string = data.getString(com.tencent.open.downloadnew.e.f341493b);
        f.h("NoticeUpdateHandler", "+++++what:" + message.what + "+++++" + data);
        DownloadInfo w3 = DownloadManager.C().w(string);
        if (w3 != null) {
            if (w3.Z == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
                f.a("NoticeUpdateHandler", "notification isShowNotification=" + w3.Z);
                return;
            }
            NoticeParam noticeParam = this.f341490a;
            noticeParam.f341445d = w3.f341184e;
            noticeParam.f341446e = w3.f341191i;
            noticeParam.f341448h = w3.f341189h;
            noticeParam.f341450m = 1;
            noticeParam.D = w3.f341196m;
            noticeParam.C = 1;
            noticeParam.F = w3.R;
            noticeParam.E = w3.D;
            noticeParam.G = w3.C;
            noticeParam.f341449i = w3.f341186f;
            try {
                if (this.f341491b == null) {
                    this.f341491b = a.e().f(this.f341490a);
                } else {
                    RemoteViews remoteViews = new RemoteViews(com.tencent.open.adapter.a.f().e().getPackageName(), R.layout.qapp_center_notification);
                    a.e().l(remoteViews);
                    remoteViews.setInt(R.id.notification_root, "setBackgroundColor", -1);
                    remoteViews.setInt(R.id.notification_title, "setTextColor", -16777216);
                    remoteViews.setInt(R.id.notification_progress, "setTextColor", -12303292);
                    remoteViews.setInt(R.id.notification_content, "setTextColor", -12303292);
                    this.f341491b.contentView = remoteViews;
                }
            } catch (Exception e16) {
                f.d("NoticeUpdateHandler", "init Notification>>>", e16);
            }
            Notification notification = this.f341491b;
            if (notification == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == -2) {
                f.e("NoticeUpdateHandler", ">>error:" + this.f341490a.f341445d);
                this.f341491b.contentView.setViewVisibility(R.id.notification_content, 0);
                this.f341491b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                this.f341491b.contentView.setViewVisibility(R.id.notification_progress, 8);
                this.f341491b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload_error);
                String str = (String) message.obj;
                if (TextUtils.isEmpty(str)) {
                    str = a(R.string.download_err_unknown);
                }
                this.f341491b.tickerText = b(R.string.notification_tickerText_download_err, str);
                this.f341491b.contentView.setTextViewText(R.id.notification_content, b(R.string.notification_content_download_err_suffix, str));
                this.f341491b.contentView.setTextViewText(R.id.notification_title, j.i(w3.f341191i, 18, true));
                c(this.f341491b, c.b(1, this.f341490a), true);
                this.f341491b.flags = 16 & (-3);
                a.e().b(this.f341490a.D);
            } else {
                if (i3 == 6) {
                    a.e().a(this.f341490a.D);
                    return;
                }
                if (i3 == 20) {
                    notification.tickerText = b(R.string.notification_tickerText_download_prefix, w3.f341191i);
                    this.f341491b.contentView.setViewVisibility(R.id.notification_content, 0);
                    this.f341491b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                    this.f341491b.contentView.setViewVisibility(R.id.notification_progress, 8);
                    this.f341491b.contentView.setTextViewText(R.id.notification_title, j.i(b(R.string.notification_title_download_prefix, w3.f341191i), 18, true));
                    this.f341491b.contentView.setTextViewText(R.id.notification_content, a(R.string.download_wait));
                    this.f341491b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                    c(this.f341491b, c.b(2, this.f341490a), true);
                    this.f341491b.flags = 32 | 2;
                    a.e().b(this.f341490a.D);
                } else if (i3 == 2) {
                    f.e("NoticeUpdateHandler", ">>downloading:" + this.f341490a.f341445d);
                    f.a("NoticeUpdateHandler", "size = " + w3.Q + " content = ");
                    this.f341491b.tickerText = b(R.string.notification_tickerText_download_prefix, w3.f341191i);
                    this.f341491b.contentView.setViewVisibility(R.id.notification_content, 8);
                    this.f341491b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 0);
                    this.f341491b.contentView.setViewVisibility(R.id.notification_progress, 0);
                    this.f341491b.contentView.setProgressBar(R.id.notif_pro_bar, 100, w3.Q, false);
                    this.f341491b.contentView.setTextViewText(R.id.notification_progress, ((w3.Q * 100) / 100) + "%");
                    this.f341491b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                    this.f341491b.contentView.setTextViewText(R.id.notification_title, j.i(b(R.string.notification_title_download_prefix, w3.f341191i), 18, true));
                    c(this.f341491b, c.b(2, this.f341490a), true);
                    if (!TextUtils.isEmpty("")) {
                        this.f341491b.contentView.setViewVisibility(R.id.notification_content, 0);
                        this.f341491b.contentView.setTextViewText(R.id.notification_content, Html.fromHtml(""));
                    } else {
                        this.f341491b.contentView.setViewVisibility(R.id.notification_content, 8);
                    }
                    this.f341491b.flags = 32 | 2;
                } else if (i3 == 3) {
                    f.e("NoticeUpdateHandler", ">>pause:" + this.f341490a.f341445d);
                    this.f341491b.tickerText = a(R.string.notification_content_download_pause);
                    this.f341491b.contentView.setViewVisibility(R.id.notification_content, 0);
                    this.f341491b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                    this.f341491b.contentView.setViewVisibility(R.id.notification_progress, 8);
                    this.f341491b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload_pause);
                    this.f341491b.contentView.setTextViewText(R.id.notification_title, j.i(w3.f341191i, 18, true));
                    this.f341491b.contentView.setTextViewText(R.id.notification_content, a(R.string.notification_content_download_pause));
                    c(this.f341491b, c.b(1, this.f341490a), true);
                    this.f341491b.flags = 16 & (-3);
                    a.e().b(this.f341490a.D);
                } else if (i3 == 4) {
                    f.e("NoticeUpdateHandler", ">>complete:" + this.f341490a.f341445d);
                    this.f341490a.C = 3;
                    Notification f16 = a.e().f(this.f341490a);
                    this.f341491b = f16;
                    if (f16 == null) {
                        return;
                    }
                    f16.tickerText = a(R.string.notification_tickerText_download_complete);
                    this.f341491b.contentView.setViewVisibility(R.id.notification_content, 0);
                    this.f341491b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                    this.f341491b.contentView.setViewVisibility(R.id.notification_progress, 8);
                    this.f341491b.contentView.setTextViewText(R.id.notification_content, a(R.string.notification_content_download_complete));
                    this.f341491b.contentView.setTextViewText(R.id.notification_title, j.i(w3.f341191i, 18, true));
                    c(this.f341491b, c.b(4, this.f341490a), false);
                    Bitmap c16 = com.tencent.open.base.d.c(this.f341490a.f341445d);
                    if (c16 != null) {
                        this.f341491b.contentView.setImageViewBitmap(R.id.notification_icon, c16);
                    } else {
                        f.e("NoticeUpdateHandler", ">>download icon fail,so we use default notification icon");
                        this.f341491b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                    }
                    this.f341491b.flags = 16 & (-3);
                    a.e().b(this.f341490a.D);
                }
            }
            a e17 = a.e();
            NoticeParam noticeParam2 = this.f341490a;
            int g16 = e17.g(noticeParam2.D, noticeParam2.C, noticeParam2.f341445d);
            a e18 = a.e();
            NoticeParam noticeParam3 = this.f341490a;
            this.f341491b.when = e18.i(noticeParam3.D, noticeParam3.C, noticeParam3.f341445d);
            a.e().j(g16, this.f341491b);
            f.a("NoticeUpdateHandler", "notify key=" + this.f341490a.D + " type=" + this.f341490a.C + "appid=" + this.f341490a.f341445d);
        }
    }

    public e(Looper looper) {
        super(looper);
        this.f341490a = new NoticeParam();
    }
}
