package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/b;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/d;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "lastMsg", "firstMsg", "", "b", "a", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b implements d {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
    public boolean a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, displayList, lastMsg, firstMsg)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        if (!displayList.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
            if (((com.tencent.aio.data.msglist.a) first).getMsgSeq() > 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.d
    public boolean b(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList, @Nullable com.tencent.aio.data.msglist.a lastMsg, @Nullable com.tencent.aio.data.msglist.a firstMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, this, displayList, lastMsg, firstMsg)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        return !displayList.isEmpty();
    }
}
