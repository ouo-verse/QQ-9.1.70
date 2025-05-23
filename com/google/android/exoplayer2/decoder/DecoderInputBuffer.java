package com.google.android.exoplayer2.decoder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DecoderInputBuffer extends Buffer {
    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    private final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo = new CryptoInfo();
    public ByteBuffer data;
    public long timeUs;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface BufferReplacementMode {
    }

    public DecoderInputBuffer(int i3) {
        this.bufferReplacementMode = i3;
    }

    private ByteBuffer createReplacementByteBuffer(int i3) {
        int capacity;
        int i16 = this.bufferReplacementMode;
        if (i16 == 1) {
            return ByteBuffer.allocate(i3);
        }
        if (i16 == 2) {
            return ByteBuffer.allocateDirect(i3);
        }
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            capacity = 0;
        } else {
            capacity = byteBuffer.capacity();
        }
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i3 + ")");
    }

    public static DecoderInputBuffer newFlagsOnlyInstance() {
        return new DecoderInputBuffer(0);
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public void ensureSpaceForWrite(int i3) throws IllegalStateException {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            this.data = createReplacementByteBuffer(i3);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.data.position();
        int i16 = i3 + position;
        if (capacity >= i16) {
            return;
        }
        ByteBuffer createReplacementByteBuffer = createReplacementByteBuffer(i16);
        if (position > 0) {
            this.data.position(0);
            this.data.limit(position);
            createReplacementByteBuffer.put(this.data);
        }
        this.data = createReplacementByteBuffer;
    }

    public final void flip() {
        this.data.flip();
    }

    public final boolean isEncrypted() {
        return getFlag(1073741824);
    }

    public final boolean isFlagsOnly() {
        if (this.data == null && this.bufferReplacementMode == 0) {
            return true;
        }
        return false;
    }
}
