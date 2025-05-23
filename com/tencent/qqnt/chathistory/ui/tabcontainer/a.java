package com.tencent.qqnt.chathistory.ui.tabcontainer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.tabcontainer.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/tabcontainer/a;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "", "Lcom/tencent/qqnt/chathistory/ui/tabcontainer/data/a;", "userIntent", "", "S1", "R1", "()Lcom/tencent/qqnt/chathistory/ui/tabcontainer/data/a;", "mNoneValueIntent", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends BaseHistoryViewModel<Object, com.tencent.qqnt.chathistory.ui.tabcontainer.data.a> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.chathistory.ui.tabcontainer.data.a getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chathistory.ui.tabcontainer.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.C9554a.f353931a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.chathistory.ui.tabcontainer.data.a userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
        } else {
            Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        }
    }
}
