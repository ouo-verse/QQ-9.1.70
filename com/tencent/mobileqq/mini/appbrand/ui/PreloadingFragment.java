package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppShowInfoEntity;
import com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils;
import com.tencent.mobileqq.mini.appbrand.utils.PreviewManager;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.MiniGameVAInterceptCallback;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.model.StartupReportData;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import du3.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class PreloadingFragment extends QPublicBaseFragment {
    public static final String KEY_APPID = "mini_appid";
    public static final String KEY_ENTRY_PATH = "mini_entryPath";
    public static final String KEY_ENV_VERSION = "mini_envVersion";
    public static final String KEY_LAUNCH_PARAM = "mini_launch_param";
    public static final String KEY_LINK = "mini_link";
    public static final String KEY_LINK_TYPE = "mini_link_type";
    public static final String KEY_RESULT_RECEIVER = "mini_receiver";
    public static final String KEY_SLOT_ID = "mini_slot_id";
    public static final String KEY_START_TIME = "mini_start_time";
    public static final String KEY_TIANSHU_AD_ID = "mini_tianshu_ad_id";
    public static final String KEY_VIA = "mini_via";
    private static final String PRE_INTERCEPT_MC_CONFIG_ID = "102999";
    private static final String SHARE_LINK_PREFIX = "https://m.q.qq.com/a/p/";
    private static final String TAG = "PreloadingFragment";
    private static final boolean mEnableDBCache;
    private PreLoadingMiniGameVAInterceptCallback interceptCallback;
    private Bundle mBundle;
    private LinearLayout mLoadingView;
    private ResultReceiver mResultReceiver;
    private View mRootView;
    private long mStartTime;
    private Handler mUIHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public static class LinkParam {
        String appid;
        String firstPage;
        String via;

        public LinkParam(String str, String str2, String str3) {
            this.appid = str;
            this.firstPage = str2;
            this.via = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class PreLoadingMiniGameVAInterceptCallback implements MiniGameVAInterceptCallback {
        private String appid;
        private String entryPath;
        private String envVersion;
        private WeakReference<PreloadingFragment> fragmentRef;
        private String link;
        private int linkType;
        private LaunchParam param;
        private long startTime;

        PreLoadingMiniGameVAInterceptCallback(PreloadingFragment preloadingFragment) {
            this.fragmentRef = null;
            this.fragmentRef = new WeakReference<>(preloadingFragment);
        }

        public void initLaunchParam(LaunchParam launchParam, long j3, String str, String str2, String str3, String str4, int i3) {
            this.param = launchParam;
            this.startTime = j3;
            this.appid = str;
            this.envVersion = str2;
            this.link = str3;
            this.entryPath = str4;
            this.linkType = i3;
        }

        @Override // com.tencent.mobileqq.minigame.api.MiniGameVAInterceptCallback
        public void onInterceptResult(boolean z16, boolean z17) {
            PreloadingFragment preloadingFragment;
            WeakReference<PreloadingFragment> weakReference = this.fragmentRef;
            if (weakReference == null || (preloadingFragment = weakReference.get()) == null) {
                return;
            }
            QLog.d(PreloadingFragment.TAG, 1, "doTask interceptLaunch isSuccess:", Boolean.valueOf(z16), ", duration=", Long.valueOf(System.currentTimeMillis() - this.startTime));
            LaunchParam launchParam = this.param;
            launchParam.isPreIntercept = true;
            launchParam.isPreInterceptSuccess = z16;
            if (z17) {
                preloadingFragment.quit();
                QLog.i(PreloadingFragment.TAG, 1, "close preloading activity");
            } else {
                preloadingFragment.doRequest(this.appid, launchParam, this.envVersion, this.link, this.linkType, this.entryPath);
            }
        }
    }

    static {
        mEnableDBCache = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_enable_db_cache", 0) == 1;
    }

    public PreloadingFragment() {
        View inflate = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.f168277s0, (ViewGroup) null);
        this.mRootView = inflate;
        this.mLoadingView = (LinearLayout) inflate.findViewById(R.id.loading_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequest(String str, LaunchParam launchParam, String str2, String str3, int i3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            doRequestByAppid(str, str4, str2, launchParam);
        } else if (!TextUtils.isEmpty(str3)) {
            doRequestByLink(str3, i3, str2, launchParam);
        } else {
            quit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doRequestByLink(String str, int i3, String str2, LaunchParam launchParam) {
        String str3;
        boolean z16;
        String str4;
        String str5;
        int i16;
        String str6;
        Object obj;
        String str7;
        String str8;
        String str9;
        String str10;
        MiniAppEntityManager miniAppEntityManager;
        List<? extends Entity> queryEntity;
        MiniAppByLinkEntity miniAppByLinkEntity;
        final String str11 = str;
        final LaunchParam launchParam2 = launchParam == null ? new LaunchParam() : launchParam;
        boolean z17 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_ENABLE_DB_APPINFO_CACHE, 1) == 1;
        boolean z18 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_ENABLE_FAKE_APPINFO_CACHE, 0) == 1;
        boolean z19 = mEnableDBCache;
        boolean z26 = z19 ? false : z17;
        if (!z19) {
            str3 = "show_cache";
            z16 = z26;
            str4 = "start without appinfo fail, link: ";
            str5 = "miniapp-db";
            i16 = 1028;
            str6 = "start by showinfo ";
            obj = "_mappid";
            str7 = TAG;
        } else {
            if (startMiniAppFromLinkDB(str11, i3, str2, launchParam2)) {
                quit();
                return;
            }
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (!(runtime instanceof QQAppInterface) || (miniAppEntityManager = (MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER)) == null || (queryEntity = miniAppEntityManager.queryEntity(MiniAppByLinkEntity.class, false, "link=? and linkType=? ", new String[]{str11, String.valueOf(i3)}, null, null, null, null)) == null || queryEntity.size() != 1 || (miniAppByLinkEntity = (MiniAppByLinkEntity) queryEntity.get(0)) == null) {
                str3 = "show_cache";
                str9 = TAG;
                z16 = z26;
                str5 = "miniapp-db";
                obj = "_mappid";
                str10 = "start without appinfo fail, link: ";
                str6 = "start by showinfo ";
            } else {
                String str12 = miniAppByLinkEntity.appId;
                launchParam2.startupReportData = StartupReportUtil.reportBegin(str12, launchParam2.scene, 1, this.mStartTime);
                str3 = "show_cache";
                z16 = z26;
                str5 = "miniapp-db";
                str9 = TAG;
                str10 = "start without appinfo fail, link: ";
                obj = "_mappid";
                str6 = "start by showinfo ";
                MiniAppConfig showInfoFromDB = getShowInfoFromDB(str12, str, i3, null, launchParam2);
                if (showInfoFromDB != null) {
                    QLog.d(str5, 1, str6 + str12);
                    MiniAppLauncher.launchAppByAppConfig(getQBaseActivity(), showInfoFromDB, this.mResultReceiver);
                    MiniReportManager.reportEventType(showInfoFromDB, 1028, str3, MiniReportManager.getAppType(showInfoFromDB));
                    quit();
                    return;
                }
            }
            if (z18 && MiniAppLauncher.isMiniAppSchemeV2(str)) {
                try {
                    String str13 = URLUtil.getArgumentsFromURL(str).get(obj);
                    QLog.d(str9, 4, "scheme: appid:  " + str13);
                    if (!TextUtils.isEmpty(str13)) {
                        launchParam2.startupReportData = StartupReportUtil.reportBegin(str13, launchParam2.scene, 1, this.mStartTime);
                        MiniAppConfig showInfoFromDB2 = getShowInfoFromDB(str13, str, i3, "", launchParam2);
                        if (showInfoFromDB2 != null) {
                            QLog.d(str5, 1, str6 + str13);
                            MiniAppLauncher.launchAppByAppConfig(getQBaseActivity(), showInfoFromDB2, this.mResultReceiver);
                            i16 = 1028;
                            try {
                                MiniReportManager.reportEventType(showInfoFromDB2, 1028, str3, MiniReportManager.getAppType(showInfoFromDB2));
                                quit();
                                return;
                            } catch (Exception unused) {
                                StringBuilder sb5 = new StringBuilder();
                                str4 = str10;
                                sb5.append(str4);
                                str7 = str9;
                                str11 = str;
                                sb5.append(str11);
                                QLog.e(str7, 4, sb5.toString());
                                if (z16) {
                                }
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.6
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (PreloadingFragment.this.mLoadingView != null) {
                                            PreloadingFragment.this.mLoadingView.setVisibility(0);
                                        }
                                    }
                                });
                                MiniAppCmdUtil.getInstance().getAppInfoByLink(str11, i3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7
                                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                    public void onCmdListener(boolean z27, final JSONObject jSONObject) {
                                        if (z27 && jSONObject != null) {
                                            long optLong = jSONObject.optLong("retCode");
                                            String optString = jSONObject.optString("errMsg");
                                            QLog.d(PreloadingFragment.TAG, 2, "getAppInfoByLink, retCode = " + optLong + ",errMsg = " + optString);
                                            if (optLong != 0) {
                                                if (TextUtils.isEmpty(optString)) {
                                                    optString = PreloadingFragment.this.getString(R.string.h1y);
                                                }
                                                if (PreloadingFragment.this.mResultReceiver != null) {
                                                    Bundle bundle = new Bundle();
                                                    bundle.putLong("retCode", optLong);
                                                    bundle.putString("errMsg", optString);
                                                    PreloadingFragment.this.mResultReceiver.send(1, bundle);
                                                }
                                                PreloadingFragment.this.showToast(optString);
                                                PreloadingFragment.this.quit();
                                                return;
                                            }
                                            MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("appInfo");
                                            String optString2 = jSONObject.optString("shareTicket", "");
                                            if (PreloadingFragment.this.isContainerMiniApp(miniAppInfo)) {
                                                PreloadingFragment.this.refreshContainer(miniAppInfo);
                                                return;
                                            }
                                            PreviewManager previewManager = PreviewManager.getInstance();
                                            if (miniAppInfo != null && previewManager.containsAppId(miniAppInfo.appId)) {
                                                DebugUtil.setDebugEnabled(miniAppInfo.appId, false);
                                            }
                                            if (previewManager.recordAppInfo(miniAppInfo, launchParam2)) {
                                                PreloadingFragment.this.showToast("Preview AppInfo Recorded!");
                                                PreloadingFragment.this.quit();
                                                return;
                                            }
                                            MiniAppInfo previewInfo = previewManager.getPreviewInfo(miniAppInfo);
                                            if (optLong == 0 && previewInfo != null && !TextUtils.isEmpty(previewInfo.appId)) {
                                                LaunchParam launchParam3 = launchParam2;
                                                launchParam3.startupReportData = StartupReportUtil.reportBegin(previewInfo.appId, launchParam3.scene, 1, PreloadingFragment.this.mStartTime);
                                                MiniAppConfig miniAppConfig = new MiniAppConfig(previewInfo);
                                                LaunchParam launchParam4 = launchParam2;
                                                miniAppConfig.launchParam = launchParam4;
                                                launchParam4.miniAppId = previewInfo.appId;
                                                launchParam4.shareTicket = optString2;
                                                launchParam4.navigateExtData = previewInfo.extraData;
                                                miniAppConfig.link = str11;
                                                QLog.e(PreloadingFragment.TAG, 2, "getAppInfoByLink, link = " + str11);
                                                if (!TextUtils.isEmpty(miniAppConfig.launchParam.shareTicket)) {
                                                    miniAppConfig.launchParam.scene = 1044;
                                                }
                                                if (TextUtils.isEmpty(miniAppConfig.launchParam.reportData)) {
                                                    miniAppConfig.launchParam.reportData = previewInfo.reportData;
                                                } else if (!TextUtils.isEmpty(previewInfo.reportData)) {
                                                    miniAppConfig.launchParam.reportData = miniAppConfig.launchParam.reportData + ContainerUtils.FIELD_DELIMITER + previewInfo.reportData;
                                                }
                                                int i17 = previewInfo.verType;
                                                if (i17 != 3 && i17 != 1) {
                                                    miniAppConfig.launchParam.forceReload = 3;
                                                }
                                                if (previewInfo.clearAuths == 1 && a.f().l() > 0) {
                                                    miniAppConfig.config.clearAuths = 0;
                                                }
                                                try {
                                                    PreloadingFragment.this.doStartMiniApp(miniAppConfig);
                                                    if (PreloadingFragment.this.mResultReceiver != null) {
                                                        Bundle bundle2 = new Bundle();
                                                        bundle2.putLong("retCode", optLong);
                                                        bundle2.putString("errMsg", optString);
                                                        PreloadingFragment.this.mResultReceiver.send(0, bundle2);
                                                    }
                                                    MiniReportManager.reportEventType(miniAppConfig, 1028, "main_loading", MiniReportManager.getAppType(miniAppConfig));
                                                } catch (Throwable th5) {
                                                    QLog.e(PreloadingFragment.TAG, 1, "MiniAppController.startApp exception ", th5);
                                                }
                                            } else {
                                                if (previewInfo == null) {
                                                    QLog.e(PreloadingFragment.TAG, 1, "getAppInfoByLink  onCmdListener appinfo==null retCode= " + optLong);
                                                } else {
                                                    QLog.e(PreloadingFragment.TAG, 1, "getAppInfoByLink  onCmdListener retCode= " + optLong + " appid=" + previewInfo.appId);
                                                }
                                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.1
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        long optLong2 = jSONObject.optLong("retCode");
                                                        String optString3 = jSONObject.optString("errMsg");
                                                        QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. retCode=" + optLong2 + " errMsg=" + optString3);
                                                        try {
                                                            DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), optLong2, optString3);
                                                        } catch (Throwable th6) {
                                                            QLog.e(PreloadingFragment.TAG, 1, "", th6);
                                                        }
                                                    }
                                                });
                                                if (PreloadingFragment.this.mResultReceiver != null) {
                                                    Bundle bundle3 = new Bundle();
                                                    bundle3.putLong("retCode", optLong);
                                                    bundle3.putString("errMsg", optString);
                                                    PreloadingFragment.this.mResultReceiver.send(1, bundle3);
                                                }
                                            }
                                        } else {
                                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.2
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    long j3;
                                                    String str14;
                                                    JSONObject jSONObject2 = jSONObject;
                                                    if (jSONObject2 == null) {
                                                        j3 = 0;
                                                        str14 = "";
                                                    } else {
                                                        j3 = jSONObject2.optLong("retCode");
                                                        str14 = jSONObject.optString("errMsg");
                                                    }
                                                    QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. retCode=" + j3 + " errMsg=" + str14);
                                                    try {
                                                        DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), j3, str14);
                                                    } catch (Throwable th6) {
                                                        QLog.e(PreloadingFragment.TAG, 1, "", th6);
                                                    }
                                                }
                                            });
                                            if (PreloadingFragment.this.mResultReceiver != null) {
                                                Bundle bundle4 = new Bundle();
                                                if (jSONObject != null) {
                                                    bundle4.putLong("retCode", jSONObject.optLong("retCode"));
                                                    bundle4.putString("errMsg", jSONObject.optString("errMsg"));
                                                }
                                                PreloadingFragment.this.mResultReceiver.send(1, bundle4);
                                            }
                                            QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. isSuc=" + z27);
                                        }
                                        PreloadingFragment.this.quit();
                                    }
                                });
                            }
                        }
                    }
                    i16 = 1028;
                    str7 = str9;
                    str4 = str10;
                } catch (Exception unused2) {
                    i16 = 1028;
                }
            } else {
                str7 = str9;
                str4 = str10;
                i16 = 1028;
            }
            str11 = str;
        }
        if (z16) {
            int i17 = i16;
            String str14 = str3;
            if (startMiniAppFromAppInfoLinkDB(str11, i3, str2, launchParam2)) {
                quit();
                return;
            }
            if (z18 && MiniAppLauncher.isMiniAppSchemeV2(str)) {
                try {
                    String str15 = URLUtil.getArgumentsFromURL(str).get(obj);
                    QLog.d(str7, 4, "scheme: appid:  " + str15);
                    if (!TextUtils.isEmpty(str15)) {
                        launchParam2.startupReportData = StartupReportUtil.reportBegin(str15, launchParam2.scene, 1, this.mStartTime);
                        str8 = str7;
                        try {
                            MiniAppConfig showInfoFromDB3 = getShowInfoFromDB(str15, str, i3, "", launchParam2);
                            if (showInfoFromDB3 != null) {
                                QLog.d(str5, 1, str6 + str15);
                                MiniAppLauncher.launchAppByAppConfig(getQBaseActivity(), showInfoFromDB3, this.mResultReceiver);
                                MiniReportManager.reportEventType(showInfoFromDB3, i17, str14, MiniReportManager.getAppType(showInfoFromDB3));
                                quit();
                                return;
                            }
                        } catch (Exception unused3) {
                            QLog.e(str8, 4, str4 + str11);
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PreloadingFragment.this.mLoadingView != null) {
                                        PreloadingFragment.this.mLoadingView.setVisibility(0);
                                    }
                                }
                            });
                            MiniAppCmdUtil.getInstance().getAppInfoByLink(str11, i3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7
                                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                public void onCmdListener(boolean z27, final JSONObject jSONObject) {
                                    if (z27 && jSONObject != null) {
                                        long optLong = jSONObject.optLong("retCode");
                                        String optString = jSONObject.optString("errMsg");
                                        QLog.d(PreloadingFragment.TAG, 2, "getAppInfoByLink, retCode = " + optLong + ",errMsg = " + optString);
                                        if (optLong != 0) {
                                            if (TextUtils.isEmpty(optString)) {
                                                optString = PreloadingFragment.this.getString(R.string.h1y);
                                            }
                                            if (PreloadingFragment.this.mResultReceiver != null) {
                                                Bundle bundle = new Bundle();
                                                bundle.putLong("retCode", optLong);
                                                bundle.putString("errMsg", optString);
                                                PreloadingFragment.this.mResultReceiver.send(1, bundle);
                                            }
                                            PreloadingFragment.this.showToast(optString);
                                            PreloadingFragment.this.quit();
                                            return;
                                        }
                                        MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("appInfo");
                                        String optString2 = jSONObject.optString("shareTicket", "");
                                        if (PreloadingFragment.this.isContainerMiniApp(miniAppInfo)) {
                                            PreloadingFragment.this.refreshContainer(miniAppInfo);
                                            return;
                                        }
                                        PreviewManager previewManager = PreviewManager.getInstance();
                                        if (miniAppInfo != null && previewManager.containsAppId(miniAppInfo.appId)) {
                                            DebugUtil.setDebugEnabled(miniAppInfo.appId, false);
                                        }
                                        if (previewManager.recordAppInfo(miniAppInfo, launchParam2)) {
                                            PreloadingFragment.this.showToast("Preview AppInfo Recorded!");
                                            PreloadingFragment.this.quit();
                                            return;
                                        }
                                        MiniAppInfo previewInfo = previewManager.getPreviewInfo(miniAppInfo);
                                        if (optLong == 0 && previewInfo != null && !TextUtils.isEmpty(previewInfo.appId)) {
                                            LaunchParam launchParam3 = launchParam2;
                                            launchParam3.startupReportData = StartupReportUtil.reportBegin(previewInfo.appId, launchParam3.scene, 1, PreloadingFragment.this.mStartTime);
                                            MiniAppConfig miniAppConfig = new MiniAppConfig(previewInfo);
                                            LaunchParam launchParam4 = launchParam2;
                                            miniAppConfig.launchParam = launchParam4;
                                            launchParam4.miniAppId = previewInfo.appId;
                                            launchParam4.shareTicket = optString2;
                                            launchParam4.navigateExtData = previewInfo.extraData;
                                            miniAppConfig.link = str11;
                                            QLog.e(PreloadingFragment.TAG, 2, "getAppInfoByLink, link = " + str11);
                                            if (!TextUtils.isEmpty(miniAppConfig.launchParam.shareTicket)) {
                                                miniAppConfig.launchParam.scene = 1044;
                                            }
                                            if (TextUtils.isEmpty(miniAppConfig.launchParam.reportData)) {
                                                miniAppConfig.launchParam.reportData = previewInfo.reportData;
                                            } else if (!TextUtils.isEmpty(previewInfo.reportData)) {
                                                miniAppConfig.launchParam.reportData = miniAppConfig.launchParam.reportData + ContainerUtils.FIELD_DELIMITER + previewInfo.reportData;
                                            }
                                            int i172 = previewInfo.verType;
                                            if (i172 != 3 && i172 != 1) {
                                                miniAppConfig.launchParam.forceReload = 3;
                                            }
                                            if (previewInfo.clearAuths == 1 && a.f().l() > 0) {
                                                miniAppConfig.config.clearAuths = 0;
                                            }
                                            try {
                                                PreloadingFragment.this.doStartMiniApp(miniAppConfig);
                                                if (PreloadingFragment.this.mResultReceiver != null) {
                                                    Bundle bundle2 = new Bundle();
                                                    bundle2.putLong("retCode", optLong);
                                                    bundle2.putString("errMsg", optString);
                                                    PreloadingFragment.this.mResultReceiver.send(0, bundle2);
                                                }
                                                MiniReportManager.reportEventType(miniAppConfig, 1028, "main_loading", MiniReportManager.getAppType(miniAppConfig));
                                            } catch (Throwable th5) {
                                                QLog.e(PreloadingFragment.TAG, 1, "MiniAppController.startApp exception ", th5);
                                            }
                                        } else {
                                            if (previewInfo == null) {
                                                QLog.e(PreloadingFragment.TAG, 1, "getAppInfoByLink  onCmdListener appinfo==null retCode= " + optLong);
                                            } else {
                                                QLog.e(PreloadingFragment.TAG, 1, "getAppInfoByLink  onCmdListener retCode= " + optLong + " appid=" + previewInfo.appId);
                                            }
                                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    long optLong2 = jSONObject.optLong("retCode");
                                                    String optString3 = jSONObject.optString("errMsg");
                                                    QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. retCode=" + optLong2 + " errMsg=" + optString3);
                                                    try {
                                                        DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), optLong2, optString3);
                                                    } catch (Throwable th6) {
                                                        QLog.e(PreloadingFragment.TAG, 1, "", th6);
                                                    }
                                                }
                                            });
                                            if (PreloadingFragment.this.mResultReceiver != null) {
                                                Bundle bundle3 = new Bundle();
                                                bundle3.putLong("retCode", optLong);
                                                bundle3.putString("errMsg", optString);
                                                PreloadingFragment.this.mResultReceiver.send(1, bundle3);
                                            }
                                        }
                                    } else {
                                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                long j3;
                                                String str142;
                                                JSONObject jSONObject2 = jSONObject;
                                                if (jSONObject2 == null) {
                                                    j3 = 0;
                                                    str142 = "";
                                                } else {
                                                    j3 = jSONObject2.optLong("retCode");
                                                    str142 = jSONObject.optString("errMsg");
                                                }
                                                QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. retCode=" + j3 + " errMsg=" + str142);
                                                try {
                                                    DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), j3, str142);
                                                } catch (Throwable th6) {
                                                    QLog.e(PreloadingFragment.TAG, 1, "", th6);
                                                }
                                            }
                                        });
                                        if (PreloadingFragment.this.mResultReceiver != null) {
                                            Bundle bundle4 = new Bundle();
                                            if (jSONObject != null) {
                                                bundle4.putLong("retCode", jSONObject.optLong("retCode"));
                                                bundle4.putString("errMsg", jSONObject.optString("errMsg"));
                                            }
                                            PreloadingFragment.this.mResultReceiver.send(1, bundle4);
                                        }
                                        QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. isSuc=" + z27);
                                    }
                                    PreloadingFragment.this.quit();
                                }
                            });
                        }
                    }
                } catch (Exception unused4) {
                    str8 = str7;
                }
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.6
            @Override // java.lang.Runnable
            public void run() {
                if (PreloadingFragment.this.mLoadingView != null) {
                    PreloadingFragment.this.mLoadingView.setVisibility(0);
                }
            }
        });
        MiniAppCmdUtil.getInstance().getAppInfoByLink(str11, i3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z27, final JSONObject jSONObject) {
                if (z27 && jSONObject != null) {
                    long optLong = jSONObject.optLong("retCode");
                    String optString = jSONObject.optString("errMsg");
                    QLog.d(PreloadingFragment.TAG, 2, "getAppInfoByLink, retCode = " + optLong + ",errMsg = " + optString);
                    if (optLong != 0) {
                        if (TextUtils.isEmpty(optString)) {
                            optString = PreloadingFragment.this.getString(R.string.h1y);
                        }
                        if (PreloadingFragment.this.mResultReceiver != null) {
                            Bundle bundle = new Bundle();
                            bundle.putLong("retCode", optLong);
                            bundle.putString("errMsg", optString);
                            PreloadingFragment.this.mResultReceiver.send(1, bundle);
                        }
                        PreloadingFragment.this.showToast(optString);
                        PreloadingFragment.this.quit();
                        return;
                    }
                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("appInfo");
                    String optString2 = jSONObject.optString("shareTicket", "");
                    if (PreloadingFragment.this.isContainerMiniApp(miniAppInfo)) {
                        PreloadingFragment.this.refreshContainer(miniAppInfo);
                        return;
                    }
                    PreviewManager previewManager = PreviewManager.getInstance();
                    if (miniAppInfo != null && previewManager.containsAppId(miniAppInfo.appId)) {
                        DebugUtil.setDebugEnabled(miniAppInfo.appId, false);
                    }
                    if (previewManager.recordAppInfo(miniAppInfo, launchParam2)) {
                        PreloadingFragment.this.showToast("Preview AppInfo Recorded!");
                        PreloadingFragment.this.quit();
                        return;
                    }
                    MiniAppInfo previewInfo = previewManager.getPreviewInfo(miniAppInfo);
                    if (optLong == 0 && previewInfo != null && !TextUtils.isEmpty(previewInfo.appId)) {
                        LaunchParam launchParam3 = launchParam2;
                        launchParam3.startupReportData = StartupReportUtil.reportBegin(previewInfo.appId, launchParam3.scene, 1, PreloadingFragment.this.mStartTime);
                        MiniAppConfig miniAppConfig = new MiniAppConfig(previewInfo);
                        LaunchParam launchParam4 = launchParam2;
                        miniAppConfig.launchParam = launchParam4;
                        launchParam4.miniAppId = previewInfo.appId;
                        launchParam4.shareTicket = optString2;
                        launchParam4.navigateExtData = previewInfo.extraData;
                        miniAppConfig.link = str11;
                        QLog.e(PreloadingFragment.TAG, 2, "getAppInfoByLink, link = " + str11);
                        if (!TextUtils.isEmpty(miniAppConfig.launchParam.shareTicket)) {
                            miniAppConfig.launchParam.scene = 1044;
                        }
                        if (TextUtils.isEmpty(miniAppConfig.launchParam.reportData)) {
                            miniAppConfig.launchParam.reportData = previewInfo.reportData;
                        } else if (!TextUtils.isEmpty(previewInfo.reportData)) {
                            miniAppConfig.launchParam.reportData = miniAppConfig.launchParam.reportData + ContainerUtils.FIELD_DELIMITER + previewInfo.reportData;
                        }
                        int i172 = previewInfo.verType;
                        if (i172 != 3 && i172 != 1) {
                            miniAppConfig.launchParam.forceReload = 3;
                        }
                        if (previewInfo.clearAuths == 1 && a.f().l() > 0) {
                            miniAppConfig.config.clearAuths = 0;
                        }
                        try {
                            PreloadingFragment.this.doStartMiniApp(miniAppConfig);
                            if (PreloadingFragment.this.mResultReceiver != null) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putLong("retCode", optLong);
                                bundle2.putString("errMsg", optString);
                                PreloadingFragment.this.mResultReceiver.send(0, bundle2);
                            }
                            MiniReportManager.reportEventType(miniAppConfig, 1028, "main_loading", MiniReportManager.getAppType(miniAppConfig));
                        } catch (Throwable th5) {
                            QLog.e(PreloadingFragment.TAG, 1, "MiniAppController.startApp exception ", th5);
                        }
                    } else {
                        if (previewInfo == null) {
                            QLog.e(PreloadingFragment.TAG, 1, "getAppInfoByLink  onCmdListener appinfo==null retCode= " + optLong);
                        } else {
                            QLog.e(PreloadingFragment.TAG, 1, "getAppInfoByLink  onCmdListener retCode= " + optLong + " appid=" + previewInfo.appId);
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                long optLong2 = jSONObject.optLong("retCode");
                                String optString3 = jSONObject.optString("errMsg");
                                QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. retCode=" + optLong2 + " errMsg=" + optString3);
                                try {
                                    DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), optLong2, optString3);
                                } catch (Throwable th6) {
                                    QLog.e(PreloadingFragment.TAG, 1, "", th6);
                                }
                            }
                        });
                        if (PreloadingFragment.this.mResultReceiver != null) {
                            Bundle bundle3 = new Bundle();
                            bundle3.putLong("retCode", optLong);
                            bundle3.putString("errMsg", optString);
                            PreloadingFragment.this.mResultReceiver.send(1, bundle3);
                        }
                    }
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            long j3;
                            String str142;
                            JSONObject jSONObject2 = jSONObject;
                            if (jSONObject2 == null) {
                                j3 = 0;
                                str142 = "";
                            } else {
                                j3 = jSONObject2.optLong("retCode");
                                str142 = jSONObject.optString("errMsg");
                            }
                            QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. retCode=" + j3 + " errMsg=" + str142);
                            try {
                                DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), j3, str142);
                            } catch (Throwable th6) {
                                QLog.e(PreloadingFragment.TAG, 1, "", th6);
                            }
                        }
                    });
                    if (PreloadingFragment.this.mResultReceiver != null) {
                        Bundle bundle4 = new Bundle();
                        if (jSONObject != null) {
                            bundle4.putLong("retCode", jSONObject.optLong("retCode"));
                            bundle4.putString("errMsg", jSONObject.optString("errMsg"));
                        }
                        PreloadingFragment.this.mResultReceiver.send(1, bundle4);
                    }
                    QLog.e(PreloadingFragment.TAG, 1, "GetAppInfoByLink failed. isSuc=" + z27);
                }
                PreloadingFragment.this.quit();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartMiniApp(MiniAppConfig miniAppConfig) {
        try {
            if (!isMiniAppInfoValid(miniAppConfig)) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.11
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.pcf), 1).show();
                    }
                });
            } else {
                MiniAppLauncher.launchAppByAppConfig(getQBaseActivity(), miniAppConfig, null);
                checkHandlePreloadPkg(miniAppConfig);
            }
        } catch (Throwable th5) {
            QLog.e("miniapp", 1, "startAppByAppid exception! ", th5);
        }
    }

    private LinkParam getParamFromLink(String str) {
        String str2;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            if (MiniAppLauncher.decodeScheme(str, hashMap)) {
                str2 = (String) hashMap.get("appid");
                try {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = (String) hashMap.get(KEY_APPID);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = (String) hashMap.get("_mappid");
                    }
                    str3 = (String) hashMap.get("_nq");
                } catch (Exception e16) {
                    e = e16;
                    str3 = null;
                    QLog.e(TAG, 1, "getAppIdFromLink exception:", e);
                    QLog.d(TAG, 1, "getParamFromLink appId=", str2, ", firstPage=", str3, ", link=", str, ", via=", str4);
                    return new LinkParam(str2, str3, str4);
                }
                try {
                    if (!TextUtils.isEmpty(str3)) {
                        str3 = URLUtil.decodeUrl(str3);
                    }
                } catch (Exception e17) {
                    e = e17;
                    QLog.e(TAG, 1, "getAppIdFromLink exception:", e);
                    QLog.d(TAG, 1, "getParamFromLink appId=", str2, ", firstPage=", str3, ", link=", str, ", via=", str4);
                    return new LinkParam(str2, str3, str4);
                }
            } else {
                str2 = null;
                str3 = null;
            }
            if (str.startsWith(SHARE_LINK_PREFIX)) {
                Matcher matcher = Pattern.compile("\\d+").matcher(str);
                if (matcher.find()) {
                    str2 = matcher.group();
                }
                String str5 = (String) hashMap.get(ReportConstant.COSTREPORT_PREFIX);
                if (!TextUtils.isEmpty(str5)) {
                    str3 = URLUtil.decodeUrl(str5);
                }
            }
            str4 = (String) hashMap.get("via");
        } catch (Exception e18) {
            e = e18;
            str2 = null;
            str3 = null;
        }
        QLog.d(TAG, 1, "getParamFromLink appId=", str2, ", firstPage=", str3, ", link=", str, ", via=", str4);
        return new LinkParam(str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quit() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            QBaseActivity qBaseActivity = getQBaseActivity();
            if (qBaseActivity == null || qBaseActivity.isFinishing()) {
                return;
            }
            qBaseActivity.finish();
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.13
            @Override // java.lang.Runnable
            public void run() {
                QBaseActivity qBaseActivity2 = PreloadingFragment.this.getQBaseActivity();
                if (qBaseActivity2 == null || qBaseActivity2.isFinishing()) {
                    return;
                }
                qBaseActivity2.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QQToast.makeText(PreloadingFragment.this.getQBaseActivity(), str, 0).show();
                } catch (Throwable th5) {
                    QLog.e(PreloadingFragment.TAG, 1, "", th5);
                }
            }
        });
    }

    public Bundle getArgumentBundle() {
        return this.mBundle;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QLog.i("miniapp-start", 1, "LoadingFragment onCreate");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d("miniapp-start", 1, "LoadingFragment onDestroy...");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.1
            @Override // java.lang.Runnable
            public void run() {
                PreloadingFragment.this.doTask();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        QLog.i("miniapp-start", 1, "LoadingFragment onViewCreated");
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public void setArgumentBundle(Bundle bundle) {
        this.mBundle = bundle;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshContainer(MiniAppInfo miniAppInfo) {
        QLog.d(TAG, 2, "refreshContainer");
        s.x().f0().i0(getContext()).g0("").h0(MiniSdkLauncher.convert(miniAppInfo)).d0();
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).reloadAllMiniContainer();
        showToast(getString(R.string.xym));
        quit();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QLog.i("miniapp-start", 1, "LoadingFragment onCreateView");
        if (this.mRootView == null) {
            View inflate = LayoutInflater.from(getQBaseActivity()).inflate(R.layout.f168277s0, (ViewGroup) null);
            this.mRootView = inflate;
            this.mLoadingView = (LinearLayout) inflate.findViewById(R.id.loading_layout);
        }
        return this.mRootView;
    }

    private void checkHandlePreloadPkg(final MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null || !miniAppConfig.isEngineTypeMiniGame()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.12
            @Override // java.lang.Runnable
            public void run() {
                MiniSDK.preDownloadPkg(BaseApplication.getContext(), MiniSdkLauncher.convert(miniAppConfig), null);
            }
        }, 64, null, false);
    }

    private void doRequestByAppid(String str, String str2, String str3, final LaunchParam launchParam) {
        MiniAppConfig showInfoFromDB;
        String optString;
        if (launchParam == null) {
            launchParam = new LaunchParam();
        }
        launchParam.startupReportData = StartupReportUtil.reportBegin(str, launchParam.scene, 1, this.mStartTime);
        boolean z16 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_ENABLE_DB_APPINFO_CACHE, 1) == 1;
        boolean z17 = mEnableDBCache;
        boolean z18 = z17 ? false : z16;
        if (z17 && startMiniAppFromIdDB(str, str2, str3, launchParam)) {
            quit();
            return;
        }
        if (z18 && startMiniAppFromAppInfoIdDB(str, str2, str3, launchParam)) {
            quit();
            return;
        }
        if ((z17 || z18) && (showInfoFromDB = getShowInfoFromDB(str, null, 0, str2, launchParam)) != null) {
            QLog.d("miniapp-db", 1, "start by showinfo " + str);
            MiniAppLauncher.launchAppByAppConfig(getQBaseActivity(), showInfoFromDB, this.mResultReceiver);
            MiniReportManager.reportEventType(showInfoFromDB, 1028, "show_cache", MiniReportManager.getAppType(showInfoFromDB));
            quit();
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (PreloadingFragment.this.mLoadingView != null) {
                    PreloadingFragment.this.mLoadingView.setVisibility(0);
                }
            }
        });
        if (launchParam.privateExtraData != null) {
            try {
                optString = new JSONObject(launchParam.privateExtraData).optJSONObject("functionalPage").optJSONObject("originAccountInfo").optString("appId");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            MiniAppCmdUtil.getInstance().getAppInfoById(null, str, str2, str3, optString, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z19, final JSONObject jSONObject) {
                    if (z19) {
                        final long optLong = jSONObject.optLong("retCode");
                        final String optString2 = jSONObject.optString("errMsg");
                        QLog.i(PreloadingFragment.TAG, 1, "getAppInfoById, retCode = " + optLong + ",errMsg = " + optString2);
                        if (optLong == -1003) {
                            QLog.e(PreloadingFragment.TAG, 1, "getAppInfoById error https decode buffer, clear token");
                            MiniAppSecurityUtil.doClearAfterLoginSuccess(true);
                        }
                        MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                        if (miniAppInfo != null) {
                            MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                            LaunchParam launchParam2 = launchParam;
                            miniAppConfig.launchParam = launchParam2;
                            launchParam2.miniAppId = miniAppInfo.appId;
                            if (!TextUtils.isEmpty(launchParam2.extendData)) {
                                miniAppConfig.config.extendData = launchParam.extendData;
                            }
                            int i3 = miniAppInfo.verType;
                            if (i3 != 3 && i3 != 1) {
                                miniAppConfig.launchParam.forceReload = 3;
                            }
                            PreloadingFragment.this.doStartMiniApp(miniAppConfig);
                            if (PreloadingFragment.this.mResultReceiver != null) {
                                Bundle bundle = new Bundle();
                                bundle.putLong("retCode", optLong);
                                bundle.putString("errMsg", optString2);
                                PreloadingFragment.this.mResultReceiver.send(0, bundle);
                            }
                            MiniReportManager.reportEventType(miniAppConfig, 1028, "main_loading", MiniReportManager.getAppType(miniAppConfig));
                        } else {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), optLong, optString2);
                                }
                            });
                            if (PreloadingFragment.this.mResultReceiver != null) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putLong("retCode", optLong);
                                bundle2.putString("errMsg", optString2);
                                PreloadingFragment.this.mResultReceiver.send(1, bundle2);
                            }
                        }
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                String str4;
                                long j3;
                                JSONObject jSONObject2 = jSONObject;
                                if (jSONObject2 != null) {
                                    j3 = jSONObject2.optLong("retCode");
                                    str4 = jSONObject.optString("errMsg");
                                } else {
                                    str4 = "";
                                    j3 = 0;
                                }
                                QLog.e(PreloadingFragment.TAG, 1, "getAppInfoById failed. retCode=" + j3 + " errMsg=" + str4);
                                DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), j3, str4);
                            }
                        });
                        if (PreloadingFragment.this.mResultReceiver != null) {
                            Bundle bundle3 = new Bundle();
                            if (jSONObject != null) {
                                bundle3.putLong("retCode", jSONObject.optLong("retCode"));
                                bundle3.putString("errMsg", jSONObject.optString("errMsg"));
                            }
                            PreloadingFragment.this.mResultReceiver.send(1, bundle3);
                        }
                    }
                    PreloadingFragment.this.quit();
                }
            });
        }
        optString = null;
        MiniAppCmdUtil.getInstance().getAppInfoById(null, str, str2, str3, optString, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z19, final JSONObject jSONObject) {
                if (z19) {
                    final long optLong = jSONObject.optLong("retCode");
                    final String optString2 = jSONObject.optString("errMsg");
                    QLog.i(PreloadingFragment.TAG, 1, "getAppInfoById, retCode = " + optLong + ",errMsg = " + optString2);
                    if (optLong == -1003) {
                        QLog.e(PreloadingFragment.TAG, 1, "getAppInfoById error https decode buffer, clear token");
                        MiniAppSecurityUtil.doClearAfterLoginSuccess(true);
                    }
                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                    if (miniAppInfo != null) {
                        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                        LaunchParam launchParam2 = launchParam;
                        miniAppConfig.launchParam = launchParam2;
                        launchParam2.miniAppId = miniAppInfo.appId;
                        if (!TextUtils.isEmpty(launchParam2.extendData)) {
                            miniAppConfig.config.extendData = launchParam.extendData;
                        }
                        int i3 = miniAppInfo.verType;
                        if (i3 != 3 && i3 != 1) {
                            miniAppConfig.launchParam.forceReload = 3;
                        }
                        PreloadingFragment.this.doStartMiniApp(miniAppConfig);
                        if (PreloadingFragment.this.mResultReceiver != null) {
                            Bundle bundle = new Bundle();
                            bundle.putLong("retCode", optLong);
                            bundle.putString("errMsg", optString2);
                            PreloadingFragment.this.mResultReceiver.send(0, bundle);
                        }
                        MiniReportManager.reportEventType(miniAppConfig, 1028, "main_loading", MiniReportManager.getAppType(miniAppConfig));
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), optLong, optString2);
                            }
                        });
                        if (PreloadingFragment.this.mResultReceiver != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putLong("retCode", optLong);
                            bundle2.putString("errMsg", optString2);
                            PreloadingFragment.this.mResultReceiver.send(1, bundle2);
                        }
                    }
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            String str4;
                            long j3;
                            JSONObject jSONObject2 = jSONObject;
                            if (jSONObject2 != null) {
                                j3 = jSONObject2.optLong("retCode");
                                str4 = jSONObject.optString("errMsg");
                            } else {
                                str4 = "";
                                j3 = 0;
                            }
                            QLog.e(PreloadingFragment.TAG, 1, "getAppInfoById failed. retCode=" + j3 + " errMsg=" + str4);
                            DangerousPersonToastUtils.openErrorToast(BaseApplication.getContext(), j3, str4);
                        }
                    });
                    if (PreloadingFragment.this.mResultReceiver != null) {
                        Bundle bundle3 = new Bundle();
                        if (jSONObject != null) {
                            bundle3.putLong("retCode", jSONObject.optLong("retCode"));
                            bundle3.putString("errMsg", jSONObject.optString("errMsg"));
                        }
                        PreloadingFragment.this.mResultReceiver.send(1, bundle3);
                    }
                }
                PreloadingFragment.this.quit();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doTask() {
        String str;
        String str2;
        String str3;
        LinkParam paramFromLink;
        QLog.i("miniapp-start", 1, "LoadingFragment doTask");
        Bundle arguments = getArguments();
        if (arguments == null) {
            quit();
            return;
        }
        MiniSdkLauncher.initSDK(getContext() != null ? getContext().getApplicationContext() : null);
        arguments.setClassLoader(getClass().getClassLoader());
        this.mResultReceiver = (ResultReceiver) arguments.getParcelable("mini_receiver");
        String string = arguments.getString(KEY_APPID);
        LaunchParam launchParam = (LaunchParam) arguments.getParcelable("mini_launch_param");
        if (launchParam == null) {
            launchParam = new LaunchParam();
        }
        LaunchParam launchParam2 = launchParam;
        String string2 = arguments.getString("mini_envVersion");
        String string3 = arguments.getString("mini_link");
        int i3 = arguments.getInt("mini_link_type");
        String string4 = arguments.getString("mini_entryPath");
        String string5 = arguments.getString(KEY_VIA);
        int i16 = arguments.getInt(KEY_TIANSHU_AD_ID);
        this.mStartTime = arguments.getLong(KEY_START_TIME, System.currentTimeMillis());
        if (!TextUtils.isEmpty(string5)) {
            launchParam2.via = string5;
        }
        if (i16 != 0) {
            launchParam2.tianshuAdId = i16;
        }
        String string6 = arguments.getString(KEY_SLOT_ID);
        if (!TextUtils.isEmpty(string6)) {
            launchParam2.slotId = string6;
        }
        if (!TextUtils.isEmpty(string) || TextUtils.isEmpty(string3) || (paramFromLink = getParamFromLink(string3)) == null) {
            str = string5;
            str2 = string;
            str3 = string4;
        } else {
            String str4 = paramFromLink.appid;
            String str5 = paramFromLink.firstPage;
            str = paramFromLink.via;
            str2 = str4;
            str3 = str5;
        }
        FragmentActivity activity = getActivity();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(PRE_INTERCEPT_MC_CONFIG_ID, false);
        QLog.d(TAG, 1, "doTask miniAppId:", str2, ", isPreInterceptOn=", Boolean.valueOf(isSwitchOn), ", activity=", activity);
        if (!launchParam2.isPreIntercept && isSwitchOn && !TextUtils.isEmpty(str2) && activity != null) {
            long currentTimeMillis = System.currentTimeMillis();
            PreLoadingMiniGameVAInterceptCallback preLoadingMiniGameVAInterceptCallback = new PreLoadingMiniGameVAInterceptCallback(this);
            this.interceptCallback = preLoadingMiniGameVAInterceptCallback;
            preLoadingMiniGameVAInterceptCallback.initLaunchParam(launchParam2, currentTimeMillis, string, string2, string3, string4, i3);
            ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).interceptLaunch(activity, str2, str3, launchParam2.scene, str, this.interceptCallback);
            return;
        }
        doRequest(string, launchParam2, string2, string3, i3, string4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isContainerMiniApp(MiniAppInfo miniAppInfo) {
        return miniAppInfo != null && MiniConst.MiniContainerConst.APP_ID.equals(miniAppInfo.appId);
    }

    private boolean isMiniAppInfoValid(MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo;
        return (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || TextUtils.isEmpty(miniAppInfo.appId) || TextUtils.isEmpty(miniAppConfig.config.downloadUrl)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if ("release".equals(r21) == false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean startMiniAppFromAppInfoIdDB(String str, String str2, String str3, LaunchParam launchParam) {
        MiniAppInfoByIdEntity miniAppInfoByIdEntity;
        MiniAppInfo miniAppInfoByIdFromDB;
        if (TextUtils.isEmpty(str3)) {
        }
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                MiniAppEntityManager miniAppEntityManager = (MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
                if (miniAppEntityManager != null) {
                    QLog.d("miniapp-db", 1, "query appInfo startAppByAppid start.");
                    String str4 = str2 == null ? "" : str2;
                    List<? extends Entity> queryEntity = miniAppEntityManager.queryEntity(MiniAppInfoByIdEntity.class, false, "appId=? and entryPath=? ", new String[]{str, str4}, null, null, null, null);
                    if (queryEntity != null && queryEntity.size() == 1 && (miniAppInfoByIdEntity = (MiniAppInfoByIdEntity) queryEntity.get(0)) != null && (miniAppInfoByIdFromDB = MiniAppInfo.getMiniAppInfoByIdFromDB(miniAppInfoByIdEntity)) != null) {
                        LaunchParam launchParam2 = launchParam == null ? new LaunchParam() : launchParam;
                        if (launchParam != null && !TextUtils.isEmpty(launchParam.extendData)) {
                            miniAppInfoByIdFromDB.extendData = launchParam.extendData;
                        }
                        QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Id DB.");
                        MiniAppLauncher.launchAppByAppInfo(getQBaseActivity(), miniAppInfoByIdFromDB, launchParam2, (ResultReceiver) null);
                        if (this.mResultReceiver != null) {
                            Bundle bundle = new Bundle();
                            bundle.putLong("retCode", 0L);
                            bundle.putString("errMsg", "");
                            this.mResultReceiver.send(0, bundle);
                        }
                        MiniAppCmdUtil.getInstance().getAppInfoById(null, str, str4, str3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.5
                            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                                if (z16 && jSONObject != null) {
                                    long optLong = jSONObject.optLong("retCode");
                                    String optString = jSONObject.optString("errMsg");
                                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                                    if (optLong == 0 && miniAppInfo == null) {
                                        return;
                                    }
                                    if (miniAppInfo == null) {
                                        QLog.e("miniapp-db", 1, "getAppInfoById  onCmdListener appinfo==null retCode= " + optLong + "; errMsg : " + optString);
                                        return;
                                    }
                                    QLog.e("miniapp-db", 1, "getAppInfoById  onCmdListener retCode= " + optLong + " appid=" + miniAppInfo.appId + "; errMsg : " + optString);
                                    return;
                                }
                                QLog.e("miniapp-db", 1, "launchMiniAppById cmd fail." + z16);
                            }
                        });
                        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfoByIdFromDB);
                        MiniReportManager.reportEventType(miniAppConfig, 1028, MiniReportManager.Value.MINI_APP_START_BY_ID_INFO_CACHE, MiniReportManager.getAppType(miniAppConfig));
                        return true;
                    }
                }
            } else {
                QLog.e("miniapp-db", 1, "not QQAppInterface");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "startMiniAppFromAppInfoIdDB getLinkInfo from db error,", th5);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if ("release".equals(r22) == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean startMiniAppFromIdDB(String str, String str2, String str3, LaunchParam launchParam) {
        MiniAppInfo miniAppInfoByIdFromDB;
        if (TextUtils.isEmpty(str3)) {
        }
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                MiniAppEntityManager miniAppEntityManager = (MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
                if (miniAppEntityManager != null) {
                    QLog.d("miniapp-db", 1, "query startAppByAppid start.");
                    String str4 = str2 == null ? "" : str2;
                    List<? extends Entity> queryEntity = miniAppEntityManager.queryEntity(MiniAppByIdEntity.class, false, "appId=? and entryPath=? ", new String[]{str, str4}, null, null, null, null);
                    List<? extends Entity> queryEntity2 = miniAppEntityManager.queryEntity(MiniAppInfoEntity.class, false, "appId=? ", new String[]{str}, null, null, null, null);
                    if (queryEntity != null && queryEntity.size() == 1 && queryEntity2 != null && queryEntity2.size() == 1) {
                        MiniAppByIdEntity miniAppByIdEntity = (MiniAppByIdEntity) queryEntity.get(0);
                        MiniAppInfoEntity miniAppInfoEntity = (MiniAppInfoEntity) queryEntity2.get(0);
                        if (miniAppByIdEntity != null && (miniAppInfoByIdFromDB = MiniAppInfo.getMiniAppInfoByIdFromDB(miniAppByIdEntity, miniAppInfoEntity)) != null) {
                            LaunchParam launchParam2 = launchParam == null ? new LaunchParam() : launchParam;
                            if (launchParam != null && !TextUtils.isEmpty(launchParam.extendData)) {
                                miniAppInfoByIdFromDB.extendData = launchParam.extendData;
                            }
                            QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Id DB.");
                            MiniAppLauncher.launchAppByAppInfo(getQBaseActivity(), miniAppInfoByIdFromDB, launchParam2, (ResultReceiver) null);
                            if (this.mResultReceiver != null) {
                                Bundle bundle = new Bundle();
                                bundle.putLong("retCode", 0L);
                                bundle.putString("errMsg", "");
                                this.mResultReceiver.send(0, bundle);
                            }
                            MiniAppCmdUtil.getInstance().getAppInfoById(null, str, str4, str3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.4
                                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                                    if (z16 && jSONObject != null) {
                                        long optLong = jSONObject.optLong("retCode");
                                        String optString = jSONObject.optString("errMsg");
                                        MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                                        if (optLong == 0 && miniAppInfo == null) {
                                            return;
                                        }
                                        if (miniAppInfo == null) {
                                            QLog.e("miniapp-db", 1, "getAppInfoById  onCmdListener appinfo==null retCode= " + optLong + "; errMsg : " + optString);
                                            return;
                                        }
                                        QLog.e("miniapp-db", 1, "getAppInfoById  onCmdListener retCode= " + optLong + " appid=" + miniAppInfo.appId + "; errMsg : " + optString);
                                        return;
                                    }
                                    QLog.e("miniapp-db", 1, "launchMiniAppById cmd fail." + z16);
                                }
                            });
                            MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfoByIdFromDB);
                            MiniReportManager.reportEventType(miniAppConfig, 1028, "id_cache", MiniReportManager.getAppType(miniAppConfig));
                            return true;
                        }
                    }
                }
            } else {
                QLog.e("miniapp-db", 1, "not QQAppInterface");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getLinkInfo from db error,", th5);
        }
        return false;
    }

    private MiniAppConfig getShowInfoFromDB(String str, String str2, int i3, String str3, LaunchParam launchParam) {
        MiniAppEntityManager miniAppEntityManager;
        List<? extends Entity> queryEntity;
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (!(runtime instanceof QQAppInterface) || (miniAppEntityManager = (MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER)) == null || (queryEntity = miniAppEntityManager.queryEntity(MiniAppShowInfoEntity.class, false, "appId=? ", new String[]{str}, null, null, null, null)) == null || queryEntity.size() != 1) {
                return null;
            }
            MiniAppShowInfoEntity miniAppShowInfoEntity = (MiniAppShowInfoEntity) queryEntity.get(0);
            String str4 = miniAppShowInfoEntity.appId;
            String str5 = miniAppShowInfoEntity.appName;
            String str6 = miniAppShowInfoEntity.icon;
            String str7 = miniAppShowInfoEntity.desc;
            String str8 = miniAppShowInfoEntity.gameCopyrightInfo;
            String str9 = miniAppShowInfoEntity.gamePublicationNumber;
            String str10 = miniAppShowInfoEntity.gamePublicationCompany;
            String str11 = miniAppShowInfoEntity.gameApprovalNumber;
            String str12 = miniAppShowInfoEntity.gameOperatingCompany;
            String str13 = miniAppShowInfoEntity.gameRegistrationNumber;
            int i16 = miniAppShowInfoEntity.reportType;
            int i17 = miniAppShowInfoEntity.engineType;
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6)) {
                return null;
            }
            MiniAppInfo miniAppInfo = new MiniAppInfo();
            miniAppInfo.appId = str4;
            miniAppInfo.name = str5;
            miniAppInfo.iconUrl = str6;
            miniAppInfo.setReportType(i16);
            miniAppInfo.setEngineType(i17);
            miniAppInfo.developerDesc = str7;
            miniAppInfo.gameCopyrightInfo = str8;
            miniAppInfo.gamePublicationNumber = str9;
            miniAppInfo.gamePublicationCompany = str10;
            miniAppInfo.gameApprovalNumber = str11;
            miniAppInfo.gameOperatingCompany = str12;
            miniAppInfo.gameRegistrationNumber = str13;
            FirstPageInfo firstPageInfo = new FirstPageInfo();
            miniAppInfo.firstPage = firstPageInfo;
            firstPageInfo.setPagePath(str3);
            MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
            miniAppConfig.launchParam = launchParam;
            miniAppConfig.isFromShowInfo = true;
            miniAppConfig.link = str2;
            miniAppConfig.linkType = i3;
            miniAppConfig.entryPath = str3;
            miniAppInfo.verType = MiniAppInfo.getVerType(launchParam.envVersion);
            return miniAppConfig;
        } catch (Throwable th5) {
            QLog.e("miniapp-db", 1, "getShowInfoFromDB error, ", th5);
            return null;
        }
    }

    private boolean startMiniAppFromAppInfoLinkDB(String str, int i3, String str2, LaunchParam launchParam) {
        MiniAppInfoByLinkEntity miniAppInfoByLinkEntity;
        MiniAppInfo miniAppInfoByLinkFromDB;
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                MiniAppEntityManager miniAppEntityManager = (MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
                if (miniAppEntityManager != null) {
                    QLog.d("miniapp-db", 1, "query linkEntityList start.");
                    List<? extends Entity> queryEntity = miniAppEntityManager.queryEntity(MiniAppInfoByLinkEntity.class, false, "link=? and linkType=? ", new String[]{str, String.valueOf(i3)}, null, null, null, null);
                    if (queryEntity != null && queryEntity.size() == 1 && (miniAppInfoByLinkEntity = (MiniAppInfoByLinkEntity) queryEntity.get(0)) != null && (miniAppInfoByLinkFromDB = MiniAppInfo.getMiniAppInfoByLinkFromDB(miniAppInfoByLinkEntity)) != null) {
                        MiniAppInfo previewInfo = PreviewManager.getInstance().getPreviewInfo(miniAppInfoByLinkFromDB);
                        LaunchParam launchParam2 = launchParam == null ? new LaunchParam() : launchParam;
                        String str3 = miniAppInfoByLinkEntity.shareTicket;
                        launchParam2.shareTicket = str3;
                        if (!TextUtils.isEmpty(str3)) {
                            launchParam2.scene = 1044;
                        }
                        launchParam2.startupReportData = StartupReportUtil.reportBegin(previewInfo.appId, launchParam2.scene, 0, this.mStartTime);
                        QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Link DB.");
                        MiniAppLauncher.launchAppByAppInfo(getQBaseActivity(), previewInfo, launchParam2, str, null);
                        new MiniAppConfig(previewInfo).launchParam = launchParam2;
                        if (this.mResultReceiver != null) {
                            Bundle bundle = new Bundle();
                            bundle.putLong("retCode", 0L);
                            bundle.putString("errMsg", "");
                            this.mResultReceiver.send(0, bundle);
                        }
                        MiniAppCmdUtil.getInstance().getAppInfoByLink(str, i3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.9
                            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                                if (z16 && jSONObject != null) {
                                    long optLong = jSONObject.optLong("retCode");
                                    String optString = jSONObject.optString("errMsg");
                                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("appInfo");
                                    if (optLong == 0 && miniAppInfo != null) {
                                        if (miniAppInfo.clearAuths == 1) {
                                            TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount());
                                            return;
                                        }
                                        return;
                                    }
                                    if (miniAppInfo == null) {
                                        QLog.e("miniapp-db", 1, "getAppInfoByLink  onCmdListener appinfo==null retCode= " + optLong + "; errMsg : " + optString);
                                        return;
                                    }
                                    QLog.e("miniapp-db", 1, "getAppInfoByLink  onCmdListener retCode= " + optLong + " appid=" + miniAppInfo.appId + "; errMsg : " + optString);
                                    return;
                                }
                                QLog.e("miniapp-db", 1, "launchMiniAppByLink cmd fail." + z16);
                            }
                        });
                        MiniAppConfig miniAppConfig = new MiniAppConfig(previewInfo);
                        MiniReportManager.reportEventType(miniAppConfig, 1028, MiniReportManager.Value.MINI_APP_START_BY_LINK_INFO_CACHE, MiniReportManager.getAppType(miniAppConfig));
                        return true;
                    }
                }
            } else {
                QLog.e("miniapp-db", 1, "not QQAppInterface");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getLinkInfo from db error,", th5);
        }
        return false;
    }

    @Deprecated
    private boolean startMiniAppFromLinkDB(String str, int i3, String str2, LaunchParam launchParam) {
        MiniAppByLinkEntity miniAppByLinkEntity;
        MiniAppInfo miniAppInfoByLinkFromDB;
        LaunchParam launchParam2 = launchParam;
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                MiniAppEntityManager miniAppEntityManager = (MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
                if (miniAppEntityManager != null) {
                    QLog.d("miniapp-db", 1, "query linkEntityList start.");
                    List<? extends Entity> queryEntity = miniAppEntityManager.queryEntity(MiniAppByLinkEntity.class, false, "link=? and linkType=? ", new String[]{str, String.valueOf(i3)}, null, null, null, null);
                    if (queryEntity != null && queryEntity.size() == 1 && (miniAppByLinkEntity = (MiniAppByLinkEntity) queryEntity.get(0)) != null) {
                        String str3 = miniAppByLinkEntity.appId;
                        StartupReportData reportBegin = StartupReportUtil.reportBegin(str3, launchParam2 == null ? 9999 : launchParam2.scene, 1, this.mStartTime);
                        if (launchParam2 != null) {
                            launchParam2.startupReportData = reportBegin;
                        }
                        List<? extends Entity> queryEntity2 = miniAppEntityManager.queryEntity(MiniAppInfoEntity.class, false, "appId=? ", new String[]{str3}, null, null, null, null);
                        if (queryEntity2 != null && queryEntity2.size() == 1 && (miniAppInfoByLinkFromDB = MiniAppInfo.getMiniAppInfoByLinkFromDB(miniAppByLinkEntity, (MiniAppInfoEntity) queryEntity2.get(0))) != null) {
                            if (launchParam2 == null) {
                                launchParam2 = new LaunchParam();
                            }
                            String str4 = miniAppByLinkEntity.shareTicket;
                            launchParam2.shareTicket = str4;
                            launchParam2.navigateExtData = miniAppInfoByLinkFromDB.extraData;
                            if (!TextUtils.isEmpty(str4)) {
                                launchParam2.scene = 1044;
                            }
                            QLog.d("miniapp-db", 1, "launchMiniAppByAppInfo by Link DB.");
                            MiniAppLauncher.launchAppByAppInfo(getQBaseActivity(), miniAppInfoByLinkFromDB, launchParam2, (ResultReceiver) null);
                            new MiniAppConfig(miniAppInfoByLinkFromDB).launchParam = launchParam2;
                            if (this.mResultReceiver != null) {
                                Bundle bundle = new Bundle();
                                bundle.putLong("retCode", 0L);
                                bundle.putString("errMsg", "");
                                this.mResultReceiver.send(0, bundle);
                            }
                            MiniAppCmdUtil.getInstance().getAppInfoByLink(str, i3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.8
                                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                                    if (z16 && jSONObject != null) {
                                        long optLong = jSONObject.optLong("retCode");
                                        String optString = jSONObject.optString("errMsg");
                                        MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("appInfo");
                                        if (optLong == 0 && miniAppInfo != null) {
                                            if (miniAppInfo.clearAuths == 1) {
                                                TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount());
                                                return;
                                            }
                                            return;
                                        }
                                        if (miniAppInfo == null) {
                                            QLog.e("miniapp-db", 1, "getAppInfoByLink  onCmdListener appinfo==null retCode= " + optLong + "; errMsg : " + optString);
                                            return;
                                        }
                                        QLog.e("miniapp-db", 1, "getAppInfoByLink  onCmdListener retCode= " + optLong + " appid=" + miniAppInfo.appId + "; errMsg : " + optString);
                                        return;
                                    }
                                    QLog.e("miniapp-db", 1, "launchMiniAppByLink cmd fail." + z16);
                                }
                            });
                            MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfoByLinkFromDB);
                            MiniReportManager.reportEventType(miniAppConfig, 1028, "link_cache", MiniReportManager.getAppType(miniAppConfig));
                            return true;
                        }
                    }
                }
            } else {
                QLog.e("miniapp-db", 1, "not QQAppInterface");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getLinkInfo from db error,", th5);
        }
        return false;
    }
}
