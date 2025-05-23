package com.tencent.qqmini.miniapp.core.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandRemoteService extends AbsAppBrandService {
    protected static final String TAG = "AppBrandRemoteService";
    protected static HandlerThread mHandlerThread;
    protected static Handler mThreadHandler;
    private AppBrandWebSocket appBrandWebSocket;
    protected String threadName;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnLoadServiceWebvieJsListener {
        void onLoadFinish();
    }

    public AppBrandRemoteService(IMiniAppContext iMiniAppContext, ServiceEventListener serviceEventListener) {
        super(iMiniAppContext);
        this.threadName = "mini_remote_service_thread";
        synchronized (AppBrandRemoteService.class) {
            if (mHandlerThread == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(this.threadName);
                mHandlerThread = baseHandlerThread;
                baseHandlerThread.start();
                mThreadHandler = new Handler(mHandlerThread.getLooper());
            }
        }
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        String str = miniAppInfo.appId;
        DebugInfo debugInfo = miniAppInfo.debugInfo;
        initFramework(iMiniAppContext, str, debugInfo.roomId, debugInfo.wsUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setApkgInfo$0() {
        setCurrState(this.stateLoadSucc);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateCallbackJs(int i3, String str) {
        String format = String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", Integer.valueOf(i3), str);
        QMLog.d("AppBrandRemoteService", "evaluateCallbackJs 2: " + format);
        evaluateJs(format, null);
    }

    @Override // com.tencent.qqmini.miniapp.core.fsm.JsStatMachine
    public void evaluateJs(String str, ValueCallback valueCallback, String str2) {
        QMLog.d("AppBrandRemoteService", "evaluateJs 1: " + str);
        evaluateJs(str, valueCallback);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateSubscribeJS(String str, String str2, int i3) {
        QMLog.d("AppBrandRemoteService", "evaluateSubscribeJS  eventName=" + str);
        evaluateJs("WeixinJSBridge.subscribeHandler(\"" + str + "\"," + str2 + "," + i3 + ",0)", null);
    }

    @Override // com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public int getStatus() {
        return 0;
    }

    @Override // com.tencent.qqmini.miniapp.core.service.AbsAppBrandService, com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public void initBaseJs(BaselibLoader.BaselibContent baselibContent) {
        setCurrState(this.stateWaJsLoading);
    }

    @Override // com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public void initEmbeddedState(EmbeddedState embeddedState) {
        QMLog.d("AppBrandRemoteService", "initEmbeddedState");
        AppBrandWebSocket appBrandWebSocket = this.appBrandWebSocket;
        if (appBrandWebSocket != null) {
            appBrandWebSocket.initEmbeddedState(embeddedState);
        }
    }

    public void initFramework(final IMiniAppContext iMiniAppContext, final String str, final String str2, final String str3) {
        final String account = LoginManager.getInstance().getAccount();
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getA2(new MiniAppProxy.GetA2InfoCallback() { // from class: com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetA2InfoCallback
            public void onFail(int i3, String str4) {
                QMLog.e("AppBrandRemoteService", " GetA2InfoCallback errorCode: " + i3 + " errorMsg: " + str4);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetA2InfoCallback
            public void onSuccess(String str4, String str5, String str6) {
                AppBrandRemoteService.this.appBrandWebSocket = new AppBrandWebSocket(iMiniAppContext, AppBrandRemoteService.mThreadHandler, AppBrandRemoteService.this);
                String str7 = str3 + "?appId=" + str + "&roomId=" + str2 + "&uin=" + account + "&bytesSig=" + str4;
                AppBrandRemoteService.this.appBrandWebSocket.connect(str7);
                QMLog.d("AppBrandRemoteService", " connect: " + str7);
            }
        });
    }

    public void sendDomEvent(String str, int i3) {
        AppBrandWebSocket appBrandWebSocket = this.appBrandWebSocket;
        if (appBrandWebSocket != null) {
            appBrandWebSocket.sendDomEvent(str, i3);
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.service.AbsAppBrandService, com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public void setApkgInfo(ApkgInfo apkgInfo) {
        QMLog.d("AppBrandRemoteService", "setApkgInfo");
        AppBrandWebSocket appBrandWebSocket = this.appBrandWebSocket;
        if (appBrandWebSocket != null) {
            appBrandWebSocket.setApkgInfo(apkgInfo);
            this.appBrandWebSocket.sendSetupContextCmd(new OnLoadServiceWebvieJsListener() { // from class: com.tencent.qqmini.miniapp.core.service.a
                @Override // com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService.OnLoadServiceWebvieJsListener
                public final void onLoadFinish() {
                    AppBrandRemoteService.this.lambda$setApkgInfo$0();
                }
            });
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public void setAppBrandEventInterface(ServiceEventListener serviceEventListener) {
        QMLog.d("AppBrandRemoteService", "setAppBrandEventInterface");
        AppBrandWebSocket appBrandWebSocket = this.appBrandWebSocket;
        if (appBrandWebSocket != null) {
            appBrandWebSocket.setServiceEventListener(serviceEventListener);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateJs(String str, ValueCallback valueCallback) {
        QMLog.d("AppBrandRemoteService", "evaluateJs 2: " + str);
        AppBrandWebSocket appBrandWebSocket = this.appBrandWebSocket;
        if (appBrandWebSocket != null) {
            appBrandWebSocket.evaluateJs(str, valueCallback);
        }
    }
}
