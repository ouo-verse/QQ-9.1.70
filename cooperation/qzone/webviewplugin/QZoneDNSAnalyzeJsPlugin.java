package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZoneDNSAnalyzeJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    private static final String TAG = "QZoneDNSAnalyzeJsPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public void callJS(String str, int i3, String str2) {
        WebViewPlugin.b bVar;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "callback is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", i3);
            jSONObject.put("host_ip", str2);
            String jSONObject2 = jSONObject.toString();
            WebViewPlugin webViewPlugin = this.parentPlugin;
            if (webViewPlugin == null || (bVar = webViewPlugin.mRuntime) == null || bVar.e() == null) {
                return;
            }
            this.parentPlugin.mRuntime.e().callJs(str, jSONObject2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (!str2.equals("Qzone") || (webViewPlugin = this.parentPlugin) == null || webViewPlugin.mRuntime == null || !str3.equalsIgnoreCase("getHostIpAddress")) {
            return false;
        }
        handleGetHostIpAddress(this.parentPlugin, strArr);
        return true;
    }

    private void handleGetHostIpAddress(WebViewPlugin webViewPlugin, String[] strArr) {
        Activity a16;
        if (strArr == null || strArr.length == 0 || (a16 = webViewPlugin.mRuntime.a()) == null || a16.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            final String optString = jSONObject.optString("host");
            final String optString2 = jSONObject.optString("callback");
            if (TextUtils.isEmpty(optString2)) {
                QLog.e(TAG, 1, "callback is empty.");
            } else if (TextUtils.isEmpty(optString)) {
                QLog.e(TAG, 1, "host is empty.");
            } else {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str = "";
                        try {
                            str = InetAddress.getByName(optString).getHostAddress();
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            QLog.e(QZoneDNSAnalyzeJsPlugin.TAG, 1, "Analyze " + optString + " ip address : " + str);
                            QZoneDNSAnalyzeJsPlugin.this.callJS(optString2, 0, str);
                        } catch (UnknownHostException unused) {
                            QLog.e(QZoneDNSAnalyzeJsPlugin.TAG, 1, "UnknownHostException:Analyze " + optString + " ip address failed");
                            QZoneDNSAnalyzeJsPlugin.this.callJS(optString2, -1, str);
                        }
                    }
                });
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        Object obj;
        if (j3 != 8589934595L || map == null || (obj = map.get("errorCode")) == null || !(obj instanceof Integer)) {
            return false;
        }
        final int intValue = ((Integer) obj).intValue();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QZoneDNSAnalyzeJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                int netWorkType = HttpUtil.getNetWorkType();
                if (netWorkType != 0 && netWorkType != -1) {
                    try {
                        QLog.e(QZoneDNSAnalyzeJsPlugin.TAG, 1, "netType: " + netWorkType + " error code: " + intValue + ", Analyze h5.qzone.qq.com ip address : " + InetAddress.getByName("h5.qzone.qq.com").getHostAddress());
                        return;
                    } catch (UnknownHostException e16) {
                        e16.printStackTrace();
                        QLog.e(QZoneDNSAnalyzeJsPlugin.TAG, 1, "netType: " + netWorkType + " error code: " + intValue + ", UnknownHostException:Analyze  h5.qzone.qq.com  ip address failed");
                        return;
                    }
                }
                QLog.e(QZoneDNSAnalyzeJsPlugin.TAG, 1, "netType: " + netWorkType + " error code: " + intValue + ", No ActiveNetwork, Analyze  h5.qzone.qq.com  ip address failed");
            }
        });
        return false;
    }
}
