package com.tencent.mobileqq.qcoroutine.framework;

import android.os.Handler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/DispatcherThread;", "Landroid/os/HandlerThread;", "Lkotlin/Function0;", "", "block", "d", "Landroid/os/Handler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class DispatcherThread extends BaseHandlerThread {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final DispatcherThread C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        DispatcherThread dispatcherThread = new DispatcherThread();
        C = dispatcherThread;
        dispatcherThread.start();
        handler = new Handler(dispatcherThread.getLooper());
    }

    DispatcherThread() {
        super("QCoroutine_Dispatcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public final void d(@NotNull final Function0<Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) block);
        } else {
            Intrinsics.checkNotNullParameter(block, "block");
            handler.post(new Runnable(block) { // from class: com.tencent.mobileqq.qcoroutine.framework.DispatcherThread$sam$java_lang_Runnable$0
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                private final /* synthetic */ Function0 f261787d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) block);
                    } else {
                        this.f261787d = block;
                    }
                }

                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Intrinsics.checkNotNullExpressionValue(this.f261787d.invoke(), "invoke(...)");
                }
            });
        }
    }
}
