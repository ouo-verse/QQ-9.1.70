package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.context.StrictContextStorage;
import com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap;
import com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
final class StrictContextStorage implements ContextStorage, AutoCloseable {
    static IPatchRedirector $redirector_;
    private static final Logger logger;
    private final ContextStorage delegate;
    private final PendingScopes pendingScopes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class CallerStackTrace extends Throwable {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 783294061323215387L;
        volatile boolean closed;
        final Context context;
        final long threadId;
        final String threadName;

        CallerStackTrace(Context context) {
            super("Thread [" + Thread.currentThread().getName() + "] opened scope for " + context + " here:");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            this.threadName = Thread.currentThread().getName();
            this.threadId = Thread.currentThread().getId();
            this.context = context;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static class PendingScopes extends WeakConcurrentMap<Scope, CallerStackTrace> {
        static IPatchRedirector $redirector_;
        private final ConcurrentHashMap<AbstractWeakConcurrentMap.WeakKey<Scope>, CallerStackTrace> map;

        PendingScopes(ConcurrentHashMap<AbstractWeakConcurrentMap.WeakKey<Scope>, CallerStackTrace> concurrentHashMap) {
            super(false, false, concurrentHashMap);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) concurrentHashMap);
                return;
            }
            this.map = concurrentHashMap;
            BaseThread baseThread = new BaseThread(this);
            baseThread.setName("weak-ref-cleaner-strictcontextstorage");
            baseThread.setPriority(1);
            baseThread.setDaemon(true);
            baseThread.start();
        }

        static PendingScopes create() {
            return new PendingScopes(new ConcurrentHashMap());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$drainPendingCallers$0(CallerStackTrace callerStackTrace) {
            return !callerStackTrace.closed;
        }

        List<CallerStackTrace> drainPendingCallers() {
            Stream stream;
            Stream filter;
            Collector list;
            Object collect;
            stream = this.map.values().stream();
            filter = stream.filter(new Predicate() { // from class: com.tencent.opentelemetry.context.m
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$drainPendingCallers$0;
                    lambda$drainPendingCallers$0 = StrictContextStorage.PendingScopes.lambda$drainPendingCallers$0((StrictContextStorage.CallerStackTrace) obj);
                    return lambda$drainPendingCallers$0;
                }
            });
            list = Collectors.toList();
            collect = filter.collect(list);
            List<CallerStackTrace> list2 = (List) collect;
            this.map.clear();
            return list2;
        }

