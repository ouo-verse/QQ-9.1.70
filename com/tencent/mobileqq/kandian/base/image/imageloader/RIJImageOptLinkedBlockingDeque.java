package com.tencent.mobileqq.kandian.base.image.imageloader;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RIJImageOptLinkedBlockingDeque extends LinkedBlockingDeque {
    public RIJImageOptLinkedBlockingDeque(int i3) {
        super(i3);
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.Deque
    public Object poll() {
        return pollLast();
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public Object take() throws InterruptedException {
        return takeLast();
    }

    @Override // java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public Object poll(long j3, TimeUnit timeUnit) throws InterruptedException {
        return pollLast(j3, timeUnit);
    }
}
