package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneBannerJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String NAMESPACE = "Qzone";
    public static final int UNIT_DP = 2;
    public static final int UNIT_PX = 1;
    public static final int UNIT_RATION = 3;
    private String TAG = QzoneBannerJsPlugin.class.getSimpleName();

    private JSONObject toJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e16) {
            QLog.e(this.TAG, 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        WebViewPlugin.b bVar;
        if ("Qzone".equals(str2) && (webViewPlugin = this.parentPlugin) != null && (bVar = webViewPlugin.mRuntime) != null) {
            CustomWebView e16 = (webViewPlugin == null || bVar == null) ? null : bVar.e();
            if (e16 != null) {
                Object tag = e16.getTag(R.id.daa);
                if (tag != null && (tag instanceof WebViewBannerInterface)) {
                    WebViewBannerInterface webViewBannerInterface = (WebViewBannerInterface) tag;
                    if ("setBannerHeight".equals(str3) && strArr != null && strArr.length >= 1) {
                        JSONObject json = toJson(strArr[0]);
                        if (json == null) {
                            QLog.e(this.TAG, 1, "setBannerHeight \u65b9\u6cd5\u53c2\u6570\u9519\u8bef\uff01\uff01\uff01\uff01");
                            return false;
                        }
                        double optDouble = json.optDouble("height");
                        if (optDouble <= 0.0d) {
                            QLog.e(this.TAG, 1, "setBannerHeight \u65b9\u6cd5\u53c2\u6570\u9519\u8bef height<=0 \uff01\uff01\uff01\uff01  )");
                        } else {
                            int optInt = json.optInt("unit");
                            QLog.i(this.TAG, 1, "setBannerHeight height:" + optDouble + ",unit:" + optInt);
                            if (optInt == 1) {
                                webViewBannerInterface.setBannerHeight((int) optDouble);
                            } else if (optInt == 2) {
                                webViewBannerInterface.setBannerHeight(ViewUtils.dip2px((float) optDouble));
                            } else if (optInt == 3) {
                                webViewBannerInterface.setBannerHeight((int) (optDouble * ViewUtils.getScreenWidth()));
                            } else {
                                QLog.e(this.TAG, 1, "setBannerHeight \u65b9\u6cd5\u53c2\u6570\u9519\u8bef :unit= " + optInt);
                            }
                        }
                        return true;
                    }
                    if ("closeBanner".equals(str3)) {
                        QLog.i(this.TAG, 1, "closeBanner:");
                        webViewBannerInterface.close();
                        return true;
                    }
                    if ("enableGesture".equals(str3) && strArr != null && strArr.length >= 1) {
                        JSONObject json2 = toJson(strArr[0]);
                        if (json2 == null) {
                            QLog.e(this.TAG, 1, "enableGesture \u65b9\u6cd5\u53c2\u6570\u9519\u8bef\uff01\uff01\uff01\uff01");
                        } else {
                            boolean optBoolean = json2.optBoolean("enable");
                            QLog.i(this.TAG, 1, "enableGesture enable:" + optBoolean);
                            webViewBannerInterface.enableGesture(optBoolean);
                        }
                        return true;
                    }
                    if ("getBannerData".equals(str3) && strArr != null && strArr.length >= 1) {
                        JSONObject json3 = toJson(strArr[0]);
                        if (json3 == null) {
                            QLog.e(this.TAG, 1, "getBannerData \u65b9\u6cd5\u53c2\u6570\u9519\u8bef\uff01\uff01\uff01\uff01");
                        } else {
                            String optString = json3.optString("callback");
                            if (TextUtils.isEmpty(optString)) {
                                QLog.e(this.TAG, 1, "getBannerData \u65b9\u6cd5\u53c2\u6570\u9519\u8bef\uff01\uff01\uff01\uff01");
                            }
                            String bannerData = webViewBannerInterface.getBannerData();
                            e16.callJs(optString, bannerData);
                            QLog.i(this.TAG, 1, "getBannerData " + bannerData);
                        }
                        return true;
                    }
                    if (!"qbossReport".equals(str3) || strArr == null || strArr.length < 1) {
                        return false;
                    }
                    JSONObject json4 = toJson(strArr[0]);
                    if (json4 == null) {
                        QLog.e(this.TAG, 1, "qbossReport \u65b9\u6cd5\u53c2\u6570\u9519\u8bef\uff01\uff01\uff01\uff01");
                    } else {
                        String optString2 = json4.optString("sQBosstrace");
                        if (TextUtils.isEmpty(optString2)) {
                            QLog.e(this.TAG, 1, "qbossReport \u65b9\u6cd5\u53c2\u6570\u9519\u8bef\uff01\uff01\uff01\uff01");
                        }
                        int optInt2 = json4.optInt("type");
                        String optString3 = json4.optString(CacheTable.TABLE_NAME);
                        webViewBannerInterface.qbossReport(optInt2, optString2, optString3);
                        QLog.i(this.TAG, 1, "qbossReport type:" + optInt2 + ",qBosstrace:" + optString2 + " ,reportInfo:" + optString3);
                    }
                    return true;
                }
                QLog.e(this.TAG, 1, "webViewBannerInterface error o=" + tag);
                return false;
            }
            QLog.e(this.TAG, 1, "handleJsRequest webView==null");
        }
        return false;
    }
}
