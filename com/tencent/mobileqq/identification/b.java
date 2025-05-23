package com.tencent.mobileqq.identification;

import android.os.Build;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f237934d;

    public b(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static b b() {
        if (f237934d == null) {
            synchronized (b.class) {
                if (f237934d == null) {
                    f237934d = new b("DeviceProtectQIPCModule");
                }
            }
        }
        return f237934d;
    }

    private EIPCResult c(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.e("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo error: QQAppInterface is null");
            return EIPCResult.createResult(-102, null);
        }
        Bundle bundle = new Bundle();
        try {
            BaseApplication context = BaseApplication.getContext();
            String buf_to_string = util.buf_to_string(com.tencent.mobileqq.guid.c.f213821a.c());
            String b16 = com.tencent.mobileqq.statistics.o.b();
            String c16 = com.tencent.mobileqq.statistics.o.c();
            String valueOf = String.valueOf(AppSetting.f());
            String str = Build.BRAND;
            String model = DeviceInfoMonitor.getModel();
            HwNetworkUtil.getSystemNetwork(context);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("guid:");
            sb5.append(buf_to_string);
            sb5.append("qimei:");
            sb5.append(b16);
            sb5.append("qimei36:");
            sb5.append(c16);
            sb5.append("subappid:");
            sb5.append(valueOf);
            sb5.append("platform:");
            sb5.append("Android");
            sb5.append("brand:");
            sb5.append(str);
            sb5.append("model:");
            sb5.append(model);
            sb5.append("bssid:");
            sb5.append("");
            QLog.d("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo info: " + ((Object) sb5));
            bundle.putString("guid", buf_to_string);
            bundle.putString(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, b16);
            bundle.putString("qimei36", c16);
            bundle.putString("subappid", valueOf);
            bundle.putString("platform", "Android");
            bundle.putString("brand", str);
            bundle.putString("model", model);
            bundle.putString("bssid", "");
            return EIPCResult.createResult(0, bundle);
        } catch (Exception e16) {
            QLog.e("DeviceProtectQIPCModule", 1, "handleGetDeviceInfo error: " + e16.getMessage());
            return EIPCResult.createResult(-102, null);
        }
    }

    private void d(AppRuntime appRuntime, int i3) {
        if (appRuntime == null) {
            QLog.e("DeviceProtectQIPCModule", 1, "handleGetGuidInfo error: QQAppInterface is null");
            callbackResult(i3, EIPCResult.createResult(-102, null));
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("guid", util.buf_to_string(com.tencent.mobileqq.guid.c.f213821a.c()));
            QLog.d("DeviceProtectQIPCModule", 1, "handleGetGuidInfo success");
            callbackResult(i3, EIPCResult.createResult(0, bundle));
        } catch (Exception e16) {
            QLog.e("DeviceProtectQIPCModule", 1, "handleGetGuidInfo error: " + e16.getMessage());
            callbackResult(i3, EIPCResult.createResult(-102, null));
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ("ACTION_GET_DEVICE_INFO".equals(str)) {
            return c(waitAppRuntime);
        }
        if ("ACTION_GET_GUID_INFO".equals(str)) {
            d(waitAppRuntime, i3);
        }
        return null;
    }
}
