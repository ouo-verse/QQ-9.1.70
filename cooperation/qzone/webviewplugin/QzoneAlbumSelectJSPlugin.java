package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import cooperation.qzone.QZoneHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneAlbumSelectJSPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    private static final String TAG = QzoneBlogJsPlugin.class.getSimpleName();
    private static String pickCallBack = "";

    private void handleSelectAlbum(WebViewPlugin.b bVar, String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            pickCallBack = jSONObject.getString("callback");
            Bundle bundle = new Bundle();
            bundle.putInt("key_personal_album_enter_model", 0);
            bundle.putBoolean(QZoneHelper.QZoneAlbumConstants.KEY_PASS_RESULT_BY_BUNDLE, true);
            bundle.putString(QZoneHelper.QZoneAlbumConstants.KEY_ACCEPT_ALBUM_ANONYMITY, jSONObject.optString("acceptType"));
            bundle.putString(QZoneHelper.QZoneAlbumConstants.KEY_DENY_SELECT_TIPS, jSONObject.optString("denyTips"));
            bundle.putBoolean(QZoneHelper.QZoneAlbumConstants.KEY_CAN_NEW_ALBUM, false);
            bundle.putString(QZoneHelper.QZoneAlbumConstants.KEY_FROM_TYPE, jSONObject.optString(IProfileCardConst.KEY_FROM_TYPE));
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = this.parentPlugin.mRuntime.b().getCurrentAccountUin();
            bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, false);
            Activity a16 = this.parentPlugin.mRuntime.a();
            WebViewPlugin webViewPlugin = this.parentPlugin;
            QZoneHelper.forwardToPersonalAlbumSelect(a16, userInfo, bundle, QZoneHelperProxyImpl.generateRequestCode(webViewPlugin, webViewPlugin.mRuntime, 7));
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "handlePickQzoneAlbum,decode param error");
            }
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (!str2.equals("Qzone") || (webViewPlugin = this.parentPlugin) == null || webViewPlugin.mRuntime == null || !str3.equalsIgnoreCase("PickQzoneAlbum")) {
            return false;
        }
        handleSelectAlbum(this.parentPlugin.mRuntime, strArr);
        return true;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (b16 != 7 || TextUtils.isEmpty(pickCallBack) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_ID);
        String stringExtra2 = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_NAME);
        intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_COVER);
        intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_PERMISSION, 0);
        int intExtra = intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_TYPE, 0);
        int intExtra2 = intent.getIntExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO_ALBUM_ANONYMITY, 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("albumid", stringExtra);
            jSONObject.put("albumtype", intExtra);
            jSONObject.put("albumname", stringExtra2);
            jSONObject.put("albumanonymity", intExtra2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, jSONObject.toString());
        }
        this.parentPlugin.callJs(pickCallBack, jSONObject.toString());
    }
}
