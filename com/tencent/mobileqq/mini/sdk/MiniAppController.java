package com.tencent.mobileqq.mini.sdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.apkg.AppMediaInfo;
import com.tencent.mobileqq.mini.apkg.AppPkgInfo;
import com.tencent.mobileqq.mini.apkg.AppVideoInfo;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI1;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI2;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI3;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.MiniGameVAInterceptCallback;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minigame.ui.GameActivity2;
import com.tencent.mobileqq.minigame.ui.GameActivity3;
import com.tencent.mobileqq.minigame.ui.GameActivity6;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.util.AppSetting;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppController {
    public static final int ACTION_REQUEST_API_PERMISSION = 5;
    public static final int ACTION_REQUEST_CODE_CAMERA = 4;
    public static final int ACTION_REQUEST_CODE_CHOOSE_LOCATION = 3;
    public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_FRIEND_H5 = 3004;
    public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_H5 = 3003;
    public static final int ACTION_REQUEST_CODE_GAME_PAY_BY_WX_H5 = 3005;
    public static final int ACTION_REQUEST_CODE_GAME_PAY_THROUGH_TOOL = 3002;
    public static final int ACTION_REQUEST_CODE_GET_VIDEO = 2;
    public static final int ACTION_REQUEST_CODE_LOAD_MINI_CONF = 1;
    public static final int ACTION_REQUEST_CODE_PAY = 3001;
    public static final int ACTION_REQUEST_OPEN_BLUETOOTH = 6;
    public static final int ACTION_REQUEST_OPEN_GROUP_API = 9;
    public static final int ACTION_REQUEST_OPEN_GROUP_SELECTMEMBERS = 10;
    public static final int ACTION_REQUEST_SELECT_PHOTO = 8;
    public static final int ACTION_REQUEST_SHARE = 7;
    private static final Set<String> MINI_GAME_ACTIVITY_SET;
    private static final String MINI_PROCESS_NAME = "com.tencent.mobileqq:mini";
    private static final String MINI_PROCESS_PRELOAD_ENTRY = "mini_myfile";
    private static final Set<String> MINI_PROGRAM_ACTIVITY_SET;
    private static final int REPORT_FOREGROUND_RESERVES_AV_CONVERSATION = 4;
    private static final int REPORT_FOREGROUND_RESERVES_CAMERA_PREVIEW = 3;
    private static final int REPORT_FOREGROUND_RESERVES_MINI_GAME = 2;
    private static final int REPORT_FOREGROUND_RESERVES_MINI_PROGRAM = 1;
    private static final int REPORT_NO_FOREGROUND = 0;
    public static final String TAG = "MiniAppController";
    private static List<Integer> arkBattleScenes;
    private static MiniAppController instance;
    private static byte[] lock = new byte[0];
    private ArrayList<ActivityResultListener> activityResultListenerList;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface ActivityResultListener {
        boolean doOnActivityResult(int i3, int i16, Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    @interface ReportForegroundType {
    }

    MiniAppController() {
    }

    private static void addVAToRecentPlay(MiniAppConfig miniAppConfig) {
        MiniAppUtils.updatePullDownEntryListData(miniAppConfig);
    }

    private static int checkIfCameraPreviewingOrAVConversationOrMiniAppForeground(Context context) {
        ComponentName componentName;
        ComponentName componentName2;
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                if (activityManager != null) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(1)) {
                        if (runningTaskInfo != null) {
                            componentName = runningTaskInfo.topActivity;
                            if (componentName != null) {
                                componentName2 = runningTaskInfo.topActivity;
                                String className = componentName2.getClassName();
                                QLog.d("MiniAppController", 1, "checkIfCameraPreviewingOrAVConversationOrMiniAppForeground ", className);
                                if (!((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName().equals(className) && !"com.android.camera.CaptureCameraActivity".equals(className)) {
                                    if (!AVActivity.class.getName().equals(className) && !VideoInviteActivity.class.getName().equals(className) && !GaInviteLockActivity.class.getName().equals(className)) {
                                        if (MINI_PROGRAM_ACTIVITY_SET.contains(className)) {
                                            return 1;
                                        }
                                        if (MINI_GAME_ACTIVITY_SET.contains(className)) {
                                            return 2;
                                        }
                                    }
                                    return 4;
                                }
                                return 3;
                            }
                            continue;
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("MiniAppController", 1, "checkIfCameraPreviewingOrAVConversationOrMiniAppForeground", e16);
            }
        }
        return 0;
    }

    private static void checkMiniAppEntityDB() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.1
            @Override // java.lang.Runnable
            public void run() {
                MiniAppEntityManager miniAppEntityManager;
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof QQAppInterface) {
                    try {
                        miniAppEntityManager = (MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
                    } catch (Exception e16) {
                        QLog.e("MiniAppController", 1, "checkMiniAppEntityDB error : ", e16);
                        miniAppEntityManager = null;
                    }
                    if (miniAppEntityManager != null) {
                        miniAppEntityManager.checkDB();
                    }
                }
            }
        }, 32, null, true);
    }

    public static MiniAppController getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MiniAppController();
                }
            }
        }
        return instance;
    }

    private static VirtualAppInfo getVirtualAppInfo(MiniAppConfig miniAppConfig) {
        String str;
        String str2;
        AppVideoInfo appVideoInfo;
        AppMediaInfo appMediaInfo;
        MiniAppInfo miniAppInfo = miniAppConfig.config;
        VirtualAppInfo virtualAppInfo = new VirtualAppInfo();
        String str3 = miniAppInfo.iconUrl;
        if (str3 == null) {
            str3 = "";
        }
        virtualAppInfo.y(str3);
        String str4 = miniAppInfo.name;
        if (str4 == null) {
            str4 = "";
        }
        virtualAppInfo.A(str4);
        String str5 = miniAppInfo.tags;
        if (str5 == null) {
            str5 = "";
        }
        virtualAppInfo.G(str5);
        String str6 = miniAppInfo.desc;
        if (str6 == null) {
            str6 = "";
        }
        virtualAppInfo.D(str6);
        String str7 = miniAppInfo.appId;
        if (str7 == null) {
            str7 = "";
        }
        virtualAppInfo.z(str7);
        String str8 = "1";
        if (!miniAppInfo.isMultiLogin) {
            str = "";
        } else {
            str = "1";
        }
        virtualAppInfo.a0(str);
        if (!miniAppInfo.isSupportPay) {
            str8 = "";
        }
        virtualAppInfo.b0(str8);
        LaunchParam launchParam = miniAppConfig.launchParam;
        virtualAppInfo.Z(launchParam == null ? 9999 : launchParam.scene);
        String str9 = miniAppInfo.via;
        if (str9 == null) {
            str9 = "";
        }
        virtualAppInfo.d0(str9);
        LaunchParam launchParam2 = miniAppConfig.launchParam;
        if (launchParam2 == null || (str2 = launchParam2.reportData) == null) {
            str2 = "";
        }
        virtualAppInfo.V(str2);
        AppPkgInfo appPkgInfo = miniAppInfo.pkgInfo;
        if (appPkgInfo != null) {
            String str10 = appPkgInfo.name;
            if (str10 == null) {
                str10 = "";
            }
            virtualAppInfo.N(str10);
        }
        String str11 = miniAppInfo.version;
        if (str11 == null) {
            str11 = "";
        }
        virtualAppInfo.c0(str11);
        String str12 = miniAppInfo.downloadUrl;
        if (str12 == null) {
            str12 = "";
        }
        virtualAppInfo.E(str12);
        List<AppMediaInfo> list = miniAppInfo.coverInfo;
        if (list != null && list.size() > 0) {
            String str13 = miniAppInfo.coverInfo.get(0).url;
            if (str13 == null) {
                str13 = "";
            }
            virtualAppInfo.C(str13);
        }
        List<AppVideoInfo> list2 = miniAppInfo.videoInfo;
        if (list2 != null && list2.size() > 0 && (appMediaInfo = (appVideoInfo = miniAppInfo.videoInfo.get(0)).video) != null) {
            String str14 = appMediaInfo.url;
            virtualAppInfo.f0(str14 != null ? str14 : "");
            virtualAppInfo.e0(appVideoInfo.video.height);
            virtualAppInfo.g0(appVideoInfo.video.width);
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniAppController", 2, "[getVirtualAppInfo] virtualAppInfo:" + virtualAppInfo);
        }
        return virtualAppInfo;
    }

    private static boolean isArkBattleUrl(String str, LaunchParam launchParam) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (launchParam != null && arkBattleScenes.contains(Integer.valueOf(launchParam.scene))) {
            return true;
        }
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        String str2 = argumentsFromURL.containsKey("scene") ? argumentsFromURL.get("scene") : null;
        if (!TextUtils.isEmpty(str2)) {
            Iterator<Integer> it = arkBattleScenes.iterator();
            while (it.hasNext()) {
                if (String.valueOf(it.next()).equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isInterceptStartYunGameMiniApp(MiniAppConfig miniAppConfig, Activity activity) {
        String str;
        LaunchParam launchParam = miniAppConfig.launchParam;
        if (launchParam != null) {
            str = String.valueOf(launchParam.scene);
        } else {
            str = "";
        }
        if (!MiniAppStartUtils.shouldInterceptStartMiniApp(miniAppConfig.config.appId, str)) {
            return false;
        }
        QLog.i("MiniAppController", 1, "study mode, can't start in current scene = " + str);
        QQToastUtil.showQQToastInUiThread(0, activity.getString(R.string.f167672dk));
        return true;
    }

    private static void launchMiniAppByLink(Context context, String str, int i3, LaunchParam launchParam, final MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener) {
        Intent intent = new Intent();
        intent.putExtra("mini_link", str);
        intent.putExtra("mini_link_type", i3);
        if (launchParam != null) {
            intent.putExtra("mini_launch_param", launchParam);
        }
        if (miniAppLaunchListener != null) {
            intent.putExtra("mini_receiver", new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.5
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i16, Bundle bundle) {
                    super.onReceiveResult(i16, bundle);
                    miniAppLaunchListener.onLaunchResult(i16 == 0, bundle);
                }
            });
        }
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra(PreloadingFragment.KEY_START_TIME, System.currentTimeMillis());
        if (context != null) {
            if (!(context instanceof Activity)) {
                intent.addFlags(411041792);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, PreloadingFragment.class);
        }
    }

    public static void navigateBackMiniApp(Context context, String str, LaunchParam launchParam, final MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener) {
        Intent intent = new Intent();
        intent.putExtra(PreloadingFragment.KEY_APPID, str);
        if (launchParam != null) {
            launchParam.fromBackToMiniApp = 1;
            intent.putExtra("mini_launch_param", launchParam);
        }
        intent.putExtra("mini_receiver", new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.9
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                super.onReceiveResult(i3, bundle);
                MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener2 = miniAppLaunchListener;
                if (miniAppLaunchListener2 != null) {
                    miniAppLaunchListener2.onLaunchResult(i3 == 0, new Bundle());
                }
            }
        });
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra(PreloadingFragment.KEY_START_TIME, System.currentTimeMillis());
        if (context != null) {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, PreloadingFragment.class);
        }
    }

    public static void preDownloadPkg(String str, String str2, IMiniCallback iMiniCallback) {
        AppBrandLaunchManager.g().preDownloadPkg(str, str2, iMiniCallback);
    }

    public static void preloadMiniApp() {
        MiniAppReportManager.registerActivityLifecycleCallbacks();
        if (com.tencent.mobileqq.perf.process.foregroud.b.f257916a.c(MINI_PROCESS_PRELOAD_ENTRY, "com.tencent.mobileqq:mini")) {
            MiniAppMainServiceApiManager.INSTANCE.preloadMiniApp();
        }
        checkMiniAppEntityDB();
    }

    public static void preloadMiniAppLibs() {
        if (com.tencent.mobileqq.perf.process.foregroud.b.f257916a.c(MINI_PROCESS_PRELOAD_ENTRY, "com.tencent.mobileqq:mini")) {
            MiniAppMainServiceApiManager.INSTANCE.preloadMiniAppLibs();
        }
    }

    public static void recordAppLaunchTime(String str, int i3) {
        QLog.e("MiniAppController", 1, "startApp startTime = " + System.currentTimeMillis());
        MiniReportManager.getLaunchState(str).eventTime.put(Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startApp(final Activity activity, final MiniAppConfig miniAppConfig, final ResultReceiver resultReceiver) {
        boolean z16;
        boolean z17;
        MiniAppInfo miniAppInfo;
        String str;
        int i3;
        String str2;
        if (miniAppConfig == null) {
            QLog.e("MiniAppController", 1, "startApp appConfig is empty!");
            return;
        }
        QLog.e("MiniAppController", 1, "startApp appConfig " + miniAppConfig.link);
        LaunchParam launchParam = miniAppConfig.launchParam;
        if (launchParam != null) {
            z17 = launchParam.isPreIntercept;
            z16 = launchParam.isPreInterceptSuccess;
        } else {
            z16 = false;
            z17 = false;
        }
        QLog.d("MiniAppController", 1, "startApp isPreIntercept:", Boolean.valueOf(z17), ", isPreInterceptSuccess=", Boolean.valueOf(z16));
        if (z16) {
            addVAToRecentPlay(miniAppConfig);
            return;
        }
        MiniAppInfo miniAppInfo2 = miniAppConfig.config;
        if (miniAppInfo2 != null && miniAppInfo2.isWxMiniApp()) {
            IWxMiniHostSceneManager iWxMiniHostSceneManager = (IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class);
            int convertFromRefer = iWxMiniHostSceneManager.convertFromRefer(miniAppConfig.launchParam.scene);
            if (!TextUtils.isEmpty(miniAppConfig.link)) {
                convertFromRefer = iWxMiniHostSceneManager.formatHostScene(Uri.parse(miniAppConfig.link).getQueryParameter("host_scene"), convertFromRefer);
            }
            String str3 = miniAppConfig.launchParam.entryPath;
            FirstPageInfo firstPageInfo = miniAppConfig.config.firstPage;
            if (firstPageInfo != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
                str3 = miniAppConfig.config.firstPage.pagePath;
            }
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(activity, miniAppConfig.config.appId, str3, convertFromRefer);
            return;
        }
        if (!AppSetting.isPublicVersion() && MiniGameVAUtil.canRedirectMeta(miniAppConfig.config.appId)) {
            FirstPageInfo firstPageInfo2 = miniAppConfig.config.firstPage;
            firstPageInfo2.pagePath = MiniGameVAUtil.getRedirectMeta(firstPageInfo2.pagePath);
        }
        if (activity != null && (miniAppInfo = miniAppConfig.config) != null && !TextUtils.isEmpty(miniAppInfo.appId) && !z17) {
            final long currentTimeMillis = System.currentTimeMillis();
            FirstPageInfo firstPageInfo3 = miniAppConfig.config.firstPage;
            if (firstPageInfo3 == null) {
                str = "";
            } else {
                str = firstPageInfo3.pagePath;
            }
            LaunchParam launchParam2 = miniAppConfig.launchParam;
            if (launchParam2 == null) {
                i3 = 0;
                str2 = "";
            } else {
                int i16 = launchParam2.scene;
                str2 = launchParam2.via;
                i3 = i16;
            }
            ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).interceptLaunch(activity, miniAppConfig.config.appId, str, i3, str2, new MiniGameVAInterceptCallback() { // from class: com.tencent.mobileqq.mini.sdk.b
                @Override // com.tencent.mobileqq.minigame.api.MiniGameVAInterceptCallback
                public final void onInterceptResult(boolean z18, boolean z19) {
                    MiniAppController.lambda$startApp$0(currentTimeMillis, activity, miniAppConfig, resultReceiver, z18, z19);
                }
            });
            return;
        }
        startAppInner(activity, miniAppConfig, resultReceiver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startAppByAppid(final Context context, String str, String str2, String str3, LaunchParam launchParam, final MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener) {
        QLog.i("MiniAppController", 1, "startAppByAppid appid:" + str + " entryPath:" + str2 + " envVersion:" + str3 + "  param:" + launchParam);
        if (BaseActivity.sTopActivity != null) {
            QLog.d("MiniAppController", 1, "cur Activity:" + BaseActivity.sTopActivity.getActivityName() + "  class :" + BaseActivity.sTopActivity.getLocalClassName());
        }
        if (!NetworkUtil.isNetworkAvailable(context)) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(context, R.string.c4w, 0).show();
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.3
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(context, "AppID\u4e3a\u7a7a", 0).show();
                }
            });
            return;
        }
        launchParam.timestamp = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.putExtra(PreloadingFragment.KEY_APPID, str);
        intent.putExtra("mini_entryPath", str2);
        intent.putExtra("mini_envVersion", str3);
        intent.putExtra(PreloadingFragment.KEY_VIA, launchParam.via);
        intent.putExtra(PreloadingFragment.KEY_TIANSHU_AD_ID, launchParam.tianshuAdId);
        intent.putExtra(PreloadingFragment.KEY_SLOT_ID, launchParam.slotId);
        intent.putExtra("mini_launch_param", launchParam);
        if (!(context instanceof Activity)) {
            intent.addFlags(411041792);
        }
        if (miniAppLaunchListener != null) {
            intent.putExtra("mini_receiver", new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.4
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i3, Bundle bundle) {
                    super.onReceiveResult(i3, bundle);
                    miniAppLaunchListener.onLaunchResult(i3 == 0, bundle);
                }
            });
        }
        intent.putExtra(PreloadingFragment.KEY_START_TIME, System.currentTimeMillis());
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, PreloadingFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startAppByLink(final Context context, String str, int i3, LaunchParam launchParam, MiniAppLauncher.MiniAppLaunchListener miniAppLaunchListener) {
        QLog.i("MiniAppController", 1, "startAppByLink link:" + str + " linkType:" + i3 + "  param:" + launchParam);
        if (BaseActivity.sTopActivity != null) {
            QLog.d("MiniAppController", 1, "cur Activity:" + BaseActivity.sTopActivity.getActivityName() + "  class :" + BaseActivity.sTopActivity.getLocalClassName());
        }
        if (!NetworkUtil.isNetworkAvailable(context)) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(context, R.string.c4w, 0).show();
                }
            });
            return;
        }
        int checkIfCameraPreviewingOrAVConversationOrMiniAppForeground = checkIfCameraPreviewingOrAVConversationOrMiniAppForeground(context);
        if (isArkBattleUrl(str, launchParam) && checkIfCameraPreviewingOrAVConversationOrMiniAppForeground != 0) {
            QLog.e("MiniAppController", 1, "startAppByLink prohibit battle mini game open from ark, link:" + str + " check result " + checkIfCameraPreviewingOrAVConversationOrMiniAppForeground);
            MiniProgramLpReportDC04239.reportByQQ("ark", "ark_battle", "fail", String.valueOf(checkIfCameraPreviewingOrAVConversationOrMiniAppForeground), "", "", "");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.7
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(context, "\u53c2\u6570link\u4e3a\u7a7a", 0).show();
                }
            });
        } else {
            launchMiniAppByLink(context, str, i3, launchParam, miniAppLaunchListener);
        }
    }

    public void notifyResultListener(int i3, int i16, Intent intent) {
        QLog.d("MiniAppController", 1, "notifyResultListener requestCode:", Integer.valueOf(i3), " resultCode:", Integer.valueOf(i16));
        ArrayList<ActivityResultListener> arrayList = this.activityResultListenerList;
        if (arrayList != null && arrayList.size() != 0) {
            try {
                synchronized (this.activityResultListenerList) {
                    Iterator<ActivityResultListener> it = this.activityResultListenerList.iterator();
                    while (it.hasNext()) {
                        ActivityResultListener next = it.next();
                        if (next.doOnActivityResult(i3, i16, intent)) {
                            QLog.d("MiniAppController", 1, "triggerListener", next);
                            return;
                        }
                    }
                    return;
                }
            } catch (Throwable th5) {
                QLog.e("MiniAppController", 1, th5, new Object[0]);
                return;
            }
        }
        QLog.e("MiniAppController", 1, "activityResultListenerList == null || activityResultListenerList.size() == 0");
    }

    public void onDestory() {
        ArrayList<ActivityResultListener> arrayList = this.activityResultListenerList;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.activityResultListenerList.clear();
            }
        }
    }

    static {
        HashSet hashSet = new HashSet();
        MINI_PROGRAM_ACTIVITY_SET = hashSet;
        HashSet hashSet2 = new HashSet();
        MINI_GAME_ACTIVITY_SET = hashSet2;
        hashSet.addAll(Arrays.asList(AppBrandLaunchUI.class.getName(), AppBrandUI.class.getName(), AppBrandUI1.class.getName(), AppBrandUI2.class.getName(), AppBrandUI3.class.getName()));
        hashSet2.addAll(Arrays.asList(GameActivity1.class.getName(), GameActivity2.class.getName(), GameActivity3.class.getName(), GameActivity6.class.getName()));
        arkBattleScenes = Arrays.asList(2072, 4016, 4017);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startApp$0(long j3, Activity activity, MiniAppConfig miniAppConfig, ResultReceiver resultReceiver, boolean z16, boolean z17) {
        QLog.d("MiniAppController", 1, "startApp interceptLaunch isSuccess:", Boolean.valueOf(z16), ", duration=", Long.valueOf(System.currentTimeMillis() - j3));
        if (!z16) {
            startAppInner(activity, miniAppConfig, resultReceiver);
        } else {
            addVAToRecentPlay(miniAppConfig);
        }
    }

    private static void startAppInner(Activity activity, MiniAppConfig miniAppConfig, ResultReceiver resultReceiver) {
        if (miniAppConfig == null) {
            QLog.e("MiniAppController", 1, "startApp appConfig is empty!");
            return;
        }
        QLog.e("MiniAppController", 1, "startApp appConfig " + miniAppConfig.link);
        if (MiniGameVAUtil.needStopBackgroundGame(miniAppConfig.launchParam.scene, miniAppConfig.config.appId)) {
            MiniSDK.stopMiniApp(activity, MiniSdkLauncher.convert(miniAppConfig));
            miniAppConfig.launchParam.forceReload = 1;
            QLog.i("MiniAppController", 1, "startAppInner: stop background game.");
        }
        MiniAppInfo miniAppInfo = miniAppConfig.config;
        int i3 = 2;
        if (miniAppInfo != null && miniAppInfo.isAppTypeVirtualApp()) {
            ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).startVirtualApp(activity, getVirtualAppInfo(miniAppConfig), 2);
        } else {
            MiniAppInfo miniAppInfo2 = miniAppConfig.config;
            if (miniAppInfo2 != null && miniAppInfo2.isAppTypeYungGameApp()) {
                if (isInterceptStartYunGameMiniApp(miniAppConfig, activity)) {
                    QLog.e("MiniAppController", 1, "InterceptStartYunGameMiniApp!");
                    return;
                }
                Intent intent = new Intent();
                if (QLog.isColorLevel()) {
                    QLog.i("MiniAppController", 2, "startApp id:" + miniAppConfig.config.appId + " yungame: " + miniAppConfig.config.downloadUrl);
                }
                if (!TextUtils.isEmpty(miniAppConfig.config.downloadUrl)) {
                    intent.setData(Uri.parse(miniAppConfig.config.downloadUrl));
                    RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_JUMP);
                } else {
                    QLog.e("MiniAppController", 2, "start App yungame failed. downloadUrl is empty.");
                }
            } else {
                MiniAppInfo miniAppInfo3 = miniAppConfig.config;
                if (miniAppInfo3 != null && miniAppInfo3.isAppTypeEnterUri()) {
                    if (isInterceptStartYunGameMiniApp(miniAppConfig, activity)) {
                        QLog.e("MiniAppController", 1, "InterceptStartYunGameMiniApp!");
                        return;
                    }
                    if (!TextUtils.isEmpty(miniAppConfig.config.downloadUrl)) {
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).gotoSchemaUri(activity, miniAppConfig.config.downloadUrl);
                        if (miniAppConfig.config.getReportType() != 7) {
                            i3 = miniAppConfig.config.getReportType() == 8 ? 3 : 0;
                        }
                        MiniAppCmdUtil.getInstance().addRecentPlay(miniAppConfig.config.appId, i3, null);
                    } else {
                        QLog.e("MiniAppController", 1, "start uri game failed. downloadUrl is empty. type:" + miniAppConfig.config.getReportType());
                    }
                } else {
                    MiniAppMainServiceApiManager.INSTANCE.startMiniApp(activity, miniAppConfig, resultReceiver);
                }
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.sdk.MiniAppController.8
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.perf.process.foregroud.b.f257916a.i(MiniAppController.MINI_PROCESS_PRELOAD_ENTRY);
            }
        }, 16, null, true);
    }

    public void removeActivityResultListener(ActivityResultListener activityResultListener) {
        QLog.d("MiniAppController", 1, "removeActivityResultListener", activityResultListener);
        if (activityResultListener != null) {
            try {
                ArrayList<ActivityResultListener> arrayList = this.activityResultListenerList;
                if (arrayList == null) {
                    return;
                }
                arrayList.remove(activityResultListener);
            } catch (Throwable th5) {
                QLog.e("MiniAppController", 1, th5, new Object[0]);
            }
        }
    }

    public void setActivityResultListener(ActivityResultListener activityResultListener) {
        QLog.d("MiniAppController", 1, "setActivityResultListener", activityResultListener);
        if (activityResultListener == null) {
            return;
        }
        try {
            if (this.activityResultListenerList == null) {
                this.activityResultListenerList = new ArrayList<>();
            }
            this.activityResultListenerList.add(activityResultListener);
        } catch (Throwable th5) {
            QLog.e("MiniAppController", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void launchMiniAppByAppInfo(Activity activity, MiniAppInfo miniAppInfo, LaunchParam launchParam, String str, ResultReceiver resultReceiver) throws MiniAppException {
        if (launchParam == null) {
            launchParam = new LaunchParam();
        }
        if (launchParam.startupReportData == null) {
            MiniSdkLauncher.initSDK(activity != null ? activity.getApplicationContext() : null);
            launchParam.startupReportData = StartupReportUtil.reportBegin(miniAppInfo.appId, launchParam.scene, 0);
        }
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam = launchParam;
        launchParam.miniAppId = miniAppInfo.appId;
        miniAppConfig.link = str;
        if (TextUtils.isEmpty(launchParam.reportData)) {
            miniAppConfig.launchParam.reportData = miniAppInfo.reportData;
        } else if (!TextUtils.isEmpty(miniAppInfo.reportData)) {
            miniAppConfig.launchParam.reportData = miniAppConfig.launchParam.reportData + ContainerUtils.FIELD_DELIMITER + miniAppInfo.reportData;
        }
        LaunchParam launchParam2 = miniAppConfig.launchParam;
        if (launchParam2.scene == 1075) {
            launchParam2.shareTicket = launchParam2.navigateExtData;
        }
        if (miniAppInfo.isWxMiniApp()) {
            IWxMiniHostSceneManager iWxMiniHostSceneManager = (IWxMiniHostSceneManager) QRoute.api(IWxMiniHostSceneManager.class);
            int convertFromRefer = iWxMiniHostSceneManager.convertFromRefer(launchParam.scene);
            if (!TextUtils.isEmpty(str)) {
                convertFromRefer = iWxMiniHostSceneManager.formatHostScene(Uri.parse(str).getQueryParameter("host_scene"), convertFromRefer);
            }
            String str2 = launchParam.entryPath;
            FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
            if (firstPageInfo != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
                str2 = miniAppInfo.firstPage.pagePath;
            }
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(activity, miniAppInfo.appId, str2, convertFromRefer);
            return;
        }
        startApp(activity, miniAppConfig, resultReceiver);
    }
}
