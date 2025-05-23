package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private Context f238182d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.biz.troop.b f238183e = null;

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "groupVideo";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934615L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.i("GroupVideoManager.GVideoWebPlugin", 2, "url:" + str + " pkgName:" + str2 + " method:" + str3 + " args:" + strArr);
        }
        if (TextUtils.equals(str2, "groupVideo") && strArr != null && strArr.length != 0) {
            if (TextUtils.equals(str3, "closeGroupVideoAPI")) {
                try {
                    JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
                    if (jsonFromJSBridge != null) {
                        int optInt = jsonFromJSBridge.optInt("type");
                        Intent intent = new Intent("tencent.video.webjs.cmd");
                        intent.putExtra("type", optInt);
                        if (optInt == 1 || optInt == 2) {
                            this.f238182d.sendBroadcast(intent);
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return true;
            }
            if (TextUtils.equals(str3, "openRoom")) {
                try {
                    JSONObject jsonFromJSBridge2 = WebViewPlugin.getJsonFromJSBridge(str);
                    if (jsonFromJSBridge2 != null) {
                        this.f238183e.Z(jsonFromJSBridge2.optString("roomCode"), jsonFromJSBridge2.optInt("isGroupCode"), jsonFromJSBridge2.optString("action"), jsonFromJSBridge2.optString("fromId"), jsonFromJSBridge2.optString("backType"), jsonFromJSBridge2.optString("openType"), jsonFromJSBridge2.optString("extra"));
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                return true;
            }
            if (TextUtils.equals(str3, "preload")) {
                try {
                    QLog.e("GroupVideoManager.GVideoWebPlugin", 2, "preload url:" + str);
                    this.f238183e.g0();
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f238182d = this.mRuntime.a().getApplicationContext();
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.f238183e = A;
        A.p();
        if (QLog.isColorLevel()) {
            QLog.i("GroupVideoManager.GVideoWebPlugin", 2, "GVideoWebPlugin onCreate");
        }
        new IntentFilter(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction("com.tencent.od")).addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction("com.tencent.od"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.troop.b bVar = this.f238183e;
        if (bVar != null) {
            bVar.q();
        }
    }
}
