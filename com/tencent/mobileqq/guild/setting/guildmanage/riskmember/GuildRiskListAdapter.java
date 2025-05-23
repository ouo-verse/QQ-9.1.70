package com.tencent.mobileqq.guild.setting.guildmanage.riskmember;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GroupSelectType;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskMemberData;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate.GuildRiskEmptyAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate.GuildRiskGroupAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate.GuildRiskLoadMoreAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate.GuildRiskLoadingAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate.GuildRiskMemberAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate.GuildRiskSearchEmptyAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.delegate.GuildRiskTipsAdapterDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskListAdapter;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/e;", "memberListEventCallback", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/e;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRiskListAdapter extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildRiskListAdapter$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GroupSelectType, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, e.class, "onGroupLick", "onGroupLick(Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GroupSelectType groupSelectType) {
            invoke2(groupSelectType);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull GroupSelectType p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            ((e) this.receiver).b(p06);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskListAdapter$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "oldItem", "newItem", "", "b", "a", "", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e oldItem, @NotNull com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e oldItem, @NotNull com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if ((oldItem instanceof GuildRiskMemberData) && (newItem instanceof GuildRiskMemberData)) {
                if (((GuildRiskMemberData) oldItem).getTinyId() == ((GuildRiskMemberData) newItem).getTinyId()) {
                    return true;
                }
                return false;
            }
            if (oldItem.getItemType() == newItem.getItemType()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e oldItem, @NotNull com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return new Object();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRiskListAdapter(@NotNull e memberListEventCallback) {
        super(new a());
        Intrinsics.checkNotNullParameter(memberListEventCallback, "memberListEventCallback");
        this.f236209m.c(new GuildRiskLoadingAdapterDelegate()).c(new GuildRiskGroupAdapterDelegate(new AnonymousClass1(memberListEventCallback))).c(new GuildRiskMemberAdapterDelegate(memberListEventCallback)).c(new GuildRiskTipsAdapterDelegate()).c(new GuildRiskEmptyAdapterDelegate()).c(new GuildRiskSearchEmptyAdapterDelegate()).c(new GuildRiskLoadMoreAdapterDelegate());
    }
}
