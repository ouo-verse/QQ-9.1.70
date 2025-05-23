package com.tencent.could.huiyansdk.api;

import android.content.Context;
import com.tencent.could.huiyansdk.callback.e;
import com.tencent.could.huiyansdk.entity.AuthUiConfig;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.entity.HuiYanSdkConfig;
import com.tencent.could.huiyansdk.entity.UpdateYtConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HuiYanSdk {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "HuiYanSdk";

    HuiYanSdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getVersion() {
        return "v1.0.9.31";
    }

    public static void init(Context context) {
        HuiYanSdkImp.getInstance().init(context);
    }

    public static void initNoLoadLibs(Context context) {
        HuiYanSdkImp.getInstance().initNoLoadLibs(context);
    }

    public static void release() {
        HuiYanSdkImp.getInstance().release();
    }

    public static void setAuthUiConfig(AuthUiConfig authUiConfig) {
        HuiYanSdkImp.getInstance().setAuthUiConfig(authUiConfig);
    }

    public static void setHuiYanSdkEventCallback(HuiYanSdkEventCallBack huiYanSdkEventCallBack) {
        HuiYanSdkImp.getInstance().setHuiYanSdkEventCallback(huiYanSdkEventCallBack);
    }

    public static void setHuiYanSdkExtraCallBack(HuiYanExtraCallBack huiYanExtraCallBack) {
        HuiYanSdkImp.getInstance().setExtraCallBack(huiYanExtraCallBack);
    }

    public static void setLoggerCallback(String str, e eVar) {
        HuiYanSdkImp.getInstance().setLoggerCallback(str, eVar);
    }

    public static void setTuringVideoParams(String str, String str2) {
        HuiYanSdkImp.getInstance().setTuringVideoParams(str, str2);
    }

    public static void showErrorDialog(int i3, String str) {
        HuiYanSdkImp.getInstance().showErrorDialog(i3, str);
    }

    public static void startHuiYanCheck(HuiYanSdkConfig huiYanSdkConfig, HuiYanSdkCallBack huiYanSdkCallBack) {
        HuiYanSdkImp.getInstance().startHuiYanCheck(huiYanSdkConfig, huiYanSdkCallBack);
    }

    public static void startNextStepByLight(String str) {
        HuiYanSdkImp.getInstance().startNextStepByLight(str);
    }

    public static void stopAuthAction(CompareResult compareResult) {
        HuiYanSdkImp.getInstance().stopAuthAction(compareResult);
    }

    public static void updateYtConfigFunction(UpdateYtConfig updateYtConfig) {
        HuiYanSdkImp.getInstance().updateYtConfigFunction(updateYtConfig);
    }
}
