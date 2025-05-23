package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class d implements IteApkInfoResp {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Cygnus f383314a;

    public d(Cygnus cygnus) {
        this.f383314a = cygnus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cygnus);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public long getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.f383314a.getErrorCode();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public String getFileMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f383314a.getFileMd5();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public String getFileName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f383314a.getFileName();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public String getFileSha1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f383314a.getFileSha1();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public String getHandleUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f383314a.getHandleUrl();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public String getPkgName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f383314a.getPkgName();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public int getRiskCategory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f383314a.getRiskCategory();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public String getRiskTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f383314a.getRiskTips();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public int getSafeLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f383314a.getSafeLevel();
    }

    @Override // com.tencent.turingfd.sdk.xq.IteApkInfoResp, com.tencent.turingfd.sdk.xq.Cygnus
    public boolean isSucceed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f383314a.isSucceed();
    }
}
