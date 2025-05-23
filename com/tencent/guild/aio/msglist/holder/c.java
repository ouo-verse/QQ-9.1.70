package com.tencent.guild.aio.msglist.holder;

import android.view.ViewGroup;
import com.tencent.aio.api.list.h;
import com.tencent.aio.api.list.k;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/c;", "Lcom/tencent/aio/api/list/h;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/aio/api/list/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "d", "b", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "a", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "getFactoryProvider", "()Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", "<init>", "(Lcom/tencent/guild/aio/msglist/holder/config/c;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.holder.config.c factoryProvider;

    public c(@NotNull com.tencent.guild.aio.msglist.holder.config.c factoryProvider) {
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        this.factoryProvider = factoryProvider;
    }

    @Override // com.tencent.aio.api.list.f
    public int b() {
        return this.factoryProvider.getClass().hashCode();
    }

    @Override // com.tencent.aio.api.list.f
    @Nullable
    public k c() {
        return h.a.a(this);
    }

    @Override // com.tencent.aio.api.list.h
    @NotNull
    public com.tencent.aio.api.list.a<? extends ol3.b, ? extends MviUIState> d(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.factoryProvider.a(viewType).b(parent, MsgExtKt.T(viewType), viewType, this.factoryProvider);
    }

    public /* synthetic */ c(com.tencent.guild.aio.msglist.holder.config.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? GuildItemViewHolderFactoryProvider.f111480a : cVar);
    }
}
