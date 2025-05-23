package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class e {
    public static Scope a(Context context) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Scope) iPatchRedirector.redirect((short) 6, (Object) context);
        }
        return g.c().attach(context);
    }

    public static Context b(Context context, ImplicitContextKeyed implicitContextKeyed) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, (Object) context, (Object) implicitContextKeyed);
        }
        return implicitContextKeyed.storeInContext(context);
    }

    public static Runnable c(final Context context, final Runnable runnable) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Runnable) iPatchRedirector.redirect((short) 7, (Object) context, (Object) runnable);
        }
        return new Runnable() { // from class: com.tencent.opentelemetry.context.a
            @Override // java.lang.Runnable
            public final void run() {
                e.h(Context.this, runnable);
            }
        };
    }

    public static Callable d(final Context context, final Callable callable) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Callable) iPatchRedirector.redirect((short) 8, (Object) context, (Object) callable);
        }
        return new Callable() { // from class: com.tencent.opentelemetry.context.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e.i(Context.this, callable);
            }
        };
    }

    public static Executor e(final Context context, final Executor executor) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Executor) iPatchRedirector.redirect((short) 9, (Object) context, (Object) executor);
        }
        return new Executor() { // from class: com.tencent.opentelemetry.context.c
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                e.j(Context.this, executor, runnable);
            }
        };
    }

    public static ExecutorService f(Context context, ExecutorService executorService) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ExecutorService) iPatchRedirector.redirect((short) 10, (Object) context, (Object) executorService);
        }
        return new ContextExecutorService(context, executorService);
    }

    public static ScheduledExecutorService g(Context context, ScheduledExecutorService scheduledExecutorService) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ScheduledExecutorService) iPatchRedirector.redirect((short) 11, (Object) context, (Object) scheduledExecutorService);
        }
        return new ContextScheduledExecutorService(context, scheduledExecutorService);
    }

    public static /* synthetic */ void h(Context context, Runnable runnable) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) context, (Object) runnable);
            return;
        }
        Scope makeCurrent = context.makeCurrent();
        try {
            runnable.run();
            if (makeCurrent != null) {
                makeCurrent.close();
            }
        } catch (Throwable th5) {
            if (makeCurrent != null) {
                try {
                    makeCurrent.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }

    public static /* synthetic */ Object i(Context context, Callable callable) throws Exception {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, (Object) context, (Object) callable);
        }
        Scope makeCurrent = context.makeCurrent();
        try {
            Object call = callable.call();
            if (makeCurrent != null) {
                makeCurrent.close();
            }
            return call;
        } catch (Throwable th5) {
            if (makeCurrent != null) {
                try {
                    makeCurrent.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
            }
            throw th5;
        }
    }

    public static /* synthetic */ void j(Context context, Executor executor, Runnable runnable) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) context, (Object) executor, (Object) runnable);
        } else {
            executor.execute(context.wrap(runnable));
        }
    }

    public static Context k() {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Context) iPatchRedirector.redirect((short) 1);
        }
        Context current = g.c().current();
        if (current == null) {
            return m();
        }
        return current;
    }

    public static /* synthetic */ void l(Executor executor, Runnable runnable) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) executor, (Object) runnable);
        } else {
            executor.execute(k().wrap(runnable));
        }
    }

    public static Context m() {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2);
        }
        return ArrayBasedContext.root();
    }

    public static Executor n(final Executor executor) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Executor) iPatchRedirector.redirect((short) 3, (Object) executor);
        }
        return new Executor() { // from class: com.tencent.opentelemetry.context.b
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                e.l(executor, runnable);
            }
        };
    }

    public static ExecutorService o(ExecutorService executorService) {
        IPatchRedirector iPatchRedirector = Context.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ExecutorService) iPatchRedirector.redirect((short) 4, (Object) executorService);
        }
        return new CurrentContextExecutorService(executorService);
    }
}
