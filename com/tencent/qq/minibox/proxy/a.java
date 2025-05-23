package com.tencent.qq.minibox.proxy;

import com.tencent.minibox.proxy.IDownloadCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qq/minibox/proxy/a;", "", "", "c", "", "a", "Ljava/lang/String;", "mUrl", "b", "mTargetPath", "Lcom/tencent/minibox/proxy/IDownloadCallback;", "Lcom/tencent/minibox/proxy/IDownloadCallback;", "callback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/minibox/proxy/IDownloadCallback;)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mTargetPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IDownloadCallback callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qq/minibox/proxy/a$a", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDone", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qq.minibox.proxy.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9352a extends com.tencent.mobileqq.vip.f {
        C9352a() {
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(@NotNull com.tencent.mobileqq.vip.g task) {
            Intrinsics.checkNotNullParameter(task, "task");
            if (task.f313006d != 0) {
                IDownloadCallback iDownloadCallback = a.this.callback;
                int i3 = task.f313006d;
                String str = task.f313007e;
                Intrinsics.checkNotNullExpressionValue(str, "task.errMsg");
                iDownloadCallback.onDownloaded(i3, str);
                return;
            }
            a.this.callback.onDownloaded(0, a.this.mTargetPath);
        }
    }

    public a(@NotNull String mUrl, @NotNull String mTargetPath, @NotNull IDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(mUrl, "mUrl");
        Intrinsics.checkNotNullParameter(mTargetPath, "mTargetPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mUrl = mUrl;
        this.mTargetPath = mTargetPath;
        this.callback = callback;
    }

    public final void c() {
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(this.mUrl, new File(this.mTargetPath));
        gVar.u(new C9352a());
        ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.waitAppRuntime(null));
    }
}
