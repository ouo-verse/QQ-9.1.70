package cooperation.qzone.webviewplugin.famous;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;

/* loaded from: classes38.dex */
public class QzoneHomePageJsPlugin extends QzoneInternalWebViewPlugin {
    public static String METHOD_NAME = "setPGCNavViewSetting";
    public static String PKG_NAME = "Qzone";

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin.b bVar;
        if (!str2.equals(PKG_NAME) || !METHOD_NAME.equals(str3)) {
            return false;
        }
        QZLog.i("QzoneHomePageJsPlugin", 4, "navigation url:" + str + " pkgName:" + str2 + " method:" + str3 + " jsonString:" + strArr[0]);
        Intent intent = new Intent(QZoneHelper.HOME_PAGE_SPACE_JS_CALL_REFLUSH_NAVIGATION_BAR);
        intent.putExtra(QZoneHelper.KEY_FAMOUS_SPACE_NAVIGATION_BAR_INFO, strArr[0]);
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || bVar.a() == null) {
            return true;
        }
        this.parentPlugin.mRuntime.a().sendBroadcast(intent);
        return true;
    }
}
