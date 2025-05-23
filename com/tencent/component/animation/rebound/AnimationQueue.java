package com.tencent.component.animation.rebound;

import com.tencent.component.animation.rebound.ChoreographerCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AnimationQueue {
    private boolean mRunning;
    private final Queue<Double> mPendingQueue = new LinkedList();
    private final Queue<Double> mAnimationQueue = new LinkedList();
    private final List<Callback> mCallbacks = new ArrayList();
    private final ArrayList<Double> mTempValues = new ArrayList<>();
    private final ChoreographerCompat mChoreographer = ChoreographerCompat.getInstance();
    private final ChoreographerCompat.FrameCallback mChoreographerCallback = new ChoreographerCompat.FrameCallback() { // from class: com.tencent.component.animation.rebound.AnimationQueue.1
        @Override // com.tencent.component.animation.rebound.ChoreographerCompat.FrameCallback
        public void doFrame(long j3) {
            AnimationQueue.this.onFrame(j3);
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface Callback {
        void onFrame(Double d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFrame(long j3) {
        int max;
        Double poll = this.mPendingQueue.poll();
        if (poll != null) {
            this.mAnimationQueue.offer(poll);
            max = 0;
        } else {
            max = Math.max(this.mCallbacks.size() - this.mAnimationQueue.size(), 0);
        }
        this.mTempValues.addAll(this.mAnimationQueue);
        int size = this.mTempValues.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            Double d16 = this.mTempValues.get(size);
            int size2 = ((this.mTempValues.size() - 1) - size) + max;
            if (this.mCallbacks.size() > size2) {
                this.mCallbacks.get(size2).onFrame(d16);
            }
        }
        this.mTempValues.clear();
        while (this.mAnimationQueue.size() + max >= this.mCallbacks.size()) {
            this.mAnimationQueue.poll();
        }
        if (this.mAnimationQueue.isEmpty() && this.mPendingQueue.isEmpty()) {
            this.mRunning = false;
        } else {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    private void runIfIdle() {
        if (!this.mRunning) {
            this.mRunning = true;
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    public void addAllValues(Collection<Double> collection) {
        this.mPendingQueue.addAll(collection);
        runIfIdle();
    }

    public void addCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    public void addValue(Double d16) {
        this.mPendingQueue.add(d16);
        runIfIdle();
    }

    public void clearCallbacks() {
        this.mCallbacks.clear();
    }

    public void clearValues() {
        this.mPendingQueue.clear();
    }

    public void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }
}
