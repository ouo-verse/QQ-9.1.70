package com.tencent.richframework.preload.activity;

import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.NodePO;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a \u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006\u001a\n\u0010\t\u001a\u00020\u0002*\u00020\u0002\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0002*\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/preload/activity/PreloadMode;", "preloadMode", "Lcom/tencent/richframework/argus/node/NodePO;", "parentNodePO", "", "isNodeAutoPreloadEnabled", "Lcom/tencent/richframework/argus/node/ArgusNode;", "node", "findAutoPreloadNode", "findSelfPO", "findActivityNodePO", "argus-preload_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusPreloadManagerKt {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        return com.tencent.richframework.argus.node.NodePO.copy$default(r3, null, null, 0, null, null, null, null, 95, null);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final NodePO findActivityNodePO(@NotNull NodePO findActivityNodePO) {
        NodePO nodePO;
        List<NodePO> children;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(findActivityNodePO, "$this$findActivityNodePO");
        if (Intrinsics.areEqual(findActivityNodePO.getContainerDesc(), "Activity")) {
            nodePO = findActivityNodePO;
        } else {
            nodePO = null;
        }
        NodePO nodePO2 = nodePO;
        while (true) {
            if (findActivityNodePO.getChildren() != null && (!r0.isEmpty()) && (children = findActivityNodePO.getChildren()) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) children);
                findActivityNodePO = (NodePO) firstOrNull;
                if (findActivityNodePO == null) {
                    break;
                }
                if (Intrinsics.areEqual(findActivityNodePO.getContainerDesc(), "Activity")) {
                    nodePO2 = findActivityNodePO;
                }
            } else {
                break;
            }
        }
        return null;
    }

    @Nullable
    public static final ArgusNode<?> findAutoPreloadNode(@NotNull PreloadMode preloadMode, @NotNull ArgusNode<?> node) {
        Intrinsics.checkNotNullParameter(preloadMode, "preloadMode");
        Intrinsics.checkNotNullParameter(node, "node");
        if (preloadMode == PreloadMode.AUTO_PRELOAD) {
            return node;
        }
        if (preloadMode == PreloadMode.PRELOAD_WITH_TAG) {
            if (node.getAnnotationTags().contains("AUTO_PRELOAD")) {
                return node;
            }
            ArgusNode<?> parentNode = node.getParentNode();
            if (parentNode != null) {
                return findAutoPreloadNode(preloadMode, parentNode);
            }
            return null;
        }
        return null;
    }

    @NotNull
    public static final NodePO findSelfPO(@NotNull NodePO findSelfPO) {
        List<NodePO> children;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(findSelfPO, "$this$findSelfPO");
        while (true) {
            if (findSelfPO.getChildren() != null && (!r0.isEmpty()) && (children = findSelfPO.getChildren()) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) children);
                NodePO nodePO = (NodePO) firstOrNull;
                if (nodePO == null) {
                    break;
                }
                findSelfPO = nodePO;
            } else {
                break;
            }
        }
        return findSelfPO;
    }

    public static final boolean isNodeAutoPreloadEnabled(@NotNull PreloadMode preloadMode, @NotNull NodePO parentNodePO) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(preloadMode, "preloadMode");
        Intrinsics.checkNotNullParameter(parentNodePO, "parentNodePO");
        if (preloadMode == PreloadMode.AUTO_PRELOAD) {
            return true;
        }
        if (preloadMode == PreloadMode.PRELOAD_WITH_TAG) {
            List<String> annotationTag = parentNodePO.getAnnotationTag();
            if (annotationTag != null) {
                bool = Boolean.valueOf(annotationTag.contains("AUTO_PRELOAD"));
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                return true;
            }
            List<NodePO> children = parentNodePO.getChildren();
            if (children != null) {
                Iterator<NodePO> it = children.iterator();
                while (it.hasNext()) {
                    if (isNodeAutoPreloadEnabled(preloadMode, it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
