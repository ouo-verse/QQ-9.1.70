package com.tencent.qqmini.miniapp.core.worker;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsError;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppWorker {
    private HandlerThread mHandlerThread;
    private JsContext mJsContext;
    private IMiniAppContext mMiniAppContext;
    private MiniAppWorkerManager mMiniAppWorkerManager;
    private Handler mThreadHandler;
    private JsVirtualMachine mVM;
    private WebView mWebView;
    private volatile boolean mIsTerminated = false;
    private volatile boolean mIsCtxValid = false;
    private Object mLock = new Object();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class ServiceInterface {
        public ServiceInterface() {
        }

        @JavascriptInterface
        public String invokeHandler(String str, String str2, int i3) {
            QMLog.d(MiniAppWorkerManager.TAG, "invokeHandler|service: " + str + " |id:" + i3);
            return "";
        }

        @JavascriptInterface
        public void publishHandler(String str, String str2, String str3) {
            QMLog.d(MiniAppWorkerManager.TAG, "publishHandler|service: " + str + " |webviewIds:" + str3);
        }
    }

    public MiniAppWorker(IMiniAppContext iMiniAppContext, MiniAppWorkerManager miniAppWorkerManager) {
        this.mMiniAppContext = iMiniAppContext;
        this.mMiniAppWorkerManager = miniAppWorkerManager;
        if (miniAppWorkerManager.isJsCoreMode()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("mini_worker_thread");
            this.mHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
            this.mThreadHandler = new Handler(this.mHandlerThread.getLooper());
            QMLog.i(MiniAppWorkerManager.TAG, "[MiniAppWorker] create and alive in thread --> mini_worker_thread.");
        }
    }

    private void evaluteJs(final String str, final ValueCallback valueCallback) {
        if (this.mMiniAppWorkerManager.isJsCoreMode()) {
            this.mThreadHandler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.8
                @Override // java.lang.Runnable
                public void run() {
                    if (MiniAppWorker.this.mJsContext != null) {
                        MiniAppWorker.this.mJsContext.evaluateJavascript(str, valueCallback);
                    } else {
                        QMLog.e(MiniAppWorkerManager.TAG, " mJsContext === null  ");
                    }
                }
            });
        } else {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.9
                @Override // java.lang.Runnable
                public void run() {
                    if (MiniAppWorker.this.mWebView != null) {
                        MiniAppWorker.this.mWebView.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initJsCore() {
        QMLog.i(MiniAppWorkerManager.TAG, "[initJsCore]");
        JsVirtualMachine jsVirtualMachine = new JsVirtualMachine(this.mMiniAppContext.getContext(), this.mThreadHandler.getLooper());
        this.mVM = jsVirtualMachine;
        JsContext jsContext = new JsContext(jsVirtualMachine);
        this.mJsContext = jsContext;
        jsContext.setExceptionHandler(new JsContext.ExceptionHandler() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.3
            @Override // com.tencent.smtt.sdk.JsContext.ExceptionHandler
            public void handleException(JsContext jsContext2, JsError jsError) {
                QMLog.e(MiniAppWorkerManager.TAG, "X5Exception:" + jsError.getMessage());
            }
        });
        this.mJsContext.addJavascriptInterface(new ServiceInterface(), "WeixinJSCore");
        this.mJsContext.addJavascriptInterface(new MiniWorkerInterface(this.mMiniAppContext), MiniAppWorkerManager.OBJ_WEIXINWORKER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebview() {
        QMLog.i(MiniAppWorkerManager.TAG, "[initWebview]");
        QmX5Webview qmX5Webview = new QmX5Webview(this.mMiniAppContext.getContext());
        this.mWebView = qmX5Webview;
        WebSettings settings = qmX5Webview.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        this.mWebView.addJavascriptInterface(new ServiceInterface(), "WeixinJSCore");
        this.mWebView.addJavascriptInterface(new MiniWorkerInterface(this.mMiniAppContext), MiniAppWorkerManager.OBJ_WEIXINWORKER);
    }

    public void clearUp() {
        QMLog.e(MiniAppWorkerManager.TAG, "clearUp");
        try {
            try {
                JsContext jsContext = this.mJsContext;
                if (jsContext != null) {
                    jsContext.removeJavascriptInterface("WeixinJSCore");
                    this.mJsContext.removeJavascriptInterface(MiniAppWorkerManager.OBJ_WEIXINWORKER);
                    this.mJsContext.destroy();
                    this.mJsContext = null;
                }
                if (this.mWebView != null) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.7
                        @Override // java.lang.Runnable
                        public void run() {
                            MiniAppWorker.this.mWebView.removeJavascriptInterface("WeixinJSCore");
                            MiniAppWorker.this.mWebView.removeJavascriptInterface(MiniAppWorkerManager.OBJ_WEIXINWORKER);
                            MiniAppWorker.this.mWebView.destroy();
                            MiniAppWorker.this.mWebView = null;
                        }
                    });
                }
                JsVirtualMachine jsVirtualMachine = this.mVM;
                if (jsVirtualMachine != null) {
                    jsVirtualMachine.destroy();
                    this.mVM = null;
                }
                HandlerThread handlerThread = this.mHandlerThread;
                if (handlerThread != null && handlerThread.getLooper() != null) {
                    this.mHandlerThread.getLooper().quitSafely();
                }
                this.mHandlerThread = null;
                synchronized (this.mLock) {
                    this.mIsTerminated = true;
                    this.mIsCtxValid = false;
                }
            } catch (Exception e16) {
                QMLog.e(MiniAppWorkerManager.TAG, "[clearUp] failed with : ", e16);
                synchronized (this.mLock) {
                    this.mIsTerminated = true;
                    this.mIsCtxValid = false;
                }
            }
        } catch (Throwable th5) {
            synchronized (this.mLock) {
                this.mIsTerminated = true;
                this.mIsCtxValid = false;
                throw th5;
            }
        }
    }

    public void ctxValid() {
        synchronized (this.mLock) {
            this.mIsCtxValid = true;
        }
    }

    public void initJSContext() {
        QMLog.e(MiniAppWorkerManager.TAG, "[initJSContext]");
        if (this.mMiniAppWorkerManager.isJsCoreMode()) {
            Handler handler = this.mThreadHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniAppWorker.this.initJsCore();
                    }
                });
            }
        } else {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.2
                @Override // java.lang.Runnable
                public void run() {
                    MiniAppWorker.this.initWebview();
                }
            });
        }
        MiniAppWorkerManager miniAppWorkerManager = this.mMiniAppWorkerManager;
        if (miniAppWorkerManager != null) {
            miniAppWorkerManager.onWorkerJSContextInitFinished();
        }
    }

    public boolean isJSContextValid() {
        return this.mIsCtxValid;
    }

    public boolean isTerminated() {
        return this.mIsTerminated;
    }

    public boolean loadExecutedAppConfig() {
        QMLog.i(MiniAppWorkerManager.TAG, "[loadExecutedAppConfig]");
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null && this.mMiniAppContext.getMiniAppInfo().apkgInfo != null) {
            String format = String.format("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nif (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);", this.mMiniAppContext.getMiniAppInfo().apkgInfo.mConfigStr);
            if (DebugUtil.getDebugEnabled(this.mMiniAppContext.getMiniAppInfo().appId)) {
                format = format + "__qqConfig.debug=true;";
            }
            evaluteJs(format, new ValueCallback() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.4
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                public void onReceiveValue(Object obj) {
                    QMLog.i(MiniAppWorkerManager.TAG, "[loadExecutedAppConfig] over");
                }
            });
            return true;
        }
        QMLog.e(MiniAppWorkerManager.TAG, "[loadExecutedAppConfig] failed : empty apkginfo");
        return false;
    }

    public boolean loadWorkerJs(String str) {
        QMLog.i(MiniAppWorkerManager.TAG, "[load workerJs]");
        if (TextUtils.isEmpty(str)) {
            QMLog.e(MiniAppWorkerManager.TAG, "[loadWAWorker] failed : empty workerJs");
            return false;
        }
        evaluteJs(str, new ValueCallback() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.5
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public void onReceiveValue(Object obj) {
                QMLog.i(MiniAppWorkerManager.TAG, "[workerJS] over");
            }
        });
        return true;
    }

    public void postMessageListToWorker(ArrayList<String> arrayList) {
        if (arrayList == null) {
            QMLog.e(MiniAppWorkerManager.TAG, "[postMessageListToWorker] messagePendingList is null");
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            postMessageToWorker(it.next());
        }
        arrayList.clear();
    }

    public void postMessageToWorker(String str) {
        String format = String.format("WeixinWorker.appServiceMsgHandler(%s)", str);
        QMLog.i(MiniAppWorkerManager.TAG, "[postMessageToWorker] jsScript:" + format);
        evaluteJs(format, new ValueCallback() { // from class: com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.6
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public void onReceiveValue(Object obj) {
                QMLog.i(MiniAppWorkerManager.TAG, "[postMessageToWorker] over");
            }
        });
    }
}
