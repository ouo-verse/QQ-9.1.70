package com.tencent.mtt.hippy.bridge;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.bugly.library.BuglyAppVersionMode;
import com.tencent.hippy.qq.utils.ComponentFactory;
import com.tencent.mtt.hippy.BuildConfig;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.jsi.TurboModuleManager;
import com.tencent.mtt.hippy.c.c.b.d;
import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.runtime.builtins.i;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.DimensionsUtil;
import com.tencent.mtt.hippy.utils.I18nUtil;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements Handler.Callback, HippyBridge.a, a {

    /* renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f337024j = true;

    /* renamed from: a, reason: collision with root package name */
    final HippyEngineContext f337025a;

    /* renamed from: b, reason: collision with root package name */
    final HippyBundleLoader f337026b;

    /* renamed from: c, reason: collision with root package name */
    HippyBridge f337027c;

    /* renamed from: e, reason: collision with root package name */
    Handler f337029e;

    /* renamed from: f, reason: collision with root package name */
    final int f337030f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f337031g;

    /* renamed from: i, reason: collision with root package name */
    HippyEngine.ModuleListener f337033i;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f337034k;

    /* renamed from: l, reason: collision with root package name */
    private final String f337035l;

    /* renamed from: m, reason: collision with root package name */
    private final int f337036m;

    /* renamed from: n, reason: collision with root package name */
    private final HippyThirdPartyAdapter f337037n;

    /* renamed from: o, reason: collision with root package name */
    private StringBuilder f337038o;

    /* renamed from: p, reason: collision with root package name */
    private d f337039p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.mtt.hippy.c.c.b.c f337040q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.mtt.hippy.c.a.b f337041r;

    /* renamed from: s, reason: collision with root package name */
    private com.tencent.mtt.hippy.c.d.b f337042s;

    /* renamed from: t, reason: collision with root package name */
    private TurboModuleManager f337043t;

    /* renamed from: u, reason: collision with root package name */
    private HippyEngine.V8InitParams f337044u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    private NativeCallback f337045v;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f337028d = false;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<String> f337032h = null;

    /* renamed from: w, reason: collision with root package name */
    private final AtomicInteger f337046w = new AtomicInteger(0);

    public b(HippyEngineContext hippyEngineContext, HippyBundleLoader hippyBundleLoader, int i3, boolean z16, boolean z17, String str, int i16, HippyThirdPartyAdapter hippyThirdPartyAdapter, HippyEngine.V8InitParams v8InitParams) {
        this.f337025a = hippyEngineContext;
        this.f337026b = hippyBundleLoader;
        this.f337030f = i3;
        this.f337034k = z17;
        this.f337035l = str;
        this.f337036m = i16;
        this.f337037n = hippyThirdPartyAdapter;
        this.f337031g = z16;
        this.f337044u = v8InitParams;
        if (z16) {
            this.f337041r = new com.tencent.mtt.hippy.c.a.b();
            this.f337042s = new com.tencent.mtt.hippy.c.d.b();
        } else {
            this.f337038o = new StringBuilder(1024);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        if (this.f337025a.getGlobalConfigs() != null && this.f337025a.getGlobalConfigs().enableTurbo()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public long b() {
        HippyBridge hippyBridge;
        if (!this.f337028d || (hippyBridge = this.f337027c) == null) {
            return -1L;
        }
        return hippyBridge.getV8RuntimeId();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0004. Please report as an issue. */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        final HippyRootView hippyRootView;
        try {
        } catch (Throwable th5) {
            a(th5);
        }
        switch (message.what) {
            case 10:
                this.f337025a.getStartTimeMonitor().startEvent(HippyEngineMonitorEvent.ENGINE_LOAD_EVENT_INIT_BRIDGE);
                final Callback callback = (Callback) message.obj;
                try {
                    HippyEngineContext hippyEngineContext = this.f337025a;
                    if (this.f337030f == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    HippyBridgeImpl hippyBridgeImpl = new HippyBridgeImpl(hippyEngineContext, this, z16, this.f337031g, this.f337034k, this.f337035l, this.f337044u);
                    this.f337027c = hippyBridgeImpl;
                    hippyBridgeImpl.initJSBridge(c(), new NativeCallback(this.f337029e) { // from class: com.tencent.mtt.hippy.bridge.b.3
                        @Override // com.tencent.mtt.hippy.bridge.NativeCallback
                        public void Call(long j3, Message message2, String str, String str2) {
                            if (j3 != 0) {
                                RuntimeException runtimeException = new RuntimeException("initJSBridge error: result=" + j3 + ", reason=" + str2);
                                Callback callback2 = callback;
                                if (callback2 != null) {
                                    callback2.callback(Boolean.FALSE, runtimeException);
                                    return;
                                }
                                return;
                            }
                            if (b.this.e()) {
                                b bVar = b.this;
                                bVar.f337043t = new TurboModuleManager(bVar.f337025a);
                                b.this.f337043t.install(b.this.f337027c.getV8RuntimeId());
                            }
                            if (b.this.f337037n != null) {
                                b.this.f337037n.onRuntimeInit(b.this.f337027c.getV8RuntimeId());
                            }
                            b.this.f337025a.getStartTimeMonitor().startEvent(HippyEngineMonitorEvent.ENGINE_LOAD_EVENT_LOAD_COMMONJS);
                            b.this.f337028d = true;
                            b bVar2 = b.this;
                            HippyBundleLoader hippyBundleLoader = bVar2.f337026b;
                            if (hippyBundleLoader != null) {
                                hippyBundleLoader.load(bVar2.f337027c, new NativeCallback(bVar2.f337029e) { // from class: com.tencent.mtt.hippy.bridge.b.3.1
                                    @Override // com.tencent.mtt.hippy.bridge.NativeCallback
                                    public void Call(long j16, Message message3, String str3, String str4) {
                                        boolean z17;
                                        RuntimeException runtimeException2;
                                        if (j16 == 0) {
                                            z17 = true;
                                        } else {
                                            z17 = false;
                                        }
                                        if (!z17) {
                                            runtimeException2 = new RuntimeException("load coreJsBundle failed, check your core jsBundle:" + str4);
                                        } else {
                                            runtimeException2 = null;
                                        }
                                        callback.callback(Boolean.valueOf(z17), runtimeException2);
                                    }
                                });
                            } else {
                                callback.callback(Boolean.valueOf(bVar2.f337028d), null);
                            }
                        }
                    }, this.f337036m);
                } catch (Throwable th6) {
                    this.f337028d = false;
                    callback.callback(Boolean.FALSE, th6);
                }
                return true;
            case 11:
                int i3 = message.arg2;
                if (i3 > 0) {
                    hippyRootView = this.f337025a.getInstance(i3);
                    if (hippyRootView != null && hippyRootView.getTimeMonitor() != null) {
                        hippyRootView.getTimeMonitor().startEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_LOAD_BUNDLE);
                    }
                } else {
                    hippyRootView = null;
                }
                HippyBundleLoader hippyBundleLoader = (HippyBundleLoader) message.obj;
                if (!this.f337028d) {
                    a(HippyEngine.ModuleLoadStatus.STATUS_ENGINE_UNINIT, "load module error. HippyBridge mIsInit:" + this.f337028d, (HippyRootView) null);
                    return true;
                }
                if (hippyBundleLoader == null) {
                    a(HippyEngine.ModuleLoadStatus.STATUS_VARIABLE_NULL, "load module error. loader:" + ((Object) null), (HippyRootView) null);
                    return true;
                }
                String bundleUniKey = hippyBundleLoader.getBundleUniKey();
                if (this.f337032h != null && !TextUtils.isEmpty(bundleUniKey) && this.f337032h.contains(bundleUniKey)) {
                    a(HippyEngine.ModuleLoadStatus.STATUS_REPEAT_LOAD, "repeat load module. loader.getBundleUniKey=" + bundleUniKey, hippyRootView);
                    return true;
                }
                if (!TextUtils.isEmpty(bundleUniKey)) {
                    if (this.f337032h == null) {
                        this.f337032h = new ArrayList<>();
                    }
                    this.f337032h.add(bundleUniKey);
                    hippyBundleLoader.load(this.f337027c, new NativeCallback(this.f337029e) { // from class: com.tencent.mtt.hippy.bridge.b.4
                        @Override // com.tencent.mtt.hippy.bridge.NativeCallback
                        public void Call(long j3, Message message2, String str, String str2) {
                            if (j3 == 0) {
                                b.this.a(HippyEngine.ModuleLoadStatus.STATUS_OK, (String) null, hippyRootView);
                            } else {
                                b.this.a(HippyEngine.ModuleLoadStatus.STATUS_ERR_RUN_BUNDLE, "load module error. loader.load failed. check the file!!", (HippyRootView) null);
                            }
                        }
                    });
                } else {
                    a(HippyEngine.ModuleLoadStatus.STATUS_VARIABLE_NULL, "can not load module. loader.getBundleUniKey=null", (HippyRootView) null);
                }
                return true;
            case 12:
                if (this.f337028d) {
                    a(message);
                }
                return true;
            case 13:
                c(message);
                return true;
            case 14:
                if (this.f337028d) {
                    b(message);
                }
                return true;
            default:
                return false;
        }
    }

    private boolean d() {
        return (this.f337025a.getGlobalConfigs().getContext().getResources().getConfiguration().uiMode & 48) == 32;
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void b(int i3) {
        if (this.f337028d) {
            this.f337029e.sendMessage(this.f337029e.obtainMessage(12, 0, 3, Integer.valueOf(i3)));
        }
    }

    String c() {
        String str;
        String str2;
        String str3;
        Context context = this.f337025a.getGlobalConfigs().getContext();
        if (!f337024j && context == null) {
            throw new AssertionError();
        }
        HippyMap hippyMap = new HippyMap();
        HippyMap dimensions = DimensionsUtil.getDimensions(-1, -1, context, false);
        if (this.f337025a.getGlobalConfigs() != null && this.f337025a.getGlobalConfigs().getDeviceAdapter() != null) {
            this.f337025a.getGlobalConfigs().getDeviceAdapter().reviseDimensionIfNeed(context, dimensions, false, false);
        }
        hippyMap.pushMap("Dimensions", dimensions);
        HippyMap hippyMap2 = new HippyMap();
        HippyThirdPartyAdapter hippyThirdPartyAdapter = this.f337037n;
        if (hippyThirdPartyAdapter != null) {
            str = hippyThirdPartyAdapter.getPackageName();
            str2 = this.f337037n.getAppVersion();
            str3 = this.f337037n.getPageUrl();
            hippyMap2.pushJSONObject(this.f337037n.getExtraData());
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            if (TextUtils.isEmpty(str)) {
                str = packageInfo.packageName;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = packageInfo.versionName;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        HippyMap hippyMap3 = new HippyMap();
        hippyMap3.pushString(Global.TRACKING_OS, "android");
        hippyMap3.pushString("PackageName", str == null ? "" : str);
        hippyMap3.pushString("VersionName", str2 == null ? "" : str2);
        hippyMap3.pushInt("APILevel", Build.VERSION.SDK_INT);
        hippyMap3.pushBoolean("NightMode", d());
        hippyMap3.pushString("SDKVersion", BuildConfig.LIBRARY_VERSION);
        HippyMap hippyMap4 = new HippyMap();
        hippyMap4.pushString(IjkMediaMeta.IJKM_KEY_LANGUAGE, I18nUtil.getLanguage());
        hippyMap4.pushString("country", I18nUtil.getCountry());
        hippyMap4.pushInt("direction", I18nUtil.getLayoutDirection());
        hippyMap3.pushMap("Localization", hippyMap4);
        hippyMap.pushMap("Platform", hippyMap3);
        if (this.f337025a.getDevSupportManager().b()) {
            HippyMap hippyMap5 = new HippyMap();
            hippyMap5.pushString("debugClientId", this.f337025a.getDevSupportManager().c());
            hippyMap.pushMap(BuglyAppVersionMode.DEBUG, hippyMap5);
        }
        HippyMap hippyMap6 = new HippyMap();
        if (str3 == null) {
            str3 = "";
        }
        hippyMap6.pushString("url", str3);
        if (str == null) {
            str = "";
        }
        hippyMap6.pushString("appName", str);
        hippyMap6.pushString("appVersion", str2 != null ? str2 : "");
        hippyMap6.pushMap("extra", hippyMap2);
        hippyMap.pushMap(ComponentFactory.TDK, hippyMap6);
        return ArgumentUtils.objectToJson(hippyMap);
    }

    private void b(Message message) {
        this.f337027c.runScript((String) message.obj);
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void c(int i3) {
        if (this.f337028d) {
            this.f337029e.sendMessage(this.f337029e.obtainMessage(12, 0, 4, Integer.valueOf(i3)));
        }
    }

    private void c(Message message) {
        HippyThirdPartyAdapter hippyThirdPartyAdapter = this.f337037n;
        if (hippyThirdPartyAdapter != null) {
            hippyThirdPartyAdapter.onRuntimeDestroy();
        }
        final boolean z16 = message.arg1 == 1;
        final Callback callback = (Callback) message.obj;
        this.f337027c.destroy(new NativeCallback(this.f337029e) { // from class: com.tencent.mtt.hippy.bridge.b.2
            @Override // com.tencent.mtt.hippy.bridge.NativeCallback
            public void Call(long j3, Message message2, String str, String str2) {
                boolean z17;
                RuntimeException runtimeException;
                if (j3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                b.this.f337027c.onDestroy(z16);
                if (callback != null) {
                    if (!z17) {
                        runtimeException = new RuntimeException("destroy error: result=" + j3 + ", reason=" + str2);
                    } else {
                        runtimeException = null;
                    }
                    callback.callback(Boolean.valueOf(z17), runtimeException);
                }
                b.this.f337045v = null;
            }
        }, z16);
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a() {
        this.f337028d = false;
        this.f337033i = null;
        Handler handler = this.f337029e;
        if (handler != null) {
            handler.removeMessages(10);
            this.f337029e.removeMessages(11);
            this.f337029e.removeMessages(12);
            this.f337029e.removeMessages(14);
        }
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(int i3) {
        if (this.f337028d) {
            this.f337029e.sendMessage(this.f337029e.obtainMessage(12, 0, 2, Integer.valueOf(i3)));
        }
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(int i3, HippyBundleLoader hippyBundleLoader, HippyEngine.ModuleListener moduleListener, HippyRootView hippyRootView) {
        boolean z16 = this.f337028d;
        this.f337033i = moduleListener;
        if (!z16) {
            a(HippyEngine.ModuleLoadStatus.STATUS_ENGINE_UNINIT, "load module error. HippyBridge not initialized", hippyRootView);
        } else {
            this.f337029e.sendMessage(this.f337029e.obtainMessage(11, 0, i3, hippyBundleLoader));
        }
    }

    private void a(Message message) {
        String str;
        ByteBuffer byteBuffer;
        switch (message.arg2) {
            case 1:
                Object obj = message.obj;
                if (obj instanceof HippyMap) {
                    HippyRootView hippyEngineContext = this.f337025a.getInstance(((HippyMap) obj).getInt("id"));
                    if (hippyEngineContext != null) {
                        hippyEngineContext.startMonitorEvent(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RUN_BUNDLE);
                    }
                }
                str = "loadInstance";
                break;
            case 2:
                str = "resumeInstance";
                break;
            case 3:
                str = "pauseInstance";
                break;
            case 4:
                str = "destroyInstance";
                break;
            case 5:
                str = "callBack";
                break;
            case 6:
                str = "callJsModule";
                break;
            default:
                str = null;
                break;
        }
        String str2 = str;
        this.f337046w.incrementAndGet();
        if (this.f337046w.get() >= 20000) {
            HippyBridge hippyBridge = this.f337027c;
            String str3 = "handleCallFunction, project:" + (hippyBridge != null ? hippyBridge.getComponentName() : "unknown") + ", action:" + str2 + ", msg=" + message;
            if (this.f337025a.getGlobalConfigs().getLogAdapter() != null) {
                this.f337025a.getGlobalConfigs().getLogAdapter().onReceiveLogMessage(3, "HippyBridgeManagerImpl", str3);
            }
        }
        if (this.f337045v == null) {
            this.f337045v = new NativeCallback(this.f337029e) { // from class: com.tencent.mtt.hippy.bridge.b.1
                @Override // com.tencent.mtt.hippy.bridge.NativeCallback
                public void Call(long j3, Message message2, String str4, String str5) {
                    b.this.f337046w.decrementAndGet();
                    if (j3 != 0) {
                        b.this.a(new Throwable("CallFunction error: action=" + str4 + ", result=" + j3 + ", reason=" + str5));
                    }
                }
            };
        }
        com.tencent.mtt.hippy.c.d dVar = message.obj instanceof i ? this.f337042s : this.f337041r;
        if (message.arg1 != HippyEngine.BridgeTransferType.BRIDGE_TRANSFER_TYPE_NIO.value()) {
            if (!this.f337031g) {
                this.f337038o.setLength(0);
                this.f337027c.callFunction(str2, this.f337045v, ArgumentUtils.objectToJsonOpt(message.obj, this.f337038o).getBytes(StandardCharsets.UTF_16LE));
                return;
            }
            d dVar2 = this.f337039p;
            if (dVar2 == null) {
                this.f337039p = new d();
            } else {
                dVar2.b();
            }
            dVar.a((com.tencent.mtt.hippy.c.c.b.b) this.f337039p);
            dVar.a();
            dVar.b();
            dVar.a(message.obj);
            ByteBuffer a16 = this.f337039p.a();
            this.f337027c.callFunction(str2, this.f337045v, a16.array(), a16.arrayOffset() + a16.position(), a16.limit() - a16.position());
            return;
        }
        if (this.f337031g) {
            com.tencent.mtt.hippy.c.c.b.c cVar = this.f337040q;
            if (cVar == null) {
                this.f337040q = new com.tencent.mtt.hippy.c.c.b.c(1024, 0);
            } else {
                cVar.b();
            }
            dVar.a((com.tencent.mtt.hippy.c.c.b.b) this.f337040q);
            dVar.a();
            dVar.b();
            dVar.a(message.obj);
            byteBuffer = this.f337040q.a();
        } else {
            this.f337038o.setLength(0);
            byte[] bytes = ArgumentUtils.objectToJsonOpt(message.obj, this.f337038o).getBytes(StandardCharsets.UTF_16LE);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
            allocateDirect.put(bytes);
            byteBuffer = allocateDirect;
        }
        this.f337027c.callFunction(str2, this.f337045v, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final HippyEngine.ModuleLoadStatus moduleLoadStatus, final String str, final HippyRootView hippyRootView) {
        if (!UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.bridge.b.6
                @Override // java.lang.Runnable
                public void run() {
                    HippyEngine.ModuleListener moduleListener = b.this.f337033i;
                    if (moduleListener != null) {
                        moduleListener.onLoadCompleted(moduleLoadStatus, str, hippyRootView);
                    }
                }
            });
            return;
        }
        HippyEngine.ModuleListener moduleListener = this.f337033i;
        if (moduleListener != null) {
            moduleListener.onLoadCompleted(moduleLoadStatus, str, hippyRootView);
        }
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(Callback<Boolean> callback) {
        Handler handler = new Handler(this.f337025a.getThreadExecutor().getJsThread().getLooper(), this);
        this.f337029e = handler;
        this.f337029e.sendMessage(handler.obtainMessage(10, callback));
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(Callback<Boolean> callback, boolean z16) {
        if (!f337024j && this.f337029e == null) {
            throw new AssertionError();
        }
        Handler handler = this.f337029e;
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(13, callback);
        obtainMessage.arg1 = z16 ? 1 : 0;
        this.f337029e.sendMessage(obtainMessage);
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(final HippyJsException hippyJsException) {
        if (!UIThreadUtils.isOnUiThread()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.bridge.b.5
                @Override // java.lang.Runnable
                public void run() {
                    HippyEngine.ModuleListener moduleListener = b.this.f337033i;
                    if (moduleListener != null && moduleListener.onJsException(hippyJsException)) {
                        b.this.f337033i = null;
                    }
                }
            });
            return;
        }
        HippyEngine.ModuleListener moduleListener = this.f337033i;
        if (moduleListener == null || !moduleListener.onJsException(hippyJsException)) {
            return;
        }
        this.f337033i = null;
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(Object obj, HippyEngine.BridgeTransferType bridgeTransferType) {
        this.f337029e.sendMessage(this.f337029e.obtainMessage(12, bridgeTransferType.value(), 5, obj));
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(String str) {
        Handler handler;
        if (!this.f337028d || (handler = this.f337029e) == null) {
            return;
        }
        this.f337029e.sendMessage(handler.obtainMessage(14, str));
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(String str, int i3, HippyMap hippyMap) {
        if (this.f337028d) {
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushString("name", str);
            hippyMap2.pushInt("id", i3);
            hippyMap2.pushMap("params", hippyMap);
            this.f337029e.sendMessage(this.f337029e.obtainMessage(12, 0, 1, hippyMap2));
            this.f337025a.getDevSupportManager().d().a(str);
        }
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge.a
    public void a(String str, String str2) {
        HippyEngineContext hippyEngineContext = this.f337025a;
        if (hippyEngineContext == null) {
            return;
        }
        hippyEngineContext.handleException(new HippyJsException(str, str2));
    }

    @Override // com.tencent.mtt.hippy.bridge.a
    public void a(String str, String str2, Object obj, HippyEngine.BridgeTransferType bridgeTransferType) {
        if (this.f337028d) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("moduleName", str);
            hippyMap.pushString("methodName", str2);
            hippyMap.pushObject("params", obj);
            this.f337029e.sendMessage(this.f337029e.obtainMessage(12, bridgeTransferType.value(), 6, hippyMap));
        }
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge.a
    public void a(String str, String str2, String str3, Object obj) {
        HippyModuleManager moduleManager;
        HippyEngineContext hippyEngineContext = this.f337025a;
        if (hippyEngineContext == null || (moduleManager = hippyEngineContext.getModuleManager()) == null) {
            return;
        }
        moduleManager.callNatives(HippyCallNativeParams.obtain(str, str2, str3, obj));
    }

    @Override // com.tencent.mtt.hippy.bridge.HippyBridge.a
    public void a(Throwable th5) {
        HippyEngineContext hippyEngineContext = this.f337025a;
        if (hippyEngineContext == null || th5 == null) {
            return;
        }
        hippyEngineContext.handleException(th5);
    }
}
