package com.tencent.richframework.argus.node;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/argus/node/RecyclerViewNode;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Landroidx/recyclerview/widget/RecyclerView;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "recyclerView", "(Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)V", "toString", "", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RecyclerViewNode extends ArgusNode<RecyclerView> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewNode(@NotNull View rootView, @NotNull RecyclerView recyclerView) {
        super(rootView, recyclerView);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    @NotNull
    public String toString() {
        String string = RFWStringBuilderUtils.getString("RecyclerViewNode(cls=", getNodeViewClassName(), " cCls=", getContainerClassName(), " vId=", Integer.valueOf(getNodeViewId()), " aTag=", getAnnotationTags());
        Intrinsics.checkNotNullExpressionValue(string, "RFWStringBuilderUtils.ge\u2026 annotationTags\n        )");
        return string;
    }
}
