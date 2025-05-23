package com.tencent.qqmini.miniapp.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EmbeddedHelper {
    public static final String EVENT_INSERT_LIVE_PLAYER = "insertLivePlayer";
    public static final String EVENT_INSERT_LIVE_PUSHER = "insertLivePusher";
    public static final String EVENT_INSERT_VIDEO_PLAYER = "insertVideoPlayer";
    public static final String SP_NAME = "update_embedded_status";
    public static final String TAG = "EmbeddedHelper";
    private static ArrayList<String> appIDWhiteList;
    private static final boolean enableEmbeddedLiveConfig;
    private static final boolean enableEmbeddedVideoConfiog;
    private static boolean enableUpdateForEmbeddedWidget;
    private static volatile Boolean isRunning = Boolean.FALSE;
    private static String mCurWhiteListConfig;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class RealCheckRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Activity> f346317d;

        /* renamed from: e, reason: collision with root package name */
        private final RequestEvent f346318e;

        /* renamed from: f, reason: collision with root package name */
        private final String f346319f;

        public RealCheckRunnable(Activity activity, RequestEvent requestEvent, String str) {
            this.f346317d = new WeakReference<>(activity);
            this.f346318e = requestEvent;
            this.f346319f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f346317d.get() != null) {
                EmbeddedHelper.doRealCheck(this.f346318e, this.f346319f, this.f346317d.get());
            }
        }
    }

    static {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_ENABLE_UPDATE_FOR_EMBEDDED_WIDGET, 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        enableUpdateForEmbeddedWidget = z16;
        if (WnsConfig.getConfig("qqminiapp", "enable_embedded_video", 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        enableEmbeddedVideoConfiog = z17;
        if (WnsConfig.getConfig("qqminiapp", "enable_embedded_live", 1) != 1) {
            z18 = false;
        }
        enableEmbeddedLiveConfig = z18;
        appIDWhiteList = null;
        mCurWhiteListConfig = null;
    }

    static /* synthetic */ SharedPreferences access$400() {
        return getSp();
    }

    public static void checkEmbeddedWidgetSupport(RequestEvent requestEvent, String str, Activity activity) {
        ThreadManager.getSubThreadHandler().post(new RealCheckRunnable(activity, requestEvent, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean doRealCheck(RequestEvent requestEvent, String str, final Activity activity) {
        getAppWhiteList();
        if (isIsRunning().booleanValue()) {
            QMLog.d(TAG, "checkEmbeddedWidgetSupport isRunning, return.");
            return false;
        }
        setIsRunning(Boolean.TRUE);
        if (requestEvent == null) {
            QMLog.d(TAG, "checkEmbeddedWidgetSupport req nll, return.");
            setIsRunning(Boolean.FALSE);
            return false;
        }
        if (activity != null && !activity.isFinishing()) {
            QMLog.d(TAG, "checkEmbeddedWidgetSupport event : " + requestEvent.event);
            if (!isEmbeddedWidgetApi(requestEvent)) {
                QMLog.d(TAG, "checkEmbeddedWidgetSupport isEmbeddedWidgetApi false, return.");
                setIsRunning(Boolean.FALSE);
                return false;
            }
            if (!enableUpdateForEmbeddedWidget) {
                QMLog.d(TAG, "checkEmbeddedWidgetSupport enableUpdateForEmbeddedWidget false, return.");
                setIsRunning(Boolean.FALSE);
                return false;
            }
            if (!appIDWhiteList.contains(str)) {
                QMLog.d(TAG, "checkEmbeddedWidgetSupport appIDWhiteList false, appid is : " + str + ", return.");
                setIsRunning(Boolean.FALSE);
                return false;
            }
            final String account = LoginManager.getInstance().getAccount();
            final String appVersion = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion();
            if (getSp().getInt(appVersion + account, 0) == 1) {
                QMLog.d(TAG, "checkEmbeddedWidgetSupport sp false, return.");
                setIsRunning(Boolean.FALSE);
                return false;
            }
            if (!enableEmbeddedVideoConfiog && !enableEmbeddedLiveConfig) {
                QMLog.d(TAG, "checkEmbeddedWidgetSupport widget false, return.");
                setIsRunning(Boolean.FALSE);
                return false;
            }
            int tbsVersion = QbSdk.getTbsVersion(activity);
            int tmpDirTbsVersion = QbSdk.getTmpDirTbsVersion(activity);
            QMLog.d(TAG, "tbsVersion : " + tbsVersion + "; tmpDirTbsVersion : " + tmpDirTbsVersion);
            if (tbsVersion <= 0 && tmpDirTbsVersion <= 0) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.util.EmbeddedHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EmbeddedHelper.showUpdateDialog(activity, appVersion, account);
                    }
                });
                setTbsListener(activity);
                return true;
            }
            QMLog.d(TAG, "checkEmbeddedWidgetSupport tbsVersion || tmpDirTbsVersion > 0, return.");
            setIsRunning(Boolean.FALSE);
            return false;
        }
        setIsRunning(Boolean.FALSE);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadSuccess(final Activity activity) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.util.EmbeddedHelper.5
            @Override // java.lang.Runnable
            public void run() {
                EmbeddedHelper.showRestartDialog(activity);
            }
        });
    }

    private static ArrayList<String> getAppWhiteList() {
        String config;
        if (appIDWhiteList == null && (config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_ENABLE_UPDATE_EMBEDDED_APP_LIST, WnsConfig.DEFAULT_ENABLE_UPDATE_EMBEDDED_APP_LIST)) != null && !config.equals(mCurWhiteListConfig)) {
            appIDWhiteList = new ArrayList<>();
            try {
                for (String str : config.split(";")) {
                    if (!TextUtils.isEmpty(str)) {
                        appIDWhiteList.add(str);
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            mCurWhiteListConfig = config;
        }
        return appIDWhiteList;
    }

    private static SharedPreferences getSp() {
        return AppLoaderFactory.g().getContext().getSharedPreferences(SP_NAME, 4);
    }

    private static boolean isEmbeddedWidgetApi(RequestEvent requestEvent) {
        if (!"insertVideoPlayer".equals(requestEvent.event) && !"insertLivePlayer".equals(requestEvent.event) && !"insertLivePusher".equals(requestEvent.event)) {
            return false;
        }
        return true;
    }

    public static Boolean isIsRunning() {
        return isRunning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportEmbeddedStatus(final int i3, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.util.EmbeddedHelper.8
            @Override // java.lang.Runnable
            public void run() {
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), i3, "0", str, null, null, null);
            }
        });
    }

    public static void setIsRunning(Boolean bool) {
        isRunning = bool;
    }

    private static void setTbsListener(final Activity activity) {
        QbSdk.setTbsListener(new TbsListener() { // from class: com.tencent.qqmini.miniapp.util.EmbeddedHelper.2
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i3) {
                QMLog.e(EmbeddedHelper.TAG, "onDownloadFinish " + i3);
                if (i3 == 177 || i3 == 110) {
                    EmbeddedHelper.downloadSuccess(activity);
                }
                EmbeddedHelper.reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_UPDATE_RESULT, "downloadFinish" + i3);
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i3) {
                QMLog.e(EmbeddedHelper.TAG, "onDownloadProgress : " + i3);
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i3) {
                QMLog.e(EmbeddedHelper.TAG, "onInstallFinish : " + i3);
                if (i3 == 220 || i3 == 232) {
                    EmbeddedHelper.downloadSuccess(activity);
                }
                EmbeddedHelper.reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_UPDATE_RESULT, "installFinish" + i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showRestartDialog(Activity activity) {
        DialogUtil.createCustomDialog(activity, 230, "\u5347\u7ea7\u6210\u529f", "\u5c0f\u7a0b\u5e8f\u5185\u6838\u5347\u7ea7\u5b8c\u6210\uff0c\u91cd\u542f\u624b\u673aQQ\u7acb\u5373\u751f\u6548", R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.util.EmbeddedHelper.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                try {
                    QMLog.e(EmbeddedHelper.TAG, "killProcess " + Process.myPid());
                    AppBrandCmdProxy.g().sendCmd("cmd_exit_qq", new Bundle(), null);
                    SystemMethodProxy.killProcess(Process.myPid());
                    dialogInterface.dismiss();
                    EmbeddedHelper.reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_UPDATE_RESULT, "killProcess");
                } catch (Throwable th5) {
                    QMLog.e(EmbeddedHelper.TAG, "onClick error ", th5);
                }
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.util.EmbeddedHelper.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
                EmbeddedHelper.reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_UPDATE_RESULT, "cancel kill");
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showUpdateDialog(final Activity activity, final String str, final String str2) {
        DialogUtil.createCustomDialog(activity, 230, "\u63d0\u793a", "\u5efa\u8bae\u60a8\u5347\u7ea7\u5c0f\u7a0b\u5e8f\u5185\u6838\u63d0\u5347\u89c6\u9891\uff0c\u76f4\u64ad\u7b49\u89c2\u770b\u4f53\u9a8c", R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.util.EmbeddedHelper.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                QMLog.e(EmbeddedHelper.TAG, "startDownload");
                EmbeddedHelper.access$400().edit().putInt(str + str2, 1).commit();
                TbsDownloader.startDownload(activity, true);
                dialogInterface.dismiss();
                EmbeddedHelper.setIsRunning(Boolean.FALSE);
                EmbeddedHelper.reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_UPDATE_RESULT, "download");
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.util.EmbeddedHelper.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                EmbeddedHelper.access$400().edit().putInt(str + str2, 1).commit();
                dialogInterface.dismiss();
                EmbeddedHelper.setIsRunning(Boolean.FALSE);
                EmbeddedHelper.reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_UPDATE_RESULT, "cancel download");
            }
        }).show();
    }
}
