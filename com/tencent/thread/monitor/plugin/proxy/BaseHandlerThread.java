package com.tencent.thread.monitor.plugin.proxy;

import android.os.HandlerThread;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.api.IReporter;
import com.tencent.thread.monitor.plugin.api.ProxyController;
import com.tencent.thread.monitor.plugin.manager.ProxyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/thread/monitor/plugin/proxy/BaseHandlerThread;", "Landroid/os/HandlerThread;", "name", "", "(Ljava/lang/String;)V", "priority", "", "(Ljava/lang/String;I)V", TencentLocation.RUN_MODE, "", "start", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public class BaseHandlerThread extends HandlerThread {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseHandlerThread(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) name);
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.run();
        if (ProxyController.INSTANCE.getEnabled()) {
            ProxyManager.removeThreadInfo(getId());
        }
    }

    @Override // java.lang.Thread
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            BaseHandlerThreadHelper.INSTANCE.callBeforeHandlerThreadStart(this);
            super.start();
        } catch (OutOfMemoryError e16) {
            ProxyController proxyController = ProxyController.INSTANCE;
            if (proxyController.getEnableOptimized()) {
                proxyController.trimThreads(true);
                super.start();
                IReporter iReporter = proxyController.getIReporter();
                if (iReporter != null) {
                    iReporter.reportFixOOM();
                }
            } else {
                throw e16;
            }
        }
        if (ProxyController.INSTANCE.getEnabled()) {
            ProxyManager.getOrPutThreadInfo(getId()).update(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseHandlerThread(@NotNull String name, int i3) {
        super(name, i3);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) name, i3);
    }
}
