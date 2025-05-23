package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import c25.b;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.api.IVasFragment;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ZipDownloadBusiness;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.PermissionUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class KCWraperV2 extends l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public AtomicBoolean f312740a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class a implements b.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // c25.b.a
        public void a(c25.f fVar) {
            String account;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("KC.KCWraperV2", 1, "state changed");
            }
            AppRuntime app = VasUtil.getApp();
            if (app == null) {
                account = null;
            } else {
                account = app.getAccount();
            }
            if (!TextUtils.isEmpty(account) && fVar != null) {
                l.j(account, fVar);
            }
        }

        @Override // c25.b.a
        public void b(c25.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
            }
        }
    }

    public KCWraperV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f312740a = new AtomicBoolean(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(c25.f fVar) {
        String str;
        String account;
        boolean z16;
        if (fVar != null) {
            str = fVar.toString();
        } else {
            str = "result == null";
        }
        g(str);
        if (fVar == null) {
            return;
        }
        AppInterface appInterface = VasUtil.getAppInterface();
        if (appInterface == null) {
            account = null;
        } else {
            account = appInterface.getAccount();
        }
        int i3 = 1;
        if (!TextUtils.isEmpty(account)) {
            boolean j3 = l.j(account, fVar);
            String str2 = fVar.f30244c;
            if (fVar.f30245d == 1) {
                IVasDepTemp iVasDepTemp = (IVasDepTemp) QRoute.api(IVasDepTemp.class);
                if (fVar.f30242a == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                iVasDepTemp.guanjiaReport(account, str2, z16, fVar.f30243b, "");
                IVasDepTemp iVasDepTemp2 = (IVasDepTemp) QRoute.api(IVasDepTemp.class);
                long parseLong = Long.parseLong(account);
                if (fVar.f30242a != 1) {
                    i3 = 0;
                }
                iVasDepTemp2.reportKCLP(parseLong, i3);
            }
            if (j3) {
                ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).sendGetBaseVipInfoReq(VasSkey.getSkey((TicketManager) VasUtil.getAppInterface().getManager(2), account), account);
                return;
            }
            return;
        }
        QLog.e("KC.TMSManager", 1, "tmsQuery can't get uin");
    }

    private void q(Context context, File file) {
        ThreadManagerV2.post(new Runnable(file, context) { // from class: com.tencent.mobileqq.vip.KCWraperV2.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ File f312741d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f312742e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.vip.KCWraperV2$1$a */
            /* loaded from: classes20.dex */
            class a implements c25.c {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // c25.c
                public void print(String str) {
                    String str2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                        return;
                    }
                    String m3 = KCWraperV2.this.m();
                    if (str == null) {
                        str2 = "\n";
                    } else {
                        str2 = str;
                    }
                    QLog.e(m3, 1, str2);
                    if (!TextUtils.isEmpty(str) && str.contains("checkLisence failed")) {
                        QLog.e("KC.KCWraperV2", 1, " \u738b\u5361\u521d\u59cb\u5316\u5f02\u5e38\uff01\uff01\u7b7e\u540d\u6587\u4ef6\u6821\u9a8c\u5931\u8d25\uff01\uff01");
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.vip.KCWraperV2$1$b */
            /* loaded from: classes20.dex */
            class b implements c25.e {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // c25.e
                public Object a(String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                    }
                    if ("model".equals(str)) {
                        return ah.F();
                    }
                    if ("manufacturer".equals(str)) {
                        return ah.C();
                    }
                    if ("build_version".equals(str)) {
                        return Integer.toString(Build.VERSION.SDK_INT);
                    }
                    return "";
                }

                @Override // c25.e
                public void b(int i3, String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                    }
                }
            }

            {
                this.f312741d = file;
                this.f312742e = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, KCWraperV2.this, file, context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                long cRC32Value = IOUtil.getCRC32Value(this.f312741d);
                QLog.d(KCWraperV2.this.m(), 1, "tryLoad " + this.f312741d.getName() + " crc32: " + Long.toHexString(cRC32Value));
                QLog.flushLog();
                synchronized (KCWraperV2.this.f312740a) {
                    if (KCWraperV2.this.f312740a.get()) {
                        return;
                    }
                    b25.a h16 = b25.a.h();
                    if (QLog.isColorLevel()) {
                        h16.o(new a());
                    }
                    h16.n(QLog.isColorLevel());
                    if (TMSManager.i()) {
                        boolean isHasPhonePermission = PermissionUtil.isHasPhonePermission(this.f312742e);
                        File file2 = new File(this.f312742e.getFilesDir(), "kingcard/kcsdk.jar");
                        if (file2.exists() && IOUtil.getCRC32Value(file2) == cRC32Value && file2.length() == this.f312741d.length()) {
                            QLog.i("KC.KCWraperV2", 1, " crc32\u4e00\u81f4\uff0c\u65e0\u9700\u590d\u5236");
                        } else {
                            QLog.i("KC.KCWraperV2", 1, " \u590d\u5236jar");
                            FileUtils.deleteFile(file2.getParentFile());
                            if (!FileUtils.copyFile(this.f312741d, file2)) {
                                QLog.i("KC.KCWraperV2", 1, " \u5931\u8d25");
                            }
                        }
                        z16 = h16.k(this.f312742e, isHasPhonePermission, file2.getAbsolutePath(), new b());
                        QLog.e(KCWraperV2.this.m(), 1, "initInBaseProcess");
                        if (h16.j(this.f312742e) != null) {
                            h16.j(this.f312742e).b(new a());
                        }
                    } else {
                        QLog.w(KCWraperV2.this.m(), 1, "only load in main process!");
                        z16 = false;
                    }
                    if (!z16) {
                        QLog.e(KCWraperV2.this.m(), 1, "tryLoad failed");
                        l.k(false);
                    } else {
                        KCWraperV2.this.f312740a.set(true);
                        l.k(true);
                    }
                    KCWraperV2.this.f312740a.notify();
                }
            }
        }, 5, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public void a(ViewGroup viewGroup) {
        c25.b j3 = b25.a.h().j(BaseApplication.getContext());
        if (j3 != null) {
            c25.a a16 = j3.a(viewGroup.getContext());
            if (a16 != null) {
                viewGroup.addView(a16.getWebView());
                a16.a();
                return;
            }
            QLog.e("KC.TMSManager", 1, "activationViewer == null");
        }
        QLog.e("KC.TMSManager", 1, "kingCardInterface == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public boolean f() {
        if (this.f312740a.get()) {
            return true;
        }
        if (!((ZipDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ZipDownloadBusiness.class)).getKingCardJarPath().exists()) {
            return false;
        }
        synchronized (this.f312740a) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.e(m(), 1, "wait load");
                }
                this.f312740a.wait(500L);
                if (QLog.isColorLevel()) {
                    QLog.e(m(), 1, "wait end");
                }
            } catch (InterruptedException e16) {
                e16.printStackTrace();
                QLog.e(m(), 1, e16, new Object[0]);
            }
        }
        return this.f312740a.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public boolean h(Activity activity) {
        ((IVasFragment) QRoute.api(IVasFragment.class)).startKingCard(activity);
        return true;
    }

    @Override // com.tencent.mobileqq.vip.l
    public void i(TMSManager.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aVar, Boolean.valueOf(z16));
        } else {
            ThreadManagerV2.post(new Runnable(aVar, z16) { // from class: com.tencent.mobileqq.vip.KCWraperV2.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TMSManager.a f312745d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f312746e;

                {
                    this.f312745d = aVar;
                    this.f312746e = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, KCWraperV2.this, aVar, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    c25.b j3 = b25.a.h().j(BaseApplication.getContext());
                    boolean z17 = false;
                    if (j3 == null) {
                        KCWraperV2.this.g("no KingCardInterface");
                        i3 = 0;
                    } else {
                        c25.f result = j3.getResult();
                        if (result.f30242a > 0) {
                            z17 = true;
                        }
                        i3 = result.f30243b;
                        KCWraperV2.this.p(result);
                    }
                    TMSManager.a aVar2 = this.f312745d;
                    if (aVar2 != null) {
                        if (this.f312746e) {
                            ThreadManager.getUIHandler().post(new Runnable(z17, i3) { // from class: com.tencent.mobileqq.vip.KCWraperV2.2.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ boolean f312747d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ int f312748e;

                                {
                                    this.f312747d = z17;
                                    this.f312748e = i3;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, this, AnonymousClass2.this, Boolean.valueOf(z17), Integer.valueOf(i3));
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    } else {
                                        AnonymousClass2.this.f312745d.a(true, this.f312747d, this.f312748e);
                                    }
                                }
                            });
                        } else {
                            aVar2.a(true, z17, i3);
                        }
                    }
                }
            }, 5, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public boolean l() {
        if (QLog.isColorLevel()) {
            QLog.e("KC.TMSManager", 1, "supportActivationView == true");
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vip.l
    String m() {
        return "KC.KCWraperV2";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public void n(Runnable runnable) {
        g("load jar");
        if (this.f312740a.get()) {
            return;
        }
        Context applicationContext = VasUtil.getApp().getApplicationContext();
        File kingCardJarPath = ((ZipDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ZipDownloadBusiness.class)).getKingCardJarPath();
        if (!kingCardJarPath.exists()) {
            if (runnable != null) {
                runnable.run();
            }
            l.k(false);
            return;
        }
        q(applicationContext, kingCardJarPath);
    }
}
