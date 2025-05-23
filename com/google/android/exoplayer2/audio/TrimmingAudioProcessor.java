package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
final class TrimmingAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer;
    private int channelCount;
    private byte[] endBuffer;
    private int endBufferSize;
    private boolean inputEnded;
    private boolean isActive;
    private ByteBuffer outputBuffer;
    private int pendingTrimStartBytes;
    private int sampleRateHz;
    private int trimEndSamples;
    private int trimStartSamples;

    public TrimmingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
        this.channelCount = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i3, int i16, int i17) throws AudioProcessor.UnhandledFormatException {
        boolean z16;
        if (i17 == 2) {
            this.channelCount = i16;
            this.sampleRateHz = i3;
            int i18 = this.trimEndSamples;
            this.endBuffer = new byte[i18 * i16 * 2];
            this.endBufferSize = 0;
            int i19 = this.trimStartSamples;
            this.pendingTrimStartBytes = i16 * i19 * 2;
            boolean z17 = this.isActive;
            if (i19 == 0 && i18 == 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.isActive = z16;
            if (z17 == z16) {
                return false;
            }
            return true;
        }
        throw new AudioProcessor.UnhandledFormatException(i3, i16, i17);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputEnded = false;
        this.pendingTrimStartBytes = 0;
        this.endBufferSize = 0;
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
        return this.isActive;
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

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        int min = Math.min(i3, this.pendingTrimStartBytes);
        this.pendingTrimStartBytes -= min;
        byteBuffer.position(position + min);
        if (this.pendingTrimStartBytes > 0) {
            return;
        }
        int i16 = i3 - min;
        int length = (this.endBufferSize + i16) - this.endBuffer.length;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        int constrainValue = Util.constrainValue(length, 0, this.endBufferSize);
        this.buffer.put(this.endBuffer, 0, constrainValue);
        int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i16);
        byteBuffer.limit(byteBuffer.position() + constrainValue2);
        this.buffer.put(byteBuffer);
        byteBuffer.limit(limit);
        int i17 = i16 - constrainValue2;
        int i18 = this.endBufferSize - constrainValue;
        this.endBufferSize = i18;
        byte[] bArr = this.endBuffer;
        System.arraycopy(bArr, constrainValue, bArr, 0, i18);
        byteBuffer.get(this.endBuffer, this.endBufferSize, i17);
        this.endBufferSize += i17;
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.endBuffer = null;
    }

    public void setTrimSampleCount(int i3, int i16) {
        this.trimStartSamples = i3;
        this.trimEndSamples = i16;
    }
}
