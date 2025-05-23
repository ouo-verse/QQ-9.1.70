package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.OuterCallLog;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadInterface extends BaseInterface implements com.tencent.open.business.base.c {
    public static final String PLUGIN_NAMESPACE = "q_download";
    private static final String TAG = "DownloadInterface";
    protected String jsCallBackMethod = "";
    e lastActionRecord = null;
    protected UpdateManager.a listener;
    protected Activity mActivity;
    protected Handler mHandler;
    protected final WebView webview;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements com.tencent.open.downloadnew.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f340672a;

        a(String str) {
            this.f340672a = str;
        }

        @Override // com.tencent.open.downloadnew.f
        public void onException(int i3, String str) {
            com.tencent.open.base.f.c(DownloadInterface.TAG, "innerQueryDownloadInfo ERROR");
        }

        @Override // com.tencent.open.downloadnew.f
        public void onResult(List<DownloadInfo> list) {
            com.tencent.open.base.f.a(DownloadInterface.TAG, "innerQueryDownloadInfo onResult = " + list.size());
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                JSONObject jSONObject = new JSONObject();
                DownloadInfo downloadInfo = list.get(i3);
                try {
                    jSONObject.put("appid", downloadInfo.f341184e);
                    jSONObject.put(WadlResult.WEB_KEY_PROGRESS, downloadInfo.Q);
                    jSONObject.put("state", downloadInfo.f());
                    jSONObject.put("ismyapp", downloadInfo.J);
                    jSONObject.put("download_from", downloadInfo.W);
                    jSONObject.put(WadlResult.WEB_KEY_WRITE_CODE_STATE, downloadInfo.f341179a0);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                jSONArray.mo162put(jSONObject);
            }
            String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + this.f340672a + ", \"r\" : 0, \"data\":" + jSONArray.toString() + "});}void(0);";
            com.tencent.open.base.f.a(DownloadInterface.TAG, "querySucess : " + str);
            DownloadInterface.this.jsCallBack(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements com.tencent.open.downloadnew.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f340674a;

        b(String str) {
            this.f340674a = str;
        }

        @Override // com.tencent.open.downloadnew.f
        public void onException(int i3, String str) {
            com.tencent.open.base.f.c(DownloadInterface.TAG, "innerQueryDownloadInfoByViaInfo ERROR");
        }

        @Override // com.tencent.open.downloadnew.f
        public void onResult(List<DownloadInfo> list) {
            com.tencent.open.base.f.a(DownloadInterface.TAG, "innerQueryDownloadInfoByVia onResult = " + list.size());
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                JSONObject jSONObject = new JSONObject();
                DownloadInfo downloadInfo = list.get(i3);
                try {
                    jSONObject.put("appid", downloadInfo.f341184e);
                    jSONObject.put(WadlResult.WEB_KEY_PROGRESS, downloadInfo.Q);
                    jSONObject.put("state", downloadInfo.f());
                    jSONObject.put("ismyapp", downloadInfo.J);
                    jSONObject.put("download_from", downloadInfo.W);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                jSONArray.mo162put(jSONObject);
            }
            String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadActionByVia',{\"guid\": " + this.f340674a + ", \"r\" : 0, \"data\":" + jSONArray.toString() + "});}void(0);";
            com.tencent.open.base.f.a(DownloadInterface.TAG, "innerQueryDownloadInfoByVia querySucess : " + str);
            DownloadInterface.this.jsCallBack(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements UpdateManager.a {

        /* renamed from: a, reason: collision with root package name */
        protected String f340676a;

        public c(String str) {
            this.f340676a = str;
        }

        @Override // com.tencent.open.downloadnew.UpdateManager.a
        public void a(String str) {
            if (!DownloadInterface.this.hasRight()) {
                return;
            }
            com.tencent.open.base.f.c(DownloadInterface.TAG, "JsCheckUpdateCallback onException >>> " + str);
            DownloadInterface.this.jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.f340676a + "\",\"r\":\"-1\"});}void(0);");
        }

        public void b(String str) {
            this.f340676a = str;
        }

        @Override // com.tencent.open.downloadnew.UpdateManager.a
        public void onResult(ArrayList<ApkUpdateDetail> arrayList) {
            String str;
            if (!DownloadInterface.this.hasRight()) {
                return;
            }
            com.tencent.open.base.f.h(DownloadInterface.TAG, "JsCheckUpdateCallback onResult >>> " + arrayList.size());
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                try {
                    ApkUpdateDetail apkUpdateDetail = arrayList.get(i3);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("packageName", apkUpdateDetail.packageName);
                    jSONObject2.put("newapksize", apkUpdateDetail.newapksize);
                    jSONObject2.put("patchsize", apkUpdateDetail.patchsize);
                    jSONObject2.put("updatemethod", apkUpdateDetail.updatemethod);
                    jSONObject2.put("versioncode", apkUpdateDetail.versioncode);
                    jSONObject2.put("versionname", apkUpdateDetail.versionname);
                    jSONObject2.put("fileMd5", apkUpdateDetail.fileMd5);
                    jSONObject2.put("sigMd5", apkUpdateDetail.sigMd5);
                    jSONObject2.put("url", apkUpdateDetail.url);
                    jSONArray.mo162put(jSONObject2);
                } catch (JSONException unused) {
                    str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.f340676a + "\",\"r\":\"-1\"});}void(0);";
                }
            }
            jSONObject.put("guid", this.f340676a);
            jSONObject.put("content", jSONArray.toString());
            jSONObject.put(QzoneIPCModule.RESULT_CODE, "0");
            str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{'guid':'" + this.f340676a + "','r':'0','data':'" + jSONArray.toString() + "'});}void(0);";
            com.tencent.open.base.f.e(DownloadInterface.TAG, ">>checkUpdate jsUrl:" + str);
            DownloadInterface.this.jsCallBack(str);
        }
    }

    public DownloadInterface(Activity activity, WebView webView) {
        com.tencent.common.app.AppInterface appInterface = null;
        com.tencent.open.base.f.a(TAG, "init in");
        this.mActivity = activity;
        this.webview = webView;
        this.mHandler = new Handler(Looper.getMainLooper());
        if (activity instanceof PublicFragmentActivityForTool) {
            appInterface = (com.tencent.common.app.AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        } else if (activity instanceof BaseActivity) {
            appInterface = (com.tencent.common.app.AppInterface) ((BaseActivity) activity).getAppRuntime();
        }
        DownloadManager.C().b0(appInterface);
        com.tencent.open.business.base.d.a().c(this);
        com.tencent.open.base.f.a(TAG, "init out");
    }

    public static boolean changeIntToBoolean(int i3) {
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    public static String getRefIdFromActivity(Activity activity) {
        try {
            return activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getSourceInfoFromActivity(Activity activity) {
        try {
            return activity.getIntent().getStringExtra("big_brother_source_key");
        } catch (Throwable unused) {
            return "";
        }
    }

    private void innerQueryDownloadInfo(JSONArray jSONArray, String str) {
        try {
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                DownloadInfo downloadInfo = new DownloadInfo();
                downloadInfo.f341184e = jSONObject.optString("appid");
                downloadInfo.G = jSONObject.optString("myAppId");
                downloadInfo.H = jSONObject.optString("apkId");
                downloadInfo.f341189h = jSONObject.optString("packageName");
                downloadInfo.I = jSONObject.optInt("versionCode");
                arrayList.add(downloadInfo);
            }
            DownloadApi.g(arrayList, new a(str));
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(TAG, "innerQueryDownloadInfo>>>", e16);
        }
    }

    private void innerQueryDownloadInfoByVia(String str, String str2) {
        try {
            DownloadApi.h(str, new b(str2));
        } catch (Exception e16) {
            com.tencent.open.base.f.d(TAG, "innerQueryDownloadInfoByVia Exception>>>", e16);
        }
    }

    public static String parseCurrentPageId(Activity activity) {
        String refIdFromActivity = getRefIdFromActivity(activity);
        if (TextUtils.isEmpty(refIdFromActivity)) {
            refIdFromActivity = getSourceInfoFromActivity(activity);
        }
        com.tencent.open.base.f.a(TAG, ">parseCurrentPageId " + refIdFromActivity);
        return refIdFromActivity;
    }

    public static String parseSourceType(Activity activity, JSONObject jSONObject) {
        String optString = jSONObject.optString("sourceType");
        String optString2 = jSONObject.optString("source");
        if (!TextUtils.isEmpty(optString2)) {
            return optString2;
        }
        if (TextUtils.isEmpty(optString)) {
            optString = getSourceInfoFromActivity(activity);
        }
        com.tencent.open.base.f.e(TAG, ">parseSourceType sourceType=" + optString);
        return optString;
    }

    public void cancelDownload(String str, String str2) {
        if (!hasRight()) {
            return;
        }
        DownloadApi.a(str, str2, true);
    }

    public void cancelNotification(String str) {
        if (!hasRight()) {
            return;
        }
        DownloadManager.C().i(str);
    }

    public void checkUpdate(String str) {
        checkUpdate(str, "");
    }

    public void delDelayDownloadTasks(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(Constants.Raft.TASKS);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                GameCenterUtil.deleteAppidFromList(jSONArray.get(i3).toString(), "DELAY_LIST");
            }
            jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
        } catch (Exception e16) {
            com.tencent.open.base.f.d(TAG, "delDelayDownloadTasks>>>", e16);
        }
    }

    public void deleteDownload(String str, String str2) {
        if (!hasRight()) {
            return;
        }
        DownloadApi.c(str, str2, true);
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public void destroy() {
        com.tencent.open.base.f.a(TAG, "destroy");
        com.tencent.open.business.base.d.a().d(this);
        if (UpdateManager.e()) {
            UpdateManager.d().h(this.listener);
        }
    }

    public int doDownloadAction(String str) {
        ApkUpdateDetail apkUpdateDetail;
        ApkUpdateDetail apkUpdateDetail2;
        String optString;
        String[] split;
        com.tencent.open.base.f.a("TIME-STATISTIC", "DownloadInterface--doDownloadAction");
        if (!hasRight()) {
            return -1;
        }
        Bundle bundle = new Bundle();
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(this.mActivity) >= 6) {
            bundle.putLong(OuterCallLog.OuterCall_JS_DoDownloadAction, System.currentTimeMillis());
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("delayDownload")) {
                int optInt = jSONObject.optInt("delayDownload", -1);
                Activity activity = this.mActivity;
                if (activity instanceof BaseActivity) {
                }
                String optString2 = jSONObject.optString("appid");
                if (1 == optInt) {
                    GameCenterUtil.addAppidToList(optString2, "DELAY_LIST");
                    GameCenterUtil.saveAppDetail(optString2, str, "DELAY_APPID_DETAIL_");
                    GameCenterBroadcastReceiver.c();
                    sendRemoteReq(com.tencent.mobileqq.emosm.a.a("gamecenter_delaydownload", "callback", 0, null), false, false);
                    return 0;
                }
                apkUpdateDetail = null;
                if (optInt == 0) {
                    GameCenterUtil.deleteAppidFromList(optString2, "DELAY_LIST");
                }
            } else {
                apkUpdateDetail = null;
            }
            bundle.putString(com.tencent.open.downloadnew.e.f341493b, jSONObject.optString("appid"));
            bundle.putString(com.tencent.open.downloadnew.e.f341501j, jSONObject.optString("url"));
            bundle.putString(com.tencent.open.downloadnew.e.f341497f, jSONObject.optString("packageName"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341502k, jSONObject.optInt("actionCode"));
            bundle.putString(com.tencent.open.downloadnew.e.f341500i, jSONObject.optString("via"));
            bundle.putString(com.tencent.open.downloadnew.e.f341503l, jSONObject.optString("appName"));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341510s, changeIntToBoolean(jSONObject.optInt("showNetworkDialog")));
            bundle.putString(com.tencent.open.downloadnew.e.F, jSONObject.optString("iconUrl"));
            bundle.putInt(com.tencent.open.downloadnew.e.J, jSONObject.optInt("showNotification"));
            bundle.putBoolean(com.tencent.open.downloadnew.e.L, changeIntToBoolean(jSONObject.optInt("isAutoInstallBySdk")));
            bundle.putString(com.tencent.open.downloadnew.e.K, jSONObject.optString(WadlProxyConsts.EXTRA_DATA));
            bundle.putString(com.tencent.open.downloadnew.e.H, jSONObject.optString("downloadStyle"));
            bundle.putString(com.tencent.open.downloadnew.e.I, jSONObject.optString("downloadSize"));
            bundle.putString(com.tencent.open.downloadnew.e.f341507p, jSONObject.optString("wording"));
            String optString3 = jSONObject.optString("source");
            bundle.putString("big_brother_source_key", optString3);
            boolean optBoolean = jSONObject.optBoolean("isUniteDownload", false);
            bundle.putBoolean(com.tencent.open.downloadnew.e.A, optBoolean);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[UniteDownload] jsapi doDownloadAction: invoked. ", " source: ", optString3, " isUniteDownload: ", Boolean.valueOf(optBoolean));
            }
            String optString4 = jSONObject.optString(com.tencent.open.downloadnew.e.D);
            com.tencent.open.base.f.i(TAG, " feedChannel:" + optString4);
            String str2 = "";
            if (!TextUtils.isEmpty(optString4) && !optString4.startsWith("0;") && (split = optString4.split(";")) != null && split.length > 0) {
                String str3 = split[0];
                if (!TextUtils.isEmpty(str3) && !str3.equals("0")) {
                    str2 = str3;
                }
            }
            com.tencent.open.base.f.i(TAG, " finalFeedChannel:" + str2);
            bundle.putString(com.tencent.open.downloadnew.e.D, str2);
            String optString5 = jSONObject.optString("via");
            String optString6 = jSONObject.optString("appid");
            int optInt2 = jSONObject.optInt("actionCode");
            e eVar = this.lastActionRecord;
            if (eVar == null) {
                this.lastActionRecord = new e(optString6, optString5, optInt2);
            } else if (eVar.a(optString6, optString5, optInt2)) {
                return 0;
            }
            if (jSONObject.optInt("actionCode") == 12) {
                bundle.putBoolean(com.tencent.open.downloadnew.e.f341506o, changeIntToBoolean(jSONObject.optInt("updateType")));
                if (jSONObject.has("updateData")) {
                    try {
                        optString = jSONObject.optString("updateData");
                    } catch (Exception unused) {
                        apkUpdateDetail2 = apkUpdateDetail;
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        apkUpdateDetail2 = new ApkUpdateDetail();
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString);
                            apkUpdateDetail2.packageName = jSONObject2.optString("packageName");
                            apkUpdateDetail2.newapksize = jSONObject2.optInt("newapksize");
                            apkUpdateDetail2.patchsize = jSONObject2.optInt("patchsize");
                            apkUpdateDetail2.updatemethod = jSONObject2.optInt("updatemethod");
                            apkUpdateDetail2.versioncode = jSONObject2.optInt("versioncode");
                            apkUpdateDetail2.versionname = jSONObject2.optString("versionname");
                            apkUpdateDetail2.fileMd5 = jSONObject2.optString("fileMd5");
                            apkUpdateDetail2.sigMd5 = jSONObject2.optString("sigMd5");
                            apkUpdateDetail2.url = jSONObject2.optString("url");
                        } catch (Exception unused2) {
                            com.tencent.open.base.f.a(TAG, "enter doDownloadAction updateData json");
                            apkUpdateDetail = apkUpdateDetail2;
                            int optInt3 = jSONObject.optInt("myAppConfig");
                            bundle.putString(com.tencent.open.downloadnew.e.f341494c, jSONObject.optString("myAppId"));
                            bundle.putString(com.tencent.open.downloadnew.e.f341495d, jSONObject.optString("apkId"));
                            bundle.putInt(com.tencent.open.downloadnew.e.f341496e, jSONObject.optInt("versionCode"));
                            bundle.putInt(com.tencent.open.downloadnew.e.f341505n, jSONObject.optInt("toPageType"));
                            bundle.putBoolean(com.tencent.open.downloadnew.e.f341498g, changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
                            bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
                            bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, jSONObject.optBoolean("bolckNotify"));
                            String parseSourceType = parseSourceType(this.mActivity, jSONObject);
                            bundle.putString(LaunchParam.KEY_REF_ID, parseCurrentPageId(this.mActivity));
                            com.tencent.open.base.f.a(TAG, "doDownloadAction object " + jSONObject.toString());
                            DownloadApi.d(this.mActivity, bundle, parseSourceType, apkUpdateDetail, optInt3);
                            return 0;
                        }
                        apkUpdateDetail = apkUpdateDetail2;
                    }
                }
            }
            int optInt32 = jSONObject.optInt("myAppConfig");
            bundle.putString(com.tencent.open.downloadnew.e.f341494c, jSONObject.optString("myAppId"));
            bundle.putString(com.tencent.open.downloadnew.e.f341495d, jSONObject.optString("apkId"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341496e, jSONObject.optInt("versionCode"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341505n, jSONObject.optInt("toPageType"));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341498g, changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, jSONObject.optBoolean("bolckNotify"));
            String parseSourceType2 = parseSourceType(this.mActivity, jSONObject);
            bundle.putString(LaunchParam.KEY_REF_ID, parseCurrentPageId(this.mActivity));
            com.tencent.open.base.f.a(TAG, "doDownloadAction object " + jSONObject.toString());
            DownloadApi.d(this.mActivity, bundle, parseSourceType2, apkUpdateDetail, optInt32);
            return 0;
        } catch (NumberFormatException e16) {
            com.tencent.open.base.f.d(TAG, "Exception", e16);
            return -1;
        } catch (JSONException e17) {
            com.tencent.open.base.f.d(TAG, "JSONException", e17);
            return -1;
        }
    }

    public void doGCDownloadAction(String str) {
        doDownloadAction(str);
    }

    public int doQueryDownloadStatus(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("downloadUrl");
            String optString2 = jSONObject.optString("callback");
            TMAssistantDownloadTaskInfo F = DownloadManager.C().F(optString);
            if (F == null) {
                return -1;
            }
            int i3 = (int) ((((float) F.mReceiveDataLen) / ((float) F.mTotalDataLen)) * 100.0f);
            int i16 = F.mState;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("progress", i3);
            jSONObject2.put("status", i16);
            WebView webView = this.webview;
            if (webView != null && (webView instanceof CustomWebView)) {
                ((CustomWebView) webView).callJs(optString2, jSONObject2.toString());
            }
            return 0;
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(TAG, "JSONException", e16);
            return -1;
        }
    }

    public void doWifiDownloadAction(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.tencent.open.base.f.a(TAG, "doDownloadAction object " + jSONObject.toString());
            MyAppApi.z().k0(this.mActivity, jSONObject.optString("via"), "biz_src_yyb");
        } catch (Exception e16) {
            com.tencent.open.base.f.d(TAG, "doWifiDownloadAction>>>", e16);
        }
    }

    public void getDelayDownloadTasks() {
        String readFromSp = GameCenterSpUtils.readFromSp("DELAY_LIST");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(readFromSp)) {
            String[] split = readFromSp.split("\\|");
            for (int i3 = 0; i3 < split.length; i3++) {
                if (!TextUtils.isEmpty(split[i3])) {
                    try {
                        jSONObject.put("appid", split[i3]);
                        jSONArray.mo162put(jSONObject);
                    } catch (JSONException e16) {
                        com.tencent.open.base.f.d(TAG, "getDelayDownloadTasks>>>", e16);
                    }
                }
            }
        }
        jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + jSONArray.toString() + "});}void(0);");
    }

    public String getDownloadVersion() {
        return DownloadApi.i() + "";
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public String getInterfaceName() {
        return PLUGIN_NAMESPACE;
    }

    @Override // com.tencent.open.business.base.c
    public String getJsCallbackMethod() {
        return this.jsCallBackMethod;
    }

    public void getQueryDownloadAction(String str, String str2) {
        try {
            innerQueryDownloadInfo(new JSONArray(str), str2);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(TAG, "query>>>", e16);
        }
    }

    public void getQueryDownloadActionByVia(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            innerQueryDownloadInfoByVia(jSONObject.getString("via"), jSONObject.getString("guid"));
        } catch (Exception e16) {
            com.tencent.open.base.f.d(TAG, "query>>>", e16);
        }
    }

    @Override // com.tencent.open.business.base.c
    public WebView getWebview() {
        return this.webview;
    }

    public void installYYB() {
        MyAppApi.z().J(this.mActivity);
    }

    protected void jsCallBack(final String str) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.open.appcommon.js.DownloadInterface.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (DownloadInterface.this.webview != null && !TextUtils.isEmpty(str)) {
                        DownloadInterface.this.webview.loadUrl(str);
                    }
                } catch (Exception e16) {
                    com.tencent.open.base.f.b(DownloadInterface.TAG, "webview loadUrl>>> ", e16);
                }
            }
        });
    }

    public int openDownloaderWebview(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            bundle.putString("url", jSONObject.optString("url"));
            DownloadApi.m(this.mActivity, bundle);
            return 0;
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(TAG, "JSONException", e16);
            return 0;
        }
    }

    public void registerDownloadCallBackListener(String str) {
        com.tencent.open.base.f.a(TAG, "enter registerDownloadCallBackListener");
        this.jsCallBackMethod = str;
    }

    protected void sendRemoteReq(Bundle bundle, boolean z16, boolean z17) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            if (z17) {
                Toast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.f171906ls4), 0).show();
            }
        } else if (z16) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(bundle);
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(bundle);
        }
    }

    public int setDownloaderFirstOpenPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            bundle.putString("url", jSONObject.optString("url"));
            long optLong = jSONObject.optLong(AEEditorConstants.VIDEO_CLIP_START_TIME);
            long optLong2 = jSONObject.optLong(AEEditorConstants.VIDEO_CLIP_END_TIME);
            com.tencent.open.base.f.a(TAG, optLong + "|" + optLong2 + "|" + (System.currentTimeMillis() - optLong));
            bundle.putLong("startTime", optLong);
            bundle.putLong("endTime", optLong2);
            DownloadApi.p(bundle);
            return 0;
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(TAG, "JSONException", e16);
            return 0;
        }
    }

    public int setDownloaderFirstOpenPageByTmast(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            bundle.putString("url", jSONObject.optString("url"));
            DownloadApi.q(bundle);
            return 0;
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(TAG, "JSONException", e16);
            return 0;
        }
    }

    public void checkUpdate(String str, String str2) {
        com.tencent.open.base.f.a(TAG, "enter checkUpdate json=" + str + ", guid = " + str2);
        if (hasRight()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = jSONObject.optString("guid");
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("packageNames");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList.add(optJSONArray.getString(i3));
                    }
                }
                UpdateManager.a aVar = this.listener;
                if (aVar == null) {
                    this.listener = new c(str2);
                    UpdateManager.d().g(this.listener);
                } else {
                    ((c) aVar).b(str2);
                }
                UpdateManager.d().a(arrayList);
            } catch (JSONException e16) {
                com.tencent.open.base.f.d(TAG, "httpRequest JSONException", e16);
            }
        }
    }

    public void getQueryDownloadAction(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            innerQueryDownloadInfo(jSONObject.getJSONArray("infolist"), jSONObject.getString("guid"));
        } catch (Exception e16) {
            com.tencent.open.base.f.d(TAG, "query>>>", e16);
        }
    }
}
