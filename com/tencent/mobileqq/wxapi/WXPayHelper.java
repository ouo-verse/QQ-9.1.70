package com.tencent.mobileqq.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* loaded from: classes21.dex */
public class WXPayHelper implements IWXAPIEventHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f327448h;

    /* renamed from: i, reason: collision with root package name */
    private static WXPayHelper f327449i;

    /* renamed from: d, reason: collision with root package name */
    private final String f327450d;

    /* renamed from: e, reason: collision with root package name */
    private final IWXAPI f327451e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<Handler> f327452f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f327448h = new byte[0];
            f327449i = null;
        }
    }

    WXPayHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f327452f = new ArrayList<>(1);
        this.f327450d = "wxf0a80d0ac2e82aa7";
        this.f327451e = WXAPIFactory.createWXAPI(BaseApplication.getContext(), "wxf0a80d0ac2e82aa7", true);
    }

    public static WXPayHelper getInstance() {
        if (f327449i == null) {
            synchronized (f327448h) {
                if (f327449i == null) {
                    f327449i = new WXPayHelper();
                }
            }
        }
        return f327449i;
    }

    public void addObserver(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) handler);
            return;
        }
        synchronized (this.f327452f) {
            if (!this.f327452f.contains(handler)) {
                this.f327452f.add(handler);
            }
        }
    }

    public int getWXAppSupportAPI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f327451e.getWXAppSupportAPI();
    }

    public void handleIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
        } else {
            this.f327451e.handleIntent(intent, this);
        }
    }

    public boolean isWXinstalled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f327451e.isWXAppInstalled();
    }

    public boolean isWXsupportApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f327451e.getWXAppSupportAPI() >= 553779201) {
            return true;
        }
        return false;
    }

    public boolean isWXsupportPayApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.f327451e.getWXAppSupportAPI() >= 570425345) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) baseReq);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) baseResp);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", baseResp.errCode);
        bundle.putString("errStr", baseResp.errStr);
        bundle.putString("openId", baseResp.openId);
        bundle.putString("transaction", baseResp.transaction);
        Intent intent = new Intent("broadcast_wx_pay_callback");
        intent.putExtras(bundle);
        MobileQQ.sMobileQQ.sendBroadcast(intent);
        synchronized (this.f327452f) {
            Iterator<Handler> it = this.f327452f.iterator();
            while (it.hasNext()) {
                Handler next = it.next();
                Message message = new Message();
                message.what = 10;
                message.setData(bundle);
                next.sendMessage(message);
            }
        }
    }

    public void registerApp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f327451e.registerApp(str);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    public void removeObserver(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) handler);
            return;
        }
        synchronized (this.f327452f) {
            this.f327452f.remove(handler);
        }
    }

    public void sendReq(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle);
            return;
        }
        PayReq payReq = new PayReq();
        String string = bundle.getString("appid");
        if (TextUtils.isEmpty(string)) {
            string = this.f327450d;
        }
        payReq.appId = string;
        payReq.partnerId = bundle.getString("partnerid");
        payReq.prepayId = bundle.getString("prepayid");
        payReq.nonceStr = bundle.getString("noncestr");
        payReq.timeStamp = bundle.getString("timestamp");
        payReq.packageValue = bundle.getString("package");
        payReq.sign = bundle.getString("sign");
        this.f327451e.sendReq(payReq);
    }

    public void unRegisterApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f327451e.unregisterApp();
        }
    }

    public void registerApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f327451e.registerApp(this.f327450d);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
