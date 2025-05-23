package com.tencent.could.huiyansdk.api;

import android.content.Context;
import com.tencent.could.huiyansdk.entity.AuthConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanAuth {
    static IPatchRedirector $redirector_;

    HuiYanAuth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getVersion() {
        return HuiYanAuthImp.getInstance().getVersion();
    }

    public static void init(Context context) {
        HuiYanAuthImp.getInstance().init(context);
    }

    public static void initNoLoadLibs(Context context) {
        HuiYanAuthImp.getInstance().initNoLoadLibs(context);
    }

    public static void release() {
        HuiYanAuthImp.getInstance().release();
    }

    public static void setAuthEventCallBack(HuiYanAuthEventCallBack huiYanAuthEventCallBack) {
        HuiYanAuthImp.getInstance().setAuthEventCallBack(huiYanAuthEventCallBack);
    }

    public static void setFaceIdTokenCreateFunction(CreateFaceIdToken createFaceIdToken) {
        HuiYanAuthImp.getInstance().setFaceIdTokenCreateFunction(createFaceIdToken);
    }

    public static void setHuiYanEventListener(HuiYanEventAuthCallback huiYanEventAuthCallback) {
        HuiYanAuthImp.getInstance().setHuiYanEventListener(huiYanEventAuthCallback);
    }

    public static void setHuiYanPublicEventCallBack(HuiYanPublicEventCallBack huiYanPublicEventCallBack) {
        HuiYanAuthImp.getInstance().setHuiYanPublicEventCallBack(huiYanPublicEventCallBack);
    }

    public static void startHuiYanAuth(AuthConfig authConfig, HuiYanAuthResultListener huiYanAuthResultListener) {
        HuiYanAuthImp.getInstance().startHuiYanAuth(authConfig, huiYanAuthResultListener);
    }
}
