package ba1;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends WebViewPlugin {
    private void p(String[] strArr) {
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            return;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        Intent intent = (bVar == null || bVar.f() == null || this.mRuntime.f().getIntent() == null) ? null : this.mRuntime.f().getIntent();
        if (intent == null) {
            return;
        }
        try {
            String optString = new JSONObject(strArr[0]).optString("callback");
            long longExtra = intent.getLongExtra(ProtocolDownloaderConstants.HEADER_FRIEND_UIN, 0L);
            String stringExtra = intent.getStringExtra("peer_uid");
            JSONObject jSONObject = new JSONObject();
            if (longExtra != 0) {
                jSONObject.put(ProtocolDownloaderConstants.HEADER_FRIEND_UIN, longExtra);
            }
            if (stringExtra != null) {
                jSONObject.put("peer_uid", stringExtra);
            }
            String jSONObject2 = jSONObject.toString();
            callJs(optString, jSONObject2);
            QLog.d("C2CGameJsPlugin", 1, "[handleGetGamePartnerData] callback=" + optString + ", data=" + jSONObject2);
        } catch (Throwable th5) {
            QLog.d("C2CGameJsPlugin", 1, "[handleGetGamePartnerData] e=", th5);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "Game";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("getGamePartnerData".equals(str3)) {
            p(strArr);
            return true;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }
}
