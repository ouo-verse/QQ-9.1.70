package com.tencent.gdtad.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class f implements AdIPCManager.Adapter {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private Map<String, AdIPCManager.Handler> f108460a = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f108461d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f108462e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f108463f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f108464h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AdIPCManager.Params f108465i;

        a(WeakReference weakReference, String str, String str2, String str3, AdIPCManager.Params params) {
            this.f108461d = weakReference;
            this.f108462e = str;
            this.f108463f = str2;
            this.f108464h = str3;
            this.f108465i = params;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult eIPCResult) {
            AdIPCManager.Callback callback;
            boolean z16;
            WeakReference weakReference = this.f108461d;
            Bundle bundle = null;
            if (weakReference != null) {
                callback = (AdIPCManager.Callback) weakReference.get();
            } else {
                callback = null;
            }
            Object[] objArr = new Object[4];
            boolean z17 = true;
            if (callback != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            objArr[1] = this.f108462e;
            objArr[2] = this.f108463f;
            objArr[3] = this.f108464h;
            GdtLog.i("GdtIPCAdapter", String.format("send.onCallback:%b action:%s from:%s to:%s", objArr));
            if (callback != null) {
                AdIPCManager.Result result = new AdIPCManager.Result();
                if (eIPCResult == null || !eIPCResult.isSuccess()) {
                    z17 = false;
                }
                result.success = z17;
                if (eIPCResult != null) {
                    bundle = eIPCResult.data;
                }
                result.bundle = bundle;
                callback.onCallback(this.f108465i, result);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f108467d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f108468e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f108469f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f108470h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AdIPCManager.Params f108471i;

        b(WeakReference weakReference, String str, String str2, String str3, AdIPCManager.Params params) {
            this.f108467d = weakReference;
            this.f108468e = str;
            this.f108469f = str2;
            this.f108470h = str3;
            this.f108471i = params;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(@Nullable EIPCResult eIPCResult) {
            AdIPCManager.Callback callback;
            boolean z16;
            WeakReference weakReference = this.f108467d;
            Bundle bundle = null;
            if (weakReference != null) {
                callback = (AdIPCManager.Callback) weakReference.get();
            } else {
                callback = null;
            }
            Object[] objArr = new Object[4];
            boolean z17 = true;
            if (callback != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            objArr[1] = this.f108468e;
            objArr[2] = this.f108469f;
            objArr[3] = this.f108470h;
            GdtLog.i("GdtIPCAdapter", String.format("send.onCallback:%b action:%s from:%s to:%s", objArr));
            if (callback != null) {
                AdIPCManager.Result result = new AdIPCManager.Result();
                if (eIPCResult == null || !eIPCResult.isSuccess()) {
                    z17 = false;
                }
                result.success = z17;
                if (eIPCResult != null) {
                    bundle = eIPCResult.data;
                }
                result.bundle = bundle;
                callback.onCallback(this.f108471i, result);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class c extends QIPCModule {

        /* renamed from: d, reason: collision with root package name */
        private static volatile c f108473d;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class a implements EIPCResultCallback {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AdIPCManager.Params f108474d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f108475e;

            a(AdIPCManager.Params params, int i3) {
                this.f108474d = params;
                this.f108475e = i3;
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(@Nullable EIPCResult eIPCResult) {
                Object[] objArr = new Object[3];
                boolean z16 = false;
                objArr[0] = this.f108474d.getAction();
                objArr[1] = this.f108474d.getToProcessName();
                if (eIPCResult != null && eIPCResult.isSuccess()) {
                    z16 = true;
                }
                objArr[2] = Boolean.valueOf(z16);
                GdtLog.i("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.onCallback action:%s to:%s success:%b", objArr));
                c.this.callbackResult(this.f108475e, eIPCResult);
            }
        }

        c(String str) {
            super(str);
        }

        public static c b() {
            if (f108473d == null) {
                synchronized (c.class) {
                    if (f108473d == null) {
                        f108473d = new c("gdt_ipc_async_module_client_to_server");
                    }
                }
            }
            return f108473d;
        }

        @Override // eipc.EIPCModule
        public void callbackResult(int i3, @Nullable EIPCResult eIPCResult) {
            boolean z16 = true;
            Object[] objArr = new Object[1];
            if (eIPCResult == null || !eIPCResult.isSuccess()) {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            GdtLog.i("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.callbackResult success:%b", objArr));
            super.callbackResult(i3, eIPCResult);
        }

        @Override // eipc.EIPCModule
        @Nullable
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            Bundle bundle2;
            AdIPCManager.Params params = new AdIPCManager.Params(bundle);
            int i16 = 0;
            GdtLog.i("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.onCall action:%s to:%s", params.getAction(), params.getToProcessName()));
            if (!TextUtils.isEmpty(str) && params.isValid() && TextUtils.equals(params.getAction(), str)) {
                String currentProcessName = AdProcessManager.getInstance().getCurrentProcessName(BaseApplication.getContext());
                AdIPCManager.Handler handler = AdIPCManager.getInstance().getHandler(str);
                if (TextUtils.equals(currentProcessName, params.getToProcessName())) {
                    if (handler != null) {
                        AdIPCManager.Result handle = handler.handle(params);
                        EIPCResult eIPCResult = new EIPCResult();
                        if (handle == null || !handle.success) {
                            i16 = -102;
                        }
                        eIPCResult.code = i16;
                        if (handle != null) {
                            bundle2 = handle.bundle;
                        } else {
                            bundle2 = null;
                        }
                        eIPCResult.data = bundle2;
                        callbackResult(i3, eIPCResult);
                    }
                } else {
                    QIPCServerHelper.getInstance().callClient(params.getToProcessName(), "gdt_ipc_module_server_to_client", params.getAction(), bundle, new a(params, i3));
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class d extends QIPCModule {

        /* renamed from: d, reason: collision with root package name */
        private static volatile d f108477d;

        d(String str) {
            super(str);
        }

        public static d b() {
            if (f108477d == null) {
                synchronized (c.class) {
                    if (f108477d == null) {
                        f108477d = new d("gdt_ipc_sync_module_client_to_server");
                    }
                }
            }
            return f108477d;
        }

        @Override // eipc.EIPCModule
        @Nullable
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            Boolean isOnMainProcess;
            AdIPCManager.Handler handler;
            AdIPCManager.Params params = new AdIPCManager.Params(bundle);
            int i16 = 0;
            GdtLog.i("GdtIPCAdapter", String.format("ClientToServerIPCSyncModule.onCall action:%s to:%s", params.getAction(), params.getToProcessName()));
            Bundle bundle2 = null;
            if (TextUtils.isEmpty(str) || !params.isValid() || !TextUtils.equals(params.getAction(), str) || (isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess()) == null || !isOnMainProcess.booleanValue() || !TextUtils.equals(AdProcessManager.getInstance().getCurrentProcessName(BaseApplication.getContext()), params.getToProcessName()) || (handler = AdIPCManager.getInstance().getHandler(str)) == null) {
                return null;
            }
            AdIPCManager.Result handle = handler.handle(params);
            EIPCResult eIPCResult = new EIPCResult();
            if (handle == null || !handle.success) {
                i16 = -102;
            }
            eIPCResult.code = i16;
            if (handle != null) {
                bundle2 = handle.bundle;
            }
            eIPCResult.data = bundle2;
            return eIPCResult;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class e extends QIPCModule {

        /* renamed from: d, reason: collision with root package name */
        private static volatile e f108478d;

        e(String str) {
            super(str);
        }

        public static e b() {
            if (f108478d == null) {
                synchronized (e.class) {
                    if (f108478d == null) {
                        f108478d = new e("gdt_ipc_module_server_to_client");
                    }
                }
            }
            return f108478d;
        }

        @Override // eipc.EIPCModule
        public void callbackResult(int i3, @Nullable EIPCResult eIPCResult) {
            boolean z16 = true;
            Object[] objArr = new Object[1];
            if (eIPCResult == null || !eIPCResult.isSuccess()) {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            GdtLog.i("GdtIPCAdapter", String.format("ServerToClientIPCModule.callbackResult success:%b", objArr));
            super.callbackResult(i3, eIPCResult);
        }

        @Override // eipc.EIPCModule
        @Nullable
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            AdIPCManager.Handler handler;
            Bundle bundle2;
            AdIPCManager.Params params = new AdIPCManager.Params(bundle);
            int i16 = 0;
            GdtLog.i("GdtIPCAdapter", String.format("ServerToClientIPCModule.onCall action:%s to:%s", params.getAction(), params.getToProcessName()));
            if (!TextUtils.isEmpty(str) && params.isValid() && TextUtils.equals(params.getAction(), str) && TextUtils.equals(AdProcessManager.getInstance().getCurrentProcessName(BaseApplication.getContext()), params.getToProcessName()) && (handler = AdIPCManager.getInstance().getHandler(str)) != null) {
                AdIPCManager.Result handle = handler.handle(params);
                EIPCResult eIPCResult = new EIPCResult();
                if (handle == null || !handle.success) {
                    i16 = -102;
                }
                eIPCResult.code = i16;
                if (handle != null) {
                    bundle2 = handle.bundle;
                } else {
                    bundle2 = null;
                }
                eIPCResult.data = bundle2;
                callbackResult(i3, eIPCResult);
            }
            return null;
        }
    }

    @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Adapter
    @Nullable
    public AdIPCManager.Handler getHandler(String str) {
        return this.f108460a.get(str);
    }

    @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Adapter
    public void init(Context context) {
        GdtLog.i("GdtIPCAdapter", "init");
        QIPCClientHelper.getInstance().register(e.b());
    }

    @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Adapter
    public boolean register(String str, @Nullable AdIPCManager.Handler handler) {
        boolean z16;
        if (TextUtils.isEmpty(str) || handler == null || this.f108460a.containsKey(str)) {
            z16 = false;
        } else {
            this.f108460a.put(str, handler);
            z16 = true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("register action:");
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        sb5.append("result:");
        sb5.append(z16);
        GdtLog.i("GdtIPCAdapter", sb5.toString());
        return z16;
    }

    @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Adapter
    @Nullable
    public AdIPCManager.Result send(Context context, @Nullable AdIPCManager.Params params) {
        String action = params != null ? params.getAction() : null;
        String toProcessName = params != null ? params.getToProcessName() : null;
        AdIPCManager.Handler handler = getHandler(action);
        String currentProcessName = AdProcessManager.getInstance().getCurrentProcessName(context);
        if (Looper.myLooper() != Looper.getMainLooper() && !TextUtils.isEmpty(currentProcessName) && handler != null && params != null && params.isValid()) {
            GdtLog.i("GdtIPCAdapter", String.format("send action:%s from:%s to:%s", action, currentProcessName, toProcessName));
            if (TextUtils.equals(currentProcessName, toProcessName)) {
                return handler.handle(params);
            }
            if (TextUtils.equals(AdProcessManager.getInstance().getMainProcessName(), toProcessName)) {
                EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "gdt_ipc_sync_module_client_to_server", action, params.bundle);
                AdIPCManager.Result result = new AdIPCManager.Result();
                result.success = callServer != null && callServer.isSuccess();
                result.bundle = callServer != null ? callServer.data : null;
                return result;
            }
            GdtLog.e("GdtIPCAdapter", String.format("send error action:%s from:%s to:%s", action, currentProcessName, toProcessName));
            return null;
        }
        GdtLog.e("GdtIPCAdapter", String.format("send error actionad:%s from:%s to:%s", action, currentProcessName, toProcessName));
        return null;
    }

    @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Adapter
    public void send(Context context, @Nullable AdIPCManager.Params params, @Nullable WeakReference<AdIPCManager.Callback> weakReference) {
        String action = params != null ? params.getAction() : null;
        String toProcessName = params != null ? params.getToProcessName() : null;
        AdIPCManager.Handler handler = getHandler(action);
        String currentProcessName = AdProcessManager.getInstance().getCurrentProcessName(context);
        if (!TextUtils.isEmpty(currentProcessName) && handler != null && params != null && params.isValid()) {
            GdtLog.i("GdtIPCAdapter", String.format("send action:%s from:%s to:%s", action, currentProcessName, toProcessName));
            if (TextUtils.equals(currentProcessName, toProcessName)) {
                AdIPCManager.Result handle = handler.handle(params);
                AdIPCManager.Callback callback = weakReference != null ? weakReference.get() : null;
                if (callback != null) {
                    callback.onCallback(params, handle);
                    return;
                }
                return;
            }
            if (TextUtils.equals(AdProcessManager.getInstance().getMainProcessName(), toProcessName)) {
                QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_async_module_client_to_server", action, params.bundle, new a(weakReference, action, currentProcessName, toProcessName, params));
                return;
            } else {
                QIPCClientHelper.getInstance().getClient().callServer("gdt_ipc_async_module_client_to_server", action, params.bundle, new b(weakReference, action, currentProcessName, toProcessName, params));
                return;
            }
        }
        GdtLog.e("GdtIPCAdapter", String.format("send error action:%s from:%s to:%s", action, currentProcessName, toProcessName));
    }
}
