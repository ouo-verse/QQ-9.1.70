package com.tencent.mobileqq.zplan.web.api.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.k;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.utils.WebSSOUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.zplan.web.ApolloSSOConfig;
import com.tencent.mobileqq.zplan.web.ApolloUrlInterceptor;
import com.tencent.mobileqq.zplan.web.api.IZPlanWebDataHandler;
import com.tencent.mobileqq.zplan.web.api.IZPlanWebUtil;
import com.tencent.mobileqq.zplan.web.d;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.util.LRULinkedHashMap;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* loaded from: classes34.dex */
public class ZPlanWebDataHandlerImpl implements IZPlanWebDataHandler {
    private static final int DATA_INVALID_INTERVAL = 10000;
    public static final String SP_KEY_DISABLE_THUNDER_CACHE = "sp_key_disable_thunder_cache";
    public static final String SP_KEY_NAME = "sp_apollo_webView";
    public static final String SP_KEY_SSO_CHECK_TIME = "sp_key_sso_check_time";
    public static final String SP_KEY_WEBVIEW_CONFIG_VERSION = "sp_key_apollo_webView_config_version";
    public static final String TAG = "[zplan]apollo_client_ApolloWebDataHandler";
    private final LRULinkedHashMap<String, b> mPreloadSSODatas = new LRULinkedHashMap<>(128);
    private ApolloSSOConfig mSSOConfig = new ApolloSSOConfig();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<ZPlanWebDataHandlerImpl> f336016a;

        /* renamed from: b, reason: collision with root package name */
        public String f336017b;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<WebViewPlugin> f336018c;

        public a(ZPlanWebDataHandlerImpl zPlanWebDataHandlerImpl, String str, WebViewPlugin webViewPlugin) {
            this.f336016a = new WeakReference<>(zPlanWebDataHandlerImpl);
            this.f336017b = str;
            this.f336018c = new WeakReference<>(webViewPlugin);
        }

