package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int i3, int i16) {
        this.targetType = i3;
        byte[] bArr = new byte[i16 + 3];
        this.nalData = bArr;
        bArr[2] = 1;
    }

    public void appendToNalUnit(byte[] bArr, int i3, int i16) {
        if (!this.isFilling) {
            return;
        }
        int i17 = i16 - i3;
        byte[] bArr2 = this.nalData;
        int length = bArr2.length;
        int i18 = this.nalLength;
        if (length < i18 + i17) {
            this.nalData = Arrays.copyOf(bArr2, (i18 + i17) * 2);
        }
        System.arraycopy(bArr, i3, this.nalData, this.nalLength, i17);
        this.nalLength += i17;
    }

    public boolean endNalUnit(int i3) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= i3;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public void startNalUnit(int i3) {
        boolean z16 = true;
        Assertions.checkState(!this.isFilling);
        if (i3 != this.targetType) {
            z16 = false;
        }
        this.isFilling = z16;
        if (z16) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }
}
