package com.tencent.aio.base.thread;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/base/thread/DisplayOperationThread;", "Ljava/lang/Thread;", "target", "Ljava/lang/Runnable;", "threadName", "", "(Ljava/lang/Runnable;Ljava/lang/String;)V", TencentLocation.RUN_MODE, "", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class DisplayOperationThread extends BaseThread {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisplayOperationThread(@NotNull Runnable target, @NotNull String threadName) {
        super(target);
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(threadName, "threadName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) target, (Object) threadName);
        } else {
            setName(threadName);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a.f69217b.b();
            super.run();
        }
    }
}
