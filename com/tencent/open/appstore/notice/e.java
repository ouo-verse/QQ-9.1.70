package com.tencent.open.appstore.notice;

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
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.j;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.NoticeParam;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends Handler {

    /* renamed from: a, reason: collision with root package name */
    protected NoticeParam f340920a;

    /* renamed from: b, reason: collision with root package name */
    protected Notification f340921b;

    public e() {
        this.f340920a = new NoticeParam();
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
        String string = data.getString(com.tencent.open.downloadnew.e.f341492a);
        com.tencent.open.base.f.h("NoticeHintHandler", "+++++what:" + message.what + "+++++" + data);
        DownloadInfo R = DownloadManagerV2.V().R(string);
        if (R != null) {
            if (R.Z == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
                com.tencent.open.base.f.a("NoticeHintHandler", "notification isShowNotification=" + R.Z);
                return;
            }
            NoticeParam noticeParam = this.f340920a;
            noticeParam.f341445d = R.f341184e;
            noticeParam.f341446e = R.f341191i;
            noticeParam.f341448h = R.f341189h;
            noticeParam.f341450m = 1;
            noticeParam.D = R.f341196m;
            noticeParam.C = 1;
            noticeParam.F = R.R;
            noticeParam.E = R.D;
            noticeParam.G = R.C;
            noticeParam.f341449i = R.f341186f;
            try {
                if (this.f340921b == null) {
                    this.f340921b = com.tencent.open.downloadnew.common.a.e().f(this.f340920a);
                } else {
                    RemoteViews remoteViews = new RemoteViews(com.tencent.open.adapter.a.f().e().getPackageName(), R.layout.qapp_center_notification);
                    com.tencent.open.downloadnew.common.a.e().l(remoteViews);
                    remoteViews.setInt(R.id.notification_root, "setBackgroundColor", -1);
                    remoteViews.setInt(R.id.notification_title, "setTextColor", -16777216);
                    remoteViews.setInt(R.id.notification_progress, "setTextColor", -12303292);
                    remoteViews.setInt(R.id.notification_content, "setTextColor", -12303292);
                    this.f340921b.contentView = remoteViews;
                }
            } catch (Exception e16) {
                com.tencent.open.base.f.d("NoticeHintHandler", "init Notification>>>", e16);
            }
            Notification notification = this.f340921b;
            if (notification == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == -2) {
                com.tencent.open.base.f.e("NoticeHintHandler", ">>error:" + this.f340920a.f341445d);
                this.f340921b.contentView.setViewVisibility(R.id.notification_content, 0);
                this.f340921b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                this.f340921b.contentView.setViewVisibility(R.id.notification_progress, 8);
                this.f340921b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload_error);
                String str = (String) message.obj;
                if (TextUtils.isEmpty(str)) {
                    str = a(R.string.download_err_unknown);
                }
                this.f340921b.tickerText = b(R.string.notification_tickerText_download_err, str);
                this.f340921b.contentView.setTextViewText(R.id.notification_content, b(R.string.notification_content_download_err_suffix, str));
                this.f340921b.contentView.setTextViewText(R.id.notification_title, j.i(R.f341191i, 18, true));
                c(this.f340921b, com.tencent.open.downloadnew.common.c.b(1, this.f340920a), true);
                this.f340921b.flags = 16 & (-3);
                com.tencent.open.downloadnew.common.a.e().b(this.f340920a.D);
            } else {
                if (i3 == 6) {
                    com.tencent.open.downloadnew.common.a.e().a(this.f340920a.D);
                    return;
                }
                if (i3 == 20) {
                    notification.tickerText = b(R.string.notification_tickerText_download_prefix, R.f341191i);
                    this.f340921b.contentView.setViewVisibility(R.id.notification_content, 0);
                    this.f340921b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                    this.f340921b.contentView.setViewVisibility(R.id.notification_progress, 8);
                    this.f340921b.contentView.setTextViewText(R.id.notification_title, j.i(b(R.string.notification_title_download_prefix, R.f341191i), 18, true));
                    this.f340921b.contentView.setTextViewText(R.id.notification_content, a(R.string.download_wait));
                    this.f340921b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                    c(this.f340921b, com.tencent.open.downloadnew.common.c.b(2, this.f340920a), true);
                    this.f340921b.flags = 32 | 2;
                    com.tencent.open.downloadnew.common.a.e().b(this.f340920a.D);
                } else if (i3 == 2) {
                    com.tencent.open.base.f.e("NoticeHintHandler", ">>downloading:" + this.f340920a.f341445d);
                    com.tencent.open.base.f.a("NoticeHintHandler", "size = " + R.Q + " content = ");
                    this.f340921b.tickerText = b(R.string.notification_tickerText_download_prefix, R.f341191i);
                    this.f340921b.contentView.setViewVisibility(R.id.notification_content, 8);
                    this.f340921b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 0);
                    this.f340921b.contentView.setViewVisibility(R.id.notification_progress, 0);
                    this.f340921b.contentView.setProgressBar(R.id.notif_pro_bar, 100, R.Q, false);
                    this.f340921b.contentView.setTextViewText(R.id.notification_progress, ((R.Q * 100) / 100) + "%");
                    this.f340921b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                    this.f340921b.contentView.setTextViewText(R.id.notification_title, j.i(b(R.string.notification_title_download_prefix, R.f341191i), 18, true));
                    c(this.f340921b, com.tencent.open.downloadnew.common.c.b(2, this.f340920a), true);
                    if (!TextUtils.isEmpty("")) {
                        this.f340921b.contentView.setViewVisibility(R.id.notification_content, 0);
                        this.f340921b.contentView.setTextViewText(R.id.notification_content, Html.fromHtml(""));
                    } else {
                        this.f340921b.contentView.setViewVisibility(R.id.notification_content, 8);
                    }
                    this.f340921b.flags = 32 | 2;
                } else if (i3 == 3) {
                    com.tencent.open.base.f.e("NoticeHintHandler", ">>pause:" + this.f340920a.f341445d);
                    this.f340921b.tickerText = a(R.string.notification_content_download_pause);
                    this.f340921b.contentView.setViewVisibility(R.id.notification_content, 0);
                    this.f340921b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                    this.f340921b.contentView.setViewVisibility(R.id.notification_progress, 8);
                    this.f340921b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload_pause);
                    this.f340921b.contentView.setTextViewText(R.id.notification_title, j.i(R.f341191i, 18, true));
                    this.f340921b.contentView.setTextViewText(R.id.notification_content, a(R.string.notification_content_download_pause));
                    c(this.f340921b, com.tencent.open.downloadnew.common.c.b(1, this.f340920a), true);
                    this.f340921b.flags = 16 & (-3);
                    com.tencent.open.downloadnew.common.a.e().b(this.f340920a.D);
                } else if (i3 == 4) {
                    com.tencent.open.base.f.e("NoticeHintHandler", ">>complete:" + this.f340920a.f341445d);
                    this.f340920a.C = 3;
                    Notification f16 = com.tencent.open.downloadnew.common.a.e().f(this.f340920a);
                    this.f340921b = f16;
                    if (f16 == null) {
                        return;
                    }
                    f16.tickerText = a(R.string.notification_tickerText_download_complete);
                    this.f340921b.contentView.setViewVisibility(R.id.notification_content, 0);
                    this.f340921b.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                    this.f340921b.contentView.setViewVisibility(R.id.notification_progress, 8);
                    this.f340921b.contentView.setTextViewText(R.id.notification_content, a(R.string.notification_content_download_complete));
                    this.f340921b.contentView.setTextViewText(R.id.notification_title, j.i(R.f341191i, 18, true));
                    c(this.f340921b, com.tencent.open.downloadnew.common.c.b(4, this.f340920a), false);
                    Bitmap c16 = com.tencent.open.base.d.c(this.f340920a.f341445d);
                    if (c16 != null) {
                        this.f340921b.contentView.setImageViewBitmap(R.id.notification_icon, c16);
                    } else {
                        com.tencent.open.base.f.e("NoticeHintHandler", ">>download icon fail,so we use default notification icon");
                        this.f340921b.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                    }
                    this.f340921b.flags = 16 & (-3);
                    com.tencent.open.downloadnew.common.a.e().b(this.f340920a.D);
                }
            }
            com.tencent.open.downloadnew.common.a e17 = com.tencent.open.downloadnew.common.a.e();
            NoticeParam noticeParam2 = this.f340920a;
            int g16 = e17.g(noticeParam2.D, noticeParam2.C, noticeParam2.f341445d);
            com.tencent.open.downloadnew.common.a e18 = com.tencent.open.downloadnew.common.a.e();
            NoticeParam noticeParam3 = this.f340920a;
            this.f340921b.when = e18.i(noticeParam3.D, noticeParam3.C, noticeParam3.f341445d);
            com.tencent.open.downloadnew.common.a.e().j(g16, this.f340921b);
            com.tencent.open.base.f.a("NoticeHintHandler", "notify key=" + this.f340920a.D + " type=" + this.f340920a.C + "appid=" + this.f340920a.f341445d);
        }
    }

    public e(Looper looper) {
        super(looper);
        this.f340920a = new NoticeParam();
    }
}
