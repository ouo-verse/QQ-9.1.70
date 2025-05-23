package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
final class FixedSampleSizeRechunker {
    private static final int MAX_SAMPLE_SIZE = 8192;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Results {
        public final long duration;
        public final int[] flags;
        public final int maximumSize;
        public final long[] offsets;
        public final int[] sizes;
        public final long[] timestamps;

        Results(long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2, long j3) {
            this.offsets = jArr;
            this.sizes = iArr;
            this.maximumSize = i3;
            this.timestamps = jArr2;
            this.flags = iArr2;
            this.duration = j3;
        }
    }

    FixedSampleSizeRechunker() {
    }

    public static Results rechunk(int i3, long[] jArr, int[] iArr, long j3) {
        int i16 = 8192 / i3;
        int i17 = 0;
        for (int i18 : iArr) {
            i17 += Util.ceilDivide(i18, i16);
        }
        long[] jArr2 = new long[i17];
        int[] iArr2 = new int[i17];
        long[] jArr3 = new long[i17];
        int[] iArr3 = new int[i17];
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        for (int i28 = 0; i28 < iArr.length; i28++) {
            int i29 = iArr[i28];
            long j16 = jArr[i28];
            while (i29 > 0) {
                int min = Math.min(i16, i29);
                jArr2[i26] = j16;
                int i36 = i3 * min;
                iArr2[i26] = i36;
                i27 = Math.max(i27, i36);
                jArr3[i26] = i19 * j3;
                iArr3[i26] = 1;
                j16 += iArr2[i26];
                i19 += min;
                i29 -= min;
                i26++;
            }
        }
        return new Results(jArr2, iArr2, i27, jArr3, iArr3, j3 * i19);
    }
}
