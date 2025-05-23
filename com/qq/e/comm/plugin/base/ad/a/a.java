package com.qq.e.comm.plugin.base.ad.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.pi.JsCallback;
import com.qq.e.comm.pi.TangramExposureCallback;
import com.qq.e.comm.pi.UTI;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.e;
import com.qq.e.comm.plugin.base.ad.e.b;
import com.qq.e.comm.plugin.base.ad.e.f;
import com.qq.e.comm.plugin.base.ad.e.g;
import com.qq.e.comm.plugin.base.ad.model.d;
import com.qq.e.comm.plugin.base.ad.model.p;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.download.data.MediaCustomDownloaderCallBackInfo;
import com.qq.e.tg.tangram.action.TangramAdActionParams;
import com.qq.e.tg.tangram.module.TangramAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements UTI {
    private void a(final p pVar, View view, long j3) {
        com.qq.e.comm.plugin.base.ad.model.a aVar = new com.qq.e.comm.plugin.base.ad.model.a(pVar.u(), com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD, pVar.s());
        String k3 = pVar.k();
        String j16 = pVar.j();
        g.a((String) null, 0, pVar, aVar, (!pVar.as() || StringUtil.isEmpty(k3)) ? j16 : g.a(j16, j3), new b.a() { // from class: com.qq.e.comm.plugin.base.ad.a.a.1
            @Override // com.qq.e.comm.plugin.base.ad.e.b.a
            public void a() {
                if (StringUtil.isEmpty(pVar.au())) {
                    return;
                }
                af.b(pVar.au());
            }

            @Override // com.qq.e.comm.plugin.base.ad.e.b.a
            public void a(int i3) {
                GDTLogger.e("tangram ad exposed err");
            }
        });
        pVar.aa();
        pVar.Z();
    }

    @Override // com.qq.e.comm.pi.UTI
    public boolean deleteApk(Context context, int i3) {
        ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).deleteApk(i3);
        return false;
    }

    @Override // com.qq.e.comm.pi.UTI
    public void doClick(TangramAd tangramAd, View view, TangramAdActionParams tangramAdActionParams) {
        ClickInfo.e eVar;
        if (tangramAd == null) {
            GDTLogger.e("clicked data is null");
            return;
        }
        if (view == null) {
            GDTLogger.e("clicked view is null");
            return;
        }
        if (tangramAdActionParams != null && tangramAdActionParams.isEnableExposure()) {
            if (tangramAdActionParams.getExposureCallback() != null) {
                f.a(tangramAd.getJsonData(), (WeakReference<TangramExposureCallback>) new WeakReference(tangramAdActionParams.getExposureCallback()));
            } else {
                GDTLogger.e("fail to exposure, exposureCallback is null");
            }
        }
        p a16 = ((c) tangramAd).a();
        a16.a(com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD);
        if (tangramAdActionParams != null) {
            try {
                if (tangramAdActionParams.getClickPos() != -1) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("click_pos", String.valueOf(tangramAdActionParams.getClickPos()));
                    String a17 = ay.a(a16.n(), "feeds_attachment", jSONObject.toString());
                    a16.av().put("rl", a17);
                    a16.l(a17);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        ClickInfo.a aVar = null;
        if (TextUtils.isEmpty(a16.x()) || tangramAdActionParams == null || tangramAdActionParams.getVideoOption() == null) {
            eVar = null;
        } else {
            eVar = new ClickInfo.e(tangramAdActionParams.getVideoOption().isDetailPageMuted(), tangramAdActionParams.getVideoOption().getVideoWidth(), tangramAdActionParams.getVideoOption().getVideoHeight(), a16.at(), tangramAdActionParams.getVideoOption().getCurrentPlayTime(), tangramAdActionParams.getVideoOption().getVideoPath(), tangramAdActionParams.getResultReceiver());
            a(tangramAdActionParams.getVideoOption(), a16);
        }
        int clickViewTag = tangramAdActionParams != null ? tangramAdActionParams.getClickViewTag() : -1;
        if (tangramAdActionParams != null) {
            aVar = new ClickInfo.a();
            if (tangramAdActionParams.getCarouselIndex() >= 0) {
                aVar.a(tangramAdActionParams.getCarouselIndex());
            }
            if (tangramAdActionParams.isMarketAutoDownload()) {
                aVar.a(true);
            }
        }
        e eVar2 = new e(new WeakReference(view));
        eVar2.a(0);
        eVar2.b(clickViewTag);
        g.a(new ClickInfo.b().a(a16).a(new ClickInfo.c(a16.u(), a16.t(), a16.s())).a(eVar2).a(eVar).a(aVar).a(com.qq.e.comm.plugin.j.c.a(a16.s(), Constants.KEYS.DOWNLOAD_CONFIRM, 0)).a(a(tangramAdActionParams)).a());
    }

    @Override // com.qq.e.comm.pi.UTI
    public String getAdRequestCgi(int i3) {
        return com.qq.e.comm.plugin.base.ad.e.c.b(com.qq.e.comm.plugin.base.ad.b.a(i3));
    }

    @Override // com.qq.e.comm.pi.UTI
    public Map<String, String> getAdRequestParams(int i3, int i16, String str, LoadAdParams loadAdParams) {
        try {
            return com.qq.e.comm.plugin.base.ad.a.a(new PlainRequest(getAdRequestCgi(i16), 1, (byte[]) null), GDTADManager.getInstance(), a(i3, i16, str, loadAdParams));
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.qq.e.comm.pi.UTI
    public MediaCustomDownloaderCallBackInfo getApkInfo(String str) {
        if (!com.qq.e.comm.plugin.j.c.a("externalApkInfoSwitch", 1, 1)) {
            GDTLogger.i("[getAPKDownloadInfo] switch closed");
            return null;
        }
        return com.qq.e.comm.plugin.k.c.a(((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getTask(str));
    }

    @Override // com.qq.e.comm.pi.UTI
    public List<MediaCustomDownloaderCallBackInfo> getApkInfoList() {
        List<d> downloadedTasks;
        if (!com.qq.e.comm.plugin.j.c.a("externalApkInfoSwitch", 1, 1)) {
            GDTLogger.i("[getAPKDownloadInfo] switch closed");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            downloadedTasks = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getDownloadedTasks();
            List<d> downloadingOrPausedTasks = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getDownloadingOrPausedTasks();
            if (com.qq.e.comm.plugin.k.g.b(downloadedTasks)) {
                downloadedTasks = downloadingOrPausedTasks;
            } else if (com.qq.e.comm.plugin.k.g.a(downloadingOrPausedTasks)) {
                downloadedTasks.addAll(downloadingOrPausedTasks);
            }
        } catch (Throwable th5) {
            GDTLogger.e("[getApkInfoList]", th5);
        }
        if (downloadedTasks == null) {
            GDTLogger.i("[getAPKDownloadInfo] switch closed");
            return null;
        }
        for (d dVar : downloadedTasks) {
            if (dVar != null) {
                arrayList.add(com.qq.e.comm.plugin.k.c.a(dVar));
            }
        }
        return arrayList;
    }

    @Override // com.qq.e.comm.pi.UTI
    public JSONObject getAppInfoFromAdJson(String str) {
        return com.qq.e.comm.plugin.k.d.b(y.a(str));
    }

    @Override // com.qq.e.comm.pi.UTI
    public JSONObject getDeviceInfo() throws JSONException {
        return ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).get(com.qq.e.comm.plugin.base.ad.b.UNKNOWN.b(), new com.qq.e.comm.plugin.e.c());
    }

    @Override // com.qq.e.comm.pi.UTI
    public List<JSONObject> getDownloadedPackage(Context context) {
        return ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getDownloadedPackage();
    }

    @Override // com.qq.e.comm.pi.UTI
    public Pair<String, String> getTaidAndOaid() {
        return ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getTaidAndOaidTicket();
    }

    @Override // com.qq.e.comm.pi.UTI
    public String handleJs(View view, JSONObject jSONObject, String str, JsCallback jsCallback) {
        if (view != null && !TextUtils.isEmpty(str)) {
            return ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).handleJs(view, jSONObject, str, jsCallback);
        }
        return "";
    }

    @Override // com.qq.e.comm.pi.UTI
    public void installApp(Context context, int i3) {
        ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).installApp(context, i3);
    }

    @Override // com.qq.e.comm.pi.UTI
    public void onActivityResultCallBack() {
        com.qq.e.comm.plugin.base.ad.clickcomponent.d.b.a().b();
    }

    @Override // com.qq.e.comm.pi.UTI
    public void onExposure(TangramAd tangramAd, View view, long j3) {
        onExposure(tangramAd, view, j3, (TangramAdActionParams) null);
    }

    @Override // com.qq.e.comm.pi.UTI
    public void sendUpdateWuJiRequest() {
        com.qq.e.comm.plugin.j.e.a().d();
    }

    @Override // com.qq.e.comm.pi.UTI
    public JSONObject getDeviceInfo(int i3) throws JSONException {
        return getDeviceInfo(i3, true);
    }

    @Override // com.qq.e.comm.pi.UTI
    public void onExposure(TangramAd tangramAd, View view, long j3, TangramAdActionParams tangramAdActionParams) {
        if (tangramAd == null) {
            GDTLogger.e("Exposure data is null");
            return;
        }
        if (view == null) {
            GDTLogger.e("Exposure view is null");
            return;
        }
        p a16 = ((c) tangramAd).a();
        if (tangramAdActionParams != null && tangramAdActionParams.getRenderPosition() >= 0) {
            a16.setRenderPosition(tangramAdActionParams.getRenderPosition());
        }
        a(a16, view, j3);
    }

    @Override // com.qq.e.comm.pi.UTI
    public JSONObject getDeviceInfo(int i3, boolean z16) throws JSONException {
        if (z16) {
            return ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).get(i3, new com.qq.e.comm.plugin.e.c());
        }
        return ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getOnlyCache(i3, new com.qq.e.comm.plugin.e.c());
    }

    @Override // com.qq.e.comm.pi.UTI
    public void onExposure(String str, String str2, View view, long j3) {
        onExposure(str, str2, view, j3, null);
    }

    @Override // com.qq.e.comm.pi.UTI
    public void onExposure(String str, String str2, View view, long j3, TangramAdActionParams tangramAdActionParams) {
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e("pos id is invalid");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Exposure data is null");
            return;
        }
        if (view == null) {
            GDTLogger.e("Exposure view is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            p a16 = new c(GDTADManager.getInstance().getAppStatus().getAPPID(), str2, Thread.currentThread().getId() + "", null, false, jSONObject).a();
            if (tangramAdActionParams != null && tangramAdActionParams.getRenderPosition() >= 0) {
                a16.setRenderPosition(tangramAdActionParams.getRenderPosition());
            }
            a(a16, view, j3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private com.qq.e.comm.plugin.base.ad.model.b a(int i3, int i16, String str, LoadAdParams loadAdParams) {
        com.qq.e.comm.plugin.base.ad.model.b bVar = new com.qq.e.comm.plugin.base.ad.model.b();
        bVar.a(1);
        bVar.b(i3);
        bVar.a(str);
        bVar.c(2);
        bVar.f(i16);
        bVar.k(1);
        if (loadAdParams != null) {
            bVar.g(loadAdParams.getFlowSourceId());
            bVar.a(loadAdParams.getLoginType());
            bVar.d(loadAdParams.getLoginAppId());
            bVar.b(loadAdParams.getLoginOpenid());
            if (SDKStatus.getSDKVersionCode() >= 50) {
                bVar.a(loadAdParams.getPassThroughInfo());
            }
            if (SDKStatus.getSDKVersionCode() >= 70) {
                bVar.e(loadAdParams.getUid());
            }
            if (SDKStatus.getSDKVersionCode() >= 90) {
                bVar.a(loadAdParams.getExperimentId());
                bVar.m(loadAdParams.getExperimentType());
            }
        }
        return bVar;
    }

    private void a(VideoOption videoOption, p pVar) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("tangram_videoMuted", Integer.valueOf(videoOption.isDetailPageMuted() ? 1 : 0));
        au.a(1310531, pVar.s(), cVar);
    }

    private ClickInfo.d a(TangramAdActionParams tangramAdActionParams) {
        if (tangramAdActionParams == null || SDKStatus.getSDKVersionCode() < 420) {
            return null;
        }
        GDTLogger.i("TangramAdActionImpparams.getActionClickType()" + tangramAdActionParams.getActionClickType());
        return new ClickInfo.d(com.qq.e.comm.plugin.base.ad.clickcomponent.d.a.a(tangramAdActionParams.getActionClickType()));
    }

    @Override // com.qq.e.comm.pi.UTI
    public void doClick(String str, String str2, View view, TangramAdActionParams tangramAdActionParams) {
        ClickInfo.e eVar;
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.e("pos id is invalid");
            return;
        }
        GDTLogger.d("TangramAdActionTrigger.doClick(), ad = " + str);
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("ad data is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (tangramAdActionParams != null && tangramAdActionParams.isEnableExposure()) {
                if (tangramAdActionParams.getExposureCallback() != null) {
                    f.a(jSONObject, (WeakReference<TangramExposureCallback>) new WeakReference(tangramAdActionParams.getExposureCallback()));
                } else {
                    GDTLogger.e("fail to exposure, exposureCallback is null");
                }
            }
            String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
            p a16 = new c(appid, str2, com.qq.e.comm.plugin.k.a.a(appid, str2, ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId()), null, false, jSONObject).a();
            a16.a(com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD);
            if (tangramAdActionParams != null) {
                try {
                    if (tangramAdActionParams.getClickPos() != -1) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("click_pos", String.valueOf(tangramAdActionParams.getClickPos()));
                        String a17 = ay.a(a16.n(), "feeds_attachment", jSONObject2.toString());
                        a16.av().put("rl", a17);
                        a16.l(a17);
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            ClickInfo.a aVar = null;
            if (TextUtils.isEmpty(a16.x()) || tangramAdActionParams == null || tangramAdActionParams.getVideoOption() == null) {
                eVar = null;
            } else {
                eVar = new ClickInfo.e(tangramAdActionParams.getVideoOption().isDetailPageMuted(), tangramAdActionParams.getVideoOption().getVideoWidth(), tangramAdActionParams.getVideoOption().getVideoHeight(), a16.at(), tangramAdActionParams.getVideoOption().getCurrentPlayTime(), tangramAdActionParams.getVideoOption().getVideoPath(), tangramAdActionParams.getResultReceiver());
                a(tangramAdActionParams.getVideoOption(), a16);
            }
            int clickViewTag = tangramAdActionParams != null ? tangramAdActionParams.getClickViewTag() : -1;
            if (tangramAdActionParams != null) {
                aVar = new ClickInfo.a();
                if (tangramAdActionParams.getCarouselIndex() >= 0) {
                    aVar.a(tangramAdActionParams.getCarouselIndex());
                }
                if (tangramAdActionParams.isMarketAutoDownload()) {
                    aVar.a(true);
                }
            }
            e eVar2 = new e(new WeakReference(view));
            eVar2.a(0);
            eVar2.b(clickViewTag);
            g.a(new ClickInfo.b().a(a16).a(new ClickInfo.c(a16.u(), a16.t(), a16.s())).a(eVar2).a(eVar).a(aVar).a(com.qq.e.comm.plugin.j.c.a(a16.s(), Constants.KEYS.DOWNLOAD_CONFIRM, 0)).a(a(tangramAdActionParams)).a());
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
    }
}
