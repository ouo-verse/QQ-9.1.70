package com.tencent.mobileqq.mini.entry.newdesktop.argus;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost;
import com.tencent.richframework.argus.node.ArgusNodeCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/argus/MiniAppNodeCreator;", "Lcom/tencent/richframework/argus/node/ArgusNodeCreator;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/argus/MiniAppNode;", "()V", "canHandle", "", "currentView", "Landroid/view/View;", ParseCommon.CONTAINER, "", "createNode", "nodeView", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppNodeCreator implements ArgusNodeCreator<MiniAppNode> {
    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    public boolean canHandle(View currentView, Object container) {
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        return container instanceof MiniAppDesktopPartHost;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    public MiniAppNode createNode(View nodeView, Object container) {
        Intrinsics.checkNotNullParameter(nodeView, "nodeView");
        Intrinsics.checkNotNull(container, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost");
        return new MiniAppNode(nodeView, (MiniAppDesktopPartHost) container);
    }
}
