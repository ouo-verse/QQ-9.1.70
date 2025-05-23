package com.tencent.qqnt.kernel.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/kernel/utils/n;", "", "", "priority", "", "k", "Lkotlin/Function0;", "block", "f", "d", tl.h.F, "Landroid/os/HandlerThread;", "b", "Landroid/os/HandlerThread;", "handlerThread", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "chatHandler", "", "<set-?>", "Z", "j", "()Z", "isHighPriority", "<init>", "()V", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f359273a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HandlerThread handlerThread;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Handler chatHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isHighPriority;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f359273a = new n();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RecentThreadDispatcher", -10);
        handlerThread = baseHandlerThread;
        isHighPriority = true;
        baseHandlerThread.start();
        chatHandler = new Handler(handlerThread.getLooper());
    }

    n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void d(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Thread.currentThread(), handlerThread)) {
            block.invoke();
            return;
        }
        Handler handler = chatHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.qqnt.kernel.utils.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.e(Function0.this);
                }
            });
        }
    }

    public final void f(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Handler handler = chatHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.qqnt.kernel.utils.k
                @Override // java.lang.Runnable
                public final void run() {
                    n.g(Function0.this);
                }
            });
        }
    }

    public final void h(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) block);
            return;
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Handler handler = chatHandler;
        if (handler != null) {
            handler.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.qqnt.kernel.utils.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.i(Function0.this);
                }
            });
        }
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return isHighPriority;
    }

    public final void k(int priority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, priority);
            return;
        }
        QLog.i("RecentThreadDispatcher", 1, "setPriority: " + priority);
        isHighPriority = false;
        handlerThread.setPriority(priority);
    }
}
