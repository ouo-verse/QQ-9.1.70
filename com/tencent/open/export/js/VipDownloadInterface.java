package com.tencent.open.export.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.business.base.d;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.e;
import com.tencent.open.downloadnew.f;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VipDownloadInterface extends BaseInterface implements com.tencent.open.business.base.c {

    /* renamed from: d, reason: collision with root package name */
    protected final String f341533d;

    /* renamed from: e, reason: collision with root package name */
    protected String f341534e;

    /* renamed from: f, reason: collision with root package name */
    protected Handler f341535f;

    /* renamed from: h, reason: collision with root package name */
    protected final WebView f341536h;

    /* renamed from: i, reason: collision with root package name */
    protected final Activity f341537i;

    /* renamed from: m, reason: collision with root package name */
    protected UpdateManager.a f341538m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f341540a;

        a(String str) {
            this.f341540a = str;
        }

        @Override // com.tencent.open.downloadnew.f
        public void onException(int i3, String str) {
            com.tencent.open.base.f.c(VipDownloadInterface.this.f341533d, "getQueryDownloadAction ERROR");
        }

        @Override // com.tencent.open.downloadnew.f
        public void onResult(List<DownloadInfo> list) {
            com.tencent.open.base.f.a(VipDownloadInterface.this.f341533d, "getQueryDownloadAction onResult = " + list.size());
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
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                jSONArray.mo162put(jSONObject);
            }
            String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + this.f341540a + ", \"r\" : 0, \"data\":" + jSONArray.toString() + "});}void(0);";
            com.tencent.open.base.f.a(VipDownloadInterface.this.f341533d, "querySucess : " + str);
            VipDownloadInterface.this.jsCallBack(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements f {
        b() {
        }

        @Override // com.tencent.open.downloadnew.f
        public void onException(int i3, String str) {
            com.tencent.open.base.f.c(VipDownloadInterface.this.f341533d, "getQueryDownloadAction onException code = " + i3 + " msg= ");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i3);
                jSONObject.put("errMsg", str);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            VipDownloadInterface.this.jsCallBack("javascript:publicAccountDownload.queryProcess(" + jSONObject.toString() + ")");
        }

        @Override // com.tencent.open.downloadnew.f
        public void onResult(List<DownloadInfo> list) {
            com.tencent.open.base.f.h(VipDownloadInterface.this.f341533d, "getQueryDownloadAction onResult = " + list.size());
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
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                jSONArray.mo162put(jSONObject);
            }
            String str = "javascript:publicAccountDownload.queryProcess(" + jSONArray.toString() + ")";
            com.tencent.open.base.f.h(VipDownloadInterface.this.f341533d, "getQueryDownloadAction callback url = " + str);
            VipDownloadInterface.this.jsCallBack(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements UpdateManager.a {

        /* renamed from: a, reason: collision with root package name */
        protected final String f341543a;

        public c(String str) {
            com.tencent.open.base.f.e(VipDownloadInterface.this.f341533d, "new  JsCheckUpdateCallback");
            this.f341543a = str;
        }

        @Override // com.tencent.open.downloadnew.UpdateManager.a
        public void a(String str) {
            if (!VipDownloadInterface.this.hasRight()) {
                return;
            }
            com.tencent.open.base.f.c(VipDownloadInterface.this.f341533d, "JsCheckUpdateCallback onException >>> " + str);
            VipDownloadInterface.this.jsCallBack("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.f341543a + "\",\"r\":\"-1\"});}void(0);");
        }

        @Override // com.tencent.open.downloadnew.UpdateManager.a
        public void onResult(ArrayList<ApkUpdateDetail> arrayList) {
            String str;
            if (!VipDownloadInterface.this.hasRight()) {
                return;
            }
            com.tencent.open.base.f.h(VipDownloadInterface.this.f341533d, "JsCheckUpdateCallback onResult >>> " + arrayList.size());
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
                    str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.f341543a + "\",\"r\":\"-1\"});}void(0);";
                }
            }
            jSONObject.put("guid", this.f341543a);
            jSONObject.put("content", jSONArray.toString());
            jSONObject.put(QzoneIPCModule.RESULT_CODE, "0");
            str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{'guid':'" + this.f341543a + "','r':'0','data':'" + jSONArray.toString() + "'});}void(0);";
            com.tencent.open.base.f.e(VipDownloadInterface.this.f341533d, ">>checkUpdate jsUrl:" + str);
            VipDownloadInterface.this.jsCallBack(str);
        }
    }

    public VipDownloadInterface(Activity activity, WebView webView) {
        String simpleName = VipDownloadInterface.class.getSimpleName();
        this.f341533d = simpleName;
        this.f341534e = "";
        com.tencent.open.base.f.a(simpleName, "init in");
        this.f341536h = webView;
        this.f341537i = activity;
        this.f341535f = new Handler(Looper.getMainLooper());
        AppInterface appInterface = null;
        if (activity instanceof PublicFragmentActivityForTool) {
            appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        } else if (activity instanceof BaseActivity) {
            appInterface = (AppInterface) ((BaseActivity) activity).getAppRuntime();
        }
        DownloadManager.C().b0(appInterface);
        DownloadManager.C();
        com.tencent.open.base.f.a(simpleName, "init out");
    }

    public boolean cancelDownload(String str, String str2) {
        if (!hasRight()) {
            return false;
        }
        DownloadApi.a(str, str2, true);
        return true;
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

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public void destroy() {
        com.tencent.open.base.f.a(this.f341533d, "destroy");
        d.a().d(this);
        if (UpdateManager.e()) {
            UpdateManager.d().h(this.f341538m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0255 A[Catch: NumberFormatException -> 0x0279, JSONException -> 0x0286, TryCatch #2 {JSONException -> 0x0286, blocks: (B:15:0x0106, B:18:0x010f, B:20:0x0175, B:30:0x01f9, B:32:0x0255, B:33:0x025b, B:38:0x01ef), top: B:14:0x0106 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doDownloadAction(String str) {
        String str2;
        JSONObject jSONObject;
        ApkUpdateDetail apkUpdateDetail;
        String optString;
        String optString2;
        com.tencent.open.base.f.h(this.f341533d, "enter doDownloadAction json=" + str);
        if (!hasRight()) {
            return;
        }
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            int optInt = jSONObject2.optInt("myAppConfig");
            String optString3 = jSONObject2.optString(e.D);
            if (TextUtils.isEmpty(optString3) || optString3.equals("0")) {
                optString3 = "";
            }
            com.tencent.open.base.f.h(this.f341533d, "finalChannel :" + optString3);
            if (optInt == 0) {
                try {
                    bundle.putString(e.f341493b, jSONObject2.optString("appid"));
                    bundle.putString(e.f341501j, jSONObject2.optString("url"));
                    bundle.putString(e.f341497f, jSONObject2.optString("packageName"));
                    bundle.putInt(e.f341502k, jSONObject2.optInt("actionCode"));
                    bundle.putString(e.f341500i, jSONObject2.optString("via"));
                    bundle.putString(e.f341503l, jSONObject2.optString("appName"));
                    bundle.putString(e.D, optString3);
                    String optString4 = jSONObject2.optString("sourceType");
                    if (TextUtils.isEmpty(optString4)) {
                        optString4 = DownloadInterface.getSourceInfoFromActivity(this.f341537i);
                    }
                    if (!"biz_src_news".equals(optString4)) {
                        optString4 = "biz_src_jc_vip";
                    }
                    com.tencent.open.base.f.h(this.f341533d, "doDownloadAction object " + jSONObject2.toString());
                    DownloadApi.d(this.f341537i, bundle, optString4, null, 0);
                    return;
                } catch (NumberFormatException e16) {
                    com.tencent.open.base.f.d(this.f341533d, "Exception", e16);
                    return;
                }
            }
            try {
                try {
                    jSONObject = new JSONObject(str);
                    str2 = "Exception";
                } catch (NumberFormatException e17) {
                    e = e17;
                    str2 = "Exception";
                }
                try {
                    bundle.putString(e.f341493b, jSONObject.optString("appid"));
                    bundle.putString(e.f341501j, jSONObject.optString("url"));
                    bundle.putString(e.f341497f, jSONObject.optString("packageName"));
                    bundle.putInt(e.f341502k, jSONObject.optInt("actionCode"));
                    bundle.putString(e.f341500i, jSONObject.optString("via"));
                    bundle.putString(e.f341503l, jSONObject.optString("appName"));
                    bundle.putBoolean(e.f341510s, DownloadInterface.changeIntToBoolean(jSONObject.optInt("showNetworkDialog")));
                    bundle.putString(e.f341507p, jSONObject.optString("wording"));
                    bundle.putString(e.D, optString3);
                    jSONObject.optString("via");
                    jSONObject.optString("appid");
                    jSONObject.optInt("actionCode");
                    if (jSONObject.optInt("actionCode") == 12) {
                        bundle.putBoolean(e.f341506o, DownloadInterface.changeIntToBoolean(jSONObject.optInt("updateType")));
                        if (jSONObject.has("updateData")) {
                            try {
                                optString2 = jSONObject.optString("updateData");
                            } catch (Exception unused) {
                                apkUpdateDetail = null;
                            }
                            if (!TextUtils.isEmpty(optString2)) {
                                ApkUpdateDetail apkUpdateDetail2 = new ApkUpdateDetail();
                                try {
                                    JSONObject jSONObject3 = new JSONObject(optString2);
                                    apkUpdateDetail2.packageName = jSONObject3.optString("packageName");
                                    apkUpdateDetail2.newapksize = jSONObject3.optInt("newapksize");
                                    apkUpdateDetail2.patchsize = jSONObject3.optInt("patchsize");
                                    apkUpdateDetail2.updatemethod = jSONObject3.optInt("updatemethod");
                                    apkUpdateDetail2.versioncode = jSONObject3.optInt("versioncode");
                                    apkUpdateDetail2.versionname = jSONObject3.optString("versionname");
                                    apkUpdateDetail2.fileMd5 = jSONObject3.optString("fileMd5");
                                    apkUpdateDetail2.sigMd5 = jSONObject3.optString("sigMd5");
                                    apkUpdateDetail2.url = jSONObject3.optString("url");
                                    apkUpdateDetail = apkUpdateDetail2;
                                } catch (Exception unused2) {
                                    apkUpdateDetail = apkUpdateDetail2;
                                    com.tencent.open.base.f.a(this.f341533d, "enter doDownloadAction updateData json");
                                    bundle.putString(e.f341494c, jSONObject.optString("myAppId"));
                                    bundle.putString(e.f341495d, jSONObject.optString("apkId"));
                                    bundle.putInt(e.f341496e, jSONObject.optInt("versionCode", -10));
                                    bundle.putInt(e.f341505n, jSONObject.optInt("toPageType"));
                                    bundle.putBoolean(e.f341498g, DownloadInterface.changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
                                    bundle.putBoolean(e.f341499h, DownloadInterface.changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
                                    optString = jSONObject.optString("sourceType");
                                    if (TextUtils.isEmpty(optString)) {
                                    }
                                    com.tencent.open.base.f.a(this.f341533d, "doDownloadAction object " + jSONObject.toString());
                                    DownloadApi.d(this.f341537i, bundle, optString, apkUpdateDetail, optInt);
                                }
                                bundle.putString(e.f341494c, jSONObject.optString("myAppId"));
                                bundle.putString(e.f341495d, jSONObject.optString("apkId"));
                                bundle.putInt(e.f341496e, jSONObject.optInt("versionCode", -10));
                                bundle.putInt(e.f341505n, jSONObject.optInt("toPageType"));
                                bundle.putBoolean(e.f341498g, DownloadInterface.changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
                                bundle.putBoolean(e.f341499h, DownloadInterface.changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
                                optString = jSONObject.optString("sourceType");
                                if (TextUtils.isEmpty(optString)) {
                                    optString = DownloadInterface.getSourceInfoFromActivity(this.f341537i);
                                }
                                com.tencent.open.base.f.a(this.f341533d, "doDownloadAction object " + jSONObject.toString());
                                DownloadApi.d(this.f341537i, bundle, optString, apkUpdateDetail, optInt);
                            }
                        }
                    }
                    apkUpdateDetail = null;
                    bundle.putString(e.f341494c, jSONObject.optString("myAppId"));
                    bundle.putString(e.f341495d, jSONObject.optString("apkId"));
                    bundle.putInt(e.f341496e, jSONObject.optInt("versionCode", -10));
                    bundle.putInt(e.f341505n, jSONObject.optInt("toPageType"));
                    bundle.putBoolean(e.f341498g, DownloadInterface.changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
                    bundle.putBoolean(e.f341499h, DownloadInterface.changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
                    optString = jSONObject.optString("sourceType");
                    if (TextUtils.isEmpty(optString)) {
                    }
                    com.tencent.open.base.f.a(this.f341533d, "doDownloadAction object " + jSONObject.toString());
                    DownloadApi.d(this.f341537i, bundle, optString, apkUpdateDetail, optInt);
                } catch (NumberFormatException e18) {
                    e = e18;
                    com.tencent.open.base.f.d(this.f341533d, str2, e);
                }
            } catch (JSONException e19) {
                com.tencent.open.base.f.d(this.f341533d, "JSONException", e19);
            }
        } catch (JSONException e26) {
            com.tencent.open.base.f.d(this.f341533d, "JSONException", e26);
        }
    }

    public String getDownloadVersion() {
        return DownloadApi.i() + "";
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public String getInterfaceName() {
        return "q_download_vip";
    }

    @Override // com.tencent.open.business.base.c
    public String getJsCallbackMethod() {
        return this.f341534e;
    }

    public void getQueryDownloadAction(String str) {
        com.tencent.open.base.f.e(this.f341533d, "enter getQueryDownloadAction = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("infolist");
            String string = jSONObject.getString("guid");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                DownloadInfo downloadInfo = new DownloadInfo();
                downloadInfo.f341184e = jSONObject2.optString("appid");
                downloadInfo.G = jSONObject2.optString("myAppId");
                downloadInfo.H = jSONObject2.optString("apkId");
                downloadInfo.f341189h = jSONObject2.optString("packageName");
                downloadInfo.I = jSONObject2.optInt("versionCode");
                arrayList.add(downloadInfo);
            }
            DownloadApi.g(arrayList, new a(string));
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(this.f341533d, "getQueryDownloadAction>>>", e16);
        }
    }

    @Override // com.tencent.open.business.base.c
    public WebView getWebview() {
        return this.f341536h;
    }

    protected void jsCallBack(final String str) {
        this.f341535f.post(new Runnable() { // from class: com.tencent.open.export.js.VipDownloadInterface.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (VipDownloadInterface.this.f341536h != null && !TextUtils.isEmpty(str)) {
                        VipDownloadInterface.this.f341536h.loadUrl(str);
                    }
                } catch (Exception e16) {
                    com.tencent.open.base.f.b(VipDownloadInterface.this.f341533d, "webview loadUrl>>> ", e16);
                }
            }
        });
    }

    public void registerDownloadCallBackListener(String str) {
        d.a().c(this);
        this.f341534e = str;
    }

    public void checkUpdate(String str, String str2) {
        com.tencent.open.base.f.a(this.f341533d, "enter checkUpdate json=" + str);
        if (hasRight()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = jSONObject.optString("guid");
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("packageNames");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList.add(optJSONArray.getString(i3));
                    }
                }
                if (this.f341538m == null) {
                    this.f341538m = new c(str2);
                    UpdateManager.d().g(this.f341538m);
                }
                UpdateManager.d().a(arrayList);
            } catch (JSONException e16) {
                com.tencent.open.base.f.d(this.f341533d, "httpRequest JSONException", e16);
            }
        }
    }

    public void getQueryDownloadAction(String str, String str2) {
        com.tencent.open.base.f.h(this.f341533d, "enter getQueryDownloadAction = " + str);
        if (hasRight()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < length; i3++) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    downloadInfo.f341184e = jSONArray.getString(i3);
                    arrayList.add(downloadInfo);
                }
                DownloadApi.g(arrayList, new b());
            } catch (JSONException e16) {
                com.tencent.open.base.f.d(this.f341533d, "getQueryDownloadAction>>>", e16);
            }
        }
    }
}
