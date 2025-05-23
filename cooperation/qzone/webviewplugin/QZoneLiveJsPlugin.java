package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzonePatchApi;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneLiveJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String METHOD_NAME_OF_GET_QZONE_LIVE_PLUGIN_STATUS = "getQZoneLiveStatus";
    public static final String NAMESPACE = "Qzone";
    private static final String TAG = "QZoneLiveJsPlugin";

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null && METHOD_NAME_OF_GET_QZONE_LIVE_PLUGIN_STATUS.equals(str3) && strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                final String optString = jSONObject.optString("callback");
                final boolean optBoolean = jSONObject.optBoolean("needInstall");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "H5\u53c2\u6570\uff1a" + jSONObject);
                }
                final JSONObject jSONObject2 = new JSONObject();
                String loadQZoneLivePluginId = QZonePluginUtils.getLoadQZoneLivePluginId();
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "pluginid \uff1a" + loadQZoneLivePluginId);
                }
                if (TextUtils.isEmpty(loadQZoneLivePluginId)) {
                    jSONObject2.put("isInstalled", false);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "pluginid \u4e3a\u7a7a\uff0c\u8fd4\u56de\uff1a" + jSONObject2);
                    }
                    this.parentPlugin.callJs(optString, jSONObject2.toString());
                } else if ("qzone_live_video_plugin.apk".equals(loadQZoneLivePluginId)) {
                    if (!TextUtils.isEmpty(optString)) {
                        Activity a16 = this.parentPlugin.mRuntime.a();
                        if (a16 == null) {
                            jSONObject2.put("isInstalled", false);
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "context \u4e3a\u7a7a\uff0c\u8fd4\u56de\uff1a" + jSONObject2);
                            }
                            this.parentPlugin.callJs(optString, jSONObject2.toString());
                        } else {
                            PluginManagerHelper.getPluginInterface(a16, new PluginManagerHelper.OnPluginManagerLoadedListener() { // from class: cooperation.qzone.webviewplugin.QZoneLiveJsPlugin.1
                                @Override // com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener
                                public void onPluginManagerLoaded(PluginManagerClient pluginManagerClient) {
                                    try {
                                        if (pluginManagerClient == null) {
                                            if (QLog.isColorLevel()) {
                                                QLog.i(QZoneLiveJsPlugin.TAG, 2, "context \u4e3a\u7a7a\uff0c\u8fd4\u56de\uff1a" + jSONObject2);
                                            }
                                            jSONObject2.put("isInstalled", false);
                                            if (QLog.isColorLevel()) {
                                                QLog.i(QZoneLiveJsPlugin.TAG, 2, "pluginManagerClient \u4e3a\u7a7a\uff0c\u8fd4\u56de\uff1a" + jSONObject2);
                                            }
                                            QZoneLiveJsPlugin.this.parentPlugin.callJs(optString, jSONObject2.toString());
                                            return;
                                        }
                                        PluginBaseInfo queryPlugin = pluginManagerClient.queryPlugin("qzone_live_video_plugin.apk");
                                        if (queryPlugin == null) {
                                            jSONObject2.put("isInstalled", false);
                                            if (QLog.isColorLevel()) {
                                                QLog.i(QZoneLiveJsPlugin.TAG, 2, "pluginInfo \u4e3a\u7a7a\uff0c\u8fd4\u56de\uff1a" + jSONObject2);
                                            }
                                            QZoneLiveJsPlugin.this.parentPlugin.callJs(optString, jSONObject2.toString());
                                            return;
                                        }
                                        if (queryPlugin.mState == 4) {
                                            jSONObject2.put("isInstalled", true);
                                            if (QLog.isColorLevel()) {
                                                QLog.i(QZoneLiveJsPlugin.TAG, 2, "\u63d2\u4ef6\u5df2\u5b89\u88c5\uff0c\u8fd4\u56de\uff1a" + jSONObject2);
                                            }
                                            QZoneLiveJsPlugin.this.parentPlugin.callJs(optString, jSONObject2.toString());
                                            return;
                                        }
                                        jSONObject2.put("isInstalled", false);
                                        if (QLog.isColorLevel()) {
                                            QLog.i(QZoneLiveJsPlugin.TAG, 2, "\u63d2\u4ef6\u672a\u5b89\u88c5,state=" + queryPlugin.mState + "needInstall\uff1a" + optBoolean + "\u8fd4\u56de\uff1a" + jSONObject2);
                                        }
                                        if (optBoolean) {
                                            int networkType = NetworkState.getNetworkType();
                                            if (QLog.isColorLevel()) {
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append("NetworkState.NET_TYPE_WIFI == type:");
                                                sb5.append(1 == networkType);
                                                QLog.i(QZoneLiveJsPlugin.TAG, 2, sb5.toString());
                                            }
                                            if (1 == networkType) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.i(QZoneLiveJsPlugin.TAG, 2, "\u5f00\u59cb\u4e0b\u8f7d");
                                                }
                                                pluginManagerClient.installPlugin("qzone_live_video_plugin.apk");
                                            }
                                        }
                                        QZoneLiveJsPlugin.this.parentPlugin.callJs(optString, jSONObject2.toString());
                                    } catch (JSONException e16) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e(QZoneLiveJsPlugin.TAG, 2, "", e16);
                                        }
                                    }
                                }
                            });
                        }
                    }
                } else if (loadQZoneLivePluginId.equals(IQzonePatchApi.LIVE_PLUGIN_ID)) {
                    TextUtils.isEmpty(optString);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "", e16);
                }
            }
        }
        return false;
    }
}
