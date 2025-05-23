package com.tencent.rfw.barrage.core;

import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import tz3.i;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private i f365034a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<BlockingQueue<com.tencent.rfw.barrage.data.a>> f365035b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private final BlockingQueue<com.tencent.rfw.barrage.data.a> f365036c = new LinkedBlockingQueue();

    public c(i iVar) {
        this.f365034a = iVar;
    }

    public com.tencent.rfw.barrage.data.a a(int i3, Object obj) {
        i iVar;
        BlockingQueue<com.tencent.rfw.barrage.data.a> blockingQueue = this.f365035b.get(i3);
        if (blockingQueue == null) {
            blockingQueue = new LinkedBlockingQueue<>();
        }
        com.tencent.rfw.barrage.data.a poll = blockingQueue.poll();
        if (poll == null && (iVar = this.f365034a) != null) {
            poll = iVar.c(i3);
            wz3.b.i("RFWBarrageFactory", poll, " is created ");
        } else {
            wz3.b.i("RFWBarrageFactory", poll, " is reused ");
        }
        poll.g0();
        poll.l0(obj);
        return poll;
    }

    protected int b() {
        return 300;
    }

    public void c(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null) {
            return;
        }
        int J = aVar.J();
        BlockingQueue<com.tencent.rfw.barrage.data.a> blockingQueue = this.f365035b.get(J);
        if (blockingQueue == null) {
            blockingQueue = new LinkedBlockingQueue<>();
            this.f365035b.put(J, blockingQueue);
        }
        if (b() > blockingQueue.size()) {
            blockingQueue.add(aVar);
        }
    }
}
