package com.tencent.open.appstore.notice;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.base.j;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.NoticeParam;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    protected NoticeParam f340912a;

    /* renamed from: b, reason: collision with root package name */
    protected Notification f340913b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f340914c;

    public c(Looper looper) {
        super(looper);
        this.f340912a = new NoticeParam();
    }

    private void a() {
        if (this.f340914c) {
            com.tencent.open.downloadnew.common.a.e().a(this.f340912a.D);
        }
    }

    private void b(String str, String str2) {
        this.f340913b.contentView.setViewVisibility(R.id.sbz, 0);
        this.f340913b.contentView.setViewVisibility(R.id.sbx, 8);
        this.f340913b.contentView.setViewVisibility(R.id.f163985sc1, 8);
        this.f340913b.contentView.setViewVisibility(R.id.sby, 4);
        this.f340913b.contentView.setImageViewResource(R.id.f163984sc0, R.drawable.qfile_file_ufdownload_error);
        if (TextUtils.isEmpty(str2)) {
            str2 = h(R.string.download_err_unknown);
        }
        this.f340913b.tickerText = i(R.string.notification_tickerText_download_err, str2);
        this.f340913b.contentView.setTextViewText(R.id.sbz, i(R.string.notification_content_download_err_suffix, str2));
        this.f340913b.contentView.setTextViewText(R.id.f163987sc3, j.i(str, 18, true));
        NoticeParam noticeParam = this.f340912a;
        noticeParam.J = 1;
        l(this.f340913b, com.tencent.open.downloadnew.common.c.b(1, noticeParam), true);
        this.f340913b.flags = 16 & (-3);
        com.tencent.open.downloadnew.common.a.e().b(this.f340912a.D);
    }

    private void c(String str, int i3, int i16) {
        this.f340913b.tickerText = h(R.string.f171362nj);
        this.f340913b.contentView.setViewVisibility(R.id.sbz, 8);
        this.f340913b.contentView.setViewVisibility(R.id.sbx, 0);
        this.f340913b.contentView.setViewVisibility(R.id.f163985sc1, 0);
        this.f340913b.contentView.setViewVisibility(R.id.sby, 0);
        this.f340913b.contentView.setImageViewResource(R.id.f163984sc0, R.drawable.qfile_file_ufdownload_pause);
        this.f340913b.contentView.setProgressBar(R.id.sbw, 100, i3, false);
        this.f340913b.contentView.setTextViewText(R.id.f163985sc1, ((i3 * i16) / 100.0d) + "M / " + i16 + "M\uff0c" + h(R.string.f171362nj));
        this.f340913b.contentView.setTextViewText(R.id.f163987sc3, j.i(str, 18, true));
        this.f340913b.contentView.setCharSequence(R.id.sby, IECSearchBar.METHOD_SET_TEXT, "\u7ee7\u7eed");
        NoticeParam noticeParam = this.f340912a;
        noticeParam.J = 1;
        l(this.f340913b, com.tencent.open.downloadnew.common.c.b(1, noticeParam), true);
        NoticeParam noticeParam2 = this.f340912a;
        noticeParam2.J = 2;
        k(this.f340913b, com.tencent.open.downloadnew.common.c.b(1, noticeParam2), true);
        this.f340913b.flags = 2 | 32;
        com.tencent.open.downloadnew.common.a.e().b(this.f340912a.D);
    }

    private void d(String str) {
        this.f340913b.tickerText = i(R.string.notification_tickerText_download_prefix, str);
        this.f340913b.contentView.setViewVisibility(R.id.sbz, 0);
        this.f340913b.contentView.setViewVisibility(R.id.sbx, 8);
        this.f340913b.contentView.setViewVisibility(R.id.f163985sc1, 8);
        this.f340913b.contentView.setViewVisibility(R.id.sby, 4);
        this.f340913b.contentView.setTextViewText(R.id.f163987sc3, j.i(str, 18, true));
        this.f340913b.contentView.setTextViewText(R.id.sbz, h(R.string.download_wait));
        this.f340913b.contentView.setImageViewResource(R.id.f163984sc0, R.drawable.qfile_file_ufdownload);
        NoticeParam noticeParam = this.f340912a;
        noticeParam.J = 1;
        l(this.f340913b, com.tencent.open.downloadnew.common.c.b(2, noticeParam), true);
        this.f340913b.flags = 32 | 2;
        com.tencent.open.downloadnew.common.a.e().b(this.f340912a.D);
    }

    private void e(String str) {
        this.f340913b.tickerText = h(R.string.notification_tickerText_download_complete);
        this.f340913b.contentView.setViewVisibility(R.id.sbz, 0);
        this.f340913b.contentView.setViewVisibility(R.id.sbx, 8);
        this.f340913b.contentView.setViewVisibility(R.id.f163985sc1, 8);
        this.f340913b.contentView.setViewVisibility(R.id.sby, 0);
        this.f340913b.contentView.setTextViewText(R.id.sbz, h(R.string.notification_content_download_complete));
        this.f340913b.contentView.setTextViewText(R.id.f163987sc3, j.i(str, 18, true));
        this.f340913b.contentView.setCharSequence(R.id.sby, IECSearchBar.METHOD_SET_TEXT, "\u5b89\u88c5");
        NoticeParam noticeParam = this.f340912a;
        noticeParam.J = 1;
        l(this.f340913b, com.tencent.open.downloadnew.common.c.b(4, noticeParam), true);
        NoticeParam noticeParam2 = this.f340912a;
        noticeParam2.J = 2;
        k(this.f340913b, com.tencent.open.downloadnew.common.c.b(4, noticeParam2), true);
        Bitmap c16 = com.tencent.open.base.d.c(this.f340912a.f341445d);
        if (c16 != null) {
            this.f340913b.contentView.setImageViewBitmap(R.id.f163984sc0, c16);
        } else {
            com.tencent.open.base.f.e("AdNoticeHandler", ">>download icon fail,so we use default notification icon");
            this.f340913b.contentView.setImageViewResource(R.id.f163984sc0, R.drawable.qfile_file_ufdownload);
        }
        this.f340913b.flags = 16;
        com.tencent.open.downloadnew.common.a.e().b(this.f340912a.D);
    }

    private void f(String str, int i3, int i16) {
        this.f340913b.tickerText = i(R.string.notification_tickerText_download_prefix, str);
        this.f340913b.contentView.setViewVisibility(R.id.sbz, 8);
        this.f340913b.contentView.setViewVisibility(R.id.sbx, 0);
        this.f340913b.contentView.setViewVisibility(R.id.f163985sc1, 0);
        this.f340913b.contentView.setViewVisibility(R.id.sby, 4);
        this.f340913b.contentView.setProgressBar(R.id.sbw, 100, i3, false);
        this.f340913b.contentView.setTextViewText(R.id.f163987sc3, j.i(str, 18, true));
        this.f340913b.contentView.setImageViewResource(R.id.f163984sc0, R.drawable.qfile_file_ufdownload);
        this.f340913b.contentView.setTextViewText(R.id.f163985sc1, ((i3 * i16) / 100.0d) + "M / " + i16 + "M\uff0c\u6b63\u5728\u4e0b\u8f7d\u4e2d");
        NoticeParam noticeParam = this.f340912a;
        noticeParam.J = 1;
        l(this.f340913b, com.tencent.open.downloadnew.common.c.b(2, noticeParam), true);
        this.f340913b.flags = 32 | 2;
    }

    private Notification g(NoticeParam noticeParam) {
        RemoteViews remoteViews;
        if (com.tencent.open.adapter.a.f().e() != null && noticeParam != null) {
            com.tencent.open.base.f.e("AdNoticeHandler", "getAdNotification");
            Notification notification = new Notification();
            notification.tickerText = noticeParam.f341446e;
            notification.when = noticeParam.E;
            notification.icon = R.drawable.qfile_file_ufdownload_top;
            if (Build.VERSION.SDK_INT >= 31) {
                remoteViews = new RemoteViews(com.tencent.open.adapter.a.f().e().getPackageName(), R.layout.i9a);
            } else {
                remoteViews = new RemoteViews(com.tencent.open.adapter.a.f().e().getPackageName(), R.layout.i9_);
                remoteViews.setInt(R.id.f163986sc2, "setBackgroundColor", -1);
                remoteViews.setInt(R.id.f163987sc3, "setTextColor", -16777216);
                remoteViews.setFloat(R.id.sbz, "setTextSize", 14.0f);
                remoteViews.setFloat(R.id.f163987sc3, "setTextSize", 16.0f);
                remoteViews.setFloat(R.id.f163985sc1, "setTextSize", 10.0f);
                remoteViews.setFloat(R.id.sby, "setTextSize", 14.0f);
            }
            notification.contentView = remoteViews;
            remoteViews.setOnClickPendingIntent(R.id.f163986sc2, com.tencent.open.downloadnew.common.c.b(1, noticeParam));
            QQNotificationManager.addChannelIfNeed(notification, QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
            return notification;
        }
        com.tencent.open.base.f.c("AdNoticeHandler", "getAdNotification context == null");
        return null;
    }

    private void j() {
        this.f340913b.contentView.setViewVisibility(R.id.sbz, 0);
        this.f340913b.contentView.setViewVisibility(R.id.sbx, 8);
        this.f340913b.contentView.setViewVisibility(R.id.f163985sc1, 8);
        this.f340913b.contentView.setViewVisibility(R.id.sby, 0);
        this.f340913b.contentView.setString(R.id.sby, IECSearchBar.METHOD_SET_TEXT, "\u6253\u5f00");
        this.f340913b.contentView.setTextViewText(R.id.sbz, h(R.string.f171182n2));
        NoticeParam noticeParam = this.f340912a;
        noticeParam.J = 1;
        l(this.f340913b, com.tencent.open.downloadnew.common.c.b(6, noticeParam), true);
        NoticeParam noticeParam2 = this.f340912a;
        noticeParam2.J = 2;
        k(this.f340913b, com.tencent.open.downloadnew.common.c.b(6, noticeParam2), true);
        this.f340913b.flags = 16;
        com.tencent.open.downloadnew.common.a.e().a(this.f340912a.D);
    }

    protected String h(int i3) {
        return com.tencent.open.adapter.a.f().e().getString(i3);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z16;
        RemoteViews remoteViews;
        super.handleMessage(message);
        Bundle data = message.getData();
        DownloadInfo R = DownloadManagerV2.V().R(data.getString(com.tencent.open.downloadnew.e.f341492a));
        if (R == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f340914c = z16;
        if (R == null) {
            R = (DownloadInfo) data.getParcelable("downloadInfo");
        }
        if (R == null) {
            return;
        }
        if (R.Z == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
            com.tencent.open.base.f.a("AdNoticeHandler", "notification isShowNotification=" + R.Z);
            return;
        }
        this.f340912a.I = data.getBoolean("is_New_Downloader", false) ? 1 : 0;
        NoticeParam noticeParam = this.f340912a;
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
        noticeParam.H = R.N;
        try {
            if (this.f340913b == null) {
                this.f340913b = g(noticeParam);
            } else {
                if (Build.VERSION.SDK_INT >= 31) {
                    remoteViews = new RemoteViews(com.tencent.open.adapter.a.f().e().getPackageName(), R.layout.i9a);
                } else {
                    RemoteViews remoteViews2 = new RemoteViews(com.tencent.open.adapter.a.f().e().getPackageName(), R.layout.i9_);
                    remoteViews2.setInt(R.id.f163986sc2, "setBackgroundColor", -1);
                    remoteViews2.setInt(R.id.f163987sc3, "setTextColor", -16777216);
                    remoteViews2.setFloat(R.id.sbz, "setTextSize", 14.0f);
                    remoteViews2.setFloat(R.id.f163987sc3, "setTextSize", 16.0f);
                    remoteViews2.setFloat(R.id.f163985sc1, "setTextSize", 10.0f);
                    remoteViews2.setFloat(R.id.sby, "setTextSize", 14.0f);
                    remoteViews = remoteViews2;
                }
                this.f340913b.contentView = remoteViews;
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d("AdNoticeHandler", "init Notification>>>", e16);
        }
        if (this.f340913b == null) {
            return;
        }
        int i3 = ((int) R.f341180b0) / 1048576;
        int i16 = message.what;
        if (i16 != -2) {
            if (i16 != 6) {
                if (i16 != 10) {
                    if (i16 != 20) {
                        if (i16 != 30) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    if (i16 == 4) {
                                        com.tencent.open.base.f.e("AdNoticeHandler", ">>complete:" + this.f340912a.f341445d);
                                        e(R.f341191i);
                                    }
                                } else {
                                    com.tencent.open.base.f.e("AdNoticeHandler", ">>pause:" + this.f340912a.f341445d);
                                    c(R.f341191i, R.Q, i3);
                                }
                            } else {
                                com.tencent.open.base.f.e("AdNoticeHandler", ">>downloading:" + this.f340912a.f341445d);
                                f(R.f341191i, R.Q, i3);
                            }
                        }
                    } else {
                        com.tencent.open.base.f.e("AdNoticeHandler", ">>downloadwait:" + this.f340912a.f341445d);
                        d(R.f341191i);
                    }
                }
                com.tencent.open.base.f.e("AdNoticeHandler", ">>package:" + this.f340912a.f341445d);
                a();
                return;
            }
            com.tencent.open.base.f.e("AdNoticeHandler", ">>package:" + this.f340912a.f341445d);
            j();
        } else {
            com.tencent.open.base.f.e("AdNoticeHandler", ">>error:" + this.f340912a.f341445d);
            b(R.f341191i, (String) message.obj);
        }
        com.tencent.open.downloadnew.common.a e17 = com.tencent.open.downloadnew.common.a.e();
        NoticeParam noticeParam2 = this.f340912a;
        int g16 = e17.g(noticeParam2.D, noticeParam2.C, noticeParam2.f341445d);
        com.tencent.open.downloadnew.common.a e18 = com.tencent.open.downloadnew.common.a.e();
        NoticeParam noticeParam3 = this.f340912a;
        this.f340913b.when = e18.i(noticeParam3.D, noticeParam3.C, noticeParam3.f341445d);
        com.tencent.open.downloadnew.common.a.e().j(g16, this.f340913b);
        com.tencent.open.base.f.a("AdNoticeHandler", "notify key=" + this.f340912a.D + " type=" + this.f340912a.C + "appid=" + this.f340912a.f341445d);
    }

    protected String i(int i3, Object... objArr) {
        return com.tencent.open.adapter.a.f().e().getString(i3, objArr);
    }

    protected void k(Notification notification, PendingIntent pendingIntent, boolean z16) {
        if (z16) {
            notification.contentView.setOnClickPendingIntent(R.id.sby, pendingIntent);
        } else {
            notification.contentIntent = pendingIntent;
        }
    }

    protected void l(Notification notification, PendingIntent pendingIntent, boolean z16) {
        if (z16) {
            notification.contentView.setOnClickPendingIntent(R.id.f163986sc2, pendingIntent);
        } else {
            notification.contentIntent = pendingIntent;
        }
    }
}
