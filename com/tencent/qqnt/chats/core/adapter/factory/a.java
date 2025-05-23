package com.tencent.qqnt.chats.core.adapter.factory;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0007\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004J\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H&J \u0010\u000e\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R,\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00040\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/factory/a;", "", "", "viewType", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "b", "builder", "", "f", "d", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "c", "a", "", "[Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "builderCache", "", "e", "()[I", "viewTypes", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>>[] builderCache;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int d16 = d();
        com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>>[] aVarArr = new com.tencent.qqnt.chats.core.adapter.builder.a[d16];
        for (int i3 = 0; i3 < d16; i3++) {
            aVarArr[i3] = null;
        }
        this.builderCache = aVarArr;
    }

    @Nullable
    public abstract com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> a(int viewType);

    @Nullable
    public final com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> b(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.core.adapter.builder.a) iPatchRedirector.redirect((short) 2, (Object) this, viewType);
        }
        return this.builderCache[viewType];
    }

    public abstract int c(@NotNull Object item);

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return e().length;
    }

    @NotNull
    public abstract int[] e();

    public final void f(int viewType, @NotNull com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, viewType, (Object) builder);
        } else {
            Intrinsics.checkNotNullParameter(builder, "builder");
            this.builderCache[viewType] = builder;
        }
    }
}
