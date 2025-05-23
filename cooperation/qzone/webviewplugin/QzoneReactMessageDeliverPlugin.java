package cooperation.qzone.webviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes38.dex */
public class QzoneReactMessageDeliverPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (!"Qzone".equals(str2) || (webViewPlugin = this.parentPlugin) == null || webViewPlugin.mRuntime == null || !QZoneJsConstants.METHOD_REACT_DELIVER_MSG.equalsIgnoreCase(str3)) {
            return false;
        }
        WebViewPlugin webViewPlugin2 = this.parentPlugin;
        deliverMsg(webViewPlugin2, webViewPlugin2.mRuntime, strArr);
        return true;
    }

    private void deliverMsg(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        if (strArr == null || strArr.length == 0 || bVar == null) {
            return;
        }
        QLog.i("QzoneReactMessageDeliverPlugin", 1, strArr[0]);
        Intent intent = new Intent("ReactNativeMsgDeliver");
        intent.putExtra("args", strArr[0]);
        BaseApplication.getContext().sendBroadcast(intent);
    }
}
