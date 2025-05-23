package ci3;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lci3/a;", "", "", "scene", "url", "Ljava/io/File;", "downloadFile", "Lci3/a$a;", "listener", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f30972a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lci3/a$a;", "", "", "isSuccess", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ci3.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public interface InterfaceC0194a {
        void onResult(boolean isSuccess);
    }

    a() {
    }

    public final void a(String scene, String url, File downloadFile, InterfaceC0194a listener) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(downloadFile, "downloadFile");
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i("ZPlanImageDownloadHelper", 1, "scene: " + scene + ", downloadImage url = " + url);
        b bVar = new b(downloadFile, listener);
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = bVar;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mReqUrl = url;
        httpNetReq.mOutPath = downloadFile.getAbsolutePath();
        httpNetReq.mPrioty = 1;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ZPlanImageDownloadHelper", 1, "download fail, appRuntime null.");
            listener.onResult(false);
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IHttpEngineService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        ((IHttpEngineService) runtimeService).sendReq(httpNetReq);
        QLog.i("ZPlanImageDownloadHelper", 1, "start download image " + url);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"ci3/a$b", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f30973d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InterfaceC0194a f30974e;

        b(File file, InterfaceC0194a interfaceC0194a) {
            this.f30973d = file;
            this.f30974e = interfaceC0194a;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp resp) {
            Integer valueOf = resp != null ? Integer.valueOf(resp.mResult) : null;
            QLog.i("ZPlanImageDownloadHelper", 1, "downloadImage onResp " + valueOf + " path=" + this.f30973d.getAbsolutePath());
            if (resp != null && resp.mResult == 3) {
                return;
            }
            if ((resp != null && resp.mResult == 0) && this.f30973d.exists()) {
                this.f30974e.onResult(true);
            } else {
                this.f30973d.delete();
                this.f30974e.onResult(false);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq req, long curOffset, long totalLen) {
        }
    }
}
