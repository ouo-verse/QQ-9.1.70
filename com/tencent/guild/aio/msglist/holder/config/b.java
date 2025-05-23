package com.tencent.guild.aio.msglist.holder.config;

import android.view.ViewGroup;
import com.tencent.guild.aio.msglist.holder.component.v;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J4\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000eH\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/config/b;", "Lcom/tencent/guild/aio/msglist/holder/component/v;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "", "viewType", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "b", "Lcom/tencent/aio/api/list/b;", "a", "Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "getDelegate", "()Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "delegate", "<init>", "(Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildItemViewHolderDelegate delegate;

    public b(@NotNull GuildItemViewHolderDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.v
    @NotNull
    public com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> a() {
        return this.delegate.a();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.v
    @NotNull
    public com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b(@NotNull ViewGroup parent, boolean isSelf, int viewType, @NotNull c factoryProvider) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        return this.delegate.b(parent, isSelf, viewType, factoryProvider);
    }
}
