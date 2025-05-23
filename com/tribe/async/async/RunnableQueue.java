package com.tribe.async.async;

import com.tribe.async.dispatch.SimpleQueue;
import com.tribe.async.log.SLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RunnableQueue implements SimpleQueue<Runnable> {
    private static final String TAG = "async.boss.RunnableQueue";
    private final List<Runnable> mQueue = new LinkedList();

    @Override // com.tribe.async.dispatch.SimpleQueue
    public void dump() {
        Iterator<Runnable> it = this.mQueue.iterator();
        String str = "[";
        while (it.hasNext()) {
            str = str + "," + it.next().toString();
        }
        SLog.d(TAG, str + "]");
    }

    @Override // com.tribe.async.dispatch.SimpleQueue
    public void enqueue(Runnable runnable) {
        this.mQueue.add(runnable);
    }

    @Override // com.tribe.async.dispatch.SimpleQueue
    public Runnable poll() {
        if (this.mQueue.size() > 0) {
            return this.mQueue.remove(0);
        }
        return null;
    }
}
