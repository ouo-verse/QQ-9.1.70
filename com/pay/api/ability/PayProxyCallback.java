package com.pay.api.ability;

import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.plugin.APPluginInterfaceManager;

/* loaded from: classes2.dex */
public class PayProxyCallback {
    public static void handleCallback(int i3, String str, String str2) {
        APLog.d("ProxyPayCallback", "resultCode=" + i3 + ",resultInnerCode=" + str + ",resultMsg=" + str2);
        try {
            APPluginInterfaceManager.initPluginInterface(APMidasPayHelper.staticActivityContext, APMidasPayHelper.MIDAS_PLUGIN_NAME, "com.pay.api.ability.PayCallbackImpl", "handleCallback", new Object[]{Integer.valueOf(i3), str, str2});
        } catch (Exception e16) {
            APLog.e("PayProxyCallback", "handleIntent got exception = " + e16.toString());
            e16.printStackTrace();
        }
    }
}
