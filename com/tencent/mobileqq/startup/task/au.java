package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/startup/task/au;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "c", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class au extends NtTask {
    static IPatchRedirector $redirector_;

    public au() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c() {
        com.tencent.mobileqq.qdispatchqueue.d.g(new com.tencent.mobileqq.qdispatchqueue.e() { // from class: com.tencent.mobileqq.startup.task.as
            @Override // com.tencent.mobileqq.qdispatchqueue.e
            public final void a(Runnable runnable, long j3) {
                au.d(runnable, j3);
            }
        }, new Executor() { // from class: com.tencent.mobileqq.startup.task.at
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                au.e(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Runnable runnable, long j3) {
        ThreadManagerV2.executeDelay(runnable, 16, null, false, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Runnable runnable) {
        ThreadManagerV2.excute(runnable, 16, null, false);
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ThreadManagerV2.init();
        c();
    }
}
