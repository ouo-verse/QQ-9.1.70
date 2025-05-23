package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* loaded from: classes38.dex */
public class QzoneBlogJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    private static final String TAG = "QzoneBlogJsPlugin";

    private static void handleWriteBlog(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE);
        Bundle bundle = new Bundle();
        bundle.putString("cmd", QZoneJsConstants.METHOD_WRITEBLOGSUCCESS);
        intent.putExtras(bundle);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleWriteBlog actionString: " + intent.getAction());
        }
        QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (!str2.equals("Qzone") || (webViewPlugin = this.parentPlugin) == null || webViewPlugin.mRuntime == null || !str3.equalsIgnoreCase(QZoneJsConstants.METHOD_WRITEBLOGSUCCESS)) {
            return false;
        }
        WebViewPlugin webViewPlugin2 = this.parentPlugin;
        handleWriteBlog(webViewPlugin2, webViewPlugin2.mRuntime, strArr);
        return true;
    }
}
