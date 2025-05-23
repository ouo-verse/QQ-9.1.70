package com.tencent.mtt.hippy.modules.nativemodules.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.netinfo.NetInfoModule;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
@HippyNativeModule(name = "NetInfo")
/* loaded from: classes20.dex */
public class NetInfoModule extends HippyNativeModuleBase {

    /* renamed from: a, reason: collision with root package name */
    private a f337514a;

    /* renamed from: b, reason: collision with root package name */
    private final ConnectivityManager f337515b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f337516c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        private final String f337518b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f337519c;

        /* renamed from: d, reason: collision with root package name */
        private String f337520d;

        /* renamed from: e, reason: collision with root package name */
        private Context f337521e;

        a() {
            this.f337518b = "networkStatusDidChange";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            String a16 = NetInfoModule.this.a();
            if (!a16.equalsIgnoreCase(this.f337520d)) {
                try {
                    this.f337520d = a16;
                    HippyMap hippyMap = new HippyMap();
                    hippyMap.pushString("network_info", this.f337520d);
                    ((EventDispatcher) ((HippyNativeModuleBase) NetInfoModule.this).mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("networkStatusDidChange", hippyMap);
                } catch (Throwable th5) {
                    LogUtils.d("NetInfoModule", "onReceive sendEvent: ", th5);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                try {
                    ((HippyNativeModuleBase) NetInfoModule.this).mContext.getGlobalConfigs().getExecutorSupplierAdapter().getBackgroundTaskExecutor().execute(new Runnable() { // from class: com.tencent.mtt.hippy.modules.nativemodules.netinfo.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            NetInfoModule.a.this.b();
                        }
                    });
                } catch (RejectedExecutionException e16) {
                    LogUtils.d("NetInfoModule", "onReceive execute: ", e16);
                }
            }
        }

        void a() {
            Context context;
            if (this.f337519c && (context = this.f337521e) != null) {
                context.unregisterReceiver(this);
                this.f337521e = null;
            }
        }

        void a(Context context) {
            if (this.f337519c) {
                return;
            }
            this.f337521e = context;
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this, intentFilter);
                this.f337519c = true;
            }
        }
    }

    public NetInfoModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337516c = false;
        this.f337515b = (ConnectivityManager) hippyEngineContext.getGlobalConfigs().getContext().getSystemService("connectivity");
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        c();
    }

    @HippyMethod(name = "getCurrentConnectivity")
    public void getCurrentConnectivity(Promise promise) {
        if (this.f337516c) {
            promise.reject("To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
            return;
        }
        String a16 = a();
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("network_info", a16);
        promise.resolve(hippyMap);
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void handleAddListener(String str) {
        b();
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void handleRemoveListener(String str) {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = "UNKNOWN";
        try {
            NetworkInfo activeNetworkInfo = this.f337515b.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (!ConnectivityManager.isNetworkTypeValid(NetworkMonitor.getType(activeNetworkInfo))) {
                    return "UNKNOWN";
                }
                str = NetworkMonitor.getTypeName(activeNetworkInfo).toUpperCase();
                return str;
            }
            return "NONE";
        } catch (Exception unused) {
            this.f337516c = true;
            return str;
        }
    }

    private void b() {
        if (this.f337514a == null) {
            this.f337514a = new a();
        }
        try {
            this.f337514a.a(this.mContext.getGlobalConfigs().getContext());
        } catch (Throwable th5) {
            LogUtils.d("NetInfoModule", "registerReceiver: " + th5.getMessage());
        }
    }

    private void c() {
        try {
            a aVar = this.f337514a;
            if (aVar != null) {
                aVar.a();
                this.f337514a = null;
            }
        } catch (Throwable th5) {
            LogUtils.d("NetInfoModule", "unregisterReceiver: " + th5.getMessage());
        }
    }
}
