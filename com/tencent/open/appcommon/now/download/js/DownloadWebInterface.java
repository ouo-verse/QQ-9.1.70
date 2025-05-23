package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.base.f;
import com.tencent.open.business.base.c;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.e;
import com.tencent.smtt.sdk.WebView;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadWebInterface extends BaseInterface implements c {
    public static final String PLUGIN_NAMESPACE = "q_download_now";
    protected final String TAG;
    protected String jsCallBackMethod;
    protected UpdateManager.a listener;
    protected Activity mActivity;
    protected Handler mHandler;
    protected final WebView webview;

    public DownloadWebInterface(Activity activity, WebView webView) {
        String simpleName = DownloadWebInterface.class.getSimpleName();
        this.TAG = simpleName;
        this.jsCallBackMethod = "";
        f.a(simpleName, "init in");
        this.mActivity = activity;
        this.webview = webView;
        this.mHandler = new Handler(Looper.getMainLooper());
        AppInterface appInterface = null;
        if (activity instanceof PublicFragmentActivityForTool) {
            appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        } else if (activity instanceof BaseActivity) {
            appInterface = (AppInterface) ((BaseActivity) activity).getAppRuntime();
        }
        DownloadManager.C().b0(appInterface);
        a.a().c(this);
        f.a(simpleName, "init out");
    }

    public static boolean changeIntToBoolean(int i3) {
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public void destroy() {
        f.a(this.TAG, "destroy");
        a.a().d(this);
        if (UpdateManager.e()) {
            UpdateManager.d().h(this.listener);
        }
        com.tencent.open.appcommon.now.download.a.e().i(DownloadCallbackWebImpl.h());
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0241 A[Catch: NumberFormatException -> 0x0268, JSONException -> 0x0272, TryCatch #4 {NumberFormatException -> 0x0268, JSONException -> 0x0272, blocks: (B:7:0x002b, B:9:0x00d7, B:10:0x00e0, B:13:0x0107, B:16:0x0111, B:19:0x011b, B:22:0x011f, B:24:0x0127, B:28:0x0132, B:30:0x015d, B:42:0x01d5, B:44:0x01dd, B:46:0x0241, B:47:0x0247), top: B:6:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int doDownloadAction(String str) {
        String optString;
        String[] split;
        f.a("TIME-STATISTIC", "DownloadWebInterface--doDownloadAction");
        if (!hasRight()) {
            return -1;
        }
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bundle.putString(e.f341493b, jSONObject.optString("appid"));
            bundle.putString(e.f341501j, jSONObject.optString("url"));
            bundle.putString(e.f341497f, jSONObject.optString("packageName"));
            bundle.putInt(e.f341502k, jSONObject.optInt("actionCode"));
            bundle.putString(e.f341500i, jSONObject.optString("via"));
            bundle.putString(e.f341503l, jSONObject.optString("appName"));
            bundle.putBoolean(e.f341510s, changeIntToBoolean(jSONObject.optInt("showNetworkDialog")));
            bundle.putString(e.F, jSONObject.optString("iconUrl"));
            bundle.putInt(e.J, jSONObject.optInt("showNotification"));
            bundle.putBoolean(e.L, changeIntToBoolean(jSONObject.optInt("isAutoInstallBySdk")));
            bundle.putString(e.K, jSONObject.optString(WadlProxyConsts.EXTRA_DATA));
            bundle.putString(e.H, jSONObject.optString("downloadStyle"));
            bundle.putString(e.I, jSONObject.optString("downloadSize"));
            bundle.putString(e.f341507p, jSONObject.optString("wording"));
            if (jSONObject.has("bolckNotify")) {
                bundle.putBoolean(e.f341515x, jSONObject.optBoolean("bolckNotify"));
            }
            String optString2 = jSONObject.optString(e.D);
            f.i(this.TAG, " feedChannel:" + optString2);
            String str2 = "";
            if (!TextUtils.isEmpty(optString2) && !optString2.startsWith("0;") && (split = optString2.split(";")) != null && split.length > 0) {
                String str3 = split[0];
                if (!TextUtils.isEmpty(str3) && !str3.equals("0")) {
                    str2 = str3;
                }
            }
            f.i(this.TAG, " finalFeedChannel:" + str2);
            bundle.putString(e.D, str2);
            jSONObject.optString("via");
            jSONObject.optString("appid");
            ApkUpdateDetail apkUpdateDetail = null;
            if (jSONObject.optInt("actionCode") == 12) {
                bundle.putBoolean(e.f341506o, changeIntToBoolean(jSONObject.optInt("updateType")));
                if (jSONObject.has("updateData")) {
                    try {
                        String optString3 = jSONObject.optString("updateData");
                        if (!TextUtils.isEmpty(optString3)) {
                            ApkUpdateDetail apkUpdateDetail2 = new ApkUpdateDetail();
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString3);
                                apkUpdateDetail2.packageName = jSONObject2.optString("packageName");
                                apkUpdateDetail2.newapksize = jSONObject2.optInt("newapksize");
                                apkUpdateDetail2.patchsize = jSONObject2.optInt("patchsize");
                                apkUpdateDetail2.updatemethod = jSONObject2.optInt("updatemethod");
                                apkUpdateDetail2.versioncode = jSONObject2.optInt("versioncode");
                                apkUpdateDetail2.versionname = jSONObject2.optString("versionname");
                                apkUpdateDetail2.fileMd5 = jSONObject2.optString("fileMd5");
                                apkUpdateDetail2.sigMd5 = jSONObject2.optString("sigMd5");
                                apkUpdateDetail2.url = jSONObject2.optString("url");
                                apkUpdateDetail = apkUpdateDetail2;
                            } catch (Exception unused) {
                                apkUpdateDetail = apkUpdateDetail2;
                                f.a(this.TAG, "enter doDownloadAction updateData json");
                                int optInt = jSONObject.optInt("myAppConfig");
                                bundle.putString(e.f341494c, jSONObject.optString("myAppId"));
                                bundle.putString(e.f341495d, jSONObject.optString("apkId"));
                                bundle.putInt(e.f341496e, jSONObject.optInt("versionCode"));
                                bundle.putInt(e.f341505n, jSONObject.optInt("toPageType"));
                                bundle.putBoolean(e.f341498g, changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
                                bundle.putBoolean(e.f341499h, changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
                                optString = jSONObject.optString("sourceType");
                                if (TextUtils.isEmpty(optString)) {
                                }
                                f.a(this.TAG, "doDownloadAction object " + jSONObject.toString());
                                DownloadJSApi.d(this.mActivity, bundle, optString, apkUpdateDetail, optInt);
                                return 0;
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            int optInt2 = jSONObject.optInt("myAppConfig");
            bundle.putString(e.f341494c, jSONObject.optString("myAppId"));
            bundle.putString(e.f341495d, jSONObject.optString("apkId"));
            bundle.putInt(e.f341496e, jSONObject.optInt("versionCode"));
            bundle.putInt(e.f341505n, jSONObject.optInt("toPageType"));
            bundle.putBoolean(e.f341498g, changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
            bundle.putBoolean(e.f341499h, changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
            optString = jSONObject.optString("sourceType");
            if (TextUtils.isEmpty(optString)) {
                optString = DownloadInterface.getSourceInfoFromActivity(this.mActivity);
            }
            f.a(this.TAG, "doDownloadAction object " + jSONObject.toString());
            DownloadJSApi.d(this.mActivity, bundle, optString, apkUpdateDetail, optInt2);
            return 0;
        } catch (NumberFormatException e16) {
            f.d(this.TAG, "Exception", e16);
            return -1;
        } catch (JSONException e17) {
            f.d(this.TAG, "JSONException", e17);
            return -1;
        }
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

    @Override // com.tencent.open.business.base.c
    public WebView getWebview() {
        return this.webview;
    }

    protected void jsCallBack(final String str) {
        this.mHandler.post(new Runnable() { // from class: com.tencent.open.appcommon.now.download.js.DownloadWebInterface.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (DownloadWebInterface.this.webview != null && !TextUtils.isEmpty(str)) {
                        DownloadWebInterface.this.webview.loadUrl(str);
                    }
                } catch (Exception e16) {
                    f.b(DownloadWebInterface.this.TAG, "webview loadUrl>>> ", e16);
                }
            }
        });
    }

    public void registerDownloadCallBackListener(String str) {
        f.a(this.TAG, "enter registerDownloadCallBackListener");
        this.jsCallBackMethod = str;
        com.tencent.open.appcommon.now.download.a.e().b(DownloadCallbackWebImpl.h());
    }
}
