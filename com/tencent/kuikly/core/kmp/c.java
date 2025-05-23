package com.tencent.kuikly.core.kmp;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/kmp/c;", "", "", "a", "b", "c", "d", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "rwLock", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public final void a() {
        this.rwLock.readLock().lock();
    }

    public final void b() {
        this.rwLock.readLock().unlock();
    }

    public final void c() {
        this.rwLock.writeLock().lock();
    }

    public final void d() {
        this.rwLock.writeLock().unlock();
    }
}
