package com.tencent.videocut.utils.thread;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/videocut/utils/thread/PriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "Ljava/lang/Runnable;", "r", "Ljava/lang/Thread;", "newThread", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "mNumber", "", "e", "Ljava/lang/String;", "mName", "", "f", "I", "mPriority", "<init>", "(Ljava/lang/String;I)V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class PriorityThreadFactory implements ThreadFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger mNumber;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String mName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mPriority;

    public PriorityThreadFactory(@NotNull String mName, int i3) {
        Intrinsics.checkNotNullParameter(mName, "mName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) mName, i3);
            return;
        }
        this.mName = mName;
        this.mPriority = i3;
        this.mNumber = new AtomicInteger();
    }

    @Override // java.util.concurrent.ThreadFactory
    @NotNull
    public Thread newThread(@NotNull final Runnable r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Thread) iPatchRedirector.redirect((short) 1, (Object) this, (Object) r16);
        }
        Intrinsics.checkNotNullParameter(r16, "r");
        final String str = this.mName + '-' + this.mNumber.getAndIncrement();
        return new BaseThread(r16, r16, str) { // from class: com.tencent.videocut.utils.thread.PriorityThreadFactory$newThread$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Runnable C;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r16, str);
                this.C = r16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, PriorityThreadFactory.this, r16, r16, str);
                }
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) {
                    i3 = PriorityThreadFactory.this.mPriority;
                    Process.setThreadPriority(i3);
                    super.run();
                    return;
                }
                iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        };
    }
}
