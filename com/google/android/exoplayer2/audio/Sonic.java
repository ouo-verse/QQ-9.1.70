package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
final class Sonic {
    private static final int AMDF_FREQUENCY = 4000;
    private static final int MAXIMUM_PITCH = 400;
    private static final int MINIMUM_PITCH = 65;
    private final short[] downSampleBuffer;
    private short[] inputBuffer;
    private int inputBufferSize;
    private final int inputSampleRateHz;
    private int maxDiff;
    private final int maxPeriod;
    private final int maxRequired;
    private int minDiff;
    private final int minPeriod;
    private final int numChannels;
    private int numInputSamples;
    private int numOutputSamples;
    private int numPitchSamples;
    private short[] outputBuffer;
    private int outputBufferSize;
    private final float pitch;
    private short[] pitchBuffer;
    private int pitchBufferSize;
    private int prevMinDiff;
    private final float rate;
    private int remainingInputToCopy;
    private final float speed;
    private int oldRatePosition = 0;
    private int newRatePosition = 0;
    private int prevPeriod = 0;

    public Sonic(int i3, int i16, float f16, float f17, int i17) {
        this.inputSampleRateHz = i3;
        this.numChannels = i16;
        this.minPeriod = i3 / 400;
        int i18 = i3 / 65;
        this.maxPeriod = i18;
        int i19 = i18 * 2;
        this.maxRequired = i19;
        this.downSampleBuffer = new short[i19];
        this.inputBufferSize = i19;
        this.inputBuffer = new short[i19 * i16];
        this.outputBufferSize = i19;
        this.outputBuffer = new short[i19 * i16];
        this.pitchBufferSize = i19;
        this.pitchBuffer = new short[i19 * i16];
        this.speed = f16;
        this.pitch = f17;
        this.rate = i3 / i17;
    }

    private void adjustRate(float f16, int i3) {
        int i16;
        int i17;
        if (this.numOutputSamples == i3) {
            return;
        }
        int i18 = this.inputSampleRateHz;
        int i19 = (int) (i18 / f16);
        while (true) {
            if (i19 <= 16384 && i18 <= 16384) {
                break;
            }
            i19 /= 2;
            i18 /= 2;
        }
        moveNewSamplesToPitchBuffer(i3);
        int i26 = 0;
        while (true) {
            int i27 = this.numPitchSamples;
            boolean z16 = true;
            if (i26 < i27 - 1) {
                while (true) {
                    i16 = this.oldRatePosition;
                    int i28 = (i16 + 1) * i19;
                    i17 = this.newRatePosition;
                    if (i28 <= i17 * i18) {
                        break;
                    }
                    enlargeOutputBufferIfNeeded(1);
                    int i29 = 0;
                    while (true) {
                        int i36 = this.numChannels;
                        if (i29 < i36) {
                            this.outputBuffer[(this.numOutputSamples * i36) + i29] = interpolate(this.pitchBuffer, (i36 * i26) + i29, i18, i19);
                            i29++;
                        }
                    }
                    this.newRatePosition++;
                    this.numOutputSamples++;
                }
                int i37 = i16 + 1;
                this.oldRatePosition = i37;
                if (i37 == i18) {
                    this.oldRatePosition = 0;
                    if (i17 != i19) {
                        z16 = false;
                    }
                    Assertions.checkState(z16);
                    this.newRatePosition = 0;
                }
                i26++;
            } else {
                removePitchSamples(i27 - 1);
                return;
            }
        }
    }

    private void changeSpeed(float f16) {
        int insertPitchPeriod;
        int i3 = this.numInputSamples;
        if (i3 < this.maxRequired) {
            return;
        }
        int i16 = 0;
        do {
            if (this.remainingInputToCopy > 0) {
                insertPitchPeriod = copyInputToOutput(i16);
            } else {
                int findPitchPeriod = findPitchPeriod(this.inputBuffer, i16, true);
                if (f16 > 1.0d) {
                    insertPitchPeriod = findPitchPeriod + skipPitchPeriod(this.inputBuffer, i16, f16, findPitchPeriod);
                } else {
                    insertPitchPeriod = insertPitchPeriod(this.inputBuffer, i16, f16, findPitchPeriod);
                }
            }
            i16 += insertPitchPeriod;
        } while (this.maxRequired + i16 <= i3);
        removeProcessedInputSamples(i16);
    }

    private int copyInputToOutput(int i3) {
        int min = Math.min(this.maxRequired, this.remainingInputToCopy);
        copyToOutput(this.inputBuffer, i3, min);
        this.remainingInputToCopy -= min;
        return min;
    }

    private void copyToOutput(short[] sArr, int i3, int i16) {
        enlargeOutputBufferIfNeeded(i16);
        int i17 = this.numChannels;
        System.arraycopy(sArr, i3 * i17, this.outputBuffer, this.numOutputSamples * i17, i17 * i16);
        this.numOutputSamples += i16;
    }

