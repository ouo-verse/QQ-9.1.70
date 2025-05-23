package com.tencent.mobileqq.minigame.api.impl;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.MiniGameVAImpl;
import com.tencent.mobileqq.minigame.va.StatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016JZ\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2@\u0010\u0010\u001a<\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\u0004\u0018\u0001`\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016JX\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\b2F\u0010\u0010\u001aB\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`#H\u0016JX\u0010$\u001a\u00020\u00062N\u0010\u0010\u001aJ\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\n\u0018\u00010%\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0%`#H\u0016JX\u0010&\u001a\u00020\u00062N\u0010\u0010\u001aJ\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\n\u0018\u00010%\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0%`#H\u0016JT\u0010'\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\b2B\u0010\u0010\u001a>\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u0011j\b\u0012\u0004\u0012\u00020\n`#H\u0016J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0016Jb\u0010+\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2@\u0010\u0010\u001a<\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\u0004\u0018\u0001`\u0017H\u0016J9\u0010-\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u00122\b\u0010/\u001a\u0004\u0018\u00010\u00122\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0012H\u0016\u00a2\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u00105\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/impl/MiniGameVAServiceImpl;", "Lcom/tencent/mobileqq/minigame/api/IMiniGameVAService;", "()V", "miniGameVA", "Lcom/tencent/mobileqq/minigame/va/MiniGameVAImpl;", "cancelDownload", "", VirtualAppProxy.KEY_GAME_ID, "", "getLastUpdateVA", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "getSpaceLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "installVA", "data", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "Lcom/tencent/mobileqq/minigame/va/MiniGameGeneralCallback;", "needCheckDiff", "launchVA", "uriData", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "pauseDownload", "preloadVADownload", "queryCanUpdateVA", "appId", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "queryExistDownloadList", "", "queryExistVAList", "queryVAInfo", "registerStatusListener", "listener", "Lcom/tencent/mobileqq/minigame/va/StatusListener;", "restartAndInstallVA", "versionCode", "startDownload", "needInstall", "onlyWifi", "scene", "", "autoResume", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;IZ)V", "uninstallVA", "unregisterStatusListener", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVAServiceImpl implements IMiniGameVAService {
    private MiniGameVAImpl miniGameVA;

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void cancelDownload(String gameId) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.cancelDownload(gameId);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public MiniGameDownloadDataWrapper getLastUpdateVA() {
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        return miniGameVAImpl.getLastUpdateVA();
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVAService
    public MutableLiveData<Long> getSpaceLiveData() {
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        return miniGameVAImpl.getSpaceLiveData();
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void installVA(MiniGameDownloadDataWrapper data, Function2<? super Boolean, ? super String, Unit> callback, boolean needCheckDiff) {
        Intrinsics.checkNotNullParameter(data, "data");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.installVA(data, callback, needCheckDiff);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void launchVA(MiniGameDownloadDataWrapper data, String uriData) {
        Intrinsics.checkNotNullParameter(data, "data");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.launchVA(data, uriData);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        iMiniBoxLauncher.init(context);
        this.miniGameVA = new MiniGameVAImpl();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.onDestroy();
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void pauseDownload(String gameId) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.pauseDownload(gameId);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void preloadVADownload() {
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.preloadVADownload();
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void queryCanUpdateVA(String appId, Function2<? super Boolean, ? super MiniGameDownloadDataWrapper, Unit> callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.queryCanUpdateVA(appId, callback);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void queryExistDownloadList(Function2<? super Boolean, ? super List<MiniGameDownloadDataWrapper>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.queryExistDownloadList(callback);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void queryExistVAList(Function2<? super Boolean, ? super List<MiniGameDownloadDataWrapper>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.queryExistVAList(callback);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void queryVAInfo(String appId, Function2<? super Boolean, ? super MiniGameDownloadDataWrapper, Unit> callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.queryVAInfo(appId, callback);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void registerStatusListener(String gameId, StatusListener listener) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.registerStatusListener(gameId, listener);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void restartAndInstallVA(String appId, String gameId, String versionCode, Function2<? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(versionCode, "versionCode");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.restartAndInstallVA(appId, gameId, versionCode, callback);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void startDownload(String gameId, Boolean needInstall, Boolean onlyWifi, int scene, boolean autoResume) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.startDownload(gameId, needInstall, onlyWifi, scene, autoResume);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void uninstallVA(String gameId) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.uninstallVA(gameId);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void unregisterStatusListener(String gameId, StatusListener listener) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MiniGameVAImpl miniGameVAImpl = this.miniGameVA;
        if (miniGameVAImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniGameVA");
            miniGameVAImpl = null;
        }
        miniGameVAImpl.unregisterStatusListener(gameId, listener);
    }
}
