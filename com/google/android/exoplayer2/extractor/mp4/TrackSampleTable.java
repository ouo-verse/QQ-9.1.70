package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
final class TrackSampleTable {
    public final long durationUs;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int sampleCount;
    public final int[] sizes;
    public final long[] timestampsUs;

    public TrackSampleTable(long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2, long j3) {
        boolean z16;
        boolean z17;
        if (iArr.length == jArr2.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        if (jArr.length == jArr2.length) {
            z17 = true;
        } else {
            z17 = false;
        }
        Assertions.checkArgument(z17);
        Assertions.checkArgument(iArr2.length == jArr2.length);
        this.offsets = jArr;
        this.sizes = iArr;
        this.maximumSize = i3;
        this.timestampsUs = jArr2;
        this.flags = iArr2;
        this.durationUs = j3;
        this.sampleCount = jArr.length;
    }

    public int getIndexOfEarlierOrEqualSynchronizationSample(long j3) {
        for (int binarySearchFloor = Util.binarySearchFloor(this.timestampsUs, j3, true, false); binarySearchFloor >= 0; binarySearchFloor--) {
            if ((this.flags[binarySearchFloor] & 1) != 0) {
                return binarySearchFloor;
            }
        }
        return -1;
    }

    public int getIndexOfLaterOrEqualSynchronizationSample(long j3) {
        for (int binarySearchCeil = Util.binarySearchCeil(this.timestampsUs, j3, true, false); binarySearchCeil < this.timestampsUs.length; binarySearchCeil++) {
            if ((this.flags[binarySearchCeil] & 1) != 0) {
                return binarySearchCeil;
            }
        }
        return -1;
    }
}