        @Override // com.tencent.opentelemetry.context.internal.shaded.WeakConcurrentMap, com.tencent.opentelemetry.context.internal.shaded.AbstractWeakConcurrentMap, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            while (!Thread.interrupted()) {
                try {
                    CallerStackTrace remove = this.map.remove(remove());
                    if (remove != null && !remove.closed) {
                        StrictContextStorage.logger.log(Level.SEVERE, "Scope garbage collected before being closed.", (Throwable) StrictContextStorage.callerError(remove));
                    }
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    final class StrictScope implements Scope {
        static IPatchRedirector $redirector_;
        final CallerStackTrace caller;
        final Scope delegate;

        StrictScope(Scope scope, CallerStackTrace callerStackTrace) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, StrictContextStorage.this, scope, callerStackTrace);
                return;
            }
            this.delegate = scope;
            this.caller = callerStackTrace;
            StrictContextStorage.this.pendingScopes.put(this, callerStackTrace);
        }

        @Override // com.tencent.opentelemetry.context.Scope, java.lang.AutoCloseable
        public void close() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.caller.closed = true;
            StrictContextStorage.this.pendingScopes.remove(this);
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (int i3 = 0; i3 < stackTrace.length; i3++) {
                StackTraceElement stackTraceElement = stackTrace[i3];
                if (stackTraceElement.getClassName().equals(StrictScope.class.getName()) && stackTraceElement.getMethodName().equals("close")) {
                    int i16 = i3 + 2;
                    int i17 = i3 + 1;
                    if (i17 < stackTrace.length) {
                        StackTraceElement stackTraceElement2 = stackTrace[i17];
                        if (stackTraceElement2.getClassName().equals("kotlin.jdk7.AutoCloseableKt") && stackTraceElement2.getMethodName().equals("closeFinally") && i16 < stackTrace.length) {
                            i16 = i3 + 3;
                        }
                    }
                    if (stackTrace[i16].getMethodName().equals("invokeSuspend")) {
                        i16++;
                    }
                    if (i16 < stackTrace.length) {
                        StackTraceElement stackTraceElement3 = stackTrace[i16];
                        if (stackTraceElement3.getClassName().equals("kotlin.coroutines.jvm.internal.BaseContinuationImpl") && stackTraceElement3.getMethodName().equals("resumeWith")) {
                            throw new AssertionError("Attempting to close a Scope created by Context.makeCurrent from inside a Kotlin coroutine. This is not allowed. Use Context.asContextElement provided by extension-kotlin instead of makeCurrent.");
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (Thread.currentThread().getId() == this.caller.threadId) {
                this.delegate.close();
                return;
            }
            throw new IllegalStateException(String.format("Thread [%s] opened scope, but thread [%s] closed it", this.caller.threadName, Thread.currentThread().getName()), this.caller);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            String message = this.caller.getMessage();
            if (message == null) {
                return super.toString();
            }
            return message;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16064);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            logger = Logger.getLogger(StrictContextStorage.class.getName());
        }
    }

    StrictContextStorage(ContextStorage contextStorage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) contextStorage);
        } else {
            this.delegate = contextStorage;
            this.pendingScopes = PendingScopes.create();
        }
    }

    static AssertionError callerError(CallerStackTrace callerStackTrace) {
        AssertionError assertionError = new AssertionError("Thread [" + callerStackTrace.threadName + "] opened a scope of " + callerStackTrace.context + " here:");
        assertionError.setStackTrace(callerStackTrace.getStackTrace());
        return assertionError;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StrictContextStorage create(ContextStorage contextStorage) {
        return new StrictContextStorage(contextStorage);
    }

    @Override // com.tencent.opentelemetry.context.ContextStorage
    public Scope attach(Context context) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Scope) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Scope attach = this.delegate.attach(context);
        CallerStackTrace callerStackTrace = new CallerStackTrace(context);
        StackTraceElement[] stackTrace = callerStackTrace.getStackTrace();
        for (int i16 = 0; i16 < stackTrace.length; i16++) {
            StackTraceElement stackTraceElement = stackTrace[i16];
            if (stackTraceElement.getClassName().equals(Context.class.getName()) && stackTraceElement.getMethodName().equals("makeCurrent") && (i3 = i16 + 2) < stackTrace.length) {
                StackTraceElement stackTraceElement2 = stackTrace[i3];
                if (stackTraceElement2.getClassName().equals("kotlin.coroutines.jvm.internal.BaseContinuationImpl") && stackTraceElement2.getMethodName().equals("resumeWith")) {
                    throw new AssertionError("Attempting to call Context.makeCurrent from inside a Kotlin coroutine. This is not allowed. Use Context.asContextElement provided by opentelemetry-extension-kotlin instead of makeCurrent.");
                }
            }
        }
        int i17 = 1;
        while (i17 < stackTrace.length) {
            String className = stackTrace[i17].getClassName();
            if (!className.startsWith("io.opentelemetry.api.") && !className.startsWith("io.opentelemetry.sdk.testing.context.SettableContextStorageProvider") && !className.startsWith("io.opentelemetry.context.")) {
                break;
            }
            i17++;
        }
        callerStackTrace.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i17, stackTrace.length));
        return new StrictScope(attach, callerStackTrace);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.pendingScopes.expungeStaleEntries();
        List<CallerStackTrace> drainPendingCallers = this.pendingScopes.drainPendingCallers();
        if (!drainPendingCallers.isEmpty()) {
            if (drainPendingCallers.size() > 1) {
                logger.log(Level.SEVERE, "Multiple scopes leaked - first will be thrown as an error.");
                Iterator<CallerStackTrace> it = drainPendingCallers.iterator();
                while (it.hasNext()) {
                    logger.log(Level.SEVERE, "Scope leaked", (Throwable) callerError(it.next()));
                }
            }
            throw callerError(drainPendingCallers.get(0));
        }
    }

    @Override // com.tencent.opentelemetry.context.ContextStorage
    @Nullable
    public Context current() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.delegate.current();
    }
}
