package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.richframework.argus.node.ArgusNode;
import com.tencent.richframework.argus.node.NodePO;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2 = {"Landroidx/fragment/app/ArgusUtil;", "", "()V", "checkIsAlreadyExist", "", "rootNode", "Lcom/tencent/richframework/argus/node/NodePO;", "targetNode", "findNodeFromRootNode", "Lcom/tencent/richframework/argus/node/ArgusNode;", "showNodePO", "isLaunchMainActivity", "context", "Landroid/content/Context;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ArgusUtil {

    @NotNull
    public static final ArgusUtil INSTANCE = new ArgusUtil();

    ArgusUtil() {
    }

    public final boolean checkIsAlreadyExist(@NotNull NodePO rootNode, @NotNull NodePO targetNode) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        Intrinsics.checkNotNullParameter(targetNode, "targetNode");
        List<NodePO> children = rootNode.getChildren();
        List<NodePO> children2 = targetNode.getChildren();
        List<String> annotationTag = rootNode.getAnnotationTag();
        List<String> annotationTag2 = targetNode.getAnnotationTag();
        rootNode.setChildren(null);
        targetNode.setChildren(null);
        rootNode.setAnnotationTag(null);
        targetNode.setAnnotationTag(null);
        boolean areEqual = Intrinsics.areEqual(rootNode, targetNode);
        rootNode.setChildren(children);
        targetNode.setChildren(children2);
        rootNode.setAnnotationTag(annotationTag);
        targetNode.setAnnotationTag(annotationTag2);
        if (!areEqual) {
            return false;
        }
        List<NodePO> list = children2;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        List<NodePO> list2 = children;
        if (list2 != null && !list2.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return false;
        }
        NodePO nodePO = children2.get(0);
        Iterator<NodePO> it = children.iterator();
        while (it.hasNext()) {
            if (checkIsAlreadyExist(it.next(), nodePO)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final ArgusNode<?> findNodeFromRootNode(@NotNull ArgusNode<?> rootNode, @NotNull NodePO showNodePO) {
        boolean z16;
        NodePO nodePO;
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        Intrinsics.checkNotNullParameter(showNodePO, "showNodePO");
        if (!rootNode.isPOGenerateFromNode(showNodePO)) {
            return null;
        }
        List<NodePO> children = showNodePO.getChildren();
        if (children != null && !children.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return rootNode;
        }
        List<NodePO> children2 = showNodePO.getChildren();
        if (children2 != null && (nodePO = children2.get(0)) != null) {
            if (rootNode.getAllChildNode().isEmpty()) {
                return null;
            }
            Iterator<ArgusNode<?>> it = rootNode.getAllChildNode().iterator();
            while (it.hasNext()) {
                ArgusNode<?> childBlock = it.next();
                Intrinsics.checkNotNullExpressionValue(childBlock, "childBlock");
                ArgusNode<?> findNodeFromRootNode = findNodeFromRootNode(childBlock, nodePO);
                if (findNodeFromRootNode != null) {
                    return findNodeFromRootNode;
                }
            }
            return null;
        }
        return rootNode;
    }

    public final boolean isLaunchMainActivity(@NotNull Context context) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity == null || (intent = activity.getIntent()) == null || !Intrinsics.areEqual("android.intent.action.MAIN", intent.getAction()) || !intent.hasCategory("android.intent.category.LAUNCHER")) {
            return false;
        }
        return true;
    }
}
