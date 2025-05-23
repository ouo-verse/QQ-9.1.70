package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SimpleOutputBuffer extends OutputBuffer {
    public ByteBuffer data;
    private final SimpleDecoder<?, SimpleOutputBuffer, ?> owner;

    public SimpleOutputBuffer(SimpleDecoder<?, SimpleOutputBuffer, ?> simpleDecoder) {
        this.owner = simpleDecoder;
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public ByteBuffer init(long j3, int i3) {
        this.timeUs = j3;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < i3) {
            this.data = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(i3);
        return this.data;
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
