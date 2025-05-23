package nm0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ams.dynamic.IDynamicApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f420450b;

    /* renamed from: a, reason: collision with root package name */
    private volatile a f420451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a implements AdIPCManager.Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Context> f420452a;

        a(WeakReference<Context> weakReference) {
            this.f420452a = weakReference;
            AdIPCManager.getInstance().register("GDT_MOTIVE_HIPPY_PRE_DOWNLOADER", this);
        }

        public void a() {
            Context context;
            WeakReference<Context> weakReference = this.f420452a;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            if (context != null) {
                QLog.i("GdtMotiveHippyPreDownloader ", 1, "[IPCHandler][doPreDownload] start");
                Bundle bundle = new Bundle();
                bundle.putString(AdIPCManager.Params.KEY_ACTION, "GDT_MOTIVE_HIPPY_PRE_DOWNLOADER");
                bundle.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getMainProcessName());
                bundle.putString("METHOD", "DO_PRE_DOWNLOAD");
                AdIPCManager.Result send = AdIPCManager.getInstance().send(context, new AdIPCManager.Params(bundle));
                if (send != null && send.success) {
                    QLog.i("GdtMotiveHippyPreDownloader ", 1, "[IPCHandler][doPreDownload] success");
                }
            }
            QLog.e("GdtMotiveHippyPreDownloader ", 1, "[IPCHandler][doPreDownload] error");
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        public AdIPCManager.Result handle(AdIPCManager.Params params) {
            Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
            if (isOnMainProcess != null && isOnMainProcess.booleanValue() && params != null && params.bundle != null) {
                AdIPCManager.Result result = new AdIPCManager.Result();
                String string = params.bundle.getString("METHOD");
                if (TextUtils.isEmpty(string)) {
                    QLog.e("GdtMotiveHippyPreDownloader ", 1, "[IPCHandler][handle] error, method is empty");
                    return null;
                }
                if (string.equals("DO_PRE_DOWNLOAD")) {
                    b.c().f();
                    result.success = true;
                }
                QLog.i("GdtMotiveHippyPreDownloader ", 1, "[IPCHandler][handle] result:" + result.success);
                return result;
            }
            QLog.e("GdtMotiveHippyPreDownloader ", 1, "[IPCHandler][handle] error, not valid");
            return null;
        }
    }

    b() {
    }

    public static b c() {
        if (f420450b == null) {
            synchronized (b.class) {
                if (f420450b == null) {
                    f420450b = new b();
                }
            }
        }
        return f420450b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        if (this.f420451a != null) {
            this.f420451a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
        if (isOnMainProcess != null && isOnMainProcess.booleanValue()) {
            if (!c.a().c()) {
                QLog.i("GdtMotiveHippyPreDownloader ", 1, "[preDownloadOnlyInMainProcess] error, isEnablePreDownload == false");
                return;
            }
            QLog.i("GdtMotiveHippyPreDownloader ", 1, "[preDownloadOnlyInMainProcess]");
            ((IDynamicApi) QRoute.api(IDynamicApi.class)).initDynamicSDK();
            c.a().b();
            return;
        }
        QLog.e("GdtMotiveHippyPreDownloader ", 1, "[preDownloadOnlyInMainProcess] error, isOnMainProcess == null");
    }

    public void e() {
        Boolean isOnMainProcess = AdProcessManager.getInstance().isOnMainProcess();
        if (isOnMainProcess == null) {
            AdLog.e("GdtMotiveHippyPreDownloader ", "update isOnMainProcess == null");
        } else if (!isOnMainProcess.booleanValue()) {
            AdThreadManager.getInstance().post(new Runnable() { // from class: nm0.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.d();
                }
            }, 3);
        } else {
            f();
        }
    }

    public void g(Context context) {
        this.f420451a = new a(new WeakReference(context));
    }
}
