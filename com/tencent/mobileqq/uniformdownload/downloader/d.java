package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.downloader.a;
import com.tencent.mobileqq.uniformdownload.util.f;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d extends c implements com.tencent.mobileqq.uniformdownload.util.b {
    static IPatchRedirector $redirector_;

    /* renamed from: s, reason: collision with root package name */
    public static String f305974s;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.mobileqq.uniformdownload.util.d f305975o;

    /* renamed from: p, reason: collision with root package name */
    private e f305976p;

    /* renamed from: q, reason: collision with root package name */
    private Object f305977q;

    /* renamed from: r, reason: collision with root package name */
    long f305978r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.downloader.d.b
        public void a(int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bundle);
                return;
            }
            d.this.h(i3);
            if (d.this.f305975o != null && i3 - d.this.d() > 0) {
                d.this.g(i3);
                d.this.f305975o.a(i3, bundle);
            }
        }

        @Override // com.tencent.mobileqq.uniformdownload.downloader.d.b
        public void c(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                d.this.m();
                d.this.i(5);
                if (d.this.f305975o != null) {
                    d.this.f305975o.c(i3, str, bundle);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, bundle);
        }

        @Override // com.tencent.mobileqq.uniformdownload.downloader.d.b
        public void h(String str, long j3, Bundle bundle) {
            long j16;
            long j17;
            int i3;
            Bundle bundle2;
            String str2;
            a aVar = this;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                d.this.m();
                d.this.i(4);
                if (FileUtils.fileExists(d.this.f305964d)) {
                    d dVar = d.this;
                    dVar.f305964d = ah.w1(dVar.f305964d);
                }
                QLog.i(d.f305974s, 1, "[UniformDL][" + d.this.f305966f + "]. >>>Download SUCCESS.  save file to: =" + d.this.f305964d);
                if (bundle != null) {
                    j16 = bundle.getLong("EXT_TRANS_SIZE ");
                    j17 = bundle.getLong("EXT_TTRANS_SIZE ");
                    i3 = bundle.getInt("EXT_AUTOTRY_COUNT");
                } else {
                    j16 = j3;
                    j17 = j16;
                    i3 = 1;
                }
                if (!FileUtils.renameFile(new File(d.this.f305965e), new File(d.this.f305964d))) {
                    QLog.e(d.f305974s, 1, "[UniformDL][" + d.this.f305966f + "].rename failed.temppath=" + d.this.f305965e + " path=" + d.this.f305964d);
                    d.this.i(5);
                    String a16 = f.a(7);
                    AppRuntime k3 = UniformDownloadMgr.m().k();
                    if (k3 != null) {
                        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
                        d dVar2 = d.this;
                        str2 = a16;
                        long j18 = 7;
                        ah.A1(baseQQAppInterface, dVar2.f305966f, "actFileUfGenDownload", dVar2.f305978r, "", "", "", "", j18, str2, j17, j16, dVar2.f305963c, dVar2.f305961a, "", 0, str2, null);
                        aVar = this;
                        d dVar3 = d.this;
                        ah.A1(baseQQAppInterface, dVar3.f305966f, "actFileUfGenDownloadDetail", dVar3.f305978r, "", "", "", "", j18, str2, j17, j16, dVar3.f305963c, dVar3.f305961a, "", 0, str2, null);
                    } else {
                        str2 = a16;
                        QLog.w(d.f305974s, 1, "[UniformDL][" + d.this.f305966f + "].report failed - 5");
                    }
                    if (d.this.f305975o != null) {
                        d.this.f305975o.c(7, str2, bundle);
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.uniformdownload.downloader.a.d().b(d.this.f305961a);
                AppRuntime k16 = UniformDownloadMgr.m().k();
                if (k16 != null) {
                    BaseQQAppInterface baseQQAppInterface2 = (BaseQQAppInterface) k16;
                    long j19 = d.this.f305966f;
                    long currentTimeMillis = System.currentTimeMillis();
                    d dVar4 = d.this;
                    bundle2 = bundle;
                    ah.C1(baseQQAppInterface2, j19, "actFileUfGenDownload", currentTimeMillis - dVar4.f305978r, "", "", "", "", j17, j16, dVar4.f305963c, i3, null);
                    long j26 = d.this.f305966f;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    d dVar5 = d.this;
                    ah.C1(baseQQAppInterface2, j26, "actFileUfGenDownloadDetail", currentTimeMillis2 - dVar5.f305978r, "", "", "", "", j17, j16, dVar5.f305963c, i3, null);
                } else {
                    bundle2 = bundle;
                    QLog.i(d.f305974s, 1, "[UniformDL][" + d.this.f305966f + "].report failed - 0");
                }
                if (d.this.f305975o != null) {
                    d dVar6 = d.this;
                    long j27 = dVar6.f305963c;
                    if (j27 <= 0 || j3 > 0) {
                        j27 = j3;
                    }
                    dVar6.f305975o.h(d.this.f305964d, j27, bundle2);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, aVar, str, Long.valueOf(j3), bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface b {
        void a(int i3, Bundle bundle);

        void c(int i3, String str, Bundle bundle);

        void h(String str, long j3, Bundle bundle);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19687);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f305974s = "UniformDownloaderGen";
        }
    }

    public d(long j3) {
        super(j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.f305976p = null;
        this.f305977q = new Object();
        this.f305978r = 0L;
    }

    private e l() {
        e eVar;
        synchronized (this.f305977q) {
            eVar = this.f305976p;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] killWoker. ");
        e l3 = l();
        if (l3 != null) {
            l3.r();
            p(null);
            return;
        }
        QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] killWoker. not worker");
    }

    private void n() {
        String a16 = f.a(1);
        AppRuntime k3 = UniformDownloadMgr.m().k();
        if (k3 != null) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
            long j3 = this.f305966f;
            long j16 = this.f305978r;
            long j17 = 1;
            long e16 = e();
            long j18 = this.f305963c;
            ah.A1(baseQQAppInterface, j3, "actFileUfGenDownload", j16, "", "", "", "", j17, a16, 0L, e16 * j18, j18, this.f305961a, "", 0, a16, null);
            long j19 = this.f305966f;
            long j26 = this.f305978r;
            long e17 = e();
            long j27 = this.f305963c;
            ah.A1(baseQQAppInterface, j19, "actFileUfGenDownloadDetail", j26, "", "", "", "", j17, a16, 0L, e17 * j27, j27, this.f305961a, "", 0, a16, null);
            return;
        }
        QLog.w(f305974s, 1, "[UniformDL][" + this.f305966f + "].report failed - 9");
    }

    private boolean o(long j3) {
        e l3 = l();
        if (l3 != null) {
            QLog.w(f305974s, 1, "[UniformDL][" + this.f305966f + "] runWorker. before worker be stoped");
            l3.r();
        }
        if (UniformDownloadMgr.m().k() == null) {
            return false;
        }
        e eVar = new e(this.f305966f, UniformDownloadMgr.m().k(), this.f305961a, this.f305963c, this.f305967g, new a());
        p(eVar);
        QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] runWorker. start ,mTempStrFilePath=" + this.f305965e);
        return eVar.q(this.f305965e, j3);
    }

    private void p(e eVar) {
        synchronized (this.f305977q) {
            this.f305976p = eVar;
        }
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int a(com.tencent.mobileqq.uniformdownload.util.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar)).intValue();
        }
        this.f305975o = dVar;
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] resume. ST:" + getStatus() + " PGR:" + e());
        i(8);
        e l3 = l();
        if (l3 != null) {
            l3.l();
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.downloader.c, com.tencent.mobileqq.uniformdownload.util.b
    public int c(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bundle)).intValue();
        }
        super.c(str, bundle);
        a.C8879a c16 = com.tencent.mobileqq.uniformdownload.downloader.a.d().c(str);
        if (c16 != null) {
            QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] >>>init. HAPPY.have a BreakpointTransInfo,tempPath:" + c16.f305953c);
            if (ah.I(c16.f305953c)) {
                this.f305965e = c16.f305953c;
                return 0;
            }
            QLog.e(f305974s, 1, "[UniformDL][" + this.f305966f + "] >>>init. no exsit");
            return 0;
        }
        QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] >>>init. NO HAPPY. Not BreakpointTransInfo,add it:");
        com.tencent.mobileqq.uniformdownload.downloader.a.d().a(str, null, this.f305963c, this.f305965e, this.f305964d);
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.downloader.c, com.tencent.mobileqq.uniformdownload.util.b
    public int getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
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
            QLog.e(f305974s, 1, "[UniformDL][" + this.f305966f + "] pause. not inited");
            n();
            com.tencent.mobileqq.uniformdownload.util.d dVar = this.f305975o;
            if (dVar != null) {
                dVar.c(1, f.a(1), null);
                return -1;
            }
            return -1;
        }
        int status = getStatus();
        if (3 != status && 7 != status) {
            synchronized (this) {
                m();
            }
            QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] pause. ST:" + status + " PGR:" + e());
            i(3);
            com.tencent.mobileqq.uniformdownload.util.d dVar2 = this.f305975o;
            if (dVar2 != null) {
                dVar2.R0(e(), null);
            }
            return 0;
        }
        QLog.w(f305974s, 1, "[UniformDL][" + this.f305966f + "] pause. had be paused");
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (!f()) {
            QLog.e(f305974s, 1, "[UniformDL][" + this.f305966f + "] resume. not inited");
            n();
            com.tencent.mobileqq.uniformdownload.util.d dVar = this.f305975o;
            if (dVar != null) {
                dVar.c(1, f.a(1), null);
                return -1;
            }
            return -1;
        }
        int status = getStatus();
        if (6 != status && 2 != status && 4 != status) {
            QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] resume. ST:" + status + " PGR:" + e());
            i(6);
            com.tencent.mobileqq.uniformdownload.util.d dVar2 = this.f305975o;
            if (dVar2 != null) {
                dVar2.c2(e(), null);
            }
            return 0;
        }
        QLog.w(f305974s, 1, "[UniformDL][" + this.f305966f + "] resume. had be resumed");
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int start() {
        long j3;
        com.tencent.mobileqq.uniformdownload.util.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        this.f305978r = System.currentTimeMillis();
        AppRuntime k3 = UniformDownloadMgr.m().k();
        boolean z16 = true;
        if (!f()) {
            QLog.e(f305974s, 1, "[UniformDL][" + this.f305966f + "] start. not inited");
            n();
            com.tencent.mobileqq.uniformdownload.util.d dVar2 = this.f305975o;
            if (dVar2 != null) {
                dVar2.c(1, f.a(1), null);
            }
            return -1;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.e(f305974s, 1, "[UniformDL][" + this.f305966f + "] start. but net is broken. failed drictly");
            m();
            i(5);
            String a16 = f.a(5);
            if (k3 != null) {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
                long j16 = this.f305966f;
                long j17 = this.f305978r;
                long j18 = 5;
                long e16 = e();
                long j19 = this.f305963c;
                ah.A1(baseQQAppInterface, j16, "actFileUfGenDownload", j17, "", "", "", "", j18, a16, 0L, e16 * j19, j19, this.f305961a, "", 0, a16, null);
                long j26 = this.f305966f;
                long j27 = this.f305978r;
                long e17 = e();
                long j28 = this.f305963c;
                ah.A1(baseQQAppInterface, j26, "actFileUfGenDownloadDetail", j27, "", "", "", "", j18, a16, 0L, e17 * j28, j28, this.f305961a, "", 0, a16, null);
            } else {
                QLog.w(f305974s, 1, "[UniformDL][" + this.f305966f + "].report failed - 11");
            }
            com.tencent.mobileqq.uniformdownload.util.d dVar3 = this.f305975o;
            if (dVar3 != null) {
                dVar3.c(5, "net broken", null);
            }
            return -2;
        }
        int status = getStatus();
        if (2 == status) {
            QLog.w(f305974s, 1, "[UniformDL][" + this.f305966f + "] start. is runing");
            return 0;
        }
        if (1 != status && 6 != status && 8 != status) {
            QLog.e(f305974s, 1, "[UniformDL][" + this.f305966f + "] start. before status is error:" + status);
            return -1;
        }
        long l06 = ah.l0(this.f305965e);
        long j29 = this.f305963c;
        if (l06 > j29) {
            g(0);
        } else {
            g((int) (l06 / j29));
        }
        if (cu.e()) {
            j3 = cu.b() * 1024;
        } else {
            j3 = 0;
        }
        if (j3 < this.f305963c - l06) {
            QLog.e(f305974s, 1, "[UniformDL][" + this.f305966f + "] start. sd card space is no enough:[" + this.f305963c + " " + l06 + " " + j3 + "]");
            m();
            i(5);
            if (k3 != null) {
                String a17 = f.a(9);
                BaseQQAppInterface baseQQAppInterface2 = (BaseQQAppInterface) k3;
                long j36 = 9;
                ah.A1(baseQQAppInterface2, this.f305966f, "actFileUfGenDownload", this.f305978r, "", "", "", "", j36, a17, 0L, l06, this.f305963c, this.f305961a, "", 0, a17, null);
                ah.A1(baseQQAppInterface2, this.f305966f, "actFileUfGenDownloadDetail", this.f305978r, "", "", "", "", j36, a17, 0L, l06, this.f305963c, this.f305961a, "", 0, a17, null);
            } else {
                QLog.w(f305974s, 1, "[UniformDL][" + this.f305966f + "].report failed - 5");
            }
            com.tencent.mobileqq.uniformdownload.util.d dVar4 = this.f305975o;
            if (dVar4 != null) {
                dVar4.c(9, "no space", null);
            }
            return -2;
        }
        synchronized (this) {
            o(l06);
        }
        QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] start. ST:" + status + " PGR:" + e());
        if (1 != status) {
            z16 = false;
        }
        i(2);
        if (z16 && (dVar = this.f305975o) != null) {
            dVar.g0(e(), null);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.uniformdownload.util.b
    public int stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (!f()) {
            QLog.e(f305974s, 1, "[UniformDL][" + this.f305966f + "] stop. not inited");
            return -1;
        }
        synchronized (this) {
            m();
        }
        int status = getStatus();
        QLog.i(f305974s, 1, "[UniformDL][" + this.f305966f + "] stop. ST:" + status + " PGR:" + e());
        h(0);
        i(7);
        return 0;
    }
}
