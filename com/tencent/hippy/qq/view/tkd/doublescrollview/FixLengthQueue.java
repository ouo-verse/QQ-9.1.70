package com.tencent.hippy.qq.view.tkd.doublescrollview;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FixLengthQueue {
    int length;
    long[] longs;
    int size;
    int start = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FixLengthQueue(int i3) {
        this.longs = new long[i3];
        this.length = i3;
    }

    public void add(long j3) {
        long[] jArr = this.longs;
        int i3 = this.start;
        jArr[i3] = j3;
        int i16 = i3 + 1;
        this.start = i16;
        int i17 = this.length;
        if (i16 >= i17) {
            this.start = 0;
        }
        int i18 = this.size;
        if (i18 < i17) {
            this.size = i18 + 1;
        }
    }

    public long getEnd() {
        int i3 = this.size;
        if (i3 == 0) {
            return 0L;
        }
        int i16 = this.length;
        if (i3 == i16) {
            int i17 = this.start;
            if (i17 == 0) {
                return this.longs[i16 - 1];
            }
            return this.longs[i17 - 1];
        }
        return this.longs[i3 - 1];
    }

    public long getFirst() {
        int i3 = this.size;
        int i16 = this.length;
        if (i3 != i16) {
            return this.longs[0];
        }
        if (i3 == 0 || i3 != i16) {
            return 0L;
        }
        return this.longs[this.start];
    }

    public void refreash() {
        this.start = 0;
        this.size = 0;
    }
}
