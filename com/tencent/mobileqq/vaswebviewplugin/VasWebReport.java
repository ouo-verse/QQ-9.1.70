package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.common.util.k;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.mobileqq.webviewplugin.u;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VasWebReport extends WebViewPlugin {
    private static final int HTTP_CAPTURE_TO_QLOG = 1;
    private static final int PERFORMANCE_TO_QLOG = 2;
    public static final String PLUGIN_NAMESPACE = "debug";
    static final String TAG = "VasWebReport";
    public static final String WEB_CORE_DATA_FLAGS = "filterType";
    public static final int WEB_CORE_DUMP_ERROR = 4;
    public static final int WEB_CORE_HTTP_CAPTURE = 2;
    public static final int WEB_CORE_PERFORMANCE_DATA = 1;
    URLInterceptManager mURLInterceptManager;
    private int mWebCoreDumpFlags;
    private int mWebCoreDumpHandlePolicy;
    private Map<String, Long> startTimeMap = new HashMap();
    private Map<String, Integer> errorMap = new HashMap();
    private JSONObject mIndexPerformanceObject = null;
    private JSONObject mFirstScreenPerformanceObject = null;

    private void handleNewPerformanceData(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        SwiftBrowserStatistics swiftBrowserStatistics;
        if (jSONObject == null || !jSONObject.has("infotype")) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("infotype");
            if (optInt == 2 && jSONObject.has("first_screen")) {
                this.mFirstScreenPerformanceObject = jSONObject;
                if (QLog.isDevelopLevel()) {
                    QLog.i("Web_X5_Performance", 2, "X5 mFirstScreenPerformanceObject: " + jSONObject.toString());
                }
            } else if (optInt == 1 && jSONObject.has("recv_start")) {
                String optString = jSONObject.optString("url");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                int indexOf = optString.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (indexOf != -1) {
                    optString = optString.substring(0, indexOf);
                }
                int indexOf2 = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (indexOf2 != -1) {
                    str = str.substring(0, indexOf2);
                }
                if (str.equalsIgnoreCase(optString)) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("Web_X5_Performance", 2, "X5 index onResourcesPerformance: " + jSONObject.toString());
                    }
                    this.mIndexPerformanceObject = jSONObject;
                }
            }
            JSONObject jSONObject3 = this.mIndexPerformanceObject;
            if (jSONObject3 == null || (jSONObject2 = this.mFirstScreenPerformanceObject) == null) {
                return;
            }
            jSONObject3.put("first_screen", jSONObject2.optLong("first_screen"));
            long optLong = jSONObject3.optLong("dns_start");
            jSONObject3.optLong("dns_end");
            long optLong2 = jSONObject3.optLong("connect_start");
            jSONObject3.optLong("connect_end");
            long optLong3 = jSONObject3.optLong("send_start");
            jSONObject3.optLong("send_end");
            long optLong4 = jSONObject3.optLong("recv_start");
            long optLong5 = jSONObject3.optLong("recv_end");
            if (QLog.isDevelopLevel()) {
                QLog.d("Web_X5_Performance", 1, "Web_X5_Load_Index, dns start: " + optLong + ", connect start: " + optLong2 + ", send start: " + optLong3 + ", receive first packet start: " + optLong4 + ", receive last packet end: " + optLong5);
            }
            WebViewPlugin.b bVar = this.mRuntime;
            y d16 = bVar.d(bVar.a());
            if (d16 != null && (d16 instanceof u)) {
                ((u) d16).setX5Performance(jSONObject3);
                this.mIndexPerformanceObject = null;
                this.mFirstScreenPerformanceObject = null;
            } else {
                if (!(this.mRuntime.a() instanceof com.tencent.mobileqq.webview.swift.u) || (swiftBrowserStatistics = (SwiftBrowserStatistics) super.getBrowserComponent(-2)) == null) {
                    return;
                }
                swiftBrowserStatistics.H0 = jSONObject3;
                this.mIndexPerformanceObject = null;
                this.mFirstScreenPerformanceObject = null;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void handlePerformanceData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            long optLong = jSONObject.optLong("first_word");
            long optLong2 = jSONObject.optLong("first_screen");
            long optLong3 = jSONObject.optLong("page_finish");
            if (QLog.isDevelopLevel()) {
                QLog.i("Web_X5_Performance", 2, "X5 onResourcesPerformance, first_word: " + optLong + ", first_screen:" + optLong2 + ", page_finish:" + optLong3);
            }
            JSONArray jSONArray = jSONObject.getJSONArray(DKConfiguration.Directory.RESOURCES);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return;
            }
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            if (QLog.isDevelopLevel()) {
                QLog.i("Web_X5_Performance", 2, "X5 onResourcesPerformance: " + jSONObject2);
            }
            jSONObject2.put("first_screen", optLong2);
            jSONObject2.optLong("dns_start");
            jSONObject2.optLong("dns_end");
            jSONObject2.optLong("connect_start");
            jSONObject2.optLong("connect_end");
            jSONObject2.optLong("recv_start");
            jSONObject2.optLong("recv_end");
            WebViewPlugin.b bVar = this.mRuntime;
            y d16 = bVar.d(bVar.a());
            if (d16 != null && (d16 instanceof u)) {
                ((u) d16).setX5Performance(jSONObject2);
            }
            for (int i3 = 1; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                if (QLog.isDevelopLevel()) {
                    QLog.i("Web_X5_Performance", 2, "X5 onResourcesPerformance: " + jSONObject3);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void startActivity(Intent intent) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return;
        }
        if (bVar.a() != null) {
            this.mRuntime.a().startActivity(intent);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Activity is null");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "debug";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 96L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        String str2;
        long j16;
        URLInterceptManager uRLInterceptManager;
        WebViewPlugin.b bVar;
        WebViewPlugin.b bVar2;
        CustomWebView e16;
        if (j3 == 32) {
            if ((!str.startsWith("http") && !str.startsWith("https")) || (bVar2 = this.mRuntime) == null || (e16 = bVar2.e()) == null || e16.getX5WebViewExtension() == null) {
                return false;
            }
            Integer[] webViewFeatureParams = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
            int intValue = webViewFeatureParams != null ? webViewFeatureParams[6].intValue() : 65535;
            if (MobileQQ.sProcessId == 2) {
                this.mWebCoreDumpHandlePolicy |= 1;
                this.mWebCoreDumpFlags = 0;
                if (QLog.isColorLevel()) {
                    QLog.d("WebCoreDump", 2, "disable for qzone");
                }
            } else {
                if (QLog.isDevelopLevel()) {
                    this.mWebCoreDumpHandlePolicy |= 1;
                }
                if (QLog.isDevelopLevel() && VipWebViewReportLog.i(str) && VipWebViewReportLog.h()) {
                    this.mWebCoreDumpHandlePolicy |= 1;
                    this.mWebCoreDumpFlags |= 3;
                }
                if (QLog.isDevelopLevel() && ((Boolean) t.j().b("WebView_enable_X5_Report", Boolean.TRUE)).booleanValue()) {
                    this.mWebCoreDumpFlags |= 1;
                    this.mWebCoreDumpHandlePolicy |= 2;
                }
            }
            this.mWebCoreDumpFlags &= intValue;
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreDump", 2, "Data Filter Mask=0x" + Integer.toHexString(intValue) + ". setDataFilterForRequestInfo=" + this.mWebCoreDumpFlags + ". WebCoreDumpPolicy=" + this.mWebCoreDumpHandlePolicy);
            }
            if (this.mWebCoreDumpFlags != 0) {
                Bundle bundle = new Bundle();
                bundle.putInt(WEB_CORE_DATA_FLAGS, this.mWebCoreDumpFlags);
                e16.getX5WebViewExtension().invokeMiscMethod("setDataFilterForRequestInfo", bundle);
                e16.recordHttpStream((this.mWebCoreDumpFlags & 2) != 0);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(NodeProps.ENABLED, (this.mWebCoreDumpFlags & 1) != 0);
                e16.getX5WebViewExtension().invokeMiscMethod("webPerformanceRecordingEnabled", bundle2);
            }
        } else {
            if (j3 == 64) {
                if (this.mWebCoreDumpFlags != 0) {
                    Integer num = 0;
                    Object obj = map.get("performanceData");
                    JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                    Object obj2 = map.get(WebViewPlugin.KEY_REQUEST);
                    WebResourceRequest webResourceRequest = obj2 instanceof WebResourceRequest ? (WebResourceRequest) obj2 : null;
                    Object obj3 = map.get(WebViewPlugin.KEY_RESPONSE);
                    WebResourceResponse webResourceResponse = obj3 instanceof WebResourceResponse ? (WebResourceResponse) obj3 : null;
                    Object obj4 = map.get("errorCode");
                    if (obj4 instanceof Integer) {
                        num = (Integer) obj4;
                    }
                    if ((this.mWebCoreDumpHandlePolicy & 1) != 0 && webResourceRequest != null) {
                        VipWebViewReportLog.k(jSONObject, webResourceRequest, webResourceResponse, num.intValue());
                    }
                    if ((this.mWebCoreDumpHandlePolicy & 2) != 0 && jSONObject != null) {
                        if (jSONObject.has("infotype")) {
                            handleNewPerformanceData(str, jSONObject);
                            handlePublicAccountReport(str, jSONObject);
                        } else {
                            handlePerformanceData(jSONObject);
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "WebView core dump received but no policy can handle it");
                }
                return true;
            }
            if (j3 == 8589934593L) {
                this.startTimeMap.remove(str);
                this.startTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "VasWebReport:EVENT_LOAD_START");
                }
            } else if (j3 == 8589934594L) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "VasWebReport:EVENT_LOAD_FINISH");
                }
                if (str.contains("vip.qq.com") || str.contains("vaswebreport=1")) {
                    WebViewPlugin.b bVar3 = this.mRuntime;
                    if (bVar3 == null || bVar3.a() == null) {
                        return false;
                    }
                    Context applicationContext = this.mRuntime.a().getApplicationContext();
                    if (2 == NetworkUtil.getSystemNetwork(applicationContext)) {
                        str2 = "2G";
                    } else if (3 == NetworkUtil.getSystemNetwork(applicationContext)) {
                        str2 = "3G";
                    } else if (4 == NetworkUtil.getSystemNetwork(applicationContext)) {
                        str2 = "4G";
                    } else {
                        str2 = 1 == NetworkUtil.getSystemNetwork(applicationContext) ? Global.TRACKING_WIFI : "XG";
                    }
                    String str3 = str2;
                    if (this.errorMap.containsKey(str)) {
                        ReportController.r(null, "P_CliOper", "vasweb", "", "load", "finish", 0, 1, "errocode:" + this.errorMap.get(str), str3, k.f(str, new String[0]), AppSetting.f99551k + "--android--" + Build.VERSION.SDK_INT);
                        this.errorMap.remove(str);
                    } else {
                        if (this.startTimeMap.containsKey(str)) {
                            j16 = System.currentTimeMillis() - this.startTimeMap.get(str).longValue();
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "VasWebReport--EVENT_LOAD_FINISH:report erro,there is not starttime for " + str);
                            }
                            j16 = -1;
                        }
                        ReportController.r(null, "P_CliOper", "vasweb", "", "load", "finish", 0, 0, "" + j16, str3, k.f(str, new String[0]), AppSetting.f99551k + "--android--" + Build.VERSION.SDK_INT);
                    }
                }
                this.startTimeMap.remove(str);
                WebViewPlugin.b bVar4 = this.mRuntime;
                if (bVar4 != null && bVar4.f() != null && this.mRuntime.f().getAppRuntime() != null && (uRLInterceptManager = (URLInterceptManager) this.mRuntime.f().getAppRuntime().getManager(QQManagerFactory.URL_INTECEPT_MANAGER)) != null && !uRLInterceptManager.g() && (bVar = this.mRuntime) != null) {
                    uRLInterceptManager.h(bVar.a());
                }
            } else if (j3 == 8589934595L) {
                this.errorMap.put(str, Integer.valueOf(((Integer) map.get("errorCode")).intValue()));
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "VasWebReport:EVENT_LOAD_ERROR");
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        SwiftBrowserStatistics swiftBrowserStatistics;
        if (!"debug".equalsIgnoreCase(str2) || !"log".equalsIgnoreCase(str3) || (swiftBrowserStatistics = (SwiftBrowserStatistics) super.getBrowserComponent(-2)) == null) {
            return false;
        }
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d("QQBrowser_report", 2, "try report web status, onNetworkCost,  step: 11, asyncMode: " + swiftBrowserStatistics.f314378v0 + ", from loadUrl: " + (System.currentTimeMillis() - swiftBrowserStatistics.R) + ", stepTime: " + (System.currentTimeMillis() - swiftBrowserStatistics.f314358f) + ", totalTime: " + (System.currentTimeMillis() - swiftBrowserStatistics.f314358f) + ", \n " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        this.startTimeMap.clear();
        this.startTimeMap = null;
        this.errorMap.clear();
        this.errorMap = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0146 A[Catch: Exception -> 0x019f, TryCatch #0 {Exception -> 0x019f, blocks: (B:45:0x0090, B:47:0x0096, B:49:0x009f, B:51:0x00de, B:23:0x013e, B:25:0x0146, B:27:0x0151), top: B:44:0x0090 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handlePublicAccountReport(String str, JSONObject jSONObject) {
        String str2;
        long j3;
        String str3;
        String str4;
        long j16;
        int i3;
        String str5 = str;
        if (jSONObject == null || !jSONObject.has("infotype")) {
            return;
        }
        try {
            if (jSONObject.optInt("infotype") == 1) {
                String optString = jSONObject.optString("url");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                int indexOf = optString.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                String substring = indexOf != -1 ? optString.substring(0, indexOf) : optString;
                int indexOf2 = str5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (indexOf2 != -1) {
                    str5 = str5.substring(0, indexOf2);
                }
                long optLong = jSONObject.optLong("dns_start");
                long optLong2 = jSONObject.optLong("dns_end");
                long optLong3 = jSONObject.optLong("connect_start");
                long optLong4 = jSONObject.optLong("connect_end");
                long optLong5 = jSONObject.optLong("recv_start");
                long optLong6 = jSONObject.optLong("recv_end");
                URL url = new URL(optString);
                String host = url.getHost();
                String path = url.getPath();
                String str6 = str5;
                if ("qqpublic.qpic.cn".equalsIgnoreCase(host)) {
                    try {
                        if (!TextUtils.isEmpty(path) && path.startsWith("/qq_public")) {
                            str2 = substring;
                            int i16 = (int) (optLong2 - optLong);
                            j3 = optLong2;
                            int i17 = (int) (optLong4 - optLong3);
                            int i18 = (int) (optLong6 - optLong5);
                            int optInt = jSONObject.optInt("errorcode");
                            str3 = "errorcode";
                            String optString2 = jSONObject.optString("website_address");
                            str4 = "website_address";
                            int b16 = com.tencent.mqpsdk.util.a.b(null);
                            StringBuilder sb5 = new StringBuilder();
                            j16 = optLong3;
                            sb5.append(AppSetting.f99551k);
                            sb5.append(",3,");
                            sb5.append(AppSetting.f99542b);
                            String sb6 = sb5.toString();
                            if (QLog.isColorLevel()) {
                                i3 = 2;
                                QLog.i(PublicAccountWebReport.TAG, 2, "urlStr: " + optString + ",errorcode:" + optInt + ",netType:" + b16 + ",DNSCost" + i16 + ",connectCost:" + i17 + ",receiveCost:" + i18 + ",website_address:" + optString2 + ",AppSetting.subVersion:" + sb6);
                                if (str6.equalsIgnoreCase(str2) || !PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host)) {
                                }
                                int i19 = i3;
                                try {
                                    PublicAccountWebReport.reportPublicAccountNetInfoRequest(this.mRuntime.b(), (int) (optLong4 - j16), (int) (j3 - optLong), jSONObject.optInt(str3), (int) (optLong6 - optLong5), optString, jSONObject.optString(str4));
                                    long optLong7 = this.mFirstScreenPerformanceObject.optLong("first_screen") - optLong;
                                    if (QLog.isColorLevel()) {
                                        QLog.i(PublicAccountWebReport.TAG, i19, "first_screen: " + optLong7);
                                        return;
                                    }
                                    return;
                                } catch (Exception e16) {
                                    e = e16;
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            i3 = 2;
                            if (str6.equalsIgnoreCase(str2)) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        e.printStackTrace();
                        return;
                    }
                }
                str3 = "errorcode";
                str2 = substring;
                j3 = optLong2;
                j16 = optLong3;
                str4 = "website_address";
                i3 = 2;
                if (str6.equalsIgnoreCase(str2)) {
                }
            }
        } catch (Exception e18) {
            e = e18;
        }
    }
}
