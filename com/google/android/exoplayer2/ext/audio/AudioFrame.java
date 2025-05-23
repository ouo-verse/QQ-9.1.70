package com.google.android.exoplayer2.ext.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AudioFrame {
    private static int kMaxDataSizeBytes = 5292 * 2;
    private static int kMaxDataSizeSamples = 5292;
    private static short kSizeOfShort = 2;
    private String tag_;
    private long timestamp_ = -9223372036854775807L;
    short samples_per_channel_ = 0;
    short num_channels_ = 0;
    private int sample_rate_hz_ = 0;
    private boolean muted_ = true;
    private int offset_ = 0;
    private boolean isDebug_ = true;
    private byte[] data_ = new byte[kMaxDataSizeBytes];

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioFrame(String str) {
        this.tag_ = "";
        this.tag_ = str;
    }

    static byte[] empty_data() {
        return new byte[kMaxDataSizeBytes];
    }

    void CopyFrom(AudioFrame audioFrame) {
        boolean z16;
        if (audioFrame.equals(this)) {
            return;
        }
        this.timestamp_ = audioFrame.timestamp_;
        this.muted_ = audioFrame.muted();
        short s16 = audioFrame.samples_per_channel_;
        this.samples_per_channel_ = s16;
        this.sample_rate_hz_ = audioFrame.sample_rate_hz_;
        short s17 = audioFrame.num_channels_;
        this.num_channels_ = s17;
        this.offset_ = audioFrame.offset_;
        int i3 = s16 * s17;
        if (i3 < kMaxDataSizeSamples) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        if (!audioFrame.muted()) {
            System.arraycopy(audioFrame.data(), 0, this.data_, 0, i3 * kSizeOfShort);
            this.muted_ = false;
        }
    }

    void Mute() {
        this.muted_ = true;
    }

    void ResetWithoutMuting() {
        this.timestamp_ = -9223372036854775807L;
        this.samples_per_channel_ = (short) 0;
        this.sample_rate_hz_ = 0;
        this.num_channels_ = (short) 0;
        this.offset_ = 0;
    }

    void UpdateFrame(long j3, byte[] bArr, short s16, int i3, short s17) {
        boolean z16;
        this.timestamp_ = j3;
        this.samples_per_channel_ = s16;
        this.sample_rate_hz_ = i3;
        this.num_channels_ = s17;
        int i16 = s16 * s17;
        if (i16 < kMaxDataSizeSamples) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.data_, 0, i16 * kSizeOfShort);
            this.muted_ = false;
        } else {
            this.muted_ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int UpdateFrameChunk(long j3, byte[] bArr, int i3, int i16, int i17, short s16) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (this.timestamp_ == -9223372036854775807L) {
            this.timestamp_ = j3;
        }
        boolean z27 = true;
        if (i17 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        int i18 = this.sample_rate_hz_;
        if (i18 != 0 && i18 != i17) {
            z17 = false;
        } else {
            z17 = true;
        }
        Assertions.checkArgument(z17);
        this.sample_rate_hz_ = i17;
        if (s16 > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        Assertions.checkArgument(z18);
        short s17 = this.num_channels_;
        if (s17 != 0 && s17 != s16) {
            z19 = false;
        } else {
            z19 = true;
        }
        Assertions.checkArgument(z19);
        this.num_channels_ = s16;
        int i19 = kMaxDataSizeBytes - this.offset_;
        int min = Math.min(i16, i19);
        if (min > 0 && bArr != null) {
            System.arraycopy(bArr, i3, this.data_, this.offset_, min);
            this.muted_ = false;
            if (i19 % kSizeOfShort == 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            Assertions.checkArgument(z26);
            this.samples_per_channel_ = (short) (this.samples_per_channel_ + ((min / kSizeOfShort) / this.num_channels_));
            this.offset_ += min;
        }
        if (i19 <= 0) {
            z27 = false;
        }
        Assertions.checkArgument(z27);
        if (i19 - min == 0) {
            onFrameAvailable();
        }
        return min;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int available() {
        return kMaxDataSizeBytes - this.offset_;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] data() {
        if (this.muted_) {
            return empty_data();
        }
        return this.data_;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double duration() {
        return this.samples_per_channel_ / this.sample_rate_hz_;
    }

    byte[] mutable_data() {
        if (this.muted_) {
            Arrays.fill(this.data_, 0, kMaxDataSizeBytes - 1, (byte) 0);
            this.muted_ = false;
        }
        return this.data_;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean muted() {
        return this.muted_;
    }

    private void onFrameAvailable() {
    }
}
