package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;
import cooperation.vip.AdvVideoFloat.AdvGerneralProxy;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class AdvFloatVideoJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String ADVCLICKBLANKAREA = "AdvClickBlankArea";
    public static final String ADVLOADEDNOTIFY = "AdvLoadedNotify";
    public static final String ADVREPORTVAS = "AdvReportVas";
    public static final int CURRENTWEBVIEWREADY = 0;
    public static final String NAMESPACE = "Qzone";
    public static final String TAG = "AdvFloatVideoJsPlugin";
    public String mCallback = "";

    public void handleAdvClickBlankArea(String[] strArr) {
        if (strArr == null || strArr.length < 1) {
            return;
        }
        try {
            QZLog.i(TAG, "@advWebview handleAdvClickBlankArea");
            AdvGerneralProxy.getInstance().notifyVideoBlankClick(new JSONObject(strArr[0]).optString("advid"));
        } catch (Exception e16) {
            QZLog.e(TAG, e16.toString());
        }
    }

    public void handleAdvLoadedNotify(String[] strArr) {
        if (strArr == null || strArr.length < 1) {
            return;
        }
        try {
            QZLog.i(TAG, "handleAdvLoadedNotify @advWebview");
            JSONObject jSONObject = new JSONObject(strArr[0]);
            int i3 = jSONObject.getInt("status");
            CustomWebView e16 = this.parentPlugin.mRuntime.e();
            if (e16 == null) {
                return;
            }
            String str = (String) e16.getTag(AdvGerneralProxy.getInstance().getFirstKey());
            if (i3 == 0) {
                this.mCallback = jSONObject.getString("callback");
                if (QZLog.isColorLevel()) {
                    QZLog.i(TAG, "@advWebview onlykey =" + str);
                }
                this.parentPlugin.callJs(this.mCallback, AdvGerneralProxy.getInstance().getCallBackData(str));
                e16.setTag(AdvGerneralProxy.getInstance().getFourthKey(), this.mCallback);
                return;
            }
            if (i3 == 1) {
                String string = jSONObject.getString("id");
                e16.setTag(AdvGerneralProxy.getInstance().getSecondKey(), 1);
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                AdvGerneralProxy.getInstance().notifyH5PageReady(str + "_" + string);
            }
        } catch (Exception e17) {
            QZLog.e(TAG, "handleAdvLoadedNotify eroo" + e17.toString());
        }
    }

    public void handleAdvReportVas(String[] strArr) {
        if (strArr == null || strArr.length < 1) {
            return;
        }
        try {
            QZLog.i(TAG, "handleAdvReportVas");
            AdvGerneralProxy.getInstance().notifyOnlyReportClickArea(new JSONObject(strArr[0]).optInt(GdtGetUserInfoHandler.KEY_AREA, -1));
        } catch (Exception e16) {
            QZLog.e(TAG, e16.toString());
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (str2 != null && str2.equals("Qzone") && str3 != null && (webViewPlugin = this.parentPlugin) != null && webViewPlugin.mRuntime != null) {
            if (str3.equals(ADVLOADEDNOTIFY) && strArr.length >= 1) {
                QZLog.i(TAG, ADVLOADEDNOTIFY);
                handleAdvLoadedNotify(strArr);
                return true;
            }
            if (str3.equals(ADVCLICKBLANKAREA)) {
                QZLog.i(TAG, ADVCLICKBLANKAREA);
                handleAdvClickBlankArea(strArr);
                return true;
            }
            if (str3.equals(ADVREPORTVAS)) {
                QZLog.i(TAG, ADVREPORTVAS);
                handleAdvReportVas(strArr);
                return true;
            }
        }
        return false;
    }
}
