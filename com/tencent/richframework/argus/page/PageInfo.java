package com.tencent.richframework.argus.page;

import androidx.fragment.app.Argus;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.richframework.argus.node.ArgusNode;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0007\u00a2\u0006\u0002\u0010\bJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/richframework/argus/page/PageInfo;", "", "windowToken", "", "rootNode", "Lcom/tencent/richframework/argus/node/ArgusNode;", "allVisibleNode", "", "(ILcom/tencent/richframework/argus/node/ArgusNode;Ljava/util/Set;)V", "getAllVisibleNode", "()Ljava/util/Set;", "getRootNode", "()Lcom/tencent/richframework/argus/node/ArgusNode;", "visiblePageInfoPO", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "getVisiblePageInfoPO", "()Lcom/tencent/richframework/argus/page/PageInfoPO;", "getWindowToken", "()I", "equals", "", "other", "hashCode", "printAll", "", "tag", "", "toString", "Companion", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class PageInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: allVisibleNode, reason: from kotlin metadata and from toString */
    @NotNull
    private final Set<ArgusNode<?>> allVisible;

    @NotNull
    private final ArgusNode<?> rootNode;
    private final int windowToken;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/argus/page/PageInfo$Companion;", "", "()V", "printTree", "", "tag", "", "node", "Lcom/tencent/richframework/argus/node/ArgusNode;", "prefix", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public final void printTree(@NotNull String tag, @Nullable ArgusNode<?> node, @NotNull String prefix) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            if (node == null) {
                return;
            }
            RFWLog.i(tag, RFWLog.USR, prefix + node);
            Iterator<ArgusNode<?>> it = node.getAllChildNode().iterator();
            while (it.hasNext()) {
                printTree(tag, it.next(), prefix + ProvinceSelectorView.NAME_NO_SELECT_PROFILE);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageInfo(int i3, @NotNull ArgusNode<?> rootNode, @NotNull Set<? extends ArgusNode<?>> allVisibleNode) {
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        Intrinsics.checkNotNullParameter(allVisibleNode, "allVisibleNode");
        this.windowToken = i3;
        this.rootNode = rootNode;
        this.allVisible = allVisibleNode;
    }

    public boolean equals(@Nullable Object other) {
        Set subtract;
        Set subtract2;
        Set union;
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageInfo)) {
            return false;
        }
        PageInfo pageInfo = (PageInfo) other;
        subtract = CollectionsKt___CollectionsKt.subtract(this.allVisible, pageInfo.allVisible);
        subtract2 = CollectionsKt___CollectionsKt.subtract(pageInfo.allVisible, this.allVisible);
        union = CollectionsKt___CollectionsKt.union(subtract, subtract2);
        return union.isEmpty();
    }

    @NotNull
    public final Set<ArgusNode<?>> getAllVisibleNode() {
        return this.allVisible;
    }

    @NotNull
    public final ArgusNode<?> getRootNode() {
        return this.rootNode;
    }

    @NotNull
    public final PageInfoPO getVisiblePageInfoPO() {
        return new PageInfoPO(this.rootNode.getNodeStoreObject(true, true));
    }

    public final int getWindowToken() {
        return this.windowToken;
    }

    public int hashCode() {
        return Objects.hash(this.rootNode, this.allVisible);
    }

    public final void printAll(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Argus.INSTANCE.isDebug()) {
            INSTANCE.printTree(tag, this.rootNode, "");
        }
    }

    @NotNull
    public String toString() {
        return "PageInfo{root=" + this.rootNode + ", allVisible=" + this.allVisible + '}';
    }
}
