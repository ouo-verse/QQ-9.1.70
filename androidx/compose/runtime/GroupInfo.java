package androidx.compose.runtime;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/GroupInfo;", "", "slotIndex", "", "nodeIndex", "nodeCount", "(III)V", "getNodeCount", "()I", "setNodeCount", "(I)V", "getNodeIndex", "setNodeIndex", "getSlotIndex", "setSlotIndex", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
final class GroupInfo {
    private int nodeCount;
    private int nodeIndex;
    private int slotIndex;

    public GroupInfo(int i3, int i16, int i17) {
        this.slotIndex = i3;
        this.nodeIndex = i16;
        this.nodeCount = i17;
    }

    public final int getNodeCount() {
        return this.nodeCount;
    }

    public final int getNodeIndex() {
        return this.nodeIndex;
    }

    public final int getSlotIndex() {
        return this.slotIndex;
    }

    public final void setNodeCount(int i3) {
        this.nodeCount = i3;
    }

    public final void setNodeIndex(int i3) {
        this.nodeIndex = i3;
    }

    public final void setSlotIndex(int i3) {
        this.slotIndex = i3;
    }
}
