package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk;
import com.tencent.mobileqq.uniformdownload.util.f;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends c implements com.tencent.mobileqq.uniformdownload.util.b {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.mobileqq.uniformdownload.util.d f305955o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f305956p;

    /* renamed from: q, reason: collision with root package name */
    private Object f305957q;

    /* renamed from: r, reason: collision with root package name */
    long f305958r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements com.tencent.mobileqq.uniformdownload.util.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.c
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bundle);
                return;
            }
            b.this.h(i3);
            if (b.this.f305955o != null) {
                if (i3 > 100) {
                    b.this.f305955o.a(b.this.e(), bundle);
                } else if (i3 - b.this.d() > 0) {
                    b.this.g(i3);
                    b.this.f305955o.a(i3, bundle);
                }
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.c
        public void b(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            b.this.i(3);
            if (b.this.f305955o != null) {
                b.this.f305955o.R0(b.this.e(), null);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.c
        public void c(int i3, String str, Bundle bundle) {
            a aVar;
            Bundle bundle2;
            String str2;
            long j3;
            long j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            b.this.i(5);
            AppRuntime k3 = UniformDownloadMgr.m().k();
            if (k3 != null) {
                UniformDownloaderAppBabySdk.b a16 = UniformDownloaderAppBabySdk.b.a(bundle);
                if (a16 != null) {
                    j3 = a16.f305948a;
                    j16 = a16.f305949b;
                } else {
                    j3 = -1;
                    j16 = -1;
                }
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
                b bVar = b.this;
                long j17 = bVar.f305966f;
                long j18 = bVar.f305958r;
                long j19 = i3;
                bundle2 = bundle;
                str2 = str;
                ah.A1(baseQQAppInterface, j17, "actFileUfAppBabySdkDownload", j18, "", "", "", "", j19, str, j3, j16, bVar.f305963c, bVar.f305961a, "", 0, str, null);
                aVar = this;
                b bVar2 = b.this;
                ah.A1(baseQQAppInterface, bVar2.f305966f, "actFileUfAppBabySdkDownloadDetail", bVar2.f305958r, "", "", "", "", j19, str, j3, j16, bVar2.f305963c, bVar2.f305961a, "", 0, str, null);
            } else {
                aVar = this;
                bundle2 = bundle;
                str2 = str;
                QLog.w(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "].report failed - 6");
            }
            if (b.this.f305955o != null) {
                b.this.f305955o.c(i3, str2, bundle2);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.c
        public void d(String str, Bundle bundle) {
            long j3;
            long j16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bundle);
                return;
            }
            QLog.i(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "] >>>>>>Download SUCCESS. sdk download path=" + str);
            b.this.i(4);
            if (str == null) {
                QLog.e(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "]. download success, but filepath = null");
                c(40, f.a(40), bundle);
                return;
            }
            if (FileUtils.fileExists(b.this.f305964d)) {
                b bVar = b.this;
                bVar.f305964d = ah.w1(bVar.f305964d);
            }
            QLog.i(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "]. try to rename file to path:" + b.this.f305964d);
            if (!FileUtils.renameFile(new File(str), new File(b.this.f305964d))) {
                QLog.e(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "].rename failed. temppath=" + str + " save path=" + b.this.f305964d);
                String k3 = q.k(str);
                if (!ah.c0().equalsIgnoreCase(k3)) {
                    String str2 = k3 + b.this.f305962b;
                    if (FileUtils.fileExists(str2)) {
                        str2 = ah.w1(str2);
                    }
                    QLog.i(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "]. rename failed, try to save file to path: " + str2);
                    if (!FileUtils.renameFile(new File(str), new File(str2))) {
                        QLog.e(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "]. rename failed, try failed save path: " + str2);
                        c(7, f.a(7), bundle);
                        return;
                    }
                    b.this.f305964d = str2;
                } else {
                    QLog.e(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "]. rename failed 2, try failed save path: " + str);
                    c(7, f.a(7), bundle);
                    return;
                }
            }
            QLog.i(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "]. rename file success. path:" + b.this.f305964d);
            AppRuntime k16 = UniformDownloadMgr.m().k();
            if (k16 != null) {
                UniformDownloaderAppBabySdk.b a16 = UniformDownloaderAppBabySdk.b.a(bundle);
                if (a16 != null) {
                    j3 = a16.f305948a;
                    j16 = a16.f305949b;
                } else {
                    QLog.w(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "].report may failed - 0");
                    j3 = -1L;
                    j16 = -1L;
                }
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k16;
                long j17 = b.this.f305966f;
                long currentTimeMillis = System.currentTimeMillis();
                b bVar2 = b.this;
                ah.C1(baseQQAppInterface, j17, "actFileUfAppBabySdkDownload", currentTimeMillis - bVar2.f305958r, "", "", "", "", j3, j16, bVar2.f305963c, 0, null);
                long j18 = b.this.f305966f;
                long currentTimeMillis2 = System.currentTimeMillis();
                b bVar3 = b.this;
                ah.C1(baseQQAppInterface, j18, "actFileUfAppBabySdkDownloadDetail", currentTimeMillis2 - bVar3.f305958r, "", "", "", "", j3, j16, bVar3.f305963c, 0, null);
            } else {
                QLog.i(c.f305960n, 1, "[UniformDL][" + b.this.f305966f + "].report failed - 7");
            }
            if (b.this.f305955o != null) {
                com.tencent.mobileqq.uniformdownload.util.d dVar = b.this.f305955o;
                b bVar4 = b.this;
                dVar.h(bVar4.f305964d, bVar4.f305963c, bundle);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.c
        public void e(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.util.c
        public void f(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            } else if (b.this.f305955o != null) {
                b.this.f305955o.g0(b.this.e(), null);
            }
        }
    }

    public b(long j3) {
        super(j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.f305956p = false;
        this.f305957q = new Object();
        this.f305958r = 0L;
    }

    private int k() {
        int w3 = UniformDownloaderAppBabySdk.m().w(this.f305966f, this.f305961a, this.f305963c, new a());
        if (w3 == 0) {
            n(true);
        }
        return w3;
    }

    private boolean l() {
        boolean z16;
        synchronized (this.f305957q) {
            z16 = this.f305956p;
        }
        return z16;
    }

    private void m() {
        String a16 = f.a(1);
        AppRuntime k3 = UniformDownloadMgr.m().k();
        if (k3 != null) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
            long j3 = this.f305966f;
            long j16 = this.f305958r;
            long j17 = 1;
            long e16 = e();
            long j18 = this.f305963c;
            ah.A1(baseQQAppInterface, j3, "actFileUfAppBabySdkDownload", j16, "", "", "", "", j17, a16, 0L, e16 * j18, j18, this.f305961a, "", 0, a16, null);
            long j19 = this.f305966f;
            long j26 = this.f305958r;
            long e17 = e();
            long j27 = this.f305963c;
            ah.A1(baseQQAppInterface, j19, "actFileUfAppBabySdkDownloadDetail", j26, "", "", "", "", j17, a16, 0L, e17 * j27, j27, this.f305961a, "", 0, a16, null);
            return;
        }
        QLog.w(c.f305960n, 1, "[UniformDL][" + this.f305966f + "].report failed - 9");
    }

    private void n(boolean z16) {
        synchronized (this.f305957q) {
            this.f305956p = z16;
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int a(com.tencent.mobileqq.uniformdownload.util.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar)).intValue();
        }
        this.f305955o = dVar;
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.downloader.c, com.tencent.mobileqq.uniformdownload.util.b
    public int c(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle)).intValue();
        }
        return super.c(str, bundle);
    }

    @Override // com.tencent.mobileqq.uniformdownload.downloader.c, com.tencent.mobileqq.uniformdownload.util.b
    public int getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return super.getStatus();
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (!f()) {
            QLog.e(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] pause. not inited");
            com.tencent.mobileqq.uniformdownload.util.d dVar = this.f305955o;
            if (dVar != null) {
                dVar.c(1, f.a(1), null);
                return -1;
            }
            return -1;
        }
        boolean l3 = l();
        int status = getStatus();
        if (1 != status && l3) {
            if (3 != status && 7 != status) {
                int B = UniformDownloaderAppBabySdk.m().B(this.f305961a);
                if (B == 0) {
                    QLog.i(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] pause. ST:" + status + " PGR:" + e());
                    i(3);
                } else {
                    QLog.e(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] pause failed. ST:" + status + " PGR:" + e());
                    i(5);
                    String a16 = f.a(15);
                    AppRuntime k3 = UniformDownloadMgr.m().k();
                    if (k3 != null) {
                        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
                        long j3 = this.f305966f;
                        long j16 = this.f305958r;
                        long j17 = 15;
                        long e16 = e();
                        long j18 = this.f305963c;
                        ah.A1(baseQQAppInterface, j3, "actFileUfAppBabySdkDownload", j16, "", "", "", "", j17, a16, 0L, e16 * j18, j18, this.f305961a, "", 0, a16, null);
                        long j19 = this.f305966f;
                        long j26 = this.f305958r;
                        long e17 = e();
                        long j27 = this.f305963c;
                        ah.A1(baseQQAppInterface, j19, "actFileUfAppBabySdkDownloadDetail", j26, "", "", "", "", j17, a16, 0L, e17 * j27, j27, this.f305961a, "", 0, a16, null);
                    } else {
                        QLog.w(c.f305960n, 1, "[UniformDL][" + this.f305966f + "].report failed - 8");
                    }
                    com.tencent.mobileqq.uniformdownload.util.d dVar2 = this.f305955o;
                    if (dVar2 != null) {
                        dVar2.c(15, null, null);
                    }
                }
                return B;
            }
            QLog.w(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] pause. had be paused");
            return 0;
        }
        QLog.i(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] waiting and pause. ST:" + status + " PGR:" + e() + "(inited)");
        i(3);
        com.tencent.mobileqq.uniformdownload.util.d dVar3 = this.f305955o;
        if (dVar3 != null) {
            dVar3.R0(e(), null);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (!f()) {
            QLog.e(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] resume. not inited");
            com.tencent.mobileqq.uniformdownload.util.d dVar = this.f305955o;
            if (dVar != null) {
                dVar.c(1, f.a(1), null);
                return -1;
            }
            return -1;
        }
        int status = getStatus();
        if (6 != status && 2 != status && 4 != status) {
            QLog.i(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] resume. ST:" + status + " PGR:" + e());
            i(6);
            com.tencent.mobileqq.uniformdownload.util.d dVar2 = this.f305955o;
            if (dVar2 != null) {
                dVar2.c2(e(), null);
            }
            return 0;
        }
        QLog.w(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] resume. had be resumed");
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        this.f305958r = System.currentTimeMillis();
        AppRuntime k3 = UniformDownloadMgr.m().k();
        if (!f()) {
            QLog.e(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] start. not inited");
            m();
            com.tencent.mobileqq.uniformdownload.util.d dVar = this.f305955o;
            if (dVar != null) {
                dVar.c(1, f.a(1), null);
            }
            return -1;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            i(5);
            String a16 = f.a(5);
            if (k3 != null) {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
                long j3 = this.f305966f;
                long j16 = this.f305958r;
                long j17 = 5;
                long e16 = e();
                long j18 = this.f305963c;
                ah.A1(baseQQAppInterface, j3, "actFileUfAppBabySdkDownload", j16, "", "", "", "", j17, a16, 0L, e16 * j18, j18, this.f305961a, "", 0, a16, null);
                long j19 = this.f305966f;
                long j26 = this.f305958r;
                long e17 = e();
                long j27 = this.f305963c;
                ah.A1(baseQQAppInterface, j19, "actFileUfAppBabySdkDownloadDetail", j26, "", "", "", "", j17, a16, 0L, e17 * j27, j27, this.f305961a, "", 0, a16, null);
            } else {
                QLog.w(c.f305960n, 1, "[UniformDL][" + this.f305966f + "].report failed - 8");
            }
            com.tencent.mobileqq.uniformdownload.util.d dVar2 = this.f305955o;
            if (dVar2 != null) {
                dVar2.c(5, a16, null);
                return -1;
            }
            return -1;
        }
        int status = getStatus();
        if (2 == status) {
            QLog.w(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] start. is runing");
            return 0;
        }
        if (1 != status && 6 != status) {
            QLog.e(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] start. before status is error:" + status);
            return -1;
        }
        g(0);
        if (1 == status) {
            QLog.i(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] start download. AddDownloadToAppBabySdk");
            k();
        } else if (6 == status && !UniformDownloaderAppBabySdk.m().x(this.f305961a)) {
            QLog.i(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] resume download and start it. sdk is not this download, AddDownloadToAppBabySdk");
            k();
        }
        int D = UniformDownloaderAppBabySdk.m().D(this.f305961a);
        if (D == 0) {
            QLog.i(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] start. ST:" + status + " PGR:" + e());
            i(2);
        } else {
            QLog.i(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] start failed. ST:" + status + " PGR:" + e());
            i(5);
            String a17 = f.a(2);
            if (k3 != null) {
                BaseQQAppInterface baseQQAppInterface2 = (BaseQQAppInterface) k3;
                long j28 = this.f305966f;
                long j29 = this.f305958r;
                long j36 = 2;
                long e18 = e();
                long j37 = this.f305963c;
                ah.A1(baseQQAppInterface2, j28, "actFileUfAppBabySdkDownload", j29, "", "", "", "", j36, a17, 0L, e18 * j37, j37, this.f305961a, "", 0, a17, null);
                long j38 = this.f305966f;
                long j39 = this.f305958r;
                long e19 = e();
                long j46 = this.f305963c;
                ah.A1(baseQQAppInterface2, j38, "actFileUfAppBabySdkDownloadDetail", j39, "", "", "", "", j36, a17, 0L, e19 * j46, j46, this.f305961a, "", 0, a17, null);
            } else {
                QLog.w(c.f305960n, 1, "[UniformDL][" + this.f305966f + "].report failed - 8");
            }
            com.tencent.mobileqq.uniformdownload.util.d dVar3 = this.f305955o;
            if (dVar3 != null) {
                dVar3.c(2, null, null);
            }
        }
        return D;
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int status = getStatus();
        QLog.i(c.f305960n, 1, "[UniformDL][" + this.f305966f + "] stop. ST:" + status + " PGR:" + e());
        i(7);
        return UniformDownloaderAppBabySdk.m().F(this.f305961a);
    }
}
