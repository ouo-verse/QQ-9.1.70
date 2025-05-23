package com.tencent.ams.fusion.service.splash.a;

import com.tencent.ams.fusion.service.a.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f70309a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55589);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            f70309a = null;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a d() {
        if (f70309a == null) {
            synchronized (a.class) {
                if (f70309a == null) {
                    f70309a = new a();
                }
            }
        }
        return f70309a;
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 != null && j3.a(a.C0673a.a("openSplashRealTimeSelectOrderTask", b.f70314e)) == 1) {
            return true;
        }
        return false;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 != null && j3.a(a.C0673a.a("ignoreSplashEffectTimes", b.f70311b)) == 1) {
            return true;
        }
        return false;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 != null && j3.a(a.C0673a.a("ignoreSplashResource", b.f70310a)) == 1) {
            return true;
        }
        return false;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null || j3.a(a.C0673a.a("isUseNewImgVideoDownloadLogic", 0)) != 1) {
            return false;
        }
        return true;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 != null && j3.a(a.C0673a.a("enableDownloadNonessentialSrc", 1)) == 1) {
            return true;
        }
        return false;
    }

    public int c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, i3)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 != null) {
            return j3.a(a.C0673a.a("singleTaskTimeout", i3));
        }
        return i3;
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        if (com.tencent.ams.fusion.service.b.b().j() == null) {
            return 3000L;
        }
        return r0.a(a.C0673a.a("maxSelectOrderTimeout", 3000));
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return Integer.MAX_VALUE;
        }
        return j3.a(a.C0673a.a("realTimeSelectOrderTaskTimeout", Integer.MAX_VALUE));
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return Integer.MAX_VALUE;
        }
        return j3.a(a.C0673a.a("firstPlaySelectOrderTaskTimeout", Integer.MAX_VALUE));
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 1;
        }
        return j3.a(a.C0673a.a("splashRealTimeSelectContinue", 1));
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 0;
        }
        return j3.a(a.C0673a.a("shouldDownloadVideoSrcInRealtime", 0));
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return "https://p.l.qq.com/p?";
        }
        return j3.b(a.C0673a.b("emptyOrderExposureUrl", "https://p.l.qq.com/p?"));
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 0;
        }
        return j3.a(a.C0673a.a("emptyOrderExposurePvType", 0));
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 1;
        }
        return j3.a(a.C0673a.a("splashLocalSelect", 1));
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 1;
        }
        return j3.a(a.C0673a.a("splashSpaSelect", 1));
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 2;
        }
        return j3.a(a.C0673a.a("maxParallelSourceDownload", 2));
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 1;
        }
        return j3.a(a.C0673a.a("splashPreloadRetryTimes", 1));
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 1;
        }
        return j3.a(a.C0673a.a("splashPreloadMaterialDownloadRetryTimes", 1));
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 604800000;
        }
        return j3.a(a.C0673a.a("splashDirExpiredDays", 7)) * 86400000;
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 104857600;
        }
        return j3.a(a.C0673a.a("splashDirCleanupThreshold", 100)) * 1048576;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null || j3.a(a.C0673a.a("openSplashPreload", b.f70313d)) == 1) {
            return true;
        }
        return false;
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null || j3.a(a.C0673a.a("openSplashSerializeDataTask", 0)) != 1) {
            return false;
        }
        return true;
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 != null && j3.a(a.C0673a.a("openFusionResDownloadAndClean", b.f70312c)) == 1) {
            return true;
        }
        return false;
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 0;
        }
        return j3.a(a.C0673a.a("splashPreloadTimeGap", 0));
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null) {
            return 0;
        }
        return j3.a(a.C0673a.a("splashPreloadRequestDelayTime", 0));
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 != null && j3.a(a.C0673a.a("splashLocalSelectAfterRealTimeTimeout", 1)) == 2) {
            return true;
        }
        return false;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 != null && j3.a(a.C0673a.a("splashRealTimeSelectCheckSrc", 1)) == 2) {
            return true;
        }
        return false;
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        com.tencent.ams.fusion.service.a.a j3 = com.tencent.ams.fusion.service.b.b().j();
        if (j3 == null || j3.a(a.C0673a.a("openSplashDynamic", 0)) != 1) {
            return false;
        }
        return true;
    }
}
