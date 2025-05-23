package com.tencent.qq.minibox.proxy;

import android.app.Activity;
import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.minibox.proxy.HostNotifySimpleBooleanCallback;
import com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.metadream.IMiniBoxUseMiniGameAbilityApi;
import com.tencent.qq.minibox.api.metadream.IMiniBoxVADownloadTipsDelegate;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002\u001d!B\u0007\u00a2\u0006\u0004\b$\u0010%J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0010\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0016J0\u0010\u0014\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/qq/minibox/proxy/MiniBoxGameUpgradeProxyImpl;", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy;", "Landroid/content/Context;", "hostContext", "Landroid/app/Activity;", "gameActivity", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$IDownloadView;", "getDownloadView", "", "appId", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$QueryAndUpdateVAListener;", "listener", "", "queryAndUpdateVASilence", VirtualAppProxy.KEY_GAME_ID, "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy$UpdateListener;", "registerUpdateListener", "versionCode", "Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;", "callback", "restartVirtualApp", "unregisterUpdateListener", "context", "setNetChangeReceiver", "startUpdate", "stopUpdate", "clearNetChangeReceiver", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "a", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "networkStateListener", "Lcom/tencent/qq/minibox/proxy/h;", "b", "Lcom/tencent/qq/minibox/proxy/h;", "downloadView", "<init>", "()V", "c", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MiniBoxGameUpgradeProxyImpl implements MiniBoxGameUpgradeProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private INetEventHandler networkStateListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h downloadView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qq/minibox/proxy/MiniBoxGameUpgradeProxyImpl$b;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "", TransReport.rep_has_net, "", "onNetChangeEvent", "Lmqq/util/WeakReference;", "Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;", "d", "Lmqq/util/WeakReference;", "callbackRef", "resultCallback", "<init>", "(Lcom/tencent/minibox/proxy/HostNotifySimpleBooleanCallback;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements INetEventHandler {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<HostNotifySimpleBooleanCallback> callbackRef;

        public b(@NotNull HostNotifySimpleBooleanCallback resultCallback) {
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            this.callbackRef = new WeakReference<>(resultCallback);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean hasNet) {
            HostNotifySimpleBooleanCallback hostNotifySimpleBooleanCallback = this.callbackRef.get();
            if (hostNotifySimpleBooleanCallback != null) {
                hostNotifySimpleBooleanCallback.onFinish(hasNet);
            }
        }
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void clearNetChangeReceiver(@NotNull HostNotifySimpleBooleanCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        INetEventHandler iNetEventHandler = this.networkStateListener;
        if (iNetEventHandler != null) {
            AppNetConnInfo.unregisterNetEventHandler(iNetEventHandler);
            this.networkStateListener = null;
        }
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    @Nullable
    public MiniBoxGameUpgradeProxy.IDownloadView getDownloadView(@NotNull Context hostContext, @Nullable Activity gameActivity) {
        Intrinsics.checkNotNullParameter(hostContext, "hostContext");
        QLog.i("MiniBoxGameUpgradeProxyImpl", 1, "getDownloadView hostContext:" + hostContext + " gameActivity:" + gameActivity);
        if (gameActivity == null) {
            QLog.e("MiniBoxGameUpgradeProxyImpl", 1, "getDownloadView params invalid");
            return null;
        }
        if (this.downloadView == null) {
            IMiniBoxVADownloadTipsDelegate miniBoxVADownloadTipsDelegate = ((IMiniBoxUseMiniGameAbilityApi) QRoute.api(IMiniBoxUseMiniGameAbilityApi.class)).getMiniBoxVADownloadTipsDelegate(hostContext, gameActivity);
            if (miniBoxVADownloadTipsDelegate == null) {
                QLog.e("MiniBoxGameUpgradeProxyImpl", 1, "getDownloadView delegate is null");
                return null;
            }
            this.downloadView = new h(miniBoxVADownloadTipsDelegate);
        }
        return this.downloadView;
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void onDestroy() {
        h hVar = this.downloadView;
        if (hVar != null) {
            hVar.onDestroy();
        }
        this.downloadView = null;
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void queryAndUpdateVASilence(@Nullable String appId, @Nullable final MiniBoxGameUpgradeProxy.QueryAndUpdateVAListener listener) {
        boolean z16;
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("MiniBoxGameUpgradeProxyImpl", 1, "queryAndUpdateVASilence appId invalid");
            if (listener != null) {
                listener.notingToUpdate();
                return;
            }
            return;
        }
        QRouteApi api = QRoute.api(IMiniBoxUseMiniGameAbilityApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniBoxUseMiniGameAbilityApi::class.java)");
        final IMiniBoxUseMiniGameAbilityApi iMiniBoxUseMiniGameAbilityApi = (IMiniBoxUseMiniGameAbilityApi) api;
        iMiniBoxUseMiniGameAbilityApi.queryCanUpdateVA(appId, new Function1<String, Unit>() { // from class: com.tencent.qq.minibox.proxy.MiniBoxGameUpgradeProxyImpl$queryAndUpdateVASilence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                QLog.i("MiniBoxGameUpgradeProxyImpl", 1, "queryAndUpdateVASilence callback gameId:" + str);
                boolean isWifiConnected = NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ);
                if (!(str == null || str.length() == 0)) {
                    if (isWifiConnected) {
                        IMiniBoxUseMiniGameAbilityApi.this.startDownload(str, false, true);
                    }
                    MiniBoxGameUpgradeProxy.QueryAndUpdateVAListener queryAndUpdateVAListener = listener;
                    if (queryAndUpdateVAListener != null) {
                        queryAndUpdateVAListener.onSilenceUpdate(str, isWifiConnected);
                        return;
                    }
                    return;
                }
                MiniBoxGameUpgradeProxy.QueryAndUpdateVAListener queryAndUpdateVAListener2 = listener;
                if (queryAndUpdateVAListener2 != null) {
                    queryAndUpdateVAListener2.notingToUpdate();
                }
            }
        });
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void registerUpdateListener(@Nullable String gameId, @Nullable final MiniBoxGameUpgradeProxy.UpdateListener listener) {
        ((IMiniBoxUseMiniGameAbilityApi) QRoute.api(IMiniBoxUseMiniGameAbilityApi.class)).addDownloadListener(gameId, new Function6<String, Integer, Integer, Long, Long, String, Unit>() { // from class: com.tencent.qq.minibox.proxy.MiniBoxGameUpgradeProxyImpl$registerUpdateListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(6);
            }

            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, Integer num2, Long l3, Long l16, String str2) {
                invoke(str, num.intValue(), num2.intValue(), l3.longValue(), l16.longValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable String str, int i3, int i16, long j3, long j16, @Nullable String str2) {
                MiniBoxGameUpgradeProxy.UpdateListener updateListener = MiniBoxGameUpgradeProxy.UpdateListener.this;
                if (updateListener != null) {
                    updateListener.onStatusChanged(new MiniBoxGameUpgradeProxy.MiniBoxGameUpdateState(str == null ? "" : str, i3, i16, j16, j3, str2 == null ? "" : str2));
                }
            }
        });
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void restartVirtualApp(@Nullable String appId, @Nullable String gameId, @Nullable String versionCode, @Nullable final HostNotifySimpleBooleanCallback callback) {
        boolean z16;
        boolean z17;
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (gameId != null && gameId.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                ((IMiniBoxUseMiniGameAbilityApi) QRoute.api(IMiniBoxUseMiniGameAbilityApi.class)).restartVirtualApp(appId, gameId, versionCode, new Function1<Boolean, Unit>() { // from class: com.tencent.qq.minibox.proxy.MiniBoxGameUpgradeProxyImpl$restartVirtualApp$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z18) {
                        HostNotifySimpleBooleanCallback hostNotifySimpleBooleanCallback = HostNotifySimpleBooleanCallback.this;
                        if (hostNotifySimpleBooleanCallback != null) {
                            hostNotifySimpleBooleanCallback.onFinish(z18);
                        }
                    }
                });
                return;
            }
        }
        if (callback != null) {
            callback.onFinish(false);
        }
        QLog.e("MiniBoxGameUpgradeProxyImpl", 1, "restartVirtualApp params invalid, appId:" + appId + ", gameId:" + gameId);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void setNetChangeReceiver(@Nullable Context context, @NotNull HostNotifySimpleBooleanCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        INetEventHandler iNetEventHandler = this.networkStateListener;
        if (iNetEventHandler != null) {
            AppNetConnInfo.unregisterNetEventHandler(iNetEventHandler);
        }
        b bVar = new b(callback);
        this.networkStateListener = bVar;
        AppNetConnInfo.registerNetChangeReceiver(context, bVar);
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void startUpdate(@Nullable String gameId) {
        boolean z16;
        if (gameId != null && gameId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("MiniBoxGameUpgradeProxyImpl", 1, "startUpdate gameId invalid");
        } else {
            ((IMiniBoxUseMiniGameAbilityApi) QRoute.api(IMiniBoxUseMiniGameAbilityApi.class)).startDownload(gameId, false, true);
        }
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void stopUpdate(@Nullable String gameId) {
        boolean z16;
        if (gameId != null && gameId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("MiniBoxGameUpgradeProxyImpl", 1, "stopUpdate gameId invalid");
        } else {
            ((IMiniBoxUseMiniGameAbilityApi) QRoute.api(IMiniBoxUseMiniGameAbilityApi.class)).stopUpdate(gameId);
        }
    }

    @Override // com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy
    public void unregisterUpdateListener(@Nullable String gameId) {
        QLog.d("MiniBoxGameUpgradeProxyImpl", 2, "unregisterUpdateListener gameId:" + gameId);
        ((IMiniBoxUseMiniGameAbilityApi) QRoute.api(IMiniBoxUseMiniGameAbilityApi.class)).removeDownloadListener(gameId);
    }
}
