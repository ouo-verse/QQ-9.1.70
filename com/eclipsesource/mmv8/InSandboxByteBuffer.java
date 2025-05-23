package com.eclipsesource.mmv8;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class InSandboxByteBuffer implements Releasable {

    @Nullable
    private final ByteBuffer mByteBuffer;
    private boolean mIsReleased = false;

    InSandboxByteBuffer(int i3) {
        this.mByteBuffer = V8.allocateDirectByteBufferInSandbox(i3);
    }

    public static InSandboxByteBuffer allocate(int i3) {
        return new InSandboxByteBuffer(i3);
    }

    @Nullable
    public synchronized ByteBuffer asByteBuffer() {
        if (this.mIsReleased) {
            return null;
        }
        return this.mByteBuffer;
    }

    public synchronized boolean isReleased() {
        return this.mIsReleased;
    }

    @Override // com.eclipsesource.mmv8.Releasable
    public synchronized void release() {
        if (this.mIsReleased) {
            return;
        }
        ByteBuffer byteBuffer = this.mByteBuffer;
        if (byteBuffer != null) {
            V8.releaseDirectByteBufferInSandbox(byteBuffer, byteBuffer.capacity());
            this.mIsReleased = true;
        }
    }
}
