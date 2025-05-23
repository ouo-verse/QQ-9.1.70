package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneDeviceTagJsPlugin extends QzoneInternalWebViewPlugin implements WebEventListener {
    public static final String NAMESPACE = "Qzone";
    private static final String TAG = QzoneBlogJsPlugin.class.getSimpleName();

    private static void handleDeviceTag(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String[] strArr) {
        bVar.b().getHandler(QzoneDeviceTagJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                RemoteHandleManager.getInstance().getSender().getDeviceInfos();
            }
        });
    }

    private static void handleUserTail(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, final String[] strArr) {
        bVar.b().getHandler(QzoneDeviceTagJsPlugin.class).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String str2;
                String str3;
                JSONObject jSONObject;
                String str4 = "";
                String[] strArr2 = strArr;
                if (strArr2 == null || strArr2.length <= 0 || strArr2[0] == null) {
                    return;
                }
                try {
                    jSONObject = new JSONObject(strArr[0]);
                    str = jSONObject.getString("strDiyMemo");
                } catch (JSONException e16) {
                    e = e16;
                    str = "";
                    str2 = str;
                }
                try {
                    str2 = jSONObject.getString("strDeviceTail");
                    try {
                        str3 = jSONObject.getString("strDeviceIcon");
                    } catch (JSONException e17) {
                        e = e17;
                        str3 = "";
                    }
                } catch (JSONException e18) {
                    e = e18;
                    str2 = "";
                    str3 = str2;
                    e.printStackTrace();
                    RemoteHandleManager.getInstance().getSender().setUserTail(str, str2, str3, str4);
                }
                try {
                    str4 = jSONObject.getString("strIdentifySqua");
                } catch (JSONException e19) {
                    e = e19;
                    e.printStackTrace();
                    RemoteHandleManager.getInstance().getSender().setUserTail(str, str2, str3, str4);
                }
                RemoteHandleManager.getInstance().getSender().setUserTail(str, str2, str3, str4);
            }
        });
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if ("Qzone".equals(str2) && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (QZoneJsConstants.METHOD_GETDEVICEINFO.equalsIgnoreCase(str3)) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                WebViewPlugin webViewPlugin2 = this.parentPlugin;
                handleDeviceTag(webViewPlugin2, webViewPlugin2.mRuntime, strArr);
                return true;
            }
            if (QZoneJsConstants.METHOD_SETUSERTAIL.equalsIgnoreCase(str3)) {
                RemoteHandleManager.getInstance().addWebEventListener(this);
                WebViewPlugin webViewPlugin3 = this.parentPlugin;
                handleUserTail(webViewPlugin3, webViewPlugin3.mRuntime, strArr);
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        RemoteHandleManager.getInstance().removeWebEventListener(this);
    }

    @Override // cooperation.qzone.remote.logic.WebEventListener
    public void onWebEvent(String str, Bundle bundle) {
        if (bundle == null || !bundle.containsKey("data")) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "call js function,bundle is empty");
            }
        } else {
            if (RemoteHandleConst.CMD_GET_DEVICE_INFOS.equals(str)) {
                String string = bundle2.getString(RemoteHandleConst.PARAM_DEVICE_INFOS);
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                this.parentPlugin.callJs("window.QZPhoneTagJSInterface.onReceive({code:0,data:" + string + "})");
                return;
            }
            RemoteHandleConst.CMD_SET_USER_TAIL.equals(str);
        }
    }
}
