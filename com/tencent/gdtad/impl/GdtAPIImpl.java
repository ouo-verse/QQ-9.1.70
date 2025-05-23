package com.tencent.gdtad.impl;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.tg.splash.TGSplashExpIdUtil;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.wxmini.GdtWXMiniJumpController;
import com.tencent.gdtad.basics.adbox.GdtAdBoxData;
import com.tencent.gdtad.basics.adbox.GdtAdBoxListener;
import com.tencent.gdtad.basics.adbox.IGdtAdBox;
import com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.sso.callback.SsoAdCallback;
import com.tencent.gdtad.downloader.AdAppInstallerReceiver;
import com.tencent.gdtad.downloader.p;
import com.tencent.gdtad.downloader.u;
import com.tencent.gdtad.params.GdtSsoReportMiniParam;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.gdtad.web.GdtLandingPageConfig;
import com.tencent.gdtad.web.GdtWebReportQQ;
import com.tencent.gdtad.web.k;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.ad.schedule.d;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.hippy.HippyBundleHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splash.e;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import km0.i;
import km0.j;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;
import um0.f;

/* loaded from: classes6.dex */
public class GdtAPIImpl implements IGdtAPI {
    private static final String FOREGROUND_PAUSE_EVENT = "foreground_pause_event";
    private static final String MINI_LOADING_AD_DISPLAY_CONFIG_ID = "105669";
    public static final String SPLASH_EMPTY_TAB = "splash_empty_tab_id";
    public static final String SPLASH_EXPS = "splash_exps";
    public static final String SPLASH_TAB = "splash_tab";
    public static final String TAG = "GdtAPIImpl";

