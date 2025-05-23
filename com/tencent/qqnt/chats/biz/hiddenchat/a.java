package com.tencent.qqnt.chats.biz.hiddenchat;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/biz/hiddenchat/a;", "Lcom/tencent/qqnt/chats/core/ui/ChatsListVB;", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "mViewModel", "Lcom/tencent/qqnt/chats/core/data/a;", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/mvi/a;Lcom/tencent/qqnt/chats/core/data/a;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends ChatsListVB {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mViewModel, @NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(mViewModel, mBuilder);
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mViewModel, (Object) mBuilder);
        }
    }
}