        public void a(b bVar, com.tencent.mobileqq.zplan.web.b bVar2) {
            ZPlanWebDataHandlerImpl zPlanWebDataHandlerImpl = this.f336016a.get();
            if (zPlanWebDataHandlerImpl == null || bVar == null) {
                return;
            }
            WebViewPlugin webViewPlugin = this.f336018c.get();
            if (webViewPlugin != null && !TextUtils.isEmpty(this.f336017b)) {
                if (bVar2 != null) {
                    bVar2.f336028d = System.currentTimeMillis();
                }
                if (bVar.f336022h != null) {
                    webViewPlugin.callJs(this.f336017b, bVar.f336022h.toString());
                } else {
                    webViewPlugin.callJs(this.f336017b, "");
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + bVar.f336022h);
                }
            }
            if (zPlanWebDataHandlerImpl.mPreloadSSODatas != null) {
                zPlanWebDataHandlerImpl.mPreloadSSODatas.remove(bVar.f336020e);
                if (QLog.isColorLevel()) {
                    QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + bVar.f336020e);
                }
            }
        }
    }

    private void colorLogD(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    private String getMD5FromDb(String str) {
        ApolloSSOConfig apolloSSOConfig;
        if (TextUtils.isEmpty(str) || (apolloSSOConfig = this.mSSOConfig) == null) {
            return "";
        }
        String g16 = apolloSSOConfig.g(str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getMD5FromDb pageId:" + str + " md5:" + g16);
        }
        return g16;
    }

    @Override // com.tencent.mobileqq.zplan.web.api.IZPlanWebDataHandler
    public boolean doInterceptCmd(String str, String str2, AppInterface appInterface, Object obj) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!(obj instanceof WebViewPlugin)) {
                colorLogD("doInterceptApollo false, webViewPluginObj is not instanceof WebViewPlugin");
                return false;
            }
            WebViewPlugin webViewPlugin = (WebViewPlugin) obj;
            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                colorLogD("doInterceptApollo false, NetworkUtil.isNetworkAvailable:false");
                return false;
            }
            WebViewPlugin.b bVar = webViewPlugin.mRuntime;
            if (bVar != null && bVar.e() != null) {
                if (this.mSSOConfig != null) {
                    return shouldInterceptSsoCmd(str, webViewPlugin, str2, appInterface);
                }
                colorLogD("doInterceptApollo false, mSSOConfig is null");
                return false;
            }
            colorLogD("doInterceptApollo false, plugin.mRuntime.getWebView() is null");
            return false;
        }
        colorLogD("doInterceptApollo false, url=" + str + " app:" + appInterface + " requestStr:" + str2);
        return false;
    }

    public String getApolloClientId(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.isHierarchical()) {
                return parse.getQueryParameter(IZPlanWebDataHandler.KEY_APOLLO_CLIENT);
            }
            return null;
        } catch (Exception e16) {
            QLog.e(TAG, 2, e16.getMessage());
            return null;
        }
    }

    public WebResourceResponse getApolloCmdResource(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.mSSOConfig == null) {
            return null;
        }
        String str3 = "http://cmshow.qq.com/get_thunder_data?cmd=";
        if (!str.contains("http://cmshow.qq.com/get_thunder_data?cmd=") && !str.contains("https://cmshow.qq.com/get_thunder_data?cmd=")) {
            return null;
        }
        if (str.contains("https://cmshow.qq.com/get_thunder_data?cmd=")) {
            str3 = "https://cmshow.qq.com/get_thunder_data?cmd=";
        }
        String substring = str.substring(str3.length());
        if (!this.mSSOConfig.k(str2, substring)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getApolloCmdResource false, apolloClientId:" + str2 + " cmd:" + substring + ",mSSOConfig.isValidCmd:false");
            }
            return null;
        }
        String l3 = this.mSSOConfig.l(str2, substring);
        b bVar = this.mPreloadSSODatas.get(l3);
        if (bVar != null) {
            if (bVar.C) {
                if (bVar.f(substring)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getApolloCmdResource, webSSOTask.isValid true, webSSOTask=" + bVar);
                    }
                    if (bVar.D != null) {
                        bVar.D.f336027c = System.currentTimeMillis();
                        bVar.D.f336028d = System.currentTimeMillis();
                    }
                    WebResourceResponse webResourceResponse = new WebResourceResponse("text/plain", "utf-8", com.tencent.mobileqq.zplan.web.a.k(bVar.f336022h.toString()));
                    this.mPreloadSSODatas.remove(l3);
                    return webResourceResponse;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getApolloCmdResource, webSSOTask.isValid false,webSSOTask:" + bVar);
                }
                this.mPreloadSSODatas.remove(l3);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getApolloCmdResource, has webSSOTask = false");
        }
        return new WebResourceResponse("text/plain", "utf-8", new d(null, null, null));
    }

    public List<ApolloSSOConfig.c> getCGIConfigs(String str) {
        ApolloSSOConfig apolloSSOConfig = this.mSSOConfig;
        if (apolloSSOConfig != null) {
            return apolloSSOConfig.f(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.web.api.IZPlanWebDataHandler
    public void initInAsyncThreadIfNeed() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "apollo_client initInAsyncThread");
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.api.impl.ZPlanWebDataHandlerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                QRoute.api(IZPlanWebDataHandler.class);
                if (QLog.isColorLevel()) {
                    QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "apollo_client initInAsyncThread use:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }, null, true);
    }

    public boolean isApolloClientId(String str) {
        if (((IZPlanWebUtil) QRoute.api(IZPlanWebUtil.class)).isApolloProxyEnable()) {
            QLog.d(TAG, 2, "isApolloClientId, ApolloUtil.isApolloProxyEnable() return");
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isApolloClientId, apolloClientId:" + str);
            }
            ApolloSSOConfig apolloSSOConfig = this.mSSOConfig;
            if (apolloSSOConfig != null) {
                return apolloSSOConfig.j(str);
            }
        }
        return false;
    }

    public boolean isCmdResourceUrl(String str) {
        return str.contains("http://cmshow.qq.com/get_thunder_data?cmd=") || str.contains("https://cmshow.qq.com/get_thunder_data?cmd=");
    }

    public void preLoadSSOCmd(Context context, String str, String str2, AppInterface appInterface, com.tencent.mobileqq.zplan.web.b bVar) {
        if (TextUtils.isEmpty(str) || this.mSSOConfig == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(context)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "preLoadSSOCmd false, NetworkUtil.isNetworkAvailable:false");
                return;
            }
            return;
        }
        this.mSSOConfig.c(appInterface);
        Set<String> h16 = this.mSSOConfig.h(str);
        if (h16 != null && !h16.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "preloadSSOCmd, apolloClientId:" + str + " print all task:" + this.mPreloadSSODatas);
            }
            for (String str3 : h16) {
                String l3 = this.mSSOConfig.l(str, str3);
                b bVar2 = this.mPreloadSSODatas.get(l3);
                if (bVar2 != null && bVar2.f(str3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "preloadSSOCmd, apolloClientId:" + str + " mPreloadSSOCmds.has WebSSOTask:" + bVar2);
                    }
                } else {
                    this.mPreloadSSODatas.remove(l3);
                    b bVar3 = new b(bVar, l3, str3);
                    this.mPreloadSSODatas.put(l3, bVar3);
                    JSONObject e16 = this.mSSOConfig.e(str2, str, str3, appInterface);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "preloadSSOCmd, apolloClientId:" + str + " create new WebSSOTask, requestJson" + e16);
                    }
                    if (e16 != null) {
                        bVar3.h(context, str2, e16, appInterface);
                    }
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preloadSSOCmd, apolloClientId:" + str + " cmds is null or empty");
        }
    }

    public boolean saveHtml(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        FileUtils.writeFile(com.tencent.mobileqq.zplan.web.a.d(com.tencent.mobileqq.zplan.web.a.c(str)), str2);
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d(TAG, 2, "saveHtml url:" + str + " html.length:" + str2.length());
        return true;
    }

    public boolean verifyCache(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String e16 = com.tencent.mobileqq.zplan.web.a.e(str2);
            String mD5FromDb = getMD5FromDb(str);
            if (!TextUtils.isEmpty(mD5FromDb) && !TextUtils.isEmpty(e16) && e16.toUpperCase().equals(mD5FromDb.toUpperCase())) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "verifyMd5 false:" + mD5FromDb + " contentMd5:" + e16 + ",configMd5:" + mD5FromDb + " html.length:" + str2.length());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public static class b implements BusinessObserver {
        private boolean C;
        private com.tencent.mobileqq.zplan.web.b D;

        /* renamed from: d, reason: collision with root package name */
        private final String f336019d;

        /* renamed from: e, reason: collision with root package name */
        private final String f336020e;

        /* renamed from: f, reason: collision with root package name */
        private long f336021f;

        /* renamed from: h, reason: collision with root package name */
        private JSONObject f336022h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f336023i;

        /* renamed from: m, reason: collision with root package name */
        private final List<a> f336024m = new ArrayList();

        public b(com.tencent.mobileqq.zplan.web.b bVar, String str, String str2) {
            this.f336019d = str2;
            this.f336020e = str;
            this.D = bVar;
        }

        public boolean f(String str) {
            if (TextUtils.isEmpty(str) || !str.equals(this.f336019d) || System.currentTimeMillis() - this.f336021f >= 10000 || !this.f336023i) {
                return false;
            }
            boolean z16 = this.C;
            return (z16 && this.f336022h != null) || !z16;
        }

        public void g() {
            if (this.C) {
                Iterator<a> it = this.f336024m.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.D);
                }
                this.f336024m.clear();
            }
            if (QLog.isColorLevel()) {
                QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "notifySSORsp, mReceivedSSO:" + this.C);
            }
        }

        public void h(Context context, String str, JSONObject jSONObject, AppInterface appInterface) {
            try {
                if (jSONObject != null && context != null && appInterface != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "sendRequest, currentUrl:" + str + " requestJsonObj:requestJsonObj");
                    }
                    if (jSONObject.optInt("needCookie") == 1 && !TextUtils.isEmpty(str)) {
                        String r16 = SwiftBrowserCookieMonster.r(str);
                        if (!TextUtils.isEmpty(r16)) {
                            if (r16.indexOf(44) != -1) {
                                r16.replace(',', ';');
                            }
                            jSONObject.put("Cookie", r16);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "Get cookie:" + k.e(r16, new String[0]) + " from " + k.f(str, new String[0]));
                        }
                    }
                    WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
                    webSSOAgent$UniSsoServerReqComm.platform.set(109L);
                    webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
                    webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
                    WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
                    webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
                    jSONObject.remove("callback");
                    jSONObject.remove("cmd");
                    jSONObject.remove("needCookie");
                    jSONObject.remove("timeout");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("fingerprint", Build.FINGERPRINT);
                    jSONObject2.put("model", DeviceInfoMonitor.getModel());
                    jSONObject2.put("manufacturer", Build.MANUFACTURER);
                    jSONObject2.put("brand", Build.BRAND);
                    jSONObject2.put("device", Build.DEVICE);
                    jSONObject2.put("product", Build.PRODUCT);
                    jSONObject2.put("id", Build.ID);
                    jSONObject2.put("level", Build.VERSION.SDK_INT);
                    jSONObject2.put("cpu_abi", Build.CPU_ABI);
                    jSONObject2.put("cpu_abi2", Build.CPU_ABI2);
                    jSONObject.put("option", jSONObject2);
                    webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
                    NewIntent newIntent = new NewIntent(context, am.class);
                    newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, this.f336019d);
                    newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
                    newIntent.putExtra("extra_timeout", -1L);
                    newIntent.setObserver(this);
                    if (QLog.isColorLevel()) {
                        QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "uniAgent, req, send request to msf");
                    }
                    appInterface.startServlet(newIntent);
                    com.tencent.mobileqq.zplan.web.b bVar = this.D;
                    if (bVar != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.f336021f = currentTimeMillis;
                        bVar.f336025a = currentTimeMillis;
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "sendRequest, requestJsonObj:" + jSONObject + " context:" + context + " app:" + appInterface);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            try {
                this.f336023i = z16;
                this.f336022h = i(z16, bundle);
                this.C = true;
                if (QLog.isColorLevel()) {
                    QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "WebSSOTask, onReceive, isSuccess: " + z16 + " mResultJson:" + this.f336022h);
                }
                g();
                com.tencent.mobileqq.zplan.web.b bVar = this.D;
                if (bVar != null) {
                    bVar.f336026b = System.currentTimeMillis();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(ZPlanWebDataHandlerImpl.TAG, 2, "uniAgent, onReceive, Exception: " + e16.getMessage());
                }
            }
        }

        public String toString() {
            return "mSSOCmd:" + this.f336019d + " mPreloadTS:" + this.f336021f + " mIsSuccess:" + this.f336023i + " mReceivedSSO:" + this.C + " mResultJson:" + this.f336022h;
        }

        public void e(a aVar) {
            if (aVar != null) {
                this.f336024m.add(aVar);
            }
        }

        public JSONObject i(boolean z16, Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (z16) {
                    byte[] byteArray = bundle.getByteArray("extra_data");
                    if (byteArray != null) {
                        WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                        webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 0);
                        if (webSSOAgent$UniSsoServerRsp.ret.has()) {
                            long j3 = webSSOAgent$UniSsoServerRsp.ret.get();
                            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, j3);
                            if (QLog.isColorLevel()) {
                                QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "uniAgent, ret, biz ret code=" + j3);
                            }
                        } else {
                            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                        }
                        if (webSSOAgent$UniSsoServerRsp.errmsg.has()) {
                            String str = webSSOAgent$UniSsoServerRsp.errmsg.get();
                            jSONObject.put("msg", str);
                            if (QLog.isColorLevel()) {
                                QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "uniAgent, ret, errmsg=" + str);
                            }
                        } else {
                            jSONObject.put("msg", "SSO\u53d1\u9001\u6210\u529f");
                        }
                        if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
                            String str2 = webSSOAgent$UniSsoServerRsp.rspdata.get();
                            jSONObject.put("data", str2);
                            if (QLog.isColorLevel()) {
                                QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "uniAgent, ret, rspData=" + str2);
                            }
                        }
                    } else {
                        this.f336023i = false;
                        if (QLog.isColorLevel()) {
                            QLog.w(ZPlanWebDataHandlerImpl.TAG, 2, "uniAgent, onReceive, ret success but no data");
                        }
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 255);
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                        jSONObject.put("msg", "SSO\u8fd4\u56de\u6570\u636e\u5305\u4e3a\u7a7a");
                    }
                } else {
                    int i3 = bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE);
                    if (QLog.isColorLevel()) {
                        QLog.d(ZPlanWebDataHandlerImpl.TAG, 2, "uniAgent, msfResultCode=" + i3);
                    }
                    if (i3 == 1001) {
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 201);
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                        jSONObject.put("msg", HardCodeUtil.qqStr(R.string.jmz));
                    } else {
                        if (i3 != 1002 && i3 != 1013) {
                            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 255);
                            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                            jSONObject.put("msg", HardCodeUtil.qqStr(R.string.f171597jn0));
                        }
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 202);
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                        jSONObject.put("msg", HardCodeUtil.qqStr(R.string.jmw));
                    }
                }
                return jSONObject;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0126 A[Catch: Exception -> 0x014e, TryCatch #0 {Exception -> 0x014e, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x0027, B:10:0x0033, B:12:0x003a, B:15:0x004d, B:17:0x005c, B:19:0x0081, B:21:0x0092, B:23:0x0098, B:25:0x009e, B:27:0x00b9, B:28:0x00cd, B:30:0x00e2, B:33:0x0126, B:35:0x0141, B:36:0x0148, B:38:0x00fd, B:40:0x0103, B:41:0x010d, B:42:0x011d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean shouldInterceptSsoCmd(String str, WebViewPlugin webViewPlugin, String str2, AppInterface appInterface) {
        boolean z16;
        try {
            String apolloClientId = getApolloClientId(str);
            if (TextUtils.isEmpty(apolloClientId)) {
                colorLogD("doInterceptApollo false, url is:" + str + " no need preload");
                return false;
            }
            ApolloUrlInterceptor interceptor = getInterceptor(webViewPlugin.mRuntime.e());
            if (interceptor == null) {
                colorLogD("doInterceptApollo false, apolloSession is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("callback");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            String string2 = jSONObject.getString("cmd");
            if (!this.mSSOConfig.k(apolloClientId, string2)) {
                colorLogD("doInterceptApollo false, apolloClientId:" + apolloClientId + " cmd:" + string2 + ",mSSOConfig.isValidCmd:false");
                return false;
            }
            String l3 = this.mSSOConfig.l(apolloClientId, string2);
            b bVar = this.mPreloadSSODatas.get(l3);
            if (bVar != null) {
                if (!bVar.C) {
                    if (bVar.D != null) {
                        bVar.D.f336027c = System.currentTimeMillis();
                    }
                    bVar.e(new a(this, string, webViewPlugin));
                    colorLogD("doInterceptApolloCmd, has webSSOTask = true, but webSSOTask.mReceivedSSO:false, wait notify!");
                    z16 = false;
                    if (z16) {
                        com.tencent.mobileqq.zplan.web.b o16 = interceptor.o();
                        o16.f336027c = System.currentTimeMillis();
                        b bVar2 = new b(o16, l3, string2);
                        bVar2.e(new a(this, string, webViewPlugin));
                        WebViewPlugin.b bVar3 = webViewPlugin.mRuntime;
                        if (bVar3 != null) {
                            bVar2.h(bVar3.a(), str, jSONObject, appInterface);
                        }
                        this.mPreloadSSODatas.put(l3, bVar2);
                    }
                    return true;
                }
                if (bVar.f(string2)) {
                    colorLogD("doInterceptApolloCmd, webSSOTask.isValid true, mResultJson=" + bVar);
                    if (bVar.D != null) {
                        bVar.D.f336027c = System.currentTimeMillis();
                        bVar.D.f336028d = System.currentTimeMillis();
                    }
                    webViewPlugin.callJs(string, bVar.f336022h.toString());
                    this.mPreloadSSODatas.remove(l3);
                    return true;
                }
                colorLogD("doInterceptApolloCmd, webSSOTask.isValid false,webSSOTask:" + bVar);
                this.mPreloadSSODatas.remove(l3);
            } else {
                colorLogD("doInterceptApolloCmd, has webSSOTask = false,create webSSOTask!");
            }
            z16 = true;
            if (z16) {
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private ApolloUrlInterceptor getInterceptor(CustomWebView customWebView) {
        WebViewPluginEngine pluginEngine;
        WebViewPlugin m3;
        if (customWebView == null || (pluginEngine = customWebView.getPluginEngine()) == null || (m3 = pluginEngine.m("zplan")) == null || !(m3 instanceof ZPlanJsPluginImpl)) {
            return null;
        }
        return ((ZPlanJsPluginImpl) m3).getInterceptor();
    }

    public void resumeThunderCache() {
    }

    public void stopThunderCache() {
    }
}
