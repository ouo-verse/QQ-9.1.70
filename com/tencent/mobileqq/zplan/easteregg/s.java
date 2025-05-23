package com.tencent.mobileqq.zplan.easteregg;

import com.tencent.mobileqq.zplan.easteregg.model.f;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b0\u00101J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\r\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u000bJ\u001d\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0007J\u0017\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\"\u0010%\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/s;", "Lcom/tencent/mobileqq/zplan/easteregg/model/f;", "T", "", "task", "", "e", "(Lcom/tencent/mobileqq/zplan/easteregg/model/f;)V", "d", "", "b", "(Lcom/tencent/mobileqq/zplan/easteregg/model/f;)Z", "k", "l", tl.h.F, "", "i", "(Lcom/tencent/mobileqq/zplan/easteregg/model/f;)I", "j", "interrupt", "c", "(Lcom/tencent/mobileqq/zplan/easteregg/model/f;Z)V", "f", "", "seq", "a", "(J)Lcom/tencent/mobileqq/zplan/easteregg/model/f;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "playQueue", "waitQueue", "I", "curPlayingTask", "getMaxPlayQueueCapacity", "()I", "setMaxPlayQueueCapacity", "(I)V", "maxPlayQueueCapacity", "Lcom/tencent/mobileqq/zplan/easteregg/y;", "Lcom/tencent/mobileqq/zplan/easteregg/y;", "getPlayerTaskListener", "()Lcom/tencent/mobileqq/zplan/easteregg/y;", "g", "(Lcom/tencent/mobileqq/zplan/easteregg/y;)V", "playerTaskListener", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class s<T extends com.tencent.mobileqq.zplan.easteregg.model.f> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int curPlayingTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private y playerTaskListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ConcurrentLinkedDeque<T> playQueue = new ConcurrentLinkedDeque<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ConcurrentLinkedDeque<T> waitQueue = new ConcurrentLinkedDeque<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int maxPlayQueueCapacity = 2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock lock = new ReentrantLock();

    private final boolean b(T task) {
        Iterator<T> it = this.waitQueue.iterator();
        while (it.hasNext()) {
            if (((com.tencent.mobileqq.zplan.easteregg.model.f) it.next()).b(task)) {
                return true;
            }
        }
        Iterator<T> it5 = this.playQueue.iterator();
        while (it5.hasNext()) {
            if (((com.tencent.mobileqq.zplan.easteregg.model.f) it5.next()).b(task)) {
                return true;
            }
        }
        return false;
    }

    private final void d(T task) {
        if (b(task)) {
            return;
        }
        this.waitQueue.offer(task);
        h();
    }

    private final void e(T task) {
        boolean k3 = k(task);
        l(task);
        if (k3) {
            this.playQueue.offer(task);
            y yVar = this.playerTaskListener;
            if (yVar != null) {
                yVar.a(task);
                return;
            }
            return;
        }
        this.waitQueue.offer(task);
        h();
    }

    private final void h() {
        this.lock.lock();
        if (this.curPlayingTask >= this.maxPlayQueueCapacity) {
            this.lock.unlock();
            return;
        }
        T poll = this.waitQueue.poll();
        if (poll == null) {
            this.lock.unlock();
            return;
        }
        this.curPlayingTask++;
        this.playQueue.offer(poll);
        this.lock.unlock();
        y yVar = this.playerTaskListener;
        if (yVar != null) {
            yVar.a(poll);
        }
    }

    private final int i(T task) {
        Iterator<T> it = this.playQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "playQueue.iterator()");
        int i3 = 0;
        while (it.hasNext()) {
            T item = it.next();
            if (item.c(task)) {
                it.remove();
                y yVar = this.playerTaskListener;
                if (yVar != null) {
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    yVar.b(item);
                }
                i3++;
            }
        }
        return i3;
    }

    private final boolean j(T task) {
        Iterator<T> it = this.waitQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "waitQueue.iterator()");
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next().c(task)) {
                it.remove();
                z16 = true;
            }
        }
        return z16;
    }

    private final boolean k(T task) {
        Iterator<T> it = this.playQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "playQueue.iterator()");
        boolean z16 = false;
        while (it.hasNext()) {
            T item = it.next();
            if (item.b(task)) {
                it.remove();
                y yVar = this.playerTaskListener;
                if (yVar != null) {
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    yVar.b(item);
                }
                z16 = true;
            }
        }
        return z16;
    }

    private final boolean l(T task) {
        Iterator<T> it = this.waitQueue.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "waitQueue.iterator()");
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next().b(task)) {
                it.remove();
                z16 = true;
            }
        }
        return z16;
    }

    public final T a(long seq) {
        for (T t16 : this.playQueue) {
            if (t16.a(seq)) {
                return t16;
            }
        }
        for (T t17 : this.waitQueue) {
            if (t17.a(seq)) {
                return t17;
            }
        }
        return null;
    }

    public final void c(T task, boolean interrupt) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (interrupt) {
            e(task);
        } else {
            d(task);
        }
    }

    public final void f(T task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.lock.lock();
        int i3 = i(task);
        if (i3 != 0) {
            this.curPlayingTask -= i3;
            this.lock.unlock();
            h();
        } else {
            this.lock.unlock();
            j(task);
        }
    }

    public final void g(y yVar) {
        this.playerTaskListener = yVar;
    }
}
