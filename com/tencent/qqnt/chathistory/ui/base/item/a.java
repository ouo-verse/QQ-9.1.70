package com.tencent.qqnt.chathistory.ui.base.item;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/item/a;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/a;", "Lcom/tencent/qqnt/chathistory/ui/base/i;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "child", "", "f", "", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "d", "Ljava/util/List;", "mediaItemList", "b", "()Ljava/util/List;", "childNode", "<init>", "(Ljava/util/List;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a extends com.tencent.qqnt.expandRecyclerView.adapter.node.a implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> mediaItemList;

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.node.b
    @NotNull
    public List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mediaItemList;
    }

    public final void f(@NotNull b child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) child);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        this.mediaItemList.add(child);
        child.e(this);
    }

    public /* synthetic */ a(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, Integer.valueOf(i3), defaultConstructorMarker);
    }

    public a(@NotNull List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> mediaItemList) {
        Intrinsics.checkNotNullParameter(mediaItemList, "mediaItemList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mediaItemList = mediaItemList;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mediaItemList);
        }
    }
}
