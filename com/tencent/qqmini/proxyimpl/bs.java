package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@ProxyService(proxy = ThirdAppProxy.class)
/* loaded from: classes34.dex */
public class bs extends ThirdAppProxy {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, ThirdAppProxy.AppDownloadListener> f347861a;

    /* renamed from: h, reason: collision with root package name */
    private Context f347868h;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, AsyncResult> f347862b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, AsyncResult> f347863c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, List<AsyncResult>> f347864d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, JSONObject> f347865e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, WadlParams> f347866f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<b> f347867g = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private boolean f347869i = false;

    /* renamed from: j, reason: collision with root package name */
    private int f347870j = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f347871k = false;

    /* renamed from: l, reason: collision with root package name */
    private HashMap<String, Integer> f347872l = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private WadlProxyServiceCallBackInterface f347873m = new a();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    private class b implements nl0.c {

        /* renamed from: d, reason: collision with root package name */
        private String f347875d;

        /* renamed from: e, reason: collision with root package name */
        private AsyncResult f347876e;

        public b(String str, AsyncResult asyncResult) {
            this.f347875d = str;
            this.f347876e = asyncResult;
        }

        @Override // nl0.c
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(WadlProxyConsts.CMD_GET_APK_DOWNLOAD_INFO);
            return hashSet;
        }

