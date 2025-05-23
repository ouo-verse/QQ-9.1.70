package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class ThreadLocalContextStorage implements ContextStorage {
    private static final /* synthetic */ ThreadLocalContextStorage[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final ThreadLocalContextStorage INSTANCE;
    private static final ThreadLocal<Context> THREAD_LOCAL_STORAGE;
    private static final Logger logger;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class NoopScope implements Scope {
        private static final /* synthetic */ NoopScope[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final NoopScope INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16289);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            NoopScope noopScope = new NoopScope("INSTANCE", 0);
            INSTANCE = noopScope;
            $VALUES = new NoopScope[]{noopScope};
        }

        NoopScope(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static NoopScope valueOf(String str) {
            return (NoopScope) Enum.valueOf(NoopScope.class, str);
        }

        public static NoopScope[] values() {
            return (NoopScope[]) $VALUES.clone();
        }

        @Override // com.tencent.opentelemetry.context.Scope, java.lang.AutoCloseable
        public void close() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16288);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ThreadLocalContextStorage threadLocalContextStorage = new ThreadLocalContextStorage("INSTANCE", 0);
        INSTANCE = threadLocalContextStorage;
        $VALUES = new ThreadLocalContextStorage[]{threadLocalContextStorage};
        logger = Logger.getLogger(ThreadLocalContextStorage.class.getName());
        THREAD_LOCAL_STORAGE = new ThreadLocal<>();
    }

    ThreadLocalContextStorage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attach$0(Context context, Context context2) {
        if (current() != context) {
            logger.log(Level.FINE, "Context in storage not the expected context, Scope.close was not called correctly");
        }
        THREAD_LOCAL_STORAGE.set(context2);
    }

    public static ThreadLocalContextStorage valueOf(String str) {
        return (ThreadLocalContextStorage) Enum.valueOf(ThreadLocalContextStorage.class, str);
    }

    public static ThreadLocalContextStorage[] values() {
        return (ThreadLocalContextStorage[]) $VALUES.clone();
    }

    @Override // com.tencent.opentelemetry.context.ContextStorage
    public Scope attach(final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Scope) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        if (context == null) {
            return NoopScope.INSTANCE;
        }
        final Context current = current();
        if (context == current) {
            return NoopScope.INSTANCE;
        }
        THREAD_LOCAL_STORAGE.set(context);
        return new Scope() { // from class: com.tencent.opentelemetry.context.n
            @Override // com.tencent.opentelemetry.context.Scope, java.lang.AutoCloseable
            public final void close() {
                ThreadLocalContextStorage.this.lambda$attach$0(context, current);
            }
        };
    }

    @Override // com.tencent.opentelemetry.context.ContextStorage
    @Nullable
    public Context current() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return THREAD_LOCAL_STORAGE.get();
    }
}
