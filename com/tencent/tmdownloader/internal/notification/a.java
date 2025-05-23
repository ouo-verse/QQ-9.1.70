package com.tencent.tmdownloader.internal.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.i;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.f;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static a f380722i;

    /* renamed from: a, reason: collision with root package name */
    private NotificationManager f380723a;

    /* renamed from: b, reason: collision with root package name */
    protected final ConcurrentHashMap<String, C10004a> f380724b;

    /* renamed from: c, reason: collision with root package name */
    private int f380725c;

    /* renamed from: d, reason: collision with root package name */
    i f380726d;

    /* renamed from: e, reason: collision with root package name */
    private b f380727e;

    /* renamed from: f, reason: collision with root package name */
    protected AtomicInteger f380728f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.tmdownloader.internal.notification.b f380729g;

    /* renamed from: h, reason: collision with root package name */
    protected long f380730h;

    /* compiled from: P */
    /* renamed from: com.tencent.tmdownloader.internal.notification.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C10004a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f380731a;

        /* renamed from: b, reason: collision with root package name */
        public String f380732b;

        /* renamed from: c, reason: collision with root package name */
        public int f380733c;

        /* renamed from: d, reason: collision with root package name */
        public long f380734d;

        public C10004a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            } else {
                this.f380732b = "";
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f380732b + "," + this.f380732b + "," + this.f380731a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected Integer f380736a;

        /* renamed from: b, reason: collision with root package name */
        protected float f380737b;

        /* renamed from: c, reason: collision with root package name */
        protected Integer f380738c;

        /* renamed from: d, reason: collision with root package name */
        protected float f380739d;

        /* renamed from: e, reason: collision with root package name */
        protected DisplayMetrics f380740e;

        b(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) context);
                return;
            }
            this.f380736a = null;
            this.f380737b = 14.0f;
            this.f380738c = null;
            this.f380739d = 16.0f;
            this.f380740e = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(this.f380740e);
            a(context);
        }

        public Integer a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f380736a : (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public float b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f380737b : ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }

        public Integer c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f380738c;
        }

        public float d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
            }
            return this.f380739d;
        }

        protected boolean a(ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup)).booleanValue();
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (viewGroup.getChildAt(i3) instanceof TextView) {
                    TextView textView = (TextView) viewGroup.getChildAt(i3);
                    if ("SearchForText".equals(textView.getText().toString())) {
                        this.f380736a = Integer.valueOf(textView.getTextColors().getDefaultColor());
                        float textSize = textView.getTextSize();
                        this.f380737b = textSize;
                        this.f380737b = textSize / this.f380740e.scaledDensity;
                        return true;
                    }
                } else if ((viewGroup.getChildAt(i3) instanceof ViewGroup) && a((ViewGroup) viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
            return false;
        }

        protected boolean b(ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup)).booleanValue();
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (viewGroup.getChildAt(i3) instanceof TextView) {
                    TextView textView = (TextView) viewGroup.getChildAt(i3);
                    if ("SearchForTitle".equals(textView.getText().toString())) {
                        this.f380738c = Integer.valueOf(textView.getTextColors().getDefaultColor());
                        float textSize = textView.getTextSize();
                        this.f380739d = textSize;
                        this.f380739d = textSize / this.f380740e.scaledDensity;
                        return true;
                    }
                } else if ((viewGroup.getChildAt(i3) instanceof ViewGroup) && b((ViewGroup) viewGroup.getChildAt(i3))) {
                    return true;
                }
            }
            return false;
        }

        protected void a(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
                return;
            }
            if (this.f380736a == null || this.f380738c == null) {
                try {
                    Notification.Builder builder = new Notification.Builder(GlobalUtil.getInstance().getContext());
                    builder.setContentTitle("SearchForTitle");
                    builder.setContentText("SearchForText");
                    ViewGroup viewGroup = (ViewGroup) builder.build().contentView.apply(context, null);
                    b(viewGroup);
                    a(viewGroup);
                } catch (Exception e16) {
                    r.a("SDK_NotificationManager", "" + e16.getMessage(), e16);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    protected a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380723a = null;
        this.f380724b = new ConcurrentHashMap<>();
        this.f380725c = 1;
        this.f380726d = null;
        this.f380730h = 0L;
        this.f380723a = (NotificationManager) GlobalUtil.getInstance().getContext().getSystemService("notification");
        this.f380726d = new i(GlobalUtil.getInstance().getContext());
        c();
        this.f380728f = new AtomicInteger(1);
        this.f380729g = new com.tencent.tmdownloader.internal.notification.b(Looper.getMainLooper());
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f380722i == null) {
                f380722i = new a();
            }
            aVar = f380722i;
        }
        return aVar;
    }

    public void a(int i3, Notification notification) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) notification);
            return;
        }
        NotificationManager notificationManager = this.f380723a;
        if (notificationManager != null) {
            try {
                notificationManager.notify(i3, notification);
            } catch (Exception e16) {
                r.b("SDK_NotificationManager", "notify " + e16);
            }
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            if (this.f380723a == null || !this.f380724b.containsKey(str)) {
                return;
            }
            this.f380723a.cancel(this.f380724b.get(str).f380733c);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            ApkDownloadManager.getInstance().AddDownloadListener(this);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            ApkDownloadManager.getInstance().RemoveDownloadListener(this);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    protected void finalize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        r.a("SDK_NotificationManager", "finalize \u6e05\u7406 sp\u6570\u636e");
        a();
        super.finalize();
    }

    protected void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        try {
            SharedPreferences.Editor edit = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception e16) {
            r.a("SDK_NotificationManager", "remove nid from local error:" + e16.getMessage(), e16);
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            if (this.f380723a == null || !this.f380724b.containsKey(str)) {
                return;
            }
            this.f380723a.cancel(this.f380724b.get(str).f380733c);
            this.f380724b.remove(str);
            d(str);
        }
    }

    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            Map<String, ?> all = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).getAll();
            if (all == null || all.size() <= 0) {
                return;
            }
            Iterator<T> it = all.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (this.f380724b.containsKey(entry.getKey())) {
                    r.c("SDK_NotificationManager", "\u5217\u8868\u5df2\u7ecf\u5305\u542b\uff0c\u8df3\u8fc7");
                } else {
                    C10004a b16 = b((String) entry.getValue());
                    if (b16 != null) {
                        this.f380725c = Math.max(this.f380725c, b16.f380733c);
                        r.c("SDK_NotificationManager", ">>>initValue=" + this.f380725c);
                        this.f380724b.put((String) entry.getKey(), b16);
                    } else {
                        r.a("SDK_NotificationManager", "init id from local en.getValue() error:");
                    }
                }
            }
        } catch (Exception e16) {
            r.a("SDK_NotificationManager", "init id from local error:" + e16.getMessage(), e16);
        }
    }

    public void a(RemoteViews remoteViews) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) remoteViews);
            return;
        }
        b bVar = this.f380727e;
        if (bVar == null || bVar.a() == null) {
            this.f380727e = new b(GlobalUtil.getInstance().getContext());
        }
        if (this.f380727e.c() != null) {
            remoteViews.setTextColor(this.f380726d.b("notification_title"), this.f380727e.c().intValue());
        }
        if (this.f380727e.a() != null) {
            remoteViews.setTextColor(this.f380726d.b("notification_content"), this.f380727e.a().intValue());
            remoteViews.setTextColor(this.f380726d.b("notification_progress"), this.f380727e.a().intValue());
        }
        if (this.f380727e.b() > 0.0f) {
            remoteViews.setFloat(this.f380726d.b("notification_content"), "setTextSize", this.f380727e.b());
            remoteViews.setFloat(this.f380726d.b("notification_progress"), "setTextSize", this.f380727e.b());
            remoteViews.setFloat(this.f380726d.b("notification_title"), "setTextSize", this.f380727e.d());
        }
        ApplicationInfo applicationInfo = GlobalUtil.getInstance().getContext().getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 10) {
            return;
        }
        try {
            int intValue = this.f380727e.c().intValue();
            remoteViews.setInt(this.f380726d.b("notification_root"), "setBackgroundColor", ((-1) - intValue) + (intValue & (-16777216)));
        } catch (Exception unused) {
        }
    }

    public long b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2)).longValue();
        }
        if (!this.f380724b.containsKey(str)) {
            C10004a c10004a = new C10004a();
            c10004a.f380731a = str;
            c10004a.f380733c = this.f380728f.incrementAndGet();
            c10004a.f380732b = str2;
            c10004a.f380734d = System.currentTimeMillis() + c10004a.f380733c;
            a(c10004a);
            this.f380724b.put(String.valueOf(str), c10004a);
        }
        return this.f380724b.get(String.valueOf(str)).f380734d;
    }

    public C10004a b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (C10004a) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        String[] split = str.split(",");
        if (split.length < 4) {
            return null;
        }
        C10004a c10004a = new C10004a();
        c10004a.f380733c = Integer.parseInt(split[0]);
        c10004a.f380732b = split[1];
        c10004a.f380731a = split[2];
        return c10004a;
    }

    protected void a(C10004a c10004a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) c10004a);
            return;
        }
        try {
            SharedPreferences sharedPreferences = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0);
            r.c("SDK_NotificationManager", "***\u4fdd\u5b58\u81f3\u672c\u5730\uff1a" + c10004a.toString());
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(c10004a.f380731a, c10004a.toString());
            edit.commit();
        } catch (Exception e16) {
            r.a("SDK_NotificationManager", "saveToLocal>>>", e16);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            SharedPreferences.Editor edit = GlobalUtil.getInstance().getContext().getSharedPreferences("downloadsdk_notification_ids", 0).edit();
            edit.clear();
            edit.commit();
        } catch (Exception e16) {
            r.a("SDK_NotificationManager", "clear nid from local error:" + e16.getMessage(), e16);
        }
    }

    public int a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        if (!this.f380724b.containsKey(str)) {
            C10004a c10004a = new C10004a();
            c10004a.f380731a = str;
            c10004a.f380733c = this.f380728f.incrementAndGet();
            c10004a.f380732b = str2;
            c10004a.f380734d = System.currentTimeMillis() + c10004a.f380733c;
            a(c10004a);
            this.f380724b.put(str, c10004a);
        }
        return this.f380724b.get(str).f380733c;
    }

    public Notification a(NotifyParam notifyParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Notification) iPatchRedirector.redirect((short) 17, (Object) this, (Object) notifyParam);
        }
        if (GlobalUtil.getInstance().getContext() == null || notifyParam == null) {
            return null;
        }
        r.b("SDK_NotificationManager", "<getNotification> title = " + notifyParam.title + ", content=" + notifyParam.content);
        Notification notification = new Notification();
        notification.tickerText = notifyParam.title;
        notification.when = System.currentTimeMillis();
        RemoteViews remoteViews = new RemoteViews(GlobalUtil.getInstance().getContext().getPackageName(), this.f380726d.c("qapp_center_notification"));
        a(remoteViews);
        remoteViews.setInt(this.f380726d.b("notification_root"), "setBackgroundColor", -1);
        remoteViews.setInt(this.f380726d.b("notification_title"), "setTextColor", -16777216);
        remoteViews.setInt(this.f380726d.b("notification_progress"), "setTextColor", -12303292);
        remoteViews.setInt(this.f380726d.b("notification_content"), "setTextColor", -12303292);
        remoteViews.setTextViewText(this.f380726d.b("notification_title"), d.a(notifyParam.title, 18, true, true));
        notification.icon = this.f380726d.a("qfile_file_ufdownload_top");
        notification.contentView = remoteViews;
        return notification;
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.f
    public void a(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            return;
        }
        com.tencent.tmdownloader.internal.downloadservice.c queryDownloadInfo = ApkDownloadManager.getInstance().queryDownloadInfo(str);
        if (queryDownloadInfo == null || queryDownloadInfo.J != TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
            return;
        }
        Message obtainMessage = this.f380729g.obtainMessage();
        obtainMessage.what = i3;
        obtainMessage.obj = str2;
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        obtainMessage.setData(bundle);
        a(obtainMessage);
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.f
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            e(str);
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.f
    public void a(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (System.currentTimeMillis() - this.f380730h > 1000) {
            this.f380730h = System.currentTimeMillis();
            com.tencent.tmdownloader.internal.downloadservice.c queryDownloadInfo = ApkDownloadManager.getInstance().queryDownloadInfo(str);
            if (queryDownloadInfo == null || queryDownloadInfo.J != TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
                return;
            }
            Message obtainMessage = this.f380729g.obtainMessage();
            obtainMessage.what = 2;
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            obtainMessage.setData(bundle);
            a(obtainMessage);
        }
    }

    private void a(Message message) {
        if (this.f380729g == null) {
            this.f380729g = new com.tencent.tmdownloader.internal.notification.b();
        }
        this.f380729g.sendMessage(message);
    }
}
