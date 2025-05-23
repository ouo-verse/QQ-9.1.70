package com.tencent.mobileqq.app.argus;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.argus.node.ArgusNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/app/argus/b;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Lcom/tencent/mobileqq/app/be;", "", "isSelfVisible", "()Z", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, ParseCommon.CONTAINER, "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/app/be;)V", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends ArgusNode<be> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View rootView, @NotNull be container) {
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
        be container = getContainer();
        if (container == null || !container.isFrameResume()) {
            return false;
        }
        return true;
    }
}
