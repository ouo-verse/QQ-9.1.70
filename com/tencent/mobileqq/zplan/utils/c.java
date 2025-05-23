package com.tencent.mobileqq.zplan.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/c;", "T", "", "Lcom/tencent/mobileqq/zplan/utils/j;", "observer", "", "b", "c", "data", "a", "(Ljava/lang/Object;)V", "", "Ljava/util/List;", "observers", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<j<T>> observers = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void a(T data) {
        List list;
        ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
        readLock.lock();
        try {
            list = CollectionsKt___CollectionsKt.toList(this.observers);
            readLock.unlock();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(data);
            }
        } catch (Throwable th5) {
            readLock.unlock();
            throw th5;
        }
    }

    public void b(j<T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i3 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i16 = 0; i16 < readHoldCount; i16++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.observers.add(observer);
        } finally {
            while (i3 < readHoldCount) {
                readLock.lock();
                i3++;
            }
            writeLock.unlock();
        }
    }

    public void c(j<T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i3 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i16 = 0; i16 < readHoldCount; i16++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.observers.remove(observer);
        } finally {
            while (i3 < readHoldCount) {
                readLock.lock();
                i3++;
            }
            writeLock.unlock();
        }
    }
}