        @Override // nl0.c
        public void onCmdRsp(Intent intent, String str, long j3, JSONObject jSONObject) {
            QLog.i("ThirdAppProxyImpl", 1, "onCmdRsp ret=" + j3 + ",cmd=" + str + ",dataJson=" + jSONObject);
            if (WadlProxyConsts.CMD_GET_APK_DOWNLOAD_INFO.equals(str)) {
                try {
                    AsyncResult asyncResult = this.f347876e;
                    if (asyncResult == null) {
                        return;
                    }
                    this.f347876e = null;
                    if (j3 != 0) {
                        asyncResult.onReceiveResult(false, null);
                        return;
                    }
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("v_appd_down_load_info");
                        r0 = jSONArray != null ? jSONArray.getJSONObject(0) : null;
                        asyncResult.onReceiveResult(r0 != null, r0);
                    } catch (Throwable th5) {
                        QLog.e("ThirdAppProxyImpl", 1, "exception. ", th5);
                        asyncResult.onReceiveResult(r0 != null, r0);
                    }
                } catch (Throwable th6) {
                    QLog.e("ThirdAppProxyImpl", 1, "exception. ", th6);
                }
            }
        }
    }

    private void h(int i3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ThirdAppProxyImpl", 1, "setSpeedBuffer error runtime");
        } else {
            ((IQQGameDLService) peekAppRuntime.getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI)).setSpeedBuffer(3, i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public boolean deleteDownloadTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QLog.i("ThirdAppProxyImpl", 1, "[deleteDownloadTask], appId:" + str);
        WadlProxyServiceUtil.getProxyService().deleteDownload(0, str);
        return true;
    }

    public void f(String str, ThirdAppProxy.AppDownloadListener appDownloadListener) {
        if (this.f347861a == null) {
            this.f347861a = new HashMap<>();
        }
        this.f347861a.put(str, appDownloadListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public void init() {
        if (this.f347869i) {
            return;
        }
        this.f347869i = true;
        this.f347870j = 0;
        this.f347871k = false;
        this.f347861a = new HashMap<>();
        this.f347867g = new ArrayList<>();
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this.f347873m);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public boolean installApp(String str, AsyncResult asyncResult) {
        if (TextUtils.isEmpty(str) || asyncResult == null) {
            return false;
        }
        WadlParams g16 = g(this.f347865e.get(str));
        if (g16 == null) {
            g16 = this.f347866f.get(str);
        }
        if (g16 == null) {
            asyncResult.onReceiveResult(false, null);
            return false;
        }
        g16.setFlags(2);
        g16.actionCode = 5;
        WadlProxyServiceUtil.getProxyService().doInstallAction(g16);
        asyncResult.onReceiveResult(true, null);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public void queryApkDownloadInfo(String str, AsyncResult asyncResult) {
        if (TextUtils.isEmpty(str) || asyncResult == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        b bVar = new b(str, asyncResult);
        this.f347867g.add(bVar);
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).addListener(bVar);
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).getApkDownloadInfo("10036618", arrayList);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public boolean resumeDownloadTask(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QLog.i("ThirdAppProxyImpl", 1, "[resumeDownloadTask], appId:" + str);
        WadlProxyServiceUtil.getProxyService().doResumeAction(0, str);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public void setSpeedBuffer(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("ext7", str);
        hashMap.put("ext8", String.valueOf(i3));
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929204", "18", "", hashMap);
        this.f347871k = i3 > 0;
        h(i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public void startDownload(String str, JSONObject jSONObject, boolean z16, ThirdAppProxy.AppDownloadListener appDownloadListener) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            if (appDownloadListener != null) {
                f(str, appDownloadListener);
            }
            try {
                this.f347865e.put(str, jSONObject);
                WadlParams g16 = g(jSONObject);
                if (g16 == null) {
                    return;
                }
                if (z16) {
                    g16.setFlags(7);
                } else {
                    g16.setFlags(6);
                }
                g16.actionCode = 2;
                WadlProxyServiceUtil.getProxyService().doDownloadAction(g16);
                return;
            } catch (Exception e16) {
                QLog.i("ThirdAppProxyImpl", 1, "startDownload---exception happend:", e16);
                if (appDownloadListener != null) {
                    appDownloadListener.onDownloadFailed(-1000, -2, "url is invalid");
                    return;
                }
                return;
            }
        }
        QLog.i("ThirdAppProxyImpl", 1, "startDownload, url is empty!");
        if (appDownloadListener != null) {
            appDownloadListener.onDownloadFailed(-1000, -1, "url is invalid");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public boolean stopDownloadTask(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("ThirdAppProxyImpl", 1, "[stopDownloadTask], appId is empty.");
            return false;
        }
        WadlProxyServiceUtil.getProxyService().doPauseAction(0, str);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public void unInit() {
        HashMap<String, ThirdAppProxy.AppDownloadListener> hashMap = this.f347861a;
        if (hashMap != null) {
            hashMap.clear();
            this.f347861a = null;
        }
        ArrayList<b> arrayList = this.f347867g;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.f347869i = false;
        this.f347870j = 0;
        this.f347868h = null;
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this.f347873m);
        WadlProxyServiceUtil.getProxyService().destroy();
        if (this.f347871k) {
            h(0);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy
    public void queryDownloadTask(String str, AsyncResult asyncResult) {
        if (asyncResult == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            asyncResult.onReceiveResult(false, null);
        }
        this.f347862b.put(str, asyncResult);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        WadlProxyServiceUtil.getProxyService().doQueryAction(arrayList);
    }

    private WadlParams g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            WadlParams wadlParams = new WadlParams();
            wadlParams.via = "SmallGame";
            wadlParams.apkChannel = "10036618";
            wadlParams.from = 6;
            wadlParams.apkUrl = jSONObject.optString("android_download_url");
            wadlParams.appId = jSONObject.optString("appid");
            wadlParams.versionCode = jSONObject.optInt("version_code");
            wadlParams.packageName = jSONObject.optString("pkg_name");
            wadlParams.appName = jSONObject.optString("app_name");
            wadlParams.iconUrl = jSONObject.optString(MiniConst.WxMiniAppInfoConst.EXTRA_ICON);
            wadlParams.fromWebUrl = "interrupt";
            return wadlParams;
        } catch (Throwable th5) {
            QLog.i("ThirdAppProxyImpl", 1, "createWadlParams exception happend:", th5);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements WadlProxyServiceCallBackInterface {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onQueryCallback(ArrayList<WadlResult> arrayList) {
            AsyncResult asyncResult;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<WadlResult> it = arrayList.iterator();
                while (it.hasNext()) {
                    WadlResult next = it.next();
                    WadlParams wadlParams = next.wadlParams;
                    String str = wadlParams != null ? wadlParams.appId : null;
                    if (str != null && wadlParams != null) {
                        bs.this.f347866f.put(str, wadlParams);
                    }
                    if (str != null && bs.this.f347862b.containsKey(str) && (asyncResult = (AsyncResult) bs.this.f347862b.remove(str)) != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("appid", str);
                            jSONObject.put("status", next.taskStatus);
                            jSONObject.put("downloadSize", next.downloadFileSize);
                            jSONObject.put("totalSize", next.fileSize);
                            jSONObject.put("progress", (next.downloadFileSize * 100) / next.fileSize);
                            WadlParams wadlParams2 = next.wadlParams;
                            if (wadlParams2 != null) {
                                jSONObject.put("versionCode", wadlParams2.versionCode);
                            }
                            if (next.taskStatus == 6) {
                                String str2 = next.downloadFilePath;
                                if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                                    jSONObject.put("status", 0);
                                    jSONObject.put("progress", 0);
                                }
                            }
                            asyncResult.onReceiveResult(true, jSONObject);
                        } catch (Throwable unused) {
                            asyncResult.onReceiveResult(false, null);
                        }
                    }
                }
                return;
            }
            for (Map.Entry entry : bs.this.f347862b.entrySet()) {
                AsyncResult asyncResult2 = entry != null ? (AsyncResult) entry.getValue() : null;
                if (asyncResult2 != null) {
                    asyncResult2.onReceiveResult(false, null);
                }
            }
            bs.this.f347862b.clear();
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onWadlTaskStatusChanged(WadlResult wadlResult) {
            WadlParams wadlParams;
            AsyncResult asyncResult;
            if (wadlResult != null && (wadlParams = wadlResult.wadlParams) != null) {
                String str = wadlParams.appId;
                int convertRemoteStatusToLocal = GameCenterUtil.convertRemoteStatusToLocal(wadlResult.taskStatus);
                QLog.i("ThirdAppProxyImpl", 1, "onWadlTaskStatusChanged:" + wadlResult + ",localStatus:" + convertRemoteStatusToLocal);
                if (convertRemoteStatusToLocal == -2) {
                    int wadlErrCode = GameCenterUtil.getWadlErrCode(wadlResult.errCode);
                    GameCenterUtil.getWadlErrMsg(wadlErrCode);
                    bs.this.f347872l.remove(str);
                    if (bs.this.f347861a == null || !bs.this.f347861a.containsKey(str)) {
                        return;
                    }
                    if (bs.this.f347861a.get(str) != null) {
                        ((ThirdAppProxy.AppDownloadListener) bs.this.f347861a.get(str)).onDownloadFailed(wadlErrCode, wadlErrCode, "failed");
                    }
                    bs.this.f347861a.remove(str);
                    return;
                }
                if (convertRemoteStatusToLocal == 6 || convertRemoteStatusToLocal == 13) {
                    if (!bs.this.f347863c.containsKey(str) || (asyncResult = (AsyncResult) bs.this.f347863c.remove(str)) == null) {
                        return;
                    }
                    asyncResult.onReceiveResult(true, null);
                    return;
                }
                if (convertRemoteStatusToLocal != 20) {
                    if (convertRemoteStatusToLocal == 2) {
                        if (bs.this.f347861a == null || !bs.this.f347861a.containsKey(str) || bs.this.f347861a.get(str) == null) {
                            return;
                        }
                        int intValue = bs.this.f347872l.containsKey(str) ? ((Integer) bs.this.f347872l.get(str)).intValue() : 0;
                        int i3 = (int) ((wadlResult.downloadFileSize * 100) / wadlResult.fileSize);
                        if (i3 - intValue >= 1) {
                            ((ThirdAppProxy.AppDownloadListener) bs.this.f347861a.get(str)).onDownloadProgress(wadlResult.downloadFileSize, wadlResult.fileSize, i3);
                            bs.this.f347872l.put(str, Integer.valueOf(i3));
                            return;
                        }
                        return;
                    }
                    if (convertRemoteStatusToLocal != 3) {
                        if (convertRemoteStatusToLocal != 4) {
                            if (convertRemoteStatusToLocal == 9 || convertRemoteStatusToLocal == 10) {
                                return;
                            }
                            QLog.e("ThirdAppProxyImpl", 1, "download status not response!");
                            return;
                        }
                        bs.this.f347872l.remove(str);
                        if (bs.this.f347861a == null || !bs.this.f347861a.containsKey(str) || bs.this.f347861a.get(str) == null) {
                            return;
                        }
                        ((ThirdAppProxy.AppDownloadListener) bs.this.f347861a.get(str)).onDownloadComplete();
                        bs.this.f347861a.remove(str);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.e("ThirdAppProxyImpl", 1, "onWadlTaskStatusChanged error wadlResult is null");
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
        }
    }
}
