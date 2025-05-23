package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneUserHomePageJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String ACTION_OPEN_KAPU_HOST_MESSAGE_SETTING = "QzoneUserHome.ACTION_openKapuHostMsg";
    public static final String ACTION_OPEN_MESSAGE_BOARD = "QzoneUserHome.ACTION_openMsgBoard";
    private static final int CLOSE_MESSAGE_BOARD = 0;
    public static final String KEY_KAPU_HOST_MESSAGE_SETTING = "text";
    public static final String KEY_OPEN_MESSAGE_BOARD = "openMsgBoard";
    public static final String KEY_UPDATE_MESSAGE_BOARD = "updateMsgBoard";
    public static String PKG_NAME = "Qzone";
    public static final String TAG = "QzoneUserHomePageJsPlugin";
    public static final int UPDATE_MSG_COUNT = 1;
    public static final int UPDATE_MSG_COUNT_AND_BULLET_SCREEN = 2;

    private void handleSetKapuHostMessage(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        String str = "";
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return;
        }
        try {
            str = new JSONObject(strArr[0]).optString("text", "");
        } catch (JSONException e16) {
            QZLog.e(TAG, "handleSetMessageBoardGate: parse json data error", e16);
        }
        Intent intent = new Intent("QzoneUserHome.ACTION_openKapuHostMsg");
        intent.putExtra("text", str);
        a16.sendBroadcast(intent);
        QZLog.i(TAG, 2, "handleSetKapuHostMessage: sendBroadcast,text:" + str);
    }

    private boolean handleSetMessageBoardGate(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        int i3;
        boolean z16 = false;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (jSONObject.optInt("open_msg_board", 0) != 0) {
                z16 = true;
            }
            i3 = jSONObject.optInt("update_msg_board", 1);
        } catch (JSONException e16) {
            QZLog.e(TAG, "handleSetMessageBoardGate: parse json data error", e16);
            i3 = 1;
        }
        Intent intent = new Intent("QzoneUserHome.ACTION_openMsgBoard");
        intent.putExtra("openMsgBoard", z16);
        intent.putExtra("updateMsgBoard", i3);
        a16.sendBroadcast(intent);
        QZLog.i(TAG, 2, "handleSetMessageBoardGate: sendBroadcast,isOpenMsgBoard:" + z16 + " ,updateType\uff1a" + i3);
        return true;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals(PKG_NAME) && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (QZoneJsConstants.METHOD_SETTING_MESSAGE_BOARD_GATE.equalsIgnoreCase(str3)) {
                handleSetMessageBoardGate(this.parentPlugin, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_SETTING_KAPU_HOST_MESSAGE.equalsIgnoreCase(str3)) {
                handleSetKapuHostMessage(this.parentPlugin, strArr);
                return true;
            }
        }
        return false;
    }
}
