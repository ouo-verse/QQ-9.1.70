package com.tencent.qqnt.chats.core.adapter.factory.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.biz.guild.GuildDiscoveryItemBuilder;
import com.tencent.qqnt.chats.biz.guild.GuildRecentItemBuilder;
import com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/factory/impl/b;", "Lcom/tencent/qqnt/chats/core/adapter/factory/a;", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "viewType", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "a", "", "e", "()[I", "viewTypes", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends com.tencent.qqnt.chats.core.adapter.factory.a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.factory.a
    @Nullable
    public com.tencent.qqnt.chats.core.adapter.builder.a<? extends com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b>> a(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.chats.core.adapter.builder.a) iPatchRedirector.redirect((short) 4, (Object) this, viewType);
        }
        if (viewType != 2) {
            if (viewType != 12) {
                if (viewType != 13) {
                    return CommonRecentItemBuilder.INSTANCE.a();
                }
                return GuildDiscoveryItemBuilder.INSTANCE.a();
            }
            return GuildRecentItemBuilder.INSTANCE.a();
        }
        return CommonRecentItemBuilder.INSTANCE.a();
    }

    @Override // com.tencent.qqnt.chats.core.adapter.factory.a
    public int c(@NotNull Object item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, item)).intValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (!(item instanceof com.tencent.qqnt.base.adapter.b)) {
            return e()[0];
        }
        if (!(item instanceof g)) {
            return ((com.tencent.qqnt.base.adapter.b) item).e();
        }
        g gVar = (g) item;
        int n3 = gVar.n();
        if (n3 != 16) {
            if (n3 == 60) {
                return 12;
            }
            return ((com.tencent.qqnt.base.adapter.b) item).e();
        }
        if (!gVar.E()) {
            return 12;
        }
        return 13;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.factory.a
    @NotNull
    public int[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.qqnt.chats.core.adapter.factory.b.b();
    }
}
