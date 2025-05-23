package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultAllocator implements Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean z16, int i3) {
        this(z16, i3, 0);
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized Allocation allocate() {
        Allocation allocation;
        this.allocatedCount++;
        int i3 = this.availableCount;
        if (i3 > 0) {
            Allocation[] allocationArr = this.availableAllocations;
            int i16 = i3 - 1;
            this.availableCount = i16;
            allocation = allocationArr[i16];
            allocationArr[i16] = null;
        } else {
            allocation = new Allocation(new byte[this.individualAllocationSize], 0);
        }
        return allocation;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized int getTotalBytesAllocated() {
        return this.allocatedCount * this.individualAllocationSize;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation allocation) {
        Allocation[] allocationArr = this.singleAllocationReleaseHolder;
        allocationArr[0] = allocation;
        release(allocationArr);
    }

    public synchronized void reset() {
        if (this.trimOnReset) {
            setTargetBufferSize(0);
        }
    }

    public synchronized void setTargetBufferSize(int i3) {
        boolean z16;
        if (i3 < this.targetBufferSize) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.targetBufferSize = i3;
        if (z16) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void trim() {
        int i3 = 0;
        int max = Math.max(0, Util.ceilDivide(this.targetBufferSize, this.individualAllocationSize) - this.allocatedCount);
        int i16 = this.availableCount;
        if (max >= i16) {
            return;
        }
        if (this.initialAllocationBlock != null) {
            int i17 = i16 - 1;
            while (i3 <= i17) {
                Allocation[] allocationArr = this.availableAllocations;
                Allocation allocation = allocationArr[i3];
                byte[] bArr = allocation.data;
                byte[] bArr2 = this.initialAllocationBlock;
                if (bArr == bArr2) {
                    i3++;
                } else {
                    Allocation allocation2 = allocationArr[i17];
                    if (allocation2.data != bArr2) {
                        i17--;
                    } else {
                        allocationArr[i3] = allocation2;
                        allocationArr[i17] = allocation;
                        i17--;
                        i3++;
                    }
                }
            }
            max = Math.max(max, i3);
            if (max >= this.availableCount) {
                return;
            }
        }
        Arrays.fill(this.availableAllocations, max, this.availableCount, (Object) null);
        this.availableCount = max;
    }

    public DefaultAllocator(boolean z16, int i3, int i16) {
        Assertions.checkArgument(i3 > 0);
        Assertions.checkArgument(i16 >= 0);
        this.trimOnReset = z16;
        this.individualAllocationSize = i3;
        this.availableCount = i16;
        this.availableAllocations = new Allocation[i16 + 100];
        if (i16 > 0) {
            this.initialAllocationBlock = new byte[i16 * i3];
            for (int i17 = 0; i17 < i16; i17++) {
                this.availableAllocations[i17] = new Allocation(this.initialAllocationBlock, i17 * i3);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation[] allocationArr) {
        boolean z16;
        int i3 = this.availableCount;
        int length = allocationArr.length + i3;
        Allocation[] allocationArr2 = this.availableAllocations;
        if (length >= allocationArr2.length) {
            this.availableAllocations = (Allocation[]) Arrays.copyOf(allocationArr2, Math.max(allocationArr2.length * 2, i3 + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            byte[] bArr = allocation.data;
            if (bArr != this.initialAllocationBlock && bArr.length != this.individualAllocationSize) {
                z16 = false;
                Assertions.checkArgument(z16);
                Allocation[] allocationArr3 = this.availableAllocations;
                int i16 = this.availableCount;
                this.availableCount = i16 + 1;
                allocationArr3[i16] = allocation;
            }
            z16 = true;
            Assertions.checkArgument(z16);
            Allocation[] allocationArr32 = this.availableAllocations;
            int i162 = this.availableCount;
            this.availableCount = i162 + 1;
            allocationArr32[i162] = allocation;
        }
        this.allocatedCount -= allocationArr.length;
        notifyAll();
    }
}
