package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
@CanIgnoreReturnValue
@GwtIncompatible
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private String f35216a = null;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f35217b = null;

    /* renamed from: c, reason: collision with root package name */
    private Integer f35218c = null;

    /* renamed from: d, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f35219d = null;

    /* renamed from: e, reason: collision with root package name */
    private ThreadFactory f35220e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ThreadFactory f35221d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f35222e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicLong f35223f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Boolean f35224h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Integer f35225i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f35226m;

        a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f35221d = threadFactory;
            this.f35222e = str;
            this.f35223f = atomicLong;
            this.f35224h = bool;
            this.f35225i = num;
            this.f35226m = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f35221d.newThread(runnable);
            String str = this.f35222e;
            if (str != null) {
                newThread.setName(u.d(str, Long.valueOf(this.f35223f.getAndIncrement())));
            }
            Boolean bool = this.f35224h;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f35225i;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f35226m;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    private static ThreadFactory c(u uVar) {
        AtomicLong atomicLong;
        String str = uVar.f35216a;
        Boolean bool = uVar.f35217b;
        Integer num = uVar.f35218c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = uVar.f35219d;
        ThreadFactory threadFactory = uVar.f35220e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        ThreadFactory threadFactory2 = threadFactory;
        if (str != null) {
            atomicLong = new AtomicLong(0L);
        } else {
            atomicLong = null;
        }
        return new a(threadFactory2, str, atomicLong, bool, num, uncaughtExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    @CheckReturnValue
    public ThreadFactory b() {
        return c(this);
    }

    public u e(boolean z16) {
        this.f35217b = Boolean.valueOf(z16);
        return this;
    }

    public u f(String str) {
        d(str, 0);
        this.f35216a = str;
        return this;
    }
}
