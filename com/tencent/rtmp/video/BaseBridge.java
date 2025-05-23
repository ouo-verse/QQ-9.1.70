package com.tencent.rtmp.video;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BaseBridge {
    static IPatchRedirector $redirector_ = null;
    public static final String SCREEN_CAPTURE_SDK_VERSION = "12.3.0.41603";
    public static BaseBridgeCallback mBaseBridgeCallback;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface BaseBridgeCallback {
        Context getAppContext();

        int getSystemOSVersion();

        void printLog(String str, String str2);
    }

    public BaseBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Context getAppContext() {
        BaseBridgeCallback baseBridgeCallback = mBaseBridgeCallback;
        if (baseBridgeCallback != null) {
            return baseBridgeCallback.getAppContext();
        }
        return null;
    }

    public static int getSystemOSVersion() {
        BaseBridgeCallback baseBridgeCallback = mBaseBridgeCallback;
        if (baseBridgeCallback != null) {
            return baseBridgeCallback.getSystemOSVersion();
        }
        return Build.VERSION.SDK_INT;
    }

    public static void printLog(String str, String str2) {
        BaseBridgeCallback baseBridgeCallback = mBaseBridgeCallback;
        if (baseBridgeCallback != null) {
            baseBridgeCallback.printLog(str, str2);
        }
    }

    public static void setBaseBridgeCallback(BaseBridgeCallback baseBridgeCallback) {
        mBaseBridgeCallback = baseBridgeCallback;
    }
}
