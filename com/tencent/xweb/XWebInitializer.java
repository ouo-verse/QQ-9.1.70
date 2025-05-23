package com.tencent.xweb;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.c;
import com.tencent.luggage.wxa.tq.d;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class XWebInitializer {
    private static final String TAG = "XWebInitializer";
    private boolean mHasInited = false;
    private boolean mIsWebViewCoreReady;
    protected c webViewContextWrapper;
    protected d webViewCoreWrapper;

    public final boolean a() {
        n0.a(1749L, 67L, 1L);
        if (!XWalkEnvironment.hasAvailableVersion()) {
            if (XWalkEnvironment.getAvailableVersion() == -1) {
                x0.a(TAG, "init, no available version, need download");
            } else {
                x0.a(TAG, "init, sdk not support this apk, need update new");
            }
            n0.a(1749L, 69L, 1L);
            return false;
        }
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        boolean doInitWebViewCore = doInitWebViewCore(availableVersion);
        x0.a(TAG, "init, do init webview core result:" + doInitWebViewCore);
        if (doInitWebViewCore) {
            this.mIsWebViewCoreReady = true;
            postInitWebViewCore(availableVersion);
            n0.a(1749L, 70L, 1L);
            return true;
        }
        n0.a(1749L, 68L, 1L);
        return false;
    }

    public abstract boolean doInitWebViewCore(int i3);

    public c getWebViewContextWrapper() {
        return this.webViewContextWrapper;
    }

    public d getWebViewCoreWrapper() {
        return this.webViewCoreWrapper;
    }

    public void initWebViewCore() {
        if (this.mHasInited) {
            return;
        }
        this.mHasInited = true;
        x0.d(TAG, "initWebViewCore, start");
        if (a()) {
            x0.d(TAG, "initWebViewCore, success");
        } else {
            x0.f(TAG, "initWebViewCore, fail");
        }
    }

    public boolean isWebViewCoreReady() {
        if (!this.mHasInited) {
            return false;
        }
        return this.mIsWebViewCoreReady;
    }

    public abstract void postInitWebViewCore(int i3);

    public void setLocalStorageSuffix() {
        String processName = XWalkEnvironment.getProcessName();
        if (TextUtils.isEmpty(processName)) {
            processName = XWalkEnvironment.getApplicationContext().getPackageName();
        }
        String replace = processName.replace(":", ".");
        getWebViewCoreWrapper().invokeRuntimeChannel(90002, new Object[]{replace + "." + v0.b()});
    }
}
