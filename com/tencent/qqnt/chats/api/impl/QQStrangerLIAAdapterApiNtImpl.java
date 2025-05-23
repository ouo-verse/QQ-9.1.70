package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IQQStrangerLIAAdapterApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/QQStrangerLIAAdapterApiNtImpl;", "Lcom/tencent/qqnt/chats/api/IQQStrangerLIAAdapterApi;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "newItem", "oldItem", "", "needAddLIAPayload", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class QQStrangerLIAAdapterApiNtImpl implements IQQStrangerLIAAdapterApi {
    static IPatchRedirector $redirector_;

    public QQStrangerLIAAdapterApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IQQStrangerLIAAdapterApi
    public boolean needAddLIAPayload(@NotNull g newItem, @NotNull g oldItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) newItem, (Object) oldItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        return false;
    }
}
