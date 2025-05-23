package com.tencent.mobileqq.guild.util;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0011\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0002\u00a2\u0006\u0004\b\r\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0007R\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u001a\u0010!\u001a\u00020\u001c8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010(\u001a\n #*\u0004\u0018\u00010\"0\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/util/ck;", "T", "Ljava/util/concurrent/Future;", "Lcom/tencent/mobileqq/guild/util/bl;", "value", "", "complete", "(Ljava/lang/Object;)V", "", "mayInterruptIfRunning", "cancel", "isCancelled", "isDone", "get", "()Ljava/lang/Object;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "d", "Ljava/lang/Object;", "getResult", "setResult", "result", "e", "Z", "f", "Ljava/util/concurrent/locks/ReentrantLock;", tl.h.F, "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "i", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "condition", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ck<T> implements Future<T>, bl<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T result;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isDone;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isCancelled;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReentrantLock lock;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Condition condition;

    public ck() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    @Override // java.util.concurrent.Future, com.tencent.mobileqq.guild.util.bl
    public boolean cancel(boolean mayInterruptIfRunning) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.isDone) {
                reentrantLock.unlock();
                return false;
            }
            this.isCancelled = true;
            this.condition.signalAll();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.guild.util.bl
    public void complete(@Nullable T value) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.isCancelled) {
                this.result = value;
                this.isDone = true;
                this.condition.signalAll();
                Unit unit = Unit.INSTANCE;
                return;
            }
            throw new IllegalStateException("Cannot complete a cancelled task");
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public T get() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!this.isDone && !this.isCancelled) {
            try {
                this.condition.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        if (this.isCancelled) {
            reentrantLock.unlock();
            return null;
        }
        T t16 = this.result;
        Intrinsics.checkNotNull(t16);
        return t16;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.isCancelled;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.isDone;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public T get(long timeout, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (!this.isDone && !this.isCancelled) {
                if (nanos > 0) {
                    nanos = this.condition.awaitNanos(nanos);
                } else {
                    throw new TimeoutException();
                }
            }
            if (this.isCancelled) {
                reentrantLock.unlock();
                return null;
            }
            T t16 = this.result;
            Intrinsics.checkNotNull(t16);
            return t16;
        } finally {
            reentrantLock.unlock();
        }
    }
}
