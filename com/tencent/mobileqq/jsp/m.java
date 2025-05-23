package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class m extends WebViewPlugin implements ListenTogetherIPCModuleWebClient.b {

    /* renamed from: d, reason: collision with root package name */
    protected String f238891d;

    /* renamed from: e, reason: collision with root package name */
    protected String f238892e;

    /* renamed from: f, reason: collision with root package name */
    private String f238893f;

    /* renamed from: h, reason: collision with root package name */
    private EIPCResultCallback f238894h = new a();

    /* renamed from: i, reason: collision with root package name */
    private EIPCResultCallback f238895i = new b();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (TextUtils.isEmpty(m.this.f238893f)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", eIPCResult.data.getBoolean("result") ? 0 : 1);
                m mVar = m.this;
                mVar.callJs(mVar.f238893f, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements EIPCResultCallback {
        b() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (TextUtils.isEmpty(m.this.f238893f)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", eIPCResult.data.getBoolean("result") ? 0 : 1);
                m mVar = m.this;
                mVar.callJs(mVar.f238893f, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "listenTogether";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, strArr));
        }
        if (!"listenTogether".equals(str2)) {
            return false;
        }
        JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherPlugin", 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        this.f238893f = jsonFromJSBridge.optString("callback");
        if (!"awakePlugin".equals(str3)) {
            if ("statusChanged".equals(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    ListenTogetherIPCModuleWebClient.c(jSONObject);
                    if ("checkJoin".equals(jSONObject.opt("type"))) {
                        this.f238891d = jSONObject.optString("callback");
                    } else if ("joinListen".equals(jSONObject.opt("type"))) {
                        this.f238892e = jSONObject.optString("callback");
                    }
                } catch (Exception e16) {
                    QLog.e("ListenTogetherPlugin", 1, "METHOD_STATUS_CHANGED exception e = ", e16);
                }
            } else if ("isOpener".equals(str3)) {
                if (TextUtils.isEmpty(this.f238893f)) {
                    return true;
                }
                ListenTogetherIPCModuleWebClient.b(jsonFromJSBridge, "isOpener", this.f238895i);
            } else if ("isShowAtmosphere".equals(str3)) {
                if (TextUtils.isEmpty(this.f238893f)) {
                    return true;
                }
                ListenTogetherIPCModuleWebClient.b(jsonFromJSBridge, "isShowAtmosphere", this.f238894h);
            } else if ("setPlayerId".equals(str3)) {
                ListenTogetherIPCModuleWebClient.b(jsonFromJSBridge, "setPlayerId", null);
            } else {
                if (!"setThemeEnabled".equals(str3)) {
                    return false;
                }
                ListenTogetherIPCModuleWebClient.b(jsonFromJSBridge, "setThemeEnabled", null);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient.b
    public void n(JSONObject jSONObject) {
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherPlugin", 2, "statusChanged isDestroy:" + this.isDestroy + " data:" + jSONObject + " mCheckJoinCallback:" + this.f238891d + " mJoinListenCallback:" + this.f238892e);
        }
        if (jSONObject != null && TextUtils.equals(jSONObject.optString("type"), "checkJoin")) {
            if (TextUtils.isEmpty(this.f238891d)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("canJoin", jSONObject.optInt("canJoin"));
                jSONObject2.put("isOpener", jSONObject.optInt("isOpener"));
                jSONObject2.put("uinType", jSONObject.optInt("uinType"));
                callJs(this.f238891d, jSONObject2.toString());
                return;
            } catch (Throwable th5) {
                QLog.e("ListenTogetherPlugin", 1, "statusChanged error:" + th5.getMessage());
                return;
            }
        }
        if (jSONObject != null && TextUtils.equals(jSONObject.optString("type"), "joinListen")) {
            if (TextUtils.isEmpty(this.f238892e)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("retCode", jSONObject.optInt("retCode"));
                callJs(this.f238892e, jSONObject3.toString());
            } catch (Throwable th6) {
                QLog.e("ListenTogetherPlugin", 1, "statusChanged error:" + th6.getMessage());
            }
            this.f238892e = null;
            return;
        }
        dispatchJsEvent("musicStatusChange", jSONObject, null);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherPlugin", 2, "onActivityResult requestCode=" + ((int) b16) + "  resultCode=" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherPlugin", 2, "onCreate");
        }
        ListenTogetherIPCModuleWebClient.d().e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherPlugin", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        ListenTogetherIPCModuleWebClient.d().g(this);
    }
}
