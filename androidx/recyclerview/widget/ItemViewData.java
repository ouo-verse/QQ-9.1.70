package androidx.recyclerview.widget;

import com.tencent.richframework.argus.node.ArgusNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u00c6\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Landroidx/recyclerview/widget/ItemViewData;", "", "itemHashCode", "", "itemType", "itemLayoutId", "listViewPage", "Lcom/tencent/richframework/argus/node/ArgusNode;", "(IIILcom/tencent/richframework/argus/node/ArgusNode;)V", "getItemHashCode", "()I", "getItemLayoutId", "getItemType", "getListViewPage", "()Lcom/tencent/richframework/argus/node/ArgusNode;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final /* data */ class ItemViewData {
    private final int itemHashCode;
    private final int itemLayoutId;
    private final int itemType;

    @Nullable
    private final ArgusNode<?> listViewPage;

    public ItemViewData(int i3, int i16, int i17, @Nullable ArgusNode<?> argusNode) {
        this.itemHashCode = i3;
        this.itemType = i16;
        this.itemLayoutId = i17;
        this.listViewPage = argusNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemViewData copy$default(ItemViewData itemViewData, int i3, int i16, int i17, ArgusNode argusNode, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            i3 = itemViewData.itemHashCode;
        }
        if ((i18 & 2) != 0) {
            i16 = itemViewData.itemType;
        }
        if ((i18 & 4) != 0) {
            i17 = itemViewData.itemLayoutId;
        }
        if ((i18 & 8) != 0) {
            argusNode = itemViewData.listViewPage;
        }
        return itemViewData.copy(i3, i16, i17, argusNode);
    }

    /* renamed from: component1, reason: from getter */
    public final int getItemHashCode() {
        return this.itemHashCode;
    }

    /* renamed from: component2, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getItemLayoutId() {
        return this.itemLayoutId;
    }

    @Nullable
    public final ArgusNode<?> component4() {
        return this.listViewPage;
    }

    @NotNull
    public final ItemViewData copy(int itemHashCode, int itemType, int itemLayoutId, @Nullable ArgusNode<?> listViewPage) {
        return new ItemViewData(itemHashCode, itemType, itemLayoutId, listViewPage);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ItemViewData) {
                ItemViewData itemViewData = (ItemViewData) other;
                if (this.itemHashCode != itemViewData.itemHashCode || this.itemType != itemViewData.itemType || this.itemLayoutId != itemViewData.itemLayoutId || !Intrinsics.areEqual(this.listViewPage, itemViewData.listViewPage)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getItemHashCode() {
        return this.itemHashCode;
    }

    public final int getItemLayoutId() {
        return this.itemLayoutId;
    }

    public final int getItemType() {
        return this.itemType;
    }

    @Nullable
    public final ArgusNode<?> getListViewPage() {
        return this.listViewPage;
    }

    public int hashCode() {
        int i3;
        int i16 = ((((this.itemHashCode * 31) + this.itemType) * 31) + this.itemLayoutId) * 31;
        ArgusNode<?> argusNode = this.listViewPage;
        if (argusNode != null) {
            i3 = argusNode.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "ItemViewData(itemHashCode=" + this.itemHashCode + ", itemType=" + this.itemType + ", itemLayoutId=" + this.itemLayoutId + ", listViewPage=" + this.listViewPage + ")";
    }
}
