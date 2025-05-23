package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.pluginshare.ITenCookie;
import cooperation.vip.manager.MonitorManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class QWalletPayJsPlugin extends VasWebviewJsPlugin {
    private static final String METHOD_NAME_OPENSUPERVIP = "openSuperVip";
    private static final String METHOD_NAME_QWALLETBRIDGE = "qWalletBridge";
    public static final String OBJECT_NAME_NEW = "qw.pay";
    public static final String OBJECT_NAME_NEW_COMPATIBLE_IOS = "qw_pay";
    private static final String OBJECT_NAME_OLD = "pay";
    private static final String TAG = "QWalletPayJsHandler";
    public static SparseArray<String> mFirstUrls = new SparseArray<>();
    public static ArrayList<Integer> mSequence = new ArrayList<>();
    private String mCallback;
    protected long mReceiveRequestTime;
    private QWalletPayJsPluginResultReceiver mRecevicer;
    private QWalletPayJsPluginResultReceiver mRecevicerNeedFinish;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes20.dex */
    public static class QWalletPayJsPluginResultReceiver extends ResultReceiver {
        protected QWalletPayJsPlugin mJsPlugin;
        protected boolean mNeedFinish;

        public QWalletPayJsPluginResultReceiver(QWalletPayJsPlugin qWalletPayJsPlugin, Handler handler, boolean z16) {
            super(handler);
            this.mJsPlugin = qWalletPayJsPlugin;
            this.mNeedFinish = z16;
        }

        protected void onDestroy() {
            this.mJsPlugin = null;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i(QWalletPayJsPlugin.TAG, 2, "resultCode = " + i3 + " resultData = " + bundle);
            }
            QWalletPayJsPlugin qWalletPayJsPlugin = this.mJsPlugin;
            if (qWalletPayJsPlugin != null && bundle != null) {
                Activity a16 = qWalletPayJsPlugin.mRuntime.a();
                if (a16 != null) {
                    JSONObject grapHbResult = ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getGrapHbResult(i3, bundle, a16);
                    if (grapHbResult != null) {
                        this.mJsPlugin.doCallback(grapHbResult.toString());
                    }
                    QLog.d(QWalletPayJsPlugin.TAG, 4, "activity.isFinishing():" + a16.isFinishing());
                    if (this.mNeedFinish && !a16.isFinishing()) {
                        a16.finish();
                        return;
                    }
                    return;
                }
                QLog.i(QWalletPayJsPlugin.TAG, 1, "mJsPlugin.mActivity == null");
            }
        }
    }

    private void doCallback(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        callJs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorJsData(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ret", -1111);
            jSONObject.putOpt("msg", str);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, str2 + " create errorJson error: " + e16);
        }
        return jSONObject.toString();
    }

    private void getHbResult(JSONObject jSONObject) throws Exception {
        String optString = jSONObject.optString("listid");
        String optString2 = jSONObject.optString("uin", "");
        if (!StringUtil.isEmpty(optString) && optString2.equals(this.mRuntime.c().getCurrentAccountUin())) {
            String tempArgs = ((ITenCookie) QRoute.api(ITenCookie.class)).getTempArgs(optString);
            if (StringUtil.isEmpty(tempArgs)) {
                tempArgs = SharedPreferencesProxyManager.getInstance().getProxy("common_h5_hb_info" + optString2, 0).getString(optString, "");
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getHbResult dataStr: " + tempArgs);
            }
            JSONObject jSONObject2 = new JSONObject(tempArgs);
            if (jSONObject2.has("detail_data")) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("retcode", 0);
                jSONObject3.put("retmsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject3.put("detail_data", jSONObject2.optJSONObject("detail_data"));
                doCallback(jSONObject3.toString());
                return;
            }
            if (jSONObject2.has("exception_data")) {
                doCallback(jSONObject2.optString("exception_data"));
                return;
            } else {
                handJsError("-1001", "params error, detail_data is empty");
                return;
            }
        }
        handJsError("-1001", "params error,listid is empty or is not current user");
    }

    private String getIapDataByCache(@NonNull Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra("iapData");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        return getErrorJsData("no data in cache", "iapData");
    }

    public static String getPayAppInfo() {
        ArrayList<Integer> arrayList;
        String str;
        int indexOf;
        if (mFirstUrls != null && (arrayList = mSequence) != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Integer num = mSequence.get(size);
                if (num != null) {
                    str = mFirstUrls.get(num.intValue());
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("qqwallet_appinfo=")) != -1) {
                    int i3 = indexOf + 17;
                    int indexOf2 = str.indexOf(38, i3);
                    if (indexOf2 == -1) {
                        indexOf2 = str.length();
                    }
                    return str.substring(i3, indexOf2);
                }
            }
            return "";
        }
        return "";
    }

    private String getTenpayDataByCache(@NonNull Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra("tenpayData");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        return getErrorJsData("no data in cache", "tenpayData");
    }

    private void grapH5CommonHb(JSONObject jSONObject, ResultReceiver resultReceiver) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "grapH5CommonHb params: " + jSONObject);
            }
            JSONObject extraDataForGrapH5CommonHbResult = ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getExtraDataForGrapH5CommonHbResult(jSONObject);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "grapH5CommonHb extraData: " + extraDataForGrapH5CommonHbResult);
            }
            if (extraDataForGrapH5CommonHbResult != null) {
                WebViewPlugin.b bVar = this.mRuntime;
                if (bVar != null && bVar.e() != null && this.mRuntime.e().getUrl() != null) {
                    extraDataForGrapH5CommonHbResult.put("domain", new URL(this.mRuntime.e().getUrl()).getHost());
                }
                ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getGrapH5CommonHbResult(extraDataForGrapH5CommonHbResult.toString(), resultReceiver);
                return;
            }
            handJsError("-1001", QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
        } catch (Throwable th5) {
            handJsError("-1001", th5.getLocalizedMessage());
        }
    }

    private void handJsError(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handJsError: " + str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retcode", str);
            jSONObject.put("retmsg", str2);
            doCallback(jSONObject.toString());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private boolean openSuperVip(String str) {
        String str2;
        CustomWebView e16 = this.mRuntime.e();
        if (e16 != null) {
            str2 = e16.getUrl();
        } else {
            str2 = "";
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                str2 = URLEncoder.encode(str2, "utf-8");
            }
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                e17.printStackTrace();
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("data");
            String string2 = jSONObject.getString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "HandleUrl params objectName=qw.pay,methodName=openSuperVip,jsonParams=" + str);
            }
            Bundle bundle = new Bundle();
            bundle.putString(ark.ARKMETADATA_JSON, string);
            bundle.putString("callbackSn", string2);
            bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
            bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.mReceiveRequestTime);
            bundle.putString("payparmas_h5_url", str2);
            PayBridgeActivity.tenpay(this.mRuntime.a(), 11, bundle);
            return true;
        } catch (JSONException e18) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "jsonParams JSONException,jsonParams=" + str);
            }
            e18.printStackTrace();
            return false;
        }
    }

    private void parseCallback(String str) {
        if (!TextUtils.isEmpty(str) && str.toLowerCase().indexOf("callback") >= 0) {
            try {
                this.mCallback = new JSONObject(str).optString("callback");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    private boolean qWalletBridge(String str) {
        JSONObject jSONObject;
        String optString;
        JSONObject optJSONObject;
        QWalletPayJsPluginResultReceiver qWalletPayJsPluginResultReceiver;
        try {
            jSONObject = new JSONObject(str);
            optString = jSONObject.optString("action");
            optJSONObject = jSONObject.optJSONObject("params");
        } catch (Exception e16) {
            handJsError("-1001", "params exception: " + e16.getLocalizedMessage());
        }
        if (optJSONObject == null) {
            return false;
        }
        if (jSONObject.optInt("closeWebView") == 1) {
            qWalletPayJsPluginResultReceiver = this.mRecevicerNeedFinish;
        } else {
            qWalletPayJsPluginResultReceiver = this.mRecevicer;
        }
        if ("graphb".equals(optString)) {
            grapH5CommonHb(optJSONObject, qWalletPayJsPluginResultReceiver);
        } else if ("getHbResult".equals(optString)) {
            getHbResult(optJSONObject);
        } else if ("refreshHbDetail".equals(optString)) {
            try {
                ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getHbDetailInfo(optJSONObject, "redgiftH5CommonDetail", qWalletPayJsPluginResultReceiver);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        } else {
            handJsError("-1001", "params exception: no match action");
        }
        return true;
    }

    private void requestIapDataByNet(@NonNull final Activity activity, @NonNull final String str) {
        ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).queryQbData(activity, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin.2
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(String str2) {
                if (activity.isFinishing()) {
                    QWalletPayJsPlugin qWalletPayJsPlugin = QWalletPayJsPlugin.this;
                    qWalletPayJsPlugin.callJs(str, qWalletPayJsPlugin.getErrorJsData("activity is finishing", "iapData"));
                    return Unit.INSTANCE;
                }
                QWalletPayJsPlugin.this.callJs(str, str2);
                return Unit.INSTANCE;
            }
        });
    }

    private void requestTenpayDataByNet(@NonNull Activity activity, @NonNull final String str) {
        String currentAccountUin = this.mRuntime.c().getCurrentAccountUin();
        if (TextUtils.isEmpty(currentAccountUin)) {
            callJs(str, getErrorJsData("uin is empty", "tenpayData"));
            return;
        }
        ResultReceiver resultReceiver = new ResultReceiver(null) { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                super.onReceiveResult(i3, bundle);
                QWalletPayJsPlugin.this.callJs(str, bundle.getString("retmsg"));
            }
        };
        HashMap hashMap = new HashMap();
        hashMap.put(j.T0, "appid#0|bargainor_id#0|channel#wallet_accountpage");
        ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).requestData(activity, "qwallet", currentAccountUin, hashMap, resultReceiver);
    }

    public void buyGoods(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "buyGoods requet params json=" + jSONObject.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
        bundle.putString("callbackSn", str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.mReceiveRequestTime);
        PayBridgeActivity.tenpay(this.mRuntime.a(), 7, bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return OBJECT_NAME_NEW;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 32L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        Integer num;
        if (8589934600L == j3 && (num = (Integer) map.get("requestCode")) != null && num.intValue() == 11) {
            Intent intent = (Intent) map.get("data");
            StringBuilder sb5 = new StringBuilder();
            if (intent != null) {
                String stringExtra = intent.getStringExtra("callbackSn");
                String stringExtra2 = intent.getStringExtra("result");
                callJs("qw.bridge.publicTube('" + stringExtra + "', '{\"code\":0, \"msg\":\"ok\", \"data\":" + stringExtra2 + "}')");
                sb5.append("result : ");
                sb5.append(stringExtra2);
            }
            MonitorManager.f().j(1, 2, "\u4f1a\u5458\uff1a\u8fd4\u56de\u652f\u4ed8\u7ed3\u679c", sb5.toString());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && strArr != null && strArr.length > 0) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleJsRequeste pkgName :");
                sb5.append(str2);
                sb5.append(" method: ");
                sb5.append(str3);
                if (strArr.length <= 0) {
                    str4 = "";
                } else {
                    str4 = " arg: " + strArr[0];
                }
                sb5.append(str4);
                QLog.i(TAG, 2, sb5.toString());
            }
            this.mReceiveRequestTime = System.currentTimeMillis();
            if (!OBJECT_NAME_NEW.equals(str2) && !OBJECT_NAME_NEW_COMPATIBLE_IOS.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "can not handle objectname:" + str2);
                }
            } else {
                if (METHOD_NAME_OPENSUPERVIP.equals(str3)) {
                    MonitorManager.f().j(1, 1, "\u4f1a\u5458\uff1a\u8c03\u7528\u652f\u4ed8\u652f\u4ed8sdk", "");
                    return openSuperVip(strArr[0]);
                }
                if ("qWalletBridge".equals(str3)) {
                    parseCallback(strArr[0]);
                    return qWalletBridge(strArr[0]);
                }
                if ("tenpayData".equals(str3)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strArr[0]);
                        if ("qwallet".equals(jSONObject.optString("tag"))) {
                            tenpayData(jSONObject);
                        }
                    } catch (JSONException e16) {
                        QLog.e(TAG, 1, "tenpayData create json error: " + e16);
                    }
                } else if ("iapData".equals(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(strArr[0]);
                        if ("qcoin".equals(jSONObject2.optString("tag"))) {
                            iapData(jSONObject2);
                        }
                    } catch (JSONException e17) {
                        QLog.e(TAG, 1, "iapData create json error: " + e17);
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        return handleThemeAndBubbleSchemaRequest(str, str2, "pay");
    }

    public void iapData(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        String optString = jSONObject.optString("callback");
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            callJs(optString, getErrorJsData("activity is null", "iapData"));
        } else if (optJSONObject != null && optJSONObject.optInt("is_from_cache", 0) == 1) {
            callJs(optString, getIapDataByCache(a16));
        } else {
            requestIapDataByNet(a16, optString);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            this.mRecevicer = new QWalletPayJsPluginResultReceiver(this, new Handler(), false);
            this.mRecevicerNeedFinish = new QWalletPayJsPluginResultReceiver(this, new Handler(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            Activity a16 = this.mRuntime.a();
            mFirstUrls.remove(a16.hashCode());
            mSequence.remove(Integer.valueOf(a16.hashCode()));
        }
        QWalletPayJsPluginResultReceiver qWalletPayJsPluginResultReceiver = this.mRecevicer;
        if (qWalletPayJsPluginResultReceiver != null) {
            qWalletPayJsPluginResultReceiver.onDestroy();
        }
        QWalletPayJsPluginResultReceiver qWalletPayJsPluginResultReceiver2 = this.mRecevicerNeedFinish;
        if (qWalletPayJsPluginResultReceiver2 != null) {
            qWalletPayJsPluginResultReceiver2.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        Activity a16;
        Intent intent;
        super.onWebViewCreated(customWebView);
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null && (intent = (a16 = this.mRuntime.a()).getIntent()) != null) {
            String stringExtra = intent.getStringExtra("homepage");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("url");
            }
            if (stringExtra != null) {
                mFirstUrls.append(a16.hashCode(), stringExtra);
                mSequence.add(0, Integer.valueOf(a16.hashCode()));
            }
        }
    }

    public void openService(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "openService requet params json=" + jSONObject.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
        bundle.putString("callbackSn", str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.mReceiveRequestTime);
        PayBridgeActivity.tenpay(this.mRuntime.a(), 4, bundle);
    }

    public void openTenpayView(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "openTenpayView requet params json=" + jSONObject.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
        bundle.putString("callbackSn", str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.mReceiveRequestTime);
        PayBridgeActivity.tenpay(this.mRuntime.a(), 5, bundle);
    }

    public void pay(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "pay requet params json=" + jSONObject.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
        bundle.putString("callbackSn", str);
        bundle.putString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY, getPayAppInfo());
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.mReceiveRequestTime);
        PayBridgeActivity.tenpay(this.mRuntime.a(), 9, bundle);
    }

    public void rechargeGameCurrency(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "rechargeCurrency requet params json=" + jSONObject.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
        bundle.putString("callbackSn", str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.mReceiveRequestTime);
        PayBridgeActivity.tenpay(this.mRuntime.a(), 6, bundle);
    }

    public void rechargeQb(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "rechargeQb requet params json=" + jSONObject.toString());
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
        bundle.putString("callbackSn", str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, this.mReceiveRequestTime);
        PayBridgeActivity.tenpay(this.mRuntime.a(), 8, bundle);
    }

    public void tenpayData(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        String optString = jSONObject.optString("callback");
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            callJs(optString, getErrorJsData("activity is null", "tenpayData"));
        } else if (optJSONObject != null && optJSONObject.optInt("is_from_cache", 0) == 1) {
            callJs(optString, getTenpayDataByCache(a16));
        } else {
            requestTenpayDataByNet(a16, optString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doCallback: " + str);
        }
        doCallback(this.mCallback, str);
    }
}
