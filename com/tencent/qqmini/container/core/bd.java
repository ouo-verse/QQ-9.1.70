package com.tencent.qqmini.container.core;

import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.service.ServiceEventListener;
import com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.v8rt.engine.Callback;
import com.tencent.qqmini.v8rt.engine.Engine;
import com.tencent.qqmini.v8rt.engine.IServiceEventHandler;
import com.tencent.qqmini.v8rt.engine.IWorkerEventHandler;
import com.tencent.qqmini.v8rt.engine.ServiceEventHandlerProvider;
import com.tencent.qqmini.v8rt.engine.V8JsRuntime;
import com.tencent.qqmini.v8rt.engine.WorkerHandlerProvider;

/* compiled from: P */
/* loaded from: classes23.dex */
public class bd extends j {

    /* renamed from: e, reason: collision with root package name */
    private V8JsRuntime f346084e;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements IServiceEventHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ServiceEventListener f346085a;

        a(ServiceEventListener serviceEventListener) {
            this.f346085a = serviceEventListener;
        }

        @Override // com.tencent.qqmini.v8rt.engine.IServiceEventHandler
        public void onServiceEvent(String str, String str2, int[] iArr) {
            this.f346085a.onServiceEvent(str, str2, iArr);
        }

        @Override // com.tencent.qqmini.v8rt.engine.IServiceEventHandler
        public String onServiceNativeRequest(String str, String str2, int i3) {
            return this.f346085a.onServiceNativeRequest(str, str2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements IWorkerEventHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MiniWorkerInterface f346087a;

        b(MiniWorkerInterface miniWorkerInterface) {
            this.f346087a = miniWorkerInterface;
        }

        @Override // com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
        public int create(String str) {
            return this.f346087a.create(str);
        }

        @Override // com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
        public void postMsgToAppService(String str) {
            this.f346087a.postMsgToAppService(str);
        }

        @Override // com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
        public void postMsgToWorker(int i3, String str) {
            this.f346087a.postMsgToWorker(i3, str);
        }

        @Override // com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
        public void terminate(int i3) {
            this.f346087a.terminate(i3);
        }
    }

    public bd(IMiniAppContext iMiniAppContext) {
        super(iMiniAppContext);
        Engine engine = Engine.getInstance();
        engine.setDebuggerOption(false, false);
        engine.initEngine(iMiniAppContext.getContext());
        if (engine.getStatus() == 0) {
            V8JsRuntime createJsRuntime = engine.createJsRuntime();
            this.f346084e = createJsRuntime;
            createJsRuntime.getDefaultContext().injectAll();
            i();
            return;
        }
        QMLog.e(Engine.TAG, "create js runtime failed, engine status:" + engine.getStatus());
    }

    @Override // com.tencent.qqmini.container.core.j
    public void b() {
        V8JsRuntime v8JsRuntime = this.f346084e;
        if (v8JsRuntime != null) {
            v8JsRuntime.release();
            ServiceEventHandlerProvider.getInstance().removeServiceEventHandler(this.f346084e);
            WorkerHandlerProvider.getInstance().removeWorkerHandler(this.f346084e);
        }
    }

    @Override // com.tencent.qqmini.container.core.j
    protected final void c(String str, String str2, final ValueCallback valueCallback) {
        if (valueCallback != null) {
            this.f346084e.getDefaultContext().evaluateJsAsyncWithReturn(str, new Callback() { // from class: com.tencent.qqmini.container.core.bc
                @Override // com.tencent.qqmini.v8rt.engine.Callback
                public final void onFinish(Object obj) {
                    valueCallback.onReceiveValue(obj);
                }
            });
        } else {
            this.f346084e.getDefaultContext().evaluateJsAsync(str, null);
        }
    }

    @Override // com.tencent.qqmini.container.core.j
    public void f() {
        V8JsRuntime v8JsRuntime = this.f346084e;
        if (v8JsRuntime != null) {
            v8JsRuntime.getDefaultContext().garbageCollect();
        }
    }

    @Override // com.tencent.qqmini.container.core.j
    public void h(ServiceEventListener serviceEventListener) {
        ServiceEventHandlerProvider.getInstance().setServiceEventHandler(this.f346084e, new a(serviceEventListener));
    }

    public void i() {
        WorkerHandlerProvider.getInstance().setWorkerHandler(this.f346084e, new b(new MiniWorkerInterface(this.f346121d)));
    }
}
