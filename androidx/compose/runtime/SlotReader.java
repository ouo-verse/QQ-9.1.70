package androidx.compose.runtime;

import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020=J\u000e\u0010?\u001a\u00020$2\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010@\u001a\u00020=J\u0006\u0010A\u001a\u00020=J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CJO\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\u000628\u0010G\u001a4\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020=0HH\u0000\u00a2\u0006\u0002\bLJ\u0010\u0010M\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u0010\u0010N\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u0018\u0010N\u001a\u0004\u0018\u00010\u00012\u0006\u0010F\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u00109\u001a\u00020:J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010O\u001a\u00020$2\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010P\u001a\u00020$2\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020$2\u0006\u0010;\u001a\u00020\u0006J\b\u0010Q\u001a\u0004\u0018\u00010\u0001J\u0010\u0010R\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010S\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010T\u001a\u00020=2\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010U\u001a\u00020=2\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010V\u001a\u00020\u0006J\u0006\u0010W\u001a\u00020=J\u0006\u0010X\u001a\u00020=J\u0006\u0010Y\u001a\u00020=J\b\u0010Z\u001a\u00020[H\u0016J\u0016\u0010\\\u001a\u0004\u0018\u00010\u0001*\u00020!2\u0006\u0010;\u001a\u00020\u0006H\u0002J\u0016\u0010R\u001a\u0004\u0018\u00010\u0001*\u00020!2\u0006\u0010;\u001a\u00020\u0006H\u0002J\u0016\u0010]\u001a\u0004\u0018\u00010\u0001*\u00020!2\u0006\u0010;\u001a\u00020\u0006H\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010&R\u0011\u0010(\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010&R\u0011\u0010)\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\tR\u001e\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR\u0011\u0010-\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\tR\u0011\u0010/\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\tR\u0011\u00101\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b2\u0010\tR\u0018\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000104X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108\u00a8\u0006^"}, d2 = {"Landroidx/compose/runtime/SlotReader;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "<set-?>", "", "currentEnd", "getCurrentEnd", "()I", "currentGroup", "getCurrentGroup", "currentSlot", "currentSlotEnd", "emptyCount", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupNode", "getGroupNode", "groupObjectKey", "getGroupObjectKey", "groupSize", "getGroupSize", "groupSlotCount", "getGroupSlotCount", "groupSlotIndex", "getGroupSlotIndex", "groups", "", "groupsSize", "inEmpty", "", "getInEmpty", "()Z", "isGroupEnd", "isNode", "nodeCount", "getNodeCount", HippyNestedScrollComponent.PRIORITY_PARENT, "getParent", "parentNodes", "getParentNodes", "size", "getSize", "slot", "getSlot", "slots", "", "[Ljava/lang/Object;", "slotsSize", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "index", "beginEmpty", "", "close", "containsMark", "endEmpty", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "forEachData", VipFunCallConstants.KEY_GROUP, "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "forEachData$runtime_release", "get", "groupGet", "hasMark", "hasObjectKey", "next", "node", "parentOf", "reposition", "restoreParent", "skipGroup", "skipToGroupEnd", "startGroup", "startNode", "toString", "", "aux", "objectKey", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SlotReader {

    /* renamed from: currentEnd, reason: from kotlin metadata and from toString */
    private int end;

    /* renamed from: currentGroup, reason: from kotlin metadata and from toString */
    private int current;
    private int currentSlot;
    private int currentSlotEnd;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private int parent;
    private final Object[] slots;
    private final int slotsSize;
    private final SlotTable table;

    public SlotReader(SlotTable table) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.groups = table.getGroups();
        int groupsSize = table.getGroupsSize();
        this.groupsSize = groupsSize;
        this.slots = table.getSlots();
        this.slotsSize = table.getSlotsSize();
        this.end = groupsSize;
        this.parent = -1;
    }

    private final Object aux(int[] iArr, int i3) {
        boolean hasAux;
        int auxIndex;
        hasAux = SlotTableKt.hasAux(iArr, i3);
        if (hasAux) {
            Object[] objArr = this.slots;
            auxIndex = SlotTableKt.auxIndex(iArr, i3);
            return objArr[auxIndex];
        }
        return Composer.INSTANCE.getEmpty();
    }

    private final Object objectKey(int[] iArr, int i3) {
        boolean hasObjectKey;
        int objectKeyIndex;
        hasObjectKey = SlotTableKt.hasObjectKey(iArr, i3);
        if (!hasObjectKey) {
            return null;
        }
        Object[] objArr = this.slots;
        objectKeyIndex = SlotTableKt.objectKeyIndex(iArr, i3);
        return objArr[objectKeyIndex];
    }

    public final Anchor anchor(int index) {
        ArrayList<Anchor> anchors$runtime_release = this.table.getAnchors$runtime_release();
        int search = SlotTableKt.search(anchors$runtime_release, index, this.groupsSize);
        if (search < 0) {
            Anchor anchor = new Anchor(index);
            anchors$runtime_release.add(-(search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = anchors$runtime_release.get(search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void close() {
        this.table.close$runtime_release(this);
    }

    public final boolean containsMark(int index) {
        boolean containsMark;
        containsMark = SlotTableKt.containsMark(this.groups, index);
        return containsMark;
    }

    public final void endEmpty() {
        int i3 = this.emptyCount;
        if (i3 > 0) {
            this.emptyCount = i3 - 1;
            return;
        }
        throw new IllegalArgumentException("Unbalanced begin/end empty".toString());
    }

    public final void endGroup() {
        int parentAnchor;
        int groupSize;
        int i3;
        if (this.emptyCount == 0) {
            if (this.current == this.end) {
                parentAnchor = SlotTableKt.parentAnchor(this.groups, this.parent);
                this.parent = parentAnchor;
                if (parentAnchor >= 0) {
                    groupSize = SlotTableKt.groupSize(this.groups, parentAnchor);
                    i3 = parentAnchor + groupSize;
                } else {
                    i3 = this.groupsSize;
                }
                this.end = i3;
                return;
            }
            throw new IllegalArgumentException("endGroup() not called at the end of a group".toString());
        }
    }

    public final List<KeyInfo> extractKeys() {
        int key;
        boolean isNode;
        int groupSize;
        ArrayList arrayList = new ArrayList();
        if (this.emptyCount > 0) {
            return arrayList;
        }
        int i3 = this.current;
        int i16 = 0;
        while (i3 < this.end) {
            key = SlotTableKt.key(this.groups, i3);
            Object objectKey = objectKey(this.groups, i3);
            isNode = SlotTableKt.isNode(this.groups, i3);
            arrayList.add(new KeyInfo(key, objectKey, i3, isNode ? 1 : SlotTableKt.nodeCount(this.groups, i3), i16));
            groupSize = SlotTableKt.groupSize(this.groups, i3);
            i3 += groupSize;
            i16++;
        }
        return arrayList;
    }

    public final void forEachData$runtime_release(int r56, Function2<? super Integer, Object, Unit> block) {
        int slotAnchor;
        int slotsSize;
        Intrinsics.checkNotNullParameter(block, "block");
        slotAnchor = SlotTableKt.slotAnchor(this.groups, r56);
        int i3 = r56 + 1;
        if (i3 < this.table.getGroupsSize()) {
            slotsSize = SlotTableKt.dataAnchor(this.table.getGroups(), i3);
        } else {
            slotsSize = this.table.getSlotsSize();
        }
        for (int i16 = slotAnchor; i16 < slotsSize; i16++) {
            block.invoke(Integer.valueOf(i16 - slotAnchor), this.slots[i16]);
        }
    }

    public final Object get(int index) {
        int i3 = this.currentSlot + index;
        if (i3 < this.currentSlotEnd) {
            return this.slots[i3];
        }
        return Composer.INSTANCE.getEmpty();
    }

    /* renamed from: getCurrentEnd, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* renamed from: getCurrentGroup, reason: from getter */
    public final int getCurrent() {
        return this.current;
    }

    public final Object getGroupAux() {
        int i3 = this.current;
        if (i3 < this.end) {
            return aux(this.groups, i3);
        }
        return 0;
    }

    public final int getGroupEnd() {
        return this.end;
    }

    public final int getGroupKey() {
        int key;
        int i3 = this.current;
        if (i3 >= this.end) {
            return 0;
        }
        key = SlotTableKt.key(this.groups, i3);
        return key;
    }

    public final Object getGroupNode() {
        int i3 = this.current;
        if (i3 < this.end) {
            return node(this.groups, i3);
        }
        return null;
    }

    public final Object getGroupObjectKey() {
        int i3 = this.current;
        if (i3 < this.end) {
            return objectKey(this.groups, i3);
        }
        return null;
    }

    public final int getGroupSize() {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, this.current);
        return groupSize;
    }

    public final int getGroupSlotCount() {
        int slotAnchor;
        int i3;
        int i16 = this.current;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, i16);
        int i17 = i16 + 1;
        if (i17 < this.groupsSize) {
            i3 = SlotTableKt.dataAnchor(this.groups, i17);
        } else {
            i3 = this.slotsSize;
        }
        return i3 - slotAnchor;
    }

    public final int getGroupSlotIndex() {
        int slotAnchor;
        int i3 = this.currentSlot;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, this.parent);
        return i3 - slotAnchor;
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getNodeCount() {
        int nodeCount;
        nodeCount = SlotTableKt.nodeCount(this.groups, this.current);
        return nodeCount;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int nodeCount;
        int i3 = this.parent;
        if (i3 < 0) {
            return 0;
        }
        nodeCount = SlotTableKt.nodeCount(this.groups, i3);
        return nodeCount;
    }

    /* renamed from: getSize, reason: from getter */
    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        int slotAnchor;
        int i3 = this.currentSlot;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, this.parent);
        return i3 - slotAnchor;
    }

    /* renamed from: getTable$runtime_release, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final Object groupAux(int index) {
        return aux(this.groups, index);
    }

    public final int groupEnd(int index) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, index);
        return index + groupSize;
    }

    public final Object groupGet(int index) {
        return groupGet(this.current, index);
    }

    public final int groupKey(int index) {
        int key;
        key = SlotTableKt.key(this.groups, index);
        return key;
    }

    public final Object groupObjectKey(int index) {
        return objectKey(this.groups, index);
    }

    public final int groupSize(int index) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, index);
        return groupSize;
    }

    public final boolean hasMark(int index) {
        boolean hasMark;
        hasMark = SlotTableKt.hasMark(this.groups, index);
        return hasMark;
    }

    public final boolean hasObjectKey(int index) {
        boolean hasObjectKey;
        hasObjectKey = SlotTableKt.hasObjectKey(this.groups, index);
        return hasObjectKey;
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.current == this.end;
    }

    public final boolean isNode() {
        boolean isNode;
        isNode = SlotTableKt.isNode(this.groups, this.current);
        return isNode;
    }

    public final Object next() {
        int i3;
        if (this.emptyCount <= 0 && (i3 = this.currentSlot) < this.currentSlotEnd) {
            Object[] objArr = this.slots;
            this.currentSlot = i3 + 1;
            return objArr[i3];
        }
        return Composer.INSTANCE.getEmpty();
    }

    public final Object node(int index) {
        boolean isNode;
        isNode = SlotTableKt.isNode(this.groups, index);
        if (isNode) {
            return node(this.groups, index);
        }
        return null;
    }

    public final int nodeCount(int index) {
        int nodeCount;
        nodeCount = SlotTableKt.nodeCount(this.groups, index);
        return nodeCount;
    }

    public final int parent(int i3) {
        int parentAnchor;
        parentAnchor = SlotTableKt.parentAnchor(this.groups, i3);
        return parentAnchor;
    }

    public final void reposition(int index) {
        int groupSize;
        if (this.emptyCount == 0) {
            this.current = index;
            int parentAnchor = index < this.groupsSize ? SlotTableKt.parentAnchor(this.groups, index) : -1;
            this.parent = parentAnchor;
            if (parentAnchor >= 0) {
                groupSize = SlotTableKt.groupSize(this.groups, parentAnchor);
                this.end = parentAnchor + groupSize;
            } else {
                this.end = this.groupsSize;
            }
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        throw new IllegalArgumentException("Cannot reposition while in an empty region".toString());
    }

    public final void restoreParent(int index) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, index);
        int i3 = groupSize + index;
        int i16 = this.current;
        if (i16 >= index && i16 <= i3) {
            this.parent = index;
            this.end = i3;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        throw new IllegalArgumentException(("Index " + index + " is not a parent of " + i16).toString());
    }

    public final int skipGroup() {
        boolean isNode;
        int groupSize;
        if (this.emptyCount == 0) {
            isNode = SlotTableKt.isNode(this.groups, this.current);
            int nodeCount = isNode ? 1 : SlotTableKt.nodeCount(this.groups, this.current);
            int i3 = this.current;
            groupSize = SlotTableKt.groupSize(this.groups, i3);
            this.current = i3 + groupSize;
            return nodeCount;
        }
        throw new IllegalArgumentException("Cannot skip while in an empty region".toString());
    }

    public final void skipToGroupEnd() {
        if (this.emptyCount == 0) {
            this.current = this.end;
            return;
        }
        throw new IllegalArgumentException("Cannot skip the enclosing group while in an empty region".toString());
    }

    public final void startGroup() {
        int parentAnchor;
        int groupSize;
        int slotAnchor;
        int dataAnchor;
        if (this.emptyCount <= 0) {
            parentAnchor = SlotTableKt.parentAnchor(this.groups, this.current);
            if (parentAnchor == this.parent) {
                int i3 = this.current;
                this.parent = i3;
                groupSize = SlotTableKt.groupSize(this.groups, i3);
                this.end = i3 + groupSize;
                int i16 = this.current;
                int i17 = i16 + 1;
                this.current = i17;
                slotAnchor = SlotTableKt.slotAnchor(this.groups, i16);
                this.currentSlot = slotAnchor;
                if (i16 < this.groupsSize - 1) {
                    dataAnchor = SlotTableKt.dataAnchor(this.groups, i17);
                } else {
                    dataAnchor = this.slotsSize;
                }
                this.currentSlotEnd = dataAnchor;
                return;
            }
            throw new IllegalArgumentException("Invalid slot table detected".toString());
        }
    }

    public final void startNode() {
        boolean isNode;
        if (this.emptyCount <= 0) {
            isNode = SlotTableKt.isNode(this.groups, this.current);
            if (isNode) {
                startGroup();
                return;
            }
            throw new IllegalArgumentException("Expected a node group".toString());
        }
    }

    public String toString() {
        return "SlotReader(current=" + this.current + ", key=" + getGroupKey() + ", parent=" + this.parent + ", end=" + this.end + ')';
    }

    private final Object node(int[] iArr, int i3) {
        boolean isNode;
        int nodeIndex;
        isNode = SlotTableKt.isNode(iArr, i3);
        if (isNode) {
            Object[] objArr = this.slots;
            nodeIndex = SlotTableKt.nodeIndex(iArr, i3);
            return objArr[nodeIndex];
        }
        return Composer.INSTANCE.getEmpty();
    }

    public final Object groupGet(int r36, int index) {
        int slotAnchor;
        slotAnchor = SlotTableKt.slotAnchor(this.groups, r36);
        int i3 = r36 + 1;
        int i16 = slotAnchor + index;
        return i16 < (i3 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i3) : this.slotsSize) ? this.slots[i16] : Composer.INSTANCE.getEmpty();
    }

    public final int groupKey(Anchor anchor) {
        int key;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!anchor.getValid()) {
            return 0;
        }
        key = SlotTableKt.key(this.groups, this.table.anchorIndex(anchor));
        return key;
    }

    public final boolean isNode(int index) {
        boolean isNode;
        isNode = SlotTableKt.isNode(this.groups, index);
        return isNode;
    }

    public final int parentOf(int index) {
        int parentAnchor;
        if (index >= 0 && index < this.groupsSize) {
            parentAnchor = SlotTableKt.parentAnchor(this.groups, index);
            return parentAnchor;
        }
        throw new IllegalArgumentException(("Invalid group index " + index).toString());
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader slotReader, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = slotReader.current;
        }
        return slotReader.anchor(i3);
    }
}