    private void downSampleInput(short[] sArr, int i3, int i16) {
        int i17 = this.maxRequired / i16;
        int i18 = this.numChannels;
        int i19 = i16 * i18;
        int i26 = i3 * i18;
        for (int i27 = 0; i27 < i17; i27++) {
            int i28 = 0;
            for (int i29 = 0; i29 < i19; i29++) {
                i28 += sArr[(i27 * i19) + i26 + i29];
            }
            this.downSampleBuffer[i27] = (short) (i28 / i19);
        }
    }

    private void enlargeInputBufferIfNeeded(int i3) {
        int i16 = this.numInputSamples + i3;
        int i17 = this.inputBufferSize;
        if (i16 > i17) {
            int i18 = i17 + (i17 / 2) + i3;
            this.inputBufferSize = i18;
            this.inputBuffer = Arrays.copyOf(this.inputBuffer, i18 * this.numChannels);
        }
    }

    private void enlargeOutputBufferIfNeeded(int i3) {
        int i16 = this.numOutputSamples + i3;
        int i17 = this.outputBufferSize;
        if (i16 > i17) {
            int i18 = i17 + (i17 / 2) + i3;
            this.outputBufferSize = i18;
            this.outputBuffer = Arrays.copyOf(this.outputBuffer, i18 * this.numChannels);
        }
    }

