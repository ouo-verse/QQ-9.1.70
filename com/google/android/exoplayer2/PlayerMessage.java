package com.google.android.exoplayer2;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* loaded from: classes2.dex */
public final class PlayerMessage {
    private Handler handler;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Object payload;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;
    private long positionMs = -9223372036854775807L;
    private boolean deleteAfterDelivery = true;

    /* loaded from: classes2.dex */
    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    /* loaded from: classes2.dex */
    public interface Target {
        void handleMessage(int i3, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i3, Handler handler) {
        this.sender = sender;
        this.target = target;
        this.timeline = timeline;
        this.handler = handler;
        this.windowIndex = i3;
    }

    public synchronized boolean blockUntilDelivered() throws InterruptedException {
        boolean z16;
        Assertions.checkState(this.isSent);
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        while (!this.isProcessed) {
            LockMethodProxy.wait(this);
        }
        return this.isDelivered;
    }

    public boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public Object getPayload() {
        return this.payload;
    }

    public long getPositionMs() {
        return this.positionMs;
    }

    public Target getTarget() {
        return this.target;
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    public int getType() {
        return this.type;
    }

    public int getWindowIndex() {
        return this.windowIndex;
    }

    public synchronized void markAsProcessed(boolean z16) {
        this.isDelivered = z16 | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }

    public PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if (this.positionMs == -9223372036854775807L) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public PlayerMessage setDeleteAfterDelivery(boolean z16) {
        Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z16;
        return this;
    }

    public PlayerMessage setHandler(Handler handler) {
        Assertions.checkState(!this.isSent);
        this.handler = handler;
        return this;
    }

    public PlayerMessage setPayload(@Nullable Object obj) {
        Assertions.checkState(!this.isSent);
        this.payload = obj;
        return this;
    }

    public PlayerMessage setPosition(long j3) {
        Assertions.checkState(!this.isSent);
        this.positionMs = j3;
        return this;
    }

    public PlayerMessage setType(int i3) {
        Assertions.checkState(!this.isSent);
        this.type = i3;
        return this;
    }

    public PlayerMessage setPosition(int i3, long j3) {
        Assertions.checkState(!this.isSent);
        Assertions.checkArgument(j3 != -9223372036854775807L);
        if (i3 >= 0 && (this.timeline.isEmpty() || i3 < this.timeline.getWindowCount())) {
            this.windowIndex = i3;
            this.positionMs = j3;
            return this;
        }
        throw new IllegalSeekPositionException(this.timeline, i3, j3);
    }
}
