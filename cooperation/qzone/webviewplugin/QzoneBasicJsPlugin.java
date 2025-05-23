package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendShareFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.base.config.data.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneBasicJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    private String TAG = QzoneBasicJsPlugin.class.getSimpleName();

    private boolean isFeatureEnable(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return !"stickyNote".equals(str);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if ("openUrl".equals(str3) && strArr != null && strArr.length >= 1) {
                if (QLog.isColorLevel()) {
                    QLog.i(this.TAG, 2, "openUrl=" + strArr[0]);
                }
                try {
                    this.parentPlugin.mRuntime.e().loadUrl(new JSONObject(strArr[0]).getString("url"));
                } catch (JSONException e16) {
                    QLog.e(this.TAG, 1, "handle openUrl", e16);
                }
            }
            if ("shareFriendMsg".equals(str3) && strArr != null && strArr.length >= 1) {
                if (QLog.isColorLevel()) {
                    QLog.i(this.TAG, 2, "shareFriendMsg: arg=" + strArr[0]);
                }
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    String string = jSONObject.getString("content");
                    String string2 = jSONObject.getString("jumpurl");
                    String string3 = jSONObject.getString("uin");
                    long j3 = jSONObject.getLong("timestamp");
                    Intent intent = new Intent();
                    intent.putExtra("friend_uin", string3);
                    intent.putExtra("content", string);
                    intent.putExtra(WadlProxyConsts.KEY_JUMP_URL, string2);
                    intent.putExtra("timestamp", j3);
                    PublicFragmentActivity.b.a(this.parentPlugin.mRuntime.a(), intent, PublicTransFragmentActivity.class, ActivateFriendShareFragment.class);
                } catch (Throwable th5) {
                    QLog.e(this.TAG, 1, "handle shareFriendMsg", th5);
                }
            }
            if ("isFeatureEnable".equals(str3) && strArr != null && strArr.length >= 1) {
                handleIsFeatureEnable(strArr);
            }
        }
        return false;
    }

    public void handleIsFeatureEnable(String[] strArr) {
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            JSONArray jSONArray = jSONObject.getJSONArray(k.FEATURES_KEY);
            String string = jSONObject.getString("callback");
            JSONArray jSONArray2 = new JSONArray();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string2 = jSONArray.getString(i3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("name", string2);
                jSONObject2.put("enable", isFeatureEnable(string2));
                jSONArray2.mo162put(jSONObject2);
            }
            QLog.d(this.TAG, 1, "handleIs FeatureEnable, callback: " + string + ", result: " + jSONArray2.toString());
            this.parentPlugin.callJs(string, jSONArray2.toString());
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "handleIsFeatureEnable", th5);
        }
    }
}
