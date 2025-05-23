package com.tencent.mobileqq.emoticonview.argus;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.argus.node.ArgusNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/argus/EmoticonMainPanelNode;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Lcom/tencent/mobileqq/emoticonview/EmoticonMainPanel;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", ParseCommon.CONTAINER, "(Landroid/view/View;Lcom/tencent/mobileqq/emoticonview/EmoticonMainPanel;)V", "isSelfVisible", "", "()Z", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EmoticonMainPanelNode extends ArgusNode<EmoticonMainPanel> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmoticonMainPanelNode(@NotNull View rootView, @NotNull EmoticonMainPanel container) {
        super(rootView, container);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(container, "container");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) rootView, (Object) container);
        }
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        EmoticonMainPanel emoticonMainPanel = getContainerWrf().get();
        View view = getNodeViewWrf().get();
        if (emoticonMainPanel != null && view != null) {
            return emoticonMainPanel.isPanelOpen();
        }
        return false;
    }
}
