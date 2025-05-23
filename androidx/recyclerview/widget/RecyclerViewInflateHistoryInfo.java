package androidx.recyclerview.widget;

import com.tencent.biz.richframework.layoutinflater.PreloadRequest;
import com.tencent.richframework.argus.node.NodePO;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u00c6\u0003J!\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u00050\u0005H\u00c6\u0003JK\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052 \b\u0002\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u00050\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u0019"}, d2 = {"Landroidx/recyclerview/widget/RecyclerViewInflateHistoryInfo;", "", "nodeTreeTag", "Lcom/tencent/richframework/argus/node/NodePO;", "viewTypeToResLayoutId", "", "", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "viewTypeSubLayoutInfo", "(Lcom/tencent/richframework/argus/node/NodePO;Ljava/util/Map;Ljava/util/Map;)V", "getNodeTreeTag", "()Lcom/tencent/richframework/argus/node/NodePO;", "getViewTypeSubLayoutInfo", "()Ljava/util/Map;", "getViewTypeToResLayoutId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final /* data */ class RecyclerViewInflateHistoryInfo {

    @NotNull
    private final NodePO nodeTreeTag;

    @NotNull
    private final Map<Integer, Map<PreloadRequest, Integer>> viewTypeSubLayoutInfo;

    @NotNull
    private final Map<Integer, PreloadRequest> viewTypeToResLayoutId;

    public RecyclerViewInflateHistoryInfo(@NotNull NodePO nodeTreeTag, @NotNull Map<Integer, PreloadRequest> viewTypeToResLayoutId, @NotNull Map<Integer, Map<PreloadRequest, Integer>> viewTypeSubLayoutInfo) {
        Intrinsics.checkNotNullParameter(nodeTreeTag, "nodeTreeTag");
        Intrinsics.checkNotNullParameter(viewTypeToResLayoutId, "viewTypeToResLayoutId");
        Intrinsics.checkNotNullParameter(viewTypeSubLayoutInfo, "viewTypeSubLayoutInfo");
        this.nodeTreeTag = nodeTreeTag;
        this.viewTypeToResLayoutId = viewTypeToResLayoutId;
        this.viewTypeSubLayoutInfo = viewTypeSubLayoutInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecyclerViewInflateHistoryInfo copy$default(RecyclerViewInflateHistoryInfo recyclerViewInflateHistoryInfo, NodePO nodePO, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            nodePO = recyclerViewInflateHistoryInfo.nodeTreeTag;
        }
        if ((i3 & 2) != 0) {
            map = recyclerViewInflateHistoryInfo.viewTypeToResLayoutId;
        }
        if ((i3 & 4) != 0) {
            map2 = recyclerViewInflateHistoryInfo.viewTypeSubLayoutInfo;
        }
        return recyclerViewInflateHistoryInfo.copy(nodePO, map, map2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final NodePO getNodeTreeTag() {
        return this.nodeTreeTag;
    }

    @NotNull
    public final Map<Integer, PreloadRequest> component2() {
        return this.viewTypeToResLayoutId;
    }

    @NotNull
    public final Map<Integer, Map<PreloadRequest, Integer>> component3() {
        return this.viewTypeSubLayoutInfo;
    }

    @NotNull
    public final RecyclerViewInflateHistoryInfo copy(@NotNull NodePO nodeTreeTag, @NotNull Map<Integer, PreloadRequest> viewTypeToResLayoutId, @NotNull Map<Integer, Map<PreloadRequest, Integer>> viewTypeSubLayoutInfo) {
        Intrinsics.checkNotNullParameter(nodeTreeTag, "nodeTreeTag");
        Intrinsics.checkNotNullParameter(viewTypeToResLayoutId, "viewTypeToResLayoutId");
        Intrinsics.checkNotNullParameter(viewTypeSubLayoutInfo, "viewTypeSubLayoutInfo");
        return new RecyclerViewInflateHistoryInfo(nodeTreeTag, viewTypeToResLayoutId, viewTypeSubLayoutInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RecyclerViewInflateHistoryInfo) {
                RecyclerViewInflateHistoryInfo recyclerViewInflateHistoryInfo = (RecyclerViewInflateHistoryInfo) other;
                if (!Intrinsics.areEqual(this.nodeTreeTag, recyclerViewInflateHistoryInfo.nodeTreeTag) || !Intrinsics.areEqual(this.viewTypeToResLayoutId, recyclerViewInflateHistoryInfo.viewTypeToResLayoutId) || !Intrinsics.areEqual(this.viewTypeSubLayoutInfo, recyclerViewInflateHistoryInfo.viewTypeSubLayoutInfo)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final NodePO getNodeTreeTag() {
        return this.nodeTreeTag;
    }

    @NotNull
    public final Map<Integer, Map<PreloadRequest, Integer>> getViewTypeSubLayoutInfo() {
        return this.viewTypeSubLayoutInfo;
    }

    @NotNull
    public final Map<Integer, PreloadRequest> getViewTypeToResLayoutId() {
        return this.viewTypeToResLayoutId;
    }

    public int hashCode() {
        int i3;
        int i16;
        NodePO nodePO = this.nodeTreeTag;
        int i17 = 0;
        if (nodePO != null) {
            i3 = nodePO.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        Map<Integer, PreloadRequest> map = this.viewTypeToResLayoutId;
        if (map != null) {
            i16 = map.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        Map<Integer, Map<PreloadRequest, Integer>> map2 = this.viewTypeSubLayoutInfo;
        if (map2 != null) {
            i17 = map2.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "RecyclerViewInflateHistoryInfo(nodeTreeTag=" + this.nodeTreeTag + ", viewTypeToResLayoutId=" + this.viewTypeToResLayoutId + ", viewTypeSubLayoutInfo=" + this.viewTypeSubLayoutInfo + ")";
    }
}
