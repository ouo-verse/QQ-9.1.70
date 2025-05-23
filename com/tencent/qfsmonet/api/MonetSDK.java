package com.tencent.qfsmonet.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.config.MonetConfig;
import com.tencent.qfsmonet.process.b;
import com.tencent.qfsmonet.process.common.MonetCommonParams;
import com.tencent.qfsmonet.process.common.MonetNativeLibraryLoader;
import com.tencent.qfsmonet.utils.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetSDK {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MonetSDK";
    private static volatile boolean mIsInit;

    public MonetSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addMonetConfig(String str, @NonNull MonetConfig monetConfig) {
        b.a(str, monetConfig);
    }

    @Nullable
    public static synchronized IMonetProxyFactory createMonetProxyFactory() {
        synchronized (MonetSDK.class) {
            if (!mIsInit) {
                return null;
            }
            return com.tencent.qfsmonet.proxy.b.a();
        }
    }

    public static synchronized boolean initSDK(@NonNull Context context) {
        synchronized (MonetSDK.class) {
            if (mIsInit) {
                return true;
            }
            try {
                MonetNativeLibraryLoader.loadLibIfNeeded();
                MonetCommonParams.saveApplicationContext(context);
                mIsInit = true;
            } catch (UnsupportedOperationException e16) {
                a.b(TAG, "init failed! ex=" + e16.toString());
            }
            return mIsInit;
        }
    }

    public static void setDebugEnable(boolean z16) {
        a.f(z16);
    }

    public static synchronized void setExternalLibLoader(@Nullable IMonetNativeExternalLoader iMonetNativeExternalLoader) throws IllegalStateException {
        synchronized (MonetSDK.class) {
            if (!mIsInit) {
                MonetNativeLibraryLoader.setLibLoader(iMonetNativeExternalLoader);
            } else {
                throw new IllegalStateException("player has init. need set before init.");
            }
        }
    }

    public static void setLogListener(@Nullable IMonetLogListener iMonetLogListener) {
        a.g(iMonetLogListener);
    }
}
