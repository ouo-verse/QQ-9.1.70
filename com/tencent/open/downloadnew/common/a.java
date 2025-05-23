package com.tencent.open.downloadnew.common;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.open.base.f;
import com.tencent.open.base.j;
import com.tencent.util.BadgeUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    protected static a f341458d;

    /* renamed from: a, reason: collision with root package name */
    protected QQNotificationManager f341459a;

    /* renamed from: b, reason: collision with root package name */
    protected final ConcurrentHashMap<String, C9279a> f341460b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected b f341461c;

    /* compiled from: P */
    /* renamed from: com.tencent.open.downloadnew.common.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C9279a {

        /* renamed from: a, reason: collision with root package name */
        public String f341462a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f341463b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f341464c;

        /* renamed from: d, reason: collision with root package name */
        public int f341465d;

        /* renamed from: e, reason: collision with root package name */
        public long f341466e;

        public C9279a() {
        }

        public String toString() {
            return this.f341464c + "," + this.f341463b + "," + this.f341465d + "," + this.f341462a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        protected Integer f341468a = null;

        /* renamed from: b, reason: collision with root package name */
        protected float f341469b = 14.0f;

        /* renamed from: c, reason: collision with root package name */
        protected Integer f341470c = null;

        /* renamed from: d, reason: collision with root package name */
        protected float f341471d = 16.0f;

        /* renamed from: e, reason: collision with root package name */
        protected final String f341472e = "SearchForText";

        /* renamed from: f, reason: collision with root package name */
        protected final String f341473f = "SearchForTitle";

        /* renamed from: g, reason: collision with root package name */
        protected DisplayMetrics f341474g = new DisplayMetrics();

        b(Context context) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(this.f341474g);
            a(context);
        }

        protected void a(Context context) {
            if (this.f341468a != null && this.f341470c != null) {
                return;
            }
            try {
                ViewGroup viewGroup = (ViewGroup) new Notification.Builder(context).setWhen(System.currentTimeMillis()).setContentTitle("SearchForTitle").setContentText("SearchForText").setContentIntent(null).build().contentView.apply(context, null);
                g(viewGroup);
                f(viewGroup);
            } catch (Exception unused) {
            }
        }

        public Integer b() {
            return this.f341468a;
        }

        public float c() {
            return this.f341469b;
        }

        public Integer d() {
            return this.f341470c;
        }

        public float e() {
            return this.f341471d;
        }

        protected boolean f(ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (viewGroup.getChildAt(i3) instanceof TextView) {
                    TextView textView = (TextView) viewGroup.getChildAt(i3);
                    if ("SearchForText".equals(textView.getText().toString())) {
                        this.f341468a = Integer.valueOf(textView.getTextColors().getDefaultColor());
                        float textSize = textView.getTextSize();
                        this.f341469b = textSize;
                        this.f341469b = textSize / this.f341474g.scaledDensity;
                        return true;
                    }
                } else if ((viewGroup.getChildAt(i3) instanceof ViewGroup) && f((ViewGroup) viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
            return false;
        }

        protected boolean g(ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (viewGroup.getChildAt(i3) instanceof TextView) {
                    TextView textView = (TextView) viewGroup.getChildAt(i3);
                    if ("SearchForTitle".equals(textView.getText().toString())) {
                        this.f341470c = Integer.valueOf(textView.getTextColors().getDefaultColor());
                        float textSize = textView.getTextSize();
                        this.f341471d = textSize;
                        this.f341471d = textSize / this.f341474g.scaledDensity;
                        return true;
                    }
                } else if ((viewGroup.getChildAt(i3) instanceof ViewGroup) && g((ViewGroup) viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
            return false;
        }
    }

    protected a() {
        this.f341459a = null;
        this.f341459a = QQNotificationManager.getInstance();
    }

    private int c(String str) {
        f.e("AppNotificationManager", ">genNextNotificationId key:" + str);
        if (TextUtils.isEmpty(str)) {
            return 379;
        }
        int abs = Math.abs(str.hashCode()) % 98;
        f.e("AppNotificationManager", ">genNextNotificationId mod:" + abs);
        int i3 = abs + 379;
        f.e("AppNotificationManager", ">genNextNotificationId id:" + i3);
        return i3;
    }

    private Notification d(NoticeParam noticeParam) {
        f.e("AppNotificationManager", "getAdNotification");
        Notification notification = new Notification();
        notification.tickerText = noticeParam.f341446e;
        notification.when = noticeParam.E;
        notification.icon = R.drawable.qfile_file_ufdownload_top;
        RemoteViews remoteViews = new RemoteViews(com.tencent.open.adapter.a.f().e().getPackageName(), R.layout.i9_);
        remoteViews.setInt(R.id.f163986sc2, "setBackgroundColor", -1);
        remoteViews.setInt(R.id.f163987sc3, "setTextColor", -16777216);
        remoteViews.setFloat(R.id.sbz, "setTextSize", 14.0f);
        remoteViews.setFloat(R.id.f163987sc3, "setTextSize", 16.0f);
        remoteViews.setFloat(R.id.f163985sc1, "setTextSize", 10.0f);
        remoteViews.setFloat(R.id.sby, "setTextSize", 14.0f);
        notification.contentView = remoteViews;
        remoteViews.setOnClickPendingIntent(R.id.f163986sc2, c.b(1, noticeParam));
        QQNotificationManager.addChannelIfNeed(notification, QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
        return notification;
    }

    public static a e() {
        if (f341458d == null) {
            f341458d = new a();
        }
        return f341458d;
    }

    public void a(String str) {
        f.h("AppNotificationManager", "cancelBySendTime:" + str);
        if (this.f341459a != null && this.f341460b.containsKey(str) && this.f341460b.get(str) != null) {
            C9279a c9279a = this.f341460b.get(str);
            if (c9279a != null) {
                this.f341459a.cancel("AppNotificationManager_cancelBySendTime", c9279a.f341464c);
            }
            this.f341460b.remove(str);
        }
    }

    public void b(String str) {
        f.h("AppNotificationManager", "cancelBySendTime:" + str);
        if (this.f341459a != null && this.f341460b.containsKey(str)) {
            this.f341459a.cancel("AppNotificationManager_cancelNotRemoveId", this.f341460b.get(str).f341464c);
        }
    }

    public Notification f(NoticeParam noticeParam) {
        if (com.tencent.open.adapter.a.f().e() != null && noticeParam != null) {
            if (noticeParam.H == 1) {
                return d(noticeParam);
            }
            Notification notification = new Notification();
            notification.tickerText = noticeParam.f341446e;
            notification.when = noticeParam.E;
            RemoteViews remoteViews = new RemoteViews(com.tencent.open.adapter.a.f().e().getPackageName(), R.layout.qapp_center_notification);
            PendingIntent b16 = c.b(1, noticeParam);
            l(remoteViews);
            remoteViews.setInt(R.id.notification_root, "setBackgroundColor", -1);
            remoteViews.setInt(R.id.notification_title, "setTextColor", -16777216);
            remoteViews.setInt(R.id.notification_progress, "setTextColor", -12303292);
            remoteViews.setInt(R.id.notification_content, "setTextColor", -12303292);
            remoteViews.setTextViewText(R.id.notification_title, j.g(noticeParam.f341446e, 18, true, true));
            int i3 = noticeParam.C;
            if (i3 == 1) {
                notification.icon = R.drawable.qfile_file_ufdownload_top;
                remoteViews.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                remoteViews.setViewVisibility(R.id.notification_content, 8);
                remoteViews.setViewVisibility(R.id.notif_pro_bar_layout, 0);
                remoteViews.setOnClickPendingIntent(R.id.notification_root, b16);
            } else if (i3 != 0 && i3 != 2 && i3 != 3) {
                if (i3 == 4) {
                    notification.icon = R.drawable.qfile_file_ufdownload_top;
                    remoteViews.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                    remoteViews.setTextViewText(R.id.notification_content, com.tencent.open.adapter.a.f().e().getString(R.string.ckp));
                    remoteViews.setViewVisibility(R.id.notification_content, 0);
                    remoteViews.setViewVisibility(R.id.notif_pro_bar_layout, 8);
                    PendingIntent b17 = c.b(5, noticeParam);
                    notification.flags |= 16;
                    notification.contentIntent = b17;
                } else {
                    notification.icon = R.drawable.br_;
                    remoteViews.setImageViewResource(R.id.notification_icon, R.drawable.bra);
                    remoteViews.setTextViewText(R.id.notification_content, noticeParam.f341447f);
                    notification.contentIntent = b16;
                }
            } else {
                notification.icon = R.drawable.qfile_file_ufdownload_top;
                if (i3 == 0) {
                    remoteViews.setTextViewText(R.id.notification_content, com.tencent.open.adapter.a.f().e().getString(R.string.notification_content_download_complete));
                    notification.flags |= 16;
                    notification.defaults = notification.defaults | 1 | 4;
                    remoteViews.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                }
                if (noticeParam.C == 2) {
                    remoteViews.setTextViewText(R.id.notification_content, com.tencent.open.adapter.a.f().e().getString(R.string.ckt));
                    Bitmap d16 = com.tencent.open.business.base.a.d(noticeParam.f341448h);
                    if (d16 != null) {
                        remoteViews.setImageViewBitmap(R.id.notification_icon, d16);
                    }
                    notification.flags |= 16;
                    notification.defaults = notification.defaults | 1 | 4;
                    b16 = c.b(6, noticeParam);
                }
                if (noticeParam.C == 3) {
                    remoteViews.setTextViewText(R.id.notification_content, com.tencent.open.adapter.a.f().e().getString(R.string.notification_content_download_complete));
                    b16 = c.b(4, noticeParam);
                    Bitmap c16 = com.tencent.open.base.d.c(noticeParam.f341445d);
                    if (c16 != null) {
                        remoteViews.setImageViewBitmap(R.id.notification_icon, c16);
                    } else {
                        f.e("AppNotificationManager", ">>download icon fail,so we use default notification icon");
                        remoteViews.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
                    }
                }
                if (noticeParam.C == 0) {
                    remoteViews.setOnClickPendingIntent(R.id.notification_root, b16);
                } else {
                    notification.contentIntent = b16;
                }
            }
            notification.contentView = remoteViews;
            QQNotificationManager.addChannelIfNeed(notification, QQNotificationManager.CHANNEL_ID_HIDE_BADGE);
            return notification;
        }
        f.c("AppNotificationManager", "getNotification context == null");
        return null;
    }

    public int g(String str, int i3, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            f.c("AppNotificationManager", ">getNotificationId param error, return invalid id.");
            return -1;
        }
        f.e("AppNotificationManager", ">getNotificationId " + str + ", " + str2);
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        if (!this.f341460b.containsKey(str)) {
            C9279a c9279a = new C9279a();
            c9279a.f341462a = str;
            c9279a.f341464c = c(str);
            c9279a.f341465d = i3;
            c9279a.f341463b = str2;
            c9279a.f341466e = System.currentTimeMillis() + c9279a.f341464c;
            this.f341460b.put(str, c9279a);
        }
        return this.f341460b.get(str).f341464c;
    }

    public ConcurrentHashMap<String, C9279a> h() {
        return this.f341460b;
    }

    public long i(String str, int i3, String str2) {
        f.e("AppNotificationManager", ">getNotificationWhen " + str + ", " + str2);
        if (!this.f341460b.containsKey(str)) {
            C9279a c9279a = new C9279a();
            c9279a.f341462a = str;
            c9279a.f341464c = c(str);
            c9279a.f341465d = i3;
            c9279a.f341463b = str2;
            c9279a.f341466e = System.currentTimeMillis() + c9279a.f341464c;
            this.f341460b.put(str, c9279a);
        }
        return this.f341460b.get(str).f341466e;
    }

    public void j(int i3, Notification notification) {
        if (this.f341459a != null) {
            try {
                BadgeUtils.p(com.tencent.open.adapter.a.f().e(), 0, notification);
                this.f341459a.notify("AppNotificationManagernotify2", i3, notification);
            } catch (Exception e16) {
                f.d("AppNotificationManager", "notify>>>", e16);
            }
        }
    }

    public void k(NoticeParam noticeParam) {
        Notification f16;
        if (this.f341459a != null && (f16 = f(noticeParam)) != null) {
            BadgeUtils.p(com.tencent.open.adapter.a.f().e(), 0, f16);
            this.f341459a.notify("AppNotificationManagernotify1", g(noticeParam.D, noticeParam.C, noticeParam.f341445d), f16);
        }
    }

    public void l(RemoteViews remoteViews) {
        b bVar = this.f341461c;
        if (bVar == null || bVar.b() == null) {
            this.f341461c = new b(com.tencent.open.adapter.a.f().e());
        }
        f.e("notificationtest", "title color:" + this.f341461c.d());
        if (this.f341461c.d() != null) {
            remoteViews.setTextColor(R.id.notification_title, this.f341461c.d().intValue());
        }
        f.e("notificationtest", "text color:" + this.f341461c.b());
        if (this.f341461c.b() != null) {
            remoteViews.setTextColor(R.id.notification_content, this.f341461c.b().intValue());
        }
        if (this.f341461c.b() != null) {
            remoteViews.setTextColor(R.id.notification_progress, this.f341461c.b().intValue());
        }
        f.e("notificationtest", "text size:" + this.f341461c.c());
        if (this.f341461c.c() > 0.0f) {
            remoteViews.setFloat(R.id.notification_content, "setTextSize", this.f341461c.c());
        }
        if (this.f341461c.c() > 0.0f) {
            remoteViews.setFloat(R.id.notification_progress, "setTextSize", this.f341461c.c());
        }
        if (this.f341461c.e() > 0.0f) {
            remoteViews.setFloat(R.id.notification_title, "setTextSize", this.f341461c.e());
        }
        ApplicationInfo applicationInfo = com.tencent.open.adapter.a.f().e().getApplicationInfo();
        if (applicationInfo != null && applicationInfo.targetSdkVersion < 10) {
            try {
                int intValue = this.f341461c.d().intValue();
                remoteViews.setInt(R.id.notification_root, "setBackgroundColor", ((-1) - intValue) + (intValue & (-16777216)));
            } catch (Exception unused) {
            }
        }
    }
}
