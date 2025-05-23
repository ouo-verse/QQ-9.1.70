package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f, 1.0f);
    public final float pitch;
    private final int scaledUsPerMs;
    public final float speed;

    public PlaybackParameters(float f16, float f17) {
        boolean z16;
        if (f16 > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        Assertions.checkArgument(f17 > 0.0f);
        this.speed = f16;
        this.pitch = f17;
        this.scaledUsPerMs = Math.round(f16 * 1000.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch) {
            return true;
        }
        return false;
    }

    public long getMediaTimeUsForPlayoutTimeMs(long j3) {
        return j3 * this.scaledUsPerMs;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.speed)) * 31) + Float.floatToRawIntBits(this.pitch);
    }
}
