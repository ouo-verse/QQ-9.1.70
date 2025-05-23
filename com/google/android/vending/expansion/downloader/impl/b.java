package com.google.android.vending.expansion.downloader.impl;

import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Messenger;
import androidx.core.app.NotificationCompat;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import n1.d;
import n1.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements e {

    /* renamed from: m, reason: collision with root package name */
    static final int f34584m = -908767821;

    /* renamed from: a, reason: collision with root package name */
    private int f34585a = -1;

    /* renamed from: b, reason: collision with root package name */
    private final Context f34586b;

    /* renamed from: c, reason: collision with root package name */
    private final NotificationManager f34587c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f34588d;

    /* renamed from: e, reason: collision with root package name */
    private e f34589e;

    /* renamed from: f, reason: collision with root package name */
    private NotificationCompat.Builder f34590f;

    /* renamed from: g, reason: collision with root package name */
    private NotificationCompat.Builder f34591g;

    /* renamed from: h, reason: collision with root package name */
    private NotificationCompat.Builder f34592h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f34593i;

    /* renamed from: j, reason: collision with root package name */
    private String f34594j;

    /* renamed from: k, reason: collision with root package name */
    private DownloadProgressInfo f34595k;

    /* renamed from: l, reason: collision with root package name */
    private PendingIntent f34596l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, CharSequence charSequence) {
        this.f34586b = context;
        this.f34593i = charSequence;
        this.f34587c = (NotificationManager) context.getSystemService("notification");
        this.f34590f = new NotificationCompat.Builder(context);
        this.f34591g = new NotificationCompat.Builder(context);
        this.f34590f.setPriority(-1);
        this.f34590f.setCategory("progress");
        this.f34591g.setPriority(-1);
        this.f34591g.setCategory("progress");
        this.f34592h = this.f34591g;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    @Override // n1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3) {
        int i16;
        boolean z16;
        e eVar = this.f34589e;
        if (eVar != null) {
            eVar.a(i3);
        }
        if (i3 != this.f34585a) {
            this.f34585a = i3;
            if (i3 != 1 && this.f34596l != null) {
                int i17 = R.drawable.stat_sys_warning;
                if (i3 != 0) {
                    if (i3 != 7) {
                        if (i3 != 2 && i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    switch (i3) {
                                        case 15:
                                        case 16:
                                        case 17:
                                        case 18:
                                        case 19:
                                            i16 = d.f(i3);
                                            break;
                                        default:
                                            i16 = d.f(i3);
                                            break;
                                    }
                                }
                            } else {
                                i16 = d.f(i3);
                                i17 = R.drawable.stat_sys_download;
                            }
                            z16 = true;
                            this.f34594j = this.f34586b.getString(i16);
                            this.f34588d = this.f34593i;
                            this.f34592h.setTicker(((Object) this.f34593i) + MsgSummary.STR_COLON + this.f34594j);
                            this.f34592h.setSmallIcon(i17);
                            this.f34592h.setContentTitle(this.f34588d);
                            this.f34592h.setContentText(this.f34594j);
                            if (!z16) {
                            }
                            this.f34587c.notify(f34584m, this.f34592h.build());
                        }
                        i16 = d.f(i3);
                        z16 = true;
                        i17 = 17301634;
                        this.f34594j = this.f34586b.getString(i16);
                        this.f34588d = this.f34593i;
                        this.f34592h.setTicker(((Object) this.f34593i) + MsgSummary.STR_COLON + this.f34594j);
                        this.f34592h.setSmallIcon(i17);
                        this.f34592h.setContentTitle(this.f34588d);
                        this.f34592h.setContentText(this.f34594j);
                        if (!z16) {
                            this.f34592h.setOngoing(true);
                        } else {
                            this.f34592h.setOngoing(false);
                            this.f34592h.setAutoCancel(true);
                        }
                        this.f34587c.notify(f34584m, this.f34592h.build());
                    }
                    i16 = d.f(i3);
                    z16 = false;
                    i17 = 17301634;
                    this.f34594j = this.f34586b.getString(i16);
                    this.f34588d = this.f34593i;
                    this.f34592h.setTicker(((Object) this.f34593i) + MsgSummary.STR_COLON + this.f34594j);
                    this.f34592h.setSmallIcon(i17);
                    this.f34592h.setContentTitle(this.f34588d);
                    this.f34592h.setContentText(this.f34594j);
                    if (!z16) {
                    }
                    this.f34587c.notify(f34584m, this.f34592h.build());
                }
                i16 = com.tencent.mobileqq.R.string.f228436tq;
                z16 = false;
                this.f34594j = this.f34586b.getString(i16);
                this.f34588d = this.f34593i;
                this.f34592h.setTicker(((Object) this.f34593i) + MsgSummary.STR_COLON + this.f34594j);
                this.f34592h.setSmallIcon(i17);
                this.f34592h.setContentTitle(this.f34588d);
                this.f34592h.setContentText(this.f34594j);
                if (!z16) {
                }
                this.f34587c.notify(f34584m, this.f34592h.build());
            }
        }
    }

    @Override // n1.e
    public void b(DownloadProgressInfo downloadProgressInfo) {
        this.f34595k = downloadProgressInfo;
        e eVar = this.f34589e;
        if (eVar != null) {
            eVar.b(downloadProgressInfo);
        }
        long j3 = downloadProgressInfo.f34532d;
        if (j3 <= 0) {
            this.f34591g.setTicker(this.f34588d);
            this.f34591g.setSmallIcon(R.drawable.stat_sys_download);
            this.f34591g.setContentTitle(this.f34588d);
            this.f34591g.setContentText(this.f34594j);
            this.f34592h = this.f34591g;
        } else {
            this.f34590f.setProgress((int) j3, (int) downloadProgressInfo.f34533e, false);
            this.f34590f.setContentText(d.e(downloadProgressInfo.f34533e, downloadProgressInfo.f34532d));
            this.f34590f.setSmallIcon(R.drawable.stat_sys_download);
            this.f34590f.setTicker(((Object) this.f34593i) + MsgSummary.STR_COLON + this.f34594j);
            this.f34590f.setContentTitle(this.f34593i);
            this.f34590f.setContentInfo(this.f34586b.getString(com.tencent.mobileqq.R.string.f23152723, d.i(downloadProgressInfo.f34534f)));
            this.f34592h = this.f34590f;
        }
        this.f34587c.notify(f34584m, this.f34592h.build());
    }

    public void c() {
        e eVar = this.f34589e;
        if (eVar != null) {
            eVar.a(this.f34585a);
        }
    }

    public void d(PendingIntent pendingIntent) {
        this.f34591g.setContentIntent(pendingIntent);
        this.f34590f.setContentIntent(pendingIntent);
        this.f34596l = pendingIntent;
    }

    public void e(Messenger messenger) {
        e a16 = n1.b.a(messenger);
        this.f34589e = a16;
        DownloadProgressInfo downloadProgressInfo = this.f34595k;
        if (downloadProgressInfo != null) {
            a16.b(downloadProgressInfo);
        }
        int i3 = this.f34585a;
        if (i3 != -1) {
            this.f34589e.a(i3);
        }
    }
}
