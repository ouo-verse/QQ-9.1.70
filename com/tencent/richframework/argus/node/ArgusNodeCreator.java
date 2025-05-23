package com.tencent.richframework.argus.node;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.richframework.argus.node.ArgusNode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\u001f\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/argus/node/ArgusNodeCreator;", "T", "Lcom/tencent/richframework/argus/node/ArgusNode;", "", "canHandle", "", "currentView", "Landroid/view/View;", ParseCommon.CONTAINER, "createNode", "nodeView", "(Landroid/view/View;Ljava/lang/Object;)Lcom/tencent/richframework/argus/node/ArgusNode;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface ArgusNodeCreator<T extends ArgusNode<?>> {
    boolean canHandle(@NotNull View currentView, @Nullable Object container);

    @NotNull
    T createNode(@NotNull View nodeView, @Nullable Object container);
}