    private int findPitchPeriod(short[] sArr, int i3, boolean z16) {
        int i16;
        int i17;
        int i18;
        int i19 = this.inputSampleRateHz;
        if (i19 > 4000) {
            i16 = i19 / 4000;
        } else {
            i16 = 1;
        }
        if (this.numChannels == 1 && i16 == 1) {
            i17 = findPitchPeriodInRange(sArr, i3, this.minPeriod, this.maxPeriod);
        } else {
            downSampleInput(sArr, i3, i16);
            int findPitchPeriodInRange = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i16, this.maxPeriod / i16);
            if (i16 != 1) {
                int i26 = findPitchPeriodInRange * i16;
                int i27 = i16 * 4;
                int i28 = i26 - i27;
                int i29 = i26 + i27;
                int i36 = this.minPeriod;
                if (i28 < i36) {
                    i28 = i36;
                }
                int i37 = this.maxPeriod;
                if (i29 > i37) {
                    i29 = i37;
                }
                if (this.numChannels == 1) {
                    i17 = findPitchPeriodInRange(sArr, i3, i28, i29);
                } else {
                    downSampleInput(sArr, i3, 1);
                    i17 = findPitchPeriodInRange(this.downSampleBuffer, 0, i28, i29);
                }
            } else {
                i17 = findPitchPeriodInRange;
            }
        }
        if (previousPeriodBetter(this.minDiff, this.maxDiff, z16)) {
            i18 = this.prevPeriod;
        } else {
            i18 = i17;
        }
        this.prevMinDiff = this.minDiff;
        this.prevPeriod = i17;
        return i18;
    }

    private int findPitchPeriodInRange(short[] sArr, int i3, int i16, int i17) {
        int i18 = i3 * this.numChannels;
        int i19 = 255;
        int i26 = 1;
        int i27 = 0;
        int i28 = 0;
        while (i16 <= i17) {
            int i29 = 0;
            for (int i36 = 0; i36 < i16; i36++) {
                i29 += Math.abs(sArr[i18 + i36] - sArr[(i18 + i16) + i36]);
            }
            if (i29 * i27 < i26 * i16) {
                i27 = i16;
                i26 = i29;
            }
            if (i29 * i19 > i28 * i16) {
                i19 = i16;
                i28 = i29;
            }
            i16++;
        }
        this.minDiff = i26 / i27;
        this.maxDiff = i28 / i19;
        return i27;
    }

    private int insertPitchPeriod(short[] sArr, int i3, float f16, int i16) {
        int i17;
        if (f16 < 0.5f) {
            i17 = (int) ((i16 * f16) / (1.0f - f16));
        } else {
            this.remainingInputToCopy = (int) ((i16 * ((2.0f * f16) - 1.0f)) / (1.0f - f16));
            i17 = i16;
        }
        int i18 = i16 + i17;
        enlargeOutputBufferIfNeeded(i18);
        int i19 = this.numChannels;
        System.arraycopy(sArr, i3 * i19, this.outputBuffer, this.numOutputSamples * i19, i19 * i16);
        overlapAdd(i17, this.numChannels, this.outputBuffer, this.numOutputSamples + i16, sArr, i3 + i16, sArr, i3);
        this.numOutputSamples += i18;
        return i17;
    }

    private short interpolate(short[] sArr, int i3, int i16, int i17) {
        short s16 = sArr[i3];
        short s17 = sArr[i3 + this.numChannels];
        int i18 = this.newRatePosition * i16;
        int i19 = this.oldRatePosition;
        int i26 = i19 * i17;
        int i27 = (i19 + 1) * i17;
        int i28 = i27 - i18;
        int i29 = i27 - i26;
        return (short) (((s16 * i28) + ((i29 - i28) * s17)) / i29);
    }

    private void moveNewSamplesToPitchBuffer(int i3) {
        int i16 = this.numOutputSamples - i3;
        int i17 = this.numPitchSamples + i16;
        int i18 = this.pitchBufferSize;
        if (i17 > i18) {
            int i19 = i18 + (i18 / 2) + i16;
            this.pitchBufferSize = i19;
            this.pitchBuffer = Arrays.copyOf(this.pitchBuffer, i19 * this.numChannels);
        }
        short[] sArr = this.outputBuffer;
        int i26 = this.numChannels;
        System.arraycopy(sArr, i3 * i26, this.pitchBuffer, this.numPitchSamples * i26, i26 * i16);
        this.numOutputSamples = i3;
        this.numPitchSamples += i16;
    }

    private static void overlapAdd(int i3, int i16, short[] sArr, int i17, short[] sArr2, int i18, short[] sArr3, int i19) {
        for (int i26 = 0; i26 < i16; i26++) {
            int i27 = (i17 * i16) + i26;
            int i28 = (i19 * i16) + i26;
            int i29 = (i18 * i16) + i26;
            for (int i36 = 0; i36 < i3; i36++) {
                sArr[i27] = (short) (((sArr2[i29] * (i3 - i36)) + (sArr3[i28] * i36)) / i3);
                i27 += i16;
                i29 += i16;
                i28 += i16;
            }
        }
    }

    private boolean previousPeriodBetter(int i3, int i16, boolean z16) {
        if (i3 == 0 || this.prevPeriod == 0) {
            return false;
        }
        if (z16) {
            if (i16 > i3 * 3 || i3 * 2 <= this.prevMinDiff * 3) {
                return false;
            }
            return true;
        }
        if (i3 <= this.prevMinDiff) {
            return false;
        }
        return true;
    }

    private void processStreamInput() {
        int i3 = this.numOutputSamples;
        float f16 = this.speed;
        float f17 = this.pitch;
        float f18 = f16 / f17;
        float f19 = this.rate * f17;
        double d16 = f18;
        if (d16 <= 1.00001d && d16 >= 0.99999d) {
            copyToOutput(this.inputBuffer, 0, this.numInputSamples);
            this.numInputSamples = 0;
        } else {
            changeSpeed(f18);
        }
        if (f19 != 1.0f) {
            adjustRate(f19, i3);
        }
    }

    private void removePitchSamples(int i3) {
        if (i3 == 0) {
            return;
        }
        short[] sArr = this.pitchBuffer;
        int i16 = this.numChannels;
        System.arraycopy(sArr, i3 * i16, sArr, 0, (this.numPitchSamples - i3) * i16);
        this.numPitchSamples -= i3;
    }

    private void removeProcessedInputSamples(int i3) {
        int i16 = this.numInputSamples - i3;
        short[] sArr = this.inputBuffer;
        int i17 = this.numChannels;
        System.arraycopy(sArr, i3 * i17, sArr, 0, i17 * i16);
        this.numInputSamples = i16;
    }

    private int skipPitchPeriod(short[] sArr, int i3, float f16, int i16) {
        int i17;
        if (f16 >= 2.0f) {
            i17 = (int) (i16 / (f16 - 1.0f));
        } else {
            this.remainingInputToCopy = (int) ((i16 * (2.0f - f16)) / (f16 - 1.0f));
            i17 = i16;
        }
        enlargeOutputBufferIfNeeded(i17);
        overlapAdd(i17, this.numChannels, this.outputBuffer, this.numOutputSamples, sArr, i3, sArr, i3 + i16);
        this.numOutputSamples += i17;
        return i17;
    }

    public void getOutput(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.numChannels, this.numOutputSamples);
        shortBuffer.put(this.outputBuffer, 0, this.numChannels * min);
        int i3 = this.numOutputSamples - min;
        this.numOutputSamples = i3;
        short[] sArr = this.outputBuffer;
        int i16 = this.numChannels;
        System.arraycopy(sArr, min * i16, sArr, 0, i3 * i16);
    }

    public int getSamplesAvailable() {
        return this.numOutputSamples;
    }

    public void queueEndOfStream() {
        int i3;
        int i16 = this.numInputSamples;
        float f16 = this.speed;
        float f17 = this.pitch;
        int i17 = this.numOutputSamples + ((int) ((((i16 / (f16 / f17)) + this.numPitchSamples) / (this.rate * f17)) + 0.5f));
        enlargeInputBufferIfNeeded((this.maxRequired * 2) + i16);
        int i18 = 0;
        while (true) {
            i3 = this.maxRequired;
            int i19 = this.numChannels;
            if (i18 >= i3 * 2 * i19) {
                break;
            }
            this.inputBuffer[(i19 * i16) + i18] = 0;
            i18++;
        }
        this.numInputSamples += i3 * 2;
        processStreamInput();
        if (this.numOutputSamples > i17) {
            this.numOutputSamples = i17;
        }
        this.numInputSamples = 0;
        this.remainingInputToCopy = 0;
        this.numPitchSamples = 0;
    }

    public void queueInput(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i3 = this.numChannels;
        int i16 = remaining / i3;
        enlargeInputBufferIfNeeded(i16);
        shortBuffer.get(this.inputBuffer, this.numInputSamples * this.numChannels, ((i3 * i16) * 2) / 2);
        this.numInputSamples += i16;
        processStreamInput();
    }
}
