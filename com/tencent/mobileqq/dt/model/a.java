package com.tencent.mobileqq.dt.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.AsyncFailInfo;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.n;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f203822a;

    /* renamed from: b, reason: collision with root package name */
    public static a f203823b;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f203824c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.dt.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C7489a implements OnLoadListener {
        static IPatchRedirector $redirector_;

        C7489a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            File file;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                return;
            }
            if (i3 == 0) {
                try {
                    QLog.d(a.f203822a, 1, loadExtResult.getRelatedFilesFolder());
                    String ver = loadExtResult.getVer();
                    if (TextUtils.isEmpty(ver)) {
                        QLog.e(a.f203822a, 1, "download so version is empty");
                        return;
                    }
                    QLog.i(a.f203822a, 1, "download so version is " + ver);
                    String soLoadPath = loadExtResult.getSoLoadPath();
                    if (!TextUtils.isEmpty(soLoadPath)) {
                        file = new File(soLoadPath);
                    } else {
                        file = null;
                    }
                    if (file == null || !file.exists()) {
                        file = new File(loadExtResult.getRelatedFilesFolder() + "/libfekit.so");
                        if (!file.exists()) {
                            QLog.e(a.f203822a, 1, "download suc but soFile not found");
                            return;
                        }
                    }
                    com.tencent.mobileqq.fe.e.b().m(ver);
                    com.tencent.mobileqq.fe.e.b().l(file.getAbsolutePath());
                    return;
                } catch (Throwable th5) {
                    QLog.e(a.f203822a, 1, "set so error:" + th5.getMessage());
                    return;
                }
            }
            AsyncFailInfo asyncFailInfo = loadExtResult.failInfo;
            if (asyncFailInfo != null) {
                str = asyncFailInfo.toString();
            } else {
                str = "";
            }
            QLog.e(a.f203822a, 1, "download error!,result:" + i3 + ",errmsg:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements com.tencent.rdelivery.reshub.api.h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f203826a;

        b(String str) {
            this.f203826a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
            }
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onComplete(boolean z16, @Nullable com.tencent.rdelivery.reshub.api.g gVar, @NonNull n nVar) {
            File file;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), gVar, nVar);
                return;
            }
            try {
                if (z16) {
                    String b16 = gVar.b();
                    String e16 = gVar.e();
                    long version = gVar.getVersion();
                    String description = gVar.getDescription();
                    String a16 = gVar.a();
                    String optString = new JSONObject(gVar.d()).optString("so_version");
                    if (!TextUtils.isEmpty(e16)) {
                        file = new File(e16);
                    } else {
                        file = null;
                    }
                    if (file != null && file.exists()) {
                        QLog.i(a.f203822a, 1, "url:" + b16 + ",so:" + e16 + ",version:" + version + ",desc:" + description + ",md5:" + a16 + ",so ver:" + optString);
                        com.tencent.mobileqq.fe.e.b().m(this.f203826a);
                        com.tencent.mobileqq.fe.e.b().l(file.getAbsolutePath());
                        return;
                    }
                    QLog.e(a.f203822a, 1, "download suc but soFile not found");
                    return;
                }
                QLog.e(a.f203822a, 1, "download error!,result:" + nVar.b() + ",errmsg:" + nVar.message());
            } catch (Throwable th5) {
                QLog.e(a.f203822a, 1, "res hub process error:" + th5.getMessage());
            }
        }

        @Override // com.tencent.rdelivery.reshub.api.h
        public void onProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26585);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f203822a = "FEKitMain_FESoManager";
            f203824c = new AtomicBoolean(false);
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a() {
        QLog.i(f203822a, 1, "start download use qqso!");
        ((ISoLoaderService) QRoute.api(ISoLoaderService.class)).download(com.tencent.mobileqq.fe.e.f205827f, new C7489a());
    }

    private void b(String str) {
        QLog.i(f203822a, 1, "start download use reshub!");
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance().p("fekitso", new b(str));
    }

    public static a c() {
        if (f203823b == null) {
            synchronized (a.class) {
                if (f203823b == null) {
                    f203823b = new a();
                }
            }
        }
        return f203823b;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            boolean z16 = false;
            if (!f203824c.compareAndSet(false, true)) {
                return;
            }
            String str = "0";
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (appInterface != null) {
                String currentAccountUin = appInterface.getCurrentAccountUin();
                if (!TextUtils.isEmpty(currentAccountUin)) {
                    boolean b16 = com.tencent.mobileqq.dt.app.a.c().d().b(currentAccountUin);
                    String k3 = com.tencent.mobileqq.dt.app.a.c().d().k();
                    boolean j3 = com.tencent.mobileqq.fe.e.b().j(k3);
                    QLog.d(f203822a, 1, "uc:" + b16 + ",v(" + k3 + "),cc:" + j3);
                    if (b16 && j3) {
                        z16 = true;
                    }
                    str = k3;
                } else {
                    QLog.e(f203822a, 1, "uin empty:" + currentAccountUin);
                }
            }
            if (z16) {
                if (com.tencent.mobileqq.dt.app.a.c().d().l()) {
                    b(str);
                    return;
                } else {
                    a();
                    return;
                }
            }
            com.tencent.mobileqq.fe.e.b().l("");
        } catch (Throwable th5) {
            QLog.e(f203822a, 1, "download crash:" + th5.getMessage());
        }
    }
}
