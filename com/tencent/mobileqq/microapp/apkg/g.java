package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f245854a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile g f245855b;

    /* renamed from: c, reason: collision with root package name */
    private String f245856c;

    /* renamed from: d, reason: collision with root package name */
    private String f245857d;

    /* renamed from: e, reason: collision with root package name */
    private String f245858e;

    /* renamed from: f, reason: collision with root package name */
    private String f245859f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void onInitApkgInfo$76ec3a73(int i3, com.tencent.mobileqq.microapp.a.c cVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9634);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f245854a = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/miniapp/";
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static g a() {
        if (f245855b == null) {
            synchronized (g.class) {
                if (f245855b == null) {
                    f245855b = new g();
                }
            }
        }
        return f245855b;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f245856c;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f245857d;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f245858e;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f245859f == null) {
            this.f245859f = com.tencent.mobileqq.microapp.a.c.a(BaseApplicationImpl.getApplication(), "qvip_pay_miniapp_page_frame.html");
        }
        return this.f245859f;
    }

    public static String a(ApkgConfig apkgConfig) {
        if (apkgConfig == null || TextUtils.isEmpty(apkgConfig.mini_appid)) {
            return "";
        }
        if (apkgConfig.getRuntimeType() == 1) {
            return f245854a + apkgConfig.mini_appid + "_debug" + MD5.toMD5(apkgConfig.qq_qr_code);
        }
        return f245854a + MD5.toMD5(apkgConfig.mini_appid) + "_" + apkgConfig.mini_version;
    }

    public void a(com.tencent.mobileqq.microapp.a.c cVar, String str, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, cVar, str, aVar);
            return;
        }
        String d16 = cVar.d(str);
        Map<String, String> map = cVar.f245825f.config.sub_apkg_urls;
        String str2 = map != null ? map.get(d16) : "";
        if (QLog.isColorLevel()) {
            QLog.d("ApkgManager", 1, "downloadSubPack | downPage=" + str + "subPackDownloadUrl=" + str2);
        }
        if (!TextUtils.isEmpty(str2)) {
            PreloadManagerProxy.getInstance(BaseApplicationImpl.getApplication().getRuntime()).getResPath(str2, new h(this, cVar, d16, aVar));
        } else {
            aVar.onInitApkgInfo$76ec3a73(1, null);
        }
    }
}
