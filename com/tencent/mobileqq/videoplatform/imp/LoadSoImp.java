package com.tencent.mobileqq.videoplatform.imp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LoadSoImp implements ILoadSo {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "[VideoPlatForm]LoadSoImp";
    boolean mCkeygeneratorV2;
    boolean mCkguard;
    boolean mDownProxyResult;
    boolean mTPCoreResult;

    public LoadSoImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTPCoreResult = false;
        this.mDownProxyResult = false;
        this.mCkguard = false;
        this.mCkeygeneratorV2 = false;
    }

    private boolean loadCkGenSo() {
        try {
            System.loadLibrary("ckeygeneratorV2");
            if (LogUtil.isColorLevel()) {
                LogUtil.d(TAG, 2, "loadCkGenSo success.");
            }
            this.mCkeygeneratorV2 = true;
            return true;
        } catch (Throwable th5) {
            LogUtil.e(TAG, 2, "loadCkGenSo err.", th5);
            return false;
        }
    }

    private boolean loadCkGuardSo() {
        try {
            System.loadLibrary("ckguard");
            if (LogUtil.isColorLevel()) {
                LogUtil.d(TAG, 2, "loadCkGuardSo success.");
            }
            this.mCkguard = true;
            return true;
        } catch (Throwable th5) {
            LogUtil.e(TAG, 2, "loadCkGuardSo err.", th5);
            return false;
        }
    }

    private boolean loadDownloadProxySo() {
        try {
            System.loadLibrary("DownloadProxy");
            if (LogUtil.isColorLevel()) {
                LogUtil.d(TAG, 2, "loadDownProxySync success.");
            }
            this.mDownProxyResult = true;
            return true;
        } catch (Throwable th5) {
            LogUtil.e(TAG, 2, "loadDownProxySync err.", th5);
            return false;
        }
    }

    private boolean loadTpCoreSo() {
        try {
            System.loadLibrary(ILoadSo.SONAME_TPCORE_MASTER);
            if (LogUtil.isColorLevel()) {
                LogUtil.d(TAG, 2, "loadTpCoreSo success.");
            }
            this.mTPCoreResult = true;
            return true;
        } catch (Throwable th5) {
            LogUtil.e(TAG, 2, "loadTpCoreSo err.", th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isAllSoExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isCkeygeneratorV2Load() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mCkeygeneratorV2;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isCkguardLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mCkguard;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isDownProxyLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mDownProxyResult;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isDownloadSoExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isTPCoreLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mTPCoreResult;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean isTpCoreSoExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public void loadDownProxyAsync(LoadSoCallback loadSoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) loadSoCallback);
            return;
        }
        loadDownloadProxySo();
        if (this.mDownProxyResult) {
            loadSoCallback.onLoad(true);
        } else {
            loadSoCallback.onLoad(false);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean loadDownProxySync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return loadDownloadProxySo();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public void loadSo(LoadSoCallback loadSoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadSoCallback);
            return;
        }
        loadTpCoreSo();
        loadDownloadProxySo();
        loadCkGuardSo();
        loadCkGenSo();
        if (this.mTPCoreResult && this.mDownProxyResult && this.mCkguard && this.mCkeygeneratorV2) {
            loadSoCallback.onLoad(true);
        } else {
            loadSoCallback.onLoad(false);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public boolean loadTPCoreSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return loadTpCoreSo();
    }

    @Override // com.tencent.mobileqq.videoplatform.api.ILoadSo
    public void preloadSo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }
}
