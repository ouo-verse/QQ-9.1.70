package cooperation.qzone.webviewplugin.ugcsetting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneUgcSettingJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    private String TAG = QzoneUgcSettingJsPlugin.class.getSimpleName();

    private void getLiveUgcSetting(String str, String str2) {
        Intent intent;
        Bundle extras;
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing() || TextUtils.isEmpty(str2) || (intent = a16.getIntent()) == null || (extras = intent.getExtras()) == null) {
            return;
        }
        this.parentPlugin.callJs(str2, UgcSettingUtil.liveUgcSettingToJson(extras));
    }

    private void getUgcSetting(String str) {
        Intent intent;
        Bundle extras;
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing() || TextUtils.isEmpty(str) || (intent = a16.getIntent()) == null || (extras = intent.getExtras()) == null) {
            return;
        }
        this.parentPlugin.callJs(str, UgcSettingUtil.ugcSettingToJson(extras));
    }

    private void handleCancellationStatus(WebViewPlugin.b bVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (new JSONObject(str).getInt("result") == 1) {
                QZoneUnreadServletLogic.x(0, bVar.b().getLongAccountUin());
            }
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "handleCancellationStatus... e:", th5);
        }
    }

    private void setLiveUgcSetting(String str, String str2) {
        String str3;
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(UgcSettingUtil.parseLiveJson(intent.getExtras(), str));
        a16.setResult(-1, intent);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String stringExtra = intent.getStringExtra(UgcSettingUtil.KEY_PARSE_JSON_STATUS);
        if (!TextUtils.isEmpty(stringExtra)) {
            str3 = "{\"ret\":-1, \"msg\":\"" + stringExtra + "\"}";
        } else {
            str3 = "{\"ret\":0, \"msg\":\"sucess\"}";
        }
        this.parentPlugin.callJs(str2, str3);
    }

    private void setUgcSetting(String str, String str2) {
        String str3;
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(UgcSettingUtil.parseJson(intent.getExtras(), str));
        a16.setResult(-1, intent);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String stringExtra = intent.getStringExtra(UgcSettingUtil.KEY_PARSE_JSON_STATUS);
        if (!TextUtils.isEmpty(stringExtra)) {
            str3 = "{\"ret\":-1, \"msg\":\"" + stringExtra + "\"}";
        } else {
            str3 = "{\"ret\":0, \"msg\":\"sucess\"}";
        }
        this.parentPlugin.callJs(str2, str3);
    }

    private void updateFriendSetting(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            String string2 = jSONObject.getString("value");
            long j3 = jSONObject.getLong("uin");
            jSONObject.getString("callback");
            RemoteHandleManager.getInstance().getSender().updateFriendSetting(string, string2, j3);
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "error process friend setting json string.", th5);
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2.equals("Qzone") && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (str3.equals("getUgcSetting") && strArr != null && strArr.length >= 1) {
                try {
                    getUgcSetting(new JSONObject(strArr[0]).optString("callback"));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return true;
            }
            if (str3.equals("setUgcSetting") && strArr != null && strArr.length >= 1) {
                try {
                    setUgcSetting(strArr[0], new JSONObject(strArr[0]).optString("callback"));
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                return true;
            }
            if (str3.equals("getLiveUgcSetting") && strArr != null && strArr.length >= 1) {
                try {
                    getLiveUgcSetting(strArr[0], new JSONObject(strArr[0]).optString("callback"));
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                return true;
            }
            if (str3.equals("setLiveUgcSetting") && strArr != null && strArr.length >= 1) {
                try {
                    setLiveUgcSetting(strArr[0], new JSONObject(strArr[0]).optString("callback"));
                } catch (Exception e19) {
                    e19.printStackTrace();
                }
                return true;
            }
            if (str3.equals("UpdateFriendSetting") && strArr != null && strArr.length >= 1) {
                updateFriendSetting(strArr[0]);
                return true;
            }
            if (str3.equals("reopenQzone") && strArr != null && strArr.length >= 1) {
                handleCancellationStatus(this.parentPlugin.mRuntime, strArr[0]);
                return true;
            }
        }
        return false;
    }
}