    @Override // com.tencent.gdtad.IGdtAPI
    public void actionByDownloadInfo(DownloadInfo downloadInfo) {
        p.f109191a.e(downloadInfo, null);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public IGdtAdBox buildAdBox(Context context, String str, String str2, GdtAdBoxListener gdtAdBoxListener) {
        QLog.i(TAG, 1, "buildAdBox refId=" + str2);
        return com.tencent.gdtad.basics.adbox.a.j(context).b(new GdtAdBoxData(str).setRefId(str2)).c(gdtAdBoxListener).a();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void checkAppForegroundState(Integer num, jm0.a aVar) {
        if (!QBaseActivity.mAppForground) {
            aVar.pausePlay();
            HashMap hashMap = new HashMap();
            hashMap.put(WadlProxyConsts.SCENE_ID, String.valueOf(num));
            ((IAdApi) QRoute.api(IAdApi.class)).report(FOREGROUND_PAUSE_EVENT, hashMap);
        }
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void checkScheduleDownloadTask(final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.impl.GdtAPIImpl.1
            @Override // java.lang.Runnable
            public void run() {
                d.f186939a.m(i3);
            }
        }, 128, null, false);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public access.AdGetReq createRequestAdReq(qq_ad_get.QQAdGet qQAdGet) {
        return f.f439212a.b(qQAdGet);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAMSHotSplashLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAMSHotSplashLimit " + iVar.getAmsHotSplashLimit());
        return iVar.getAmsHotSplashLimit();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAMSNormalSplashLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAMSNormalSplashLimit " + iVar.getAmsNormalSplashLimit());
        return iVar.getAmsNormalSplashLimit();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAMSSplashLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 2, "ams splash ad limit " + iVar.getAmsAdDailyFrequencyCap());
        return iVar.getAmsAdDailyFrequencyCap();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public long getAdBannerShowDelay() {
        km0.d dVar = (km0.d) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100124");
        if (dVar == null) {
            return 0L;
        }
        return dVar.a();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public List<GdtAd> getAdBoxRefreshData(String str, String str2) {
        return new GdtAdBoxData(str).setRefId(str2).getAds();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsHotBgPreloadDuration() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsHotBgPreloadDuration " + iVar.getAmsHotBgPreloadDuration());
        return iVar.getAmsHotBgPreloadDuration();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsHotShowDuration() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsHotShowDuration " + iVar.getAmsHotShowDuration());
        return iVar.getAmsHotShowDuration();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsHotSplashBgPreloadLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getHotAmsSplashPreloadLimit " + iVar.getAmsHotSplashBgPreloadLimit());
        return iVar.getAmsHotSplashBgPreloadLimit();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsPredownloadDelayTime() {
        km0.c cVar = new km0.c();
        cVar.i(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(cVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPredownloadDelay " + cVar.getAmsPredownloadDelayTime());
        return cVar.getAmsPredownloadDelayTime() * 1000;
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean getAmsPredownloadNonvideoBackgroundenable() {
        km0.c cVar = new km0.c();
        cVar.i(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(cVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPredownloadNonvideoBackgroundenable " + cVar.getAmsPredownloadNonvideoBackgroundenable());
        return cVar.getAmsPredownloadNonvideoBackgroundenable();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsPredownloadNonvideoLimit() {
        km0.c cVar = new km0.c();
        cVar.i(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(cVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPredownloadNonvideoLimit " + cVar.getAmsPredownloadNonvideoLimit());
        return cVar.getAmsPredownloadNonvideoLimit();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsPredownloadNonvideoNettype() {
        km0.c cVar = new km0.c();
        cVar.i(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(cVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPredownloadNonvideoNettype " + cVar.getAmsPredownloadNonvideoNettype());
        return cVar.getAmsPredownloadNonvideoNettype();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean getAmsPredownloadVideoBackgroundEnable() {
        km0.c cVar = new km0.c();
        cVar.i(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(cVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPredownloadVideoBackgroundEnable " + cVar.getAmsPredownloadVideoBackgroundEnable());
        return cVar.getAmsPredownloadVideoBackgroundEnable();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsPredownloadVideoNettype() {
        km0.c cVar = new km0.c();
        cVar.i(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(cVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPredownloadVideoNettype " + cVar.getAmsPredownloadVideoNettype());
        return cVar.getAmsPredownloadVideoNettype();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsPreloadDuration() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPreloadDuration " + iVar.getAmsPreloadDuration());
        return iVar.getAmsPreloadDuration();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsShowAndPreloadDuration() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsShowAndPreloadDuration " + iVar.getAmsShowAndPreloadDuration());
        return iVar.getAmsShowAndPreloadDuration();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getAmsSplashFgPreloadLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsSplashFgPreloadLimit " + iVar.getAmsPreloadLimit());
        return iVar.getAmsPreloadLimit();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean getCanHotAmsSplash() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getCanHotAmsSplash " + iVar.getCanAmsHotSplash() + "getSplashTab " + getSplashTab());
        if (iVar.getCanAmsHotSplash() && getSplashTab()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean getCanHotSplash() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getCanHotSplash " + iVar.getCanHotSplash());
        return iVar.getCanHotSplash();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public QIPCModule getDownloadIpcServer() {
        return xm0.c.f448149d;
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public QIPCModule getGdtADIpcModule() {
        return xm0.f.b();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public WebViewPlugin getGdtWebReportPlugin() {
        return new k();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public String getGdtWebReportPluginName() {
        return "GdtWebReportPlugin";
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getHotSplashLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getWarmSplashLimit " + iVar.getHotTimeLimit());
        return iVar.getHotTimeLimit();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getOlympicSplashLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getOlympicSplashColdLimit " + iVar.getAmsOlympicColdSplashLimit());
        return iVar.getAmsOlympicColdSplashLimit();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public long getSplashAdCheckJumpAppDelayTimeMs() {
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102483");
        j jVar = new j();
        jVar.e(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(jVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 2, "splash ad getSplashAdCheckJumpAppDelayTimeMs:" + jVar.getCheckJumpAppDelayTimeMs());
        return jVar.getCheckJumpAppDelayTimeMs();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public long getSplashAdCheckResultAfterJumpTimeMs() {
        j jVar = new j();
        jVar.e(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(jVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 2, "splash ad getSplashAdCheckResultAfterJumpTimeMs:" + jVar.getCheckResultAfterJumpTimeMs());
        return jVar.getCheckResultAfterJumpTimeMs();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public long getSplashAdGuardCallbackDelayTimeMs() {
        j jVar = new j();
        jVar.e(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(jVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 2, "splash ad getSplashAdGuardCallbackDelayTimeMs:" + jVar.getUnregisterGuardCallbackDelayTimeMs());
        return jVar.getUnregisterGuardCallbackDelayTimeMs();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public ArrayList<Integer> getSplashAdPriority() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 2, "splash ad priority " + iVar.b());
        return iVar.b();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getSplashDailyLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 2, "total splash ad daily limit " + iVar.getAdDailyFrequencyCap());
        return iVar.getAdDailyFrequencyCap();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public String getSplashEmptyReportExp() {
        String string = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).getString(SPLASH_EMPTY_TAB, "");
        QLog.d(TAG, 1, "getSplashEmptyReportExp " + string);
        return string;
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public List<String> getSplashExpIds() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        HashSet hashSet = new HashSet();
        from.decodeStringSet(SPLASH_EXPS, hashSet);
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            arrayList.add(str);
            QLog.d(TAG, 1, "getSplashExpIds " + str);
        }
        return arrayList;
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean getSplashTab() {
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeBool(SPLASH_TAB, false);
        QLog.d(TAG, 1, "getSplashTab " + decodeBool);
        return decodeBool;
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getSplashWeeklyLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 2, "total splash ad weekly limit " + iVar.getAdWeeklyFrequencyCap());
        return iVar.getAdWeeklyFrequencyCap();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getTianShuSplashLimit() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 2, "tianshu splash ad limit " + iVar.getTianshuAdDailyFrequencyCap());
        return iVar.getTianshuAdDailyFrequencyCap();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public int getWarmDecodeTimeout() {
        i iVar = new i();
        iVar.t(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(iVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getWarmDecodeTimeout " + iVar.getWarmDecodeTimeout());
        return iVar.getWarmDecodeTimeout();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public AdError handleWXMiniJump(AdWXMINIProgram.Params params) {
        return GdtWXMiniJumpController.f108657a.q(params);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void initLandingPageConfig(Context context) {
        GdtLandingPageConfig.b().e(context);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean isAmsPredownloadNonVideoDownloadTimeLimit() {
        km0.c cVar = new km0.c();
        cVar.i(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(cVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPredownloadNonvideoLimit " + cVar.getAmsPredownloadNonvideoLimit());
        long a16 = com.tencent.mobileqq.splash.d.a();
        QLog.d(TAG, 1, "todayAmsPredownloadNonvideoLimit " + a16);
        if (cVar.getAmsPredownloadNonvideoLimit() <= a16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean isAmsPredownloadVideoDownloadTimeLimit() {
        km0.c cVar = new km0.c();
        cVar.i(QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeString(cVar.getCONTENT_KEY(), null));
        QLog.d(TAG, 1, "getAmsPredownloadVideoLimit " + cVar.getAmsPredownloadVideoLimit());
        long b16 = com.tencent.mobileqq.splash.d.b();
        QLog.d(TAG, 1, "todayAmsPredownloadVideoLimit " + b16);
        if (cVar.getAmsPredownloadVideoLimit() <= b16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean isClickCgiUrlForTool(String str) {
        return GdtWebReportQQ.k(str);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean isHotSplashBgPreloadTimeLimit() {
        return e.c();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean needCancelHotSplashBgPreload() {
        return e.d();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public boolean needCancelSplashFgPreload() {
        return e.e();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void notifyInstallSuccess(String str) {
        com.tencent.gdtad.downloader.d.f109172a.i(str);
        com.tencent.gdtad.downloader.j jVar = com.tencent.gdtad.downloader.j.f109185f;
        DownloadInfo l3 = jVar.l("packageName=?", new String[]{str});
        if (l3 != null && !TextUtils.isEmpty(l3.f341186f) && l3.f() == 4) {
            if (MobileQQ.sProcessId != 1) {
                QLog.e(TAG, 2, "internal cancel");
                return;
            }
            u.f109203a.a(4001011, l3);
            l3.k(6);
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateAdDownloadFile(l3);
            File file = new File(l3.L);
            if (file.exists()) {
                FileUtil.deleteFile(file);
                jVar.j(l3.f341186f);
                p.f109191a.g(l3);
            }
            QLog.e(TAG, 2, "path is " + l3.L + " ex " + new File(l3.L).exists());
        }
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void observeAppInstallerReceiver(AdClickUtil.Params params, AdClickUtil.Result result) {
        AdAppInstallerReceiver.f109163a.e(params, result);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void onDrawerResume() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ((IWeatherReportApi) QRoute.api(IWeatherReportApi.class)).reportWeather(peekAppRuntime, "drawer_weather_expose");
        HippyBundleHelper.b();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public DownloadInfo queryDownloadInfoByUrl(String str) {
        return com.tencent.gdtad.downloader.j.f109185f.k(str);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void registerAppInstallerReceiver(Context context) {
        AdAppInstallerReceiver.f109163a.h(context);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void reportADFlyingStreaming(long j3) {
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(j3);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void reportAdEvent(GdtSsoReportParam gdtSsoReportParam) {
        um0.b bVar = um0.b.f439202a;
        bVar.h(gdtSsoReportParam, null);
        bVar.i();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void reportMiniAdEvent(GdtSsoReportMiniParam gdtSsoReportMiniParam) {
        um0.b bVar = um0.b.f439202a;
        bVar.g(gdtSsoReportMiniParam, null);
        bVar.j();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void requestAdBySso(access.AdGetReq adGetReq, SsoAdCallback ssoAdCallback) {
        f.f439212a.e(adGetReq, ssoAdCallback);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void restartDownloadAfterLogin() {
        p.f109191a.o();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void startGdtMotiveVideo(StartGdtMotiveVideoParams startGdtMotiveVideoParams) {
        GdtMotiveVideoFragment.wh(startGdtMotiveVideoParams);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void unRegisterAppInstallerReceiver() {
        AdAppInstallerReceiver.f109163a.k();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void updateAmsPredownloadNonVideo() {
        com.tencent.mobileqq.splash.d.c();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void updateAmsPredownloadVideo() {
        com.tencent.mobileqq.splash.d.d();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void updateHotSplashBgPreload() {
        e.f();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void updateSplashEmptyReportExp(String str) {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        QLog.d(TAG, 1, "updateSplashEmptyReportExp " + str);
        fromV2.putString(SPLASH_EMPTY_TAB, str);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void updateSplashExpIds(List<String> list) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        HashSet hashSet = new HashSet();
        for (String str : list) {
            hashSet.add(str);
            QLog.d(TAG, 1, "updateSplashExpIds " + str);
        }
        TGSplashExpIdUtil.updateExpIdSet(hashSet);
        from.encodeStringSet(SPLASH_EXPS, hashSet);
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void updateSplashFgPreload() {
        e.h();
    }

    @Override // com.tencent.gdtad.IGdtAPI
    public void updateSplashTab(boolean z16) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        QLog.d(TAG, 1, "updateSplashTab " + z16);
        from.encodeBool(SPLASH_TAB, z16);
    }
}
