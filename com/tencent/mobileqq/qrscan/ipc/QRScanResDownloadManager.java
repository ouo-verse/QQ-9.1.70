package com.tencent.mobileqq.qrscan.ipc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qrscan.earlydown.e;
import com.tencent.mobileqq.qrscan.earlydown.f;
import com.tencent.mobileqq.qrscan.earlydown.g;
import com.tencent.mobileqq.qrscan.earlydown.h;
import com.tencent.mobileqq.qrscan.earlydown.i;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRScanResDownloadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Handler f276642a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<a> f276643b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f276644d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f276645e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f276646f;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            a aVar = this.f276644d;
            if (aVar != null) {
                aVar.onProgress(this.f276645e, this.f276646f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(int i3, boolean z16);

        void onProgress(int i3, int i16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276642a = new Handler(Looper.getMainLooper());
            f276643b = new ArrayList<>(2);
        }
    }

    public QRScanResDownloadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (QRScanResDownloadManager.class) {
            if (aVar != null) {
                if (!f276643b.contains(aVar)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniRecog.ResDownloadManager", 2, "addDownloadCallback");
                    }
                    f276643b.add(aVar);
                }
            }
        }
    }

    public static boolean b(int i3, AppInterface appInterface) {
        boolean f16 = f(i3, appInterface);
        if (!f16) {
            h(i3, appInterface);
        }
        return f16;
    }

    public static void c(int i3, AppInterface appInterface) {
        com.tencent.mobileqq.earlydownload.handler.b earlyHandler;
        boolean t16;
        boolean z16;
        IEarlyDownloadService d16 = d(appInterface);
        if (d16 == null) {
            return;
        }
        boolean b16 = b(i3, appInterface);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        earlyHandler = null;
                        t16 = false;
                    } else {
                        earlyHandler = d16.getEarlyHandler("qq.android.qbarnative.model_v8.6.0");
                        t16 = i.s();
                    }
                } else {
                    earlyHandler = d16.getEarlyHandler("qq.android.minidetect.model_v8.9.85");
                    t16 = com.tencent.mobileqq.qrscan.earlydown.d.t();
                }
            } else {
                earlyHandler = d16.getEarlyHandler("qq.android.minidetect.so_v8.9.85");
                t16 = g.t();
            }
        } else {
            earlyHandler = d16.getEarlyHandler("qq.android.minidecode.so_v8.8.5");
            t16 = com.tencent.mobileqq.qrscan.earlydown.c.t();
        }
        if (earlyHandler != null) {
            int v3 = earlyHandler.v();
            if (b16 && t16 && earlyHandler.A() && v3 > 1) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.d("MiniRecog.ResDownloadManager", 1, String.format("downloadMiniRes resType=%d needDownload=%b bConfigReady=%b bResExits=%b isEarlySuc=%b version=%d", Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(b16), Boolean.valueOf(t16), Boolean.valueOf(earlyHandler.A()), Integer.valueOf(v3)));
            if (z16) {
                earlyHandler.I(true);
            }
        }
    }

    private static IEarlyDownloadService d(AppInterface appInterface) {
        Object valueOf;
        if (appInterface != null && appInterface.isLogin()) {
            try {
                return (IEarlyDownloadService) appInterface.getRuntimeService(IEarlyDownloadService.class, "");
            } catch (Exception e16) {
                QLog.d("MiniRecog.ResDownloadManager", 1, "getEarlyDownloadService() ex. " + e16.getMessage(), e16);
            }
        } else if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = appInterface;
            if (appInterface == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(appInterface.isLogin());
            }
            objArr[1] = valueOf;
            QLog.d("MiniRecog.ResDownloadManager", 2, String.format("getEarlyDownloadService() err app=%s app.isLogin=%s", objArr));
        }
        return null;
    }

    private static boolean e(com.tencent.mobileqq.earlydownload.handler.b bVar) {
        XmlData o16;
        if (bVar == null || (o16 = bVar.o()) == null) {
            return false;
        }
        if (!TextUtils.isEmpty(o16.strPkgName) && !TextUtils.isEmpty(o16.strResURL_big)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.ResDownloadManager", 2, "strPkgName is empty:" + TextUtils.isEmpty(o16.strPkgName) + " strResURL_big is empty:" + TextUtils.isEmpty(o16.strResURL_big) + " loadState :" + o16.loadState);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (com.tencent.mobileqq.qrscan.earlydown.i.s() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (com.tencent.mobileqq.qrscan.earlydown.d.t() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(int i3, AppInterface appInterface) {
        boolean e16;
        IEarlyDownloadService d16 = d(appInterface);
        if (d16 == null) {
            return false;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        h hVar = (h) d16.getEarlyHandler("qq.android.qbarnative.model_v8.6.0");
                        e16 = e(hVar);
                        if (!e16) {
                            if (hVar != null) {
                                if (hVar.A()) {
                                }
                            }
                        }
                    }
                    e16 = false;
                } else {
                    e eVar = (e) d16.getEarlyHandler("qq.android.minidetect.model_v8.9.85");
                    e16 = e(eVar);
                    if (!e16) {
                        if (eVar != null) {
                            if (eVar.A()) {
                            }
                        }
                    }
                }
            } else {
                f fVar = (f) d16.getEarlyHandler("qq.android.minidetect.so_v8.9.85");
                if (fVar != null) {
                    e16 = e(fVar);
                    if (!e16 && fVar.A() && g.t()) {
                        e16 = true;
                    }
                    if (e16) {
                        fVar.N();
                    }
                }
                e16 = false;
            }
        } else {
            com.tencent.mobileqq.qrscan.earlydown.b bVar = (com.tencent.mobileqq.qrscan.earlydown.b) d16.getEarlyHandler("qq.android.minidecode.so_v8.8.5");
            if (bVar != null) {
                e16 = e(bVar);
                if (!e16 && bVar.A() && com.tencent.mobileqq.qrscan.earlydown.c.t()) {
                    e16 = true;
                }
                if (e16) {
                    bVar.N();
                }
            }
            e16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.ResDownloadManager", 2, String.format("isResConfigReady exist [resType=%d] = [%b]", Integer.valueOf(i3), Boolean.valueOf(e16)));
        }
        return e16;
    }

    public static void g(int i3, boolean z16) {
        Object[] array;
        synchronized (QRScanResDownloadManager.class) {
            array = f276643b.toArray();
        }
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                f276642a.post(new Runnable(i3, z16) { // from class: com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f276648e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f276649f;

                    {
                        this.f276648e = i3;
                        this.f276649f = z16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, a.this, Integer.valueOf(i3), Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        a aVar = a.this;
                        if (aVar != null) {
                            aVar.a(this.f276648e, this.f276649f);
                        }
                    }
                });
            }
        }
    }

    public static void h(int i3, AppInterface appInterface) {
        h hVar;
        IEarlyDownloadService d16 = d(appInterface);
        if (d16 == null) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && (hVar = (h) d16.getEarlyHandler("qq.android.qbarnative.model_v8.6.0")) != null && hVar.A() && !i.s()) {
                        hVar.M();
                        if (QLog.isColorLevel()) {
                            QLog.d("MiniRecog.ResDownloadManager", 2, String.format("resetResDownloadState resType=%d download state", Integer.valueOf(i3)));
                            return;
                        }
                        return;
                    }
                    return;
                }
                e eVar = (e) d16.getEarlyHandler("qq.android.minidetect.model_v8.9.85");
                if (eVar != null && eVar.A() && !com.tencent.mobileqq.qrscan.earlydown.d.t()) {
                    eVar.M();
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniRecog.ResDownloadManager", 2, String.format("resetResDownloadState resType=%d download state", Integer.valueOf(i3)));
                        return;
                    }
                    return;
                }
                return;
            }
            f fVar = (f) d16.getEarlyHandler("qq.android.minidetect.so_v8.9.85");
            if (fVar != null && fVar.A() && !g.t()) {
                fVar.M();
                if (QLog.isColorLevel()) {
                    QLog.d("MiniRecog.ResDownloadManager", 2, String.format("resetResDownloadState resType=%d download state", Integer.valueOf(i3)));
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.mobileqq.qrscan.earlydown.b bVar = (com.tencent.mobileqq.qrscan.earlydown.b) d16.getEarlyHandler("qq.android.minidecode.so_v8.8.5");
        if (bVar != null && bVar.A() && !com.tencent.mobileqq.qrscan.earlydown.c.t()) {
            bVar.M();
            if (QLog.isColorLevel()) {
                QLog.d("MiniRecog.ResDownloadManager", 2, String.format("resetResDownloadState resType=%d download state", Integer.valueOf(i3)));
            }
        }
    }
}
