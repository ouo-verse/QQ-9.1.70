package com.tencent.mobileqq.guild.forward.guildselector;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.forward.guildselector.GuildSelectorForwardFragment;
import com.tencent.mobileqq.guild.forward.guildselector.adapterDelegate.GuildAdapterDelegate;
import com.tencent.mobileqq.guild.forward.guildselector.adapterDelegate.SpaceAdapterDelegate;
import com.tencent.mobileqq.guild.forward.guildselector.adapterDelegate.TitleAdapterDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/forward/guildselector/b;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/forward/guildselector/a;", "Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$b;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/forward/guildselector/GuildSelectorForwardFragment$b;)V", "I", "b", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<com.tencent.mobileqq.guild.forward.guildselector.a> {
    private static final a J = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/forward/guildselector/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/forward/guildselector/a;", "oldItem", "newItem", "", "b", "a", "", "c", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.forward.guildselector.a> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(com.tencent.mobileqq.guild.forward.guildselector.a oldItem, com.tencent.mobileqq.guild.forward.guildselector.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.a(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(com.tencent.mobileqq.guild.forward.guildselector.a oldItem, com.tencent.mobileqq.guild.forward.guildselector.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.b(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(com.tencent.mobileqq.guild.forward.guildselector.a oldItem, com.tencent.mobileqq.guild.forward.guildselector.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.c(newItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(GuildSelectorForwardFragment.b eventHandler) {
        super(J);
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.f236209m.c(new GuildAdapterDelegate(eventHandler)).c(new TitleAdapterDelegate()).c(new SpaceAdapterDelegate());
    }
}
