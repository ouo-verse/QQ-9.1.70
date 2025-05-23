package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class ChannelMappingAudioProcessor implements AudioProcessor {
    private boolean active;
    private ByteBuffer buffer;
    private int channelCount;
    private boolean inputEnded;
    private ByteBuffer outputBuffer;
    private int[] outputChannels;
    private int[] pendingOutputChannels;
    private int sampleRateHz;

    public ChannelMappingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
        this.channelCount = -1;
        this.sampleRateHz = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i3, int i16, int i17) throws AudioProcessor.UnhandledFormatException {
        boolean z16;
        boolean z17;
        boolean z18 = !Arrays.equals(this.pendingOutputChannels, this.outputChannels);
        int[] iArr = this.pendingOutputChannels;
        this.outputChannels = iArr;
        if (iArr == null) {
            this.active = false;
            return z18;
        }
        if (i17 == 2) {
            if (!z18 && this.sampleRateHz == i3 && this.channelCount == i16) {
                return false;
            }
            this.sampleRateHz = i3;
            this.channelCount = i16;
            if (i16 != iArr.length) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.active = z16;
            int i18 = 0;
            while (true) {
                int[] iArr2 = this.outputChannels;
                if (i18 >= iArr2.length) {
                    return true;
                }
                int i19 = iArr2[i18];
                if (i19 < i16) {
                    boolean z19 = this.active;
                    if (i19 != i18) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    this.active = z17 | z19;
                    i18++;
                } else {
                    throw new AudioProcessor.UnhandledFormatException(i3, i16, i17);
                }
            }
        } else {
            throw new AudioProcessor.UnhandledFormatException(i3, i16, i17);
        }
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
        int[] iArr = this.outputChannels;
        if (iArr == null) {
            return this.channelCount;
        }
        return iArr.length;
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
        return this.active;
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
        int length = ((limit - position) / (this.channelCount * 2)) * this.outputChannels.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        while (position < limit) {
            for (int i3 : this.outputChannels) {
                this.buffer.putShort(byteBuffer.getShort((i3 * 2) + position));
            }
            position += this.channelCount * 2;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.outputChannels = null;
        this.active = false;
    }

    public void setChannelMap(int[] iArr) {
        this.pendingOutputChannels = iArr;
    }
}
