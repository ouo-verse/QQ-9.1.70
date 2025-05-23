package com.tencent.opentelemetry.sdk.common;

import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class CompletableResultCode {
    static IPatchRedirector $redirector_;
    private static final CompletableResultCode FAILURE;
    private static final CompletableResultCode SUCCESS;

    @GuardedBy(JoinPoint.SYNCHRONIZATION_LOCK)
    private final List<Runnable> completionActions;
    private final Object lock;

    @Nullable
    @GuardedBy(JoinPoint.SYNCHRONIZATION_LOCK)
    private Boolean succeeded;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9790);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            SUCCESS = new CompletableResultCode().succeed();
            FAILURE = new CompletableResultCode().fail();
        }
    }

    public CompletableResultCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.succeeded = null;
        this.completionActions = new ArrayList();
        this.lock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$ofAll$0(CompletableResultCode completableResultCode, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, CompletableResultCode completableResultCode2) {
        if (!completableResultCode.isSuccess()) {
            atomicBoolean.set(true);
        }
        if (atomicInteger.decrementAndGet() == 0) {
            if (atomicBoolean.get()) {
                completableResultCode2.fail();
            } else {
                completableResultCode2.succeed();
            }
        }
    }

    public static CompletableResultCode ofAll(Collection<CompletableResultCode> collection) {
        if (collection.isEmpty()) {
            return ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (final CompletableResultCode completableResultCode2 : collection) {
            completableResultCode2.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.common.c
                @Override // java.lang.Runnable
                public final void run() {
                    CompletableResultCode.lambda$ofAll$0(CompletableResultCode.this, atomicBoolean, atomicInteger, completableResultCode);
                }
            });
        }
        return completableResultCode;
    }

    public static CompletableResultCode ofFailure() {
        return FAILURE;
    }

    public static CompletableResultCode ofSuccess() {
        return SUCCESS;
    }

    public CompletableResultCode fail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        synchronized (this.lock) {
            if (this.succeeded == null) {
                this.succeeded = Boolean.FALSE;
                Iterator<Runnable> it = this.completionActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
        return this;
    }

    public boolean isDone() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        synchronized (this.lock) {
            if (this.succeeded != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public boolean isSuccess() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        synchronized (this.lock) {
            Boolean bool = this.succeeded;
            if (bool != null && bool.booleanValue()) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public CompletableResultCode join(long j3, TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), timeUnit);
        }
        if (isDone()) {
            return this;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        whenComplete(new b(countDownLatch));
        try {
            countDownLatch.await(j3, timeUnit);
            return this;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return this;
        }
    }

    public CompletableResultCode succeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (this.lock) {
            if (this.succeeded == null) {
                this.succeeded = Boolean.TRUE;
                Iterator<Runnable> it = this.completionActions.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
        return this;
    }

    public CompletableResultCode whenComplete(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        }
        synchronized (this.lock) {
            if (this.succeeded != null) {
                runnable.run();
            } else {
                this.completionActions.add(runnable);
            }
        }
        return this;
    }
}
