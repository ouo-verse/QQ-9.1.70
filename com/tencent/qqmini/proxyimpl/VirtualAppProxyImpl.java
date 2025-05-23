package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.config.MiniGameVACustomConfig;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.danmaku.MiniGameDanmakuRequest;
import com.tencent.mobileqq.minigame.va.DownloadScene;
import com.tencent.mobileqq.minigame.va.download.MiniGameVAHotfixDownloadDelegate;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.IDanmakuLoadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.IHotfixloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.OnVADownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.ProxyCallback;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VACustomTextConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VADownloadState;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;

@ProxyService(proxy = VirtualAppProxy.class)
/* loaded from: classes34.dex */
public class VirtualAppProxyImpl extends VirtualAppProxy {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<OnVADownloadListener>> f347631a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl$2, reason: invalid class name */
    /* loaded from: classes34.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f347641d;

        AnonymousClass2(Bundle bundle) {
            this.f347641d = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_START_DOWNLOAD, this.f347641d, new EIPCResultCallback() { // from class: com.tencent.qqmini.proxyimpl.ca
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    QLog.i("VirtualAppProxyImpl", 1, "startDownload onCallback");
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void addDownloadListener(final String str, MiniAppInfo miniAppInfo, OnVADownloadListener onVADownloadListener) {
        super.addDownloadListener(str, miniAppInfo, onVADownloadListener);
        QLog.i("VirtualAppProxyImpl", 1, "addDownloadListener gameId:" + str + " processId:" + MobileQQ.sProcessId);
        if (TextUtils.isEmpty(str)) {
            QLog.e("VirtualAppProxyImpl", 1, "addDownloadListener gameId is empty");
            return;
        }
        List<OnVADownloadListener> list = this.f347631a.get(str);
        synchronized (this) {
            if (list == null) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(onVADownloadListener);
                this.f347631a.put(str, copyOnWriteArrayList);
            } else if (!list.contains(onVADownloadListener)) {
                list.add(onVADownloadListener);
            }
        }
        final Bundle bundle = new Bundle();
        bundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        bundle.putParcelable("mini_app_info", miniAppInfo);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.6

            /* renamed from: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl$6$a */
            /* loaded from: classes34.dex */
            class a implements EIPCResultCallback {
                a() {
                }

                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VirtualAppProxyImpl", 2, "addDownloadListener onCallback gameId:" + str);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_ADD_DOWNLOAD_LISTENER, bundle, new a());
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void cancelDownload(String str, ProxyCallback proxyCallback) {
        super.cancelDownload(str, proxyCallback);
        QLog.i("VirtualAppProxyImpl", 1, "cancelDownload gameId:" + str + " processId:" + MobileQQ.sProcessId);
        final Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.4

            /* renamed from: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl$4$a */
            /* loaded from: classes34.dex */
            class a implements EIPCResultCallback {
                a() {
                }

                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    QLog.i("VirtualAppProxyImpl", 1, "cancelDownload onCallback");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_CANCEL_DOWNLOAD, bundle, new a());
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void getDanmakuList(String str, final IDanmakuLoadListener iDanmakuLoadListener) {
        final MiniGameDanmakuRequest miniGameDanmakuRequest = new MiniGameDanmakuRequest();
        miniGameDanmakuRequest.setListener(new Function2() { // from class: com.tencent.qqmini.proxyimpl.bz
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit b16;
                b16 = VirtualAppProxyImpl.b(IDanmakuLoadListener.this, miniGameDanmakuRequest, (Boolean) obj, (List) obj2);
                return b16;
            }
        });
        miniGameDanmakuRequest.getDanmaku();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public boolean getDualChannelDownloadSwitch() {
        boolean isKingCard = ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard();
        QLog.i("VirtualAppProxyImpl", 1, "getDualChannelDownloadSwitch isKingCard:" + isKingCard);
        return isKingCard || MiniGameVAUtil.getUseWifiAndXGSwitch();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public VACustomTextConfig getVACustomTextConfig() {
        MiniGameVACustomConfig miniGameVACustomConfig = (MiniGameVACustomConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVACustomConfig.CONFIG_ID);
        if (miniGameVACustomConfig == null) {
            return new VACustomTextConfig();
        }
        return miniGameVACustomConfig.getCustomTextConfig();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void notifyHotfixDownloadChange(String str, int i3, int i16, long j3, int i17) {
        MiniGameVAHotfixDownloadDelegate.getInstance().notifyHotfixDownloadChange(str, i3, i16, j3, i17);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void pauseHotfixDownload(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.10
            @Override // java.lang.Runnable
            public void run() {
                MiniGameVAHotfixDownloadDelegate.getInstance().pauseDownload(str);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public boolean queryDownloadIgnoreGameEvent(String str) {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        return miniGameVAInterceptConfig != null && miniGameVAInterceptConfig.getCheckVADownloadIgnoreGameEvent();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void queryDownloadState(final String str, final ProxyCallback proxyCallback) {
        super.queryDownloadState(str, proxyCallback);
        QLog.i("VirtualAppProxyImpl", 1, "queryDownloadState appId:" + str + " processId:" + MobileQQ.sProcessId);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.1
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("appId", str);
                if (QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_QUERY_CRASH_BLOCK, bundle).code == 1) {
                    QLog.i("VirtualAppProxyImpl", 1, "queryDownloadState crash block");
                    proxyCallback.onResult(str, null);
                } else {
                    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_QUERY_DOWNLOAD_STATE, bundle, new a());
                }
            }

            /* renamed from: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl$1$a */
            /* loaded from: classes34.dex */
            class a implements EIPCResultCallback {
                a() {
                }

                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    Bundle bundle;
                    if (eIPCResult != null && (bundle = eIPCResult.data) != null) {
                        String string = bundle.getString(VirtualAppProxy.KEY_GAME_ID);
                        if (TextUtils.isEmpty(string)) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            proxyCallback.onResult(str, null);
                            return;
                        }
                        VADownloadState vADownloadState = new VADownloadState();
                        vADownloadState.autoDownload = eIPCResult.data.getInt(VirtualAppProxy.KEY_AUTO_DOWNLOAD);
                        vADownloadState.downloadTypeOnWifi = eIPCResult.data.getInt(VirtualAppProxy.KEY_DOWNLOAD_TYPE_ON_WIFI);
                        vADownloadState.downloadStatus = eIPCResult.data.getInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS);
                        vADownloadState.progress = eIPCResult.data.getInt("progress");
                        vADownloadState.pkgSize = eIPCResult.data.getLong(VirtualAppProxy.KEY_PKG_SIZE);
                        vADownloadState.downloadSize = eIPCResult.data.getLong("downloadSize");
                        vADownloadState.gameId = string;
                        vADownloadState.gameVersionCode = eIPCResult.data.getString(VirtualAppProxy.KEY_GAME_VERSION_CODE);
                        vADownloadState.downloadScene = eIPCResult.data.getInt(VirtualAppProxy.KEY_DOWNLOAD_SCENE);
                        QLog.i("VirtualAppProxyImpl", 1, "queryDownloadState onCallback downloadState:" + vADownloadState);
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        proxyCallback.onResult(str, vADownloadState);
                        return;
                    }
                    QLog.i("VirtualAppProxyImpl", 1, "queryDownloadState onCallback result is null");
                    AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                    proxyCallback.onResult(str, null);
                }
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void recordWifiAutoDownloadVAFlag(String str) {
        MiniGameVAUtil.recordWifiAutoDownloadVAFlag(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void registerHotfixDownloadCallback(final String str, final MiniAppInfo miniAppInfo, final IHotfixloadListener iHotfixloadListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.11
            @Override // java.lang.Runnable
            public void run() {
                MiniGameVAHotfixDownloadDelegate.getInstance().registerHotfixDownloadCallback(str, miniAppInfo, iHotfixloadListener);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void removeDownloadListener(String str, OnVADownloadListener onVADownloadListener) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("VirtualAppProxyImpl", 1, "removeDownloadListener gameId is empty");
            return;
        }
        super.removeDownloadListener(str, onVADownloadListener);
        QLog.i("VirtualAppProxyImpl", 1, "removeDownloadListener gameId:" + str + " processId:" + MobileQQ.sProcessId);
        List<OnVADownloadListener> list = this.f347631a.get(str);
        synchronized (this) {
            if (list != null) {
                list.remove(onVADownloadListener);
                if (list.isEmpty()) {
                    this.f347631a.remove(str);
                }
            }
        }
        final Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.7

            /* renamed from: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl$7$a */
            /* loaded from: classes34.dex */
            class a implements EIPCResultCallback {
                a() {
                }

                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    QLog.i("VirtualAppProxyImpl", 1, "removeDownloadListener onCallback");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_REMOVE_DOWNLOAD_LISTENER, bundle, new a());
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void restartVirtualApp(final String str, final String str2, final ProxyCallback proxyCallback) {
        super.restartVirtualApp(str, str2, proxyCallback);
        QLog.i("VirtualAppProxyImpl", 1, "restartVirtualApp gameId:" + str2 + " processId:" + MobileQQ.sProcessId);
        final Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str2);
        bundle.putString("appId", str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.5

            /* renamed from: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl$5$a */
            /* loaded from: classes34.dex */
            class a implements EIPCResultCallback {
                a() {
                }

                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    QLog.i("VirtualAppProxyImpl", 1, "restartVirtualApp gameId:" + str2 + ", result code:" + eIPCResult.code);
                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                    ProxyCallback proxyCallback = proxyCallback;
                    if (proxyCallback != null) {
                        proxyCallback.onResult(str, Boolean.valueOf(eIPCResult.code >= 0));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_RESTART_DOWNLOAD, bundle, new a());
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void startDownload(String str, ProxyCallback proxyCallback) {
        startDownload(str, true, proxyCallback);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void startHotfixDownload(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.8
            @Override // java.lang.Runnable
            public void run() {
                MiniGameVAHotfixDownloadDelegate.getInstance().startDownload(str);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void stopDownload(String str, ProxyCallback proxyCallback) {
        super.stopDownload(str, proxyCallback);
        QLog.i("VirtualAppProxyImpl", 1, "stopDownload gameId:" + str + " processId:" + MobileQQ.sProcessId);
        final Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.3

            /* renamed from: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl$3$a */
            /* loaded from: classes34.dex */
            class a implements EIPCResultCallback {
                a() {
                }

                @Override // eipc.EIPCResultCallback
                public void onCallback(EIPCResult eIPCResult) {
                    QLog.i("VirtualAppProxyImpl", 1, "stopDownload onCallback");
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_VA_STOP_DOWNLOAD, bundle, new a());
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void stopHotfixDownload(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.9
            @Override // java.lang.Runnable
            public void run() {
                MiniGameVAHotfixDownloadDelegate.getInstance().stopDownload(str);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void unregisterHotfixDownloadCallback(final String str, final IHotfixloadListener iHotfixloadListener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.VirtualAppProxyImpl.12
            @Override // java.lang.Runnable
            public void run() {
                MiniGameVAHotfixDownloadDelegate.getInstance().unregisterHotfixDownloadCallback(str, iHotfixloadListener);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void updateDualChannelDownloadSwitch(boolean z16) {
        QLog.i("VirtualAppProxyImpl", 1, "updateDualChannelDownloadSwitch:" + z16);
        MiniGameVAUtil.setUseWifiAndXGSwitch(z16);
        QLog.i("VirtualAppProxyImpl", 4, "updateDualChannelDownloadSwitch get:" + MiniGameVAUtil.getUseWifiAndXGSwitch());
        ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).setDualSwitch(z16 ? 1 : 0, 27);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void notifyDownloadChange(String str, int i3, int i16, long j3, long j16, String str2) {
        super.notifyDownloadChange(str, i3, i16, j3, j16, str2);
        if (TextUtils.isEmpty(str)) {
            QLog.e("VirtualAppProxyImpl", 1, "notifyDownloadChange gameId is empty");
            return;
        }
        List<OnVADownloadListener> list = this.f347631a.get(str);
        synchronized (this) {
            if (list != null) {
                Iterator<OnVADownloadListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onDownloadUpdate(str, i3, i16, j3, j16, str2);
                }
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy
    public void startDownload(String str, boolean z16, ProxyCallback proxyCallback) {
        super.startDownload(str, z16, proxyCallback);
        QLog.i("VirtualAppProxyImpl", 1, "startDownload gameId:" + str + ", autoResume:" + z16 + ", processId:" + MobileQQ.sProcessId);
        Bundle bundle = new Bundle();
        bundle.putString(VirtualAppProxy.KEY_GAME_ID, str);
        bundle.putInt(VirtualAppProxy.KEY_DOWNLOAD_SCENE, DownloadScene.SCENE_INSTALL_IN_YUNGAME.getScene());
        bundle.putBoolean("download_need_install", true);
        bundle.putBoolean("download_auto_resume", z16);
        ThreadManagerV2.excute(new AnonymousClass2(bundle), 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Unit b(IDanmakuLoadListener iDanmakuLoadListener, MiniGameDanmakuRequest miniGameDanmakuRequest, Boolean bool, List list) {
        if (iDanmakuLoadListener != 0) {
            boolean booleanValue = bool.booleanValue();
            if (list == null) {
                list = Collections.emptyList();
            }
            iDanmakuLoadListener.onGetDanmakuList(booleanValue, list);
        }
        miniGameDanmakuRequest.setListener(null);
        return null;
    }
}
