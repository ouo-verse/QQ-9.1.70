package com.tencent.qqnt.contacts.adapter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/contacts/adapter/d;", "Lcom/tencent/qqnt/contacts/widget/adapter/provider/b;", "", "Lcom/tencent/qqnt/contacts/widget/adapter/node/b;", "data", "", "position", "l0", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends com.tencent.qqnt.contacts.widget.adapter.provider.b {
    static IPatchRedirector $redirector_;

    public d() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            v0(new g());
            i0(new b());
        }
    }

    @Override // com.tencent.qqnt.contacts.widget.adapter.BaseProviderMultiAdapter
    protected int l0(@NotNull List<? extends com.tencent.qqnt.contacts.widget.adapter.node.b> data, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, position)).intValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.qqnt.contacts.widget.adapter.node.b bVar = data.get(position);
        if (bVar instanceof com.tencent.qqnt.contacts.data.item.a) {
            return 0;
        }
        if (bVar instanceof com.tencent.qqnt.contacts.data.item.b) {
            return 1;
        }
        throw new IllegalArgumentException("illegal data: " + data);
    }
}
