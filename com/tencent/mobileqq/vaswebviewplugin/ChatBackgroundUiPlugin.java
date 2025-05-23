package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.t;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* loaded from: classes35.dex */
public class ChatBackgroundUiPlugin extends VasWebviewUiPlugin {
    private static final String TAG = "ChatBackgroundUiPlugin";
    t mOnRemoteResp = new t() { // from class: com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin.1
        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(Bundle bundle) {
            if (bundle != null) {
                String string = bundle.getString("cmd");
                if (QLog.isColorLevel()) {
                    QLog.d("MessengerService", 2, "setbgjumpAIO:", "chatBgResp," + string);
                }
                if (string == null || !string.equals("chatbackground_setbg")) {
                    return;
                }
                if (!bundle.getBoolean("existScaleAIO", false) && !VasToggle.VAS_THEME_CHAT_BG_CLOSE_WEB.isEnable(true)) {
                    Activity a16 = ChatBackgroundUiPlugin.this.mRuntime.a();
                    if (a16 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MessengerService", 2, "setbgjumpAIO:", "bgSetBackAio");
                        }
                        Intent intent = new Intent();
                        intent.setComponent(SplashActivity.getAliasComponent(BaseApplicationImpl.getApplication()));
                        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                        intent.addFlags(67108864);
                        a16.startActivity(intent);
                        return;
                    }
                    return;
                }
                QLog.d("MessengerService", 2, "existScaleAIO");
            }
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(Bundle bundle) {
        }
    };
    private Bundle mReqBundle;
    private String uin;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityCreate() {
        super.OnActivityCreate();
        this.mReqBundle = new Bundle();
        this.uin = this.mRuntime.b().getAccount();
        WebViewProvider f16 = this.mRuntime.f();
        if (f16 != null) {
            f16.setCurUrl(super.decodeUrl(f16.getCurrentUrl()));
        }
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mOnRemoteResp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    public void OnActivityDestroy() {
        super.OnActivityDestroy();
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mOnRemoteResp);
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewUiPlugin
    protected boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 33554432L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 3L;
    }
}
