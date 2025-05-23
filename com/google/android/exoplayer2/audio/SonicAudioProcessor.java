package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes2.dex */
public final class SonicAudioProcessor implements AudioProcessor {
    private static final float CLOSE_THRESHOLD = 0.01f;
    public static final float MAXIMUM_PITCH = 8.0f;
    public static final float MAXIMUM_SPEED = 8.0f;
    public static final float MINIMUM_PITCH = 0.1f;
    public static final float MINIMUM_SPEED = 0.1f;
    private static final int MIN_BYTES_FOR_SPEEDUP_CALCULATION = 1024;
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    private ByteBuffer buffer;
    private long inputBytes;
    private boolean inputEnded;
    private ByteBuffer outputBuffer;
    private long outputBytes;
    private int pendingOutputSampleRateHz;
    private ShortBuffer shortBuffer;
    private Sonic sonic;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int sampleRateHz = -1;
    private int outputSampleRateHz = -1;

    public SonicAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.outputBuffer = byteBuffer;
        this.pendingOutputSampleRateHz = -1;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean configure(int i3, int i16, int i17) throws AudioProcessor.UnhandledFormatException {
        if (i17 == 2) {
            int i18 = this.pendingOutputSampleRateHz;
            if (i18 == -1) {
                i18 = i3;
            }
            if (this.sampleRateHz == i3 && this.channelCount == i16 && this.outputSampleRateHz == i18) {
                return false;
            }
            this.sampleRateHz = i3;
            this.channelCount = i16;
            this.outputSampleRateHz = i18;
            return true;
        }
        throw new AudioProcessor.UnhandledFormatException(i3, i16, i17);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.sonic = new Sonic(this.sampleRateHz, this.channelCount, this.speed, this.pitch, this.outputSampleRateHz);
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
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
        return this.outputSampleRateHz;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        if (Math.abs(this.speed - 1.0f) < 0.01f && Math.abs(this.pitch - 1.0f) < 0.01f && this.outputSampleRateHz == this.sampleRateHz) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        Sonic sonic;
        if (this.inputEnded && ((sonic = this.sonic) == null || sonic.getSamplesAvailable() == 0)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.sonic.queueEndOfStream();
        this.inputEnded = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.inputBytes += remaining;
            this.sonic.queueInput(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int samplesAvailable = this.sonic.getSamplesAvailable() * this.channelCount * 2;
        if (samplesAvailable > 0) {
            if (this.buffer.capacity() < samplesAvailable) {
                ByteBuffer order = ByteBuffer.allocateDirect(samplesAvailable).order(ByteOrder.nativeOrder());
                this.buffer = order;
                this.shortBuffer = order.asShortBuffer();
            } else {
                this.buffer.clear();
                this.shortBuffer.clear();
            }
            this.sonic.getOutput(this.shortBuffer);
            this.outputBytes += samplesAvailable;
            this.buffer.limit(samplesAvailable);
            this.outputBuffer = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.sonic = null;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.outputBuffer = byteBuffer;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.outputSampleRateHz = -1;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
        this.pendingOutputSampleRateHz = -1;
    }

    public long scaleDurationForSpeedup(long j3) {
        long j16 = this.outputBytes;
        if (j16 >= 1024) {
            int i3 = this.outputSampleRateHz;
            int i16 = this.sampleRateHz;
            if (i3 == i16) {
                return Util.scaleLargeTimestamp(j3, this.inputBytes, j16);
            }
            return Util.scaleLargeTimestamp(j3, this.inputBytes * i3, j16 * i16);
        }
        return (long) (this.speed * j3);
    }

    public void setOutputSampleRateHz(int i3) {
        this.pendingOutputSampleRateHz = i3;
    }

    public float setPitch(float f16) {
        this.pitch = Util.constrainValue(f16, 0.1f, 8.0f);
        return f16;
    }

    public float setSpeed(float f16) {
        float constrainValue = Util.constrainValue(f16, 0.1f, 8.0f);
        this.speed = constrainValue;
        return constrainValue;
    }
}
