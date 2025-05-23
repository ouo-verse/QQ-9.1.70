package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BaseJsCallBack extends BaseInterface {
    public static final String LOG_TAG = "BaseJsCallBack";
    public static final String PLUGIN_NAMESPACE = "qqZoneAppList";
    public static boolean isUpdateAssets = false;
    protected Activity activity;
    protected Handler mHandler;
    private RemoteServiceProxy mRemoteServiceProxy;
    protected String urlParams = "";
    public String timePointParams = "";
    e lastActionRecord = null;

    public BaseJsCallBack(Activity activity) {
        if (activity instanceof PluginBaseActivity) {
            this.activity = ((PluginBaseActivity) activity).getOutActivity();
        } else {
            this.activity = activity;
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRemoteServiceProxy = RemoteServiceProxy.e(String.valueOf(com.tencent.open.adapter.a.f().l()));
    }

    public boolean appIsExists(String str) {
        return com.tencent.open.business.base.a.a(str);
    }

    public String appIsExistsBatch(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String[] split = str.split(str2);
        if (split.length == 0) {
            return "";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str3 : split) {
            if (str3 != null && str3.length() > 0) {
                if (com.tencent.open.business.base.a.a(str3)) {
                    linkedHashMap.put(str3, 1);
                } else {
                    linkedHashMap.put(str3, 0);
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            sb5.append(((Map.Entry) it.next()).getValue());
            sb5.append(str2);
        }
        if (sb5.length() == 0) {
            return "";
        }
        com.tencent.open.base.f.a(LOG_TAG, "appIsExistsBatch >>>" + sb5.substring(0, sb5.length() - 1));
        return sb5.substring(0, sb5.length() - 1);
    }

    public void back() {
        this.activity.finish();
    }

    public void cgiReport(String str, String str2, String str3) {
        try {
            long parseLong = Long.parseLong(str2);
            ReportManager.h().j(str, SystemClock.elapsedRealtime() - parseLong, 0L, 0L, Integer.parseInt(str3), com.tencent.open.adapter.a.f().l(), "1000002", null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void changeLoadingTip(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.tencent.open.appcommon.js.BaseJsCallBack.6
            @Override // java.lang.Runnable
            public void run() {
                boolean equals = str.equals("1");
                if (BaseJsCallBack.this.mRemoteServiceProxy != null) {
                    SendMsg sendMsg = new SendMsg("changeLoadingTip");
                    sendMsg.f390391e.putBoolean("showLoadingView", equals);
                    BaseJsCallBack.this.mRemoteServiceProxy.h(sendMsg);
                }
            }
        });
    }

    public void clearJS() {
        com.tencent.open.base.f.c(LOG_TAG, "clearJS");
        if (this.mRemoteServiceProxy != null) {
            this.mRemoteServiceProxy.h(new SendMsg("clearJS"));
        }
    }

    public int getAPNType() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity");
        int i3 = -1;
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        try {
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type == 0) {
                if (NetworkMonitor.netGetExInfo(activeNetworkInfo) == null) {
                    i3 = 2;
                }
                if (!NetworkMonitor.netGetExInfo(activeNetworkInfo).toLowerCase(Locale.ENGLISH).equals("cmnet")) {
                    return 2;
                }
                return 3;
            }
            if (type != 1) {
                return -1;
            }
            return 1;
        } catch (Exception e16) {
            com.tencent.open.base.f.d(LOG_TAG, "getAPNType EX >>> ", e16);
            return i3;
        }
    }

    public String getAgentVersion() {
        return com.tencent.open.adapter.a.f().b();
    }

    public String getAppVersionCode(String str) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("appid");
            if (com.tencent.open.business.base.a.a(optString)) {
                i3 = com.tencent.open.business.base.a.g(optString);
            } else {
                i3 = 0;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installedVersionCode", i3);
            jSONObject2.put("downloadedVersionCode ", com.tencent.open.business.base.a.h(DownloadManager.C().v(optString2)));
            return jSONObject2.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public String getAppVersionCodeBatch(String str) {
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i16);
                if (optJSONObject != null) {
                    String string = optJSONObject.getString("packageName");
                    String string2 = optJSONObject.getString("appid");
                    if (com.tencent.open.business.base.a.a(string)) {
                        i3 = com.tencent.open.business.base.a.g(string);
                    } else {
                        i3 = 0;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("installedVersionCode", i3);
                    jSONObject2.put("downloadedVersionCode", com.tencent.open.business.base.a.h(DownloadManager.C().v(string2)));
                    jSONObject.put(string2, jSONObject2);
                }
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d(LOG_TAG, "getAppVersionCode ", e16);
        }
        return jSONObject.toString();
    }

    public String getCurrentVersion() {
        return com.tencent.open.adapter.a.f().d();
    }

    public String getDisplay() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels + HippyTKDListViewAdapter.X + displayMetrics.heightPixels;
    }

    protected String[] getFileUrl(String str) {
        return Common.h(str);
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public String getInterfaceName() {
        return PLUGIN_NAMESPACE;
    }

    public String getMobileInfo() {
        return MobileInfoUtil.getMobileInfo();
    }

    public String getPageTimePoint() {
        return this.timePointParams;
    }

    public String getParams() {
        return this.urlParams;
    }

    public String getPlatform() {
        return com.tencent.open.adapter.a.f().h();
    }

    public String getSid() {
        if (!hasRight()) {
            return "baby,you don't have permission";
        }
        return com.tencent.open.adapter.a.f().k();
    }

    public String getUin() {
        if (!hasRight()) {
            return "baby,you don't have permission";
        }
        return String.valueOf(com.tencent.open.adapter.a.f().l());
    }

    public void goOldDetail(String str) {
        AppClient.h(this.activity, str);
    }

    public void goToDetailPage(String str, String str2) {
        com.tencent.open.base.f.a("TIME-STATISTIC", "JsCallBack--goToDetailPage");
        try {
            JSONObject jSONObject = new JSONObject(str);
            final Bundle bundle = new Bundle();
            bundle.putString(com.tencent.open.downloadnew.e.f341493b, jSONObject.optString("appid"));
            bundle.putString(com.tencent.open.downloadnew.e.f341497f, jSONObject.optString("packageName"));
            bundle.putString(com.tencent.open.downloadnew.e.f341500i, jSONObject.optString("via"));
            bundle.putString(com.tencent.open.downloadnew.e.f341494c, jSONObject.optString("myAppId"));
            bundle.putString(com.tencent.open.downloadnew.e.f341495d, jSONObject.optString("apkId"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341496e, jSONObject.optInt("versionCode"));
            String optString = jSONObject.optString("via");
            String optString2 = jSONObject.optString("appid");
            int optInt = jSONObject.optInt("actionCode");
            e eVar = this.lastActionRecord;
            if (eVar == null) {
                this.lastActionRecord = new e(optString2, optString, optInt);
            } else if (eVar.a(optString2, optString, optInt)) {
                return;
            }
            final boolean changeIntToBoolean = DownloadInterface.changeIntToBoolean(jSONObject.optInt("isAutoDownload"));
            final boolean changeIntToBoolean2 = DownloadInterface.changeIntToBoolean(jSONObject.optInt("isAutoInstall"));
            DownloadInfo w3 = DownloadManager.C().w(jSONObject.optString("appid"));
            jSONObject.put("titleType", 0);
            if (w3 == null) {
                if (MyAppApi.z().n()) {
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appcommon.js.BaseJsCallBack.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MyAppApi.z().n0(BaseJsCallBack.this.activity, bundle, changeIntToBoolean, changeIntToBoolean2);
                        }
                    });
                    return;
                } else {
                    goUrl(jSONObject.optString("url"), true);
                    return;
                }
            }
            if (w3.J == 1) {
                MyAppApi.z();
                if (MyAppApi.G()) {
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appcommon.js.BaseJsCallBack.3
                        @Override // java.lang.Runnable
                        public void run() {
                            MyAppApi.z().n0(BaseJsCallBack.this.activity, bundle, changeIntToBoolean, changeIntToBoolean2);
                        }
                    });
                    return;
                }
            }
            goUrl(jSONObject.optString("url"), true);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(LOG_TAG, "goToDetailPage>>>", e16);
        }
    }

    public void goToDownloadTaskList(String str) {
        com.tencent.open.base.f.a("TIME-STATISTIC", "JsCallBack--goToDetailPage");
        final Bundle bundle = new Bundle();
        try {
            bundle.putString(com.tencent.open.downloadnew.e.f341500i, new JSONObject(str).optString("via"));
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appcommon.js.BaseJsCallBack.4
                @Override // java.lang.Runnable
                public void run() {
                    MyAppApi.z().s0(BaseJsCallBack.this.activity, bundle);
                }
            });
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(LOG_TAG, "goToDetailPage>>>", e16);
        }
    }

    protected void goUrl(String str, boolean z16) {
        if (hasRight()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray.mo162put(this.activity.getString(R.string.aj7));
                jSONObject.put("url", str);
                jSONObject.put("titleName", jSONArray);
                goUrl(jSONObject.toString());
            } catch (Exception e16) {
                com.tencent.open.base.f.d(LOG_TAG, "gourl(onlyurl) error ", e16);
            }
        }
    }

    @Deprecated
    public void goWebApp(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        JSONObject jSONObject;
        String str6 = "";
        if (!hasRight()) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("appid");
        } catch (JSONException e16) {
            e = e16;
            str2 = "";
            str3 = str2;
        } catch (Exception e17) {
            e = e17;
            str2 = "";
            str3 = str2;
        }
        try {
            str3 = jSONObject.optString("strUrl");
        } catch (JSONException e18) {
            e = e18;
            str3 = "";
            str4 = str3;
            str5 = str4;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            e.printStackTrace();
            com.tencent.open.base.f.d(LOG_TAG, "JSONException", e);
            int i26 = i17;
            int i27 = i18;
            int i28 = i19;
            String str7 = str4;
            String str8 = str5;
            com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i26 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i27 + APLogFileUtil.SEPARATOR_LOG + str7 + APLogFileUtil.SEPARATOR_LOG + str8 + APLogFileUtil.SEPARATOR_LOG + i28 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
            Intent intent = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("url", str3);
            bundle.putInt("type", i3);
            bundle.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i26);
            bundle.putInt("showQuickBar", i16);
            bundle.putInt("fullScreen", i27);
            bundle.putString("appName", str7);
            bundle.putString("appIconUrl", str8);
            bundle.putInt("showDialog", i28);
            bundle.putString("appId", str2);
            bundle.putInt("goto_type", 5);
            intent.putExtras(bundle);
            this.activity.startActivity(intent);
        } catch (Exception e19) {
            e = e19;
            str3 = "";
            str4 = str3;
            str5 = str4;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            e.printStackTrace();
            com.tencent.open.base.f.d(LOG_TAG, "Exception", e);
            int i262 = i17;
            int i272 = i18;
            int i282 = i19;
            String str72 = str4;
            String str82 = str5;
            com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i262 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i272 + APLogFileUtil.SEPARATOR_LOG + str72 + APLogFileUtil.SEPARATOR_LOG + str82 + APLogFileUtil.SEPARATOR_LOG + i282 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
            Intent intent2 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("url", str3);
            bundle2.putInt("type", i3);
            bundle2.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i262);
            bundle2.putInt("showQuickBar", i16);
            bundle2.putInt("fullScreen", i272);
            bundle2.putString("appName", str72);
            bundle2.putString("appIconUrl", str82);
            bundle2.putInt("showDialog", i282);
            bundle2.putString("appId", str2);
            bundle2.putInt("goto_type", 5);
            intent2.putExtras(bundle2);
            this.activity.startActivity(intent2);
        }
        try {
            i3 = jSONObject.optInt("type");
            try {
                i16 = jSONObject.optInt("showQuickBar");
                try {
                    i17 = jSONObject.optInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION);
                } catch (JSONException e26) {
                    e = e26;
                    str4 = "";
                    str5 = str4;
                    i17 = 0;
                    i18 = 0;
                    i19 = 0;
                    e.printStackTrace();
                    com.tencent.open.base.f.d(LOG_TAG, "JSONException", e);
                    int i2622 = i17;
                    int i2722 = i18;
                    int i2822 = i19;
                    String str722 = str4;
                    String str822 = str5;
                    com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i2622 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i2722 + APLogFileUtil.SEPARATOR_LOG + str722 + APLogFileUtil.SEPARATOR_LOG + str822 + APLogFileUtil.SEPARATOR_LOG + i2822 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
                    Intent intent22 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
                    Bundle bundle22 = new Bundle();
                    bundle22.putString("url", str3);
                    bundle22.putInt("type", i3);
                    bundle22.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i2622);
                    bundle22.putInt("showQuickBar", i16);
                    bundle22.putInt("fullScreen", i2722);
                    bundle22.putString("appName", str722);
                    bundle22.putString("appIconUrl", str822);
                    bundle22.putInt("showDialog", i2822);
                    bundle22.putString("appId", str2);
                    bundle22.putInt("goto_type", 5);
                    intent22.putExtras(bundle22);
                    this.activity.startActivity(intent22);
                } catch (Exception e27) {
                    e = e27;
                    str4 = "";
                    str5 = str4;
                    i17 = 0;
                    i18 = 0;
                    i19 = 0;
                    e.printStackTrace();
                    com.tencent.open.base.f.d(LOG_TAG, "Exception", e);
                    int i26222 = i17;
                    int i27222 = i18;
                    int i28222 = i19;
                    String str7222 = str4;
                    String str8222 = str5;
                    com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i26222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i27222 + APLogFileUtil.SEPARATOR_LOG + str7222 + APLogFileUtil.SEPARATOR_LOG + str8222 + APLogFileUtil.SEPARATOR_LOG + i28222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
                    Intent intent222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
                    Bundle bundle222 = new Bundle();
                    bundle222.putString("url", str3);
                    bundle222.putInt("type", i3);
                    bundle222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i26222);
                    bundle222.putInt("showQuickBar", i16);
                    bundle222.putInt("fullScreen", i27222);
                    bundle222.putString("appName", str7222);
                    bundle222.putString("appIconUrl", str8222);
                    bundle222.putInt("showDialog", i28222);
                    bundle222.putString("appId", str2);
                    bundle222.putInt("goto_type", 5);
                    intent222.putExtras(bundle222);
                    this.activity.startActivity(intent222);
                }
                try {
                    i18 = jSONObject.optInt("fullScreen");
                } catch (JSONException e28) {
                    e = e28;
                    str4 = "";
                    str5 = str4;
                    i18 = 0;
                    i19 = 0;
                    e.printStackTrace();
                    com.tencent.open.base.f.d(LOG_TAG, "JSONException", e);
                    int i262222 = i17;
                    int i272222 = i18;
                    int i282222 = i19;
                    String str72222 = str4;
                    String str82222 = str5;
                    com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i262222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i272222 + APLogFileUtil.SEPARATOR_LOG + str72222 + APLogFileUtil.SEPARATOR_LOG + str82222 + APLogFileUtil.SEPARATOR_LOG + i282222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
                    Intent intent2222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
                    Bundle bundle2222 = new Bundle();
                    bundle2222.putString("url", str3);
                    bundle2222.putInt("type", i3);
                    bundle2222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i262222);
                    bundle2222.putInt("showQuickBar", i16);
                    bundle2222.putInt("fullScreen", i272222);
                    bundle2222.putString("appName", str72222);
                    bundle2222.putString("appIconUrl", str82222);
                    bundle2222.putInt("showDialog", i282222);
                    bundle2222.putString("appId", str2);
                    bundle2222.putInt("goto_type", 5);
                    intent2222.putExtras(bundle2222);
                    this.activity.startActivity(intent2222);
                } catch (Exception e29) {
                    e = e29;
                    str4 = "";
                    str5 = str4;
                    i18 = 0;
                    i19 = 0;
                    e.printStackTrace();
                    com.tencent.open.base.f.d(LOG_TAG, "Exception", e);
                    int i2622222 = i17;
                    int i2722222 = i18;
                    int i2822222 = i19;
                    String str722222 = str4;
                    String str822222 = str5;
                    com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i2622222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i2722222 + APLogFileUtil.SEPARATOR_LOG + str722222 + APLogFileUtil.SEPARATOR_LOG + str822222 + APLogFileUtil.SEPARATOR_LOG + i2822222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
                    Intent intent22222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
                    Bundle bundle22222 = new Bundle();
                    bundle22222.putString("url", str3);
                    bundle22222.putInt("type", i3);
                    bundle22222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i2622222);
                    bundle22222.putInt("showQuickBar", i16);
                    bundle22222.putInt("fullScreen", i2722222);
                    bundle22222.putString("appName", str722222);
                    bundle22222.putString("appIconUrl", str822222);
                    bundle22222.putInt("showDialog", i2822222);
                    bundle22222.putString("appId", str2);
                    bundle22222.putInt("goto_type", 5);
                    intent22222.putExtras(bundle22222);
                    this.activity.startActivity(intent22222);
                }
            } catch (JSONException e36) {
                e = e36;
                str4 = "";
                str5 = str4;
                i16 = 0;
                i17 = 0;
                i18 = 0;
                i19 = 0;
                e.printStackTrace();
                com.tencent.open.base.f.d(LOG_TAG, "JSONException", e);
                int i26222222 = i17;
                int i27222222 = i18;
                int i28222222 = i19;
                String str7222222 = str4;
                String str8222222 = str5;
                com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i26222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i27222222 + APLogFileUtil.SEPARATOR_LOG + str7222222 + APLogFileUtil.SEPARATOR_LOG + str8222222 + APLogFileUtil.SEPARATOR_LOG + i28222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
                Intent intent222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
                Bundle bundle222222 = new Bundle();
                bundle222222.putString("url", str3);
                bundle222222.putInt("type", i3);
                bundle222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i26222222);
                bundle222222.putInt("showQuickBar", i16);
                bundle222222.putInt("fullScreen", i27222222);
                bundle222222.putString("appName", str7222222);
                bundle222222.putString("appIconUrl", str8222222);
                bundle222222.putInt("showDialog", i28222222);
                bundle222222.putString("appId", str2);
                bundle222222.putInt("goto_type", 5);
                intent222222.putExtras(bundle222222);
                this.activity.startActivity(intent222222);
            } catch (Exception e37) {
                e = e37;
                str4 = "";
                str5 = str4;
                i16 = 0;
                i17 = 0;
                i18 = 0;
                i19 = 0;
                e.printStackTrace();
                com.tencent.open.base.f.d(LOG_TAG, "Exception", e);
                int i262222222 = i17;
                int i272222222 = i18;
                int i282222222 = i19;
                String str72222222 = str4;
                String str82222222 = str5;
                com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i262222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i272222222 + APLogFileUtil.SEPARATOR_LOG + str72222222 + APLogFileUtil.SEPARATOR_LOG + str82222222 + APLogFileUtil.SEPARATOR_LOG + i282222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
                Intent intent2222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
                Bundle bundle2222222 = new Bundle();
                bundle2222222.putString("url", str3);
                bundle2222222.putInt("type", i3);
                bundle2222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i262222222);
                bundle2222222.putInt("showQuickBar", i16);
                bundle2222222.putInt("fullScreen", i272222222);
                bundle2222222.putString("appName", str72222222);
                bundle2222222.putString("appIconUrl", str82222222);
                bundle2222222.putInt("showDialog", i282222222);
                bundle2222222.putString("appId", str2);
                bundle2222222.putInt("goto_type", 5);
                intent2222222.putExtras(bundle2222222);
                this.activity.startActivity(intent2222222);
            }
        } catch (JSONException e38) {
            e = e38;
            str4 = "";
            str5 = str4;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            e.printStackTrace();
            com.tencent.open.base.f.d(LOG_TAG, "JSONException", e);
            int i2622222222 = i17;
            int i2722222222 = i18;
            int i2822222222 = i19;
            String str722222222 = str4;
            String str822222222 = str5;
            com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i2622222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i2722222222 + APLogFileUtil.SEPARATOR_LOG + str722222222 + APLogFileUtil.SEPARATOR_LOG + str822222222 + APLogFileUtil.SEPARATOR_LOG + i2822222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
            Intent intent22222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
            Bundle bundle22222222 = new Bundle();
            bundle22222222.putString("url", str3);
            bundle22222222.putInt("type", i3);
            bundle22222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i2622222222);
            bundle22222222.putInt("showQuickBar", i16);
            bundle22222222.putInt("fullScreen", i2722222222);
            bundle22222222.putString("appName", str722222222);
            bundle22222222.putString("appIconUrl", str822222222);
            bundle22222222.putInt("showDialog", i2822222222);
            bundle22222222.putString("appId", str2);
            bundle22222222.putInt("goto_type", 5);
            intent22222222.putExtras(bundle22222222);
            this.activity.startActivity(intent22222222);
        } catch (Exception e39) {
            e = e39;
            str4 = "";
            str5 = str4;
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            e.printStackTrace();
            com.tencent.open.base.f.d(LOG_TAG, "Exception", e);
            int i26222222222 = i17;
            int i27222222222 = i18;
            int i28222222222 = i19;
            String str7222222222 = str4;
            String str8222222222 = str5;
            com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i26222222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i27222222222 + APLogFileUtil.SEPARATOR_LOG + str7222222222 + APLogFileUtil.SEPARATOR_LOG + str8222222222 + APLogFileUtil.SEPARATOR_LOG + i28222222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
            Intent intent222222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
            Bundle bundle222222222 = new Bundle();
            bundle222222222.putString("url", str3);
            bundle222222222.putInt("type", i3);
            bundle222222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i26222222222);
            bundle222222222.putInt("showQuickBar", i16);
            bundle222222222.putInt("fullScreen", i27222222222);
            bundle222222222.putString("appName", str7222222222);
            bundle222222222.putString("appIconUrl", str8222222222);
            bundle222222222.putInt("showDialog", i28222222222);
            bundle222222222.putString("appId", str2);
            bundle222222222.putInt("goto_type", 5);
            intent222222222.putExtras(bundle222222222);
            this.activity.startActivity(intent222222222);
        }
        try {
            i19 = jSONObject.optInt("showDialog");
            try {
                str4 = jSONObject.optString("appName");
                try {
                    str5 = jSONObject.optString("appIconUrl");
                } catch (JSONException e46) {
                    e = e46;
                    str5 = "";
                } catch (Exception e47) {
                    e = e47;
                    str5 = "";
                }
            } catch (JSONException e48) {
                e = e48;
                str4 = "";
                str5 = str4;
            } catch (Exception e49) {
                e = e49;
                str4 = "";
                str5 = str4;
            }
        } catch (JSONException e56) {
            e = e56;
            str4 = "";
            str5 = str4;
            i19 = 0;
            e.printStackTrace();
            com.tencent.open.base.f.d(LOG_TAG, "JSONException", e);
            int i262222222222 = i17;
            int i272222222222 = i18;
            int i282222222222 = i19;
            String str72222222222 = str4;
            String str82222222222 = str5;
            com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i262222222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i272222222222 + APLogFileUtil.SEPARATOR_LOG + str72222222222 + APLogFileUtil.SEPARATOR_LOG + str82222222222 + APLogFileUtil.SEPARATOR_LOG + i282222222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
            Intent intent2222222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
            Bundle bundle2222222222 = new Bundle();
            bundle2222222222.putString("url", str3);
            bundle2222222222.putInt("type", i3);
            bundle2222222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i262222222222);
            bundle2222222222.putInt("showQuickBar", i16);
            bundle2222222222.putInt("fullScreen", i272222222222);
            bundle2222222222.putString("appName", str72222222222);
            bundle2222222222.putString("appIconUrl", str82222222222);
            bundle2222222222.putInt("showDialog", i282222222222);
            bundle2222222222.putString("appId", str2);
            bundle2222222222.putInt("goto_type", 5);
            intent2222222222.putExtras(bundle2222222222);
            this.activity.startActivity(intent2222222222);
        } catch (Exception e57) {
            e = e57;
            str4 = "";
            str5 = str4;
            i19 = 0;
            e.printStackTrace();
            com.tencent.open.base.f.d(LOG_TAG, "Exception", e);
            int i2622222222222 = i17;
            int i2722222222222 = i18;
            int i2822222222222 = i19;
            String str722222222222 = str4;
            String str822222222222 = str5;
            com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i2622222222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i2722222222222 + APLogFileUtil.SEPARATOR_LOG + str722222222222 + APLogFileUtil.SEPARATOR_LOG + str822222222222 + APLogFileUtil.SEPARATOR_LOG + i2822222222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
            Intent intent22222222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
            Bundle bundle22222222222 = new Bundle();
            bundle22222222222.putString("url", str3);
            bundle22222222222.putInt("type", i3);
            bundle22222222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i2622222222222);
            bundle22222222222.putInt("showQuickBar", i16);
            bundle22222222222.putInt("fullScreen", i2722222222222);
            bundle22222222222.putString("appName", str722222222222);
            bundle22222222222.putString("appIconUrl", str822222222222);
            bundle22222222222.putInt("showDialog", i2822222222222);
            bundle22222222222.putString("appId", str2);
            bundle22222222222.putInt("goto_type", 5);
            intent22222222222.putExtras(bundle22222222222);
            this.activity.startActivity(intent22222222222);
        }
        try {
            str6 = jSONObject.optString("args");
        } catch (JSONException e58) {
            e = e58;
            e.printStackTrace();
            com.tencent.open.base.f.d(LOG_TAG, "JSONException", e);
            int i26222222222222 = i17;
            int i27222222222222 = i18;
            int i28222222222222 = i19;
            String str7222222222222 = str4;
            String str8222222222222 = str5;
            com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i26222222222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i27222222222222 + APLogFileUtil.SEPARATOR_LOG + str7222222222222 + APLogFileUtil.SEPARATOR_LOG + str8222222222222 + APLogFileUtil.SEPARATOR_LOG + i28222222222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
            Intent intent222222222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
            Bundle bundle222222222222 = new Bundle();
            bundle222222222222.putString("url", str3);
            bundle222222222222.putInt("type", i3);
            bundle222222222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i26222222222222);
            bundle222222222222.putInt("showQuickBar", i16);
            bundle222222222222.putInt("fullScreen", i27222222222222);
            bundle222222222222.putString("appName", str7222222222222);
            bundle222222222222.putString("appIconUrl", str8222222222222);
            bundle222222222222.putInt("showDialog", i28222222222222);
            bundle222222222222.putString("appId", str2);
            bundle222222222222.putInt("goto_type", 5);
            intent222222222222.putExtras(bundle222222222222);
            this.activity.startActivity(intent222222222222);
        } catch (Exception e59) {
            e = e59;
            e.printStackTrace();
            com.tencent.open.base.f.d(LOG_TAG, "Exception", e);
            int i262222222222222 = i17;
            int i272222222222222 = i18;
            int i282222222222222 = i19;
            String str72222222222222 = str4;
            String str82222222222222 = str5;
            com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i262222222222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i272222222222222 + APLogFileUtil.SEPARATOR_LOG + str72222222222222 + APLogFileUtil.SEPARATOR_LOG + str82222222222222 + APLogFileUtil.SEPARATOR_LOG + i282222222222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
            Intent intent2222222222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
            Bundle bundle2222222222222 = new Bundle();
            bundle2222222222222.putString("url", str3);
            bundle2222222222222.putInt("type", i3);
            bundle2222222222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i262222222222222);
            bundle2222222222222.putInt("showQuickBar", i16);
            bundle2222222222222.putInt("fullScreen", i272222222222222);
            bundle2222222222222.putString("appName", str72222222222222);
            bundle2222222222222.putString("appIconUrl", str82222222222222);
            bundle2222222222222.putInt("showDialog", i282222222222222);
            bundle2222222222222.putString("appId", str2);
            bundle2222222222222.putInt("goto_type", 5);
            intent2222222222222.putExtras(bundle2222222222222);
            this.activity.startActivity(intent2222222222222);
        }
        int i2622222222222222 = i17;
        int i2722222222222222 = i18;
        int i2822222222222222 = i19;
        String str722222222222222 = str4;
        String str822222222222222 = str5;
        com.tencent.open.base.f.a(LOG_TAG, "strUrl = " + str3 + APLogFileUtil.SEPARATOR_LOG + i3 + APLogFileUtil.SEPARATOR_LOG + i2622222222222222 + APLogFileUtil.SEPARATOR_LOG + i16 + APLogFileUtil.SEPARATOR_LOG + i2722222222222222 + APLogFileUtil.SEPARATOR_LOG + str722222222222222 + APLogFileUtil.SEPARATOR_LOG + str822222222222222 + APLogFileUtil.SEPARATOR_LOG + i2822222222222222 + APLogFileUtil.SEPARATOR_LOG + str2 + APLogFileUtil.SEPARATOR_LOG + str6 + APLogFileUtil.SEPARATOR_LOG + 0);
        Intent intent22222222222222 = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
        Bundle bundle22222222222222 = new Bundle();
        bundle22222222222222.putString("url", str3);
        bundle22222222222222.putInt("type", i3);
        bundle22222222222222.putInt(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, i2622222222222222);
        bundle22222222222222.putInt("showQuickBar", i16);
        bundle22222222222222.putInt("fullScreen", i2722222222222222);
        bundle22222222222222.putString("appName", str722222222222222);
        bundle22222222222222.putString("appIconUrl", str822222222222222);
        bundle22222222222222.putInt("showDialog", i2822222222222222);
        bundle22222222222222.putString("appId", str2);
        bundle22222222222222.putInt("goto_type", 5);
        intent22222222222222.putExtras(bundle22222222222222);
        this.activity.startActivity(intent22222222222222);
    }

    public void onJsAlert(String str) {
        new AlertDialog.Builder(this.activity).setTitle("javaScript dialog").setMessage(str).setPositiveButton(android.R.string.ok, new a()).setCancelable(false).create().show();
    }

    public void report(String str) {
        if (!hasRight()) {
            return;
        }
        com.tencent.open.base.f.e(LOG_TAG, "[report] json=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppCenterReporter.m(jSONObject.optInt("type"), jSONObject.optString("data"));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void reportBatch(String str) {
        if (!hasRight()) {
            return;
        }
        com.tencent.open.base.f.e(LOG_TAG, "[reportBatch] json=" + str);
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    AppCenterReporter.m(optJSONObject.optInt("type"), optJSONObject.optString("data"));
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void reportForVia(String str) {
        if (!hasRight()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("actionType");
            String optString2 = jSONObject.optString("via");
            String optString3 = jSONObject.optString("appid");
            String optString4 = jSONObject.optString("jsversion");
            String optString5 = jSONObject.optString(WadlProxyConsts.EXTRA_DATA);
            Bundle bundle = new Bundle();
            bundle.putString("jsversion", optString4);
            com.tencent.open.business.base.e.f(optString, optString2, optString3, optString5, bundle);
            com.tencent.open.base.f.a(LOG_TAG, "reportForvia " + optString + APLogFileUtil.SEPARATOR_LOG + optString2 + APLogFileUtil.SEPARATOR_LOG + optString3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void reportForViaBatch(String str) {
        if (!hasRight()) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("actionType");
                    String optString2 = optJSONObject.optString("via");
                    String optString3 = optJSONObject.optString("appid");
                    String optString4 = optJSONObject.optString("jsversion");
                    String optString5 = optJSONObject.optString(WadlProxyConsts.EXTRA_DATA);
                    Bundle bundle = new Bundle();
                    bundle.putString("jsversion", optString4);
                    com.tencent.open.business.base.e.f(optString, optString2, optString3, optString5, bundle);
                    com.tencent.open.base.f.a(LOG_TAG, "reportForvia " + optString + APLogFileUtil.SEPARATOR_LOG + optString2 + APLogFileUtil.SEPARATOR_LOG + optString3);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void reportPV(String str, String str2) {
        if (isUpdateAssets) {
            isUpdateAssets = false;
            return;
        }
        if (com.tencent.open.business.base.a.a(str)) {
            com.tencent.open.business.base.e.d("100", "ANDROIDQQ.INSTALLED.APPDETAIL", str2);
        } else if (DownloadManager.C().f(str2)) {
            com.tencent.open.business.base.e.d("100", "ANDROIDQQ.UNINSTALL.APPDETAIL", str2);
        } else {
            com.tencent.open.business.base.e.d("100", "ANDROIDQQ.UNDOWNLOAD.APPDETAIL", str2);
        }
    }

    public void setActionButton(final String str) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.open.appcommon.js.BaseJsCallBack.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BaseJsCallBack.this.mRemoteServiceProxy != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        SendMsg sendMsg = new SendMsg("setActionButton");
                        sendMsg.f390391e.putString("iconType", jSONObject.optString("iconType"));
                        sendMsg.f390391e.putString(NodeProps.VISIBLE, jSONObject.optString(NodeProps.VISIBLE));
                        sendMsg.f390391e.putString("callBackKey", jSONObject.optString("callBackKey"));
                        sendMsg.f390391e.putString("rightText", jSONObject.optString("text"));
                        BaseJsCallBack.this.mRemoteServiceProxy.h(sendMsg);
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    public void setAllowCallBackEvent(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (!hasRight()) {
                return;
            }
            if (parseInt == 0) {
                com.tencent.open.appcommon.b.a().d(false);
            } else {
                com.tencent.open.appcommon.b.a().d(true);
            }
        } catch (NumberFormatException unused) {
        }
    }

    public boolean setCommonReportData(String str) {
        com.tencent.open.base.f.a(LOG_TAG, "JsCallBack--setCommonReportData");
        if (!TextUtils.isEmpty(str)) {
            try {
                com.tencent.open.adapter.a.f().q(str);
                return true;
            } catch (Exception e16) {
                com.tencent.open.base.f.d(LOG_TAG, "JsCallBack--setCommonReportData Exception", e16);
                return false;
            }
        }
        return false;
    }

    public void setParams(String str) {
        this.urlParams = str;
    }

    public void showToast(String str) {
        Activity activity;
        if (hasRight() && (activity = this.activity) != null && !activity.isFinishing()) {
            ToastUtil.a().f(str, 1);
        }
    }

    public void startApp(String str, String str2) {
        if (hasRight()) {
            try {
                if (appIsExists(str)) {
                    com.tencent.open.business.base.a.x(this.activity, str, DownloadInterface.getSourceInfoFromActivity(this.activity));
                }
            } catch (Exception unused) {
                com.tencent.open.base.f.c("startApp", "apk not exist packName = " + str);
            }
        }
    }

    public void startAppWithData(String str, String str2) {
        if (!hasRight()) {
            return;
        }
        try {
            if (appIsExists(str)) {
                com.tencent.open.business.base.a.x(this.activity, str, DownloadInterface.getSourceInfoFromActivity(this.activity));
            }
        } catch (Exception unused) {
            com.tencent.open.base.f.c("startApp", "apk not exist packName = " + str);
        }
    }

    public void startOpenApp(String str, String str2, String str3, String str4, String str5) {
        try {
            com.tencent.open.base.f.e(LOG_TAG, "start App\uff1a" + str + "," + str3 + "," + str4);
            if (appIsExists(str)) {
                try {
                    str5 = URLDecoder.decode(str5, "UTF-8");
                } catch (Exception unused) {
                }
                com.tencent.open.business.base.a.y(this.activity, str3, str, str5);
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.c(LOG_TAG, "try start app:" + e16.getMessage());
        }
    }

    public void startApp(String str, String str2, String str3) {
        try {
            if (appIsExists(str)) {
                Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(this.activity.getPackageManager(), str);
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new Intent(str);
                    launchIntentForPackage.addCategory("android.intent.category.DEFAULT");
                }
                launchIntentForPackage.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "qzone_m");
                launchIntentForPackage.putExtra("big_brother_source_key", DownloadInterface.getSourceInfoFromActivity(this.activity));
                com.tencent.open.base.f.a("add", ">>has add platformid=qzone_m");
                try {
                    this.activity.startActivity(launchIntentForPackage);
                } catch (Exception unused) {
                    ToastUtil.a().f(HardCodeUtil.qqStr(R.string.jyc), 0);
                }
            }
        } catch (Exception unused2) {
            com.tencent.open.base.f.c("startApp", "apk not exist packName = " + str);
        }
    }

    public void startOpenApp(String str, String str2, String str3) {
        if (hasRight()) {
            try {
                if (appIsExists(str)) {
                    com.tencent.open.business.base.a.x(this.activity, str, DownloadInterface.getSourceInfoFromActivity(this.activity));
                }
            } catch (Exception unused) {
            }
        }
    }

    public void goUrl(String str) {
        String str2;
        String str3;
        int i3;
        if (hasRight()) {
            com.tencent.open.base.f.a(LOG_TAG, str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                JSONArray optJSONArray = jSONObject.optJSONArray("titleInfo");
                int optInt = jSONObject.optInt("current");
                if (TextUtils.isEmpty(optString)) {
                    com.tencent.open.base.f.c(LOG_TAG, "gourl strUrl == null");
                    return;
                }
                int optInt2 = jSONObject.optInt("leftBtnType");
                int optInt3 = jSONObject.optInt("rightBtnType");
                int optInt4 = jSONObject.optInt("titleRefreshType");
                int optInt5 = jSONObject.optInt("titleType");
                String[] fileUrl = getFileUrl(optString);
                String str4 = fileUrl[0];
                String str5 = fileUrl[1];
                if (str4.equals(optString)) {
                    i3 = optInt;
                    str4 = str4.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1 ? str4 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER : str4 + ContainerUtils.FIELD_DELIMITER;
                    if (str4.indexOf("{UIN}") > 0) {
                        StringBuilder sb5 = new StringBuilder();
                        str2 = "titleType";
                        str3 = "titleRefreshType";
                        sb5.append(com.tencent.open.adapter.a.f().l());
                        sb5.append("");
                        str4 = str4.replaceAll("\\{UIN\\}", sb5.toString());
                    } else {
                        str2 = "titleType";
                        str3 = "titleRefreshType";
                    }
                } else {
                    str2 = "titleType";
                    str3 = "titleRefreshType";
                    i3 = optInt;
                }
                Intent intent = new Intent(this.activity, (Class<?>) QZoneAppListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("APP_URL", str4);
                if (str5 != null && str5.length() > 0) {
                    bundle.putString("APP_PARAMS", str5);
                }
                if (optJSONArray != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    int i16 = 0;
                    for (int length = optJSONArray.length(); i16 < length; length = length) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i16);
                        arrayList.add(jSONObject2.optString("name"));
                        arrayList2.add(jSONObject2.optString("tipNum"));
                        i16++;
                    }
                    bundle.putStringArrayList("titleName", arrayList);
                    bundle.putStringArrayList("titleTip", arrayList2);
                    bundle.putBoolean("showTitle", arrayList.size() > 0);
                    com.tencent.open.base.f.a(LOG_TAG, "array = " + arrayList.toString() + APLogFileUtil.SEPARATOR_LOG + arrayList.size());
                }
                bundle.putInt("leftBtnType", optInt2);
                bundle.putInt("rightBtnType", optInt3);
                bundle.putInt(str3, optInt4);
                bundle.putInt(str2, optInt5);
                bundle.putInt("current", i3);
                bundle.putString("uin", String.valueOf(com.tencent.open.adapter.a.f().l()));
                bundle.putString("sid", com.tencent.open.adapter.a.f().k());
                bundle.putInt("goto_type", 2);
                intent.putExtras(bundle);
                this.activity.startActivityForResult(intent, 200);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
