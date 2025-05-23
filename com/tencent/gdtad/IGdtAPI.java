package com.tencent.gdtad;

import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.adbox.GdtAdBoxListener;
import com.tencent.gdtad.basics.adbox.IGdtAdBox;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.basics.sso.callback.SsoAdCallback;
import com.tencent.gdtad.params.GdtSsoReportMiniParam;
import com.tencent.gdtad.params.GdtSsoReportParam;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import jm0.a;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtAPI extends QRouteApi {
    void actionByDownloadInfo(DownloadInfo downloadInfo);

    IGdtAdBox buildAdBox(Context context, String str, String str2, GdtAdBoxListener gdtAdBoxListener);

    void checkAppForegroundState(Integer num, a aVar);

    void checkScheduleDownloadTask(int i3);

    access.AdGetReq createRequestAdReq(qq_ad_get.QQAdGet qQAdGet);

    int getAMSHotSplashLimit();

    int getAMSNormalSplashLimit();

    int getAMSSplashLimit();

    long getAdBannerShowDelay();

    List<GdtAd> getAdBoxRefreshData(String str, String str2);

    int getAmsHotBgPreloadDuration();

    int getAmsHotShowDuration();

    int getAmsHotSplashBgPreloadLimit();

    int getAmsPredownloadDelayTime();

    boolean getAmsPredownloadNonvideoBackgroundenable();

    int getAmsPredownloadNonvideoLimit();

    int getAmsPredownloadNonvideoNettype();

    boolean getAmsPredownloadVideoBackgroundEnable();

    int getAmsPredownloadVideoNettype();

    int getAmsPreloadDuration();

    int getAmsShowAndPreloadDuration();

    int getAmsSplashFgPreloadLimit();

    boolean getCanHotAmsSplash();

    boolean getCanHotSplash();

    QIPCModule getDownloadIpcServer();

    QIPCModule getGdtADIpcModule();

    WebViewPlugin getGdtWebReportPlugin();

    String getGdtWebReportPluginName();

    int getHotSplashLimit();

    int getOlympicSplashLimit();

    long getSplashAdCheckJumpAppDelayTimeMs();

    long getSplashAdCheckResultAfterJumpTimeMs();

    long getSplashAdGuardCallbackDelayTimeMs();

    ArrayList<Integer> getSplashAdPriority();

    int getSplashDailyLimit();

    String getSplashEmptyReportExp();

    List<String> getSplashExpIds();

    boolean getSplashTab();

    int getSplashWeeklyLimit();

    int getTianShuSplashLimit();

    int getWarmDecodeTimeout();

    AdError handleWXMiniJump(AdWXMINIProgram.Params params);

    void initLandingPageConfig(Context context);

    boolean isAmsPredownloadNonVideoDownloadTimeLimit();

    boolean isAmsPredownloadVideoDownloadTimeLimit();

    boolean isClickCgiUrlForTool(String str);

    boolean isHotSplashBgPreloadTimeLimit();

    boolean needCancelHotSplashBgPreload();

    boolean needCancelSplashFgPreload();

    void notifyInstallSuccess(String str);

    void observeAppInstallerReceiver(AdClickUtil.Params params, AdClickUtil.Result result);

    void onDrawerResume();

    DownloadInfo queryDownloadInfoByUrl(String str);

    void registerAppInstallerReceiver(Context context);

    void reportADFlyingStreaming(long j3);

    void reportAdEvent(GdtSsoReportParam gdtSsoReportParam);

    void reportMiniAdEvent(GdtSsoReportMiniParam gdtSsoReportMiniParam);

    void requestAdBySso(access.AdGetReq adGetReq, SsoAdCallback ssoAdCallback);

    void restartDownloadAfterLogin();

    void startGdtMotiveVideo(StartGdtMotiveVideoParams startGdtMotiveVideoParams);

    void unRegisterAppInstallerReceiver();

    void updateAmsPredownloadNonVideo();

    void updateAmsPredownloadVideo();

    void updateHotSplashBgPreload();

    void updateSplashEmptyReportExp(String str);

    void updateSplashExpIds(List<String> list);

    void updateSplashFgPreload();

    void updateSplashTab(boolean z16);
}
