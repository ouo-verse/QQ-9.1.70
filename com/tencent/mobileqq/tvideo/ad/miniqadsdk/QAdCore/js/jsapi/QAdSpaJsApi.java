package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi;

import android.app.Application;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.effectreport.SpaAdParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.QAdBasicInterface;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.SpaEffectReportActionKey;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import jv2.c;
import org.json.JSONException;
import org.json.JSONObject;
import pw2.n;
import pw2.x;
import uv2.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdSpaJsApi extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a {
    private static final int CODE_ERROR = 1;
    private static final int CODE_SUCCESS = 0;
    private static final String GDT_DOWNLOAD_REPORT_URL = "https://t.gdt.qq.com/conv/src/61/conv?client=61&cuser=src&product_id=10332186&clickid=__CLICK_ID__&actionid=__ACTION_ID__";
    private static final String TAG = "QAdSpaJsApi";
    private gv2.b mApkDownloadListener;
    private uv2.a mAppStoreJsApiHelper;
    private jv2.a mDataHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements gv2.b {

        /* renamed from: a, reason: collision with root package name */
        long f303848a = 0;

        /* renamed from: b, reason: collision with root package name */
        long f303849b = 0;

        a() {
        }

        private String c(long j3) {
            long currentTimeMillis = System.currentTimeMillis();
            long j16 = this.f303848a;
            long j17 = 0;
            if (j16 != 0) {
                j17 = 1000 * ((j3 - j16) / (currentTimeMillis - this.f303849b));
            }
            this.f303848a = j3;
            this.f303849b = currentTimeMillis;
            long j18 = j17 / 1024;
            if (j18 > 1023) {
                return new DecimalFormat("0.0").format(((float) j18) / 1024.0f) + "M/S";
            }
            return j18 + "kb/s";
        }

        @Override // gv2.b
        public void a(d dVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("packageName", dVar.a());
                jSONObject.put("progress", dVar.b());
                jSONObject.put("apkSize", dVar.d());
                jSONObject.put("speed", c(dVar.c()));
                jSONObject.put("receiveDataLen", this.f303848a);
                QAdSpaJsApi.this.publishMessageToH5(new jv2.b("event", "onDownloadTaskProgressChanged", jSONObject.toString()));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }

        @Override // gv2.b
        public void b(e eVar) {
            try {
                int e16 = eVar.e();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("packageName", eVar.d());
                if (e16 == 15) {
                    e16 = 16;
                }
                jSONObject.put("state", e16);
                jSONObject.put("errorCode", eVar.b());
                jSONObject.put("errorMessage", eVar.c());
                QAdSpaJsApi.this.publishMessageToH5(new jv2.b("event", "onDownloadTaskStateChanged", jSONObject.toString()));
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements gv2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f303851a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f303852b;

        b(String str, c cVar) {
            this.f303851a = str;
            this.f303852b = cVar;
        }

        @Override // gv2.a
        public void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.a aVar) {
            if (aVar != null && this.f303851a.equals(aVar.b())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("downloadUrl", aVar.a());
                    jSONObject.put("packageName", this.f303851a);
                    jSONObject.put("uiState", aVar.e());
                    jSONObject.put("progress", aVar.c());
                    jSONObject.put("savePath", aVar.d());
                    com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackToH5(this.f303852b, 0, "", jSONObject.toString());
                } catch (JSONException e16) {
                    n.c("InteractJSApi", e16);
                    com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackToH5(this.f303852b, 1, e16.toString(), "{}");
                }
            }
        }
    }

    public QAdSpaJsApi(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.a aVar, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b bVar) {
        super(aVar, bVar);
    }

    private synchronized void ensureAppStoreJsapiHelper() {
        if (this.mAppStoreJsApiHelper == null) {
            this.mAppStoreJsApiHelper = new uv2.a();
        }
    }

    private String getAdVrReport() {
        jv2.a aVar = this.mDataHandler;
        if (aVar != null) {
            return aVar.e();
        }
        return "{}";
    }

    private String getExtraParams() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("page=");
        sb5.append("H5");
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        jv2.a aVar = this.mDataHandler;
        if (aVar != null && aVar.getReportParams() != null && this.mDataHandler.getReportKey() != null) {
            sb5.append(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(URLEncoder.encode(this.mDataHandler.getReportParams()));
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(URLEncoder.encode(this.mDataHandler.getReportKey()));
        }
        return sb5.toString();
    }

    private String getPrClickId() {
        jv2.a aVar = this.mDataHandler;
        if (aVar != null) {
            return aVar.c();
        }
        return "";
    }

    private SpaAdParam getSpaAdParam(int i3, JSONObject jSONObject) {
        SpaAdParam spaAdParam = new SpaAdParam();
        spaAdParam.from = i3;
        jv2.a aVar = this.mDataHandler;
        if (aVar != null) {
            if (aVar.getFrom() == 4) {
                spaAdParam.from = 4;
            }
            spaAdParam.adReport = this.mDataHandler.b();
            spaAdParam.adId = this.mDataHandler.getAdId();
            spaAdParam.adPos = this.mDataHandler.a();
            spaAdParam.adReportKey = this.mDataHandler.getReportKey();
            spaAdParam.adReportParam = this.mDataHandler.getReportParams();
        }
        if (spaAdParam.adReport == null) {
            spaAdParam.adReport = new AdReport();
        }
        if (!TextUtils.isEmpty(jSONObject.optString("effectUrl"))) {
            spaAdParam.adReport.url = jSONObject.optString("effectUrl");
        } else {
            spaAdParam.adReport.url = GDT_DOWNLOAD_REPORT_URL;
        }
        if (jSONObject.optBoolean(VirtualAppProxy.KEY_AUTO_DOWNLOAD, false)) {
            spaAdParam.from = 7;
        }
        spaAdParam.clickId = jSONObject.optString("clickId");
        return spaAdParam;
    }

    private void initDownloadListener() {
        hv2.d dVar;
        if (this.mApkDownloadListener == null && (dVar = (hv2.d) dv2.b.d().a(hv2.d.class)) != null) {
            a aVar = new a();
            this.mApkDownloadListener = aVar;
            dVar.j(aVar);
        }
    }

    private static boolean isOneEmptyOfAllParams(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    private void replaceDownloadUrl(f fVar) {
        f a16 = ev2.c.a(fVar.f303811b);
        if (a16 != null && !TextUtils.isEmpty(a16.f303810a)) {
            fVar.f303810a = a16.f303810a;
        }
    }

    private boolean reportWhenLaunch3rdApp(c cVar, String str, String str2, kv2.a aVar, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackParamError(cVar);
            return false;
        }
        Application a16 = qv2.b.a();
        boolean e16 = pw2.b.e(a16, str2);
        if (!e16) {
            e16 = pw2.b.g(a16, str);
        }
        if (e16) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackSuccessToH5(cVar);
        } else {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackParamError(cVar);
        }
        kv2.b.d(e16, str, str3);
        return e16;
    }

    @QAdBasicInterface
    public void checkDowload3rdAppState(JSONObject jSONObject, c cVar) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("downloadUrl");
            String optString2 = jSONObject.optString("packageName");
            int optInt = jSONObject.optInt("versionCode");
            hv2.d dVar = (hv2.d) dv2.b.d().a(hv2.d.class);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && dVar != null) {
                dVar.i(new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.b(optString, optString2, optInt), new b(optString2, cVar));
            } else {
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackToH5(cVar, 1, "param error", "{}");
            }
        }
    }

    @QAdBasicInterface
    public void download3rdApp(JSONObject jSONObject, c cVar) {
        hv2.d dVar = (hv2.d) dv2.b.d().a(hv2.d.class);
        if (dVar == null) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackToH5(cVar, 1, "no dwonload service", "{}");
            return;
        }
        f fVar = new f();
        fVar.f303810a = jSONObject.optString("downloadUrl");
        fVar.f303811b = jSONObject.optString("packageName");
        replaceDownloadUrl(fVar);
        fVar.f303812c = jSONObject.optString("appName");
        String optString = jSONObject.optString("iconUrl");
        fVar.f303813d = optString;
        if (isOneEmptyOfAllParams(fVar.f303810a, fVar.f303811b, fVar.f303812c, optString)) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackParamError(cVar);
            return;
        }
        fVar.f303814e = jSONObject.optInt("versionCode", 0);
        fVar.f303815f = jSONObject.optString(WadlProxyConsts.CHANNEL);
        fVar.f303816g = jSONObject.optString(QQBrowserActivity.APP_PARAM, getExtraParams());
        fVar.f303822m = jSONObject.optString("via");
        fVar.f303823n = jSONObject.optString("md5");
        fVar.f303831v = jSONObject.optInt("route", 0);
        fVar.f303825p = jSONObject.optBoolean("saveToDB", true);
        fVar.f303824o = String.valueOf(jSONObject.optInt("apkSize") * 1024);
        fVar.f303830u = jSONObject.optInt("installPolicy");
        fVar.f303818i = 1;
        fVar.f303827r = jSONObject.optBoolean("needAutoInstall", true);
        String decode = URLDecoder.decode(jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY));
        String str = "";
        if (TextUtils.isEmpty(decode)) {
            decode = "";
        }
        fVar.f303821l = decode;
        String decode2 = URLDecoder.decode(jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS));
        if (!TextUtils.isEmpty(decode2)) {
            str = decode2;
        }
        fVar.f303820k = str;
        fVar.f303833x = URLDecoder.decode(jSONObject.optString("h5Info"));
        fVar.f303817h = getAdVrReport();
        fVar.f303819j = getPrClickId();
        int optInt = jSONObject.optInt("from", 2);
        JSONObject optJSONObject = jSONObject.optJSONObject("adParam");
        if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("clickId"))) {
            fVar.f303829t = getSpaAdParam(optInt, optJSONObject);
        } else {
            fVar.f303826q = jSONObject.optBoolean("downloadOnlyWifi", true);
        }
        initDownloadListener();
        dVar.m(fVar);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackSuccessToH5(cVar);
    }

    protected kv2.a inflateReportInfo(JSONObject jSONObject) {
        kv2.a aVar = new kv2.a();
        if (this.mDataHandler != null && jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("clickId"))) {
            String optString = jSONObject.optString("clickId");
            if (TextUtils.isDigitsOnly(optString)) {
                optString = getPrClickId();
            }
            aVar.f413319g = optString;
            AdReport b16 = this.mDataHandler.b();
            if (b16 == null) {
                b16 = new AdReport();
            }
            if (TextUtils.isEmpty(b16.url)) {
                b16.url = jSONObject.optString("effectUrl");
            }
            aVar.f413314b = b16;
            aVar.f413313a = this.mDataHandler.getAdId();
            aVar.f413315c = this.mDataHandler.a();
            aVar.f413316d = this.mDataHandler.getReportKey();
            aVar.f413317e = this.mDataHandler.getReportParams();
            aVar.f413318f = x.a(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_TRY_XS);
        }
        return aVar;
    }

    @QAdBasicInterface
    public void launch3rdApp(JSONObject jSONObject, c cVar) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
            String optString2 = jSONObject.optString("schemeUrl");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = jSONObject.optString("pkgUrl");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("adParam");
            String adVrReport = getAdVrReport();
            QAdVrReport.j(true, adVrReport);
            kv2.a inflateReportInfo = inflateReportInfo(optJSONObject);
            kv2.b.b(inflateReportInfo, optString2);
            kv2.b.a(optString2, reportWhenLaunch3rdApp(cVar, optString, optString2, inflateReportInfo, adVrReport), inflateReportInfo);
        }
    }

    @QAdBasicInterface
    public void obtainDeviceInfo(c cVar) {
        ensureAppStoreJsapiHelper();
        uv2.a aVar = this.mAppStoreJsApiHelper;
        if (aVar != null) {
            callbackToH5(cVar, aVar.e().toString());
        }
    }

    @QAdBasicInterface
    public void openAppStore(JSONObject jSONObject, c cVar) {
        jv2.a aVar;
        a.C11368a f16;
        ensureAppStoreJsapiHelper();
        uv2.a aVar2 = this.mAppStoreJsApiHelper;
        if (aVar2 != null && (aVar = this.mDataHandler) != null && (f16 = aVar2.f(jSONObject, aVar.e(), this.mDataHandler.d())) != null) {
            callbackToH5(cVar, f16.toString());
        }
    }

    @QAdBasicInterface
    public void pauseDowload3rdApp(JSONObject jSONObject, c cVar) {
        String optString = jSONObject.optString("downloadUrl");
        String optString2 = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2)) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackParamError(cVar);
            return;
        }
        hv2.d dVar = (hv2.d) dv2.b.d().a(hv2.d.class);
        if (dVar == null) {
            com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackParamError(cVar);
            return;
        }
        f fVar = new f();
        fVar.f303810a = optString;
        fVar.f303811b = optString2;
        fVar.f303818i = 1;
        dVar.h(fVar);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.callbackSuccessToH5(cVar);
    }

    @QAdBasicInterface
    public void register3rdAppDownloadListener(c cVar) {
        initDownloadListener();
    }

    @QAdBasicInterface
    public void removeDownload(JSONObject jSONObject, c cVar) {
        hv2.d dVar;
        try {
            String optString = jSONObject.optString("downloadUrl");
            String optString2 = jSONObject.optString("packageName");
            if (TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString) || (dVar = (hv2.d) dv2.b.d().a(hv2.d.class)) == null) {
                return;
            }
            f fVar = new f();
            fVar.f303810a = optString;
            fVar.f303811b = optString2;
            fVar.f303818i = 1;
            boolean b16 = dVar.b(fVar);
            n.e(TAG, "removeDownload, downloadUrl:" + optString + ", packageName:" + optString2 + ", isSuccess:" + b16);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packageName", optString2);
            jSONObject2.put("isSuccess", b16);
            publishMessageToH5(new jv2.b("event", "onRemoveDownloadFinished", jSONObject2.toString()));
        } catch (JSONException e16) {
            n.c(TAG, e16);
        }
    }

    public void updateDataHandler(jv2.a aVar) {
        this.mDataHandler = aVar;
    }
}
