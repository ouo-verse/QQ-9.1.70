package com.google.android.exoplayer2.ext.audio;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AudioFrameManager {
    private AudioFrame[] audioFrames = null;
    private AudioLevel[] audioLevels = null;

    private synchronized void processAudioFrame(byte[][] bArr, Format format) {
        if (this.audioFrames == null) {
            this.audioFrames = new AudioFrame[bArr.length];
        }
        if (this.audioLevels == null) {
            this.audioLevels = new AudioLevel[bArr.length];
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            String str = "chan" + i3;
            AudioFrame[] audioFrameArr = this.audioFrames;
            if (audioFrameArr[i3] == null) {
                audioFrameArr[i3] = new AudioFrame(str);
            }
            AudioLevel[] audioLevelArr = this.audioLevels;
            if (audioLevelArr[i3] == null) {
                audioLevelArr[i3] = new AudioLevel();
            }
            int i16 = 0;
            while (true) {
                byte[] bArr2 = bArr[i3];
                if (i16 < bArr2.length - 1) {
                    int UpdateFrameChunk = this.audioFrames[i3].UpdateFrameChunk(SystemClock.uptimeMillis(), bArr[i3], i16, bArr2.length - i16, format.sampleRate, (short) 1);
                    if (this.audioFrames[i3].available() <= 0) {
                        AudioLevel audioLevel = this.audioLevels[i3];
                        AudioFrame audioFrame = this.audioFrames[i3];
                        audioLevel.ComputeLevel(audioFrame, audioFrame.duration());
                        this.audioFrames[i3] = new AudioFrame(str);
                    }
                    i16 += UpdateFrameChunk;
                }
            }
        }
    }

    public synchronized void feedAudioData(byte[] bArr, Format format) {
        boolean z16;
        int i3 = format.channelCount;
        if (i3 > 0 && i3 <= 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i3, bArr.length / i3);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < bArr.length; i18 += 2) {
            if (i16 > i3 - 1) {
                i17 += 2;
                i16 = 0;
            }
            byte[] bArr3 = bArr2[i16];
            bArr3[i17] = bArr[i18];
            bArr3[i17 + 1] = bArr[i18 + 1];
            i16++;
        }
        processAudioFrame(bArr2, format);
    }

    public synchronized double getAudioEnergy() {
        double d16 = 0.0d;
        if (this.audioLevels == null) {
            return 0.0d;
        }
        int i3 = 0;
        while (true) {
            AudioLevel[] audioLevelArr = this.audioLevels;
            if (i3 < audioLevelArr.length) {
                d16 += audioLevelArr[i3].TotalEnergy();
                i3++;
            } else {
                return d16 / audioLevelArr.length;
            }
        }
    }

    public synchronized double getDuration() {
        double d16 = 0.0d;
        if (this.audioLevels == null) {
            return 0.0d;
        }
        int i3 = 0;
        while (true) {
            AudioLevel[] audioLevelArr = this.audioLevels;
            if (i3 < audioLevelArr.length) {
                d16 += audioLevelArr[i3].TotalDuration();
                i3++;
            } else {
                return d16 / audioLevelArr.length;
            }
        }
    }
}
