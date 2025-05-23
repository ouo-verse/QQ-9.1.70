package com.tencent.qq.minibox.api.metadream.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.DownloadScene;
import com.tencent.mobileqq.minigame.va.ui.MiniBoxVADownloadTipsDelegate;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi;
import com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate;
import com.tencent.qq.minibox.api.metadream.impl.MiniBoxUseMiniGameAbilityApiImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J7\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022%\u0010\t\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004H\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u00a6\u0001\u0010\u0019\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0091\u0001\u0010\u0018\u001a\u008c\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000bH\u0016JG\u0010&\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004H\u0016\u00a8\u0006+"}, d2 = {"Lcom/tencent/qq/minibox/api/metadream/impl/MiniBoxUseMiniGameAbilityApiImpl;", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxUseMiniGameAbilityApi;", "", "appId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", VirtualAppProxy.KEY_GAME_ID, "", "callback", "queryCanUpdateVA", "", "needInstall", NotificationCompat.GROUP_KEY_SILENT, "startDownload", "stopUpdate", "Lkotlin/Function6;", "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "progress", "", "downloadSize", VirtualAppProxy.KEY_PKG_SIZE, "msg", "listener", "addDownloadListener", "removeDownloadListener", "Landroid/content/Context;", "hostContext", "Landroid/app/Activity;", "gameActivity", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate;", "getMiniBoxVADownloadTipsDelegate", PushClientConstants.TAG_PKG_NAME, "allowWifiAutoUpdate", "updateWifiAutoUpdateFlag", "versionCode", "success", "restartVirtualApp", "<init>", "()V", "Companion", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniBoxUseMiniGameAbilityApiImpl implements IMiniBoxUseMiniGameAbilityApi {
    private static final String TAG = "MiniBoxUseMiniGameAbilityApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addDownloadListener$lambda$10(String str, final Function6 function6) {
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        bundle.putParcelable("receiver", new ResultReceiver() { // from class: com.tencent.qq.minibox.api.metadream.impl.MiniBoxUseMiniGameAbilityApiImpl$addDownloadListener$runnable$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(null);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                String string = resultData != null ? resultData.getString(VirtualAppProxy.KEY_GAME_ID, null) : null;
                int i3 = resultData != null ? resultData.getInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 0) : 0;
                int i16 = resultData != null ? resultData.getInt("progress", 0) : 0;
                long j3 = resultData != null ? resultData.getLong(VirtualAppProxy.KEY_PKG_SIZE, 0L) : 0L;
                long j16 = resultData != null ? resultData.getLong("downloadSize", 0L) : 0L;
                String string2 = resultData != null ? resultData.getString(VirtualAppProxy.KEY_GAME_VERSION_CODE, null) : null;
                Function6<String, Integer, Integer, Long, Long, String, Unit> function62 = function6;
                if (function62 != null) {
                    function62.invoke(string, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), string2);
                }
            }
        });
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_ADD_DOWNLOAD_LISTENER, bundle, new EIPCResultCallback() { // from class: ds3.c
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniBoxUseMiniGameAbilityApiImpl.addDownloadListener$lambda$10$lambda$9(eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addDownloadListener$lambda$10$lambda$9(EIPCResult eIPCResult) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addDownloadListener onCallback " + eIPCResult.code + ", " + eIPCResult.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryCanUpdateVA$lambda$2(String appId, final Function1 function1) {
        Intrinsics.checkNotNullParameter(appId, "$appId");
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString("appId", appId);
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_QUERY_CAN_UPDATE_VA, bundle, new EIPCResultCallback() { // from class: ds3.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniBoxUseMiniGameAbilityApiImpl.queryCanUpdateVA$lambda$2$lambda$1(Function1.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryCanUpdateVA$lambda$2$lambda$1(Function1 function1, EIPCResult eIPCResult) {
        Bundle bundle;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "queryCanUpdateVA onCallback " + eIPCResult.code + ", " + (eIPCResult.data == null));
        }
        if (!eIPCResult.isSuccess() || (bundle = eIPCResult.data) == null) {
            if (function1 != null) {
                function1.invoke(null);
            }
        } else if (function1 != null) {
            function1.invoke(bundle.getString(VirtualAppProxy.KEY_GAME_ID));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeDownloadListener$lambda$13(String str) {
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_REMOVE_DOWNLOAD_LISTENER, bundle, new EIPCResultCallback() { // from class: ds3.h
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniBoxUseMiniGameAbilityApiImpl.removeDownloadListener$lambda$13$lambda$12(eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeDownloadListener$lambda$13$lambda$12(EIPCResult eIPCResult) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeDownloadListener onCallback " + eIPCResult.code + ", " + eIPCResult.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restartVirtualApp$lambda$16(Bundle bundle, final String gameId, final Function1 function1) {
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        Intrinsics.checkNotNullParameter(gameId, "$gameId");
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_RESTART_AND_INSTALL_VA, bundle, new EIPCResultCallback() { // from class: ds3.i
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniBoxUseMiniGameAbilityApiImpl.restartVirtualApp$lambda$16$lambda$15(gameId, function1, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restartVirtualApp$lambda$16$lambda$15(String gameId, Function1 function1, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(gameId, "$gameId");
        QLog.i(TAG, 1, "restartVirtualApp gameId:" + gameId + ", result code:" + eIPCResult.code);
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(eIPCResult.code >= 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDownload$lambda$5(String gameId, boolean z16) {
        Intrinsics.checkNotNullParameter(gameId, "$gameId");
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, gameId);
        bundle.putBoolean("download_need_install", z16);
        bundle.putInt(VirtualAppProxy.KEY_DOWNLOAD_SCENE, DownloadScene.SCENE_INSTALL_IN_VA.getScene());
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_START_DOWNLOAD, bundle, new EIPCResultCallback() { // from class: ds3.e
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                MiniBoxUseMiniGameAbilityApiImpl.startDownload$lambda$5$lambda$4(eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startDownload$lambda$5$lambda$4(EIPCResult eIPCResult) {
        QLog.d(TAG, 1, "startDownload onCallback " + eIPCResult.code + ", " + (eIPCResult.data == null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopUpdate$lambda$7(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_STOP_DOWNLOAD, bundle, new EIPCResultCallback() { // from class: ds3.l
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QLog.i(MiniBoxUseMiniGameAbilityApiImpl.TAG, 1, "stopUpdate onCallback");
            }
        });
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi
    public void addDownloadListener(final String gameId, final Function6<? super String, ? super Integer, ? super Integer, ? super Long, ? super Long, ? super String, Unit> listener) {
        ThreadManagerV2.excute(new Runnable() { // from class: ds3.k
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxUseMiniGameAbilityApiImpl.addDownloadListener$lambda$10(gameId, listener);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi
    public IMiniBoxVADownloadTipsDelegate getMiniBoxVADownloadTipsDelegate(Context hostContext, Activity gameActivity) {
        Intrinsics.checkNotNullParameter(hostContext, "hostContext");
        Intrinsics.checkNotNullParameter(gameActivity, "gameActivity");
        try {
            return new MiniBoxVADownloadTipsDelegate(hostContext, gameActivity);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getMiniBoxVADownloadTipsDelegate throw:", th5);
            return null;
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi
    public void queryCanUpdateVA(final String appId, final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        ThreadManagerV2.excute(new Runnable() { // from class: ds3.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxUseMiniGameAbilityApiImpl.queryCanUpdateVA$lambda$2(appId, callback);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi
    public void removeDownloadListener(final String gameId) {
        ThreadManagerV2.excute(new Runnable() { // from class: ds3.f
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxUseMiniGameAbilityApiImpl.removeDownloadListener$lambda$13(gameId);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi
    public void restartVirtualApp(String appId, final String gameId, String versionCode, final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        final Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, gameId);
        bundle.putString("appId", appId);
        bundle.putString(VirtualAppProxy.KEY_GAME_VERSION_CODE, versionCode);
        ThreadManagerV2.excute(new Runnable() { // from class: ds3.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxUseMiniGameAbilityApiImpl.restartVirtualApp$lambda$16(bundle, gameId, listener);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi
    public void startDownload(final String gameId, final boolean needInstall, boolean silent) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        ThreadManagerV2.excute(new Runnable() { // from class: ds3.j
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxUseMiniGameAbilityApiImpl.startDownload$lambda$5(gameId, needInstall);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi
    public void stopUpdate(String gameId) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        final Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, gameId);
        ThreadManagerV2.excute(new Runnable() { // from class: ds3.m
            @Override // java.lang.Runnable
            public final void run() {
                MiniBoxUseMiniGameAbilityApiImpl.stopUpdate$lambda$7(bundle);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi
    public void updateWifiAutoUpdateFlag(String pkgName, boolean allowWifiAutoUpdate) {
        Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> interceptConfigMap;
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        QLog.i(TAG, 2, "updateWifiAutoUpdateFlag pkgName:" + pkgName + " allowWifiAutoUpdate:" + allowWifiAutoUpdate);
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        String str = null;
        if (miniGameVAInterceptConfig != null && (interceptConfigMap = miniGameVAInterceptConfig.getInterceptConfigMap()) != null) {
            for (Map.Entry<String, MiniGameVAInterceptConfig.VAInterceptConfig> entry : interceptConfigMap.entrySet()) {
                if (TextUtils.equals(pkgName, entry.getValue().getGameAppPkgName())) {
                    str = entry.getKey();
                }
            }
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            QLog.e(TAG, 1, "updateWifiAutoUpdateFlag appId invalid, pkgName:" + pkgName);
            return;
        }
        String str3 = str;
        QLog.i(TAG, 2, "updateWifiAutoUpdateFlag pkgName:" + pkgName + " allowWifiAutoUpdate:" + allowWifiAutoUpdate + " localFlag:" + MiniGameVAUtil.getWifiAutoUpgradeVAFlag(str3));
        MiniGameVAUtil.updateWifiAutoUpgradeVAFlag$default(str3, allowWifiAutoUpdate, false, false, 8, null);
    }
}
