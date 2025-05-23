package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
final class LongAdder extends Striped64 implements Serializable, g {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // com.google.common.cache.g
    public void add(long j3) {
        int length;
        Striped64.b bVar;
        Striped64.b[] bVarArr = this.cells;
        if (bVarArr == null) {
            long j16 = this.base;
            if (casBase(j16, j16 + j3)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z16 = true;
        if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
            long j17 = bVar.f34817a;
            z16 = bVar.a(j17, j17 + j3);
            if (z16) {
                return;
            }
        }
        retryUpdate(j3, iArr, z16);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // com.google.common.cache.Striped64
    final long fn(long j3, long j16) {
        return j3 + j16;
    }

    @Override // com.google.common.cache.g
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // com.google.common.cache.g
    public long sum() {
        long j3 = this.base;
        Striped64.b[] bVarArr = this.cells;
        if (bVarArr != null) {
            for (Striped64.b bVar : bVarArr) {
                if (bVar != null) {
                    j3 += bVar.f34817a;
                }
            }
        }
        return j3;
    }

    public long sumThenReset() {
        long j3 = this.base;
        Striped64.b[] bVarArr = this.cells;
        this.base = 0L;
        if (bVarArr != null) {
            for (Striped64.b bVar : bVarArr) {
                if (bVar != null) {
                    j3 += bVar.f34817a;
                    bVar.f34817a = 0L;
                }
            }
        }
        return j3;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
