package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u001c\n\u0002\b\n\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001e\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a;\u0010\"\u001a\u00020#*\u0012\u0012\u0004\u0012\u00020#0$j\b\u0012\u0004\u0012\u00020#`%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0)H\u0082\b\u001a\u0014\u0010*\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010+\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a\u0014\u0010-\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010.\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010/\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001aD\u00100\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0002\u001a\u0014\u00102\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u00101\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a,\u00107\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020#0$j\b\u0012\u0004\u0012\u00020#`%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a\u0014\u00108\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a\u0014\u0010:\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u0010;\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0014\u00105\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u0001H\u0002\u001a,\u0010=\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020#0$j\b\u0012\u0004\u0012\u00020#`%2\u0006\u0010>\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002\u001a \u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010 *\u00020\u00182\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00010AH\u0002\u001a\u0014\u0010B\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u001c\u0010C\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u001cH\u0002\u001a\u001c\u0010D\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u0001H\u0002\u001a\u001c\u0010F\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0002\u001a\u001c\u0010G\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u001c\u0010H\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u001cH\u0002\u001a\u001c\u0010I\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u001a\u001c\u0010J\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Aux_Mask", "", "Aux_Shift", "ContainsMark_Mask", "DataAnchor_Offset", "GroupInfo_Offset", "Group_Fields_Size", "Key_Offset", "Mark_Mask", "MinGroupGrowthSize", "MinSlotsGrowthSize", "NodeBit_Mask", "NodeCount_Mask", "NodeKey", "ObjectKey_Mask", "ObjectKey_Shift", "ParentAnchor_Offset", "Size_Offset", "Slots_Shift", "parentAnchorPivot", "countOneBits", "value", "addAux", "", "", "address", "auxIndex", "containsAnyMark", "", "containsMark", "dataAnchor", "dataAnchors", "", com.tencent.luggage.wxa.c8.c.E, "getOrAdd", "Landroidx/compose/runtime/Anchor;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "effectiveSize", "block", "Lkotlin/Function0;", "groupInfo", "groupSize", "groupSizes", "hasAux", "hasMark", "hasObjectKey", "initGroup", "key", "isNode", "hasDataKey", "hasData", "parentAnchor", "keys", "locationOf", "nodeCount", "nodeCounts", "nodeIndex", "objectKeyIndex", "parentAnchors", "search", "location", "slice", "indices", "", "slotAnchor", "updateContainsMark", "updateDataAnchor", "anchor", "updateGroupKey", "updateGroupSize", "updateMark", "updateNodeCount", "updateParentAnchor", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SlotTableKt {
    private static final int Aux_Mask = 268435456;
    private static final int Aux_Shift = 28;
    private static final int ContainsMark_Mask = 67108864;
    private static final int DataAnchor_Offset = 4;
    private static final int GroupInfo_Offset = 1;
    private static final int Group_Fields_Size = 5;
    private static final int Key_Offset = 0;
    private static final int Mark_Mask = 134217728;
    private static final int MinGroupGrowthSize = 32;
    private static final int MinSlotsGrowthSize = 32;
    private static final int NodeBit_Mask = 1073741824;
    private static final int NodeCount_Mask = 67108863;
    private static final int NodeKey = 125;
    private static final int ObjectKey_Mask = 536870912;
    private static final int ObjectKey_Shift = 29;
    private static final int ParentAnchor_Offset = 2;
    private static final int Size_Offset = 3;
    private static final int Slots_Shift = 28;
    private static final int parentAnchorPivot = -2;

    public static final /* synthetic */ int access$auxIndex(int[] iArr, int i3) {
        return auxIndex(iArr, i3);
    }

    public static final /* synthetic */ boolean access$containsAnyMark(int[] iArr, int i3) {
        return containsAnyMark(iArr, i3);
    }

    public static final /* synthetic */ boolean access$containsMark(int[] iArr, int i3) {
        return containsMark(iArr, i3);
    }

    public static final /* synthetic */ int access$dataAnchor(int[] iArr, int i3) {
        return dataAnchor(iArr, i3);
    }

    public static final /* synthetic */ List access$dataAnchors(int[] iArr, int i3) {
        return dataAnchors(iArr, i3);
    }

    public static final /* synthetic */ int access$groupSize(int[] iArr, int i3) {
        return groupSize(iArr, i3);
    }

    public static final /* synthetic */ List access$groupSizes(int[] iArr, int i3) {
        return groupSizes(iArr, i3);
    }

    public static final /* synthetic */ boolean access$hasAux(int[] iArr, int i3) {
        return hasAux(iArr, i3);
    }

    public static final /* synthetic */ boolean access$hasMark(int[] iArr, int i3) {
        return hasMark(iArr, i3);
    }

    public static final /* synthetic */ boolean access$hasObjectKey(int[] iArr, int i3) {
        return hasObjectKey(iArr, i3);
    }

    public static final /* synthetic */ boolean access$isNode(int[] iArr, int i3) {
        return isNode(iArr, i3);
    }

    public static final /* synthetic */ int access$key(int[] iArr, int i3) {
        return key(iArr, i3);
    }

    public static final /* synthetic */ List access$keys(int[] iArr, int i3) {
        return keys(iArr, i3);
    }

    public static final /* synthetic */ int access$nodeCount(int[] iArr, int i3) {
        return nodeCount(iArr, i3);
    }

    public static final /* synthetic */ List access$nodeCounts(int[] iArr, int i3) {
        return nodeCounts(iArr, i3);
    }

    public static final /* synthetic */ int access$nodeIndex(int[] iArr, int i3) {
        return nodeIndex(iArr, i3);
    }

    public static final /* synthetic */ int access$objectKeyIndex(int[] iArr, int i3) {
        return objectKeyIndex(iArr, i3);
    }

    public static final /* synthetic */ int access$parentAnchor(int[] iArr, int i3) {
        return parentAnchor(iArr, i3);
    }

    public static final /* synthetic */ List access$parentAnchors(int[] iArr, int i3) {
        return parentAnchors(iArr, i3);
    }

    public static final /* synthetic */ int access$search(ArrayList arrayList, int i3, int i16) {
        return search(arrayList, i3, i16);
    }

    public static final /* synthetic */ int access$slotAnchor(int[] iArr, int i3) {
        return slotAnchor(iArr, i3);
    }

    public static final int countOneBits(int i3) {
        switch (i3) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
                return 1;
            case 3:
            case 5:
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    private static final Anchor getOrAdd(ArrayList<Anchor> arrayList, int i3, int i16, Function0<Anchor> function0) {
        int search = search(arrayList, i3, i16);
        if (search < 0) {
            Anchor invoke = function0.invoke();
            arrayList.add(-(search + 1), invoke);
            return invoke;
        }
        Anchor anchor = arrayList.get(search);
        Intrinsics.checkNotNullExpressionValue(anchor, "get(location)");
        return anchor;
    }

    public static final int locationOf(ArrayList<Anchor> arrayList, int i3, int i16) {
        int search = search(arrayList, i3, i16);
        return search >= 0 ? search : -(search + 1);
    }

    public static final int search(ArrayList<Anchor> arrayList, int i3, int i16) {
        int size = arrayList.size() - 1;
        int i17 = 0;
        while (i17 <= size) {
            int i18 = (i17 + size) >>> 1;
            int location = arrayList.get(i18).getLocation();
            if (location < 0) {
                location += i16;
            }
            int compare = Intrinsics.compare(location, i3);
            if (compare < 0) {
                i17 = i18 + 1;
            } else {
                if (compare <= 0) {
                    return i18;
                }
                size = i18 - 1;
            }
        }
        return -(i17 + 1);
    }

    private static final List<Integer> slice(int[] iArr, Iterable<Integer> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Integer> dataAnchors(int[] iArr, int i3) {
        IntRange until;
        IntProgression step;
        until = RangesKt___RangesKt.until(4, i3);
        step = RangesKt___RangesKt.step(until, 5);
        return slice(iArr, step);
    }

    public static final List<Integer> groupSizes(int[] iArr, int i3) {
        IntRange until;
        IntProgression step;
        until = RangesKt___RangesKt.until(3, i3);
        step = RangesKt___RangesKt.step(until, 5);
        return slice(iArr, step);
    }

    public static final List<Integer> keys(int[] iArr, int i3) {
        IntRange until;
        IntProgression step;
        until = RangesKt___RangesKt.until(0, i3);
        step = RangesKt___RangesKt.step(until, 5);
        return slice(iArr, step);
    }

    public static final List<Integer> nodeCounts(int[] iArr, int i3) {
        IntRange until;
        IntProgression step;
        until = RangesKt___RangesKt.until(1, i3);
        step = RangesKt___RangesKt.step(until, 5);
        List<Integer> slice = slice(iArr, step);
        ArrayList arrayList = new ArrayList(slice.size());
        int size = slice.size();
        for (int i16 = 0; i16 < size; i16++) {
            arrayList.add(Integer.valueOf(slice.get(i16).intValue() & NodeCount_Mask));
        }
        return arrayList;
    }

    public static final List<Integer> parentAnchors(int[] iArr, int i3) {
        IntRange until;
        IntProgression step;
        until = RangesKt___RangesKt.until(2, i3);
        step = RangesKt___RangesKt.step(until, 5);
        return slice(iArr, step);
    }

    public static final int auxIndex(int[] iArr, int i3) {
        int i16 = i3 * 5;
        if (i16 >= iArr.length) {
            return iArr.length;
        }
        return countOneBits(iArr[i16 + 1] >> 29) + iArr[i16 + 4];
    }

    public static final int key(int[] iArr, int i3) {
        return iArr[i3 * 5];
    }

    public static final void addAux(int[] iArr, int i3) {
        int i16 = (i3 * 5) + 1;
        iArr[i16] = iArr[i16] | 268435456;
    }

    public static final boolean containsAnyMark(int[] iArr, int i3) {
        return (iArr[(i3 * 5) + 1] & 201326592) != 0;
    }

    public static final boolean containsMark(int[] iArr, int i3) {
        return (iArr[(i3 * 5) + 1] & 67108864) != 0;
    }

    public static final int dataAnchor(int[] iArr, int i3) {
        return iArr[(i3 * 5) + 4];
    }

    public static /* synthetic */ List dataAnchors$default(int[] iArr, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = iArr.length;
        }
        return dataAnchors(iArr, i3);
    }

    public static final int groupInfo(int[] iArr, int i3) {
        return iArr[(i3 * 5) + 1];
    }

    public static final int groupSize(int[] iArr, int i3) {
        return iArr[(i3 * 5) + 3];
    }

    static /* synthetic */ List groupSizes$default(int[] iArr, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = iArr.length;
        }
        return groupSizes(iArr, i3);
    }

    public static final boolean hasAux(int[] iArr, int i3) {
        return (iArr[(i3 * 5) + 1] & 268435456) != 0;
    }

    public static final boolean hasMark(int[] iArr, int i3) {
        return (iArr[(i3 * 5) + 1] & 134217728) != 0;
    }

    public static final boolean hasObjectKey(int[] iArr, int i3) {
        return (iArr[(i3 * 5) + 1] & 536870912) != 0;
    }

    public static final boolean isNode(int[] iArr, int i3) {
        return (iArr[(i3 * 5) + 1] & 1073741824) != 0;
    }

    public static /* synthetic */ List keys$default(int[] iArr, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = iArr.length;
        }
        return keys(iArr, i3);
    }

    public static final int nodeCount(int[] iArr, int i3) {
        return iArr[(i3 * 5) + 1] & NodeCount_Mask;
    }

    static /* synthetic */ List nodeCounts$default(int[] iArr, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = iArr.length;
        }
        return nodeCounts(iArr, i3);
    }

    public static final int nodeIndex(int[] iArr, int i3) {
        return iArr[(i3 * 5) + 4];
    }

    public static final int objectKeyIndex(int[] iArr, int i3) {
        int i16 = i3 * 5;
        return iArr[i16 + 4] + countOneBits(iArr[i16 + 1] >> 30);
    }

    public static final int parentAnchor(int[] iArr, int i3) {
        return iArr[(i3 * 5) + 2];
    }

    static /* synthetic */ List parentAnchors$default(int[] iArr, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = iArr.length;
        }
        return parentAnchors(iArr, i3);
    }

    public static final int slotAnchor(int[] iArr, int i3) {
        int i16 = i3 * 5;
        return iArr[i16 + 4] + countOneBits(iArr[i16 + 1] >> 28);
    }

    public static final void updateDataAnchor(int[] iArr, int i3, int i16) {
        iArr[(i3 * 5) + 4] = i16;
    }

    private static final void updateGroupKey(int[] iArr, int i3, int i16) {
        iArr[(i3 * 5) + 0] = i16;
    }

    public static final void updateParentAnchor(int[] iArr, int i3, int i16) {
        iArr[(i3 * 5) + 2] = i16;
    }

    public static final void updateContainsMark(int[] iArr, int i3, boolean z16) {
        int i16 = (i3 * 5) + 1;
        if (z16) {
            iArr[i16] = iArr[i16] | 67108864;
        } else {
            iArr[i16] = iArr[i16] & (-67108865);
        }
    }

    public static final void updateMark(int[] iArr, int i3, boolean z16) {
        int i16 = (i3 * 5) + 1;
        if (z16) {
            iArr[i16] = iArr[i16] | 134217728;
        } else {
            iArr[i16] = iArr[i16] & (-134217729);
        }
    }

    public static final void updateGroupSize(int[] iArr, int i3, int i16) {
        if (i16 >= 0) {
            iArr[(i3 * 5) + 3] = i16;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final void updateNodeCount(int[] iArr, int i3, int i16) {
        if (i16 >= 0 && i16 < NodeCount_Mask) {
            int i17 = (i3 * 5) + 1;
            iArr[i17] = i16 | (iArr[i17] & (-67108864));
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final void initGroup(int[] iArr, int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, int i18) {
        int i19 = z16 ? 1073741824 : 0;
        int i26 = z17 ? 536870912 : 0;
        int i27 = z18 ? 268435456 : 0;
        int i28 = i3 * 5;
        iArr[i28 + 0] = i16;
        iArr[i28 + 1] = i19 | i26 | i27;
        iArr[i28 + 2] = i17;
        iArr[i28 + 3] = 0;
        iArr[i28 + 4] = i18;
    }
}
