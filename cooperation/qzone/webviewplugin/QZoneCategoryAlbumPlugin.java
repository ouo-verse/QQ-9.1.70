package cooperation.qzone.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneCategoryAlbumPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (!str2.equals("Qzone") || (webViewPlugin = this.parentPlugin) == null || webViewPlugin.mRuntime == null || !str3.equalsIgnoreCase(QZoneJsConstants.METHOD_JUMP_CATEGORY_ALBUM) || strArr == null || strArr.length <= 0) {
            return false;
        }
        return jumpCategoryAlbum(strArr[0]);
    }

    private boolean jumpCategoryAlbum(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("categoryType");
            String optString = jSONObject.optString("categoryId");
            Activity a16 = this.parentPlugin.mRuntime.a();
            if (a16 == null) {
                return false;
            }
            QZoneHelper.forwardToCategoryAlbum(a16, this.parentPlugin.mRuntime.b().getCurrentAccountUin(), optInt, optString, -1);
            return true;
        } catch (Exception e16) {
            QLog.e("QZoneCategoryAlbumPlugin", 1, e16.getMessage());
            return false;
        }
    }
}
