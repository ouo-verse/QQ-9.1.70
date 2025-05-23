package com.tencent.mobileqq.uniformdownload.downloader;

import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uniformdownload.util.f;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class UniformDownloaderAppBabySdk {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static String f305911f;

    /* renamed from: g, reason: collision with root package name */
    private static UniformDownloaderAppBabySdk f305912g;

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f305913a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f305914b;

    /* renamed from: c, reason: collision with root package name */
    private TMAssistantDownloadClient f305915c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, a> f305916d;

    /* renamed from: e, reason: collision with root package name */
    private ITMAssistantDownloadClientListener f305917e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final long f305937a;

        /* renamed from: b, reason: collision with root package name */
        final String f305938b;

        /* renamed from: c, reason: collision with root package name */
        final long f305939c;

        /* renamed from: d, reason: collision with root package name */
        long f305940d;

        /* renamed from: e, reason: collision with root package name */
        Object f305941e;

        /* renamed from: f, reason: collision with root package name */
        int f305942f;

        /* renamed from: g, reason: collision with root package name */
        Object f305943g;

        /* renamed from: h, reason: collision with root package name */
        Object f305944h;

        /* renamed from: i, reason: collision with root package name */
        int f305945i;

        /* renamed from: j, reason: collision with root package name */
        com.tencent.mobileqq.uniformdownload.util.c f305946j;

        a(long j3, String str, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UniformDownloaderAppBabySdk.this, Long.valueOf(j3), str, Long.valueOf(j16));
                return;
            }
            this.f305941e = new Object();
            this.f305943g = new Object();
            this.f305944h = new Object();
            this.f305937a = j3;
            this.f305942f = 2;
            this.f305938b = str;
            this.f305939c = j16;
            this.f305940d = 0L;
            this.f305945i = -1;
        }

        long a() {
            long j3;
            synchronized (this.f305941e) {
                j3 = this.f305940d;
            }
            return j3;
        }

        void b(long j3) {
            synchronized (this.f305941e) {
                this.f305940d = j3;
            }
        }

        void c(int i3) {
            synchronized (this.f305943g) {
                QLog.i(UniformDownloaderAppBabySdk.f305911f, 1, "[UniformDL] setStatus:" + this.f305942f + " -> " + i3 + "url:" + this.f305938b);
                this.f305942f = i3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f305948a;

        /* renamed from: b, reason: collision with root package name */
        public long f305949b;

        public b(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                this.f305948a = j3;
                this.f305949b = j16;
            }
        }

        public static b a(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            return new b(bundle.getLong("RPARAM_RECV_SIZE"), bundle.getLong("RPARAM_TRANS_SIZE"));
        }

        public Bundle b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            Bundle bundle = new Bundle();
            bundle.putLong("RPARAM_RECV_SIZE", this.f305948a);
            bundle.putLong("RPARAM_TRANS_SIZE", this.f305949b);
            return bundle;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19671);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f305911f = "UniformDownloaderAppBabySdk";
            f305912g = null;
        }
    }

    UniformDownloaderAppBabySdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f305915c = null;
        this.f305916d = new HashMap();
        this.f305917e = new ITMAssistantDownloadClientListener() { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloaderAppBabySdk.this);
                }
            }

            @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
            public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, long j3, long j16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    UniformDownloaderAppBabySdk.this.E();
                    if (!UniformDownloaderAppBabySdk.this.f305914b.post(new Runnable(str, j3, j16) { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f305922d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ long f305923e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ long f305924f;

                        {
                            this.f305922d = str;
                            this.f305923e = j3;
                            this.f305924f = j16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass4.this, str, Long.valueOf(j3), Long.valueOf(j16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                UniformDownloaderAppBabySdk.this.o(this.f305922d, this.f305923e, this.f305924f);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    })) {
                        QLog.e(UniformDownloaderAppBabySdk.f305911f, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. thread error!!");
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, this, tMAssistantDownloadClient, str, Long.valueOf(j3), Long.valueOf(j16));
            }

            @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
            public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, int i3, int i16, String str2) {
                int i17;
                TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z16 = false;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, tMAssistantDownloadClient, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
                    return;
                }
                QLog.i(UniformDownloaderAppBabySdk.f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[" + i3 + "] errcode:[" + i16 + "] errStr:[" + str2 + "] url:[" + str + "]");
                String str3 = null;
                String str4 = "";
                if (tMAssistantDownloadClient != null && 4 == i3) {
                    try {
                        tMAssistantDownloadTaskInfo = tMAssistantDownloadClient.getDownloadTaskState(str);
                        i17 = 0;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        str4 = f.a(22);
                        i17 = 22;
                        tMAssistantDownloadTaskInfo = null;
                        z16 = true;
                    }
                    if (tMAssistantDownloadTaskInfo != null) {
                        str3 = tMAssistantDownloadTaskInfo.mSavePath;
                    }
                } else {
                    i17 = 0;
                }
                String str5 = str3;
                UniformDownloaderAppBabySdk.this.E();
                if (z16) {
                    if (!UniformDownloaderAppBabySdk.this.f305914b.post(new Runnable(str, i17, str4) { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.4.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f305926d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f305927e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ String f305928f;

                        {
                            this.f305926d = str;
                            this.f305927e = i17;
                            this.f305928f = str4;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass4.this, str, Integer.valueOf(i17), str4);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                UniformDownloaderAppBabySdk.this.r(this.f305926d, this.f305927e, this.f305928f);
                                UniformDownloaderAppBabySdk.this.H();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    })) {
                        QLog.e(UniformDownloaderAppBabySdk.f305911f, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. haveErr and thread error!!");
                    }
                } else if (UniformDownloaderAppBabySdk.this.f305914b != null && !UniformDownloaderAppBabySdk.this.f305914b.post(new Runnable(str, i3, i16, str2, str5) { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.4.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f305930d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f305931e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f305932f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f305933h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f305934i;

                    {
                        this.f305930d = str;
                        this.f305931e = i3;
                        this.f305932f = i16;
                        this.f305933h = str2;
                        this.f305934i = str5;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass4.this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str5);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            UniformDownloaderAppBabySdk.this.p(this.f305930d, this.f305931e, this.f305932f, this.f305933h, this.f305934i);
                            UniformDownloaderAppBabySdk.this.H();
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                })) {
                    QLog.e(UniformDownloaderAppBabySdk.f305911f, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. thread error!!");
                }
            }

            @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
            public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient tMAssistantDownloadClient) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) tMAssistantDownloadClient);
                    return;
                }
                QLog.e(UniformDownloaderAppBabySdk.f305911f, 1, "[UniformDL] ABSdkdownload service invalid ");
                UniformDownloaderAppBabySdk.this.E();
                if (!UniformDownloaderAppBabySdk.this.f305914b.post(new Runnable() { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.4.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            UniformDownloaderAppBabySdk.this.q();
                            UniformDownloaderAppBabySdk.this.H();
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                })) {
                    QLog.e(UniformDownloaderAppBabySdk.f305911f, 1, "[UniformDL] OnDwonloadSDKServiceInvalid. thread error!!");
                }
            }
        };
    }

    private void A(String str, a aVar) {
        QLog.i(f305911f, 1, "[UniformDL] inPStartDownload success.. url = " + str);
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = this.f305915c.getDownloadTaskState(str);
            if (aVar != null && downloadTaskState != null) {
                long j3 = downloadTaskState.mReceiveDataLen;
                aVar.b(j3);
                QLog.i(f305911f, 1, "[UniformDL] inPStartDownload success. rSize:" + j3 + " url = " + str);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (aVar != null && aVar.f305946j != null) {
                aVar.f305946j.c(20, f.a(20), new b(0L, aVar.a()).b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void E() {
        if (this.f305913a == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("DL_ABSdkThread");
            this.f305913a = baseHandlerThread;
            baseHandlerThread.start();
            this.f305914b = new Handler(this.f305913a.getLooper());
            QLog.i(f305911f, 1, "[UniformDL] >>>start thread:DL_ABSdkThread...");
        }
    }

    private synchronized void G() {
        HandlerThread handlerThread = this.f305913a;
        if (handlerThread != null) {
            handlerThread.getLooper().quit();
            this.f305913a = null;
            this.f305914b = null;
            QLog.i(f305911f, 1, "[UniformDL] >>>stop thread:DL_ABSdkThread...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        int size;
        synchronized (this.f305916d) {
            size = this.f305916d.size();
        }
        if (size == 0) {
            G();
            C();
        }
    }

    private int i(String str, a aVar) {
        if (aVar != null && str != null) {
            synchronized (this.f305916d) {
                if (this.f305916d.containsKey(str)) {
                    return -2;
                }
                this.f305916d.put(str, aVar);
                QLog.i(f305911f, 1, "[UniformDL][" + aVar.f305937a + "] addDownloadCtx...total:[" + this.f305916d.size() + "] add it. url:[ " + str + "]");
                return 0;
            }
        }
        return -1;
    }

    private void j() {
        if (this.f305915c == null) {
            QLog.i(f305911f, 1, "[UniformDL] >>>create ABSdkClient...");
            TMAssistantDownloadClient downloadSDKClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("UF_DL_CLIENT");
            this.f305915c = downloadSDKClient;
            downloadSDKClient.registerDownloadTaskListener(this.f305917e);
        }
    }

    private int k(String str) {
        int size;
        synchronized (this.f305916d) {
            a remove = this.f305916d.remove(str);
            size = this.f305916d.size();
            QLog.i(f305911f, 1, "[UniformDL][" + remove.f305937a + "] delDownloadCtx...total:[" + size + "] add it. url:[ " + str + "]");
        }
        return size;
    }

    private a l(String str) {
        a aVar;
        synchronized (this.f305916d) {
            aVar = this.f305916d.get(str);
        }
        return aVar;
    }

    public static synchronized UniformDownloaderAppBabySdk m() {
        UniformDownloaderAppBabySdk uniformDownloaderAppBabySdk;
        synchronized (UniformDownloaderAppBabySdk.class) {
            if (f305912g == null) {
                f305912g = new UniformDownloaderAppBabySdk();
            }
            uniformDownloaderAppBabySdk = f305912g;
        }
        return uniformDownloaderAppBabySdk;
    }

    private void n(a aVar, int i3, String str) {
        long c16;
        int i16;
        QLog.e(f305911f, 1, "[UniformDL] >>>handleDownloadSDKTaskStateFailed. errCode:" + i3 + " errStr" + str);
        int i17 = 2;
        f.a(2);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            i16 = 5;
        } else {
            if (601 == i3) {
                i17 = 38;
            } else if (702 == i3) {
                i17 = 23;
            } else if (600 == i3) {
                i17 = 24;
            } else if (i3 == 0) {
                i17 = 25;
            } else if (704 == i3) {
                i17 = 26;
            } else if (706 == i3) {
                i17 = 27;
            } else if (709 == i3) {
                i17 = 28;
            } else if (701 == i3) {
                i17 = 29;
            } else if (707 == i3) {
                i17 = 30;
            } else if (602 == i3) {
                i17 = 31;
            } else if (705 == i3) {
                i17 = 32;
            } else if (604 == i3) {
                i17 = 39;
            } else if (603 == i3) {
                i17 = 34;
            } else if (708 == i3) {
                i17 = 35;
            } else if (700 == i3) {
                i17 = 36;
            } else if (703 == i3) {
                i17 = 37;
            }
            if (cu.e()) {
                c16 = cu.b();
            } else {
                c16 = cu.c();
            }
            long j3 = c16 * 1024;
            if (aVar != null && j3 < aVar.f305939c - aVar.a()) {
                QLog.e(f305911f, 1, "[UniformDL][" + aVar.f305937a + "] write file failed.  space is no enough:[" + aVar.f305939c + " " + aVar.a() + " " + j3 + "]");
                i16 = 9;
            } else {
                i16 = i17;
            }
        }
        String a16 = f.a(i16);
        if (aVar != null && aVar.f305946j != null) {
            aVar.f305946j.c(i16, a16, new b(aVar.a(), aVar.a()).b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, long j3, long j16) {
        int i3 = (int) ((((float) j3) / ((float) j16)) * 100.0f);
        a l3 = l(str);
        if (l3 != null) {
            l3.b(j3);
            com.tencent.mobileqq.uniformdownload.util.c cVar = l3.f305946j;
            if (cVar != null) {
                cVar.a(i3, null);
                return;
            }
            return;
        }
        QLog.e(f305911f, 1, "[UniformDL] inPDownloadSDKTaskProgressChanged. not found ctx, url: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, int i3, int i16, String str2, String str3) {
        com.tencent.mobileqq.uniformdownload.util.c cVar;
        com.tencent.mobileqq.uniformdownload.util.c cVar2;
        a l3 = l(str);
        if (l3 == null) {
            QLog.e(f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateChanged. not found ctx.  state:[" + i3 + "]errcode:[" + i16 + "] errStr:[" + str2 + "] url:[" + str + "]");
            return;
        }
        if (i3 == 1) {
            QLog.i(f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[WAITING] errcode:[" + i16 + "] errStr:[" + str2 + "] url:[" + str + "]");
            if (l3 == null || (cVar = l3.f305946j) == null) {
                return;
            }
            cVar.e(null);
            return;
        }
        if (i3 == 2) {
            QLog.i(f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[DOWNLOADING] errcode:[" + i16 + "] errStr:[" + str2 + "] url:[" + str + "]");
            if (l3 == null || (cVar2 = l3.f305946j) == null) {
                return;
            }
            cVar2.f(null);
            return;
        }
        if (i3 == 3) {
            QLog.i(f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[PAUSED] errcode:[" + i16 + "] errStr:[" + str2 + "] url:[" + str + "]");
            l3.c(2);
            com.tencent.mobileqq.uniformdownload.util.c cVar3 = l3.f305946j;
            if (cVar3 != null) {
                cVar3.b(null);
                return;
            }
            return;
        }
        if (i3 == 4) {
            QLog.i(f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[SUCCEED] errcode:[" + i16 + "] errStr:[" + str2 + "] url:[" + str + "]");
            l3.c(2);
            k(str);
            if (l3.f305946j != null) {
                l3.f305946j.d(str3, new b(l3.a(), l3.a()).b());
                return;
            }
            return;
        }
        if (i3 != 5) {
            QLog.e(f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  unkown state:[" + i3 + "]errcode:[" + i16 + "] errStr:[" + str2 + "] url:[" + str + "]");
            return;
        }
        QLog.i(f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[FAILED] errcode:[" + i16 + "] errStr:[" + str2 + "] url:[" + str + "]");
        l3.c(2);
        n(l3, i16, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        QLog.e(f305911f, 1, "[UniformDL] >>>inPDwonloadSDKServiceInvalid service invalid ");
        C();
        ArrayList<a> arrayList = new ArrayList();
        synchronized (this.f305916d) {
            Iterator<a> it = this.f305916d.values().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            this.f305916d.clear();
        }
        for (a aVar : arrayList) {
            if (aVar != null && aVar.f305946j != null) {
                aVar.f305946j.c(10, f.a(10), new b(aVar.a(), aVar.a()).b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, int i3, String str2) {
        QLog.e(f305911f, 1, "[UniformDL] >>>inPPDwonloadSDKErr errcode:" + i3 + " errStr:" + str2 + " url:" + str);
        a l3 = l(str);
        if (l3 == null) {
            QLog.e(f305911f, 1, "[UniformDL] inPDownloadSDKTaskStateFailed. not found ctx.  errcode:[" + i3 + "] errStr:[" + str2 + "] url:[" + str + "]");
            return;
        }
        l3.c(2);
        if (l3.f305946j != null) {
            l3.f305946j.c(i3, str2, new b(l3.a(), l3.a()).b());
        }
    }

    private void s(String str) {
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        com.tencent.mobileqq.uniformdownload.util.c cVar;
        j();
        a l3 = l(str);
        if (l3 == null) {
            QLog.e(f305911f, 1, "[UniformDL] inPPauseDownload. not found ctx.url:" + str);
        }
        TMAssistantDownloadClient tMAssistantDownloadClient = this.f305915c;
        if (tMAssistantDownloadClient == null) {
            QLog.e(f305911f, 1, "[UniformDL] inPPauseDownload.client = null");
            if (l3 != null && l3.f305946j != null) {
                l3.f305946j.c(41, f.a(41), new b(0L, l3.a()).b());
                return;
            }
            return;
        }
        try {
            tMAssistantDownloadTaskInfo = tMAssistantDownloadClient.getDownloadTaskState(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (l3 != null && l3.f305946j != null) {
                l3.f305946j.c(20, f.a(20), new b(l3.a(), l3.a()).b());
            }
            tMAssistantDownloadTaskInfo = null;
        }
        if (tMAssistantDownloadTaskInfo != null) {
            try {
                this.f305915c.pauseDownloadTask(str);
                return;
            } catch (Exception e17) {
                e17.printStackTrace();
                if (l3 != null && l3.f305946j != null) {
                    l3.f305946j.c(21, f.a(21), new b(l3.a(), l3.a()).b());
                    return;
                }
                return;
            }
        }
        QLog.e(f305911f, 1, "[UniformDL] inPPauseDownload. no run load");
        if (l3 != null && (cVar = l3.f305946j) != null) {
            cVar.b(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, int i3) {
        QLog.i(f305911f, 1, "[UniformDL] inPRunABSdkDownloadCmd.cmd:" + i3 + " url = " + str);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    QLog.e(f305911f, 1, "[UniformDL] inPRunABSdkDownloadCmd, errcmd: " + i3);
                    return;
                }
                v(str);
                return;
            }
            s(str);
            return;
        }
        u(str);
    }

    private void u(String str) {
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        j();
        a l3 = l(str);
        if (l3 == null) {
            QLog.e(f305911f, 1, "[UniformDL] inPStartDownload. not found ctx.url:" + str);
            return;
        }
        if (this.f305915c == null) {
            QLog.e(f305911f, 1, "[UniformDL] inPStartDownload.client = null");
            if (l3.f305946j != null) {
                l3.f305946j.c(41, f.a(41), new b(0L, l3.a()).b());
                return;
            }
            return;
        }
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo != null) {
            l3.f305945i = NetworkMonitor.getType(recentNetworkInfo);
        }
        try {
            tMAssistantDownloadTaskInfo = this.f305915c.getDownloadTaskState(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            tMAssistantDownloadTaskInfo = null;
        }
        if (tMAssistantDownloadTaskInfo != null && tMAssistantDownloadTaskInfo.mState == 2) {
            QLog.w(f305911f, 1, "[UniformDL] inPStartDownload.but it is downloading.url = " + str);
            return;
        }
        int i3 = 0;
        try {
            i3 = this.f305915c.startDownloadTask(str, "application/vnd.android.package-archive");
            QLog.i(f305911f, 1, "[UniformDL] inPStartDownload.startDownloadTask. url = " + str);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (i3 == 0) {
            A(str, l3);
        } else if (4 == i3) {
            z(str, l3);
        } else {
            y(str, l3, i3);
        }
    }

    private void v(String str) {
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
        j();
        TMAssistantDownloadClient tMAssistantDownloadClient = this.f305915c;
        if (tMAssistantDownloadClient == null) {
            QLog.e(f305911f, 1, "[UniformDL] inPStopDownload.client = null");
            return;
        }
        try {
            tMAssistantDownloadTaskInfo = tMAssistantDownloadClient.getDownloadTaskState(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            tMAssistantDownloadTaskInfo = null;
        }
        if (tMAssistantDownloadTaskInfo != null) {
            try {
                this.f305915c.cancelDownloadTask(str);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        } else {
            QLog.e(f305911f, 1, "[UniformDL] inPStopDownload. no run load");
        }
        k(str);
    }

    private void y(String str, a aVar, int i3) {
        int i16;
        String str2;
        QLog.e(f305911f, 1, "[UniformDL] inPStartDownload. task failed. result:" + i3 + ". url = " + str);
        aVar.c(2);
        if (5 == i3) {
            i16 = 16;
            str2 = "busy";
        } else if (1 == i3) {
            i16 = 17;
            str2 = "net broken";
        } else if (2 == i3) {
            i16 = 18;
            str2 = "set only for wifi";
        } else if (3 == i3) {
            i16 = 19;
            str2 = "param err";
        } else {
            i16 = 15;
            str2 = "start failed";
        }
        if (aVar.f305946j != null) {
            aVar.f305946j.c(i16, str2, new b(0L, aVar.a()).b());
        }
    }

    private void z(String str, a aVar) {
        String str2;
        QLog.w(f305911f, 1, "[UniformDL] inPStartDownload. file existed. sucess dricetly. url = " + str);
        aVar.c(2);
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = this.f305915c.getDownloadTaskState(str);
            k(str);
            aVar.b(aVar.f305939c);
            if (aVar.f305946j != null) {
                Bundle b16 = new b(0L, aVar.a()).b();
                com.tencent.mobileqq.uniformdownload.util.c cVar = aVar.f305946j;
                if (downloadTaskState == null) {
                    str2 = null;
                } else {
                    str2 = downloadTaskState.mSavePath;
                }
                cVar.d(str2, b16);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (aVar.f305946j != null) {
                aVar.f305946j.c(20, f.a(20), new b(0L, aVar.a()).b());
            }
        }
    }

    public int B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).intValue();
        }
        QLog.i(f305911f, 1, "[UniformDL] puaseADownload.url = " + str);
        if (str == null) {
            QLog.e(f305911f, 1, "[UniformDL] puaseADownload, url = null");
            return -1;
        }
        a l3 = l(str);
        if (l3 == null) {
            QLog.w(f305911f, 1, "[UniformDL] puaseADownload, not exsit download,url = " + str);
            return -2;
        }
        l3.c(2);
        E();
        if (!this.f305914b.post(new Runnable(str) { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f305919d;

            {
                this.f305919d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloaderAppBabySdk.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    UniformDownloaderAppBabySdk.this.t(this.f305919d, 2);
                    UniformDownloaderAppBabySdk.this.H();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        })) {
            QLog.i(f305911f, 1, "[UniformDL] puaseADownload.post failed url = " + str);
            return -3;
        }
        return 0;
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f305915c != null) {
            QLog.w(f305911f, 1, "[UniformDL] >>>release ABSdkClient...");
            this.f305915c.unRegisterDownloadTaskListener(this.f305917e);
            this.f305915c = null;
            TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).releaseDownloadSDKClient("UF_DL_CLIENT");
            return;
        }
        QLog.w(f305911f, 1, "[UniformDL] releaseABSdkClient. client had be stoped");
    }

    public int D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).intValue();
        }
        QLog.i(f305911f, 1, "[UniformDL] startADownload.url = " + str);
        if (str == null) {
            QLog.e(f305911f, 1, "[UniformDL] startADownload, url = null");
            return -1;
        }
        a l3 = l(str);
        if (l3 == null) {
            QLog.w(f305911f, 1, "[UniformDL] startADownload, not exsit download,url = " + str);
            return -2;
        }
        l3.c(1);
        E();
        if (!this.f305914b.post(new Runnable(str) { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f305918d;

            {
                this.f305918d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloaderAppBabySdk.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    UniformDownloaderAppBabySdk.this.t(this.f305918d, 1);
                    UniformDownloaderAppBabySdk.this.H();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        })) {
            QLog.i(f305911f, 1, "[UniformDL] startADownload.post failed url = " + str);
            l3.c(2);
            return -3;
        }
        return 0;
    }

    public int F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).intValue();
        }
        QLog.i(f305911f, 1, "[UniformDL] stopADownload.url = " + str);
        if (str == null) {
            QLog.e(f305911f, 1, "[UniformDL] stopADownload, url = null");
            return -1;
        }
        a l3 = l(str);
        if (l3 == null) {
            QLog.w(f305911f, 1, "[UniformDL] stopADownload, not exsit download,url = " + str);
            return 0;
        }
        l3.c(2);
        E();
        if (!this.f305914b.post(new Runnable(str) { // from class: com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f305920d;

            {
                this.f305920d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UniformDownloaderAppBabySdk.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    UniformDownloaderAppBabySdk.this.t(this.f305920d, 3);
                    UniformDownloaderAppBabySdk.this.H();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        })) {
            k(str);
            QLog.w(f305911f, 1, "[UniformDL] stopADownload, post failed,url = " + str);
        }
        return 0;
    }

    public int w(long j3, String str, long j16, com.tencent.mobileqq.uniformdownload.util.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, Long.valueOf(j16), cVar)).intValue();
        }
        if (str == null) {
            QLog.e(f305911f, 1, "[UniformDL] [" + j3 + "] initADownload, url = null");
            return -1;
        }
        a aVar = new a(j3, str, j16);
        aVar.f305946j = cVar;
        int i3 = i(str, aVar);
        if (i3 == 0) {
            return 0;
        }
        QLog.w(f305911f, 1, "[UniformDL]  [" + j3 + "] initADownload failed:" + i3);
        return -2;
    }

    public boolean x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (l(str) != null) {
            return true;
        }
        return false;
    }
}
