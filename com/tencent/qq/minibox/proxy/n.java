package com.tencent.qq.minibox.proxy;

import com.tencent.minibox.proxy.ExecutorProxy;
import com.tencent.minibox.proxy.HostInfoProxy;
import com.tencent.minibox.proxy.HostNotifyProxy;
import com.tencent.minibox.proxy.IDownloadCallback;
import com.tencent.minibox.proxy.LogProxy;
import com.tencent.minibox.proxy.MiniBoxGameUpgradeProxy;
import com.tencent.minibox.proxy.MiniBoxProxy;
import com.tencent.minibox.proxy.ReportProxy;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IAppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0014\u0010\u0019\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qq/minibox/proxy/n;", "Lcom/tencent/minibox/proxy/MiniBoxProxy;", "", "url", "targetPath", "Lcom/tencent/minibox/proxy/IDownloadCallback;", "callback", "", "downloadFile", "Lcom/tencent/minibox/proxy/HostInfoProxy;", "getHostInfoProxy", "Lcom/tencent/minibox/proxy/HostNotifyProxy;", "getHostNotifyProxy", "Lcom/tencent/minibox/proxy/ExecutorProxy;", "getExecutorProxy", "Lcom/tencent/minibox/proxy/LogProxy;", "getLogProxy", "Lcom/tencent/minibox/proxy/MiniBoxGameUpgradeProxy;", "getMiniBoxGameUpgradeProxy", "Lcom/tencent/qq/minibox/proxy/q;", "a", "Lcom/tencent/minibox/proxy/ReportProxy;", "getReportProxy", "getUin", "Lcom/tencent/qq/minibox/proxy/q;", "mPermissionProxy", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class n implements MiniBoxProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q mPermissionProxy = new q();

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    @NotNull
    /* renamed from: a, reason: from getter and merged with bridge method [inline-methods] */
    public q getPermissionProxy() {
        return this.mPermissionProxy;
    }

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    public void downloadFile(@NotNull String url, @NotNull String targetPath, @NotNull IDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(targetPath, "targetPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new a(url, targetPath, callback).c();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    @NotNull
    public ExecutorProxy getExecutorProxy() {
        return new b();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    @NotNull
    public HostInfoProxy getHostInfoProxy() {
        return new c();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    @NotNull
    public HostNotifyProxy getHostNotifyProxy() {
        return new HostNotifyProxyImpl();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    @NotNull
    public LogProxy getLogProxy() {
        return new g();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    @NotNull
    public MiniBoxGameUpgradeProxy getMiniBoxGameUpgradeProxy() {
        return new MiniBoxGameUpgradeProxyImpl();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    @NotNull
    public ReportProxy getReportProxy() {
        return new r();
    }

    @Override // com.tencent.minibox.proxy.MiniBoxProxy
    @NotNull
    public String getUin() {
        String account = ((IAppRuntime) QRoute.api(IAppRuntime.class)).getAccount();
        if (account == null) {
            return "";
        }
        return account;
    }
}
