package com.google.android.exoplayer2.ext.audio;

import com.google.android.exoplayer2.ext.util.AudioUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AudioLevel {
    private static final short WEBRTC_SPL_WORD16_MAX = Short.MAX_VALUE;
    static final short kSizeOfShort = 2;
    private static final short kUpdateFrequency = 1;
    private short abs_max_ = 0;
    private short count_ = 0;
    private short current_level_full_range_ = 0;
    private double total_energy_ = 0.0d;
    private double total_duration_ = 0.0d;

    static short WebRtcSpl_MaxAbsValueW16J(byte[] bArr, int i3) {
        if (bArr != null && i3 > 0) {
            int i16 = 0;
            for (int i17 = 0; i17 < i3; i17++) {
                int i18 = i17 * 2;
                int abs = Math.abs((int) AudioUtil.byteToShort(bArr[i18], bArr[i18 + 1]));
                if (abs > i16) {
                    i16 = abs;
                }
            }
            if (i16 > 32767) {
                i16 = 32767;
            }
            return (short) i16;
        }
        return (short) -1;
    }

    void Clear() {
        this.abs_max_ = (short) 0;
        this.count_ = (short) 0;
        this.current_level_full_range_ = (short) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ComputeLevel(AudioFrame audioFrame, double d16) {
        short WebRtcSpl_MaxAbsValueW16J;
        if (audioFrame.muted()) {
            WebRtcSpl_MaxAbsValueW16J = 0;
        } else {
            WebRtcSpl_MaxAbsValueW16J = WebRtcSpl_MaxAbsValueW16J(audioFrame.data(), audioFrame.samples_per_channel_ * audioFrame.num_channels_);
        }
        if (WebRtcSpl_MaxAbsValueW16J > this.abs_max_) {
            this.abs_max_ = WebRtcSpl_MaxAbsValueW16J;
        }
        short s16 = this.count_;
        this.count_ = (short) (s16 + 1);
        if (s16 == 1) {
            short s17 = this.abs_max_;
            this.current_level_full_range_ = s17;
            this.count_ = (short) 0;
            this.abs_max_ = (short) (s17 >> 2);
        }
        double d17 = this.current_level_full_range_ / 32767.0d;
        this.total_energy_ += d17 * d17 * d16;
        this.total_duration_ += d16;
    }

    short LevelFullRange() {
        return this.current_level_full_range_;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double TotalDuration() {
        return this.total_duration_;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double TotalEnergy() {
        return this.total_energy_;
    }
}
