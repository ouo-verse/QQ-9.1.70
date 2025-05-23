package com.tencent.mobileqq.mini.api;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.IRefreshOperator;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.mini.push.MiniAppControlInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import eipc.EIPCModule;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniAppService extends QRouteApi {
    public static final int FLOAT_VIEW_GAME_BOX = 18;
    public static final int TYPE_HIDE_PULL_DOWN_ENTRY = 100;

    void addMiniProgramReportData(Object obj);

    void addSearchItemAndCheckReport(SimpleMiniAppConfig simpleMiniAppConfig, String str, String str2);

    void addSearchItemAndCheckReport(String str, String str2, String str3, String str4, String str5);

    void asyncMiniAppDesktopInitReport(Long l3);

    boolean asyncShareMiniProgram(Object obj);

    void clearMiniCacheAdJson();

    void completeGameBoxTask(Context context, String str, String str2);

    BaseContactsMiniAppEntryManager createContactsMiniAppEntryManager(Context context, AppRuntime appRuntime, RelativeLayout relativeLayout, int i3);

    Entity createDeskTopAppEntity();

    Manager createMiniAppEntityManager(String str);

    MiniAppPullInterface createMiniAppEntryManager(IRefreshOperator iRefreshOperator, ViewGroup viewGroup);

    AppRuntime createMiniAppInterface(MobileQQ mobileQQ, String str);

    BaseMiniAppProfileCardView createMiniAppProfileCardView(Context context);

    Object createMiniAppWebViewPlugin();

    void createUpdatableMsg(String str, String str2, int i3, int i16, int i17, String str3, int i18, byte[] bArr, MiniAppCmdInterface miniAppCmdInterface);

    void doClearAfterLoginSuccess(boolean z16);

    void enableGameBoxView(String str);

    boolean enableHttp2();

    void forwardShareWithTryCatch(Context context, HashMap<String, String> hashMap, Bundle bundle, Intent intent);

    Class getApkgConfigManagerClass();

    Class getAppBrandUIClass();

    void getAppInfoById(COMM.StCommonExt stCommonExt, String str, String str2, String str3, String str4, MiniAppCmdInterface miniAppCmdInterface);

    void getAppInfoByLink(String str, int i3, MiniAppCmdInterface miniAppCmdInterface);

    Class getDeskTopAppEntityClass();

    Class getDesktopAppEntityV3Class();

    byte[] getGetFriendPlayListV2RequestBusiBuf(String str, int i3);

    byte[] getGetUserAppListRequestBusiBuf(long j3, long j16);

    void getHotSearchApps(COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface);

    Drawable getIcon(Context context, String str, boolean z16);

    Drawable getIcon(Context context, String str, boolean z16, int i3, int i16);

    List<MiniAppLocalSearchEntity> getLocalSearchData();

    QIPCModule getMiniAppBannerIPCModule();

    Class getMiniAppEntityClass();

    Class getMiniAppEntryHandlerClass();

    Class getMiniAppExposureManagerClass();

    Class getMiniAppGameDebugSettingFragmentClass();

    Class getMiniAppLocalSearchManagerClass();

    Class getMiniAppSearchDataManagerClass();

    Class getMiniAppSearchFragmentClass();

    int getMiniAppTopTypeByAppId(String str);

    QIPCModule getMiniAppTransferModule();

    Class getMiniAppUserAppInfoListManagerClass();

    Class getMiniChooseFriendForwardClass();

    QIPCModule getMiniGamePublicAccountIPCModule();

    Object getPhotoLocalMediaInfoByPath(String str);

    Class getPublicFragmentActivityForMiniClass();

    void getPullDesktopData();

    void getShareInfo(MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq, MiniAppCmdInterface miniAppCmdInterface);

    String getTmpPathFromOut(String str, String str2);

    void getWeixinSDKAppInfo(String str, MiniAppCmdInterface miniAppCmdInterface);

    void getWxAppUrl(int i3, String str, MiniAppCmdInterface miniAppCmdInterface);

    void gotoSchemaUri(Context context, String str);

    void guessYouLike(COMM.StCommonExt stCommonExt, int i3, MiniAppCmdInterface miniAppCmdInterface);

    void handleMiniAppMoreClick(Activity activity);

    void handleWXEntryActivityIntent(Activity activity, Intent intent);

    boolean isDebugMiniApp(String str);

    boolean isMiniAppFakeUrl(String str);

    boolean isMiniAppOpenOnProfile();

    boolean isMiniAppScheme(String str);

    boolean isMiniAppUrl(String str);

    boolean isMiniGamePay(Activity activity, String str);

    boolean isSharingMiniProgram(HashMap<String, String> hashMap);

    boolean isTroopAdminOrCreated();

    boolean isWxAppId(String str);

    void killAllMiniProcess();

    void launchAppByMiniCode(Context context, String str, int i3, MiniAppLaunchListener miniAppLaunchListener);

    void launchMainPageFragment(Context context, Parcelable parcelable, int i3);

    boolean launchMiniApp(Context context, String str, int i3, EntryModel entryModel);

    void launchMiniAppByApiAppInfo(@NonNull Activity activity, @NonNull INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo, int i3);

    void launchMiniAppByAppInfo(Activity activity, INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo, int i3);

    void launchMiniAppById(Context context, String str, String str2, String str3, String str4, String str5, int i3, MiniAppLaunchListener miniAppLaunchListener);

    void launchMiniAppByIdWithFile(Context context, String str, String str2, String str3, int i3, File file);

    boolean launchMiniAppByScheme(Context context, HashMap<String, String> hashMap, int i3, EntryModel entryModel, MiniAppLaunchListener miniAppLaunchListener);

    void launchMiniGameCenter(Context context, String str);

    void launchMiniGameCenter(Context context, String str, String str2);

    void launchMiniGamePublicAccount(Context context);

    void launchMiniGamePublicAccount(Context context, String str);

    void launchPermissionSettingFragmentForResult(Activity activity, String str, String str2, boolean z16, int i3);

    void miniAppDesktopCommonPageReport(String str, String str2, Map<String, String> map);

    void miniAppDesktopCommonReport(String str, String str2);

    void miniAppDesktopCommonReport(String str, String str2, Map<String, String> map);

    void miniAppDesktopCommonReport(String str, String str2, Map<String, String> map, String str3);

    void onDexConfigUpdate(String str);

    void onEnterBackground();

    void onEnterForeground();

    void onMiniGameCardShowMoreView(String str, int i3, int i16);

    void openDesktopWxAuthFragment();

    void openSharePanel(Context context, String str, String str2, boolean z16, int i3);

    void performUploadArkShareImage(String str, IMiniCallback iMiniCallback);

    void preDownloadPkg(String str, String str2, IMiniCallback iMiniCallback);

    void preLaunchMiniAppCheckinFromLeba();

    void prePullAppinfoByLink(String str, int i3, boolean z16, IPrePullListener iPrePullListener);

    void prePullAppinfoByLink(String str, boolean z16, IPrePullListener iPrePullListener);

    void preloadMiniApp();

    void preloadMiniAppOnce();

    void preloadMiniGame();

    void processControlInfo(String str, MiniAppControlInfo miniAppControlInfo);

    void removeGameBoxView(String str, boolean z16);

    void report4239Async(SimpleMiniAppConfig simpleMiniAppConfig, String str, String str2, String str3, String str4);

    void report4239Async(String str, String str2, String str3, String str4, String str5, String str6);

    void report4239AsyncBySdkMiniAppInfo(Object obj, String str, String str2, String str3, String str4);

    void reportByQQ(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void reportByQQqunInfo(String str, String str2, String str3, String str4);

    void reportByQzoneFeed(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void reportColorNoteExpoForMiniApp(String str, boolean z16);

    void reportColorSignClickAndStartMiniApp(Context context, String str, String str2, String str3, int i3);

    void reportColorSignClickWithNoAppInfo(int i3);

    void reportEshopExpo(String str, String str2);

    void reportMiniAppExposureData(SimpleMiniAppConfig simpleMiniAppConfig, int i3);

    void reportMiniAppShareSheetItemClick(String str, String str2, int i3, int i16);

    void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    void reportMiniGameProfile(SimpleMiniAppConfig simpleMiniAppConfig, int i3, boolean z16);

    void reportMiniGameVirtual(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    void reportMiniSearch(Object obj, int i3, boolean z16, int i16);

    void reportNavigatorbarExpose();

    void reportProfileCardExposed(Object obj, boolean z16);

    void reportShare(String str, int i3, int i16, int i17, int i18, String str2);

    void reportShareSheetChannelExpo(String str, List<Integer> list);

    void reportShareSheetShareFriendExpo(String str, List<String> list, List<Integer> list2);

    void reportShareSheetShow(String str);

    void reportWxa4239(String str, String str2, String str3, String str4, String str5, String str6, boolean z16);

    void searchApp(COMM.StCommonExt stCommonExt, String str, MiniAppCmdInterface miniAppCmdInterface);

    void sendStartUpMiniAppDesktopInfo();

    void sendUserAppListRequest(Manager manager, long j3, long j16);

    void setMiniAppTransferModuleEvent(String str, Bundle bundle, EIPCModule eIPCModule);

    void setWxAppInfo(Intent intent, MiniAppCmdInterface miniAppCmdInterface);

    void setWxAppUrl(int i3, String str, String str2);

    void shareAsArkMessage(Activity activity, MiniArkShareModel miniArkShareModel, IMiniShareCallback iMiniShareCallback);

    void shareAsQzoneFeeds(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, String str7, int i18, String str8, String str9, int i19, MiniAppCmdInterface miniAppCmdInterface);

    void shareErrorToast(Context context, long j3, String str);

    boolean shouldOpenWebFragment(String str);

    void splashMiniGameClickReport(SplashMiniGameData splashMiniGameData);

    void startApp(Activity activity, SimpleMiniAppConfig simpleMiniAppConfig, ResultReceiver resultReceiver);

    void startAppByAppid(Context context, String str, String str2, String str3, int i3, MiniAppLaunchListener miniAppLaunchListener);

    boolean startMiniApp(Context context, String str, int i3, MiniAppLaunchListener miniAppLaunchListener);

    boolean startMiniApp(Context context, String str, int i3, EntryModel entryModel, MiniAppLaunchListener miniAppLaunchListener);

    void submitSearchReportData();

    void updateDataDbFromNetResultInLocalSearchManager(MiniAppLocalSearchEntity miniAppLocalSearchEntity);

    void updateFloatView(int i3, @NonNull String str, @Nullable HashMap<String, String> hashMap);

    void updateMiniAppList(int i3);

    void updateRecentPlay(String str, int i3, int i16);

    void updateTopTypeByAppId(String str, int i3, IMiniCallback iMiniCallback);

    void uploadArkImage(String str, IMiniCallback iMiniCallback);

    Object validMoodInfo(Object obj);

    boolean verifyArkScene(int i3);
}
