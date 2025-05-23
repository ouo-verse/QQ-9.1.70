package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010.\u001a\u00020/J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000\u00a2\u0006\u0002\b4JW\u00100\u001a\u0002012\u0006\u0010)\u001a\u0002052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000\u00a2\u0006\u0004\b4\u00106J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\u001508H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0015H\u0002J\u0016\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001508H\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u0015H\u0002J\u001d\u0010@\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001082\u0006\u0010A\u001a\u00020\u0015H\u0000\u00a2\u0006\u0002\bBJ\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030DH\u0096\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001508H\u0002J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001508H\u0002J\u0006\u0010G\u001a\u000203J\u0006\u0010H\u001a\u000205J\u000e\u0010I\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001508H\u0002J:\u0010K\u001a\u0002HL\"\u0004\b\u0000\u0010L2!\u0010M\u001a\u001d\u0012\u0013\u0012\u001103\u00a2\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002HL0NH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010QJO\u0010R\u001a\u0002012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000\u00a2\u0006\u0004\bS\u0010TJ\u001d\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e082\u0006\u0010;\u001a\u00020\u0015H\u0000\u00a2\u0006\u0002\bVJ\u0006\u0010W\u001a\u000201J:\u0010X\u001a\u0002HL\"\u0004\b\u0000\u0010L2!\u0010M\u001a\u001d\u0012\u0013\u0012\u001105\u00a2\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b()\u0012\u0004\u0012\u0002HL0NH\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010QJ \u0010Y\u001a\u00020\u0015*\u00060Zj\u0002`[2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010\\\u001a\u00020\u0015H\u0002R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R0\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0015X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006]"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchor", "index", "anchorIndex", "asString", "", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "dataIndexes", "", "findEffectiveRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", VipFunCallConstants.KEY_GROUP, "groupContainsAnchor", "groupIndex", "groupSizes", "invalidateGroup", "invalidateGroupsWithKey", "target", "invalidateGroupsWithKey$runtime_release", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", k.f247491e, "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "slotsOf", "slotsOf$runtime_release", "verifyWellFormed", k.f247492f, "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private int version;
    private boolean writer;
    private int[] groups = new int[0];
    private Object[] slots = new Object[0];
    private ArrayList<Anchor> anchors = new ArrayList<>();

    private final List<Integer> dataIndexes() {
        return SlotTableKt.access$dataAnchors(this.groups, this.groupsSize * 5);
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i3) {
        if (i3 >= slotTable.groupsSize) {
            return slotTable.slotsSize;
        }
        return SlotTableKt.access$dataAnchor(slotTable.groups, i3);
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.access$groupSizes(this.groups, this.groupsSize * 5);
    }

    /* renamed from: invalidateGroupsWithKey$lambda-14$scanGroup, reason: not valid java name */
    private static final void m17invalidateGroupsWithKey$lambda14$scanGroup(SlotReader slotReader, int i3, List<Anchor> list, Ref.BooleanRef booleanRef, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        if (slotReader.getGroupKey() == i3) {
            list.add(SlotReader.anchor$default(slotReader, 0, 1, null));
            if (booleanRef.element) {
                RecomposeScopeImpl findEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getCurrent());
                if (findEffectiveRecomposeScope != null) {
                    list2.add(findEffectiveRecomposeScope);
                } else {
                    booleanRef.element = false;
                    list2.clear();
                }
            }
            slotReader.skipGroup();
            return;
        }
        slotReader.startGroup();
        while (!slotReader.isGroupEnd()) {
            m17invalidateGroupsWithKey$lambda14$scanGroup(slotReader, i3, list, booleanRef, slotTable, list2);
        }
        slotReader.endGroup();
    }

    private final List<Integer> keys() {
        return SlotTableKt.access$keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.access$nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.access$parentAnchors(this.groups, this.groupsSize * 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static final int verifyWellFormed$validateGroup(Ref.IntRef intRef, SlotTable slotTable, int i3, int i16) {
        int access$dataAnchor;
        int i17 = intRef.element;
        int i18 = i17 + 1;
        intRef.element = i18;
        int access$parentAnchor = SlotTableKt.access$parentAnchor(slotTable.groups, i17);
        if ((access$parentAnchor == i3) != false) {
            int access$groupSize = SlotTableKt.access$groupSize(slotTable.groups, i17) + i17;
            if ((access$groupSize <= slotTable.groupsSize) != true) {
                throw new IllegalStateException(("A group extends past the end of the table at " + i17).toString());
            }
            if ((access$groupSize <= i16) != false) {
                int access$dataAnchor2 = SlotTableKt.access$dataAnchor(slotTable.groups, i17);
                if (i17 >= slotTable.groupsSize - 1) {
                    access$dataAnchor = slotTable.slotsSize;
                } else {
                    access$dataAnchor = SlotTableKt.access$dataAnchor(slotTable.groups, i18);
                }
                if ((access$dataAnchor <= slotTable.slots.length) != true) {
                    throw new IllegalStateException(("Slots for " + i17 + " extend past the end of the slot table").toString());
                }
                if ((access$dataAnchor2 <= access$dataAnchor) != false) {
                    if ((SlotTableKt.access$slotAnchor(slotTable.groups, i17) <= access$dataAnchor) != true) {
                        throw new IllegalStateException(("Slots start out of range at " + i17).toString());
                    }
                    if ((access$dataAnchor - access$dataAnchor2 >= ((SlotTableKt.access$isNode(slotTable.groups, i17) ? 1 : 0) + (SlotTableKt.access$hasObjectKey(slotTable.groups, i17) ? 1 : 0)) + (SlotTableKt.access$hasAux(slotTable.groups, i17) ? 1 : 0)) != false) {
                        boolean access$isNode = SlotTableKt.access$isNode(slotTable.groups, i17);
                        if (((access$isNode && slotTable.slots[SlotTableKt.access$nodeIndex(slotTable.groups, i17)] == null) ? false : true) != false) {
                            int i19 = 0;
                            while (intRef.element < access$groupSize) {
                                i19 += verifyWellFormed$validateGroup(intRef, slotTable, i17, access$groupSize);
                            }
                            int access$nodeCount = SlotTableKt.access$nodeCount(slotTable.groups, i17);
                            int access$groupSize2 = SlotTableKt.access$groupSize(slotTable.groups, i17);
                            if ((access$nodeCount == i19) != false) {
                                int i26 = intRef.element - i17;
                                if ((access$groupSize2 == i26) != false) {
                                    if (SlotTableKt.access$containsAnyMark(slotTable.groups, i17)) {
                                        if (!(i17 <= 0 || SlotTableKt.access$containsMark(slotTable.groups, i3))) {
                                            throw new IllegalStateException(("Expected group " + i3 + " to record it contains a mark because " + i17 + " does").toString());
                                        }
                                    }
                                    if (access$isNode) {
                                        return 1;
                                    }
                                    return i19;
                                }
                                throw new IllegalStateException(("Incorrect slot count detected at " + i17 + ", expected " + access$groupSize2 + ", received " + i26).toString());
                            }
                            throw new IllegalStateException(("Incorrect node count detected at " + i17 + ", expected " + access$nodeCount + ", received " + i19).toString());
                        }
                        throw new IllegalStateException(("No node recorded for a node group at " + i17).toString());
                    }
                    throw new IllegalStateException(("Not enough slots added for group " + i17).toString());
                }
                throw new IllegalStateException(("Invalid data anchor at " + i17).toString());
            }
            throw new IllegalStateException(("A group extends past its parent group at " + i17).toString());
        }
        throw new IllegalStateException(("Invalid parent index detected at " + i17 + ", expected parent index to be " + i3 + " found " + access$parentAnchor).toString());
    }

    public final Anchor anchor(int index) {
        if (!this.writer) {
            boolean z16 = false;
            if (index >= 0 && index < this.groupsSize) {
                z16 = true;
            }
            if (z16) {
                ArrayList<Anchor> arrayList = this.anchors;
                int access$search = SlotTableKt.access$search(arrayList, index, this.groupsSize);
                if (access$search < 0) {
                    Anchor anchor = new Anchor(index);
                    arrayList.add(-(access$search + 1), anchor);
                    return anchor;
                }
                Anchor anchor2 = arrayList.get(access$search);
                Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
                return anchor2;
            }
            throw new IllegalArgumentException("Parameter index is out of range".toString());
        }
        ComposerKt.composeRuntimeError("use active SlotWriter to create an anchor location instead ".toString());
        throw new KotlinNothingValueException();
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!this.writer) {
            if (anchor.getValid()) {
                return anchor.getLocation();
            }
            throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
        }
        ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
        throw new KotlinNothingValueException();
    }

    public final String asString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append('\n');
        int i3 = this.groupsSize;
        if (i3 > 0) {
            int i16 = 0;
            while (i16 < i3) {
                i16 += emitGroup(sb5, i16, 0);
            }
        } else {
            sb5.append("<EMPTY>");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    public final void close$runtime_release(SlotReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (reader.getTable() == this && this.readers > 0) {
            this.readers--;
            return;
        }
        throw new IllegalArgumentException("Unexpected reader close()".toString());
    }

    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    /* renamed from: getVersion$runtime_release, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: getWriter$runtime_release, reason: from getter */
    public final boolean getWriter() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int groupIndex, Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!this.writer) {
            if (groupIndex >= 0 && groupIndex < this.groupsSize) {
                if (ownsAnchor(anchor)) {
                    int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndex) + groupIndex;
                    int location = anchor.getLocation();
                    if (groupIndex <= location && location < access$groupSize) {
                        return true;
                    }
                }
                return false;
            }
            ComposerKt.composeRuntimeError("Invalid group index".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Writer is active".toString());
        throw new KotlinNothingValueException();
    }

    public final List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release(int target) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        SlotReader openReader = openReader();
        try {
            m17invalidateGroupsWithKey$lambda14$scanGroup(openReader, target, arrayList, booleanRef, this, arrayList2);
            Unit unit = Unit.INSTANCE;
            openReader.close();
            SlotWriter openWriter = openWriter();
            try {
                openWriter.startGroup();
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Anchor anchor = (Anchor) arrayList.get(i3);
                    if (anchor.toIndexFor(openWriter) >= openWriter.getCurrentGroup()) {
                        openWriter.seek(anchor);
                        openWriter.bashGroup$runtime_release();
                    }
                }
                openWriter.skipToGroupEnd();
                openWriter.endGroup();
                openWriter.close();
                if (booleanRef.element) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th5) {
                openWriter.close();
                throw th5;
            }
        } catch (Throwable th6) {
            openReader.close();
            throw th6;
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final SlotReader openReader() {
        if (!this.writer) {
            this.readers++;
            return new SlotReader(this);
        }
        throw new IllegalStateException("Cannot read while a writer is pending".toString());
    }

    public final SlotWriter openWriter() {
        if (!this.writer) {
            if (this.readers <= 0) {
                this.writer = true;
                this.version++;
                return new SlotWriter(this);
            }
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
        throw new KotlinNothingValueException();
    }

    public final boolean ownsAnchor(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!anchor.getValid()) {
            return false;
        }
        int access$search = SlotTableKt.access$search(this.anchors, anchor.getLocation(), this.groupsSize);
        return access$search >= 0 && Intrinsics.areEqual(this.anchors.get(access$search), anchor);
    }

    public final <T> T read(Function1<? super SlotReader, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SlotReader openReader = openReader();
        try {
            return block.invoke(openReader);
        } finally {
            InlineMarker.finallyStart(1);
            openReader.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final void setAnchors$runtime_release(ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.anchors = arrayList;
    }

    public final void setTo$runtime_release(int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<Anchor> anchors) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(anchors, "anchors");
        this.groups = groups;
        this.groupsSize = groupsSize;
        this.slots = slots;
        this.slotsSize = slotsSize;
        this.anchors = anchors;
    }

    public final void setVersion$runtime_release(int i3) {
        this.version = i3;
    }

    public final List<Object> slotsOf$runtime_release(int group) {
        int length;
        List list;
        int access$dataAnchor = SlotTableKt.access$dataAnchor(this.groups, group);
        int i3 = group + 1;
        if (i3 < this.groupsSize) {
            length = SlotTableKt.access$dataAnchor(this.groups, i3);
        } else {
            length = this.slots.length;
        }
        list = ArraysKt___ArraysKt.toList(this.slots);
        return list.subList(access$dataAnchor, length);
    }

    public final void verifyWellFormed() {
        int i3;
        int i16;
        Ref.IntRef intRef = new Ref.IntRef();
        int i17 = -1;
        if (this.groupsSize > 0) {
            while (true) {
                i3 = intRef.element;
                i16 = this.groupsSize;
                if (i3 >= i16) {
                    break;
                } else {
                    verifyWellFormed$validateGroup(intRef, this, -1, i3 + SlotTableKt.access$groupSize(this.groups, i3));
                }
            }
            if (!(i3 == i16)) {
                throw new IllegalStateException(("Incomplete group at root " + intRef.element + " expected to be " + this.groupsSize).toString());
            }
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i18 = 0;
        while (i18 < size) {
            int indexFor = arrayList.get(i18).toIndexFor(this);
            if (!(indexFor >= 0 && indexFor <= this.groupsSize)) {
                throw new IllegalArgumentException("Location out of bound".toString());
            }
            if (!(i17 < indexFor)) {
                throw new IllegalArgumentException("Anchor is out of order".toString());
            }
            i18++;
            i17 = indexFor;
        }
    }

    public final <T> T write(Function1<? super SlotWriter, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SlotWriter openWriter = openWriter();
        try {
            return block.invoke(openWriter);
        } finally {
            InlineMarker.finallyStart(1);
            openWriter.close();
            InlineMarker.finallyEnd(1);
        }
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int group) {
        while (group > 0) {
            Iterator<Object> it = new DataIterator(this, group).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    return (RecomposeScopeImpl) next;
                }
            }
            group = SlotTableKt.access$parentAnchor(this.groups, group);
        }
        return null;
    }

    private final boolean invalidateGroup(int group) {
        while (group >= 0) {
            Iterator<Object> it = new DataIterator(this, group).iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) next;
                    recomposeScopeImpl.setRequiresRecompose(true);
                    return recomposeScopeImpl.invalidateForResult(null) != InvalidationResult.IGNORED;
                }
            }
            group = SlotTableKt.access$parentAnchor(this.groups, group);
        }
        return false;
    }

    public final void close$runtime_release(SlotWriter writer, int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<Anchor> anchors) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(slots, "slots");
        Intrinsics.checkNotNullParameter(anchors, "anchors");
        if (writer.getTable() == this && this.writer) {
            this.writer = false;
            setTo$runtime_release(groups, groupsSize, slots, slotsSize, anchors);
            return;
        }
        throw new IllegalArgumentException("Unexpected writer close()".toString());
    }

    private final int emitGroup(StringBuilder sb5, int i3, int i16) {
        boolean z16 = false;
        for (int i17 = 0; i17 < i16; i17++) {
            sb5.append(TokenParser.SP);
        }
        sb5.append("Group(");
        sb5.append(i3);
        sb5.append(") key=");
        sb5.append(SlotTableKt.access$key(this.groups, i3));
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, i3);
        sb5.append(", nodes=");
        sb5.append(SlotTableKt.access$nodeCount(this.groups, i3));
        sb5.append(", size=");
        sb5.append(access$groupSize);
        if (SlotTableKt.access$hasMark(this.groups, i3)) {
            sb5.append(", mark");
        }
        if (SlotTableKt.access$containsMark(this.groups, i3)) {
            sb5.append(", contains mark");
        }
        int emitGroup$dataIndex = emitGroup$dataIndex(this, i3);
        int i18 = i3 + 1;
        int emitGroup$dataIndex2 = emitGroup$dataIndex(this, i18);
        if (emitGroup$dataIndex >= 0 && emitGroup$dataIndex <= emitGroup$dataIndex2) {
            z16 = true;
        }
        if (z16 && emitGroup$dataIndex2 <= this.slotsSize) {
            if (SlotTableKt.access$hasObjectKey(this.groups, i3)) {
                sb5.append(" objectKey=" + this.slots[SlotTableKt.access$objectKeyIndex(this.groups, i3)]);
            }
            if (SlotTableKt.access$isNode(this.groups, i3)) {
                sb5.append(" node=" + this.slots[SlotTableKt.access$nodeIndex(this.groups, i3)]);
            }
            if (SlotTableKt.access$hasAux(this.groups, i3)) {
                sb5.append(" aux=" + this.slots[SlotTableKt.access$auxIndex(this.groups, i3)]);
            }
            int access$slotAnchor = SlotTableKt.access$slotAnchor(this.groups, i3);
            if (access$slotAnchor < emitGroup$dataIndex2) {
                sb5.append(", slots=[");
                sb5.append(access$slotAnchor);
                sb5.append(MsgSummary.STR_COLON);
                for (int i19 = access$slotAnchor; i19 < emitGroup$dataIndex2; i19++) {
                    if (i19 != access$slotAnchor) {
                        sb5.append(", ");
                    }
                    sb5.append(String.valueOf(this.slots[i19]));
                }
                sb5.append("]");
            }
        } else {
            sb5.append(", *invalid data offsets " + emitGroup$dataIndex + '-' + emitGroup$dataIndex2 + '*');
        }
        sb5.append('\n');
        int i26 = i3 + access$groupSize;
        while (i18 < i26) {
            i18 += emitGroup(sb5, i18, i16 + 1);
        }
        return access$groupSize;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }
}
