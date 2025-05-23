package com.tencent.richframework.argus.node;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R,\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/richframework/argus/node/ArgusMergeNode;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "innerNodes", "Ljava/util/List;", "getInnerNodes", "()Ljava/util/List;", "setInnerNodes", "(Ljava/util/List;)V", "isSelfVisible", "()Z", "", "argusNodes", "<init>", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusMergeNode extends ArgusNode<Object> {

    @NotNull
    private List<? extends ArgusNode<?>> innerNodes;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArgusMergeNode(@NotNull List<ArgusNode<?>> argusNodes) {
        super(r0);
        Intrinsics.checkNotNullParameter(argusNodes, "argusNodes");
        ArgusNode<?> argusNode = argusNodes.get(0);
        if (argusNode != null) {
            this.innerNodes = argusNodes;
            for (ArgusNode<?> argusNode2 : argusNodes) {
                getAllChildNode().addAll(argusNode2.getAllChildNode());
                if (argusNode2.getParentNode() != null) {
                    setParentNode(argusNode2.getParentNode());
                }
                argusNode2.setHostNode(this);
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.richframework.argus.node.ArgusNode<kotlin.Any>");
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArgusMergeNode) || !super.equals(other)) {
            return false;
        }
        return Intrinsics.areEqual(this.innerNodes, ((ArgusMergeNode) other).innerNodes);
    }

    @NotNull
    public final List<ArgusNode<?>> getInnerNodes() {
        return this.innerNodes;
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.innerNodes);
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        if (this.innerNodes.isEmpty()) {
            return false;
        }
        Iterator<? extends ArgusNode<?>> it = this.innerNodes.iterator();
        while (it.hasNext()) {
            if (!it.next().isSelfVisible()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    @NotNull
    public String toString() {
        return "ArgusMergeNode{innerNodes=" + this.innerNodes + '}';
    }
}
