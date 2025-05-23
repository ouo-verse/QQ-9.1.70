package com.tencent.qqnt.aio.assistedchat.panel;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.config.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/n;", "Lcom/tencent/qqnt/aio/assistedchat/panel/o;", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "Lcom/tencent/qqnt/aio/assistedchat/panel/j;", "param", "", "Lcom/tencent/qqnt/aio/assistedchat/panel/k;", "a", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class n implements o {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.o
    @NotNull
    public List<k> a(@NotNull AIOContact aioContact, @Nullable j param) {
        List<k> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContact, (Object) param);
        }
        Intrinsics.checkNotNullParameter(aioContact, "aioContact");
        a.Companion companion = com.tencent.qqnt.aio.assistedchat.config.a.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new k[]{new k(1, companion.a().e()), new k(2, companion.a().d())});
        return listOf;
    }
}
