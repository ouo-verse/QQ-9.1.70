package com.tencent.mobileqq.mini.launch;

import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.minigame.manager.EngineManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppCmdServlet {
    public static final String CMD_ADD_FAVORITES_TO_QQ = "cmd_add_qq_favorites";
    public static final String CMD_CHANGE_ARK_SHARE_URL = "cmd_change_ark_share_url";
    public static final String CMD_DC_REPORT_LOG_KEY_DATA = "cmd_dc_report_log_key_data";
    public static final String CMD_EXIT_QQ = "cmd_exit_qq";
    public static final String CMD_NOTIFY_EVENT_INFO = "cmd_notify_event_info";
    public static final String CMD_ON_PRELOAD_GAME_BASELIB = "cmd_on_preload_game_baselib";
    public static final String CMD_REBIND_ENGINE_CHANNEL = "cmd_rebind_engine_channel";
    public static final String CMD_REBIND_ENGINE_CHANNEL_NEW = "cmd_rebind_engine_channel_new";
    public static final String CMD_UPDATE_APP_FOR_MINI_GAME = "cmd_update_app_for_mini_game";
    public static final String CMD_UPDATE_BASELIB = "cmd_update_baselib";
    public static final String CMD_UPDATE_PULL_DOWN_ENTRY_LIST = "cmd_update_pull_down_entry_list";
    public static final String CMD_UPDATE_TRITON_ENGINE = "cmd_update_triton_engine";
    public static final String CMD_UPLOAD_ARK_SHARE_IMAGE = "cmd_upload_ark_share_image";
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_BUNDLE_APP_TYPE = "bundle_key_app_type";
    public static final String KEY_BUNDLE_PRELOAD_GAME_BASELIB_VERSION = "bundle_key_preload_game_baselib_version";
    public static final String KEY_BUNDLE_PROCESS_NAME = "bundle_key_process_name";
    public static final String KEY_EVENT = "key_event";
    public static final String KEY_SCENE = "key_scene";
    public static final String KEY_TIMESTAMP = "key_timestamp";
    public static final String KEY_URI = "key_uri";
    public static final String KEY_VIA = "key_via";
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

    private void notifyEventInfo(String str, Bundle bundle) {
        if (bundle != null) {
            MiniAppNotify.f246657g.notify(bundle.getString("key_appid", ""), bundle.getInt("key_scene", 9999), bundle.getString("key_via", ""), bundle.getString("key_event", ""), bundle.getLong("key_timestamp", 0L));
        }
    }

    public void onMiniAppCmd(final String str, Bundle bundle, final CmdCallback cmdCallback) {
        int i3;
        EngineChannel engineChannel;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i(TAG, 2, "sendCmd cmd=" + str);
        if ("cmd_exit_qq".equals(str)) {
            SystemMethodProxy.killProcess(Process.myPid());
            return;
        }
        if ("cmd_update_baselib".equals(str)) {
            if (bundle != null) {
                bundle.getString("version");
            }
            BaseLibManager.g().forceUpdateBaseLib(new BaseLibManager.UpdateListener() { // from class: com.tencent.mobileqq.mini.launch.MiniAppCmdServlet.1
                @Override // com.tencent.mobileqq.mini.apkg.BaseLibManager.UpdateListener
                public void onUpdateResult(int i16) {
                    CmdCallback cmdCallback2 = cmdCallback;
                    if (cmdCallback2 == null) {
                        return;
                    }
                    try {
                        if (i16 != 0 && i16 != 1) {
                            cmdCallback2.onCmdResult(false, new Bundle());
                        } else {
                            cmdCallback2.onCmdResult(true, new Bundle());
                        }
                    } catch (Exception e16) {
                        QLog.e(MiniAppCmdServlet.TAG, 1, "cmd response exception. cmd=" + str, e16);
                    }
                }
            });
            return;
        }
        if ("cmd_upload_ark_share_image".equals(str)) {
            if (bundle != null) {
                MiniArkShareAsyncManager.performUploadArkShareImage(bundle.getString(KEY_URI), new IMiniCallback() { // from class: com.tencent.mobileqq.mini.launch.MiniAppCmdServlet.2
                    @Override // com.tencent.mobileqq.mini.api.IMiniCallback
                    public void onCallbackResult(boolean z16, Bundle bundle2) {
                        try {
                            QLog.d(MiniAppCmdServlet.TAG, 1, "cmd response cmd=" + str + " succ:" + z16);
                            CmdCallback cmdCallback2 = cmdCallback;
                            if (cmdCallback2 != null) {
                                cmdCallback2.onCmdResult(z16, bundle2);
                            }
                        } catch (Throwable th5) {
                            QLog.e(MiniAppCmdServlet.TAG, 1, "cmd response exception. cmd=" + str, th5);
                        }
                    }
                });
                return;
            }
            QLog.e(TAG, 1, "onMiniAppCmd cmd = " + str + ", bundle is null");
            return;
        }
        if ("cmd_dc_report_log_key_data".equals(str)) {
            return;
        }
        if ("cmd_rebind_engine_channel".equals(str)) {
            i3 = bundle != null ? bundle.getInt("bundle_key_app_type", -1) : -1;
            QLog.i(TAG, 1, "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i3);
            if (i3 == 0 || i3 == 1) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("engineChannel", EngineManager.g().getChannelForType(i3 == 1 ? 2 : 3));
                if (cmdCallback != null) {
                    try {
                        cmdCallback.onCmdResult(true, bundle2);
                        return;
                    } catch (RemoteException e16) {
                        QLog.e(TAG, 1, "cmd response exception. cmd=" + str, e16);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if ("cmd_rebind_engine_channel_new".equals(str)) {
            i3 = bundle != null ? bundle.getInt("bundle_key_app_type", -1) : -1;
            QLog.i(TAG, 1, "[MiniEng] CMD_RELOAD_ENGINE_CHANNEL appType:" + i3);
            if (i3 == 0 || i3 == 1) {
                Bundle bundle3 = new Bundle();
                ICommonManager commonManager = AppLoaderFactory.g().getCommonManager();
                if (commonManager != null) {
                    engineChannel = commonManager.getChannelForType(i3 == 1 ? 2 : 3);
                } else {
                    engineChannel = null;
                }
                if (engineChannel != null) {
                    bundle3.putParcelable("engineChannel", engineChannel);
                }
                if (cmdCallback != null) {
                    try {
                        cmdCallback.onCmdResult(true, bundle3);
                        return;
                    } catch (RemoteException e17) {
                        QLog.e(TAG, 1, "cmd response exception. cmd=" + str, e17);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if ("cmd_update_pull_down_entry_list".equals(str)) {
            if (bundle != null) {
                MiniAppUtils.handlePullDownEntryListData(bundle, cmdCallback);
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.MiniAppCmdServlet.3
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniAppUtils.updateMiniAppList(6);
                    }
                }, 600L);
                return;
            }
            QLog.e(TAG, 1, "onMiniAppCmd cmd = " + str + ", bundle is null");
            return;
        }
        if ("cmd_update_app_for_mini_game".equals(str) || "cmd_update_triton_engine".equals(str)) {
            return;
        }
        if ("cmd_notify_event_info".equals(str)) {
            notifyEventInfo(str, bundle);
        } else if (CMD_CHANGE_ARK_SHARE_URL.equals(str)) {
            MiniArkShareAsyncManager.performChangeArkShareImageUrl(bundle.getString(KEY_URI), cmdCallback);
        }
    }
}
