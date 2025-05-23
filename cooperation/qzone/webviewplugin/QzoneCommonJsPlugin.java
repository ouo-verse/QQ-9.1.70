package cooperation.qzone.webviewplugin;

import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes38.dex */
public class QzoneCommonJsPlugin extends QzoneInternalWebViewPlugin {
    private static final String JUMP_QZONE_CLEAN = "jumpQQCleanPage";
    public static final String NAMESPACE = "Qzone";

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null && JUMP_QZONE_CLEAN.equalsIgnoreCase(str3)) {
            if (this.parentPlugin.mRuntime.a() != null) {
                QQSettingCleanActivity.K2(this.parentPlugin.mRuntime.a());
                return true;
            }
            QLog.e("jumpCleanPage", 2, "call activity with null runtime");
        }
        return false;
    }
}
