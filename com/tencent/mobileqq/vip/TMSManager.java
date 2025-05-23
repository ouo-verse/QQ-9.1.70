package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ZipDownloadBusiness;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TMSManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static int f312756b;

    /* renamed from: c, reason: collision with root package name */
    public static int f312757c;

    /* renamed from: d, reason: collision with root package name */
    public static int f312758d;

    /* renamed from: e, reason: collision with root package name */
    protected static final String[] f312759e;

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f312760f;

    /* renamed from: a, reason: collision with root package name */
    private l f312761a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(boolean z16, boolean z17, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final TMSManager f312764a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48217);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f312764a = new TMSManager();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48221);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f312756b = 1;
        f312757c = 0;
        f312758d = 2;
        f312759e = new String[]{"tmsdualcore", "tmsdualcore785", "tmsdualcore790", "tmsdualcore7901"};
        f312760f = new AtomicBoolean(false);
    }

    public TMSManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f312761a = null;
        }
    }

    public static TMSManager e() {
        if (b.f312764a.f312761a == null) {
            synchronized (b.f312764a) {
                if (b.f312764a.f312761a == null) {
                    b.f312764a.f();
                }
            }
        }
        g();
        return b.f312764a;
    }

    private void f() {
        if (i()) {
            this.f312761a = new KCWraperV2();
        } else if (l.e()) {
            this.f312761a = new KCWraperV2InOtherProcess();
        }
        if (this.f312761a != null) {
            m();
        }
    }

    private static void g() {
        try {
            if (!f312760f.get()) {
                y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vip.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        TMSManager.j();
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("KC.TMSManager", 1, "treasureCard,init:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean i() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j() {
        VasUtil.getService().getVasFtManager().init();
        f312760f.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        l lVar = this.f312761a;
        if (lVar != null) {
            lVar.n(new Runnable() { // from class: com.tencent.mobileqq.vip.TMSManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMSManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("KC.TMSManager", 2, "no file and requestDownloadDepends");
                    }
                    ZipDownloadBusiness zipDownloadBusiness = (ZipDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ZipDownloadBusiness.class);
                    zipDownloadBusiness.addDownLoadListener(16, new Runnable() { // from class: com.tencent.mobileqq.vip.TMSManager.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                TMSManager.e().m();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    zipDownloadBusiness.startDownload(16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ViewGroup viewGroup) {
        l lVar = this.f312761a;
        if (lVar != null && lVar.f()) {
            this.f312761a.a(viewGroup);
        }
    }

    public synchronized boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        l lVar = this.f312761a;
        if (lVar != null && lVar.f()) {
            return true;
        }
        return false;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (e.a() > 0) {
            return true;
        }
        return false;
    }

    public boolean k(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity)).booleanValue();
        }
        l lVar = this.f312761a;
        if (lVar != null && lVar.f()) {
            return this.f312761a.h(activity);
        }
        return false;
    }

    public void l(a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, aVar, Boolean.valueOf(z16));
            return;
        }
        l lVar = this.f312761a;
        if (lVar != null && lVar.f()) {
            this.f312761a.i(aVar, z16);
        } else if (aVar != null) {
            if (z16) {
                ThreadManager.getUIHandler().post(new Runnable(aVar) { // from class: com.tencent.mobileqq.vip.TMSManager.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ a f312762d;

                    {
                        this.f312762d = aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TMSManager.this, (Object) aVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f312762d.a(false, false, 0);
                        }
                    }
                });
            } else {
                aVar.a(false, false, 0);
            }
        }
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        l lVar = this.f312761a;
        if (lVar != null && lVar.f()) {
            return this.f312761a.l();
        }
        return false;
    }
}
