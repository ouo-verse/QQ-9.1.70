package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public abstract class QzoneInternalWebViewPlugin {
    protected WebViewPlugin parentPlugin;

    public static void dispatchEventImpl(final CustomWebView customWebView, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (TextUtils.isEmpty(str) || customWebView == null) {
            return;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("event", str);
            if (jSONObject != null) {
                jSONObject3.put("data", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject3.put("options", jSONObject2);
            }
            final String str2 = "jsbridge://event/dispatchEvent?p=" + Uri.encode(jSONObject3.toString());
            if (QLog.isDebugVersion()) {
                QLog.i("QzoneInternalWebViewPlugin", 1, "dispatchEventImpl url:" + str2);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                customWebView.loadUrl(str2);
            } else {
                customWebView.post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CustomWebView.this.loadUrl(str2);
                    }
                });
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void dispatchEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        WebViewPlugin.b bVar;
        WebViewPlugin webViewPlugin = this.parentPlugin;
        dispatchEventImpl((webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null) ? null : bVar.e(), str, jSONObject, jSONObject2);
    }

    public Object handleEvent(String str, long j3) {
        return null;
    }

    public abstract boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr);

    public void initRuntime(WebViewPlugin webViewPlugin) {
        this.parentPlugin = webViewPlugin;
    }

    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        return false;
    }

    public void onDestroy() {
    }

    public void onActivityResult(Intent intent, byte b16, int i3) {
    }
}
