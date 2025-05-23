package com.tencent.qfsmonet.process.common;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.IMonetNativeExternalLoader;
import com.tencent.qfsmonet.utils.a;

/* compiled from: P */
@Keep
/* loaded from: classes22.dex */
public class MonetNativeLibraryLoader {
    static IPatchRedirector $redirector_ = null;
    private static final String LIB_MONET_CORE_MODULE_NAME = "monet";
    private static final int MAJOR_VERSION_LEN = 5;
    private static final String MONET_CORE_VERSION = "2.1.8.0000";
    private static final String MONET_DEFAULT_VERSION = "unknown";
    private static final String TAG = "MonetNativeLibraryLoader";
    private static boolean mIsLibLoaded;
    private static IMonetNativeExternalLoader mLibLoader;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26367);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mIsLibLoaded = false;
            mLibLoader = null;
        }
    }

    public MonetNativeLibraryLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized String getCoreVersion() {
        String monetCoreVersion;
        synchronized (MonetNativeLibraryLoader.class) {
            monetCoreVersion = getMonetCoreVersion();
        }
        return monetCoreVersion;
    }

    private static String getMonetCoreVersion() {
        try {
            String nativeMonetCoreVersion = getNativeMonetCoreVersion();
            a.c(TAG, "getMonetCoreVersion, version:" + nativeMonetCoreVersion);
            return nativeMonetCoreVersion;
        } catch (Throwable th5) {
            a.b(TAG, "getMonetCoreVersion, ex=" + th5.getMessage());
            return "unknown";
        }
    }

    @Keep
    private static native String getNativeMonetCoreVersion();

    private static boolean isMatchJavaAndMonetCore(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str.regionMatches(true, 0, str2, 0, 5);
        }
        return false;
    }

    private static boolean loadLib() {
        boolean loadLibDefault;
        a.c(TAG, "loadLib");
        if (mLibLoader != null) {
            a.c(TAG, "loadLib by loader!");
            loadLibDefault = mLibLoader.loadLib("monet", getMonetCoreVersion());
        } else {
            a.c(TAG, "loadLib by default!");
            loadLibDefault = loadLibDefault("monet");
        }
        if (loadLibDefault) {
            String monetCoreVersion = getMonetCoreVersion();
            boolean isMatchJavaAndMonetCore = isMatchJavaAndMonetCore(MONET_CORE_VERSION, monetCoreVersion);
            if (!isMatchJavaAndMonetCore) {
                a.c(TAG, "nativeMonetCoreVer(" + monetCoreVersion + ") doesn't match javaMonetCoreVer:(" + MONET_CORE_VERSION + ")");
            }
            return isMatchJavaAndMonetCore;
        }
        return loadLibDefault;
    }

    private static boolean loadLibDefault(String str) {
        boolean z16 = false;
        try {
            a.c(TAG, "loadLibDefault loading " + str);
            System.loadLibrary(str);
            z16 = true;
            a.c(TAG, "loadLibDefault " + str + " loaded successfully");
            return true;
        } catch (Throwable th5) {
            a.c(TAG, "loadLibDefault name=" + str + "failed," + th5.getMessage());
            return z16;
        }
    }

    public static synchronized void loadLibIfNeeded() throws UnsupportedOperationException {
        synchronized (MonetNativeLibraryLoader.class) {
            a.c(TAG, "loadLibIfNeeded");
            if (!mIsLibLoaded) {
                mIsLibLoaded = loadLib();
            }
            if (mIsLibLoaded) {
                a.c(TAG, "MonetNativeLibraryLoader load lib successfully");
            } else {
                a.b(TAG, "MonetNativeLibraryLoader load lib failed");
                throw new UnsupportedOperationException("Failed to load native library");
            }
        }
    }

    public static synchronized void setLibLoader(IMonetNativeExternalLoader iMonetNativeExternalLoader) {
        synchronized (MonetNativeLibraryLoader.class) {
            a.c(TAG, "setLibLoader");
            mLibLoader = iMonetNativeExternalLoader;
        }
    }
}
