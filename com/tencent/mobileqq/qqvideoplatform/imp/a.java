package com.tencent.mobileqq.qqvideoplatform.imp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements ILoadSo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    boolean f276409a;

    /* renamed from: b, reason: collision with root package name */
    boolean f276410b;

    public a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.f276409a = false;
            this.f276410b = z16;
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isAllSoExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).isAllSoExist(this.f276410b);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isCkeygeneratorV2Load() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f276409a;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isCkguardLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f276409a;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isDownProxyLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return VideoPlaySDKManager.getInstance().isSoLoadSuc();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isDownloadSoExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).isDownloadSoExist(this.f276410b);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isTPCoreLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return VideoPlaySDKManager.getInstance().isSoLoadSuc();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isTpCoreSoExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).isTpCoreSoExist(this.f276410b);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public void loadDownProxyAsync(LoadSoCallback loadSoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) loadSoCallback);
        } else {
            ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).loadDownProxyAsync(this.f276410b, loadSoCallback);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean loadDownProxySync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).loadDownProxySync(this.f276410b);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public void loadSo(LoadSoCallback loadSoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadSoCallback);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "initSDKAsync, loadSo begin.");
        }
        ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).loadSo(this.f276410b, loadSoCallback);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean loadTPCoreSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).loadTPCoreSync(this.f276410b);
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public void preloadSo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            ((IVideoSoLoader) QRoute.api(IVideoSoLoader.class)).preloadSo(this.f276410b);
        }
    }
}
