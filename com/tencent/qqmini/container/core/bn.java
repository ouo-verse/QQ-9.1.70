package com.tencent.qqmini.container.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsError;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class bn extends j {

    /* renamed from: e, reason: collision with root package name */
    private JsContext f346112e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f346113f;

    /* renamed from: h, reason: collision with root package name */
    private final HandlerThread f346114h;

    /* renamed from: i, reason: collision with root package name */
    private ServiceEventListener f346115i;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z16, String str);
    }

    public bn(IMiniAppContext iMiniAppContext) {
        super(iMiniAppContext);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("mini_service_thread");
        this.f346114h = baseHandlerThread;
        baseHandlerThread.start();
        this.f346113f = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void r(final a aVar) {
        this.f346113f.post(new Runnable() { // from class: com.tencent.qqmini.container.core.bl
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.s(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        JsContext jsContext = this.f346112e;
        if (jsContext != null) {
            jsContext.destroy();
        }
        if (this.f346114h.isAlive()) {
            this.f346114h.quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str, ValueCallback valueCallback) {
        JsContext jsContext = this.f346112e;
        if (jsContext != null) {
            jsContext.evaluateJavascript(str, valueCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(a aVar) {
        try {
            JsVirtualMachine jsVirtualMachine = new JsVirtualMachine(this.f346121d.getContext(), this.f346113f.getLooper());
            if (jsVirtualMachine.isFallback()) {
                if (aVar != null) {
                    aVar.a(false, "can not use x5 core");
                }
                jsVirtualMachine.destroy();
                return;
            }
            JsContext jsContext = new JsContext(jsVirtualMachine);
            this.f346112e = jsContext;
            jsContext.setExceptionHandler(new JsContext.ExceptionHandler() { // from class: com.tencent.qqmini.container.core.bm
                @Override // com.tencent.smtt.sdk.JsContext.ExceptionHandler
                public final void handleException(JsContext jsContext2, JsError jsError) {
                    bn.t(jsContext2, jsError);
                }
            });
            this.f346112e.addJavascriptInterface(this, "WeixinJSCore");
            this.f346112e.addJavascriptInterface(new MiniWorkerInterface(this.f346121d), MiniAppWorkerManager.OBJ_WEIXINWORKER);
            if (aVar != null) {
                aVar.a(true, "");
            }
        } catch (Exception e16) {
            if (aVar != null) {
                aVar.a(false, String.valueOf(e16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(JsContext jsContext, JsError jsError) {
        QMLog.e("Mini-X5JsService", "X5Exception:" + jsError.getMessage());
    }

    @Override // com.tencent.qqmini.container.core.j
    public void b() {
        Handler handler = this.f346113f;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.qqmini.container.core.bj
                @Override // java.lang.Runnable
                public final void run() {
                    bn.this.p();
                }
            });
        }
    }

    @Override // com.tencent.qqmini.container.core.j
    protected final void c(final String str, String str2, final ValueCallback valueCallback) {
        if (Thread.currentThread() == this.f346114h) {
            JsContext jsContext = this.f346112e;
            if (jsContext != null) {
                jsContext.evaluateJavascript(str, valueCallback);
                return;
            }
            return;
        }
        this.f346113f.post(new Runnable() { // from class: com.tencent.qqmini.container.core.bi
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.q(str, valueCallback);
            }
        });
    }

    @Override // com.tencent.qqmini.container.core.j
    public void h(ServiceEventListener serviceEventListener) {
        this.f346115i = serviceEventListener;
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i3) {
        ServiceEventListener serviceEventListener = this.f346115i;
        if (serviceEventListener != null) {
            return serviceEventListener.onServiceNativeRequest(str, str2, i3);
        }
        return "";
    }

    public void n(final a aVar) {
        eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.bk
            @Override // java.lang.Runnable
            public final void run() {
                bn.this.r(aVar);
            }
        });
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        ServiceEventListener serviceEventListener = this.f346115i;
        if (serviceEventListener != null) {
            serviceEventListener.onServiceEvent(str, str2, eu3.a.a(str3));
        }
    }
}
