package com.tencent.ams.mosaic.jsengine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSEvaluationException;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.hippo.quickjs.android.JSRuntime;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.hippo.quickjs.android.QuickJS;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.g;
import com.tencent.ams.mosaic.h;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.common.AppManager;
import com.tencent.ams.mosaic.jsengine.component.Component;
import com.tencent.ams.mosaic.jsengine.sensor.SensorFactory;
import com.tencent.ams.mosaic.jsengine.typeadapter.AgentTypeAdapter;
import com.tencent.ams.mosaic.jsengine.typeadapter.FunctionTypeAdapter;
import com.tencent.ams.mosaic.jsengine.typeadapter.ObjectTypeAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QuickJSEngine implements com.tencent.ams.mosaic.jsengine.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QuickJS f70655a;

    /* renamed from: b, reason: collision with root package name */
    private JSRuntime f70656b;

    /* renamed from: c, reason: collision with root package name */
    private JSContext f70657c;

    /* renamed from: d, reason: collision with root package name */
    private d f70658d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f70659e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f70660f;

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f70661g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Class<? extends Component>> f70662h;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Class<? extends Component>> f70663i;

    /* renamed from: j, reason: collision with root package name */
    private final h f70664j;

    /* renamed from: k, reason: collision with root package name */
    private c f70665k;

    /* renamed from: l, reason: collision with root package name */
    private f.c f70666l;

    /* renamed from: m, reason: collision with root package name */
    private f.InterfaceC0685f f70667m;

    /* renamed from: n, reason: collision with root package name */
    private final HandlerThread f70668n;

    /* renamed from: o, reason: collision with root package name */
    private final a f70669o;

    /* renamed from: p, reason: collision with root package name */
    private AppManager f70670p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.ams.mosaic.jsengine.common.file.a f70671q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.ams.mosaic.jsengine.common.click.a f70672r;

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.QuickJSEngine$6, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f70685d;
        final /* synthetic */ QuickJSEngine this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f70685d.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }
    }

    public QuickJSEngine(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f70659e = new AtomicBoolean();
        this.f70661g = new ArrayList();
        this.f70662h = new HashMap();
        this.f70663i = new HashMap();
        this.f70664j = new h();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Mosaic-JS-Engine", f.k().l());
        this.f70668n = baseHandlerThread;
        baseHandlerThread.start();
        this.f70669o = new a(baseHandlerThread.getLooper());
        this.f70658d = new d();
        if (!f.k().w()) {
            Q(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, Object[] objArr, a.b bVar) {
        if (this.f70660f) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "callGlobalJsFunction '" + str + "' failed: closed");
            return;
        }
        if (!T()) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "callJsGlobalFunction failed: not initialized");
            if (bVar != null) {
                bVar.onFail(null);
                return;
            }
            return;
        }
        if (this.f70657c != null && !TextUtils.isEmpty(str)) {
            try {
                JSObject globalObject = this.f70657c.getGlobalObject();
                if (globalObject == null) {
                    com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "callJsGlobalFunction failed: globalObject is null");
                    if (bVar != null) {
                        bVar.onFail(null);
                        return;
                    }
                    return;
                }
                JSValue property = globalObject.getProperty(str);
                if (property instanceof JSFunction) {
                    JSFunction jSFunction = (JSFunction) property.cast(JSFunction.class);
                    jSFunction.setFuncName(str);
                    N(jSFunction, objArr, bVar);
                } else if (bVar != null) {
                    bVar.onFail(null);
                }
                com.tencent.ams.mosaic.utils.f.e("QuickJSEngine", "callGlobalJsFunction '" + str + "' success");
                return;
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.i("QuickJSEngine", "callJsGlobalFunction failed", th5);
                if (bVar != null) {
                    bVar.onFail(null);
                    return;
                }
                return;
            }
        }
        com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "callJsGlobalFunction failed: invalid params");
        if (bVar != null) {
            bVar.onFail(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        r6.onSuccess(r4, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void N(JSFunction jSFunction, Object[] objArr, a.b bVar) {
        String str = null;
        try {
            JSValue invoke = jSFunction.invoke(null, e.i(objArr, l()));
            if (!S() && !P()) {
                if (bVar != null) {
                    bVar.onFail(jSFunction);
                }
            }
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("QuickJSEngine", "doCallJsFunction failed", th5);
            if (bVar != null) {
                bVar.onFail(jSFunction);
            }
            if (jSFunction != null) {
                str = jSFunction.getFuncName();
            }
            String str2 = "doCallJsFunction failed, funcName: " + str + ", error: " + th5.getMessage();
            com.tencent.ams.mosaic.utils.f.i("QuickJSEngine", str2, th5);
            HashMap hashMap = new HashMap(4);
            hashMap.put("msg", str2);
            hashMap.put("exception", th5);
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, 4);
            hashMap.put("paramValue", str);
            this.f70664j.b(new g("onCallJsFunctionFailed", hashMap));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        r6.onSuccess(r4, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O(JSFunction jSFunction, Object[] objArr, a.b bVar) {
        String str = null;
        try {
            JSValue invokeWithoutLock = jSFunction.invokeWithoutLock(null, e.i(objArr, l()));
            if (!S() && !P()) {
                if (bVar != null) {
                    bVar.onFail(jSFunction);
                }
            }
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("QuickJSEngine", "doCallJsFunction failed", th5);
            if (bVar != null) {
                bVar.onFail(jSFunction);
            }
            if (jSFunction != null) {
                str = jSFunction.getFuncName();
            }
            String str2 = "doCallJsFunction failed, funcName: " + str + ", error: " + th5.getMessage();
            com.tencent.ams.mosaic.utils.f.i("QuickJSEngine", str2, th5);
            HashMap hashMap = new HashMap(4);
            hashMap.put("msg", str2);
            hashMap.put("exception", th5);
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, 4);
            hashMap.put("paramValue", str);
            this.f70664j.b(new g("onCallJsFunctionFailed", hashMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        if (this.f70660f) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "executePendingJob failed: closed'");
            return false;
        }
        JSContext jSContext = this.f70657c;
        if (jSContext == null) {
            return true;
        }
        do {
            try {
                if (this.f70660f) {
                    com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "executePendingJob failed: closed'");
                    return false;
                }
            } catch (JSEvaluationException unused) {
                return false;
            }
        } while (jSContext.executePendingJob());
        com.tencent.ams.mosaic.utils.f.a("QuickJSEngine", "executePendingJob: no pending job'");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f70661g.contains(str);
    }

    private boolean S() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    private void U(@NonNull Runnable runnable) {
        if (Thread.currentThread() == this.f70668n) {
            runnable.run();
        } else {
            this.f70669o.post(runnable);
        }
    }

    public void Q(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        } else {
            U(new Runnable(context) { // from class: com.tencent.ams.mosaic.jsengine.QuickJSEngine.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f70673d;

                {
                    this.f70673d = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QuickJSEngine.this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!QuickJSEngine.this.f70659e.get()) {
                        try {
                            QuickJSEngine.this.f70655a = new QuickJS.Builder().registerTypeAdapterFactory(AgentTypeAdapter.FACTORY).registerTypeAdapter(JSFunction.class, new FunctionTypeAdapter().nullable()).registerTypeAdapter(JSObject.class, new ObjectTypeAdapter().nullable()).build();
                            QuickJSEngine quickJSEngine = QuickJSEngine.this;
                            quickJSEngine.f70656b = quickJSEngine.f70655a.createJSRuntime();
                            QuickJSEngine quickJSEngine2 = QuickJSEngine.this;
                            quickJSEngine2.f70657c = quickJSEngine2.f70656b.createJSContext();
                            QuickJSEngine.this.f70670p = new AppManager(this.f70673d, QuickJSEngine.this);
                            QuickJSEngine.this.f70671q = new com.tencent.ams.mosaic.jsengine.common.file.a(this.f70673d);
                            QuickJSEngine quickJSEngine3 = QuickJSEngine.this;
                            quickJSEngine3.f70672r = new com.tencent.ams.mosaic.jsengine.common.click.a(this.f70673d, quickJSEngine3);
                            QuickJSEngine.this.f70659e.set(true);
                            QuickJSEngine.this.h(MosaicConstants$JsProperty.PROP_CONSOLE, new com.tencent.ams.mosaic.jsengine.common.b());
                            QuickJSEngine quickJSEngine4 = QuickJSEngine.this;
                            quickJSEngine4.h(MosaicConstants$JsProperty.PROP_DOWNLOAD_MANAGER, new com.tencent.ams.mosaic.jsengine.common.download.a(quickJSEngine4));
                            QuickJSEngine quickJSEngine5 = QuickJSEngine.this;
                            quickJSEngine5.h(MosaicConstants$JsProperty.PROP_EVENT_CENTER, quickJSEngine5.f70664j);
                            QuickJSEngine quickJSEngine6 = QuickJSEngine.this;
                            quickJSEngine6.h(MosaicConstants$JsProperty.PROP_APP_MANAGER, quickJSEngine6.f70670p);
                            QuickJSEngine quickJSEngine7 = QuickJSEngine.this;
                            quickJSEngine7.h(MosaicConstants$JsProperty.PROP_FILE_MANAGER, quickJSEngine7.f70671q);
                            QuickJSEngine quickJSEngine8 = QuickJSEngine.this;
                            quickJSEngine8.h(MosaicConstants$JsProperty.PROP_WX_MANAGER, quickJSEngine8.f70672r);
                            QuickJSEngine.this.h(MosaicConstants$JsProperty.PROP_SENSOR_FACTORY, new SensorFactory(this.f70673d, QuickJSEngine.this));
                            QuickJSEngine.this.h(MosaicConstants$JsProperty.APP_RESOURCE, new com.tencent.ams.mosaic.jsengine.common.a());
                        } catch (Throwable th5) {
                            com.tencent.ams.mosaic.utils.f.c("QuickJSEngine", "init failed", th5);
                            HashMap hashMap = new HashMap(4);
                            hashMap.put("msg", th5.getMessage());
                            hashMap.put("exception", th5);
                            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, 1);
                            hashMap.put("paramValue", "init");
                            QuickJSEngine.this.f70664j.b(new g("onJsEngineInitFailed", hashMap));
                        }
                    }
                }
            });
        }
    }

    public boolean T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f70659e.get();
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public f.c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (f.c) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f70666l;
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    @SuppressLint({"ObsoleteSdkInt"})
    public synchronized void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f70660f) {
            return;
        }
        this.f70660f = true;
        this.f70668n.quitSafely();
        JSContext jSContext = this.f70657c;
        if (jSContext != null) {
            jSContext.close();
        }
        JSRuntime jSRuntime = this.f70656b;
        if (jSRuntime != null) {
            jSRuntime.close();
        }
        AppManager appManager = this.f70670p;
        if (appManager != null) {
            appManager.d();
        }
        com.tencent.ams.mosaic.jsengine.common.file.a aVar = this.f70671q;
        if (aVar != null) {
            aVar.b();
        }
        f.k().F(this);
        com.tencent.ams.mosaic.utils.a.b().a();
        com.tencent.ams.mosaic.utils.f.e("QuickJSEngine", AudioContext.State.CLOSED);
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f70658d;
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void e(f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) cVar);
        } else {
            this.f70666l = cVar;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public Class<? extends Component> f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Class) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f70662h.get(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    @NonNull
    public h g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f70664j;
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public f.InterfaceC0685f getVideoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (f.InterfaceC0685f) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.f70667m;
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void h(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, obj);
            return;
        }
        if (this.f70660f) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "injectJSProperty '" + str + "' failed: closed");
            return;
        }
        U(new Runnable(str, obj) { // from class: com.tencent.ams.mosaic.jsengine.QuickJSEngine.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f70674d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Object f70675e;

            {
                this.f70674d = str;
                this.f70675e = obj;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QuickJSEngine.this, str, obj);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!QuickJSEngine.this.T()) {
                    com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "injectJSProperty failed: not initialized");
                    return;
                }
                try {
                    JSObject globalObject = QuickJSEngine.this.f70657c.getGlobalObject();
                    if (globalObject == null) {
                        return;
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    globalObject.setProperty(this.f70674d, QuickJSEngine.this.f70655a.getAdapter(this.f70675e.getClass()).toJSValue(QuickJSEngine.this.f70657c, this.f70675e));
                    com.tencent.ams.mosaic.utils.f.e("QuickJSEngine", "inject js property: '" + this.f70674d + "' success, cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                } catch (Throwable th5) {
                    String str2 = "inject js property: '" + this.f70674d + "' failed, error: " + th5.getMessage();
                    com.tencent.ams.mosaic.utils.f.i("QuickJSEngine", str2, th5);
                    HashMap hashMap = new HashMap(4);
                    hashMap.put("msg", str2);
                    hashMap.put("exception", th5);
                    hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, 2);
                    hashMap.put("paramValue", this.f70674d);
                    QuickJSEngine.this.f70664j.b(new g("onInjectPropFailed", hashMap));
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void i(@NonNull Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, runnable, Long.valueOf(j3));
        } else if (j3 > 0) {
            this.f70669o.postDelayed(runnable, j3);
        } else {
            U(runnable);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public boolean isClosed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f70660f;
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public c j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (c) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f70665k;
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void k(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cVar);
        } else {
            this.f70665k = cVar;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public JSContext l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSContext) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70657c;
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void m(JSFunction jSFunction, Object[] objArr, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, jSFunction, objArr, bVar);
        } else if (this.f70660f) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "callJsFunctionInCurrentThreadWithoutLock failed: closed");
        } else {
            O(jSFunction, objArr, bVar);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void n(String str, Object[] objArr, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, objArr, bVar);
            return;
        }
        if (this.f70660f) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "callGlobalJsFunction '" + str + "' failed: closed");
            return;
        }
        U(new Runnable(str, objArr, bVar) { // from class: com.tencent.ams.mosaic.jsengine.QuickJSEngine.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f70679d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Object[] f70680e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ a.b f70681f;

            {
                this.f70679d = str;
                this.f70680e = objArr;
                this.f70681f = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QuickJSEngine.this, str, objArr, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QuickJSEngine.this.M(this.f70679d, this.f70680e, this.f70681f);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void o(String str, Class<? extends Component> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) cls);
        } else if (!TextUtils.isEmpty(str) && cls != null) {
            this.f70662h.put(str, cls);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void p(JSFunction jSFunction, Object[] objArr, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, jSFunction, objArr, bVar);
        } else if (this.f70660f) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "callJsFunctionInCurrentThread failed: closed");
        } else {
            N(jSFunction, objArr, bVar);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void q(f.InterfaceC0685f interfaceC0685f) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) interfaceC0685f);
        } else {
            this.f70667m = interfaceC0685f;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void r(Object obj, String str, a.InterfaceC0686a interfaceC0686a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, obj, str, interfaceC0686a);
            return;
        }
        if (this.f70660f) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "evaluate '" + str + "' failed: closed");
            if (interfaceC0686a != null) {
                interfaceC0686a.onFail("failCodeClosed");
                return;
            }
            return;
        }
        U(new Runnable(interfaceC0686a, str, obj) { // from class: com.tencent.ams.mosaic.jsengine.QuickJSEngine.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a.InterfaceC0686a f70676d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f70677e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object f70678f;

            {
                this.f70676d = interfaceC0686a;
                this.f70677e = str;
                this.f70678f = obj;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QuickJSEngine.this, interfaceC0686a, str, obj);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!QuickJSEngine.this.T()) {
                    com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "evaluate failed: not initialized");
                    a.InterfaceC0686a interfaceC0686a2 = this.f70676d;
                    if (interfaceC0686a2 != null) {
                        interfaceC0686a2.onFail("failCodeNotInit");
                        return;
                    }
                    return;
                }
                try {
                    if (QuickJSEngine.this.f70657c != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!QuickJSEngine.this.R(this.f70677e)) {
                            Object obj2 = this.f70678f;
                            if (obj2 instanceof String) {
                                QuickJSEngine.this.f70657c.evaluate((String) this.f70678f, this.f70677e);
                                QuickJSEngine.this.P();
                            } else if (obj2 instanceof byte[]) {
                                QuickJSEngine.this.f70657c.evaluateBytecode((byte[]) this.f70678f, this.f70677e);
                                QuickJSEngine.this.P();
                            } else {
                                throw new IllegalArgumentException("javascript data error.");
                            }
                            if (!TextUtils.isEmpty(this.f70677e)) {
                                QuickJSEngine.this.f70661g.add(this.f70677e);
                            }
                        }
                        a.InterfaceC0686a interfaceC0686a3 = this.f70676d;
                        if (interfaceC0686a3 != null) {
                            interfaceC0686a3.onSuccess(this.f70677e);
                        }
                        com.tencent.ams.mosaic.utils.f.e("QuickJSEngine", "evaluate success: " + this.f70677e + ", cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                        return;
                    }
                    a.InterfaceC0686a interfaceC0686a4 = this.f70676d;
                    if (interfaceC0686a4 != null) {
                        interfaceC0686a4.onFail("failCodeJsContextNull");
                    }
                } catch (Throwable th5) {
                    com.tencent.ams.mosaic.utils.f.i("QuickJSEngine", "evaluate failed: " + this.f70677e, th5);
                    a.InterfaceC0686a interfaceC0686a5 = this.f70676d;
                    if (interfaceC0686a5 != null) {
                        interfaceC0686a5.onFail(this.f70677e);
                    }
                    HashMap hashMap = new HashMap(4);
                    hashMap.put("msg", "evaluate failed: " + this.f70677e + ", error: " + th5.getMessage());
                    hashMap.put("exception", th5);
                    hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, 3);
                    hashMap.put("paramValue", this.f70677e);
                    QuickJSEngine.this.f70664j.b(new g("onJsEvaluateFailed", hashMap));
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void s(String str, Object[] objArr, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, objArr, bVar);
        } else {
            M(str, objArr, bVar);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public Class<? extends Component> t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Class) iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f70663i.get(str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.a
    public void u(JSFunction jSFunction, Object[] objArr, a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, jSFunction, objArr, bVar);
        } else if (this.f70660f) {
            com.tencent.ams.mosaic.utils.f.h("QuickJSEngine", "callJsFunction failed: closed");
        } else {
            U(new Runnable(jSFunction, objArr, bVar) { // from class: com.tencent.ams.mosaic.jsengine.QuickJSEngine.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f70682d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Object[] f70683e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ a.b f70684f;

                {
                    this.f70682d = jSFunction;
                    this.f70683e = objArr;
                    this.f70684f = bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QuickJSEngine.this, jSFunction, objArr, bVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QuickJSEngine.this.N(this.f70682d, this.f70683e, this.f70684f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
