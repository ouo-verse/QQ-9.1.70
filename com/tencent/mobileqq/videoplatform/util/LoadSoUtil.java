package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.imp.LoadSoImp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LoadSoUtil {
    static IPatchRedirector $redirector_;
    private static ILoadSo sLoader;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sLoader = new LoadSoImp();
        }
    }

    public LoadSoUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isAllSoExist() {
        return sLoader.isAllSoExist();
    }

    public static boolean isCkeygeneratorV2Load() {
        return sLoader.isCkeygeneratorV2Load();
    }

    public static boolean isCkguardLoad() {
        return sLoader.isCkguardLoad();
    }

    public static boolean isDownProxyLoad() {
        return sLoader.isDownProxyLoad();
    }

    public static boolean isDownloadSoExist() {
        return sLoader.isDownloadSoExist();
    }

    public static boolean isTPCoreLoad() {
        return sLoader.isTPCoreLoad();
    }

    public static boolean isTpCoreSoExist() {
        return sLoader.isTpCoreSoExist();
    }

    public static void loadDownProxyAsync(LoadSoCallback loadSoCallback) {
        sLoader.loadDownProxyAsync(loadSoCallback);
    }

    public static boolean loadDownProxySync() {
        return sLoader.loadDownProxySync();
    }

    public static void loadSo(LoadSoCallback loadSoCallback) {
        sLoader.loadSo(loadSoCallback);
    }

    public static boolean loadTPCoreSync() {
        return sLoader.loadTPCoreSync();
    }

    public static void preloadSo() {
        sLoader.preloadSo();
    }

    public static void setLoadSoImp(ILoadSo iLoadSo) {
        sLoader = iLoadSo;
    }
}
