package androidx.compose.runtime.snapshots;

import com.gcore.abase.utils.PatternUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J \u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\b\u00f8\u0001\u0000J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", QCircleLpReportDc05507.KEY_CLEAR, "bit", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", PatternUtils.NO_MATCH, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }

        private Companion() {
        }
    }

    private SnapshotIdSet(long j3, long j16, int i3, int[] iArr) {
        this.upperSet = j3;
        this.lowerSet = j16;
        this.lowerBound = i3;
        this.belowBound = iArr;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet bits) {
        Intrinsics.checkNotNullParameter(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return snapshotIdSet;
        }
        int i3 = bits.lowerBound;
        int i16 = this.lowerBound;
        if (i3 == i16) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet & (~bits.upperSet), this.lowerSet & (~bits.lowerSet), i16, iArr2);
            }
        }
        Iterator<Integer> it = bits.iterator();
        SnapshotIdSet snapshotIdSet2 = this;
        while (it.hasNext()) {
            snapshotIdSet2 = snapshotIdSet2.clear(it.next().intValue());
        }
        return snapshotIdSet2;
    }

    public final void fastForEach(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int[] iArr = this.belowBound;
        if (iArr != null) {
            for (int i3 : iArr) {
                block.invoke(Integer.valueOf(i3));
            }
        }
        if (this.lowerSet != 0) {
            for (int i16 = 0; i16 < 64; i16++) {
                if ((this.lowerSet & (1 << i16)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + i16));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i17 = 0; i17 < 64; i17++) {
                if ((this.upperSet & (1 << i17)) != 0) {
                    block.invoke(Integer.valueOf(i17 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final boolean get(int bit) {
        int[] iArr;
        int i3 = bit - this.lowerBound;
        if (i3 >= 0 && i3 < 64) {
            return ((1 << i3) & this.lowerSet) != 0;
        }
        if (i3 >= 64 && i3 < 128) {
            return ((1 << (i3 - 64)) & this.upperSet) != 0;
        }
        if (i3 <= 0 && (iArr = this.belowBound) != null) {
            return SnapshotIdSetKt.binarySearch(iArr, bit) >= 0;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        Sequence sequence;
        sequence = SequencesKt__SequenceBuilderKt.sequence(new SnapshotIdSet$iterator$1(this, null));
        return sequence.iterator();
    }

    public final int lowest(int r65) {
        int lowestBitOf;
        int lowestBitOf2;
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j3 = this.lowerSet;
        if (j3 != 0) {
            int i3 = this.lowerBound;
            lowestBitOf2 = SnapshotIdSetKt.lowestBitOf(j3);
            return i3 + lowestBitOf2;
        }
        long j16 = this.upperSet;
        if (j16 == 0) {
            return r65;
        }
        int i16 = this.lowerBound + 64;
        lowestBitOf = SnapshotIdSetKt.lowestBitOf(j16);
        return i16 + lowestBitOf;
    }

    public final SnapshotIdSet or(SnapshotIdSet bits) {
        Intrinsics.checkNotNullParameter(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return bits;
        }
        int i3 = bits.lowerBound;
        int i16 = this.lowerBound;
        if (i3 == i16) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet | bits.upperSet, this.lowerSet | bits.lowerSet, i16, iArr2);
            }
        }
        if (this.belowBound == null) {
            Iterator<Integer> it = iterator();
            while (it.hasNext()) {
                bits = bits.set(it.next().intValue());
            }
            return bits;
        }
        Iterator<Integer> it5 = bits.iterator();
        SnapshotIdSet snapshotIdSet2 = this;
        while (it5.hasNext()) {
            snapshotIdSet2 = snapshotIdSet2.set(it5.next().intValue());
        }
        return snapshotIdSet2;
    }

    public String toString() {
        int collectionSizeOrDefault;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append(" [");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(this, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().intValue()));
        }
        sb5.append(ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
        sb5.append(']');
        return sb5.toString();
    }

    public final SnapshotIdSet and(SnapshotIdSet bits) {
        Intrinsics.checkNotNullParameter(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (Intrinsics.areEqual(bits, snapshotIdSet) || Intrinsics.areEqual(this, snapshotIdSet)) {
            return snapshotIdSet;
        }
        int i3 = bits.lowerBound;
        int i16 = this.lowerBound;
        if (i3 == i16) {
            int[] iArr = bits.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                long j3 = this.upperSet;
                long j16 = bits.upperSet;
                long j17 = j3 & j16;
                long j18 = this.lowerSet;
                long j19 = bits.lowerSet;
                return (j17 == 0 && (j18 & j19) == 0 && iArr2 == null) ? snapshotIdSet : new SnapshotIdSet(j16 & j3, j18 & j19, i16, iArr2);
            }
        }
        if (this.belowBound == null) {
            Iterator<Integer> it = iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (bits.get(intValue)) {
                    snapshotIdSet = snapshotIdSet.set(intValue);
                }
            }
            return snapshotIdSet;
        }
        Iterator<Integer> it5 = bits.iterator();
        while (it5.hasNext()) {
            int intValue2 = it5.next().intValue();
            if (get(intValue2)) {
                snapshotIdSet = snapshotIdSet.set(intValue2);
            }
        }
        return snapshotIdSet;
    }

    public final SnapshotIdSet clear(int bit) {
        int[] iArr;
        int binarySearch;
        int i3 = this.lowerBound;
        int i16 = bit - i3;
        if (i16 >= 0 && i16 < 64) {
            long j3 = 1 << i16;
            long j16 = this.lowerSet;
            if ((j16 & j3) != 0) {
                return new SnapshotIdSet(this.upperSet, j16 & (~j3), i3, this.belowBound);
            }
        } else if (i16 >= 64 && i16 < 128) {
            long j17 = 1 << (i16 - 64);
            long j18 = this.upperSet;
            if ((j18 & j17) != 0) {
                return new SnapshotIdSet(j18 & (~j17), this.lowerSet, i3, this.belowBound);
            }
        } else if (i16 < 0 && (iArr = this.belowBound) != null && (binarySearch = SnapshotIdSetKt.binarySearch(iArr, bit)) >= 0) {
            int length = iArr.length - 1;
            if (length == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] iArr2 = new int[length];
            if (binarySearch > 0) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, 0, binarySearch);
            }
            if (binarySearch < length) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, binarySearch, binarySearch + 1, length + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
    
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.toIntArray(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SnapshotIdSet set(int bit) {
        int i3;
        int[] iArr;
        int i16 = this.lowerBound;
        int i17 = bit - i16;
        long j3 = 0;
        if (i17 >= 0 && i17 < 64) {
            long j16 = 1 << i17;
            long j17 = this.lowerSet;
            if ((j17 & j16) == 0) {
                return new SnapshotIdSet(this.upperSet, j17 | j16, i16, this.belowBound);
            }
        } else if (i17 >= 64 && i17 < 128) {
            long j18 = 1 << (i17 - 64);
            long j19 = this.upperSet;
            if ((j19 & j18) == 0) {
                return new SnapshotIdSet(j19 | j18, this.lowerSet, i16, this.belowBound);
            }
        } else if (i17 >= 128) {
            if (!get(bit)) {
                long j26 = this.upperSet;
                long j27 = this.lowerSet;
                int i18 = this.lowerBound;
                int i19 = ((bit + 1) / 64) * 64;
                ArrayList arrayList = null;
                long j28 = j27;
                long j29 = j26;
                while (true) {
                    if (i18 >= i19) {
                        i3 = i18;
                        break;
                    }
                    if (j28 != j3) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            int[] iArr2 = this.belowBound;
                            if (iArr2 != null) {
                                for (int i26 : iArr2) {
                                    arrayList.add(Integer.valueOf(i26));
                                }
                            }
                        }
                        for (int i27 = 0; i27 < 64; i27++) {
                            if (((1 << i27) & j28) != 0) {
                                arrayList.add(Integer.valueOf(i27 + i18));
                            }
                        }
                        j3 = 0;
                    }
                    if (j29 == j3) {
                        i3 = i19;
                        j28 = j3;
                        break;
                    }
                    i18 += 64;
                    j28 = j29;
                    j29 = j3;
                }
                if (arrayList == null || iArr == null) {
                    iArr = this.belowBound;
                }
                return new SnapshotIdSet(j29, j28, i3, iArr).set(bit);
            }
        } else {
            int[] iArr3 = this.belowBound;
            if (iArr3 == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, i16, new int[]{bit});
            }
            int binarySearch = SnapshotIdSetKt.binarySearch(iArr3, bit);
            if (binarySearch < 0) {
                int i28 = -(binarySearch + 1);
                int length = iArr3.length + 1;
                int[] iArr4 = new int[length];
                ArraysKt___ArraysJvmKt.copyInto(iArr3, iArr4, 0, 0, i28);
                ArraysKt___ArraysJvmKt.copyInto(iArr3, iArr4, i28 + 1, i28, length - 1);
                iArr4[i28] = bit;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr4);
            }
        }
        return this;
    }
}
