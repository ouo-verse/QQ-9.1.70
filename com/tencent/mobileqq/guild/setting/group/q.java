package com.tencent.mobileqq.guild.setting.group;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.BindEmptyAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.BindTitleAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.GroupChatAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.LoadingAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.ShowMoreAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.SpaceAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.UnbindGroupAdapterDelegate;
import com.tencent.mobileqq.guild.setting.group.adapterDelegate.UnbindTitleAdapterDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/q;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/guild/setting/group/GuildBindGroupSettingFragment$a;)V", "I", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<com.tencent.mobileqq.guild.setting.group.a> {

    @NotNull
    private static final a J = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/group/q$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/setting/group/a;", "oldItem", "newItem", "", "b", "a", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.setting.group.a> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.setting.group.a oldItem, @NotNull com.tencent.mobileqq.guild.setting.group.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.a(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.setting.group.a oldItem, @NotNull com.tencent.mobileqq.guild.setting.group.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.b(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.setting.group.a oldItem, @NotNull com.tencent.mobileqq.guild.setting.group.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.c(newItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull GuildBindGroupSettingFragment.a eventHandler) {
        super(J);
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.f236209m.c(new BindTitleAdapterDelegate(eventHandler)).c(new BindEmptyAdapterDelegate()).c(new GroupChatAdapterDelegate(eventHandler)).c(new ShowMoreAdapterDelegate(eventHandler)).c(new UnbindTitleAdapterDelegate(eventHandler)).c(new UnbindGroupAdapterDelegate(eventHandler)).c(new SpaceAdapterDelegate()).c(new LoadingAdapterDelegate());
    }
}
