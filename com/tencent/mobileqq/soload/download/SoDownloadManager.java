package com.tencent.mobileqq.soload.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.IFlowControlService;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J$\u0010\u000e\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/soload/download/SoDownloadManager;", "", "Lcom/tencent/mobileqq/soload/download/DownloadParam;", "downloadParam", "Lcom/tencent/mobileqq/vip/f;", "listener", "", "errCode", "", "e", "Landroid/os/Bundle;", "params", "dp", "f", h.F, "<init>", "()V", "a", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SoDownloadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<SoDownloadManager> f288656b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/soload/download/SoDownloadManager$a;", "", "Lcom/tencent/mobileqq/soload/download/SoDownloadManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/soload/download/SoDownloadManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "BUSINESS_CODE_QQ_SO", "Ljava/lang/String;", "TAG", "<init>", "()V", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.soload.download.SoDownloadManager$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final SoDownloadManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SoDownloadManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (SoDownloadManager) SoDownloadManager.f288656b.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/soload/download/SoDownloadManager$b", "Lcom/tencent/mobileqq/soload/api/IFlowControlService$OnFlowControlListener;", "", "code", "", "onSuccess", "", "nextTime", "onLimited", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements IFlowControlService.OnFlowControlListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f288658b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vip.f f288659c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DownloadParam f288660d;

        b(Bundle bundle, com.tencent.mobileqq.vip.f fVar, DownloadParam downloadParam) {
            this.f288658b = bundle;
            this.f288659c = fVar;
            this.f288660d = downloadParam;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SoDownloadManager.this, bundle, fVar, downloadParam);
            }
        }

        @Override // com.tencent.mobileqq.soload.api.IFlowControlService.OnFlowControlListener
        public void onLimited(int code, long nextTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(code), Long.valueOf(nextTime));
                return;
            }
            QLog.i("SoLoadWidget.SoDownloadManager", 1, "[onLimited] nextTime:" + nextTime + ",code:" + code);
            SoDownloadManager.this.e(this.f288660d, this.f288659c, code);
        }

        @Override // com.tencent.mobileqq.soload.api.IFlowControlService.OnFlowControlListener
        public void onSuccess(int code) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, code);
                return;
            }
            QLog.i("SoLoadWidget.SoDownloadManager", 1, "[onSuccess],code:" + code);
            SoDownloadManager.this.f(this.f288658b, this.f288659c, this.f288660d);
        }
    }

    static {
        Lazy<SoDownloadManager> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) SoDownloadManager$Companion$instance$2.INSTANCE);
        f288656b = lazy;
    }

    public SoDownloadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(DownloadParam downloadParam, com.tencent.mobileqq.vip.f listener, int errCode) {
        g gVar = new g(downloadParam.url, new File(downloadParam.filePath));
        gVar.f313006d = errCode;
        gVar.f313004c = downloadParam.url;
        if (listener != null) {
            listener.onDoneFile(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final Bundle params, final com.tencent.mobileqq.vip.f listener, final DownloadParam dp5) {
        QLog.i("SoLoadWidget.SoDownloadManager", 2, "[realDownload] downloadParam" + dp5);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.soload.download.c
            @Override // java.lang.Runnable
            public final void run() {
                SoDownloadManager.g(DownloadParam.this, listener, params);
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(DownloadParam dp5, com.tencent.mobileqq.vip.f fVar, Bundle bundle) {
        Intrinsics.checkNotNullParameter(dp5, "$dp");
        g gVar = new g(dp5.url, new File(dp5.filePath));
        gVar.S = "business_qqso";
        List<Pair<String, String>> list = dp5.headers;
        if (list != null) {
            for (Pair<String, String> pair : list) {
                if (pair != null) {
                    gVar.b(pair.first, pair.second);
                }
            }
        }
        gVar.f313000a = dp5.downloadPriority;
        com.tencent.mobileqq.vip.h downloader = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(dp5.downloaderType);
        if (downloader != null) {
            downloader.startDownload(gVar, fVar, bundle);
        }
    }

    public final void h(@Nullable DownloadParam dp5, @Nullable com.tencent.mobileqq.vip.f listener, @Nullable Bundle params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, dp5, listener, params);
            return;
        }
        if (dp5 != null && !TextUtils.isEmpty(dp5.url) && !TextUtils.isEmpty(dp5.filePath)) {
            QLog.i("SoLoadWidget.SoDownloadManager", 1, "[startDownload] url:" + dp5.url);
            ((IFlowControlService) QRoute.api(IFlowControlService.class)).reqSoFlowControl(dp5.url, new b(params, listener, dp5));
            return;
        }
        QLog.e("SoLoadWidget.SoDownloadManager", 1, "[startDownload] params invalid," + dp5);
    }
}
