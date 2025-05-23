package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IContactCommAPI;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J'\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ContactCommAPIImpl;", "Lcom/tencent/qqnt/chats/api/IContactCommAPI;", "", "event", "", "sendEventToChat", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "data", "", "listType", "Lcom/tencent/qqnt/chats/data/b;", "convertRecentInfoToNotifyItem", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/tencent/qqnt/chats/data/b;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ContactCommAPIImpl implements IContactCommAPI {
    static IPatchRedirector $redirector_;

    public ContactCommAPIImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IContactCommAPI
    @NotNull
    public com.tencent.qqnt.chats.data.b convertRecentInfoToNotifyItem(@NotNull List<RecentContactInfo> data, @Nullable Integer listType) {
        com.tencent.qqnt.chats.data.converter.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.data.b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data, (Object) listType);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (listType == null) {
            bVar = new com.tencent.qqnt.chats.data.converter.b(0, 1, null);
        } else {
            bVar = new com.tencent.qqnt.chats.data.converter.b(listType.intValue());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            g b16 = com.tencent.qqnt.chats.data.converter.b.b(bVar, (RecentContactInfo) it.next(), null, 2, null);
            if (b16 != null) {
                arrayList.add(b16);
            }
        }
        return new com.tencent.qqnt.chats.data.b(arrayList, 0, false, false, 0, false, null, 126, null);
    }

    @Override // com.tencent.qqnt.chats.api.IContactCommAPI
    public void sendEventToChat(@NotNull Object event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            com.tencent.qqnt.chats.c.f354431a.b(new a.d(event));
        }
    }
}
