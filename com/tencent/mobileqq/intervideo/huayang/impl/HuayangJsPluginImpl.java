package com.tencent.mobileqq.intervideo.huayang.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.huayang.MonitorConfig;
import com.tencent.mobileqq.intervideo.od.ODAppJSPlugin;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class HuayangJsPluginImpl extends WebViewPlugin implements IHuayangJsPlugin {
    private static final String ACTION_BACK_NOTIFY = "com.tencent.mobileqq.intervideo.backPressed";
    private static final String ACTION_CACHE_USER_NOTIFY = "com.tencent.mobileqq.intervideo.userCacheState";
    private static final String ACTION_DOWNLOAD_NOTIFY = "com.tencent.mobileqq.intervideo.huayang.downloadPreLoad";
    private static final String ACTION_HY_LAUHCHER_NOTIFY = "com.tencent.mobileqq.huayang.launcher";
    public static final String ACTION_JS_CHECK_VERSION = "checkVersion";
    public static final String ACTION_JS_DOWNLOAD = "download";
    public static final String ACTION_JS_SIIENT_DOWNLOAD = "slientDownload";
    public static final String EXTRA_KEY_DOWNLOAD_PROGRESS = "key_progress";
    public static final String EXTRA_KEY_DOWNLOAD_TOTALSIZE = "key_totalSize";
    public static final String EXTRA_KEY_ERRORMSG = "key_error_msg";
    public static final String EXTRA_KEY_INSTALLED_PLUGIN = "key_installedplugin";
    public static final String EXTRA_KEY_ISCACHE = "key_isCache";
    public static final String EXTRA_KEY_SATTE = "key_state";
    public static final String NAMESPACE = "huayang";
    public static final int STATE_CHECK_VERSION = 0;
    public static final int STATE_DOWANLOADING = 1;
    public static final int STATE_DOWANLODAD_COMPLETE = 2;
    public static final int STATE_DOWANLODAD_FAILED = 3;
    public static final int STATE_LAUNCHERING = 8;
    public static final int STATE_LAUNCHER_FAILED = 10;
    public static final int STATE_LAUNCHER_SUCC = 9;
    public static final int STATE_LOADING = 4;
    public static final int STATE_LOAD_COMPLETE = 6;
    public static final int STATE_LOAD_FALIED = 7;
    public static final int STATE_PRELOAD_FALIED = 5;
    public static final int STATE_STOP_LOAD = 10;
    private static final String TAG = "HuayangJsPlugin";
    private String mAction;
    protected Context mContext;
    private int mCurrentProgress;
    protected String mJsNotifyCallback;
    private long mStartTime;
    private int mState;
    protected String pluginPackageName;
    protected com.tencent.biz.troop.b mClient = null;
    private String appType = null;
    private int mCacheUserState = -1;
    protected BroadcastReceiver mHuayangPluginBroadcastReceiver = new a();
    private Handler mUIHandler = new b(Looper.getMainLooper());

    /* loaded from: classes33.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:20:0x009a. Please report as an issue. */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb5;
            String str;
            String action = intent.getAction();
            if (!action.equals(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(HuayangJsPluginImpl.this.pluginPackageName)) && !action.equals(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getLauncherNotifyAction(HuayangJsPluginImpl.this.pluginPackageName))) {
                if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(HuayangJsPluginImpl.this.pluginPackageName).equals(action)) {
                    Activity a16 = HuayangJsPluginImpl.this.mRuntime.a();
                    if (a16 instanceof BaseActivity) {
                        ((BaseActivity) a16).doOnBackPressed();
                        return;
                    } else {
                        a16.onBackPressed();
                        return;
                    }
                }
                if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getCacheUserNotifyAction(HuayangJsPluginImpl.this.pluginPackageName).equals(action)) {
                    HuayangJsPluginImpl.this.mCacheUserState = intent.getIntExtra("key_isCache", -1);
                    return;
                }
                return;
            }
            int intExtra = intent.getIntExtra("key_state", -1);
            HuayangJsPluginImpl.this.mState = intExtra;
            JSONObject callJsStateJson = HuayangJsPluginImpl.this.getCallJsStateJson(intExtra);
            switch (intExtra) {
                case 0:
                    long longExtra = intent.getLongExtra("key_totalSize", 0L);
                    HuayangJsPluginImpl.this.log("size:" + longExtra);
                    try {
                        callJsStateJson.putOpt("totalSize", Long.valueOf(longExtra));
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    callJsStateJson.remove("state");
                    HuayangJsPluginImpl huayangJsPluginImpl = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl.callJs(huayangJsPluginImpl.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 1:
                case 4:
                    int intExtra2 = intent.getIntExtra("key_progress", 0);
                    long longExtra2 = intent.getLongExtra("key_totalSize", 0L);
                    HuayangJsPluginImpl huayangJsPluginImpl2 = HuayangJsPluginImpl.this;
                    if (intExtra == 1) {
                        sb5 = new StringBuilder();
                        str = "progress:STATE_DOWANLOADING:";
                    } else {
                        sb5 = new StringBuilder();
                        str = "progress:STATE_LOADING:";
                    }
                    sb5.append(str);
                    sb5.append(intExtra2);
                    huayangJsPluginImpl2.log(sb5.toString());
                    if (intExtra == 4) {
                        if (intExtra2 <= 90) {
                            return;
                        } else {
                            HuayangJsPluginImpl.this.mUIHandler.removeCallbacksAndMessages(null);
                        }
                    }
                    try {
                        callJsStateJson.putOpt("totalSize", Long.valueOf(longExtra2));
                        callJsStateJson.putOpt(WadlResult.WEB_KEY_PROGRESS, Integer.valueOf(intExtra2));
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                    HuayangJsPluginImpl huayangJsPluginImpl3 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl3.callJs(huayangJsPluginImpl3.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 2:
                    HuayangJsPluginImpl.this.log("STATE_DOWANLODAD_COMPLETE");
                    Message obtain = Message.obtain();
                    if (HuayangJsPluginImpl.this.mCacheUserState == 1) {
                        obtain.arg1 = 40;
                    } else {
                        obtain.arg1 = 0;
                    }
                    if (!TextUtils.equals(HuayangJsPluginImpl.this.mAction, "checkVersion")) {
                        HuayangJsPluginImpl.this.mCurrentProgress = 0;
                        HuayangJsPluginImpl.this.mUIHandler.sendMessage(obtain);
                    }
                    HuayangJsPluginImpl huayangJsPluginImpl32 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl32.callJs(huayangJsPluginImpl32.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 3:
                    HuayangJsPluginImpl.this.log("STATE_DOWANLODAD_FAILED");
                    HuayangJsPluginImpl huayangJsPluginImpl322 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl322.callJs(huayangJsPluginImpl322.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 5:
                    HuayangJsPluginImpl.this.log("STATE_PRELOAD_FALIED");
                    HuayangJsPluginImpl huayangJsPluginImpl3222 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl3222.callJs(huayangJsPluginImpl3222.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 6:
                    HuayangJsPluginImpl.this.log("STATE_LOAD_COMPLETE");
                    HuayangJsPluginImpl huayangJsPluginImpl32222 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl32222.callJs(huayangJsPluginImpl32222.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 7:
                    HuayangJsPluginImpl.this.log("STATE_LOAD_FALIED");
                    HuayangJsPluginImpl huayangJsPluginImpl322222 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl322222.callJs(huayangJsPluginImpl322222.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 8:
                    HuayangJsPluginImpl.this.log("STATE_LAUNCHERING");
                    HuayangJsPluginImpl huayangJsPluginImpl3222222 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl3222222.callJs(huayangJsPluginImpl3222222.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 9:
                    HuayangJsPluginImpl.this.log("STATE_LAUNCHER_SUCC");
                    HuayangJsPluginImpl huayangJsPluginImpl32222222 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl32222222.callJs(huayangJsPluginImpl32222222.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                case 10:
                    HuayangJsPluginImpl.this.log("STATE_LAUNCHER_FAILED");
                    HuayangJsPluginImpl huayangJsPluginImpl322222222 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl322222222.callJs(huayangJsPluginImpl322222222.mJsNotifyCallback, callJsStateJson.toString());
                    return;
                default:
                    HuayangJsPluginImpl huayangJsPluginImpl3222222222 = HuayangJsPluginImpl.this;
                    huayangJsPluginImpl3222222222.callJs(huayangJsPluginImpl3222222222.mJsNotifyCallback, callJsStateJson.toString());
                    return;
            }
        }
    }

    /* loaded from: classes33.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.arg1;
            if (i3 < HuayangJsPluginImpl.this.mCurrentProgress || i3 > 95) {
                return;
            }
            HuayangJsPluginImpl.this.mCurrentProgress = i3;
            HuayangJsPluginImpl.this.log("STATE_Loading:" + i3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("state", 4);
                jSONObject.putOpt("totalSize", 100);
                jSONObject.putOpt(WadlResult.WEB_KEY_PROGRESS, Integer.valueOf(i3));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            HuayangJsPluginImpl huayangJsPluginImpl = HuayangJsPluginImpl.this;
            huayangJsPluginImpl.callJs(huayangJsPluginImpl.mJsNotifyCallback, jSONObject.toString());
            Message obtain = Message.obtain();
            obtain.arg1 = i3 + 5;
            sendMessageDelayed(obtain, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject getCallJsStateJson(int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("state", Integer.valueOf(i3));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    private void unregisterBroadcast() {
        try {
            this.mContext.unregisterReceiver(this.mHuayangPluginBroadcastReceiver);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin
    public String getBackNotifyAction(String str) {
        return ACTION_BACK_NOTIFY + str;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin
    public String getCacheUserNotifyAction(String str) {
        return ACTION_CACHE_USER_NOTIFY + str;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin
    public String getDownloadNotifyAction(String str) {
        return ACTION_DOWNLOAD_NOTIFY + str;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin
    public String getLauncherNotifyAction(String str) {
        return ACTION_HY_LAUHCHER_NOTIFY + str;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "huayang";
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin
    public boolean isHyPkg(String str) {
        return TextUtils.equals(str, "com.tencent.huayang");
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin
    public boolean isODPkg(String str) {
        return TextUtils.equals(str, "com.tencent.od");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.mClient = A;
        A.p();
        this.mContext = this.mRuntime.a().getApplicationContext();
        log(" onCreate");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        com.tencent.biz.troop.b bVar = this.mClient;
        if (bVar != null) {
            bVar.i(this.pluginPackageName, this.appType);
            this.mClient.q();
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " onDestroy");
        }
        Monitor.d("2597860");
        unregisterBroadcast();
        this.mUIHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0117  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        JSONObject jSONObject;
        String optString;
        String optString2;
        long optInt;
        if (!"huayang".equals(str2) && !ODAppJSPlugin.NAMESPACE.equals(str2)) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleJsRequest: method:");
        sb5.append(str3);
        sb5.append(" args:");
        if (strArr != null && strArr.length > 0) {
            str4 = strArr[0];
        } else {
            str4 = "";
        }
        sb5.append(str4);
        log(sb5.toString());
        if ("open".equals(str3)) {
            Monitor.d("2490057");
            if (strArr == null || strArr.length <= 0) {
                str5 = null;
                str6 = null;
                str7 = null;
            } else {
                try {
                    jSONObject = new JSONObject(strArr[0]);
                    str8 = jSONObject.optString("opentype");
                } catch (JSONException e16) {
                    e = e16;
                    str8 = null;
                    str9 = null;
                }
                try {
                    str9 = jSONObject.optString(LayoutAttrDefine.CLICK_URI);
                    try {
                        this.mJsNotifyCallback = jSONObject.optString("notifyJsCallback");
                        this.mAction = jSONObject.optString("action");
                        this.pluginPackageName = jSONObject.optString("pluginPackageName");
                        str10 = jSONObject.optString("pluginData");
                    } catch (JSONException e17) {
                        e = e17;
                        str10 = null;
                    }
                } catch (JSONException e18) {
                    e = e18;
                    str9 = null;
                    str10 = str9;
                    if (QLog.isColorLevel()) {
                    }
                    ((IHuayangCrashReport) QRoute.api(IHuayangCrashReport.class)).report(e);
                    if (TextUtils.isEmpty(this.pluginPackageName)) {
                    }
                    IntentFilter intentFilter = new IntentFilter(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(this.pluginPackageName));
                    intentFilter.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(this.pluginPackageName));
                    intentFilter.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getCacheUserNotifyAction(this.pluginPackageName));
                    intentFilter.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getLauncherNotifyAction(this.pluginPackageName));
                    this.mContext.registerReceiver(this.mHuayangPluginBroadcastReceiver, intentFilter);
                    str5 = str8;
                    str6 = str9;
                    str7 = str10;
                    this.mStartTime = System.currentTimeMillis();
                    this.mClient.a0(this.appType, str5, str6, this.mAction, this.pluginPackageName, str7);
                    id0.a.n("huayang", "openPlugin", this.mState, (int) (System.currentTimeMillis() - this.mStartTime), this.mAction, null, this.pluginPackageName, AppSetting.f99551k);
                    return true;
                }
                try {
                    this.appType = jSONObject.optString("appType");
                    optString = jSONObject.optString("monitorId");
                    optString2 = jSONObject.optString("frameAction");
                    optInt = jSONObject.optInt("fromId");
                } catch (JSONException e19) {
                    e = e19;
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e, new Object[0]);
                    }
                    ((IHuayangCrashReport) QRoute.api(IHuayangCrashReport.class)).report(e);
                    if (TextUtils.isEmpty(this.pluginPackageName)) {
                    }
                    IntentFilter intentFilter2 = new IntentFilter(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(this.pluginPackageName));
                    intentFilter2.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(this.pluginPackageName));
                    intentFilter2.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getCacheUserNotifyAction(this.pluginPackageName));
                    intentFilter2.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getLauncherNotifyAction(this.pluginPackageName));
                    this.mContext.registerReceiver(this.mHuayangPluginBroadcastReceiver, intentFilter2);
                    str5 = str8;
                    str6 = str9;
                    str7 = str10;
                    this.mStartTime = System.currentTimeMillis();
                    this.mClient.a0(this.appType, str5, str6, this.mAction, this.pluginPackageName, str7);
                    id0.a.n("huayang", "openPlugin", this.mState, (int) (System.currentTimeMillis() - this.mStartTime), this.mAction, null, this.pluginPackageName, AppSetting.f99551k);
                    return true;
                }
                if (!TextUtils.isEmpty(optString2)) {
                    Intent intent = new Intent(this.mContext, (Class<?>) ODLoadingActivity.class);
                    intent.putExtra("fromId", optInt);
                    intent.putExtra("bizType", this.appType);
                    intent.putExtra("pluginPackageName", this.pluginPackageName);
                    intent.putExtra("pluginData", str10);
                    intent.putExtra("action", this.mAction);
                    intent.putExtra(LayoutAttrDefine.CLICK_URI, str9);
                    intent.setFlags(268435456);
                    this.mContext.startActivity(intent);
                    return true;
                }
                MonitorConfig.d(this.mContext, this.appType, optString);
                if (str9 != null) {
                    try {
                        str9 = URLDecoder.decode(str9, "UTF-8");
                    } catch (UnsupportedEncodingException e26) {
                        e26.printStackTrace();
                        str9 = null;
                    }
                }
                if (TextUtils.isEmpty(this.pluginPackageName)) {
                    this.pluginPackageName = "com.tencent.huayang";
                }
                IntentFilter intentFilter22 = new IntentFilter(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(this.pluginPackageName));
                intentFilter22.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(this.pluginPackageName));
                intentFilter22.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getCacheUserNotifyAction(this.pluginPackageName));
                intentFilter22.addAction(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getLauncherNotifyAction(this.pluginPackageName));
                this.mContext.registerReceiver(this.mHuayangPluginBroadcastReceiver, intentFilter22);
                str5 = str8;
                str6 = str9;
                str7 = str10;
            }
            this.mStartTime = System.currentTimeMillis();
            this.mClient.a0(this.appType, str5, str6, this.mAction, this.pluginPackageName, str7);
            id0.a.n("huayang", "openPlugin", this.mState, (int) (System.currentTimeMillis() - this.mStartTime), this.mAction, null, this.pluginPackageName, AppSetting.f99551k);
            return true;
        }
        if ("cancelPage".equals(str3)) {
            this.mClient.i(this.pluginPackageName, this.appType);
            if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(this.pluginPackageName)) {
                Monitor.d("2691702");
            } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(this.pluginPackageName)) {
                Monitor.d("2597719");
            } else if (MonitorConfig.f238245i.get(this.appType) != null) {
                Monitor.b(String.valueOf(MonitorConfig.f238245i.get(this.appType).f238253h));
            }
            unregisterBroadcast();
            id0.a.n("huayang", "cancelPage", this.mState, (int) (System.currentTimeMillis() - this.mStartTime), String.valueOf(this.mCacheUserState), null, this.pluginPackageName, AppSetting.f99551k);
        } else if ("openWithLoading".equals(str3)) {
            Intent intent2 = new Intent(this.mContext, (Class<?>) ODLoadingActivity.class);
            intent2.setFlags(268435456);
            intent2.putExtra("param_general", strArr[0]);
            this.mContext.startActivity(intent2);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin
    public WebViewPlugin init() {
        return this;
    }
}
