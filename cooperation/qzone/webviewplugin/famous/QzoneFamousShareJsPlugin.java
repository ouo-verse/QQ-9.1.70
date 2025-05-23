package cooperation.qzone.webviewplugin.famous;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.wxa.gg.c;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneFamousShareJsPlugin extends QzoneInternalWebViewPlugin {
    public static String EXTRA_FAMOUS_IS_FOLLOWED = "is_followed";
    public static String EXTRA_FAMOUS_SHARE_BACKGROUND_URL = "background_url";
    public static String EXTRA_FAMOUS_SHARE_DESCPTION = "descption";
    public static String EXTRA_FAMOUS_SHARE_DETAIL_URL = "detail_url";
    public static String EXTRA_FAMOUS_SHARE_FANS_COUNT = "fans_count";
    public static String EXTRA_FAMOUS_SHARE_H5_DETAIL_URL = "h5_detail_url";
    public static String EXTRA_FAMOUS_SHARE_NICKNAME = "nick_name";
    public static String EXTRA_FAMOUS_SHARE_QRCODE_URL = "qrcode_url";
    public static String EXTRA_FAMOUS_SHARE_SCHEMA_DETAIL_URL = "schema_detail_url";
    public static String EXTRA_FAMOUS_SHARE_SUMMARY = "summary";
    public static String EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL = "thumb_photo_url";
    public static String EXTRA_FAMOUS_SHARE_TITLE = "title";
    public static String EXTRA_FAMOUS_SHARE_VISITOR_COUNT = "visitor_count";
    public static String EXTRA_FAMOUS_SHOW_REPORT_MENU = "show_report";
    public static String EXTRA_FAMOUS_UIN = "famous_uin";
    public static String PKG_NAME = "Qzone";
    public static final String TAG = "QzoneFamousShareJsPlugin";

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (!str2.equals(PKG_NAME) || (webViewPlugin = this.parentPlugin) == null || webViewPlugin.mRuntime == null || !str3.equalsIgnoreCase(c.NAME)) {
            return false;
        }
        handleShare(this.parentPlugin.mRuntime.a(), strArr);
        return true;
    }

    private void handleShare(Activity activity, String[] strArr) {
        Intent intent;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            String string = jSONObject.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_UIN);
            String string2 = jSONObject.getString("title");
            String string3 = jSONObject.getString("summary");
            String string4 = jSONObject.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL);
            String string5 = jSONObject.getString("detail_url");
            String string6 = jSONObject.has(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME) ? jSONObject.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME) : null;
            String string7 = jSONObject.has(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_DESCPTION) ? jSONObject.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_DESCPTION) : null;
            long j3 = jSONObject.has(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT) ? jSONObject.getLong(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT) : 0L;
            int i3 = jSONObject.has(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_VISITOR_COUNT) ? jSONObject.getInt(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_VISITOR_COUNT) : 0;
            String string8 = jSONObject.has(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL) ? jSONObject.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL) : null;
            String string9 = jSONObject.has(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_QRCODE_URL) ? jSONObject.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_QRCODE_URL) : null;
            System.out.println("---------title:" + string2 + ",summary:" + string3 + ",thumb_photo_url" + string4 + ",detail_url:" + string5);
            intent = new Intent();
            intent.putExtra(EXTRA_FAMOUS_UIN, string);
            intent.putExtra(EXTRA_FAMOUS_SHARE_TITLE, string2);
            intent.putExtra(EXTRA_FAMOUS_SHARE_SUMMARY, string3);
            intent.putExtra(EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL, string4);
            intent.putExtra(EXTRA_FAMOUS_SHARE_NICKNAME, string6);
            intent.putExtra(EXTRA_FAMOUS_SHARE_DESCPTION, string7);
            intent.putExtra(EXTRA_FAMOUS_SHARE_FANS_COUNT, j3);
            intent.putExtra(EXTRA_FAMOUS_SHARE_VISITOR_COUNT, i3);
            intent.putExtra(EXTRA_FAMOUS_SHARE_BACKGROUND_URL, string8);
            intent.putExtra(EXTRA_FAMOUS_SHARE_QRCODE_URL, string9);
            intent.putExtra(EXTRA_FAMOUS_SHARE_DETAIL_URL, string5);
            intent.putExtra("cmd", QZoneJsConstants.METHOD_FAMOUST_SHOW_DIALOG);
        } catch (JSONException e16) {
            e = e16;
        }
        try {
            String account = this.parentPlugin.mRuntime.c().getAccount();
            QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY);
            QzonePluginProxyActivity.launchPluingActivityForResult(activity, account, intent, 0);
            activity.startActivity(intent);
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
        }
    }
}
