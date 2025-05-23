package com.tencent.mobileqq.minigame.va.download;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.HotfixDownloadState;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.IHotfixloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J0\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\"\u0010\u0016\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001c\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u001d\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/minigame/va/download/MiniGameVAHotfixDownloadDelegate;", "", "()V", "handler", "Landroid/os/Handler;", "hotfixDownloadListeners", "", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/IHotfixloadListener;", "timeoutCallback", "Ljava/lang/Runnable;", "addTimeoutObserver", "", "notifyHotfixDownloadChange", VirtualAppProxy.KEY_GAME_ID, "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "progress", "totalSize", "", "code", "pauseDownload", "registerHotfixDownloadCallback", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "callback", "removeTimeoutObserver", "startDownload", "stopDownload", "unregisterHotfixDownloadCallback", "Companion", "SingletonHolder", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAHotfixDownloadDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MiniGameVAHotfixDownloadDelegate";
    private Handler handler;
    private List<IHotfixloadListener> hotfixDownloadListeners = new ArrayList();
    private final Runnable timeoutCallback = new Runnable() { // from class: com.tencent.mobileqq.minigame.va.download.c
        @Override // java.lang.Runnable
        public final void run() {
            MiniGameVAHotfixDownloadDelegate.timeoutCallback$lambda$2(MiniGameVAHotfixDownloadDelegate.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/download/MiniGameVAHotfixDownloadDelegate$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/tencent/mobileqq/minigame/va/download/MiniGameVAHotfixDownloadDelegate;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MiniGameVAHotfixDownloadDelegate getInstance() {
            return SingletonHolder.INSTANCE.getINSTANCE();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\b\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/download/MiniGameVAHotfixDownloadDelegate$SingletonHolder;", "", "()V", "INSTANCE", "Lcom/tencent/mobileqq/minigame/va/download/MiniGameVAHotfixDownloadDelegate;", "getINSTANCE", "()Lcom/tencent/mobileqq/minigame/va/download/MiniGameVAHotfixDownloadDelegate;", "setINSTANCE", "(Lcom/tencent/mobileqq/minigame/va/download/MiniGameVAHotfixDownloadDelegate;)V", "INSTANCE$1", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();

        /* renamed from: INSTANCE$1, reason: from kotlin metadata */
        private static MiniGameVAHotfixDownloadDelegate INSTANCE = new MiniGameVAHotfixDownloadDelegate();

        SingletonHolder() {
        }

        public final MiniGameVAHotfixDownloadDelegate getINSTANCE() {
            return INSTANCE;
        }

        public final void setINSTANCE(MiniGameVAHotfixDownloadDelegate miniGameVAHotfixDownloadDelegate) {
            Intrinsics.checkNotNullParameter(miniGameVAHotfixDownloadDelegate, "<set-?>");
            INSTANCE = miniGameVAHotfixDownloadDelegate;
        }
    }

    private final void addTimeoutObserver() {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null) {
            long hotfixTimeout = miniGameVAInterceptConfig.getHotfixTimeout();
            if (hotfixTimeout > 0) {
                if (this.handler == null) {
                    this.handler = new Handler(ThreadManagerV2.getSubThreadLooper());
                }
                Handler handler = this.handler;
                if (handler != null) {
                    handler.removeCallbacks(this.timeoutCallback);
                }
                Handler handler2 = this.handler;
                if (handler2 != null) {
                    handler2.postDelayed(this.timeoutCallback, hotfixTimeout);
                }
                QLog.i(TAG, 2, "addTimeoutObserver");
            }
        }
    }

    @JvmStatic
    public static final MiniGameVAHotfixDownloadDelegate getInstance() {
        return INSTANCE.getInstance();
    }

    private final void removeTimeoutObserver() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.timeoutCallback);
        }
        this.handler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void timeoutCallback$lambda$2(MiniGameVAHotfixDownloadDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 2, "hot fix timeout");
        HotfixDownloadState hotfixDownloadState = new HotfixDownloadState();
        hotfixDownloadState.setStatus(3);
        hotfixDownloadState.setProgess(100);
        synchronized (this$0) {
            Iterator<T> it = this$0.hotfixDownloadListeners.iterator();
            while (it.hasNext()) {
                ((IHotfixloadListener) it.next()).onDownloadStatusChange(hotfixDownloadState);
            }
            this$0.hotfixDownloadListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void notifyHotfixDownloadChange(String gameId, int downloadStatus, int progress, long totalSize, int code) {
        QLog.d(TAG, 4, "notifyHotfixDownloadChange downloadStatus:" + downloadStatus + ", progress:" + progress + ", totalSize:" + totalSize + ", code:" + code);
        removeTimeoutObserver();
        HotfixDownloadState hotfixDownloadState = new HotfixDownloadState();
        hotfixDownloadState.setStatus(downloadStatus);
        hotfixDownloadState.setProgess(progress);
        hotfixDownloadState.setTotalSize(totalSize);
        hotfixDownloadState.setErrorCode(code);
        synchronized (this) {
            Iterator<T> it = this.hotfixDownloadListeners.iterator();
            while (it.hasNext()) {
                ((IHotfixloadListener) it.next()).onDownloadStatusChange(hotfixDownloadState);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void pauseDownload(String gameId) {
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, gameId);
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_LETS_GO_RES_PAUSE_DOWNLOAD, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.va.download.e
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QLog.i(MiniGameVAHotfixDownloadDelegate.TAG, 2, "pauseDownload callback");
            }
        });
        removeTimeoutObserver();
    }

    public final void registerHotfixDownloadCallback(String gameId, MiniAppInfo miniAppInfo, IHotfixloadListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this) {
            this.hotfixDownloadListeners.add(callback);
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        bundle.putParcelable("mini_app_info", miniAppInfo);
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, gameId);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_LETS_GO_RES_REGISTER_CALLBACK, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.va.download.g
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QLog.i(MiniGameVAHotfixDownloadDelegate.TAG, 2, "registerHotfixDownloadCallback callback");
            }
        });
    }

    public final void startDownload(String gameId) {
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, gameId);
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_LETS_GO_RES_START_DOWNLOAD, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.va.download.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QLog.i(MiniGameVAHotfixDownloadDelegate.TAG, 2, "startDownload callback");
            }
        });
        addTimeoutObserver();
    }

    public final void stopDownload(String gameId) {
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, gameId);
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_LETS_GO_RES_STOP_DOWNLOAD, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.va.download.f
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QLog.i(MiniGameVAHotfixDownloadDelegate.TAG, 2, "stopDownload callback");
            }
        });
        removeTimeoutObserver();
    }

    public final void unregisterHotfixDownloadCallback(String gameId, IHotfixloadListener callback) {
        synchronized (this) {
            TypeIntrinsics.asMutableCollection(this.hotfixDownloadListeners).remove(callback);
        }
        QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, gameId);
        Unit unit = Unit.INSTANCE;
        qIPCClientHelper.callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_LETS_GO_RES_UNREGISTER_CALLBACK, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.minigame.va.download.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QLog.i(MiniGameVAHotfixDownloadDelegate.TAG, 2, "unregisterHotfixDownloadCallback callback");
            }
        });
    }
}
