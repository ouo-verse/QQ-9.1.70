package com.tencent.qqnt.qbasealbum.coroutine;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/coroutine/f;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "Landroid/os/HandlerThread;", "d", "Landroid/os/HandlerThread;", "refreshHandlerThread", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "refreshHandler", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
final class f implements Executor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HandlerThread refreshHandlerThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler refreshHandler;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("qbasealbum-db");
        this.refreshHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.refreshHandler = new Handler(baseHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@Nullable final Runnable command) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) command);
        } else {
            this.refreshHandler.post(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.coroutine.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.c(command);
                }
            });
        }
    }
}
