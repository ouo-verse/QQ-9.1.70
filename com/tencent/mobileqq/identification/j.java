package com.tencent.mobileqq.identification;

import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.identification.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f237960c;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f237961d;

    /* renamed from: a, reason: collision with root package name */
    private final f f237962a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f237963b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements f.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f237964a;

        a(d dVar) {
            this.f237964a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.identification.f.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.e("HuiYanResLoader", 1, "[Models] download models fail");
            d dVar = this.f237964a;
            if (dVar != null) {
                dVar.a(-1);
            }
        }

        @Override // com.tencent.mobileqq.identification.f.b
        public void onDownloadSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.i("HuiYanResLoader", 1, "[Models] download models success");
            try {
                if (j.this.q()) {
                    QLog.i("HuiYanResLoader", 1, "[Models] models is exist\uff0cdon't need to uncompress");
                    d dVar = this.f237964a;
                    if (dVar != null) {
                        dVar.a(0);
                        return;
                    }
                    return;
                }
                try {
                    FileUtils.uncompressZip(str, j.l(), false);
                    try {
                        new File(str).delete();
                    } catch (Exception e16) {
                        QLog.e("HuiYanResLoader", 1, "delete download file fail ", e16);
                    }
                    if (!j.this.q()) {
                        QLog.e("HuiYanResLoader", 1, "[Models] download and uncompress success\uff0cbut models is invalid");
                        d dVar2 = this.f237964a;
                        if (dVar2 != null) {
                            dVar2.a(-4);
                            return;
                        }
                        return;
                    }
                    QLog.i("HuiYanResLoader", 1, "[Models] load models success");
                    d dVar3 = this.f237964a;
                    if (dVar3 != null) {
                        dVar3.a(0);
                    }
                } catch (IOException e17) {
                    QLog.e("HuiYanResLoader", 1, "[Models] uncompress models fail ", e17);
                    j.this.h();
                    d dVar4 = this.f237964a;
                    if (dVar4 != null) {
                        dVar4.a(-2);
                    }
                    try {
                        new File(str).delete();
                    } catch (Exception e18) {
                        QLog.e("HuiYanResLoader", 1, "delete download file fail ", e18);
                    }
                }
            } catch (Throwable th5) {
                try {
                    new File(str).delete();
                } catch (Exception e19) {
                    QLog.e("HuiYanResLoader", 1, "delete download file fail ", e19);
                }
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements f.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f237966a;

        b(d dVar) {
            this.f237966a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.identification.f.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.e("HuiYanResLoader", 1, "download so fail");
            d dVar = this.f237966a;
            if (dVar != null) {
                dVar.a(-1);
            }
        }

        @Override // com.tencent.mobileqq.identification.f.b
        public void onDownloadSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.i("HuiYanResLoader", 1, "[SO] download so success");
            try {
                if (j.this.r()) {
                    QLog.i("HuiYanResLoader", 1, "[SO] so is exist\uff0cdon't need to uncompress");
                    d dVar = this.f237966a;
                    if (dVar != null) {
                        dVar.a(0);
                        return;
                    }
                    return;
                }
                try {
                    FileUtils.uncompressZip(str, j.l(), false);
                    try {
                        new File(str).delete();
                    } catch (Exception e16) {
                        QLog.e("HuiYanResLoader", 1, "delete download file fail ", e16);
                    }
                    if (j.this.r()) {
                        j.this.w();
                        d dVar2 = this.f237966a;
                        if (dVar2 != null) {
                            dVar2.a(0);
                            return;
                        }
                        return;
                    }
                    QLog.e("HuiYanResLoader", 1, "[SO] download and uncompress success, but check so fail");
                    j.this.i();
                    d dVar3 = this.f237966a;
                    if (dVar3 != null) {
                        dVar3.a(-4);
                    }
                } catch (IOException e17) {
                    QLog.e("HuiYanResLoader", 1, "[SO] uncompress so fail ", e17);
                    d dVar4 = this.f237966a;
                    if (dVar4 != null) {
                        dVar4.a(-2);
                    }
                    try {
                        new File(str).delete();
                    } catch (Exception e18) {
                        QLog.e("HuiYanResLoader", 1, "delete download file fail ", e18);
                    }
                }
            } catch (Throwable th5) {
                try {
                    new File(str).delete();
                } catch (Exception e19) {
                    QLog.e("HuiYanResLoader", 1, "delete download file fail ", e19);
                }
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final j f237968a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20744);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f237968a = new j();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface e {
        void a(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f237960c = new String[]{"libYTCommonLiveness.so", "libYTLiveness.so"};
            f237961d = new String[]{"aa2179394e25091af5a6d0577edb68af", "33f728f17dac185a07fc4d193260dc33"};
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f237963b = false;
            this.f237962a = new f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            String p16 = p();
            FileUtils.deleteDirectory(p16);
            if (QLog.isColorLevel()) {
                QLog.d("HuiYanResLoader", 2, "[SO] delete so dir " + p16);
            }
        } catch (Exception e16) {
            QLog.e("HuiYanResLoader", 1, "delete so exception ", e16);
        }
    }

    public static String l() {
        File file = new File(BaseApplication.getContext().getFilesDir() + "/qqidentification/huiyan");
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static j m() {
        return c.f237968a;
    }

    private String n() {
        return l() + File.separator + IQQGameCommApi.K_ABTEST_MODELS;
    }

    private String p() {
        return l() + File.separator + "huiyan_so";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        String n3 = n();
        File file = new File(n3);
        boolean z16 = false;
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list != null && list.length != 0) {
                int length = list.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if ("face-tracker-v003".equalsIgnoreCase(list[i3])) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
                if (!z16) {
                    QLog.i("HuiYanResLoader", 1, "[Models] keyFile is not exist face-tracker-v003");
                }
                return z16;
            }
            QLog.i("HuiYanResLoader", 1, "[Models] models file is empty");
            return false;
        }
        QLog.i("HuiYanResLoader", 1, "[Models] models dir is not exist or not directory, " + n3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        File file = new File(p());
        if (file.exists() && file.isDirectory()) {
            int i3 = 0;
            while (true) {
                String[] strArr = f237960c;
                if (i3 >= strArr.length) {
                    return true;
                }
                String str = strArr[i3];
                String str2 = f237961d[i3];
                File file2 = new File(file, str);
                if (!file2.exists()) {
                    QLog.w("HuiYanResLoader", 1, "[SO] so file is not exist, filename=" + str);
                    return false;
                }
                if (!f.b(file2.getAbsolutePath(), str2)) {
                    QLog.w("HuiYanResLoader", 1, "[SO] so file md5 is invalid, filename=" + str + ", md5=" + str2);
                    return false;
                }
                i3++;
            }
        } else {
            QLog.i("HuiYanResLoader", 1, "[SO] so dir is not exist or not directory, " + file.getAbsolutePath());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(d dVar) {
        QLog.i("HuiYanResLoader", 1, "[Modes] start load models");
        n();
        if (q()) {
            QLog.i("HuiYanResLoader", 1, "[Models] models is exist");
            if (dVar != null) {
                dVar.a(0);
                return;
            }
            return;
        }
        h();
        QLog.i("HuiYanResLoader", 1, "[Modes] start download models");
        this.f237962a.f("https://static-res.qq.com/static-res/faceIdentify/huiyan_models_20250120.zip", "fc169421e0b9128bb103358bba3e8943", new a(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(d dVar) {
        QLog.i("HuiYanResLoader", 1, "[SO] start load so");
        if (r()) {
            QLog.i("HuiYanResLoader", 1, "[SO] so is exist, don't need to download");
            if (dVar != null) {
                dVar.a(0);
                return;
            }
            return;
        }
        i();
        QLog.i("HuiYanResLoader", 1, "[SO] start download so");
        this.f237962a.f("https://static-res.qq.com/static-res/faceIdentify/huiyan_so_64_20250120.zip", "039480f2dfa724c50b701c6c5ffcb53a", new b(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(e eVar) {
        int i3 = 0;
        if (this.f237963b) {
            QLog.i("HuiYanResLoader", 1, "[SO] loadSoLibrary repeat");
            if (eVar != null) {
                eVar.a(0);
                return;
            }
            return;
        }
        if (!r()) {
            QLog.i("HuiYanResLoader", 1, "[SO] loadSoLibrary fail, is not exist");
            if (eVar != null) {
                eVar.a(-3);
                return;
            }
            return;
        }
        File file = new File(p());
        boolean z16 = true;
        for (String str : f237960c) {
            try {
                String str2 = file + File.separator + str;
                QLog.i("HuiYanResLoader", 1, "[SO] try to load so library " + str);
                System.load(str2);
            } catch (Throwable th5) {
                QLog.e("HuiYanResLoader", 1, "[SO] load so library error ", th5);
                z16 = false;
            }
        }
        QLog.i("HuiYanResLoader", 1, "[SO] loadSoLibrary success = " + z16);
        if (!z16) {
            i();
        } else {
            this.f237963b = true;
        }
        if (eVar != null) {
            if (!z16) {
                i3 = -3;
            }
            eVar.a(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        QLog.i("HuiYanResLoader", 2, "registerSoFile");
        File file = new File(p());
        for (String str : f237960c) {
            try {
                ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(BaseApplication.getContext(), file + File.separator + str);
            } catch (Exception e16) {
                QLog.e("HuiYanResLoader", 1, "registerSoFile error ", e16);
            }
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            String n3 = n();
            FileUtils.deleteDirectory(n3);
            if (QLog.isColorLevel()) {
                QLog.d("HuiYanResLoader", 2, "[Models] delete models dir " + n3);
            }
        } catch (Exception e16) {
            QLog.e("HuiYanResLoader", 1, "delete models exception ", e16);
        }
    }

    public void j(final d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.identification.g
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.s(dVar);
                }
            }, 64, null, false);
        }
    }

    public void k(final d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.identification.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.t(dVar);
                }
            }, 64, null, false);
        }
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return n() + File.separator + "face-tracker-v003";
    }

    public void v(final e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.identification.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.u(eVar);
                }
            }, 16, null, false);
        }
    }
}
