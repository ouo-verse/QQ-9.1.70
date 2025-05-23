package com.tencent.mobileqq.wxapi.impl;

import android.content.Intent;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a implements IWXAPIEventHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f327585h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile a f327586i;

    /* renamed from: d, reason: collision with root package name */
    private final IWXAPI f327587d;

    /* renamed from: e, reason: collision with root package name */
    private C9101a f327588e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicLong f327589f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wxapi.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C9101a implements IWXAuthApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f327590a;

        /* renamed from: b, reason: collision with root package name */
        final IWXAuthApi.a f327591b;

        public C9101a(String str, IWXAuthApi.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) aVar);
            } else {
                this.f327590a = str;
                this.f327591b = aVar;
            }
        }

        @Override // com.tencent.mobileqq.wxapi.IWXAuthApi.a
        public void a(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                return;
            }
            IWXAuthApi.a aVar = this.f327591b;
            if (aVar != null) {
                aVar.a(i3, str, str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45656);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f327585h = new byte[0];
            f327586i = null;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f327589f = new AtomicLong(0L);
        String b16 = b();
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(BaseApplication.getContext(), b16, true);
        this.f327587d = createWXAPI;
        createWXAPI.registerApp(b16);
    }

    public static a a() {
        if (f327586i == null) {
            synchronized (f327585h) {
                if (f327586i == null) {
                    f327586i = new a();
                }
            }
        }
        return f327586i;
    }

    private void c(SendAuth.Resp resp) {
        int i3 = resp.errCode;
        String str = resp.errStr;
        QLog.d("WXAuthComponent", 2, "handleWXAuthResp, errorCode = " + i3 + ", errorMsg = " + str);
        if (this.f327588e == null) {
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqlogin_wxauth_component_check_transaction_switch", true)) {
            QLog.i("WXAuthComponent", 1, "handleWXAuthResp transaction = " + resp.transaction);
            String str2 = this.f327588e.f327590a;
            if (str2 != null && !str2.isEmpty()) {
                if (!str2.equals(resp.transaction)) {
                    QLog.e("WXAuthComponent", 1, "handleWXAuthResp transaction is not match! [" + str2 + "/" + resp.transaction + "]");
                    return;
                }
            } else {
                QLog.e("WXAuthComponent", 1, "handleWXAuthResp error. reqTransaction is null or empty");
                return;
            }
        }
        this.f327588e.a(i3, str, resp.code);
        this.f327588e = null;
    }

    private boolean e() {
        if (!DeviceInfoMonitor.getModel().toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) && !Build.MANUFACTURER.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            return false;
        }
        return true;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "wxf14070172bb44e41";
    }

    public void d(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else {
            this.f327587d.handleIntent(intent, this);
        }
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f327587d.isWXAppInstalled();
    }

    public void g(IWXAuthApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        String str = "qqlogin_" + this.f327589f.incrementAndGet();
        QLog.i("WXAuthComponent", 1, "start getWxAuthCode. seq = " + str);
        this.f327588e = new C9101a(str, aVar);
        SendAuth.Req req = new SendAuth.Req();
        req.transaction = str;
        req.scope = "snsapi_userinfo";
        req.state = "qq_wx_login";
        if (e()) {
            QLog.d("WXAuthComponent", 1, "vivo system, use WXEntryActivityCompat.");
            SendAuth.Options options = new SendAuth.Options();
            options.callbackClassName = "com.tencent.mobileqq.wxapi.WXEntryActivityCompat";
            req.options = options;
        }
        this.f327587d.sendReq(req);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) baseReq);
        } else {
            QLog.d("WXAuthComponent", 1, "onReq.");
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) baseResp);
            return;
        }
        QLog.d("WXAuthComponent", 1, "onResp");
        if (baseResp instanceof SendAuth.Resp) {
            c((SendAuth.Resp) baseResp);
        }
    }
}
