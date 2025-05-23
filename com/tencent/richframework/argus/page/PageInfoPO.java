package com.tencent.richframework.argus.page;

import androidx.fragment.app.Argus;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.profilecard.widget.selector.ProvinceSelectorView;
import com.tencent.richframework.argus.node.NodePO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/richframework/argus/page/PageInfoPO;", "", "rootNode", "Lcom/tencent/richframework/argus/node/NodePO;", "(Lcom/tencent/richframework/argus/node/NodePO;)V", "getRootNode", "()Lcom/tencent/richframework/argus/node/NodePO;", "printAll", "", "tag", "", "toString", "Companion", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class PageInfoPO {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final NodePO rootNode;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/argus/page/PageInfoPO$Companion;", "", "()V", "printTree", "", "tag", "", "nodePO", "Lcom/tencent/richframework/argus/node/NodePO;", "prefix", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public final void printTree(@NotNull String tag, @Nullable NodePO nodePO, @NotNull String prefix) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            if (nodePO == null) {
                return;
            }
            RFWLog.i(tag, RFWLog.USR, prefix + nodePO);
            List<NodePO> children = nodePO.getChildren();
            if (children != null) {
                for (NodePO nodePO2 : children) {
                    PageInfoPO.INSTANCE.printTree(tag, nodePO2, prefix + ProvinceSelectorView.NAME_NO_SELECT_PROFILE);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PageInfoPO(@Nullable NodePO nodePO) {
        this.rootNode = nodePO;
    }

    @Nullable
    public final NodePO getRootNode() {
        return this.rootNode;
    }

    public final void printAll(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Argus.INSTANCE.isDebug()) {
            INSTANCE.printTree(tag, this.rootNode, "");
        }
    }

    @NotNull
    public String toString() {
        return "PageInfoPO{rootNode=" + this.rootNode + '}';
    }
}
