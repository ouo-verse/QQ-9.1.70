package com.tencent.mobileqq.uniformdownload.core;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.mobileqq.uniformdownload.util.d;
import com.tencent.mobileqq.uniformdownload.util.e;
import com.tencent.mobileqq.uniformdownload.util.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static String f305846f;

    /* renamed from: g, reason: collision with root package name */
    private static b f305847g;

    /* renamed from: h, reason: collision with root package name */
    private static QQNotificationManager f305848h;

    /* renamed from: a, reason: collision with root package name */
    protected HandlerThread f305849a;

    /* renamed from: b, reason: collision with root package name */
    protected Handler f305850b;

    /* renamed from: c, reason: collision with root package name */
    private C8877b f305851c;

    /* renamed from: d, reason: collision with root package name */
    private long f305852d;

    /* renamed from: e, reason: collision with root package name */
    private int f305853e;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends Handler implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        Notification f305854d;

        /* renamed from: e, reason: collision with root package name */
        final Bundle f305855e;

        /* renamed from: f, reason: collision with root package name */
        final int f305856f;

        /* renamed from: h, reason: collision with root package name */
        final long f305857h;

        /* renamed from: i, reason: collision with root package name */
        int f305858i;

        /* renamed from: m, reason: collision with root package name */
        int f305859m;

        public a(Looper looper, int i3, Bundle bundle, long j3) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, looper, Integer.valueOf(i3), bundle, Long.valueOf(j3));
                return;
            }
            this.f305858i = 0;
            this.f305859m = 0;
            this.f305856f = i3;
            Bundle bundle2 = (Bundle) bundle.clone();
            this.f305855e = bundle2;
            this.f305857h = j3;
            if (bundle2 != null) {
                bundle2.putInt("_notify_param_Id", i3);
                this.f305854d = b.this.i(bundle);
                return;
            }
            QLog.e(b.f305846f, 1, "[UniformDL][" + j3 + "]. notify runable, param is null");
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void R0(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) bundle);
                return;
            }
            QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadPause, NF");
            Message obtain = Message.obtain();
            obtain.what = 3;
            Bundle bundle2 = new Bundle();
            bundle2.putInt("_FILE_PROGRESS_", i3);
            obtain.setData(bundle2);
            if (!sendMessage(obtain)) {
                QLog.e(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadPause, sendMessage failed, NF");
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bundle);
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle2 = new Bundle();
            bundle2.putInt("_FILE_PROGRESS_", i3);
            obtain.setData(bundle2);
            if (!sendMessage(obtain)) {
                QLog.e(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadProgress, sendMessage failed, NF");
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void c(int i3, String str, Bundle bundle) {
            Bundle bundle2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadFailed, NF --> " + str);
            if (bundle != null && (bundle2 = bundle.getBundle("_CB_USERDATA")) != null && bundle2.getBoolean("tbs_new_report", false)) {
                ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).reportQQBrowserDownloadEvent("stat_download_failed");
            }
            Message obtain = Message.obtain();
            obtain.what = 5;
            Bundle bundle3 = new Bundle();
            bundle3.putInt("_FILE_ERR_CODE_", i3);
            bundle3.putString("_FILE_ERR_STRING_", str);
            obtain.setData(bundle3);
            if (!sendMessage(obtain)) {
                QLog.e(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadFailed, sendMessage failed, NF");
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void c2(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
                return;
            }
            QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadResume progress=" + i3 + ", NF ");
            Message obtain = Message.obtain();
            obtain.what = 7;
            Bundle bundle2 = new Bundle();
            bundle2.putInt("_FILE_PROGRESS_", i3);
            obtain.setData(bundle2);
            if (!sendMessage(obtain)) {
                QLog.e(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadResume, sendMessage failed, NF");
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void g0(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
                return;
            }
            QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadStart, NF");
            Message obtain = Message.obtain();
            obtain.what = 1;
            Bundle bundle2 = new Bundle();
            bundle2.putInt("_FILE_PROGRESS_", i3);
            bundle2.putInt("_START_WAITING_", 0);
            obtain.setData(bundle2);
            if (!sendMessage(obtain)) {
                QLog.e(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadStart, sendMessage failed, NF");
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void h(String str, long j3, Bundle bundle) {
            Bundle bundle2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                int e16 = b.this.e();
                String c16 = UniformDownloadUtil.c(str);
                if (c16 != null) {
                    e eVar = new e(c16, e16);
                    if (bundle != null && (bundle2 = bundle.getBundle("_CB_USERDATA")) != null) {
                        eVar.f306007c = bundle2.getString(IUniformDownloadMgr.OPEN_WITH_QQBROWSER, "");
                        String string = bundle2.getString(IUniformDownloadMgr.PARAMS_OPEN_WITH_YYB, "");
                        if (!TextUtils.isEmpty(string)) {
                            eVar.f306008d.putString(IUniformDownloadMgr.PARAMS_OPEN_WITH_YYB, string);
                            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).reportAppStoreDownloadSuc();
                        }
                        boolean z16 = bundle2.getBoolean("tbs_new_report", false);
                        eVar.f306008d.putBoolean("tbs_new_report", z16);
                        if (z16) {
                            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).reportQQBrowserDownloadEvent("stat_download_success");
                        }
                        b.this.c(bundle2);
                    }
                    UniformDownloadMgr.m().o().g(eVar);
                }
                QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadSucess, NF");
                Message obtain = Message.obtain();
                obtain.what = 4;
                Bundle bundle3 = new Bundle();
                bundle3.putString("_FILE_PATH_", str);
                bundle3.putLong("_FILE_SIZE_", j3);
                bundle3.putInt("_NEW_N_ID_", e16);
                if (c16 != null) {
                    bundle3.putString("_PKG_NAME_", c16);
                }
                obtain.setData(bundle3);
                if (!sendMessage(obtain)) {
                    QLog.e(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. onDownloadSucess, sendMessage failed, NF");
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), bundle);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. NF_START, NF. NId = " + this.f305856f + " url:" + this.f305855e.getString("_notify_param_Url"));
                    b.this.n(this.f305856f, this.f305854d, this.f305855e, data);
                    int i3 = data.getInt("_START_WAITING_");
                    com.tencent.mobileqq.uniformdownload.data.b l3 = UniformDownloadMgr.m().l();
                    String string = this.f305855e.getString("_notify_param_Url");
                    String string2 = this.f305855e.getString("_notify_param_Filename");
                    String string3 = this.f305855e.getString("_notify_param_ContentTitle", "");
                    long j3 = this.f305855e.getLong("_notify_param_Filesize");
                    Bundle bundle = this.f305855e.getBundle("_notify_param_userdata");
                    int i16 = this.f305856f;
                    if (i3 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    l3.f(string, string2, string3, j3, bundle, i16, z16);
                    this.f305859m = 1;
                    break;
                case 2:
                    b.this.p(this.f305856f, this.f305854d, this.f305855e, data);
                    if (2 != this.f305859m) {
                        UniformDownloadMgr.m().l().f(this.f305855e.getString("_notify_param_Url"), this.f305855e.getString("_notify_param_Filename"), this.f305855e.getString("_notify_param_ContentTitle", ""), this.f305855e.getLong("_notify_param_Filesize"), this.f305855e.getBundle("_notify_param_userdata"), this.f305856f, false);
                    }
                    this.f305859m = 2;
                    break;
                case 3:
                    QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. NF_PAUSE, NF. NId = " + this.f305856f + " url:" + this.f305855e.getString("_notify_param_Url"));
                    b.this.l(this.f305856f, this.f305854d, this.f305855e, data);
                    UniformDownloadMgr.m().l().e(this.f305855e.getString("_notify_param_Url"));
                    this.f305859m = 3;
                    break;
                case 4:
                    QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. NF_SUC, NF. NId = " + this.f305856f + " url:" + this.f305855e.getString("_notify_param_Url"));
                    b.this.o(this.f305856f, this.f305855e, data);
                    UniformDownloadMgr.m().l().e(this.f305855e.getString("_notify_param_Url"));
                    this.f305859m = 4;
                    break;
                case 5:
                    b.this.k(this.f305856f, this.f305854d, this.f305855e, data);
                    UniformDownloadMgr.m().l().e(this.f305855e.getString("_notify_param_Url"));
                    this.f305859m = 5;
                    break;
                case 6:
                    QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. NF_CLR, NF. NId = " + this.f305856f);
                    b.this.j(this.f305856f);
                    UniformDownloadMgr.m().l().e(this.f305855e.getString("_notify_param_Url"));
                    break;
                case 7:
                    QLog.i(b.f305846f, 1, "[UniformDL][" + this.f305857h + "]. NF_RESUME, NF. NId = " + this.f305856f + " url:" + this.f305855e.getString("_notify_param_Url"));
                    b.this.m(this.f305856f, this.f305854d, this.f305855e, data);
                    UniformDownloadMgr.m().l().f(this.f305855e.getString("_notify_param_Url"), this.f305855e.getString("_notify_param_Filename"), this.f305855e.getString("_notify_param_ContentTitle", ""), this.f305855e.getLong("_notify_param_Filesize"), this.f305855e.getBundle("_notify_param_userdata"), this.f305856f, true);
                    this.f305859m = 7;
                    break;
            }
            this.f305858i = message.what;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uniformdownload.core.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C8877b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Integer f305860a;

        /* renamed from: b, reason: collision with root package name */
        float f305861b;

        /* renamed from: c, reason: collision with root package name */
        Integer f305862c;

        /* renamed from: d, reason: collision with root package name */
        float f305863d;

        /* renamed from: e, reason: collision with root package name */
        final String f305864e;

        /* renamed from: f, reason: collision with root package name */
        final String f305865f;

        /* renamed from: g, reason: collision with root package name */
        DisplayMetrics f305866g;

        /* renamed from: h, reason: collision with root package name */
        int f305867h;

        C8877b(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) context);
                return;
            }
            this.f305860a = null;
            this.f305861b = 14.0f;
            this.f305862c = null;
            this.f305863d = 16.0f;
            this.f305864e = "SearchForText";
            this.f305865f = "SearchForTitle";
            this.f305866g = new DisplayMetrics();
            this.f305867h = 0;
            if (context != null) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(this.f305866g);
            }
        }

        public float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
            }
            return this.f305861b;
        }

        public Integer b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f305862c;
        }

        public float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
            }
            return this.f305863d;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        f305846f = "UniformDownloadNfn";
        f305847g = null;
        f305848h = null;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f305849a = null;
        this.f305850b = null;
        this.f305851c = null;
        this.f305853e = 278;
        try {
            f305848h = QQNotificationManager.getInstance();
            this.f305851c = new C8877b(BaseApplication.getContext());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.f305852d = 123456L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bundle bundle) {
        if (bundle.getInt(IUniformDownloadMgr.DOWNLOAD_QQBROWSER_BUSINESS, -1) == 1) {
            ReportController.o(null, "dc00898", "", "", "0X800ADF0", "0X800ADF0", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int e() {
        int i3;
        i3 = this.f305853e;
        QLog.e(f305846f, 1, "genNID : notificationId[" + i3 + "]");
        int i16 = this.f305853e + 1;
        this.f305853e = i16;
        if (i16 > 377) {
            this.f305853e = 278;
            QLog.e(f305846f, 1, "genNID : notificationId is reach to the max Id.");
        }
        return i3;
    }

    private int f() {
        return (int) (System.currentTimeMillis() & 268435455);
    }

    private long g(int i3) {
        long j3;
        long j16;
        if (i3 == 0) {
            j3 = this.f305852d;
            j16 = 30;
        } else if (1 == i3) {
            j3 = this.f305852d;
            j16 = 20;
        } else if (2 == i3) {
            j3 = this.f305852d;
            j16 = 10;
        } else {
            if (3 == i3) {
                return this.f305852d;
            }
            return System.currentTimeMillis();
        }
        return j3 - j16;
    }

    public static b h() {
        if (f305847g == null) {
            f305847g = new b();
        }
        return f305847g;
    }

    public int d(UniformDownloader uniformDownloader, Bundle bundle, long j3, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, uniformDownloader, bundle, Long.valueOf(j3), Integer.valueOf(i3))).intValue();
        }
        if (-1 == i3) {
            int e16 = e();
            QLog.i(f305846f, 1, "[UniformDL][" + j3 + "]. attachDownloader.notificationId = " + e16);
            i16 = e16;
        } else {
            QLog.w(f305846f, 1, "[UniformDL][" + j3 + "]. attachDownloader.here will using notificationid,maybe is not uinform id");
            i16 = i3;
        }
        if (uniformDownloader != null) {
            uniformDownloader.j(new a(ThreadManager.getSubThreadHandler().getLooper(), i16, bundle, j3), false);
        } else {
            QLog.e(f305846f, 1, "[UniformDL][" + j3 + "]. attachDownloader.dler = null. notificationId = " + i16);
        }
        return i16;
    }

    public Notification i(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Notification) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(BaseApplication.getContext());
        if (SdkInfoUtil.isOreo() && SdkInfoUtil.isTargetSDKOreo()) {
            builder.setChannelId(QQNotificationManager.CHANNEL_ID_OTHER);
        }
        Notification build = builder.build();
        if (bundle != null) {
            String string = bundle.getString("_notify_param_ContentTitle");
            build.icon = R.drawable.qfile_file_ufdownload_top;
            RemoteViews remoteViews = new RemoteViews(BaseApplication.getContext().getPackageName(), R.layout.hcj);
            remoteViews.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
            remoteViews.setTextViewText(R.id.notification_title, string);
            remoteViews.setProgressBar(R.id.notif_pro_bar, 100, 0, false);
            remoteViews.setViewVisibility(R.id.notification_content, 8);
            remoteViews.setViewVisibility(R.id.notif_pro_bar_layout, 8);
            remoteViews.setTextColor(R.id.notification_title, -7829368);
            remoteViews.setTextColor(R.id.notification_content, -7829368);
            remoteViews.setTextColor(R.id.f166431fb4, -7829368);
            float a16 = this.f305851c.a();
            if (this.f305851c.a() <= 0.0f) {
                QLog.w(f305846f, 1, "[UniformDL]. initNotification param error. getTextSize failed. set defualt value:14");
                a16 = 14.0f;
            }
            remoteViews.setFloat(R.id.notification_content, "setTextSize", a16);
            remoteViews.setFloat(R.id.f166431fb4, "setTextSize", a16);
            float c16 = this.f305851c.c();
            if (c16 <= 0.0f) {
                QLog.w(f305846f, 1, "[UniformDL]. initNotification param error. getTitleSize failed. set defualt value:16");
                c16 = 16.0f;
            }
            remoteViews.setFloat(R.id.notification_title, "setTextSize", c16);
            ApplicationInfo applicationInfo = BaseApplication.getContext().getApplicationInfo();
            if (applicationInfo != null && applicationInfo.targetSdkVersion < 10) {
                try {
                    int intValue = this.f305851c.b().intValue();
                    remoteViews.setInt(R.id.fb8, "setBackgroundColor", ((-1) - intValue) + (intValue & (-16777216)));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            build.contentView = remoteViews;
            return build;
        }
        QLog.e(f305846f, 1, "[UniformDL]. getNfn param error, NF");
        return null;
    }

    protected void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        QQNotificationManager qQNotificationManager = f305848h;
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel(f305846f, i3);
        }
    }

    protected void k(int i3, Notification notification, Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), notification, bundle, bundle2);
            return;
        }
        if (notification != null && bundle != null && bundle2 != null) {
            QQNotificationManager qQNotificationManager = f305848h;
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel(f305846f, i3);
            }
            notification.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
            int i16 = bundle2.getInt("_FILE_ERR_CODE_");
            if (5 == i16) {
                notification.tickerText = BaseApplication.getContext().getString(R.string.f215065ul);
                notification.contentView.setTextViewText(R.id.notification_content, BaseApplication.getContext().getString(R.string.f215065ul));
            } else {
                notification.tickerText = BaseApplication.getContext().getString(R.string.f215055uk) + " " + bundle.getString("_notify_param_Filename");
                notification.contentView.setTextViewText(R.id.notification_content, f.a(i16) + HardCodeUtil.qqStr(R.string.f215095uo));
            }
            notification.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload_error);
            notification.contentView.setViewVisibility(R.id.notification_content, 0);
            notification.contentView.setTextViewText(R.id.f166431fb4, " ");
            notification.flags = 16;
            Intent intent = new Intent("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("_PARAM_EXTRA", bundle);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, i3);
            PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent, 167772160);
            notification.when = g(1);
            notification.contentView.setOnClickPendingIntent(R.id.fb8, broadcast);
            Intent intent2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
            intent2.setPackage(BaseApplication.getContext().getPackageName());
            intent2.putExtra("_PARAM_EXTRA", bundle);
            notification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent2, 167772160);
            QQNotificationManager qQNotificationManager2 = f305848h;
            if (qQNotificationManager2 != null) {
                try {
                    qQNotificationManager2.notify(f305846f, i3, notification);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        QLog.e(f305846f, 1, "[UniformDL]. nfnFAILED, param error. mId = " + i3);
    }

    protected void l(int i3, Notification notification, Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), notification, bundle, bundle2);
            return;
        }
        if (notification != null && bundle != null && bundle2 != null) {
            QQNotificationManager qQNotificationManager = f305848h;
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel(f305846f, i3);
            }
            notification.tickerText = null;
            int i16 = bundle2.getInt("_FILE_PROGRESS_");
            notification.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload_pause);
            notification.contentView.setViewVisibility(R.id.notification_content, 0);
            notification.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
            notification.contentView.setTextViewText(R.id.notification_content, BaseApplication.getContext().getString(R.string.f215075um));
            notification.contentView.setProgressBar(R.id.notif_pro_bar, 100, i16, false);
            notification.contentView.setTextViewText(R.id.f166431fb4, "" + i16 + "%");
            notification.flags = 16;
            Intent intent = new Intent("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("_PARAM_EXTRA", bundle);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, i3);
            PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent, 167772160);
            notification.when = g(1);
            notification.contentView.setOnClickPendingIntent(R.id.fb8, broadcast);
            Intent intent2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
            intent2.putExtra("_PARAM_EXTRA", bundle);
            intent2.setPackage(BaseApplication.getContext().getPackageName());
            notification.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent2, 167772160);
            QQNotificationManager qQNotificationManager2 = f305848h;
            if (qQNotificationManager2 != null) {
                try {
                    qQNotificationManager2.notify(f305846f, i3, notification);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        QLog.e(f305846f, 1, "[UniformDL]. nfnPUASE, param error. mId = " + i3);
    }

    protected void m(int i3, Notification notification, Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), notification, bundle, bundle2);
            return;
        }
        if (notification != null && bundle != null && bundle2 != null) {
            QQNotificationManager qQNotificationManager = f305848h;
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel(f305846f, i3);
            }
            notification.tickerText = null;
            notification.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
            notification.contentView.setViewVisibility(R.id.notification_content, 8);
            notification.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 0);
            notification.contentView.setProgressBar(R.id.notif_pro_bar, 100, bundle2.getInt("_FILE_PROGRESS_"), false);
            notification.contentView.setTextViewText(R.id.f166431fb4, BaseApplication.getContext().getString(R.string.f215105up));
            notification.flags = 34;
            Intent intent = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("_PARAM_EXTRA", bundle);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, i3);
            PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent, 167772160);
            notification.when = g(2);
            notification.contentView.setOnClickPendingIntent(R.id.fb8, broadcast);
            QQNotificationManager qQNotificationManager2 = f305848h;
            if (qQNotificationManager2 != null) {
                try {
                    qQNotificationManager2.notify(f305846f, i3, notification);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        QLog.e(f305846f, 1, "[UniformDL]. nfnRESUME, param error. mId = " + i3);
    }

    protected void n(int i3, Notification notification, Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), notification, bundle, bundle2);
            return;
        }
        if (notification != null && bundle != null && bundle2 != null) {
            notification.tickerText = BaseApplication.getContext().getString(R.string.f215085un) + " " + bundle.getString("_notify_param_Filename");
            notification.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
            int i16 = bundle2.getInt("_START_WAITING_");
            if (1 == i16) {
                notification.contentView.setTextViewText(R.id.f166431fb4, BaseApplication.getContext().getString(R.string.f215105up));
            } else {
                notification.contentView.setTextViewText(R.id.f166431fb4, "0%");
            }
            notification.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 0);
            notification.contentView.setViewVisibility(R.id.notification_content, 8);
            notification.contentView.setProgressBar(R.id.notif_pro_bar, 100, 0, false);
            notification.flags = 34;
            Intent intent = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("_PARAM_EXTRA", bundle);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, i3);
            PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent, 167772160);
            if (1 == i16) {
                notification.when = g(2);
            } else {
                notification.when = g(3);
            }
            notification.contentView.setOnClickPendingIntent(R.id.fb8, broadcast);
            QQNotificationManager qQNotificationManager = f305848h;
            if (qQNotificationManager != null) {
                try {
                    qQNotificationManager.notify(f305846f, i3, notification);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        QLog.e(f305846f, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + i3);
    }

    protected void o(int i3, Bundle bundle, Bundle bundle2) {
        String str;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), bundle, bundle2);
            return;
        }
        if (bundle != null && bundle2 != null) {
            QQNotificationManager qQNotificationManager = f305848h;
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel(f305846f, i3);
            }
            Notification i16 = i(bundle);
            String string = bundle2.getString("_FILE_PATH_");
            bundle2.getLong("_FILE_SIZE_");
            int i17 = bundle2.getInt("_NEW_N_ID_");
            String string2 = bundle2.getString("_PKG_NAME_");
            i16.tickerText = BaseApplication.getContext().getString(R.string.f215025uh) + " " + bundle.getString("_notify_param_Filename");
            Bundle bundle3 = bundle.getBundle("_notify_param_userdata");
            String str2 = "";
            if (bundle3 != null) {
                str2 = bundle3.getString("big_brother_source_key", "");
            }
            String string3 = BaseApplication.getContext().getString(R.string.f215045uj);
            if (UniformDownloadUtil.c(string) != null) {
                bitmap = UniformDownloadUtil.b(string);
                str = BaseApplication.getContext().getString(R.string.f215035ui);
            } else {
                str = string3;
                bitmap = null;
            }
            if (bitmap == null) {
                int f06 = ah.f0(string);
                if (f06 != 0) {
                    i16.contentView.setImageViewResource(R.id.notification_icon, f06);
                } else {
                    i16.contentView.setImageViewResource(R.id.notification_icon, R.drawable.bsd);
                }
                i16.contentView.setImageViewResource(R.id.notification_icon, R.drawable.bsd);
            } else {
                i16.contentView.setImageViewBitmap(R.id.notification_icon, bitmap);
            }
            i16.contentView.setViewVisibility(R.id.notification_content, 0);
            i16.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 8);
            i16.contentView.setTextViewText(R.id.notification_content, str);
            i16.flags = 16;
            Intent intent = new Intent("com.tencent.mobileqq.UniformDownloadNfn.INSTALL");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("_PARAM_FILEPATH", string);
            intent.putExtra("_PARAM_DL_SUC_NEW_NID", i17);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, i3);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("big_brother_source_key", str2);
            }
            if (string2 != null) {
                intent.putExtra("_PARAM_PKGNAME", string2);
            }
            i16.contentIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent, 167772160);
            Intent intent2 = new Intent("com.tencent.mobileqq.UniformDownloadNfn.BEDEL");
            intent2.setPackage(BaseApplication.getContext().getPackageName());
            intent2.putExtra("_PARAM_DL_SUC_NEW_NID", i17);
            if (string2 != null) {
                intent2.putExtra("_PARAM_PKGNAME", string2);
            }
            i16.deleteIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent2, 167772160);
            i16.when = g(0);
            if (f305848h != null) {
                QLog.i(f305846f, 1, "[UniformDL]. NF_SUC, NF. newNId = " + i17 + " url:" + bundle.getString("_notify_param_Url"));
                try {
                    f305848h.notify(f305846f, i17, i16);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        QLog.e(f305846f, 1, "[UniformDL]. nfnSUCESS, param error. mId = " + i3);
    }

    protected void p(int i3, Notification notification, Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), notification, bundle, bundle2);
            return;
        }
        if (notification != null && bundle != null && bundle2 != null) {
            notification.tickerText = null;
            notification.contentView.setImageViewResource(R.id.notification_icon, R.drawable.qfile_file_ufdownload);
            notification.contentView.setViewVisibility(R.id.notification_content, 8);
            notification.contentView.setViewVisibility(R.id.notif_pro_bar_layout, 0);
            int i16 = bundle2.getInt("_FILE_PROGRESS_");
            notification.contentView.setProgressBar(R.id.notif_pro_bar, 100, i16, false);
            notification.contentView.setTextViewText(R.id.f166431fb4, "" + i16 + "%");
            notification.flags = 34;
            Intent intent = new Intent("com.tencent.mobileqq.UniformDownloadNfn.PAUSE");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("_PARAM_EXTRA", bundle);
            intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, i3);
            PendingIntent broadcast = PendingIntent.getBroadcast(BaseApplication.getContext(), f(), intent, 167772160);
            notification.when = g(3);
            notification.contentView.setOnClickPendingIntent(R.id.fb8, broadcast);
            QQNotificationManager qQNotificationManager = f305848h;
            if (qQNotificationManager != null) {
                try {
                    qQNotificationManager.notify(f305846f, i3, notification);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        QLog.e(f305846f, 1, "[UniformDL]. nfnUPDATE, param error. mId = " + i3);
    }

    public void q(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
            return;
        }
        QLog.i(f305846f, 1, "[UniformDL]. sendCancelNotification, NF id:" + i3);
        j(i3);
        if (bundle != null) {
            UniformDownloadMgr.m().l().e(bundle.getString("_notify_param_Url"));
        }
    }

    public void r(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
            return;
        }
        if (bundle == null) {
            QLog.e(f305846f, 1, "[UniformDL]. sendPauseNotification param error, NF id:" + i3);
            return;
        }
        QLog.i(f305846f, 1, "[UniformDL]. sendPauseNotification, NF id:" + i3);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_FILE_PROGRESS_", bundle.getInt("_notify_param_Progress"));
        Notification i16 = i(bundle);
        if (i16 != null) {
            l(i3, i16, bundle, bundle2);
            UniformDownloadMgr.m().l().e(bundle.getString("_notify_param_Url"));
            return;
        }
        QLog.e(f305846f, 1, "[UniformDL]. sendPauseNotification failed to getNfn, NF id:" + i3);
    }

    public void s(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
            return;
        }
        if (bundle == null) {
            QLog.e(f305846f, 1, "[UniformDL]. sendStartAndWatingNotification param error, NF id:" + i3);
            return;
        }
        QLog.i(f305846f, 1, "[UniformDL]. sendStartAndWatingNotification, NF id:" + i3);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_FILE_PROGRESS_", 0);
        bundle2.putInt("_START_WAITING_", 1);
        Notification i16 = i(bundle);
        if (i16 != null) {
            n(i3, i16, bundle, bundle2);
            UniformDownloadMgr.m().l().f(bundle.getString("_notify_param_Url"), bundle.getString("_notify_param_Filename"), bundle.getString("_notify_param_ContentTitle", ""), bundle.getLong("_notify_param_Filesize"), bundle.getBundle("_notify_param_userdata"), i3, true);
            return;
        }
        QLog.e(f305846f, 1, "[UniformDL]. sendStartAndWatingNotification failed to getNfn, NF id:" + i3);
    }
}
