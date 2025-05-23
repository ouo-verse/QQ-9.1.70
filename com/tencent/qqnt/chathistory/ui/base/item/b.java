package com.tencent.qqnt.chathistory.ui.base.item;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chathistory.ui.base.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "Lcom/tencent/qqnt/chathistory/ui/base/i;", "Lcom/tencent/qqnt/chathistory/ui/base/item/a;", "c", "Lcom/tencent/qqnt/chathistory/ui/base/item/a;", "d", "()Lcom/tencent/qqnt/chathistory/ui/base/item/a;", "e", "(Lcom/tencent/qqnt/chathistory/ui/base/item/a;)V", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class b extends com.tencent.qqnt.expandRecyclerView.adapter.node.b implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public a parent;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        a aVar = this.parent;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException(HippyNestedScrollComponent.PRIORITY_PARENT);
        return null;
    }

    public final void e(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.parent = aVar;
        }
    }
}
