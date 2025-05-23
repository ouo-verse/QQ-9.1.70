package com.tencent.mobileqq.login.verify;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f242692a;

    /* renamed from: b, reason: collision with root package name */
    private final String f242693b;

    /* renamed from: c, reason: collision with root package name */
    private final Bundle f242694c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC7991b f242695d;

    /* renamed from: e, reason: collision with root package name */
    private final DevlockInfo f242696e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements ne1.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // ne1.a
        public void a(@NonNull GetLocalPhone$OIDBGetPhoneRsp getLocalPhone$OIDBGetPhoneRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) getLocalPhone$OIDBGetPhoneRsp);
                return;
            }
            String str = getLocalPhone$OIDBGetPhoneRsp.msg_auth_device_succed_data.get().str_auth_device_succceed_sig.get();
            if (str != null && !str.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putString("devlock_verify_sig", str);
                b.this.f(bundle, 0);
            } else {
                QLog.i("DevLockGatewayVerify", 1, "startVerifyByECDH onSuccess succeedSig is null");
                b.this.e("V_GET_TOKEN_ERROR", -1, "token is null");
            }
        }

        @Override // ne1.a
        public void onFail(int i3, @Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i("DevLockGatewayVerify", 1, "startVerifyByECDH onFail errorCode: " + i3 + " errorMsg: " + str);
            b.this.e("V_GET_TOKEN_ERROR", i3, str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.login.verify.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC7991b {
        void a(int i3, Bundle bundle);
    }

    public b(int i3, DevlockInfo devlockInfo, String str, Bundle bundle, InterfaceC7991b interfaceC7991b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), devlockInfo, str, bundle, interfaceC7991b);
            return;
        }
        this.f242692a = i3;
        this.f242696e = devlockInfo;
        this.f242693b = str;
        this.f242694c = bundle;
        this.f242695d = interfaceC7991b;
    }

    private AppRuntime c() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private Context d() {
        return c().getApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, int i3, String str2) {
        i.f(d(), c(), 3, this.f242693b);
        com.tencent.mobileqq.login.verify.a.a().b(c(), "0X800B661");
        g(str, i3, str2, 0);
        InterfaceC7991b interfaceC7991b = this.f242695d;
        if (interfaceC7991b != null) {
            interfaceC7991b.a(-1, null);
        }
        this.f242695d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Bundle bundle, int i3) {
        i.f(d(), c(), 4, this.f242693b);
        g("V_RET_SUCCESS", 0, "", i3);
        ILoginReporter iLoginReporter = (ILoginReporter) QRoute.api(ILoginReporter.class);
        ReportController.r(c(), "dc00898", "", iLoginReporter.getLoginUinForReport(), "0X800B662", "0X800B662", iLoginReporter.getLoginEntranceForReport(), 0, "", "", "", "");
        InterfaceC7991b interfaceC7991b = this.f242695d;
        if (interfaceC7991b != null) {
            interfaceC7991b.a(0, bundle);
        }
        this.f242695d = null;
    }

    private void g(String str, int i3, String str2, int i16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("K_RESULT_TYPE", str);
        hashMap.put("K_RET", String.valueOf(i3));
        hashMap.put("K_UIN", this.f242693b);
        hashMap.put("K_RESULT_MSG", str2);
        if ("V_RET_SUCCESS".equals(str)) {
            hashMap.put("K_REDIRECT_TIME", String.valueOf(i16));
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f242693b, "TGatewayVerifyResult", "V_RET_SUCCESS".equals(str), 0L, 0L, hashMap, "");
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.d("DevLockGatewayVerify", 1, "startVerifyByECDH");
        String str = URLUtil.getArgumentsFromURL(this.f242696e.OtherDevLockVerifyUrl).get(PreloadTRTCPlayerParams.KEY_SIG);
        String str2 = URLUtil.getArgumentsFromURL(this.f242696e.OtherDevLockVerifyUrl).get("uin");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle bundle = new Bundle();
            bundle.putInt(IPublicAccountBrowser.KEY_UIN_TYPE, 1);
            bundle.putString("uin", str2);
            bundle.putString("req_sig", str);
            com.tencent.mobileqq.gateway.localphone.ecdh.g.m(4, 13, new a(), bundle);
            return;
        }
        e("V_GET_GATEWAY_URL_ERROR", -1, "new device url error");
    }
}
