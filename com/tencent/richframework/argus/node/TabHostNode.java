package com.tencent.richframework.argus.node;

import android.view.View;
import android.widget.TabHost;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/argus/node/TabHostNode;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Landroid/widget/TabHost;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "tabHost", "(Landroid/view/View;Landroid/widget/TabHost;)V", "isSelfVisible", "", "()Z", "toString", "", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class TabHostNode extends ArgusNode<TabHost> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabHostNode(@NotNull View rootView, @NotNull TabHost tabHost) {
        super(rootView, tabHost);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(tabHost, "tabHost");
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        TabHost tabHost = getContainerWrf().get();
        View view = getNodeViewWrf().get();
        if (tabHost != null && view != null && tabHost.getCurrentView() == view && view.isShown()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    @NotNull
    public String toString() {
        return "TabHostNode{view=" + getNodeViewWrf().get() + ", tabHost=" + getContainerWrf().get() + '}';
    }
}
