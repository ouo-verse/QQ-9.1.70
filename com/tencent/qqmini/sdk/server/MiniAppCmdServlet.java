package com.tencent.qqmini.sdk.server;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMiniAppNotifyProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.manager.EngineManager;
import com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04902;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppCmdServlet {
    private static final String TAG = "MiniAppCmdServlet";
    private static MiniAppCmdServlet instance;
    private static byte[] lock = new byte[0];

    public static MiniAppCmdServlet g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MiniAppCmdServlet();
                }
            }
        }
        return instance;
    }

    private void launchReport(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
                MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable("app_config");
                String string = bundle.getString("sub_action");
                SDKMiniProgramLpReportDC04239.report(miniAppInfo, bundle.getString("app_type"), bundle.getString("path"), bundle.getString("action_type"), string, bundle.getString("reserves"), bundle.getString("reserves2"), null, null, null, null);
            } catch (Exception unused) {
            }
        }
    }

    private void launchReport2(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        if (bundle != null) {
            bundle.setClassLoader(MiniAppReportManager2.class.getClassLoader());
            MiniAppReportManager2.reportPageView(bundle.getString("sub_action"), bundle.getString("reserves"), bundle.getString("path"), (MiniAppInfo) bundle.getParcelable("app_config"));
            return;
        }
        QMLog.e(TAG, "onMiniAppCmd cmd = " + str + ", bundle is null");
    }

    private void notifyEventInfo(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        if (bundle != null) {
            ((IMiniAppNotifyProxy) ProxyManager.get(IMiniAppNotifyProxy.class)).report(bundle.getString("key_appid", ""), bundle.getInt("key_scene", 9999), bundle.getString("key_via", ""), bundle.getString("key_event", ""), bundle.getLong("key_timestamp", 0L));
        }
    }

    private void onUpdateV8rt(String str, Bundle bundle, final MiniCmdCallback miniCmdCallback) {
        String string;
        String scriptXPath;
        String str2;
        String str3;
        boolean z16 = false;
        if (bundle != null) {
            z16 = bundle.getBoolean(IPCConst.KEY_USE_SCRIPTX, false);
        }
        if (!z16) {
            QMLog.i(TAG, "Start download v8rt");
            String config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_V8RT_URL, WnsConfig.DEFAULT_MINI_APP_V8RT_URL);
            QMLog.i(TAG, "urlJson:" + config);
            if (TextUtils.isEmpty(config)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(config);
                if (QUAUtil.isAbi64()) {
                    str2 = "url64";
                } else {
                    str2 = "url";
                }
                string = jSONObject.getString(str2);
                if (QUAUtil.isAbi64()) {
                    str3 = "size64";
                } else {
                    str3 = "size";
                }
                int i3 = jSONObject.getInt(str3);
                if (!TextUtils.isEmpty(string) && i3 != 0) {
                    scriptXPath = MiniSDKConst.getMiniAppV8rtPath();
                } else {
                    QMLog.e(TAG, "url is" + string + "  size:" + i3);
                    return;
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "parse v8rt_url failed", e16);
                return;
            }
        } else {
            QMLog.i(TAG, "Start download scriptX");
            string = bundle.getString(IPCConst.KEY_SO_URL, "");
            if (TextUtils.isEmpty(string)) {
                QMLog.e(TAG, "onUpdateV8rt error, scriptX download url is null!!!");
                return;
            }
            scriptXPath = MiniSDKConst.getScriptXPath();
        }
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(string, null, scriptXPath, 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.sdk.server.MiniAppCmdServlet.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i16, String str4) {
                QMLog.e(MiniAppCmdServlet.TAG, "download v8rt failed: " + str4);
                MiniCmdCallback miniCmdCallback2 = miniCmdCallback;
                if (miniCmdCallback2 != null) {
                    try {
                        miniCmdCallback2.onCmdResult(false, null);
                    } catch (Exception e17) {
                        QMLog.e(MiniAppCmdServlet.TAG, "download v8rt failed,callback.onCmdResult exception ", e17);
                    }
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
                QMLog.i(MiniAppCmdServlet.TAG, "download v8rt succeed progress: " + f16 + " totalBytesWritten:" + j3 + "  totalBytesExpectedToWrite:" + j16);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i16, String str4, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                QMLog.e(MiniAppCmdServlet.TAG, "download v8rt succeed: " + str4 + " result:" + downloadResult);
                MiniCmdCallback miniCmdCallback2 = miniCmdCallback;
                if (miniCmdCallback2 != null) {
                    try {
                        miniCmdCallback2.onCmdResult(true, null);
                    } catch (Exception e17) {
                        QMLog.e(MiniAppCmdServlet.TAG, "download v8rt failed,callback.onCmdResult exception ", e17);
                    }
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int i16, Map<String, List<String>> map) {
            }
        });
    }

    private void rebindEngineChannel(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        int i3;
        int i16 = -1;
        if (bundle != null) {
            i16 = bundle.getInt("bundle_key_app_type", -1);
        }
        QMLog.i(TAG, "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i16);
        if (i16 == 0 || i16 == 1) {
            Bundle bundle2 = new Bundle();
            EngineManager g16 = EngineManager.g();
            if (i16 == 1) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            bundle2.putParcelable("engineChannel", g16.getChannelForType(i3));
            if (miniCmdCallback != null) {
                try {
                    miniCmdCallback.onCmdResult(true, bundle2);
                } catch (RemoteException e16) {
                    QMLog.e(TAG, "cmd response exception. cmd=" + str, e16);
                }
            }
        }
    }

    private void rebindEngineChannelNew(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        int i3;
        int i16 = -1;
        if (bundle != null) {
            i16 = bundle.getInt("bundle_key_app_type", -1);
        }
        QMLog.i(TAG, "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i16);
        if (i16 == 0 || i16 == 1) {
            Bundle bundle2 = new Bundle();
            EngineManager g16 = EngineManager.g();
            if (i16 == 1) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            bundle2.putParcelable("engineChannel", g16.getChannelForType(i3));
            if (miniCmdCallback != null) {
                try {
                    miniCmdCallback.onCmdResult(true, bundle2);
                } catch (RemoteException e16) {
                    QMLog.e(TAG, "cmd response exception. cmd=" + str, e16);
                }
            }
        }
    }

    private void recordDuration(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(SDKMiniProgramLpReportDC04239.class.getClassLoader());
                SDKMiniProgramLpReportDC04239.recordDuration((MiniAppInfo) bundle.getParcelable("app_config"), bundle.getLong("add_duration_ms"));
            } catch (Exception unused) {
            }
        }
    }

    private void updateAppForMiniGame(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        QMLog.d(TAG, "handleUpdateAppForMiniGame() called with: bundle = [" + bundle + "]");
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(getClass().getClassLoader());
        MiniAppInfo miniAppInfo = (MiniAppInfo) bundle.getParcelable(MiniAppCmdUtil.KEY_APP_INFO);
        if (miniAppInfo != null) {
            MiniServer.g().getLaunchManagerService().stopMiniApp(miniAppInfo);
            MiniAppLauncher.launchMiniApp((Activity) null, miniAppInfo, (Bundle) null, (ResultReceiver) null);
        } else {
            QMLog.e(TAG, "handleUpdateAppForMiniGame: failed, miniAppInfo = null");
        }
    }

    private void updateBaseLib(final String str, Bundle bundle, final MiniCmdCallback miniCmdCallback) {
        BaseLibManager.g().forceUpdateBaseLib(new BaseLibManager.UpdateListener() { // from class: com.tencent.qqmini.sdk.server.MiniAppCmdServlet.1
            @Override // com.tencent.qqmini.sdk.manager.BaseLibManager.UpdateListener
            public void onUpdateResult(int i3) {
                MiniCmdCallback miniCmdCallback2 = miniCmdCallback;
                if (miniCmdCallback2 == null) {
                    return;
                }
                try {
                    if (i3 != 0 && i3 != 1) {
                        miniCmdCallback2.onCmdResult(false, new Bundle());
                    } else {
                        miniCmdCallback2.onCmdResult(true, new Bundle());
                    }
                } catch (Exception e16) {
                    QMLog.e(MiniAppCmdServlet.TAG, "cmd response exception. cmd=" + str, e16);
                }
            }
        });
    }

    public void onMiniAppCmd(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("cmd_exit_qq".equals(str)) {
            QMLog.i(TAG, "CMD_EXIT_QQ pid=" + Process.myPid());
            ProcessUtil.killProcess(Process.myPid());
        } else if ("cmd_update_baselib".equals(str)) {
            updateBaseLib(str, bundle, miniCmdCallback);
        } else if ("cmd_upload_ark_share_image".equals(str)) {
            if (bundle == null) {
                QMLog.e(TAG, "onMiniAppCmd cmd = " + str + ", bundle is null");
            }
        } else if (IPCConst.CMD_SHARE_ARK_ASYNC_MESSAGE.equals(str)) {
            if (bundle == null) {
                QMLog.e(TAG, "onMiniAppCmd cmd = " + str + ", bundle is null");
            }
        } else if ("cmd_add_qq_favorites".equals(str)) {
            FavoritesJsPlugin.addFavoritesBundle(bundle, miniCmdCallback);
        } else if ("cmd_dc_report_log_key_data".equals(str)) {
            MiniProgramLpReportDC04902.reportToServer(bundle);
        } else if ("cmd_rebind_engine_channel".equals(str)) {
            rebindEngineChannel(str, bundle, miniCmdCallback);
        } else if ("cmd_rebind_engine_channel_new".equals(str)) {
            rebindEngineChannelNew(str, bundle, miniCmdCallback);
        } else if ("cmd_update_pull_down_entry_list".equals(str)) {
            if (bundle == null) {
                QMLog.e(TAG, "onMiniAppCmd cmd = " + str + ", bundle is null");
            }
        } else if ("launch_report".equals(str)) {
            launchReport(str, bundle, miniCmdCallback);
        } else if ("launch_report2".equals(str)) {
            launchReport2(str, bundle, miniCmdCallback);
        } else if ("record_duration".equals(str)) {
            recordDuration(str, bundle, miniCmdCallback);
        } else if ("cmd_update_app_for_mini_game".equals(str)) {
            updateAppForMiniGame(str, bundle, miniCmdCallback);
        } else if ("cmd_notify_event_info".equals(str)) {
            notifyEventInfo(str, bundle, miniCmdCallback);
        } else if (IPCConst.CMD_UPDATE_V8RT.equals(str)) {
            onUpdateV8rt(str, bundle, miniCmdCallback);
        }
        CmdProxy cmdProxy = (CmdProxy) ProxyManager.get(CmdProxy.class);
        if (cmdProxy != null) {
            cmdProxy.handleMiniAppCmd(str, bundle, miniCmdCallback);
        }
    }
}
