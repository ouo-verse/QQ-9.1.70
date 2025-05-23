package com.tencent.open.appstore.js;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.dataline.util.d;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.e;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.business.base.c;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantbase.util.OuterCallLog;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import com.tencent.trpcprotocol.sc_report.sso_data_recv.sso_data_recv.DownloadApkReport$DownloadInfo;
import com.tencent.trpcprotocol.sc_report.sso_data_recv.sso_data_recv.DownloadApkReport$InstallInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DINewForCommonWebView extends BaseInterface implements c {

    /* renamed from: e, reason: collision with root package name */
    private WebView f340870e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f340871f;

    /* renamed from: h, reason: collision with root package name */
    private Activity f340872h;

    /* renamed from: d, reason: collision with root package name */
    private String f340869d = "";

    /* renamed from: i, reason: collision with root package name */
    private e f340873i = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f340876a;

        a(String str) {
            this.f340876a = str;
        }

        @Override // com.tencent.open.downloadnew.f
        public void onException(int i3, String str) {
            com.tencent.open.base.f.c("DINewForCommonWebView", "[innerQuery] [onException] errorCode=" + i3 + ", errorMsg=" + str);
        }

        @Override // com.tencent.open.downloadnew.f
        public void onResult(List<DownloadInfo> list) {
            com.tencent.open.base.f.a("DINewForCommonWebView", "[innerQuery] onResult = " + list.size());
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                JSONObject jSONObject = new JSONObject();
                DownloadInfo downloadInfo = list.get(i3);
                try {
                    jSONObject.put("appid", downloadInfo.f341184e);
                    jSONObject.put("packagename", downloadInfo.f341189h);
                    jSONObject.put("versioncode", downloadInfo.I);
                    jSONObject.put("url", downloadInfo.f341186f);
                    jSONObject.put(WadlResult.WEB_KEY_PROGRESS, downloadInfo.Q);
                    jSONObject.put("state", downloadInfo.f());
                    jSONObject.put("ismyapp", downloadInfo.J);
                    jSONObject.put("download_from", downloadInfo.W);
                    jSONObject.put(WadlResult.WEB_KEY_WRITE_CODE_STATE, downloadInfo.f341179a0);
                    if (TextUtils.isEmpty(downloadInfo.L)) {
                        jSONObject.put("final_file_exits", "false");
                    } else {
                        jSONObject.put("final_file_exits", new File(downloadInfo.L).exists());
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                jSONArray.mo162put(jSONObject);
            }
            String str = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + this.f340876a + "(" + jSONArray.toString() + ")";
            com.tencent.open.base.f.a("DINewForCommonWebView", "[innerQuery] querySucess : " + str);
            DINewForCommonWebView.this.jsCallBack(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f340878a;

        /* renamed from: b, reason: collision with root package name */
        private AppRuntime f340879b;

        /* renamed from: c, reason: collision with root package name */
        private String f340880c;

        /* renamed from: d, reason: collision with root package name */
        private String f340881d;

        /* renamed from: e, reason: collision with root package name */
        private String f340882e;

        /* renamed from: f, reason: collision with root package name */
        private String f340883f;

        /* renamed from: g, reason: collision with root package name */
        private String f340884g;

        public b(String str) {
            this.f340878a = str;
        }

        public AppRuntime a() {
            return this.f340879b;
        }

        public String b() {
            return this.f340883f;
        }

        public String c() {
            return this.f340882e;
        }

        public String d() {
            return this.f340880c;
        }

        public String e() {
            return this.f340884g;
        }

        public String f() {
            return this.f340881d;
        }

        public b g() {
            this.f340879b = BaseApplicationImpl.getApplication().getRuntime();
            String[] split = this.f340878a.split("/");
            byte[] guid = ((WtloginManager) this.f340879b.getManager(1)).getGUID();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_14);
            this.f340880c = d.b(d.a());
            this.f340881d = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            this.f340882e = util.buf_to_string(guid);
            this.f340883f = this.f340878a;
            if (split.length != 0) {
                this.f340883f = split[split.length - 1];
            }
            this.f340884g = AppSetting.n();
            return this;
        }
    }

    public DINewForCommonWebView(Activity activity, WebView webView) {
        AppInterface appInterface = null;
        com.tencent.open.base.f.e("DINewForCommonWebView", "<DINewForCommonWebView>");
        this.f340872h = activity;
        this.f340870e = webView;
        this.f340871f = new Handler(Looper.getMainLooper());
        if (activity instanceof PublicFragmentActivityForTool) {
            appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        } else if (activity instanceof BaseActivity) {
            appInterface = (AppInterface) ((BaseActivity) activity).getAppRuntime();
        }
        DownloadManagerV2.V().x0(appInterface);
        com.tencent.open.business.base.d.a().c(this);
    }

    private void c(JSONArray jSONArray, String str) {
        try {
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                DownloadInfo downloadInfo = new DownloadInfo();
                downloadInfo.f341186f = jSONObject.optString("url");
                downloadInfo.f341189h = jSONObject.optString("packageName");
                downloadInfo.I = jSONObject.optInt("versionCode");
                downloadInfo.f341184e = jSONObject.optString("appid");
                downloadInfo.m();
                arrayList.add(downloadInfo);
            }
            DownloadProxy.k().o(arrayList, new a(str));
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("DINewForCommonWebView", "[innerQuery] e=", e16);
        }
    }

    private static boolean changeIntToBoolean(int i3) {
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    private void d(AppRuntime appRuntime, String str, ByteStringMicro byteStringMicro, ByteStringMicro byteStringMicro2, String str2, ByteStringMicro byteStringMicro3) {
        DownloadApkReport$DownloadInfo downloadApkReport$DownloadInfo = new DownloadApkReport$DownloadInfo();
        downloadApkReport$DownloadInfo.filename.set(byteStringMicro);
        downloadApkReport$DownloadInfo.url.set(str);
        downloadApkReport$DownloadInfo.client_ip.set(byteStringMicro2);
        downloadApkReport$DownloadInfo.timestamp.set(str2);
        downloadApkReport$DownloadInfo.guid.set(byteStringMicro3);
        downloadApkReport$DownloadInfo.client_ver.set(AppSetting.n());
        ProtoUtils.d(appRuntime, new com.tencent.mobileqq.webview.b(), downloadApkReport$DownloadInfo.toByteArray(), "trpc.sc_report.sso_data_recv.sso_data_recv.ApkDownload");
    }

    private void e(AppRuntime appRuntime, String str, ByteStringMicro byteStringMicro, ByteStringMicro byteStringMicro2, String str2, ByteStringMicro byteStringMicro3) {
        DownloadApkReport$InstallInfo downloadApkReport$InstallInfo = new DownloadApkReport$InstallInfo();
        downloadApkReport$InstallInfo.filename.set(byteStringMicro);
        downloadApkReport$InstallInfo.url.set(str);
        downloadApkReport$InstallInfo.client_ip.set(byteStringMicro2);
        downloadApkReport$InstallInfo.timestamp.set(str2);
        downloadApkReport$InstallInfo.guid.set(byteStringMicro3);
        downloadApkReport$InstallInfo.client_ver.set(AppSetting.n());
        ProtoUtils.d(appRuntime, new com.tencent.mobileqq.webview.b(), downloadApkReport$InstallInfo.toByteArray(), "trpc.sc_report.sso_data_recv.sso_data_recv.ApkInstall");
    }

    private void f(String str, int i3) {
        b g16 = new b(str).g();
        AppRuntime a16 = g16.a();
        String d16 = g16.d();
        String f16 = g16.f();
        String c16 = g16.c();
        String b16 = g16.b();
        if (QLog.isColorLevel()) {
            QLog.d("DINewForCommonWebView", 2, "reportApkData  ip = ", d16, " date = ", f16, " guid = ", c16, " fileName = ", b16, " url = ", str, " actionCode = ", Integer.valueOf(i3));
        }
        ByteStringMicro copyFromUtf8 = ByteStringMicro.copyFromUtf8(c16);
        ByteStringMicro copyFromUtf82 = ByteStringMicro.copyFromUtf8(b16);
        ByteStringMicro copyFromUtf83 = ByteStringMicro.copyFromUtf8(d16);
        if (i3 == 2) {
            d(a16, str, copyFromUtf82, copyFromUtf83, f16, copyFromUtf8);
        } else if (i3 == 5) {
            e(a16, str, copyFromUtf82, copyFromUtf83, f16, copyFromUtf8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jsCallBack(final String str) {
        this.f340871f.post(new Runnable() { // from class: com.tencent.open.appstore.js.DINewForCommonWebView.2

            /* compiled from: P */
            /* renamed from: com.tencent.open.appstore.js.DINewForCommonWebView$2$a */
            /* loaded from: classes22.dex */
            class a implements ValueCallback<String> {
                a() {
                }

                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    com.tencent.open.base.f.e("DINewForCommonWebView", "[jsCallBack]:" + str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DINewForCommonWebView.this.f340870e.evaluateJavascript(str, new a());
                } catch (Exception e16) {
                    com.tencent.open.base.f.b("DINewForCommonWebView", "[jsCallBack] e>>> ", e16);
                }
            }
        });
    }

    private void sendRemoteReq(Bundle bundle, boolean z16, boolean z17) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            if (z17) {
                Toast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.ln9), 0).show();
            }
        } else if (z16) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(bundle);
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(bundle);
        }
    }

    public int batchDownloadByYYB(String str) {
        JSONException jSONException;
        String str2;
        int i3;
        String str3;
        String str4;
        JSONArray jSONArray;
        String str5 = "";
        com.tencent.open.base.f.e("DINewForCommonWebView", ">batchDownloadByYYB" + str);
        if (!hasRight()) {
            return -1;
        }
        JSONArray jSONArray2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONArray2 = jSONObject.optJSONArray("appInfo");
            String optString = jSONObject.optString(com.tencent.open.downloadnew.e.f341500i);
            try {
                i3 = jSONObject.optInt(com.tencent.open.downloadnew.e.f341502k);
            } catch (JSONException e16) {
                jSONException = e16;
                str2 = "";
                i3 = 0;
            }
            try {
                String optString2 = jSONObject.optString("sourceType");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = DownloadInterface.getSourceInfoFromActivity(this.f340872h);
                }
                str3 = optString2;
                jSONArray = jSONArray2;
                str4 = optString;
            } catch (JSONException e17) {
                jSONException = e17;
                str2 = "";
                str5 = optString;
                com.tencent.open.base.f.d("DINewForCommonWebView", ">batchDownloadByYYB JSONException", jSONException);
                str3 = str2;
                str4 = str5;
                jSONArray = jSONArray2;
                int i16 = i3;
                com.tencent.open.base.f.e("DINewForCommonWebView", ">batchDownloadByYYB appInfo:" + jSONArray + "||via:" + str4);
                if (jSONArray != null) {
                }
                return -1;
            }
        } catch (JSONException e18) {
            jSONException = e18;
            str2 = "";
            i3 = 0;
        }
        int i162 = i3;
        com.tencent.open.base.f.e("DINewForCommonWebView", ">batchDownloadByYYB appInfo:" + jSONArray + "||via:" + str4);
        if (jSONArray != null || jSONArray.length() == 0) {
            return -1;
        }
        MyAppApi.z().j0(this.f340872h, jSONArray, i162, str4, str3);
        return 0;
    }

    public void cancelDownload(String str) {
        if (!hasRight()) {
            return;
        }
        DownloadProxy.k().e(str, true);
    }

    public void deleteDownload(String str) {
        if (!hasRight()) {
            return;
        }
        DownloadProxy.k().f(str, true);
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public void destroy() {
        com.tencent.open.base.f.e("DINewForCommonWebView", "destroy");
        com.tencent.open.business.base.d.a().d(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x01c8, code lost:
    
        if (r0.equals("0") == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int doDownloadAction(String str) {
        String str2;
        String str3;
        ApkUpdateDetail apkUpdateDetail;
        ApkUpdateDetail apkUpdateDetail2;
        String[] split;
        com.tencent.open.base.f.e("DINewForCommonWebView", "[doDownloadAction]" + str);
        if (!hasRight()) {
            return -1;
        }
        Bundle bundle = new Bundle();
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(this.f340872h) >= 6) {
            str2 = "sourceFromServer";
            bundle.putLong(OuterCallLog.OuterCall_JS_DoDownloadAction, System.currentTimeMillis());
        } else {
            str2 = "sourceFromServer";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appId");
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("appid");
            }
            if (jSONObject.has("delayDownload")) {
                int optInt = jSONObject.optInt("delayDownload", -1);
                Activity activity = this.f340872h;
                if (activity instanceof BaseActivity) {
                }
                if (1 == optInt) {
                    GameCenterUtil.addAppidToList(optString, "DELAY_LIST");
                    GameCenterUtil.saveAppDetail(optString, str, "DELAY_APPID_DETAIL_");
                    GameCenterBroadcastReceiver.c();
                    sendRemoteReq(com.tencent.mobileqq.emosm.a.a("gamecenter_delaydownload", "callback", 0, null), false, false);
                    return 0;
                }
                if (optInt == 0) {
                    GameCenterUtil.deleteAppidFromList(optString, "DELAY_LIST");
                }
            }
            bundle.putString(com.tencent.open.downloadnew.e.f341493b, optString);
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
            bundle.putLong(com.tencent.open.downloadnew.e.I, jSONObject.optLong("downloadSize"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341517z, jSONObject.optInt("notificationStyle"));
            bundle.putString(com.tencent.open.downloadnew.e.f341507p, jSONObject.optString("wording"));
            String optString2 = jSONObject.optString(com.tencent.open.downloadnew.e.D);
            com.tencent.open.base.f.e("DINewForCommonWebView", "[doDownloadAction] feedChannel:" + optString2);
            if (!TextUtils.isEmpty(optString2) && !optString2.startsWith("0;") && (split = optString2.split(";")) != null && split.length > 0) {
                str3 = split[0];
                if (!TextUtils.isEmpty(str3)) {
                }
            }
            str3 = "";
            String optString3 = jSONObject.optString(com.tencent.open.downloadnew.e.M);
            com.tencent.open.base.f.e("DINewForCommonWebView", "[doDownloadAction] finalFeedChannel:" + str3);
            if (TextUtils.isEmpty(str3)) {
                bundle.putString(com.tencent.open.downloadnew.e.D, optString3);
            } else {
                bundle.putString(com.tencent.open.downloadnew.e.D, str3);
            }
            String optString4 = jSONObject.optString("via");
            int optInt2 = jSONObject.optInt("actionCode");
            e eVar = this.f340873i;
            if (eVar == null) {
                this.f340873i = new e(optString, optString4, optInt2);
            } else if (eVar.a(optString, optString4, optInt2)) {
                com.tencent.open.base.f.e("DINewForCommonWebView", "[doDownloadAction] repeat action,return");
                return 0;
            }
            if (jSONObject.optInt("actionCode") == 12) {
                bundle.putBoolean(com.tencent.open.downloadnew.e.f341506o, changeIntToBoolean(jSONObject.optInt("updateType")));
                if (jSONObject.has("updateData")) {
                    try {
                        String optString5 = jSONObject.optString("updateData");
                        if (TextUtils.isEmpty(optString5)) {
                            apkUpdateDetail2 = null;
                        } else {
                            ApkUpdateDetail apkUpdateDetail3 = new ApkUpdateDetail();
                            try {
                                JSONObject jSONObject2 = new JSONObject(optString5);
                                apkUpdateDetail3.packageName = jSONObject2.optString("packageName");
                                apkUpdateDetail3.newapksize = jSONObject2.optInt("newapksize");
                                apkUpdateDetail3.patchsize = jSONObject2.optInt("patchsize");
                                apkUpdateDetail3.updatemethod = jSONObject2.optInt("updatemethod");
                                apkUpdateDetail3.versioncode = jSONObject2.optInt("versioncode");
                                apkUpdateDetail3.versionname = jSONObject2.optString("versionname");
                                apkUpdateDetail3.fileMd5 = jSONObject2.optString("fileMd5");
                                apkUpdateDetail3.sigMd5 = jSONObject2.optString("sigMd5");
                                apkUpdateDetail3.url = jSONObject2.optString("url");
                                apkUpdateDetail2 = apkUpdateDetail3;
                            } catch (Exception e16) {
                                e = e16;
                                apkUpdateDetail2 = apkUpdateDetail3;
                                com.tencent.open.base.f.a("DINewForCommonWebView", "[doDownloadAction]  updateData e=" + e.getMessage());
                                apkUpdateDetail = apkUpdateDetail2;
                                int optInt3 = jSONObject.optInt("myAppConfig");
                                bundle.putString(com.tencent.open.downloadnew.e.f341494c, optString);
                                bundle.putString(com.tencent.open.downloadnew.e.f341495d, jSONObject.optString("apkId"));
                                bundle.putInt(com.tencent.open.downloadnew.e.f341496e, jSONObject.optInt("versionCode"));
                                bundle.putInt(com.tencent.open.downloadnew.e.f341505n, jSONObject.optInt("toPageType"));
                                bundle.putBoolean(com.tencent.open.downloadnew.e.f341498g, changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
                                bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
                                bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, jSONObject.optBoolean("bolckNotify"));
                                bundle.putString("recommendId", jSONObject.optString("recommendId"));
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("");
                                String str4 = str2;
                                sb5.append(jSONObject.optInt(str4));
                                bundle.putString(str4, sb5.toString());
                                bundle.putString(com.tencent.open.downloadnew.e.M, optString3);
                                bundle.putString("pageId", "" + jSONObject.optInt("pageId"));
                                bundle.putString("moduleId", "" + jSONObject.optInt("moduleId"));
                                bundle.putString("positionId", "" + jSONObject.optInt("positionId"));
                                bundle.putString("apkId", jSONObject.optString("apkId"));
                                bundle.putString("appId", optString);
                                bundle.putInt("auto_start_yyb_download", jSONObject.optInt("auto_start_yyb_download"));
                                String parseSourceType = DownloadInterface.parseSourceType(this.f340872h, jSONObject);
                                bundle.putString(LaunchParam.KEY_REF_ID, DownloadInterface.parseCurrentPageId(this.f340872h));
                                bundle.putInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, jSONObject.optInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
                                com.tencent.open.base.f.e("DINewForCommonWebView", "[doDownloadAction] object " + jSONObject.toString());
                                f(jSONObject.optString("url"), optInt2);
                                DownloadProxy.k().g(this.f340872h, bundle, parseSourceType, apkUpdateDetail, optInt3);
                                return 0;
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        apkUpdateDetail2 = null;
                    }
                    apkUpdateDetail = apkUpdateDetail2;
                    int optInt32 = jSONObject.optInt("myAppConfig");
                    bundle.putString(com.tencent.open.downloadnew.e.f341494c, optString);
                    bundle.putString(com.tencent.open.downloadnew.e.f341495d, jSONObject.optString("apkId"));
                    bundle.putInt(com.tencent.open.downloadnew.e.f341496e, jSONObject.optInt("versionCode"));
                    bundle.putInt(com.tencent.open.downloadnew.e.f341505n, jSONObject.optInt("toPageType"));
                    bundle.putBoolean(com.tencent.open.downloadnew.e.f341498g, changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
                    bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
                    bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, jSONObject.optBoolean("bolckNotify"));
                    bundle.putString("recommendId", jSONObject.optString("recommendId"));
                    StringBuilder sb52 = new StringBuilder();
                    sb52.append("");
                    String str42 = str2;
                    sb52.append(jSONObject.optInt(str42));
                    bundle.putString(str42, sb52.toString());
                    bundle.putString(com.tencent.open.downloadnew.e.M, optString3);
                    bundle.putString("pageId", "" + jSONObject.optInt("pageId"));
                    bundle.putString("moduleId", "" + jSONObject.optInt("moduleId"));
                    bundle.putString("positionId", "" + jSONObject.optInt("positionId"));
                    bundle.putString("apkId", jSONObject.optString("apkId"));
                    bundle.putString("appId", optString);
                    bundle.putInt("auto_start_yyb_download", jSONObject.optInt("auto_start_yyb_download"));
                    String parseSourceType2 = DownloadInterface.parseSourceType(this.f340872h, jSONObject);
                    bundle.putString(LaunchParam.KEY_REF_ID, DownloadInterface.parseCurrentPageId(this.f340872h));
                    bundle.putInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, jSONObject.optInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
                    com.tencent.open.base.f.e("DINewForCommonWebView", "[doDownloadAction] object " + jSONObject.toString());
                    f(jSONObject.optString("url"), optInt2);
                    DownloadProxy.k().g(this.f340872h, bundle, parseSourceType2, apkUpdateDetail, optInt32);
                    return 0;
                }
            }
            apkUpdateDetail = null;
            int optInt322 = jSONObject.optInt("myAppConfig");
            bundle.putString(com.tencent.open.downloadnew.e.f341494c, optString);
            bundle.putString(com.tencent.open.downloadnew.e.f341495d, jSONObject.optString("apkId"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341496e, jSONObject.optInt("versionCode"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341505n, jSONObject.optInt("toPageType"));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341498g, changeIntToBoolean(jSONObject.optInt("isAutoDownload")));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, changeIntToBoolean(jSONObject.optInt("isAutoInstall")));
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, jSONObject.optBoolean("bolckNotify"));
            bundle.putString("recommendId", jSONObject.optString("recommendId"));
            StringBuilder sb522 = new StringBuilder();
            sb522.append("");
            String str422 = str2;
            sb522.append(jSONObject.optInt(str422));
            bundle.putString(str422, sb522.toString());
            bundle.putString(com.tencent.open.downloadnew.e.M, optString3);
            bundle.putString("pageId", "" + jSONObject.optInt("pageId"));
            bundle.putString("moduleId", "" + jSONObject.optInt("moduleId"));
            bundle.putString("positionId", "" + jSONObject.optInt("positionId"));
            bundle.putString("apkId", jSONObject.optString("apkId"));
            bundle.putString("appId", optString);
            bundle.putInt("auto_start_yyb_download", jSONObject.optInt("auto_start_yyb_download"));
            String parseSourceType22 = DownloadInterface.parseSourceType(this.f340872h, jSONObject);
            bundle.putString(LaunchParam.KEY_REF_ID, DownloadInterface.parseCurrentPageId(this.f340872h));
            bundle.putInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE, jSONObject.optInt(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
            com.tencent.open.base.f.e("DINewForCommonWebView", "[doDownloadAction] object " + jSONObject.toString());
            f(jSONObject.optString("url"), optInt2);
            DownloadProxy.k().g(this.f340872h, bundle, parseSourceType22, apkUpdateDetail, optInt322);
            return 0;
        } catch (NumberFormatException e18) {
            com.tencent.open.base.f.d("DINewForCommonWebView", "[doDownloadAction] Exception", e18);
            return -1;
        } catch (JSONException e19) {
            com.tencent.open.base.f.d("DINewForCommonWebView", "[doDownloadAction] JSONException", e19);
            return -1;
        }
    }

    @Override // com.tencent.open.appcommon.js.BaseInterface
    public String getInterfaceName() {
        return "q_download_v2";
    }

    @Override // com.tencent.open.business.base.c
    public String getJsCallbackMethod() {
        return this.f340869d;
    }

    public void getQueryDownloadAction(String str) {
        com.tencent.open.base.f.e("DINewForCommonWebView", "<getQueryDownloadAction> paramJson=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            c(new JSONArray(jSONObject.optString("queryParams")), jSONObject.optString("callback"));
        } catch (JSONException e16) {
            com.tencent.open.base.f.c("DINewForCommonWebView", "[queryDownloadAction] e=" + e16.getMessage());
        }
    }

    @Override // com.tencent.open.business.base.c
    public WebView getWebview() {
        return this.f340870e;
    }

    public void isYYBSupportBatchDownload(String str) {
        boolean z16;
        com.tencent.open.base.f.e("DINewForCommonWebView", ">isYYBSupportBatchDownload " + str);
        try {
            String optString = new JSONObject(str).optString("callback");
            int C = MyAppApi.C();
            com.tencent.open.base.f.e("DINewForCommonWebView", ">isYYBSupportBatchDownload yybApiLevel=" + C);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX);
            sb5.append(optString);
            sb5.append("(");
            if (C >= 9) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(")");
            String sb6 = sb5.toString();
            com.tencent.open.base.f.a("DINewForCommonWebView", ">isYYBSupportBatchDownload:" + sb6);
            jsCallBack(sb6);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public int openDownloaderWebview(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle = new Bundle();
            bundle.putString("url", jSONObject.optString("url"));
            DownloadProxy.n(this.f340872h, bundle);
            return 0;
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("DINewForCommonWebView", "JSONException", e16);
            return 0;
        }
    }

    public void queryYYBApiLevel(String str) {
        com.tencent.open.base.f.e("DINewForCommonWebView", ">queryYYBApiLevel " + str);
        try {
            String optString = new JSONObject(str).optString("callback");
            int C = MyAppApi.C();
            com.tencent.open.base.f.e("DINewForCommonWebView", ">queryYYBApiLevel yybApiLevel=" + C);
            String str2 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + optString + "(" + C + ")";
            com.tencent.open.base.f.a("DINewForCommonWebView", ">queryYYBApiLevel:" + str2);
            jsCallBack(str2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void registerDownloadCallBackListener(String str) {
        com.tencent.open.base.f.e("DINewForCommonWebView", "<registerDownloadCallBackListener> paramJsonStr=" + str);
        try {
            this.f340869d = new JSONObject(str).optString("callback");
            com.tencent.open.base.f.e("DINewForCommonWebView", "<registerDownloadCallBackListener>" + this.f340869d);
        } catch (JSONException e16) {
            e16.printStackTrace();
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
            DownloadProxy.p(bundle);
            return 0;
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("DINewForCommonWebView", "JSONException", e16);
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
            DownloadProxy.q(bundle);
            return 0;
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("DINewForCommonWebView", "JSONException", e16);
            return 0;
        }
    }
}
