package com.tencent.qqnt.chats.core.adapter.builder;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chats.core.adapter.holder.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.itempart.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0010\b\u0000\u0010\u0003*\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b*\u0010+JA\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0018\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0019\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u001a\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u001b\u0010\u0016J\u001f\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u0016J'\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001dH&\u00a2\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H&\u00a2\u0006\u0004\b!\u0010\u0016J\u001f\u0010\"\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\"\u0010\u0016R\"\u0010)\u001a\u00020#8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "T", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "Lcom/tencent/qqnt/chats/core/adapter/h;", "operatorListener", "a", "(Landroid/view/ViewGroup;ILcom/tencent/qqnt/chats/core/itempart/d;Lcom/tencent/mobileqq/quibadge/b;Lcom/tencent/qqnt/chats/core/adapter/h;)Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "c", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;Lcom/tencent/qqnt/chats/core/adapter/holder/b;)V", "j", h.F, "i", "l", "d", "g", "Landroid/view/View$OnClickListener;", "listener", "f", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;Lcom/tencent/qqnt/chats/core/adapter/holder/b;Landroid/view/View$OnClickListener;)V", "e", "k", "Lcom/tencent/qqnt/chats/core/adapter/menu/b;", "Lcom/tencent/qqnt/chats/core/adapter/menu/b;", "b", "()Lcom/tencent/qqnt/chats/core/adapter/menu/b;", "setMenuProcess", "(Lcom/tencent/qqnt/chats/core/adapter/menu/b;)V", "menuProcess", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a<T extends b<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b>> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.core.adapter.menu.b menuProcess;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.menuProcess = new com.tencent.qqnt.chats.core.adapter.menu.b(new com.tencent.qqnt.chats.core.adapter.menu.creator.b());
        }
    }

    @NotNull
    public abstract T a(@NotNull ViewGroup parent, int viewType, @Nullable d itemPartCollect, @Nullable com.tencent.mobileqq.quibadge.b dragListener, @Nullable com.tencent.qqnt.chats.core.adapter.h operatorListener);

    @NotNull
    public com.tencent.qqnt.chats.core.adapter.menu.b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.core.adapter.menu.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.menuProcess;
    }

    public abstract void c(@NotNull g item, @NotNull T holder);

    public abstract void d(@NotNull g item, @NotNull T holder);

    public abstract void e(@NotNull g item, @NotNull T holder);

    public abstract void f(@NotNull g item, @NotNull T holder, @NotNull View.OnClickListener listener);

    public void g(@NotNull g item, @NotNull T holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    public abstract void h(@NotNull g item, @NotNull T holder);

    public abstract void i(@NotNull g item, @NotNull T holder);

    public abstract void j(@NotNull g item, @NotNull T holder);

    public void k(@NotNull g item, @NotNull T holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item, (Object) holder);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(holder, "holder");
        }
    }

    public abstract void l(@NotNull g item, @NotNull T holder);
}
