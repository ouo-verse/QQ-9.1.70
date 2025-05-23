package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class BubbleUiPlugin extends VasWebviewUiPlugin {
    private static final String TAG = "BubbleUiPlugin";
    t mOnRemoteResp = new t() { // from class: com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin.2
        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
            BubbleUiPlugin bubbleUiPlugin = BubbleUiPlugin.this;
            if (bubbleUiPlugin.isHomePageWatingBind) {
                bubbleUiPlugin.reportBubbleSetting();
                if (QLog.isColorLevel()) {
                    QLog.i(BubbleUiPlugin.TAG, 2, "onResume -> onBindedToClient:loadurl");
                }
                BubbleUiPlugin.this.isHomePageWatingBind = false;
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityDestroy() {
        super.OnActivityDestroy();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mOnRemoteResp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityResume() {
        super.OnActivityResume();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mOnRemoteResp);
        if (((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            reportBubbleSetting();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "OnActivityResume -> loading url");
                return;
            }
            return;
        }
        this.isHomePageWatingBind = true;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "OnActivityResume -> loadurl waiting binding");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 64L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public boolean onActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "BaseWebActivity onActivityResult requestCode=" + i3 + ",resultCode=" + i16);
        }
        if (i16 != -1) {
            return false;
        }
        switch (i3) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                try {
                    String stringExtra = intent.getStringExtra("callbackSn");
                    String stringExtra2 = intent.getStringExtra("result");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("responseId", stringExtra);
                    jSONObject.put(WebViewPlugin.KEY_RESPONSE, new JSONObject(stringExtra2));
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "BaseWebActivity loadUrl setMessage =" + jSONObject.toString());
                    }
                    this.mRuntime.e().loadUrl("javascript:window.qqJSBridge&&qqJSBridge.setMessage('" + jSONObject.toString() + "');");
                    return true;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return true;
                }
            default:
                return false;
        }
    }

    public void reportBubbleSetting() {
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("optype", "Bubble");
                bundle.putString("opname", "Clk_bubble_setting");
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("reportActionCount", "", BubbleUiPlugin.this.mOnRemoteResp.key, bundle));
            }
        }, 1000L);
    }
}
