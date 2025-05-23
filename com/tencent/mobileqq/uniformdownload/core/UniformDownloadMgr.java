package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.data.c;
import com.tencent.mobileqq.uniformdownload.data.e;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.mobileqq.uniformdownload.util.d;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UniformDownloadMgr {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static UniformDownloadMgr f305807h;

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f305808a;

    /* renamed from: b, reason: collision with root package name */
    private e f305809b;

    /* renamed from: c, reason: collision with root package name */
    private c f305810c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.uniformdownload.data.b f305811d;

    /* renamed from: e, reason: collision with root package name */
    private DownloadInstContextMgr f305812e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f305813f;

    /* renamed from: g, reason: collision with root package name */
    private BroadcastReceiver f305814g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UniformDownloadMgr.this);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void R0(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bundle);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void c(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, bundle);
            } else {
                UniformDownloadMgr.this.f305812e.o();
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void c2(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void g0(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.d
        public void h(String str, long j3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), bundle);
                return;
            }
            bundle.getInt("_CB_SID");
            String string = bundle.getString("_CB_URL");
            Bundle bundle2 = bundle.getBundle("_CB_USERDATA");
            UniformDownloadMgr.this.f305812e.d(string);
            QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>insertFM and install. PH:" + str + " SZ:" + j3);
            if (UniformDownloadMgr.this.f305808a == null) {
                ah.b(str);
            }
            if (bundle2 != null) {
                UniformDownloadUtil.h(str, bundle2.getString("big_brother_source_key"));
            }
            UniformDownloadMgr.this.f305812e.o();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            f305807h = null;
        }
    }

    UniformDownloadMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f305809b = new e();
        this.f305810c = new c();
        this.f305811d = new com.tencent.mobileqq.uniformdownload.data.b();
        this.f305812e = new DownloadInstContextMgr(this.f305809b);
        this.f305813f = true;
        this.f305814g = null;
        try {
            UniformDownloadPkgInstallReceiver.b(BaseApplication.getContext());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static synchronized UniformDownloadMgr m() {
        UniformDownloadMgr uniformDownloadMgr;
        synchronized (UniformDownloadMgr.class) {
            if (f305807h == null) {
                if (QLog.isColorLevel()) {
                    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-getInstance] create");
                }
                f305807h = new UniformDownloadMgr();
            }
            uniformDownloadMgr = f305807h;
        }
        return uniformDownloadMgr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(String str, Bundle bundle) {
        if (str != null && bundle != null) {
            int i3 = bundle.getInt("_notify_param_Id");
            String string = bundle.getString("_notify_param_Filename");
            String string2 = bundle.getString("_notify_param_ContentTitle", "");
            long j3 = bundle.getLong("_notify_param_Filesize");
            Bundle bundle2 = bundle.getBundle("_notify_param_userdata");
            QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>inRResumeDownload. URL:" + str + " nofiyid:" + i3);
            if (-1 == this.f305812e.j(str)) {
                com.tencent.mobileqq.uniformdownload.core.a m3 = new com.tencent.mobileqq.uniformdownload.core.a().o(str).j(string).k(j3).m(string2);
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                j(m3.i(bundle2).l(i3).n(true));
                return 0;
            }
            return 0;
        }
        QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] inRResumeDownload. param error!!");
        return -1;
    }

    private void r(com.tencent.mobileqq.uniformdownload.core.a aVar, File file) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(file, aVar) { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ File f305829d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uniformdownload.core.a f305830e;

            {
                this.f305829d = file;
                this.f305830e = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, UniformDownloadMgr.this, file, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String string;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String absolutePath = this.f305829d.getAbsolutePath();
                if (this.f305830e.a() == null) {
                    string = null;
                } else {
                    string = this.f305830e.a().getString("big_brother_source_key");
                }
                UniformDownloadUtil.h(this.f305829d.getAbsolutePath(), string);
                d c16 = UniformDownloadMgr.this.f305809b.c(this.f305830e.g());
                if (c16 != null) {
                    c16.h(absolutePath, this.f305829d.getTotalSpace(), this.f305830e.a());
                }
            }
        });
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloadMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UniformDownloadMgr.this.f305812e.i();
                    if (UniformDownloadMgr.this.f305813f) {
                        QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. start resume");
                        Map<String, com.tencent.mobileqq.uniformdownload.data.a> b16 = UniformDownloadMgr.this.f305811d.b();
                        UniformDownloadMgr.this.f305811d.a();
                        HashMap hashMap = new HashMap();
                        if (b16 != null && b16.size() > 0) {
                            Iterator<T> it = b16.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                String str = (String) entry.getKey();
                                com.tencent.mobileqq.uniformdownload.data.a aVar = (com.tencent.mobileqq.uniformdownload.data.a) entry.getValue();
                                if (aVar != null) {
                                    if (aVar.f305882e) {
                                        hashMap.put(str, aVar);
                                    } else {
                                        QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + str + "] nId:[" + aVar.f305878a + "] - 1");
                                        UniformDownloadMgr uniformDownloadMgr = UniformDownloadMgr.this;
                                        com.tencent.mobileqq.uniformdownload.core.a m3 = new com.tencent.mobileqq.uniformdownload.core.a().o(str).j(aVar.f305879b).k(aVar.f305881d).m(aVar.f305880c);
                                        Bundle bundle = aVar.f305883f;
                                        if (bundle == null) {
                                            bundle = new Bundle();
                                        }
                                        uniformDownloadMgr.j(m3.i(bundle).l(aVar.f305878a).n(true));
                                    }
                                } else {
                                    QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + str + "] -1");
                                }
                            }
                        }
                        if (hashMap.size() > 0) {
                            for (Map.Entry entry2 : hashMap.entrySet()) {
                                String str2 = (String) entry2.getKey();
                                com.tencent.mobileqq.uniformdownload.data.a aVar2 = (com.tencent.mobileqq.uniformdownload.data.a) entry2.getValue();
                                if (aVar2 != null) {
                                    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot, url:[" + str2 + "] nId:[" + aVar2.f305878a + "] - 2");
                                    UniformDownloadMgr uniformDownloadMgr2 = UniformDownloadMgr.this;
                                    com.tencent.mobileqq.uniformdownload.core.a m16 = new com.tencent.mobileqq.uniformdownload.core.a().o(str2).j(aVar2.f305879b).k(aVar2.f305881d).m(aVar2.f305880c);
                                    Bundle bundle2 = aVar2.f305883f;
                                    if (bundle2 == null) {
                                        bundle2 = new Bundle();
                                    }
                                    uniformDownloadMgr2.j(m16.i(bundle2).l(aVar2.f305878a).n(true));
                                } else {
                                    QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] resumeRuningDownloadPreMobileQQReboot, value error. url:[" + str2 + "] -2");
                                }
                            }
                        }
                    } else {
                        QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>resumeRuningDownloadPreMobileQQReboot. not resume");
                        UniformDownloadMgr.this.f305811d.a();
                    }
                    UniformDownloadMgr.this.f305812e.n();
                }
            });
        }
    }

    public void B(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        QLog.d("UniformDownloadMgr_Impl", 1, "\u3010UniformDL-startDownload\u3011 URL:" + str);
        ThreadManager.getSubThreadHandler().post(new Runnable(str, bundle) { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f305822d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f305823e;

            {
                this.f305822d = str;
                this.f305823e = bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UniformDownloadMgr.this, str, bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.uniformdownload.data.d.a(this.f305822d, this.f305823e);
                UniformDownloadMgr.this.D(this.f305822d, this.f305823e);
                UniformDownloadMgr.this.f305812e.n();
            }
        });
    }

    public void C(String str, Bundle bundle, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, bundle, dVar);
            return;
        }
        QLog.d("UniformDownloadMgr_Impl", 1, "\u3010UniformDL-startDownload + listener\u3011 URL:" + str);
        d c16 = this.f305809b.c(str);
        this.f305809b.a(str, dVar);
        ThreadManager.getSubThreadHandler().post(new Runnable(str, bundle, c16) { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f305824d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f305825e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ d f305826f;

            {
                this.f305824d = str;
                this.f305825e = bundle;
                this.f305826f = c16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UniformDownloadMgr.this, str, bundle, c16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.uniformdownload.data.d.a(this.f305824d, this.f305825e);
                UniformDownloadMgr.this.x(this.f305824d, this.f305826f);
                UniformDownloadMgr.this.D(this.f305824d, this.f305825e);
                UniformDownloadMgr.this.f305812e.n();
            }
        });
    }

    public boolean D(String str, Bundle bundle) {
        UniformDownloader uniformDownloader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) bundle)).booleanValue();
        }
        QLog.d("UniformDownloadMgr_Impl", 1, "\u3010UniformDL-inRStartDownload\u3011");
        if (str != null && bundle != null) {
            DownloadInstContextMgr.b e16 = this.f305812e.e(str);
            if (e16 != null && (uniformDownloader = e16.f305876e) != null) {
                int o16 = uniformDownloader.o();
                QLog.w("UniformDownloadMgr_Impl", 1, "[inRStartDownload] instance is exist.status:" + o16 + " may be do something. url:" + str);
                if (o16 != 2) {
                    if (o16 != 3) {
                        if (o16 != 4) {
                            if (o16 != 5) {
                                if (o16 == 7) {
                                    this.f305812e.d(str);
                                }
                            }
                        } else {
                            this.f305812e.d(str);
                            j(com.tencent.mobileqq.uniformdownload.core.a.f(bundle, str));
                        }
                    }
                    this.f305812e.j(str);
                } else {
                    d c16 = this.f305809b.c(str);
                    if (c16 != null) {
                        e16.f305876e.x(c16);
                        e16.f305876e.j(c16, false);
                    }
                }
                return true;
            }
            QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-inRStartDownload] run a new download. url:" + str);
            j(com.tencent.mobileqq.uniformdownload.core.a.f(bundle, str));
        }
        return false;
    }

    public void E(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) bundle);
            return;
        }
        QLog.d("UniformDownloadMgr_Impl", 1, "\u3010UniformDL-startDownloadNoSzie\u3011 URL:" + str);
        ThreadManager.getSubThreadHandler().post(new Runnable(bundle, str) { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f305827d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f305828e;

            {
                this.f305827d = bundle;
                this.f305828e = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UniformDownloadMgr.this, bundle, str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                this.f305827d.putLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, com.tencent.mobileqq.uniformdownload.data.d.e(this.f305828e, 4));
                QLog.d("UniformDownloadMgr_Impl", 1, "\u3010UniformDL-startDownloadNoSzie\u3011 fileSize: " + this.f305827d.getLong(IUniformDownloadMgr.FILESIZE_FROM_DIALOG, 0L));
                UniformDownloadMgr.this.D(this.f305828e, this.f305827d);
                UniformDownloadMgr.this.f305812e.n();
            }
        });
    }

    public void F(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) bundle);
        } else {
            z(str, bundle);
        }
    }

    public void i(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) bundle);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(str, bundle) { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f305816d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f305817e;

                {
                    this.f305816d = str;
                    this.f305817e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UniformDownloadMgr.this, str, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f305816d != null && (bundle2 = this.f305817e) != null) {
                        QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>onDownloadNotificationBeClean. URL:" + this.f305816d + " nofiyid:" + bundle2.getInt("_notify_param_Id"));
                        UniformDownloadMgr.this.f305812e.e(this.f305816d);
                        UniformDownloadMgr.this.f305812e.l(this.f305816d);
                        UniformDownloadMgr.this.f305812e.d(this.f305816d);
                        UniformDownloadMgr.this.f305811d.e(this.f305816d);
                        UniformDownloadMgr.this.f305812e.n();
                        return;
                    }
                    QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] onDownloadNotificationBeClean. param error!!");
                }
            });
        }
    }

    public int j(com.tencent.mobileqq.uniformdownload.core.a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) aVar)).intValue();
        }
        if (aVar.g() != null && aVar.b() != null) {
            File file = new File(n(aVar.b()));
            if (file.isFile() && file.exists()) {
                r(aVar, file);
                return 4;
            }
            long a16 = UniformDownloadUtil.a();
            UniformDownloader uniformDownloader = new UniformDownloader(a16, aVar.g(), aVar.a());
            Bundle bundle = new Bundle();
            bundle.putString("_PARAM_FILENAME", aVar.b());
            bundle.putLong("_PARAM_FILESIZE", aVar.c());
            bundle.putBundle("_PARAM_USER_DATA", aVar.a());
            if (!uniformDownloader.r(bundle)) {
                QLog.e("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask][" + a16 + " - NEW_ID] create UniformDownloader failed. url:" + aVar.g());
                return -2;
            }
            if (1 == uniformDownloader.p()) {
                QLog.i("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask][" + a16 + " - NEW_ID]. >>> create UniformDownloader.using appbaby. url: " + aVar.g());
            } else if (2 == uniformDownloader.p()) {
                QLog.i("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask][" + a16 + " - NEW_ID]. >>>create UniformDownloader.using common. url:" + aVar.g());
            }
            uniformDownloader.j(new a(), true);
            d c16 = this.f305809b.c(aVar.g());
            if (c16 != null) {
                uniformDownloader.j(c16, false);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_notify_param_Filename", aVar.b());
            if (!TextUtils.isEmpty(aVar.e())) {
                bundle2.putString("_notify_param_ContentTitle", aVar.e());
            } else {
                bundle2.putString("_notify_param_ContentTitle", aVar.b());
            }
            bundle2.putString("_notify_param_Url", aVar.g());
            bundle2.putLong("_notify_param_Filesize", aVar.c());
            bundle2.putBundle("_notify_param_userdata", aVar.a());
            int d16 = b.h().d(uniformDownloader, bundle2, a16, aVar.d());
            this.f305812e.b(aVar.g(), new DownloadInstContextMgr.b(null, uniformDownloader.p(), uniformDownloader, a16, d16));
            if (aVar.h()) {
                z16 = true;
                QLog.w("UniformDownloadMgr_Impl", 1, "[UniformDL][" + a16 + "] preHadStarted. url:" + aVar.g());
                uniformDownloader.z(true);
            } else {
                z16 = true;
            }
            if (this.f305812e.k(aVar.g()) == 0) {
                uniformDownloader.z(z16);
                b.h().s(d16, bundle2);
            }
            this.f305813f = false;
            return 0;
        }
        QLog.e("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask] createAndStartDownloadTask.. param = null");
        return -1;
    }

    public AppRuntime k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f305808a == null) {
            QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-getApp] APP=null.");
        }
        return this.f305808a;
    }

    public com.tencent.mobileqq.uniformdownload.data.b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.uniformdownload.data.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305811d;
    }

    protected String n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        return AppConstants.SDCARD_FILE_SAVE_PATH + str;
    }

    public c o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f305810c;
    }

    public boolean q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).booleanValue();
        }
        if (this.f305812e.e(str) != null) {
            return true;
        }
        return false;
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onActiveAccount...");
            A();
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppDestroy]");
        this.f305808a = null;
        this.f305812e.h();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloadMgr.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (UniformDownloadMgr.this.f305814g == null) {
                        QLog.w("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppDestroy] UniformDownloadMgr unRegister UNIDOWNLOAD_BORDCAST, had unRegister");
                        return;
                    }
                    BaseApplication.getContext().unregisterReceiver(UniformDownloadMgr.this.f305814g);
                    UniformDownloadMgr.this.f305814g = null;
                    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppDestroy] UniformDownloadMgr unRegister UNIDOWNLOAD_BORDCAST");
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    public void u(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
            return;
        }
        QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppInit]");
        this.f305808a = appRuntime;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr$1$a */
            /* loaded from: classes17.dex */
            class a extends BroadcastReceiver {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    } else {
                        if (intent == null) {
                            return;
                        }
                        Bundle bundleExtra = intent.getBundleExtra("param");
                        UniformDownloadMgr.m().E(intent.getStringExtra("param"), bundleExtra);
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloadMgr.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (UniformDownloadMgr.this.f305814g != null) {
                        QLog.w("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppInit] mRecv is already setted");
                        return;
                    }
                    UniformDownloadMgr.this.f305814g = new a();
                    BaseApplication.getContext().registerReceiver(UniformDownloadMgr.this.f305814g, new IntentFilter(IUniformDownloadMgr.UNIDOWNLOAD_BORDCAST));
                    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppInit] UniformDownloadMgr Register UNIDOWNLOAD_BORDCAST");
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit...");
        this.f305812e.c();
        this.f305810c.a();
        this.f305811d.a();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloadMgr.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit releaseABSdkClient...");
                    UniformDownloaderAppBabySdk.m().C();
                }
            }
        });
    }

    public void w(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) bundle);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(str, bundle) { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f305818d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f305819e;

                {
                    this.f305818d = str;
                    this.f305819e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UniformDownloadMgr.this, str, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        UniformDownloadMgr.this.f305812e.m(this.f305818d, this.f305819e);
                        UniformDownloadMgr.this.f305812e.n();
                    }
                }
            });
        }
    }

    public void x(String str, d dVar) {
        UniformDownloader uniformDownloader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) dVar);
            return;
        }
        DownloadInstContextMgr.b e16 = this.f305812e.e(str);
        if (e16 != null && (uniformDownloader = e16.f305876e) != null) {
            int o16 = uniformDownloader.o();
            if (o16 == 1 || o16 == 2) {
                if (dVar != null) {
                    e16.f305876e.x(dVar);
                }
                d c16 = this.f305809b.c(str);
                if (c16 != null) {
                    e16.f305876e.j(c16, false);
                }
                QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-reflashOuterListenser] startDownload. URL:" + str + " update OuterListenner");
            }
        }
    }

    public void y(String str) {
        DownloadInstContextMgr.b e16;
        UniformDownloader uniformDownloader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        d b16 = this.f305809b.b(str);
        if (!TextUtils.isEmpty(str) && (e16 = this.f305812e.e(str)) != null && (uniformDownloader = e16.f305876e) != null && b16 != null) {
            uniformDownloader.x(b16);
        }
    }

    public void z(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) bundle);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(str, bundle) { // from class: com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr.12
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f305820d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f305821e;

                {
                    this.f305820d = str;
                    this.f305821e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UniformDownloadMgr.this, str, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        UniformDownloadMgr.this.p(this.f305820d, this.f305821e);
                        UniformDownloadMgr.this.f305812e.n();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
