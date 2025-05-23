package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.plugin.IPluginManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PayJsPlugin extends com.tencent.mobileqq.webview.swift.k {

    /* renamed from: d, reason: collision with root package name */
    Activity f97377d;

    /* renamed from: e, reason: collision with root package name */
    AppInterface f97378e;

    /* renamed from: f, reason: collision with root package name */
    protected MyResultRecevicer f97379f;

    /* renamed from: h, reason: collision with root package name */
    protected Bundle f97380h;

    /* renamed from: m, reason: collision with root package name */
    protected long f97382m;

    /* renamed from: i, reason: collision with root package name */
    private boolean f97381i = false;
    private final String C = OpenConstants.ApiName.PAY;
    private final String D = TenpayPlugin.PLUGIN_NAME;
    private final String E = "openService";
    private final String F = IVipPayApi.METHOD_BUYGOODS;
    private final String G = "rechargeGameCurrency";
    private final String H = "rechargeQb";
    private final String I = "preparePay";
    private final String J = "subscribeMonthCardPay";
    private final String K = "getQBRecord";
    private final String L = "closeFullWindow";
    private final String M = "launchWechatPaySign";

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes32.dex */
    public static class MyResultRecevicer extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<PayJsPlugin> f97383d;

        public MyResultRecevicer(PayJsPlugin payJsPlugin, Handler handler) {
            super(handler);
            this.f97383d = new WeakReference<>(payJsPlugin);
        }

        private void a(PayJsPlugin payJsPlugin, Bundle bundle) {
            String string = bundle.getString("callbackSn");
            String string2 = bundle.getString("result");
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "onOpenTenpayViewCallback:" + string2 + ", callbackSn=" + string);
            WebViewPlugin.b bVar = payJsPlugin.mRuntime;
            if (bVar == null || bVar.e() == null || string == null || string2 == null) {
                return;
            }
            payJsPlugin.callJs(string, string2);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "MyResultRecevicer receive = " + this);
                QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "resultCode = " + i3 + " resultData = " + bundle);
            }
            PayJsPlugin payJsPlugin = this.f97383d.get();
            if (payJsPlugin == null || bundle == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "js callback...");
            }
            int i16 = bundle.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID);
            if (i3 == 0 && i16 == 5) {
                i3 = 5;
            }
            if (i3 != 14) {
                if (i3 != 24) {
                    if (i3 == 16) {
                        String string = bundle.getString("callback");
                        String string2 = bundle.getString("retData");
                        WebViewPlugin.b bVar = payJsPlugin.mRuntime;
                        if (bVar == null || bVar.e() == null || string == null || string2 == null) {
                            return;
                        }
                        payJsPlugin.p(string, string2);
                        return;
                    }
                    if (i3 != 17) {
                        switch (i3) {
                            case 4:
                            case 6:
                            case 7:
                            case 8:
                                break;
                            case 5:
                                a(payJsPlugin, bundle);
                                return;
                            case 9:
                                break;
                            default:
                                return;
                        }
                    }
                }
                String string3 = bundle.getString("callbackSn");
                String string4 = bundle.getString("result");
                bundle.getBoolean("isChoosePubAcc", false);
                bundle.getString("pubAcc");
                WebViewPlugin.b bVar2 = payJsPlugin.mRuntime;
                if (bVar2 == null || bVar2.e() == null || string3 == null || string4 == null) {
                    return;
                }
                payJsPlugin.mRuntime.e().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + string3 + "',{'r':0,'result':" + string4 + "});");
                return;
            }
            String string5 = bundle.getString("callbackSn");
            String string6 = bundle.getString("result");
            WebViewPlugin.b bVar3 = payJsPlugin.mRuntime;
            if (bVar3 == null || bVar3.e() == null || string5 == null || string6 == null) {
                return;
            }
            payJsPlugin.mRuntime.e().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + string5 + "',{'r':0,'result':" + string6 + "});");
        }
    }

    private void r(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 16);
        bundle.putString("payparmas_h5_url", s());
        bundle.putString("uin", this.f97378e.getCurrentAccountUin());
        bundle.putString("reqData", str);
        if (this.f97379f != null) {
            Parcel obtain = Parcel.obtain();
            this.f97379f.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            bundle.putParcelable(IPayLogic.RECEIVER_COM_KEY, resultReceiver);
        }
        QWalletPayBridge.launchForeground(this.mRuntime.a(), bundle);
    }

    private String s() {
        String str;
        CustomWebView e16 = this.mRuntime.e();
        if (e16 == null) {
            str = "";
        } else {
            str = e16.getUrl();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                e17.printStackTrace();
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return OpenConstants.ApiName.PAY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.k, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        if (!getNameSpace().equals(str2)) {
            return false;
        }
        if (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(strArr[0])) {
            str4 = "";
        } else {
            str4 = strArr[0];
        }
        this.f97382m = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i(IQWalletHelper.TAG_WALLET_PAY, 2, "" + this.f97382m + " PayJsPlugin.handleJsRequest params:" + str4);
        }
        if (str4 != null && OpenConstants.ApiName.PAY.equals(str3)) {
            AppInterface appInterface = this.f97378e;
            if (appInterface != null && !appInterface.isLogin()) {
                x(str4, jsBridgeListener);
                return true;
            }
            w(str4, jsBridgeListener);
            return true;
        }
        if (str4 != null && TenpayPlugin.PLUGIN_NAME.equals(str3)) {
            u(str4, jsBridgeListener);
            return true;
        }
        if (str4 != null && "openService".equals(str3)) {
            t(4, str4, jsBridgeListener);
            return true;
        }
        if (str4 != null && IVipPayApi.METHOD_BUYGOODS.equals(str3)) {
            t(7, str4, jsBridgeListener);
            return true;
        }
        if (str4 != null && "rechargeGameCurrency".equals(str3)) {
            t(6, str4, jsBridgeListener);
            return true;
        }
        if (str4 != null && "rechargeQb".equals(str3)) {
            t(8, str4, jsBridgeListener);
            return true;
        }
        if (str4 != null && "subscribeMonthCardPay".equals(str3)) {
            t(14, str4, jsBridgeListener);
            return true;
        }
        if (str4 != null && "launchWechatPaySign".equals(str3)) {
            t(17, str4, jsBridgeListener);
            return true;
        }
        if ("preparePay".equals(str3)) {
            v();
            return true;
        }
        if (str4 != null && "getQBRecord".equals(str3)) {
            r(str4);
            return true;
        }
        if (!"closeFullWindow".equals(str3)) {
            return false;
        }
        q(str4);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        this.f97377d = this.mRuntime.a();
        this.f97378e = this.mRuntime.b();
        this.f97379f = new MyResultRecevicer(this, new Handler());
    }

    protected void p(String str, String str2) {
        super.callJs("javascript:window.JsBridge&&JsBridge.callback('" + str + "',{'r':0,'result':" + str2 + "});");
    }

    protected void t(int i3, String str, JsBridgeListener jsBridgeListener) {
        String string;
        String valueOf = String.valueOf(jsBridgeListener.b());
        Bundle bundle = new Bundle();
        bundle.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, valueOf);
        bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.f97382m);
        bundle.putString("payparmas_h5_url", s());
        Bundle newPay = PayBridgeActivity.newPay(this.f97378e, this.f97377d, this.f97379f, i3, bundle);
        this.f97380h = newPay;
        if (newPay.getInt("retCode", -1) == 0 || (string = this.f97380h.getString("retJson")) == null) {
            return;
        }
        callJs(valueOf, string);
    }

    protected void u(String str, JsBridgeListener jsBridgeListener) {
        if (QLog.isColorLevel()) {
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "openTenpayView requet params json=" + str);
        }
        CustomWebView e16 = this.mRuntime.e();
        String str2 = "";
        if (e16 != null) {
            try {
                str2 = new URL(e16.getUrl()).getHost();
            } catch (Exception e17) {
                if (QLog.isDevelopLevel()) {
                    e17.printStackTrace();
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, str);
        bundle.putString("callbackSn", String.valueOf(jsBridgeListener.b()));
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.f97382m);
        bundle.putString("h5_common_redpacket_domain", str2);
        PayBridgeActivity.tenpay(this.f97377d, 5, bundle);
    }

    protected void v() {
        if (QLog.isColorLevel()) {
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet preparePay");
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.a() == null || QWalletHelperDelegate.isQWalletProcessExist(this.mRuntime.a())) {
            return;
        }
        Intent intent = new Intent("cooperation.qwallet.QWALLET_PRELOAD");
        AppRuntime runtime = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getRuntime();
        if (runtime != null) {
            intent.putExtra("uin", runtime.getCurrentAccountUin());
        }
        IPluginManager.i iVar = new IPluginManager.i(0);
        iVar.f390198d = "qwallet_plugin.apk";
        iVar.f390201g = "Wallet";
        iVar.f390202h = "com.qwallet.receiver.QWallPreloadReceiver";
        iVar.f390204j = intent;
        IPluginManager.z5(this.mRuntime.a(), iVar);
    }

    protected void w(String str, JsBridgeListener jsBridgeListener) {
        String string;
        if (QLog.isColorLevel()) {
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet params json=" + str);
        }
        if (this.f97381i) {
            return;
        }
        this.f97381i = true;
        String appInfoFromHistory = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getAppInfoFromHistory();
        String valueOf = String.valueOf(jsBridgeListener.b());
        Bundle bundle = new Bundle();
        bundle.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, valueOf);
        bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.f97382m);
        bundle.putString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY, appInfoFromHistory);
        bundle.putString("payparmas_h5_url", s());
        Bundle newPay = PayBridgeActivity.newPay(this.f97378e, this.f97377d, this.f97379f, a15.a.f(str) ? 24 : 9, bundle);
        this.f97380h = newPay;
        if (newPay.getInt("retCode", -1) != 0 && (string = this.f97380h.getString("retJson")) != null) {
            callJs(valueOf, string);
        }
        this.f97381i = false;
    }

    protected void x(String str, JsBridgeListener jsBridgeListener) {
        if (QLog.isColorLevel()) {
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet params json=" + str);
        }
        if (this.f97381i) {
            return;
        }
        this.f97381i = true;
        String appInfoFromHistory = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getAppInfoFromHistory();
        String valueOf = String.valueOf(jsBridgeListener.b());
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ark.ARKMETADATA_JSON, str);
            bundle.putString("callbackSn", valueOf);
            bundle.putString("payparmas_h5_url", s());
            bundle.putString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY, appInfoFromHistory);
            bundle.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, valueOf);
            bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
            if (this.f97379f != null) {
                Parcel obtain = Parcel.obtain();
                this.f97379f.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
                bundle.putParcelable(IPayLogic.RECEIVER_COM_KEY, resultReceiver);
            }
            PayBridgeActivity.tenpay(this.f97377d, 9, bundle);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.f97381i = false;
    }

    private void q(String str) {
        String str2;
        try {
            str2 = new JSONObject(str).optString("url");
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = null;
        }
        Intent intent = new Intent("cn.abel.action.broadcast");
        intent.putExtra(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, !TextUtils.isEmpty(str2));
        BaseApplicationImpl.sApplication.sendBroadcast(intent);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Intent intent2 = new Intent(this.f97377d, (Class<?>) QQBrowserActivity.class);
        intent2.putExtra("url", str2);
        intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.f97377d.startActivity(intent2);
        if (QWalletHelperDelegate.sFullWindowActivitySource == 1) {
            ReportController.o(null, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "index.layila.intopage", 0, 0, "", "", "", "");
        }
        int i3 = QWalletHelperDelegate.sFullWndCurType;
        if (i3 == 0) {
            VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "screenReport", null, QWalletHelperDelegate.sFullWndCurID + "", 0, null);
            return;
        }
        if (i3 == 1) {
            VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "pullReport", null, QWalletHelperDelegate.sFullWndCurID + "", 0, null);
        }
    }
}
