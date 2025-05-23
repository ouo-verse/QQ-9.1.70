package com.tencent.mobileqq.emoticonview.argus;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.argus.node.ArgusNodeCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/argus/EmoticonMainPanelCreator;", "Lcom/tencent/richframework/argus/node/ArgusNodeCreator;", "Lcom/tencent/mobileqq/emoticonview/argus/EmoticonMainPanelNode;", "()V", "canHandle", "", "currentView", "Landroid/view/View;", ParseCommon.CONTAINER, "", "createNode", "nodeView", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmoticonMainPanelCreator implements ArgusNodeCreator<EmoticonMainPanelNode> {
    static IPatchRedirector $redirector_;

    public EmoticonMainPanelCreator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    public boolean canHandle(@NotNull View currentView, @Nullable Object container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) currentView, container)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        return container instanceof EmoticonMainPanel;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.richframework.argus.node.ArgusNodeCreator
    @NotNull
    public EmoticonMainPanelNode createNode(@NotNull View nodeView, @Nullable Object container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EmoticonMainPanelNode) iPatchRedirector.redirect((short) 3, (Object) this, (Object) nodeView, container);
        }
        Intrinsics.checkNotNullParameter(nodeView, "nodeView");
        Intrinsics.checkNotNull(container, "null cannot be cast to non-null type com.tencent.mobileqq.emoticonview.EmoticonMainPanel");
        return new EmoticonMainPanelNode(nodeView, (EmoticonMainPanel) container);
    }
}
