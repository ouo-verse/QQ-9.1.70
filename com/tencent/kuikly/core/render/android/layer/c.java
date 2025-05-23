package com.tencent.kuikly.core.render.android.layer;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u00a8\u0006\u0006"}, d2 = {"Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Lkotlin/Function0;", "", "task", "d", "c", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ReentrantReadWriteLock reentrantReadWriteLock, Function0<Unit> function0) {
        try {
            reentrantReadWriteLock.readLock().lock();
            function0.invoke();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ReentrantReadWriteLock reentrantReadWriteLock, Function0<Unit> function0) {
        try {
            reentrantReadWriteLock.writeLock().lock();
            function0.invoke();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
}
