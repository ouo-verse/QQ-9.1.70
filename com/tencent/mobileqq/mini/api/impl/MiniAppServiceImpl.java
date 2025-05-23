package com.tencent.mobileqq.mini.api.impl;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import NS_MINI_REPORT.REPORT$SingleDcData;
import NS_MINI_SHARE.MiniProgramShare$StAdaptShareInfoReq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityBehind;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment;
import com.tencent.mobileqq.mini.activity.MiniSharePanelFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.api.IMiniShareCallback;
import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.mini.api.MiniProgramReportConst;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl;
import com.tencent.mobileqq.mini.apkg.ApkgConfigManager;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.entry.ContactsMiniAppEntryManager;
import com.tencent.mobileqq.mini.entry.IRefreshOperator;
import com.tencent.mobileqq.mini.entry.MiniAppEntity;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DeskTopAppEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppEntityV3;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.MiniDesktopDataPullStep;
import com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.mini.profilecard.BaseMiniAppProfileCardView;
import com.tencent.mobileqq.mini.push.MiniAppControlInfo;
import com.tencent.mobileqq.mini.push.MiniAppPushControl;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniAppShareMenuReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.servlet.GetFriendPlayListV2Request;
import com.tencent.mobileqq.mini.servlet.GetUserAppListRequest;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.share.WXShareHelperFromQQMiniApp;
import com.tencent.mobileqq.mini.ui.GuildMiniAppNavigationBar;
import com.tencent.mobileqq.mini.ui.WxAuthDetailFragment;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.utils.MiniAppReportShareUtil;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.widget.MiniAppProfileCardView;
import com.tencent.mobileqq.minigame.data.PublishMoodInfo;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.minigame.report.ProfileCardReporter;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.utils.EntryConstants;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.SharePlugin;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.FileMaterialInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv;
import com.tencent.util.ArrayUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import eipc.EIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppServiceImpl implements IMiniAppService {
    private static final String FAKE_APPID_FOR_REPORT = "0000000000";
    private static final String KEY_APP_INFO = "appInfo";
    private static final String KEY_BUSINESS_TYPE = "businessType";
    private static final String MINI_APP_DF_SEARCH_FRAGMENT = "com.tencent.mobileqq.mini.entry.dfsearch.ui.MiniAppSearchFragment";
    private static final HashMap<String, MiniArkShareModel> SHARE_MODEL_MAP;
    private static final String TAG = "MiniAppServiceImpl";
    private static final String WXA_ID_PREFIX = "wx";
    private static final String[] XIA_LA_ACTION_ARRAY;
    private static final AtomicBoolean mHasMiniAppPreloaded = new AtomicBoolean(false);
    private WeakReference<MiniAppPullInterface> mMiniAppPullInterface;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl$11, reason: invalid class name */
    /* loaded from: classes33.dex */
    public class AnonymousClass11 implements MiniAppCmdInterface {
        final /* synthetic */ MiniAppInfo val$miniAppInfo;
        final /* synthetic */ IMiniCallback val$miniCallback;

        AnonymousClass11(IMiniCallback iMiniCallback, MiniAppInfo miniAppInfo) {
            this.val$miniCallback = iMiniCallback;
            this.val$miniAppInfo = miniAppInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCmdListener$0() {
            MiniAppServiceImpl.this.showNormalFailTip();
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            String str;
            if (this.val$miniCallback != null) {
                Bundle bundle = new Bundle();
                if (z16) {
                    str = "";
                } else {
                    str = "EIPCResult.CODE_UNKOWN";
                }
                bundle.putString("ErrorMsg", str);
                this.val$miniCallback.onCallbackResult(z16, bundle);
            }
            if (z16) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast makeText;
                        if (AnonymousClass11.this.val$miniAppInfo.topType == 1) {
                            makeText = QQToast.makeText(BaseApplicationImpl.getApplication(), R.string.f16528284, 0);
                        } else {
                            makeText = QQToast.makeText(BaseApplicationImpl.getApplication(), R.string.f16529285, 0);
                        }
                        makeText.setToastIcon(QQToast.getIconRes(2));
                        makeText.setType(2);
                        makeText.show();
                    }
                });
                QLog.d(MiniAppServiceImpl.TAG, 2, "sendSetUserAppTopRequest, success to set top");
            } else {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppServiceImpl.AnonymousClass11.this.lambda$onCmdListener$0();
                    }
                });
                QLog.e(MiniAppServiceImpl.TAG, 1, "sendSetUserAppTopRequest, fail to set top");
            }
        }
    }

    static {
        HashMap<String, MiniArkShareModel> hashMap = new HashMap<>();
        SHARE_MODEL_MAP = hashMap;
        XIA_LA_ACTION_ARRAY = new String[]{String.valueOf(3002), String.valueOf(1001), String.valueOf(5007), String.valueOf(3020), String.valueOf(3001), String.valueOf(3003), String.valueOf(3027), String.valueOf(3022), String.valueOf(3009), String.valueOf(3007), String.valueOf(3010), String.valueOf(3012), String.valueOf(3015), String.valueOf(3013), String.valueOf(3011), String.valueOf(3021)};
        MiniArkShareModelBuilder miniArkShareModelBuilder = new MiniArkShareModelBuilder();
        miniArkShareModelBuilder.setAppId(MiniGameVAUtil.META_MINI_GAME_APPID).setTitle("\u5143\u68a6\u4e4b\u661f\u5c0f\u6e38\u620f").setWebURL("https://speed.gamecenter.qq.com/pushgame/v1/auth-admin/detail?_wv=134&_wwv=4&appid=1112198072&gc-refer=auth-admin&adtag_mall=&from_new_gamecenter=1").setIconUrl("https://miniapp.gtimg.cn/public/appicon/d04589e6c4bf8e7b910d3757d211ef3a_200.jpg").setDescription("\u661f\u5b9d\u9080\u8bf7\u4f60\u6765\u5bb6\u91cc\u5077\u83dc\u5566!").setPicUrl("https://img.gamecenter.qq.com/xgame/gm/1722482463095_652e01809c8a580973f0f48d06992f7d.png").setJumpUrl("mqqapi://miniapp/open?_atype=1&_mappid=1112288843&_miniapptype=1&_mvid=&_vt=3&referer=1007&via=va&_sig=3507726070&_nq=cd_extendInfo%3D%257B%2522jumpType%2522%253A5%252C%2522jumpId%2522%253A1%252C%2522jumpParams%2522%253A%257B%2522JQCallInfo%2522%253A%2522%257B%255C%2522CallType%255C%2522%253A9%252C%255C%2522GameType%255C%2522%253A%255C%2522666%255C%2522%257D%2522%257D%257D").setVersionType(3).setShareBusinessType(1).setVersionId("").setTemplateId("").setTemplateData("{}").setShareTemplateType(1).setShareBusinessType(1).setShareScene(1).setShareTarget(0).setMiniAppShareFrom(12);
        hashMap.put(MiniGameVAUtil.META_MINI_GAME_APPID, miniArkShareModelBuilder.createMiniArkShareModel());
    }

    private com.tencent.qqmini.sdk.launcher.model.MiniAppInfo getFakeMiniAppInfoForReport(String str, String str2) {
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
        miniAppInfo.appId = str;
        try {
            miniAppInfo.verType = Integer.parseInt(str2);
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "reportColorSignClickAndStartMiniApp parseInt err:", th5);
        }
        return miniAppInfo;
    }

    private IMiniGameEnv.IMiniGameFloatViewOperator getFloatViewOperator(int i3) {
        IMiniAppEnv miniAppEnv = AppLoaderFactory.g().getMiniAppEnv();
        if (miniAppEnv != null) {
            IMiniGameEnv miniGameEnv = miniAppEnv.getMiniGameEnv();
            if (miniGameEnv != null) {
                return miniGameEnv.getFloatViewOperator(i3);
            }
            QLog.e(TAG, 1, "[getFloatViewOperator] miniGameEnv is null.");
            return null;
        }
        QLog.e(TAG, 1, "[getFloatViewOperator] miniAppEnv is null.");
        return null;
    }

    private boolean isFromGuild(int i3) {
        if (i3 == 5002) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchMiniApp$1(JSONObject jSONObject, String str, Context context, int i3, EntryModel entryModel) {
        String str2;
        String str3;
        MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt(KEY_APP_INFO);
        if (miniAppInfo != null && (str2 = miniAppInfo.appId) != null && str2.startsWith("wx")) {
            FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
            if ((firstPageInfo == null || firstPageInfo.pagePath == null) ? false : true) {
                str3 = firstPageInfo.pagePath;
            } else {
                str3 = "";
            }
            int resetQQMiniAppVtToWxMiniAppVt = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).resetQQMiniAppVtToWxMiniAppVt(miniAppInfo.verType);
            String queryParameter = Uri.parse(str).getQueryParameter("host_scene");
            IWxMiniHostSceneManager iWxMiniHostSceneManager = (IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class);
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(context, miniAppInfo.appId, str3, iWxMiniHostSceneManager.formatHostScene(queryParameter, iWxMiniHostSceneManager.convertFromRefer(i3)), resetQQMiniAppVtToWxMiniAppVt, Uri.parse(str));
            return;
        }
        startMiniApp(context, str, i3, entryModel, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportMiniSearch$7(String str, String str2, String str3, boolean z16, int i3, MiniAppInfo miniAppInfo, String str4, boolean z17) {
        String str5;
        String str6;
        String str7;
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        WadlReportBuilder ext = wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setExt(11, "1").setExt(12, str).setOperModule(str2).setExt(1, str3);
        if (z16) {
            str5 = "914506";
        } else {
            str5 = "914505";
        }
        WadlReportBuilder operId = ext.setOperId(str5);
        if (z16) {
            str6 = "20";
        } else {
            str6 = "8";
        }
        WadlReportBuilder ext2 = operId.setExt(4, str6);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String str8 = "";
        sb5.append("");
        ext2.setExt(2, sb5.toString()).setGameAppId(miniAppInfo.appId).setExtSubModule(str4).setExtModule(str2);
        wadlReportBuilder.report();
        if (z17) {
            MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
            if (z16) {
                str7 = "click";
            } else {
                str7 = "expo";
            }
            if (z16) {
                str8 = "search_shop_page";
            }
            MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", str7, str8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportNavigatorbarExpose$4() {
        MiniProgramLpReportDC04239.reportNavigatorbarExpose();
        MiniAppUtils.reportMiniGameCenterDC00087("1", "969", "9043", "904301", "209625", "8", EntryConstants.LEBA_ENTRY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportWxa4239$3(String str, String str2, String str3, String str4, String str5, String str6, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
        arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
        arrayList.add(MiniProgramReportHelper.newEntry("actiontype", String.valueOf(str)));
        arrayList.add(MiniProgramReportHelper.newEntry("sub_actiontype", String.valueOf(str2)));
        arrayList.add(MiniProgramReportHelper.newEntry("reserves_action", String.valueOf(str3)));
        arrayList.add(MiniProgramReportHelper.newEntry("host_scene", String.valueOf(str4)));
        arrayList.add(MiniProgramReportHelper.newEntry("appid", String.valueOf(str5)));
        arrayList.add(MiniProgramReportHelper.newEntry("reserves2", String.valueOf(str6)));
        MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
        if (z16) {
            MiniProgramReporter.getInstance().flush();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "reportWxa4239 subActionType:" + str2 + ", appId:" + str5 + ", hostScene:" + str4 + ", reserves:" + str3 + ", reserves2:" + str6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setWxAppUrl$6(boolean z16, JSONObject jSONObject) {
        QLog.d(TAG, 1, "setWxAppUrl success: " + z16 + ", result: " + jSONObject);
    }

    private void reportMiniSearchDFResult(boolean z16) {
        String str;
        if (Build.VERSION.SDK_INT >= 26) {
            if (z16) {
                str = MiniReportManager.Value.MINI_SEARCH_DF_RESULT_MMCL_SUC;
            } else {
                str = MiniReportManager.Value.MINI_SEARCH_DF_RESULT_MMCL_FAIL;
            }
        } else if (z16) {
            str = MiniReportManager.Value.MINI_SEARCH_DF_RESULT_DEX_SUC;
        } else {
            str = MiniReportManager.Value.MINI_SEARCH_DF_RESULT_DEX_FAIL;
        }
        MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1061, "0", str, "", "", "");
    }

    private void reportMiniSearchLaunchMode(String str) {
        MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1060, "0", str, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalFailTip() {
        QQToast makeText = QQToast.makeText(BaseApplicationImpl.getApplication(), R.string.f16527283, 0);
        makeText.setToastIcon(QQToast.getIconRes(0));
        makeText.setType(0);
        makeText.show();
    }

    public static Map<String, String> stringConvertMap(String str) {
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String[] split2 = str2.split(":");
            hashMap.put(split2[0], split2[1]);
        }
        return hashMap;
    }

    private void triggerMiniSearchDFInstall(com.tencent.mobileqq.qroute.module.a aVar) {
        MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1062, "0");
        aVar.d(new com.tencent.mobileqq.qroute.module.c() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.1
            @Override // com.tencent.mobileqq.qroute.module.c
            public void onInstallError(String str, int i3) {
                QLog.e(MiniAppServiceImpl.TAG, 1, "miniSearchPlugin onInstallError, errMsg:" + str + ", code:" + i3);
            }

            @Override // com.tencent.mobileqq.qroute.module.c
            public void onInstallFinish(String str) {
                MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1063, "0");
                QLog.d(MiniAppServiceImpl.TAG, 1, "miniSearchPlugin onInstallFinish!" + str);
            }

            @Override // com.tencent.mobileqq.qroute.module.c
            public void onInstallBegin(String str) {
                QLog.d(MiniAppServiceImpl.TAG, 1, "start install miniSearchPlugin!");
                MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1062, "0");
            }

            @Override // com.tencent.mobileqq.qroute.module.c
            public void onInstallDownloadProgress(String str, int i3, int i16) {
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void addMiniProgramReportData(Object obj) {
        if (obj instanceof REPORT$SingleDcData) {
            MiniProgramReporter.getInstance().add((REPORT$SingleDcData) obj);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void addSearchItemAndCheckReport(String str, String str2, String str3, String str4, String str5) {
        ((MiniAppExposureManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).addSearchItemAndCheckReport(new MiniAppExposureManager.CommonExposureData(str, str2, str3, str4, str5));
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void asyncMiniAppDesktopInitReport(Long l3) {
        MiniAppUtils.asyncMiniAppDesktopInitReport(l3);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean asyncShareMiniProgram(Object obj) {
        try {
            return MiniProgramOpenSdkUtil.asyncShareMiniProgram((ax) obj);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "validMoodInfo exception!", th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void clearMiniCacheAdJson() {
        MiniLoadingAdManager.clearCachedSpAdJson();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void completeGameBoxTask(Context context, String str, String str2) {
        IMiniAppEnv miniAppEnv = AppLoaderFactory.g().getMiniAppEnv();
        if (miniAppEnv != null) {
            IMiniGameEnv miniGameEnv = miniAppEnv.getMiniGameEnv();
            if (miniGameEnv != null) {
                miniGameEnv.completeGameBoxTask(str, str2);
                return;
            } else {
                QLog.e(TAG, 1, "[completeGameBoxTask] miniGameEnv is null.");
                return;
            }
        }
        QLog.e(TAG, 1, "[completeGameBoxTask] miniAppEnv is null.");
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public BaseContactsMiniAppEntryManager createContactsMiniAppEntryManager(Context context, AppRuntime appRuntime, RelativeLayout relativeLayout, int i3) {
        return new ContactsMiniAppEntryManager(context, (QQAppInterface) appRuntime, relativeLayout, i3);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Entity createDeskTopAppEntity() {
        return new DeskTopAppEntity();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Manager createMiniAppEntityManager(String str) {
        return MiniAppEntityManager.get(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public MiniAppPullInterface createMiniAppEntryManager(IRefreshOperator iRefreshOperator, ViewGroup viewGroup) {
        try {
            WeakReference<MiniAppPullInterface> weakReference = new WeakReference<>(new MiniAppExpDesktopPartHost(viewGroup, iRefreshOperator));
            this.mMiniAppPullInterface = weakReference;
            return weakReference.get();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "createMiniAppEntryManager failed\uff01", th5);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public AppRuntime createMiniAppInterface(MobileQQ mobileQQ, String str) {
        if (mobileQQ instanceof BaseApplicationImpl) {
            return new MiniAppInterface((BaseApplicationImpl) mobileQQ, str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public BaseMiniAppProfileCardView createMiniAppProfileCardView(Context context) {
        return new MiniAppProfileCardView(context);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Object createMiniAppWebViewPlugin() {
        return new MiniAppPlugin();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void createUpdatableMsg(String str, String str2, int i3, int i16, int i17, String str3, int i18, byte[] bArr, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().createUpdatableMsg(str, str2, i3, i16, i17, str3, i18, bArr, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void doClearAfterLoginSuccess(boolean z16) {
        MiniAppSecurityUtil.doClearAfterLoginSuccess(z16);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean enableHttp2() {
        return GameWnsUtils.enableHttp2();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void forwardShareWithTryCatch(Context context, HashMap<String, String> hashMap, Bundle bundle, Intent intent) {
        MiniProgramOpenSdkUtil.forwardShareWithTryCatch(context, hashMap, bundle, intent);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getApkgConfigManagerClass() {
        return ApkgConfigManager.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getAppBrandUIClass() {
        return AppBrandUI.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void getAppInfoById(COMM.StCommonExt stCommonExt, String str, String str2, String str3, String str4, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().getAppInfoById(stCommonExt, str, str2, str3, str4, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void getAppInfoByLink(String str, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().getAppInfoByLink(str, i3, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getDeskTopAppEntityClass() {
        return DeskTopAppEntity.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getDesktopAppEntityV3Class() {
        return DesktopAppEntityV3.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public byte[] getGetFriendPlayListV2RequestBusiBuf(String str, int i3) {
        return new GetFriendPlayListV2Request(createProfileExt(false), str, i3).getBusiBuf();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public byte[] getGetUserAppListRequestBusiBuf(long j3, long j16) {
        return new GetUserAppListRequest(createProfileExt(true), j3, j16).getBusiBuf();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void getHotSearchApps(COMM.StCommonExt stCommonExt, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().getHotSearchApps(stCommonExt, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Drawable getIcon(Context context, String str, boolean z16) {
        return MiniAppUtils.getIcon(context, str, z16);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public List<MiniAppLocalSearchEntity> getLocalSearchData() {
        MiniAppLocalSearchManager miniAppLocalSearchManager = (MiniAppLocalSearchManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH);
        if (miniAppLocalSearchManager != null) {
            return miniAppLocalSearchManager.getLocalSearchData();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public QIPCModule getMiniAppBannerIPCModule() {
        return MiniAppBannerIPCModule.getInstance();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniAppEntityClass() {
        return MiniAppEntity.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniAppEntryHandlerClass() {
        return MiniAppEntryHandler.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniAppExposureManagerClass() {
        return MiniAppExposureManager.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniAppGameDebugSettingFragmentClass() {
        return MiniAppGameDebugSettingFragment.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniAppLocalSearchManagerClass() {
        return MiniAppLocalSearchManager.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniAppSearchDataManagerClass() {
        return MiniAppSearchDataManager.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniAppSearchFragmentClass() {
        if (!(QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_ENABLE_SEARCH_DYNAMIC_FEATURE, 0) == 1)) {
            QLog.d(TAG, 1, "getMiniAppSearchFragmentClass and enableMiniSearchDf is false");
            reportMiniSearchLaunchMode(MiniReportManager.Value.MINI_SEARCH_DF_LAUNCH_NORMAL);
            return MiniAppSearchFragment.class;
        }
        com.tencent.mobileqq.qroute.module.a plugin = QRoute.plugin("qqminisearch_feature.apk");
        QLog.d(TAG, 1, "start install miniSearchPlugin!");
        if (!plugin.b()) {
            QLog.d(TAG, 1, "getMiniAppSearchFragmentClass - miniSearchPlugin do not installed!");
            triggerMiniSearchDFInstall(plugin);
            reportMiniSearchLaunchMode(MiniReportManager.Value.MINI_SEARCH_DF_LAUNCH_NORMAL);
            return MiniAppSearchFragment.class;
        }
        QLog.d(TAG, 1, "getMiniAppSearchFragmentClass - miniSearchPlugin has been installed!");
        try {
            plugin.e();
            QLog.e(TAG, 1, "[\u540c\u6b65\u8c03\u7528-\u83b7\u53d6dfFragment] classloader:" + BaseApplicationImpl.sApplication.getClassLoader());
            Class<?> cls = Class.forName(MINI_APP_DF_SEARCH_FRAGMENT);
            QLog.e(TAG, 1, "[\u540c\u6b65\u8c03\u7528-\u83b7\u53d6dfFragment\u6210\u529f!]");
            reportMiniSearchLaunchMode(MiniReportManager.Value.MINI_SEARCH_DF_LAUNCH_DF);
            reportMiniSearchDFResult(true);
            return cls;
        } catch (ClassNotFoundException e16) {
            QLog.e(TAG, 1, "ClassNotFoundException:", e16);
            QLog.e(TAG, 1, "[\u540c\u6b65\u8c03\u7528-\u83b7\u53d6dfFragment\u5931\u8d25]");
            reportMiniSearchLaunchMode(MiniReportManager.Value.MINI_SEARCH_DF_LAUNCH_NORMAL);
            reportMiniSearchDFResult(false);
            return MiniAppSearchFragment.class;
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public int getMiniAppTopTypeByAppId(String str) {
        WeakReference<MiniAppPullInterface> weakReference = this.mMiniAppPullInterface;
        if (weakReference != null && weakReference.get() != null) {
            if (!TextUtils.isEmpty(str)) {
                return this.mMiniAppPullInterface.get().getMiniAppInfoByDesktopInfoMap(3, str) != null ? 1 : 0;
            }
            QLog.e(TAG, 1, "getMiniAppTopTypeByAppId appId is null or empty!");
            return 0;
        }
        QLog.e(TAG, 1, "getMiniAppTopTypeByAppId mMiniAppPullInterface is null!");
        return 0;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public QIPCModule getMiniAppTransferModule() {
        return MiniAppTransferModule.getInstance();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniAppUserAppInfoListManagerClass() {
        return MiniAppUserAppInfoListManager.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getMiniChooseFriendForwardClass() {
        return ForwardMiniChooseFriendOption.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public QIPCModule getMiniGamePublicAccountIPCModule() {
        return MiniGamePublicAccountIPCModule.getInstance();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Object getPhotoLocalMediaInfoByPath(String str) {
        return SharePlugin.b(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Class getPublicFragmentActivityForMiniClass() {
        return PublicFragmentActivityForMini.class;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void getPullDesktopData() {
        MiniDesktopDataPullStep.pullMiniDesktopData();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void getShareInfo(MiniProgramShare$StAdaptShareInfoReq miniProgramShare$StAdaptShareInfoReq, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().getShareInfo(miniProgramShare$StAdaptShareInfoReq, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public String getTmpPathFromOut(String str, String str2) {
        return MiniAppFileManager.getInstance().getTmpPathFromOut(str, str2);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void getWeixinSDKAppInfo(String str, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().getWeixinSDKAppInfo(str, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void getWxAppUrl(int i3, String str, MiniAppCmdInterface miniAppCmdInterface) {
        if (!TextUtils.isEmpty(str)) {
            MiniAppCmdUtil.getInstance().getWxAppUrl(i3, str, miniAppCmdInterface);
        } else if (miniAppCmdInterface != null) {
            miniAppCmdInterface.onCmdListener(false, new JSONObject());
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void gotoSchemaUri(Context context, String str) {
        SchemaUtils.gotoUri(context, str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void guessYouLike(COMM.StCommonExt stCommonExt, int i3, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().guessYouLike(stCommonExt, i3, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void handleMiniAppMoreClick(Activity activity) {
        MiniAppUtils.handleMiniAppMoreClick(activity);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void handleWXEntryActivityIntent(Activity activity, Intent intent) {
        WXShareHelperFromQQMiniApp.getInstance().handleWXEntryActivityIntent(activity, intent);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isDebugMiniApp(String str) {
        return MiniAppUtils.isDebugMiniApp(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isMiniAppFakeUrl(String str) {
        return MiniAppLauncher.isFakeUrl(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isMiniAppOpenOnProfile() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105971", false);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isMiniAppScheme(String str) {
        return MiniAppLauncher.isMiniAppScheme(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isMiniAppUrl(String str) {
        return MiniAppLauncher.isMiniAppUrl(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isMiniGamePay(Activity activity, String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (activity instanceof GameActivity1)) {
            if (str.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")) {
                return true;
            }
            String payForFriendUrl = GameWnsUtils.getPayForFriendUrl();
            if (!TextUtils.isEmpty(payForFriendUrl) && (indexOf = payForFriendUrl.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) > 0) {
                return str.startsWith(payForFriendUrl.substring(0, indexOf));
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isSharingMiniProgram(HashMap<String, String> hashMap) {
        return MiniProgramOpenSdkUtil.isSharingMiniProgram(hashMap);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isTroopAdminOrCreated() {
        return TroopApplicationListUtil.isAdminOrCreated();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean isWxAppId(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("wx");
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void killAllMiniProcess() {
        Intent intent = new Intent(MiniAppInterface.ACTION_MINI_PROCESS_EXIT);
        intent.setPackage(MobileQQ.PACKAGE_NAME);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMainPageFragment(Context context, Parcelable parcelable, int i3) {
        if (parcelable instanceof MiniAppConfig) {
            MainPageFragment.launch(context, (MiniAppConfig) parcelable, i3);
            return;
        }
        QLog.e(TAG, 1, "appConfig is invalid! appConfig=" + parcelable);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean launchMiniApp(final Context context, final String str, final int i3, final EntryModel entryModel) {
        String queryParameter = Uri.parse(str).getQueryParameter("businessType");
        if (!TextUtils.isEmpty(queryParameter) && queryParameter.matches("\\d+")) {
            if (Integer.parseInt(queryParameter) == 2) {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByQQUrl(context, str, i3);
                return true;
            }
            startMiniApp(context, str, i3, entryModel, null);
            return true;
        }
        getAppInfoByLink(str, isMiniAppFakeUrl(str) ? 0 : 2, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.api.impl.g
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppServiceImpl.this.lambda$launchMiniApp$2(context, str, i3, entryModel, z16, jSONObject);
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMiniAppByApiAppInfo(Activity activity, INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo, int i3) {
        MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = i3;
        MiniAppLauncher.launchAppByAppInfo(activity, from, launchParam, (ResultReceiver) null);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMiniAppByAppInfo(Activity activity, INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo, int i3) {
        MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StUserAppInfo);
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = i3;
        MiniAppLauncher.launchAppByAppInfo(activity, from, launchParam, (ResultReceiver) null);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMiniAppByIdWithFile(Context context, String str, String str2, String str3, int i3, File file) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FileMaterialInfo(new MiniAppFileMaterialServiceImpl().getFileMimeTypeImpl(file.getAbsolutePath()), file.getName(), file.getAbsolutePath(), file.length()));
        MiniAppLauncher.launchMiniAppByIdWithFile(context, str, str2, str3, i3, arrayList);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMiniGameCenter(Context context, String str) {
        MiniAppLauncher.launchMiniGameCenter(context, str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMiniGamePublicAccount(Context context) {
        launchMiniGamePublicAccount(context, "");
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchPermissionSettingFragmentForResult(Activity activity, String str, String str2, boolean z16, int i3) {
        PermissionSettingFragment.launchForResult(activity, str, str2, z16, i3);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void miniAppDesktopCommonPageReport(String str, String str2, Map<String, String> map) {
        MiniAppDesktopDtReportHelper.INSTANCE.getInstance().miniAppDesktopCommonPageReport(str, str2, map);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void miniAppDesktopCommonReport(String str, String str2) {
        miniAppDesktopCommonReport(str, str2, new HashMap());
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void onDexConfigUpdate(String str) {
        MiniSdkLauncher.onDexConfigUpdate(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void onEnterBackground() {
        MiniAppReportManager.onEnterBackground();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void onEnterForeground() {
        MiniAppReportManager.onEnterForeground();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void onMiniGameCardShowMoreView(String str, int i3, final int i16) {
        MiniAppCmdUtil.getInstance().getAppInfoByLink(str, i3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.9
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppInfo miniAppInfo;
                if (!z16 || jSONObject == null || (miniAppInfo = (MiniAppInfo) jSONObject.opt(MiniAppServiceImpl.KEY_APP_INFO)) == null) {
                    return;
                }
                MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                LaunchParam launchParam = miniAppConfig.launchParam;
                if (launchParam != null) {
                    launchParam.scene = 2064;
                }
                MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "expo", null, String.valueOf(i16));
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void openDesktopWxAuthFragment() {
        QPublicFragmentActivity.b.d(null, QPublicFragmentActivity.class, WxAuthDetailFragment.class);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void openSharePanel(Context context, String str, String str2, boolean z16, int i3) {
        MiniArkShareModel miniArkShareModel = SHARE_MODEL_MAP.get(str2);
        if (miniArkShareModel == null) {
            return;
        }
        miniArkShareModel.setGuildSuccessAction(i3);
        miniArkShareModel.setPkgName(str);
        Intent intent = new Intent();
        intent.putExtra(MiniChatConstants.MINI_APP_ARK_MODEL, miniArkShareModel);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QQ, true);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_QZONE, true);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_FRIENDS, true);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SHARE_WECHAT_MOMENT, true);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_COMPLAINT, true);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_RESTART_MINIAPP, false);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_SETTING, true);
        intent.putExtra(MiniChatConstants.MINI_APP_SHOW_DETAIL, true);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(MiniChatConstants.MINI_APP_ADD_SHORTCUT, true);
            intent.putExtra("key_color_note", 1);
        }
        intent.putExtra(MiniChatConstants.MINI_APP_LANDSCAPE, z16);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra(MiniChatConstants.KEY_MINI_FROM, 1);
        intent.putExtra(MiniChatConstants.MINI_APP_BG_TRANSPARENT, true);
        intent.putExtra("big_brother_source_key", "biz_src_miniapp");
        QLog.d(TAG, 1, "showArkSharePanel");
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivityBehind.class, MiniSharePanelFragment.class);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void performUploadArkShareImage(String str, IMiniCallback iMiniCallback) {
        MiniArkShareAsyncManager.performUploadArkShareImage(str, iMiniCallback);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void preDownloadPkg(String str, String str2, IMiniCallback iMiniCallback) {
        MiniAppController.preDownloadPkg(str, str2, iMiniCallback);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void preLaunchMiniAppCheckinFromLeba() {
        MiniSdkLauncher.preLaunchMiniAppCheckinFromLeba();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void prePullAppinfoByLink(String str, boolean z16, IPrePullListener iPrePullListener) {
        MiniAppPrePullManager.getInstance().prePullAppinfoByLink(str, z16, iPrePullListener);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void preloadMiniApp() {
        mHasMiniAppPreloaded.set(true);
        MiniAppController.preloadMiniApp();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void preloadMiniAppOnce() {
        if (mHasMiniAppPreloaded.compareAndSet(false, true)) {
            MiniAppController.preloadMiniApp();
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void preloadMiniGame() {
        AppBrandLaunchManager.g().preloadMiniGame();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void processControlInfo(String str, MiniAppControlInfo miniAppControlInfo) {
        MiniAppPushControl.getInstance(str).processControlInfo(miniAppControlInfo);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void report4239Async(SimpleMiniAppConfig simpleMiniAppConfig, String str, String str2, String str3, String str4) {
        MiniAppConfig miniAppConfig;
        SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo;
        MiniAppInfo miniAppInfo;
        if (simpleMiniAppConfig == null || (simpleMiniAppInfo = simpleMiniAppConfig.config) == null) {
            miniAppConfig = null;
        } else {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = simpleMiniAppInfo.stApiAppInfo;
            if (iNTERFACE$StApiAppInfo != null) {
                miniAppInfo = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
            } else {
                miniAppInfo = new MiniAppInfo();
                SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo2 = simpleMiniAppConfig.config;
                miniAppInfo.appId = simpleMiniAppInfo2.appId;
                miniAppInfo.name = simpleMiniAppInfo2.name;
                miniAppInfo.iconUrl = simpleMiniAppInfo2.iconUrl;
                miniAppInfo.verType = simpleMiniAppInfo2.verType;
                miniAppInfo.via = simpleMiniAppInfo2.via;
                miniAppInfo.hostScene = simpleMiniAppInfo2.hostScene;
            }
            miniAppConfig = new MiniAppConfig(miniAppInfo);
            LaunchParam launchParam = new LaunchParam();
            miniAppConfig.launchParam = launchParam;
            SimpleMiniAppConfig.SimpleLaunchParam simpleLaunchParam = simpleMiniAppConfig.launchParam;
            launchParam.scene = simpleLaunchParam.scene;
            launchParam.miniAppId = simpleLaunchParam.miniAppId;
            launchParam.reportData = simpleLaunchParam.reportData;
        }
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig, str, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void report4239AsyncBySdkMiniAppInfo(Object obj, String str, String str2, String str3, String str4) {
        MiniProgramLpReportDC04239.reportAsync(obj instanceof com.tencent.qqmini.sdk.launcher.model.MiniAppInfo ? new MiniAppConfig(MiniSdkLauncher.convert((com.tencent.qqmini.sdk.launcher.model.MiniAppInfo) obj)) : null, str, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportByQQ(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        MiniProgramLpReportDC04239.reportByQQ(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportByQQqunInfo(String str, String str2, String str3, String str4) {
        MiniProgramLpReportDC04239.reportByQQqunInfo(str, str2, str3, "", "", "", str4);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportByQzoneFeed(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        MiniProgramLpReportDC04239.reportByQzoneFeed(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportColorSignClickAndStartMiniApp(Context context, String str, String str2, String str3, int i3) {
        reportColorSignClick(i3, getFakeMiniAppInfoForReport(str, str3));
        String standardEntryPath = SimpleMiniAppConfig.SimpleLaunchParam.standardEntryPath(str2);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(context, str, standardEntryPath, str3, i3, null);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startMiniApp, appId: " + str + ", entryPath: " + standardEntryPath + ", versionType: " + str3 + ", colorSignScene: " + i3);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportEshopExpo(String str, String str2) {
        MiniAppBusiReport.reportEshopExpo(str, str2);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportMiniAppExposureData(SimpleMiniAppConfig simpleMiniAppConfig, int i3) {
        MiniAppConfig convert = convert(simpleMiniAppConfig);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MiniAppExposureManager.MiniAppExposureData(convert, i3));
        MiniProgramLpReportDC04239.reportPageView(arrayList, "expo");
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportMiniAppShareSheetItemClick(String str, String str2, int i3, int i16) {
        MiniAppShareMenuReportHelper.getInstance().miniAppShareSheetItemClickReport(str, str2, i3, i16);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        MiniAppUtils.reportToDC00087Async(str, str2, str3, str4, str5, str6, str7, "1");
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportMiniGameProfile(final SimpleMiniAppConfig simpleMiniAppConfig, final int i3, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.8
            @Override // java.lang.Runnable
            public void run() {
                SimpleMiniAppConfig simpleMiniAppConfig2 = simpleMiniAppConfig;
                ProfileCardReporter.reportMiniGameProfile(simpleMiniAppConfig2 != null ? MiniAppServiceImpl.this.convert(simpleMiniAppConfig2) : null, i3, z16);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportMiniGameVirtual(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, String str8, final String str9) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.7
            @Override // java.lang.Runnable
            public void run() {
                String str10;
                try {
                    String str11 = str4;
                    if (TextUtils.isEmpty(str11)) {
                        if (ArrayUtils.contains(MiniAppServiceImpl.XIA_LA_ACTION_ARRAY, str7)) {
                            str11 = "minagame_xiala_page";
                        } else if (str7.equals(String.valueOf(1037))) {
                            str11 = MiniProgramReportConst.RESERVES_ACTION_MINIGAME_SHOP_PAGE;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(MiniProgramReportHelper.newUserInfoEntries());
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(MiniProgramReportHelper.newEntry("appid", str));
                    }
                    COMM.Entry[] entryArr = new COMM.Entry[7];
                    String str12 = str7;
                    String str13 = "";
                    if (str12 == null) {
                        str12 = "";
                    }
                    entryArr[0] = MiniProgramReportHelper.newEntry("refer", str12);
                    entryArr[1] = MiniProgramReportHelper.newEntry("actiontype", String.valueOf(str2));
                    entryArr[2] = MiniProgramReportHelper.newEntry("sub_actiontype", String.valueOf(str3));
                    entryArr[3] = MiniProgramReportHelper.newEntry("reserves_action", String.valueOf(str11));
                    entryArr[4] = MiniProgramReportHelper.newEntry("reserves2", String.valueOf(str5));
                    entryArr[5] = MiniProgramReportHelper.newEntry("reserves8", String.valueOf(str6));
                    entryArr[6] = MiniProgramReportHelper.newEntry("app_type", "1");
                    arrayList.addAll(Arrays.asList(entryArr));
                    if (!TextUtils.isEmpty(str9)) {
                        arrayList.addAll(MiniProgramReportHelper.newReportEntries(str9));
                    }
                    if (!str11.equals("minagame_xiala_page")) {
                        if (TextUtils.isEmpty(str9)) {
                            str10 = "";
                        } else {
                            QLog.d(MiniAppServiceImpl.TAG, 4, "reportMiniGameVirtual reportData: " + str9);
                            String[] parseModeAndLocation = MiniProgramLpReportDC04239.parseModeAndLocation(str9);
                            str13 = parseModeAndLocation[0];
                            str10 = parseModeAndLocation[1];
                        }
                        arrayList.addAll(MiniProgramReportHelper.newModeAndLocation(str13, str10));
                    }
                    arrayList.addAll(MiniProgramReportHelper.newGenericEntries());
                    MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(2, arrayList, null));
                    MiniProgramReporter.getInstance().flush();
                } catch (OutOfMemoryError e16) {
                    QLog.e(MiniAppServiceImpl.TAG, 1, "reportMiniGameVirtual oom: ", e16);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportNavigatorbarExpose() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.e
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppServiceImpl.lambda$reportNavigatorbarExpose$4();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportProfileCardExposed(Object obj, boolean z16) {
        if (obj instanceof ProfileMiniAppInfo) {
            ProfileCardReporter.reportProfileCardExposed((ProfileMiniAppInfo) obj, z16);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportShare(String str, int i3, int i16, int i17, int i18, String str2) {
        MiniAppReportShareUtil.getInstance().reportShare(str, i3, i16, i17, i18, str2);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportShareSheetChannelExpo(String str, List<Integer> list) {
        MiniAppShareMenuReportHelper.getInstance().shareSheetChannelExpoReport(str, list);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportShareSheetShareFriendExpo(String str, List<String> list, List<Integer> list2) {
        MiniAppShareMenuReportHelper.getInstance().shareSheetShareFriendExpoReport(str, list, list2);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportShareSheetShow(String str) {
        MiniAppShareMenuReportHelper.getInstance().shareSheetShowReport(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportWxa4239(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final boolean z16) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppServiceImpl.lambda$reportWxa4239$3(str2, str3, str5, str4, str, str6, z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void searchApp(COMM.StCommonExt stCommonExt, String str, MiniAppCmdInterface miniAppCmdInterface) {
        MiniAppCmdUtil.getInstance().searchApp(stCommonExt, str, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void sendStartUpMiniAppDesktopInfo() {
        WeakReference<MiniAppPullInterface> weakReference = this.mMiniAppPullInterface;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mMiniAppPullInterface.get().sendStartUpMiniAppDesktopInfo();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void sendUserAppListRequest(Manager manager, long j3, long j16) {
        if (manager instanceof MiniAppUserAppInfoListManager) {
            ((MiniAppUserAppInfoListManager) manager).sendUserAppListRequest(j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void setMiniAppTransferModuleEvent(String str, Bundle bundle, EIPCModule eIPCModule) {
        WeakReference<MiniAppPullInterface> weakReference = this.mMiniAppPullInterface;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mMiniAppPullInterface.get().setMiniAppTransferModuleEvent(str, bundle, eIPCModule);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void setWxAppUrl(int i3, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        MiniAppCmdUtil.getInstance().setWxAppUrl(i3, str, str2, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.api.impl.f
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppServiceImpl.lambda$setWxAppUrl$6(z16, jSONObject);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void shareAsArkMessage(Activity activity, MiniArkShareModel miniArkShareModel, final IMiniShareCallback iMiniShareCallback) {
        ShareQQArkHelper.s(activity, miniArkShareModel, new MiniProgramShareUtils.OnShareListener() { // from class: com.tencent.mobileqq.mini.api.impl.h
            @Override // com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener
            public final void onShared(boolean z16, boolean z17) {
                MiniAppServiceImpl.lambda$shareAsArkMessage$5(IMiniShareCallback.this, z16, z17);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void shareAsQzoneFeeds(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, String str7, int i18, String str8, String str9, int i19, MiniAppCmdInterface miniAppCmdInterface) {
        MiniProgramShareUtils.shareAsQzoneFeeds(str, str2, str3, i3, i16, i17, str4, str5, str6, str7, i18, str8, str9, i19, miniAppCmdInterface);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void shareErrorToast(Context context, long j3, String str) {
        DangerousPersonToastUtils.shareErrorToast(context, j3, str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean shouldOpenWebFragment(String str) {
        return MiniGamePublicAccountHelper.shouldOpenWebFragment(str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void splashMiniGameClickReport(SplashMiniGameData splashMiniGameData) {
        MiniAppReportManager.splashMiniGameClickReport(splashMiniGameData);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean startMiniApp(Context context, String str, int i3, MiniAppLaunchListener miniAppLaunchListener) {
        return startMiniApp(context, str, i3, null, miniAppLaunchListener);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void submitSearchReportData() {
        ((MiniAppExposureManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).submitSearchReportData();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void updateDataDbFromNetResultInLocalSearchManager(MiniAppLocalSearchEntity miniAppLocalSearchEntity) {
        MiniAppLocalSearchManager miniAppLocalSearchManager = (MiniAppLocalSearchManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH);
        if (miniAppLocalSearchManager != null) {
            miniAppLocalSearchManager.updateDataDbFromNetResult(miniAppLocalSearchEntity);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void updateFloatView(int i3, String str, HashMap<String, String> hashMap) {
        IMiniGameEnv.IMiniGameFloatViewOperator floatViewOperator = getFloatViewOperator(i3);
        if (floatViewOperator != null) {
            floatViewOperator.updateFloatView(str, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void updateMiniAppList(int i3) {
        MiniAppUtils.updateMiniAppList(i3);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void updateRecentPlay(String str, int i3, int i16) {
        MiniAppUtils.updatePullDownEntryWeixinApp(str, i3, i16);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void updateTopTypeByAppId(String str, int i3, IMiniCallback iMiniCallback) {
        DesktopAppInfo desktopAppInfo;
        WeakReference<MiniAppPullInterface> weakReference = this.mMiniAppPullInterface;
        if (weakReference != null && weakReference.get() != null) {
            if (TextUtils.isEmpty(str)) {
                QLog.e(TAG, 1, "updateTopTypeByAppId appId is null or empty!");
                return;
            }
            QLog.d(TAG, 1, "updateTopTypeByAppId, appId :" + str + " topType:" + i3);
            if (i3 == 1) {
                desktopAppInfo = (DesktopAppInfo) this.mMiniAppPullInterface.get().getMiniAppInfoByDesktopInfoMap(1, str);
            } else {
                desktopAppInfo = (DesktopAppInfo) this.mMiniAppPullInterface.get().getMiniAppInfoByDesktopInfoMap(3, str);
            }
            if (desktopAppInfo != null) {
                MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
                miniAppInfo.topType = i3;
                sendSetUserAppTopRequest(miniAppInfo, iMiniCallback);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "updateTopTypeByAppId mMiniAppPullInterface is null!");
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void uploadArkImage(String str, IMiniCallback iMiniCallback) {
        MiniArkShareAsyncManager.performUploadArkShareImage(str, iMiniCallback);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Object validMoodInfo(Object obj) {
        try {
            return SharePlugin.h((PublishMoodInfo) obj);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "validMoodInfo exception!", th5);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean verifyArkScene(int i3) {
        return MiniAppLauncher.verifyArkScene(i3);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public Drawable getIcon(Context context, String str, boolean z16, int i3, int i16) {
        return MiniAppUtils.getIcon(context, str, z16, i3, i16);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMiniGameCenter(Context context, String str, String str2) {
        MiniAppLauncher.launchMiniGameCenter(context, str, str2);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMiniGamePublicAccount(Context context, String str) {
        MiniGamePublicAccountHelper.launchMiniGamePublicAccount(context, str);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void miniAppDesktopCommonReport(String str, String str2, Map<String, String> map) {
        MiniAppDesktopDtReportHelper.INSTANCE.getInstance().miniAppDesktopCommonReport(str, str2, map, "");
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void prePullAppinfoByLink(String str, int i3, boolean z16, IPrePullListener iPrePullListener) {
        MiniAppPrePullManager.getInstance().prePullAppinfoByLink(str, i3, z16, iPrePullListener);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        MiniAppUtils.reportToDC00087Async(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean startMiniApp(Context context, String str, int i3, EntryModel entryModel, final MiniAppLaunchListener miniAppLaunchListener) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("_miniapptype");
        String valueOf = String.valueOf(3);
        if (parse.getQueryParameter("_vt") != null) {
            valueOf = parse.getQueryParameter("_vt");
        }
        if (TextUtils.equals(queryParameter, "2")) {
            String queryParameter2 = parse.getQueryParameter("_mappid");
            String queryParameter3 = parse.getQueryParameter("_path");
            int resetQQMiniAppVtToWxMiniAppVt = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).resetQQMiniAppVtToWxMiniAppVt(Integer.parseInt(valueOf));
            String queryParameter4 = Uri.parse(str).getQueryParameter("host_scene");
            IWxMiniHostSceneManager iWxMiniHostSceneManager = (IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class);
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(context, queryParameter2, queryParameter3, iWxMiniHostSceneManager.formatHostScene(queryParameter4, iWxMiniHostSceneManager.convertFromRefer(i3)), resetQQMiniAppVtToWxMiniAppVt, parse);
            return true;
        }
        MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener2 = miniAppLaunchListener != null ? new MiniAppLauncher.MiniAppLaunchListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.2
            @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
            public void onLaunchResult(boolean z16, Bundle bundle) {
                MiniAppLaunchListener miniAppLaunchListener3 = miniAppLaunchListener;
                if (miniAppLaunchListener3 != null) {
                    miniAppLaunchListener3.onLaunchResult(z16, bundle);
                }
            }
        } : null;
        if (isFromGuild(i3) && entryModel != null) {
            entryModel.titleBarClassName = GuildMiniAppNavigationBar.class.getName();
        }
        return MiniAppLauncher.startMiniApp(context, str, i3, entryModel, miniAppLaunchListener2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MiniAppConfig convert(SimpleMiniAppConfig simpleMiniAppConfig) {
        SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo;
        MiniAppInfo miniAppInfo;
        if (simpleMiniAppConfig == null || (simpleMiniAppInfo = simpleMiniAppConfig.config) == null) {
            return null;
        }
        INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = simpleMiniAppInfo.stApiAppInfo;
        if (iNTERFACE$StApiAppInfo != null) {
            miniAppInfo = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
        } else {
            miniAppInfo = new MiniAppInfo();
            SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo2 = simpleMiniAppConfig.config;
            miniAppInfo.appId = simpleMiniAppInfo2.appId;
            miniAppInfo.name = simpleMiniAppInfo2.name;
            miniAppInfo.iconUrl = simpleMiniAppInfo2.iconUrl;
            miniAppInfo.verType = simpleMiniAppInfo2.verType;
            miniAppInfo.via = simpleMiniAppInfo2.via;
        }
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        LaunchParam launchParam = new LaunchParam();
        miniAppConfig.launchParam = launchParam;
        SimpleMiniAppConfig.SimpleLaunchParam simpleLaunchParam = simpleMiniAppConfig.launchParam;
        launchParam.scene = simpleLaunchParam.scene;
        launchParam.miniAppId = simpleLaunchParam.miniAppId;
        launchParam.reportData = simpleLaunchParam.reportData;
        return miniAppConfig;
    }

    private COMM.StCommonExt createProfileExt(boolean z16) {
        String str;
        if (z16) {
            str = "my_card";
        } else {
            str = "friend_card";
        }
        COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
        COMM.Entry entry = new COMM.Entry();
        entry.key.set("scene");
        entry.value.set(str);
        stCommonExt.mapInfo.add(entry);
        return stCommonExt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shareAsArkMessage$5(IMiniShareCallback iMiniShareCallback, boolean z16, boolean z17) {
        if (iMiniShareCallback != null) {
            iMiniShareCallback.onShared(z17);
        }
    }

    private void sendSetUserAppTopRequest(final MiniAppInfo miniAppInfo, final IMiniCallback iMiniCallback) {
        if (miniAppInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "sendSetUserAppTopRequest, miniAppInfo = null");
            }
            Bundle bundle = new Bundle();
            bundle.putString("ErrorMsg", "miniAppInfo is null");
            iMiniCallback.onCallbackResult(false, bundle);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("appid", miniAppInfo.appId);
        bundle2.putInt(MiniChatConstants.MINI_APP_TOP_TYPE, miniAppInfo.topType);
        bundle2.putInt("verType", miniAppInfo.verType);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_SYNC_MINI_APP_DATA, bundle2, new EIPCResultCallback() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.10
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                if (eIPCResult == null || eIPCResult.code != -100) {
                    MiniAppServiceImpl.this.setMiniAppTop(miniAppInfo, iMiniCallback);
                    return;
                }
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniAppInfo miniAppInfo2 = miniAppInfo;
                        if (miniAppInfo2 != null) {
                            miniAppInfo2.topType = 0;
                        }
                        if (MiniAppConfProcessor.m()) {
                            QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.qqStr(R.string.k7n) + MiniAppConfProcessor.d() + HardCodeUtil.qqStr(R.string.k7m), 0).show();
                            return;
                        }
                        QQToast.makeText(BaseApplicationImpl.getApplication(), "\u6700\u591a\u4ec5\u652f\u6301\u7f6e\u987610\u4e2a\u5c0f\u7a0b\u5e8f", 0).show();
                    }
                });
                Bundle bundle3 = new Bundle();
                bundle3.putString("ErrorMsg", "EIPCResult.CODE_UNKOWN");
                iMiniCallback.onCallbackResult(false, bundle3);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void enableGameBoxView(String str) {
        IMiniGameEnv.IMiniGameFloatViewOperator floatViewOperator = getFloatViewOperator(18);
        if (floatViewOperator != null) {
            floatViewOperator.addFloatView(str, null);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchAppByMiniCode(Context context, String str, int i3, final MiniAppLaunchListener miniAppLaunchListener) {
        MiniAppLauncher.launchAppByMiniCode(context, str, i3, miniAppLaunchListener != null ? new MiniAppLauncher.MiniAppLaunchListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.6
            @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
            public void onLaunchResult(boolean z16, Bundle bundle) {
                MiniAppLaunchListener miniAppLaunchListener2 = miniAppLaunchListener;
                if (miniAppLaunchListener2 != null) {
                    miniAppLaunchListener2.onLaunchResult(z16, bundle);
                }
            }
        } : null);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public boolean launchMiniAppByScheme(Context context, HashMap<String, String> hashMap, int i3, EntryModel entryModel, final MiniAppLaunchListener miniAppLaunchListener) {
        MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener2 = miniAppLaunchListener != null ? new MiniAppLauncher.MiniAppLaunchListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.5
            @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
            public void onLaunchResult(boolean z16, Bundle bundle) {
                MiniAppLaunchListener miniAppLaunchListener3 = miniAppLaunchListener;
                if (miniAppLaunchListener3 != null) {
                    miniAppLaunchListener3.onLaunchResult(z16, bundle);
                }
            }
        } : null;
        LaunchParam launchParam = new LaunchParam();
        launchParam.scene = i3;
        launchParam.entryModel = entryModel;
        return MiniAppLauncher.launchMiniAppByScheme(context, hashMap, launchParam, miniAppLaunchListener2);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void miniAppDesktopCommonReport(String str, String str2, Map<String, String> map, String str3) {
        MiniAppDesktopDtReportHelper.INSTANCE.getInstance().miniAppDesktopCommonReport(str, str2, map, str3);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void removeGameBoxView(String str, boolean z16) {
        IMiniGameEnv.IMiniGameFloatViewOperator floatViewOperator = getFloatViewOperator(18);
        if (floatViewOperator != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isShowOpenGuide", z16);
            floatViewOperator.removeFloatView(str, bundle);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportColorNoteExpoForMiniApp(String str, boolean z16) {
        String str2;
        String str3;
        if (z16) {
            str2 = "addRecentColorSign";
            str3 = "recentColorSign_enter";
        } else {
            str2 = "addColorSign";
            str3 = "colorSign_enter";
        }
        if (str.contains("#@#")) {
            String[] split = str.split("#@#");
            if (split.length == 2) {
                report4239AsyncBySdkMiniAppInfo(getFakeMiniAppInfoForReport(split[0], split[1]), str2, str3, "expo", null);
                return;
            }
            return;
        }
        report4239Async(str2, str3, "expo", null, null, null);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        MiniAppUtils.reportToDC00087Async(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void startApp(Activity activity, SimpleMiniAppConfig simpleMiniAppConfig, ResultReceiver resultReceiver) {
        if (simpleMiniAppConfig == null || simpleMiniAppConfig.config == null) {
            return;
        }
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo = simpleMiniAppConfig.config;
        miniAppInfo.appId = simpleMiniAppInfo.appId;
        miniAppInfo.name = simpleMiniAppInfo.name;
        miniAppInfo.iconUrl = simpleMiniAppInfo.iconUrl;
        miniAppInfo.setEngineType(simpleMiniAppInfo.engineType);
        miniAppInfo.setReportType(simpleMiniAppConfig.config.reportType);
        SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo2 = simpleMiniAppConfig.config;
        miniAppInfo.developerDesc = simpleMiniAppInfo2.developerDesc;
        miniAppInfo.gameRegistrationNumber = simpleMiniAppInfo2.gameRegistrationNumber;
        miniAppInfo.verType = simpleMiniAppInfo2.verType;
        LaunchParam launchParam = new LaunchParam();
        SimpleMiniAppConfig.SimpleLaunchParam simpleLaunchParam = simpleMiniAppConfig.launchParam;
        if (simpleLaunchParam != null) {
            launchParam.miniAppId = simpleLaunchParam.miniAppId;
            launchParam.scene = simpleLaunchParam.scene;
        }
        MiniAppLauncher.launchAppByAppInfo(activity, miniAppInfo, launchParam, resultReceiver);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void startAppByAppid(Context context, String str, String str2, String str3, int i3, final MiniAppLaunchListener miniAppLaunchListener) {
        MiniAppLauncher.launchMiniAppById(context, str, str2, null, str3, null, i3, miniAppLaunchListener != null ? new MiniAppLauncher.MiniAppLaunchListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.3
            @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
            public void onLaunchResult(boolean z16, Bundle bundle) {
                MiniAppLaunchListener miniAppLaunchListener2 = miniAppLaunchListener;
                if (miniAppLaunchListener2 != null) {
                    miniAppLaunchListener2.onLaunchResult(z16, bundle);
                }
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMiniAppTop(MiniAppInfo miniAppInfo, IMiniCallback iMiniCallback) {
        if (miniAppInfo == null) {
            QLog.e(TAG, 1, "setMiniAppTop, miniAppInfo = null.");
        } else {
            MiniAppCmdUtil.getInstance().setUserAppTop(miniAppInfo.appId, miniAppInfo.topType, miniAppInfo.verType, null, new AnonymousClass11(iMiniCallback, miniAppInfo));
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void addSearchItemAndCheckReport(SimpleMiniAppConfig simpleMiniAppConfig, String str, String str2) {
        ((MiniAppExposureManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(convert(simpleMiniAppConfig), "page_view", "expo"));
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void launchMiniAppById(Context context, String str, String str2, String str3, String str4, String str5, int i3, final MiniAppLaunchListener miniAppLaunchListener) {
        MiniAppLauncher.launchMiniAppById(context, str, str2, str3, str4, str5, i3, miniAppLaunchListener != null ? new MiniAppLauncher.MiniAppLaunchListener() { // from class: com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.4
            @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
            public void onLaunchResult(boolean z16, Bundle bundle) {
                MiniAppLaunchListener miniAppLaunchListener2 = miniAppLaunchListener;
                if (miniAppLaunchListener2 != null) {
                    miniAppLaunchListener2.onLaunchResult(z16, bundle);
                }
            }
        } : null);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void setWxAppInfo(Intent intent, MiniAppCmdInterface miniAppCmdInterface) {
        if (intent != null) {
            MiniAppCmdUtil.getInstance().setWxAppInfo(intent, miniAppCmdInterface);
        } else if (miniAppCmdInterface != null) {
            miniAppCmdInterface.onCmdListener(false, new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchMiniApp$2(final Context context, final String str, final int i3, final EntryModel entryModel, boolean z16, final JSONObject jSONObject) {
        if (z16 && jSONObject != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.j
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppServiceImpl.this.lambda$launchMiniApp$1(jSONObject, str, context, i3, entryModel);
                }
            });
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppServiceImpl.this.lambda$launchMiniApp$0(context, str, i3, entryModel);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$launchMiniApp$0(Context context, String str, int i3, EntryModel entryModel) {
        startMiniApp(context, str, i3, entryModel, null);
    }

    private void reportColorSignClick(int i3, com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo) {
        if (i3 == 1132) {
            if (miniAppInfo != null) {
                report4239AsyncBySdkMiniAppInfo(miniAppInfo, "addRecentColorSign", "recentColorSign_enter", "click", null);
                return;
            } else {
                report4239Async("addRecentColorSign", "recentColorSign_enter", "click", null, null, null);
                return;
            }
        }
        if (miniAppInfo != null) {
            report4239AsyncBySdkMiniAppInfo(miniAppInfo, "addColorSign", "colorSign_enter", "click", null);
        } else {
            report4239Async("addColorSign", "colorSign_enter", "click", null, null, null);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void reportColorSignClickWithNoAppInfo(int i3) {
        if (i3 == 1132) {
            report4239Async("addRecentColorSign", "recentColorSign_enter", "click", null, null, null);
        } else {
            report4239Async("addColorSign", "colorSign_enter", "click", null, null, null);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    public void report4239Async(String str, String str2, String str3, String str4, String str5, String str6) {
        MiniProgramLpReportDC04239.reportAsync(str, str2, str3, str4, str5, str6);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    @Override // com.tencent.mobileqq.mini.api.IMiniAppService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportMiniSearch(Object obj, int i3, final boolean z16, final int i16) {
        String str;
        final String str2;
        final boolean z17;
        int i17;
        final String str3;
        final String str4;
        final MiniAppInfo miniAppInfo;
        if (i16 == 5 || i16 == 6 || i16 == 7 || i16 == 8) {
            if (i3 == 1) {
                str = "9075";
                str2 = "907501";
                z17 = true;
                i17 = 1005;
                str3 = "982";
            } else if (i3 != 2) {
                str3 = "";
                i17 = 9999;
                str = "";
                str2 = str;
                z17 = false;
            } else {
                str = "9436";
                str2 = "943601";
                z17 = false;
                str4 = str2;
                str3 = "1117";
                i17 = 3026;
                if (!(obj instanceof MiniAppInfo)) {
                    miniAppInfo = (MiniAppInfo) obj;
                } else {
                    if (!(obj instanceof MiniAppLocalSearchEntity)) {
                        return;
                    }
                    miniAppInfo = new MiniAppInfo();
                    miniAppInfo.appId = ((MiniAppLocalSearchEntity) obj).appId;
                }
                new MiniAppConfig(miniAppInfo).launchParam.scene = i17;
                final String str5 = str;
                MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppServiceImpl.lambda$reportMiniSearch$7(str3, str5, str4, z16, i16, miniAppInfo, str2, z17);
                    }
                });
            }
            str4 = str2;
            if (!(obj instanceof MiniAppInfo)) {
            }
            new MiniAppConfig(miniAppInfo).launchParam.scene = i17;
            final String str52 = str;
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppServiceImpl.lambda$reportMiniSearch$7(str3, str52, str4, z16, i16, miniAppInfo, str2, z17);
                }
            });
        }
    }
}
