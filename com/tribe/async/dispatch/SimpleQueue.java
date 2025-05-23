package com.tribe.async.dispatch;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface SimpleQueue<ITEM> {
    void dump();

    void enqueue(ITEM item);

    ITEM poll();
}
