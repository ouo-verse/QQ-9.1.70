package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ShuffleOrder {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DefaultShuffleOrder implements ShuffleOrder {
        private final int[] indexInShuffled;
        private final Random random;
        private final int[] shuffled;

        public DefaultShuffleOrder(int i3) {
            this(i3, new Random());
        }

        private static int[] createShuffledList(int i3, Random random) {
            int[] iArr = new int[i3];
            int i16 = 0;
            while (i16 < i3) {
                int i17 = i16 + 1;
                int nextInt = random.nextInt(i17);
                iArr[i16] = iArr[nextInt];
                iArr[nextInt] = i16;
                i16 = i17;
            }
            return iArr;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndClear() {
            return new DefaultShuffleOrder(0, new Random(this.random.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int i3, int i16) {
            int[] iArr = new int[i16];
            int[] iArr2 = new int[i16];
            int i17 = 0;
            int i18 = 0;
            while (i18 < i16) {
                iArr[i18] = this.random.nextInt(this.shuffled.length + 1);
                int i19 = i18 + 1;
                int nextInt = this.random.nextInt(i19);
                iArr2[i18] = iArr2[nextInt];
                iArr2[nextInt] = i18 + i3;
                i18 = i19;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.shuffled.length + i16];
            int i26 = 0;
            int i27 = 0;
            while (true) {
                int[] iArr4 = this.shuffled;
                if (i17 < iArr4.length + i16) {
                    if (i26 < i16 && i27 == iArr[i26]) {
                        iArr3[i17] = iArr2[i26];
                        i26++;
                    } else {
                        int i28 = i27 + 1;
                        int i29 = iArr4[i27];
                        iArr3[i17] = i29;
                        if (i29 >= i3) {
                            iArr3[i17] = i29 + i16;
                        }
                        i27 = i28;
                    }
                    i17++;
                } else {
                    return new DefaultShuffleOrder(iArr3, new Random(this.random.nextLong()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int i3) {
            int i16;
            int[] iArr = new int[this.shuffled.length - 1];
            int i17 = 0;
            boolean z16 = false;
            while (true) {
                int[] iArr2 = this.shuffled;
                if (i17 < iArr2.length) {
                    int i18 = iArr2[i17];
                    if (i18 == i3) {
                        z16 = true;
                    } else {
                        if (z16) {
                            i16 = i17 - 1;
                        } else {
                            i16 = i17;
                        }
                        if (i18 > i3) {
                            i18--;
                        }
                        iArr[i16] = i18;
                    }
                    i17++;
                } else {
                    return new DefaultShuffleOrder(iArr, new Random(this.random.nextLong()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.shuffled.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i3) {
            int i16 = this.indexInShuffled[i3] + 1;
            int[] iArr = this.shuffled;
            if (i16 < iArr.length) {
                return iArr[i16];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i3) {
            int i16 = this.indexInShuffled[i3] - 1;
            if (i16 < 0) {
                return -1;
            }
            return this.shuffled[i16];
        }

        public DefaultShuffleOrder(int i3, long j3) {
            this(i3, new Random(j3));
        }

        DefaultShuffleOrder(int i3, Random random) {
            this(createShuffledList(i3, random), random);
        }

        DefaultShuffleOrder(int[] iArr, Random random) {
            this.shuffled = iArr;
            this.random = random;
            this.indexInShuffled = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                this.indexInShuffled[iArr[i3]] = i3;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        private final int length;

        public UnshuffledShuffleOrder(int i3) {
            this.length = i3;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndClear() {
            return new UnshuffledShuffleOrder(0);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int i3, int i16) {
            return new UnshuffledShuffleOrder(this.length + i16);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int i3) {
            return new UnshuffledShuffleOrder(this.length - 1);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            if (this.length > 0) {
                return 0;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int i3 = this.length;
            if (i3 > 0) {
                return i3 - 1;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i3) {
            int i16 = i3 + 1;
            if (i16 >= this.length) {
                return -1;
            }
            return i16;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i3) {
            int i16 = i3 - 1;
            if (i16 < 0) {
                return -1;
            }
            return i16;
        }
    }

    ShuffleOrder cloneAndClear();

    ShuffleOrder cloneAndInsert(int i3, int i16);

    ShuffleOrder cloneAndRemove(int i3);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i3);

    int getPreviousIndex(int i3);
}
