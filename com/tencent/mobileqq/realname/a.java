package com.tencent.mobileqq.realname;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends VasWebviewJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    public byte f280192d = 1;

    /* renamed from: e, reason: collision with root package name */
    private String f280193e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.realname.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public class C8495a implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f280194a;

        C8495a(String str) {
            this.f280194a = str;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            a.this.r("", this.f280194a);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            a.this.r(mainTicketInfo.getA2(), this.f280194a);
        }
    }

    private void q(TicketManager ticketManager, AppInterface appInterface, String str) {
        ticketManager.getA2(appInterface.getLongAccountUin(), 16, new C8495a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, String str2) {
        String str3 = new String(NetConnInfoCenter.GUID);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", String.valueOf(AppSetting.f()));
            jSONObject.put("imei", QQDeviceInfo.getIMEI("ef0716"));
            jSONObject.put("guid", str3);
            jSONObject.put(NowProxyConstants.AccountInfoKey.A2, str);
            callJs(str2, jSONObject.toString());
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
            }
        }
    }

    private void s(TicketManager ticketManager, AppInterface appInterface, String str) {
        r(ticketManager.getA2(appInterface.getAccount()), str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "RealName";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.i("RealName", 2, "handleJsRequest url: " + str + " pkgName: " + str2 + " method: " + str3 + " args: " + strArr[0]);
        }
        if (!str2.equalsIgnoreCase("RealName") || strArr == null || strArr.length < 1) {
            return false;
        }
        if (str3.equalsIgnoreCase("getCountryCode")) {
            try {
                this.f280193e = new JSONObject(strArr[0]).getString("callbackId");
                QBaseActivity qBaseActivity = (QBaseActivity) this.mRuntime.a();
                if (qBaseActivity == null) {
                    return false;
                }
                startActivityForResult(new Intent(qBaseActivity, (Class<?>) CountryActivity.class), this.f280192d);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
                return false;
            }
        } else if (str3.equalsIgnoreCase("onAuthResult")) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                int i3 = jSONObject.getInt("result");
                String optString = jSONObject.optString("from", "");
                Bundle bundle = new Bundle();
                bundle.putInt("result", i3);
                bundle.putString("source", optString);
                BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "REAL_NAME", "ON_WEB_AUTH_RESULT", bundle);
            } catch (JSONException e17) {
                if (QLog.isColorLevel()) {
                    e17.printStackTrace();
                }
                return false;
            }
        } else if (str3.equalsIgnoreCase("getDeviceInfo")) {
            try {
                String string = new JSONObject(strArr[0]).getString("callbackId");
                AppInterface b16 = this.mRuntime.b();
                TicketManager ticketManager = (TicketManager) b16.getManager(2);
                if (ticketManager.useAsyncTicketInterface()) {
                    q(ticketManager, b16, string);
                } else {
                    s(ticketManager, b16, string);
                }
            } catch (JSONException e18) {
                if (QLog.isColorLevel()) {
                    e18.printStackTrace();
                }
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        int i16 = -1;
        try {
            if (b16 == this.f280192d && i3 == -1) {
                if (intent != null) {
                    str = intent.getStringExtra("k_name");
                    str2 = intent.getStringExtra("k_code");
                    if (QLog.isColorLevel()) {
                        QLog.i("RealName", 2, "onActivity countryName is: " + str + " countryCode: " + str2);
                    }
                    i16 = 0;
                    jSONObject.put("retCode", i16);
                    jSONObject.put("country", str);
                    jSONObject.put("value", str2);
                    callJs(this.f280193e, jSONObject.toString());
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("RealName", 2, "onActivityResult, intent is null.");
                }
            }
            jSONObject.put("retCode", i16);
            jSONObject.put("country", str);
            jSONObject.put("value", str2);
            callJs(this.f280193e, jSONObject.toString());
            return;
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
                return;
            }
            return;
        }
        str = "";
        str2 = "";
    }
}
