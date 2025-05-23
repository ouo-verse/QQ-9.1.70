package com.tencent.mobileqq.guild.setting.member.selector;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates.GuildEmptyAdapterDelegate;
import com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates.GuildFooterAdapterDelegate;
import com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates.GuildLoadingAdapterDelegate;
import com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates.GuildMemberAdapterDelegate;
import com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates.GuildRoleTitleAdapterDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0003\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/d;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/setting/member/selector/a;", "", "newList", "", "submitList", "Lcom/tencent/mobileqq/guild/setting/member/selector/q;", "memberListCallback", "<init>", "(Lcom/tencent/mobileqq/guild/setting/member/selector/q;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<com.tencent.mobileqq.guild.setting.member.selector.a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/member/selector/d$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/setting/member/selector/a;", "oldItem", "newItem", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.setting.member.selector.a> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.setting.member.selector.a oldItem, @NotNull com.tencent.mobileqq.guild.setting.member.selector.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.a(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.setting.member.selector.a oldItem, @NotNull com.tencent.mobileqq.guild.setting.member.selector.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.b(newItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull q memberListCallback) {
        super(new a());
        Intrinsics.checkNotNullParameter(memberListCallback, "memberListCallback");
        this.f236209m.c(new GuildMemberAdapterDelegate(memberListCallback)).c(new GuildRoleTitleAdapterDelegate()).c(new GuildLoadingAdapterDelegate()).c(new GuildEmptyAdapterDelegate()).c(new GuildFooterAdapterDelegate(memberListCallback));
    }

    public final void submitList(@Nullable List<? extends com.tencent.mobileqq.guild.setting.member.selector.a> newList) {
        this.C.submitList(newList);
    }
}
