package com.tencent.qqmini.minigame.manager;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.a;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class JsApiUpdateManager {
    private static final String KEY_APP_INFO = "key_app_info";
    private static final String TAG = "JsApiUpdateManager";
    private static MiniAppInfo newerMiniAppInfo;
    private static MiniAppInfo olderMiniAppInfo;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IUpdateListener {
        void onCheckResult(boolean z16);

        void onDownloadResult(boolean z16);
    }

    public static void checkForUpdate(final MiniAppInfo miniAppInfo, final IUpdateListener iUpdateListener) {
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            olderMiniAppInfo = miniAppInfo;
            QMLog.d(TAG, "checkUpdate() called with: oldMiniAppConfig = [" + miniAppInfo + "], callback = [" + iUpdateListener + "]");
            if (miniAppInfo.verType != 3) {
                QMLog.w(TAG, "checkForUpdate skip check for not online version");
                handleUpdateCheckResult(iUpdateListener, false);
                return;
            } else {
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoById(miniAppInfo.appId, "", "", new AsyncResult() { // from class: com.tencent.qqmini.minigame.manager.JsApiUpdateManager.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                        QMLog.d(JsApiUpdateManager.TAG, "onCmdListener() called with: isSuc = [" + z16 + "], ret = [" + jSONObject + "]");
                        if (jSONObject != null && z16) {
                            MiniAppInfo unused = JsApiUpdateManager.newerMiniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                            if (JsApiUpdateManager.newerMiniAppInfo != null) {
                                if (AppBrandUtil.needUpdate(MiniAppInfo.this, JsApiUpdateManager.newerMiniAppInfo)) {
                                    JsApiUpdateManager.handleUpdateCheckResult(iUpdateListener, true);
                                    JsApiUpdateManager.handleUpdateDownload(JsApiUpdateManager.newerMiniAppInfo, iUpdateListener);
                                    return;
                                } else {
                                    JsApiUpdateManager.handleUpdateCheckResult(iUpdateListener, false);
                                    return;
                                }
                            }
                            QMLog.e(JsApiUpdateManager.TAG, "onCmdListener newMiniAppInfo = null");
                            return;
                        }
                        QMLog.e(JsApiUpdateManager.TAG, "onCmdListener success = " + z16 + " ret = " + jSONObject);
                    }
                });
                return;
            }
        }
        QMLog.e(TAG, "checkUpdate() called with: oldMiniAppConfig = [" + miniAppInfo + "], callback = [" + iUpdateListener + "]");
    }

    public static void handleUpdateApp() {
        MiniAppInfo miniAppInfo;
        LaunchParam launchParam;
        LaunchParam launchParam2;
        QMLog.d(TAG, "handleUpdateApp() called");
        MiniAppInfo miniAppInfo2 = olderMiniAppInfo;
        if (miniAppInfo2 != null && (miniAppInfo = newerMiniAppInfo) != null && (launchParam = miniAppInfo2.launchParam) != null && (launchParam2 = miniAppInfo.launchParam) != null) {
            launchParam2.forceReload = 3;
            launchParam2.scene = launchParam.scene;
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_app_info", newerMiniAppInfo);
            AppBrandCmdProxy.g().sendCmd("cmd_update_app_for_mini_game", bundle, null);
            return;
        }
        QMLog.e(TAG, "handleUpdateApp olderMiniAppInfo = " + olderMiniAppInfo + " newerMiniAppInfo = " + newerMiniAppInfo);
    }

    public static void handleUpdateCheckResult(IUpdateListener iUpdateListener, boolean z16) {
        QMLog.d(TAG, "handleUpdateCheckResult hasUpdate:" + z16 + ", callback:" + iUpdateListener);
        if (iUpdateListener != null) {
            iUpdateListener.onCheckResult(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleUpdateDownload(MiniAppInfo miniAppInfo, final IUpdateListener iUpdateListener) {
        if (miniAppInfo != null) {
            QMLog.d(TAG, "handleUpdateDownload() called with: callback = [" + iUpdateListener + "], miniAppConfig = [" + miniAppInfo + "]");
            com.tencent.qqmini.sdk.manager.a.a(miniAppInfo, true, new a.b() { // from class: com.tencent.qqmini.minigame.manager.JsApiUpdateManager.2
                @Override // com.tencent.qqmini.sdk.manager.a.b
                public void onFail(@NonNull String str) {
                    QMLog.e(JsApiUpdateManager.TAG, "handleUpdateDownload: fail, errorMsg=" + str);
                    JsApiUpdateManager.handleUpdateDownloadResult(IUpdateListener.this, false);
                }

                @Override // com.tencent.qqmini.sdk.manager.a.b
                public void onSuccess() {
                    JsApiUpdateManager.handleUpdateDownloadResult(IUpdateListener.this, true);
                }

                @Override // com.tencent.qqmini.sdk.manager.a.b
                public void onProgress(float f16, long j3) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleUpdateDownloadResult(IUpdateListener iUpdateListener, boolean z16) {
        QMLog.d(TAG, "handleUpdateDownloadResult success:" + z16 + ", callback:" + iUpdateListener);
        if (iUpdateListener != null) {
            iUpdateListener.onDownloadResult(z16);
        }
    }
}
