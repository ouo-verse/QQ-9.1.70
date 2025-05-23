package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
final class ResamplingAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer;
    private boolean inputEnded;
    private ByteBuffer outputBuffer;
    private int sampleRateHz = -1;
    private int channelCount = -1;
    private int encoding = 0;

    public ResamplingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i3, int i16, int i17) throws AudioProcessor.UnhandledFormatException {
        if (i17 != 3 && i17 != 2 && i17 != Integer.MIN_VALUE && i17 != 1073741824) {
            throw new AudioProcessor.UnhandledFormatException(i3, i16, i17);
        }
        if (this.sampleRateHz == i3 && this.channelCount == i16 && this.encoding == i17) {
            return false;
        }
        this.sampleRateHz = i3;
        this.channelCount = i16;
        this.encoding = i17;
        if (i17 == 2) {
            this.buffer = AudioProcessor.EMPTY_BUFFER;
            return true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputEnded = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        return this.channelCount;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        int i3 = this.encoding;
        if (i3 != 0 && i3 != 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        if (this.inputEnded && this.outputBuffer == AudioProcessor.EMPTY_BUFFER) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.inputEnded = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[ADDED_TO_REGION, LOOP:2: B:24:0x0081->B:25:0x0083, LOOP_START, PHI: r0
  0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:10:0x0041, B:25:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void queueInput(ByteBuffer byteBuffer) {
        int i3;
        int i16;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i17 = limit - position;
        int i18 = this.encoding;
        if (i18 != Integer.MIN_VALUE) {
            if (i18 != 3) {
                if (i18 == 1073741824) {
                    i3 = i17 / 2;
                    if (this.buffer.capacity() >= i3) {
                        this.buffer = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
                    } else {
                        this.buffer.clear();
                    }
                    i16 = this.encoding;
                    if (i16 == Integer.MIN_VALUE) {
                        if (i16 != 3) {
                            if (i16 == 1073741824) {
                                while (position < limit) {
                                    this.buffer.put(byteBuffer.get(position + 2));
                                    this.buffer.put(byteBuffer.get(position + 3));
                                    position += 4;
                                }
                            } else {
                                throw new IllegalStateException();
                            }
                        } else {
                            while (position < limit) {
                                this.buffer.put((byte) 0);
                                this.buffer.put((byte) ((byteBuffer.get(position) & 255) - 128));
                                position++;
                            }
                        }
                    } else {
                        while (position < limit) {
                            this.buffer.put(byteBuffer.get(position + 1));
                            this.buffer.put(byteBuffer.get(position + 2));
                            position += 3;
                        }
                    }
                    byteBuffer.position(byteBuffer.limit());
                    this.buffer.flip();
                    this.outputBuffer = this.buffer;
                }
                throw new IllegalStateException();
            }
        } else {
            i17 /= 3;
        }
        i3 = i17 * 2;
        if (this.buffer.capacity() >= i3) {
        }
        i16 = this.encoding;
        if (i16 == Integer.MIN_VALUE) {
        }
        byteBuffer.position(byteBuffer.limit());
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.sampleRateHz = -1;
        this.channelCount = -1;
        this.encoding = 0;
    }
}
