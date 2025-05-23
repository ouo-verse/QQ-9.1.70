package com.squareup.wire.internal;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u001a\u0018\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"NANOS_PER_SECOND", "", "addExactLong", HippyTKDListViewAdapter.X, "y", "floorDivLong", "dividend", "divisor", "floorModLong", "wire-runtime"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class MathMethodsKt {
    public static final long NANOS_PER_SECOND = 1000000000;

    public static final long addExactLong(long j3, long j16) {
        boolean z16;
        long j17 = j3 + j16;
        boolean z17 = true;
        if ((j16 ^ j3) < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((j3 ^ j17) < 0) {
            z17 = false;
        }
        if (z16 | z17) {
            return j17;
        }
        throw new ArithmeticException();
    }

    public static final long floorDivLong(long j3, long j16) {
        long j17 = j3 / j16;
        if (j3 - (j16 * j17) == 0) {
            return j17;
        }
        if ((((j3 ^ j16) >> 63) | 1) < 0) {
            return j17 - 1;
        }
        return j17;
    }

    public static final long floorModLong(long j3, long j16) {
        long j17 = j3 % j16;
        if (j17 == 0) {
            return 0L;
        }
        if ((((j3 ^ j16) >> 63) | 1) <= 0) {
            return j17 + j16;
        }
        return j17;
    }
}
