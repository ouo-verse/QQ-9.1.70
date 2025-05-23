package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QZonePersonalizeJsHandleLogic {
    public static final String TAG = "QZonePersonalizeJsHandleLogicQZonePersonalizePlugin";

    public static void handleSwitchFinished(WebViewPlugin.b bVar, String... strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                int optInt = jSONObject.optInt("facade", -1);
                int optInt2 = jSONObject.optInt("feedskin", -1);
                int optInt3 = jSONObject.optInt("avatar", -1);
                int optInt4 = jSONObject.optInt("float", -1);
                int optInt5 = jSONObject.optInt("customvip", -1);
                int optInt6 = jSONObject.optInt("praise", -1);
                int optInt7 = jSONObject.optInt("player", -1);
                boolean optBoolean = jSONObject.optBoolean("isAfter785", false);
                int optInt8 = jSONObject.optInt(QZoneJsConstants.METHOD_CLEAR_DIY, -1);
                Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
                Bundle bundle = new Bundle();
                bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.PERSONALIZE_SWITCH_FINISHED);
                bundle.putInt("facade", optInt);
                bundle.putInt("feedskin", optInt2);
                bundle.putInt("avatar", optInt3);
                bundle.putInt("floatObject", optInt4);
                bundle.putInt("customvip", optInt5);
                bundle.putInt("praise", optInt6);
                bundle.putInt("player", optInt7);
                bundle.putInt("isAfter785", optBoolean ? 1 : 0);
                bundle.putInt(QZoneJsConstants.METHOD_CLEAR_DIY, optInt8);
                intent.putExtras(bundle);
                QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
            } catch (JSONException unused) {
            }
        }
    }
}
