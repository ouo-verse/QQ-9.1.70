package com.tencent.mobileqq.teamwork.app;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.teamwork.ProcessOpenDocsPerformanceData;
import com.tencent.mobileqq.teamwork.api.ITDocWebIPCModuleApi;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f291959d;

    /* renamed from: e, reason: collision with root package name */
    private b f291960e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements EIPCOnGetConnectionListener {
        a() {
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            QLog.i(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, 1, "onConnectBind");
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            QLog.i(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, 1, "onConnectUnbind");
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    interface b {
        EIPCResult a(QIPCModule qIPCModule, String str, Bundle bundle, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static r f291962a = new r();
    }

    public r() {
        super(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME);
        this.f291959d = new AtomicBoolean(false);
    }

    public static r b() {
        return c.f291962a;
    }

    public void c(String str, int i3, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", str);
        bundle.putInt("key_error_code", i3);
        bundle.putString("key_error_msg", str2);
        QIPCClientHelper.getInstance().callServer(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_SERVER_NAME, ITDocWebIPCModuleApi.ACTION_NOTIFY_OPEN_FILE_RESULT, bundle, null);
    }

    public void d(String str, ProcessOpenDocsPerformanceData processOpenDocsPerformanceData) {
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", str);
        bundle.putParcelable(ITDocWebIPCModuleApi.KEY_PERFORMANCE_DATA, processOpenDocsPerformanceData);
        QIPCClientHelper.getInstance().callServer(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_SERVER_NAME, ITDocWebIPCModuleApi.ACTION_OPEN_PERFORMANCE_DATA, bundle, null);
    }

    public void e(b bVar) {
        Log.d(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, "register actionHandler:" + bVar);
        this.f291960e = bVar;
    }

    public void f(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(ITDocWebIPCModuleApi.KEY_JS_API_NAME_SPACE, str);
        bundle.putString(ITDocWebIPCModuleApi.KEY_JS_API_METHOD, str2);
        bundle.putString(ITDocWebIPCModuleApi.KEY_JS_API_ARGS, str3);
        QIPCClientHelper.getInstance().callServer(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_SERVER_NAME, ITDocWebIPCModuleApi.ACTION_SEND_JS_API, bundle, null);
    }

    public void g(b bVar) {
        Log.d(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, "unRegister actionHandler:" + bVar);
        if (this.f291960e == bVar) {
            this.f291960e = null;
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        Log.d(ITDocWebIPCModuleApi.IPC_MODULE_TDOC_WEB_CLIENT_NAME, "receive action: " + str);
        b bVar = this.f291960e;
        if (bVar != null) {
            return bVar.a(this, str, bundle, i3);
        }
        return EIPCResult.UNKNOW_RESULT;
    }

    public void register() {
        if (!this.f291959d.compareAndSet(false, true)) {
            return;
        }
        QIPCClientHelper.getInstance().register(this);
        QIPCClientHelper.getInstance().getClient().addListener(new a());
    }
}
