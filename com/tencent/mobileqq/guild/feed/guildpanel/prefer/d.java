package com.tencent.mobileqq.guild.feed.guildpanel.prefer;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLikeUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/d;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProLikeUserInfo;", "", "position", "", "getItemId", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/k;", "userPreferListener", "<init>", "(Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/k;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends AsyncListDifferDelegationAdapter<GProLikeUserInfo> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/guildpanel/prefer/d$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProLikeUserInfo;", "oldItem", "newItem", "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends DiffUtil.ItemCallback<GProLikeUserInfo> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull GProLikeUserInfo oldItem, @NotNull GProLikeUserInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.idd == newItem.idd && Intrinsics.areEqual(oldItem.nick, newItem.nick) && Intrinsics.areEqual(oldItem.avatar, newItem.avatar)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull GProLikeUserInfo oldItem, @NotNull GProLikeUserInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.idd == newItem.idd && Intrinsics.areEqual(oldItem.nick, newItem.nick)) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull k userPreferListener) {
        super(new a(), new AdapterDelegatesManager(new c(userPreferListener)));
        Intrinsics.checkNotNullParameter(userPreferListener, "userPreferListener");
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
