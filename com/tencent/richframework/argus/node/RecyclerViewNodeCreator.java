package com.tencent.richframework.argus.node;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/argus/node/RecyclerViewNodeCreator;", "Lcom/tencent/richframework/argus/node/ArgusNodeCreator;", "Lcom/tencent/richframework/argus/node/RecyclerViewNode;", "()V", "canHandle", "", "currentView", "Landroid/view/View;", ParseCommon.CONTAINER, "", "createNode", "nodeView", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RecyclerViewNodeCreator implements ArgusNodeCreator<RecyclerViewNode> {
    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    public boolean canHandle(@NotNull View currentView, @Nullable Object container) {
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        return currentView instanceof RecyclerView;
    }

    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    @NotNull
    public RecyclerViewNode createNode(@NotNull View nodeView, @Nullable Object container) {
        Intrinsics.checkNotNullParameter(nodeView, "nodeView");
        return new RecyclerViewNode(nodeView, (RecyclerView) nodeView);
    }
}
