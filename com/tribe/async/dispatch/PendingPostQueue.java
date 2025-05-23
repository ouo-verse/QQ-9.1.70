package com.tribe.async.dispatch;

/* loaded from: classes27.dex */
final class PendingPostQueue implements SimpleQueue<PendingPost> {
    private PendingPost mHead;
    private PendingPost mTail;

    @Override // com.tribe.async.dispatch.SimpleQueue
    public synchronized void enqueue(PendingPost pendingPost) {
        try {
            if (pendingPost != null) {
                PendingPost pendingPost2 = this.mTail;
                if (pendingPost2 != null) {
                    pendingPost2.next = pendingPost;
                    this.mTail = pendingPost;
                } else if (this.mHead == null) {
                    this.mTail = pendingPost;
                    this.mHead = pendingPost;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tribe.async.dispatch.SimpleQueue
    public synchronized PendingPost poll() {
        PendingPost pendingPost;
        pendingPost = this.mHead;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.next;
            this.mHead = pendingPost2;
            if (pendingPost2 == null) {
                this.mTail = null;
            }
        }
        return pendingPost;
    }

    public synchronized PendingPost poll(int i3) throws InterruptedException {
        if (this.mHead == null) {
            wait(i3);
        }
        return poll();
    }

    @Override // com.tribe.async.dispatch.SimpleQueue
    public void dump() {
    }
}
