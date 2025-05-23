package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
public final class SeekParameters {
    public static final SeekParameters CLOSEST_SYNC;
    public static final SeekParameters DEFAULT;
    public static final SeekParameters EXACT;
    public static final SeekParameters NEXT_SYNC;
    public static final SeekParameters PREVIOUS_SYNC;
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    static {
        SeekParameters seekParameters = new SeekParameters(0L, 0L);
        EXACT = seekParameters;
        CLOSEST_SYNC = new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
        PREVIOUS_SYNC = new SeekParameters(Long.MAX_VALUE, 0L);
        NEXT_SYNC = new SeekParameters(0L, Long.MAX_VALUE);
        DEFAULT = seekParameters;
    }

    public SeekParameters(long j3, long j16) {
        boolean z16;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        Assertions.checkArgument(j16 >= 0);
        this.toleranceBeforeUs = j3;
        this.toleranceAfterUs = j16;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekParameters.class != obj.getClass()) {
            return false;
        }
        SeekParameters seekParameters = (SeekParameters) obj;
        if (this.toleranceBeforeUs == seekParameters.toleranceBeforeUs && this.toleranceAfterUs == seekParameters.toleranceAfterUs) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.toleranceBeforeUs) * 31) + ((int) this.toleranceAfterUs);
    }
}
