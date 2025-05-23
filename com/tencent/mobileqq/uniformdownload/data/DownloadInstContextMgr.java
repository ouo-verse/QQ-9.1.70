package com.tencent.mobileqq.uniformdownload.data;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class DownloadInstContextMgr {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, b> f305869a;

    /* renamed from: b, reason: collision with root package name */
    private e f305870b;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements com.tencent.mobileqq.uniformdownload.util.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadInstContextMgr.this);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.a
        public void a(String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final long f305872a;

        /* renamed from: b, reason: collision with root package name */
        final Bundle f305873b;

        /* renamed from: c, reason: collision with root package name */
        public final int f305874c;

        /* renamed from: d, reason: collision with root package name */
        public String f305875d;

        /* renamed from: e, reason: collision with root package name */
        public UniformDownloader f305876e;

        /* renamed from: f, reason: collision with root package name */
        public final int f305877f;

        public b(Bundle bundle, int i3, UniformDownloader uniformDownloader, long j3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bundle, Integer.valueOf(i3), uniformDownloader, Long.valueOf(j3), Integer.valueOf(i16));
                return;
            }
            this.f305873b = bundle;
            this.f305874c = i3;
            this.f305876e = uniformDownloader;
            this.f305872a = j3;
            this.f305875d = uniformDownloader.q();
            this.f305877f = i16;
            QLog.i("DownloadInstContextMgr", 1, "[UniformDL] new DownloadInst.[ mUDID:[" + j3 + "] url:" + this.f305875d + " ]");
        }
    }

    public DownloadInstContextMgr(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        } else {
            this.f305869a = new HashMap();
            this.f305870b = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        UniformDownloader uniformDownloader;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f305869a) {
            if (this.f305869a.size() > 0) {
                Iterator<Map.Entry<String, b>> it = this.f305869a.entrySet().iterator();
                while (it.hasNext()) {
                    b value = it.next().getValue();
                    if (value != null && (uniformDownloader = value.f305876e) != null && uniformDownloader.t() && 2 == value.f305876e.p()) {
                        arrayList.add(value);
                    }
                }
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((b) it5.next()).f305876e.w();
        }
        n();
    }

    public boolean b(String str, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bVar)).booleanValue();
        }
        if (str != null && bVar != null) {
            synchronized (this.f305869a) {
                if (this.f305869a.containsKey(str)) {
                    QLog.i("DownloadInstContextMgr", 1, "[UniformDL] url[" + str + "] exsited! total[" + this.f305869a.size() + "]");
                    return false;
                }
                this.f305869a.put(str, bVar);
                QLog.i("DownloadInstContextMgr", 1, "[UniformDL] addDownloadInst.. total[" + this.f305869a.size() + "] add it. url[" + str + "]");
                return true;
            }
        }
        QLog.e("DownloadInstContextMgr", 1, "[UniformDL] addDownloadInst.. param null");
        return false;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        synchronized (this.f305869a) {
            if (this.f305869a.size() == 0) {
                return;
            }
            Iterator<Map.Entry<String, b>> it = this.f305869a.entrySet().iterator();
            while (it.hasNext()) {
                b value = it.next().getValue();
                UniformDownloader uniformDownloader = value.f305876e;
                if (uniformDownloader != null && uniformDownloader.t()) {
                    QLog.i("DownloadInstContextMgr", 1, "[UniformDL] >>>onQQProcessExit. stop download:url:" + value.f305875d);
                }
                Bundle bundle = new Bundle();
                bundle.putString("_notify_param_Url", value.f305875d);
                com.tencent.mobileqq.uniformdownload.core.b.h().q(value.f305877f, bundle);
                QLog.i("DownloadInstContextMgr", 1, "[UniformDL] >>>onQQProcessExit. cancel notification:" + value.f305877f);
            }
        }
    }

    public int d(String str) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).intValue();
        }
        synchronized (this.f305869a) {
            b remove = this.f305869a.remove(str);
            if (remove != null) {
                com.tencent.mobileqq.uniformdownload.util.d c16 = this.f305870b.c(str);
                UniformDownloader uniformDownloader = remove.f305876e;
                if (uniformDownloader != null && c16 != null) {
                    uniformDownloader.x(c16);
                }
            }
            size = this.f305869a.size();
            QLog.i("DownloadInstContextMgr", 1, "[UniformDL] delDownloadInst.. total[" + this.f305869a.size() + "] del it. url[" + str + "]");
        }
        return size;
    }

    public b e(String str) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        synchronized (this.f305869a) {
            bVar = this.f305869a.get(str);
        }
        return bVar;
    }

    public int f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
        }
        b e16 = e(str);
        if (e16 != null) {
            UniformDownloader uniformDownloader = e16.f305876e;
            if (uniformDownloader != null) {
                uniformDownloader.v();
            }
            k(null);
            return 0;
        }
        QLog.e("DownloadInstContextMgr", 1, "[UniformDL] inPPauseDownload.. inst not exsited. url:" + str);
        return -1;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QLog.i("DownloadInstContextMgr", 1, "[UniformDL] pauseSlienceRuningGenDownloadOfOldApp ...");
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DownloadInstContextMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DownloadInstContextMgr.this.g();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ArrayList<b> arrayList = new ArrayList();
        synchronized (this.f305869a) {
            if (this.f305869a.size() > 0) {
                Iterator<Map.Entry<String, b>> it = this.f305869a.entrySet().iterator();
                while (it.hasNext()) {
                    b value = it.next().getValue();
                    UniformDownloader uniformDownloader = value.f305876e;
                    if (uniformDownloader != null && 8 == uniformDownloader.o() && 2 == value.f305876e.p()) {
                        arrayList.add(value);
                    }
                }
            }
        }
        for (b bVar : arrayList) {
            QLog.w("DownloadInstContextMgr", 1, "[UniformDL] >>> resumeRuningGenDownloadOfOldApp, url:[" + bVar.f305875d + "]");
            bVar.f305876e.A();
        }
    }

    public int j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).intValue();
        }
        b e16 = e(str);
        if (e16 == null) {
            QLog.w("DownloadInstContextMgr", 1, "[UniformDL] inPResumeDownload.. inst not exsited. url:" + str);
            return -1;
        }
        if (e16.f305876e != null) {
            com.tencent.mobileqq.uniformdownload.util.d c16 = this.f305870b.c(str);
            if (c16 != null) {
                e16.f305876e.j(c16, false);
            }
            e16.f305876e.y();
        }
        k(null);
        return 0;
    }

    public int k(String str) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).intValue();
        }
        if (NetworkUtil.isNetSupport(BaseApplication.getContext()) && !ah.X0()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount. togetherDownloadMaxCount=" + i3);
        ArrayList arrayList = new ArrayList();
        synchronized (this.f305869a) {
            i16 = 0;
            if (this.f305869a.size() > 0) {
                Iterator<Map.Entry<String, b>> it = this.f305869a.entrySet().iterator();
                i17 = 0;
                while (it.hasNext()) {
                    b value = it.next().getValue();
                    UniformDownloader uniformDownloader = value.f305876e;
                    if (uniformDownloader != null && uniformDownloader.t()) {
                        i16++;
                        if (str != null && str.equalsIgnoreCase(value.f305875d)) {
                            QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount.. download is runing. traceUrl:" + str);
                            i17 = 1;
                        }
                    }
                    arrayList.add(value);
                }
            } else {
                i17 = 0;
            }
        }
        if (i16 < i3) {
            Iterator it5 = arrayList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                b bVar = (b) it5.next();
                UniformDownloader uniformDownloader2 = bVar.f305876e;
                if (uniformDownloader2 != null && uniformDownloader2.u()) {
                    if (i16 == i3) {
                        QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount.. total[" + this.f305869a.size() + "] the task of downloading is overload,other need waiting... 1");
                        break;
                    }
                    QLog.i("DownloadInstContextMgr", 1, "[UniformDL] >>> Happy. start a download task, url:[" + bVar.f305875d + "]");
                    i16++;
                    bVar.f305876e.A();
                    if (str != null && str.equalsIgnoreCase(bVar.f305875d)) {
                        QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount.. download is started. traceUrl:" + str);
                        i17 = 2;
                    }
                }
            }
        } else {
            QLog.i("DownloadInstContextMgr", 1, "[UniformDL] startWaitingDownloaderForMaxCount.. total[" + this.f305869a.size() + "] the task of downloading is overload,other need waiting... 2");
        }
        n();
        return i17;
    }

    public int l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).intValue();
        }
        b e16 = e(str);
        if (e16 != null) {
            UniformDownloader uniformDownloader = e16.f305876e;
            if (uniformDownloader != null) {
                uniformDownloader.B();
                return 0;
            }
            return 0;
        }
        QLog.e("DownloadInstContextMgr", 1, "[UniformDL] stopDownloaderByUrl.. inst not exsited. url:" + str);
        return -1;
    }

    public int m(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) bundle)).intValue();
        }
        if (str != null && bundle != null) {
            int i3 = bundle.getInt("_notify_param_Id");
            QLog.i("DownloadInstContextMgr", 1, "[UniformDL] >>>pauseDownloaderByUrl. URL:" + str + " nofiyid:" + i3);
            if (-1 == f(str)) {
                UniformDownloadUtil.e(str, new a());
                com.tencent.mobileqq.uniformdownload.core.b.h().r(i3, (Bundle) bundle.clone());
                k(null);
                return 0;
            }
            return 0;
        }
        QLog.e("DownloadInstContextMgr", 1, "[UniformDL] pauseDownloaderByUrl. param error!!");
        return -1;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DownloadInstContextMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        DownloadInstContextMgr.this.k(null);
                        DownloadInstContextMgr.this.n();
                    }
                }
            });
        }
    }
}
